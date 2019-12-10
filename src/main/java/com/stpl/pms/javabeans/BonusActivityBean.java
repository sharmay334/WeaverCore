package com.stpl.pms.javabeans;

import java.io.Serializable;

public class BonusActivityBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int activityId;
	private String relatedTo;
	private String activity;
	private String criteriaValueType;
	private String bonusValueType;
	private String clientDeviceType;

	public String getClientDeviceType() {
		return clientDeviceType;
	}

	public void setClientDeviceType(String clientDeviceType) {
		this.clientDeviceType = clientDeviceType;
	}
	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getRelatedTo() {
		return relatedTo;
	}

	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getCriteriaValueType() {
		return criteriaValueType;
	}

	public void setCriteriaValueType(String criteriaValueType) {
		this.criteriaValueType = criteriaValueType;
	}

	public String getBonusValueType() {
		return bonusValueType;
	}

	public void setBonusValueType(String bonusValueType) {
		this.bonusValueType = bonusValueType;
	}
}
