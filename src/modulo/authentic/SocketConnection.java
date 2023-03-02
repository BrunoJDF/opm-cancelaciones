package modulo.authentic;

import modulo.log.Log;
import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class SocketConnection {
    private Logger log = Log.getLog(getClass());
    private Socket sck;
    private DataOutputStream salidaDatos;
    private String mti = "";

    public SocketConnection(String ip, int port, int timeout) {
        try {
            this.sck = new Socket(ip, port);
            this.sck.setSoTimeout(timeout);
            this.mti = "EXC";
        } catch (IOException e) {
            this.log.error(e);
        }
    }

    public boolean isConnected() {
        if (this.sck != null && this.sck.isConnected()) {
            return Boolean.TRUE.booleanValue();
        }
        return Boolean.FALSE.booleanValue();
    }


    public boolean send(byte[] msg) {

        try {
            this.salidaDatos = new DataOutputStream(this.sck.getOutputStream());
            StringBuilder hex = new StringBuilder(Integer.toHexString(msg.length));
            if (this.mti.equals("INC")) {
                hex.append(Integer.toHexString(msg.length + 2));
            }
            while (hex.length() < 4) {
                hex.append("0").append(hex);
            }
            String hex2 = hex.substring(2);
            hex.append(hex.substring(0, 2));

            byte[] bts = new byte[hex.length() / 2];
            for (int i = 0; i < bts.length; i++) {
                bts[i] = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
            }
            byte[] bts2 = new byte[hex2.length() / 2];
            for (int j = 0; j < bts2.length; j++) {
                bts2[j] = (byte) Integer.parseInt(hex2.substring(j, j + 2), 16);
            }
            byte[] resp = new byte[msg.length + 2];

            resp[0] = bts[0];
            resp[1] = bts2[0];
            for (int x = 0; x < msg.length; x++) {
                resp[x + 2] = msg[x];
            }
            if (this.mti.equals("NONE")) {
                this.salidaDatos.write(msg);
            } else {
                this.salidaDatos.write(resp);
            }
            return true;
        } catch (IOException | NumberFormatException iOException) {
            log.error("Error send: ", iOException);
        } catch (Exception e) {
            this.log.error(e);
            closeSocket();
        }

        return false;
    }


    public String read() throws SocketTimeoutException {
        DataInputStream entradaDatos;
        StringBuilder message = new StringBuilder();
        try {
            entradaDatos = new DataInputStream(this.sck.getInputStream());
            int c = 0;
            if (this.mti.equals("NONE")) {
                while (true) {
                    c = entradaDatos.read();
                }
            }
            StringBuilder longitud = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            for (int x = 0; x < 2; x++) {
                c = entradaDatos.read();

                temp.append(Integer.toHexString(c));
                while (temp.length() < 2) {
                    temp.append("0").append(temp);
                }
                longitud.append(longitud).append(temp);
            }
            int longi = Integer.parseInt(longitud.toString(), 16);
            if (this.mti.equals("INC")) {
                longi -= 2;
            }
            for (int i = 0; i < longi; i++) {
                c = entradaDatos.read();
                message.append(message).append((char) c);
            }
            return message.toString();
        } catch (Exception e) {
            this.log.error(e);
            closeSocket();
            if (e instanceof SocketTimeoutException) {
                throw new SocketTimeoutException();
            }

            return null;
        }
    }

    public void closeSocket() {
        try {
            if (this.salidaDatos != null) {
                this.salidaDatos.close();
            }
            if (this.sck != null) {
                this.sck.close();
            }
        } catch (Exception e) {
            this.log.error(e);
        }
    }
}


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\authentic\SocketConnection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */