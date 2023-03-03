package modulo.authentic;

import modulo.log.Log;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.HashMap;


public class InterfaceFieldSet {
    private Logger log = Log.getLog(getClass());

    public HashMap<String, Fields> interfaceFieldSet = new HashMap<>();
    DTOResponse response = new DTOResponse();
    int index = 0;
    String message = "";
    String field = "";


    public InterfaceFieldSet(int pIndex, String pMessage) {
        this.index = pIndex;
        this.message = pMessage;
        initialize();
    }


    public void getField(String pPosition) {
        String format = ((Fields) this.interfaceFieldSet.get(pPosition)).getFormat();
        String name = ((Fields) this.interfaceFieldSet.get(pPosition)).getName();
        String type = ((Fields) this.interfaceFieldSet.get(pPosition)).getType();
        int lenght = 0;
        String str1;
        switch ((str1 = format).hashCode()) {
            case 66:
                if (!str1.equals("B")) {
                    break;
                }


                lenght = Integer.parseInt(((Fields) this.interfaceFieldSet.get(pPosition)).getLenght());
                generateResponseBitamp(pPosition, lenght);
                return;
            case 70:
                if (!str1.equals("F"))
                    break;
                lenght = Integer.parseInt(((Fields) this.interfaceFieldSet.get(pPosition)).getLenght());
                generateResponseFixed(lenght, name, type);
                return;
        }
        generateResponseLVars(format.length(), name);
    }


