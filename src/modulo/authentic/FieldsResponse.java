package modulo.authentic;

import modulo.log.Log;
import org.apache.log4j.Logger;

import java.math.BigInteger;


public class FieldsResponse {
    int indice = 16;
    private Logger log = Log.getLog(getClass());

    public DTOResponse getResponse(String responseMsg, String serviceName) throws Exception {
        DTOResponse response = new DTOResponse();
        String bitmap = HexToBin(responseMsg.substring(this.indice, this.indice + 16), 16);
        this.indice += 16;
        if (bitmap.charAt(0) == '1') {

            bitmap = String.valueOf(bitmap) + HexToBin(responseMsg.substring(this.indice, this.indice + 16), 16);
            this.indice += 16;
        }
        InterfaceFieldSet interfaceFieldSet = new InterfaceFieldSet(this.indice, responseMsg);
        for (int i = 1; i < bitmap.length(); i++) {

            if (bitmap.charAt(i) == '1') {
                interfaceFieldSet.getField(String.valueOf(i + 1));
            }
        }
        response = interfaceFieldSet.getObject();
        String service;
        boolean isEquals;
        switch ((service = serviceName).hashCode()) {

            case -1998865772:
                isEquals = service.equals("getCustomerHomonymy");
                break;
            case 308247035:
                isEquals = service.equals("paymentOfServices");
                break;
            case 561993282:
                isEquals = service.equals("transferCustomerValidation");
                break;
            case 757288185:
                isEquals = service.equals("getCEPSpei");
                break;
            case 1472814925:
                if (service.equals("getUdiValue")) {
                    isEquals = true;
                    break;
                }
            case 2065780642:
                isEquals = service.equals("completeCashOut");
                break;
            default:
                isEquals = false;
        }
        log.info("Codigo" + isEquals);

        if (response.getReturnCode() == null && response.getError() == null && response.getCodigoError() == null) {
            throw new Exception("Empty returnCode");
        }
        return response;
    }


    public String validateResponse(String cadena) {
        if (cadena.equals("")) {
            return null;
        }
        return cadena;
    }


    public String HexToBin(String input, int hexa) {
        String binSec = (new BigInteger(input, 16)).toString(2);
        int agregados = hexa * 4 - binSec.length();
        for (int i = 0; i < agregados; i++) {
            binSec = "0" + binSec;
        }
        return binSec;
    }
}


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\authentic\FieldsResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */