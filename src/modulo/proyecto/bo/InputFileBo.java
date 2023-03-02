 package modulo.proyecto.bo;
 
 import java.util.List;
 
 
 public class InputFileBo
 {
   private String filePath;
   private String fileName;
   private String bankId;
   private int recordsNumber;
   private List<DetailInputFileBo> records;
   
   public InputFileBo() {}
   
   public InputFileBo(String filePath, String fileName) {
     this.filePath = filePath;
     this.fileName = fileName;
   }
   
   public String getBankId() {
     return this.bankId;
   }
   public void setBankId(String bankId) {
     this.bankId = bankId;
   }
   public int getRecordsNumber() {
     return this.recordsNumber;
   }
   public void setRecordsNumber(int recordsNumber) {
     this.recordsNumber = recordsNumber;
   }
   public List<DetailInputFileBo> getRecords() {
     return this.records;
   }
   public void setRecords(List<DetailInputFileBo> records) {
     this.records = records;
   }
   public String getFilePath() {
     return this.filePath;
   }
   public void setFilePath(String filePath) {
     this.filePath = filePath;
   }
   public String getFileName() {
     return this.fileName;
   }
   public void setFileName(String fileName) {
     this.fileName = fileName;
   }
 
   
   public int hashCode() {
     int prime = 31;
     int result = 1;
     result = 31 * result + ((this.bankId == null) ? 0 : this.bankId.hashCode());
     result = 31 * result + ((this.fileName == null) ? 0 : this.fileName.hashCode());
     result = 31 * result + ((this.filePath == null) ? 0 : this.filePath.hashCode());
     result = 31 * result + ((this.records == null) ? 0 : this.records.hashCode());
     result = 31 * result + this.recordsNumber;
     return result;
   }
 
   
   public boolean equals(Object obj) {
     if (this == obj)
       return true; 
     if (obj == null)
       return false; 
     if (getClass() != obj.getClass())
       return false; 
     InputFileBo other = (InputFileBo)obj;
     if (this.bankId == null) {
       if (other.bankId != null)
         return false; 
     } else if (!this.bankId.equals(other.bankId)) {
       return false;
     }  if (this.fileName == null) {
       if (other.fileName != null)
         return false; 
     } else if (!this.fileName.equals(other.fileName)) {
       return false;
     }  if (this.filePath == null) {
       if (other.filePath != null)
         return false; 
     } else if (!this.filePath.equals(other.filePath)) {
       return false;
     }  if (this.records == null) {
       if (other.records != null)
         return false; 
     } else if (!this.records.equals(other.records)) {
       return false;
     }  if (this.recordsNumber != other.recordsNumber)
       return false; 
     return true;
   }
 }


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyecto\bo\InputFileBo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */