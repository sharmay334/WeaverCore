package com.stpl.pms.hibernate.mapping;

/**
 * StPortalCasinoMaster entity. @author MyEclipse Persistence Tools
 */

public class StPortalCasinoMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer gameId;
	private String gameName;
	private String gameNumber;
	private String gameType;
	private String gameImagePath;
	private Double gamePrice;
	private String gameUrl;
	private String gameParameters;
	private String gameDesc;
	private Short windowHeight;
	private Short windowWidth;
	private String isFlash;
	private String isHtml5;
	private StRmVendorMaster  stRmVendorMaster;

	// Constructors

	/** default constructor */
	public StPortalCasinoMaster() {
	}

	/** minimal constructor */
	public StPortalCasinoMaster(String gameName, String gameNumber,
			String gameImagePath) {
		this.gameName = gameName;
		this.gameNumber = gameNumber;
		this.gameImagePath = gameImagePath;
	}

	/** full constructor */
	public StPortalCasinoMaster(StRmVendorMaster  stRmVendorMaster, String gameName,
			String gameNumber, String gameType, String gameImagePath,
			Double gamePrice,String gameDesc, Short windowHeight, Short windowWidth,String isFlash,String isHtml5) {
		this.stRmVendorMaster = stRmVendorMaster;
		this.gameName = gameName;
		this.gameNumber = gameNumber;
		this.gameType = gameType;
		this.gameImagePath = gameImagePath;
		this.gamePrice = gamePrice;
		this.gameDesc = gameDesc;
		this.windowHeight = windowHeight;
		this.windowWidth = windowWidth;
		this.isFlash=isFlash;
		this.isHtml5=isHtml5;
	}

	// Property accessors

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return this.gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameNumber() {
		return this.gameNumber;
	}

	public void setGameNumber(String gameNumber) {
		this.gameNumber = gameNumber;
	}

	public String getGameType() {
		return this.gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getGameImagePath() {
		return this.gameImagePath;
	}

	public void setGameImagePath(String gameImagePath) {
		this.gameImagePath = gameImagePath;
	}

	public Double getGamePrice() {
		return this.gamePrice;
	}

	public void setGamePrice(Double gamePrice) {
		this.gamePrice = gamePrice;
	}

	public String getGameUrl() {
		return this.gameUrl;
	}

	public void setGameUrl(String gameUrl) {
		this.gameUrl = gameUrl;
	}

	public String getGameParameters() {
		return this.gameParameters;
	}

	public void setGameParameters(String gameParameters) {
		this.gameParameters = gameParameters;
	}

	public String getGameDesc() {
		return this.gameDesc;
	}

	public void setGameDesc(String gameDesc) {
		this.gameDesc = gameDesc;
	}

	public Short getWindowHeight() {
		return this.windowHeight;
	}

	public void setWindowHeight(Short windowHeight) {
		this.windowHeight = windowHeight;
	}

	public Short getWindowWidth() {
		return this.windowWidth;
	}

	public void setWindowWidth(Short windowWidth) {
		this.windowWidth = windowWidth;
	}

	public StRmVendorMaster getStRmVendorMaster() {
		return stRmVendorMaster;
	}

	public void setStRmVendorMaster(StRmVendorMaster stRmVendorMaster) {
		this.stRmVendorMaster = stRmVendorMaster;
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