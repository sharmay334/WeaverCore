package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;


/**
 * StTxnPlrWagerMasterCasino6 entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrWagerMasterCasino6 implements java.io.Serializable, StTxnWagerMaster {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Timestamp transactionDate;
	private Double amount;
	private Double amountNative;
	private Integer currencyId;
	private Long gameId;
	private Double vatAmount;
	private Double vatAmountNative;
	private String refTxnNo;
	private Double wgrContriAmt;
	private String gameType;
	private String gameName;
	private Short vendorId;
	private Double cashPortion;
	private Double bonusPortion;
	private Double depPortion;
	private Double winPortion;
	private Double pendingWinPortion;
	private Double subwalletPortion;
	private Double processChargeRefund;
	private Double withdrawableBalPortion;
	private String wagerStatus;
	private Timestamp confirmationDate;
	private String isCancel;
	private String txnDevice;
	private String userAgent;
	private String os;
	private String browser;
	private String model;
	private Long subWalletId;
	private Double rake;
	private Double bonusToCash;
	private Integer deviceLocMapId;
    private String walletProvider;
    // Constructors

	/** default constructor */
	public StTxnPlrWagerMasterCasino6() {
	}

	/** minimal constructor */
	public StTxnPlrWagerMasterCasino6(Long transactionId, Long playerId,
			Short domainId, Timestamp transactionDate, Double amount,
			Double amountNative, Integer currencyId, Short vendorId,
			Double cashPortion, Double bonusPortion, Double pendingWinPortion,
			Double subwalletPortion, Double processChargeRefund,
			Double withdrawableBalPortion, String wagerStatus, String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.amountNative = amountNative;
		this.currencyId = currencyId;
		this.vendorId = vendorId;
		this.cashPortion = cashPortion;
		this.bonusPortion = bonusPortion;
		this.pendingWinPortion = pendingWinPortion;
		this.subwalletPortion = subwalletPortion;
		this.processChargeRefund = processChargeRefund;
		this.withdrawableBalPortion = withdrawableBalPortion;
		this.wagerStatus = wagerStatus;
		this.isCancel = isCancel;
	}

	/** full constructor */
	public StTxnPlrWagerMasterCasino6(Long transactionId, Long playerId,
			Short domainId, short aliasId, Timestamp transactionDate, Double amount,
			Double amountNative, Integer currencyId, Long gameId,
			Double vatAmount, Double vatAmountNative, String refTxnNo,
			Double wgrContriAmt, String gameType, String gameName,
			Short vendorId, Double cashPortion, Double bonusPortion, Double depPortion, Double winPortion,
			Double pendingWinPortion, Double subwalletPortion,
			Double processChargeRefund, Double withdrawableBalPortion,
			String wagerStatus, String isCancel,String txnDevice,String userAgent,Long subWalletId,Double rake, Integer deviceLocMapId) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.amountNative = amountNative;
		this.currencyId = currencyId;
		this.gameId = gameId;
		this.vatAmount = vatAmount;
		this.vatAmountNative = vatAmountNative;
		this.refTxnNo = refTxnNo;
		this.wgrContriAmt = wgrContriAmt;
		this.gameType = gameType;
		this.gameName = gameName;
		this.vendorId = vendorId;
		this.cashPortion = cashPortion;
		this.bonusPortion = bonusPortion;
		this.depPortion = depPortion;
		this.winPortion = winPortion;
		this.pendingWinPortion = pendingWinPortion;
		this.subwalletPortion = subwalletPortion;
		this.processChargeRefund = processChargeRefund;
		this.withdrawableBalPortion = withdrawableBalPortion;
		this.wagerStatus = wagerStatus;
		this.isCancel = isCancel;
		this.txnDevice = txnDevice;
		this.userAgent = userAgent;
		this.subWalletId = subWalletId;
		this.rake = rake;
		this.deviceLocMapId = deviceLocMapId;
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

	public Long getGameId() {
		return this.gameId;
	}

	public void setGameId(Long gameId) {
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

	public Timestamp getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(Timestamp confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public Long getSubWalletId() {
		return subWalletId;
	}

	public void setSubWalletId(Long subWalletId) {
		this.subWalletId = subWalletId;
	}

	public Double getRake() {
		return rake;
	}

	public void setRake(Double rake) {
		this.rake = rake;
	}

	public Double getBonusToCash() {
		return bonusToCash;
	}

	public void setBonusToCash(Double bonusToCash) {
		this.bonusToCash = bonusToCash;
	}

	public Double getDepPortion() {
		return depPortion;
	}

	public void setDepPortion(Double depPortion) {
		this.depPortion = depPortion;
	}

	public Double getWinPortion() {
		return winPortion;
	}

	public void setWinPortion(Double winPortion) {
		this.winPortion = winPortion;
	}

	public Integer getDeviceLocMapId() {
		return deviceLocMapId;
	}

	public void setDeviceLocMapId(Integer deviceLocMapId) {
		this.deviceLocMapId = deviceLocMapId;
	}

    public String getWalletProvider() {
        return walletProvider;
    }

    public void setWalletProvider(String walletProvider) {
        this.walletProvider = walletProvider;
    }



}