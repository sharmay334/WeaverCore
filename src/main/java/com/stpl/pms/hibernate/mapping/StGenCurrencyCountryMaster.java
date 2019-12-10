package com.stpl.pms.hibernate.mapping;

/**
 * StGenCurrencyCountryMaster entity. @author MyEclipse Persistence Tools
 */

public class StGenCurrencyCountryMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer curCouId;
	private Integer currencyId;
	private String countryCode;

	// Constructors

	/** default constructor */
	public StGenCurrencyCountryMaster() {
	}

	/** full constructor */
	public StGenCurrencyCountryMaster(Integer currencyId, String countryCode) {
		this.currencyId = currencyId;
		this.countryCode = countryCode;
	}

	// Property accessors

	public Integer getCurCouId() {
		return this.curCouId;
	}

	public void setCurCouId(Integer curCouId) {
		this.curCouId = curCouId;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}