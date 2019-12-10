package com.stpl.pms.hibernate.mapping;

/**
 * StPromoBonusActivity entity. @author MyEclipse Persistence Tools
 */

public class StPromoBonusActivity implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer activityId;
	private String relatedTo;
	private String activity;
	private String criteriaValueType;
	private String bonusValueType;
	private String clientDeviceType;

	// Constructors

	
	
	/** default constructor */
	public StPromoBonusActivity() {
	}

	// Property accessors

	public String getClientDeviceType() {
		return clientDeviceType;
	}

	public void setClientDeviceType(String clientDeviceType) {
		this.clientDeviceType = clientDeviceType;
	}

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

}