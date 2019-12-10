package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrWinningMasterGoldenRace18 entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrWinningMasterGoldenRace18 implements java.io.Serializable {

	// Fields

	private Long id;
	private Long transactionId;
	private Long playerId;
	private Integer unitId;
	private Integer staffId;
	private Short domainId;
	private Short aliasId;
	private Timestamp transactionDate;
	private Double winningAmount;
	private Double winningAmountNative;
	private Double tdsAmount;
	private Double tdsAmountNative;
	private Double amount;
	private Double amountNative;
	private Integer currencyId;
	private Long gameId;
	private String gameName;
	private Double vatAmount;
	private Double vatAmountNative;
	private String refTxnNo;
	private String status;
	private Short vendorId;
	private String isCancel;
	private Double cashPortion;
	private Double bonusPortion;
	private Double pendingWinPortion;
	private Double subwalletPortion;
	private Double jackpot;
	private Long subWalletId;
	

	// Constructors

	/** default constructor */
	public StTxnPlrWinningMasterGoldenRace18() {
	}

	/** minimal constructor */
	public StTxnPlrWinningMasterGoldenRace18(Long transactionId, Long playerId,
			Integer unitId, Integer staffId, Short domainId, Short aliasId,
			Timestamp transactionDate, Double winningAmount,
			Double winningAmountNative, Double tdsAmount,
			Double tdsAmountNative, Double amount, Double amountNative,
			Integer currencyId, Short vendorId, String isCancel,
			Double cashPortion, Double bonusPortion, Double pendingWinPortion,
			Double subwalletPortion) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.unitId = unitId;
		this.staffId = staffId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.transactionDate = transactionDate;
		this.winningAmount = winningAmount;
		this.winningAmountNative = winningAmountNative;
		this.tdsAmount = tdsAmount;
		this.tdsAmountNative = tdsAmountNative;
		this.amount = amount;
		this.amountNative = amountNative;
		this.currencyId = currencyId;
		this.vendorId = vendorId;
		this.isCancel = isCancel;
		this.cashPortion = cashPortion;
		this.bonusPortion = bonusPortion;
		this.pendingWinPortion = pendingWinPortion;
		this.subwalletPortion = subwalletPortion;
	}

	/** full constructor */
	public StTxnPlrWinningMasterGoldenRace18(Long transactionId, Long playerId,
			Integer unitId, Integer staffId, Short domainId, Short aliasId,
			Timestamp transactionDate, Double winningAmount,
			Double winningAmountNative, Double tdsAmount,
			Double tdsAmountNative, Double amount, Double amountNative,
			Integer currencyId, Long gameId, String gameName,
			Double vatAmount, Double vatAmountNative, String refTxnNo,
			String status, Short vendorId, String isCancel, Double cashPortion,
			Double bonusPortion, Double pendingWinPortion,
			Double subwalletPortion, Long subwalletId) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.unitId = unitId;
		this.staffId = staffId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.transactionDate = transactionDate;
		this.winningAmount = winningAmount;
		this.winningAmountNative = winningAmountNative;
		this.tdsAmount = tdsAmount;
		this.tdsAmountNative = tdsAmountNative;
		this.amount = amount;
		this.amountNative = amountNative;
		this.currencyId = currencyId;
		this.gameId = gameId;
		this.gameName = gameName;
		this.vatAmount = vatAmount;
		this.vatAmountNative = vatAmountNative;
		this.refTxnNo = refTxnNo;
		this.status = status;
		this.vendorId = vendorId;
		this.isCancel = isCancel;
		this.cashPortion = cashPortion;
		this.bonusPortion = bonusPortion;
		this.pendingWinPortion = pendingWinPortion;
		this.subwalletPortion = subwalletPortion;
		this.subWalletId = subwalletId;
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

	public Integer getUnitId() {
		return this.unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Short getAliasId() {
		return this.aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
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

	public Long getGameId() {
		return this.gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return this.gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
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

	public String getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
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

	public Long getSubWalletId() {
		return this.subWalletId;
	}

	public void setSubWalletId(Long subwalletId) {
		this.subWalletId = subwalletId;
	}

	public Double getJackpot() {
		return jackpot;
	}

	public void setJackpot(Double jackpot) {
		this.jackpot = jackpot;
	}

}