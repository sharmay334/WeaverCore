package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrWithdrawalResponseMpower entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrWithdrawalResponseMpower implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long requestId;
	private String txId;
	private String message;
	private String status;

	// Constructors

	/** default constructor */
	public StCshPlrWithdrawalResponseMpower() {
	}

	/** minimal constructor */
	public StCshPlrWithdrawalResponseMpower(Long requestId) {
		this.requestId = requestId;
	}

	/** full constructor */
	public StCshPlrWithdrawalResponseMpower(Long requestId, String txId,
			String message, String status) {
		this.requestId = requestId;
		this.txId = txId;
		this.message = message;
		this.status = status;
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

	public String getTxId() {
		return this.txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}