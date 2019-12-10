package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrDepositResponsePagaAgent entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositResponsePagaAgent implements java.io.Serializable {

	// Fields

	private Long id;
	private String utcTransactionDateTime;
	private String transactionType;
	private String totalAmount;
	private String agentAmount;
	private String merchantAmount;
	private String isCredit;
	private String pagaTransactionId;
	private String merchantTransactionId;
	private String currency;
	private String customerReference;
	private String customerFirstName;
	private String customerLastName;
	private String channel;
	private String location;
	private String description;

	// Constructors

	/** default constructor */
	public StCshPlrDepositResponsePagaAgent() {
	}

	/** full constructor */
	public StCshPlrDepositResponsePagaAgent(String utcTransactionDateTime,
			String transactionType, String totalAmount, String agentAmount,
			String merchantAmount, String isCredit, String pagaTransactionId,
			String merchantTransactionId, String currency,
			String customerReference, String customerFirstName,
			String customerLastName, String channel, String location,
			String description) {
		this.utcTransactionDateTime = utcTransactionDateTime;
		this.transactionType = transactionType;
		this.totalAmount = totalAmount;
		this.agentAmount = agentAmount;
		this.merchantAmount = merchantAmount;
		this.isCredit = isCredit;
		this.pagaTransactionId = pagaTransactionId;
		this.merchantTransactionId = merchantTransactionId;
		this.currency = currency;
		this.customerReference = customerReference;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.channel = channel;
		this.location = location;
		this.description = description;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUtcTransactionDateTime() {
		return this.utcTransactionDateTime;
	}

	public void setUtcTransactionDateTime(String utcTransactionDateTime) {
		this.utcTransactionDateTime = utcTransactionDateTime;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAgentAmount() {
		return this.agentAmount;
	}

	public void setAgentAmount(String agentAmount) {
		this.agentAmount = agentAmount;
	}

	public String getMerchantAmount() {
		return this.merchantAmount;
	}

	public void setMerchantAmount(String merchantAmount) {
		this.merchantAmount = merchantAmount;
	}

	public String getIsCredit() {
		return this.isCredit;
	}

	public void setIsCredit(String isCredit) {
		this.isCredit = isCredit;
	}

	public String getPagaTransactionId() {
		return this.pagaTransactionId;
	}

	public void setPagaTransactionId(String pagaTransactionId) {
		this.pagaTransactionId = pagaTransactionId;
	}

	public String getMerchantTransactionId() {
		return this.merchantTransactionId;
	}

	public void setMerchantTransactionId(String merchantTransactionId) {
		this.merchantTransactionId = merchantTransactionId;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCustomerReference() {
		return this.customerReference;
	}

	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}

	public String getCustomerFirstName() {
		return this.customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return this.customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}