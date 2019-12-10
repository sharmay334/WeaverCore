package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerRegistrationBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<String> labelValues;
	private Short domainId;
	private Integer affiliateCode;
	private String remoteAddress;
	private String playerQues;
	private String countryCode;
	private String languageCode;
	private String addressVerified;
	private String emailVerified;
	private String phoneVerified;
	private String ageVerified;
	private String status;
	private ArrayList<String> requiredFieldList;
	private String playerPassword;
	private Long playerId;
	private String userName;
	private Long secQuesId;
	private String secAns;
	private String title;
	private String firstName;
	private String lastName;
	private Long phoneNum;
	private String houseNum;
	private String addressLine1;
	private String city;
	private String dateOfBirth;
	private String gender;
	private String country;
	private String stateCode;
	private Long mobileNo;
	private String emailId;
	private String postalCode;
	private String promoOpt;
	private String commPromo;
	private String commSupport;
	private String commTechnical;
	private String commNews;
	private Short referenceId;
	private String ppVersion;
	private String tcVersion;
	private String password;
	private int currencyId;
	
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
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	
	public Long getSecQuesId() {
		return secQuesId;
	}
	public void setSecQuesId(Long secQuesId) {
		this.secQuesId = secQuesId;
	}
	public String getSecAns() {
		return secAns;
	}
	public void setSecAns(String secAns) {
		this.secAns = secAns;
	}
	public Long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPanCardFileName() {
		return panCardFileName;
	}
	public void setPanCardFileName(String panCardFileName) {
		this.panCardFileName = panCardFileName;
	}
	private String panCardFileName;
	
	
	public Short getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(Short referenceId) {
		this.referenceId = referenceId;
	}
	public String getAddressVerified() {
		return addressVerified;
	}
	public void setAddressVerified(String addressVerified) {
		this.addressVerified = addressVerified;
	}
	public String getEmailVerified() {
		return emailVerified;
	}
	public void setEmailVerified(String emailVerified) {
		this.emailVerified = emailVerified;
	}
	public String getPhoneVerified() {
		return phoneVerified;
	}
	public void setPhoneVerified(String phoneVerified) {
		this.phoneVerified = phoneVerified;
	}
	public String getAgeVerified() {
		return ageVerified;
	}
	public void setAgeVerified(String ageVerified) {
		this.ageVerified = ageVerified;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public ArrayList<String> getLabelValues() {
		return labelValues;
	}
	public void setLabelValues(ArrayList<String> labelValues) {
		this.labelValues = labelValues;
	}
	public Short getDomainId() {
		return domainId;
	}
	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}
	public Integer getAffiliateCode() {
		return affiliateCode;
	}
	public void setAffiliateCode(Integer affiliateCode) {
		this.affiliateCode = affiliateCode;
	}
	public String getRemoteAddress() {
		return remoteAddress;
	}
	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}
	public void setPlayerQues(String playerQues) {
		this.playerQues = playerQues;
	}
	public String getPlayerQues() {
		return playerQues;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	
	public void setRequiredFieldList(ArrayList<String> requiredFieldList) {
		this.requiredFieldList = requiredFieldList;
	}
	public ArrayList<String> getRequiredFieldList() {
		return requiredFieldList;
	}
	public void setPlayerPassword(String playerPassword) {
		this.playerPassword = playerPassword;
	}
	public String getPlayerPassword() {
		return playerPassword;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCommNews(String commNews) {
		this.commNews = commNews;
	}
	public String getCommNews() {
		return commNews;
	}
	
	
}
