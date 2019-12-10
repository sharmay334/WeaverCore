package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlrVerificationMaster entity. @author MyEclipse Persistence Tools
 */

public class StPmPlrVerificationMaster implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long verificationId;
	private Long playerId;
	private String emailVerificationCode;
	private Timestamp emailVerificationExpiry;
	private String mobVerificationCode;
	private Timestamp mobVerificationExpiry;
	private String passwordVerificationCode;
	private Timestamp passwordVerificationExpiry;

	// Constructors

	/** default constructor */
	public StPmPlrVerificationMaster() {
	}

	/** minimal constructor */
	public StPmPlrVerificationMaster(Long playerId) {
		this.playerId = playerId;
	}

	/** full constructor */
	public StPmPlrVerificationMaster(Long playerId,
			String emailVerificationCode, Timestamp emailVerificationExpiry,
			String mobVerificationCode, Timestamp mobVerificationExpiry,
			String passwordVerificationCode,
			Timestamp passwordVerificationExpiry) {
		this.playerId = playerId;
		this.emailVerificationCode = emailVerificationCode;
		this.emailVerificationExpiry = emailVerificationExpiry;
		this.mobVerificationCode = mobVerificationCode;
		this.mobVerificationExpiry = mobVerificationExpiry;
		this.passwordVerificationCode = passwordVerificationCode;
		this.passwordVerificationExpiry = passwordVerificationExpiry;
	}

	// Property accessors

	public Long getVerificationId() {
		return this.verificationId;
	}

	public void setVerificationId(Long verificationId) {
		this.verificationId = verificationId;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getEmailVerificationCode() {
		return this.emailVerificationCode;
	}

	public void setEmailVerificationCode(String emailVerificationCode) {
		this.emailVerificationCode = emailVerificationCode;
	}

	public Timestamp getEmailVerificationExpiry() {
		return this.emailVerificationExpiry;
	}

	public void setEmailVerificationExpiry(Timestamp emailVerificationExpiry) {
		this.emailVerificationExpiry = emailVerificationExpiry;
	}

	public String getMobVerificationCode() {
		return this.mobVerificationCode;
	}

	public void setMobVerificationCode(String mobVerificationCode) {
		this.mobVerificationCode = mobVerificationCode;
	}

	public Timestamp getMobVerificationExpiry() {
		return this.mobVerificationExpiry;
	}

	public void setMobVerificationExpiry(Timestamp mobVerificationExpiry) {
		this.mobVerificationExpiry = mobVerificationExpiry;
	}

	public String getPasswordVerificationCode() {
		return this.passwordVerificationCode;
	}

	public void setPasswordVerificationCode(String passwordVerificationCode) {
		this.passwordVerificationCode = passwordVerificationCode;
	}

	public Timestamp getPasswordVerificationExpiry() {
		return this.passwordVerificationExpiry;
	}

	public void setPasswordVerificationExpiry(
			Timestamp passwordVerificationExpiry) {
		this.passwordVerificationExpiry = passwordVerificationExpiry;
	}

}