package com.stpl.pms.hibernate.mapping;

public class StRiskPlrTxnControl implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private String deposit;
	private String withdrawal;
	private String wagerSports;
	private String wagerCasino;
	private String wagerRummy;
	private String wagerLiveCasino;
	private String wagerPoker;
	private String wagerBingo;
	private String wagerGames;
	private String wagerDrawGames;
	private String wagerSportsLottery;
	private String wagerInstantDraw;
	
	public StRiskPlrTxnControl() {
	}

	public StRiskPlrTxnControl(Long playerId) {
		this.playerId = playerId;
		this.deposit = "Y";
		this.withdrawal = "Y";
		this.wagerBingo = "Y";
		this.wagerCasino = "Y";
		this.wagerLiveCasino = "Y";
		this.wagerPoker = "Y";
		this.wagerRummy = "Y";
		this.wagerSports = "Y";
		this.wagerGames = "Y";
		this.wagerDrawGames = "Y";
		this.setWagerSportsLottery("Y");
		this.wagerInstantDraw = "Y";
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

	public String getDeposit() {
		return this.deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getWithdrawal() {
		return this.withdrawal;
	}

	public void setWithdrawal(String withdrawal) {
		this.withdrawal = withdrawal;
	}

	public String getWagerSports() {
		return this.wagerSports;
	}

	public void setWagerSports(String wagerSports) {
		this.wagerSports = wagerSports;
	}

	public String getWagerCasino() {
		return this.wagerCasino;
	}

	public void setWagerCasino(String wagerCasino) {
		this.wagerCasino = wagerCasino;
	}

	public String getWagerRummy() {
		return this.wagerRummy;
	}

	public void setWagerRummy(String wagerRummy) {
		this.wagerRummy = wagerRummy;
	}

	public String getWagerLiveCasino() {
		return this.wagerLiveCasino;
	}

	public void setWagerLiveCasino(String wagerLiveCasino) {
		this.wagerLiveCasino = wagerLiveCasino;
	}

	public String getWagerPoker() {
		return this.wagerPoker;
	}

	public void setWagerPoker(String wagerPoker) {
		this.wagerPoker = wagerPoker;
	}

	public String getWagerBingo() {
		return this.wagerBingo;
	}

	public void setWagerBingo(String wagerBingo) {
		this.wagerBingo = wagerBingo;
	}

	public void setWagerGames(String wagerGames) {
		this.wagerGames = wagerGames;
	}

	public String getWagerGames() {
		return wagerGames;
	}

	public String getWagerInstantDraw() {
		return wagerInstantDraw;
	}

	public void setWagerInstantDraw(String wagerInstantDraw) {
		this.wagerInstantDraw = wagerInstantDraw;
	}

	public void setWagerDrawGames(String wagerDrawGames) {
		this.wagerDrawGames = wagerDrawGames;
	}

	public String getWagerDrawGames() {
		return wagerDrawGames;
	}

	public String getWagerSportsLottery() {
		return wagerSportsLottery;
	}

	public void setWagerSportsLottery(String wagerSportsLottery) {
		this.wagerSportsLottery = wagerSportsLottery;
	}

}