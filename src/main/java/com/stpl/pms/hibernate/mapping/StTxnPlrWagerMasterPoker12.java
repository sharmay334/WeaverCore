package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrWagerMasterPoker12 entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrWagerMasterPoker12 implements java.io.Serializable,StTxnWagerMaster {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Timestamp transactionDate;
	private Double amount;
	private Double amountNative;
	private Integer currencyId;
	private String gameId;
	private Double vatAmount;
	private Double vatAmountNative;
	private String refTxnNo;
	private Double wgrContriAmt;
	private String gameType;
	private String gameName;
	private Short vendorId;
	private Double cashPortion;
	private Double bonusPortion;
	private Double pendingWinPortion;
	private Double subwalletPortion;
	private Double processChargeRefund;
	private Double withdrawableBalPortion;
	private String wagerStatus;
	private String actionId;
	private String gameRefre;
	private String isCancel;
	private String txnDevice;
	private String userAgent;
	private String tableId;
	private String tournamentId;
	private String gameQueueId;
	private Short aliasId;
	private Long subWalletId;
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
	public StTxnPlrWagerMasterPoker12() {
	}

	/** full constructor 
	 * @param rake 
	 * @param  */
	public StTxnPlrWagerMasterPoker12(Long transactionId, Long playerId,
			Short domainId,Short aliasId, Timestamp transactionDate, Double amount,
			Double amountNative, Integer currencyId, String gameId,
			Double vatAmount, Double vatAmountNative,
			Double wgrContriAmt, String gameType, String gameName,
			Short vendorId, Double cashPortion, Double bonusPortion,
			Double pendingWinPortion, Double subwalletPortion,
			Double processChargeRefund, Double withdrawableBalPortion,
			String wagerStatus, String isCancel,String actionId,String tableId,String tournamentId,String txnDevice,String userAgent,Long subWalletId, Double rake) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.amountNative = amountNative;
		this.currencyId = currencyId;
		this.gameId = "".equalsIgnoreCase(gameId)?null:gameId;
		this.vatAmount = vatAmount;
		this.vatAmountNative = vatAmountNative;
		this.wgrContriAmt = wgrContriAmt;
		this.gameType = gameType;
		this.gameName = gameName;
		this.vendorId = vendorId;
		this.cashPortion = cashPortion;
		this.bonusPortion = bonusPortion;
		this.pendingWinPortion = pendingWinPortion;
		this.subwalletPortion = subwalletPortion;
		this.processChargeRefund = processChargeRefund;
		this.withdrawableBalPortion = withdrawableBalPortion;
		this.wagerStatus = wagerStatus;
		this.isCancel = isCancel;
		this.actionId = actionId == null?"":actionId;
		this.tableId = tableId;
		this.tournamentId = tournamentId;
		this.txnDevice = txnDevice;
		this.userAgent = userAgent;
		this.subWalletId = subWalletId;
		this.rake = rake;
		this.gameRefre = gameName;
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

	public String getGameId() {
		return this.gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
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

	public String getGameName() {
		return this.gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
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
	
	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getGameRefre() {
		return gameRefre;
	}

	public void setGameRefre(String gameRefre) {
		this.gameRefre = gameRefre;
	}

	public String getTxnDevice() {
		return txnDevice;
	}

	public void setTxnDevice(String txnDevice) {
		this.txnDevice = txnDevice;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public Long getSubWalletId() {
		return subWalletId;
	}

	public void setSubWalletId(Long subWalletId) {
		this.subWalletId = subWalletId;
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

	public String getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getGameQueueId() {
		return gameQueueId;
	}

	public void setGameQueueId(String gameQueueId) {
		this.gameQueueId = gameQueueId;
	}
}