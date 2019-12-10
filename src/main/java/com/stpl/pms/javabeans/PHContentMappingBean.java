package com.stpl.pms.javabeans;

import java.sql.Timestamp;

public class PHContentMappingBean {

	private Integer phId;
	private Integer groupId;
	private Integer phCriteriaId;
	private String ctIdWithValue;
	private Integer contentId;
	private String mappingStatus;
	private String redirectUrl;
	private Timestamp startDate ;
	private Timestamp endDate ;

	public Integer getPhId() {
		return phId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public Integer getPhCriteriaId() {
		return phCriteriaId;
	}

	public void setPhId(Integer phId) {
		this.phId = phId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public void setPhCriteriaId(Integer phCriteriaId) {
		this.phCriteriaId = phCriteriaId;
	}

	public String getCtIdWithValue() {
		return ctIdWithValue;
	}

	public void setCtIdWithValue(String ctIdWithValue) {
		this.ctIdWithValue = ctIdWithValue;
	}

	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public String getMappingStatus() {
		return mappingStatus;
	}

	public void setMappingStatus(String mappingStatus) {
		this.mappingStatus = mappingStatus;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
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
