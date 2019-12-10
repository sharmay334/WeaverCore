package com.stpl.pms.javabeans;

public class BonusCriteriaListBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer criteriaId;
	private String criteriaValue;
	private double criteriaValueMin;
	private double criteriaValueMax;

	public Integer getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(Integer criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getCriteriaValue() {
		return criteriaValue;
	}

	public void setCriteriaValue(String criteriaValue) {
		this.criteriaValue = criteriaValue;
	}

	public double getCriteriaValueMin() {
		return criteriaValueMin;
	}

	public void setCriteriaValueMin(double criteriaValueMin) {
		this.criteriaValueMin = criteriaValueMin;
	}

	public double getCriteriaValueMax() {
		return criteriaValueMax;
	}

	public void setCriteriaValueMax(double criteriaValueMax) {
		this.criteriaValueMax = criteriaValueMax;
	}

	@Override
	public String toString() {
		return "BonusCriteriaListBean [criteriaId=" + criteriaId
				+ ", criteriaValue=" + criteriaValue + ", criteriaValueMax="
				+ criteriaValueMax + ", criteriaValueMin=" + criteriaValueMin
				+ "]";
	}

}
