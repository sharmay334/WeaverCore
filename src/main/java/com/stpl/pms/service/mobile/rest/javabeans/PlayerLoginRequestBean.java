package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

public class PlayerLoginRequestBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private String loginToken;
	private String domainName;
	private String requestIp;
	private String device_id;
	private String app_type;
	private String imei ;

	public PlayerLoginRequestBean() {
	}

	public PlayerLoginRequestBean(String userName, String password,
			String loginToken, String domainName, String requestIp,String device_id, String app_type,String imei) {
		this.userName = userName;
		this.password = password;
		this.loginToken = loginToken;
		this.domainName = domainName;
		this.requestIp = requestIp;
		this.device_id=device_id;
		this.app_type=app_type;
		this.imei=imei;
		
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

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getApp_type() {
		return app_type;
	}

	public void setApp_type(String app_type) {
		this.app_type = app_type;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	


	
	
	

}
