package com.stpl.pms.hibernate.mapping;

/**
 * StRmDomainAliasVendorMapping entity. @author MyEclipse Persistence Tools
 */

public class StRmDomainAliasVendorMapping implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short domainId;
	private Short aliasId;
	private Short vendorId;
	private String status;

	// Constructors

	/** default constructor */
	public StRmDomainAliasVendorMapping() {
	}

	/** full constructor */
	public StRmDomainAliasVendorMapping(Short domainId, Short aliasId,
			Short vendorId, String status) {
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.vendorId = vendorId;
		this.status = status;
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

	public Short getAliasId() {
		return this.aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public Short getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Short vendorId) {
		this.vendorId = vendorId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}