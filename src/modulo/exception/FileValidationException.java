package modulo.exception;

import modulo.proyecto.bo.InputFileBo;

public class FileValidationException
        extends Exception {
    private static final long serialVersionUID = 1L;
    private InputFileBo inputFile;
    private String errorCode;

    public FileValidationException() {
    }

    public FileValidationException(String message) {
        super(message);
    }

    public FileValidationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public FileValidationException(String message, InputFileBo inputFile) {
        super(message);
        this.inputFile = inputFile;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public InputFileBo getInputFile() {
        return this.inputFile;
    }

    public void setInputFile(InputFileBo inputFile) {
        this.inputFile = inputFile;
    }
}


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\exception\FileValidationException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */