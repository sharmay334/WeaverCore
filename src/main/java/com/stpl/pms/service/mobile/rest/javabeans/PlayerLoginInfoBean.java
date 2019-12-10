package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerLoginInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userName;
	private Long playerId;
	private PlrWalletBean walletBean;
	private int unreadMsgCount;
	private String avatarPath;
	private String playerStatus;
	private String emailId;
	private String mobileNo;
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String state;
	private String city;
	private String country;
	private String pinCode;
	private String registrationIp;
	private String regDevice;
	private String registrationDate;
	private String firstLoginDate;
	private String lastLoginDate;
	private String firstDepositDate;
	private String olaPlayer;
	private String referSource;
	private String campaignName; 
	
	

	public PlayerLoginInfoBean(String userName, Long playerId,
			PlrWalletBean walletBean, int unreadMsgCount, String avatarPath,
			String playerStatus, String emailId, String mobileNo,
			String firstName, String lastName, String gender, String dob,
			String state, String city, String country, String pinCode,
			String registrationIp, String regDevice, String registrationDate,
			String firstLoginDate, String lastLoginDate,
			String firstDepositDate, String emailVerified,
			String phoneVerified, String playerType, String ageVerified,
			String addressVerified,String olaPlayer,String referSource,String campaignName) {
		super();
		this.userName = userName;
		this.playerId = playerId;
		this.walletBean = walletBean;
		this.unreadMsgCount = unreadMsgCount;
		this.avatarPath = avatarPath;
		this.playerStatus = playerStatus;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.state = state;
		this.city = city;
		this.country = country;
		this.pinCode = pinCode;
		this.registrationIp = registrationIp;
		this.regDevice = regDevice;
		this.registrationDate = registrationDate;
		this.firstLoginDate = firstLoginDate;
		this.lastLoginDate = lastLoginDate;
		this.firstDepositDate = firstDepositDate;
		this.emailVerified = emailVerified;
		this.phoneVerified = phoneVerified;
		this.playerType = playerType;
		this.ageVerified = ageVerified;
		this.addressVerified = addressVerified;
		this.olaPlayer=olaPlayer;
		this.referSource=referSource;
		this.campaignName=campaignName;
	}


	private String emailVerified;
	private String phoneVerified;
	private String playerType;
	private String ageVerified;
	private String addressVerified;

	public PlayerLoginInfoBean() {
	}
	public PlayerLoginInfoBean(String userName, Long playerId,
			PlrWalletBean walletBean, int unreadMsgCount, String avatarPath,
			String playerStatus, String emailVerified, String phoneVerified,
			String playerType, String ageVerified, String addressVerified) {
		super();
		this.userName = userName;
		this.playerId = playerId;
		this.walletBean = walletBean;
		this.unreadMsgCount = unreadMsgCount;
		this.avatarPath = avatarPath;
		this.playerStatus = playerStatus;
		this.emailVerified = emailVerified;
		this.phoneVerified = phoneVerified;
		this.playerType = playerType;
		this.ageVerified = ageVerified;
		this.addressVerified = addressVerified;
	}


	public String getPlayerStatus() {
		return playerStatus;
	}

	public void setPlayerStatus(String playerStatus) {
		this.playerStatus = playerStatus;
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

	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	public String getAgeVerified() {
		return ageVerified;
	}

	public void setAgeVerified(String ageVerified) {
		this.ageVerified = ageVerified;
	}

	public String getAddressVerified() {
		return addressVerified;
	}

	public void setAddressVerified(String addressVerified) {
		this.addressVerified = addressVerified;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public PlrWalletBean getWalletBean() {
		return walletBean;
	}

	public void setWalletBean(PlrWalletBean walletBean) {
		this.walletBean = walletBean;
	}

	public int getUnreadMsgCount() {
		return unreadMsgCount;
	}

	public void setUnreadMsgCount(int unreadMsgCount) {
		this.unreadMsgCount = unreadMsgCount;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	public String getAvatarPath() {
		return avatarPath;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getPinCode() {
		return pinCode;
	}



	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}



	public String getRegistrationIp() {
		return registrationIp;
	}



	public void setRegistrationIp(String registrationIp) {
		this.registrationIp = registrationIp;
	}



	public String getRegDevice() {
		return regDevice;
	}



	public void setRegDevice(String regDevice) {
		this.regDevice = regDevice;
	}



	public String getRegistrationDate() {
		return registrationDate;
	}



	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}



	public String getFirstLoginDate() {
		return firstLoginDate;
	}



	public void setFirstLoginDate(String firstLoginDate) {
		this.firstLoginDate = firstLoginDate;
	}



	public String getLastLoginDate() {
		return lastLoginDate;
	}



	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}



	public String getFirstDepositDate() {
		return firstDepositDate;
	}



	public void setFirstDepositDate(String firstDepositDate) {
		this.firstDepositDate = firstDepositDate;
	}
	public String getOlaPlayer() {
		return olaPlayer;
	}
	public void setOlaPlayer(String olaPlayer) {
		this.olaPlayer = olaPlayer;
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
	
}
