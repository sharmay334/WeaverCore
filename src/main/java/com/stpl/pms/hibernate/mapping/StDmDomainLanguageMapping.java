package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StDmDomainLanguageMapping entity. @author MyEclipse Persistence Tools
 */

public class StDmDomainLanguageMapping implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short domainId;
	private StGenLanguageMaster languageMaster;
	private String status;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;
	

	// Constructors

	public StGenLanguageMaster getLanguageMaster() {
		return languageMaster;
	}

	public void setLanguageMaster(StGenLanguageMaster languageMaster) {
		this.languageMaster = languageMaster;
	}

	/** default constructor */
	public StDmDomainLanguageMapping() {
	}

	/** full constructor */
	public StDmDomainLanguageMapping(Short domainId, StGenLanguageMaster languageMaster,
			String status) {
		this.domainId = domainId;
		this.languageMaster = languageMaster;
		this.status = status;
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