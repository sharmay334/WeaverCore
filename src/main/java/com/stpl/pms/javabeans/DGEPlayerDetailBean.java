package com.stpl.pms.javabeans;

import java.io.Serializable;

public class DGEPlayerDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long playerId;
	private String userName;
	private String firstName;
	private String lastName;
	private String domainName;
	private String vipBand;
	private String language;
	private String addressLine1;
	private String city;
	private String currencyCode;
	private String emailId;
	private String gender;
	private Long mobileNo;
	private String postalCode;
	private String state;

	public DGEPlayerDetailBean() {
	}

	public DGEPlayerDetailBean(PlayerInfoBean playerInfoBean,
			String domainName, String vipBand) {
		this.playerId = playerInfoBean.getPlayerId();
		this.userName = playerInfoBean.getUserName();
		this.firstName = playerInfoBean.getFirstName();
		this.lastName = playerInfoBean.getLastName();
		this.domainName = domainName;
		this.vipBand = vipBand;
		this.language = playerInfoBean.getLanguage();
		this.addressLine1 = playerInfoBean.getAddressLine1();
		this.city = playerInfoBean.getCity();
		this.currencyCode = playerInfoBean.getCurrencyCode();
		this.emailId = playerInfoBean.getEmailId();
		this.gender = playerInfoBean.getGender();
		this.mobileNo = playerInfoBean.getMobileNo();
		this.postalCode = playerInfoBean.getPostalCode();
		this.state = playerInfoBean.getStateCode();
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getVipBand() {
		return vipBand;
	}

	public void setVipBand(String vipBand) {
		this.vipBand = vipBand;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "DGEPlayerDetailBean [addressLine1=" + addressLine1 + ", city="
				+ city + ", currencyCode=" + currencyCode + ", domainName="
				+ domainName + ", emailId=" + emailId + ", firstName="
				+ firstName + ", gender=" + gender + ", language=" + language
				+ ", lastName=" + lastName + ", mobileNo=" + mobileNo
				+ ", playerId=" + playerId + ", postalCode=" + postalCode
				+ ", state=" + state + ", userName=" + userName + ", vipBand="
				+ vipBand + "]";
	}

}
