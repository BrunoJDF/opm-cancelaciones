 package modulo.authentic;

 import java.io.IOException;
 import java.util.List;
 import java.util.Map;
 
 
 public class DTOResponse
 {
   private String accessMethod;
   private String accountNumber;
   private String accountNumberType;
   private String addressAppartment;
   private String addressBuildingExternal;
   private String addressBuildingInternal;
   private String addressLocation;
   private String addressNeighbourhood;
   private String addressState;
   private String addressStreet;
   private List<String> allowedBanksDestAccount;
   private List<String> allowedBanksSourceAccount;
   private String amount;
   private String amountThreshold;
   private String auditNumber;
   private String availableBalance;
   private String balance;
   private String bankId;
   private String branchId;
   private String cardAcceptorTerminalId;
   private String cardAcceptorTerminalIdNameLoc;
   private String cardNumber;
   private String CLABE;
   private String codigoRastreo;
   private String comment;
   private String commissionPayer;
   private String confirmPin;
   private String corresponsalId;
   private String countryCode;
   private String currency;
   private String curp;
   private String customerData;
   private String customerIdentifier;
   private String customerName;
   private String customerNumber;
   private String customerStatus;
   private String dateOfBirth;
   private String descripcionError;
   private String destAccountId;
   private String destAccountIdType;
   private String destAvailableBalance;
   private String destBalance;
   private String destBankId;
   private String destEmail;
   private String destFeeAmount;
   private String destFeeVatAmount;
   private String destMsisdn;
   private String destRateOfTax;
   private String destRfc;
   private String destTotalFeeAmount;
   private String email;
   private String error;
   private String errorDescription;
   private String executiveId;
   private String externalTransactionId;
   private String fee;
   private String fechaValidacionRenapo;
   private String firstLastName;
   private String folio;
   private String folioTransaccion;
   private String fromDate;
   private String fundingAccount;
   private String identifierType;
   private String idTransaccion;
   private String idTransaccionReverso;
   private String isPinLocked;
   private String locks;
   private String minAmount;
   private String moreTransactions;
   private String mpsTransactionId;
   private String msisdn;
   private String name;
   private String newPin;
   private String notificationMethod;
   private String numCelular;
   private String numeroTarjeta;
   private String numOfRecords;
   private String officeId;
   private String originalAuditNumber;
   private String originalMpsTransactionId;
   private String originalOriginatorTransactionId;
   private String originatorTransactionId;
   private String otp;
   private String parameterName;
   private String paymentData;
   private String pendingTaxAmount;
   private String physicalBoxId;
   private String physicalBoxIdNameLoc;
   private String pin;
   private String pinIndicator;
   private String pinLockReason;
   private String pocketTaxMap;
   private String postalCode;
   private String precio;
   private String rateOfTax;
   private String reason;
   private Map<String, String> references;
   private String registrationDate;
   private String registrationLevel;
   private String reservedBalance;
   private String response;
   private String responseCode;
   private String responseDescripcion;
   private String resultado;
   private String retirementDate;
   private String retirementReason;
   private String returnCode;
   private String rfc;
   private String secondLastName;
   private String segmentNumber;
   private String settlementAccountId;
   private String settlementAccountIdType;
   private String sourceAccount;
   private String sourceAccountId;
   private String sourceAccountIdType;
   private String sourceAvailableBalance;
   private String sourceBalance;
   private String sourceBankId;
   private String sourceEmail;
   private String sourceFeeAmount;
   private String sourceFeeVatAmount;
   private String sourceMsisdn;
   private String sourceRateOfTax;
   private String sourceRfc;
   private String sourceTotalFeeAmount;
   private String speiCode;
   private String statusRenapo;
   private String storeReference;
   private String svaAccountNumber;
   private String systemDate;
   private String tan;
   private String tax;
   private String toDate;
   private String transactionID;
   private String transactionSubtype;
   private String transactionType;
   private String errorCode;
   private String errorDesc;
   private String errorContext;
   private String addressApartment;
   private String emailId;
   private String reserved_balance;
   private String creationTime;
   private String pinDefiend;
   private String lock;
   private String clabe;
   private String hasMoreTransactions;
   private String transaction;
   private String renapoStatus;
   private String renapoValidationDate;
   private String renapoValidationCounter;
   private String remarks;
   private String idType;
   private String idNumber;
   private String gender;
   private String birthState;
   private String hasCardHistory;
   private String municipio;
   private String entidadFederativa;
   private String nombre2;
   private String numeroExterior;
   private String rrn;
   private String bankTransactionId;
   private String UDIValue;
   private String transactions;
   private String msisdnList;
   private String limitMap;
   private String authorizationId;
   private String authentificationResponse;
   private String estimatedAmount;
   private String amountRequired;
   private String addressStateCode;
   private String beneficiario;
   private String descripcionIdentificacionId;
   private String esRegistro;
   private String idAsesor;
   private String idDomicilioPersona;
   private String idPersona;
   private String merchantName;
   private String nombreEmpleado;
   private String referenciaExterna;
   private String referenciaLeyenda;
   private String referenciaNumerica;
   private String virtualFileNumber;
   private String queueName;
   private String asociar;
   private String banks;
   private String receptionMSISDN;
   private String codigoError;
   private String apellidoPaterno;
   private String apellidoMaterno;
   private String nombre;
   private String msisdnReception;
   private String secondName;
   private String ticketList;
   private String ticketsExpirationDate;
   private String messageMap;
   private String messagesMap;
   private String srcSvaAccountNumber;
   private String dstSvaAccountNumber;
   private String createsAnonymous;
   private String urlPdf;
   private String getUrl;
   private String urlXml;
   private String processingCode;
   private String sourceFullName;
   private String carrierId;
   private String fechaNacimiento;
   private String associationType;
   private String carrier;
   private String AuthIdentificationResponse;
   private String settlementDate;
   private String sourceCardNumber;
   private String numeroInterior;
   private String bankCode;
   private String tanExpirationTime;
   private String otpExpirationTime;
   
   public String getCreatesAnonymous() {
     return this.createsAnonymous;
   }
 
   
   public void setCreatesAnonymous(String createsAnonymous) {
     this.createsAnonymous = createsAnonymous;
   }
 
   
   public String getPaymentData() {
     return this.paymentData;
   }
 
   
   public void setPaymentData(String paymentData) {
     this.paymentData = paymentData;
   }
 
   
   public String getDstSvaAccountNumber() {
     return this.dstSvaAccountNumber;
   }
 
   
   public void setDstSvaAccountNumber(String dstSvaAccountNumber) {
     this.dstSvaAccountNumber = dstSvaAccountNumber;
   }
 
   
   public String getSrcSvaAccountNumber() {
     return this.srcSvaAccountNumber;
   }
 
   
   public void setSrcSvaAccountNumber(String srcSvaAccountNumber) {
     this.srcSvaAccountNumber = srcSvaAccountNumber;
   }
 
   
   public String getMessagesMap() {
     return this.messagesMap;
   }
 
   
   public void setMessagesMap(String messagesMap) {
     this.messagesMap = messagesMap;
   }
 
   
   public String getCarrierId() {
     return this.carrierId;
   }
 
   
   public void setCarrierId(String carrierId) {
     this.carrierId = carrierId;
   }
 
   
   public String getMessageMap() {
     return this.messageMap;
   }
 
   
   public void setMessageMap(String messageMap) {
     this.messageMap = messageMap;
   }
 
   
   public String getTicketsExpirationDate() {
     return this.ticketsExpirationDate;
   }
 
   
   public void setTicketsExpirationDate(String ticketsExpirationDate) {
     this.ticketsExpirationDate = ticketsExpirationDate;
   }
 
   
   public String getTicketList() {
     return this.ticketList;
   }
 
   
   public void setTicketList(String ticketList) {
     this.ticketList = ticketList;
   }
 
   
   public String getSecondName() {
     return this.secondName;
   }
 
   
   public void setSecondName(String secondName) {
     this.secondName = secondName;
   }
 
   
   public String getMsisdnReception() {
     return this.msisdnReception;
   }
 
   
   public void setMsisdnReception(String msisdnReception) {
     this.msisdnReception = msisdnReception;
   }
 
   
   public String getApellidoPaterno() {
     return this.apellidoPaterno;
   }
 
   
   public void setApellidoPaterno(String apellidoPaterno) {
     this.apellidoPaterno = apellidoPaterno;
   }
 
   
   public String getApellidoMaterno() {
     return this.apellidoMaterno;
   }
 
   
   public void setApellidoMaterno(String apellidoMaterno) {
     this.apellidoMaterno = apellidoMaterno;
   }
 
   
   public String getNombre() {
     return this.nombre;
   }
 
   
   public void setNombre(String nombre) {
     this.nombre = nombre;
   }
 
   
   public String getFechaNacimiento() {
     return this.fechaNacimiento;
   }
 
   
   public void setFechaNacimiento(String fechaNacimiento) {
     this.fechaNacimiento = fechaNacimiento;
   }
 
   
   public String getCodigoError() {
     return this.codigoError;
   }
 
   
   public void setCodigoError(String codigoError) {
     this.codigoError = codigoError;
   }
 
   
   public String getReceptionMSISDN() {
     return this.receptionMSISDN;
   }
 
   
   public void setReceptionMSISDN(String receptionMSISDN) {
     this.receptionMSISDN = receptionMSISDN;
   }
 
   
   public String getCarrier() {
     return this.carrier;
   }
 
   
   public void setCarrier(String carrier) {
     this.carrier = carrier;
   }
 
   
   public String getAssociationType() {
     return this.associationType;
   }
 
   
   public void setAssociationType(String associationType) {
     this.associationType = associationType;
   }
 
   
   public String getBanks() {
     return this.banks;
   }
 
   
   public void setBanks(String banks) {
     this.banks = banks;
   }
 
   
   public String getAsociar() {
     return this.asociar;
   }
 
   
   public void setAsociar(String asociar) {
     this.asociar = asociar;
   }
 
   
   public String getQueueName() {
     return this.queueName;
   }
 
   
   public void setQueueName(String queueName) {
     this.queueName = queueName;
   }
 
   
   public String getVirtualFileNumber() {
     return this.virtualFileNumber;
   }
 
   
   public void setVirtualFileNumber(String virtualFileNumber) {
     this.virtualFileNumber = virtualFileNumber;
   }
 
   
   public String getReferenciaNumerica() {
     return this.referenciaNumerica;
   }
 
   
   public void setReferenciaNumerica(String referenciaNumerica) {
     this.referenciaNumerica = referenciaNumerica;
   }
 
   
   public String getReferenciaLeyenda() {
     return this.referenciaLeyenda;
   }
 
   
   public void setReferenciaLeyenda(String referenciaLeyenda) {
     this.referenciaLeyenda = referenciaLeyenda;
   }
 
   
   public String getReferenciaExterna() {
     return this.referenciaExterna;
   }
 
   
   public void setReferenciaExterna(String referenciaExterna) {
     this.referenciaExterna = referenciaExterna;
   }
 
   
   public String getNombreEmpleado() {
     return this.nombreEmpleado;
   }
 
   
   public void setNombreEmpleado(String nombreEmpleado) {
     this.nombreEmpleado = nombreEmpleado;
   }
 
   
   public String getMerchantName() {
     return this.merchantName;
   }
 
   
   public void setMerchantName(String merchantName) {
     this.merchantName = merchantName;
   }
 
   
   public String getIdPersona() {
     return this.idPersona;
   }
 
   
   public void setIdPersona(String idPersona) {
     this.idPersona = idPersona;
   }
 
   
   public String getIdDomicilioPersona() {
     return this.idDomicilioPersona;
   }
 
   
   public void setIdDomicilioPersona(String idDomicilioPersona) {
     this.idDomicilioPersona = idDomicilioPersona;
   }
 
   
   public String getIdAsesor() {
     return this.idAsesor;
   }
 
   
   public void setIdAsesor(String idAsesor) {
     this.idAsesor = idAsesor;
   }
 
   
   public String getEsRegistro() {
     return this.esRegistro;
   }
 
   
   public void setEsRegistro(String esRegistro) {
     this.esRegistro = esRegistro;
   }
 
   
   public String getDescripcionIdentificacionId() {
     return this.descripcionIdentificacionId;
   }
 
   
   public void setDescripcionIdentificacionId(String descripcionIdentificacionId) {
     this.descripcionIdentificacionId = descripcionIdentificacionId;
   }
 
   
   public String getBeneficiario() {
     return this.beneficiario;
   }
 
   
   public void setBeneficiario(String beneficiario) {
     this.beneficiario = beneficiario;
   }
 
   
   public String getAddressStateCode() {
     return this.addressStateCode;
   }
 
   
   public void setAddressStateCode(String addressStateCode) {
     this.addressStateCode = addressStateCode;
   }
 
   
   public String getAmountRequired() {
     return this.amountRequired;
   }
 
   
   public void setAmountRequired(String amountRequired) {
     this.amountRequired = amountRequired;
   }
 
   
   public String getEstimatedAmount() {
     return this.estimatedAmount;
   }
 
   
   public void setEstimatedAmount(String estimatedAmount) {
     this.estimatedAmount = estimatedAmount;
   }
 
   
   public String getAuthentificationResponse() {
     return this.authentificationResponse;
   }
 
   
   public void setAuthentificationResponse(String authentificationResponse) {
     this.authentificationResponse = authentificationResponse;
   }
 
   
   public String getAuthIdentificationResponse() {
     return this.AuthIdentificationResponse;
   }
 
   
   public void setAuthIdentificationResponse(String AuthIdentificationResponse) {
     this.AuthIdentificationResponse = AuthIdentificationResponse;
   }
 
   
   public String getSourceCardNumber() {
     return this.sourceCardNumber;
   }
 
   
   public void setSourceCardNumber(String sourceCardNumber) {
     this.sourceCardNumber = sourceCardNumber;
   }
 
   
   public String getSettlementDate() {
     return this.settlementDate;
   }
 
   
   public void setSettlementDate(String settlementDate) {
     this.settlementDate = settlementDate;
   }
 
   
   public String getAuthorizationId() {
     return this.authorizationId;
   }
 
   
   public void setAuthorizationId(String authorizationId) {
     this.authorizationId = authorizationId;
   }
 
   
   public String getLimitMap() {
     return this.limitMap;
   }
 
   
   public void setLimitMap(String limitMap) {
     this.limitMap = limitMap;
   }
 
   
   public String getMsisdnList() {
     return this.msisdnList;
   }
 
   
   public String getTransactions() {
     return this.transactions;
   }
 
   
   public String getUDIValue() {
     return this.UDIValue;
   }
 
   
   public void setUDIValue(String UDIValue) {
     this.UDIValue = UDIValue;
   }
 
   
   public String getBankTransactionId() {
     return this.bankTransactionId;
   }
 
   
   public void setBankTransactionId(String bankTransactionId) {
     this.bankTransactionId = bankTransactionId;
   }
 
   
   public String getRrn() {
     return this.rrn;
   }
 
   
   public void setRrn(String rrn) {
     this.rrn = rrn;
   }
 
   
   public String getOtpExpirationTime() {
     return this.otpExpirationTime;
   }
 
   
   public void setOtpExpirationTime(String otpExpirationTime) {
     this.otpExpirationTime = otpExpirationTime;
   }
 
   
   public String getTanExpirationTime() {
     return this.tanExpirationTime;
   }
 
   
   public void setTanExpirationTime(String tanExpirationTime) {
     this.tanExpirationTime = tanExpirationTime;
   }
 
   
   public String getBankCode() {
     return this.bankCode;
   }
 
   
   public void setBankCode(String bankCode) {
     this.bankCode = bankCode;
   }
 
   
   public String getNumeroExterior() {
     return this.numeroExterior;
   }
 
   
   public void setNumeroExterior(String numeroExterior) {
     this.numeroExterior = numeroExterior;
   }
 
   
   public String getNumeroInterior() {
     return this.numeroInterior;
   }
 
   
   public void setNumeroInterior(String numeroInterior) {
     this.numeroInterior = numeroInterior;
   }
 
   
   public String getNombre2() {
     return this.nombre2;
   }
 
   
   public void setNombre2(String nombre2) {
     this.nombre2 = nombre2;
   }
 
   
   public String getEntidadFederativa() {
     return this.entidadFederativa;
   }
 
   
   public void setEntidadFederativa(String entidadFederativa) {
     this.entidadFederativa = entidadFederativa;
   }
 
   
   public String getMunicipio() {
     return this.municipio;
   }
 
   
   public void setMunicipio(String municipio) {
     this.municipio = municipio;
   }
 
   
   public String getErrorContext() {
     return this.errorContext;
   }
 
   
   public void setErrorContext(String errorContext) {
     this.errorContext = errorContext;
   }
 
   
   public String getTransaction() {
     return this.transaction;
   }
 
   
   public void setTransaction(String transaction) {
     this.transaction = transaction;
   }
 
   
   public String getAddressApartment() {
     return this.addressApartment;
   }
 
   
   public void setAddressApartment(String addressApartment) {
     this.addressApartment = addressApartment;
   }
 
   
   public String getClabe() {
     return this.clabe;
   }
 
   
   public void setClabe(String clabe) {
     this.clabe = clabe;
   }
 
   
   public String getCreationTime() {
     return this.creationTime;
   }
 
   
   public void setCreationTime(String creationTime) {
     this.creationTime = creationTime;
   }
 
   
   public String getEmailId() {
     return this.emailId;
   }
 
   
   public void setEmailId(String emailId) {
     this.emailId = emailId;
   }
 
   
   public String getLock() {
     return this.lock;
   }
 
   
   public void setLock(String lock) {
     this.lock = lock;
   }
 
   
   public String getPinDefiend() {
     return this.pinDefiend;
   }
 
   
   public void setPinDefiend(String pinDefiend) {
     this.pinDefiend = pinDefiend;
   }
 
   
   public String getReserved_balance() {
     return this.reserved_balance;
   }
 
   
   public void setReserved_balance(String reserved_balance) {
     this.reserved_balance = reserved_balance;
   }
 
   
   public String getErrorCode() {
     return this.errorCode;
   }
 
   
   public void setErrorCode(String errorCode) {
     this.errorCode = errorCode;
   }
 
   
   public String getErrorDesc() {
     return this.errorDesc;
   }
 
   
   public void setErrorDesc(String errorDesc) {
     this.errorDesc = errorDesc;
   }
 
   
   public String getCLABE() {
     return this.CLABE;
   }
 
   
   public void setCLABE(String CLABE) {
     this.CLABE = CLABE;
   }
 
   
   public String getCodigoRastreo() {
     return this.codigoRastreo;
   }
 
   
   public void setCodigoRastreo(String codigoRastreo) {
     this.codigoRastreo = codigoRastreo;
   }
 
   
   public String getAccessMethod() {
     return this.accessMethod;
   }
 
   
   public void setAccessMethod(String accessMethod) {
     this.accessMethod = accessMethod;
   }
 
   
   public String getAccountNumber() {
     return this.accountNumber;
   }
 
   
   public void setAccountNumber(String accountNumber) {
     this.accountNumber = accountNumber;
   }
 
   
   public String getAccountNumberType() {
     return this.accountNumberType;
   }
 
   
   public void setAccountNumberType(String accountNumberType) {
     this.accountNumberType = accountNumberType;
   }
 
   
   public String getAddressAppartment() {
     return this.addressAppartment;
   }
 
   
   public void setAddressAppartment(String addressAppartment) {
     this.addressAppartment = addressAppartment;
   }
 
   
   public String getAddressBuildingExternal() {
     return this.addressBuildingExternal;
   }
 
   
   public void setAddressBuildingExternal(String addressBuildingExternal) {
     this.addressBuildingExternal = addressBuildingExternal;
   }
 
   
   public String getAddressBuildingInternal() {
     return this.addressBuildingInternal;
   }
 
   
   public void setAddressBuildingInternal(String addressBuildingInternal) {
     this.addressBuildingInternal = addressBuildingInternal;
   }
 
   
   public String getAddressLocation() {
     return this.addressLocation;
   }
 
   
   public void setAddressLocation(String addressLocation) {
     this.addressLocation = addressLocation;
   }
 
   
   public String getAddressNeighbourhood() {
     return this.addressNeighbourhood;
   }
 
   
   public void setAddressNeighbourhood(String addressNeighbourhood) {
     this.addressNeighbourhood = addressNeighbourhood;
   }
 
   
   public String getAddressState() {
     return this.addressState;
   }
 
   
   public void setAddressState(String addressState) {
     this.addressState = addressState;
   }
 
   
   public String getAddressStreet() {
     return this.addressStreet;
   }
 
   
   public void setAddressStreet(String addressStreet) {
     this.addressStreet = addressStreet;
   }
 
   
   public List<String> getAllowedBanksDestAccount() {
     return this.allowedBanksDestAccount;
   }
 
   
   public void setAllowedBanksDestAccount(List<String> allowedBanksDestAccount) {
     this.allowedBanksDestAccount = allowedBanksDestAccount;
   }
 
   
   public List<String> getAllowedBanksSourceAccount() {
     return this.allowedBanksSourceAccount;
   }
 
   
   public void setAllowedBanksSourceAccount(List<String> allowedBanksSourceAccount) {
     this.allowedBanksSourceAccount = allowedBanksSourceAccount;
   }
 
   
   public String getAmount() {
     return this.amount;
   }
 
   
   public void setAmount(String amount) {
     this.amount = amount;
   }
 
   
   public String getAmountThreshold() {
     return this.amountThreshold;
   }
 
   
   public void setAmountThreshold(String amountThreshold) {
     this.amountThreshold = amountThreshold;
   }
 
   
   public String getAuditNumber() {
     return this.auditNumber;
   }
 
   
   public void setAuditNumber(String auditNumber) {
     this.auditNumber = auditNumber;
   }
 
   
   public String getAvailableBalance() {
     return this.availableBalance;
   }
 
   
   public void setAvailableBalance(String availableBalance) {
     this.availableBalance = availableBalance;
   }
 
   
   public String getBalance() {
     return this.balance;
   }
 
   
   public void setBalance(String balance) {
     this.balance = balance;
   }
 
   
   public String getBankId() {
     return this.bankId;
   }
 
   
   public void setBankId(String bankId) {
     this.bankId = bankId;
   }
 
   
   public String getBranchId() {
     return this.branchId;
   }
 
   
   public void setBranchId(String branchId) {
     this.branchId = branchId;
   }
 
   
   public String getCardAcceptorTerminalId() {
     return this.cardAcceptorTerminalId;
   }
 
   
   public void setCardAcceptorTerminalId(String cardAcceptorTerminalId) {
     this.cardAcceptorTerminalId = cardAcceptorTerminalId;
   }
 
   
   public String getCardAcceptorTerminalIdNameLoc() {
     return this.cardAcceptorTerminalIdNameLoc;
   }
 
   
   public void setCardAcceptorTerminalIdNameLoc(String cardAcceptorTerminalIdNameLoc) {
     this.cardAcceptorTerminalIdNameLoc = cardAcceptorTerminalIdNameLoc;
   }
 
   
   public String getCardNumber() {
     return this.cardNumber;
   }
 
   
   public void setCardNumber(String cardNumber) {
     this.cardNumber = cardNumber;
   }
 
   
   public String getComment() {
     return this.comment;
   }
 
   
   public void setComment(String comment) {
     this.comment = comment;
   }
 
   
   public String getCommissionPayer() {
     return this.commissionPayer;
   }
 
   
   public void setCommissionPayer(String commissionPayer) {
     this.commissionPayer = commissionPayer;
   }
 
   
   public String getConfirmPin() {
     return this.confirmPin;
   }
 
   
   public void setConfirmPin(String confirmPin) {
     this.confirmPin = confirmPin;
   }
 
   
   public String getCorresponsalId() {
     return this.corresponsalId;
   }
 
   
   public void setCorresponsalId(String corresponsalId) {
     this.corresponsalId = corresponsalId;
   }
 
   
   public String getCountryCode() {
     return this.countryCode;
   }
 
   
   public void setCountryCode(String countryCode) {
     this.countryCode = countryCode;
   }
 
   
   public String getCurrency() {
     return this.currency;
   }
 
   
   public void setCurrency(String currency) {
     this.currency = currency;
   }
 
   
   public String getCurp() {
     return this.curp;
   }
 
   
   public void setCurp(String curp) {
     this.curp = curp;
   }
 
   
   public String getCustomerData() {
     return this.customerData;
   }
 
 
   
   public void setCustomerData(String customerData) throws IOException {
     this.customerData = customerData;
   }
 
   
   public String getCustomerIdentifier() {
     return this.customerIdentifier;
   }
 
   
   public void setCustomerIdentifier(String customerIdentifier) {
     this.customerIdentifier = customerIdentifier;
   }
 
   
   public String getCustomerName() {
     return this.customerName;
   }
 
   
   public void setCustomerName(String customerName) {
     this.customerName = customerName;
   }
 
   
   public String getCustomerNumber() {
     return this.customerNumber;
   }
 
   
   public void setCustomerNumber(String customerNumber) {
     this.customerNumber = customerNumber;
   }
 
   
   public String getCustomerStatus() {
     return this.customerStatus;
   }
 
   
   public void setCustomerStatus(String customerStatus) {
     this.customerStatus = customerStatus;
   }
 
   
   public String getDateOfBirth() {
     return this.dateOfBirth;
   }
 
   
   public void setDateOfBirth(String dateOfBirth) {
     this.dateOfBirth = dateOfBirth;
   }
 
   
   public String getDescripcionError() {
     return this.descripcionError;
   }
 
   
   public void setDescripcionError(String descripcionError) {
     this.descripcionError = descripcionError;
   }
 
   
   public String getDestAccountId() {
     return this.destAccountId;
   }
 
   
   public void setDestAccountId(String destAccountId) {
     this.destAccountId = destAccountId;
   }
 
   
   public String getDestAccountIdType() {
     return this.destAccountIdType;
   }
 
   
   public void setDestAccountIdType(String destAccountIdType) {
     this.destAccountIdType = destAccountIdType;
   }
 
   
   public String getDestAvailableBalance() {
     return this.destAvailableBalance;
   }
 
   
   public void setDestAvailableBalance(String destAvailableBalance) {
     this.destAvailableBalance = destAvailableBalance;
   }
 
   
   public String getDestBalance() {
     return this.destBalance;
   }
 
   
   public void setDestBalance(String destBalance) {
     this.destBalance = destBalance;
   }
 
   
   public String getDestBankId() {
     return this.destBankId;
   }
 
   
   public void setDestBankId(String destBankId) {
     this.destBankId = destBankId;
   }
 
   
   public String getDestEmail() {
     return this.destEmail;
   }
 
   
   public void setDestEmail(String destEmail) {
     this.destEmail = destEmail;
   }
 
   
   public String getError() {
     return this.error;
   }
 
   
   public void setError(String error) {
     this.error = error;
   }
 
   
   public String getDestFeeAmount() {
     return this.destFeeAmount;
   }
 
   
   public void setDestFeeAmount(String destFeeAmount) {
     this.destFeeAmount = destFeeAmount;
   }
 
   
   public String getDestFeeVatAmount() {
     return this.destFeeVatAmount;
   }
 
   
   public void setDestFeeVatAmount(String destFeeVatAmount) {
     this.destFeeVatAmount = destFeeVatAmount;
   }
 
   
   public String getDestMsisdn() {
     return this.destMsisdn;
   }
 
   
   public void setDestMsisdn(String destMsisdn) {
     this.destMsisdn = destMsisdn;
   }
 
   
   public String getDestRateOfTax() {
     return this.destRateOfTax;
   }
 
   
   public void setDestRateOfTax(String destRateOfTax) {
     this.destRateOfTax = destRateOfTax;
   }
 
   
   public String getDestRfc() {
     return this.destRfc;
   }
 
   
   public void setDestRfc(String destRfc) {
     this.destRfc = destRfc;
   }
 
   
   public String getDestTotalFeeAmount() {
     return this.destTotalFeeAmount;
   }
 
   
   public void setDestTotalFeeAmount(String destTotalFeeAmount) {
     this.destTotalFeeAmount = destTotalFeeAmount;
   }
 
   
   public String getEmail() {
     return this.email;
   }
 
   
   public void setEmail(String email) {
     this.email = email;
   }
 
   
   public String getErrorDescription() {
     return this.errorDescription;
   }
 
   
   public void setErrorDescription(String errorDescription) {
     this.errorDescription = errorDescription;
   }
 
   
   public String getExecutiveId() {
     return this.executiveId;
   }
 
   
   public void setExecutiveId(String executiveId) {
     this.executiveId = executiveId;
   }
 
   
   public String getExternalTransactionId() {
     return this.externalTransactionId;
   }
 
   
   public void setExternalTransactionId(String externalTransactionId) {
     this.externalTransactionId = externalTransactionId;
   }
 
   
   public String getFee() {
     return this.fee;
   }
 
   
   public void setFee(String fee) {
     this.fee = fee;
   }
 
   
   public String getFechaValidacionRenapo() {
     return this.fechaValidacionRenapo;
   }
 
   
   public void setFechaValidacionRenapo(String fechaValidacionRenapo) {
     this.fechaValidacionRenapo = fechaValidacionRenapo;
   }
 
   
   public String getFirstLastName() {
     return this.firstLastName;
   }
 
   
   public void setFirstLastName(String firstLastName) {
     this.firstLastName = firstLastName;
   }
 
   
   public String getFolio() {
     return this.folio;
   }
 
   
   public void setFolio(String folio) {
     this.folio = folio;
   }
 
   
   public String getFolioTransaccion() {
     return this.folioTransaccion;
   }
 
   
   public void setFolioTransaccion(String folioTransaccion) {
     this.folioTransaccion = folioTransaccion;
   }
 
   
   public String getFromDate() {
     return this.fromDate;
   }
 
   
   public void setFromDate(String fromDate) {
     this.fromDate = fromDate;
   }
 
   
   public String getFundingAccount() {
     return this.fundingAccount;
   }
 
   
   public void setFundingAccount(String fundingAccount) {
     this.fundingAccount = fundingAccount;
   }
 
   
   public String getIdentifierType() {
     return this.identifierType;
   }
 
   
   public void setIdentifierType(String identifierType) {
     this.identifierType = identifierType;
   }
 
   
   public String getIdTransaccion() {
     return this.idTransaccion;
   }
 
   
   public void setIdTransaccion(String idTransaccion) {
     this.idTransaccion = idTransaccion;
   }
 
   
   public String getIdTransaccionReverso() {
     return this.idTransaccionReverso;
   }
 
   
   public void setIdTransaccionReverso(String idTransaccionReverso) {
     this.idTransaccionReverso = idTransaccionReverso;
   }
 
   
   public String getIsPinLocked() {
     return this.isPinLocked;
   }
 
   
   public void setIsPinLocked(String isPinLocked) {
     this.isPinLocked = isPinLocked;
   }
 
   
   public String getLocks() {
     return this.locks;
   }
 
   
   public void setLocks(String locks) {
     this.locks = locks;
   }
 
   
   public String getMinAmount() {
     return this.minAmount;
   }
 
   
   public void setMinAmount(String minAmount) {
     this.minAmount = minAmount;
   }
 
   
   public String getMoreTransactions() {
     return this.moreTransactions;
   }
 
   
   public void setMoreTransactions(String moreTransactions) {
     this.moreTransactions = moreTransactions;
   }
 
   
   public String getMpsTransactionId() {
     return this.mpsTransactionId;
   }
 
   
   public void setMpsTransactionId(String mpsTransactionId) {
     this.mpsTransactionId = mpsTransactionId;
   }
 
   
   public String getMsisdn() {
     return this.msisdn;
   }
 
   
   public void setMsisdn(String msisdn) {
     this.msisdn = msisdn;
   }
 
   
   public String getName() {
     return this.name;
   }
 
   
   public void setName(String name) {
     this.name = name;
   }
 
   
   public String getNewPin() {
     return this.newPin;
   }
 
   
   public void setNewPin(String newPin) {
     this.newPin = newPin;
   }
 
   
   public String getNotificationMethod() {
     return this.notificationMethod;
   }
 
   
   public void setNotificationMethod(String notificationMethod) {
     this.notificationMethod = notificationMethod;
   }
 
   
   public String getNumCelular() {
     return this.numCelular;
   }
 
   
   public void setNumCelular(String numCelular) {
     this.numCelular = numCelular;
   }
 
   
   public String getNumeroTarjeta() {
     return this.numeroTarjeta;
   }
 
   
   public void setNumeroTarjeta(String numeroTarjeta) {
     this.numeroTarjeta = numeroTarjeta;
   }
 
   
   public String getNumOfRecords() {
     return this.numOfRecords;
   }
 
   
   public void setNumOfRecords(String numOfRecords) {
     this.numOfRecords = numOfRecords;
   }
 
   
   public String getOfficeId() {
     return this.officeId;
   }
 
   
   public void setOfficeId(String officeId) {
     this.officeId = officeId;
   }
 
   
   public String getOriginalAuditNumber() {
     return this.originalAuditNumber;
   }
 
   
   public void setOriginalAuditNumber(String originalAuditNumber) {
     this.originalAuditNumber = originalAuditNumber;
   }
 
   
   public String getOriginalMpsTransactionId() {
     return this.originalMpsTransactionId;
   }
 
   
   public void setOriginalMpsTransactionId(String originalMpsTransactionId) {
     this.originalMpsTransactionId = originalMpsTransactionId;
   }
 
   
   public String getOriginalOriginatorTransactionId() {
     return this.originalOriginatorTransactionId;
   }
 
   
   public void setOriginalOriginatorTransactionId(String originalOriginatorTransactionId) {
     this.originalOriginatorTransactionId = originalOriginatorTransactionId;
   }
 
   
   public String getOriginatorTransactionId() {
     return this.originatorTransactionId;
   }
 
   
   public void setOriginatorTransactionId(String originatorTransactionId) {
     this.originatorTransactionId = originatorTransactionId;
   }
 
   
   public String getOtp() {
     return this.otp;
   }
 
   
   public void setOtp(String otp) {
     this.otp = otp;
   }
 
   
   public String getParameterName() {
     return this.parameterName;
   }
 
   
   public void setParameterName(String parameterName) {
     this.parameterName = parameterName;
   }
 
   
   public String getPendingTaxAmount() {
     return this.pendingTaxAmount;
   }
 
   
   public void setPendingTaxAmount(String pendingTaxAmount) {
     this.pendingTaxAmount = pendingTaxAmount;
   }
 
   
   public String getPhysicalBoxId() {
     return this.physicalBoxId;
   }
 
   
   public void setPhysicalBoxId(String physicalBoxId) {
     this.physicalBoxId = physicalBoxId;
   }
 
   
   public String getPhysicalBoxIdNameLoc() {
     return this.physicalBoxIdNameLoc;
   }
 
   
   public void setPhysicalBoxIdNameLoc(String physicalBoxIdNameLoc) {
     this.physicalBoxIdNameLoc = physicalBoxIdNameLoc;
   }
 
   
   public String getPin() {
     return this.pin;
   }
 
   
   public void setPin(String pin) {
     this.pin = pin;
   }
 
   
   public String getPinIndicator() {
     return this.pinIndicator;
   }
 
   
   public void setPinIndicator(String pinIndicator) {
     this.pinIndicator = pinIndicator;
   }
 
   
   public String getPinLockReason() {
     return this.pinLockReason;
   }
 
   
   public void setPinLockReason(String pinLockReason) {
     this.pinLockReason = pinLockReason;
   }
 
   
   public String getPocketTaxMap() {
     return this.pocketTaxMap;
   }
 
   
   public void setPocketTaxMap(String pocketTaxMap) {
     this.pocketTaxMap = pocketTaxMap;
   }
 
   
   public String getPostalCode() {
     return this.postalCode;
   }
 
   
   public void setPostalCode(String postalCode) {
     this.postalCode = postalCode;
   }
 
   
   public String getPrecio() {
     return this.precio;
   }
 
   
   public void setPrecio(String precio) {
     this.precio = precio;
   }
 
   
   public String getRateOfTax() {
     return this.rateOfTax;
   }
 
   
   public void setRateOfTax(String rateOfTax) {
     this.rateOfTax = rateOfTax;
   }
 
   
   public String getReason() {
     return this.reason;
   }
 
   
   public void setReason(String reason) {
     this.reason = reason;
   }
 
   
   public Map<String, String> getReferences() {
     return this.references;
   }
 
   
   public void setReferences(Map<String, String> references) {
     this.references = references;
   }
 
   
   public String getRegistrationDate() {
     return this.registrationDate;
   }
 
   
   public void setRegistrationDate(String registrationDate) {
     this.registrationDate = registrationDate;
   }
 
   
   public String getRegistrationLevel() {
     return this.registrationLevel;
   }
 
   
   public void setRegistrationLevel(String registrationLevel) {
     this.registrationLevel = registrationLevel;
   }
 
   
   public String getReservedBalance() {
     return this.reservedBalance;
   }
 
   
   public void setReservedBalance(String reservedBalance) {
     this.reservedBalance = reservedBalance;
   }
 
   
   public String getResponse() {
     return this.response;
   }
 
   
   public void setResponse(String response) {
     this.response = response;
   }
 
   
   public String getResponseCode() {
     return this.responseCode;
   }
 
   
   public void setResponseCode(String responseCode) {
     this.responseCode = responseCode;
   }
 
   
   public String getResponseDescripcion() {
     return this.responseDescripcion;
   }
 
   
   public void setResponseDescripcion(String responseDescripcion) {
     this.responseDescripcion = responseDescripcion;
   }
 
   
   public String getResultado() {
     return this.resultado;
   }
 
   
   public void setResultado(String resultado) {
     this.resultado = resultado;
   }
 
   
   public String getRetirementDate() {
     return this.retirementDate;
   }
 
   
   public void setRetirementDate(String retirementDate) {
     this.retirementDate = retirementDate;
   }
 
   
   public String getRetirementReason() {
     return this.retirementReason;
   }
 
   
   public void setRetirementReason(String retirementReason) {
     this.retirementReason = retirementReason;
   }
 
   
   public String getReturnCode() {
     return this.returnCode;
   }
 
   
   public void setReturnCode(String returnCode) {
     this.returnCode = returnCode;
   }
 
   
   public String getRfc() {
     return this.rfc;
   }
 
   
   public void setRfc(String rfc) {
     this.rfc = rfc;
   }
 
   
   public String getSecondLastName() {
     return this.secondLastName;
   }
 
   
   public void setSecondLastName(String secondLastName) {
     this.secondLastName = secondLastName;
   }
 
   
   public String getSegmentNumber() {
     return this.segmentNumber;
   }
 
   
   public void setSegmentNumber(String segmentNumber) {
     this.segmentNumber = segmentNumber;
   }
 
   
   public String getSettlementAccountId() {
     return this.settlementAccountId;
   }
 
   
   public void setSettlementAccountId(String settlementAccountId) {
     this.settlementAccountId = settlementAccountId;
   }
 
   
   public String getSettlementAccountIdType() {
     return this.settlementAccountIdType;
   }
 
   
   public void setSettlementAccountIdType(String settlementAccountIdType) {
     this.settlementAccountIdType = settlementAccountIdType;
   }
 
   
   public String getSourceAccount() {
     return this.sourceAccount;
   }
 
   
   public void setSourceAccount(String sourceAccount) {
     this.sourceAccount = sourceAccount;
   }
 
   
   public String getSourceAccountId() {
     return this.sourceAccountId;
   }
 
   
   public void setSourceAccountId(String sourceAccountId) {
     this.sourceAccountId = sourceAccountId;
   }
 
   
   public String getSourceAccountIdType() {
     return this.sourceAccountIdType;
   }
 
   
   public void setSourceAccountIdType(String sourceAccountIdType) {
     this.sourceAccountIdType = sourceAccountIdType;
   }
 
   
   public String getSourceAvailableBalance() {
     return this.sourceAvailableBalance;
   }
 
   
   public void setSourceAvailableBalance(String sourceAvailableBalance) {
     this.sourceAvailableBalance = sourceAvailableBalance;
   }
 
   
   public String getSourceBalance() {
     return this.sourceBalance;
   }
 
   
   public void setSourceBalance(String sourceBalance) {
     this.sourceBalance = sourceBalance;
   }
 
   
   public String getSourceBankId() {
     return this.sourceBankId;
   }
 
   
   public void setSourceBankId(String sourceBankId) {
     this.sourceBankId = sourceBankId;
   }
 
   
   public String getSourceEmail() {
     return this.sourceEmail;
   }
 
   
   public void setSourceEmail(String sourceEmail) {
     this.sourceEmail = sourceEmail;
   }
 
   
   public String getSourceFeeAmount() {
     return this.sourceFeeAmount;
   }
 
   
   public void setSourceFeeAmount(String sourceFeeAmount) {
     this.sourceFeeAmount = sourceFeeAmount;
   }
 
   
   public String getSourceFeeVatAmount() {
     return this.sourceFeeVatAmount;
   }
 
   
   public void setSourceFeeVatAmount(String sourceFeeVatAmount) {
     this.sourceFeeVatAmount = sourceFeeVatAmount;
   }
 
   
   public String getSourceMsisdn() {
     return this.sourceMsisdn;
   }
 
   
   public void setSourceMsisdn(String sourceMsisdn) {
     this.sourceMsisdn = sourceMsisdn;
   }
 
   
   public String getSourceRateOfTax() {
     return this.sourceRateOfTax;
   }
 
   
   public void setSourceRateOfTax(String sourceRateOfTax) {
     this.sourceRateOfTax = sourceRateOfTax;
   }
 
   
   public String getSourceRfc() {
     return this.sourceRfc;
   }
 
   
   public void setSourceRfc(String sourceRfc) {
     this.sourceRfc = sourceRfc;
   }
 
   
   public String getSourceTotalFeeAmount() {
     return this.sourceTotalFeeAmount;
   }
 
   
   public void setSourceTotalFeeAmount(String sourceTotalFeeAmount) {
     this.sourceTotalFeeAmount = sourceTotalFeeAmount;
   }
 
   
   public String getStatusRenapo() {
     return this.statusRenapo;
   }
 
   
   public String getSpeiCode() {
     return this.speiCode;
   }
 
   
   public void setSpeiCode(String speiCode) {
     this.speiCode = speiCode;
   }
 
   
   public void setStatusRenapo(String statusRenapo) {
     this.statusRenapo = statusRenapo;
   }
 
   
   public String getStoreReference() {
     return this.storeReference;
   }
 
   
   public void setStoreReference(String storeReference) {
     this.storeReference = storeReference;
   }
 
   
   public String getSvaAccountNumber() {
     return this.svaAccountNumber;
   }
 
   
   public void setSvaAccountNumber(String svaAccountNumber) {
     this.svaAccountNumber = svaAccountNumber;
   }
 
   
   public String getSystemDate() {
     return this.systemDate;
   }
 
   
   public void setSystemDate(String systemDate) {
     this.systemDate = systemDate;
   }
 
   
   public String getTan() {
     return this.tan;
   }
 
   
   public void setTan(String tan) {
     this.tan = tan;
   }
 
   
   public String getTax() {
     return this.tax;
   }
 
   
   public void setTax(String tax) {
     this.tax = tax;
   }
 
   
   public String getToDate() {
     return this.toDate;
   }
 
   
   public void setToDate(String toDate) {
     this.toDate = toDate;
   }
 
   
   public String getTransactionID() {
     return this.transactionID;
   }
 
   
   public void setTransactionID(String transactionID) {
     this.transactionID = transactionID;
   }
 
   
   public String getTransactionSubtype() {
     return this.transactionSubtype;
   }
 
   
   public void setTransactionSubtype(String transactionSubtype) {
     this.transactionSubtype = transactionSubtype;
   }
 
   
   public String getTransactionType() {
     return this.transactionType;
   }
 
   
   public void setTransactionType(String transactionType) {
     this.transactionType = transactionType;
   }
 
   
   public String getHasMoreTransactions() {
     return this.hasMoreTransactions;
   }
 
   
   public void setHasMoreTransactions(String hasMoreTransactions) {
     this.hasMoreTransactions = hasMoreTransactions;
   }
 
   
   public String getBirthState() {
     return this.birthState;
   }
 
   
   public void setBirthState(String birthState) {
     this.birthState = birthState;
   }
 
   
   public String getGender() {
     return this.gender;
   }
 
   
   public void setGender(String gender) {
     this.gender = gender;
   }
 
   
   public String getIdNumber() {
     return this.idNumber;
   }
 
   
   public void setIdNumber(String idNumber) {
     this.idNumber = idNumber;
   }
 
   
   public String getIdType() {
     return this.idType;
   }
 
   
   public void setIdType(String idType) {
     this.idType = idType;
   }
 
   
   public String getRemarks() {
     return this.remarks;
   }
 
   
   public void setRemarks(String remarks) {
     this.remarks = remarks;
   }
 
   
   public String getRenapoStatus() {
     return this.renapoStatus;
   }
 
   
   public void setRenapoStatus(String renapoStatus) {
     this.renapoStatus = renapoStatus;
   }
 
   
   public String getRenapoValidationCounter() {
     return this.renapoValidationCounter;
   }
 
   
   public void setRenapoValidationCounter(String renapoValidationCounter) {
     this.renapoValidationCounter = renapoValidationCounter;
   }
 
   
   public String getRenapoValidationDate() {
     return this.renapoValidationDate;
   }
 
   
   public void setRenapoValidationDate(String renapoValidationDate) {
     this.renapoValidationDate = renapoValidationDate;
   }
 
   
   public String getHasCardHistory() {
     return this.hasCardHistory;
   }
 
   
   public void setHasCardHistory(String hasCardHistory) {
     this.hasCardHistory = hasCardHistory;
   }
 
   
   public String getGetUrl() {
     return this.getUrl;
   }
 
   
   public void setGetUrl(String getUrl) {
     this.getUrl = getUrl;
   }
 
   
   public String getUrlPdf() {
     return this.urlPdf;
   }
 
   
   public void setUrlPdf(String urlPdf) {
     this.urlPdf = urlPdf;
   }
 
   
   public String getUrlXml() {
     return this.urlXml;
   }
 
   
   public void setUrlXml(String urlXml) {
     this.urlXml = urlXml;
   }
 
   
   public void setProcessingCode(String processingCode) {
     this.processingCode = processingCode;
   }
 
   
   public void setSourceFullName(String sourceFullName) {
     this.sourceFullName = sourceFullName;
   }
 }


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\authentic\DTOResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */