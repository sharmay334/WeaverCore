package com.stpl.pms.hibernate.mapping;

/**
 * StDmAliasDeeplinkRep entity. @author MyEclipse Persistence Tools
 */

public class StDmAliasDeeplinkRep implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short aliasId;
	private String deepLink;
	private String appType;
	private String dispCode;
	private String status;

	// Constructors

	/** default constructor */
	public StDmAliasDeeplinkRep() {
	}

	/** full constructor */
	public StDmAliasDeeplinkRep(Short aliasId, String deepLink, String appType,
			String dispCode, String status) {
		this.aliasId = aliasId;
		this.deepLink = deepLink;
		this.appType = appType;
		this.dispCode = dispCode;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getAliasId() {
		return this.aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getDeepLink() {
		return this.deepLink;
	}

	public void setDeepLink(String deepLink) {
		this.deepLink = deepLink;
	}

	public String getAppType() {
		return this.appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getDispCode() {
		return this.dispCode;
	}

	public void setDispCode(String dispCode) {
		this.dispCode = dispCode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}