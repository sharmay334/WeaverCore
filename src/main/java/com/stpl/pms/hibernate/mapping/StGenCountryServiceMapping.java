package com.stpl.pms.hibernate.mapping;

/**
 * StGenCountryServiceMapping entity. @author MyEclipse Persistence Tools
 */

public class StGenCountryServiceMapping implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private String countryCode;
	private Integer defaultServiceId;
	private String activeServiceId;
	private String isActive;

	// Constructors

	/** default constructor */
	public StGenCountryServiceMapping() {
	}

	/** full constructor */
	public StGenCountryServiceMapping(String countryCode,
			Integer defaultServiceId, String activeServiceId, String isActive) {
		this.countryCode = countryCode;
		this.defaultServiceId = defaultServiceId;
		this.activeServiceId = activeServiceId;
		this.isActive = isActive;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Integer getDefaultServiceId() {
		return this.defaultServiceId;
	}

	public void setDefaultServiceId(Integer defaultServiceId) {
		this.defaultServiceId = defaultServiceId;
	}

	public String getActiveServiceId() {
		return this.activeServiceId;
	}

	public void setActiveServiceId(String activeServiceId) {
		this.activeServiceId = activeServiceId;
	}

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}