    public void initialize() {
        this.interfaceFieldSet.put("2", new Fields("L", "transactionType", null, null));
        this.interfaceFieldSet.put("3", new Fields("F", "processingCode", "6", null));
        this.interfaceFieldSet.put("4", new Fields("F", "amount", "12", "D"));
        this.interfaceFieldSet.put("5", new Fields("F", "additionalAmount", "12", "D"));
        this.interfaceFieldSet.put("6", new Fields("F", "additionalAmountType", "2", null));
        this.interfaceFieldSet.put("7", new Fields("F", "transactionDateAndTime", "10", null));
        this.interfaceFieldSet.put("9", new Fields("LL", "serviceName", null, null));
        this.interfaceFieldSet.put("10", new Fields("LL", "serviceNameFlow", null, null));
        this.interfaceFieldSet.put("11", new Fields("LL", "auditNumber", null, null));
        this.interfaceFieldSet.put("12", new Fields("F", "localTransactionTime", "6", null));
        this.interfaceFieldSet.put("13", new Fields("F", "localTransactionDate", "4", null));
        this.interfaceFieldSet.put("14", new Fields("F", "expirationDate", "15", null));
        this.interfaceFieldSet.put("15", new Fields("F", "settlementDate", "15", null));
        this.interfaceFieldSet.put("16", new Fields("F", "systemDate", "15", null));
        this.interfaceFieldSet.put("19", new Fields("F", "countryCode", "3", null));
        this.interfaceFieldSet.put("26", new Fields("F", "accessMethod", "3", null));
        this.interfaceFieldSet.put("27", new Fields("F", "validatedReturnCode", "4", null));
        this.interfaceFieldSet.put("31", new Fields("F", "bankId", "3", null));
        this.interfaceFieldSet.put("32", new Fields("F", "sourceBankId", "3", null));
        this.interfaceFieldSet.put("33", new Fields("F", "destBankId", "3", null));
        this.interfaceFieldSet.put("39", new Fields("F", "returnCode", "4", "I"));
        this.interfaceFieldSet.put("40", new Fields("LLL", "errorDescription", null, null));
        this.interfaceFieldSet.put("41", new Fields("LL", "physicalBoxId", null, null));
        this.interfaceFieldSet.put("42", new Fields("LL", "branchId", null, null));
        this.interfaceFieldSet.put("43", new Fields("LL", "posId", null, null));
        this.interfaceFieldSet.put("45", new Fields("LL", "merchantId", null, null));
        this.interfaceFieldSet.put("46", new Fields("LL", "merchantName", null, null));
        this.interfaceFieldSet.put("49", new Fields("F", "currency", "3", null));
        this.interfaceFieldSet.put("52", new Fields("LL", "pin", null, null));
        this.interfaceFieldSet.put("66", new Fields("LL", "originatorTransactionId", null, null));
        this.interfaceFieldSet.put("67", new Fields("LL", "originalOriginatorTransactionId", null, null));
        this.interfaceFieldSet.put("68", new Fields("LL", "originalAuditNumber", null, null));
        this.interfaceFieldSet.put("71", new Fields("F", "mpsTransactionId", "12", null));
        this.interfaceFieldSet.put("72", new Fields("F", "originalMpsTransactionId", "12", null));
        this.interfaceFieldSet.put("83", new Fields("F", "destFeeAmount", "12", "D"));
        this.interfaceFieldSet.put("85", new Fields("F", "sourceFeeAmount", "12", "D"));
        this.interfaceFieldSet.put("98", new Fields("F", "commissionPayer", "1", null));
        this.interfaceFieldSet.put("102", new Fields("LL", "sourceAccountId", null, null));
        this.interfaceFieldSet.put("103", new Fields("LL", "destAccountId", null, null));
        this.interfaceFieldSet.put("104", new Fields("F", "sourceAccountIdType", "3", null));
        this.interfaceFieldSet.put("105", new Fields("F", "destAccountIdType", "3", null));
        this.interfaceFieldSet.put("105", new Fields("F", "destAccountIdType", "3", null));
        this.interfaceFieldSet.put("106", new Fields("B", "additionalTransactionData", "4", null));
        this.interfaceFieldSet.put("106-2", new Fields("F", "authorizedPush", "1", null));
        this.interfaceFieldSet.put("106-3", new Fields("F", "transactionConcept", "3", null));
        this.interfaceFieldSet.put("106-4", new Fields("F", "validateUpdateSrcLimits", "1", null));
        this.interfaceFieldSet.put("106-5", new Fields("F", "validateUpdateDstLimits", "1", null));
        this.interfaceFieldSet.put("106-6", new Fields("F", "status", "1", null));
        this.interfaceFieldSet.put("106-7", new Fields("F", "algorithm", "1", null));
        this.interfaceFieldSet.put("106-8", new Fields("LL", "speiCode", null, null));
        this.interfaceFieldSet.put("107", new Fields("B", "responseData", "4", null));
        this.interfaceFieldSet.put("107-2", new Fields("F", "errorContext", "1", null));
        this.interfaceFieldSet.put("107-3", new Fields("F", "folio", "12", null));
        this.interfaceFieldSet.put("107-4", new Fields("L", "authentificationResponse", "6", null));
        this.interfaceFieldSet.put("107-5", new Fields("LL", "externalTransactionId", "1", null));
        this.interfaceFieldSet.put("107-6", new Fields("F", "asociar", "1", null));
        this.interfaceFieldSet.put("107-7", new Fields("F", "createsAnonymous", "1", null));
        this.interfaceFieldSet.put("107-8", new Fields("LLL", "urlPdf", null, null));
        this.interfaceFieldSet.put("107-9", new Fields("LLL", "urlXml", null, null));
        this.interfaceFieldSet.put("108", new Fields("B", "pinData", "4", null));
        this.interfaceFieldSet.put("108-2", new Fields("LL", "confirmPin", null, null));
        this.interfaceFieldSet.put("108-3", new Fields("LL", "newPin", null, null));
        this.interfaceFieldSet.put("108-4", new Fields("F", "isPinLocked", "1", null));
        this.interfaceFieldSet.put("108-5", new Fields("F", "pinLockReason", "2", null));
        this.interfaceFieldSet.put("108-6", new Fields("F", "pinIndicator", "1", null));
        this.interfaceFieldSet.put("109", new Fields("B", "externalSystemData", "4", null));
        this.interfaceFieldSet.put("109-2", new Fields("LL", "executiveId", null, null));
        this.interfaceFieldSet.put("109-3", new Fields("LL", "corresponsalId", null, null));
        this.interfaceFieldSet.put("109-4", new Fields("LL", "storeReference", null, null));
        this.interfaceFieldSet.put("109-5", new Fields("LL", "physicalBoxIdNameLoc", null, null));
        this.interfaceFieldSet.put("109-6", new Fields("L", "numericReference", null, null));
        this.interfaceFieldSet.put("109-7", new Fields("LL", "alphanumericReference", null, null));
        this.interfaceFieldSet.put("109-8", new Fields("LL", "latitude", null, null));
        this.interfaceFieldSet.put("109-9", new Fields("LL", "longitude", null, null));
        this.interfaceFieldSet.put("110", new Fields("B", "amountData", "4", null));
        this.interfaceFieldSet.put("110-2", new Fields("F", "amountSignedType", "1", null));
        this.interfaceFieldSet.put("110-3", new Fields("F", "amountThreshold", "12", "D"));
        this.interfaceFieldSet.put("110-4", new Fields("F", "minAmount", "12", "D"));
        this.interfaceFieldSet.put("110-5", new Fields("F", "pendingTaxAmount", "12", "D"));
        this.interfaceFieldSet.put("110-6", new Fields("F", "amountRequired", "12", "D"));
        this.interfaceFieldSet.put("110-7", new Fields("F", "estimatedAmount", "12", "D"));
        this.interfaceFieldSet.put("111", new Fields("B", "additionalSourceAccountData", "4", null));
        this.interfaceFieldSet.put("111-2", new Fields("LL", "sourceRfc", null, null));
        this.interfaceFieldSet.put("111-3", new Fields("F", "sourceMsisdn", "12", null));
        this.interfaceFieldSet.put("111-4", new Fields("LLL", "sourceEmail", null, null));
        this.interfaceFieldSet.put("111-5", new Fields("F", "sourceBalance", "12", "D"));
        this.interfaceFieldSet.put("111-6", new Fields("F", "sourceAvailableBalance", "12", "D"));
        this.interfaceFieldSet.put("111-7", new Fields("LLL", "sourceFullName", null, null));
        this.interfaceFieldSet.put("111-8", new Fields("LL", "sourceBankAcronym", null, null));
        this.interfaceFieldSet.put("111-9", new Fields("F", "srcSvaAccountNumber", "11", null));
        this.interfaceFieldSet.put("112", new Fields("B", "additionalDestAccountData", "4", null));
        this.interfaceFieldSet.put("112-2", new Fields("LL", "destRfc", null, null));
        this.interfaceFieldSet.put("112-3", new Fields("F", "destMsisdn", "12", null));
        this.interfaceFieldSet.put("112-4", new Fields("LLL", "destEmail", null, null));
        this.interfaceFieldSet.put("112-5", new Fields("F", "destBalance", "12", "D"));
        this.interfaceFieldSet.put("112-6", new Fields("F", "destAvailableBalance", "12", "D"));
        this.interfaceFieldSet.put("112-7", new Fields("LLL", "destFullName", null, null));
        this.interfaceFieldSet.put("112-8", new Fields("LL", "destBankAcronym", null, null));
        this.interfaceFieldSet.put("112-9", new Fields("F", "dstSvaAccountNumber", "11", null));
        this.interfaceFieldSet.put("113", new Fields("B", "generalAdditionalData", "4", null));
        this.interfaceFieldSet.put("113-2", new Fields("LLL", "references", null, null));
        this.interfaceFieldSet.put("113-3", new Fields("LLL", "alias", null, null));
        this.interfaceFieldSet.put("113-4", new Fields("LLL", "reason", null, null));
        this.interfaceFieldSet.put("113-5", new Fields("LL", "lockType", null, null));
        this.interfaceFieldSet.put("113-6", new Fields("LL", "pocketType", null, null));
        this.interfaceFieldSet.put("114", new Fields("B", "paymentCommissionData", "4", null));
        this.interfaceFieldSet.put("114-2", new Fields("F", "sourceFeeVatAmount", "12", "D"));
        this.interfaceFieldSet.put("114-3", new Fields("F", "sourceTotalFeeAmount", "12", "D"));
        this.interfaceFieldSet.put("114-4", new Fields("F", "sourceRateOfTax", "12", "D"));
        this.interfaceFieldSet.put("114-5", new Fields("F", "destFeeVatAmount", "12", "D"));
        this.interfaceFieldSet.put("114-6", new Fields("F", "destTotalFeeAmount", "12", "D"));
        this.interfaceFieldSet.put("114-7", new Fields("F", "destRateOfTax", "12", "D"));
        this.interfaceFieldSet.put("115", new Fields("B", "generalCommissionData", "2", null));
        this.interfaceFieldSet.put("115-2", new Fields("F", "fee", "12", "D"));
        this.interfaceFieldSet.put("115-3", new Fields("F", "tax", "12", "D"));
        this.interfaceFieldSet.put("115-4", new Fields("F", "rateOfTax", "12", "D"));
        this.interfaceFieldSet.put("116", new Fields("B", "oneTimeCodesData", "2", null));
        this.interfaceFieldSet.put("116-2", new Fields("L", "tan", null, null));
        this.interfaceFieldSet.put("116-3", new Fields("LL", "tanExpirationTime", null, null));
        this.interfaceFieldSet.put("116-4", new Fields("LL", "otp", null, null));
        this.interfaceFieldSet.put("116-5", new Fields("LL", "otpExpirationTime", null, null));
        this.interfaceFieldSet.put("116-6", new Fields("F", "otpStatus", "1", null));
        this.interfaceFieldSet.put("117", new Fields("B", "limitingTransactionsData", "2", null));
        this.interfaceFieldSet.put("117-2", new Fields("F", "fromDate", "8", null));
        this.interfaceFieldSet.put("117-3", new Fields("F", "toDate", "8", null));
        this.interfaceFieldSet.put("117-4", new Fields("F", "numOfRecords", "3", null));
        this.interfaceFieldSet.put("117-5", new Fields("F", "segmentNumber", "3", null));
        this.interfaceFieldSet.put("117-6", new Fields("F", "cutOffDate", "7", null));
        this.interfaceFieldSet.put("118", new Fields("B", "transactionCollectionsData", "2", null));
        this.interfaceFieldSet.put("118-2", new Fields("LLL", "transaction", null, null));
        this.interfaceFieldSet.put("118-3", new Fields("LLLL", "transactions", null, null));
        this.interfaceFieldSet.put("118-4", new Fields("L", "moreTransactions", null, null));
        this.interfaceFieldSet.put("119", new Fields("B", "generalCollectionsData", "8", null));
        this.interfaceFieldSet.put("119-2", new Fields("LLLL", "msisdnList", null, null));
        this.interfaceFieldSet.put("119-3", new Fields("LLLL", "limitMap", null, null));
        this.interfaceFieldSet.put("119-4", new Fields("LLLL", "banks", null, null));
        this.interfaceFieldSet.put("119-5", new Fields("LLLL", "messagesMap", null, null));
        this.interfaceFieldSet.put("119-6", new Fields("LLLL", "propertyMap", null, null));
        this.interfaceFieldSet.put("119-7", new Fields("LLLL", "allowedBanksSourceAccount", null, null));
        this.interfaceFieldSet.put("119-8", new Fields("LLLL", "pocketTaxMap", null, null));
        this.interfaceFieldSet.put("119-9", new Fields("LLLL", "carriers", null, null));
        this.interfaceFieldSet.put("119-10", new Fields("LLLL", "customerData", null, null));
        this.interfaceFieldSet.put("119-11", new Fields("LLLL", "institutions", null, null));
        this.interfaceFieldSet.put("119-12", new Fields("LLLL", "allowedBanksDestAccount", null, null));
        this.interfaceFieldSet.put("119-13", new Fields("LLLL", "paymentData", null, null));
        this.interfaceFieldSet.put("119-14", new Fields("LLLL", "ticketList", null, null));
        this.interfaceFieldSet.put("120", new Fields("B", "generalCollectionsData", "8", null));
        this.interfaceFieldSet.put("121", new Fields("B", "customerBasicData", "8", null));
        this.interfaceFieldSet.put("121-2", new Fields("LLL", "name", null, null));
        this.interfaceFieldSet.put("121-3", new Fields("LLL", "secondName", null, null));
        this.interfaceFieldSet.put("121-4", new Fields("LLL", "firstLastName", null, null));
        this.interfaceFieldSet.put("121-5", new Fields("LLL", "secondLastName", null, null));
        this.interfaceFieldSet.put("121-6", new Fields("LLL", "addressStreet", null, null));
        this.interfaceFieldSet.put("121-7", new Fields("LLL", "addressBuildingInternal", null, null));
        this.interfaceFieldSet.put("121-8", new Fields("LLL", "addressBuildingExternal", null, null));
        this.interfaceFieldSet.put("121-9", new Fields("LLL", "addressAppartment", null, null));
        this.interfaceFieldSet.put("121-10", new Fields("LLL", "addressNeighbourhood", null, null));
        this.interfaceFieldSet.put("121-11", new Fields("LLL", "addressLocation", null, null));
        this.interfaceFieldSet.put("121-12", new Fields("LLL", "addressState", null, null));
        this.interfaceFieldSet.put("121-13", new Fields("LL", "postalCode", null, null));
        this.interfaceFieldSet.put("121-14", new Fields("LL", "dateOfBirth", null, null));
        this.interfaceFieldSet.put("121-15", new Fields("LLL", "msisdn", null, null));
        this.interfaceFieldSet.put("121-16", new Fields("LLL", "email", null, null));
        this.interfaceFieldSet.put("121-17", new Fields("LL", "fundingAccount", null, null));
        this.interfaceFieldSet.put("121-18", new Fields("LL", "rfc", null, null));
        this.interfaceFieldSet.put("121-19", new Fields("LL", "notificationMethod", null, null));
        this.interfaceFieldSet.put("121-20", new Fields("F", "cardNumber", "16", null));
        this.interfaceFieldSet.put("121-21", new Fields("LL", "customerNumber", null, null));
        this.interfaceFieldSet.put("121-22", new Fields("F", "idType", "1", null));
        this.interfaceFieldSet.put("121-23", new Fields("LL", "idNumber", null, null));
        this.interfaceFieldSet.put("121-24", new Fields("F", "gender", "1", null));
        this.interfaceFieldSet.put("121-25", new Fields("LL", "birthStateCode", "1", null));
        this.interfaceFieldSet.put("121-26", new Fields("LL", "birthState", null, null));
        this.interfaceFieldSet.put("121-27", new Fields("LL", "virtualFileNumber", null, null));
        this.interfaceFieldSet.put("121-28", new Fields("F", "carrierId", "4", null));
        this.interfaceFieldSet.put("121-29", new Fields("LL", "curp", null, null));
        this.interfaceFieldSet.put("121-30", new Fields("F", "renapoStatus", "3", null));
        this.interfaceFieldSet.put("121-31", new Fields("LL", "renapoValidationDate", null, null));
        this.interfaceFieldSet.put("121-32", new Fields("F", "renapoValidationCounter", "2", null));
        this.interfaceFieldSet.put("122", new Fields("B", "additionalCustomerData", "4", null));
        this.interfaceFieldSet.put("122-2", new Fields("L", "customerStatus", null, null));
        this.interfaceFieldSet.put("122-3", new Fields("L", "registrationLevel", null, null));
        this.interfaceFieldSet.put("122-4", new Fields("LL", "registrationDate", null, null));
        this.interfaceFieldSet.put("122-5", new Fields("L", "retirementReason", null, null));
        this.interfaceFieldSet.put("122-6", new Fields("F", "retirementDate", "15", null));
        this.interfaceFieldSet.put("122-7", new Fields("F", "associationType", "1", null));
        this.interfaceFieldSet.put("122-8", new Fields("F", "hasCardHistory ", "1", null));
        this.interfaceFieldSet.put("122-9", new Fields("LLL", "locks ", null, null));
        this.interfaceFieldSet.put("122-10", new Fields("LL", "language ", null, null));
        this.interfaceFieldSet.put("122-11", new Fields("LL", "timeZone ", null, null));
        this.interfaceFieldSet.put("122-12", new Fields("LLL", "remarks ", null, null));
        this.interfaceFieldSet.put("123", new Fields("B", "additionalCustomerRegistrationData", "4", null));
        this.interfaceFieldSet.put("123-2", new Fields("F", "esRegistro", "2", null));
        this.interfaceFieldSet.put("123-3", new Fields("L", "idUsuarioCaptura", null, null));
        this.interfaceFieldSet.put("123-4", new Fields("F", "tipoDeApertura", "1", null));
        this.interfaceFieldSet.put("123-5", new Fields("F", "clave", "10", null));
        this.interfaceFieldSet.put("123-6", new Fields("LLL", "nombreEmpleado", null, null));
        this.interfaceFieldSet.put("123-7", new Fields("L", "idAsesor", null, null));
        this.interfaceFieldSet.put("123-8", new Fields("L", "idDomicilioPersona", null, null));
        this.interfaceFieldSet.put("123-9", new Fields("F", "IdCustomerNumber", "12", null));
        this.interfaceFieldSet.put("123-10", new Fields("F", "IdPersona", "12", null));
        this.interfaceFieldSet.put("123", new Fields("B", "additionalCustomerRegistrationData", "4", null));
        this.interfaceFieldSet.put("123-2", new Fields("F", "esRegistro", "3", null));
        this.interfaceFieldSet.put("123-3", new Fields("L", "idUsuarioCaptura", null, null));
        this.interfaceFieldSet.put("123-4", new Fields("F", "tipoDeApertura", null, null));
        this.interfaceFieldSet.put("123-5", new Fields("F", "clave", "10", null));
        this.interfaceFieldSet.put("123-6", new Fields("F", "nombreEmpleado", null, null));
        this.interfaceFieldSet.put("123-7", new Fields("L", "idAsesor", null, null));
        this.interfaceFieldSet.put("123-8", new Fields("L", "idDomicilioPersona", null, null));
        this.interfaceFieldSet.put("123-9", new Fields("F", "IdCustomerNumber", "12", null));
        this.interfaceFieldSet.put("123-10", new Fields("F", "IdPersona", "9", null));
        this.interfaceFieldSet.put("124", new Fields("B", "customerBalanceData", "2", null));
        this.interfaceFieldSet.put("124-2", new Fields("F", "balance", "12", "D"));
        this.interfaceFieldSet.put("124-3", new Fields("F", "availableBalance", "12", "D"));
        this.interfaceFieldSet.put("124-4", new Fields("F", "reservedBalance", "12", "D"));
        this.interfaceFieldSet.put("125", new Fields("B", "customerBalanceData", "2", null));
        this.interfaceFieldSet.put("125-2", new Fields("F", "clabe", "18", null));
        this.interfaceFieldSet.put("125-3", new Fields("F", "svaAccountNumber", "12", null));
        this.interfaceFieldSet.put("125-4", new Fields("F", "msisdnReception", "12", null));
        this.interfaceFieldSet.put("125-5", new Fields("LLL", "bankCode", null, null));
    }


