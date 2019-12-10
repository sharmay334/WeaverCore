package com.stpl.pms.javabeans;

public class GamePlayedWithPlayer implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int noOfGames;
	private String alias;
	private IpDetails ipDetails;
	private GameResult gameResult;

	public int getNoOfGames() {
		return noOfGames;
	}

	public void setNoOfGames(int noOfGames) {
		this.noOfGames = noOfGames;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public IpDetails getIpDetails() {
		return ipDetails;
	}

	public void setIpDetails(IpDetails ipDetails) {
		this.ipDetails = ipDetails;
	}

	public GameResult getGameResult() {
		return gameResult;
	}

	public void setGameResult(GameResult gameResult) {
		this.gameResult = gameResult;
	}

	@Override
	public String toString() {
		return "GamePlayedWithPlayer [noOfGames=" + noOfGames + ", alias="
				+ alias + ", ipDetails=" + ipDetails + ", gameResult=" + gameResult
				+ "]";
	}

}
