package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StDmDomainLocationDeviceMapping entity. @author MyEclipse Persistence Tools
 */

public class StDmDomainLocationDeviceMapping implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Short aliasId;
	private StDmDomainLocationMaster locMaster;
	private StDmDomainDeviceMaster locDevices;
	private String status;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;

	// Constructors

	/** default constructor */
	public StDmDomainLocationDeviceMapping() {
	}

	/** minimal constructor */
	public StDmDomainLocationDeviceMapping(Short aliasId, StDmDomainLocationMaster locMaster,
			StDmDomainDeviceMaster locDevices, String status) {
		this.setAliasId(aliasId);
		this.locMaster = locMaster;
		this.locDevices = locDevices;
		this.status = status;
	}

	/** full constructor */
	public StDmDomainLocationDeviceMapping(Short aliasId, StDmDomainLocationMaster locMaster,
			StDmDomainDeviceMaster locDevices, String status, Long createdBy,
			Timestamp creationTime, Long lastUpdatedBy,
			Timestamp lastUpdationTime) {
		this.setAliasId(aliasId);
		this.locMaster = locMaster;
		this.locDevices = locDevices;
		this.status = status;
		this.createdBy = createdBy;
		this.creationTime = creationTime;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdationTime = lastUpdationTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Long getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdationTime() {
		return this.lastUpdationTime;
	}

	public void setLastUpdationTime(Timestamp lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}

	public StDmDomainLocationMaster getLocMaster() {
		return locMaster;
	}

	public void setLocMaster(StDmDomainLocationMaster locMaster) {
		this.locMaster = locMaster;
	}

	public StDmDomainDeviceMaster getLocDevices() {
		return locDevices;
	}

	public void setLocDevices(StDmDomainDeviceMaster locDevices) {
		this.locDevices = locDevices;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}