package com.stpl.pms.hibernate.mapping;

/**
 * StPortalPriviledgeRep entity. @author MyEclipse Persistence Tools
 */

public class StPortalPriviledgeRep implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer actionId;
	private Integer privId;
	private String privDispCode;
	private String actionMapping;
	private String relatedTo;
	private String actionNamespace;
	private String checkPreLogin;
	private String checkPostLogin;
	private String isDefault;
	private String status;

	// Constructors

	/** default constructor */
	public StPortalPriviledgeRep() {
	}

	/** minimal constructor */
	public StPortalPriviledgeRep(Integer privId, String relatedTo,
			String checkPreLogin, String checkPostLogin, String isDefault, String status) {
		this.privId = privId;
		this.relatedTo = relatedTo;
		this.checkPreLogin = checkPreLogin;
		this.checkPostLogin = checkPostLogin;
		this.isDefault = isDefault;
		this.status = status;
	}

	/** full constructor */
	public StPortalPriviledgeRep(Integer privId, String privDispCode,
			String actionMapping, String relatedTo, String checkPreLogin, String checkPostLogin,
			String isDefault, String status) {
		this.privId = privId;
		this.privDispCode = privDispCode;
		this.actionMapping = actionMapping;
		this.relatedTo = relatedTo;
		this.checkPreLogin = checkPreLogin;
		this.checkPostLogin = checkPostLogin;
		this.isDefault = isDefault;
		this.status = status;
	}

	// Property accessors

	public String getCheckPreLogin() {
		return checkPreLogin;
	}

	public void setCheckPreLogin(String checkPreLogin) {
		this.checkPreLogin = checkPreLogin;
	}

	public String getCheckPostLogin() {
		return checkPostLogin;
	}

	public void setCheckPostLogin(String checkPostLogin) {
		this.checkPostLogin = checkPostLogin;
	}

	public Integer getActionId() {
		return this.actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	public Integer getPrivId() {
		return this.privId;
	}

	public void setPrivId(Integer privId) {
		this.privId = privId;
	}

	public String getPrivDispCode() {
		return this.privDispCode;
	}

	public void setPrivDispCode(String privDispCode) {
		this.privDispCode = privDispCode;
	}

	public String getActionMapping() {
		return this.actionMapping;
	}

	public void setActionMapping(String actionMapping) {
		this.actionMapping = actionMapping;
	}

	public String getRelatedTo() {
		return this.relatedTo;
	}

	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}

	public String getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActionNamespace() {
		return actionNamespace;
	}

	public void setActionNamespace(String actionNamespace) {
		this.actionNamespace = actionNamespace;
	}

}