package com.stpl.pms.javabeans;

public class PortalUrlDetailBean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer urlId;
	private String url;
	private String urlDisplayName;
	public Integer getUrlId() {
		return urlId;
	}
	public void setUrlId(Integer urlId) {
		this.urlId = urlId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrlDisplayName() {
		return urlDisplayName;
	}
	public void setUrlDisplayName(String urlDisplayName) {
		this.urlDisplayName = urlDisplayName;
	}

}
