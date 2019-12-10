package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrDepositResponseOla entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositResponseOla implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long requestId;
	private Long playerId;
	private String serialNo;
	private String pinNo;
	private String refTxnNo;
	private Double amount;
	private String depositType;
	private String errorCode;
	private String errorMsg;

	// Constructors

	/** default constructor */
	public StCshPlrDepositResponseOla() {
	}

	/** full constructor */
	public StCshPlrDepositResponseOla(Long requestId, Long playerId,
			String serialNo, String pinNo, String refTxnNo, Double amount,
			String depositType, String errorCode, String errorMsg) {
		this.requestId = requestId;
		this.playerId = playerId;
		this.serialNo = serialNo;
		this.pinNo = pinNo;
		this.refTxnNo = refTxnNo;
		this.amount = amount;
		this.depositType = depositType;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getPinNo() {
		return this.pinNo;
	}

	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}

	public String getRefTxnNo() {
		return this.refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDepositType() {
		return this.depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return this.errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}