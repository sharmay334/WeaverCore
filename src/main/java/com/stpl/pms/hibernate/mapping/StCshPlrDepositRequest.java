package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StCshPlrDepositRequest entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositRequest implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long requestId;
	private Short domainId;
	private Short aliasId;
	private Integer fromCurrencyId;
	private Double fromAmount;
	private Double fromAmountNative;
	private Integer processCurrencyId;
	private Double processCharge;
	private Double processChargeNative;
	private Integer toCurrencyId;
	private Double toAmount;
	private Double toAmountNative;
	private String reqStatus;
	private String description;
	private Timestamp requestTime;
	private Timestamp responseTime;
	private StCshPaymentOptionsDomainMapping payOptDomMapping;
	private StCshPlrDepositResponseGharpay gharpayResp;
	private StCshPlrDepositRequestChequeTrans chequeReqDetail;
	private StCshPlrDepositRequestWireTrans wireReqDetail;
	private StPmPlayerMaster plrMaster;
	private String settlementStatus;
	private String userAgent;
	private String depDevice;
	private String cshDepositRequestJson;
	// Constructors


	/** default constructor */
	public StCshPlrDepositRequest() {
	}

	// Property accessors

	public Long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Integer getFromCurrencyId() {
		return this.fromCurrencyId;
	}

	public void setFromCurrencyId(Integer fromCurrencyId) {
		this.fromCurrencyId = fromCurrencyId;
	}

	public Double getFromAmount() {
		return this.fromAmount;
	}

	public void setFromAmount(Double fromAmount) {
		this.fromAmount = fromAmount;
	}

	public Double getFromAmountNative() {
		return this.fromAmountNative;
	}

	public void setFromAmountNative(Double fromAmountNative) {
		this.fromAmountNative = fromAmountNative;
	}

	public Integer getProcessCurrencyId() {
		return this.processCurrencyId;
	}

	public void setProcessCurrencyId(Integer processCurrencyId) {
		this.processCurrencyId = processCurrencyId;
	}

	public Double getProcessCharge() {
		return this.processCharge;
	}

	public void setProcessCharge(Double processCharge) {
		this.processCharge = processCharge;
	}

	public Double getProcessChargeNative() {
		return this.processChargeNative;
	}

	public void setProcessChargeNative(Double processChargeNative) {
		this.processChargeNative = processChargeNative;
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

	public String getReqStatus() {
		return this.reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getRequestTime() {
		return this.requestTime;
	}

	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}

	public Timestamp getResponseTime() {
		return this.responseTime;
	}

	public void setResponseTime(Timestamp responseTime) {
		this.responseTime = responseTime;
	}

	public void setPayOptDomMapping(
			StCshPaymentOptionsDomainMapping payOptDomMapping) {
		this.payOptDomMapping = payOptDomMapping;
	}

	public StCshPaymentOptionsDomainMapping getPayOptDomMapping() {
		return payOptDomMapping;
	}

	public void setGharpayResp(StCshPlrDepositResponseGharpay gharpayResp) {
		this.gharpayResp = gharpayResp;
	}

	public StCshPlrDepositResponseGharpay getGharpayResp() {
		return gharpayResp;
	}

	public void setChequeReqDetail(
			StCshPlrDepositRequestChequeTrans chequeReqDetail) {
		this.chequeReqDetail = chequeReqDetail;
	}

	public StCshPlrDepositRequestChequeTrans getChequeReqDetail() {
		return chequeReqDetail;
	}

	public void setWireReqDetail(StCshPlrDepositRequestWireTrans wireReqDetail) {
		this.wireReqDetail = wireReqDetail;
	}

	public StCshPlrDepositRequestWireTrans getWireReqDetail() {
		return wireReqDetail;
	}

	public void setPlrMaster(StPmPlayerMaster plrMaster) {
		this.plrMaster = plrMaster;
	}

	public StPmPlayerMaster getPlrMaster() {
		return plrMaster;
	}

	public String getSettlementStatus() {
		return this.settlementStatus;
	}

	public void setSettlementStatus(String settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getDepDevice() {
		return depDevice;
	}

	public void setDepDevice(String depDevice) {
		this.depDevice = depDevice;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getCshDepositRequestJson() {
		return cshDepositRequestJson;
	}

	public void setCshDepositRequestJson(String cshDepositRequestJson) {
		this.cshDepositRequestJson = cshDepositRequestJson;
	}

}