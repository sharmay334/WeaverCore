package com.stpl.pms.javabeans;

public class CommonMiscGameBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer gameId;
	private Integer vendorId;
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
	private String mode;
	private String gameTypeAssign;
	private String status;

	// Constructors

	/** default constructor */
	public CommonMiscGameBean() {
	}

	/** minimal constructor */
	public CommonMiscGameBean(String gameName, String gameNumber,
			String gameImagePath) {
		this.gameName = gameName;
		this.gameNumber = gameNumber;
		this.gameImagePath = gameImagePath;
	}

	/** full constructor */
	public CommonMiscGameBean(Integer vendorId, String gameName,
			String gameNumber, String gameType, String gameImagePath,
			Double gamePrice, String gameDesc, Short windowHeight,
			Short windowWidth, String status) {
		this.vendorId = vendorId;
		this.gameName = gameName;
		this.gameNumber = gameNumber;
		this.gameType = gameType;
		this.gameImagePath = gameImagePath;
		this.gamePrice = gamePrice;
		this.gameDesc = gameDesc;
		this.windowHeight = windowHeight;
		this.windowWidth = windowWidth;
		this.status = status;
	}

	public Integer getGameId() {
		return gameId;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public String getGameName() {
		return gameName;
	}

	public String getGameNumber() {
		return gameNumber;
	}

	public String getGameType() {
		return gameType;
	}

	public String getGameImagePath() {
		return gameImagePath;
	}

	public Double getGamePrice() {
		return gamePrice;
	}

	public String getGameUrl() {
		return gameUrl;
	}

	public String getGameParameters() {
		return gameParameters;
	}

	public String getGameDesc() {
		return gameDesc;
	}

	public Short getWindowHeight() {
		return windowHeight;
	}

	public Short getWindowWidth() {
		return windowWidth;
	}

	public String getMode() {
		return mode;
	}

	public String getGameTypeAssign() {
		return gameTypeAssign;
	}

	public String getStatus() {
		return status;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public void setGameNumber(String gameNumber) {
		this.gameNumber = gameNumber;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public void setGameImagePath(String gameImagePath) {
		this.gameImagePath = gameImagePath;
	}

	public void setGamePrice(Double gamePrice) {
		this.gamePrice = gamePrice;
	}

	public void setGameUrl(String gameUrl) {
		this.gameUrl = gameUrl;
	}

	public void setGameParameters(String gameParameters) {
		this.gameParameters = gameParameters;
	}

	public void setGameDesc(String gameDesc) {
		this.gameDesc = gameDesc;
	}

	public void setWindowHeight(Short windowHeight) {
		this.windowHeight = windowHeight;
	}

	public void setWindowWidth(Short windowWidth) {
		this.windowWidth = windowWidth;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void setGameTypeAssign(String gameTypeAssign) {
		this.gameTypeAssign = gameTypeAssign;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// Property accessors


}
