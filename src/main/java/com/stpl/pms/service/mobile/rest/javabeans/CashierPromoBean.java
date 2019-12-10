package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CashierPromoBean extends CommonRequestBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double depositAmount;
	private String promoCode;

	public CashierPromoBean() {
	}

	public CashierPromoBean(Double depositAmount, String promoCode) {
		this.depositAmount = depositAmount;
		this.promoCode = promoCode;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getPromoCode() {
		return promoCode;
	}

}
