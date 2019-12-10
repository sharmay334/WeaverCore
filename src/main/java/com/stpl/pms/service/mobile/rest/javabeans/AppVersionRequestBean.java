package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

public class AppVersionRequestBean extends CommonRequestBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String os;
	private String appType;
	
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	
	
}
