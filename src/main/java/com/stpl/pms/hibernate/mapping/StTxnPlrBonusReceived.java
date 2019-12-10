package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrBonusReceived entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrBonusReceived implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Timestamp transactionDate;
	private Long bonusId;
	private Double receivedCash;
	private Double receivedCashNative;
	private Double receivedBonus;
	private Double receivedBonusNative;
	private String inBonusDetail;
	private Integer currencyId;
	private String isCancel;

	// Constructors

	/** default constructor */
	public StTxnPlrBonusReceived() {
	}

	/** full constructor */
	public StTxnPlrBonusReceived(Long transactionId, Long playerId,
			Short domainId, Timestamp transactionDate, Long bonusId,
			Double receivedCash, Double receivedCashNative,
			Double receivedBonus, Double receivedBonusNative,
			String inBonusDetail, Integer currencyId, String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.bonusId = bonusId;
		this.receivedCash = receivedCash;
		this.receivedCashNative = receivedCashNative;
		this.receivedBonus = receivedBonus;
		this.receivedBonusNative = receivedBonusNative;
		this.inBonusDetail = inBonusDetail;
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

	public Double getReceivedCash() {
		return this.receivedCash;
	}

	public void setReceivedCash(Double receivedCash) {
		this.receivedCash = receivedCash;
	}

	public Double getReceivedCashNative() {
		return this.receivedCashNative;
	}

	public void setReceivedCashNative(Double receivedCashNative) {
		this.receivedCashNative = receivedCashNative;
	}

	public Double getReceivedBonus() {
		return this.receivedBonus;
	}

	public void setReceivedBonus(Double receivedBonus) {
		this.receivedBonus = receivedBonus;
	}

	public Double getReceivedBonusNative() {
		return this.receivedBonusNative;
	}

	public void setReceivedBonusNative(Double receivedBonusNative) {
		this.receivedBonusNative = receivedBonusNative;
	}

	public String getInBonusDetail() {
		return this.inBonusDetail;
	}

	public void setInBonusDetail(String inBonusDetail) {
		this.inBonusDetail = inBonusDetail;
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