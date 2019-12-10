package com.stpl.pms.hibernate.mapping;

/**
 * StRgPlayerLimit entity. @author MyEclipse Persistence Tools
 */

public class StRgPlayerLimit implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Integer nogWagerDaily;
	private Integer nogWagerWeekly;
	private Integer maxLossDaily;
	private Integer maxLossWeekly;
	private Integer maxWagerDaily;
	private Integer maxWagerWeekly;
	private Integer maxDepositDaily;
	private Integer maxDepositWeekly;
	private Integer nogWagerDailyRummy;
	private Integer nogWagerWeeklyRummy;
	private Integer nogWagerDailyCasino;
	private Integer nogWagerWeeklyCasino;
	private Integer nogWagerDailyGames;
	private Integer nogWagerWeeklyGames;
	private Integer nogWagerDailyBingo;
	private Integer nogWagerWeeklyBingo;
	private Integer nogWagerDailyLiveCasino;
	private Integer nogWagerWeeklyLiveCasino;
	private Integer nogWagerDailyPoker;
	private Integer nogWagerWeeklyPoker;
	private Integer nogWagerDailySports;
	private Integer nogWagerWeeklySports;
	private Integer nogWagerDailyInstantDraw;
	private Integer nogWagerWeeklyInstantDraw;
	private Integer maxLossDailyRummy;
	private Integer maxLossWeeklyRummy;
	private Integer maxLossDailyCasino;
	private Integer maxLossWeeklyCasino;
	private Integer maxLossDailyGames;
	private Integer maxLossWeeklyGames;
	private Integer maxLossDailyBingo;
	private Integer maxLossWeeklyBingo;
	private Integer maxLossDailyLiveCasino;
	private Integer maxLossWeeklyLiveCasino;
	private Integer maxLossDailyPoker;
	private Integer maxLossWeeklyPoker;
	private Integer maxLossDailySports;
	private Integer maxLossWeeklySports;
	private Integer maxLossDailyInstantDraw;
	private Integer maxLossWeeklyInstantDraw;
	private Integer maxWagerDailyRummy;
	private Integer maxWagerWeeklyRummy;
	private Integer maxWagerDailyCasino;
	private Integer maxWagerWeeklyCasino;
	private Integer maxWagerDailyGames;
	private Integer maxWagerWeeklyGames;
	private Integer maxWagerDailyBingo;
	private Integer maxWagerWeeklyBingo;
	private Integer maxWagerDailyLiveCasino;
	private Integer maxWagerWeeklyLiveCasino;
	private Integer maxWagerDailyPoker;
	private Integer maxWagerWeeklyPoker;
	private Integer maxWagerDailySports;
	private Integer maxWagerWeeklySports;
	private Integer maxWagerDailyInstantDraw;
	private Integer maxWagerWeeklyInstantDraw;
	
	private Integer maxWagerDailyDrawGames;
	private Integer maxWagerWeeklyDrawGames;
	private Integer maxLossDailyDrawGames;
	private Integer maxLossWeeklyDrawGames;
	private Integer nogWagerDailyDrawGames;
	private Integer nogWagerWeeklyDrawGames;
	
	
	// Constructors

	/** default constructor */
	public StRgPlayerLimit() {
	}

	public StRgPlayerLimit(Long playerId, Short domainId) {
		this.playerId = playerId;
		this.domainId = domainId;
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

	public Integer getMaxLossDaily() {
		return this.maxLossDaily;
	}

	public void setMaxLossDaily(Integer maxLossDaily) {
		this.maxLossDaily = maxLossDaily;
	}

	public Integer getMaxLossWeekly() {
		return this.maxLossWeekly;
	}

	public void setMaxLossWeekly(Integer maxLossWeekly) {
		this.maxLossWeekly = maxLossWeekly;
	}

	public Integer getMaxWagerDaily() {
		return this.maxWagerDaily;
	}

	public void setMaxWagerDaily(Integer maxWagerDaily) {
		this.maxWagerDaily = maxWagerDaily;
	}

	public Integer getMaxWagerWeekly() {
		return this.maxWagerWeekly;
	}

	public void setMaxWagerWeekly(Integer maxWagerWeekly) {
		this.maxWagerWeekly = maxWagerWeekly;
	}

	public Integer getMaxDepositDaily() {
		return this.maxDepositDaily;
	}

	public void setMaxDepositDaily(Integer maxDepositDaily) {
		this.maxDepositDaily = maxDepositDaily;
	}

	public Integer getMaxDepositWeekly() {
		return this.maxDepositWeekly;
	}

	public void setMaxDepositWeekly(Integer maxDepositWeekly) {
		this.maxDepositWeekly = maxDepositWeekly;
	}

	public Integer getNogWagerDailyRummy() {
		return this.nogWagerDailyRummy;
	}

	public void setNogWagerDailyRummy(Integer nogWagerDailyRummy) {
		this.nogWagerDailyRummy = nogWagerDailyRummy;
	}

	public Integer getNogWagerWeeklyRummy() {
		return this.nogWagerWeeklyRummy;
	}

	public void setNogWagerWeeklyRummy(Integer nogWagerWeeklyRummy) {
		this.nogWagerWeeklyRummy = nogWagerWeeklyRummy;
	}

	public Integer getNogWagerDailyCasino() {
		return this.nogWagerDailyCasino;
	}

	public void setNogWagerDailyCasino(Integer nogWagerDailyCasino) {
		this.nogWagerDailyCasino = nogWagerDailyCasino;
	}

	public Integer getNogWagerWeeklyCasino() {
		return this.nogWagerWeeklyCasino;
	}

	public void setNogWagerWeeklyCasino(Integer nogWagerWeeklyCasino) {
		this.nogWagerWeeklyCasino = nogWagerWeeklyCasino;
	}

	public Integer getNogWagerDailyGames() {
		return this.nogWagerDailyGames;
	}

	public void setNogWagerDailyGames(Integer nogWagerDailyGames) {
		this.nogWagerDailyGames = nogWagerDailyGames;
	}

	public Integer getNogWagerWeeklyGames() {
		return this.nogWagerWeeklyGames;
	}

	public void setNogWagerWeeklyGames(Integer nogWagerWeeklyGames) {
		this.nogWagerWeeklyGames = nogWagerWeeklyGames;
	}

	public Integer getNogWagerDailyBingo() {
		return this.nogWagerDailyBingo;
	}

	public void setNogWagerDailyBingo(Integer nogWagerDailyBingo) {
		this.nogWagerDailyBingo = nogWagerDailyBingo;
	}

	public Integer getNogWagerWeeklyBingo() {
		return this.nogWagerWeeklyBingo;
	}

	public void setNogWagerWeeklyBingo(Integer nogWagerWeeklyBingo) {
		this.nogWagerWeeklyBingo = nogWagerWeeklyBingo;
	}

	public Integer getNogWagerDailyLiveCasino() {
		return this.nogWagerDailyLiveCasino;
	}

	public void setNogWagerDailyLiveCasino(Integer nogWagerDailyLiveCasino) {
		this.nogWagerDailyLiveCasino = nogWagerDailyLiveCasino;
	}

	public Integer getNogWagerWeeklyLiveCasino() {
		return this.nogWagerWeeklyLiveCasino;
	}

	public void setNogWagerWeeklyLiveCasino(Integer nogWagerWeeklyLiveCasino) {
		this.nogWagerWeeklyLiveCasino = nogWagerWeeklyLiveCasino;
	}

	public Integer getNogWagerDailyPoker() {
		return this.nogWagerDailyPoker;
	}

	public void setNogWagerDailyPoker(Integer nogWagerDailyPoker) {
		this.nogWagerDailyPoker = nogWagerDailyPoker;
	}

	public Integer getNogWagerWeeklyPoker() {
		return this.nogWagerWeeklyPoker;
	}

	public void setNogWagerWeeklyPoker(Integer nogWagerWeeklyPoker) {
		this.nogWagerWeeklyPoker = nogWagerWeeklyPoker;
	}

	public Integer getNogWagerDailySports() {
		return this.nogWagerDailySports;
	}

	public void setNogWagerDailySports(Integer nogWagerDailySports) {
		this.nogWagerDailySports = nogWagerDailySports;
	}

	public Integer getNogWagerWeeklySports() {
		return this.nogWagerWeeklySports;
	}

	public void setNogWagerWeeklySports(Integer nogWagerWeeklySports) {
		this.nogWagerWeeklySports = nogWagerWeeklySports;
	}

	public Integer getMaxLossDailyRummy() {
		return this.maxLossDailyRummy;
	}

	public void setMaxLossDailyRummy(Integer maxLossDailyRummy) {
		this.maxLossDailyRummy = maxLossDailyRummy;
	}

	public Integer getMaxLossWeeklyRummy() {
		return this.maxLossWeeklyRummy;
	}

	public void setMaxLossWeeklyRummy(Integer maxLossWeeklyRummy) {
		this.maxLossWeeklyRummy = maxLossWeeklyRummy;
	}

	public Integer getMaxLossDailyCasino() {
		return this.maxLossDailyCasino;
	}

	public void setMaxLossDailyCasino(Integer maxLossDailyCasino) {
		this.maxLossDailyCasino = maxLossDailyCasino;
	}

	public Integer getMaxLossWeeklyCasino() {
		return this.maxLossWeeklyCasino;
	}

	public void setMaxLossWeeklyCasino(Integer maxLossWeeklyCasino) {
		this.maxLossWeeklyCasino = maxLossWeeklyCasino;
	}

	public Integer getMaxLossDailyGames() {
		return this.maxLossDailyGames;
	}

	public void setMaxLossDailyGames(Integer maxLossDailyGames) {
		this.maxLossDailyGames = maxLossDailyGames;
	}

	public Integer getMaxLossWeeklyGames() {
		return this.maxLossWeeklyGames;
	}

	public void setMaxLossWeeklyGames(Integer maxLossWeeklyGames) {
		this.maxLossWeeklyGames = maxLossWeeklyGames;
	}

	public Integer getMaxLossDailyBingo() {
		return this.maxLossDailyBingo;
	}

	public void setMaxLossDailyBingo(Integer maxLossDailyBingo) {
		this.maxLossDailyBingo = maxLossDailyBingo;
	}

	public Integer getMaxLossWeeklyBingo() {
		return this.maxLossWeeklyBingo;
	}

	public void setMaxLossWeeklyBingo(Integer maxLossWeeklyBingo) {
		this.maxLossWeeklyBingo = maxLossWeeklyBingo;
	}

	public Integer getMaxLossDailyLiveCasino() {
		return this.maxLossDailyLiveCasino;
	}

	public void setMaxLossDailyLiveCasino(Integer maxLossDailyLiveCasino) {
		this.maxLossDailyLiveCasino = maxLossDailyLiveCasino;
	}

	public Integer getMaxLossWeeklyLiveCasino() {
		return this.maxLossWeeklyLiveCasino;
	}

	public void setMaxLossWeeklyLiveCasino(Integer maxLossWeeklyLiveCasino) {
		this.maxLossWeeklyLiveCasino = maxLossWeeklyLiveCasino;
	}

	public Integer getMaxLossDailyPoker() {
		return this.maxLossDailyPoker;
	}

	public void setMaxLossDailyPoker(Integer maxLossDailyPoker) {
		this.maxLossDailyPoker = maxLossDailyPoker;
	}

	public Integer getMaxLossWeeklyPoker() {
		return this.maxLossWeeklyPoker;
	}

	public void setMaxLossWeeklyPoker(Integer maxLossWeeklyPoker) {
		this.maxLossWeeklyPoker = maxLossWeeklyPoker;
	}

	public Integer getMaxLossDailySports() {
		return this.maxLossDailySports;
	}

	public void setMaxLossDailySports(Integer maxLossDailySports) {
		this.maxLossDailySports = maxLossDailySports;
	}

	public Integer getMaxLossWeeklySports() {
		return this.maxLossWeeklySports;
	}

	public void setMaxLossWeeklySports(Integer maxLossWeeklySports) {
		this.maxLossWeeklySports = maxLossWeeklySports;
	}

	public Integer getMaxWagerDailyRummy() {
		return this.maxWagerDailyRummy;
	}

	public void setMaxWagerDailyRummy(Integer maxWagerDailyRummy) {
		this.maxWagerDailyRummy = maxWagerDailyRummy;
	}

	public Integer getMaxWagerWeeklyRummy() {
		return this.maxWagerWeeklyRummy;
	}

	public void setMaxWagerWeeklyRummy(Integer maxWagerWeeklyRummy) {
		this.maxWagerWeeklyRummy = maxWagerWeeklyRummy;
	}

	public Integer getMaxWagerDailyCasino() {
		return this.maxWagerDailyCasino;
	}

	public void setMaxWagerDailyCasino(Integer maxWagerDailyCasino) {
		this.maxWagerDailyCasino = maxWagerDailyCasino;
	}

	public Integer getMaxWagerWeeklyCasino() {
		return this.maxWagerWeeklyCasino;
	}

	public void setMaxWagerWeeklyCasino(Integer maxWagerWeeklyCasino) {
		this.maxWagerWeeklyCasino = maxWagerWeeklyCasino;
	}

	public Integer getMaxWagerDailyGames() {
		return this.maxWagerDailyGames;
	}

	public void setMaxWagerDailyGames(Integer maxWagerDailyGames) {
		this.maxWagerDailyGames = maxWagerDailyGames;
	}

	public Integer getMaxWagerWeeklyGames() {
		return this.maxWagerWeeklyGames;
	}

	public void setMaxWagerWeeklyGames(Integer maxWagerWeeklyGames) {
		this.maxWagerWeeklyGames = maxWagerWeeklyGames;
	}

	public Integer getMaxWagerDailyBingo() {
		return this.maxWagerDailyBingo;
	}

	public void setMaxWagerDailyBingo(Integer maxWagerDailyBingo) {
		this.maxWagerDailyBingo = maxWagerDailyBingo;
	}

	public Integer getMaxWagerWeeklyBingo() {
		return this.maxWagerWeeklyBingo;
	}

	public void setMaxWagerWeeklyBingo(Integer maxWagerWeeklyBingo) {
		this.maxWagerWeeklyBingo = maxWagerWeeklyBingo;
	}

	public Integer getMaxWagerDailyLiveCasino() {
		return this.maxWagerDailyLiveCasino;
	}

	public void setMaxWagerDailyLiveCasino(Integer maxWagerDailyLiveCasino) {
		this.maxWagerDailyLiveCasino = maxWagerDailyLiveCasino;
	}

	public Integer getMaxWagerWeeklyLiveCasino() {
		return this.maxWagerWeeklyLiveCasino;
	}

	public void setMaxWagerWeeklyLiveCasino(Integer maxWagerWeeklyLiveCasino) {
		this.maxWagerWeeklyLiveCasino = maxWagerWeeklyLiveCasino;
	}

	public Integer getMaxWagerDailyPoker() {
		return this.maxWagerDailyPoker;
	}

	public void setMaxWagerDailyPoker(Integer maxWagerDailyPoker) {
		this.maxWagerDailyPoker = maxWagerDailyPoker;
	}

	public Integer getMaxWagerWeeklyPoker() {
		return this.maxWagerWeeklyPoker;
	}

	public void setMaxWagerWeeklyPoker(Integer maxWagerWeeklyPoker) {
		this.maxWagerWeeklyPoker = maxWagerWeeklyPoker;
	}

	public Integer getMaxWagerDailySports() {
		return this.maxWagerDailySports;
	}

	public void setMaxWagerDailySports(Integer maxWagerDailySports) {
		this.maxWagerDailySports = maxWagerDailySports;
	}

	public Integer getMaxWagerWeeklySports() {
		return this.maxWagerWeeklySports;
	}

	public void setMaxWagerWeeklySports(Integer maxWagerWeeklySports) {
		this.maxWagerWeeklySports = maxWagerWeeklySports;
	}

	public Integer getNogWagerDailyInstantDraw() {
		return nogWagerDailyInstantDraw;
	}

	public void setNogWagerDailyInstantDraw(Integer nogWagerDailyInstantDraw) {
		this.nogWagerDailyInstantDraw = nogWagerDailyInstantDraw;
	}

	public Integer getNogWagerWeeklyInstantDraw() {
		return nogWagerWeeklyInstantDraw;
	}

	public void setNogWagerWeeklyInstantDraw(Integer nogWagerWeeklyInstantDraw) {
		this.nogWagerWeeklyInstantDraw = nogWagerWeeklyInstantDraw;
	}

	public Integer getMaxLossDailyInstantDraw() {
		return maxLossDailyInstantDraw;
	}

	public void setMaxLossDailyInstantDraw(Integer maxLossDailyInstantDraw) {
		this.maxLossDailyInstantDraw = maxLossDailyInstantDraw;
	}

	public Integer getMaxLossWeeklyInstantDraw() {
		return maxLossWeeklyInstantDraw;
	}

	public void setMaxLossWeeklyInstantDraw(Integer maxLossWeeklyInstantDraw) {
		this.maxLossWeeklyInstantDraw = maxLossWeeklyInstantDraw;
	}

	public Integer getMaxWagerDailyInstantDraw() {
		return maxWagerDailyInstantDraw;
	}

	public void setMaxWagerDailyInstantDraw(Integer maxWagerDailyInstantDraw) {
		this.maxWagerDailyInstantDraw = maxWagerDailyInstantDraw;
	}

	public Integer getMaxWagerWeeklyInstantDraw() {
		return maxWagerWeeklyInstantDraw;
	}

	public void setMaxWagerWeeklyInstantDraw(Integer maxWagerWeeklyInstantDraw) {
		this.maxWagerWeeklyInstantDraw = maxWagerWeeklyInstantDraw;
	}

	public Integer getMaxWagerDailyDrawGames() {
		return maxWagerDailyDrawGames;
	}

	public void setMaxWagerDailyDrawGames(Integer maxWagerDailyDrawGames) {
		this.maxWagerDailyDrawGames = maxWagerDailyDrawGames;
	}

	public Integer getMaxWagerWeeklyDrawGames() {
		return maxWagerWeeklyDrawGames;
	}

	public void setMaxWagerWeeklyDrawGames(Integer maxWagerWeeklyDrawGames) {
		this.maxWagerWeeklyDrawGames = maxWagerWeeklyDrawGames;
	}

	public Integer getMaxLossDailyDrawGames() {
		return maxLossDailyDrawGames;
	}

	public void setMaxLossDailyDrawGames(Integer maxLossDailyDrawGames) {
		this.maxLossDailyDrawGames = maxLossDailyDrawGames;
	}

	public Integer getMaxLossWeeklyDrawGames() {
		return maxLossWeeklyDrawGames;
	}

	public void setMaxLossWeeklyDrawGames(Integer maxLossWeeklyDrawGames) {
		this.maxLossWeeklyDrawGames = maxLossWeeklyDrawGames;
	}

	public Integer getNogWagerDailyDrawGames() {
		return nogWagerDailyDrawGames;
	}

	public void setNogWagerDailyDrawGames(Integer nogWagerDailyDrawGames) {
		this.nogWagerDailyDrawGames = nogWagerDailyDrawGames;
	}

	public Integer getNogWagerWeeklyDrawGames() {
		return nogWagerWeeklyDrawGames;
	}

	public void setNogWagerWeeklyDrawGames(Integer nogWagerWeeklyDrawGames) {
		this.nogWagerWeeklyDrawGames = nogWagerWeeklyDrawGames;
	}

}