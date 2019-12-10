package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StGenSchedulerRunStatus entity. @author MyEclipse Persistence Tools
 */

public class StGenSchedulerRunStatus implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer schedulerId;
	private String schedulerCode;
	private String schedulerName;
	private String jobName;
	private String groupName;
	private String cronExpression;
	private String jobClass;
	private String isJavaSchd;
	private Timestamp lastRunTime;

	// Constructors

	/** default constructor */
	public StGenSchedulerRunStatus() {
	}

	/** minimal constructor */
	public StGenSchedulerRunStatus(String schedulerCode, String schedulerName,
			String jobName, String groupName, String cronExpression,
			String isJavaSchd, Timestamp lastRunTime) {
		this.schedulerCode = schedulerCode;
		this.schedulerName = schedulerName;
		this.jobName = jobName;
		this.groupName = groupName;
		this.cronExpression = cronExpression;
		this.isJavaSchd = isJavaSchd;
		this.lastRunTime = lastRunTime;
	}

	/** full constructor */
	public StGenSchedulerRunStatus(String schedulerCode, String schedulerName,
			String jobName, String groupName, String cronExpression,
			String jobClass, String isJavaSchd, Timestamp lastRunTime) {
		this.schedulerCode = schedulerCode;
		this.schedulerName = schedulerName;
		this.jobName = jobName;
		this.groupName = groupName;
		this.cronExpression = cronExpression;
		this.jobClass = jobClass;
		this.isJavaSchd = isJavaSchd;
		this.lastRunTime = lastRunTime;
	}

	// Property accessors

	public Integer getSchedulerId() {
		return this.schedulerId;
	}

	public void setSchedulerId(Integer schedulerId) {
		this.schedulerId = schedulerId;
	}

	public String getSchedulerCode() {
		return this.schedulerCode;
	}

	public void setSchedulerCode(String schedulerCode) {
		this.schedulerCode = schedulerCode;
	}

	public String getSchedulerName() {
		return this.schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCronExpression() {
		return this.cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getJobClass() {
		return this.jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}

	public String getIsJavaSchd() {
		return this.isJavaSchd;
	}

	public void setIsJavaSchd(String isJavaSchd) {
		this.isJavaSchd = isJavaSchd;
	}

	public Timestamp getLastRunTime() {
		return this.lastRunTime;
	}

	public void setLastRunTime(Timestamp lastRunTime) {
		this.lastRunTime = lastRunTime;
	}

}