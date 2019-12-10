package com.stpl.pms.javabeans;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class PlayerConfirmWagerRespBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String sessionId;
	private Long playerId;
	private Long refWagerTxnId;
	private Double bonusToCash;
	private String response;
	private String errorMsg;
	private Integer errorCode;

	public PlayerConfirmWagerRespBean() {
	}

	public PlayerConfirmWagerRespBean(String sessionId, Long playerId,
			Long refWagerTxnId, String response, String errorMsg,
			Integer errorCode,Double bonusToCash) {
		this.sessionId = sessionId;
		this.playerId = playerId;
		this.response = response;
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
		this.refWagerTxnId = refWagerTxnId;
		this.bonusToCash = bonusToCash;
	}

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

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
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
		return "PlayerConfirmWagerRespBean [errorCode=" + errorCode
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

}
