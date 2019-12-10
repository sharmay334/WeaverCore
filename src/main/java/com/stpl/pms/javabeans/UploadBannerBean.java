package com.stpl.pms.javabeans;

public class UploadBannerBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short domainId;
	private Integer relatedCampaign;
	private String bannerContext;
	private String bannerName;
	private String bannerType;
	private String bannerDescrip;
	private String path;
	
	public Short getDomainId() {
		return domainId;
	}
	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}
	public Integer getRelatedCampaign() {
		return relatedCampaign;
	}
	public void setRelatedCampaign(Integer relatedCampaign) {
		this.relatedCampaign = relatedCampaign;
	}
	public String getBannerContext() {
		return bannerContext;
	}
	public void setBannerContext(String bannerContext) {
		this.bannerContext = bannerContext;
	}
	public String getBannerName() {
		return bannerName;
	}
	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}
	public String getBannerType() {
		return bannerType;
	}
	public void setBannerType(String bannerType) {
		this.bannerType = bannerType;
	}
	public String getBannerDescrip() {
		return bannerDescrip;
	}
	public void setBannerDescrip(String bannerDescrip) {
		this.bannerDescrip = bannerDescrip;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
