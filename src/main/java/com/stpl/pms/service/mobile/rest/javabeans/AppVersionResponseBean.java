package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

public class AppVersionResponseBean extends CommonResponseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String version;
	private String downloadUrl;
	private String mandatory;
	private String message;
	private String versionCode;
	private String lastMandatoryVersionCode;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public String getMandatory() {
		return mandatory;
	}
	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	public String getLastMandatoryVersionCode() {
		return lastMandatoryVersionCode;
	}
	public void setLastMandatoryVersionCode(String lastMandatoryVersionCode) {
		this.lastMandatoryVersionCode = lastMandatoryVersionCode;
	} 
	
	
	
}
