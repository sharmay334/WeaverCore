package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class LocDevMappingBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer mappingId;
	private Short aliasId;
	private DeviceMasterBean locDevices;
	private LocationMaster locMaster;// locMaster
	private String status;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;
	
	public LocDevMappingBean(){
		
	}
	
	public LocDevMappingBean(Integer mappingId, Short aliasId,
			DeviceMasterBean locDevices, LocationMaster locMaster,
			String status, Long createdBy, Timestamp creationTime,
			Long lastUpdatedBy, Timestamp lastUpdationTime) {
		super();
		this.mappingId = mappingId;
		this.aliasId = aliasId;
		this.locDevices = locDevices;
		this.locMaster = locMaster;
		this.status = status;
		this.createdBy = createdBy;
		this.creationTime = creationTime;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdationTime = lastUpdationTime;
	}
	
	public Integer getMappingId() {
		return mappingId;
	}
	public Short getAliasId() {
		return aliasId;
	}
	public DeviceMasterBean getLocDevices() {
		return locDevices;
	}
	public LocationMaster getLocMaster() {
		return locMaster;
	}
	public String getStatus() {
		return status;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public Timestamp getCreationTime() {
		return creationTime;
	}
	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public Timestamp getLastUpdationTime() {
		return lastUpdationTime;
	}
	public void setMappingId(Integer mappingId) {
		this.mappingId = mappingId;
	}
	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}
	public void setLocDevices(DeviceMasterBean locDevices) {
		this.locDevices = locDevices;
	}
	public void setLocMaster(LocationMaster locMaster) {
		this.locMaster = locMaster;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public void setLastUpdationTime(Timestamp lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}
}
