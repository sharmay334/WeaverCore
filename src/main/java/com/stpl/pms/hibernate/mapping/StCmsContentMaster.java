package com.stpl.pms.hibernate.mapping;

/**
 * StCmsContentMaster entity. @author MyEclipse Persistence Tools
 */

public class StCmsContentMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer cmsContentId;
	private Short domainId;
	private Short aliasId;
	private String contentName;
	private String contentType;
	private String contentPath;
	private Integer contentHeight;
	private Integer contentWidth;
	private String description;
	private String status;
	private StGenLanguageMaster langMaster;
	private String device;
	private String deviceOS;

	// Constructors

	/** default constructor */
	public StCmsContentMaster() {
	}

	/** minimal constructor */
	public StCmsContentMaster(Short domainId, String contentName,
			String contentType, String contentPath, String description, String status) {
		this.domainId = domainId;
		this.contentName = contentName;
		this.contentType = contentType;
		this.contentPath = contentPath;
		this.description = description;
		this.status = status;
	}

	/** full constructor */
	public StCmsContentMaster(Short domainId, String contentName,
			String contentType, String contentPath, Integer contentHeight,
			Integer contentWidth, String description, String status, String device) {
		this.domainId = domainId;
		this.contentName = contentName;
		this.contentType = contentType;
		this.contentPath = contentPath;
		this.contentHeight = contentHeight;
		this.contentWidth = contentWidth;
		this.description = description;
		this.status = status;
		this.device = device;
	}

	// Property accessors

	
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

	public String getContentPath() {
		return this.contentPath;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

	public Integer getContentHeight() {
		return this.contentHeight;
	}

	public void setContentHeight(Integer contentHeight) {
		this.contentHeight = contentHeight;
	}

	public Integer getContentWidth() {
		return this.contentWidth;
	}

	public void setContentWidth(Integer contentWidth) {
		this.contentWidth = contentWidth;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCmsContentId(Integer cmsContentId) {
		this.cmsContentId = cmsContentId;
	}

	public Integer getCmsContentId() {
		return cmsContentId;
	}

	@Override
	public String toString() {
		return "StCmsContentMaster [cmsContentId=" + cmsContentId
				+ ", contentHeight=" + contentHeight + ", contentName="
				+ contentName + ", contentPath=" + contentPath
				+ ", contentType=" + contentType + ", contentWidth="
				+ contentWidth + ", description=" + description + ", domainId="
				+ domainId + ", status=" + status + "]";
	}

	public void setLangMaster(StGenLanguageMaster langMaster) {
		this.langMaster = langMaster;
	}

	public StGenLanguageMaster getLangMaster() {
		return langMaster;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getDeviceOS() {
		return deviceOS;
	}

	public void setDeviceOS(String deviceOS) {
		this.deviceOS = deviceOS;
	}
}