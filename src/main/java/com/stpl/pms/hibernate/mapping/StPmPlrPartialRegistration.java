package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;
import java.util.Date;

/**
 * StPmPlrPartialRegistration entity. @author MyEclipse Persistence Tools
 */

public class StPmPlrPartialRegistration implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long partialPlayerId;
	private Short domainId;
	private Short aliasId;
	private Timestamp registrationDate;
	private String status;
	private String title;
	private String userName;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String emailId;
	private Long phoneNum;
	private Long mobileNum;
	private String houseNum;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String stateCode;
	private String countryCode;
	private String postalCode;
	private String photoIdType;
	private String photoIdNum;
	private String language;
	private String timeZone;
	private String commNews;
	private String commPromo;
	private String commSupport;
	private String commTechnical;
	private Integer affiliateCode;
	private Long playerId;
	private String userStatus;
	private Long referenceId;
	private String TCVersion;
	private String PPVersion;
	private StPmPlayerMaster plrMaster;
	// Constructors

	/** default constructor */
	public StPmPlrPartialRegistration() {
	}

	/** minimal constructor */
	public StPmPlrPartialRegistration(Timestamp registrationDate,
			String commNews, String commPromo, String commSupport,
			String commTechnical, String TCVersion, String PPVersion) {
		this.registrationDate = registrationDate;
		this.commNews = commNews;
		this.commPromo = commPromo;
		this.commSupport = commSupport;
		this.commTechnical = commTechnical;
		this.TCVersion = TCVersion;
		this.PPVersion = PPVersion;
	}

	/** full constructor */
	public StPmPlrPartialRegistration(Short domainId,
			Timestamp registrationDate, String status, String title,
			String userName, String firstName, String lastName,
			Date dateOfBirth, String gender, String emailId, Long phoneNum,
			Long mobileNum, String houseNum, String addressLine1,
			String addressLine2, String city, String stateCode,
			String countryCode, String postalCode, String photoIdType,
			String photoIdNum, String language, String timeZone,
			String commNews, String commPromo, String commSupport,
			String commTechnical, Integer affiliateCode, Long playerId,
			String userStatus, Long referenceId, String TCVersion,
			String PPVersion) {
		this.domainId = domainId;
		this.registrationDate = registrationDate;
		this.status = status;
		this.title = title;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.emailId = emailId;
		this.phoneNum = phoneNum;
		this.mobileNum = mobileNum;
		this.houseNum = houseNum;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.stateCode = stateCode;
		this.countryCode = countryCode;
		this.postalCode = postalCode;
		this.photoIdType = photoIdType;
		this.photoIdNum = photoIdNum;
		this.language = language;
		this.timeZone = timeZone;
		this.commNews = commNews;
		this.commPromo = commPromo;
		this.commSupport = commSupport;
		this.commTechnical = commTechnical;
		this.affiliateCode = affiliateCode;
		this.playerId = playerId;
		this.userStatus = userStatus;
		this.referenceId = referenceId;
		this.TCVersion = TCVersion;
		this.PPVersion = PPVersion;
	}

	// Property accessors

	public Long getPartialPlayerId() {
		return this.partialPlayerId;
	}

	public void setPartialPlayerId(Long partialPlayerId) {
		this.partialPlayerId = partialPlayerId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Timestamp getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Long getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Long getMobileNum() {
		return this.mobileNum;
	}

	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
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

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTimeZone() {
		return this.timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getCommNews() {
		return this.commNews;
	}

	public void setCommNews(String commNews) {
		this.commNews = commNews;
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

	public Integer getAffiliateCode() {
		return this.affiliateCode;
	}

	public void setAffiliateCode(Integer affiliateCode) {
		this.affiliateCode = affiliateCode;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Long getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
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

	public void setPlrMaster(StPmPlayerMaster plrMaster) {
		this.plrMaster = plrMaster;
	}

	public StPmPlayerMaster getPlrMaster() {
		return plrMaster;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}