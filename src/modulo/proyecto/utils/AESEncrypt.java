package modulo.proyecto.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AESEncrypt {
    private static final String ALGORITM = "AES/CBC/PKCS5Padding";
    private static final String UNICODE_FORMAT = "UTF-8";
    private static byte[] iv = new byte[16];

    public static byte[] encryptToByte(String data, String keyValue) {
        byte[] encVal = null;
        if (data != null) {
            try {
                Key key = generateKey(keyValue);
                Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
                IvParameterSpec ivspec = new IvParameterSpec(iv);
                c.init(1, key, ivspec);
                encVal = c.doFinal(data.getBytes("UTF-8"));
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return encVal;
    }

    public static String encryptToString(String data, String keyValue) {
        byte[] encVal = encryptToByte(data, keyValue);
        String encryptedValue = null;


        return encryptedValue;
    }

    public static byte[] decryptToByte(String data, String keyValue) {
        byte[] decValue = null;
        if (data != null) {
            try {
                Key key = generateKey(keyValue);
                Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
                IvParameterSpec ivspec = new IvParameterSpec(iv);
                c.init(2, key, ivspec);
                byte[] decodedValue = Base64.decodeBase64(data);
                decValue = c.doFinal(decodedValue);
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return decValue;
    }

    public static String decryptToString(String data, String keyValue) {
        byte[] decValue = decryptToByte(data, keyValue);
        String decryptedValue = null;
        if (decValue != null) {
            decryptedValue = new String(decValue);
        }
        return decryptedValue;
    }

    private static Key generateKey(String keyText) {
        byte[] keyValue = Arrays.copyOf(keyText.getBytes(), 16);
        Key key = new SecretKeySpec(keyValue, "AES");
        return key;
    }

    private static byte[] fromHexString(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }

        return data;
    }


    public static String decryptBancoppelUrl(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] llaveByte = new byte[16];
        byte[] b = key.getBytes("UTF-8");
        int len = b.length;
        if (len > llaveByte.length) {
            len = llaveByte.length;
        }
        System.arraycopy(b, 0, llaveByte, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(llaveByte, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(llaveByte);
        cipher.init(2, keySpec, ivSpec);
        byte[] resultados = cipher.doFinal(Base64.decodeBase64(data));
        return new String(resultados, "UTF-8");
    }
}


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyect\\utils\AESEncrypt.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */