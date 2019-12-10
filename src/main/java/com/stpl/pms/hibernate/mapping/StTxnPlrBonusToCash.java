package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrBonusToCash entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrBonusToCash implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Timestamp transactionDate;
	private Long bonusId;
	private Double redeemedAmtToCash;
	private Double redeemedAmtToCashNative;
	private Double wrContributionAtTransfer;
	private Integer currencyId;
	private String isCancel;

	private StPromoBonusMaster bonusInfo;
	// Constructors

	/** default constructor */
	public StTxnPlrBonusToCash() {
	}

	/** full constructor */
	public StTxnPlrBonusToCash(Long transactionId, Long playerId,
			Short domainId, Timestamp transactionDate, Long bonusId,
			Double redeemedAmtToCash, Double redeemedAmtToCashNative,
			Double wrContributionAtTransfer, Integer currencyId, String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.bonusId = bonusId;
		this.redeemedAmtToCash = redeemedAmtToCash;
		this.redeemedAmtToCashNative = redeemedAmtToCashNative;
		this.wrContributionAtTransfer = wrContributionAtTransfer;
		this.currencyId = currencyId;
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

	public Long getBonusId() {
		return this.bonusId;
	}

	public void setBonusId(Long bonusId) {
		this.bonusId = bonusId;
	}

	public Double getRedeemedAmtToCash() {
		return this.redeemedAmtToCash;
	}

	public void setRedeemedAmtToCash(Double redeemedAmtToCash) {
		this.redeemedAmtToCash = redeemedAmtToCash;
	}

	public Double getRedeemedAmtToCashNative() {
		return this.redeemedAmtToCashNative;
	}

	public void setRedeemedAmtToCashNative(Double redeemedAmtToCashNative) {
		this.redeemedAmtToCashNative = redeemedAmtToCashNative;
	}

	public Double getWrContributionAtTransfer() {
		return this.wrContributionAtTransfer;
	}

	public void setWrContributionAtTransfer(Double wrContributionAtTransfer) {
		this.wrContributionAtTransfer = wrContributionAtTransfer;
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

	public StPromoBonusMaster getBonusInfo() {
		return bonusInfo;
	}

	public void setBonusInfo(StPromoBonusMaster bonusInfo) {
		this.bonusInfo = bonusInfo;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}