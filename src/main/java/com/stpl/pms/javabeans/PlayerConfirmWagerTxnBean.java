package com.stpl.pms.javabeans;

public class PlayerConfirmWagerTxnBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String sessionId;
	private Long playerId;
	private Short aliasId;
	private String aliasName;
	private String walletType;
	private Double wrContriPer;
	private Long refWagerTxnId;
	private Double amount;

	public PlayerConfirmWagerTxnBean() {
		
	}

	public PlayerConfirmWagerTxnBean(String sessionId, Long playerId, Short aliasId,
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

	
}
