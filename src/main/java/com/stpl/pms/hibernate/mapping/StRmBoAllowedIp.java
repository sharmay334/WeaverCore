package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * StBoAllowedIp entity. @author MyEclipse Persistence Tools
 */
@Entity
public class StRmBoAllowedIp implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Short id;
	private Short domainId;
	private String allowedIp;
	private String status;
	private Integer userId;
	private String reason;
	private Long lastUpdatedBy;
	private Timestamp creationTime;
	private Timestamp lastUpdationTime;

	// Constructors

	/** default constructor */
	public StRmBoAllowedIp() {
	}
	public StRmBoAllowedIp(Short id, Short domainId, String allowedIp,
			String status, Integer userId, String reason) {
		super();
		this.id = id;
		this.domainId = domainId;
		this.allowedIp = allowedIp;
		this.status = status;
		this.userId = userId;
		this.reason = reason;
	}


	// Property accessors

	

	public Short getDomainId() {
		return domainId;
	}


	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}


	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getAllowedIp() {
		return this.allowedIp;
	}

	public void setAllowedIp(String allowedIp) {
		this.allowedIp = allowedIp;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Timestamp getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
	public Timestamp getLastUpdationTime() {
		return lastUpdationTime;
	}
	public void setLastUpdationTime(Timestamp lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}

}