package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.List;

public class PortalPageLinkBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Short domainId;
	private Short aliasId;
	private String contentName;
	private String pageType;
	private String path;
	private String description;
	private Integer language;
	private String pageHTML;
	private String contentType;
	private Integer contentId;
	private Integer contentHeight;
	private Integer contentWidth;
	private String url;
	private List<PlaceHolderBean> placeHolderBeans;
	private String[] variableIds;
	private String isPreLogin;
	private String isPostLogin;
	private String isLink;
	private TemplateMasterBean tmpBean;
	private String device;
	private String isCommonCSS;
	private String isCustomCSS;
	private Integer specificCssId;
	private String status;

	public String getIsCommonCSS() {
		return isCommonCSS;
	}

	public void setIsCommonCSS(String isCommonCSS) {
		this.isCommonCSS = isCommonCSS;
	}

	public String getIsCustomCSS() {
		return isCustomCSS;
	}

	public void setIsCustomCSS(String isCustomCSS) {
		this.isCustomCSS = isCustomCSS;
	}

	public Integer getContentHeight() {
		return contentHeight;
	}

	public void setContentHeight(Integer contentHeight) {
		this.contentHeight = contentHeight;
	}

	public Integer getContentWidth() {
		return contentWidth;
	}

	public void setContentWidth(Integer contentWidth) {
		this.contentWidth = contentWidth;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPageHTML() {
		return pageHTML;
	}

	public void setPageHTML(String pageHTML) {
		this.pageHTML = pageHTML;
	}

	public Integer getLanguage() {
		return language;
	}

	public void setLanguage(Integer language) {
		this.language = language;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public Integer getContentId() {
		return contentId;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPlaceHolderBeans(List<PlaceHolderBean> placeHolderBeans) {
		this.placeHolderBeans = placeHolderBeans;
	}

	public List<PlaceHolderBean> getPlaceHolderBeans() {
		return placeHolderBeans;
	}

	public void setVariableIds(String[] variableIds) {
		this.variableIds = variableIds;
	}

	public String[] getVariableIds() {
		return variableIds;
	}

	public void setIsPreLogin(String isPreLogin) {
		this.isPreLogin = isPreLogin;
	}

	public String getIsPreLogin() {
		return isPreLogin;
	}

	public void setIsPostLogin(String isPostLogin) {
		this.isPostLogin = isPostLogin;
	}

	public String getIsPostLogin() {
		return isPostLogin;
	}

	public void setIsLink(String isLink) {
		this.isLink = isLink;
	}

	public String getIsLink() {
		return isLink;
	}

	public void setTmpBean(TemplateMasterBean tmpBean) {
		this.tmpBean = tmpBean;
	}

	public TemplateMasterBean getTmpBean() {
		return tmpBean;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public Integer getSpecificCssId() {
		return specificCssId;
	}

	public void setSpecificCssId(Integer specificCssId) {
		this.specificCssId = specificCssId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	
}
