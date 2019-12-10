package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlayerInfoChangeRequest entity. @author MyEclipse Persistence Tools
 */

public class StPmPlayerInfoChangeRequest implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Timestamp requestDate;
	private String requestFor;
	private String requestValue;
	private Long existingPlayerId;
	private String verificationCode;
	private Long verifiedPlayerId;
	private String requestStatus;

	// Constructors

	/** default constructor */
	public StPmPlayerInfoChangeRequest() {
	}

	/**
	 * minimal constructor
	 *
	 */
	public StPmPlayerInfoChangeRequest(Long playerId, Timestamp requestDate,
			String requestFor, String requestValue, String verificationCode,
			String requestStatus) {
		this.playerId = playerId;
		this.requestDate = requestDate;
		this.requestFor = requestFor;
		this.requestValue = requestValue;
		this.verificationCode = verificationCode;
		this.requestStatus = requestStatus;
	}

	/** full constructor */
	public StPmPlayerInfoChangeRequest(Long playerId, Timestamp requestDate,
			String requestFor, String requestValue, Long existingPlayerId,
			String verificationCode, Long verifiedPlayerId, String requestStatus) {
		this.playerId = playerId;
		this.requestDate = requestDate;
		this.requestFor = requestFor;
		this.requestValue = requestValue;
		this.existingPlayerId = existingPlayerId;
		this.verificationCode = verificationCode;
		this.verifiedPlayerId = verifiedPlayerId;
		this.requestStatus = requestStatus;
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

	public Timestamp getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestFor() {
		return this.requestFor;
	}

	public void setRequestFor(String requestFor) {
		this.requestFor = requestFor;
	}

	public String getRequestValue() {
		return this.requestValue;
	}

	public void setRequestValue(String requestValue) {
		this.requestValue = requestValue;
	}

	public Long getExistingPlayerId() {
		return this.existingPlayerId;
	}

	public void setExistingPlayerId(Long existingPlayerId) {
		this.existingPlayerId = existingPlayerId;
	}

	public String getVerificationCode() {
		return this.verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Long getVerifiedPlayerId() {
		return this.verifiedPlayerId;
	}

	public void setVerifiedPlayerId(Long verifiedPlayerId) {
		this.verifiedPlayerId = verifiedPlayerId;
	}

	public String getRequestStatus() {
		return this.requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

}