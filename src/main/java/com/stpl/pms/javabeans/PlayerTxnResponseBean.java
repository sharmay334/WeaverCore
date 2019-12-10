package com.stpl.pms.javabeans;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class PlayerTxnResponseBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sessionId;
	private Long playerId;
	private Long gameId;
	private Double amount;
	private String refTxnNo;
	private String subwalletRefNo;
	private String txnType;

	private Long txnId;
	private Double realBal;
	private Double promoBal;
	private Double totalBal;
	private Double pendingWinning;
	private Double practiceBal;
	private Double bonusToCash;
	private Integer errorCode;
	private String errorMsg;
	
	private List<PlayerConfirmWagerRespBean>confirmWagerRespBean;
	private List<PlayerTxnStatusBean>transactionStatus;

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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public String getRefTxnNo() {
		return refTxnNo;
	}

	public void setTotalBal(Double totalBal) {
		this.totalBal = totalBal;
	}

	public Double getTotalBal() {
		return totalBal;
	}

	public void setPendingWinning(Double pendingWinning) {
		this.pendingWinning = pendingWinning;
	}

	public Double getPendingWinning() {
		return pendingWinning;
	}

	public void setPracticeBal(Double practiceBal) {
		this.practiceBal = practiceBal;
	}

	public Double getPracticeBal() {
		return practiceBal;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setSubwalletRefNo(String subwalletRefNo) {
		this.subwalletRefNo = subwalletRefNo;
	}

	public String getSubwalletRefNo() {
		return subwalletRefNo;
	}

	public void setConfirmWagerRespBean(List<PlayerConfirmWagerRespBean> confirmWagerRespBean) {
		this.confirmWagerRespBean = confirmWagerRespBean;
	}

	public List<PlayerConfirmWagerRespBean> getConfirmWagerRespBean() {
		return confirmWagerRespBean;
	}

	public void setTransactionStatus(List<PlayerTxnStatusBean> transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public List<PlayerTxnStatusBean> getTransactionStatus() {
		return transactionStatus;
	}

	@Override
	public String toString() {
		return "PlayerTxnResponseBean [amount=" + amount
				+ ", confirmWagerRespBean=" + confirmWagerRespBean
				+ ", errorCode=" + errorCode + ", errorMsg=" + errorMsg
				+ ", gameId=" + gameId + ", pendingWinning=" + pendingWinning
				+ ", playerId=" + playerId + ", practiceBal=" + practiceBal
				+ ", promoBal=" + promoBal + ", realBal=" + realBal
				+ ", refTxnNo=" + refTxnNo + ", sessionId=" + sessionId
				+ ", subwalletRefNo=" + subwalletRefNo + ", totalBal="
				+ totalBal + ", transactionStatus=" + transactionStatus
				+ ", txnId=" + txnId + ", txnType=" + txnType + "]";
	}

	public Double getBonusToCash() {
		return bonusToCash;
	}

	public void setBonusToCash(Double bonusToCash) {
		this.bonusToCash = bonusToCash;
	}

}
