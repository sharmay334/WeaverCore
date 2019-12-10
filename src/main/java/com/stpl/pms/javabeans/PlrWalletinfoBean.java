package com.stpl.pms.javabeans;

public class PlrWalletinfoBean {
	private static final long serialVersionUID = 1L;
	private Double totalBalance;
	private Double cashBalance;
	private Double bonusBalance;
	private Double withdrawableBal;
	private Double practiceBalance;
	private String currency;

	public PlrWalletinfoBean() {
	}

	public PlrWalletinfoBean(Double totalBalance, Double cashBalance,
			Double bonusBalance, Double withdrawableBal,
			Double practiceBalance, String currency) {
		this.totalBalance = totalBalance;
		this.cashBalance = cashBalance;
		this.bonusBalance = bonusBalance;
		this.withdrawableBal = withdrawableBal;
		this.practiceBalance = practiceBalance;
		this.currency = currency;
	}

	public Double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public Double getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(Double cashBalance) {
		this.cashBalance = cashBalance;
	}

	public Double getBonusBalance() {
		return bonusBalance;
	}

	public void setBonusBalance(Double bonusBalance) {
		this.bonusBalance = bonusBalance;
	}

	public Double getWithdrawableBal() {
		return withdrawableBal;
	}

	public void setWithdrawableBal(Double withdrawableBal) {
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
