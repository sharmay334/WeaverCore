package com.stpl.pms.hibernate.mapping;

/**
 * StRmServiceVendorProperties entity. @author MyEclipse Persistence Tools
 */

public class StRmServiceVendorProperties implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String tier;
	private String propertyKey;
	private String propertyValue;
	private String urlParameter;
	private StRmVendorMaster stRmVendorMaster;

	// Constructors

	/** default constructor */
	public StRmServiceVendorProperties() {
	}

	/** minimal constructor */

public StRmServiceVendorProperties(Integer id, Integer serviceId,
			 String tier, String propertyKey,
			String propertyValue, String urlParameter,
			StRmVendorMaster stRmVendorMaster) {
		super();
		this.id = id;
		this.tier = tier;
		this.propertyKey = propertyKey;
		this.propertyValue = propertyValue;
		this.urlParameter = urlParameter;
		this.stRmVendorMaster = stRmVendorMaster;
	}

// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getTier() {
		return this.tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getPropertyKey() {
		return this.propertyKey;
	}

	public void setPropertyKey(String propertyKey) {
		this.propertyKey = propertyKey;
	}

	public String getPropertyValue() {
		return this.propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getUrlParameter() {
		return this.urlParameter;
	}

	public void setUrlParameter(String urlParameter) {
		this.urlParameter = urlParameter;
	}

	public StRmVendorMaster getStRmVendorMaster() {
		return stRmVendorMaster;
	}

	public void setStRmVendorMaster(StRmVendorMaster stRmVendorMaster) {
		this.stRmVendorMaster = stRmVendorMaster;
	}

}