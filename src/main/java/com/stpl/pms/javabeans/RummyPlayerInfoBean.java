package com.stpl.pms.javabeans;

import java.io.Serializable;

public class RummyPlayerInfoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String tokenId;
	private Long playerId;
	private String userName;
	private String firstName;
	private String lastName;
	private String domainName;
	private String vipBand;
	private String lang;
	private String addressLine1;
	private String city;
	private String currencyCode;
	private String emailId;
	private String gender;
	private Long mobileNum;
	private String postalCode;
	private String state;
	private String avatarPath;
	private String loginIP;
	private String registrationDate;
	private String birthdayDate;
	private String aliasName;
	private String regDevice;
	private String referSource;
	private String campaignName;
	private String displayTab;
	private String displaySubTab;

	public RummyPlayerInfoBean(String tokenId, PlayerInfoBean playerInfoBean,
			String domainName, String aliasName, String vipBand, String avatarPath,String campaignName) {
		super();
		this.tokenId = tokenId;
		this.playerId = playerInfoBean.getPlayerId();
		this.userName = playerInfoBean.getUserName();
		this.firstName = playerInfoBean.getFirstName();
		this.lastName = playerInfoBean.getLastName();
		this.domainName = domainName;
		this.vipBand = vipBand;
		this.lang = playerInfoBean.getLanguage();
		this.addressLine1 = playerInfoBean.getAddressLine1();
		this.city = playerInfoBean.getCity();
		this.currencyCode = playerInfoBean.getCurrencyCode();
		this.emailId = playerInfoBean.getEmailId();
		this.gender = playerInfoBean.getGender();
		this.mobileNum = playerInfoBean.getMobileNo();
		this.postalCode = playerInfoBean.getPostalCode();
		this.state = playerInfoBean.getStateCode();
		this.avatarPath = avatarPath+playerInfoBean.getPlayerImagePath();
		this.loginIP = playerInfoBean.getRemoteAddress();
		this.registrationDate = playerInfoBean.getRegistrationDate().toString();
		this.birthdayDate = playerInfoBean.getDateOfBirth();
		this.aliasName = aliasName;
		this.regDevice=playerInfoBean.getRegDevice();		
		
		if(playerInfoBean.getReferSource().equals("NONE"))
			this.referSource="Direct";
		else
			this.referSource=playerInfoBean.getReferSource();
		
		if(campaignName==null || "".equals(campaignName))
			campaignName="NA";		
		this.campaignName=campaignName;
	}
	
	
	public RummyPlayerInfoBean(String tokenId, PlayerInfoBean playerInfoBean,
			String domainName, String aliasName, String vipBand, String avatarPath,String campaignName,String displayTab,String displaySubTab) {
		super();
		this.tokenId = tokenId;
		this.playerId = playerInfoBean.getPlayerId();
		this.userName = playerInfoBean.getUserName();
		this.firstName = playerInfoBean.getFirstName();
		this.lastName = playerInfoBean.getLastName();
		this.domainName = domainName;
		this.vipBand = vipBand;
		this.lang = playerInfoBean.getLanguage();
		this.addressLine1 = playerInfoBean.getAddressLine1();
		this.city = playerInfoBean.getCity();
		this.currencyCode = playerInfoBean.getCurrencyCode();
		this.emailId = playerInfoBean.getEmailId();
		this.gender = playerInfoBean.getGender();
		this.mobileNum = playerInfoBean.getMobileNo();
		this.postalCode = playerInfoBean.getPostalCode();
		this.state = playerInfoBean.getStateCode();
		this.avatarPath = avatarPath+playerInfoBean.getPlayerImagePath();
		this.loginIP = playerInfoBean.getRemoteAddress();
		this.registrationDate = playerInfoBean.getRegistrationDate().toString();
		this.birthdayDate = playerInfoBean.getDateOfBirth();
		this.aliasName = aliasName;
		this.regDevice=playerInfoBean.getRegDevice();		
		this.displayTab = displayTab;
		this.displaySubTab = displaySubTab;
		if(playerInfoBean.getReferSource().equals("NONE"))
			this.referSource="Direct";
		else
			this.referSource=playerInfoBean.getReferSource();
		
		if(campaignName==null || "".equals(campaignName))
			campaignName="NA";		
		this.campaignName=campaignName;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
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

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
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

	public Long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
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

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	public String getLoginIP() {
		return loginIP;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	@Override
	public String toString() {
		return "RummyPlayerInfoBean [playerId=" + playerId + ", userName="
				+ userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", domainName=" + domainName + ", vipBand="
				+ vipBand + ", lang=" + lang + ", addressLine1=" + addressLine1
				+ ", city=" + city + ", currencyCode=" + currencyCode
				+ ", emailId=" + emailId + ", gender=" + gender
				+ ", mobileNum=" + mobileNum + ", postalCode=" + postalCode
				+ ", state=" + state + ", avatarPath=" + avatarPath
				+ ", loginIP=" + loginIP + ", registrationDate="
				+ registrationDate + ", birthdayDate=" + birthdayDate
				+ ", aliasName=" + aliasName + ", regDevice=" + regDevice
				+ ", referSource=" + referSource + ", campaignName="
				+ campaignName + "]";
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(String birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getRegDevice() {
		return regDevice;
	}

	public void setRegDevice(String regDevice) {
		this.regDevice = regDevice;
	}

	public String getReferSource() {
		return referSource;
	}

	public void setReferSource(String referSource) {
		this.referSource = referSource;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getDisplaySubTab() {
		return displaySubTab;
	}

	public void setDisplaySubTab(String displaySubTab) {
		this.displaySubTab = displaySubTab;
	}

	public String getDisplayTab() {
		return displayTab;
	}

	public void setDisplayTab(String displayTab) {
		this.displayTab = displayTab;
	}	
}
