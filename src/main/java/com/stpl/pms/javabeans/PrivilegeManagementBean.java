package com.stpl.pms.javabeans;

import java.util.List;

public class PrivilegeManagementBean {
	private Integer fnId;
	private String fnName;
	private Integer privId;
	private String privNameCode;
	private Short groupId;
	private String groupNameCode;
	private String privStatus;
	private String tier;
	private String relatedTo;
	private String checkLogin;
	private String isDefault;
	private String isDefaultGroup;
	private Integer actionId;
	private String actionName;
	private String actionDesc;
	private String actionURL;
	private String actionStatus;
	private List<PrivilegeManagementBean> subPriv;
	public List<PrivilegeManagementBean> getSubPriv() {
		return subPriv;
	}
	public void setSubPriv(List<PrivilegeManagementBean> subPriv) {
		this.subPriv = subPriv;
	}
	public Integer getFnId() {
		return fnId;
	}
	public void setFnId(Integer fnId) {
		this.fnId = fnId;
	}
	public String getFnName() {
		return fnName;
	}
	public void setFnName(String fnName) {
		this.fnName = fnName;
	}
	public Integer getPrivId() {
		return privId;
	}
	public void setPrivId(Integer privId) {
		this.privId = privId;
	}
	public String getPrivNameCode() {
		return privNameCode;
	}
	public void setPrivNameCode(String privNameCode) {
		this.privNameCode = privNameCode;
	}
	public Short getGroupId() {
		return groupId;
	}
	public void setGroupId(Short groupId) {
		this.groupId = groupId;
	}
	public String getGroupNameCode() {
		return groupNameCode;
	}
	public void setGroupNameCode(String groupNameCode) {
		this.groupNameCode = groupNameCode;
	}
	public String getPrivStatus() {
		return privStatus;
	}
	public void setPrivStatus(String privStatus) {
		this.privStatus = privStatus;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public String getRelatedTo() {
		return relatedTo;
	}
	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}
	public String getCheckLogin() {
		return checkLogin;
	}
	public void setCheckLogin(String checkLogin) {
		this.checkLogin = checkLogin;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	public String getIsDefaultGroup() {
		return isDefaultGroup;
	}
	public void setIsDefaultGroup(String isDefaultGroup) {
		this.isDefaultGroup = isDefaultGroup;
	}
	public Integer getActionId() {
		return actionId;
	}
	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getActionDesc() {
		return actionDesc;
	}
	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}
	
	public String getActionURL() {
		return actionURL;
	}
	public void setActionURL(String actionURL) {
		this.actionURL = actionURL;
	}
	public String getActionStatus() {
		return actionStatus;
	}
	public void setActionStatus(String actionStatus) {
		this.actionStatus = actionStatus;
	}
}
