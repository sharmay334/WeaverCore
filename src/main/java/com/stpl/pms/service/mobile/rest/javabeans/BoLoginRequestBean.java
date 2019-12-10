package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

public class BoLoginRequestBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String domainName;
	private String loginToken;
	private String requestIp;
	private String deviceId;
	
	public BoLoginRequestBean() {
	}


	public BoLoginRequestBean(String userName, String password,
			String domainName, String loginToken, String requestIp, String deviceId) {
		super();
		this.userName = userName;
		this.password = password;
		this.domainName = domainName;
		this.loginToken = loginToken;
		this.requestIp = requestIp;
		this.deviceId = deviceId;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}
	public String getRequestIp() {
		return requestIp;
	}



	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}


	public String getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	
}
