package com.stpl.pms.hibernate.mapping;

/**
 * StGenCurrencyMaster entity. @author MyEclipse Persistence Tools
 */

public class StGenCurrencyMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer currencyId;
	private String currencyCode;
	private String currencyDescription;
	private String countryCode;

	// Constructors

	/** default constructor */
	public StGenCurrencyMaster() {
	}

	/** minimal constructor */
	public StGenCurrencyMaster(String currencyCode, String currencyDescription) {
		this.currencyCode = currencyCode;
		this.currencyDescription = currencyDescription;
	}

	/** full constructor */
	public StGenCurrencyMaster(String currencyCode, String currencyDescription,
			String countryCode) {
		this.currencyCode = currencyCode;
		this.currencyDescription = currencyDescription;
		this.countryCode = countryCode;
	}

	// Property accessors

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyDescription() {
		return this.currencyDescription;
	}

	public void setCurrencyDescription(String currencyDescription) {
		this.currencyDescription = currencyDescription;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}