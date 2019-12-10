package com.stpl.pms.hibernate.mapping;

/**
 * StPortalCasinoSlot1Id entity. @author MyEclipse Persistence Tools
 */

public class StPortalCasinoSlot1 extends StPortalCasinoMaster implements
		java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private String url;
	private String status;

	// Constructors

	/** default constructor */
	public StPortalCasinoSlot1() {
	}

	/** minimal constructor */

	/** full constructor */
	public StPortalCasinoSlot1(StRmVendorMaster  stRmVendorMaster, String gameName,
			String gameNumber, String gameType, String gameImagePath,
			Double gamePrice, String gameDesc, Short windowHeight,
			Short windowWidth,String isFlash,String isHtml, String url, String status) {
		
		super(stRmVendorMaster,gameName,gameNumber,gameType,gameImagePath,
			gamePrice,gameDesc,windowHeight,windowWidth,isFlash,isHtml);;
		this.url = url;
		this.status = status;
	}

	// Property accessors

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}