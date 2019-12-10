package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlayerLastActivityRecords entity. @author MyEclipse Persistence Tools
 */

public class StPmPlayerLastActivityRecords implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Short lastLoginAliasId;
	private Timestamp lastLoginDate;
	private Short lastLogoutAliasId;
	private Timestamp lastLogoutDate;
	private Short lastDepositAliasId;
	private Timestamp lastDepositDate;
	private Long lastDepositAmount;
	private Short lastWagerAliasId;
	private Timestamp lastWagerDate;
	private Long lastWagerAmount;
	private Short lastWinningAliasId;
	private Timestamp lastWinningDate;
	private Long lastWinningAmount;
	private Short lastWithdrawalAliasId;
	private Timestamp lastWithdrawalDate;
	private Long lastWithdrawalAmount;
	private Short lastBonusAliasId;
	private Timestamp lastBonusDate;
	private Long lastBonusAmount;

	// Constructors

	/** default constructor */
	public StPmPlayerLastActivityRecords() {
	}

	/** minimal constructor */
	public StPmPlayerLastActivityRecords(Long playerId, Short domainId) {
		this.playerId = playerId;
		this.domainId = domainId;
	}

	/** full constructor */
	public StPmPlayerLastActivityRecords(Long playerId, Short domainId,
			Timestamp lastLoginDate, Timestamp lastDepositDate,
			Long lastDepositAmount, Timestamp lastWagerDate,
			Long lastWagerAmount, Timestamp lastWinningDate,
			Long lastWinningAmount, Timestamp lastWithdrawDate,
			Long lastWithdrawAmount, Timestamp lastBonusDate,
			Long lastBonusAmount, Timestamp lastWithdrawalDate, Long lastWithdrawalAmount) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.lastLoginDate = lastLoginDate;
		this.lastDepositDate = lastDepositDate;
		this.lastDepositAmount = lastDepositAmount;
		this.lastWagerDate = lastWagerDate;
		this.lastWagerAmount = lastWagerAmount;
		this.lastWinningDate = lastWinningDate;
		this.lastWinningAmount = lastWinningAmount;
		this.lastWithdrawalDate = lastWithdrawalDate;
		this.lastWithdrawalAmount = lastWithdrawalAmount;
		this.lastBonusDate = lastBonusDate;
		this.lastBonusAmount = lastBonusAmount;
	}

	// Property accessors

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

	public Timestamp getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Timestamp getLastDepositDate() {
		return this.lastDepositDate;
	}

	public void setLastDepositDate(Timestamp lastDepositDate) {
		this.lastDepositDate = lastDepositDate;
	}

	public Long getLastDepositAmount() {
		return this.lastDepositAmount;
	}

	public void setLastDepositAmount(Long lastDepositAmount) {
		this.lastDepositAmount = lastDepositAmount;
	}

	public Timestamp getLastWagerDate() {
		return this.lastWagerDate;
	}

	public void setLastWagerDate(Timestamp lastWagerDate) {
		this.lastWagerDate = lastWagerDate;
	}

	public Long getLastWagerAmount() {
		return this.lastWagerAmount;
	}

	public void setLastWagerAmount(Long lastWagerAmount) {
		this.lastWagerAmount = lastWagerAmount;
	}

	public Timestamp getLastWinningDate() {
		return this.lastWinningDate;
	}

	public void setLastWinningDate(Timestamp lastWinningDate) {
		this.lastWinningDate = lastWinningDate;
	}

	public Long getLastWinningAmount() {
		return this.lastWinningAmount;
	}

	public void setLastWinningAmount(Long lastWinningAmount) {
		this.lastWinningAmount = lastWinningAmount;
	}

	public Timestamp getLastWithdrawalDate() {
		return this.lastWithdrawalDate;
	}

	public void setLastWithdrawalDate(Timestamp lastWithdrawalDate) {
		this.lastWithdrawalDate = lastWithdrawalDate;
	}

	public Long getLastWithdrawalAmount() {
		return this.lastWithdrawalAmount;
	}

	public void setLastWithdrawalAmount(Long lastWithdrawalAmount) {
		this.lastWithdrawalAmount = lastWithdrawalAmount;
	}

	public Timestamp getLastBonusDate() {
		return this.lastBonusDate;
	}

	public void setLastBonusDate(Timestamp lastBonusDate) {
		this.lastBonusDate = lastBonusDate;
	}

	public Long getLastBonusAmount() {
		return this.lastBonusAmount;
	}

	public void setLastBonusAmount(Long lastBonusAmount) {
		this.lastBonusAmount = lastBonusAmount;
	}

	public Timestamp getLastLogoutDate() {
		return lastLogoutDate;
	}

	public void setLastLogoutDate(Timestamp lastLogoutDate) {
		this.lastLogoutDate = lastLogoutDate;
	}

	public Short getLastLoginAliasId() {
		return lastLoginAliasId;
	}

	public void setLastLoginAliasId(Short lastLoginAliasId) {
		this.lastLoginAliasId = lastLoginAliasId;
	}

	public Short getLastDepositAliasId() {
		return lastDepositAliasId;
	}

	public void setLastDepositAliasId(Short lastDepositAliasId) {
		this.lastDepositAliasId = lastDepositAliasId;
	}

	public Short getLastWagerAliasId() {
		return lastWagerAliasId;
	}

	public void setLastWagerAliasId(Short lastWagerAliasId) {
		this.lastWagerAliasId = lastWagerAliasId;
	}

	public Short getLastLogoutAliasId() {
		return lastLogoutAliasId;
	}

	public void setLastLogoutAliasId(Short lastLogoutAliasId) {
		this.lastLogoutAliasId = lastLogoutAliasId;
	}

	public Short getLastWinningAliasId() {
		return lastWinningAliasId;
	}

	public void setLastWinningAliasId(Short lastWinningAliasId) {
		this.lastWinningAliasId = lastWinningAliasId;
	}

	public Short getLastWithdrawalAliasId() {
		return lastWithdrawalAliasId;
	}

	public void setLastWithdrawalAliasId(Short lastWithdrawalAliasId) {
		this.lastWithdrawalAliasId = lastWithdrawalAliasId;
	}

	public Short getLastBonusAliasId() {
		return lastBonusAliasId;
	}

	public void setLastBonusAliasId(Short lastBonusAliasId) {
		this.lastBonusAliasId = lastBonusAliasId;
	}

}