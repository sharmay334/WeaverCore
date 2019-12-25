package com.stpl.pms.hibernate.mapping;

import java.io.File;

public class StRmBoUserInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer Id;
	private Integer userId;
	//private StRmBoUserMaster stRmBoUserMaster;
	private String firstName;
	private String lastName;
	private String gender;
	private String emailId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String stateCode;
	private String countryCode;
	private String postalCode;
	private String phoneNum;
	private String mobileNum;
	private String fatherName;
	private String dob;
	private String panNumber;
	private String aadharNumber;
	private String voterNumber;
	private String passportNumber;
	private String bloodGroup;
	private String branch;
	private String currentAddress;
	private String permanentAddress;
	private String doj;
	private String dol;
	private String country;
	private String state;
	private String pincode;
	private String photo_doc;
	private String oldSalarySlip;
	private String expCertificate;
	private String eduCertificate;
	private String panDoc;
	private String aadharDoc;
	private String voterDoc;
	private String drivingDoc;
	private String passbookDoc;
	private String addressDoc;

	/** default constructor */
	public StRmBoUserInfo() {
	}
	
	
	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getPanNumber() {
		return panNumber;
	}


	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}


	public String getAadharNumber() {
		return aadharNumber;
	}


	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


	public String getVoterNumber() {
		return voterNumber;
	}


	public void setVoterNumber(String voterNumber) {
		this.voterNumber = voterNumber;
	}


	public String getPassportNumber() {
		return passportNumber;
	}


	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getCurrentAddress() {
		return currentAddress;
	}


	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}


	public String getPermanentAddress() {
		return permanentAddress;
	}


	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}


	public String getDoj() {
		return doj;
	}


	public void setDoj(String doj) {
		this.doj = doj;
	}


	public String getDol() {
		return dol;
	}


	public void setDol(String dol) {
		this.dol = dol;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getPhoto_doc() {
		return photo_doc;
	}


	public void setPhoto_doc(String photo_doc) {
		this.photo_doc = photo_doc;
	}


	public String getOldSalarySlip() {
		return oldSalarySlip;
	}


	public void setOldSalarySlip(String oldSalarySlip) {
		this.oldSalarySlip = oldSalarySlip;
	}


	public String getExpCertificate() {
		return expCertificate;
	}


	public void setExpCertificate(String expCertificate) {
		this.expCertificate = expCertificate;
	}


	public String getEduCertificate() {
		return eduCertificate;
	}


	public void setEduCertificate(String eduCertificate) {
		this.eduCertificate = eduCertificate;
	}


	public String getPanDoc() {
		return panDoc;
	}


	public void setPanDoc(String panDoc) {
		this.panDoc = panDoc;
	}


	public String getAadharDoc() {
		return aadharDoc;
	}


	public void setAadharDoc(String aadharDoc) {
		this.aadharDoc = aadharDoc;
	}


	public String getVoterDoc() {
		return voterDoc;
	}


	public void setVoterDoc(String voterDoc) {
		this.voterDoc = voterDoc;
	}


	public String getDrivingDoc() {
		return drivingDoc;
	}


	public void setDrivingDoc(String drivingDoc) {
		this.drivingDoc = drivingDoc;
	}


	public String getPassbookDoc() {
		return passbookDoc;
	}


	public void setPassbookDoc(String passbookDoc) {
		this.passbookDoc = passbookDoc;
	}


	public String getAddressDoc() {
		return addressDoc;
	}


	public void setAddressDoc(String addressDoc) {
		this.addressDoc = addressDoc;
	}


	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	/*public StRmBoUserMaster getStRmBoUserMaster() {
		return this.stRmBoUserMaster;
	}

	public void setStRmBoUserMaster(StRmBoUserMaster stRmBoUserMaster) {
		this.stRmBoUserMaster = stRmBoUserMaster;
	}*/

	public String getFirstName() {
		return this.firstName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

}