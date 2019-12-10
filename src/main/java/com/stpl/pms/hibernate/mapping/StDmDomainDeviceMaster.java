package com.stpl.pms.hibernate.mapping;

/**
 * StDmDomainDeviceMaster entity. @author MyEclipse Persistence Tools
 */

public class StDmDomainDeviceMaster implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer deviceId;
	private String deviceName;
	private String deviceType;
	private String deviceMacAddress;
	private String deviceOs;
	private String status;
	private Short aliasId;

	// Constructors

	/** default constructor */
	public StDmDomainDeviceMaster() {
	}

	/** full constructor */
	public StDmDomainDeviceMaster(String deviceName, String deviceType,
			String deviceMacAddress, String deviceOs, String status,Short aliasId) {
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		this.deviceMacAddress = deviceMacAddress;
		this.deviceOs = deviceOs;
		this.status = status;
		this.aliasId=aliasId;
	}

	// Property accessors

	public Integer getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceType() {
		return this.deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceMacAddress() {
		return this.deviceMacAddress;
	}

	public void setDeviceMacAddress(String deviceMacAddress) {
		this.deviceMacAddress = deviceMacAddress;
	}

	public String getDeviceOs() {
		return this.deviceOs;
	}

	public void setDeviceOs(String deviceOs) {
		this.deviceOs = deviceOs;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}