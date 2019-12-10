package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StDmBlockedEmailId entity. @author MyEclipse Persistence Tools
 */

public class StDmBlockedEmailId implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String emailId;
	private Integer userId;
	private Timestamp dateTime;
	private String status;
	private Short domainId;
	private String reason;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;

	// Constructors

	/** default constructor */
	public StDmBlockedEmailId() {
	}

	/** full constructor */
	public StDmBlockedEmailId(String emailId, Integer userId,
			Timestamp dateTime, String status, Short domainId, String reason,Long lastUpdatedBy,Timestamp lastUpdationTime) {
		this.emailId = emailId;
		this.userId = userId;
		this.dateTime = dateTime;
		this.status = status;
		this.domainId = domainId;
		this.reason = reason;
		this.lastUpdatedBy=lastUpdatedBy;
		this.lastUpdationTime=lastUpdationTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setLastUpdationTime(Timestamp lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}

	public Timestamp getLastUpdationTime() {
		return lastUpdationTime;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

}