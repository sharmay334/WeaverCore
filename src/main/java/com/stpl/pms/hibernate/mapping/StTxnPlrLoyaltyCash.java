package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrDepositAgstWdrlCancel entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrLoyaltyCash implements java.io.Serializable {

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
	private Integer currencyId;
	private Double amount;
	private Double amountNative;
	private String transactionType;
	private String remarks;
	private String isCancel;

	// Constructors

	/** default constructor */
	public StTxnPlrLoyaltyCash() {
	}

	/** minimal constructor */
	public StTxnPlrLoyaltyCash(Long transactionId, Long playerId,
			Short domainId, Timestamp transactionDate, Integer currencyId,
			Double amount, Double amountNative,
			String transactionType) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.currencyId = currencyId;
		this.amount = amount;
		this.amountNative = amountNative;
		this.transactionType = transactionType;
	}

	/** full constructor */
	public StTxnPlrLoyaltyCash(Long transactionId, Long playerId,
			Short domainId, Short aliasId, Timestamp transactionDate, Integer currencyId,
			Double amount, Double amountNative,
			String transactionType, String remarks, String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.transactionDate = transactionDate;
		this.currencyId = currencyId;
		this.amount = amount;
		this.amountNative = amountNative;
		this.transactionType = transactionType;
		this.remarks = remarks;
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

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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