package com.stpl.pms.javabeans;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class PlrWiseTxnRespBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String sessionId;
	private Long playerId;
	private Long refWagerTxnId;
	private Double bonusToCash;
	private String response;
	private String errorMsg;
	private int errorCode;
	private Double realBal;
	private Double promoBal;
	private Double totalBal;
	private Double pendingWinning;
	private Double practiceBal;
	private Long txnId;
	private Short gameId;
	private String refTxnNo;
	
	public PlrWiseTxnRespBean() {
	}

	public PlrWiseTxnRespBean(String sessionId, Long playerId,
			Long refWagerTxnId, String response, String errorMsg,
			int errorCode,Double bonusToCash) {
		this.sessionId = sessionId;
		this.playerId = playerId;
		this.response = response;
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
		this.refWagerTxnId = refWagerTxnId;
		this.bonusToCash = bonusToCash;
	}
	public PlrWiseTxnRespBean(String sessionId, Long playerId,
			Long refWagerTxnId, String response, String errorMsg,
			int errorCode,Double bonusToCash,String refTxnNo) {
		this.sessionId = sessionId;
		this.playerId = playerId;
		this.response = response;
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
		this.refWagerTxnId = refWagerTxnId;
		this.bonusToCash = bonusToCash;
		this.refTxnNo = refTxnNo;
	}
	
	/*@JsonIgnore
	public BulkTxnStatusBean getBulkTxnStatusBean() {
		BulkTxnStatusBean bean=new BulkTxnStatusBean();
		bean.setTxnId(txnId);
//		bean.setTxnType("WINNING");
		bean.setTotalBal(totalBal);
		bean.setRealBal(realBal);
		bean.setErrorCode(errorCode);
		bean.setErrorMsg(errorMsg);
		bean.setRefTxnNo(refTxnNo);
		return bean;
	}*/

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
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

	public void setRefWagerTxnId(Long refWagerTxnId) {
		this.refWagerTxnId = refWagerTxnId;
	}

	public Long getRefWagerTxnId() {
		return refWagerTxnId;
	}

	@Override
	public String toString() {
		return "PlrWiseTxnRespBean [errorCode=" + errorCode
				+ ", errorMsg=" + errorMsg + ", playerId=" + playerId
				+ ", refWagerTxnId=" + refWagerTxnId + ", response=" + response
				+ ", sessionId=" + sessionId + "]";
	}

	public Double getBonusToCash() {
		return bonusToCash;
	}

	public void setBonusToCash(Double bonusToCash) {
		this.bonusToCash = bonusToCash;
	}

	public Double getRealBal() {
		return realBal;
	}

	public Double getPromoBal() {
		return promoBal;
	}

	public Double getTotalBal() {
		return totalBal;
	}

	public Double getPendingWinning() {
		return pendingWinning;
	}

	public Double getPracticeBal() {
		return practiceBal;
	}

	public Long getTxnId() {
		return txnId;
	}

	public Short getGameId() {
		return gameId;
	}

	public void setRealBal(Double realBal) {
		this.realBal = realBal;
	}

	public void setPromoBal(Double promoBal) {
		this.promoBal = promoBal;
	}

	public void setTotalBal(Double totalBal) {
		this.totalBal = totalBal;
	}

	public void setPendingWinning(Double pendingWinning) {
		this.pendingWinning = pendingWinning;
	}

	public void setPracticeBal(Double practiceBal) {
		this.practiceBal = practiceBal;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public void setGameId(Short gameId) {
		this.gameId = gameId;
	}
	
	public String getRefTxnNo() {
		return refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

}
