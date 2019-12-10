package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StDmDomainCurrencyMapping entity. @author MyEclipse Persistence Tools
 */

public class StDmDomainCurrencyMapping implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short domainId;
	private String status;
	private StGenCurrencyMaster currencyMaster;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;
	

	// Constructors

	/** default constructor */
	public StDmDomainCurrencyMapping() {
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCurrencyMaster(StGenCurrencyMaster currencyMaster) {
		this.currencyMaster = currencyMaster;
	}

	public StGenCurrencyMaster getCurrencyMaster() {
		return currencyMaster;
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