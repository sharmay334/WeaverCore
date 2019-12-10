package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PlayerWalletBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private long playerId;
	private short domainId;
	private int currencyId;
	private double totalBal;
	private double cashBal;
	private double depositBal;
	private double winningBal;
	private double bonusBal;
	private double pendingWinning;
	private double withdrawableBal;
	private double pgCharges;
	private double totalWgr;
	private double totalDeposit;
	private double openingCashBal;
    private String preferredWallet;

	public PlayerWalletBean() {
	}

	public PlayerWalletBean(long playerId, short domainId, int currencyId,
			double totalBal, double cashBal, double bonusBal,
			double pendingWinning, double withdrawableBal, double pgCharges, double depositBal, double winningBal) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.currencyId = currencyId;
		this.totalBal = totalBal;
		this.cashBal = cashBal;
		this.bonusBal = bonusBal;
		this.pendingWinning = pendingWinning;
		this.withdrawableBal = withdrawableBal;
		this.pgCharges = pgCharges;
		this.depositBal = depositBal;
		this.winningBal=winningBal;
	}
	
	public PlayerWalletBean(long playerId, short domainId, int currencyId,
			double totalBal, double cashBal, double bonusBal,
			double pendingWinning, double withdrawableBal, double pgCharges,double totalWgr, double depositBal, double winningBal) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.currencyId = currencyId;
		this.totalBal = totalBal;
		this.cashBal = cashBal;
		this.bonusBal = bonusBal;
		this.pendingWinning = pendingWinning;
		this.withdrawableBal = withdrawableBal;
		this.pgCharges = pgCharges;
		this.totalWgr = totalWgr;
		this.depositBal = depositBal;
		this.winningBal=winningBal;
	}
	
	public PlayerWalletBean(long playerId, short domainId, int currencyId,
			double totalBal, double cashBal, double bonusBal,
			double pendingWinning, double withdrawableBal, double pgCharges,double totalWgr,double totalDeposit, double depositBal, double winningBal) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.currencyId = currencyId;
		this.totalBal = totalBal;
		this.cashBal = cashBal;
		this.bonusBal = bonusBal;
		this.pendingWinning = pendingWinning;
		this.withdrawableBal = withdrawableBal;
		this.pgCharges = pgCharges;
		this.totalWgr = totalWgr;
		this.totalDeposit = totalDeposit;
		this.depositBal = depositBal;
		this.winningBal=winningBal;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public double getTotalBal() {
		return totalBal;
	}

	public void setTotalBal(double totalBal) {
		this.totalBal = totalBal;
	}

	public double getCashBal() {
		return cashBal;
	}

	public void setCashBal(double cashBal) {
		this.cashBal = cashBal;
	}

	public double getBonusBal() {
		return bonusBal;
	}

	public void setBonusBal(double bonusBal) {
		this.bonusBal = bonusBal;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setPendingWinning(double pendingWinning) {
		this.pendingWinning = pendingWinning;
	}

	public double getPendingWinning() {
		return pendingWinning;
	}

	public void setWithdrawableBal(double withdrawableBal) {
		this.withdrawableBal = withdrawableBal;
	}

	public double getWithdrawableBal() {
		return withdrawableBal;
	}

	public void setPgCharges(double pgCharges) {
		this.pgCharges = pgCharges;
	}

	public double getPgCharges() {
		return pgCharges;
	}

	public double getTotalWgr() {
		return totalWgr;
	}

	public void setTotalWgr(double totalWgr) {
		this.totalWgr = totalWgr;
	}

	public double getTotalDeposit() {
		return totalDeposit;
	}

	public void setTotalDeposit(double totalDeposit) {
		this.totalDeposit = totalDeposit;
	}

	public double getOpeningCashBal() {
		return openingCashBal;
	}

	public void setOpeningCashBal(double openingCashBal) {
		this.openingCashBal = openingCashBal;
	}

	public double getWinningBal() {
		return winningBal;
	}

	public void setWinningBal(double winningBal) {
		this.winningBal = winningBal;
	}

	public double getDepositBal() {
		return depositBal;
	}

	public void setDepositBal(double depositBal) {
		this.depositBal = depositBal;
	}

    public String getPreferredWallet() {
        return preferredWallet;
    }

    public void setPreferredWallet(String preferredWallet) {
        this.preferredWallet = preferredWallet;
    }


}
