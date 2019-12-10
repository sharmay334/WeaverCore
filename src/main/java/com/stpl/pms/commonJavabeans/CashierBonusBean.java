package com.stpl.pms.commonJavabeans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CashierBonusBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double depositAmount;
	private double bonusValue;
	private String bonusName;
	private String bonusValueAs;
	private String bonusValueType;
	private double activityValueMin;
	private double activityValueMax;
	private String promoCode;

	public CashierBonusBean() {
	}

	public CashierBonusBean(Double depositAmount, double bonusValue,
			String bonusName) {
		this.depositAmount = depositAmount;
		this.bonusValue = bonusValue;
		this.bonusName = bonusName;
	}

	public CashierBonusBean(Double depositAmount, double bonusValue,
			String bonusName, String bonusValueAs, String bonusValueType,
			double activityValueMin, double activityValueMax, String promoCode) {
		this.depositAmount = depositAmount;
		this.bonusValue = bonusValue;
		this.bonusName = bonusName;
		this.bonusValueAs = bonusValueAs;
		this.bonusValueType = bonusValueType;
		this.activityValueMin = activityValueMin;
		this.activityValueMax = activityValueMax;
		this.promoCode = promoCode;
	}

	public void setBonusName(String bonusName) {
		this.bonusName = bonusName;
	}

	public String getBonusName() {
		return bonusName;
	}

	public void setBonusValue(double bonusValue) {
		this.bonusValue = bonusValue;
	}

	public double getBonusValue() {
		return bonusValue;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setBonusValueAs(String bonusValueAs) {
		this.bonusValueAs = bonusValueAs;
	}

	public String getBonusValueAs() {
		return bonusValueAs;
	}

	public void setBonusValueType(String bonusValueType) {
		this.bonusValueType = bonusValueType;
	}

	public String getBonusValueType() {
		return bonusValueType;
	}

	public void setActivityValueMin(double activityValueMin) {
		this.activityValueMin = activityValueMin;
	}

	public double getActivityValueMin() {
		return activityValueMin;
	}

	public void setActivityValueMax(double activityValueMax) {
		this.activityValueMax = activityValueMax;
	}

	public double getActivityValueMax() {
		return activityValueMax;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getPromoCode() {
		return promoCode;
	}

}
