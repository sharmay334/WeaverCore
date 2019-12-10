package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPortalContentMaster entity. @author MyEclipse Persistence Tools
 */

public class StPortalContentMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer contentId;
	private Short domainId;
	private Short aliasId;
	private String contentName;
	private String contentType;
	private StGenLanguageMaster langMaster;
	private String isPreLogin;
	private String isPostLogin;
	private String contentPath;
	private String url;
	private Integer actionId;
	private String title;
	private String metaDescription;
	private String keyword;
	private String description;
	private String isPopup;
	private String status;
	private String isLink;
	private String device;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;
	private String isCommonCSS;
	private String isCustomCSS;
	private Integer specificCssId;
	private String isPhUrl;

	// Constructors


	/** default constructor */
	public StPortalContentMaster() {
		isCommonCSS = "N";
		isCustomCSS = "N";
		isPhUrl = "N";
	}

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

	/** minimal constructor */
	public StPortalContentMaster(String isPopup, String status) {
		this.isPopup = isPopup;
		this.status = status;
	}

	/** Minimal constructor */
	public StPortalContentMaster(Short domainId, String contentName,
			String contentType, StGenLanguageMaster langMaster,
			String isPreLogin, String isPostLogin, String contentPath,
			String url, Integer actionId, String title, String metaDescription,
			String keyword, String description, String isPopup, String status,
			String isLink, String device) {
		this.domainId = domainId;
		this.contentName = contentName;
		this.contentType = contentType;
		this.langMaster = langMaster;
		this.isPreLogin = isPreLogin;
		this.isPostLogin = isPostLogin;
		this.contentPath = contentPath;
		this.url = url;
		this.actionId = actionId;
		this.title = title;
		this.metaDescription = metaDescription;
		this.keyword = keyword;
		this.description = description;
		this.isPopup = isPopup;
		this.status = status;
		this.isLink = isLink;
		this.device = device;
	}

	/** full constructor */
	public StPortalContentMaster(Short domainId, Short aliasId, String contentName,
			String contentType, StGenLanguageMaster langMaster,
			String isPreLogin, String isPostLogin, String contentPath,
			String url, Integer actionId, String title, String metaDescription,
			String keyword, String description, String isPopup, String status,
			String isLink, String device) {
		this.domainId = domainId;
		this.contentName = contentName;
		this.contentType = contentType;
		this.langMaster = langMaster;
		this.isPreLogin = isPreLogin;
		this.isPostLogin = isPostLogin;
		this.contentPath = contentPath;
		this.url = url;
		this.actionId = actionId;
		this.title = title;
		this.metaDescription = metaDescription;
		this.keyword = keyword;
		this.description = description;
		this.isPopup = isPopup;
		this.status = status;
		this.isLink = isLink;
		this.device = device;
		this.aliasId = aliasId;
	}
	
	// Property accessors

	public Integer getContentId() {
		return this.contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getContentName() {
		return this.contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getIsPreLogin() {
		return this.isPreLogin;
	}

	public void setIsPreLogin(String isPreLogin) {
		this.isPreLogin = isPreLogin;
	}

	public String getIsPostLogin() {
		return this.isPostLogin;
	}

	public void setIsPostLogin(String isPostLogin) {
		this.isPostLogin = isPostLogin;
	}

	public String getContentPath() {
		return this.contentPath;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getActionId() {
		return this.actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMetaDescription() {
		return this.metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsPopup() {
		return this.isPopup;
	}

	public void setIsPopup(String isPopup) {
		this.isPopup = isPopup;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StGenLanguageMaster getLangMaster() {
		return langMaster;
	}

	public void setLangMaster(StGenLanguageMaster langMaster) {
		this.langMaster = langMaster;
	}

	public void setIsLink(String isLink) {
		this.isLink = isLink;
	}

	public String getIsLink() {
		return isLink;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdationTime() {
		return lastUpdationTime;
	}

	public void setLastUpdationTime(Timestamp lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}

	public Integer getSpecificCssId() {
		return specificCssId;
	}

	public void setSpecificCssId(Integer specificCssId) {
		this.specificCssId = specificCssId;
	}
	public String getIsPhUrl() {
		return isPhUrl;
	}

	public void setIsPhUrl(String isPhUrl) {
		this.isPhUrl = isPhUrl;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}
}