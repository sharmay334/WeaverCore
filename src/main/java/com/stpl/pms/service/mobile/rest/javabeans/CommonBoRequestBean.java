package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

public class CommonBoRequestBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userId;
	private String boToken;
	private String domainName;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getBoToken() {
		return boToken;
	}
	public void setBoToken(String boToken) {
		this.boToken = boToken;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public CommonBoRequestBean()
	{
		
	}
	public CommonBoRequestBean(Long userId, String boToken, String domainName) {
		super();
		this.userId = userId;
		this.boToken = boToken;
		this.domainName = domainName;
	}
	
	
	
	

}
