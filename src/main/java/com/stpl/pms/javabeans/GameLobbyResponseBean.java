package com.stpl.pms.javabeans;

public class GameLobbyResponseBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String gameNumber;
	private String gameName;
	private String gameImageLocations;
	private String currencyCode;
	private double gamePrice;
	private String gameDescription;
	private String gameCategory;
	private short windowHeight;
	private short windowWidth;
	private String isFlash;
	private String isHtml5;
	
	
	public GameLobbyResponseBean()
	{
		
	}
	
	public GameLobbyResponseBean(String gameNumber, String gameName,
			String gameImageLocations, String currencyCode, double gamePrice,
			String gameDescription, String gameCategory, short windowHeight,
			short windowWidth,String isFlash,String isHtml5) {
		super();
		this.gameNumber = gameNumber;
		this.gameName = gameName;
		this.gameImageLocations = gameImageLocations;
		this.currencyCode = currencyCode;
		this.gamePrice = gamePrice;
		this.gameDescription = gameDescription;
		this.gameCategory = gameCategory;
		this.windowHeight = windowHeight;
		this.windowWidth = windowWidth;
		this.isFlash=isFlash;
		this.isHtml5=isHtml5;
	} 
	
	
	public String getGameName() {
		return gameName;
	}
	public String getGameImageLocations() {
		return gameImageLocations;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public double getGamePrice() {
		return gamePrice;
	}
	public String getGameDescription() {
		return gameDescription;
	}
	public String getGameCategory() {
		return gameCategory;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public void setGameImageLocations(String gameImageLocations) {
		this.gameImageLocations = gameImageLocations;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public void setGamePrice(double gamePrice) {
		this.gamePrice = gamePrice;
	}
	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}
	public void setGameCategory(String gameCategory) {
		this.gameCategory = gameCategory;
	}

	public String getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(String gameNumber) {
		this.gameNumber = gameNumber;
	}

	public short getWindowHeight() {
		return windowHeight;
	}

	public short getWindowWidth() {
		return windowWidth;
	}

	public void setWindowHeight(short windowHeight) {
		this.windowHeight = windowHeight;
	}

	public void setWindowWidth(short windowWidth) {
		this.windowWidth = windowWidth;
	}

	public String getIsFlash() {
		return isFlash;
	}

	public String getIsHtml5() {
		return isHtml5;
	}

	public void setIsFlash(String isFlash) {
		this.isFlash = isFlash;
	}

	public void setIsHtml5(String isHtml5) {
		this.isHtml5 = isHtml5;
	}

}
