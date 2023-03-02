 package modulo.proyecto.utils;

 import javax.crypto.Cipher;
 import javax.crypto.spec.SecretKeySpec;
 import java.math.BigInteger;
 
 
 public class Encryption
 {
   private final int KEY_LENGTH = 7;
   private final int KEY_POSITION = 4;
   
   public String encrypt(String rawString) {
     String key = generateKey();
     String cipher;
     for (cipher = blowfishEncode(rawString, key); cipher.charAt(0) == '-' || cipher.length() < 4; 
       cipher = blowfishEncode(rawString, key))
     {
       key = generateKey();
     }
     return String.valueOf(cipher.substring(0, 4)) + key + cipher.substring(4, cipher.length());
   }
 
   
//   public static void main(String[] arg) {
//     Encryption en = new Encryption();
//     System.out.println(en.encrypt("543211"));
//   }
 
 
 
   
   public String decrypt(String cipherString) {
     String k = getKey(cipherString);
     if (k == " ") {
       return "invalid";
     }
     String cipher = getCipherFromCipherString(cipherString);
     return blowfishDecode(cipher, k);
   }
   
   private String generateKey() {
     StringBuffer key = new StringBuffer("");
     for (int i = 0; i < 7; i++) {
       String k = getRandomHexDigit();
       key.append(k);
     } 
     return key.toString();
   }
   
   private String getRandomHexDigit() {
     double d = Math.random();
     d *= 16.0D;
     int j = (int)d;
     return Integer.toHexString(j);
   }
   
   private String getCipherFromCipherString(String cipherString) {
     if (cipherString.length() < 11) {
       System.out.println("Invalid cipher string - check it was produced with the correct algorithm");
       
       return cipherString;
     } 
     String p1 = cipherString.substring(0, 4);
     String p2 = cipherString.substring(11, cipherString.length());
     return String.valueOf(p1) + p2;
   }
   
   private String getKey(String cipherString) {
     if (cipherString.length() < 11) {
       System.out.println("Invalid cipher string - check it was produced with the correct algorithm");
       
       return " ";
     } 
     String k = cipherString.substring(4, 11);
     return k;
   }
   
   private static String blowfishEncode(String secret, String k) {
     try {
       byte[] kbytes = k.getBytes();
       SecretKeySpec key = new SecretKeySpec(kbytes, "Blowfish");
       Cipher cipher = Cipher.getInstance("Blowfish");
       cipher.init(1, key);
       byte[] encoding = cipher.doFinal(secret.getBytes());
       BigInteger n = new BigInteger(encoding);
       return n.toString(16);
     } catch (Exception e) {
       System.out.println("Error decoding blowfish encryption string: " + e.getMessage());
 
       
       return "";
     } 
   }
   private String blowfishDecode(String secret, String k) {
     byte[] kbytes = k.getBytes();
     SecretKeySpec key = new SecretKeySpec(kbytes, "Blowfish");
     BigInteger n = new BigInteger(secret, 16);
     byte[] encoding = n.toByteArray();
     try {
       Cipher cipher = Cipher.getInstance("Blowfish");
       cipher.init(2, key);
       byte[] decode = cipher.doFinal(encoding);
       return new String(decode);
     } catch (Exception e) {
       System.out.println("NumberFormatException decoding blowfish encryption string\nPossibly invalid cipher: " + secret + " or key: " + k);
 
       
       System.out.println("Error decoding blowfish encryption string: " + e.getMessage());
 
       
       return "";
     } 
   }
   public static String decryptAccountNumber(String poAccountNumber, String poCustomerN) {
     String accountNumber = "";
     try {
       String key = "tr4n$f3r";
       accountNumber = AESEncrypt.decryptToString(poAccountNumber, String.valueOf(poCustomerN) + key);
     } catch (Exception ex) {
       accountNumber = "";
     } 
     return accountNumber;
   }
 }


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyect\\utils\Encryption.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */