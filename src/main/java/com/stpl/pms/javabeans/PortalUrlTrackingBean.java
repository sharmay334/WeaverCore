package com.stpl.pms.javabeans;

public class PortalUrlTrackingBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short domainId;
	private String scriptFor;
	private Integer urlId;
	private String jsPath;
	public Short getDomainId() {
		return domainId;
	}
	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}
	public String getScriptFor() {
		return scriptFor;
	}
	public void setScriptFor(String scriptFor) {
		this.scriptFor = scriptFor;
	}
	public Integer geturlId() {
		return urlId;
	}
	public void seturlId(Integer urlId) {
		this.urlId = urlId;
	}
	public String getJsPath() {
		return jsPath;
	}
	public void setJsPath(String jsPath) {
		this.jsPath = jsPath;
	}
}
