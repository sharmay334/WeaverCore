package com.stpl.pms.javabeans;

import java.io.Serializable;

import com.stpl.pms.hibernate.mapping.StDmDomainLocationMaster;

public class LocationMaster implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer locationId;
	private Short domainId;
	private String fullName;
	private String locationName;
	private String address;
	private String email;
	private Long mobileNo;
	private Long landlineNo;
	private String status;

	public LocationMaster(){
		
	}
	
	public LocationMaster (StDmDomainLocationMaster locMaster){
		this.locationId = locMaster.getLocationId();
		this.domainId = locMaster.getDomainId();
		this.fullName = locMaster.getFullName();
		this.locationName = locMaster.getLocationName();
		this.address = locMaster.getAddress();
		this.email = locMaster.getEmail();
		this.mobileNo = locMaster.getMobileNo();
		this.landlineNo = locMaster.getLandlineNo();
		this.status = locMaster.getStatus();
	}
	
	public LocationMaster(Integer locationId, Short domainId, String fullName,
			String locationName, String address, String email, Long mobileNo,
			Long landlineNo, String status) {
		super();
		this.locationId = locationId;
		this.domainId = domainId;
		this.fullName = fullName;
		this.locationName = locationName;
		this.address = address;
		this.email = email;
		this.mobileNo = mobileNo;
		this.landlineNo = landlineNo;
		this.status = status;
	}
	
	public Integer getLocationId() {
		return this.locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getLandlineNo() {
		return this.landlineNo;
	}

	public void setLandlineNo(Long landlineNo) {
		this.landlineNo = landlineNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
