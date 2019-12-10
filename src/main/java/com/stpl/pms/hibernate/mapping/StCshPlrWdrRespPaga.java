package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrWdrRespPaga entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrWdrRespPaga implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private String requestId;
	private String transactionId;
	private String withdrawalCode;
	private String currency;
	private String exchangeRate;
	private String fee;
	private String recRegStatus;
	private String responseCode;
	private String message;

	// Constructors

	/** default constructor */
	public StCshPlrWdrRespPaga() {
	}

	/** full constructor */
	public StCshPlrWdrRespPaga(String requestId, String transactionId,
			String withdrawalCode, String currency, String exchangeRate,
			String fee, String recRegStatus, String responseCode, String message) {
		this.requestId = requestId;
		this.transactionId = transactionId;
		this.withdrawalCode = withdrawalCode;
		this.currency = currency;
		this.exchangeRate = exchangeRate;
		this.fee = fee;
		this.recRegStatus = recRegStatus;
		this.responseCode = responseCode;
		this.message = message;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestId() {
		return this.requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getWithdrawalCode() {
		return this.withdrawalCode;
	}

	public void setWithdrawalCode(String withdrawalCode) {
		this.withdrawalCode = withdrawalCode;
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

	public String getFee() {
		return this.fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getRecRegStatus() {
		return this.recRegStatus;
	}

	public void setRecRegStatus(String recRegStatus) {
		this.recRegStatus = recRegStatus;
	}

	public String getResponseCode() {
		return this.responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}