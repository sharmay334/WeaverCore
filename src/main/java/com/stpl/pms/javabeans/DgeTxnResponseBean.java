package com.stpl.pms.javabeans;

import java.util.ArrayList;
import java.util.List;

public class DgeTxnResponseBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String sessionId;
	private Long playerId;
	private Short gameId;
	private String subWalletRefNo;
	private String subWalletTime;
	private String txnType;
	private Double realBal;
	private Double promoBal;
	private Double totalBal;
	private Double pendingWinning;
	private Double practiceBal;
	private List<TransactionDetailBean> transactionInfoList;
	private Integer errorCode;
	private String errorMsg;
	private Double bonusToCash;
	private String device;
	private String platform;

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

	public Short getGameId() {
		return gameId;
	}

	public void setGameId(Short gameId) {
		this.gameId = gameId;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Double getRealBal() {
		return realBal;
	}

	public void setRealBal(Double realBal) {
		this.realBal = realBal;
	}

	public Double getPromoBal() {
		return promoBal;
	}

	public void setPromoBal(Double promoBal) {
		this.promoBal = promoBal;
	}

	public Double getTotalBal() {
		return totalBal;
	}

	public void setTotalBal(Double totalBal) {
		this.totalBal = totalBal;
	}

	public Double getPendingWinning() {
		return pendingWinning;
	}

	public void setPendingWinning(Double pendingWinning) {
		this.pendingWinning = pendingWinning;
	}

	public Double getPracticeBal() {
		return practiceBal;
	}

	public void setPracticeBal(Double practiceBal) {
		this.practiceBal = practiceBal;
	}

	public List<TransactionDetailBean> getTransactionInfoList() {
		return transactionInfoList;
	}

	public void setTransactionInfoList(
			List<TransactionDetailBean> transactionInfoList) {
		this.transactionInfoList = transactionInfoList;
	}

	public void setTransactionInfoList(TransactionDetailBean transactionInfoBean) {
		if (this.transactionInfoList == null) {
			this.transactionInfoList = new ArrayList<TransactionDetailBean>();
		}
		this.transactionInfoList.add(transactionInfoBean);
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void setSubWalletRefNo(String subWalletRefNo) {
		this.subWalletRefNo = subWalletRefNo;
	}

	public String getSubWalletRefNo() {
		return subWalletRefNo;
	}

	public Double getBonusToCash() {
		return bonusToCash;
	}

	public void setBonusToCash(Double bonusToCash) {
		this.bonusToCash = bonusToCash;
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


}
