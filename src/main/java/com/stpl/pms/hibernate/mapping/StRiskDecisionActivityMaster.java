package com.stpl.pms.hibernate.mapping;

/**
 * StRiskDecisionActivityMaster entity. @author MyEclipse Persistence Tools
 */

public class StRiskDecisionActivityMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer activityId;
	private String activityCode;
	private String activityName;
	private String status;

	// Constructors

	/** default constructor */
	public StRiskDecisionActivityMaster() {
	}

	/** full constructor */
	public StRiskDecisionActivityMaster(String activityCode,
			String activityName, String status) {
		this.activityCode = activityCode;
		this.activityName = activityName;
		this.status = status;
	}

	// Property accessors

	public Integer getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityCode() {
		return this.activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}