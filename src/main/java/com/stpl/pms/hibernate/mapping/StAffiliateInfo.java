package com.stpl.pms.hibernate.mapping;

import java.util.Date;

/**
 * StAffiliateInfo entity. @author MyEclipse Persistence Tools
 */

public class StAffiliateInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private StAffiliateMaster stAffiliateMaster;
	private String title;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String emailId;
	private String phoneNum;
	private String mobileNum;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String stateCode;
	private String countryCode;
	private String postalCode;
	private Boolean isnewsLetter;

	// Constructors

	/** default constructor */
	public StAffiliateInfo() {
	}

	/** minimal constructor */
	public StAffiliateInfo(Integer id,
			StAffiliateMaster stAffiliateMaster, String title,
			String firstName, String lastName, String gender, String emailId,
			String addressLine1, String stateCode, String countryCode,
			Boolean isnewsLetter) {
		this.id = id;
		this.stAffiliateMaster = stAffiliateMaster;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.emailId = emailId;
		this.addressLine1 = addressLine1;
		this.stateCode = stateCode;
		this.countryCode = countryCode;
		this.isnewsLetter = isnewsLetter;
	}

	/** full constructor */
	public StAffiliateInfo(Integer id,
			StAffiliateMaster stAffiliateMaster, String title,
			String firstName, String lastName, Date dateOfBirth, String gender,
			String emailId, String phoneNum, String mobileNum,
			String addressLine1, String addressLine2, String city,
			String stateCode, String countryCode, String postalCode,
			Boolean isnewsLetter) {
		this.id = id;
		this.stAffiliateMaster = stAffiliateMaster;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.emailId = emailId;
		this.phoneNum = phoneNum;
		this.mobileNum = mobileNum;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.stateCode = stateCode;
		this.countryCode = countryCode;
		this.postalCode = postalCode;
		this.isnewsLetter = isnewsLetter;
	}

	// Property accessors

	
	public StAffiliateMaster getStAffiliateMaster() {
		return this.stAffiliateMaster;
	}

	public void setStAffiliateMaster(StAffiliateMaster stAffiliateMaster) {
		this.stAffiliateMaster = stAffiliateMaster;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getMobileNum() {
		return this.mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Boolean getIsnewsLetter() {
		return this.isnewsLetter;
	}

	public void setIsnewsLetter(Boolean isnewsLetter) {
		this.isnewsLetter = isnewsLetter;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}