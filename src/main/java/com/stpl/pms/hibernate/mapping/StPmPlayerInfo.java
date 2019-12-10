package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlayerInfo entity. @author MyEclipse Persistence Tools
 */

public class StPmPlayerInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Long phoneNum;
	private String houseNum;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String town;
	private String registrationCity;
	private String postalCode;
	private String photoIdType;
	private String photoIdNum;
	private String timeZone;
	private Long secQuesId;
	private String secAns;
	private Timestamp registrationDate;
	private Timestamp activationDate;
	private String registrationIp;
	private String TCVersion;
	private String PPVersion;
	private String commPromo;
	private String commSupport;
	private String commTechnical;
	private String commNews;
	private String firstDepositMode;
	private Timestamp firstDepositTime;
	private String reason;
	private StGenCountryMaster stGenCountryMaster;
	private StGenStateMaster stGenStateMaster;

	// Constructors

	/** default constructor */
	public StPmPlayerInfo() {
	}

	/** minimal constructor */
	public StPmPlayerInfo(Long playerId, String houseNum, String addressLine1,
			String registrationCity, String photoIdType, Long secQuesId, String secAns,
			Timestamp registrationDate, Timestamp activationDate,
			String registrationIp, String TCVersion, String PPVersion,
			String commPromo, String commSupport, String commTechnical,
			String commNews, String firstDepositMode) {
		this.playerId = playerId;
		this.houseNum = houseNum;
		this.addressLine1 = addressLine1;
		this.registrationCity = registrationCity;
		
		this.photoIdType = photoIdType;
		this.secQuesId = secQuesId;
		this.secAns = secAns;
		this.registrationDate = registrationDate;
		this.activationDate = activationDate;
		this.registrationIp = registrationIp;
		this.TCVersion = TCVersion;
		this.PPVersion = PPVersion;
		this.commPromo = commPromo;
		this.commSupport = commSupport;
		this.commTechnical = commTechnical;
		this.commNews = commNews;
		this.firstDepositMode = firstDepositMode;
	}

	/** full constructor */
	public StPmPlayerInfo(Long playerId, Long phoneNum, String houseNum,
			String addressLine1, String addressLine2, String city,
			String registrationCity, String stateCode, String countryCode,
			String postalCode, String photoIdType, String photoIdNum,
			String timeZone, Long secQuesId, String secAns,
			Timestamp registrationDate, Timestamp activationDate,
			String registrationIp, String TCVersion, String PPVersion,
			String commPromo, String commSupport, String commTechnical,
			String commNews, String firstDepositMode,
			Timestamp firstDepositTime, String reason) {
		this.playerId = playerId;
		this.phoneNum = phoneNum;
		this.houseNum = houseNum;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.registrationCity = registrationCity;
		this.postalCode = postalCode;
		this.photoIdType = photoIdType;
		this.photoIdNum = photoIdNum;
		this.timeZone = timeZone;
		this.secQuesId = secQuesId;
		this.secAns = secAns;
		this.registrationDate = registrationDate;
		this.activationDate = activationDate;
		this.registrationIp = registrationIp;
		this.TCVersion = TCVersion;
		this.PPVersion = PPVersion;
		this.commPromo = commPromo;
		this.commSupport = commSupport;
		this.commTechnical = commTechnical;
		this.commNews = commNews;
		this.firstDepositMode = firstDepositMode;
		this.firstDepositTime = firstDepositTime;
		this.reason = reason;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Long getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getHouseNum() {
		return this.houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
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

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getRegistrationCity() {
		return this.registrationCity;
	}

	public void setRegistrationCity(String registrationCity) {
		this.registrationCity = registrationCity;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhotoIdType() {
		return this.photoIdType;
	}

	public void setPhotoIdType(String photoIdType) {
		this.photoIdType = photoIdType;
	}

	public String getPhotoIdNum() {
		return this.photoIdNum;
	}

	public void setPhotoIdNum(String photoIdNum) {
		this.photoIdNum = photoIdNum;
	}

	public String getTimeZone() {
		return this.timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Long getSecQuesId() {
		return this.secQuesId;
	}

	public void setSecQuesId(Long secQuesId) {
		this.secQuesId = secQuesId;
	}

	public String getSecAns() {
		return this.secAns;
	}

	public void setSecAns(String secAns) {
		this.secAns = secAns;
	}

	public Timestamp getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Timestamp getActivationDate() {
		return this.activationDate;
	}

	public void setActivationDate(Timestamp activationDate) {
		this.activationDate = activationDate;
	}

	public String getRegistrationIp() {
		return this.registrationIp;
	}

	public void setRegistrationIp(String registrationIp) {
		this.registrationIp = registrationIp;
	}

	public String getTCVersion() {
		return this.TCVersion;
	}

	public void setTCVersion(String TCVersion) {
		this.TCVersion = TCVersion;
	}

	public String getPPVersion() {
		return this.PPVersion;
	}

	public void setPPVersion(String PPVersion) {
		this.PPVersion = PPVersion;
	}

	public String getCommPromo() {
		return this.commPromo;
	}

	public void setCommPromo(String commPromo) {
		this.commPromo = commPromo;
	}

	public String getCommSupport() {
		return this.commSupport;
	}

	public void setCommSupport(String commSupport) {
		this.commSupport = commSupport;
	}

	public String getCommTechnical() {
		return this.commTechnical;
	}

	public void setCommTechnical(String commTechnical) {
		this.commTechnical = commTechnical;
	}

	public String getCommNews() {
		return this.commNews;
	}

	public void setCommNews(String commNews) {
		this.commNews = commNews;
	}

	public String getFirstDepositMode() {
		return this.firstDepositMode;
	}

	public void setFirstDepositMode(String firstDepositMode) {
		this.firstDepositMode = firstDepositMode;
	}

	public Timestamp getFirstDepositTime() {
		return this.firstDepositTime;
	}

	public void setFirstDepositTime(Timestamp firstDepositTime) {
		this.firstDepositTime = firstDepositTime;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setStGenCountryMaster(StGenCountryMaster stGenCountryMaster) {
		this.stGenCountryMaster = stGenCountryMaster;
	}

	public StGenCountryMaster getStGenCountryMaster() {
		return stGenCountryMaster;
	}

	public void setStGenStateMaster(StGenStateMaster stGenStateMaster) {
		this.stGenStateMaster = stGenStateMaster;
	}

	public StGenStateMaster getStGenStateMaster() {
		return stGenStateMaster;
	}

	

}