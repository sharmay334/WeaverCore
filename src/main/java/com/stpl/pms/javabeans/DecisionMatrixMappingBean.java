package com.stpl.pms.javabeans;

import java.io.Serializable;

public class DecisionMatrixMappingBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int mappingId;
	private String activityName;
	private String doerName;
	private String valueOn;
	private int priorityOrder;
	private String status;

	public int getMappingId() {
		return mappingId;
	}

	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getDoerName() {
		return doerName;
	}

	public void setDoerName(String doerName) {
		this.doerName = doerName;
	}

	public String getValueOn() {
		return valueOn;
	}

	public void setValueOn(String valueOn) {
		this.valueOn = valueOn;
	}

	public int getPriorityOrder() {
		return priorityOrder;
	}

	public void setPriorityOrder(int priorityOrder) {
		this.priorityOrder = priorityOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
