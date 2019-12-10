package com.stpl.pms.hibernate.mapping;

/**
 * StPortalCasinoLiveCasino1Id entity. @author MyEclipse Persistence Tools
 */

public class StPortalCasinoLiveCasino1 extends StPortalCasinoMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer gameId;
	private String url;
	private String status;

	// Constructors

	/** default constructor */
	public StPortalCasinoLiveCasino1() {
	}

	/** minimal constructor */
	public StPortalCasinoLiveCasino1(Integer gameId) {
		this.gameId = gameId;
	}

	/** full constructor */
	public StPortalCasinoLiveCasino1(StRmVendorMaster  stRmVendorMaster, String gameName,
			String gameNumber, String gameType, String gameImagePath,
			Double gamePrice, String gameDesc, Short windowHeight,
			Short windowWidth,String isFlash,String isHtml, String url, String status) {
		
		super(stRmVendorMaster,gameName,gameNumber,gameType,gameImagePath,
			gamePrice,gameDesc,windowHeight,windowWidth,isFlash,isHtml);
	  this.url = url;
		this.status = status;
	}

	// Property accessors

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
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
		if (!(other instanceof StPortalCasinoLiveCasino1))
			return false;
		StPortalCasinoLiveCasino1 castOther = (StPortalCasinoLiveCasino1) other;

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