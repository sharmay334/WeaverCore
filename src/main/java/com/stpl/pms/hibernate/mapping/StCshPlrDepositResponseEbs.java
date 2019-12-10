package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrDepositResponseEbs entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositResponseEbs implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private String deliveryCity;
	private String secureHash;
	private String billingPostalCode;
	private String billingCountry;
	private String isFlagged;
	private String billingEmail;
	private String deliveryPostalCode;
	private String merchantRefno;
	private String deliveryCountry;
	private String deliveryName;
	private String requestId;
	private String billingAddress;
	private String responseCode;
	private String billingCity;
	private String responseMessage;
	private String dateCreated;
	private String paymentMethod;
	private String deliveryAddress;
	private String billingState;
	private String mode;
	private String paymentId;
	private String amount;
	private String deliveryState;
	private String billingPhone;
	private String transactionId;
	private String deliveryPhone;
	private String billingName;
	private String description;

	// Constructors

	/** default constructor */
	public StCshPlrDepositResponseEbs() {
	}

	/** full constructor */
	public StCshPlrDepositResponseEbs(String deliveryCity, String secureHash,
			String billingPostalCode, String billingCountry, String isFlagged,
			String billingEmail, String deliveryPostalCode,
			String merchantRefno, String deliveryCountry, String deliveryName,
			String requestId, String billingAddress, String responseCode,
			String billingCity, String responseMessage, String dateCreated,
			String paymentMethod, String deliveryAddress, String billingState,
			String mode, String paymentId, String amount, String deliveryState,
			String billingPhone, String transactionId, String deliveryPhone,
			String billingName, String description) {
		this.deliveryCity = deliveryCity;
		this.secureHash = secureHash;
		this.billingPostalCode = billingPostalCode;
		this.billingCountry = billingCountry;
		this.isFlagged = isFlagged;
		this.billingEmail = billingEmail;
		this.deliveryPostalCode = deliveryPostalCode;
		this.merchantRefno = merchantRefno;
		this.deliveryCountry = deliveryCountry;
		this.deliveryName = deliveryName;
		this.requestId = requestId;
		this.billingAddress = billingAddress;
		this.responseCode = responseCode;
		this.billingCity = billingCity;
		this.responseMessage = responseMessage;
		this.dateCreated = dateCreated;
		this.paymentMethod = paymentMethod;
		this.deliveryAddress = deliveryAddress;
		this.billingState = billingState;
		this.mode = mode;
		this.paymentId = paymentId;
		this.amount = amount;
		this.deliveryState = deliveryState;
		this.billingPhone = billingPhone;
		this.transactionId = transactionId;
		this.deliveryPhone = deliveryPhone;
		this.billingName = billingName;
		this.description = description;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeliveryCity() {
		return this.deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public String getSecureHash() {
		return this.secureHash;
	}

	public void setSecureHash(String secureHash) {
		this.secureHash = secureHash;
	}

	public String getBillingPostalCode() {
		return this.billingPostalCode;
	}

	public void setBillingPostalCode(String billingPostalCode) {
		this.billingPostalCode = billingPostalCode;
	}

	public String getBillingCountry() {
		return this.billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getIsFlagged() {
		return this.isFlagged;
	}

	public void setIsFlagged(String isFlagged) {
		this.isFlagged = isFlagged;
	}

	public String getBillingEmail() {
		return this.billingEmail;
	}

	public void setBillingEmail(String billingEmail) {
		this.billingEmail = billingEmail;
	}

	public String getDeliveryPostalCode() {
		return this.deliveryPostalCode;
	}

	public void setDeliveryPostalCode(String deliveryPostalCode) {
		this.deliveryPostalCode = deliveryPostalCode;
	}

	public String getMerchantRefno() {
		return this.merchantRefno;
	}

	public void setMerchantRefno(String merchantRefno) {
		this.merchantRefno = merchantRefno;
	}

	public String getDeliveryCountry() {
		return this.deliveryCountry;
	}

	public void setDeliveryCountry(String deliveryCountry) {
		this.deliveryCountry = deliveryCountry;
	}

	public String getDeliveryName() {
		return this.deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getRequestId() {
		return this.requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getBillingAddress() {
		return this.billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getResponseCode() {
		return this.responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getBillingCity() {
		return this.billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getResponseMessage() {
		return this.responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getBillingState() {
		return this.billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getMode() {
		return this.mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDeliveryState() {
		return this.deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getBillingPhone() {
		return this.billingPhone;
	}

	public void setBillingPhone(String billingPhone) {
		this.billingPhone = billingPhone;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getDeliveryPhone() {
		return this.deliveryPhone;
	}

	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}

	public String getBillingName() {
		return this.billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}