    public void generateResponseFixed(int tam, String fieldName, String type) {
        try {
            this.field = this.message.substring(this.index, this.index + tam);

            type = (type != null) ? type : "";
            String str;
            switch ((str = type).hashCode()) {

                case 68:
                    if (str.equals("D")) ;
                    break;


                case 73:
                    if (!str.equals("I")) {

                        this.field = amountFormated(this.field);

                        break;
                    }
                    this.field = String.valueOf(Integer.parseInt(this.field));
                    break;
            }

            PropertyUtils.setNestedProperty(this.response, fieldName, this.field);
            this.index += tam;
        } catch (Exception ex) {

            this.log.error("[" + fieldName + "]: " + ex);
            this.index += tam;
        }
    }


    public void generateResponseLVars(int pTam, String fieldName) {
        int tam = 0;

        try {
            tam = Integer.parseInt(this.message.substring(this.index, this.index + pTam));
            this.index += pTam;
            PropertyUtils.setNestedProperty(this.response, fieldName, this.message.substring(this.index, this.index + tam));
            this.index += tam;
        } catch (Exception ex) {

            this.log.error("[" + fieldName + "]: " + ex);
            this.index += tam;
        }
    }


    public void generateResponseBitamp(String pPosition, int tam) {
        String bitmap = HexToBin(this.message.substring(this.index, this.index + tam), tam);
        this.index += tam;
        for (int i = 0; i < bitmap.length(); i++) {
            if (bitmap.charAt(i) == '1') {
                getField(String.valueOf(pPosition) + "-" + (i + 1));
            }
        }
    }


    public String HexToBin(String input, int hexa) {
        String binSec = (new BigInteger(input, 16)).toString(2);
        int agregados = hexa * 4 - binSec.length();
        for (int i = 0; i < agregados; i++) {
            binSec = "0" + binSec;
        }
        return binSec;
    }


    public DTOResponse getObject() {
        return this.response;
    }


    public String amountFormated(String samount) {
        DecimalFormat format = new DecimalFormat("#######0.00");
        String amount = format.format(Long.valueOf(samount).longValue() / 100.0D);
        return amount;
    }
}


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\authentic\InterfaceFieldSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */