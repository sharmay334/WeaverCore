package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlrWalletBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private double totalBalance;
	private double cashBalance;
	private double bonusBalance;
	private double withdrawableBal;
	private Double practiceBalance;
	private String currency;

	public PlrWalletBean() {
	}

	public PlrWalletBean(double totalBalance, double cashBalance,
			double bonusBalance, double withdrawableBal,
			Double practiceBalance, String currency) {
		this.totalBalance = totalBalance;
		this.cashBalance = cashBalance;
		this.bonusBalance = bonusBalance;
		this.withdrawableBal = withdrawableBal;
		this.practiceBalance = practiceBalance;
		this.currency = currency;
	}

	public double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public double getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(double cashBalance) {
		this.cashBalance = cashBalance;
	}

	public double getBonusBalance() {
		return bonusBalance;
	}

	public void setBonusBalance(double bonusBalance) {
		this.bonusBalance = bonusBalance;
	}

	public double getWithdrawableBal() {
		return withdrawableBal;
	}

	public void setWithdrawableBal(double withdrawableBal) {
		this.withdrawableBal = withdrawableBal;
	}

	public Double getPracticeBalance() {
		return practiceBalance;
	}

	public void setPracticeBalance(Double practiceBalance) {
		this.practiceBalance = practiceBalance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
