package com.stpl.pms.javabeans;

import java.util.List;

public class FixedPageDetailBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Short domainId;
	private Short aliasId;
	private String pageType;
    private String device;
    private String templateType;
    private Integer contentId;
    private List<PlaceHolderBean> placeHolderBeans;
    private String[] variableIds;
    private String content;
    
    public Short getDomainId() {
		return domainId;
	}
	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getTemplateType() {
		return templateType;
	}
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
	public List<PlaceHolderBean> getPlaceHolderBeans() {
		return placeHolderBeans;
	}
	public void setPlaceHolderBeans(List<PlaceHolderBean> placeHolderBeans) {
		this.placeHolderBeans = placeHolderBeans;
	}
	public String[] getVariableIds() {
		return variableIds;
	}
	public void setVariableIds(String[] variableIds) {
		this.variableIds = variableIds;
	}
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public Integer getContentId() {
		return contentId;
	}
	public Short getAliasId() {
		return aliasId;
	}
	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
