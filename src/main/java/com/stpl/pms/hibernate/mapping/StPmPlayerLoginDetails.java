package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlayerLoginDetails entity. @author MyEclipse Persistence Tools
 */

public class StPmPlayerLoginDetails implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Short domainId;
	private Long playerId;
	private Timestamp loginDate;
	private Timestamp logoutDate;
	private Short loginAliasId;
	private Short logoutAliasId;
	private String city;
	private String countryCode;
	private String ipAddress;
	private String device;
	private String userAgent;
	private String status;
	private String appVersion;
	// Constructors

	/** default constructor */
	public StPmPlayerLoginDetails() {
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Timestamp getLoginDate() {
		return this.loginDate;
	}

	public void setLoginDate(Timestamp loginDate) {
		this.loginDate = loginDate;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDevice() {
		return this.device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public Timestamp getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Timestamp logoutDate) {
		this.logoutDate = logoutDate;
	}

	public String getUserAgent() {
		return this.userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Short getLogoutAliasId() {
		return logoutAliasId;
	}

	public void setLogoutAliasId(Short logoutAliasId) {
		this.logoutAliasId = logoutAliasId;
	}

	public Short getLoginAliasId() {
		return loginAliasId;
	}

	public void setLoginAliasId(Short loginAliasId) {
		this.loginAliasId = loginAliasId;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	
}