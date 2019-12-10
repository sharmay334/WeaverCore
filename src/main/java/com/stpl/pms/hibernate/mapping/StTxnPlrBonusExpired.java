package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;


public class StTxnPlrBonusExpired implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Timestamp transactionDate;
	private Long bonusId;
	private String txMode;
	private Double expiredBonusAmt;
	private Double expiredBonusAmtNative;
	private Double wrContributionAtExpiry;
	private Double transferredWrContribution;
	private String wrContrTransferedToBonusId;
	private Long cancelByUserId;
	private String reason;
	private Integer currencyId;
	private String isCancel;

	// Constructors

	/** default constructor */
	public StTxnPlrBonusExpired() {
	}

	public StTxnPlrBonusExpired(StTxnPlrBonusDetails bean,String txMode,Long userId,String reason) {
		this.playerId = bean.getPlayerId();
		this.domainId = bean.getDomainId();
		this.bonusId = bean.getBonusId();
		this.aliasId = bean.getAliasId();
		this.txMode = txMode;
		this.expiredBonusAmt = bean.getBonusAmt()-bean.getRedeemedBonusAmt();
		this.wrContributionAtExpiry = bean.getWrContribution();
		this.wrContrTransferedToBonusId = "";
		this.cancelByUserId = userId;
		this.reason = reason;
		this.isCancel = "N";
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

	public Long getBonusId() {
		return this.bonusId;
	}

	public void setBonusId(Long bonusId) {
		this.bonusId = bonusId;
	}

	public String getTxMode() {
		return this.txMode;
	}

	public void setTxMode(String txMode) {
		this.txMode = txMode;
	}

	public Double getExpiredBonusAmt() {
		return this.expiredBonusAmt;
	}

	public void setExpiredBonusAmt(Double expiredBonusAmt) {
		this.expiredBonusAmt = expiredBonusAmt;
	}

	public Double getExpiredBonusAmtNative() {
		return this.expiredBonusAmtNative;
	}

	public void setExpiredBonusAmtNative(Double expiredBonusAmtNative) {
		this.expiredBonusAmtNative = expiredBonusAmtNative;
	}

	public Double getWrContributionAtExpiry() {
		return this.wrContributionAtExpiry;
	}

	public void setWrContributionAtExpiry(Double wrContributionAtExpiry) {
		this.wrContributionAtExpiry = wrContributionAtExpiry;
	}

	public Double getTransferredWrContribution() {
		return this.transferredWrContribution;
	}

	public void setTransferredWrContribution(Double transferredWrContribution) {
		this.transferredWrContribution = transferredWrContribution;
	}

	public String getWrContrTransferedToBonusId() {
		return this.wrContrTransferedToBonusId;
	}

	public void setWrContrTransferedToBonusId(String wrContrTransferedToBonusId) {
		this.wrContrTransferedToBonusId = wrContrTransferedToBonusId;
	}

	public Long getCancelByUserId() {
		return this.cancelByUserId;
	}

	public void setCancelByUserId(Long cancelByUserId) {
		this.cancelByUserId = cancelByUserId;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public String getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}