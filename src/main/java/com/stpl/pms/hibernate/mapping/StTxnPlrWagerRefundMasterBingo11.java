package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrWagerRefundMasterBingo11 entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrWagerRefundMasterBingo11 implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Timestamp transactionDate;
	private Double amount;
	private Integer currencyId;
	private Short gameId;
	private Double vatAmount;
	private String refTxnNo;
	private Double wgrContriAmt;
	private String gameType;
	private Short vendorId;
	private Double cashPortion;
	private Double bonusPortion;
	private Double pendingWinPortion;
	private Double subwalletPortion;
	private Double processChargeRefund;
	private Double withdrawableBalPortion;
	private Long refWagerTxnId;
	private Double refundCharge;
	private String isCancel;

	// Constructors

	/** default constructor */
	public StTxnPlrWagerRefundMasterBingo11() {
	}

	/** minimal constructor */
	public StTxnPlrWagerRefundMasterBingo11(Long transactionId, Long playerId,
			Short domainId, Timestamp transactionDate, Double amount,
			Integer currencyId, Short vendorId, Double cashPortion,
			Double bonusPortion, Double pendingWinPortion,
			Double subwalletPortion, Double processChargeRefund,
			Double withdrawableBalPortion, Long refWagerTxnId,
			Double refundCharge, String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.currencyId = currencyId;
		this.vendorId = vendorId;
		this.cashPortion = cashPortion;
		this.bonusPortion = bonusPortion;
		this.pendingWinPortion = pendingWinPortion;
		this.subwalletPortion = subwalletPortion;
		this.processChargeRefund = processChargeRefund;
		this.withdrawableBalPortion = withdrawableBalPortion;
		this.refWagerTxnId = refWagerTxnId;
		this.refundCharge = refundCharge;
		this.isCancel = isCancel;
	}

	/** full constructor */
	public StTxnPlrWagerRefundMasterBingo11(Long transactionId, Long playerId,
			Short domainId, Timestamp transactionDate, Double amount,
			Integer currencyId, Short gameId, Double vatAmount,
			String refTxnNo, Double wgrContriAmt, String gameType,
			Short vendorId, Double cashPortion, Double bonusPortion,
			Double pendingWinPortion, Double subwalletPortion,
			Double processChargeRefund, Double withdrawableBalPortion,
			Long refWagerTxnId, Double refundCharge, String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.currencyId = currencyId;
		this.gameId = gameId;
		this.vatAmount = vatAmount;
		this.refTxnNo = refTxnNo;
		this.wgrContriAmt = wgrContriAmt;
		this.gameType = gameType;
		this.vendorId = vendorId;
		this.cashPortion = cashPortion;
		this.bonusPortion = bonusPortion;
		this.pendingWinPortion = pendingWinPortion;
		this.subwalletPortion = subwalletPortion;
		this.processChargeRefund = processChargeRefund;
		this.withdrawableBalPortion = withdrawableBalPortion;
		this.refWagerTxnId = refWagerTxnId;
		this.refundCharge = refundCharge;
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

	public Short getGameId() {
		return this.gameId;
	}

	public void setGameId(Short gameId) {
		this.gameId = gameId;
	}

	public Double getVatAmount() {
		return this.vatAmount;
	}

	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public String getRefTxnNo() {
		return this.refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public Double getWgrContriAmt() {
		return this.wgrContriAmt;
	}

	public void setWgrContriAmt(Double wgrContriAmt) {
		this.wgrContriAmt = wgrContriAmt;
	}

	public String getGameType() {
		return this.gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
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

	public Double getProcessChargeRefund() {
		return this.processChargeRefund;
	}

	public void setProcessChargeRefund(Double processChargeRefund) {
		this.processChargeRefund = processChargeRefund;
	}

	public Double getWithdrawableBalPortion() {
		return this.withdrawableBalPortion;
	}

	public void setWithdrawableBalPortion(Double withdrawableBalPortion) {
		this.withdrawableBalPortion = withdrawableBalPortion;
	}

	public Long getRefWagerTxnId() {
		return this.refWagerTxnId;
	}

	public void setRefWagerTxnId(Long refWagerTxnId) {
		this.refWagerTxnId = refWagerTxnId;
	}

	public Double getRefundCharge() {
		return this.refundCharge;
	}

	public void setRefundCharge(Double refundCharge) {
		this.refundCharge = refundCharge;
	}

	public String getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}

}