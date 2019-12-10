package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StDmDomainWinApproveLimitMaster entity. @author MyEclipse Persistence Tools
 */

public class StDmDomainWinApproveLimitMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Short id;
	private Short domainId;
	private Double casinoLimit;
	private Double rummyLimit;
	private Double pokerLimit;
	private Double sportsLimit;
	private Double bingoLimit;
	private Double liveCasinoLimit;
	private Double gamesLimit;
	private Double drawGamesLimit;
	private Double sportsLotteryLimit;
	private Double goldenRaceLimit;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;
	// Constructors

	/** default constructor */
	public StDmDomainWinApproveLimitMaster() {
	}

	public StDmDomainWinApproveLimitMaster(Short id, Short domainId,
			Double casinoLimit, Double rummyLimit, Double pokerLimit,
			Double sportsLimit, Double bingoLimit, Double liveCasinoLimit, Double gamesLimit, Double drawGamesLimit) {
		this.id = id;
		this.domainId = domainId;
		this.casinoLimit = casinoLimit;
		this.rummyLimit = rummyLimit;
		this.pokerLimit = pokerLimit;
		this.sportsLimit = sportsLimit;
		this.bingoLimit = bingoLimit;
		this.liveCasinoLimit = liveCasinoLimit;
		this.gamesLimit = gamesLimit;
		this.drawGamesLimit = drawGamesLimit;
	}

	// Property accessors

	public Double getCasinoLimit() {
		return casinoLimit;
	}

	public void setCasinoLimit(Double casinoLimit) {
		this.casinoLimit = casinoLimit;
	}

	public Double getPokerLimit() {
		return pokerLimit;
	}

	public void setPokerLimit(Double pokerLimit) {
		this.pokerLimit = pokerLimit;
	}

	public Double getSportsLimit() {
		return sportsLimit;
	}

	public void setSportsLimit(Double sportsLimit) {
		this.sportsLimit = sportsLimit;
	}

	public Double getBingoLimit() {
		return bingoLimit;
	}

	public void setBingoLimit(Double bingoLimit) {
		this.bingoLimit = bingoLimit;
	}

	public Double getLiveCasinoLimit() {
		return liveCasinoLimit;
	}

	public void setLiveCasinoLimit(Double liveCasinoLimit) {
		this.liveCasinoLimit = liveCasinoLimit;
	}

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

	public Double getRummyLimit() {
		return this.rummyLimit;
	}

	public void setRummyLimit(Double rummyLimit) {
		this.rummyLimit = rummyLimit;
	}

	public void setGamesLimit(Double gamesLimit) {
		this.gamesLimit = gamesLimit;
	}

	public Double getGamesLimit() {
		return gamesLimit;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdationTime() {
		return lastUpdationTime;
	}

	public void setLastUpdationTime(Timestamp lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}

	public void setDrawGamesLimit(Double drawGamesLimit) {
		this.drawGamesLimit = drawGamesLimit;
	}

	public Double getDrawGamesLimit() {
		return drawGamesLimit;
	}

	public Double getSportsLotteryLimit() {
		return sportsLotteryLimit;
	}

	public void setSportsLotteryLimit(Double sportsLotteryLimit) {
		this.sportsLotteryLimit = sportsLotteryLimit;
	}

	public Double getGoldenRaceLimit() {
		return goldenRaceLimit;
	}

	public void setGoldenRaceLimit(Double goldenRaceLimit) {
		this.goldenRaceLimit = goldenRaceLimit;
	}

}