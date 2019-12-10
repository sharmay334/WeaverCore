package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StRgDailyTxn entity. @author MyEclipse Persistence Tools
 */

public class StRgDailyTxn implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Timestamp currentDate;
	private Integer nogWagerDaily;
	private Integer maxLossDaily;
	private Integer maxWagerDaily;
	private Integer maxDepositDaily;
	private Integer nogWagerDailyRummy;
	private Integer maxLossDailyRummy;
	private Integer maxWagerDailyRummy;
	private Integer nogWagerDailyCasino;
	private Integer maxLossDailyCasino;
	private Integer maxWagerDailyCasino;
	private Integer nogWagerDailySports;
	private Integer maxLossDailySports;
	private Integer maxWagerDailySports;
	private Integer nogWagerDailyBingo;
	private Integer maxLossDailyBingo;
	private Integer maxWagerDailyBingo;
	private Integer nogWagerDailyPoker;
	private Integer maxLossDailyPoker;
	private Integer maxWagerDailyPoker;
	private Integer nogWagerDailyGames;
	private Integer maxLossDailyGames;
	private Integer maxWagerDailyGames;
	private Integer nogWagerDailyLiveCasino;
	private Integer maxLossDailyLiveCasino;
	private Integer maxWagerDailyLiveCasino;
	private Integer nogWagerDailyInstantDraw;
	private Integer maxLossDailyInstantDraw;
	private Integer maxWagerDailyInstantDraw;
	private Integer nogWagerDailyDrawGames;
	private Integer maxLossDailyDrawGames;
	private Integer maxWagerDailyDrawGames;
	// Constructors

	/** default constructor */
	public StRgDailyTxn() {
	}

	/** full constructor */
	public StRgDailyTxn(Long playerId, Short domainId, Timestamp currentDate) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.currentDate = currentDate;
		this.nogWagerDaily = 0;
		this.maxLossDaily = 0;
		this.maxWagerDaily = 0;
		this.maxDepositDaily = 0;
		this.nogWagerDailyRummy = 0;
		this.maxLossDailyRummy = 0;
		this.maxWagerDailyRummy = 0;
		this.nogWagerDailyCasino = 0;
		this.maxLossDailyCasino = 0;
		this.maxWagerDailyCasino = 0;
		this.nogWagerDailySports = 0;
		this.maxLossDailySports = 0;
		this.maxWagerDailySports = 0;
		this.nogWagerDailyBingo = 0;
		this.maxLossDailyBingo = 0;
		this.maxWagerDailyBingo = 0;
		this.nogWagerDailyPoker = 0;
		this.maxLossDailyPoker = 0;
		this.maxWagerDailyPoker = 0;
		this.nogWagerDailyGames = 0;
		this.maxLossDailyGames = 0;
		this.maxWagerDailyGames = 0;
		this.nogWagerDailyLiveCasino = 0;
		this.maxLossDailyLiveCasino = 0;
		this.maxWagerDailyLiveCasino = 0;
		this.nogWagerDailyInstantDraw = 0;
		this.maxLossDailyInstantDraw = 0;
		this.maxWagerDailyInstantDraw = 0;
		this.nogWagerDailyDrawGames = 0;
		this.maxLossDailyDrawGames = 0;
		this.maxWagerDailyDrawGames = 0;
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

	public Timestamp getCurrentDate() {
		return this.currentDate;
	}

	public void setCurrentDate(Timestamp currentDate) {
		this.currentDate = currentDate;
	}

	public Integer getNogWagerDaily() {
		return this.nogWagerDaily;
	}

	public void setNogWagerDaily(Integer nogWagerDaily) {
		this.nogWagerDaily = nogWagerDaily;
	}

	public Integer getMaxLossDaily() {
		return this.maxLossDaily;
	}

	public void setMaxLossDaily(Integer maxLossDaily) {
		this.maxLossDaily = maxLossDaily;
	}

	public Integer getMaxWagerDaily() {
		return this.maxWagerDaily;
	}

	public void setMaxWagerDaily(Integer maxWagerDaily) {
		this.maxWagerDaily = maxWagerDaily;
	}

	public Integer getMaxDepositDaily() {
		return this.maxDepositDaily;
	}

	public void setMaxDepositDaily(Integer maxDepositDaily) {
		this.maxDepositDaily = maxDepositDaily;
	}

	public Integer getNogWagerDailyRummy() {
		return this.nogWagerDailyRummy;
	}

	public void setNogWagerDailyRummy(Integer nogWagerDailyRummy) {
		this.nogWagerDailyRummy = nogWagerDailyRummy;
	}

	public Integer getMaxLossDailyRummy() {
		return this.maxLossDailyRummy;
	}

	public void setMaxLossDailyRummy(Integer maxLossDailyRummy) {
		this.maxLossDailyRummy = maxLossDailyRummy;
	}

	public Integer getMaxWagerDailyRummy() {
		return this.maxWagerDailyRummy;
	}

	public void setMaxWagerDailyRummy(Integer maxWagerDailyRummy) {
		this.maxWagerDailyRummy = maxWagerDailyRummy;
	}

	public Integer getNogWagerDailyCasino() {
		return this.nogWagerDailyCasino;
	}

	public void setNogWagerDailyCasino(Integer nogWagerDailyCasino) {
		this.nogWagerDailyCasino = nogWagerDailyCasino;
	}

	public Integer getMaxLossDailyCasino() {
		return this.maxLossDailyCasino;
	}

	public void setMaxLossDailyCasino(Integer maxLossDailyCasino) {
		this.maxLossDailyCasino = maxLossDailyCasino;
	}

	public Integer getMaxWagerDailyCasino() {
		return this.maxWagerDailyCasino;
	}

	public void setMaxWagerDailyCasino(Integer maxWagerDailyCasino) {
		this.maxWagerDailyCasino = maxWagerDailyCasino;
	}

	public Integer getNogWagerDailySports() {
		return this.nogWagerDailySports;
	}

	public void setNogWagerDailySports(Integer nogWagerDailySports) {
		this.nogWagerDailySports = nogWagerDailySports;
	}

	public Integer getMaxLossDailySports() {
		return this.maxLossDailySports;
	}

	public void setMaxLossDailySports(Integer maxLossDailySports) {
		this.maxLossDailySports = maxLossDailySports;
	}

	public Integer getMaxWagerDailySports() {
		return this.maxWagerDailySports;
	}

	public void setMaxWagerDailySports(Integer maxWagerDailySports) {
		this.maxWagerDailySports = maxWagerDailySports;
	}

	public Integer getNogWagerDailyBingo() {
		return this.nogWagerDailyBingo;
	}

	public void setNogWagerDailyBingo(Integer nogWagerDailyBingo) {
		this.nogWagerDailyBingo = nogWagerDailyBingo;
	}

	public Integer getMaxLossDailyBingo() {
		return this.maxLossDailyBingo;
	}

	public void setMaxLossDailyBingo(Integer maxLossDailyBingo) {
		this.maxLossDailyBingo = maxLossDailyBingo;
	}

	public Integer getMaxWagerDailyBingo() {
		return this.maxWagerDailyBingo;
	}

	public void setMaxWagerDailyBingo(Integer maxWagerDailyBingo) {
		this.maxWagerDailyBingo = maxWagerDailyBingo;
	}

	public Integer getNogWagerDailyPoker() {
		return this.nogWagerDailyPoker;
	}

	public void setNogWagerDailyPoker(Integer nogWagerDailyPoker) {
		this.nogWagerDailyPoker = nogWagerDailyPoker;
	}

	public Integer getMaxLossDailyPoker() {
		return this.maxLossDailyPoker;
	}

	public void setMaxLossDailyPoker(Integer maxLossDailyPoker) {
		this.maxLossDailyPoker = maxLossDailyPoker;
	}

	public Integer getMaxWagerDailyPoker() {
		return this.maxWagerDailyPoker;
	}

	public void setMaxWagerDailyPoker(Integer maxWagerDailyPoker) {
		this.maxWagerDailyPoker = maxWagerDailyPoker;
	}

	public Integer getNogWagerDailyGames() {
		return this.nogWagerDailyGames;
	}

	public void setNogWagerDailyGames(Integer nogWagerDailyGames) {
		this.nogWagerDailyGames = nogWagerDailyGames;
	}

	public Integer getMaxLossDailyGames() {
		return this.maxLossDailyGames;
	}

	public void setMaxLossDailyGames(Integer maxLossDailyGames) {
		this.maxLossDailyGames = maxLossDailyGames;
	}

	public Integer getMaxWagerDailyGames() {
		return this.maxWagerDailyGames;
	}

	public void setMaxWagerDailyGames(Integer maxWagerDailyGames) {
		this.maxWagerDailyGames = maxWagerDailyGames;
	}

	public Integer getNogWagerDailyLiveCasino() {
		return this.nogWagerDailyLiveCasino;
	}

	public void setNogWagerDailyLiveCasino(Integer nogWagerDailyLiveCasino) {
		this.nogWagerDailyLiveCasino = nogWagerDailyLiveCasino;
	}

	public Integer getMaxLossDailyLiveCasino() {
		return this.maxLossDailyLiveCasino;
	}

	public void setMaxLossDailyLiveCasino(Integer maxLossDailyLiveCasino) {
		this.maxLossDailyLiveCasino = maxLossDailyLiveCasino;
	}

	public Integer getMaxWagerDailyLiveCasino() {
		return this.maxWagerDailyLiveCasino;
	}

	public void setMaxWagerDailyLiveCasino(Integer maxWagerDailyLiveCasino) {
		this.maxWagerDailyLiveCasino = maxWagerDailyLiveCasino;
	}

	public Integer getNogWagerDailyInstantDraw() {
		return nogWagerDailyInstantDraw;
	}

	public void setNogWagerDailyInstantDraw(Integer nogWagerDailyInstantDraw) {
		this.nogWagerDailyInstantDraw = nogWagerDailyInstantDraw;
	}

	public Integer getMaxLossDailyInstantDraw() {
		return maxLossDailyInstantDraw;
	}

	public void setMaxLossDailyInstantDraw(Integer maxLossDailyInstantDraw) {
		this.maxLossDailyInstantDraw = maxLossDailyInstantDraw;
	}

	public Integer getMaxWagerDailyInstantDraw() {
		return maxWagerDailyInstantDraw;
	}

	public void setMaxWagerDailyInstantDraw(Integer maxWagerDailyInstantDraw) {
		this.maxWagerDailyInstantDraw = maxWagerDailyInstantDraw;
	}

	public void setNogWagerDailyDrawGames(Integer nogWagerDailyDrawGames) {
		this.nogWagerDailyDrawGames = nogWagerDailyDrawGames;
	}

	public Integer getNogWagerDailyDrawGames() {
		return nogWagerDailyDrawGames;
	}

	public void setMaxLossDailyDrawGames(Integer maxLossDailyDrawGames) {
		this.maxLossDailyDrawGames = maxLossDailyDrawGames;
	}

	public Integer getMaxLossDailyDrawGames() {
		return maxLossDailyDrawGames;
	}

	public void setMaxWagerDailyDrawGames(Integer maxWagerDailyDrawGames) {
		this.maxWagerDailyDrawGames = maxWagerDailyDrawGames;
	}

	public Integer getMaxWagerDailyDrawGames() {
		return maxWagerDailyDrawGames;
	}

}