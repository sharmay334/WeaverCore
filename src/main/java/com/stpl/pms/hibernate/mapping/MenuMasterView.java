package com.stpl.pms.hibernate.mapping;

/**
 * MenuMasterView entity. @author MyEclipse Persistence Tools
 */

public class MenuMasterView implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer menuId;
	private Short domainId;
	private Short aliasId;
	private Integer displayCode;
	private Integer orderBy;
	private Integer parentId;
	private Short level;
	private String device;
	private Integer contentId;
	private String contentType;
	private String contentName;
	private String url;
	private String isPreLogin;
	private String isPostLogin;
	private String isPopup;
	private String status;
	private String highLightOpts;

	// Constructors

	/** default constructor */
	public MenuMasterView() {
	}

	/** minimal constructor */
	public MenuMasterView(Short domainId, Integer displayCode, String device,
			Integer contentId, String status) {
		this.domainId = domainId;
		this.displayCode = displayCode;
		this.device = device;
		this.contentId = contentId;
		this.status = status;
	}

	/** full constructor */
	public MenuMasterView(Short domainId, Integer displayCode, Integer orderBy,
			Integer parentId, Short level, String device, Integer contentId,
			String contentType, String contentName, String url,
			String isPreLogin, String isPostLogin, String status) {
		this.domainId = domainId;
		this.displayCode = displayCode;
		this.orderBy = orderBy;
		this.parentId = parentId;
		this.level = level;
		this.device = device;
		this.contentId = contentId;
		this.contentType = contentType;
		this.contentName = contentName;
		this.url = url;
		this.isPreLogin = isPreLogin;
		this.isPostLogin = isPostLogin;
		this.status = status;
	}

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Integer getDisplayCode() {
		return this.displayCode;
	}

	public void setDisplayCode(Integer displayCode) {
		this.displayCode = displayCode;
	}

	public Integer getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Short getLevel() {
		return this.level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	public String getDevice() {
		return this.device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public Integer getContentId() {
		return this.contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentName() {
		return this.contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsPopup() {
		return isPopup;
	}

	public void setIsPopup(String isPopup) {
		this.isPopup = isPopup;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getHighLightOpts() {
		return highLightOpts;
	}

	public void setHighLightOpts(String highLightOpts) {
		this.highLightOpts = highLightOpts;
	}
	

}