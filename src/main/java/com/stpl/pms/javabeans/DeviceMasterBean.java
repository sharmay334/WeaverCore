package com.stpl.pms.javabeans;

import java.io.Serializable;

import com.stpl.pms.hibernate.mapping.StDmDomainDeviceMaster;

public class DeviceMasterBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer deviceId;
	private String deviceName;
	private String deviceType;
	private String deviceMacAddress;
	private String deviceOs;
	private String status;
	
	public DeviceMasterBean(){
		
	}
	
	public DeviceMasterBean(StDmDomainDeviceMaster devMaster) {
		this.deviceId = devMaster.getDeviceId();
		this.deviceName = devMaster.getDeviceName();
		this.deviceType = devMaster.getDeviceType();
		this.deviceMacAddress = devMaster.getDeviceMacAddress();
		this.deviceOs=devMaster.getDeviceOs();
		this.status = devMaster.getStatus();
	}
	
	public DeviceMasterBean(Integer deviceId, String deviceName, String deviceType,
			String deviceMacAddress, String deviceOs, String status) {
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		this.deviceMacAddress = deviceMacAddress;
		this.deviceOs=deviceOs;
		this.status = status;
	}
	
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getDeviceMacAddress() {
		return deviceMacAddress;
	}
	public void setDeviceMacAddress(String deviceMacAddress) {
		this.deviceMacAddress = deviceMacAddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeviceOs() {
		return deviceOs;
	}

	public void setDeviceOs(String deviceOs) {
		this.deviceOs = deviceOs;
	}

}
