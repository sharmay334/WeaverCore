package com.stpl.pms.hibernate.mapping;

/**
 * StCmsCampaignMaster entity. @author MyEclipse Persistence Tools
 */

public class StCmsCampaignMaster implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Long campaignId;
	private Short domainId;
	private Short aliasId;
	private String campaignName;
	private String campaignType;
	private String status;
	private String device;
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	private String param5;
	private String param6;
	private String param7;
	private String param8;
	private String param9;
	private String param10;

	// Constructors

	

	/** default constructor */
	public StCmsCampaignMaster() {
	}

	/** full constructor */
	public StCmsCampaignMaster(Long campaignId, Short domainId,
			String campaignName, String campaignType, String status,
			String param1, String param2, String param3, String param4,
			String param5, String param6, String param7, String param8,
			String param9, String param10, String device) {
		super();
		this.campaignId = campaignId;
		this.domainId = domainId;
		this.campaignName = campaignName;
		this.campaignType = campaignType;
		this.status = status;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
		this.param4 = param4;
		this.param5 = param5;
		this.param6 = param6;
		this.param7 = param7;
		this.param8 = param8;
		this.param9 = param9;
		this.param10 = param10;
		this.status = status;
		this.device = device;
	}

	// Property accessors

	public Long getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getCampaignName() {
		return this.campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getCampaignType() {
		return this.campaignType;
	}

	public void setCampaignType(String campaignType) {
		this.campaignType = campaignType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	

	public String getDevice() {
		return this.device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam1() {
		return param1;
	}
	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getParam4() {
		return param4;
	}

	public void setParam4(String param4) {
		this.param4 = param4;
	}

	public String getParam5() {
		return param5;
	}

	public void setParam5(String param5) {
		this.param5 = param5;
	}

	public String getParam6() {
		return param6;
	}

	public void setParam6(String param6) {
		this.param6 = param6;
	}

	public String getParam7() {
		return param7;
	}

	public void setParam7(String param7) {
		this.param7 = param7;
	}

	public String getParam8() {
		return param8;
	}

	public void setParam8(String param8) {
		this.param8 = param8;
	}

	public String getParam9() {
		return param9;
	}

	public void setParam9(String param9) {
		this.param9 = param9;
	}

	public String getParam10() {
		return param10;
	}

	public void setParam10(String param10) {
		this.param10 = param10;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}