package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrWagerRefundMasterLiveCasino7 entity. @author MyEclipse Persistence
 * Tools
 */

public class StTxnPlrWagerRefundMasterLiveCasino7 implements
		java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Timestamp transactionDate;
	private Double amount;
	private Integer currencyId;
	private String betId;
	private String refTxnNo;
	private String gameName;
	private String drawCode;
	private String lotteryBarcode;
	private Double vatAmount;
	private Double wgrContriAmt;
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
	private Double amountNative;
	private Double vatAmountNative;
	private Double refundChargeNative;

	// Constructors

	/** default constructor */
	public StTxnPlrWagerRefundMasterLiveCasino7() {
	}

	/** full constructor */
	public StTxnPlrWagerRefundMasterLiveCasino7(Long transactionId,
			Long playerId, Short domainId, Timestamp transactionDate,
			Double amount, Integer currencyId, String betId, String refTxnNo,
			String gameName, String drawCode, String lotteryBarcode,
			Double vatAmount, Double wgrContriAmt, Short vendorId,
			Double cashPortion, Double bonusPortion, Double pendingWinPortion,
			Double subwalletPortion, Double processChargeRefund,
			Double withdrawableBalPortion, Long refWagerTxnId,
			Double refundCharge, String isCancel, Double amountNative,
			Double vatAmountNative, Double refundChargeNative) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.currencyId = currencyId;
		this.betId = betId;
		this.refTxnNo = refTxnNo;
		this.gameName = gameName;
		this.drawCode = drawCode;
		this.lotteryBarcode = lotteryBarcode;
		this.vatAmount = vatAmount;
		this.wgrContriAmt = wgrContriAmt;
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
		this.amountNative = amountNative;
		this.vatAmountNative = vatAmountNative;
		this.refundChargeNative = refundChargeNative;
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

	public String getGameName() {
		return this.gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getDrawCode() {
		return this.drawCode;
	}

	public void setDrawCode(String drawCode) {
		this.drawCode = drawCode;
	}

	public String getLotteryBarcode() {
		return this.lotteryBarcode;
	}

	public void setLotteryBarcode(String lotteryBarcode) {
		this.lotteryBarcode = lotteryBarcode;
	}

	public Double getVatAmount() {
		return this.vatAmount;
	}

	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public Double getWgrContriAmt() {
		return this.wgrContriAmt;
	}

	public void setWgrContriAmt(Double wgrContriAmt) {
		this.wgrContriAmt = wgrContriAmt;
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

	public void setAmountNative(Double amountNative) {
		this.amountNative = amountNative;
	}

	public Double getAmountNative() {
		return amountNative;
	}

	public void setRefundChargeNative(Double refundChargeNative) {
		this.refundChargeNative = refundChargeNative;
	}

	public Double getRefundChargeNative() {
		return refundChargeNative;
	}

	public void setVatAmountNative(Double vatAmountNative) {
		this.vatAmountNative = vatAmountNative;
	}

	public Double getVatAmountNative() {
		return vatAmountNative;
	}

}