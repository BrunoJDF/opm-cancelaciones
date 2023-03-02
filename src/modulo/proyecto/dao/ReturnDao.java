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
import java.util.Map;

public class ReturnDao {
    private Logger log = Log.getLog(getClass());

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private Map<String, String> valuesDB;

    public ReturnDao() {
        this.valuesDB = Utils.getDBProperties();
    }


    public int obtenerSecuencia() {
        int sequencia = -1;
        if (!openDB()) {
            return sequencia;
        }
        try {
            StringBuilder query = new StringBuilder();
            query.append("SELECT *FROM OPM_CANCELACC_BATCH WHERE PROCESADO = 1 ");

            this.log.debug(query);

            this.stmt = this.conn.createStatement();
            this.rs = this.stmt.executeQuery(query.toString());

            if (this.rs.next()) {
                sequencia = this.rs.getInt(1);
            }
        } catch (Exception e) {
            this.log.error("Error obteniendo secuencia OPM_CANCELACC_BATCH", e);
        } finally {
            closeDB();
        }
        return sequencia;
    }


    public ArrayList<DetailReturn> getListAccountFinalToCancel(HashMap<String, DetailInputFile> ctaaCancelar) {
        String nameService = "retireCustomer";
        String countryCode = "484";

        ArrayList<DetailReturn> listAccountsToCancel = new ArrayList<>();
        DetailReturn detDevolucion = null;

        if (!openDB()) {
            return null;
        }
        try {
            for (DetailInputFile string : ctaaCancelar.values()) {
                detDevolucion = new DetailReturn();
                detDevolucion.setIdBanco(string.getIdBanco());
                detDevolucion.setIdentifierType(Integer.toString(string.getIdentifierType()));
                detDevolucion.setCustomerIdentifier(string.getCustomerIdentifier());
                detDevolucion.setFecha(string.getFecha());
                detDevolucion.setExecutiveId(string.getExecutiveId());
                detDevolucion.setBranchId(string.getBranchId());
                detDevolucion.setServicename(nameService);
                detDevolucion.setCountryCode(countryCode);

                listAccountsToCancel.add(detDevolucion);
            }
        } catch (Exception exception) {


        } finally {


            closeDB();
        }
        return listAccountsToCancel;
    }


    public ArrayList<DetailReturn> getListAccountFinalToCancel(InputFileBo inputFile) {
        String nameService = "retireCustomer";
        String countryCode = "484";

        ArrayList<DetailReturn> listAccountsToCancel = new ArrayList<>();
        DetailReturn detDevolucion = null;

        if (!openDB()) {
            return null;
        }
        try {
            for (DetailInputFileBo detail : inputFile.getRecords()) {
                detDevolucion = new DetailReturn();
                detDevolucion.setIdBanco(inputFile.getBankId());
                detDevolucion.setIdentifierType(detail.getIdentifierType());
                detDevolucion.setCustomerIdentifier(detail.getCustomerIdentifier());
                detDevolucion.setFecha(Integer.parseInt(detail.getProcessDate()));
                detDevolucion.setExecutiveId(detail.getExecutiveId());
                detDevolucion.setBranchId(detail.getBranchId());
                detDevolucion.setServicename(nameService);
                detDevolucion.setCountryCode(countryCode);

                listAccountsToCancel.add(detDevolucion);
            }
        } catch (Exception exception) {


        } finally {
            closeDB();
        }
        return listAccountsToCancel;
    }

    private boolean openDB() {
        try {
            DriverManager.registerDriver((Driver) new OracleDriver());

            String user = this.valuesDB.get("user");
            String pass = "umerchant"; //this.valuesDB.get("pass");
            this.conn = DriverManager.getConnection("jdbc:oracle:thin:@" + (String) this.valuesDB.get("ip") + ":" + (String) this.valuesDB.get("port") + ":" + (String) this.valuesDB.get("sid"), user, pass);


            return true;
        } catch (SQLException e) {
            this.log.error("Error al abrir la conexion", e);

            return false;
        }
    }

    private void closeDB() {
        try {
            this.conn.close();
            this.conn = null;
            if (this.stmt != null && !this.stmt.isClosed()) {
                this.stmt.close();
                this.stmt = null;
            }
            if (this.rs != null && !this.rs.isClosed()) {
                this.rs.close();
                this.rs = null;
            }
        } catch (SQLException e) {
            this.log.error("Error al cerrar la conexion", e);
        }
    }
}


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyecto\dao\ReturnDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */