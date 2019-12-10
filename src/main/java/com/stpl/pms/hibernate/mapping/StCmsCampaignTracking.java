package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StCmsCampaignTracking entity. @author MyEclipse Persistence Tools
 */

/**
 * @author stpl
 *
 */
public class StCmsCampaignTracking implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long campaignId;
	private Long subCampaignId;
	private String visitorIp;
	private String countryCode;
	private String visitorCity;
	private Timestamp visitingTime;
	private Long playerId;
	private String campaignLogin;
	private String value1;
	private String value2;
	private String value3;
	private String value4;
	private String value5;
	private String value6;
	private String value7;
	private String value8;
	private String value9;
	private String value10;

	// Constructors

	

	public void setValue10(String value10) {
		this.value10 = value10;
	}

	/** default constructor */
	public StCmsCampaignTracking() {
	}

	/** minimal constructor */
	public StCmsCampaignTracking(Long campaignId, Long subCampaignId,
			String visitorIp, Timestamp visitingTime) {
		this.campaignId = campaignId;
		this.subCampaignId = subCampaignId;
		this.visitorIp = visitorIp;
		this.visitingTime = visitingTime;
	}

	/** full constructor */
	public StCmsCampaignTracking(Long id, Long campaignId, Long subCampaignId,
			String visitorIp, String countryCode, String visitorCity,
			Timestamp visitingTime, String value1, String value2,
			String value3, String value4, String value5, String value6,
			String value7, String value8, String value9, String value10) {
		super();
		this.id = id;
		this.campaignId = campaignId;
		this.subCampaignId = subCampaignId;
		this.visitorIp = visitorIp;
		this.countryCode = countryCode;
		this.visitorCity = visitorCity;
		this.visitingTime = visitingTime;
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
		this.value4 = value4;
		this.value5 = value5;
		this.value6 = value6;
		this.value7 = value7;
		this.value8 = value8;
		this.value9 = value9;
		this.value10 = value10;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}

	public Long getSubCampaignId() {
		return this.subCampaignId;
	}

	public void setSubCampaignId(Long subCampaignId) {
		this.subCampaignId = subCampaignId;
	}

	public String getVisitorIp() {
		return this.visitorIp;
	}

	public void setVisitorIp(String visitorIp) {
		this.visitorIp = visitorIp;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getVisitorCity() {
		return this.visitorCity;
	}

	public void setVisitorCity(String visitorCity) {
		this.visitorCity = visitorCity;
	}

	public Timestamp getVisitingTime() {
		return this.visitingTime;
	}

	public void setVisitingTime(Timestamp visitingTime) {
		this.visitingTime = visitingTime;
	}
	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}

	public String getValue5() {
		return value5;
	}

	public void setValue5(String value5) {
		this.value5 = value5;
	}

	public String getValue6() {
		return value6;
	}

	public void setValue6(String value6) {
		this.value6 = value6;
	}

	public String getValue7() {
		return value7;
	}

	public void setValue7(String value7) {
		this.value7 = value7;
	}

	public String getValue8() {
		return value8;
	}

	public void setValue8(String value8) {
		this.value8 = value8;
	}

	public String getValue9() {
		return value9;
	}

	public void setValue9(String value9) {
		this.value9 = value9;
	}

	public String getValue10() {
		return value10;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getCampaignLogin() {
		return campaignLogin;
	}

	public void setCampaignLogin(String campaignLogin) {
		this.campaignLogin = campaignLogin;
	}

	@Override
	public String toString() {
		return "StCmsCampaignTracking [id=" + id + ", campaignId=" + campaignId + ", subCampaignId=" + subCampaignId
				+ ", visitorIp=" + visitorIp + ", countryCode=" + countryCode + ", visitorCity=" + visitorCity
				+ ", visitingTime=" + visitingTime + ", playerId=" + playerId + ", campaignLogin=" + campaignLogin
				+ ", value1=" + value1 + ", value2=" + value2 + ", value3=" + value3 + ", value4=" + value4
				+ ", value5=" + value5 + ", value6=" + value6 + ", value7=" + value7 + ", value8=" + value8
				+ ", value9=" + value9 + ", value10=" + value10 + "]";
	}
	
	

}