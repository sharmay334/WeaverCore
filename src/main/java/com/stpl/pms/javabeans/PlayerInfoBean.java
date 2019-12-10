package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.stpl.pms.hibernate.mapping.StPmPlayerMaster;
@JsonSerialize(include = Inclusion.NON_NULL)
public class PlayerInfoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private long playerId;
	private short domainId;
	private short aliasId;
	private String countryCode;
	private int countryId;
	private String gender;
	private String firstName;
	private String lastName;
	private String emailId;
	private String userName;
	private String addressLine1;
	private String city;
	private String postalCode;
	private String houseNum;
	private String addressLine2;
	private int vipLevel;
	private String language;
	private Integer languageId;
	private Long mobileNo;
	private PlayerWalletBean walletBean;
	private Map<String, String> txnControlMap;
	private String CurrencyCode;
	private double practiceBal;
	private String playerImagePath;
	private Integer affiliateCode;
	private int firstDepositPayTypeId;
	private Timestamp firstDepositDate;
	private String referSource;
	private Long referSourceId;
	private Long subSourceId;
	private Long referId;
	private Timestamp registrationDate;
    private Long campTrckId;
    private String registrationIp;
    private String firstDepositReferSource;
	private Long firstDepositReferSourceId;
	private Long firstDepositSubSourceId;
	private Long firstDepositCampTrackId;
	private Integer totalDepCount;
	/*
	 * required while registration
	 */
	private ArrayList<String> labelValues;
	private String remoteAddress;
	private String playerQues;
	private String addressVerified;
	private String emailVerified;
	private String phoneVerified;
	private String ageVerified;
	private String status;
	private String playerPassword;
	private Long secQuesId;
	private String secAns;
	private String title;
	private Long phoneNum;
	private String dateOfBirth;
	private String country;
	private String stateCode;
	private String state;
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
	private String panCardFileName;
	private String taxationIdVerified;
	private byte[] panCard;

	private String affiliateBind;
	private int affiliateId;
	private String affiliateReference;
	private int unreadCount;

	/*
	 * required while login
	 */
	private String sessionId;
	private String device;
	private String regDevice;
	
	private Integer stateId;
	private String deviceType;
	private String lastBonusType;
	private String userAgent;
	private Short loginAliasId;
	private String rakeAmt;
	private String betAmt;
	/*
	  * Required for RummyDeepLinking
	*/
	private String displayTab;
	private String displaySubTab;
	private String plrStatus;
	private String isPlay2X;
	private String referFriendCode;


	public PlayerInfoBean() {
		
	}

	
	public PlayerInfoBean(String firstName, String lastName,
			String userName, String password, String gender,
			String dateOfBirth, String emailId, Long mobileNo, Long phoneNum,
			String houseNum, String addressLine1, String addressLine2,
			String city, String countryCode, String stateCode,
			String postalCode, String remoteAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.phoneNum = phoneNum;
		this.houseNum = houseNum;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.countryCode = countryCode;
		this.stateCode = stateCode;
		this.postalCode = postalCode;
		this.remoteAddress = remoteAddress;
	}
	
	public PlayerInfoBean(StPmPlayerMaster plrMaster){
		this.playerId = plrMaster.getPlayerId();
		this.title = plrMaster.getTitle();
		this.firstName = plrMaster.getFirstName();
		this.lastName = plrMaster.getLastName();
		this.emailId = plrMaster.getEmailId();
		this.mobileNo = plrMaster.getMobileNo();
		this.gender = plrMaster.getGender();
		this.userName = plrMaster.getUserName();
		this.status = plrMaster.getStatus();
		this.affiliateCode = plrMaster.getAffiliateCode();
		this.domainId = plrMaster.getDomainId();
		this.aliasId = plrMaster.getAliasId();
		this.promoOpt = plrMaster.getPromoOpt();
		this.addressVerified = plrMaster.getAddressVerified();
		this.emailVerified = plrMaster.getEmailVerified();
		this.phoneVerified = plrMaster.getPhoneVerified();
		this.ageVerified = plrMaster.getAgeVerified();
		this.taxationIdVerified = plrMaster.getTaxationIdVerified();
		this.vipLevel = plrMaster.getVipLevel();
		this.language = plrMaster.getLanguageCode();
		this.practiceBal = plrMaster.getPracticeBal();
		this.playerImagePath = plrMaster.getPlayerImagePath();
		this.firstDepositDate = plrMaster.getFirstDepositDate();
		this.firstDepositPayTypeId = plrMaster.getFirstDepositPayTypeId();
		this.referSource = plrMaster.getReferSource();
		this.referSourceId = plrMaster.getReferSourceId();
		this.subSourceId = plrMaster.getSubSourceId();
		this.campTrckId = plrMaster.getCampTrackId();
		this.affiliateBind = plrMaster.getAffiliateBind();
		this.affiliateId = plrMaster.getAffiliateId();
		this.affiliateReference = plrMaster.getAffiliateReference();
		this.regDevice = plrMaster.getRegDevice();
		this.userAgent = plrMaster.getUserAgent();
	}
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public ArrayList<String> getLabelValues() {
		return labelValues;
	}

	public void setLabelValues(ArrayList<String> labelValues) {
		this.labelValues = labelValues;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public String getPlayerQues() {
		return playerQues;
	}

	public void setPlayerQues(String playerQues) {
		this.playerQues = playerQues;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPlayerPassword() {
		return playerPassword;
	}

	public void setPlayerPassword(String playerPassword) {
		this.playerPassword = playerPassword;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
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

	public String getCommNews() {
		return commNews;
	}

	public void setCommNews(String commNews) {
		this.commNews = commNews;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setWalletBean(PlayerWalletBean walletBean) {
		this.walletBean = walletBean;
	}

	public PlayerWalletBean getWalletBean() {
		return walletBean;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setTxnControlMap(Map<String, String> txnControlMap) {
		this.txnControlMap = txnControlMap;
	}

	public Map<String, String> getTxnControlMap() {
		return txnControlMap;
	}

	public void setCurrencyCode(String currencyCode) {
		CurrencyCode = currencyCode;
	}

	public String getCurrencyCode() {
		return CurrencyCode;
	}

	public void setPracticeBal(double practiceBal) {
		this.practiceBal = practiceBal;
	}

	public double getPracticeBal() {
		return practiceBal;
	}

	public void setPlayerImagePath(String playerImagePath) {
		this.playerImagePath = playerImagePath;
	}

	public String getPlayerImagePath() {
		return playerImagePath;
	}

	public void setAffiliateCode(Integer affiliateCode) {
		this.affiliateCode = affiliateCode;
	}

	public Integer getAffiliateCode() {
		return affiliateCode;
	}

	public void setPanCardFileName(String panCardFileName) {
		this.panCardFileName = panCardFileName;
	}

	public String getPanCardFileName() {
		return panCardFileName;
	}

	public void setTaxationIdVerified(String taxationIdVerified) {
		this.taxationIdVerified = taxationIdVerified;
	}

	public String getTaxationIdVerified() {
		return taxationIdVerified;
	}

	public void setFirstDepositPayTypeId(int firstDepositPayTypeId) {
		this.firstDepositPayTypeId = firstDepositPayTypeId;
	}

	public int getFirstDepositPayTypeId() {
		return firstDepositPayTypeId;
	}

	public void setFirstDepositDate(Timestamp firstDepositDate) {
		this.firstDepositDate = firstDepositDate;
	}

	public Timestamp getFirstDepositDate() {
		return firstDepositDate;
	}

	public void setPanCard(byte[] panCard) {
		this.panCard = panCard;
	}

	public byte[] getPanCard() {
		return panCard;
	}

	public String getReferSource() {
		return referSource;
	}

	public Long getReferSourceId() {
		return referSourceId;
	}

	public Long getSubSourceId() {
		return subSourceId;
	}

	public void setReferSource(String referSource) {
		this.referSource = referSource;
	}

	public void setReferSourceId(Long referSourceId) {
		this.referSourceId = referSourceId;
	}

	public void setSubSourceId(Long subSourceId) {
		this.subSourceId = subSourceId;
	}

	public Long getReferId() {
		return referId;
	}

	public void setReferId(Long referId) {
		this.referId = referId;
	}

	public void setAffiliateId(Integer affiliateId) {
		this.affiliateId = affiliateId;
	}

	public Integer getAffiliateId() {
		return affiliateId;
	}

	public void setAffiliateReference(String affiliateReference) {
		this.affiliateReference = affiliateReference;
	}

	public String getAffiliateReference() {
		return affiliateReference;
	}

	public void setAffiliateBind(String affiliateBind) {
		this.affiliateBind = affiliateBind;
	}

	public String getAffiliateBind() {
		return affiliateBind;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	public int getUnreadCount() {
		return unreadCount;
	}

	public void setUnreadCount(int unreadCount) {
		this.unreadCount = unreadCount;
	}

	public void setCampTrckId(Long campTrckId) {
		this.campTrckId = campTrckId;
	}

	public Long getCampTrckId() {
		return campTrckId;
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


	public String getLastBonusType() {
		return lastBonusType;
	}


	public void setLastBonusType(String lastBonusType) {
		this.lastBonusType = lastBonusType;
	}
	
	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}


	public short getAliasId() {
		return aliasId;
	}


	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}


	public Short getLoginAliasId() {
		return loginAliasId;
	}


	public void setLoginAliasId(Short loginAliasId) {
		this.loginAliasId = loginAliasId;
	}


	public String getRakeAmt() {
		return rakeAmt;
	}


	public void setRakeAmt(String rakeAmt) {
		this.rakeAmt = rakeAmt;
	}


	public String getBetAmt() {
		return betAmt;
	}


	public void setBetAmt(String betAmt) {
		this.betAmt = betAmt;
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


	public String getDisplayTab() {
		return displayTab;
	}


	public void setDisplayTab(String displayTab) {
		this.displayTab = displayTab;
	}


	public String getDisplaySubTab() {
		return displaySubTab;
	}


	public void setDisplaySubTab(String displaySubTab) {
		this.displaySubTab = displaySubTab;
	}


	public Integer getTotalDepCount() {
		return totalDepCount;
	}


	public void setTotalDepCount(Integer totalDepCount) {
		this.totalDepCount = totalDepCount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getPlrStatus() {
		return plrStatus;
	}


	public void setPlrStatus(String plrStatus) {
		this.plrStatus = plrStatus;
	}

	public String getDeviceType() {
		return deviceType;
	}


	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}


	public Integer getStateId() {
		return stateId;
	}


	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}


	public String getIsPlay2X() {
		return isPlay2X;
	}


	public void setIsPlay2X(String isPlay2X) {
		this.isPlay2X = isPlay2X;
	}

	public String getReferFriendCode() { return referFriendCode; }

	public void setReferFriendCode(String referFriendCode) { this.referFriendCode = referFriendCode; }


	@Override
	public String toString() {
		return "PlayerInfoBean [playerId=" + playerId + ", domainId="
				+ domainId + ", aliasId=" + aliasId + ", countryCode="
				+ countryCode + ", countryId=" + countryId + ", gender="
				+ gender + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", userName=" + userName
				+ ", addressLine1=" + addressLine1 + ", city=" + city
				+ ", postalCode=" + postalCode + ", houseNum=" + houseNum
				+ ", addressLine2=" + addressLine2 + ", vipLevel=" + vipLevel
				+ ", language=" + language + ", languageId=" + languageId
				+ ", mobileNo=" + mobileNo + ", walletBean=" + walletBean
				+ ", txnControlMap=" + txnControlMap + ", CurrencyCode="
				+ CurrencyCode + ", practiceBal=" + practiceBal
				+ ", playerImagePath=" + playerImagePath + ", affiliateCode="
				+ affiliateCode + ", firstDepositPayTypeId="
				+ firstDepositPayTypeId + ", firstDepositDate="
				+ firstDepositDate + ", referSource=" + referSource
				+ ", referSourceId=" + referSourceId + ", subSourceId="
				+ subSourceId + ", referId=" + referId + ", registrationDate="
				+ registrationDate + ", campTrckId=" + campTrckId
				+ ", registrationIp=" + registrationIp
				+ ", firstDepositReferSource=" + firstDepositReferSource
				+ ", firstDepositReferSourceId=" + firstDepositReferSourceId
				+ ", firstDepositSubSourceId=" + firstDepositSubSourceId
				+ ", firstDepositCampTrackId=" + firstDepositCampTrackId
				+ ", totalDepCount=" + totalDepCount + ", labelValues="
				+ labelValues + ", remoteAddress=" + remoteAddress
				+ ", playerQues=" + playerQues + ", addressVerified="
				+ addressVerified + ", emailVerified=" + emailVerified
				+ ", phoneVerified=" + phoneVerified + ", ageVerified="
				+ ageVerified + ", status=" + status + ", playerPassword="
				+ playerPassword + ", secQuesId=" + secQuesId + ", secAns="
				+ secAns + ", title=" + title + ", phoneNum=" + phoneNum
				+ ", dateOfBirth=" + dateOfBirth + ", country=" + country
				+ ", stateCode=" + stateCode + ", state=" + state
				+ ", promoOpt=" + promoOpt + ", commPromo=" + commPromo
				+ ", commSupport=" + commSupport + ", commTechnical="
				+ commTechnical + ", commNews=" + commNews + ", referenceId="
				+ referenceId + ", ppVersion=" + ppVersion + ", tcVersion="
				+ tcVersion + ", password=" + password + ", currencyId="
				+ currencyId + ", panCardFileName=" + panCardFileName
				+ ", taxationIdVerified=" + taxationIdVerified + ", panCard="
				+ Arrays.toString(panCard) + ", affiliateBind=" + affiliateBind
				+ ", affiliateId=" + affiliateId + ", affiliateReference="
				+ affiliateReference + ", unreadCount=" + unreadCount
				+ ", sessionId=" + sessionId + ", device=" + device
				+ ", regDevice=" + regDevice + ", stateId=" + stateId
				+ ", deviceType=" + deviceType + ", lastBonusType="
				+ lastBonusType + ", userAgent=" + userAgent
				+ ", loginAliasId=" + loginAliasId + ", rakeAmt=" + rakeAmt
				+ ", betAmt=" + betAmt + ", displayTab=" + displayTab
				+ ", displaySubTab=" + displaySubTab + ", plrStatus="
				+ plrStatus + ", isPlay2X=" + isPlay2X + "]";
	}

	
}
