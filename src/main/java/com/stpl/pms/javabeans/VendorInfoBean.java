package com.stpl.pms.javabeans;

import java.sql.Timestamp;


public class VendorInfoBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short vendorId;
	private String vendorCode;
	private String vendorName;
	private Timestamp registrationDate;
	private String userName;
	private String password;
	private String vendorRefNo;
	private String secretKeys;
	private String status;
	private Integer vendorKey;
	private String vendorLobbyType;
	private String vendorPassword;
	private String defaultGameGroup;
	private String vendorDomainName;
	private String ipWhiteList;
	
	// Property accessors

	public Short getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Short vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorCode() {
		return this.vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return this.vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Timestamp getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
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

	public String getVendorRefNo() {
		return this.vendorRefNo;
	}

	public void setVendorRefNo(String vendorRefNo) {
		this.vendorRefNo = vendorRefNo;
	}

	public String getSecretKeys() {
		return this.secretKeys;
	}

	public void setSecretKeys(String secretKeys) {
		this.secretKeys = secretKeys;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getVendorPassword() {
		return vendorPassword;
	}

	public void setVendorPassword(String vendorPassword) {
		this.vendorPassword = vendorPassword;
	}

	public Integer getVendorKey() {
		return vendorKey;
	}

	public void setVendorKey(Integer vendorKey) {
		this.vendorKey = vendorKey;
	}

	public String getDefaultGameGroup() {
		return defaultGameGroup;
	}

	public void setDefaultGameGroup(String defaultGameGroup) {
		this.defaultGameGroup = defaultGameGroup;
	}

	public String getVendorDomainName() {
		return vendorDomainName;
	}

	public void setVendorDomainName(String vendorDomainName) {
		this.vendorDomainName = vendorDomainName;
	}

	@Override
	public String toString() {
		return "VendorInfoBean [vendorId=" + vendorId + ", vendorCode=" + vendorCode + ", vendorName=" + vendorName
				+ ", registrationDate=" + registrationDate + ", userName=" + userName + ", password=" + password
				+ ", vendorRefNo=" + vendorRefNo + ", secretKeys=" + secretKeys + ", status=" + status + ", vendorKey="
				+ vendorKey + ", vendorLobbyType=" + vendorLobbyType + ", vendorPassword=" + vendorPassword
				+ ", defaultGameGroup=" + defaultGameGroup + ", vendorDomainName=" + vendorDomainName + ", ipWhiteList="
				+ ipWhiteList + "]";
	}

	public void setVendorLobbyType(String vendorLobbyType) {
		this.vendorLobbyType = vendorLobbyType;
	}

	public String getVendorLobbyType() {
		return vendorLobbyType;
	}

	public String getIpWhiteList() {
		return ipWhiteList;
	}

	public void setIpWhiteList(String ipWhiteList) {
		this.ipWhiteList = ipWhiteList;
	}
	
}
