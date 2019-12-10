package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameEngineBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private String serverIp;
	private Object serverIp;
	private String serverPort;
	private String serverUrl;
	private String userName;
	private String password;
	private String secretKey;
	
	
//	public GameEngineBean(List<String> serverIp, String serverPort, String serverUrl) {
//		this.serverIp = serverIp;
//		this.serverPort = serverPort;
//		this.serverUrl = serverUrl;
//	}
//	public GameEngineBean(String serverIp, String serverPort, String serverUrl) {
//		this.serverIp = serverIp;
//		this.serverPort = serverPort;
//		this.serverUrl = serverUrl;
//	}
//	
	
	public GameEngineBean() {
	}

	public String getServerPort() {
		return serverPort;
	}
	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}


	public Object getServerIp() {
		return  serverIp;
	}
	public void setServerIp(List<String> serverIp) {
		this.serverIp = serverIp;
	}
	
	public void setServerIp(String serverIp){
		this.serverIp = serverIp;
	}

}
