package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PlayerLoginRequestBean implements Serializable {

	private static final long serialVersionUID = 1l;
	
	
	private String username;
	private String password;
	private String loginToken;
	private String sessionId;
	private Short domainId;
	private Short aliasId;
	private String device;
	private String requestIp;
	private String deviceType;
	private String userAgent;
	private String currAppVer;
	private String deviceId;
	private String imeiNo;
	private Long referSourceId;
	private String referSourceType;
	private Long campTrackId;
	private Long subSourceId;
	private boolean isUSSD;

	public PlayerLoginRequestBean(){
		
	}

	public PlayerLoginRequestBean(String username, String password, String loginToken,
			String sessionId, Short domainId, Short aliasId, String device,
			String requestIp, String deviceType, String userAgent,
			String currAppVer, String deviceId, String imeiNo) {
		this.username = username;
		this.password = password;
		this.loginToken = loginToken;
		this.sessionId = sessionId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.device = device;
		this.requestIp = requestIp;
		this.deviceType = deviceType;
		this.userAgent = userAgent;
		this.currAppVer = currAppVer;
		this.deviceId = deviceId;
		this.imeiNo = imeiNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Short getDomainId() {
		return domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getCurrAppVer() {
		return currAppVer;
	}

	public void setCurrAppVer(String currAppVer) {
		this.currAppVer = currAppVer;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}
	
	public Long getReferSourceId() {
		return referSourceId;
	}
	
	public void setReferSourceId(Long referSourceId) {
		this.referSourceId = referSourceId;
	}
	
	public String getReferSourceType() {
		return referSourceType;
	}
	
	public void setReferSourceType(String referSourceType) {
		this.referSourceType = referSourceType;
	}
	
	public Long getCampTrackId() {
		return campTrackId;
	}
	
	public void setCampTrackId(Long campTrackId) {
		this.campTrackId = campTrackId;
	}
	
	public Long getSubSourceId() {
		return subSourceId;
	}
	
	public void setSubSourceId(Long subSourceId) {
		this.subSourceId = subSourceId;
	}

	public boolean isUSSD() {
		return isUSSD;
	}

	public void setUSSD(boolean isUSSD) {
		this.isUSSD = isUSSD;
	}
	
	
}
