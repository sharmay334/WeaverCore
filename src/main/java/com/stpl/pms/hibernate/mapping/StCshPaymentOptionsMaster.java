package com.stpl.pms.hibernate.mapping;

/**
 * StCshPaymentOptionsMaster entity. @author MyEclipse Persistence Tools
 */

public class StCshPaymentOptionsMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long paymentOptionId;
	private Integer providerId;
	private Integer paymentTypeId;
	private Integer subTypeId;
	private String providerSubTypeCode;
	private Integer countryId;
	private Integer currencyId;
	private String providerCurrencyCode;
	private String txnType;
	private String typicalProcessTime;
	private String status;
	private Long successReqCount;
	private Long processingTimeSecTotal;
	private Long totalReq;

	// Constructors

	/** default constructor */
	public StCshPaymentOptionsMaster() {
	}

	// Property accessors

	public Long getPaymentOptionId() {
		return this.paymentOptionId;
	}

	public void setPaymentOptionId(Long paymentOptionId) {
		this.paymentOptionId = paymentOptionId;
	}

	public Integer getProviderId() {
		return this.providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Integer getPaymentTypeId() {
		return this.paymentTypeId;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public Integer getSubTypeId() {
		return this.subTypeId;
	}

	public void setSubTypeId(Integer subTypeId) {
		this.subTypeId = subTypeId;
	}

	public String getProviderSubTypeCode() {
		return this.providerSubTypeCode;
	}

	public void setProviderSubTypeCode(String providerSubTypeCode) {
		this.providerSubTypeCode = providerSubTypeCode;
	}

	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public String getProviderCurrencyCode() {
		return this.providerCurrencyCode;
	}

	public void setProviderCurrencyCode(String providerCurrencyCode) {
		this.providerCurrencyCode = providerCurrencyCode;
	}

	public String getTxnType() {
		return this.txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getTypicalProcessTime() {
		return this.typicalProcessTime;
	}

	public void setTypicalProcessTime(String typicalProcessTime) {
		this.typicalProcessTime = typicalProcessTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSuccessReqCount() {
		return this.successReqCount;
	}

	public void setSuccessReqCount(Long successReqCount) {
		this.successReqCount = successReqCount;
	}

	public Long getProcessingTimeSecTotal() {
		return this.processingTimeSecTotal;
	}

	public void setProcessingTimeSecTotal(Long processingTimeSecTotal) {
		this.processingTimeSecTotal = processingTimeSecTotal;
	}

	public Long getTotalReq() {
		return this.totalReq;
	}

	public void setTotalReq(Long totalReq) {
		this.totalReq = totalReq;
	}

}