package modulo.proyecto.dao;


import modulo.log.Log;
import modulo.proyecto.bo.DetailInputFile;
import modulo.proyecto.bo.DetailInputFileBo;
import modulo.proyecto.bo.DetailReturn;
import modulo.proyecto.bo.InputFileBo;
import modulo.proyecto.utils.Utils;
import oracle.jdbc.OracleDriver;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CancellationsDao {
    private Logger log = Log.getLog(getClass());

    private Connection conn;
    private Map<String, String> valuesDB;

    public CancellationsDao() {
        this.valuesDB = Utils.getDBProperties();
    }

    private boolean openDB() {
        try {
            DriverManager.registerDriver((Driver) new OracleDriver());

            String user = this.valuesDB.get("user");
            String pass = this.valuesDB.get("pass");
            this.conn = DriverManager.getConnection("jdbc:oracle:thin:@" + (String) this.valuesDB.get("ip") + ":" + (String) this.valuesDB.get("port") + "/" + (String) this.valuesDB.get("sid"), user, pass);
            this.conn.setAutoCommit(false);
            return true;
        } catch (SQLException e) {
            this.log.error("Error opening connection", e);

            return false;
        }
    }

    public boolean insertDetailCancellations(InputFileBo inputFileBo) {
        int[] rs = null;
        StringBuffer query = null;
        boolean result = false;
        PreparedStatement ps = null;
        this.log.info("Inserting [" + inputFileBo.getRecords().size() + "] to temp table");
        if (!openDB()) {
            return false;
        }
        try {
            query = new StringBuffer();
            query.append("INSERT INTO OPM_CANCELACC_BATCH ");
            query.append("(ID_BANCO, IDENTIFIER_TYPE, CUSTOMER_IDENTIFIER, FECHA_SOLICITUD,EXECUTIVE_ID,");
            query.append("BRANCH_ID)");
            query.append("VALUES(?,?,?,?,?,?)");

            this.log.debug(query);
            ps = this.conn.prepareStatement(query.toString());

            for (DetailInputFileBo detail : inputFileBo.getRecords()) {
                ps.setString(1, inputFileBo.getBankId());
                ps.setInt(2, Integer.parseInt(detail.getIdentifierType()));
                ps.setString(3, detail.getCustomerIdentifier());
                ps.setInt(4, Integer.parseInt(detail.getProcessDate()));
                ps.setString(5, detail.getExecutiveId());
                ps.setString(6, detail.getBranchId());
                ps.addBatch();
            }

            try {
                rs = ps.executeBatch();
                if (rs.length > 0) {
                    this.conn.commit();
                    result = true;
                }

                if (rs.length <= 0) {
                    this.log.info("Error inserting the detail of the accounts to be canceled");
                }
            } catch (Exception e) {
                this.log.info("Error inserting the detail of the accounts to be canceled" + e);
            }

        } catch (Exception e) {
            this.log.error(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception exception) {
            }
        }


        return result;
    }

    public boolean insertTableHeaderFile(String fileName, int fechaSolicitud, int status, int hash) {
        boolean result = Boolean.FALSE.booleanValue();
        int[] rs = null;
        StringBuffer query = null;
        PreparedStatement ps = null;

        this.log.debug("Inserting in the header table");
        if (!openDB()) {
            return Boolean.FALSE.booleanValue();
        }
        try {
            query = new StringBuffer();
            query.append("INSERT INTO OPM_RETCUST_FILE");
            query.append("(NOMBRE_ARCHIVO, FECHA_PROCESADO,STATUS,HASH)");
            query.append("VALUES(?,?,?,?)");

            this.log.debug(query);
            ps = this.conn.prepareStatement(query.toString());

            ps.setString(1, fileName);
            ps.setInt(2, fechaSolicitud);
            ps.setInt(3, status);
            ps.setInt(4, hash);
            ps.addBatch();

            try {
                rs = ps.executeBatch();
                if (rs.length > 0) {
                    this.conn.commit();
                    result = Boolean.TRUE.booleanValue();
                } else {
                    this.log.info("Error inserting the file into the header table");
                }
            } catch (Exception e) {
                this.log.info("Could not insert file" + e);
                result = Boolean.FALSE.booleanValue();
            }
        } catch (Exception e) {
            this.log.info("Error inserting the file into the header table", e);
            result = Boolean.FALSE.booleanValue();
        }
        return result;
    }

    public boolean UpdatesStatusFileCancellations2(String nombreArchivo, int status) {
        boolean resultado = false;
        StringBuffer query = null;
        PreparedStatement ps = null;

        System.out.println("YA ENTRE AL METODO PARA ACTUALIZAR STATUS");
        this.log.debug("Insertando en la tabla del archivo");
        if (!openDB()) {
            return false;
        }

        try {
            query = new StringBuffer();
            query.append("UPDATE OPM_RETCUST_FILE SET STATUS = 2 WHERE NOMBRE_ARCHIVO ='" + nombreArchivo + "'");
            this.log.debug(query);
            ps = this.conn.prepareStatement(query.toString());
            try {
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    this.conn.commit();
                    resultado = true;
                }
            } catch (Exception exception) {
            }

        } catch (Exception e) {
            e.printStackTrace();
            this.log.error(e);
        } finally {

            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                    System.out.println(ps);
                }
            } catch (Exception ex) {
                this.log.error(ex);
                resultado = false;
            }
        }
        return resultado;
    }

    public boolean actualizaEstatusArchivioCancelaciones3(String nombreArchivo, int status) {
        boolean resultado = false;
        StringBuffer query = null;
        PreparedStatement ps = null;

        System.out.println("YA ENTRE AL METODO PARA ACTUALIZAR STATUS");
        this.log.debug("Insertando en la tabla del archivo");
        if (!openDB()) {
            return false;
        }

        try {
            query = new StringBuffer();
            query.append("UPDATE OPM_RETCUST_FILE SET STATUS = 2 WHERE NOMBRE_ARCHIVO ='" + nombreArchivo + "'");
            this.log.debug(query);
            ps = this.conn.prepareStatement(query.toString());
            try {
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    this.conn.commit();
                    resultado = true;
                }
            } catch (Exception exception) {
            }

        } catch (Exception e) {
            e.printStackTrace();
            this.log.error(e);
        } finally {

            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                    System.out.println(ps);
                }
            } catch (Exception ex) {
                this.log.error(ex);
                resultado = false;
            }
        }
        return resultado;
    }

    public boolean deleteDetailTableBD() {
        boolean result = false;

        Statement st = null;
        if (!openDB()) {
            return false;
        }

        try {
            st = this.conn.createStatement();
            String sb = new String();
            sb = "DELETE FROM OPM_CANCELACC_BATCH";

            st.executeQuery(sb);

            if (st != null) {
                result = true;
                this.log.debug("Already deleted the detail from the temporal table");
            }

        } catch (Exception e) {
            this.log.debug("Error deleting temporal detail table");
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (Exception ex) {
                this.log.error(ex);
                result = false;
            }
        }

        return result;
    }

    public boolean recordsProcessedCancellations(List<DetailReturn> devoluciones) {
        int[] result = null;
        StringBuilder query = null;
        boolean resultado = false;
        PreparedStatement pstmt = null;

        this.log.debug("Storing details in history");
        if (!openDB()) {
            return false;
        }
        try {
            query = new StringBuilder();
            query.append("INSERT INTO OPM_CANCELACC_BATCH_HISTORICO");
            query.append("(ID_BANCO, IDENTIFIER_TYPE, CUSTOMER_IDENTIFIER, FECHA_SOLICITUD,EXECUTIVE_ID,");
            query.append("BRANCH_ID, ERROR_DESCRIPTION, CUSTOMER_STATUS,BALANCE,");
            query.append("FOLIO, MPS_TRANSACTION_ID, PROCESADO,RETURN_CODE)");
            query.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");

            this.log.debug(query);
            pstmt = this.conn.prepareStatement(query.toString());

            for (DetailReturn devolucion : devoluciones) {

                pstmt.setString(1, devolucion.getIdBanco());
                pstmt.setString(2, devolucion.getIdentifierType());
                pstmt.setString(3, devolucion.getCustomerIdentifier());
                pstmt.setInt(4, devolucion.getFecha());
                pstmt.setString(5, devolucion.getExecutiveId());
                pstmt.setString(6, devolucion.getBranchId());
                pstmt.setString(7, devolucion.getErrorDescription());
                pstmt.setString(8, devolucion.getCustomer_Status());
                pstmt.setString(9, devolucion.getBalance());
                pstmt.setString(10, devolucion.getFolio());
                pstmt.setString(11, devolucion.getMpsTransactionId());
                pstmt.setInt(12, 1);
                pstmt.setString(13, devolucion.getReturnCode());
                pstmt.addBatch();
            }

            try {
                result = pstmt.executeBatch();
                this.log.info("Records of detail in history are stored successfully ");

                if (result.length > 0) {
                    this.conn.commit();
                    resultado = true;
                }

            } catch (Exception e) {
                this.log.info("Error storing processed cancellations ");
            }

        } catch (Exception e) {
            this.log.error(e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception ex) {
                this.log.error(ex);
                resultado = false;
            }
        }

        return resultado;
    }

    public ArrayList<String> revisaSiYaFueronCanceladaslasCuentas(HashMap<String, DetailInputFile> mapAccountToCancel) {
        ArrayList<String> cuentasYaCanceladas = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        this.log.debug("Revisar si la cuenta ya fue cancelada");
        if (!openDB()) {
            return null;
        }

        try {
            StringBuffer query = new StringBuffer();
            query.append("Select CUSTOMER_IDENTIFIER from OPM_CANCELACC_BATCH_HISTORICO where ");
            query.append("CUSTOMER_IDENTIFIER IN (");

            for (DetailInputFile iterable_element : mapAccountToCancel.values()) {
                query.append("'");
                query.append(iterable_element.getCustomerIdentifier());
                query.append("',");
            }
            query.setLength(query.length() - 1);
            query.append(")");

            this.log.debug(query);
            ps = this.conn.prepareStatement(query.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                String identificadorCliente = rs.getString("CUSTOMER_IDENTIFIER");
                cuentasYaCanceladas.add(identificadorCliente);
            }

        } catch (Exception e) {
            this.log.error("Error consultando si hay cuentas Ya canceladas", e);
        }

        return cuentasYaCanceladas;
    }

    public ArrayList<String> revisaSiYaFueronCanceladaslasCuentas() {
        ArrayList<String> cuentasYaCanceladas = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        this.log.debug("Revisar si la cuenta ya fue cancelada");
        if (!openDB()) {
            return null;
        }

        try {
            StringBuffer query = new StringBuffer();
            query.append("Select CUSTOMER_IDENTIFIER from OPM_CANCELACC_BATCH_HISTORICO where ");
            query.append("CUSTOMER_IDENTIFIER IN (");
            query.append("SELECT CUSTOMER_IDENTIFIER FROM OPM_CANCELACC_BATCH");
            query.append(")");

            this.log.debug(query);
            ps = this.conn.prepareStatement(query.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                String identificadorCliente = rs.getString("CUSTOMER_IDENTIFIER");
                cuentasYaCanceladas.add(identificadorCliente);
            }

        } catch (Exception e) {
            this.log.error("Error consultando si hay cuentas Ya canceladas", e);
        }

        return cuentasYaCanceladas;
    }

    public HashMap<String, String> revisaSiYaFueronCanceladaslasCuentasRecibeLista(List<DetailReturn> returns) {
        HashMap<String, String> mapaCuentasYaEnDetalleHistorico = new HashMap<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        this.log.debug("Revisar si la cuenta ya fue cancelada");
        if (!openDB()) {
            return null;
        }

        try {
            StringBuffer query = new StringBuffer();
            query.append("Select CUSTOMER_IDENTIFIER from OPM_CANCELACC_BATCH_HISTORICO where ");
            query.append("CUSTOMER_IDENTIFIER IN (");

            for (DetailReturn string : returns) {
                query.append("'");
                query.append(string.getCustomerIdentifier());
                query.append("',");
            }

            query.setLength(query.length() - 1);
            query.append(")");

            this.log.debug(query);
            ps = this.conn.prepareStatement(query.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                String identificadorCliente = rs.getString("CUSTOMER_IDENTIFIER");

                mapaCuentasYaEnDetalleHistorico.put(identificadorCliente, identificadorCliente);
            }

        } catch (Exception e) {
            this.log.error("Error consultando si hay cuentas Ya canceladas", e);
        }

        return mapaCuentasYaEnDetalleHistorico;
    }

    public HashMap<String, DetailReturn> revisaSiYaFueronCanceladaslasCuentasRecibeLista() {
        HashMap<String, DetailReturn> mapaCuentasYaEnDetalleHistorico = new HashMap<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        this.log.debug("Revisar si la cuenta ya fue cancelada");
        if (!openDB()) {
            return null;
        }

        try {
            StringBuffer query = new StringBuffer();
            query.append("Select CUSTOMER_IDENTIFIER, RETURN_CODE from OPM_CANCELACC_BATCH_HISTORICO where ");
            query.append("CUSTOMER_IDENTIFIER IN (");
            query.append("SELECT CUSTOMER_IDENTIFIER FROM OPM_CANCELACC_BATCH");
            query.append(")");

            this.log.debug(query);
            ps = this.conn.prepareStatement(query.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                String identificadorCliente = rs.getString("CUSTOMER_IDENTIFIER");
                DetailReturn detailReturn = new DetailReturn();
                detailReturn.setCustomerIdentifier(identificadorCliente);
                detailReturn.setReturnCode(rs.getString("RETURN_CODE"));

                mapaCuentasYaEnDetalleHistorico.put(identificadorCliente, detailReturn);
            }

        } catch (Exception e) {
            this.log.error("Error consultando si hay cuentas Ya canceladas", e);
        }

        return mapaCuentasYaEnDetalleHistorico;
    }
}


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyecto\dao\CancellationsDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */