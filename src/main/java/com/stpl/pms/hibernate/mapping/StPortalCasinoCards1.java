package com.stpl.pms.hibernate.mapping;

/**
 * StPortalCasinoCards1Id entity. @author MyEclipse Persistence Tools
 */

public class StPortalCasinoCards1 extends StPortalCasinoMaster implements java.io.Serializable {

	// Fields

	
	private static final long serialVersionUID = 1L;
	private String url;
	private String status;

	// Constructors

	/** default constructor */
	public StPortalCasinoCards1() {
	}


	/** full constructor */
	public StPortalCasinoCards1(StRmVendorMaster  stRmVendorMaster, String gameName,
			String gameNumber, String gameType, String gameImagePath,
			Double gamePrice, String gameDesc, Short windowHeight,
			Short windowWidth,String isFlash,String isHtml, String url, String status) {
		
		super(stRmVendorMaster,gameName,gameNumber,gameType,gameImagePath,
			gamePrice,gameDesc,windowHeight,windowWidth,isFlash,isHtml);
		this.url = url;
		this.status = status;
	}

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StPortalCasinoCards1))
			return false;
		StPortalCasinoCards1 castOther = (StPortalCasinoCards1) other;

		return ((this.getGameId() == castOther.getGameId()) || (this
				.getGameId() != null
				&& castOther.getGameId() != null && this.getGameId().equals(
				castOther.getGameId())))
				&& ((this.getUrl() == castOther.getUrl()) || (this.getUrl() != null
						&& castOther.getUrl() != null && this.getUrl().equals(
						castOther.getUrl())))
				&& ((this.getStatus() == castOther.getStatus()) || (this
						.getStatus() != null
						&& castOther.getStatus() != null && this.getStatus()
						.equals(castOther.getStatus())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGameId() == null ? 0 : this.getGameId().hashCode());
		result = 37 * result
				+ (getUrl() == null ? 0 : this.getUrl().hashCode());
		result = 37 * result
				+ (getStatus() == null ? 0 : this.getStatus().hashCode());
		return result;
	}

}