package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StRmVendorMaster entity. @author MyEclipse Persistence Tools
 */

public class StRmVendorMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Short vendorId;
	private String vendorCode;
	private String vendorName;
	private String vendorDomainName;
	private Timestamp registrationDate;
	private String userName;
	private String password;
	private String vendorRefNo;
	private String vendorLobbyType;
	private String secretKeys;
	private String status;
	private Integer vendorKey;
	private String vendorPassword;
	private String defaultGameGroup;
	private String serverIp;
	private String serverPort;
	private StRmDomainAliasVendorMapping stRmDomainAliasVendorMapping;
	private String vendorUserName;
	private String ipWhiteList;
	private String gameEngineBoUrl;
	// Constructors

	/** default constructor */
	public StRmVendorMaster() {
	}
	public StRmVendorMaster(Short vendorId) {
        this.vendorId=vendorId;
	}


	/** minimal constructor */
	public StRmVendorMaster(String vendorCode, String status) {
		this.vendorCode = vendorCode;
		this.status = status;
	}

	
	public StRmVendorMaster(Short vendorId, String vendorCode,
			String vendorName,String vendorDomainName, Timestamp registrationDate, String userName,
			String password, String vendorRefNo, String secretKeys,
			String status, Integer vendorKey, String vendorPassword,String defaultGameGroup, String serverIp,
			String serverPort, String vendorUserName,String gameEngineBoUrl) {
		super();
		this.vendorId = vendorId;
		this.vendorCode = vendorCode;
		this.vendorName = vendorName;
		this.vendorDomainName=vendorDomainName;
		this.registrationDate = registrationDate;
		this.userName = userName;
		this.password = password;
		this.vendorRefNo = vendorRefNo;
		this.secretKeys = secretKeys;
		this.serverIp = serverIp;
		this.serverPort = serverPort;
		this.status = status;
		this.vendorKey = vendorKey;
		this.vendorPassword = vendorPassword;
	    this.defaultGameGroup=defaultGameGroup;
	    this.vendorUserName = vendorUserName;
	    this.gameEngineBoUrl=gameEngineBoUrl;
	}

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

	public String getVendorUserName() {
		return this.vendorUserName;
	}

	public void setVendorUserName(String vendorUserName) {
		this.vendorUserName = vendorUserName;
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
	public void setVendorLobbyType(String vendorLobbyType) {
		this.vendorLobbyType = vendorLobbyType;
	}
	public String getVendorLobbyType() {
		return vendorLobbyType;
	}
	public String getServerIp() {
		return this.serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getServerPort() {
		return this.serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	public StRmDomainAliasVendorMapping getStRmDomainAliasVendorMapping() {
		return stRmDomainAliasVendorMapping;
	}
	public void setStRmDomainAliasVendorMapping(
			StRmDomainAliasVendorMapping stRmDomainAliasVendorMapping) {
		this.stRmDomainAliasVendorMapping = stRmDomainAliasVendorMapping;
	}
	public String getIpWhiteList() {
		return ipWhiteList;
	}
	public void setIpWhiteList(String ipWhiteList) {
		this.ipWhiteList = ipWhiteList;
	}

	public String getGameEngineBoUrl() {
		return gameEngineBoUrl;
	}

	public void setGameEngineBoUrl(String gameEngineBoUrl) {
		this.gameEngineBoUrl = gameEngineBoUrl;
	}
}