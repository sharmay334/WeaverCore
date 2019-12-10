package com.stpl.pms.javabeans;

import java.io.Serializable;

public class DomainWinApproveLimitBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Short domainId;
	private Double casinoLimit;
	private Double rummyLimit;
	private Double pokerLimit;
	private Double sportsLimit;
	private Double bingoimit;
	private Double liveCasinoLimit;
	private Double gamesLimit;
	private Double drawGamesLimit;
	private Double sportsLotteryLimit;
	private Double goldenRaceLimit;
	
	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Short getDomainId() {
		return domainId;
	}

	public void setRummyLimit(Double rummyLimit) {
		this.rummyLimit = rummyLimit;
	}

	public Double getRummyLimit() {
		return rummyLimit;
	}

	public void setCasinoLimit(Double casinoLimit) {
		this.casinoLimit = casinoLimit;
	}

	public Double getCasinoLimit() {
		return casinoLimit;
	}

	public void setPokerLimit(Double pokerLimit) {
		this.pokerLimit = pokerLimit;
	}

	public Double getPokerLimit() {
		return pokerLimit;
	}

	public void setSportsLimit(Double sportsLimit) {
		this.sportsLimit = sportsLimit;
	}

	public Double getSportsLimit() {
		return sportsLimit;
	}

	public void setBingoimit(Double bingoimit) {
		this.bingoimit = bingoimit;
	}

	public Double getBingoimit() {
		return bingoimit;
	}

	public void setLiveCasinoLimit(Double liveCasinoLimit) {
		this.liveCasinoLimit = liveCasinoLimit;
	}

	public Double getLiveCasinoLimit() {
		return liveCasinoLimit;
	}

	public void setGamesLimit(Double gamesLimit) {
		this.gamesLimit = gamesLimit;
	}

	public Double getGamesLimit() {
		return gamesLimit;
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
