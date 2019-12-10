package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

public class StRmBoUserMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer userId;
	private Integer parentUserId;
	private StRmBoRoleMaster stRmBoRoleMaster;
	private Short domainId;
	private Timestamp registrationDate;
	private Timestamp lastLoginDate;
	private String userName;
	private String password;
	private Short autoPassword;
	private String status;
	private String secQues;
	private String secAns;
	private String isRoleHead;
	private String lastLoginIp;
	private String userType;
	private Short invalidLoginTry;
	private String deviceId;
	private String userAccessType;

	private StRmBoUserInfo userInfo;
	// private StRmBoUserInfo stRmBoUserInfo;

	/** default constructor */
	public StRmBoUserMaster() {
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public StRmBoUserMaster(int userId2) {
		this.userId = userId2;
	}

	public StRmBoRoleMaster getStRmBoRoleMaster() {
		return stRmBoRoleMaster;
	}

	public void setStRmBoRoleMaster(StRmBoRoleMaster stRmBoRoleMaster) {
		this.stRmBoRoleMaster = stRmBoRoleMaster;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getParentUserId() {
		return this.parentUserId;
	}

	public void setParentUserId(Integer parentUserId) {
		this.parentUserId = parentUserId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Timestamp getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Timestamp getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Short getAutoPassword() {
		return this.autoPassword;
	}

	public void setAutoPassword(Short autoPassword) {
		this.autoPassword = autoPassword;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSecQues() {
		return this.secQues;
	}

	public void setSecQues(String secQues) {
		this.secQues = secQues;
	}

	public String getSecAns() {
		return this.secAns;
	}

	public void setSecAns(String secAns) {
		this.secAns = secAns;
	}

	public String getIsRoleHead() {
		return isRoleHead;
	}

	public void setIsRoleHead(String isRoleHead) {
		this.isRoleHead = isRoleHead;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public Short getInvalidLoginTry() {
		return invalidLoginTry;
	}

	public void setInvalidLoginTry(Short invalidLoginTry) {
		this.invalidLoginTry = invalidLoginTry;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public StRmBoUserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(StRmBoUserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getUserAccessType() {
		return userAccessType;
	}

	public void setUserAccessType(String userAccessType) {
		this.userAccessType = userAccessType;
	}

	
	// public void setStRmBoUserInfo(StRmBoUserInfo stRmBoUserInfo) {
	// this.stRmBoUserInfo = stRmBoUserInfo;
	// }
	//
	// public StRmBoUserInfo getStRmBoUserInfo() {
	// return stRmBoUserInfo;
	// }

	
}