package com.stpl.pms.javabeans;

import java.io.Serializable;

public class VipLevelCriteriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String criteriaCode;
	private String criteriaName;
	private String relatedTo;
	private String relatedColumn;
	private String criteriaStatus;

	public VipLevelCriteriaBean() {
		// TODO Auto-generated constructor stub
	}

	public VipLevelCriteriaBean(Integer id, String criteriaCode,
			String criteriaName, String relatedTo, String relatedColumn,
			String criteriaStatus) {
		this.id = id;
		this.criteriaCode = criteriaCode;
		this.criteriaName = criteriaName;
		this.relatedTo = relatedTo;
		this.relatedColumn = relatedColumn;
		this.criteriaStatus = criteriaStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCriteriaCode() {
		return criteriaCode;
	}

	public void setCriteriaCode(String criteriaCode) {
		this.criteriaCode = criteriaCode;
	}

	public String getCriteriaName() {
		return criteriaName;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}

	public String getRelatedTo() {
		return relatedTo;
	}

	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}

	public void setRelatedColumn(String relatedColumn) {
		this.relatedColumn = relatedColumn;
	}

	public String getRelatedColumn() {
		return relatedColumn;
	}

	public void setCriteriaStatus(String criteriaStatus) {
		this.criteriaStatus = criteriaStatus;
	}

	public String getCriteriaStatus() {
		return criteriaStatus;
	}

	@Override
	public String toString() {
		return "VipLevelCriteriaBean [criteriaCode=" + criteriaCode
				+ ", criteriaName=" + criteriaName + ", criteriaStatus="
				+ criteriaStatus + ", id=" + id + ", relatedColumn="
				+ relatedColumn + ", relatedTo=" + relatedTo + "]";
	}

}
