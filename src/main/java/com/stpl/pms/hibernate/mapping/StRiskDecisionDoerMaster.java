package com.stpl.pms.hibernate.mapping;

/**
 * StRiskDecisionDoerMaster entity. @author MyEclipse Persistence Tools
 */

public class StRiskDecisionDoerMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer doerId;
	private String doerCode;
	private String doerName;
	private String doerType;
	private String status;

	// Constructors

	/** default constructor */
	public StRiskDecisionDoerMaster() {
	}

	/** full constructor */
	public StRiskDecisionDoerMaster(String doerCode, String doerName,
			String doerType, String status) {
		this.doerCode = doerCode;
		this.doerName = doerName;
		this.doerType = doerType;
		this.status = status;
	}

	// Property accessors

	public Integer getDoerId() {
		return this.doerId;
	}

	public void setDoerId(Integer doerId) {
		this.doerId = doerId;
	}

	public String getDoerCode() {
		return this.doerCode;
	}

	public void setDoerCode(String doerCode) {
		this.doerCode = doerCode;
	}

	public String getDoerName() {
		return this.doerName;
	}

	public void setDoerName(String doerName) {
		this.doerName = doerName;
	}

	public String getDoerType() {
		return this.doerType;
	}

	public void setDoerType(String doerType) {
		this.doerType = doerType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}