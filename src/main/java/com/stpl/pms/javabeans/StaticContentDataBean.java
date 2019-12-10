package com.stpl.pms.javabeans;

import java.util.Map;

public class StaticContentDataBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contentPath;
	private String contentType;
	private String isPreLogin;
	private String isPostLogin;
	private String regStatusForRefer;
//	private Map<String, String> phCodeContentMap;
	private Map<String, String> variableCodeContentMap;
	private String languageCode;
	private Long trackId;
	private String status;
	private Long subSourceId;
	private String domainName;
	private String aliasName;
	private CommonInfoBean infobean;
	
	public String getContentPath() {
		return contentPath;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

//	public Map<String, String> getPhCodeContentMap() {
//		return phCodeContentMap;
//	}
//
//	public void setPhCodeContentMap(Map<String, String> phCodeContentMap) {
//		this.phCodeContentMap = phCodeContentMap;
//	}

	public void setVariableCodeContentMap(
			Map<String, String> variableCodeContentMap) {
		this.variableCodeContentMap = variableCodeContentMap;
	}

	public Map<String, String> getVariableCodeContentMap() {
		return variableCodeContentMap;
	}

	public String getIsPreLogin() {
		return isPreLogin;
	}

	public void setIsPreLogin(String isPreLogin) {
		this.isPreLogin = isPreLogin;
	}

	public String getIsPostLogin() {
		return isPostLogin;
	}

	public void setIsPostLogin(String isPostLogin) {
		this.isPostLogin = isPostLogin;
	}

	public void setRegStatusForRefer(String regStatusForRefer) {
		this.regStatusForRefer = regStatusForRefer;
	}

	public String getRegStatusForRefer() {
		return regStatusForRefer;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}

	public Long getTrackId() {
		return trackId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSubSourceId() {
		return subSourceId;
	}

	public void setSubSourceId(Long subSourceId) {
		this.subSourceId = subSourceId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public CommonInfoBean getInfobean() {
		return infobean;
	}

	public void setInfobean(CommonInfoBean infobean) {
		this.infobean = infobean;
	}
	
}
