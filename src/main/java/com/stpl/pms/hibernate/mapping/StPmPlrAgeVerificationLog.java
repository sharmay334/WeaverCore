package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlrAgeVerificationLog entity. @author MyEclipse Persistence Tools
 */

public class StPmPlrAgeVerificationLog implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer ageVerificationLogId;
	private Long playerId;
	private Short domainId;
	private Short sourceId;
	private String uniqueTxId;
	private Timestamp reqTime;
	private String result;
	private String verificationId;
	private Boolean isNameVerified;
	private Boolean isDobVerified;
	private Boolean isAddressVerified;
	private Boolean isOver18;

	// Constructors

	/** default constructor */
	public StPmPlrAgeVerificationLog() {
	}

	/** minimal constructor */
	public StPmPlrAgeVerificationLog(Timestamp reqTime) {
		this.reqTime = reqTime;
	}

	/** full constructor */
	public StPmPlrAgeVerificationLog(Long playerId, Short domainId,
			Short sourceId, String uniqueTxId, Timestamp reqTime,
			String result, String verificationId, Boolean isNameVerified,
			Boolean isDobVerified, Boolean isAddressVerified, Boolean isOver18) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.sourceId = sourceId;
		this.uniqueTxId = uniqueTxId;
		this.reqTime = reqTime;
		this.result = result;
		this.verificationId = verificationId;
		this.isNameVerified = isNameVerified;
		this.isDobVerified = isDobVerified;
		this.isAddressVerified = isAddressVerified;
		this.isOver18 = isOver18;
	}

	// Property accessors

	public Integer getAgeVerificationLogId() {
		return this.ageVerificationLogId;
	}

	public void setAgeVerificationLogId(Integer ageVerificationLogId) {
		this.ageVerificationLogId = ageVerificationLogId;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Short getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(Short sourceId) {
		this.sourceId = sourceId;
	}

	public String getUniqueTxId() {
		return this.uniqueTxId;
	}

	public void setUniqueTxId(String uniqueTxId) {
		this.uniqueTxId = uniqueTxId;
	}

	public Timestamp getReqTime() {
		return this.reqTime;
	}

	public void setReqTime(Timestamp reqTime) {
		this.reqTime = reqTime;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getVerificationId() {
		return this.verificationId;
	}

	public void setVerificationId(String verificationId) {
		this.verificationId = verificationId;
	}

	public Boolean getIsNameVerified() {
		return this.isNameVerified;
	}

	public void setIsNameVerified(Boolean isNameVerified) {
		this.isNameVerified = isNameVerified;
	}

	public Boolean getIsDobVerified() {
		return this.isDobVerified;
	}

	public void setIsDobVerified(Boolean isDobVerified) {
		this.isDobVerified = isDobVerified;
	}

	public Boolean getIsAddressVerified() {
		return this.isAddressVerified;
	}

	public void setIsAddressVerified(Boolean isAddressVerified) {
		this.isAddressVerified = isAddressVerified;
	}

	public Boolean getIsOver18() {
		return this.isOver18;
	}

	public void setIsOver18(Boolean isOver18) {
		this.isOver18 = isOver18;
	}

}