package com.stpl.pms.javabeans;

import java.util.List;

public class CampaignBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Long campaignId;
	private Short domainId;
	private Short aliasId;
	private String campaignName;
	private String campaignType;
	private String status;
	private List<CampaignDetailBean> campDetailList;
	private List<String> campParams;
	private String device;
	
	public Long getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}
	public Short getDomainId() {
		return domainId;
	}
	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public String getCampaignType() {
		return campaignType;
	}
	public void setCampaignType(String campaignType) {
		this.campaignType = campaignType;
	}
	public void setCampDetailList(List<CampaignDetailBean> campDetailList) {
		this.campDetailList = campDetailList;
	}
	public List<CampaignDetailBean> getCampDetailList() {
		return campDetailList;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setCampParams(List<String> campParams) {
		this.campParams = campParams;
	}
	public List<String> getCampParams() {
		return campParams;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public Short getAliasId() {
		return aliasId;
	}
	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}
	

}
