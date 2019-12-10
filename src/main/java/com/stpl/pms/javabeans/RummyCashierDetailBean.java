package com.stpl.pms.javabeans;

import java.io.Serializable;

public class RummyCashierDetailBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Double cashBal;
	private Double bonusBal;
	private Double practiceBal;

	public RummyCashierDetailBean(PlayerInfoBean infoBean) {
		super();
		this.cashBal = infoBean.getWalletBean().getCashBal();
		this.bonusBal = infoBean.getWalletBean().getBonusBal();
		this.practiceBal = infoBean.getPracticeBal();
	}

	public void setCashBal(Double cashBal) {
		this.cashBal = cashBal;
	}

	public Double getCashBal() {
		return cashBal;
	}

	public void setBonusBal(Double bonusBal) {
		this.bonusBal = bonusBal;
	}

	public Double getBonusBal() {
		return bonusBal;
	}

	public void setPracticeBal(Double practiceBal) {
		this.practiceBal = practiceBal;
	}

	public Double getPracticeBal() {
		return practiceBal;
	}

	@Override
	public String toString() {
		return "RummyCashierDetailBean [bonusBal=" + bonusBal + ", cashBal="
				+ cashBal + ", practiceBal=" + practiceBal + "]";
	}

}
