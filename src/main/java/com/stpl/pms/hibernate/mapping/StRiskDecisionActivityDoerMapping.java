package com.stpl.pms.hibernate.mapping;

/**
 * StRiskDecisionActivityDoerMapping entity. @author MyEclipse Persistence Tools
 */

public class StRiskDecisionActivityDoerMapping implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String valueOn;
	private Integer priorityOrder;
	private String status;
	private StRiskDecisionActivityMaster activityMaster;
	private StRiskDecisionDoerMaster doerMaster;

	// Constructors

	/** default constructor */
	public StRiskDecisionActivityDoerMapping() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValueOn() {
		return this.valueOn;
	}

	public void setValueOn(String valueOn) {
		this.valueOn = valueOn;
	}

	public Integer getPriorityOrder() {
		return this.priorityOrder;
	}

	public void setPriorityOrder(Integer priorityOrder) {
		this.priorityOrder = priorityOrder;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setActivityMaster(StRiskDecisionActivityMaster activityMaster) {
		this.activityMaster = activityMaster;
	}

	public StRiskDecisionActivityMaster getActivityMaster() {
		return activityMaster;
	}

	public void setDoerMaster(StRiskDecisionDoerMaster doerMaster) {
		this.doerMaster = doerMaster;
	}

	public StRiskDecisionDoerMaster getDoerMaster() {
		return doerMaster;
	}

}