package com.stpl.pms.hibernate.mapping;

/**
 * StCmsDomainSpecificCss entity. @author MyEclipse Persistence Tools
 */

public class StCmsDomainSpecificCss implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer cssId;
	private Short domainId;
	private Short aliasId;
	private String cssName;
	private String cssPath;

	// Constructors

	/** default constructor */
	public StCmsDomainSpecificCss() {
	}

	/** minimal constructor */
	public StCmsDomainSpecificCss(Short domainId, String cssName, String cssPath) {
		this.domainId = domainId;
		this.cssName = cssName;
		this.cssPath = cssPath;
	}

	public StCmsDomainSpecificCss(Short domainId, Short aliasId, String cssName, String cssPath) {
		this.domainId = domainId;
		this.cssName = cssName;
		this.aliasId = aliasId;
		this.cssPath = cssPath;
	}
	// Property accessors

	public Integer getCssId() {
		return this.cssId;
	}

	public void setCssId(Integer cssId) {
		this.cssId = cssId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getCssName() {
		return this.cssName;
	}

	public void setCssName(String cssName) {
		this.cssName = cssName;
	}

	public String getCssPath() {
		return this.cssPath;
	}

	public void setCssPath(String cssPath) {
		this.cssPath = cssPath;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}