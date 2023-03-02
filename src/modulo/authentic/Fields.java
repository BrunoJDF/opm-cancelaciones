 package modulo.authentic;
 
 
 public class Fields
 {
   private String format;
   private String name;
   private String lenght;
   private String type;
   
   public Fields(String format, String name, String lenght, String type) {
     this.format = format;
     this.name = name;
     this.lenght = lenght;
     this.type = type;
   }
 
   
   public String getFormat() {
     return this.format;
   }
 
   
   public String getLenght() {
     return this.lenght;
   }
 
   
   public String getName() {
     return this.name;
   }
 
   
   public String getType() {
     return this.type;
   }
 }


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\authentic\Fields.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */