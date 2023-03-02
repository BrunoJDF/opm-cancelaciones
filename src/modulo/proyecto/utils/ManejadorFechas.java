 package modulo.proyecto.utils;
 //import java.sql.Date;

 import java.text.DateFormat;
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.GregorianCalendar;
 
 public class ManejadorFechas {
   public static String getFechaActual() {
     Date ahora = new Date();
     SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
     return formateador.format(ahora);
   }
   
   public static String getHoraActual() {
     Date ahora = new Date();
     SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
     return formateador.format(ahora);
   }
   
   public static Date sumarFechasDias(Date fch, int dias) {
     Calendar cal = new GregorianCalendar();
     cal.setTimeInMillis(fch.getTime());
     cal.add(5, dias);
     return new Date(cal.getTimeInMillis());
   }
   
   public static synchronized Date restarFechasDias(Date fch, int dias) {
     Calendar cal = new GregorianCalendar();
     cal.setTimeInMillis(fch.getTime());
     cal.add(5, -dias);
     return new Date(cal.getTimeInMillis());
   }
   
   public static synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {
     DateFormat df = DateFormat.getDateInstance(2);
     String fechaInicioString = df.format(fechaInicial);
     
     try {
       fechaInicial = df.parse(fechaInicioString);
     } catch (ParseException parseException) {}
 
 
     
     String fechaFinalString = df.format(fechaFinal);
     
     try {
       fechaFinal = df.parse(fechaFinalString);
     } catch (ParseException parseException) {}
 
 
     
     long fechaInicialMs = fechaInicial.getTime();
     long fechaFinalMs = fechaFinal.getTime();
     long diferencia = fechaFinalMs - fechaInicialMs;
     double dias = Math.floor((diferencia / 86400000L));
     return (int)dias;
   }
   
   public static synchronized Date deStringToDate(String fecha) {
     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
     Date fechaEnviar = null;
     
     try {
       fechaEnviar = formatoDelTexto.parse(fecha);
       return fechaEnviar;
     } catch (ParseException var4) {
       var4.printStackTrace();
       return null;
     } 
   }
 }


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyect\\utils\ManejadorFechas.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */