package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrWinningMasterCasino6 entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrWinningMasterCasino6 implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
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
	private String gameType;
	private Double vatAmount;
	private Double vatAmountNative;
	private String refTxnNo;
	private String status;
	private Short vendorId;
	private Double cashPortion;
	private Double bonusPortion;
	private Double winPortion;
	private Double pendingWinPortion;
	private Double subwalletPortion;
	private String isCancel;
	private String txnDevice;
	private String userAgent;
	private String os;
	private String browser;
	private String model;
	private Long subWalletId;
	private Integer deviceLocMapId;
	// Constructors

	/** default constructor */
	public StTxnPlrWinningMasterCasino6() {
	}

	/** minimal constructor */
	public StTxnPlrWinningMasterCasino6(Long transactionId, Long playerId,
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
	public StTxnPlrWinningMasterCasino6(Long transactionId, Long playerId,
			Short domainId, Short aliasId, Timestamp transactionDate,
			Double winningAmount, Double winningAmountNative, Double tdsAmount,
			Double tdsAmountNative, Double amount, Double amountNative,
			Integer currencyId, Long gameId, String gameName, String gameType,
			Double vatAmount, Double vatAmountNative, String refTxnNo,
			String status, Short vendorId, Double cashPortion,
			Double bonusPortion, Double winPortion, Double pendingWinPortion,
			Double subwalletPortion, String isCancel, String txnDevice,
			String userAgent, Long subWalletId, Integer deviceLocMapId) {
		this.transactionId = transactionId;
		this.playerId = playerId;
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
		this.gameType = gameType;
		this.vatAmount = vatAmount;
		this.vatAmountNative = vatAmountNative;
		this.refTxnNo = refTxnNo;
		this.status = status;
		this.vendorId = vendorId;
		this.cashPortion = cashPortion;
		this.bonusPortion = bonusPortion;
		this.winPortion = winPortion;
		this.pendingWinPortion = pendingWinPortion;
		this.subwalletPortion = subwalletPortion;
		this.isCancel = isCancel;
		this.txnDevice = txnDevice;
		this.userAgent = userAgent;
		this.subWalletId = subWalletId;
		this.setDeviceLocMapId(deviceLocMapId);

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

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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

	public Double getWinPortion() {
		return winPortion;
	}

	public void setWinPortion(Double winPortion) {
		this.winPortion = winPortion;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public Integer getDeviceLocMapId() {
		return deviceLocMapId;
	}

	public void setDeviceLocMapId(Integer deviceLocMapId) {
		this.deviceLocMapId = deviceLocMapId;
	}

}