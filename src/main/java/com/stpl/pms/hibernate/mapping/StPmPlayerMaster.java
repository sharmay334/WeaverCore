package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;
import java.util.Date;

/**
 * StPmPlayerMaster entity. @author MyEclipse Persistence Tools
 */

public class StPmPlayerMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long playerId;
	private Timestamp lastLoginDate;
	private String title;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String emailId;
	private Long mobileNo;
	private String gender;
	private String autoPassword;
	private String userName;
	private String password;
	private String status;
	private String plrStatus;
	private String verificationStatus;
	private String verificationMode;
	private Integer affiliateCode;
	private Short domainId;
	private Short aliasId;
	private String duplicationCheckReq;
	private String promoOpt;
	private String addressVerified;
	private String emailVerified;
	private String phoneVerified;
	private String ageVerified;
	private String taxationIdVerified;
	private Integer vipLevel;
	private String languageCode;
	private String lastLoginCity;
	private String lastLoginCountryCode;
	private String lastLoginIp;
	private String lastLoginThrough;
	private Double practiceBal;
	private String playerImagePath;
	private Timestamp firstDepositDate;
	private Integer firstDepositPayTypeId;
	private String referSource;
	private Long referSourceId;
	private Long subSourceId;
	private Long campTrackId;
	private String firstDepositReferSource;
	private Long firstDepositReferSourceId;
	private Long firstDepositSubSourceId;
	private Long firstDepositCampTrackId;
	private Double migratePlrBalance;
	private String affiliateBind;
	private Integer affiliateId;
	private String affiliateReference;
	private Short tPVerificationSource;
	private Short invalidLoginTry;
	private String tPVerificationId;
	private String regDevice;
	private String userAgent;
	
	private String isPlay2x;

	private StPmPlayerInfo stPmPlayerInfo;
	private StTxnPlrWalletMaster playerWallet;
	private String referFriendCode;
	// Constructors

	/** default constructor */
	public StPmPlayerMaster() {
	}

	/** minimal constructor */
	public StPmPlayerMaster(Timestamp lastLoginDate, String autoPassword,
			String password, String status, String verificationStatus,
			String verificationMode, Short domainId,
			String duplicationCheckReq, String addressVerified,
			String emailVerified, String phoneVerified, String ageVerified,
			Integer vipLevel, String languageCode, String lastLoginCity,
			String lastLoginCountryCode, String lastLoginIp,
			String lastLoginThrough, Integer firstDepositPayTypeId,
			String affiliateBind, Integer affiliateId, Short invalidLoginTry, String userAgent) {
		this.lastLoginDate = lastLoginDate;
		this.autoPassword = autoPassword;
		this.password = password;
		this.status = status;
		this.verificationStatus = verificationStatus;
		this.verificationMode = verificationMode;
		this.domainId = domainId;
		this.duplicationCheckReq = duplicationCheckReq;
		this.addressVerified = addressVerified;
		this.emailVerified = emailVerified;
		this.phoneVerified = phoneVerified;
		this.ageVerified = ageVerified;
		this.vipLevel = vipLevel;
		this.languageCode = languageCode;
		this.lastLoginCity = lastLoginCity;
		this.lastLoginCountryCode = lastLoginCountryCode;
		this.lastLoginIp = lastLoginIp;
		this.lastLoginThrough = lastLoginThrough;
		this.firstDepositPayTypeId = firstDepositPayTypeId;
		this.affiliateBind = affiliateBind;
		this.affiliateId = affiliateId;
		this.invalidLoginTry = invalidLoginTry;
		this.userAgent = userAgent;
	}

	/** full constructor */
	public StPmPlayerMaster(Timestamp lastLoginDate, String title,
			String firstName, String lastName, Date dateOfBirth,
			String emailId, Long mobileNo, String gender, String autoPassword,
			String userName, String password, String status,
			String verificationStatus, String verificationMode,
			Integer affiliateCode, Short domainId, String duplicationCheckReq,
			String promoOpt, String addressVerified, String emailVerified,
			String phoneVerified, String ageVerified,
			String taxationIdVerified, Integer vipLevel, String languageCode,
			String lastLoginCity, String lastLoginCountryCode,
			String lastLoginIp, String lastLoginThrough, Double practiceBal,
			String playerImagePath, Timestamp firstDepositDate,
			Integer firstDepositPayTypeId, String referSource,
			Long referSourceId, Long subSourceId, Long campTrackId,
			Double migratePlrBalance, String affiliateBind,
			Integer affiliateId, String affiliateReference,
			Short tPVerificationSource, Short invalidLoginTry,
			String tPVerificationId, String regDevice,String userAgent) {
		this.lastLoginDate = lastLoginDate;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.autoPassword = autoPassword;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.verificationStatus = verificationStatus;
		this.verificationMode = verificationMode;
		this.affiliateCode = affiliateCode;
		this.domainId = domainId;
		this.duplicationCheckReq = duplicationCheckReq;
		this.promoOpt = promoOpt;
		this.addressVerified = addressVerified;
		this.emailVerified = emailVerified;
		this.phoneVerified = phoneVerified;
		this.ageVerified = ageVerified;
		this.taxationIdVerified = taxationIdVerified;
		this.vipLevel = vipLevel;
		this.languageCode = languageCode;
		this.lastLoginCity = lastLoginCity;
		this.lastLoginCountryCode = lastLoginCountryCode;
		this.lastLoginIp = lastLoginIp;
		this.lastLoginThrough = lastLoginThrough;
		this.practiceBal = practiceBal;
		this.playerImagePath = playerImagePath;
		this.firstDepositDate = firstDepositDate;
		this.firstDepositPayTypeId = firstDepositPayTypeId;
		this.referSource = referSource;
		this.referSourceId = referSourceId;
		this.subSourceId = subSourceId;
		this.campTrackId = campTrackId;
		this.migratePlrBalance = migratePlrBalance;
		this.affiliateBind = affiliateBind;
		this.affiliateId = affiliateId;
		this.affiliateReference = affiliateReference;
		this.settPVerificationSource(tPVerificationSource);
		this.invalidLoginTry = invalidLoginTry;
		this.settPVerificationId(tPVerificationId);
		this.regDevice = regDevice;
		this.userAgent = userAgent;
	}

	// Property accessors

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Timestamp getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
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

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAutoPassword() {
		return this.autoPassword;
	}

	public void setAutoPassword(String autoPassword) {
		this.autoPassword = autoPassword;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVerificationStatus() {
		return this.verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getVerificationMode() {
		return this.verificationMode;
	}

	public void setVerificationMode(String verificationMode) {
		this.verificationMode = verificationMode;
	}

	public Integer getAffiliateCode() {
		return this.affiliateCode;
	}

	public void setAffiliateCode(Integer affiliateCode) {
		this.affiliateCode = affiliateCode;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getDuplicationCheckReq() {
		return this.duplicationCheckReq;
	}

	public void setDuplicationCheckReq(String duplicationCheckReq) {
		this.duplicationCheckReq = duplicationCheckReq;
	}

	public String getPromoOpt() {
		return this.promoOpt;
	}

	public void setPromoOpt(String promoOpt) {
		this.promoOpt = promoOpt;
	}

	public String getAddressVerified() {
		return this.addressVerified;
	}

	public void setAddressVerified(String addressVerified) {
		this.addressVerified = addressVerified;
	}

	public String getEmailVerified() {
		return this.emailVerified;
	}

	public void setEmailVerified(String emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getPhoneVerified() {
		return this.phoneVerified;
	}

	public void setPhoneVerified(String phoneVerified) {
		this.phoneVerified = phoneVerified;
	}

	public String getAgeVerified() {
		return this.ageVerified;
	}

	public void setAgeVerified(String ageVerified) {
		this.ageVerified = ageVerified;
	}

	public String getTaxationIdVerified() {
		return this.taxationIdVerified;
	}

	public void setTaxationIdVerified(String taxationIdVerified) {
		this.taxationIdVerified = taxationIdVerified;
	}

	public Integer getVipLevel() {
		return this.vipLevel;
	}

	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLastLoginCity() {
		return this.lastLoginCity;
	}

	public void setLastLoginCity(String lastLoginCity) {
		this.lastLoginCity = lastLoginCity;
	}

	public String getLastLoginCountryCode() {
		return this.lastLoginCountryCode;
	}

	public void setLastLoginCountryCode(String lastLoginCountryCode) {
		this.lastLoginCountryCode = lastLoginCountryCode;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLastLoginThrough() {
		return this.lastLoginThrough;
	}

	public void setLastLoginThrough(String lastLoginThrough) {
		this.lastLoginThrough = lastLoginThrough;
	}

	public Double getPracticeBal() {
		return this.practiceBal;
	}

	public void setPracticeBal(Double practiceBal) {
		this.practiceBal = practiceBal;
	}

	public String getPlayerImagePath() {
		return this.playerImagePath;
	}

	public void setPlayerImagePath(String playerImagePath) {
		this.playerImagePath = playerImagePath;
	}

	public Timestamp getFirstDepositDate() {
		return this.firstDepositDate;
	}

	public void setFirstDepositDate(Timestamp firstDepositDate) {
		this.firstDepositDate = firstDepositDate;
	}

	public Integer getFirstDepositPayTypeId() {
		return this.firstDepositPayTypeId;
	}

	public void setFirstDepositPayTypeId(Integer firstDepositPayTypeId) {
		this.firstDepositPayTypeId = firstDepositPayTypeId;
	}

	public String getReferSource() {
		return this.referSource;
	}

	public void setReferSource(String referSource) {
		this.referSource = referSource;
	}

	public Long getReferSourceId() {
		return this.referSourceId;
	}

	public void setReferSourceId(Long referSourceId) {
		this.referSourceId = referSourceId;
	}

	public Long getSubSourceId() {
		return this.subSourceId;
	}

	public void setSubSourceId(Long subSourceId) {
		this.subSourceId = subSourceId;
	}

	public Long getCampTrackId() {
		return this.campTrackId;
	}

	public void setCampTrackId(Long campTrackId) {
		this.campTrackId = campTrackId;
	}

	public Double getMigratePlrBalance() {
		return this.migratePlrBalance;
	}

	public void setMigratePlrBalance(Double migratePlrBalance) {
		this.migratePlrBalance = migratePlrBalance;
	}

	public String getAffiliateBind() {
		return this.affiliateBind;
	}

	public void setAffiliateBind(String affiliateBind) {
		this.affiliateBind = affiliateBind;
	}

	public Integer getAffiliateId() {
		return this.affiliateId;
	}

	public void setAffiliateId(Integer affiliateId) {
		this.affiliateId = affiliateId;
	}

	public String getAffiliateReference() {
		return this.affiliateReference;
	}

	public void setAffiliateReference(String affiliateReference) {
		this.affiliateReference = affiliateReference;
	}

	public Short getInvalidLoginTry() {
		return this.invalidLoginTry;
	}

	public void setInvalidLoginTry(Short invalidLoginTry) {
		this.invalidLoginTry = invalidLoginTry;
	}

	public StPmPlayerInfo getStPmPlayerInfo() {
		return stPmPlayerInfo;
	}

	public void setStPmPlayerInfo(StPmPlayerInfo stPmPlayerInfo) {
		this.stPmPlayerInfo = stPmPlayerInfo;
	}

	public StTxnPlrWalletMaster getPlayerWallet() {
		return playerWallet;
	}

	public void setPlayerWallet(StTxnPlrWalletMaster playerWallet) {
		this.playerWallet = playerWallet;
	}

	public Short gettPVerificationSource() {
		return tPVerificationSource;
	}

	public void settPVerificationSource(Short tPVerificationSource) {
		this.tPVerificationSource = tPVerificationSource;
	}

	public String gettPVerificationId() {
		return tPVerificationId;
	}

	public void settPVerificationId(String tPVerificationId) {
		this.tPVerificationId = tPVerificationId;
	}
	
	public String getRegDevice() {
		return this.regDevice;
	}

	public void setRegDevice(String regDevice) {
		this.regDevice = regDevice;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getPlrStatus() {
		return plrStatus;
	}

	public void setPlrStatus(String plrStatus) {
		this.plrStatus = plrStatus;
	}

	public String getFirstDepositReferSource() {
		return firstDepositReferSource;
	}

	public void setFirstDepositReferSource(String firstDepositReferSource) {
		this.firstDepositReferSource = firstDepositReferSource;
	}

	public Long getFirstDepositReferSourceId() {
		return firstDepositReferSourceId;
	}

	public void setFirstDepositReferSourceId(Long firstDepositReferSourceId) {
		this.firstDepositReferSourceId = firstDepositReferSourceId;
	}

	public Long getFirstDepositSubSourceId() {
		return firstDepositSubSourceId;
	}

	public void setFirstDepositSubSourceId(Long firstDepositSubSourceId) {
		this.firstDepositSubSourceId = firstDepositSubSourceId;
	}

	public Long getFirstDepositCampTrackId() {
		return firstDepositCampTrackId;
	}

	public void setFirstDepositCampTrackId(Long firstDepositCampTrackId) {
		this.firstDepositCampTrackId = firstDepositCampTrackId;
	}
	
	public String getIsPlay2x() {
		return isPlay2x;
	}

	public void setIsPlay2x(String isPlay2x) {
		this.isPlay2x = isPlay2x;
	}

	public String getReferFriendCode() {
		return referFriendCode;
	}

	public void setReferFriendCode(String referFriendCode) {
		this.referFriendCode = referFriendCode;
	}

	
	
	
	

	
}