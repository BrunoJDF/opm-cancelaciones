 package modulo.log;

 import org.apache.log4j.Logger;
 import org.apache.log4j.MDC;
 
 
 public class Log
 {
   public static Logger getLog(Class<?> className) {
     MDC.put("trdId", Long.valueOf(Thread.currentThread().getId()));
     return Logger.getLogger(className);
   }
 }


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\log\Log.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */