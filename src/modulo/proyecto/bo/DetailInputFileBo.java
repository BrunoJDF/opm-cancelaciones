 package modulo.proyecto.bo;
 
 public class DetailInputFileBo
 {
   private String identifierType;
   private String customerIdentifier;
   private String processDate;
   private String executiveId;
   private String branchId;
   
   public String getIdentifierType() {
     return this.identifierType;
   }
   public void setIdentifierType(String identifierType) {
     this.identifierType = identifierType;
   }
   public String getCustomerIdentifier() {
     return this.customerIdentifier;
   }
   public void setCustomerIdentifier(String customerIdentifier) {
     this.customerIdentifier = customerIdentifier;
   }
   public String getProcessDate() {
     return this.processDate;
   }
   public void setProcessDate(String processDate) {
     this.processDate = processDate;
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
 
   
   public int hashCode() {
     int prime = 31;
     int result = 1;
     result = 31 * result + ((this.branchId == null) ? 0 : this.branchId.hashCode());
     result = 31 * result + ((this.customerIdentifier == null) ? 0 : this.customerIdentifier.hashCode());
     result = 31 * result + ((this.executiveId == null) ? 0 : this.executiveId.hashCode());
     result = 31 * result + ((this.identifierType == null) ? 0 : this.identifierType.hashCode());
     result = 31 * result + ((this.processDate == null) ? 0 : this.processDate.hashCode());
     return result;
   }
 
   
   public boolean equals(Object obj) {
     if (this == obj)
       return true; 
     if (obj == null)
       return false; 
     if (getClass() != obj.getClass())
       return false; 
     DetailInputFileBo other = (DetailInputFileBo)obj;
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
     }  if (this.executiveId == null) {
       if (other.executiveId != null)
         return false; 
     } else if (!this.executiveId.equals(other.executiveId)) {
       return false;
     }  if (this.identifierType == null) {
       if (other.identifierType != null)
         return false; 
     } else if (!this.identifierType.equals(other.identifierType)) {
       return false;
     }  if (this.processDate == null) {
       if (other.processDate != null)
         return false; 
     } else if (!this.processDate.equals(other.processDate)) {
       return false;
     }  return true;
   }
 }


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyecto\bo\DetailInputFileBo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */