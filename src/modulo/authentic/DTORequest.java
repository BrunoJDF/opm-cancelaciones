 package modulo.authentic;

 import org.apache.commons.lang.StringUtils;

 import java.io.UnsupportedEncodingException;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.Map;
 import java.util.TreeMap;
 
 
 public class DTORequest
 {
   Tools tool = new Tools();
   
   private Map<Integer, Object> OAM = new TreeMap<>();
   private Map<Integer, String> additionalTransactionData = new TreeMap<>();
   private Map<Integer, String> responseData = new TreeMap<>();
   private Map<Integer, String> pinData = new TreeMap<>();
   private Map<Integer, String> externalSystemData = new TreeMap<>();
   private Map<Integer, String> amountData = new TreeMap<>();
   private Map<Integer, String> additionalSourceAccountData = new TreeMap<>();
   private Map<Integer, String> additionalDestAccountData = new TreeMap<>();
   private Map<Integer, String> generalAdditionalData = new TreeMap<>();
   private Map<Integer, String> paymentCommissionData = new TreeMap<>();
   private Map<Integer, String> generalCommissionData = new TreeMap<>();
   private Map<Integer, String> oneTimeCodesData = new TreeMap<>();
   private Map<Integer, String> limitingTransactionsData = new TreeMap<>();
   private Map<Integer, String> transactionCollectionsData = new TreeMap<>();
   private Map<Integer, String> additionalISOData = new TreeMap<>();
   private Map<Integer, String> generalCollectionsData = new TreeMap<>();
   private Map<Integer, String> customerBasicData = new TreeMap<>();
   private Map<Integer, String> additionalCustomerData = new TreeMap<>();
   private Map<Integer, String> additionalCustomerRegistrationData = new TreeMap<>();
   private Map<Integer, String> customerBalanceData = new TreeMap<>();
   private Map<Integer, String> customerSVAInfoData = new TreeMap<>();
   private StringBuffer request = new StringBuffer();
   private StringBuffer OAMBuilder = new StringBuffer();
   private String mti = "";
   private String header = "";
   private String amount = "";
   private String serviceName = "";
   private boolean bitmapSec = false;
   private final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
 
   
   public void setTransactionType(String transactionType) {
     this.OAM.put(Integer.valueOf(2), LVar(transactionType));
   }
 
   
   public String getTransactionType() {
     return (String)this.OAM.get(Integer.valueOf(2));
   }
 
   
   public void setTipoTransferencia(String tipoTransferencia) {
     this.OAM.put(Integer.valueOf(2), LVar(tipoTransferencia));
   }
 
   
   public void setTipoOperacion(String tipoOperacion) {
     this.OAM.put(Integer.valueOf(2), LVar(tipoOperacion));
   }
 
   
   public void setPaymentType(String paymentType) {
     this.OAM.put(Integer.valueOf(2), LVar(paymentType));
   }
 
   
   public void setPackageAction(String packageAction) {
     this.OAM.put(Integer.valueOf(2), LVar(packageAction));
   }
 
   
   public void setProcessingCodeAuthentic(String processingCodeAuthentic) {
     this.OAM.put(Integer.valueOf(3), StringUtils.leftPad(String.valueOf(processingCodeAuthentic) + this.mti, 6, "0"));
   }
 
   
   public void setAmount(String amount) {
     this.amount = amount;
     amount = validarMonto(amount);
     this.OAM.put(Integer.valueOf(4), amount);
   }
 
   
   public void setPrecio(String precio) {
     precio = validarMonto(precio);
     this.OAM.put(Integer.valueOf(4), precio);
   }
 
   
   public void setImporte(String importe) {
     importe = validarMonto(importe);
     this.OAM.put(Integer.valueOf(4), importe);
   }
 
   
   public void setSourceAmount(String sourceAmount) {
     sourceAmount = validarMonto(sourceAmount);
     this.OAM.put(Integer.valueOf(4), sourceAmount);
   }
 
   
   public void setCashbackAmount(String cashbackAmount) {
     cashbackAmount = validarMonto(cashbackAmount);
     this.OAM.put(Integer.valueOf(4), cashbackAmount);
   }
 
   
   public void setAdditionalAmount(String additionalAmount) {
     additionalAmount = validarMonto(additionalAmount);
     this.OAM.put(Integer.valueOf(5), additionalAmount);
   }
 
   
   public void setTotalAmount(String totalAmount) {
     totalAmount = validarMonto(totalAmount);
     this.OAM.put(Integer.valueOf(5), totalAmount);
   }
 
   
   public void setAdditionalAmountType(String additionalAmountType) {
     this.OAM.put(Integer.valueOf(6), StringUtils.leftPad(additionalAmountType, 2, "0"));
   }
 
   
   public void setTransactionDateAndTime(String transactionDateAndTime) {
     this.OAM.put(Integer.valueOf(7), StringUtils.leftPad(transactionDateAndTime, 10, "0"));
   }
 
   
   public void setServiceName(String serviceName) {
     this.serviceName = serviceName;
     this.OAM.put(Integer.valueOf(9), LLVar(serviceName));
   }
 
   
   public String getServiceName() {
     return this.serviceName;
   }
 
   
   public void setServiceNameFlow(String serviceNameFlow) {
     this.OAM.put(Integer.valueOf(10), LLVar(serviceNameFlow));
   }
 
   
   public void setAuditNumber(String auditNumber) {
     this.OAM.put(Integer.valueOf(11), LLVar(auditNumber));
   }
 
   
   public void setLocalTransactionTime(String localTransactionTime) {
     this.OAM.put(Integer.valueOf(12), StringUtils.leftPad(localTransactionTime, 6, "0"));
   }
 
   
   public void setLocalTransactionDate(String localTransactionDate) {
     this.OAM.put(Integer.valueOf(13), StringUtils.leftPad(localTransactionDate, 4, "0"));
   }
 
   
   public void setTransactionDate(String transactionDate) {
     this.OAM.put(Integer.valueOf(13), StringUtils.leftPad(transactionDate.substring(4), 4, "0"));
   }
 
   
   public void setExpirationDate(String expirationDate) {
     this.OAM.put(Integer.valueOf(14), StringUtils.leftPad(expirationDate, 15, "0"));
   }
 
   
   public void setExpirationTime(String expirationTime) {
     this.OAM.put(Integer.valueOf(14), StringUtils.leftPad(expirationTime, 15, "0"));
   }
 
   
   public void setSessionId(String sessionId) {
     this.OAM.put(Integer.valueOf(15), StringUtils.leftPad(sessionId, 15, "0"));
   }
 
   
   public void setSystemDate(String systemDate) {
     this.OAM.put(Integer.valueOf(16), StringUtils.leftPad(systemDate, 15, "0"));
   }
 
   
   public void setCountryCode(String countryCode) {
     this.OAM.put(Integer.valueOf(19), StringUtils.leftPad(countryCode, 3, "0"));
   }
 
   
   public void setAccessMethod(String accessMethod) {
     this.OAM.put(Integer.valueOf(26), StringUtils.leftPad(accessMethod, 3, "0"));
   }
 
   
   public String getAccessMethod() {
     return (String)this.OAM.get(Integer.valueOf(26));
   }
 
   
   public void setRequester(String requester) {
     this.OAM.put(Integer.valueOf(26), StringUtils.leftPad(requester, 3, "0"));
   }
 
   
   public void setBankId(String bankId) {
     this.OAM.put(Integer.valueOf(31), StringUtils.leftPad(bankId, 3, "0"));
   }
 
   
   public void setSourceBankId(String sourceBankId) {
     this.OAM.put(Integer.valueOf(32), StringUtils.leftPad(sourceBankId, 3, "0"));
   }
 
   
   public void setSourceBank(String sourceBank) {
     this.OAM.put(Integer.valueOf(32), StringUtils.leftPad(sourceBank, 3, "0"));
   }
 
   
   public void setDestBankId(String destBankId) {
     this.OAM.put(Integer.valueOf(33), StringUtils.leftPad(destBankId, 3, "0"));
   }
 
   
   public void setDstBank(String dstBank) {
     this.OAM.put(Integer.valueOf(33), StringUtils.leftPad(dstBank, 3, "0"));
   }
 
   
   public void setBankDest(String bankDest) {
     this.OAM.put(Integer.valueOf(33), StringUtils.leftPad(bankDest, 3, "0"));
   }
 
   
   public void setReturnCode(String returnCode) {
     this.OAM.put(Integer.valueOf(39), StringUtils.leftPad(returnCode, 4, "0"));
   }
 
   
   public void setResultado(String resultado) {
     this.OAM.put(Integer.valueOf(39), StringUtils.leftPad(resultado, 4, "0"));
   }
 
   
   public void setCodigoError(String codigoError) {
     this.OAM.put(Integer.valueOf(39), StringUtils.leftPad(codigoError, 4, "0"));
   }
 
   
   public void setResponseCode(String responseCode) {
     this.OAM.put(Integer.valueOf(39), StringUtils.leftPad(responseCode, 4, "0"));
   }
 
   
   public void setErrorDescription(String errorDescription) {
     this.OAM.put(Integer.valueOf(40), LLLVar(errorDescription));
   }
 
   
   public void setError(String error) {
     this.OAM.put(Integer.valueOf(40), LLLVar(error));
   }
 
   
   public void setDescripcionError(String descripcionError) {
     this.OAM.put(Integer.valueOf(40), LLLVar(descripcionError));
   }
 
   
   public void setResponseDescription(String responseDescription) {
     this.OAM.put(Integer.valueOf(40), LLLVar(responseDescription));
   }
 
   
   public void setPhysicalBoxId(String physicalBoxId) {
     this.OAM.put(Integer.valueOf(41), LLVar(physicalBoxId));
   }
 
   
   public void setCardAcceptorTerminalId(String cardAcceptorTerminalId) {
     this.OAM.put(Integer.valueOf(41), LLVar(cardAcceptorTerminalId));
   }
 
   
   public void setBranchId(String branchId) {
     this.OAM.put(Integer.valueOf(42), LLVar(branchId));
   }
 
   
   public void setOfficeId(String officeId) {
     this.OAM.put(Integer.valueOf(42), LLVar(officeId));
   }
 
   
   public void setPosId(String posId) {
     this.OAM.put(Integer.valueOf(43), LLVar(posId));
   }
 
   
   public void setMerchantId(String merchantId) {
     this.OAM.put(Integer.valueOf(45), LLVar(merchantId));
   }
 
   
   public void setMerchantName(String merchantName) {
     this.OAM.put(Integer.valueOf(46), LLVar(merchantName));
   }
 
   
   public void setCurrency(String currency) {
     this.OAM.put(Integer.valueOf(49), StringUtils.leftPad(currency, 3, "0"));
   }
 
   
   public void setKey(String key) {
     this.OAM.put(Integer.valueOf(52), LLVar(key));
   }
 
   
   public void setOriginatorTransactionId(String originatorTransactionId) {
     this.OAM.put(Integer.valueOf(66), LLVar(originatorTransactionId));
   }
 
   
   public void setReferenciaExterna(String referenciaExterna) {
     this.OAM.put(Integer.valueOf(66), LLVar(referenciaExterna));
   }
 
   
   public void setFolioMPS(String folioMPS) {
     this.OAM.put(Integer.valueOf(66), LLVar(folioMPS));
   }
 
   
   public void setIdTransaccion(String idTransaccion) {
     this.OAM.put(Integer.valueOf(66), LLVar(idTransaccion));
   }
 
   
   public void setOriginalOriginatorTransactionId(String originalOriginatorTransactionId) {
     this.OAM.put(Integer.valueOf(67), LLVar(originalOriginatorTransactionId));
   }
 
   
   public void setOriginatorTransactionReference(String originatorTransactionReference) {
     this.OAM.put(Integer.valueOf(67), LLVar(originatorTransactionReference));
   }
 
   
   public void setFlowId(String flowId) {
     this.OAM.put(Integer.valueOf(67), LLVar(flowId));
   }
 
   
   public void setOriginalAuditNumber(String originalAuditNumber) {
     this.OAM.put(Integer.valueOf(68), LLVar(originalAuditNumber));
   }
 
   
   public void setTransactionID(String transactionID) {
     this.OAM.put(Integer.valueOf(68), LLVar(transactionID));
   }
 
   
   public void setMpsTransactionId(String mpsTransactionId) {
     this.OAM.put(Integer.valueOf(71), StringUtils.leftPad(mpsTransactionId, 12, "0"));
   }
 
   
   public void setAuthorizationId(String authorizationId) {
     this.OAM.put(Integer.valueOf(71), StringUtils.leftPad(authorizationId, 12, "0"));
   }
 
   
   public void setOriginalMpsTransactionId(String originalMpsTransactionId) {
     this.OAM.put(Integer.valueOf(72), StringUtils.leftPad(originalMpsTransactionId, 12, "0"));
   }
 
   
   public void setMpsTransactionIdOrig(String mpsTransactionIdOrig) {
     this.OAM.put(Integer.valueOf(72), StringUtils.leftPad(mpsTransactionIdOrig, 12, "0"));
   }
 
   
   public void setDestFeeAmount(String destFeeAmount) {
     destFeeAmount = validarMonto(destFeeAmount);
     this.OAM.put(Integer.valueOf(83), destFeeAmount);
   }
 
   
   public void setSourceFeeAmount(String sourceFeeAmount) {
     sourceFeeAmount = validarMonto(sourceFeeAmount);
     this.OAM.put(Integer.valueOf(85), sourceFeeAmount);
   }
 
   
   public void setCommissionPayer(String commissionPayer) {
     this.OAM.put(Integer.valueOf(98), commissionPayer);
   }
 
   
   public void setSourceAccountId(String sourceAccountId) {
     this.OAM.put(Integer.valueOf(102), LLVar(sourceAccountId));
   }
 
   
   public void setCuentaOrigen(String cuentaOrigen) {
     this.OAM.put(Integer.valueOf(102), LLVar(cuentaOrigen));
   }
 
   
   public void setCuentaCargo(String cuentaCargo) {
     this.OAM.put(Integer.valueOf(102), LLVar(cuentaCargo));
   }
 
   
   public void setCustomerIdentifier(String customerIdentifier) {
     this.OAM.put(Integer.valueOf(102), LLVar(customerIdentifier));
   }
 
   
   public void setSourceCardNumber(String sourceCardNumber) {
     this.OAM.put(Integer.valueOf(102), LLVar(sourceCardNumber));
   }
 
   
   public void setSrcMSISDN(String srcMSISDN) {
     this.OAM.put(Integer.valueOf(102), LLVar(srcMSISDN));
   }
 
   
   public void setNumCelularOrigen(String numCelularOrigen) {
     this.OAM.put(Integer.valueOf(102), LLVar(numCelularOrigen));
   }
 
   
   public void setBankSourceAccount(String bankSourceAccount) {
     this.OAM.put(Integer.valueOf(102), LLVar(bankSourceAccount));
   }
 
   
   public void setDestAccountId(String destAccountId) {
     this.OAM.put(Integer.valueOf(103), LLVar(destAccountId));
   }
 
   
   public void setNumCuentaCargoAbono(String numCuentaCargoAbono) {
     this.OAM.put(Integer.valueOf(103), LLVar(numCuentaCargoAbono));
   }
 
   
   public void setNumCtaCargoAbono(String numCtaCargoAbono) {
     this.OAM.put(Integer.valueOf(103), LLVar(numCtaCargoAbono));
   }
 
   
   public void setCuentaAbono(String cuentaAbono) {
     this.OAM.put(Integer.valueOf(103), LLVar(cuentaAbono));
   }
 
   
   public void setSettlementAccountId(String settlementAccountId) {
     this.OAM.put(Integer.valueOf(103), LLVar(settlementAccountId));
   }
 
   
   public void setBankDestAccount(String bankDestAccount) {
     this.OAM.put(Integer.valueOf(103), LLVar(bankDestAccount));
   }
 
   
   public void setDstMSISDN(String dstMSISDN) {
     this.OAM.put(Integer.valueOf(103), LLVar(dstMSISDN));
   }
 
   
   public void setDstAccount(String dstAccount) {
     this.OAM.put(Integer.valueOf(103), LLVar(dstAccount));
   }
 
   
   public void setMerchantIdentifier(String merchantIdentifier) {
     this.OAM.put(Integer.valueOf(103), LLVar(merchantIdentifier));
   }
 
   
   public void setSourceAccountIdType(String sourceAccountIdType) {
     this.OAM.put(Integer.valueOf(104), StringUtils.leftPad(sourceAccountIdType, 3, "0"));
   }
 
   
   public void setIdentifierType(String identifierType) {
     this.OAM.put(Integer.valueOf(104), StringUtils.leftPad(identifierType, 3, "0"));
   }
 
   
   public void setCustomerIdentifierType(String customerIdentifierType) {
     this.OAM.put(Integer.valueOf(104), StringUtils.leftPad(customerIdentifierType, 3, "0"));
   }
 
   
   public void setBankSourceAccountType(String bankSourceAccountType) {
     this.OAM.put(Integer.valueOf(104), StringUtils.leftPad(bankSourceAccountType, 3, "0"));
   }
 
   
   public void setDestAccountIdType(String destAccountIdType) {
     this.OAM.put(Integer.valueOf(105), StringUtils.leftPad(destAccountIdType, 3, "0"));
   }
 
   
   public void setSettlementAccountIdType(String settlementAccountIdType) {
     this.OAM.put(Integer.valueOf(105), StringUtils.leftPad(settlementAccountIdType, 3, "0"));
   }
 
   
   public void setBankDestAccountType(String bankDestAccountType) {
     this.OAM.put(Integer.valueOf(105), StringUtils.leftPad(bankDestAccountType, 3, "0"));
   }
 
   
   public void setAccountNumberType(String accountNumberType) {
     this.OAM.put(Integer.valueOf(105), StringUtils.leftPad(accountNumberType, 3, "0"));
   }
 
   
   public void setAuthorizedPush(String authorizedPush) {
     this.additionalTransactionData.put(Integer.valueOf(2), LVar(authorizedPush));
     this.OAM.put(Integer.valueOf(106), this.additionalTransactionData);
   }
 
   
   public void setTransactionConcept(String transactionConcept) {
     this.additionalTransactionData.put(Integer.valueOf(3), StringUtils.leftPad(transactionConcept, 3, "0"));
     this.OAM.put(Integer.valueOf(106), this.additionalTransactionData);
   }
 
   
   public void setValidateUpdateSrcLimits(String validateUpdateSrcLimits) {
     this.additionalTransactionData.put(Integer.valueOf(4), validateUpdateSrcLimits);
     this.OAM.put(Integer.valueOf(106), this.additionalTransactionData);
   }
 
   
   public void setValidateUpdateDstLimits(String validateUpdateDstLimits) {
     this.additionalTransactionData.put(Integer.valueOf(5), validateUpdateDstLimits);
     this.OAM.put(Integer.valueOf(106), this.additionalTransactionData);
   }
 
   
   public void setStatus(String status) {
     this.additionalTransactionData.put(Integer.valueOf(6), status);
     this.OAM.put(Integer.valueOf(106), this.additionalTransactionData);
   }
 
   
   public void setAlgorithm(String Algorithm) {
     this.additionalTransactionData.put(Integer.valueOf(7), Algorithm);
     this.OAM.put(Integer.valueOf(106), this.additionalTransactionData);
   }
 
   
   public void setSpeiCode(String speiCode) {
     this.additionalTransactionData.put(Integer.valueOf(8), LLVar(speiCode));
     this.OAM.put(Integer.valueOf(106), this.additionalTransactionData);
   }
 
   
   public void setCodigoRastreo(String codigoRastreo) {
     this.additionalTransactionData.put(Integer.valueOf(8), LLVar(codigoRastreo));
     this.OAM.put(Integer.valueOf(106), this.additionalTransactionData);
   }
 
   
   public void setIsSvaToBank(String isSvaToBank) {
     this.additionalTransactionData.put(Integer.valueOf(9), isSvaToBank);
     this.OAM.put(Integer.valueOf(106), this.additionalTransactionData);
   }
 
   
   public void setTypeQuery(String typeQuery) {
     this.additionalTransactionData.put(Integer.valueOf(10), typeQuery);
     this.OAM.put(Integer.valueOf(106), this.additionalTransactionData);
   }
 
   
   public void setIdentifierValue(String IdentifierValue) {
     this.additionalTransactionData.put(Integer.valueOf(11), LLVar(IdentifierValue));
     this.OAM.put(Integer.valueOf(106), this.additionalTransactionData);
   }
 
   
   public void setErrorContext(String errorContext) {
     this.responseData.put(Integer.valueOf(2), errorContext);
     this.OAM.put(Integer.valueOf(107), this.responseData);
   }
 
   
   public void setFolio(String folio) {
     this.responseData.put(Integer.valueOf(3), StringUtils.leftPad(folio, 12, "0"));
     this.OAM.put(Integer.valueOf(107), this.responseData);
   }
 
   
   public void setAuthentificationResponse(String authentificationResponse) {
     this.responseData.put(Integer.valueOf(4), LVar(authentificationResponse));
     this.OAM.put(Integer.valueOf(107), this.responseData);
   }
 
   
   public void setAuthIdentificationResponse(String AuthIdentificationResponse) {
     this.responseData.put(Integer.valueOf(4), LVar(AuthIdentificationResponse));
     this.OAM.put(Integer.valueOf(107), this.responseData);
   }
 
   
   public void setResponse(String response) {
     this.responseData.put(Integer.valueOf(4), LVar(response));
     this.OAM.put(Integer.valueOf(107), this.responseData);
   }
 
   
   public void setExternalTransactionId(String externalTransactionId) {
     this.responseData.put(Integer.valueOf(5), LLVar(externalTransactionId));
     this.OAM.put(Integer.valueOf(107), this.responseData);
   }
 
   
   public void setFolioTransaccion(String folioTransaccion) {
     this.responseData.put(Integer.valueOf(5), LLVar(folioTransaccion));
     this.OAM.put(Integer.valueOf(107), this.responseData);
   }
 
   
   public void setIdTransaccionReverso(String idTransaccionReverso) {
     this.responseData.put(Integer.valueOf(5), LLVar(idTransaccionReverso));
     this.OAM.put(Integer.valueOf(107), this.responseData);
   }
 
   
   public void setAsociar(String asociar) {
     this.responseData.put(Integer.valueOf(6), asociar);
     this.OAM.put(Integer.valueOf(107), this.responseData);
   }
 
   
   public void setCreatesAnonymous(String createsAnonymous) {
     this.responseData.put(Integer.valueOf(7), createsAnonymous);
     this.OAM.put(Integer.valueOf(107), this.responseData);
   }
 
   
   public void setIsPinLocked(String isPinLocked) {
     this.pinData.put(Integer.valueOf(4), isPinLocked);
     this.OAM.put(Integer.valueOf(108), this.pinData);
   }
 
   
   public void setPinLockReason(String pinLockReason) {
     this.pinData.put(Integer.valueOf(5), StringUtils.leftPad(pinLockReason, 2, "0"));
     this.OAM.put(Integer.valueOf(108), this.pinData);
   }
 
   
   public void setPinIndicator(String pinIndicator) {
     this.pinData.put(Integer.valueOf(6), pinIndicator);
     this.OAM.put(Integer.valueOf(108), this.pinData);
   }
 
   
   public void setExecutiveId(String executiveId) {
     this.externalSystemData.put(Integer.valueOf(2), LLVar(executiveId));
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setExecutiveID(String executiveID) {
     this.externalSystemData.put(Integer.valueOf(2), LLVar(executiveID));
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setCorresponsalId(String corresponsalId) {
     this.externalSystemData.put(Integer.valueOf(3), LLVar(corresponsalId));
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setAgentId(String agentId) {
     this.externalSystemData.put(Integer.valueOf(3), LLVar(agentId));
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setStoreReference(String storeReference) {
     this.externalSystemData.put(Integer.valueOf(4), LLVar(storeReference));
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setPhysicalBoxIdNameLoc(String physicalBoxIdNameLoc) {
     this.externalSystemData.put(Integer.valueOf(5), LLVar(physicalBoxIdNameLoc));
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setCardAcceptorTerminalIdNameLoc(String cardAcceptorTerminalIdNameLoc) {
     this.externalSystemData.put(Integer.valueOf(5), LLVar(cardAcceptorTerminalIdNameLoc));
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setNumericReference(String numericReference) {
     this.externalSystemData.put(Integer.valueOf(6), LVar(numericReference));
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setReferenciaNumerica(String referenciaNumerica) {
     this.externalSystemData.put(Integer.valueOf(6), LVar(referenciaNumerica));
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setAlphanumericReference(String alphanumericReference) {
     this.externalSystemData.put(Integer.valueOf(7), LLVar(alphanumericReference));
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setReferenciaLeyenda(String referenciaLeyenda) {
     this.externalSystemData.put(Integer.valueOf(7), LLVar(referenciaLeyenda));
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setLatitude(String latitude) {
     this.externalSystemData.put(Integer.valueOf(8), LLVar(latitude));
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setLongitude(String longitude) {
     this.externalSystemData.put(Integer.valueOf(9), LLVar(longitude));
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setMedioAcceso(String medioAcceso) {
     this.externalSystemData.put(Integer.valueOf(10), medioAcceso);
     this.OAM.put(Integer.valueOf(109), this.externalSystemData);
   }
 
   
   public void setAmountSignedType(String amountSignedType) {
     this.amountData.put(Integer.valueOf(2), amountSignedType);
     this.OAM.put(Integer.valueOf(110), this.amountData);
   }
 
   
   public void setAmountThreshold(String amountThreshold) {
     amountThreshold = validarMonto(amountThreshold);
     this.amountData.put(Integer.valueOf(3), amountThreshold);
     this.OAM.put(Integer.valueOf(110), this.amountData);
   }
 
   
   public void setMinAmount(String minAmount) {
     minAmount = validarMonto(minAmount);
     this.amountData.put(Integer.valueOf(4), minAmount);
     this.OAM.put(Integer.valueOf(110), this.amountData);
   }
 
   
   public void setPendingTaxAmount(String pendingTaxAmount) {
     pendingTaxAmount = validarMonto(pendingTaxAmount);
     this.amountData.put(Integer.valueOf(5), pendingTaxAmount);
     this.OAM.put(Integer.valueOf(110), this.amountData);
   }
 
   
   public void setAmountRequired(String amountRequired) {
     amountRequired = validarMonto(amountRequired);
     this.amountData.put(Integer.valueOf(6), amountRequired);
     this.OAM.put(Integer.valueOf(110), this.amountData);
   }
 
   
   public void setEstimatedAmount(String estimatedAmount) {
     estimatedAmount = validarMonto(estimatedAmount);
     this.amountData.put(Integer.valueOf(7), estimatedAmount);
     this.OAM.put(Integer.valueOf(110), this.amountData);
   }
 
   
   public void setSourceRfc(String sourceRfc) {
     this.additionalSourceAccountData.put(Integer.valueOf(2), LLVar(sourceRfc));
     this.OAM.put(Integer.valueOf(111), this.additionalSourceAccountData);
   }
 
   
   public void setSourceMsisdn(String sourceMsisdn) {
     this.additionalSourceAccountData.put(Integer.valueOf(3), StringUtils.leftPad(sourceMsisdn, 12, "0"));
     this.OAM.put(Integer.valueOf(111), this.additionalSourceAccountData);
   }
 
   
   public void setNumCelular(String numCelular) {
     this.additionalSourceAccountData.put(Integer.valueOf(3), StringUtils.leftPad(numCelular, 12, "0"));
     this.OAM.put(Integer.valueOf(111), this.additionalSourceAccountData);
   }
 
   
   public void setSourceEmail(String sourceEmail) {
     this.additionalSourceAccountData.put(Integer.valueOf(4), LLVar(sourceEmail));
     this.OAM.put(Integer.valueOf(111), this.additionalSourceAccountData);
   }
 
   
   public void setSourceBalance(String sourceBalance) {
     sourceBalance = validarMonto(sourceBalance);
     this.additionalSourceAccountData.put(Integer.valueOf(5), sourceBalance);
     this.OAM.put(Integer.valueOf(111), this.additionalSourceAccountData);
   }
 
   
   public void setSourceAvailableBalance(String sourceAvailableBalance) {
     sourceAvailableBalance = validarMonto(sourceAvailableBalance);
     this.additionalSourceAccountData.put(Integer.valueOf(6), sourceAvailableBalance);
     this.OAM.put(Integer.valueOf(111), this.additionalSourceAccountData);
   }
 
   
   public void setSourceFullName(String sourceFullName) {
     this.additionalSourceAccountData.put(Integer.valueOf(7), LLLVar(sourceFullName));
     this.OAM.put(Integer.valueOf(111), this.additionalSourceAccountData);
   }
 
   
   public void setSourceBankAcronym(String sourceBankAcronym) {
     this.additionalSourceAccountData.put(Integer.valueOf(8), LLVar(sourceBankAcronym));
     this.OAM.put(Integer.valueOf(111), this.additionalSourceAccountData);
   }
 
   
   public void setSrcSvaAccountNumber(String srcSvaAccountNumber) {
     this.additionalSourceAccountData.put(Integer.valueOf(9), LLLVar(srcSvaAccountNumber));
     this.OAM.put(Integer.valueOf(111), this.additionalSourceAccountData);
   }
 
   
   public void setSourceAccount(String sourceAccount) {
     this.additionalSourceAccountData.put(Integer.valueOf(9), LLLVar(sourceAccount));
     this.OAM.put(Integer.valueOf(111), this.additionalSourceAccountData);
   }
 
   
   public void setDestRfc(String destRfc) {
     this.additionalDestAccountData.put(Integer.valueOf(2), LLVar(destRfc));
     this.OAM.put(Integer.valueOf(112), this.additionalDestAccountData);
   }
 
   
   public void setRfcBeneficiario(String rfcBeneficiario) {
     this.additionalDestAccountData.put(Integer.valueOf(2), LLVar(rfcBeneficiario));
     this.OAM.put(Integer.valueOf(112), this.additionalDestAccountData);
   }
 
   
   public void setDestMsisdn(String destMsisdn) {
     this.additionalDestAccountData.put(Integer.valueOf(3), StringUtils.leftPad(destMsisdn, 12, "0"));
     this.OAM.put(Integer.valueOf(112), this.additionalDestAccountData);
   }
 
   
   public void setDestEmail(String destEmail) {
     this.additionalDestAccountData.put(Integer.valueOf(4), LLLVar(destEmail));
     this.OAM.put(Integer.valueOf(112), this.additionalDestAccountData);
   }
 
   
   public void setDestBalance(String destBalance) {
     destBalance = validarMonto(destBalance);
     this.additionalDestAccountData.put(Integer.valueOf(5), destBalance);
     this.OAM.put(Integer.valueOf(112), this.additionalDestAccountData);
   }
 
   
   public void setDestAvailableBalance(String destAvailableBalance) {
     destAvailableBalance = validarMonto(destAvailableBalance);
     this.additionalDestAccountData.put(Integer.valueOf(6), destAvailableBalance);
     this.OAM.put(Integer.valueOf(112), this.additionalDestAccountData);
   }
 
   
   public void setDestFullName(String destFullName) {
     this.additionalDestAccountData.put(Integer.valueOf(7), LLLVar(destFullName));
     this.OAM.put(Integer.valueOf(112), this.additionalDestAccountData);
   }
 
   
   public void setBeneficiario(String beneficiario) {
     this.additionalDestAccountData.put(Integer.valueOf(7), LLLVar(beneficiario));
     this.OAM.put(Integer.valueOf(112), this.additionalDestAccountData);
   }
 
   
   public void setDestBankAcronym(String destBankAcronym) {
     this.additionalDestAccountData.put(Integer.valueOf(8), LLVar(destBankAcronym));
     this.OAM.put(Integer.valueOf(112), this.additionalDestAccountData);
   }
 
   
   public void setBankAcronym(String bankAcronym) {
     this.additionalDestAccountData.put(Integer.valueOf(8), LLVar(bankAcronym));
     this.OAM.put(Integer.valueOf(112), this.additionalDestAccountData);
   }
 
   
   public void setDstSvaAccountNumber(String dstSvaAccountNumber) {
     this.additionalDestAccountData.put(Integer.valueOf(9), StringUtils.leftPad(dstSvaAccountNumber, 11, "0"));
     this.OAM.put(Integer.valueOf(112), this.additionalDestAccountData);
   }
 
   
   public void setReferences(String references) {
     this.generalAdditionalData.put(Integer.valueOf(2), LLLVar(references));
     this.OAM.put(Integer.valueOf(113), this.generalAdditionalData);
   }
 
   
   public void setAlias(String alias) {
     this.generalAdditionalData.put(Integer.valueOf(3), LLVar(alias));
     this.OAM.put(Integer.valueOf(113), this.generalAdditionalData);
   }
 
   
   public void setReason(String reason) {
     this.generalAdditionalData.put(Integer.valueOf(4), LLLVar(reason));
     this.OAM.put(Integer.valueOf(113), this.generalAdditionalData);
   }
 
   
   public void setCodigo(String codigo) {
     this.generalAdditionalData.put(Integer.valueOf(4), LLLVar(codigo));
     this.OAM.put(Integer.valueOf(113), this.generalAdditionalData);
   }
 
   
   public void setComment(String comment) {
     this.generalAdditionalData.put(Integer.valueOf(4), LLLVar(comment));
     this.OAM.put(Integer.valueOf(113), this.generalAdditionalData);
   }
 
   
   public void setLockType(String lockType) {
     this.generalAdditionalData.put(Integer.valueOf(5), LLVar(lockType));
     this.OAM.put(Integer.valueOf(113), this.generalAdditionalData);
   }
 
   
   public void setPocketType(String pocketType) {
     this.generalAdditionalData.put(Integer.valueOf(5), LLVar(pocketType));
     this.OAM.put(Integer.valueOf(113), this.generalAdditionalData);
   }
 
   
   public void setSourceFeeVatAmount(String sourceFeeVatAmount) {
     sourceFeeVatAmount = validarMonto(sourceFeeVatAmount);
     this.paymentCommissionData.put(Integer.valueOf(2), sourceFeeVatAmount);
     this.OAM.put(Integer.valueOf(114), this.paymentCommissionData);
   }
 
   
   public void setSourceTotalFeeAmount(String sourceTotalFeeAmount) {
     sourceTotalFeeAmount = validarMonto(sourceTotalFeeAmount);
     this.paymentCommissionData.put(Integer.valueOf(3), sourceTotalFeeAmount);
     this.OAM.put(Integer.valueOf(114), this.paymentCommissionData);
   }
 
   
   public void setSourceRateOfTax(String sourceRateOfTax) {
     sourceRateOfTax = validarMonto(sourceRateOfTax);
     this.paymentCommissionData.put(Integer.valueOf(4), sourceRateOfTax);
     this.OAM.put(Integer.valueOf(114), this.paymentCommissionData);
   }
 
   
   public void setDestFeeVatAmount(String destFeeVatAmount) {
     destFeeVatAmount = validarMonto(destFeeVatAmount);
     this.paymentCommissionData.put(Integer.valueOf(5), destFeeVatAmount);
     this.OAM.put(Integer.valueOf(114), this.paymentCommissionData);
   }
 
   
   public void setDestTotalFeeAmount(String destTotalFeeAmount) {
     destTotalFeeAmount = validarMonto(destTotalFeeAmount);
     this.paymentCommissionData.put(Integer.valueOf(6), destTotalFeeAmount);
     this.OAM.put(Integer.valueOf(114), this.paymentCommissionData);
   }
 
   
   public void setDestRateOfTax(String destRateOfTax) {
     destRateOfTax = validarMonto(destRateOfTax);
     this.paymentCommissionData.put(Integer.valueOf(7), destRateOfTax);
     this.OAM.put(Integer.valueOf(114), this.paymentCommissionData);
   }
 
   
   public void setFee(String fee) {
     fee = validarMonto(fee);
     this.generalCommissionData.put(Integer.valueOf(2), fee);
     this.OAM.put(Integer.valueOf(115), this.generalCommissionData);
   }
 
   
   public void setComision(String comision) {
     comision = validarMonto(comision);
     this.generalCommissionData.put(Integer.valueOf(2), comision);
     this.OAM.put(Integer.valueOf(115), this.generalCommissionData);
   }
 
   
   public void setTax(String tax) {
     tax = validarMonto(tax);
     this.generalCommissionData.put(Integer.valueOf(3), tax);
     this.OAM.put(Integer.valueOf(115), this.generalCommissionData);
   }
 
   
   public void setIva(String iva) {
     iva = validarMonto(iva);
     this.generalCommissionData.put(Integer.valueOf(3), iva);
     this.OAM.put(Integer.valueOf(115), this.generalCommissionData);
   }
 
   
   public void setRateOfTax(String rateOfTax) {
     rateOfTax = validarMonto(rateOfTax);
     this.generalCommissionData.put(Integer.valueOf(4), rateOfTax);
     this.OAM.put(Integer.valueOf(115), this.generalCommissionData);
   }
 
   
   public void setTasaIva(String tasaIva) {
     tasaIva = validarMonto(tasaIva);
     this.generalCommissionData.put(Integer.valueOf(4), tasaIva);
     this.OAM.put(Integer.valueOf(115), this.generalCommissionData);
   }
 
   
   public void setFixRate(String fixRate) {
     fixRate = validarMonto(fixRate);
     this.generalCommissionData.put(Integer.valueOf(4), fixRate);
     this.OAM.put(Integer.valueOf(115), this.generalCommissionData);
   }
 
   
   public void setTan(String tan) {
     this.oneTimeCodesData.put(Integer.valueOf(2), LVar(tan));
     this.OAM.put(Integer.valueOf(116), this.oneTimeCodesData);
   }
 
   
   public void setTAN(String tan) {
     this.oneTimeCodesData.put(Integer.valueOf(2), LVar(tan));
     this.OAM.put(Integer.valueOf(116), this.oneTimeCodesData);
   }
 
   
   public void setTanExpirationTime(String tanExpirationTime) {
     this.oneTimeCodesData.put(Integer.valueOf(2), LLVar(tanExpirationTime));
     this.OAM.put(Integer.valueOf(116), this.oneTimeCodesData);
   }
 
   
   public void setOtp(String otp) {
     this.oneTimeCodesData.put(Integer.valueOf(2), LLVar(otp));
     this.OAM.put(Integer.valueOf(116), this.oneTimeCodesData);
   }
 
   
   public void setOtpExpirationTime(String otpExpirationTime) {
     this.oneTimeCodesData.put(Integer.valueOf(2), LLVar(otpExpirationTime));
     this.OAM.put(Integer.valueOf(116), this.oneTimeCodesData);
   }
 
   
   public void setOtpStatus(String otpStatus) {
     this.oneTimeCodesData.put(Integer.valueOf(2), otpStatus);
     this.OAM.put(Integer.valueOf(116), this.oneTimeCodesData);
   }
 
   
   public void setFromDate(String fromDate) {
     this.limitingTransactionsData.put(Integer.valueOf(2), StringUtils.leftPad(fromDate, 8, "0"));
     this.OAM.put(Integer.valueOf(117), this.limitingTransactionsData);
   }
 
   
   public void setToDate(String toDate) {
     this.limitingTransactionsData.put(Integer.valueOf(3), StringUtils.leftPad(toDate, 8, "0"));
     this.OAM.put(Integer.valueOf(117), this.limitingTransactionsData);
   }
 
   
   public void setNumOfRecords(String numOfRecords) {
     this.limitingTransactionsData.put(Integer.valueOf(4), StringUtils.leftPad(numOfRecords, 3, "0"));
     this.OAM.put(Integer.valueOf(117), this.limitingTransactionsData);
   }
 
   
   public void setSegmentNumber(String segmentNumber) {
     this.limitingTransactionsData.put(Integer.valueOf(5), StringUtils.leftPad(segmentNumber, 3, "0"));
     this.OAM.put(Integer.valueOf(117), this.limitingTransactionsData);
   }
 
   
   public void setCutOffDate(String cutOffDate) {
     this.limitingTransactionsData.put(Integer.valueOf(6), StringUtils.leftPad(cutOffDate, 7, "0"));
     this.OAM.put(Integer.valueOf(117), this.limitingTransactionsData);
   }
 
   
   public void setTransaction(String transaction) {
     this.transactionCollectionsData.put(Integer.valueOf(2), LLLVar(transaction));
     this.OAM.put(Integer.valueOf(118), this.transactionCollectionsData);
   }
 
   
   public void setTransactions(String transactions) {
     this.transactionCollectionsData.put(Integer.valueOf(3), LLLLVar(transactions));
     this.OAM.put(Integer.valueOf(118), this.transactionCollectionsData);
   }
 
   
   public void setMoreTransactions(String moreTransactions) {
     this.transactionCollectionsData.put(Integer.valueOf(4), moreTransactions);
     this.OAM.put(Integer.valueOf(118), this.transactionCollectionsData);
   }
 
   
   public void setLimitMap(String limitMap) {
     this.generalCollectionsData.put(Integer.valueOf(3), LLLLVar(limitMap));
     this.OAM.put(Integer.valueOf(119), this.generalCollectionsData);
   }
 
   
   public void setBanks(String banks) {
     this.generalCollectionsData.put(Integer.valueOf(4), LLLLVar(banks));
     this.OAM.put(Integer.valueOf(119), this.generalCollectionsData);
   }
 
   
   public void setMessagesMap(String messagesMap) {
     this.generalCollectionsData.put(Integer.valueOf(5), LLLLVar(messagesMap));
     this.OAM.put(Integer.valueOf(119), this.generalCollectionsData);
   }
 
   
   public void setPropertyMap(String propertyMap) {
     this.generalCollectionsData.put(Integer.valueOf(6), LLLLVar(propertyMap));
     this.OAM.put(Integer.valueOf(119), this.generalCollectionsData);
   }
 
   
   public void setAllowedBanksSourceAccount(String allowedBanksSourceAccount) {
     this.generalCollectionsData.put(Integer.valueOf(7), LLLLVar(allowedBanksSourceAccount));
     this.OAM.put(Integer.valueOf(119), this.generalCollectionsData);
   }
 
   
   public void setPocketTaxMap(String pocketTaxMap) {
     this.generalCollectionsData.put(Integer.valueOf(8), LLLLVar(pocketTaxMap));
     this.OAM.put(Integer.valueOf(119), this.generalCollectionsData);
   }
 
   
   public void setCarriers(String carriers) {
     this.generalCollectionsData.put(Integer.valueOf(9), LLLLVar(carriers));
     this.OAM.put(Integer.valueOf(119), this.generalCollectionsData);
   }
 
   
   public void setCustomerData(String customerData) {
     this.generalCollectionsData.put(Integer.valueOf(10), LLLLVar(customerData));
     this.OAM.put(Integer.valueOf(119), this.generalCollectionsData);
   }
 
   
   public void setInstitutions(String institutions) {
     this.generalCollectionsData.put(Integer.valueOf(10), LLLLVar(institutions));
     this.OAM.put(Integer.valueOf(119), this.generalCollectionsData);
   }
 
   
   public void setAllowedBanksDestAccount(String allowedBanksDestAccount) {
     this.generalCollectionsData.put(Integer.valueOf(10), LLLLVar(allowedBanksDestAccount));
     this.OAM.put(Integer.valueOf(119), this.generalCollectionsData);
   }
 
   
   public void setPaymentData(String paymentData) {
     this.generalCollectionsData.put(Integer.valueOf(10), LLLLVar(paymentData));
     this.OAM.put(Integer.valueOf(119), this.generalCollectionsData);
   }
 
   
   public void setProcessingCode(String processingCode) {
     this.additionalISOData.put(Integer.valueOf(2), StringUtils.leftPad(processingCode, 6, "0"));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setRetrievalReferenceNumber(String RetrievalReferenceNumber) {
     this.additionalISOData.put(Integer.valueOf(5), StringUtils.leftPad(RetrievalReferenceNumber, 12, "0"));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setInfoAdicionalCompra(String infoAdicionalCompra) {
     this.additionalISOData.put(Integer.valueOf(6), LLVar(infoAdicionalCompra));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setTransmissionDateAndTime(String transmissionDateAndTime) {
     this.additionalISOData.put(Integer.valueOf(7), LLVar(transmissionDateAndTime));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setSystemTraceAuditNumber(String systemTraceAuditNumber) {
     this.additionalISOData.put(Integer.valueOf(8), LVar(systemTraceAuditNumber));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setSettlementDate(String settlementDate) {
     this.additionalISOData.put(Integer.valueOf(9), settlementDate);
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setCaptureDate(String captureDate) {
     this.additionalISOData.put(Integer.valueOf(10), LVar(captureDate));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setMerchantType(String merchantType) {
     this.additionalISOData.put(Integer.valueOf(11), LVar(merchantType));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setPosEntryMode(String posEntryMode) {
     this.additionalISOData.put(Integer.valueOf(12), LVar(posEntryMode));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setAcquiringInstitutionIdentificationCode(String acquiringInstitutionIdentificationCode) {
     this.additionalISOData.put(Integer.valueOf(13), LLVar(acquiringInstitutionIdentificationCode));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setCardAcceptorTerminalIdentification(String cardAcceptorTerminalIdentification) {
     this.additionalISOData.put(Integer.valueOf(14), LLVar(cardAcceptorTerminalIdentification));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setCardAcceptorNameLoc(String cardAcceptorNameLoc) {
     this.additionalISOData.put(Integer.valueOf(15), LLVar(cardAcceptorNameLoc));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setBase24POSRetailerData(String base24POSRetailerData) {
     this.additionalISOData.put(Integer.valueOf(16), LLVar(base24POSRetailerData));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setTerminalData(String terminalData) {
     this.additionalISOData.put(Integer.valueOf(17), LLVar(terminalData));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setTrack2Data(String track2Data) {
     this.additionalISOData.put(Integer.valueOf(18), StringUtils.leftPad(track2Data, 37, "0"));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setAuthorizeId(String authorizeId) {
     this.additionalISOData.put(Integer.valueOf(19), StringUtils.leftPad(authorizeId, 6, "0"));
     this.OAM.put(Integer.valueOf(120), this.additionalISOData);
   }
 
   
   public void setName(String name) {
     this.customerBasicData.put(Integer.valueOf(2), LLLVar(name));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setCustomerName(String customerName) {
     this.customerBasicData.put(Integer.valueOf(2), LLLVar(customerName));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setUsuario(String usuario) {
     this.customerBasicData.put(Integer.valueOf(2), LLLVar(usuario));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setNombre(String nombre) {
     this.customerBasicData.put(Integer.valueOf(2), LLLVar(nombre));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setSecondName(String secondName) {
     this.customerBasicData.put(Integer.valueOf(3), LLLVar(secondName));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setNombre2(String nombre2) {
     this.customerBasicData.put(Integer.valueOf(3), LLLVar(nombre2));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setFirstLastName(String firstLastName) {
     this.customerBasicData.put(Integer.valueOf(4), LLLVar(firstLastName));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setApellidoPaterno(String apellidoPaterno) {
     this.customerBasicData.put(Integer.valueOf(4), LLLVar(apellidoPaterno));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setSecondLastName(String secondLastName) {
     this.customerBasicData.put(Integer.valueOf(5), LLLVar(secondLastName));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setApellidoMaterno(String apellidoMaterno) {
     this.customerBasicData.put(Integer.valueOf(5), LLLVar(apellidoMaterno));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setAddressStreet(String addressStreet) {
     this.customerBasicData.put(Integer.valueOf(6), LLLVar(addressStreet));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setCalle(String calle) {
     this.customerBasicData.put(Integer.valueOf(6), LLLVar(calle));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setAddressBuildingInternal(String addressBuildingInternal) {
     this.customerBasicData.put(Integer.valueOf(7), LLLVar(addressBuildingInternal));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setNumeroInterior(String numeroInterior) {
     this.customerBasicData.put(Integer.valueOf(7), LLLVar(numeroInterior));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setAddressBuildingExternal(String addressBuildingExternal) {
     this.customerBasicData.put(Integer.valueOf(8), LLLVar(addressBuildingExternal));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setNumeroExterior(String numeroExterior) {
     this.customerBasicData.put(Integer.valueOf(8), LLLVar(numeroExterior));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setAddressAppartment(String addressAppartment) {
     this.customerBasicData.put(Integer.valueOf(9), LLLVar(addressAppartment));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setNumeroDepto(String numeroDepto) {
     this.customerBasicData.put(Integer.valueOf(9), LLLVar(numeroDepto));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setAddressNeighbourhood(String addressNeighbourhood) {
     this.customerBasicData.put(Integer.valueOf(10), LLLVar(addressNeighbourhood));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setColonia(String colonia) {
     this.customerBasicData.put(Integer.valueOf(10), LLLVar(colonia));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setAddressLocation(String addressLocation) {
     this.customerBasicData.put(Integer.valueOf(11), LLLVar(addressLocation));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setMunicipio(String municipio) {
     this.customerBasicData.put(Integer.valueOf(11), LLLVar(municipio));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setAddressState(String addressState) {
     this.customerBasicData.put(Integer.valueOf(12), LLLVar(addressState));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setEstado(String estado) {
     this.customerBasicData.put(Integer.valueOf(12), LLLVar(estado));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setPostalCode(String postalCode) {
     this.customerBasicData.put(Integer.valueOf(13), LLVar(postalCode));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setCodigoPostal(String codigoPostal) {
     this.customerBasicData.put(Integer.valueOf(13), LLVar(codigoPostal));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setDateOfBirth(String dateOfBirth) {
     this.customerBasicData.put(Integer.valueOf(14), LLVar(dateOfBirth));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setFechaNacimiento(String fechaNacimiento) {
     this.customerBasicData.put(Integer.valueOf(14), LLVar(fechaNacimiento));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setMsisdn(String msisdn) {
     this.customerBasicData.put(Integer.valueOf(15), LLLVar(msisdn));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setMSISDN(String MSISDN) {
     this.customerBasicData.put(Integer.valueOf(15), LLLVar(MSISDN));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setEmail(String email) {
     this.customerBasicData.put(Integer.valueOf(16), LLLVar(email));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setEmailId(String emailId) {
     this.customerBasicData.put(Integer.valueOf(16), LLLVar(emailId));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setEmailed(String emailed) {
     this.customerBasicData.put(Integer.valueOf(16), LLLVar(emailed));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setFundingAccount(String fundingAccount) {
     this.customerBasicData.put(Integer.valueOf(17), LLVar(fundingAccount));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setNumeroCuenta(String numeroCuenta) {
     this.customerBasicData.put(Integer.valueOf(17), LLVar(numeroCuenta));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setRfc(String rfc) {
     this.customerBasicData.put(Integer.valueOf(18), LLVar(rfc));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setRFC(String rfc) {
     this.customerBasicData.put(Integer.valueOf(18), LLVar(rfc));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setNotificationMethod(String notificationMethod) {
     this.customerBasicData.put(Integer.valueOf(19), LLVar(notificationMethod));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setMetodoNotificacion(String metodoNotificacion) {
     this.customerBasicData.put(Integer.valueOf(19), LLVar(metodoNotificacion));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setCardNumber(String cardNumber) {
     this.customerBasicData.put(Integer.valueOf(20), StringUtils.leftPad(cardNumber, 16, "0"));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setNumeroTarjeta(String numeroTarjeta) {
     this.customerBasicData.put(Integer.valueOf(20), StringUtils.leftPad(numeroTarjeta, 16, "0"));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setCustomerNumber(String customerNumber) {
     this.customerBasicData.put(Integer.valueOf(21), StringUtils.leftPad(customerNumber, 12, "0"));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setBankCustomerNumber(String bankCustomerNumber) {
     this.customerBasicData.put(Integer.valueOf(21), StringUtils.leftPad(bankCustomerNumber, 12, "0"));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setIdType(String idType) {
     this.customerBasicData.put(Integer.valueOf(22), idType);
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setDescripcionIdentificacionId(String descripcionIdentificacionId) {
     this.customerBasicData.put(Integer.valueOf(22), descripcionIdentificacionId);
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setIdNumber(String idNumber) {
     this.customerBasicData.put(Integer.valueOf(23), LLVar(idNumber));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setValorIdentificacion(String valorIdentificacion) {
     this.customerBasicData.put(Integer.valueOf(23), LLVar(valorIdentificacion));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setGender(String gender) {
     this.customerBasicData.put(Integer.valueOf(24), gender);
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setGenero(String genero) {
     this.customerBasicData.put(Integer.valueOf(24), genero);
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setSexo(String sexo) {
     this.customerBasicData.put(Integer.valueOf(24), sexo);
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setBirthStateCode(String birthStateCode) {
     this.customerBasicData.put(Integer.valueOf(25), LLVar(birthStateCode));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setCodigoEntidadNacimiento(String codigoEntidadNacimiento) {
     this.customerBasicData.put(Integer.valueOf(25), LLVar(codigoEntidadNacimiento));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setEntidadFederativa(String entidadFederativa) {
     this.customerBasicData.put(Integer.valueOf(25), LLVar(entidadFederativa));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setBirthState(String birthState) {
     this.customerBasicData.put(Integer.valueOf(26), LLVar(birthState));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setEntidadNacimiento(String entidadNacimiento) {
     this.customerBasicData.put(Integer.valueOf(26), LLVar(entidadNacimiento));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setVirtualFileNumber(String virtualFileNumber) {
     this.customerBasicData.put(Integer.valueOf(27), LLVar(virtualFileNumber));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setCarrier(String carrier) {
     this.customerBasicData.put(Integer.valueOf(28), StringUtils.leftPad(carrier, 4, "0"));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setCarrierId(String carrierId) {
     this.customerBasicData.put(Integer.valueOf(28), StringUtils.leftPad(carrierId, 4, "0"));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setCurp(String curp) {
     this.customerBasicData.put(Integer.valueOf(29), LLVar(curp));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setCURP(String CURP) {
     this.customerBasicData.put(Integer.valueOf(29), LLVar(CURP));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setRenapoStatus(String renapoStatus) {
     this.customerBasicData.put(Integer.valueOf(30), StringUtils.leftPad(renapoStatus, 3, "0"));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setRenapoValidationDate(String renapoValidationDate) {
     this.customerBasicData.put(Integer.valueOf(31), LLVar(renapoValidationDate));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setRenapoValidationCounter(String renapoValidationCounter) {
     this.customerBasicData.put(Integer.valueOf(32), StringUtils.leftPad(renapoValidationCounter, 2, "0"));
     this.OAM.put(Integer.valueOf(121), this.customerBasicData);
   }
 
   
   public void setCustomerStatus(String customerStatus) {
     this.additionalCustomerData.put(Integer.valueOf(2), StringUtils.leftPad(customerStatus, 2, "0"));
     this.OAM.put(Integer.valueOf(122), this.additionalCustomerData);
   }
 
   
   public void setEstatusCuenta(String estatusCuenta) {
     this.additionalCustomerData.put(Integer.valueOf(2), StringUtils.leftPad(estatusCuenta, 2, "0"));
     this.OAM.put(Integer.valueOf(122), this.additionalCustomerData);
   }
 
   
   public void setRegistrationLevel(String registrationLevel) {
     this.additionalCustomerData.put(Integer.valueOf(3), StringUtils.leftPad(registrationLevel, 2, "0"));
     this.OAM.put(Integer.valueOf(122), this.additionalCustomerData);
   }
 
   
   public void setRegistrationDate(String registrationDate) {
     this.additionalCustomerData.put(Integer.valueOf(4), StringUtils.leftPad(registrationDate, 15, "0"));
     this.OAM.put(Integer.valueOf(122), this.additionalCustomerData);
   }
 
   
   public void setRetirementReason(String retirementReason) {
     this.additionalCustomerData.put(Integer.valueOf(5), StringUtils.leftPad(retirementReason, 2, "0"));
     this.OAM.put(Integer.valueOf(122), this.additionalCustomerData);
   }
 
   
   public void setRetirementDate(String retirementDate) {
     this.additionalCustomerData.put(Integer.valueOf(6), StringUtils.leftPad(retirementDate, 15, "0"));
     this.OAM.put(Integer.valueOf(122), this.additionalCustomerData);
   }
 
   
   public void setAssociationType(String associationType) {
     this.additionalCustomerData.put(Integer.valueOf(7), associationType);
     this.OAM.put(Integer.valueOf(122), this.additionalCustomerData);
   }
 
   
   public void setHasCardHistory(String hasCardHistory) {
     this.additionalCustomerData.put(Integer.valueOf(8), hasCardHistory);
     this.OAM.put(Integer.valueOf(122), this.additionalCustomerData);
   }
 
   
   public void setLocks(String locks) {
     this.additionalCustomerData.put(Integer.valueOf(9), LLLVar(locks));
     this.OAM.put(Integer.valueOf(122), this.additionalCustomerData);
   }
 
   
   public void setLanguage(String language) {
     this.additionalCustomerData.put(Integer.valueOf(10), LLVar(language));
     this.OAM.put(Integer.valueOf(122), this.additionalCustomerData);
   }
 
   
   public void setTimeZone(String timeZone) {
     this.additionalCustomerData.put(Integer.valueOf(11), LLVar(timeZone));
     this.OAM.put(Integer.valueOf(122), this.additionalCustomerData);
   }
 
   
   public void setRemarks(String remarks) {
     this.additionalCustomerData.put(Integer.valueOf(12), LLLVar(remarks));
     this.OAM.put(Integer.valueOf(122), this.additionalCustomerData);
   }
 
   
   public void setEsRegistro(String esRegistro) {
     this.additionalCustomerRegistrationData.put(Integer.valueOf(2), esRegistro);
     this.OAM.put(Integer.valueOf(123), this.additionalCustomerRegistrationData);
   }
 
   
   public void setIdUsuarioCaptura(String idUsuarioCaptura) {
     this.additionalCustomerRegistrationData.put(Integer.valueOf(3), LVar(idUsuarioCaptura));
     this.OAM.put(Integer.valueOf(123), this.additionalCustomerRegistrationData);
   }
 
   
   public void setTipoDeApertura(String tipoDeApertura) {
     this.additionalCustomerRegistrationData.put(Integer.valueOf(4), tipoDeApertura);
     this.OAM.put(Integer.valueOf(123), this.additionalCustomerRegistrationData);
   }
 
   
   public void setClave(String clave) {
     this.additionalCustomerRegistrationData.put(Integer.valueOf(5), StringUtils.leftPad(clave, 10, "0"));
     this.OAM.put(Integer.valueOf(123), this.additionalCustomerRegistrationData);
   }
 
   
   public void setNombreEmpleado(String nombreEmpleado) {
     this.additionalCustomerRegistrationData.put(Integer.valueOf(6), LLLVar(nombreEmpleado));
     this.OAM.put(Integer.valueOf(123), this.additionalCustomerRegistrationData);
   }
 
   
   public void setIdAsesor(String idAsesor) {
     this.additionalCustomerRegistrationData.put(Integer.valueOf(7), LVar(idAsesor));
     this.OAM.put(Integer.valueOf(123), this.additionalCustomerRegistrationData);
   }
 
   
   public void setIdDomicilioPersona(String idDomicilioPersona) {
     this.additionalCustomerRegistrationData.put(Integer.valueOf(8), LVar(idDomicilioPersona));
     this.OAM.put(Integer.valueOf(123), this.additionalCustomerRegistrationData);
   }
 
   
   public void setIdCustomerNumber(String IdCustomerNumber) {
     this.additionalCustomerRegistrationData.put(Integer.valueOf(9), StringUtils.leftPad(IdCustomerNumber, 12, "0"));
     this.OAM.put(Integer.valueOf(123), this.additionalCustomerRegistrationData);
   }
 
   
   public void setIdPersona(String IdPersona) {
     this.additionalCustomerRegistrationData.put(Integer.valueOf(10), StringUtils.leftPad(IdPersona, 9, "0"));
     this.OAM.put(Integer.valueOf(123), this.additionalCustomerRegistrationData);
   }
 
   
   public void setBalance(String balance) {
     balance = validarMonto(balance);
     this.customerBalanceData.put(Integer.valueOf(2), balance);
     this.OAM.put(Integer.valueOf(124), this.customerBalanceData);
   }
 
   
   public void setAvailableBalance(String availableBalance) {
     availableBalance = validarMonto(availableBalance);
     this.customerBalanceData.put(Integer.valueOf(3), availableBalance);
     this.OAM.put(Integer.valueOf(124), this.customerBalanceData);
   }
 
   
   public void setReservedBalance(String reservedBalance) {
     reservedBalance = validarMonto(reservedBalance);
     this.customerBalanceData.put(Integer.valueOf(4), reservedBalance);
     this.OAM.put(Integer.valueOf(124), this.customerBalanceData);
   }
 
   
   public void setClabe(String clabe) {
     this.customerSVAInfoData.put(Integer.valueOf(2), StringUtils.leftPad(clabe, 18, "0"));
     this.OAM.put(Integer.valueOf(125), this.customerSVAInfoData);
   }
 
   
   public void setCLABE(String clabe) {
     this.customerSVAInfoData.put(Integer.valueOf(2), StringUtils.leftPad(clabe, 18, "0"));
     this.OAM.put(Integer.valueOf(125), this.customerSVAInfoData);
   }
 
   
   public void setSvaAccountNumber(String svaAccountNumber) {
     this.customerSVAInfoData.put(Integer.valueOf(3), StringUtils.leftPad(svaAccountNumber, 11, "0"));
     this.OAM.put(Integer.valueOf(125), this.customerSVAInfoData);
   }
 
   
   public void setAccountNumber(String accountNumber) {
     this.customerSVAInfoData.put(Integer.valueOf(3), StringUtils.leftPad(accountNumber, 11, "0"));
     this.OAM.put(Integer.valueOf(125), this.customerSVAInfoData);
   }
 
   
   public void setMsisdnReception(String msisdnReception) {
     this.customerSVAInfoData.put(Integer.valueOf(4), StringUtils.leftPad(msisdnReception, 12, "0"));
     this.OAM.put(Integer.valueOf(125), this.customerSVAInfoData);
   }
 
   
   public void setReceptionMSISDN(String receptionMSISDN) {
     this.customerSVAInfoData.put(Integer.valueOf(4), StringUtils.leftPad(receptionMSISDN, 12, "0"));
     this.OAM.put(Integer.valueOf(125), this.customerSVAInfoData);
   }
 
   
   public void setNumCelularSPEI(String numCelularSPEI) {
     this.customerSVAInfoData.put(Integer.valueOf(4), StringUtils.leftPad(numCelularSPEI, 12, "0"));
     this.OAM.put(Integer.valueOf(125), this.customerSVAInfoData);
   }
 
   
   public void setBankCode(String bankCode) {
     this.customerSVAInfoData.put(Integer.valueOf(5), LLVar(bankCode));
     this.OAM.put(Integer.valueOf(125), this.customerSVAInfoData);
   }
 
   
   public void setHeader(String header) {
     this.header = header;
   }
 
   
   public void setMti(String mti) {
     this.mti = mti;
   }
 
 
   
   public String getIso() {
     try {
       validaciones();
       this.OAMBuilder.append(this.header);
       this.OAMBuilder.append(this.mti);
       
       String[] bitmapOAM = this.tool.getArrayBitmAP(128);
       for (Map.Entry<Integer, Object> entry : this.OAM.entrySet()) {
         
         int position = Integer.parseInt(((Integer)entry.getKey()).toString());
         bitmapOAM[position - 1] = "1";
         if (position > 64) {
           
           bitmapOAM[0] = "1";
           this.bitmapSec = true;
           if (position > 105) {
             this.request.append(getIsoFromMap((Map<Integer, String>)entry.getValue(), position)); continue;
           } 
           this.request.append(entry.getValue());
           
           continue;
         } 
         
         this.request.append(entry.getValue());
       } 
       
       if (this.bitmapSec) {
         this.OAMBuilder.append(this.tool.convertBinaryToHexa(this.tool.getBitmapFields(bitmapOAM)));
       } else {
         this.OAMBuilder.append(this.tool.convertBinaryToHexa(this.tool.getBitmapFields(bitmapOAM).substring(0, 64)));
       } 
       this.OAMBuilder.append(this.request);
       return this.OAMBuilder.toString();
     }
     catch (Exception exception) {
       return null;
     } 
   }
   
   public void validaciones() {
     if (this.serviceName.equals("setSVABalance")) {
       if (this.amount.contains("-")) {
         
         this.amount = this.amount.replace("-", "");
         setAmount(this.amount);
         setIdType("n");
       }
       else {
         
         setIdType("p");
       } 
     }
   }
 
   
   public String validarMonto(String samount) {
     String decimales = "";
     int traePunto = samount.indexOf('.');
     String[] arreglo = samount.split("\\.");
     if (traePunto != -1) {
       decimales = arreglo[1];
     }
     while (decimales.length() < 2) {
       decimales = String.valueOf(decimales) + "0";
     }
     samount = arreglo[0];
     samount = String.valueOf(samount) + decimales;
     while (samount.length() < 12) {
       samount = "0" + samount;
     }
     return samount;
   }
 
   
   public String LVar(String cadena) {
     String size = String.valueOf(cadena.length());
     return String.valueOf(size) + cadena;
   }
 
   
   public String LLVar(String cadena) {
     String size = String.valueOf(cadena.length());
     if (Integer.parseInt(size) < 10) {
       size = "0" + size;
     }
     return String.valueOf(size) + cadena;
   }
 
   
   public String LLLVar(String cadena) {
     String size = String.valueOf(cadena.length());
     if (Integer.parseInt(size) < 10) {
       size = "00" + size;
     } else if (Integer.parseInt(size) < 100) {
       size = "0" + size;
     } 
     return String.valueOf(size) + cadena;
   }
 
   
   public String LLLLVar(String cadena) {
     String size = String.valueOf(cadena.length());
     if (Integer.parseInt(size) < 10) {
       size = "000" + size;
     } else if (Integer.parseInt(size) < 100) {
       size = "00" + size;
     } else if (Integer.parseInt(size) < 1000) {
       size = "0" + size;
     } 
     return String.valueOf(size) + cadena;
   }
 
   
   public String LLLLLVar(String cadena) {
     String size = String.valueOf(cadena.length());
     if (Integer.parseInt(size) < 10) {
       size = "0000" + size;
     } else if (Integer.parseInt(size) < 100) {
       size = "000" + size;
     } else if (Integer.parseInt(size) < 1000) {
       size = "00" + size;
     } else if (Integer.parseInt(size) < 10000) {
       size = "0" + size;
     } 
     return String.valueOf(size) + cadena;
   }
 
   
   public String getDateAuthentic(String epochtime) {
     Date date = new Date(Long.valueOf(epochtime).longValue());
     DateFormat format = new SimpleDateFormat("MMddHHmmss");
     String formatted = format.format(date);
     return formatted;
   }
 
 
   
   public String stringToHex(String input) throws UnsupportedEncodingException {
     if (input == null) {
       return "";
     }
     return asHex(input.getBytes());
   }
 
   
   private String asHex(byte[] buf) {
     char[] chars = new char[2 * buf.length];
     for (int i = 0; i < buf.length; i++) {
       
       chars[2 * i] = this.HEX_CHARS[(buf[i] & 0xF0) >>> 4];
       chars[2 * i + 1] = this.HEX_CHARS[buf[i] & 0xF];
     } 
     return new String(chars);
   }
 
   
   private String getIsoFromMap(Map<Integer, String> mapBitmap, int position) {
     int tamBitamp = 0;
     switch (position) {
       
       case 106:
       case 107:
       case 108:
       case 109:
       case 110:
       case 111:
       case 112:
       case 113:
       case 114:
       case 122:
       case 123:
         tamBitamp = 16;
         break;
       case 115:
       case 116:
       case 117:
       case 118:
       case 124:
       case 125:
         tamBitamp = 8;
         break;
       case 119:
       case 120:
       case 121:
         tamBitamp = 32; break;
     } 
     StringBuilder fields = new StringBuilder();
     StringBuilder field = new StringBuilder();
     String[] bitmap = this.tool.getArrayBitmAP(tamBitamp);
     for (Map.Entry<Integer, String> entry : mapBitmap.entrySet()) {
       
       bitmap[Integer.parseInt(((Integer)entry.getKey()).toString()) - 1] = "1";
       fields.append(entry.getValue());
     } 
     field.append(this.tool.convertBinaryToHexa(this.tool.getBitmapFields(bitmap)));
     field.append(fields);
     return field.toString();
   }
 }


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\authentic\DTORequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */