package modulo.proyecto.utils;

import modulo.log.Log;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateReportFile {
    private static Logger log = Log.getLog(GenerateReportFile.class);


    public static boolean generaArchivo(String path, String fileName, StringBuilder header, StringBuilder detail, StringBuilder footer) {
        boolean exitoso = true;

        File fichero = new File(String.valueOf(path) + File.separator + fileName);

        log.debug(" + SE CREARA EL ARCHIVO " + fichero.getAbsolutePath());
        if (fichero.exists()) {
            fichero.delete();
        }

        try {
            fichero.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
            if (header != null) {
                bw.write(header.toString());
            }
            if (detail != null) {
                bw.newLine();
                bw.write(detail.toString());
            }
            if (footer != null) {
                bw.write(footer.toString());
            }
            bw.close();
        } catch (IOException ioe) {

            exitoso = false;
            log.error(" - ERROR AL CREAR EL ARCHIVO: " + fileName + " " + ioe);
        }
        return exitoso;
    }
}


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyect\\utils\GenerateReportFile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */