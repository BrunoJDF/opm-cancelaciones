package modulo.cancelacion;


import modulo.exception.FileValidationException;
import modulo.log.Log;
import modulo.proyecto.bo.DetailInputFileBo;
import modulo.proyecto.bo.DetailReturn;
import modulo.proyecto.bo.InputFileBo;
import modulo.proyecto.dao.CancellationsDao;
import modulo.proyecto.negocio.CancellationsBusiness;
import modulo.proyecto.utils.ReadFile;
import modulo.proyecto.utils.SearchFile;
import modulo.proyecto.utils.Utils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class CancellationProcess {
    static Logger log = Log.getLog(CancellationProcess.class);


    public static void main(String[] args) throws IOException {
        BasicConfigurator.configure();

        CancellationsBusiness cn = null;
        CancellationsDao cancellation = new CancellationsDao();
        log.info("Starts the process of massive cancellations Search the input file");
        SearchFile searchFile = new SearchFile();
        List<InputFileBo> files = searchFile.searchValidFiles();
        log.info("[" + files.size() + "] files will be processed");
        for (InputFileBo file : files) {
            try {
                cn = new CancellationsBusiness();
                log.debug("File to process: " + file.getFileName());
                if (ReadFile.readAndValidateFile(file)) {
                    log.info("Searching for duplicate ");
                    List<DetailInputFileBo> duplicates = Utils.separatesDuplicates(file);
                    log.info("The file has [" + duplicates.size() + "] duplicate records ");
                    log.info("Cleaning temportal table--->" + cancellation.deleteDetailTableBD());
                    if (cancellation.insertDetailCancellations(file)) {
                        Utils.copyFilesAndDelete(file.getFilePath(), file.getFileName());
                        HashMap<String, DetailReturn> yaFueronCanceladas = cn.getTransactionsAlreadyCanceled();
                        log.debug("Transactions already cancelled: " + yaFueronCanceladas.size());
                        log.debug("Information is prepared to send to the service");
                        List<DetailReturn> returns = cn.generatesCancellations(file); // verificar bien
                        returns = cn.insertaHistoricoYBorra(returns, yaFueronCanceladas);
                        List<DetailReturn> convertedDuplicates = cn.convertDuplicate(duplicates);

                        returns.addAll(convertedDuplicates);
                        cn.creaDocumentoSalida(returns, file.getBankId(), file.getFileName());
                        log.debug("Finished the process, Was created output document");
                        continue;
                    }
                    log.info("Error inserting  in the dataBase");
                }

            } catch (FileValidationException e) {
                log.error(e.getMessage());
                if (cn != null)
                    cn.creaDocumentoSalidaErr(e.getMessage(), e.getInputFile());
            }
        }
    }
}


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\cancelacion\CancellationProcess.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */