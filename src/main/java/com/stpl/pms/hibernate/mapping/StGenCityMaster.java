package com.stpl.pms.hibernate.mapping;

/**
 * StGenCityMaster entity. @author MyEclipse Persistence Tools
 */

public class StGenCityMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer cityId;
	private String cityCode;
	private String cityName;
	private String stateCode;
	private String countryCode;
	private String status;
	private Integer countryId;
	private Integer stateId;
	// Constructors

	public StGenCityMaster()
	{
		
	}

	// Property accessors

	public Integer getCityId() {
		return this.cityId;
	}

	public StGenCityMaster(Integer cityId, String cityCode, String cityName,
			String stateCode, String countryCode, String status,
			Integer countryId, Integer stateId) {
		super();
		this.cityId = cityId;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.stateCode = stateCode;
		this.countryCode = countryCode;
		this.status = status;
		this.countryId = countryId;
		this.stateId = stateId;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}