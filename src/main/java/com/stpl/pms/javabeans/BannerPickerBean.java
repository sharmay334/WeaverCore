package com.stpl.pms.javabeans;



public class BannerPickerBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	//Fields	
	private String bannerDimension;	
	private String bannerType;
	private Integer campaignId;
	private String reletedTo;
	private String affiliateCode;
	
	public String getBannerDimension() {
		return bannerDimension;
	}
	public void setBannerDimension(String bannerDimension) {
		this.bannerDimension = bannerDimension;
	}
	public String getBannerType() {
		return bannerType;
	}
	public void setBannerType(String bannerType) {
		this.bannerType = bannerType;
	}
	public Integer getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}
	public String getReletedTo() {
		return reletedTo;
	}
	public void setReletedTo(String reletedTo) {
		this.reletedTo = reletedTo;
	}
	public String getAffiliateCode() {
		return affiliateCode;
	}
	public void setAffiliateCode(String affiliateCode) {
		this.affiliateCode = affiliateCode;
	}
	
	
}
