package com.stpl.pms.hibernate.mapping;

/**
 * StBannerDetailMaster entity. @author MyEclipse Persistence Tools
 */

public class StBannerDetailMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer bannerId;
	private Integer campaignId;
	private String bannerName;
	private String bannerType;
	private String bannerPath;
	private String relatedTo;
	private String bannerDescription;
	private String status;

	// Constructors

	/** default constructor */
	public StBannerDetailMaster() {
	}

	/** full constructor */
	public StBannerDetailMaster(Integer campaignId, String bannerName,
			String bannerType, String bannerPath, String relatedTo,
			String bannerDescription, String status) {
		this.campaignId = campaignId;
		this.bannerName = bannerName;
		this.bannerType = bannerType;
		this.bannerPath = bannerPath;
		this.relatedTo = relatedTo;
		this.bannerDescription = bannerDescription;
		this.status = status;
	}

	// Property accessors

	public Integer getBannerId() {
		return this.bannerId;
	}

	public void setBannerId(Integer bannerId) {
		this.bannerId = bannerId;
	}

	public Integer getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public String getBannerName() {
		return this.bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public String getBannerType() {
		return this.bannerType;
	}

	public void setBannerType(String bannerType) {
		this.bannerType = bannerType;
	}

	public String getBannerPath() {
		return this.bannerPath;
	}

	public void setBannerPath(String bannerPath) {
		this.bannerPath = bannerPath;
	}

	public String getRelatedTo() {
		return this.relatedTo;
	}

	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}

	public String getBannerDescription() {
		return this.bannerDescription;
	}

	public void setBannerDescription(String bannerDescription) {
		this.bannerDescription = bannerDescription;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}