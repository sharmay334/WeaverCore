package com.stpl.pms.hibernate.mapping;

/**
 * StDmDomainInfo entity. @author MyEclipse Persistence Tools
 */

public class StDmDomainInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short domainId;
	private String ownerName;
	private String address;
	private String countryCode;
	private String stateCode;
	private String contactPersonName;
	private Long ownerContactNo;

	// Constructors

	/** default constructor */
	public StDmDomainInfo() {
	}

	/** full constructor */
	public StDmDomainInfo(Integer id, Short domainId, String ownerName,
			String address, String countryCode, String stateCode,
			String contactPersonName, String emailId, Long ownerContactNo) {
		this.id = id;
		this.domainId = domainId;
		this.ownerName = ownerName;
		this.address = address;
		this.countryCode = countryCode;
		this.stateCode = stateCode;
		this.contactPersonName = contactPersonName;
		this.ownerContactNo = ownerContactNo;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getContactPersonName() {
		return this.contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public void setOwnerContactNo(Long ownerContactNo) {
		this.ownerContactNo = ownerContactNo;
	}

	public Long getOwnerContactNo() {
		return ownerContactNo;
	}

}