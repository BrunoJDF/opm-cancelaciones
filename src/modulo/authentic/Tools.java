 package modulo.authentic;

 import java.util.Map;
 import java.util.TreeMap;
 
 
 public class Tools
 {
   public String[] getArrayBitmAP(int tam) {
     String[] bitmap = new String[tam];
     for (int con = 0; con < tam; con++) {
       bitmap[con] = "0";
     }
     return bitmap;
   }
 
   
   public String[] getArrayBitmAPFiled() {
     String[] bitmap = new String[32];
     for (int con = 0; con < 32; con++) {
       bitmap[con] = "0";
     }
     return bitmap;
   }
 
   
   public String getBitmapFields(String[] arreglo) {
     String bitmap = "";
     for (int con = 0; con < arreglo.length; con++) {
       bitmap = String.valueOf(bitmap) + arreglo[con];
     }
     return bitmap;
   }
 
   
   public String[] getArrayFields(int tamano) {
     String[] bitmap = new String[tamano];
     for (int con = 0; con < tamano; con++) {
       bitmap[con] = "";
     }
     return bitmap;
   }
 
   
   public Map<Integer, String> putValue(Map<Integer, String> map, String value, int position) {
     if (map == null) {
       
       map = new TreeMap<>();
       map.put(Integer.valueOf(position), value);
       return map;
     } 
     map.put(Integer.valueOf(position), value);
     
     return map;
   }
 
   
   public String convertBinaryToHexa(String bitmMap) {
     StringBuffer numHexadecima = new StringBuffer();
     
     String cadenaHexa = "";
     int cont = 0;
     for (int j = 0; j < bitmMap.length() / 4; j++) {
       
       StringBuffer digitos = new StringBuffer();
       for (int i = 0; i < 4; i++) {
         
         digitos.append(bitmMap.charAt(cont));
         cont++;
       } 
       cadenaHexa = convertHexadecimal(digitos.toString());
       numHexadecima.append(cadenaHexa);
     } 
     return numHexadecima.toString();
   }
 
   
   public String convertHexadecimal(String hex) {
     Long num = Long.valueOf(Long.parseLong(hex));
     while (num.longValue() > 0L) {
       
       Long rem = Long.valueOf(num.longValue() % 10L);
       num = Long.valueOf(num.longValue() / 10L);
       if (rem.longValue() != 0L && rem.longValue() != 1L) {
         System.exit(0);
       }
     } 
     int i = Integer.parseInt(hex, 2);
     String hexString = Integer.toHexString(i);
     return hexString;
   }
 
   
   public String getDateFromArray(String[] array) {
     String cadena = ""; byte b; int i; String[] arrayOfString;
     for (i = (arrayOfString = array).length, b = 0; b < i; ) { String var = arrayOfString[b];
       cadena = String.valueOf(cadena) + var + "|"; b = (byte)(b + 1); }
     
     return cadena;
   }
 
   
   public String arrayToString(String[] stringarray) {
     String str = "";
     for (int i = 0; i < stringarray.length; i++) {
       str = String.valueOf(str) + stringarray[i];
     }
     return str;
   }
 }


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\authentic\Tools.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */