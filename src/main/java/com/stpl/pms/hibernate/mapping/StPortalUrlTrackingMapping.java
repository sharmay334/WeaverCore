package com.stpl.pms.hibernate.mapping;

/**
 * StPortalUrlTrackingMapping entity. @author MyEclipse Persistence Tools
 */

public class StPortalUrlTrackingMapping {

	// Fields

	private Integer trackingId;
//	private StPortalUrlMaster stPortalUrlMaster;
	private Short domainId;
	private String pixelPath;
	private String gaPath;

	// Constructors

	/** default constructor */
	public StPortalUrlTrackingMapping() {
	}

	/** full constructor */
	public StPortalUrlTrackingMapping(Short domainId,
			String pixelPath, String gaPath) {
//		this.setStPortalUrlMaster(stPortalUrlMaster);
		this.domainId = domainId;
		this.pixelPath = pixelPath;
		this.gaPath = gaPath;
	}

	// Property accessors

	public Integer getTrackingId() {
		return this.trackingId;
	}

	public void setTrackingId(Integer trackingId) {
		this.trackingId = trackingId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getPixelPath() {
		return this.pixelPath;
	}

	public void setPixelPath(String pixelPath) {
		this.pixelPath = pixelPath;
	}

	public String getGaPath() {
		return this.gaPath;
	}

	public void setGaPath(String gaPath) {
		this.gaPath = gaPath;
	}

//	public void setStPortalUrlMaster(StPortalUrlMaster stPortalUrlMaster) {
//		this.stPortalUrlMaster = stPortalUrlMaster;
//	}
//
//	public StPortalUrlMaster getStPortalUrlMaster() {
//		return stPortalUrlMaster;
//	}

}