package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrWinningMasterLiveCasino7 entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrWinningMasterLiveCasino7 implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Timestamp transactionDate;
	private Double winningAmount;
	private Double tdsAmount;
	private Double amount;
	private Integer currencyId;
	private String betId;
	private String refTxnNo;
	private Double vatAmount;
	private String status;
	private Short vendorId;
	private Double cashPortion;
	private Double bonusPortion;
	private Double pendingWinPortion;
	private Double subwalletPortion;
	private String isCancel;
	private Double winningAmountNative;
	private Double amountNative;
	private Double tdsAmountNative;
	private Double vatAmountNative;

	// Constructors

	public Double getWinningAmountNative() {
		return winningAmountNative;
	}

	public void setWinningAmountNative(Double winningAmountNative) {
		this.winningAmountNative = winningAmountNative;
	}

	public Double getAmountNative() {
		return amountNative;
	}

	public void setAmountNative(Double amountNative) {
		this.amountNative = amountNative;
	}

	public Double getTdsAmountNative() {
		return tdsAmountNative;
	}

	public void setTdsAmountNative(Double tdsAmountNative) {
		this.tdsAmountNative = tdsAmountNative;
	}

	public Double getVatAmountNative() {
		return vatAmountNative;
	}

	public void setVatAmountNative(Double vatAmountNative) {
		this.vatAmountNative = vatAmountNative;
	}

	/** default constructor */
	public StTxnPlrWinningMasterLiveCasino7() {
	}

	/**
	 * full constructor
	 * 
	 * @param winningAmountNative
	 * @param amountNative
	 * @param tdsAmountNative
	 * @param vatAmountNative
	 */
	public StTxnPlrWinningMasterLiveCasino7(Long transactionId, Long playerId,
			Short domainId, Timestamp transactionDate, Double winningAmount,
			Double tdsAmount, Double amount, Integer currencyId, String betId,
			String refTxnNo, Double vatAmount, String status, Short vendorId,
			Double cashPortion, Double bonusPortion, Double pendingWinPortion,
			Double subwalletPortion, String isCancel,
			Double winningAmountNative, Double amountNative,
			Double tdsAmountNative, Double vatAmountNative) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.winningAmount = winningAmount;
		this.tdsAmount = tdsAmount;
		this.amount = amount;
		this.currencyId = currencyId;
		this.betId = betId;
		this.refTxnNo = refTxnNo;
		this.vatAmount = vatAmount;
		this.status = status;
		this.vendorId = vendorId;
		this.cashPortion = cashPortion;
		this.bonusPortion = bonusPortion;
		this.pendingWinPortion = pendingWinPortion;
		this.subwalletPortion = subwalletPortion;
		this.isCancel = isCancel;
		this.winningAmountNative = winningAmountNative;
		this.amountNative = amountNative;
		this.tdsAmountNative = tdsAmountNative;
		this.vatAmountNative = vatAmountNative;
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

	public Double getTdsAmount() {
		return this.tdsAmount;
	}

	public void setTdsAmount(Double tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public String getBetId() {
		return this.betId;
	}

	public void setBetId(String betId) {
		this.betId = betId;
	}

	public String getRefTxnNo() {
		return this.refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public Double getVatAmount() {
		return this.vatAmount;
	}

	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
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