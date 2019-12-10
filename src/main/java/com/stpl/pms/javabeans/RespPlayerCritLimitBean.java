package com.stpl.pms.javabeans;

public class RespPlayerCritLimitBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String criteria;
	private String criteriaName;
	private int limit;
	private int opLimit;

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public String getCriteriaName() {
		return criteriaName;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOpLimit() {
		return opLimit;
	}

	public void setOpLimit(int opLimit) {
		this.opLimit = opLimit;
	}

}
