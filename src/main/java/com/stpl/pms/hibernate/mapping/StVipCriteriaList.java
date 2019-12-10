package com.stpl.pms.hibernate.mapping;

/**
 * StVipCriteriaList entity. @author MyEclipse Persistence Tools
 */

public class StVipCriteriaList implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String criteriaCode;
	private String criteriaName;
	private String relatedTo;
	private String relatedColumn;
	private String criteriaStatus;
	
	
	// Constructors

	/** default constructor */
	public StVipCriteriaList() {
	}

	/** full constructor  */
	public StVipCriteriaList(String criteriaCode, String criteriaName,
			String relatedTo, String relatedColumn,String criteriaStatus) {
		this.criteriaCode = criteriaCode;
		this.criteriaName = criteriaName;
		this.relatedTo = relatedTo;
		this.relatedColumn = relatedColumn;
		this.criteriaStatus = criteriaStatus;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCriteriaCode() {
		return this.criteriaCode;
	}

	public void setCriteriaCode(String criteriaCode) {
		this.criteriaCode = criteriaCode;
	}

	public String getCriteriaName() {
		return this.criteriaName;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}

	public String getRelatedTo() {
		return this.relatedTo;
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

}