package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StRgWeeklyTxn entity. @author MyEclipse Persistence Tools
 */

public class StRgWeeklyTxn implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Timestamp mondayDate;
	private Integer nogWagerDaily;
	private Integer nogWagerWeekly;
	private Integer maxLossWeekly;
	private Integer maxWagerWeekly;
	private Integer maxDepositWeekly;
	private Integer nogWagerWeeklyRummy;
	private Integer maxLossWeeklyRummy;
	private Integer maxWagerWeeklyRummy;
	private Integer nogWagerWeeklyCasino;
	private Integer maxLossWeeklyCasino;
	private Integer maxWagerWeeklyCasino;
	private Integer nogWagerWeeklySports;
	private Integer maxLossWeeklySports;
	private Integer maxWagerWeeklySports;
	private Integer nogWagerWeeklyBingo;
	private Integer maxLossWeeklyBingo;
	private Integer maxWagerWeeklyBingo;
	private Integer nogWagerWeeklyPoker;
	private Integer maxLossWeeklyPoker;
	private Integer maxWagerWeeklyPoker;
	private Integer nogWagerWeeklyGames;
	private Integer maxLossWeeklyGames;
	private Integer maxWagerWeeklyGames;
	private Integer nogWagerWeeklyLiveCasino;
	private Integer maxLossWeeklyLiveCasino;
	private Integer maxWagerWeeklyLiveCasino;
	private Integer nogWagerWeeklyInstantDraw;
	private Integer maxLossWeeklyInstantDraw;
	private Integer maxWagerWeeklyInstantDraw;

	private Integer nogWagerWeeklyDrawGames;
	private Integer maxLossWeeklyDrawGames;
	private Integer maxWagerWeeklyDrawGames;

	// Constructors

	/** default constructor */
	public StRgWeeklyTxn() {
	}

	/** full constructor */
	public StRgWeeklyTxn(Long playerId, Short domainId, Timestamp mondayDate) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.mondayDate = mondayDate;
		this.nogWagerDaily = 0;
		this.nogWagerWeekly = 0;
		this.maxLossWeekly = 0;
		this.maxWagerWeekly = 0;
		this.maxDepositWeekly = 0;
		this.nogWagerWeeklyRummy = 0;
		this.maxLossWeeklyRummy = 0;
		this.maxWagerWeeklyRummy = 0;
		this.nogWagerWeeklyCasino = 0;
		this.maxLossWeeklyCasino = 0;
		this.maxWagerWeeklyCasino = 0;
		this.nogWagerWeeklySports = 0;
		this.maxLossWeeklySports = 0;
		this.maxWagerWeeklySports = 0;
		this.nogWagerWeeklyBingo = 0;
		this.maxLossWeeklyBingo = 0;
		this.maxWagerWeeklyBingo = 0;
		this.nogWagerWeeklyPoker = 0;
		this.maxLossWeeklyPoker = 0;
		this.maxWagerWeeklyPoker = 0;
		this.nogWagerWeeklyGames = 0;
		this.maxLossWeeklyGames = 0;
		this.maxWagerWeeklyGames = 0;
		this.nogWagerWeeklyLiveCasino = 0;
		this.maxLossWeeklyLiveCasino = 0;
		this.maxWagerWeeklyLiveCasino = 0;
		this.nogWagerWeeklyInstantDraw = 0;
		this.maxLossWeeklyInstantDraw = 0;
		this.maxWagerWeeklyInstantDraw = 0;
		this.nogWagerWeeklyDrawGames = 0;
		this.maxLossWeeklyDrawGames = 0;
		this.maxWagerWeeklyDrawGames = 0;
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

	public Timestamp getMondayDate() {
		return this.mondayDate;
	}

	public void setMondayDate(Timestamp mondayDate) {
		this.mondayDate = mondayDate;
	}

	public Integer getNogWagerDaily() {
		return this.nogWagerDaily;
	}

	public void setNogWagerDaily(Integer nogWagerDaily) {
		this.nogWagerDaily = nogWagerDaily;
	}

	public Integer getNogWagerWeekly() {
		return this.nogWagerWeekly;
	}

	public void setNogWagerWeekly(Integer nogWagerWeekly) {
		this.nogWagerWeekly = nogWagerWeekly;
	}

	public Integer getMaxLossWeekly() {
		return this.maxLossWeekly;
	}

	public void setMaxLossWeekly(Integer maxLossWeekly) {
		this.maxLossWeekly = maxLossWeekly;
	}

	public Integer getMaxWagerWeekly() {
		return this.maxWagerWeekly;
	}

	public void setMaxWagerWeekly(Integer maxWagerWeekly) {
		this.maxWagerWeekly = maxWagerWeekly;
	}

	public Integer getMaxDepositWeekly() {
		return this.maxDepositWeekly;
	}

	public void setMaxDepositWeekly(Integer maxDepositWeekly) {
		this.maxDepositWeekly = maxDepositWeekly;
	}

	public Integer getNogWagerWeeklyRummy() {
		return this.nogWagerWeeklyRummy;
	}

	public void setNogWagerWeeklyRummy(Integer nogWagerWeeklyRummy) {
		this.nogWagerWeeklyRummy = nogWagerWeeklyRummy;
	}

	public Integer getMaxLossWeeklyRummy() {
		return this.maxLossWeeklyRummy;
	}

	public void setMaxLossWeeklyRummy(Integer maxLossWeeklyRummy) {
		this.maxLossWeeklyRummy = maxLossWeeklyRummy;
	}

	public Integer getMaxWagerWeeklyRummy() {
		return this.maxWagerWeeklyRummy;
	}

	public void setMaxWagerWeeklyRummy(Integer maxWagerWeeklyRummy) {
		this.maxWagerWeeklyRummy = maxWagerWeeklyRummy;
	}

	public Integer getNogWagerWeeklyCasino() {
		return this.nogWagerWeeklyCasino;
	}

	public void setNogWagerWeeklyCasino(Integer nogWagerWeeklyCasino) {
		this.nogWagerWeeklyCasino = nogWagerWeeklyCasino;
	}

	public Integer getMaxLossWeeklyCasino() {
		return this.maxLossWeeklyCasino;
	}

	public void setMaxLossWeeklyCasino(Integer maxLossWeeklyCasino) {
		this.maxLossWeeklyCasino = maxLossWeeklyCasino;
	}

	public Integer getMaxWagerWeeklyCasino() {
		return this.maxWagerWeeklyCasino;
	}

	public void setMaxWagerWeeklyCasino(Integer maxWagerWeeklyCasino) {
		this.maxWagerWeeklyCasino = maxWagerWeeklyCasino;
	}

	public Integer getNogWagerWeeklySports() {
		return this.nogWagerWeeklySports;
	}

	public void setNogWagerWeeklySports(Integer nogWagerWeeklySports) {
		this.nogWagerWeeklySports = nogWagerWeeklySports;
	}

	public Integer getMaxLossWeeklySports() {
		return this.maxLossWeeklySports;
	}

	public void setMaxLossWeeklySports(Integer maxLossWeeklySports) {
		this.maxLossWeeklySports = maxLossWeeklySports;
	}

	public Integer getMaxWagerWeeklySports() {
		return this.maxWagerWeeklySports;
	}

	public void setMaxWagerWeeklySports(Integer maxWagerWeeklySports) {
		this.maxWagerWeeklySports = maxWagerWeeklySports;
	}

	public Integer getNogWagerWeeklyBingo() {
		return this.nogWagerWeeklyBingo;
	}

	public void setNogWagerWeeklyBingo(Integer nogWagerWeeklyBingo) {
		this.nogWagerWeeklyBingo = nogWagerWeeklyBingo;
	}

	public Integer getMaxLossWeeklyBingo() {
		return this.maxLossWeeklyBingo;
	}

	public void setMaxLossWeeklyBingo(Integer maxLossWeeklyBingo) {
		this.maxLossWeeklyBingo = maxLossWeeklyBingo;
	}

	public Integer getMaxWagerWeeklyBingo() {
		return this.maxWagerWeeklyBingo;
	}

	public void setMaxWagerWeeklyBingo(Integer maxWagerWeeklyBingo) {
		this.maxWagerWeeklyBingo = maxWagerWeeklyBingo;
	}

	public Integer getNogWagerWeeklyPoker() {
		return this.nogWagerWeeklyPoker;
	}

	public void setNogWagerWeeklyPoker(Integer nogWagerWeeklyPoker) {
		this.nogWagerWeeklyPoker = nogWagerWeeklyPoker;
	}

	public Integer getMaxLossWeeklyPoker() {
		return this.maxLossWeeklyPoker;
	}

	public void setMaxLossWeeklyPoker(Integer maxLossWeeklyPoker) {
		this.maxLossWeeklyPoker = maxLossWeeklyPoker;
	}

	public Integer getMaxWagerWeeklyPoker() {
		return this.maxWagerWeeklyPoker;
	}

	public void setMaxWagerWeeklyPoker(Integer maxWagerWeeklyPoker) {
		this.maxWagerWeeklyPoker = maxWagerWeeklyPoker;
	}

	public Integer getNogWagerWeeklyGames() {
		return this.nogWagerWeeklyGames;
	}

	public void setNogWagerWeeklyGames(Integer nogWagerWeeklyGames) {
		this.nogWagerWeeklyGames = nogWagerWeeklyGames;
	}

	public Integer getMaxLossWeeklyGames() {
		return this.maxLossWeeklyGames;
	}

	public void setMaxLossWeeklyGames(Integer maxLossWeeklyGames) {
		this.maxLossWeeklyGames = maxLossWeeklyGames;
	}

	public Integer getMaxWagerWeeklyGames() {
		return this.maxWagerWeeklyGames;
	}

	public void setMaxWagerWeeklyGames(Integer maxWagerWeeklyGames) {
		this.maxWagerWeeklyGames = maxWagerWeeklyGames;
	}

	public Integer getNogWagerWeeklyLiveCasino() {
		return this.nogWagerWeeklyLiveCasino;
	}

	public void setNogWagerWeeklyLiveCasino(Integer nogWagerWeeklyLiveCasino) {
		this.nogWagerWeeklyLiveCasino = nogWagerWeeklyLiveCasino;
	}

	public Integer getMaxLossWeeklyLiveCasino() {
		return this.maxLossWeeklyLiveCasino;
	}

	public void setMaxLossWeeklyLiveCasino(Integer maxLossWeeklyLiveCasino) {
		this.maxLossWeeklyLiveCasino = maxLossWeeklyLiveCasino;
	}

	public Integer getMaxWagerWeeklyLiveCasino() {
		return this.maxWagerWeeklyLiveCasino;
	}

	public void setMaxWagerWeeklyLiveCasino(Integer maxWagerWeeklyLiveCasino) {
		this.maxWagerWeeklyLiveCasino = maxWagerWeeklyLiveCasino;
	}

	public Integer getNogWagerWeeklyInstantDraw() {
		return nogWagerWeeklyInstantDraw;
	}

	public void setNogWagerWeeklyInstantDraw(Integer nogWagerWeeklyInstantDraw) {
		this.nogWagerWeeklyInstantDraw = nogWagerWeeklyInstantDraw;
	}

	public Integer getMaxLossWeeklyInstantDraw() {
		return maxLossWeeklyInstantDraw;
	}

	public void setMaxLossWeeklyInstantDraw(Integer maxLossWeeklyInstantDraw) {
		this.maxLossWeeklyInstantDraw = maxLossWeeklyInstantDraw;
	}

	public Integer getMaxWagerWeeklyInstantDraw() {
		return maxWagerWeeklyInstantDraw;
	}

	public void setMaxWagerWeeklyInstantDraw(Integer maxWagerWeeklyInstantDraw) {
		this.maxWagerWeeklyInstantDraw = maxWagerWeeklyInstantDraw;
	}

	public void setNogWagerWeeklyDrawGames(Integer nogWagerWeeklyDrawGames) {
		this.nogWagerWeeklyDrawGames = nogWagerWeeklyDrawGames;
	}

	public Integer getNogWagerWeeklyDrawGames() {
		return nogWagerWeeklyDrawGames;
	}

	public void setMaxLossWeeklyDrawGames(Integer maxLossWeeklyDrawGames) {
		this.maxLossWeeklyDrawGames = maxLossWeeklyDrawGames;
	}

	public Integer getMaxLossWeeklyDrawGames() {
		return maxLossWeeklyDrawGames;
	}

	public void setMaxWagerWeeklyDrawGames(Integer maxWagerWeeklyDrawGames) {
		this.maxWagerWeeklyDrawGames = maxWagerWeeklyDrawGames;
	}

	public Integer getMaxWagerWeeklyDrawGames() {
		return maxWagerWeeklyDrawGames;
	}

}