package com.stpl.pms.javabeans;

public class CountryStateBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String[] countryCode;
	private String[] stateCode;
	
	
	public void setCountryCode(String[] countryCode) {
		this.countryCode = countryCode;
	}
	public String[] getCountryCode() {
		return countryCode;
	}
	public void setStateCode(String[] stateCode) {
		this.stateCode = stateCode;
	}
	public String[] getStateCode() {
		return stateCode;
	}

}
