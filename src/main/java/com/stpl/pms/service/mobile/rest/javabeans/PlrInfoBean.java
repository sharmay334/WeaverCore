package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlrInfoBean extends CommonRequestBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String gender;
	private String dob;
	private String emailId;
	private Long mobileNo;
	private Long phoneNo;
	private String houseNo;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String countryCode;
	private String stateCode;
	private String pinCode;
	private String requestIp;
	private String registrationType;
	private String emailVerified;
	private String phoneVerified;
	
	public PlrInfoBean() {
	}

	public PlrInfoBean(String firstName, String lastName, String userName,
			String password, String gender, String dob, String emailId,
			Long mobileNo, Long phoneNo, String houseNo, String addressLine1,
			String addressLine2, String city, String countryCode,
			String stateCode, String pinCode, String requestIp, String emailVerified, String phoneVerified) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.phoneNo = phoneNo;
		this.houseNo = houseNo;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.countryCode = countryCode;
		this.stateCode = stateCode;
		this.pinCode = pinCode;
		this.requestIp = requestIp;
		this.setEmailVerified(emailVerified);
		this.setPhoneVerified(phoneVerified);
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	@Override
	public String toString() {
		return "PlrInfoBean [addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", countryCode="
				+ countryCode + ", dob=" + dob + ", emailId=" + emailId
				+ ", firstName=" + firstName + ", gender=" + gender
				+ ", houseNo=" + houseNo + ", lastName=" + lastName
				+ ", mobileNo=" + mobileNo + ", password=" + password
				+ ", phoneNo=" + phoneNo + ", pinCode=" + pinCode
				+ ", requestIp=" + requestIp + ", stateCode=" + stateCode
				+ ", userName=" + userName + "]";
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public String getRegistrationType() {
		return registrationType;
	}

	public void setEmailVerified(String emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getEmailVerified() {
		return emailVerified;
	}

	public void setPhoneVerified(String phoneVerified) {
		this.phoneVerified = phoneVerified;
	}

	public String getPhoneVerified() {
		return phoneVerified;
	}

}
