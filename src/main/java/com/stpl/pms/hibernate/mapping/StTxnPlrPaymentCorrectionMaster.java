package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrPaymentCorrectionMaster entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrPaymentCorrectionMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Timestamp transactionDate;
	private Integer currencyId;
	private Double amount;
	private Double amountNative;
	private String correctionType;
	private String withdrawableImpact;
	private String reason;
	private String isCancel;
	private Integer correctionBy;

	// Constructors

	/** default constructor */
	public StTxnPlrPaymentCorrectionMaster() {
	}

	/** full constructor */
	public StTxnPlrPaymentCorrectionMaster(Long transactionId, Long playerId,
			Short domainId, Short aliasId, Timestamp transactionDate, Integer currencyId,
			Double amount, Double amountNative, String correctionType,
			String withdrawableImpact, String reason, String isCancel,
			Integer correctionBy) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.transactionDate = transactionDate;
		this.currencyId = currencyId;
		this.amount = amount;
		this.amountNative = amountNative;
		this.correctionType = correctionType;
		this.withdrawableImpact = withdrawableImpact;
		this.reason = reason;
		this.isCancel = isCancel;
		this.correctionBy = correctionBy;
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

	public String getCorrectionType() {
		return this.correctionType;
	}

	public void setCorrectionType(String correctionType) {
		this.correctionType = correctionType;
	}

	public String getWithdrawableImpact() {
		return this.withdrawableImpact;
	}

	public void setWithdrawableImpact(String withdrawableImpact) {
		this.withdrawableImpact = withdrawableImpact;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}

	public Integer getCorrectionBy() {
		return this.correctionBy;
	}

	public void setCorrectionBy(Integer correctionBy) {
		this.correctionBy = correctionBy;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}