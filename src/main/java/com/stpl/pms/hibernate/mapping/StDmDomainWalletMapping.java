package com.stpl.pms.hibernate.mapping;

/**
 * StDmDomainWalletMapping entity. @author MyEclipse Persistence Tools
 */

public class StDmDomainWalletMapping implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Short id;
	private Short domainId;
	private String walletType;
	private String winningWithdrawable;
	private Short winningWithdrawAfterDay;
	private String depositWithdrawable;
	private Short depositWithdrawAfterDay;
	private String wagerOrder;
	private String status;

	// Constructors

	/** default constructor */
	public StDmDomainWalletMapping() {
	}

	/** minimal constructor */
	public StDmDomainWalletMapping(Short domainId, String walletType,
			String status) {
		this.domainId = domainId;
		this.walletType = walletType;
		this.status = status;
	}

	/** full constructor */
	public StDmDomainWalletMapping(Short domainId, String walletType,
			String winningWithdrawable, Short winningWithdrawAfterDay,
			String depositWithdrawable, Short depositWithdrawAfterDay,
			String wagerOrder, String status) {
		this.domainId = domainId;
		this.walletType = walletType;
		this.winningWithdrawable = winningWithdrawable;
		this.winningWithdrawAfterDay = winningWithdrawAfterDay;
		this.depositWithdrawable = depositWithdrawable;
		this.depositWithdrawAfterDay = depositWithdrawAfterDay;
		this.wagerOrder = wagerOrder;
		this.status = status;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getWalletType() {
		return this.walletType;
	}

	public void setWalletType(String walletType) {
		this.walletType = walletType;
	}

	public String getWinningWithdrawable() {
		return this.winningWithdrawable;
	}

	public void setWinningWithdrawable(String winningWithdrawable) {
		this.winningWithdrawable = winningWithdrawable;
	}

	public Short getWinningWithdrawAfterDay() {
		return this.winningWithdrawAfterDay;
	}

	public void setWinningWithdrawAfterDay(Short winningWithdrawAfterDay) {
		this.winningWithdrawAfterDay = winningWithdrawAfterDay;
	}

	public String getDepositWithdrawable() {
		return this.depositWithdrawable;
	}

	public void setDepositWithdrawable(String depositWithdrawable) {
		this.depositWithdrawable = depositWithdrawable;
	}

	public Short getDepositWithdrawAfterDay() {
		return this.depositWithdrawAfterDay;
	}

	public void setDepositWithdrawAfterDay(Short depositWithdrawAfterDay) {
		this.depositWithdrawAfterDay = depositWithdrawAfterDay;
	}

	public String getWagerOrder() {
		return this.wagerOrder;
	}

	public void setWagerOrder(String wagerOrder) {
		this.wagerOrder = wagerOrder;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}