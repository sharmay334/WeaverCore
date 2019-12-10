package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrDepositResponsePaga entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositResponsePaga implements java.io.Serializable {

	// Fields
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String invoice;
	private String transactionId;
	private String customerAccount;
	private String total;
	private String fee;
	private String currency;
	private String exchangeRate;
	private String test;
	private String reference;
	private String processCode;
	private String publicKey;
	private String status;

	// Constructors

	/** default constructor */
	public StCshPlrDepositResponsePaga() {
	}

	/** full constructor */
	public StCshPlrDepositResponsePaga(String invoice, String transactionId,
			String customerAccount, String total, String fee, String currency,
			String exchangeRate, String test, String reference,
			String processCode, String publicKey, String status) {
		this.invoice = invoice;
		this.transactionId = transactionId;
		this.customerAccount = customerAccount;
		this.total = total;
		this.fee = fee;
		this.currency = currency;
		this.exchangeRate = exchangeRate;
		this.test = test;
		this.reference = reference;
		this.processCode = processCode;
		this.publicKey = publicKey;
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoice() {
		return this.invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCustomerAccount() {
		return this.customerAccount;
	}

	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getFee() {
		return this.fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getExchangeRate() {
		return this.exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getTest() {
		return this.test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getProcessCode() {
		return this.processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}
	
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

}