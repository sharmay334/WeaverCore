package com.stpl.pms.javabeans;

public class PlayerTxnStatusBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long playerId;
	private String refTxnNo;
	private Long txnId;

	private String status;
	private String errorMsg;

	public PlayerTxnStatusBean() {
	}

	public PlayerTxnStatusBean(Long playerId, String refTxnNo, Long txnId,
			String status, String errorMsg) {
		super();
		this.playerId = playerId;
		this.refTxnNo = refTxnNo;
		this.txnId = txnId;
		this.status = status;
		this.errorMsg = errorMsg;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getRefTxnNo() {
		return refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
