package com.stpl.pms.javabeans;

import java.io.Serializable;

public class VipRuleDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String criteriaCode;
	private String criteriaName;
	private String minValue;
	private String maxValue;

	public VipRuleDetailBean() {
	}

	public VipRuleDetailBean(String criteriaCode, String criteriaName,
			String minValue, String maxValue) {
		this.criteriaCode = criteriaCode;
		this.criteriaName = criteriaName;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public String getCriteriaCode() {
		return criteriaCode;
	}

	public void setCriteriaCode(String criteriaCode) {
		this.criteriaCode = criteriaCode;
	}

	public String getCriteriaName() {
		return criteriaName;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	@Override
	public String toString() {
		return "VipRuleDetailBean [criteriaCode=" + criteriaCode
				+ ", criteriaName=" + criteriaName + ", maxValue=" + maxValue
				+ ", minValue=" + minValue + "]";
	}

}
