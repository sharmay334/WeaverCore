package com.stpl.pms.javabeans;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown= true)
public class PlayerTxnBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String sessionId;
	private Long playerId;
	private Short aliasId;
	private String aliasName;
	private String walletType;
	private Double wrContriPer;
	private Long refWagerTxnId;
	private Double amount;
	private String balanceType;
	private String currencyCode;
	private Long gameId;
	private String gameType;
	private String gameName;
	private String device;
	private String platform;
	private String os;
	private String browser;
	private String model;
	private String isWithdrawable;
	private String particular;
	private String userAgent;
	private String refTxnNo;
	private boolean deviceCheck;
	private String macAddress;
	private Integer deviceLocMapId;
	private String tmpId;
	private Long tktId;
	private Double taxes;
	private Double won;
	private Double jackpot;
	public PlayerTxnBean() {
		
	}
	
	public PlayerTxnBean(String playerId, Short aliasId, String walletType,
			String refWagerTxnId, String balanceType, String particular) {
		this.playerId = (playerId!=null?Long.valueOf(playerId):null);;
		this.aliasId = aliasId;
		this.walletType = walletType;
		this.refWagerTxnId = (refWagerTxnId!=null?Long.valueOf(refWagerTxnId):null);
		this.balanceType = balanceType;
		this.particular = particular;
	}

	public PlayerTxnBean(String sessionId, Long playerId, Short aliasId,
			Double wrContriPer, Long refWagerTxnId) {
		this.sessionId = sessionId;
		this.playerId = playerId;
		this.aliasId = aliasId;
		this.wrContriPer = wrContriPer;
		this.refWagerTxnId = refWagerTxnId;
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

	public void setWrContriPer(Double wrContriPer) {
		this.wrContriPer = wrContriPer;
	}

	public Double getWrContriPer() {
		return wrContriPer;
	}

	public void setRefWagerTxnId(Long refWagerTxnId) {
		this.refWagerTxnId = refWagerTxnId;
	}

	public Long getRefWagerTxnId() {
		return refWagerTxnId;
	}

	public void setWalletType(String walletType) {
		this.walletType = walletType;
	}

	public String getWalletType() {
		return walletType;
	}

	@Override
	public String toString() {
		return "PlayerConfirmWagerTxnBean [playerId=" + playerId
				+ ", refWagerTxnId=" + refWagerTxnId + ", sessionId="
				+ sessionId + ", walletType=" + walletType + ", wrContriPer="
				+ wrContriPer + "]";
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getBalanceType() {
		return balanceType;
	}

	public void setBalanceType(String balanceType) {
		this.balanceType = balanceType;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public String getGameType() {
		return gameType;
	}

	public String getGameName() {
		return gameName;
	}

	public String getDevice() {
		return device;
	}

	public String getPlatform() {
		return platform;
	}

	public String getOs() {
		return os;
	}

	public String getBrowser() {
		return browser;
	}

	public String getModel() {
		return model;
	}

	public String getIsWithdrawable() {
		return isWithdrawable;
	}

	public String getParticular() {
		return particular;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setIsWithdrawable(String isWithdrawable) {
		this.isWithdrawable = isWithdrawable;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getRefTxnNo() {
		return refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public boolean isDeviceCheck() {
		return deviceCheck;
	}

	public void setDeviceCheck(boolean deviceCheck) {
		this.deviceCheck = deviceCheck;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public Integer getDeviceLocMapId() {
		return deviceLocMapId;
	}

	public void setDeviceLocMapId(Integer deviceLocMapId) {
		this.deviceLocMapId = deviceLocMapId;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getTmpId() {
		return tmpId;
	}

	public void setTmpId(String tmpId) {
		this.tmpId = tmpId;
	}

	public Long getTktId() {
		return tktId;
	}

	public void setTktId(Long tktId) {
		this.tktId = tktId;
	}

	public Double getTaxes() {
		return taxes;
	}

	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}

	public Double getWon() {
		return won;
	}

	public void setWon(Double won) {
		this.won = won;
	}

	public Double getJackpot() {
		return jackpot;
	}

	public void setJackpot(Double jackpot) {
		this.jackpot = jackpot;
	}

}
