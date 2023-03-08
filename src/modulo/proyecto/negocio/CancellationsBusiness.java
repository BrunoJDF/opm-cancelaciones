package modulo.proyecto.negocio;


import modulo.authentic.DTORequest;
import modulo.authentic.DTOResponse;
import modulo.authentic.SendDevolution;
import modulo.log.Log;
import modulo.proyecto.bo.DetailInputFile;
import modulo.proyecto.bo.DetailInputFileBo;
import modulo.proyecto.bo.DetailReturn;
import modulo.proyecto.bo.InputFileBo;
import modulo.proyecto.dao.CancellationsDao;
import modulo.proyecto.dao.ReturnDao;
import modulo.proyecto.utils.GenerateReportFile;
import modulo.proyecto.utils.Utils;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CancellationsBusiness {
    private Logger log = Log.getLog(getClass());
    List<DetailReturn> returns = null;
    int poolSize = Integer.parseInt(Objects.requireNonNull(Utils.getProperty("switch.poolThread", "cancelacion.properties")));
    int timeOut = Integer.parseInt(Objects.requireNonNull(Utils.getProperty("switch.poolThread.timeout", "cancelacion.properties")));
    ExecutorService executor;

    public CancellationsBusiness() {
        this.executor = Executors.newFixedThreadPool(this.poolSize);
    }

    public List<DetailReturn> generatesCancellations(InputFileBo inputFile) {
        try {
            ReturnDao returnDao = new ReturnDao();
            this.log.debug("Processing cancellations, callToSwitch");

            List<DetailReturn> listReturn = getAccountToCancel(returnDao, inputFile);

            if (listReturn != null && !listReturn.isEmpty()) {
                this.returns = new CopyOnWriteArrayList<>();
                this.log.debug("Tamaño de la lista de las cuenta de las cuentas enviadas " + listReturn.size() + " account to cancel ");

                this.log.debug("Sending accounts to switch");

                sendToSwitch(listReturn);

                while (!executor.isTerminated()) {
                    //doNothing
                    //log.debug("returns " + this.returns.size());
                }
            }
        } catch (Exception ex) {
            log.error("error generatesCancellations" + ex.getMessage());
        }
        return this.returns;
    }

    public boolean creaDocumentoSalida(List<DetailReturn> returns2, String idBank, String nombreArchivo) {
        boolean result = false;
        String[] parameters = Utils.generaParametersOutputFile(idBank);
        String path = parameters[0];
        String nombreAjustado = nombreArchivo.substring(0, 21);
        String nombreArchivoSalida = "S013000u01." + nombreAjustado + "_RES" + ".txt";
        this.log.debug("Cuentas recibidas para hacer archivo de salida " + this.returns.size());
        result = generateOutputFile(path, nombreArchivoSalida, idBank, returns2);
        return result;
    }

    public boolean creaDocumentoSalidaErr(String message, InputFileBo inputFile) {
        boolean result = false;
        String[] parameters = Utils.generaParametersOutputFile(inputFile.getBankId(), "ERR");
        String path = parameters[0];
        String nombreAjustado = inputFile.getFileName().substring(0, 21);
        String nombreArchivoSalida = "S013000u01." + nombreAjustado + "_RES" + ".ERR";
        StringBuilder detail = new StringBuilder();
        detail.append(message);
        result = generateOutputErrorFile(path, nombreArchivoSalida, inputFile.getBankId(), detail);
        return result;
    }


    public List<DetailReturn> insertaHistoricoYBorra(List<DetailReturn> returns, Map<String, DetailReturn> yaFueronCanceladas) {
        CancellationsDao cDao = new CancellationsDao();
        boolean result = false;
        if (returns != null && !returns.isEmpty()) {
            this.log.debug("Were processed " + returns.size() + " Cancellations");
            this.log.debug("Storing cancellations processed");
            List<DetailReturn> alreadyInHistoric = getTxnAlreadyInHistoric(returns, yaFueronCanceladas); //ya en historico
            returns.removeAll(alreadyInHistoric);
            if (!returns.isEmpty()) {
                result = cDao.recordsProcessedCancellations(returns);
            } else {
                result = Boolean.TRUE.booleanValue();
            }

            if (result) {
                CancellationsDao deleteDetailTable = new CancellationsDao();

                boolean borrado = deleteDetailTable.deleteDetailTableBD();
                this.log.debug("Se borró el registro del detalle borrado es " + borrado);
            }

            returns.addAll(alreadyInHistoric);
            return returns;
        }
        return returns;
    }

    public void processAlreadyCancelledTxn(List<DetailReturn> transactions) {
        if (!transactions.isEmpty()) {
            for (int i = 0; i < transactions.size(); i++) {
                ((DetailReturn) transactions.get(i)).setErrorDescription("Cuenta previamente cancelada");
            }
        }
    }


    public List<DetailReturn> getTxnAlreadyInHistoric(List<DetailReturn> returns, Map<String, DetailReturn> mapaDeCustomerIdentifierenHistorico) {
        ArrayList<DetailReturn> alreadyInHistoric = new ArrayList<>();
        try {
            for (DetailReturn itemListaRespuesta : returns) {
                String customer_Identifier = itemListaRespuesta.getCustomerIdentifier();
                for (DetailReturn mapa : mapaDeCustomerIdentifierenHistorico.values()) {
                    if (mapa.getCustomerIdentifier().contains(customer_Identifier)) {
                        this.log.info("Customer identifier already in Historic table [" + customer_Identifier + "]");
                        itemListaRespuesta.setReturnCode(mapa.getReturnCode());
                        alreadyInHistoric.add(itemListaRespuesta);
                    }

                }
            }
        } catch (Exception e) {
            this.log.error(e);
        }
        return alreadyInHistoric;
    }

    public HashMap<String, DetailReturn> getTransactionsAlreadyCanceled() {
        return (new CancellationsDao()).revisaSiYaFueronCanceladaslasCuentasRecibeLista();
    }

    public void sendToSwitch(List<DetailReturn> listReturn) {
        for (final DetailReturn devolucion : listReturn) {
            this.executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        processCancellations(devolucion);
                    } catch (Exception e) {
                        log.error("Error sendToSwitch" + e.getMessage());
                    }
                }
            });
        }

        this.executor.shutdown();
    }

    private void processCancellations(DetailReturn devolucion) throws Exception {
        if (devolucion.getServicename().equals("retireCustomer")) {
            devolucion = callBackSwitch(devolucion);
        } else {
            devolucion.setStratus("07");
            devolucion.setReturnCode("313");
        }
        agregaDevolucion(devolucion);
    }

    public DetailReturn callBackSwitch(DetailReturn devolucion) throws Exception {
        DTOResponse response = new DTOResponse();
        double r = Math.random();
        long random;
        String randomString = String.valueOf(r);
        try {
            random = new Long(randomString.substring(3, 15));
        } catch (IndexOutOfBoundsException e) {
            String newRandomString = randomString.concat(String.valueOf(Math.random()));
            String cleanNewRandomString = newRandomString.replace(".", "");
            random = new Long(cleanNewRandomString.substring(3, 15));
        }// 20 - 0
        String originatorTransactionID = Long.toString(random);
        long systeDte = System.currentTimeMillis() * 100L;
        DTORequest request = new DTORequest();
        request.setServiceName(devolucion.getServicename());
        request.setOriginatorTransactionId(originatorTransactionID);
        request.setSystemDate(String.valueOf(systeDte));
        request.setCountryCode(devolucion.getCountryCode());
        request.setBankId(devolucion.getIdBanco());
        request.setAccessMethod("122");
        request.setCustomerIdentifier(devolucion.getCustomerIdentifier());
        request.setIdentifierType(devolucion.getIdentifierType());
        if (devolucion.getExecutiveId() != null) {
            request.setExecutiveId(devolucion.getExecutiveId());
        }
        if (devolucion.getBranchId() != null) {
            request.setBranchId(devolucion.getBranchId());
        }

        SendDevolution switchAuthentic = new SendDevolution();
        this.log.debug("Preparing to send CustomerId[" + devolucion.getCustomerIdentifier() + "] SystemDate [" + systeDte + "]");

        response = switchAuthentic.generateMessage(request);

        this.log.debug("returnCode:" + response.getReturnCode());
        this.log.debug("MpsTransactionId:" + response.getMpsTransactionId());
        this.log.debug("errorDescription:" + response.getErrorDescription());
        if (response.getReturnCode().equals("0")) {
            devolucion.setCustomer_Status(response.getCustomerStatus());
            devolucion.setFolio(response.getFolio());
            devolucion.setMpsTransactionId(response.getMpsTransactionId());
            devolucion.setReturnCode("0");
            devolucion.setBalance(response.getBalance());
        } else {
            devolucion.setErrorDescription(response.getErrorDescription());
            devolucion.setMpsTransactionId(response.getMpsTransactionId());
            devolucion.setReturnCode(response.getReturnCode());
            devolucion.setCustomer_Status(response.getCustomerStatus());
            devolucion.setBalance(response.getBalance());
        }
        return devolucion;
    }

    public void agregaDevolucion(DetailReturn devolucion) {
        this.returns.add(devolucion);
    }


    public List<DetailReturn> getAccountToCancel(ReturnDao returnDao, HashMap<String, DetailInputFile> ctaaCancelar) throws Exception {
        List<DetailReturn> accountToCancel = returnDao.getListAccountFinalToCancel(ctaaCancelar);
        if (accountToCancel != null) {
            if (accountToCancel.size() > 0) {
                return accountToCancel;
            }
        } else {
            this.log.debug("Error while performing the query");
        }
        return accountToCancel;
    }

    public List<DetailReturn> getAccountToCancel(ReturnDao returnDao, InputFileBo inputFile) throws Exception {
        List<DetailReturn> accountToCancel = returnDao.getListAccountFinalToCancel(inputFile);
        if (accountToCancel != null) {
            if (accountToCancel.size() > 0) {
                return accountToCancel;
            }
        } else {
            this.log.debug("Error while performing the query");
        }
        return accountToCancel;
    }

    public long devuelveSystemDate() {
        Double r = Double.valueOf(Math.random());
        Long random = new Long(r.toString().substring(2, 18));
        System.out.println(random);
        return random.longValue();
    }

    public String getSystemDate() {
        Random random = new Random();

        String systemDate = (new StringBuilder(String.valueOf(System.currentTimeMillis()))).toString();
        systemDate = String.valueOf(systemDate) + getRandomInteger(1000, 9999, random);
        return systemDate;
    }

    public int getRandomInteger(int aStart, int aEnd, Random aRandom) {
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Error generando aleatorio.");
        }

        long range = (aEnd - aStart) + 1L;

        long fraction = (long) (range * aRandom.nextDouble());
        int randomNumber = (int) (fraction + aStart);
        return randomNumber;
    }


    public boolean generateOutputFile(String rutaArchivo, String nameFile, String idBank, List<DetailReturn> lstDetalle) {
        boolean result = false;
        StringBuilder header = null;
        StringBuilder detail = null;
        int numeroRegistros = lstDetalle.size();
        try {
            header = HeaderCreation(idBank, numeroRegistros);
            detail = DetailCreation(lstDetalle);
            if (GenerateReportFile.generaArchivo(rutaArchivo, nameFile, header, detail, null)) {
                this.log.debug("Reglas de negocio aplicadas correctamente");
                result = true;
            } else {
                this.log.debug("Reglas de negocion NO aplicadas correctamente");
                result = false;
            }
        } catch (Exception e) {
            this.log.error("Error generando archivo de salida");
            this.log.error(e);
        }
        return result;
    }

    public boolean generateOutputErrorFile(String rutaArchivo, String nameFile, String idBank, StringBuilder detail) {
        boolean result = false;
        StringBuilder header = null;
        int numeroRegistros = 0;
        try {
            header = HeaderCreation(idBank, numeroRegistros);
            if (GenerateReportFile.generaArchivo(rutaArchivo, nameFile, header, detail, null)) {
                this.log.debug("Reglas de negocio aplicadas correctamente");
                result = true;
            } else {
                this.log.debug("Reglas de negocion NO aplicadas correctamente");
                result = false;
            }
        } catch (Exception e) {
            this.log.error("Error generando archivo de salida");
            this.log.error(e);
        }
        return result;
    }

    public StringBuilder HeaderCreation(String idBanco, int numeroRegistros) throws Exception {
        StringBuilder header = new StringBuilder();
        header.append("HD|");
        header.append(idBanco).append("|");
        header.append(numeroRegistros);
        return header;
    }

    public StringBuilder DetailCreation(List<DetailReturn> lstDetalle) throws Exception {
        StringBuilder formato = new StringBuilder();
        for (DetailReturn detalle : lstDetalle) {
            formato.append("DT|");
            formato.append(detalle.getIdentifierType()).append("|");

            int tamano = detalle.getCustomerIdentifier().length();
            switch (tamano) {
                case 18:
                    formato.append(detalle.getCustomerIdentifier()).append("|");
                    break;
                case 12:
                    formato.append("000000").append(detalle.getCustomerIdentifier()).append("|");
                    break;
                case 16:
                    formato.append("00").append(detalle.getCustomerIdentifier()).append("|");
                    break;
                case 11:
                    formato.append("0000000").append(detalle.getCustomerIdentifier()).append("|");
                    break;
            }

            formato.append(detalle.getFecha()).append("|");

            if (detalle.getExecutiveId() != null && !detalle.getExecutiveId().equals("0")) {
                formato.append(detalle.getExecutiveId()).append("|");
            } else {
                formato.append("0000000000").append("|");
            }
            if (detalle.getBranchId() != null) {
                formato.append(detalle.getBranchId()).append("|");
            } else {
                formato.append("              ").append("|");
            }
            if (detalle.getErrorDescription() != null) {
                formato.append(detalle.getErrorDescription()).append("|");
            } else {
                formato.append("             ").append("|");
            }
            formato.append(detalle.getReturnCode()).append("|");
            if (detalle.getCustomer_Status() != null) {
                formato.append(detalle.getCustomer_Status()).append("|");
            } else {
                formato.append("  ").append("|");
            }
            if (detalle.getBalance() != null) {
                formato.append(detalle.getBalance()).append("|");
            }
            if (detalle.getFolio() != null) {
                formato.append(detalle.getFolio()).append("|");
            }
            if (detalle.getMpsTransactionId() != null) {
                formato.append(detalle.getMpsTransactionId());
            }

            formato.append("\r\n");
        }
        return formato;
    }

    public List<DetailReturn> convertDuplicate(List<DetailInputFileBo> duplicates) {
        List<DetailReturn> results = new ArrayList<>();
        if (!duplicates.isEmpty()) {
            for (DetailInputFileBo record : duplicates) {
                DetailReturn returnBO = new DetailReturn();
                returnBO.setBranchId(record.getBranchId());
                returnBO.setCustomerIdentifier(record.getCustomerIdentifier());
                returnBO.setIdentifierType(record.getIdentifierType());
                returnBO.setFecha(Integer.parseInt(record.getProcessDate()));
                returnBO.setExecutiveId(record.getExecutiveId());
                returnBO.setErrorDescription("Cuenta cancelada previamente");
                returnBO.setReturnCode("900");
                results.add(returnBO);
            }
        }
        return results;
    }

}


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyecto\negocio\CancellationsBusiness.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */