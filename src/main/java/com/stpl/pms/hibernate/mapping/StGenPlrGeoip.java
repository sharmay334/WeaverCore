package com.stpl.pms.hibernate.mapping;

/**
 * StGenPlrGeoip entity. @author MyEclipse Persistence Tools
 */

public class StGenPlrGeoip implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private String region;
	private String country;
	private String countryCode;
	private String city;

	// Constructors

	/** default constructor */
	public StGenPlrGeoip() {
	}

	/** full constructor */
	public StGenPlrGeoip(Long playerId, String region, String country,
			String countryCode, String city) {
		this.playerId = playerId;
		this.region = region;
		this.country = country;
		this.countryCode = countryCode;
		this.city = city;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}