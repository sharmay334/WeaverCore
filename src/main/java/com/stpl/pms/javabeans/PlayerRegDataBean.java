package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.Date;

public class PlayerRegDataBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long playerId;
	private String userName;
	private Long secretQues;
	private String secretAnswer;
	private String title;
	private String firstName;
	private String lastName;
	private String houseNo;
	private String address1;
	private String city;
	private Date dob;
	private String gender;
	private String country;
	private String state;
	private Long mobile;
	private String email;
	private Long phoneNo;
	private String postalCode;
	private String promoOpt;
	private String commPromo;
	private String commSupport;
	private String commTechnical;
	private String commNew;
	private Short referenceId;
	private String ppVersion;
	private String tcVersion;
	private String password;
	private Short domainId;
	private String panCardFileName;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getSecretQues() {
		return secretQues;
	}
	public void setSecretQues(Long secretQues) {
		this.secretQues = secretQues;
	}
	public String getSecretAnswer() {
		return secretAnswer;
	}
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPromoOpt() {
		return promoOpt;
	}
	public void setPromoOpt(String promoOpt) {
		this.promoOpt = promoOpt;
	}
	public String getCommPromo() {
		return commPromo;
	}
	public void setCommPromo(String commPromo) {
		this.commPromo = commPromo;
	}
	public String getCommSupport() {
		return commSupport;
	}
	public void setCommSupport(String commSupport) {
		this.commSupport = commSupport;
	}
	public String getCommTechnical() {
		return commTechnical;
	}
	public void setCommTechnical(String commTechnical) {
		this.commTechnical = commTechnical;
	}
	public String getCommNew() {
		return commNew;
	}
	public void setCommNew(String commNew) {
		this.commNew = commNew;
	}
	public Short getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(Short referenceId) {
		this.referenceId = referenceId;
	}
	public String getPpVersion() {
		return ppVersion;
	}
	public void setPpVersion(String ppVersion) {
		this.ppVersion = ppVersion;
	}
	public String getTcVersion() {
		return tcVersion;
	}
	public void setTcVersion(String tcVersion) {
		this.tcVersion = tcVersion;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public Long getPlayerId() {
		return playerId;
	}
	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}
	public Short getDomainId() {
		return domainId;
	}
	public void setPanCardFileName(String panCardFileName) {
		this.panCardFileName = panCardFileName;
	}
	public String getPanCardFileName() {
		return panCardFileName;
	}

}
