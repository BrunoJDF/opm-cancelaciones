 package modulo.proyecto.bo;
 
 public class DetailInputFile
 {
   private String filePath;
   private String fileName;
   private String idBanco;
   private int numeroRegistrosXArchivo;
   private int identifierType;
   private String customerIdentifier;
   private String executiveId;
   private String branchId;
   private int fecha;
   
   public String getIdBanco() {
     return this.idBanco;
   }
   
   public void setIdBanco(String idBanco) {
     this.idBanco = idBanco;
   }
   public int getNumeroRegistrosXArchivo() {
     return this.numeroRegistrosXArchivo;
   }
   public void setNumeroRegistrosXArchivo(int numeroRegistrosXArchivo) {
     this.numeroRegistrosXArchivo = numeroRegistrosXArchivo;
   }
   public int getIdentifierType() {
     return this.identifierType;
   }
   public void setIdentifierType(int identifierType) {
     this.identifierType = identifierType;
   }
   public String getCustomerIdentifier() {
     return this.customerIdentifier;
   }
   public void setCustomerIdentifier(String customerIdentifier) {
     this.customerIdentifier = customerIdentifier;
   }
   public String getExecutiveId() {
     return this.executiveId;
   }
   public void setExecutiveId(String executiveId) {
     this.executiveId = executiveId;
   }
   public String getBranchId() {
     return this.branchId;
   }
   public void setBranchId(String branchId) {
     this.branchId = branchId;
   }
   public int getFecha() {
     return this.fecha;
   }
   public void setFecha(int fecha) {
     this.fecha = fecha;
   }
 
   
   public String toString() {
     return "DetallaArchivoRecibido [idBanco=" + this.idBanco + ", numeroRegistrosXArchivo=" + this.numeroRegistrosXArchivo + ", identifierType=" + this.identifierType + ", customerIdentifier=" + this.customerIdentifier + ", executiveIde=" + this.executiveId + ", branchId=" + this.branchId + ", fecha=" + this.fecha + "]";
   }
 
 
 
 
 
 
   
   public int hashCode() {
     int prime = 31;
     int result = 1;
     result = 31 * result + ((this.branchId == null) ? 0 : this.branchId.hashCode());
     
     result = 31 * result + ((this.customerIdentifier == null) ? 0 : this.customerIdentifier.hashCode());
 
 
     
     result = 31 * result + ((this.executiveId == null) ? 0 : this.executiveId.hashCode());
     result = 31 * result + this.fecha;
     result = 31 * result + ((this.idBanco == null) ? 0 : this.idBanco.hashCode());
     result = 31 * result + this.identifierType;
     result = 31 * result + this.numeroRegistrosXArchivo;
     return result;
   }
 
   
   public boolean equals(Object obj) {
     if (this == obj)
       return true; 
     if (obj == null)
       return false; 
     if (getClass() != obj.getClass())
       return false; 
     DetailInputFile other = (DetailInputFile)obj;
     if (this.branchId == null) {
       if (other.branchId != null)
         return false; 
     } else if (!this.branchId.equals(other.branchId)) {
       return false;
     }  if (this.customerIdentifier == null) {
       if (other.customerIdentifier != null)
         return false; 
     } else if (!this.customerIdentifier.equals(other.customerIdentifier)) {
       return false;
     }  if (this.executiveId != other.executiveId)
       return false; 
     if (this.fecha != other.fecha)
       return false; 
     if (this.idBanco == null) {
       if (other.idBanco != null)
         return false; 
     } else if (!this.idBanco.equals(other.idBanco)) {
       return false;
     }  if (this.identifierType != other.identifierType)
       return false; 
     if (this.numeroRegistrosXArchivo != other.numeroRegistrosXArchivo)
       return false; 
     return true;
   }
   
   public String getFileName() {
     return this.fileName;
   }
   
   public void setFileName(String fileName) {
     this.fileName = fileName;
   }
   
   public String getFilePath() {
     return this.filePath;
   }
   
   public void setFilePath(String filePath) {
     this.filePath = filePath;
   }
 }


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyecto\bo\DetailInputFile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */