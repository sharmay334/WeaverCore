package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmSecurityQuesMaster entity. @author MyEclipse Persistence Tools
 */

public class StPmSecurityQuesMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long secQuesId;
	private String secQuesDispName;
	private Integer secQues;
	private String addedBy;
	private Short domainId;
	private String status;
	private Long userId;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;
	

	// Constructors

	/** default constructor */
	public StPmSecurityQuesMaster() {
	}

	/** full constructor */
	public StPmSecurityQuesMaster(Integer secQues,String secQuesDispName,String addedBy,
			Short domainId, String status, Long userId, Timestamp creationTime, Long lastUpdatedBy, Timestamp lastUpdationTime ) {
		this.secQuesDispName = secQuesDispName;
		this.secQues = secQues;
		this.addedBy = addedBy;
		this.domainId = domainId;
		this.status = status;
		this.userId = userId;
		this.creationTime=creationTime;
		this.lastUpdatedBy=lastUpdatedBy;
		this.lastUpdationTime=lastUpdationTime;
	}

	// Property accessors

	public Long getSecQuesId() {
		return this.secQuesId;
	}

	public void setSecQuesId(Long secQuesId) {
		this.secQuesId = secQuesId;
	}

	public Integer getSecQues() {
		return this.secQues;
	}

	public void setSecQues(Integer secQues) {
		this.secQues = secQues;
	}

	public String getAddedBy() {
		return this.addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setSecQuesDispName(String secQuesDispName) {
		this.secQuesDispName = secQuesDispName;
	}

	public String getSecQuesDispName() {
		return secQuesDispName;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdationTime() {
		return lastUpdationTime;
	}

	public void setLastUpdationTime(Timestamp lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}

}