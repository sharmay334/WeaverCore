package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StRgOperatorLimit entity. @author MyEclipse Persistence Tools
 */

public class StRgOperatorLimit implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short domainId;
	private Integer vipLevel;
	private Integer opLimit;
	private String status;
	private StRgOperatorCriteriaMaster criteriaMaster;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;
	// Constructors

	/** default constructor */
	public StRgOperatorLimit() {
	}

	public StRgOperatorLimit(Integer vipLevel,Integer opLimit,String status,StRgOperatorCriteriaMaster criteriaMaster) {
		this.vipLevel = vipLevel;
		this.opLimit = opLimit;
		this.status = status;
		this.criteriaMaster = criteriaMaster;
	}
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Integer getVipLevel() {
		return this.vipLevel;
	}

	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

	public Integer getOpLimit() {
		return this.opLimit;
	}

	public void setOpLimit(Integer opLimit) {
		this.opLimit = opLimit;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StRgOperatorCriteriaMaster getCriteriaMaster() {
		return criteriaMaster;
	}

	public void setCriteriaMaster(StRgOperatorCriteriaMaster criteriaMaster) {
		this.criteriaMaster = criteriaMaster;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
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