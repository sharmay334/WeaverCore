package com.stpl.pms.javabeans;

import java.sql.Timestamp;

public class CashierResponseBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long playerId;
	private Long requestId;
	private Long txnId;
	private Double requestAmount;
	private Double netAmount;
	private String status;
	private String txnType;
	private Timestamp requestTime;

	private String responseMsg;
	private String responseUrl;
	private Boolean firstDeposit;
	private Double bonusAmount;
	private String playerSessionId;
	private String paymentType;
	private String paySubType;
	private String promoCodeApplied;
	private String bonusType;

	private PlayerWalletBean walletInfo;

	public CashierResponseBean() {
		// TODO Auto-generated constructor stub
	}

	public CashierResponseBean(Long playerId, Long requestId, Long txnId,
			Double requestAmount, Double netAmount, String status,
			String txnType, Timestamp requestTime, String responseMsg,
			String responseUrl, Boolean firstDeposit,
			PlayerWalletBean walletInfo, Double bonusAmount,String playerSessionId) {
		super();
		this.playerId = playerId;
		this.requestId = requestId;
		this.txnId = txnId;
		this.requestAmount = requestAmount;
		this.netAmount = netAmount;
		this.status = status;
		this.txnType = txnType;
		this.requestTime = requestTime;
		this.responseMsg = responseMsg;
		this.responseUrl = responseUrl;
		this.firstDeposit = firstDeposit;
		this.walletInfo = walletInfo;
		this.bonusAmount = bonusAmount;
		this.playerSessionId = playerSessionId;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public Double getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(Double requestAmount) {
		this.requestAmount = requestAmount;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Timestamp getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getResponseUrl() {
		return responseUrl;
	}

	public void setResponseUrl(String responseUrl) {
		this.responseUrl = responseUrl;
	}

	public void prepareResponse(Long playerId, Long requestId,
			Double requestAmount, Double netAmount, String status,
			String txnType, Timestamp requestTime, String responseMsg,
			String responseUrl, Boolean firstDeposit,
			PlayerWalletBean walletInfo, Double bonusAmount) {
		this.playerId = playerId;
		this.requestId = requestId;
		this.requestAmount = requestAmount;
		this.netAmount = netAmount;
		this.status = status;
		this.txnType = txnType;
		this.requestTime = requestTime;
		this.responseMsg = responseMsg;
		this.responseUrl = responseUrl;
		this.firstDeposit = firstDeposit;
		this.walletInfo = walletInfo;
		this.bonusAmount = bonusAmount;
	}

	public void setFirstDeposit(Boolean firstDeposit) {
		this.firstDeposit = firstDeposit;
	}

	public Boolean getFirstDeposit() {
		return firstDeposit;
	}

	public void setWalletInfo(PlayerWalletBean walletInfo) {
		this.walletInfo = walletInfo;
	}

	public PlayerWalletBean getWalletInfo() {
		return walletInfo;
	}

	public void setBonusAmount(Double bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public Double getBonusAmount() {
		return bonusAmount;
	}

	public String getPlayerSessionId() {
		return playerSessionId;
	}

	public void setPlayerSessionId(String playerSessionId) {
		this.playerSessionId = playerSessionId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaySubType() {
		return paySubType;
	}

	public void setPaySubType(String paySubType) {
		this.paySubType = paySubType;
	}

	public String getPromoCodeApplied() {
		return promoCodeApplied;
	}

	public void setPromoCodeApplied(String promoCodeApplied) {
		this.promoCodeApplied = promoCodeApplied;
	}

	public String getBonusType() {
		return bonusType;
	}

	public void setBonusType(String bonusType) {
		this.bonusType = bonusType;
	}
	
	

}
