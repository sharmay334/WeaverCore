package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BonusDevicEligibilityBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<String> deviceTypeId;
	public List<String> getDeviceTypeId() {
		return deviceTypeId;
	}
	public void setDeviceTypeId(List<String> deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	
	public void setDeviceTypeId(String deviceTypeId) {
		if(this.deviceTypeId ==null)
			this.deviceTypeId = new ArrayList<String>();
		this.deviceTypeId.add(deviceTypeId);
	}
	
	@Override
	public String toString() {
		return "BonusDevicEligibilityBean [deviceTypeId=" + deviceTypeId
				+ ", getDeviceTypeId()=" + getDeviceTypeId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
	

}
