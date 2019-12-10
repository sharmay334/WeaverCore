package com.stpl.pms.javabeans;

import java.sql.Timestamp;

public class CampaignDetailBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long subCampaignId;
	private String subCampaignName;
	private Timestamp fromDate;
	private Timestamp toDate;
	private String content;
	private String deepRummy;
	
	
	public Long getSubCampaignId() {
		return subCampaignId;
	}
	public void setSubCampaignId(Long subCampaignId) {
		this.subCampaignId = subCampaignId;
	}
	public String getSubCampaignName() {
		return subCampaignName;
	}
	public void setSubCampaignName(String subCampaignName) {
		this.subCampaignName = subCampaignName;
	}
	public Timestamp getFromDate() {
		return fromDate;
	}
	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}
	public Timestamp getToDate() {
		return toDate;
	}
	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDeepRummy() {
		return deepRummy;
	}
	public void setDeepRummy(String deepRummy) {
		this.deepRummy = deepRummy;
	}

}
