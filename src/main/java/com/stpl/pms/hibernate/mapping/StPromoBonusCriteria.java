package com.stpl.pms.hibernate.mapping;

/**
 * StPromoBonusCriteria entity. @author MyEclipse Persistence Tools
 */

public class StPromoBonusCriteria implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer activityId;
	private String relatedTo;
	private String activity;
	private String criteriaValueType;
	private String bonusValueType;
	private String relatedColumn;

	// Constructors

	/** default constructor */
	public StPromoBonusCriteria() {
	}

	/** full constructor */
	public StPromoBonusCriteria(String relatedTo, String activity,
			String criteriaValueType, String bonusValueType) {
		this.relatedTo = relatedTo;
		this.activity = activity;
		this.criteriaValueType = criteriaValueType;
		this.bonusValueType = bonusValueType;
	}

	// Property accessors

	public Integer getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getRelatedTo() {
		return this.relatedTo;
	}

	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}

	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getCriteriaValueType() {
		return this.criteriaValueType;
	}

	public void setCriteriaValueType(String criteriaValueType) {
		this.criteriaValueType = criteriaValueType;
	}

	public String getBonusValueType() {
		return this.bonusValueType;
	}

	public void setBonusValueType(String bonusValueType) {
		this.bonusValueType = bonusValueType;
	}

	public void setRelatedColumn(String relatedColumn) {
		this.relatedColumn = relatedColumn;
	}

	public String getRelatedColumn() {
		return relatedColumn;
	}

}