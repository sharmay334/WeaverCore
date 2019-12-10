package com.stpl.pms.hibernate.mapping;

/**
 * StRmPrivilegeRepSge entity. @author MyEclipse Persistence Tools
 */

public class StRmPrivilegeRepSge implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer fnId;
	private String functionName;
	private Integer privId;
	private String privNameCode;
	private Short groupId;
	private String groupNameCode;
	private String privStatus;
	private String tier;
	private String relatedTo;
	private String dependentPriv;
	private String checkLogin;
	private String isDefault;
	private String isDefaultGroup;

	// Constructors

	/** default constructor */
	public StRmPrivilegeRepSge() {
	}

	/** minimal constructor */
	public StRmPrivilegeRepSge(String functionName, Integer privId,
			Short groupId, String privStatus, String tier, String relatedTo,
			String checkLogin, String isDefault, String isDefaultGroup) {
		this.functionName = functionName;
		this.privId = privId;
		this.groupId = groupId;
		this.privStatus = privStatus;
		this.tier = tier;
		this.relatedTo = relatedTo;
		this.checkLogin = checkLogin;
		this.isDefault = isDefault;
		this.isDefaultGroup = isDefaultGroup;
	}

	/** full constructor */
	public StRmPrivilegeRepSge(String functionName, Integer privId,
			String privNameCode, Short groupId, String groupNameCode,
			String privStatus, String tier, String relatedTo,
			String dependentPriv, String checkLogin, String isDefault,
			String isDefaultGroup) {
		this.functionName = functionName;
		this.privId = privId;
		this.privNameCode = privNameCode;
		this.groupId = groupId;
		this.groupNameCode = groupNameCode;
		this.privStatus = privStatus;
		this.tier = tier;
		this.relatedTo = relatedTo;
		this.dependentPriv = dependentPriv;
		this.checkLogin = checkLogin;
		this.isDefault = isDefault;
		this.isDefaultGroup = isDefaultGroup;
	}

	// Property accessors

	public Integer getFnId() {
		return this.fnId;
	}

	public void setFnId(Integer fnId) {
		this.fnId = fnId;
	}

	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public Integer getPrivId() {
		return this.privId;
	}

	public void setPrivId(Integer privId) {
		this.privId = privId;
	}

	public String getPrivNameCode() {
		return this.privNameCode;
	}

	public void setPrivNameCode(String privNameCode) {
		this.privNameCode = privNameCode;
	}

	public Short getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Short groupId) {
		this.groupId = groupId;
	}

	public String getGroupNameCode() {
		return this.groupNameCode;
	}

	public void setGroupNameCode(String groupNameCode) {
		this.groupNameCode = groupNameCode;
	}

	public String getPrivStatus() {
		return this.privStatus;
	}

	public void setPrivStatus(String privStatus) {
		this.privStatus = privStatus;
	}

	public String getTier() {
		return this.tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getRelatedTo() {
		return this.relatedTo;
	}

	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}

	public String getDependentPriv() {
		return this.dependentPriv;
	}

	public void setDependentPriv(String dependentPriv) {
		this.dependentPriv = dependentPriv;
	}

	public String getCheckLogin() {
		return this.checkLogin;
	}

	public void setCheckLogin(String checkLogin) {
		this.checkLogin = checkLogin;
	}

	public String getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getIsDefaultGroup() {
		return this.isDefaultGroup;
	}

	public void setIsDefaultGroup(String isDefaultGroup) {
		this.isDefaultGroup = isDefaultGroup;
	}

}