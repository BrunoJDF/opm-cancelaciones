 package modulo.proyecto.bo;
 
 public class BeanArchivoEntrada
 {
   private String nombreArchivo;
   private int fecha_procesado;
   private int status;
   
   public String getNombreArchivo() {
     return this.nombreArchivo;
   }
   public void setNombreArchivo(String nombreArchivo) {
     this.nombreArchivo = nombreArchivo;
   }
   public int getFecha_procesado() {
     return this.fecha_procesado;
   }
   public void setFecha_procesado(int fecha_procesado) {
     this.fecha_procesado = fecha_procesado;
   }
   public int getStatus() {
     return this.status;
   }
   public void setStatus(int status) {
     this.status = status;
   }
 }


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyecto\bo\BeanArchivoEntrada.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */