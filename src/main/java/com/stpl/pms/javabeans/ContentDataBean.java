package com.stpl.pms.javabeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentDataBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String urlStr;
	private String languageCode;
	private String device;
	private short domainId;
	private short aliasId;
	private String referSourceType;
	private Long referSourceId;
	private Long subSourceId;
	private String requesrIp;
	private List<String> paramValues = new ArrayList<String>();
	private String sessionId;
	private String serverName;
	private Map<String, String> reqParams;
	private String[] reqProp;
	
	public String getUrlStr() {
		return urlStr;
	}
	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	
	public Long getReferSourceId() {
		return referSourceId;
	}
	public void setReferSourceId(Long referSourceId) {
		this.referSourceId = referSourceId;
	}
	public Long getSubSourceId() {
		return subSourceId;
	}
	public void setSubSourceId(Long subSourceId) {
		this.subSourceId = subSourceId;
	}
	public String getRequesrIp() {
		return requesrIp;
	}
	public void setRequesrIp(String requesrIp) {
		this.requesrIp = requesrIp;
	}
	public void setReferSourceType(String referSourceType) {
		this.referSourceType = referSourceType;
	}
	public String getReferSourceType() {
		return referSourceType;
	}
	public short getDomainId() {
		return domainId;
	}
	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}
	public void setParamValues(List<String> paramValues) {
		this.paramValues = paramValues;
	}
	public List<String> getParamValues() {
		return paramValues;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public short getAliasId() {
		return aliasId;
	}
	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Map<String, String> getReqParams() {
		return reqParams;
	}
	public void setReqParams(Map<String, String> reqParams) {
		this.reqParams = reqParams;
	}
	public String[] getReqProp() {
		return reqProp;
	}
	public void setReqProp(String[] reqProp) {
		this.reqProp = reqProp;
	}
	
}
