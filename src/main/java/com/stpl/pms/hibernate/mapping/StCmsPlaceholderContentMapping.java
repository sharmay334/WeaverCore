package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StCmsPlaceholderContentMapping entity. @author MyEclipse Persistence Tools
 */

public class StCmsPlaceholderContentMapping implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer id;
	private StCmsPlaceholderMaster phMaster;
	private StCmsContentMaster ctMaster;
	private String contentType;
	private Integer phCriteriaId;
	private String mappingStatus;
	private Integer groupId;
	private Timestamp startDate;
	private Timestamp endDate;

	// Constructors

	/** default constructor */
	public StCmsPlaceholderContentMapping() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Integer getPhCriteriaId() {
		return this.phCriteriaId;
	}

	public void setPhCriteriaId(Integer phCriteriaId) {
		this.phCriteriaId = phCriteriaId;
	}

	public String getMappingStatus() {
		return this.mappingStatus;
	}

	public void setMappingStatus(String mappingStatus) {
		this.mappingStatus = mappingStatus;
	}

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public StCmsPlaceholderMaster getPhMaster() {
		return phMaster;
	}

	public void setPhMaster(StCmsPlaceholderMaster phMaster) {
		this.phMaster = phMaster;
	}

	public StCmsContentMaster getCtMaster() {
		return ctMaster;
	}

	public void setCtMaster(StCmsContentMaster ctMaster) {
		this.ctMaster = ctMaster;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	
	

}