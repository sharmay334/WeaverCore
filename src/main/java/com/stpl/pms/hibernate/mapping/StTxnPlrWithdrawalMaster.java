package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrWithdrawalMaster entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrWithdrawalMaster implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Short domainId;
	private Short aliasId;
	private Timestamp transactionDate;
	private Integer currencyId;
	private Double amount;
	private Double amountNative;
	private Integer processCurrencyId;
	private Double processCharges;
	private Double processChargesNative;
	private Double tdsAmount;
	private Double tdsAmountNative;
	private Integer convCurrencyId;
	private Double convCharges;
	private Double convChargesNative;
	private Integer toCurrencyId;
	private Double toAmount;
	private Double toAmountNative;
	private String withdrawalMode;
	private Timestamp processTime;
	private String refTxnNo;
	private Timestamp refTxnDate;
	private String status;
	private String isCancel;
	private StCshPaymentOptionsDomainMapping payOptDomMap;
	private StCshPlrRedeemAccMaster redeemAccMas;
	private StPmPlayerMaster plrMaster;
	private String reasonForCancel;
	private String userAgent;
	private String browser;
	private String os;
	private String device;
	private String withDevice;
	private String txnType;
	private String verificationCode;
	private Timestamp verificationCodeSentTime;
	
	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Timestamp getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAmountNative() {
		return this.amountNative;
	}

	public void setAmountNative(Double amountNative) {
		this.amountNative = amountNative;
	}

	public Integer getProcessCurrencyId() {
		return this.processCurrencyId;
	}

	public void setProcessCurrencyId(Integer processCurrencyId) {
		this.processCurrencyId = processCurrencyId;
	}

	public Double getProcessCharges() {
		return this.processCharges;
	}

	public void setProcessCharges(Double processCharges) {
		this.processCharges = processCharges;
	}

	public Double getProcessChargesNative() {
		return this.processChargesNative;
	}

	public void setProcessChargesNative(Double processChargesNative) {
		this.processChargesNative = processChargesNative;
	}

	public Double getTdsAmount() {
		return this.tdsAmount;
	}

	public void setTdsAmount(Double tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

	public Double getTdsAmountNative() {
		return this.tdsAmountNative;
	}

	public void setTdsAmountNative(Double tdsAmountNative) {
		this.tdsAmountNative = tdsAmountNative;
	}

	public Integer getConvCurrencyId() {
		return this.convCurrencyId;
	}

	public void setConvCurrencyId(Integer convCurrencyId) {
		this.convCurrencyId = convCurrencyId;
	}

	public Double getConvCharges() {
		return this.convCharges;
	}

	public void setConvCharges(Double convCharges) {
		this.convCharges = convCharges;
	}

	public Double getConvChargesNative() {
		return this.convChargesNative;
	}

	public void setConvChargesNative(Double convChargesNative) {
		this.convChargesNative = convChargesNative;
	}

	public Integer getToCurrencyId() {
		return this.toCurrencyId;
	}

	public void setToCurrencyId(Integer toCurrencyId) {
		this.toCurrencyId = toCurrencyId;
	}

	public Double getToAmount() {
		return this.toAmount;
	}

	public void setToAmount(Double toAmount) {
		this.toAmount = toAmount;
	}

	public Double getToAmountNative() {
		return this.toAmountNative;
	}

	public void setToAmountNative(Double toAmountNative) {
		this.toAmountNative = toAmountNative;
	}

	public String getWithdrawalMode() {
		return this.withdrawalMode;
	}

	public void setWithdrawalMode(String withdrawalMode) {
		this.withdrawalMode = withdrawalMode;
	}

	public Timestamp getProcessTime() {
		return this.processTime;
	}

	public void setProcessTime(Timestamp processTime) {
		this.processTime = processTime;
	}

	public String getRefTxnNo() {
		return this.refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public Timestamp getRefTxnDate() {
		return this.refTxnDate;
	}

	public void setRefTxnDate(Timestamp refTxnDate) {
		this.refTxnDate = refTxnDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}
	
	public void setPayOptDomMap(StCshPaymentOptionsDomainMapping payOptDomMap) {
		this.payOptDomMap = payOptDomMap;
	}

	public StCshPaymentOptionsDomainMapping getPayOptDomMap() {
		return payOptDomMap;
	}

	public void setRedeemAccMas(StCshPlrRedeemAccMaster redeemAccMas) {
		this.redeemAccMas = redeemAccMas;
	}

	public StCshPlrRedeemAccMaster getRedeemAccMas() {
		return redeemAccMas;
	}

	public void setPlrMaster(StPmPlayerMaster plrMaster) {
		this.plrMaster = plrMaster;
	}

	public StPmPlayerMaster getPlrMaster() {
		return plrMaster;
	}

	public String getReasonForCancel() {
		return reasonForCancel;
	}

	public void setReasonForCancel(String reasonForCancel) {
		this.reasonForCancel = reasonForCancel;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getWithDevice() {
		return withDevice;
	}

	public void setWithDevice(String withDevice) {
		this.withDevice = withDevice;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Timestamp getVerificationCodeSentTime() {
		return verificationCodeSentTime;
	}

	public void setVerificationCodeSentTime(Timestamp verificationCodeSentTime) {
		this.verificationCodeSentTime = verificationCodeSentTime;
	}

}