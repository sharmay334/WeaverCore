package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StCshPlrDepositResponseGharpay entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositResponseGharpay implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Long requestId;
	private String gharpayOrderId;
	private String errorCode;
	private String errorMsg;
	private Timestamp responseTime;
	private String status;

	// Constructors

	/** default constructor */
	public StCshPlrDepositResponseGharpay() {
	}

	/** minimal constructor */
	public StCshPlrDepositResponseGharpay(Long playerId, Long requestId,
			String status) {
		this.playerId = playerId;
		this.requestId = requestId;
		this.status = status;
	}

	/** full constructor */
	public StCshPlrDepositResponseGharpay(Long playerId, Long requestId,
			String gharpayOrderId, String errorCode, String errorMsg,
			Timestamp responseTime, String status) {
		this.playerId = playerId;
		this.requestId = requestId;
		this.gharpayOrderId = gharpayOrderId;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.responseTime = responseTime;
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getGharpayOrderId() {
		return this.gharpayOrderId;
	}

	public void setGharpayOrderId(String gharpayOrderId) {
		this.gharpayOrderId = gharpayOrderId;
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

	public Timestamp getResponseTime() {
		return this.responseTime;
	}

	public void setResponseTime(Timestamp responseTime) {
		this.responseTime = responseTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}