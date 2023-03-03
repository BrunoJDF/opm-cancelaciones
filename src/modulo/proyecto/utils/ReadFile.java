package modulo.proyecto.utils;

import modulo.cancelacion.CancellationProcess;
import modulo.exception.FileValidationException;
import modulo.log.Log;
import modulo.proyecto.bo.DetailInputFileBo;
import modulo.proyecto.bo.InputFileBo;
import modulo.proyecto.dao.CancellationsDao;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;

public class ReadFile {
    private static Logger log = Log.getLog(CancellationProcess.class);
    private static final String INVALID_HEADER = "Header fields do not match with specification";
    private static final String INVALID_BANKID = "Header Bank id does not match with file bank name";
    private static final String RECORDS_NOT_MATCH = "The records of the header do not match with number of details";
    private static final String INVALID_PREFIX = "Prefix file name is invalid";
    private static final String IDENTIFIER_TYPE_INVALID = "Does not match the customer identifier with the type identifier";

    public static boolean readAndValidateFile(InputFileBo inputFile) throws FileValidationException, IOException {
        boolean isSuccess = Boolean.FALSE.booleanValue();

        Throwable var2 = null;
        Object var3 = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile.getFilePath()));

            try {
                ArrayList<DetailInputFileBo> details = new ArrayList();

                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("HD")) {
                        validateHeader(line, inputFile.getFileName().substring(0, 9), inputFile);
                        continue;
                    }
                    if (line.startsWith("DT")) {
                        details.add(validateDetail(line, inputFile));
                    }
                }

                inputFile.setRecords(details);
                if (inputFile.getRecordsNumber() != inputFile.getRecords().size()) {
                    throw new FileValidationException("The records of the header do not match with number of details");
                }


                log.debug("Detail file validation...OK");
                if (insertTableHeaderFile(inputFile)) {
                    log.info("The header was inserted");
                    isSuccess = Boolean.TRUE.booleanValue();
                } else {
                    log.info("An error occurred while inserting the header in the bd");
                    isSuccess = Boolean.FALSE.booleanValue();
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }

        } catch (Throwable var14) {
            if (var2 == null) {
                var2 = var14;
            } else if (var2 != var14) {
                var2.addSuppressed(var14);
            }
            throw new FileValidationException("An error occurred while inserting the header in the bd", "999");
        }

        return isSuccess;
    }

    private static boolean insertTableHeaderFile(InputFileBo inputFile) {
        CancellationsDao insertFile = new CancellationsDao();
        int hash = inputFile.hashCode();
        String actualDate = DateUtils.parseDateToSQLStringfinancial(Calendar.getInstance().getTime());
        return insertFile.insertTableHeaderFile(inputFile.getFileName(), Integer.parseInt(actualDate), 1, hash);
    }


    private static void validateHeader(String headerLine, String bank, InputFileBo inputFileBo) throws FileValidationException {
        log.debug("Header Validation...");
        String[] stringHeader = headerLine.split(Pattern.quote("|"));
        if (stringHeader.length < 3) {
            throw new FileValidationException("Header fields do not match with specification", "001");
        }
        switch (bank.hashCode()) {
            case 126336119:
                if (!bank.equals("INBCANCEL")) {
                    throw new FileValidationException("Prefix file name is invalid");
                }

                if (!"036".equals(stringHeader[1])) {
                    throw new FileValidationException("Header Bank id does not match with file bank name");
                }
                break;
            case 496016935:
                if (!bank.equals("BMXCANCEL")) {
                    throw new FileValidationException("Prefix file name is invalid");
                }

                if (!"002".equals(stringHeader[1])) {
                    throw new FileValidationException("Header Bank id does not match with file bank name");
                }
                break;
            case 1737687913:
                if (bank.equals("BCPCANCEL")) {
                    if (!"137".equals(stringHeader[1])) {
                        throw new FileValidationException("Header Bank id does not match with file bank name");
                    }

                    break;
                }

                throw new FileValidationException("Prefix file name is invalid");
            default:
                throw new FileValidationException("Prefix file name is invalid");
        }

        if (!Utils.isNumeric(stringHeader[2])) {
            throw new FileValidationException("La cantidad de registros es invalida");
        }
        inputFileBo.setBankId(stringHeader[1]);
        inputFileBo.setRecordsNumber(Integer.parseInt(stringHeader[2]));
        log.debug("Header Validation...OK");
        log.debug("Performing detail validation...");
    }


    private static DetailInputFileBo validateDetail(String line, InputFileBo inputFile) throws FileValidationException {
        String[] stringDetail = line.split(Pattern.quote("|"));
        DetailInputFileBo detailInput = new DetailInputFileBo();
        if (stringDetail.length < 4) {
            throw new FileValidationException("Datos de archivo incompletos");
        }
        validateIdentifierType(stringDetail[1], stringDetail[2], detailInput, inputFile);
        validateDateRequest(stringDetail[3], detailInput, inputFile);
        if (stringDetail.length > 4) {
            if (stringDetail[4].length() > 3) {
                if (stringDetail[4].length() == 10) {
                    detailInput.setExecutiveId(stringDetail[4]);
                }

                if (stringDetail[4].length() == 14) {
                    detailInput.setBranchId(stringDetail[4]);
                }
            }

            if (stringDetail.length > 5 && detailInput.getBranchId() == null && stringDetail[5].length() == 14) {
                detailInput.setBranchId(stringDetail[5]);
            }
        }

        return detailInput;
    }


    private static void validateIdentifierType(String identifierType, String customerIdentifier, DetailInputFileBo detailInput, InputFileBo inputFile) throws FileValidationException {
        if (!Utils.isNumeric(identifierType)) {
            throw new FileValidationException("The file does not have a valid type identifier");
        }
        int idType = Integer.parseInt(identifierType);
        switch (idType) {
            case 101:
                if (customerIdentifier.length() != 12) {
                    throw new FileValidationException("Does not match the customer identifier with the type identifier");
                }
                break;

            case 102:
                if (customerIdentifier.length() != 18) {
                    throw new FileValidationException("Does not match the customer identifier with the type identifier");
                }
                break;

            case 103:
                if (customerIdentifier.length() != 16) {
                    throw new FileValidationException("Does not match the customer identifier with the type identifier");
                }
                break;

            case 104:
                if (customerIdentifier.length() != 11) {
                    throw new FileValidationException("Does not match the customer identifier with the type identifier");
                }
                break;

            default:
                throw new FileValidationException("Does not match the customer identifier with the type identifier");
        }


        detailInput.setIdentifierType(identifierType);
        detailInput.setCustomerIdentifier(customerIdentifier);
    }


    private static void validateDateRequest(String dateRequest, DetailInputFileBo detailInput, InputFileBo inputFile) throws FileValidationException {
        if (dateRequest.length() != 8)
            throw new FileValidationException("The file does not have  the date request");
        if (!Utils.isNumeric(dateRequest)) {
            throw new FileValidationException("The request date is invalid");
        }
        detailInput.setProcessDate(dateRequest);
    }
}


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyect\\utils\ReadFile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */