package com.stpl.pms.javabeans;

import java.io.File;
import java.io.Serializable;

public class UserDetailsBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String boUserType;
	private String firstName;
	private String lastName;
	private String lastnameedit;
	private int userId;
	private String userName;
	private String emailId;
	private String gender;
	private String phoneNbr;

	private String secAns;
	private String secQues;
	private String status;

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String stateCode;
	private String countryCode;
	private String postalCode;
	private String mobileNum;

	private String department;
	private String isOffline;
	private String mailingStatus;
	private String orgAddr1;
	private String orgAddr2;
	private String orgCity;
	private String orgCountry;
	private double orgCreditLimit;
	private int orgId;
	private String orgName;
	private long orgPin;
	private String orgState;
	private String orgStatus;
	private String orgType;
	private int roleId;
	private short domainId;
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
	private String approver;
	private String leaves;
	private String attendanceTime;
	private String attendanceSelfie;
	private String dailyAllowance;
	private String dailyAllowanceDoc;
	private String exCityAllowance;
	private String cityAllowance;
	private String travellingAllowance;
	private String weekDay;
	private String role;
	private String region;	
	private String authAmount;
	

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

	public String getBoUserType() {
		return boUserType;
	}

	public void setBoUserType(String boUserType) {
		this.boUserType = boUserType;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPhoneNbr() {
		return phoneNbr;
	}

	public void setPhoneNbr(String phoneNbr) {
		this.phoneNbr = phoneNbr;
	}

	public String getSecAns() {
		return secAns;
	}

	public void setSecAns(String secAns) {
		this.secAns = secAns;
	}

	public String getSecQues() {
		return secQues;
	}

	public void setSecQues(String secQues) {
		this.secQues = secQues;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getIsOffline() {
		return isOffline;
	}

	public void setIsOffline(String isOffline) {
		this.isOffline = isOffline;
	}

	public String getMailingStatus() {
		return mailingStatus;
	}

	public void setMailingStatus(String mailingStatus) {
		this.mailingStatus = mailingStatus;
	}

	public String getOrgAddr1() {
		return orgAddr1;
	}

	public void setOrgAddr1(String orgAddr1) {
		this.orgAddr1 = orgAddr1;
	}

	public String getOrgAddr2() {
		return orgAddr2;
	}

	public void setOrgAddr2(String orgAddr2) {
		this.orgAddr2 = orgAddr2;
	}

	public String getOrgCity() {
		return orgCity;
	}

	public void setOrgCity(String orgCity) {
		this.orgCity = orgCity;
	}

	public String getOrgCountry() {
		return orgCountry;
	}

	public void setOrgCountry(String orgCountry) {
		this.orgCountry = orgCountry;
	}

	public double getOrgCreditLimit() {
		return orgCreditLimit;
	}

	public void setOrgCreditLimit(double orgCreditLimit) {
		this.orgCreditLimit = orgCreditLimit;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public long getOrgPin() {
		return orgPin;
	}

	public void setOrgPin(long orgPin) {
		this.orgPin = orgPin;
	}

	public String getOrgState() {
		return orgState;
	}

	public void setOrgState(String orgState) {
		this.orgState = orgState;
	}

	public String getOrgStatus() {
		return orgStatus;
	}

	public void setOrgStatus(String orgStatus) {
		this.orgStatus = orgStatus;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public String getLastnameedit() {
		return lastnameedit;
	}

	public void setLastnameedit(String lastnameedit) {
		this.lastnameedit = lastnameedit;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getLeaves() {
		return leaves;
	}

	public void setLeaves(String leaves) {
		this.leaves = leaves;
	}

	public String getAttendanceTime() {
		return attendanceTime;
	}

	public void setAttendanceTime(String attendanceTime) {
		this.attendanceTime = attendanceTime;
	}

	public String getAttendanceSelfie() {
		return attendanceSelfie;
	}

	public void setAttendanceSelfie(String attendanceSelfie) {
		this.attendanceSelfie = attendanceSelfie;
	}

	public String getDailyAllowance() {
		return dailyAllowance;
	}

	public void setDailyAllowance(String dailyAllowance) {
		this.dailyAllowance = dailyAllowance;
	}

	public String getDailyAllowanceDoc() {
		return dailyAllowanceDoc;
	}

	public void setDailyAllowanceDoc(String dailyAllowanceDoc) {
		this.dailyAllowanceDoc = dailyAllowanceDoc;
	}

	public String getExCityAllowance() {
		return exCityAllowance;
	}

	public void setExCityAllowance(String exCityAllowance) {
		this.exCityAllowance = exCityAllowance;
	}

	public String getCityAllowance() {
		return cityAllowance;
	}

	public void setCityAllowance(String cityAllowance) {
		this.cityAllowance = cityAllowance;
	}

	public String getTravellingAllowance() {
		return travellingAllowance;
	}

	public void setTravellingAllowance(String travellingAllowance) {
		this.travellingAllowance = travellingAllowance;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAuthAmount() {
		return authAmount;
	}

	public void setAuthAmount(String authAmount) {
		this.authAmount = authAmount;
	}
	
}
