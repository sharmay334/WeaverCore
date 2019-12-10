package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StCmsCampaignSubMaster entity. @author MyEclipse Persistence Tools
 */

public class StCmsCampaignSubMaster implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Long subCampaignId;
	private Long campaignId;
	private String subCampaignName;
	private Timestamp fromDate;
	private Timestamp toDate;
	private Integer contentId;
	private String publicUrl;
	private String status;
	private String rummyUrl;

	// Constructors

	/** default constructor */
	public StCmsCampaignSubMaster() {
	}

	/** minimal constructor */
	public StCmsCampaignSubMaster(Long campaignId, String subCampaignName,
			Integer contentId, String status,String rummyUrl) {
		this.campaignId = campaignId;
		this.subCampaignName = subCampaignName;
		this.contentId = contentId;
		this.status = status;
		this.rummyUrl = rummyUrl;
	}

	/** full constructor */
	public StCmsCampaignSubMaster(Long campaignId, String subCampaignName,
			Timestamp fromDate, Timestamp toDate, Integer contentId,
			String status,String rummyUrl) {
		this.campaignId = campaignId;
		this.subCampaignName = subCampaignName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.contentId = contentId;
		this.status = status;
		this.rummyUrl = rummyUrl;
	}

	// Property accessors

	public Long getSubCampaignId() {
		return this.subCampaignId;
	}

	public void setSubCampaignId(Long subCampaignId) {
		this.subCampaignId = subCampaignId;
	}

	public Long getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}

	public String getSubCampaignName() {
		return this.subCampaignName;
	}

	public void setSubCampaignName(String subCampaignName) {
		this.subCampaignName = subCampaignName;
	}

	public Timestamp getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}

	public Timestamp getToDate() {
		return this.toDate;
	}

	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}

	public Integer getContentId() {
		return this.contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPublicUrl() {
		return publicUrl;
	}

	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}

	public String getRummyUrl() {
		return rummyUrl;
	}

	public void setRummyUrl(String rummyUrl) {
		this.rummyUrl = rummyUrl;
	}

}