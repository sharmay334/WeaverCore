package com.stpl.pms.javabeans;

import java.io.Serializable;

public class UserInfoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String isMasterRole;
	private String isRoleHeadUser;
	private int parentUserId;
	private String parentUserName;
	private int roleId;
	private String roleName;
	private String status;
	private int userId;
	private String userName;
	private String userType;
	private Short domainId;

	public String getIsMasterRole() {
		return isMasterRole;
	}

	public void setIsMasterRole(String isMasterRole) {
		this.isMasterRole = isMasterRole;
	}

	public String getIsRoleHeadUser() {
		return isRoleHeadUser;
	}

	public void setIsRoleHeadUser(String isRoleHeadUser) {
		this.isRoleHeadUser = isRoleHeadUser;
	}

	public int getParentUserId() {
		return parentUserId;
	}

	public void setParentUserId(int parentUserId) {
		this.parentUserId = parentUserId;
	}

	public String getParentUserName() {
		return parentUserName;
	}

	public void setParentUserName(String parentUserName) {
		this.parentUserName = parentUserName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Short getDomainId() {
		return domainId;
	}

}
