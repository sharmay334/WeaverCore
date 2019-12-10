package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrWagerMasterLiveCasio7 entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrWagerMasterLiveCasino7 implements java.io.Serializable,StTxnWagerMaster {
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
	private String wagerStatus;
	private String isCancel;
	private Double amountNative;
	private Double vatAmountNative;
	private Double bonusToCash;
	private Timestamp confirmationDate;
	private Double rake;
	

	// Constructors

	public Double getRake() {
		return rake;
	}

	public void setRake(Double rake) {
		this.rake = rake;
	}

	/** default constructor */
	public StTxnPlrWagerMasterLiveCasino7() {
	}

	/**
	 * full constructor
	 * 
	 * @param amountNative
	 * @param vatAmountNative
	 */
	public StTxnPlrWagerMasterLiveCasino7(Long transactionId, Long playerId,
			Short domainId, Timestamp transactionDate, Double amount,
			Integer currencyId, String betId, String refTxnNo, String gameName,
			String drawCode, String lotteryBarcode, Double vatAmount,
			Double wgrContriAmt, Short vendorId, Double cashPortion,
			Double bonusPortion, Double pendingWinPortion,
			Double subwalletPortion, Double processChargeRefund,
			Double withdrawableBalPortion, String wagerStatus, String isCancel,
			Double amountNative, Double vatAmountNative) {
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
		this.wagerStatus = wagerStatus;
		this.isCancel = isCancel;
		this.amountNative = amountNative;
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

	public String getWagerStatus() {
		return this.wagerStatus;
	}

	public void setWagerStatus(String wagerStatus) {
		this.wagerStatus = wagerStatus;
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

	public void setVatAmountNative(Double vatAmountNative) {
		this.vatAmountNative = vatAmountNative;
	}

	public Double getVatAmountNative() {
		return vatAmountNative;
	}
	
	public Double getBonusToCash() {
		return bonusToCash;
	}

	public void setBonusToCash(Double bonusToCash) {
		this.bonusToCash = bonusToCash;
	}

	public Timestamp getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(Timestamp confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	
}