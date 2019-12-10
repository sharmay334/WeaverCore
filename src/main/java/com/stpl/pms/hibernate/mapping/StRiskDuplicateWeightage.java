package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

@SuppressWarnings("serial")
public class StRiskDuplicateWeightage implements java.io.Serializable {

	private Integer id;
	private Short domainId;
	private String fieldName;
	private String matchCriteria;
	private Integer weightage;
	private String sectionName;
	private String status;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;

	/** default constructor */
	public StRiskDuplicateWeightage() {
	}

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

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMatchCriteria() {
		return this.matchCriteria;
	}

	public void setMatchCriteria(String matchCriteria) {
		this.matchCriteria = matchCriteria;
	}

	public Integer getWeightage() {
		return this.weightage;
	}

	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
	}

	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
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