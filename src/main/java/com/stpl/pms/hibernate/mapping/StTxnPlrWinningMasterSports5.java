package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrWinningMasterSports5 entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrWinningMasterSports5 implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Timestamp transactionDate;
	private Double winningAmount;
	private Double winningAmountNative;
	private Double tdsAmount;
	private Double tdsAmountNative;
	private Double amount;
	private Double amountNative;
	private Integer currencyId;
	private String gameRef;
	private String winningRefNo;
	private Double vatAmount;
	private Double vatAmountNative;
	private String refTxnNo;
	private String status;
	private Short vendorId;
	private Double cashPortion;
	private Double bonusPortion;
	private Double pendingWinPortion;
	private Double subwalletPortion;
	private String isCancel;

	// Constructors

	/** default constructor */
	public StTxnPlrWinningMasterSports5() {
	}

	/** minimal constructor */
	public StTxnPlrWinningMasterSports5(Long transactionId, Long playerId,
			Short domainId, Timestamp transactionDate, Double winningAmount,
			Double winningAmountNative, Double tdsAmount,
			Double tdsAmountNative, Double amount, Double amountNative,
			Integer currencyId, Short vendorId, Double cashPortion,
			Double bonusPortion, Double pendingWinPortion,
			Double subwalletPortion, String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.winningAmount = winningAmount;
		this.winningAmountNative = winningAmountNative;
		this.tdsAmount = tdsAmount;
		this.tdsAmountNative = tdsAmountNative;
		this.amount = amount;
		this.amountNative = amountNative;
		this.currencyId = currencyId;
		this.vendorId = vendorId;
		this.cashPortion = cashPortion;
		this.bonusPortion = bonusPortion;
		this.pendingWinPortion = pendingWinPortion;
		this.subwalletPortion = subwalletPortion;
		this.isCancel = isCancel;
	}

	/** full constructor */
	public StTxnPlrWinningMasterSports5(Long transactionId, Long playerId,
			Short domainId, Timestamp transactionDate, Double winningAmount,
			Double winningAmountNative, Double tdsAmount,
			Double tdsAmountNative, Double amount, Double amountNative,
			Integer currencyId, String gameRef, String winningRefNo,
			Double vatAmount, Double vatAmountNative, String refTxnNo,
			String status, Short vendorId, Double cashPortion,
			Double bonusPortion, Double pendingWinPortion,
			Double subwalletPortion, String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.winningAmount = winningAmount;
		this.winningAmountNative = winningAmountNative;
		this.tdsAmount = tdsAmount;
		this.tdsAmountNative = tdsAmountNative;
		this.amount = amount;
		this.amountNative = amountNative;
		this.currencyId = currencyId;
		this.gameRef = gameRef;
		this.winningRefNo = winningRefNo;
		this.vatAmount = vatAmount;
		this.vatAmountNative = vatAmountNative;
		this.refTxnNo = refTxnNo;
		this.status = status;
		this.vendorId = vendorId;
		this.cashPortion = cashPortion;
		this.bonusPortion = bonusPortion;
		this.pendingWinPortion = pendingWinPortion;
		this.subwalletPortion = subwalletPortion;
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

	public Double getWinningAmount() {
		return this.winningAmount;
	}

	public void setWinningAmount(Double winningAmount) {
		this.winningAmount = winningAmount;
	}

	public Double getWinningAmountNative() {
		return this.winningAmountNative;
	}

	public void setWinningAmountNative(Double winningAmountNative) {
		this.winningAmountNative = winningAmountNative;
	}

	public Double getTdsAmount() {
		return this.tdsAmount;
	}

	public void setTdsAmount(Double tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

	public Double getTdsAmountNative() {
		return this.tdsAmountNative;
	}

	public void setTdsAmountNative(Double tdsAmountNative) {
		this.tdsAmountNative = tdsAmountNative;
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

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public String getGameRef() {
		return this.gameRef;
	}

	public void setGameRef(String gameRef) {
		this.gameRef = gameRef;
	}

	public String getWinningRefNo() {
		return this.winningRefNo;
	}

	public void setWinningRefNo(String winningRefNo) {
		this.winningRefNo = winningRefNo;
	}

	public Double getVatAmount() {
		return this.vatAmount;
	}

	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public Double getVatAmountNative() {
		return this.vatAmountNative;
	}

	public void setVatAmountNative(Double vatAmountNative) {
		this.vatAmountNative = vatAmountNative;
	}

	public String getRefTxnNo() {
		return this.refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Short vendorId) {
		this.vendorId = vendorId;
	}

	public Double getCashPortion() {
		return this.cashPortion;
	}

	public void setCashPortion(Double cashPortion) {
		this.cashPortion = cashPortion;
	}

	public Double getBonusPortion() {
		return this.bonusPortion;
	}

	public void setBonusPortion(Double bonusPortion) {
		this.bonusPortion = bonusPortion;
	}

	public Double getPendingWinPortion() {
		return this.pendingWinPortion;
	}

	public void setPendingWinPortion(Double pendingWinPortion) {
		this.pendingWinPortion = pendingWinPortion;
	}

	public Double getSubwalletPortion() {
		return this.subwalletPortion;
	}

	public void setSubwalletPortion(Double subwalletPortion) {
		this.subwalletPortion = subwalletPortion;
	}

	public String getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}

}