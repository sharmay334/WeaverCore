package com.stpl.pms.javabeans;

import java.io.Serializable;

public class CMSWidgetBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer widgetId;
	private short domainId;
	private short aliasId;
	private String widgetName;
	private String contentUrl;
	private String widgetType;
	private String widgetPath;
	private String customCss;
	private String commonCss;
	private Integer specificCss;
	private String device;
	
	public String getWidgetPath() {
		return widgetPath;
	}
	public void setWidgetPath(String widgetPath) {
		this.widgetPath = widgetPath;
	}
	public short getDomainId() {
		return domainId;
	}
	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}
	public String getWidgetName() {
		return widgetName;
	}
	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}
	public String getWidgetType() {
		return widgetType;
	}
	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}
	public Integer getWidgetId() {
		return widgetId;
	}
	public void setWidgetId(Integer widgetId) {
		this.widgetId = widgetId;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getCustomCss() {
		return customCss;
	}
	public void setCustomCss(String customCss) {
		this.customCss = customCss;
	}
	public String getCommonCss() {
		return commonCss;
	}
	public void setCommonCss(String commonCss) {
		this.commonCss = commonCss;
	}
	public Integer getSpecificCss() {
		return specificCss;
	}
	public void setSpecificCss(Integer specificCss) {
		this.specificCss = specificCss;
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
	

}
