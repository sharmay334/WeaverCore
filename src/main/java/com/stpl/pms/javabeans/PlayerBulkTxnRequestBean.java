package com.stpl.pms.javabeans;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown= true)
public class PlayerBulkTxnRequestBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private VendorAuthInfoBean vendorAuthenticationInfo;
	private String sessionId;
	private String aliasName;
	private short aliasId;
	private Long playerId;
	private String serviceCode;
	private String gameType;
	private String gameName;
	private Long gameId;
	private Double wrContriAmount;
	private String isNewSubWallet;
	private Boolean wagerConfirmation;
	private String particular;
	private String txnType;
	private Double rake;
	private String subWalletRefNo;
	private String subWalletTime;
	private String device;
	private String platform;
	private String os;
	private String browser;
	private String model;
	private String isWithdrawable;
	private String userAgent;
	private Double wagerValue;
	private String gameSessionId;
	
	private List<TransactionDetailBean> transactionInfoList;

	private String wagerRefColumn;
	
	//for get balance only
	
	public VendorAuthInfoBean getVendorAuthenticationInfo() {
		return vendorAuthenticationInfo;
	}

	public void setVendorAuthenticationInfo(
			VendorAuthInfoBean vendorAuthenticationInfo) {
		this.vendorAuthenticationInfo = vendorAuthenticationInfo;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public Double getWrContriAmount() {
		return wrContriAmount;
	}

	public void setWrContriAmount(Double wrContriAmount) {
		this.wrContriAmount = wrContriAmount;
	}

	public String getIsNewSubWallet() {
		return isNewSubWallet;
	}

	public void setIsNewSubWallet(String isNewSubWallet) {
		this.isNewSubWallet = isNewSubWallet;
	}

	public Boolean getWagerConfirmation() {
		return wagerConfirmation;
	}

	public void setWagerConfirmation(Boolean wagerConfirmation) {
		this.wagerConfirmation = wagerConfirmation;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Double getRake() {
		return rake;
	}

	public void setRake(Double rake) {
		this.rake = rake;
	}

	public String getSubWalletRefNo() {
		return subWalletRefNo;
	}

	public void setSubWalletRefNo(String subWalletRefNo) {
		this.subWalletRefNo = subWalletRefNo;
	}

	public void setTransactionInfoList(List<TransactionDetailBean> transactionInfoList) {
		this.transactionInfoList = transactionInfoList;
	}
	
	@JsonIgnore
	public void setTransactionInfoList(TransactionDetailBean transactionInfoBean) {
		if(this.transactionInfoList == null){
			this.transactionInfoList = new ArrayList<TransactionDetailBean>();
		}
		this.transactionInfoList.add(transactionInfoBean);
	}

	public List<TransactionDetailBean> getTransactionInfoList() {
		return transactionInfoList;
	}

	public void setWagerRefColumn(String wagerRefColumn) {
		this.wagerRefColumn = wagerRefColumn;
	}

	public String getWagerRefColumn() {
		return wagerRefColumn;
	}

	public String getSubWalletTime() {
		return subWalletTime;
	}

	public void setSubWalletTime(String subWalletTime) {
		this.subWalletTime = subWalletTime;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
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

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public short getAliasId() {
		return aliasId;
	}

	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}

	public String getIsWithdrawable() {
		return isWithdrawable;
	}

	public void setIsWithdrawable(String isWithdrawable) {
		this.isWithdrawable = isWithdrawable;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public Double getWagerValue() {
		return wagerValue;
	}

	public void setWagerValue(Double wagerValue) {
		this.wagerValue = wagerValue;
	}

	public String getGameSessionId() {
		return gameSessionId;
	}

	public void setGameSessionId(String gameSessionId) {
		this.gameSessionId = gameSessionId;
	}
	
	
}
