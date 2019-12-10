package com.stpl.pms.hibernate.mapping;

import java.sql.Blob;

import org.hibernate.Hibernate;

import com.stpl.pms.javabeans.GameLobbyResponseBean;
/**
 * StPortalGamesMaster entity. @author MyEclipse Persistence Tools
 */

public class StPortalGamesMaster implements java.io.Serializable{

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer gameId;
	private String gameName;
	private String gameNumber;
	private String gameType;
	private String gameGroupType;
	private String gameImagePath;
	private Double gamePrice;
	private String gameDesc;
	private Short windowHeight;
	private Short windowWidth;
	private String isFlash;
	private String isHtml5;
	private String status;
	private Short  vendorId;
	private Blob extraParam;

	// Constructors

	/** default constructor */
	public StPortalGamesMaster() {
	}
	public StPortalGamesMaster(Integer gameId) {
		this.gameId= gameId;
	}
	/** minimal constructor */
	public StPortalGamesMaster(String gameName, String gameNumber,
			String gameImagePath) {
		this.gameName = gameName;
		this.gameNumber = gameNumber;
		this.gameImagePath = gameImagePath;
	}

	public StPortalGamesMaster(short vendorId, GameLobbyResponseBean list,
			String defaultType, String status) {
		this.vendorId = vendorId;
		this.gameName = list.getGameName();
		this.gameNumber=list.getGameNumber();
		this.gameGroupType=defaultType;
		this.gameType = list.getGameCategory();
		this.gameImagePath = list.getGameImageLocations();
		this.gamePrice = list.getGamePrice();
		this.gameDesc = list.getGameDescription();
		this.windowHeight = list.getWindowHeight();
		this.windowWidth = list.getWindowWidth();
		this.isFlash=list.getIsFlash();
		this.isHtml5=list.getIsHtml5();
		this.status=status;
	}
	public String getGameName() {
		return this.gameName;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGameGroupType() {
		return gameGroupType;
	}
	public void setGameGroupType(String gameGroupType) {
		this.gameGroupType = gameGroupType;
	}
	public Blob getExtraParam() {
		return extraParam;
	}
	public void setExtraParam(Blob extraParam) {
		this.extraParam = extraParam;
	}
	public void setExtraParam(String extraParam) {
		this.extraParam = Hibernate.createBlob(extraParam.getBytes());
	}
	public void setVendorId(Short vendorId) {
		this.vendorId = vendorId;
	}
	public Short getVendorId() {
		return vendorId;
	}

}