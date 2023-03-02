 package modulo.authentic;


 import modulo.log.Log;
 import modulo.proyecto.utils.Utils;
 import org.apache.log4j.Logger;
 
 public class SendDevolution {
   private Logger log = Log.getLog(getClass());
   private final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
   DTOResponse response = null;
   String queueName = null;
   
   public DTOResponse generateMessage(DTORequest request) throws Exception {
     SocketConnection sc = null;
     try {
       String serviceName = request.getServiceName();
       request.setHeader("OAM010100000");
       request = getProcessingCodeByServiceName(request);
       String ip = Utils.getProperty("switch.ip", "cancelacion.properties");
       int port = Integer.parseInt(Utils.getProperty("switch.port", "cancelacion.properties"));
       int timeout = Integer.parseInt(Utils.getProperty("switch.timeout", "cancelacion.properties"));
       sc = new SocketConnection(ip, port, timeout);
       if (sc.isConnected()) {
         String requestISO = request.getIso();
         this.log.debug("OAM010100000 Request:[" + requestISO.toString() + "]");
         String sHexIsoRequest = stringToHex(requestISO.getBytes());
         byte[] bHexIsoRequest = hexStringToByteArray(sHexIsoRequest);
         boolean messageSent = sc.send(bHexIsoRequest);
         if (messageSent) {
           Thread.sleep(1000L);
           String responseISO = sc.read();
           if (responseISO != null) {
             this.log.debug("OAM Response: [" + responseISO + "]");
             FieldsResponse objResponse = new FieldsResponse();
             this.response = objResponse.getResponse(responseISO, serviceName);
             sc.closeSocket();
           } else {
             this.response.setReturnCode("911");
           } 
         } else {
           this.response.setReturnCode("912");
         }
       
       } else if (this.response == null) {
         this.response = new DTOResponse();
         this.response.setErrorDescription("Switch Timeout ocurred");
         this.response.setReturnCode("909");
       
       }
     
     }
     catch (Exception ex) {
       if (this.response == null) {
         this.response = new DTOResponse();
       }
       if (ex instanceof java.net.SocketTimeoutException || ex instanceof java.net.ConnectException) {
         this.response.setErrorDescription("Switch Timeout ocurred");
       }
       this.response.setReturnCode("909");
     } finally {
       if (sc != null) {
         sc.closeSocket();
       }
     } 
     return this.response;
   }
   
   public byte[] hexStringToByteArray(String s) {
     int len = s.length();
     
     byte[] data = new byte[len / 2];
     for (int i = 0; i < len; i += 2) {
       data[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
     }
     return data;
   }
   
   private String stringToHex(byte[] buf) {
     char[] chars = new char[2 * buf.length];
     for (int i = 0; i < buf.length; i++) {
       chars[2 * i] = this.HEX_CHARS[(buf[i] & 0xF0) >>> 4];
       chars[2 * i + 1] = this.HEX_CHARS[buf[i] & 0xF];
     } 
     return new String(chars);
   }
   
   private DTORequest getProcessingCodeByServiceName(DTORequest request) {
     String str;
     switch ((str = request.getServiceName()).hashCode()) {
       case -1401837287:
         if (str.equals("retireCustomer")) {
           request.setMti("0200");
           request.setProcessingCodeAuthentic("26");
         } 
         break;
       case 744605592:
         if (str.equals("retireCustomer")) {
           request.setMti("0420");
           request.setProcessingCodeAuthentic("02");
         } 
         break;
     } 
     return request;
   }
 }


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\authentic\SendDevolution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */