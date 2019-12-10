package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PlayerWalletTxBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private double cashPortion;
	private double bonusPortion;
	private double depPortion;
	private double winPortion;
	private double pendingWinPortion;
	private double subwalletPortion;
	private double processChargeRefund;
	private double withdrawableBalPortion;
	
	public PlayerWalletTxBean() {
	}

	public PlayerWalletTxBean(double cashPortion, double bonusPortion,
			double pendingWinPortion, double subwalletPortion,
			double processChargeRefund, double withdrawableBalPortion) {
		this.cashPortion = cashPortion;
		this.bonusPortion = bonusPortion;
		this.pendingWinPortion = pendingWinPortion;
		this.subwalletPortion = subwalletPortion;
		this.processChargeRefund = processChargeRefund;
		this.withdrawableBalPortion = withdrawableBalPortion;
	}

	public double getCashPortion() {
		return cashPortion;
	}

	public void setCashPortion(double cashPortion) {
		this.cashPortion = cashPortion;
	}

	public double getBonusPortion() {
		return bonusPortion;
	}

	public void setBonusPortion(double bonusPortion) {
		this.bonusPortion = bonusPortion;
	}

	public double getPendingWinPortion() {
		return pendingWinPortion;
	}

	public void setPendingWinPortion(double pendingWinPortion) {
		this.pendingWinPortion = pendingWinPortion;
	}

	public void setSubwalletPortion(double subwalletPortion) {
		this.subwalletPortion = subwalletPortion;
	}

	public double getSubwalletPortion() {
		return subwalletPortion;
	}

	public void setProcessChargeRefund(double processChargeRefund) {
		this.processChargeRefund = processChargeRefund;
	}

	public double getProcessChargeRefund() {
		return processChargeRefund;
	}

	public void setWithdrawableBalPortion(double withdrawableBalPortion) {
		this.withdrawableBalPortion = withdrawableBalPortion;
	}

	public double getWithdrawableBalPortion() {
		return withdrawableBalPortion;
	}

	public double getDepPortion() {
		return depPortion;
	}

	public void setDepPortion(double depPortion) {
		this.depPortion = depPortion;
	}

	public double getWinPortion() {
		return winPortion;
	}

	public void setWinPortion(double winPortion) {
		this.winPortion = winPortion;
	}
}
