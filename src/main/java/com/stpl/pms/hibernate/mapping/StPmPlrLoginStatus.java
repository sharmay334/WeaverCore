package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlrLoginStatus entity. @author MyEclipse Persistence Tools
 */

public class StPmPlrLoginStatus implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Short domainId;
	private Short lastAliasId;
	private Long playerId;
	private String sessionId;
	private String ipAddress;
	private String device;
	private String status;
	private String deviceType;
	private String appType;
	private String imeiNo;
	private String deviceId;
	private String curAppVer;
	private String propAppVer;
	private String propAppMandatory;
	private String lastActivity;
	private Timestamp lastActivityDate;
	// Constructors

	/** default constructor */
	public StPmPlrLoginStatus() {
	}
	
	public StPmPlrLoginStatus(Long id, Short domainId, Long playerId,
			String sessionId, String ipAddress, String device, String status,
			String deviceType) {
		super();
		this.id = id;
		this.domainId = domainId;
		this.playerId = playerId;
		this.sessionId = sessionId;
		this.ipAddress = ipAddress;
		this.device = device;
		this.status = status;
		this.deviceType = deviceType;
	}
	// Property accessors

	public String getDeviceType() {
		return deviceType;
	}
 
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDevice() {
		return this.device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getLastAliasId() {
		return lastAliasId;
	}

	public void setLastAliasId(Short lastAliasId) {
		this.lastAliasId = lastAliasId;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getCurAppVer() {
		return curAppVer;
	}

	public void setCurAppVer(String curAppVer) {
		this.curAppVer = curAppVer;
	}

	public String getPropAppVer() {
		return propAppVer;
	}

	public void setPropAppVer(String propAppVer) {
		this.propAppVer = propAppVer;
	}

	public String getPropAppMandatory() {
		return propAppMandatory;
	}

	public void setPropAppMandatory(String propAppMandatory) {
		this.propAppMandatory = propAppMandatory;
	}

	public String getLastActivity() {
		return lastActivity;
	}

	public void setLastActivity(String lastActivity) {
		this.lastActivity = lastActivity;
	}

	public Timestamp getLastActivityDate() {
		return lastActivityDate;
	}

	public void setLastActivityDate(Timestamp lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}
}