package com.stpl.pms.javabeans;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.stpl.pms.hibernate.mapping.StPortalGameLobbyMapping;
import com.stpl.pms.hibernate.mapping.StPortalGamesMaster;
import com.stpl.pms.utility.Utility;

public class VendorGameLobbybean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String gameName;
	private String gameNumber;
	private String gameImagePath;
	private double gamePrice;
	private String gameDesc;
	private short windowHeight;
	private short windowWidth;
	private int showOrder;
	private int themeId;
	private String themeName;
	private short vendorId;
	private String tryUrl;
	private String buyUrl;

	public VendorGameLobbybean() {
	}

	public VendorGameLobbybean(StPortalGameLobbyMapping gameDetail) {
		super();
		try {
			StPortalGamesMaster gameMaster = gameDetail
					.getStPortalGamesMaster();
			this.gameName = gameMaster.getGameName();
			this.gameNumber = gameMaster.getGameNumber();
			this.gameImagePath = gameMaster.getGameImagePath();
			this.gamePrice = gameMaster.getGamePrice();
			this.gameDesc = gameMaster.getGameDesc();
			this.windowHeight = gameMaster.getWindowHeight();
			this.windowWidth = gameMaster.getWindowWidth();
			this.showOrder = gameDetail.getShowOrder();
			this.themeId =gameDetail.getStPortalGameThemeMaster().getThemeId();
			this.themeName=gameDetail.getStPortalGameThemeMaster().getThemeName();
			this.vendorId = gameMaster.getVendorId();
			this.tryUrl = URLEncoder.encode(Utility
					.encodeString(this.gameNumber + "|TRY|" + this.themeName),
					"UTF-8");
			this.buyUrl = URLEncoder.encode(Utility
					.encodeString(this.gameNumber + "|BUY|" + this.themeName),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(String gameNumber) {
		this.gameNumber = gameNumber;
	}

	public String getGameImagePath() {
		return gameImagePath;
	}

	public void setGameImagePath(String gameImagePath) {
		this.gameImagePath = gameImagePath;
	}

	public double getGamePrice() {
		return gamePrice;
	}

	public void setGamePrice(double gamePrice) {
		this.gamePrice = gamePrice;
	}

	public String getGameDesc() {
		return gameDesc;
	}

	public void setGameDesc(String gameDesc) {
		this.gameDesc = gameDesc;
	}

	public short getWindowHeight() {
		return windowHeight;
	}

	public void setWindowHeight(short windowHeight) {
		this.windowHeight = windowHeight;
	}

	public short getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(short windowWidth) {
		this.windowWidth = windowWidth;
	}

	public int getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(int showOrder) {
		this.showOrder = showOrder;
	}


	public short getVendorId() {
		return vendorId;
	}

	public void setVendorId(short vendorId) {
		this.vendorId = vendorId;
	}

	public String getTryUrl() {
		return tryUrl;
	}

	public void setTryUrl(String tryUrl) {
		this.tryUrl = tryUrl;
	}

	public String getBuyUrl() {
		return buyUrl;
	}

	public void setBuyUrl(String buyUrl) {
		this.buyUrl = buyUrl;
	}

	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}

	public int getThemeId() {
		return themeId;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getThemeName() {
		return themeName;
	}

}
