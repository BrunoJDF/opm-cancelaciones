package modulo.proyecto.utils;


import modulo.log.Log;
import modulo.proyecto.bo.DetailInputFile;
import modulo.proyecto.bo.DetailInputFileBo;
import modulo.proyecto.bo.InputFileBo;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.*;

public class Utils {
    private static Logger log = Log.getLog(Utils.class);

    public static String getFileName(String idBank, int dateNumber) {
        int dateFile = dateNumber;
        String nameFile = null;

        if (idBank.equals("002")) {
            nameFile = "BMXCANCEL_" + dateFile + ".txt";
        } else if (idBank.equals("036")) {
            nameFile = "INBCANCEL_" + dateFile + ".txt";
        } else if (idBank.equals("137")) {
            nameFile = "BCPCANCEL_" + dateFile + ".txt";
        }

        return nameFile;
    }

    public static int convierteFechaEntero(String fecha) {
        int fechaProcesado = 0;
        String fechaProcesadaCadena = fecha.replace("-", "");
        fechaProcesado = Integer.parseInt(fechaProcesadaCadena);
        return fechaProcesado;
    }

    public static String getProperty(String property, String properties) {
        Properties p = new Properties();
        InputStream istream = null;
        try {
            istream = Utils.class.getResource("/" + properties).openStream();
            p.load(istream);
            return p.getProperty(property);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        } finally {
            try {
                istream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean copyFile(String fileOrigin, String fileDest) {
        try {
            Path FROM = Paths.get(fileOrigin, new String[0]);
            Path TO = Paths.get(fileDest, new String[0]);
            CopyOption[] options = {StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES};

            Files.copy(FROM, TO, options);
            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public static boolean deleteFile(String archivo) {
        boolean isDelete = false;
        File fichero = new File(archivo);
        if (fichero.delete()) {
            isDelete = true;
            System.out.println("archivo eliminado");
        }
        return isDelete;
    }

    public static boolean moverArchivos(String pathFileInicial, String pathDestino) {
        return false;
    }

    public static String obtenPathDestino(String pathInicial) {
        String usserHome = null;

        String pathDestino = null;
        if (pathInicial.contains("BMX")) {
            usserHome = System.getProperty("user.home");
            String path = String.valueOf(usserHome) + "/reports/temp_input_files/MCM/Banamex/";
            pathDestino = path;
        } else if (pathInicial.contains("INB")) {
            usserHome = System.getProperty("user.home");
            String path = String.valueOf(usserHome) + "/reports/temp_input_files/MCM/Inbursa/";
            pathDestino = path;
        } else if (pathInicial.contains("BCP")) {
            usserHome = System.getProperty("user.home");
            String path = String.valueOf(usserHome) + "/reports/temp_input_files/MCM/Bancoppel/";
            pathDestino = path;
        }

        return pathDestino;
    }

    public static String validarMonto(String samount) {
        String decimales = "";
        int traePunto = samount.indexOf('.');
        String[] arreglo = samount.split("\\.");
        if (traePunto != -1) {
            decimales = arreglo[1];
        }
        while (decimales.length() < 2) {
            decimales = String.valueOf(decimales) + "0";
        }
        samount = arreglo[0];
        samount = String.valueOf(samount) + decimales;
        return samount;
    }

    public static Map<String, String> getDBProperties() {
        Properties p = new Properties();
        InputStream istream = null;
        try {
            istream = Utils.class.getResource("/config.properties").openStream();
            p.load(istream);
            Map<String, String> values = new HashMap<>();
            values.put("user", (new Encryption()).decrypt(p.getProperty("user.c1")));
            values.put("pass", (new Encryption()).decrypt(p.getProperty("pass.c1")));
            values.put("ip", p.getProperty("ip.c1"));
            values.put("port", p.getProperty("port.c1"));
            values.put("sid", p.getProperty("sid.c1"));
            System.out.println("llegue aqui cjc");
            return values;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        } finally {
            try {
                istream.close();
            } catch (IOException iOException) {
            }
        }
    }


    public static String[] generaParametersOutputFile(String idBanco) {
        String[] parametros = new String[2];

        String usserHome = null;

        if (idBanco.equals("002")) {
            usserHome = System.getProperty("user.home");
            String path = String.valueOf(usserHome) + "/reports/output_files/MCM/Banamex";
            String pathSalida = path;
            parametros[0] = pathSalida;
            String fechaCadena = ManejadorFechas.getFechaActual();
            int fechaInt = convierteFechaEntero(fechaCadena);
            String nombreArchivoSalida = "BMXCANCEL_" + fechaInt + "_RE" + ".txt";
            parametros[1] = nombreArchivoSalida;
            return parametros;
        }
        if (idBanco.equals("036")) {
            usserHome = System.getProperty("user.home");
            String path = String.valueOf(usserHome) + "/reports/output_files/MCM/Inbursa";
            String pathSalida = path;
            parametros[0] = pathSalida;
            String fechaCadena = ManejadorFechas.getFechaActual();
            int fechaInt = convierteFechaEntero(fechaCadena);
            String nombreArchivoSalida = "IBNCANCEL_" + fechaInt + "_RE" + ".txt";
            parametros[1] = nombreArchivoSalida;
            return parametros;
        }
        if (idBanco.equals("137")) {
            usserHome = System.getProperty("user.home");
            String path = String.valueOf(usserHome) + "/reports/output_files/MCM/Bancoppel";
            String pathSalida = path;
            parametros[0] = pathSalida;
            String fechaCadena = ManejadorFechas.getFechaActual();
            int fechaInt = convierteFechaEntero(fechaCadena);
            String nombreArchivoSalida = "BCPCANCEL_" + fechaInt + "_RE" + ".txt";
            parametros[1] = nombreArchivoSalida;
            return parametros;
        }
        return parametros;
    }

    public static String[] generaParametersOutputFile(String idBanco, String extension) {
        String[] parametros = new String[2];

        String usserHome = "c:/Users/${current_user_name}";

        if (idBanco.equals("002")) {
            usserHome = System.getProperty("user.home");
            String path = String.valueOf(usserHome) + "/reports/output_files/MCM/Banamex";
            String pathSalida = path;
            String fechaCadena = ManejadorFechas.getFechaActual();
            int fechaInt = convierteFechaEntero(fechaCadena);
            String nombreArchivoSalida = "BMXCANCEL_" + fechaInt + "_RE" + "." + extension;
            parametros[1] = nombreArchivoSalida;
            return parametros;
        }
        if (idBanco.equals("036")) {
            usserHome = System.getProperty("user.home");
            String path = String.valueOf(usserHome) + "/reports/output_files/MCM/Inbursa";
            String pathSalida = path;
            String fechaCadena = ManejadorFechas.getFechaActual();
            int fechaInt = convierteFechaEntero(fechaCadena);
            String nombreArchivoSalida = "IBNCANCEL_" + fechaInt + "_RE" + "." + extension;
            parametros[1] = nombreArchivoSalida;
            return parametros;
        }
        if (idBanco.equals("137")) {
            usserHome = System.getProperty("user.home");
            String path = String.valueOf(usserHome) + "/reports/output_files/MCM/Bancoppel";
            String pathSalida = path;
            String fechaCadena = ManejadorFechas.getFechaActual();
            int fechaInt = convierteFechaEntero(fechaCadena);
            String nombreArchivoSalida = "BCPCANCEL_" + fechaInt + "_RE" + "." + extension;
            parametros[1] = nombreArchivoSalida;
            return parametros;
        }
        return parametros;
    }

    public static boolean copyFilesAndDelete(String pathStart, String nameOfFile) {
        boolean borrado = false;

        String destination = obtenPathDestino(pathStart);
        String pathDestination = String.valueOf(destination) + nameOfFile;
        boolean copy = copyFile(pathStart, pathDestination);
        if (copy) {
            File toDetele = new File(pathStart);
            boolean delete = toDetele.delete();
            if (delete) {
                log.info(" The Backup of teh original file was properly made");
                borrado = true;
            } else {
                log.info(" Error by trying to delete the original file");
            }
        } else {

            log.info("Could not backup original file");
        }
        return borrado;
    }

    public static void deleteFiles(String path) {
        String sourcePath = path;
        File prueba = new File(sourcePath);
        File[] ficheros = prueba.listFiles();
        File f = null;
        if (prueba.exists()) {

            for (int x = 0; x < ficheros.length; x++) {
                f = new File(ficheros[x].toString());
                f.delete();
            }

        } else {

            System.out.println("No existe el directorio");
        }
    }


    public static HashMap<String, DetailInputFile> revisaSiYaestanEnBD(HashMap<String, DetailInputFile> mapAccountToCancel, ArrayList<String> yaFueronCanceladas) {
        HashMap<String, DetailInputFile> mapaYaFiltrado = new HashMap<>();
        mapaYaFiltrado = mapAccountToCancel;
        try {
            for (String string : yaFueronCanceladas) {
                if (mapaYaFiltrado.containsKey(string)) {
                    mapaYaFiltrado.remove(string);
                }
            }

        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

        return mapaYaFiltrado;
    }

    public static boolean isNumeric(Object value) {
        if (value == null) {
            return Boolean.FALSE.booleanValue();
        }
        String strVal = String.valueOf(value);
        byte b;
        int i;
        byte[] arrayOfByte;
        for (i = (arrayOfByte = strVal.getBytes()).length, b = 0; b < i; ) {
            Byte bit = Byte.valueOf(arrayOfByte[b]);
            if (bit.byteValue() < 48 || bit.byteValue() > 57)
                return Boolean.FALSE.booleanValue();
            b = (byte) (b + 1);
        }

        return Boolean.TRUE.booleanValue();
    }

    public static List<DetailInputFileBo> separatesDuplicates(InputFileBo file) {
        List<DetailInputFileBo> filterRecords = new ArrayList<>();
        List<DetailInputFileBo> duplicateRecords = new ArrayList<>();

        int count = 0;
        for (DetailInputFileBo record : file.getRecords()) {
            boolean isDuplicate = Boolean.FALSE.booleanValue();
            for (int i = count + 1; i < file.getRecords().size(); i++) {
                if (((DetailInputFileBo) file.getRecords().get(i)).getCustomerIdentifier().equals(record.getCustomerIdentifier())) {

                    duplicateRecords.add(file.getRecords().get(i));
                    isDuplicate = Boolean.TRUE.booleanValue();
                }
            }
            count++;
            if (!isDuplicate) {
                filterRecords.add(record);
            }
        }
        file.setRecords(filterRecords);
        return duplicateRecords;
    }
}


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyect\\utils\Utils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */