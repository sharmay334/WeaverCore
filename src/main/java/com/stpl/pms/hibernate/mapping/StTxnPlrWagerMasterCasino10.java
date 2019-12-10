package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrWagerMasterCasino10 entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrWagerMasterCasino10 implements java.io.Serializable,StTxnWagerMaster {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Timestamp transactionDate;
	private Double amount;
	private Integer currencyId;
	private Integer gameId;
	private Integer roundId;
	private String gameSessionId;
	private String refTxnNo;
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
	public StTxnPlrWagerMasterCasino10() {
	}

	/**
	 * full constructor
	 * 
	 * @param amountNative
	 * @param vatAmountNative
	 */
	public StTxnPlrWagerMasterCasino10(Long transactionId, Long playerId,
			Short domainId, Timestamp transactionDate, Double amount,
			Integer currencyId, Integer gameId, Integer roundId,
			String gameSessionId, String refTxnNo, Double vatAmount,
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
		this.gameId = gameId;
		this.roundId = roundId;
		this.gameSessionId = gameSessionId;
		this.refTxnNo = refTxnNo;
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

	public String getGameName() {
		return null;
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

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getRoundId() {
		return this.roundId;
	}

	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}

	public String getGameSessionId() {
		return this.gameSessionId;
	}

	public void setGameSessionId(String gameSessionId) {
		this.gameSessionId = gameSessionId;
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