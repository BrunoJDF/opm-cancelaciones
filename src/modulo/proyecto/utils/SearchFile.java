package modulo.proyecto.utils;


import modulo.proyecto.bo.InputFileBo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFile {
    private static final String BANAMEX_PATH = "/reports/input_files/MCM/Banamex";
    private static final String INBUSRSA_PATH = "/reports/input_files/MCM/Inbursa";
    String pathBanamex;
    String path;
    File file = null;

    public List<InputFileBo> searchValidFiles() {
        List<InputFileBo> files = new ArrayList<>();
        String userHome = regresaPathPropertie();
        StringBuilder fullPath = (new StringBuilder(userHome)).append("/reports/input_files/MCM/Banamex");


        if (saberSiElFicheronEstaVacio(fullPath.toString())) {
            List<InputFileBo> inbursaFiles = getFileValidNames(fullPath.toString());

            for (int i = 0; i < inbursaFiles.size(); i++) {
                ((InputFileBo) inbursaFiles.get(i)).setBankId("002");
            }

            files.addAll(inbursaFiles);
        }

        if (files.isEmpty()) {
            fullPath = (new StringBuilder(userHome)).append("/reports/input_files/MCM/Inbursa");
            if (saberSiElFicheronEstaVacio(fullPath.toString())) {
                List<InputFileBo> inbursaFiles = getFileValidNames(fullPath.toString());

                for (int i = 0; i < inbursaFiles.size(); i++) {
                    ((InputFileBo) inbursaFiles.get(i)).setBankId("036");
                }

                files.addAll(inbursaFiles);
            }
        }

        return files;
    }

    public boolean saberSiElFicheronEstaVacio(String path) {
        boolean resultado = false;
        File directorio = new File(path);
        File[] lista = directorio.listFiles();
        if (lista != null) {
            File[] var8 = lista;
            int var7 = lista.length;

            for (int var6 = 0; var6 < var7; var6++) {
                File file = var8[var6];
                if (file.isFile()) {
                    resultado = true;
                }
            }
        }

        return resultado;
    }

    public List<InputFileBo> getFileValidNames(String rutaCarpeta) {
        List<InputFileBo> listFiles = new ArrayList<>();
        File carpeta = new File(rutaCarpeta);
        File[] var7;
        int var6 = (var7 = carpeta.listFiles()).length;

        for (int var5 = 0; var5 < var6; var5++) {
            File archivo = var7[var5];
            if ((archivo.getName().startsWith("BMXCANCEL_") || archivo.getName().startsWith("INBCANCEL_") || archivo.getName().startsWith("BCPCANCEL_")) && archivo.getName().length() == 25) {
                listFiles.add(new InputFileBo(archivo.getAbsolutePath(), archivo.getName()));
            }
        }

        return listFiles;
    }

    public String regresaPathPropertie() {
        return System.getProperty("user.home");
    }
}


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyect\\utils\SearchFile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */