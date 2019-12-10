package com.stpl.pms.hibernate.mapping;

/**
 * StPortalGameVendor entity. @author MyEclipse Persistence Tools
 */

public class StPortalGameVendor implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer vendorId;

	// Constructors

	/** default constructor */
	public StPortalGameVendor() {
	}

	/** full constructor */
	public StPortalGameVendor(Integer vendorId) {
		this.vendorId = vendorId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

}