package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrDepositMaster entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrDepositMaster implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Timestamp transactionDate;
	private Long podmId;
	private Long requestId;
	private Integer fromCurrencyId;
	private Double fromAmount;
	private Double fromAmountNative;
	private Integer toCurrencyId;
	private Double toAmount;
	private Double toAmountNative;
	private Integer convCurrencyId;
	private Double convCharges;
	private Double convChargesNative;
	private Double amount;
	private Double amountNative;
	private String isCancel;
	private String depDevice;
	private String browser;
	private String os;
	private String device;

	// Constructors

	/** default constructor */
	public StTxnPlrDepositMaster() {
	}

	/** full constructor */
	public StTxnPlrDepositMaster(Long transactionId, Long playerId,
			Short domainId, short aliasId, Timestamp transactionDate, Long podmId,
			Long requestId, Integer fromCurrencyId, Double fromAmount,
			Double fromAmountNative, Integer toCurrencyId, Double toAmount,
			Double toAmountNative, Integer convCurrencyId, Double convCharges,
			Double convChargesNative, Double amount, Double amountNative,
			String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.transactionDate = transactionDate;
		this.podmId = podmId;
		this.requestId = requestId;
		this.fromCurrencyId = fromCurrencyId;
		this.fromAmount = fromAmount;
		this.fromAmountNative = fromAmountNative;
		this.toCurrencyId = toCurrencyId;
		this.toAmount = toAmount;
		this.toAmountNative = toAmountNative;
		this.convCurrencyId = convCurrencyId;
		this.convCharges = convCharges;
		this.convChargesNative = convChargesNative;
		this.amount = amount;
		this.amountNative = amountNative;
		this.isCancel = isCancel;
	}

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

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
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

	public Long getPodmId() {
		return this.podmId;
	}

	public void setPodmId(Long podmId) {
		this.podmId = podmId;
	}

	public Long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
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

	public String getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
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

}