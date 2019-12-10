package com.stpl.pms.javabeans;

public class SportsTxnResponseParam implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String token;

	private Long externalUserId;
	private String loginName;
	private String currency;
	private String countryName;
	private String cityName;
	private String languageCode;

	private Double balance;
	private Double promoBal;
	private Long extTransactionID;
	private Boolean alreadyProcessed;

	private Integer errorCode;
	private String error;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setPromoBal(Double promoBal) {
		this.promoBal = promoBal;
	}

	public Double getPromoBal() {
		return promoBal;
	}

	public void setAlreadyProcessed(Boolean alreadyProcessed) {
		this.alreadyProcessed = alreadyProcessed;
	}

	public Boolean getAlreadyProcessed() {
		return alreadyProcessed;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setExtTransactionID(Long extTransactionID) {
		this.extTransactionID = extTransactionID;
	}

	public Long getExtTransactionID() {
		return extTransactionID;
	}

	public void setExternalUserId(Long externalUserId) {
		this.externalUserId = externalUserId;
	}

	public Long getExternalUserId() {
		return externalUserId;
	}

}
