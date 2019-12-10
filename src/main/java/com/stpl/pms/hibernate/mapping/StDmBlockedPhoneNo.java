package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StDmBlockedPhoneNo entity. @author MyEclipse Persistence Tools
 */

public class StDmBlockedPhoneNo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Long phoneNo;
	private Integer userId;
	private Timestamp dateTime;
	private String status;
	private Short domainId;
	private String reason;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;

	// Constructors

	/** default constructor */
	public StDmBlockedPhoneNo() {
	}

	/** full constructor */
	public StDmBlockedPhoneNo(Long phoneNo, Integer userId, Timestamp dateTime,
			String status, Short domainId, String reason, Long lastUpdatedBy, Timestamp lastUpdationTime) {
		this.phoneNo = phoneNo;
		this.userId = userId;
		this.dateTime = dateTime;
		this.status = status;
		this.domainId = domainId;
		this.reason = reason;
		this.lastUpdatedBy= lastUpdatedBy;
		this.lastUpdationTime=lastUpdationTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
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