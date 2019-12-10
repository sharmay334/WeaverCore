package com.stpl.pms.javabeans;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class PlrRedeemAccChequeInfoBean implements java.io.Serializable {
	/**
	 * 
	 */
	private Integer paymentTypeId;
	private String paymentType;
	private Integer providerId;

	private static final long serialVersionUID = 1L;
	private Long redeemAccId;
	private String firstName;
	private String lastName;
	private String houseNum;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String stateCode;
	private String countryCode;
	private String postalCode;
	private String status;
	private boolean redeemAccCreated;
	private String country;
	private String state;

	public PlrRedeemAccChequeInfoBean() {
	}

	public PlrRedeemAccChequeInfoBean(Long redeemAccId, String firstName,
			String lastName, String houseNum, String addressLine1,
			String addressLine2, String city, String stateCode, String state,
			String countryCode, String country, String postalCode,
			String status, boolean redeemAccCreated, Integer paymentTypeId,
			String paymentType, Integer providerId) {
		super();
		this.redeemAccId = redeemAccId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.houseNum = houseNum;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.stateCode = stateCode;
		this.countryCode = countryCode;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.status = status;
		this.redeemAccCreated = redeemAccCreated;
		this.paymentTypeId = paymentTypeId;
		this.paymentType = paymentType;
		this.providerId = providerId;
	}

	public Long getRedeemAccId() {
		return redeemAccId;
	}

	public void setRedeemAccId(Long redeemAccId) {
		this.redeemAccId = redeemAccId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
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

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setRedeemAccCreated(boolean redeemAccCreated) {
		this.redeemAccCreated = redeemAccCreated;
	}

	public boolean isRedeemAccCreated() {
		return redeemAccCreated;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public Integer getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

}
