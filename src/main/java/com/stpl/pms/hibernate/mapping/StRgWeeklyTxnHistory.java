package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StRgWeeklyTxnHistory entity. @author MyEclipse Persistence Tools
 */

public class StRgWeeklyTxnHistory implements java.io.Serializable {

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
	public StRgWeeklyTxnHistory() {
	}

	/** full constructor */
	public StRgWeeklyTxnHistory(StRgWeeklyTxn bean) {
		this.playerId = bean.getPlayerId();
		this.domainId = bean.getDomainId();
		this.mondayDate = bean.getMondayDate();
		this.nogWagerDaily = bean.getNogWagerDaily();
		this.nogWagerWeekly = bean.getNogWagerWeekly();
		this.maxLossWeekly = bean.getMaxLossWeekly();
		this.maxWagerWeekly = bean.getMaxWagerWeekly();
		this.maxDepositWeekly = bean.getMaxDepositWeekly();
		this.nogWagerWeeklyRummy = bean.getNogWagerWeeklyRummy();
		this.maxLossWeeklyRummy = bean.getMaxLossWeeklyRummy();
		this.maxWagerWeeklyRummy = bean.getMaxWagerWeeklyRummy();
		this.nogWagerWeeklyCasino = bean.getNogWagerWeeklyCasino();
		this.maxLossWeeklyCasino = bean.getMaxLossWeeklyCasino();
		this.maxWagerWeeklyCasino = bean.getMaxWagerWeeklyCasino();
		this.nogWagerWeeklySports = bean.getNogWagerWeeklySports();
		this.maxLossWeeklySports = bean.getMaxLossWeeklySports();
		this.maxWagerWeeklySports = bean.getMaxWagerWeeklySports();
		this.nogWagerWeeklyBingo = bean.getNogWagerWeeklyBingo();
		this.maxLossWeeklyBingo = bean.getMaxLossWeeklyBingo();
		this.maxWagerWeeklyBingo = bean.getMaxWagerWeeklyBingo();
		this.nogWagerWeeklyPoker = bean.getNogWagerWeeklyPoker();
		this.maxLossWeeklyPoker = bean.getMaxLossWeeklyPoker();
		this.maxWagerWeeklyPoker = bean.getMaxWagerWeeklyPoker();
		this.nogWagerWeeklyGames = bean.getNogWagerWeeklyGames();
		this.maxLossWeeklyGames = bean.getMaxLossWeeklyGames();
		this.maxWagerWeeklyGames = bean.getMaxWagerWeeklyGames();
		this.nogWagerWeeklyLiveCasino = bean.getNogWagerWeeklyLiveCasino();
		this.maxLossWeeklyLiveCasino = bean.getMaxLossWeeklyLiveCasino();
		this.maxWagerWeeklyLiveCasino = bean.getMaxWagerWeeklyLiveCasino();
		this.nogWagerWeeklyInstantDraw = bean.getNogWagerWeeklyInstantDraw();
		this.maxLossWeeklyInstantDraw = bean.getMaxLossWeeklyInstantDraw();
		this.maxWagerWeeklyInstantDraw = bean.getMaxWagerWeeklyInstantDraw();
		this.nogWagerWeeklyDrawGames = bean.getNogWagerWeeklyDrawGames();
		this.maxLossWeeklyDrawGames = bean.getMaxLossWeeklyDrawGames();
		this.maxWagerWeeklyDrawGames = bean.getMaxWagerWeeklyDrawGames();
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