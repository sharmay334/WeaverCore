package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;

/**
 * StTxnPlrWalletMaster entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrWalletMaster implements Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Integer currencyId;
	private Double totalBal;
	private Double cashBal;
	private Double depositBal;
	private Double winningBal;
	private Double bonusBal;
	private Double pendingWinning;
	private Double totalDeposit;
	private Double totalWithdrawal;
	private Double totalBonus;
	private Double totalWager;
	private Double totalWinning;
	private Double refCashBal;
	private Double refBonusBal;
	private Double withdrawableBal;
	private Double pgCharges;
	private Long version;
    private String walletPref;


	// Constructors

	/** default constructor */
	public StTxnPlrWalletMaster() {
	}

	// Property accessors

	public StTxnPlrWalletMaster(Long playerId, Short domainId,
			Integer currencyId) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.currencyId = currencyId;
		this.totalBal = 0.0;
		this.cashBal = 0.0;
		this.depositBal = 0.0;
		this.winningBal = 0.0;
		this.bonusBal = 0.0;
		this.pendingWinning = 0.0;
		this.totalDeposit = 0.0;
		this.totalWithdrawal = 0.0;
		this.totalBonus = 0.0;
		this.totalWager = 0.0;
		this.totalWinning = 0.0;
		this.refCashBal = 0.0;
		this.refBonusBal = 0.0;
		this.withdrawableBal = 0.0;
		this.pgCharges = 0.0;
	}

	public StTxnPlrWalletMaster(Long playerId, Short domainId,
			Integer currencyId, Double totalBal, Double cashBal, Double depBal, Double winBal,
			Double bonusBal, Double pendingWinning, Double totalDeposit,
			Double totalWithdrawal, Double totalBonus, Double totalWager,
			Double totalWinning, Double refCashBal, Double refBonusBal,
			Double withdrawableBal, Double pgCharges) {
		super();
		this.playerId = playerId;
		this.domainId = domainId;
		this.currencyId = currencyId;
		this.totalBal = totalBal;
		this.cashBal = cashBal;
		this.depositBal = depBal;
		this.winningBal = winBal;
		this.bonusBal = bonusBal;
		this.pendingWinning = pendingWinning;
		this.totalDeposit = totalDeposit;
		this.totalWithdrawal = totalWithdrawal;
		this.totalBonus = totalBonus;
		this.totalWager = totalWager;
		this.totalWinning = totalWinning;
		this.refCashBal = refCashBal;
		this.refBonusBal = refBonusBal;
		this.withdrawableBal = withdrawableBal;
		this.pgCharges = pgCharges;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Double getTotalBal() {
		return this.totalBal;
	}

	public void setTotalBal(Double totalBal) {
		this.totalBal = totalBal;
	}

	public Double getCashBal() {
		return this.cashBal;
	}

	public void setCashBal(Double cashBal) {
		this.cashBal = cashBal;
	}

	public Double getBonusBal() {
		return this.bonusBal;
	}

	public void setBonusBal(Double bonusBal) {
		this.bonusBal = bonusBal;
	}

	public Double getPendingWinning() {
		return this.pendingWinning;
	}

	public void setPendingWinning(Double pendingWinning) {
		this.pendingWinning = pendingWinning;
	}

	public Double getTotalDeposit() {
		return this.totalDeposit;
	}

	public void setTotalDeposit(Double totalDeposit) {
		this.totalDeposit = totalDeposit;
	}

	public Double getTotalWithdrawal() {
		return this.totalWithdrawal;
	}

	public void setTotalWithdrawal(Double totalWithdrawal) {
		this.totalWithdrawal = totalWithdrawal;
	}

	public Double getTotalBonus() {
		return this.totalBonus;
	}

	public void setTotalBonus(Double totalBonus) {
		this.totalBonus = totalBonus;
	}

	public Double getTotalWager() {
		return this.totalWager;
	}

	public void setTotalWager(Double totalWager) {
		this.totalWager = totalWager;
	}

	public Double getTotalWinning() {
		return this.totalWinning;
	}

	public void setTotalWinning(Double totalWinning) {
		this.totalWinning = totalWinning;
	}

	public Double getRefCashBal() {
		return this.refCashBal;
	}

	public void setRefCashBal(Double refCashBal) {
		this.refCashBal = refCashBal;
	}

	public Double getRefBonusBal() {
		return this.refBonusBal;
	}

	public void setRefBonusBal(Double refBonusBal) {
		this.refBonusBal = refBonusBal;
	}

	public void setWithdrawableBal(Double withdrawableBal) {
		this.withdrawableBal = withdrawableBal;
	}

	public Double getWithdrawableBal() {
		return withdrawableBal;
	}

	public void setPgCharges(Double pgCharges) {
		this.pgCharges = pgCharges;
	}

	public Double getPgCharges() {
		return pgCharges;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Double getDepositBal() {
		return depositBal;
	}

	public void setDepositBal(Double depositBal) {
		this.depositBal = depositBal;
	}

	public Double getWinningBal() {
		return winningBal;
	}

	public void setWinningBal(Double winningBal) {
		this.winningBal = winningBal;
	}

    public String getWalletPref() {
        return walletPref;
    }

    public void setWalletPref(String walletPref) {
        this.walletPref = walletPref;
    }

}