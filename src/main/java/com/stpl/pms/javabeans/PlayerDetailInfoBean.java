package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stpl.pms.hibernate.mapping.StPmPlayerInboxMaster;
import com.stpl.pms.hibernate.mapping.StTxnPlrDepositMaster;
import com.stpl.pms.hibernate.mapping.StTxnPlrWalletMaster;
import com.stpl.pms.hibernate.mapping.StTxnPlrWithdrawalMaster;
import com.stpl.pms.hibernate.mapping.StVipCriteriaCurrentStatusDeposit;
import com.stpl.pms.hibernate.mapping.StVipCriteriaCurrentStatusLogin;
import com.stpl.pms.hibernate.mapping.StVipCriteriaCurrentStatusWagerRummy;
import com.stpl.pms.hibernate.mapping.StVipCriteriaCurrentStatusWithdrawal;

public class PlayerDetailInfoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private long playerId;
	private short domainId;
	private Integer countryId;
	private Integer stateId;
	private String gender;
	private String firstName;
	private String lastName;
	private String emailId;
	private String userName;
	private String addressLine1;
	private String city;
	private String postalCode;
	private String state;
	private String houseNum;
	private String addressLine2;
	private int vipLevel;
	private String language;
	private Integer languageId;
	private Long mobileNo;
	private String emailVerified;
	private String phoneVerified;
	private Timestamp lastLoginDate;
	private String duplicationCheckReq;
	private String taxationIdVerified;
	private String ageVerifed;
	private Timestamp transactionDate;
	private String particular;
	private String txnType;
	private String title;
	private Double creditAmount;
	private Double debitAmount;
	private Double balance;
	private Double openingBalance;
	private Date dob;
	private String country;
	private String regIp;
	private String lastLoginIp;
	private String regState;
	private String regCountry;
	private String lastLoginState;
	private String lastLoginCountry;
	private Double preBalance;
	private Double totBal;
	private Double bonBal;
	private String addressVerified;
	private Double cashBal;
	private String profileStatus;
	private String regStatus;
	private String reason;
	private Timestamp registrationDate;
	private String registrationState;
	private String affiliateSource;
	private ArrayList plrTxnBean;
	private List<StPmPlayerLoginDetailsBean> plrLoginBean;
	private List<StTxnPlrDepositMaster> plrDepositBean;
	private List<StTxnPlrWithdrawalMaster> plrWithdrawalBean;
	private ArrayList plrBonusDetails;
	private StVipCriteriaCurrentStatusLogin plrVipLogin;
	private StVipCriteriaCurrentStatusWithdrawal plrVipWithdrawal; 
	private StVipCriteriaCurrentStatusDeposit plrVipDeposit; 
	private StVipCriteriaCurrentStatusWagerRummy plrVipWagerRummy; 
	private List<StPmPlayerInboxMaster> plrInboxTemp;
	private StTxnPlrWalletMaster plrWalletBean;
	private String browser;
	private String os;
	private String device;
	private String appVersion;
	private String commPromo;
	
	
	public Double getTotBal() {
		return totBal;
	}
	public void setTotBal(Double totBal) {
		this.totBal = totBal;
	}
	public Double getBonBal() {
		return bonBal;
	}
	public void setBonBal(Double bonBal) {
		this.bonBal = bonBal;
	}
	public StVipCriteriaCurrentStatusLogin getPlrVipLogin() {
		return plrVipLogin;
	}
	public void setPlrVipLogin(StVipCriteriaCurrentStatusLogin plrVipLogin) {
		this.plrVipLogin = plrVipLogin;
	}
	public StVipCriteriaCurrentStatusWithdrawal getPlrVipWithdrawal() {
		return plrVipWithdrawal;
	}
	public void setPlrVipWithdrawal(
			StVipCriteriaCurrentStatusWithdrawal plrVipWithdrawal) {
		this.plrVipWithdrawal = plrVipWithdrawal;
	}
	public StVipCriteriaCurrentStatusDeposit getPlrVipDeposit() {
		return plrVipDeposit;
	}
	public void setPlrVipDeposit(StVipCriteriaCurrentStatusDeposit plrVipDeposit) {
		this.plrVipDeposit = plrVipDeposit;
	}
	public StVipCriteriaCurrentStatusWagerRummy getPlrVipWagerRummy() {
		return plrVipWagerRummy;
	}
	public void setPlrVipWagerRummy(
			StVipCriteriaCurrentStatusWagerRummy plrVipWagerRummy) {
		this.plrVipWagerRummy = plrVipWagerRummy;
	}
	@SuppressWarnings("unchecked")
	public ArrayList getPlrBonusDetails() {
		return plrBonusDetails;
	}
	@SuppressWarnings("unchecked")
	public void setPlrBonusDetails(ArrayList plrBonusDetails) {
		this.plrBonusDetails = plrBonusDetails;
	}
	public List<StTxnPlrDepositMaster> getPlrDepositBean() {
		return plrDepositBean;
	}
	public void setPlrDepositBean(List<StTxnPlrDepositMaster> plrDepositBean) {
		this.plrDepositBean = plrDepositBean;
	}
	public List<StTxnPlrWithdrawalMaster> getPlrWithdrawalBean() {
		return plrWithdrawalBean;
	}
	public void setPlrWithdrawalBean(
			List<StTxnPlrWithdrawalMaster> plrWithdrawalBean) {
		this.plrWithdrawalBean = plrWithdrawalBean;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAgeVerifed() {
		return ageVerifed;
	}
	public void setAgeVerifed(String ageVerifed) {
		this.ageVerifed = ageVerifed;
	}
	public Double getPreBalance() {
		return preBalance;
	}
	public void setPreBalance(Double preBalance) {
		this.preBalance = preBalance;
	}
	public String getRegState() {
		return regState;
	}
	public void setRegState(String regState) {
		this.regState = regState;
	}
	public String getRegCountry() {
		return regCountry;
	}
	public void setRegCountry(String regCountry) {
		this.regCountry = regCountry;
	}
	public String getLastLoginState() {
		return lastLoginState;
	}
	public void setLastLoginState(String lastLoginState) {
		this.lastLoginState = lastLoginState;
	}
	public String getLastLoginCountry() {
		return lastLoginCountry;
	}
	public void setLastLoginCountry(String lastLoginCountry) {
		this.lastLoginCountry = lastLoginCountry;
	}
	public String getRegIp() {
		return regIp;
	}
	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	@SuppressWarnings("unchecked")
	public ArrayList getPlrTxnBean() {
		return plrTxnBean;
	}
	@SuppressWarnings("unchecked")
	public void setPlrTxnBean(ArrayList plrTxnBean) {
		this.plrTxnBean = plrTxnBean;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public Double getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}
	public Double getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
	public short getDomainId() {
		return domainId;
	}
	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}
	/*public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}*/
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public int getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
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
	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getDuplicationCheckReq() {
		return duplicationCheckReq;
	}
	public void setDuplicationCheckReq(String duplicationCheckReq) {
		this.duplicationCheckReq = duplicationCheckReq;
	}
	public String getTaxationIdVerified() {
		return taxationIdVerified;
	}
	public void setTaxationIdVerified(String taxationIdVerified) {
		this.taxationIdVerified = taxationIdVerified;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public List<StPmPlayerLoginDetailsBean> getPlrLoginBean() {
		return plrLoginBean;
	}
	public void setPlrLoginBean(List<StPmPlayerLoginDetailsBean> plrLoginBean) {
		this.plrLoginBean = plrLoginBean;
	}
	
	
	public String getAddressVerified() {
		return addressVerified;
	}
	public void setAddressVerified(String addressVerified) {
		this.addressVerified = addressVerified;
	}
	
	
	public Double getCashBal() {
		return cashBal;
	}
	public void setCashBal(Double cashBal) {
		this.cashBal = cashBal;
	}
	
	
	public String getRegStatus() {
		return regStatus;
	}
	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}
	
	public Timestamp getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	/*public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}*/
	
	public String getAffiliateSource() {
		return affiliateSource;
	}
	public void setAffiliateSource(String affiliateSource) {
		this.affiliateSource = affiliateSource;
	}
	public List<StPmPlayerInboxMaster> getPlrInboxTemp() {
		return plrInboxTemp;
	}
	public void setPlrInboxTemp(List<StPmPlayerInboxMaster> plrInboxTemp) {
		this.plrInboxTemp = plrInboxTemp;
	}
	public StTxnPlrWalletMaster getPlrWalletBean() {
		return plrWalletBean;
	}
	public void setPlrWalletBean(StTxnPlrWalletMaster plrWalletBean) {
		this.plrWalletBean = plrWalletBean;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getRegistrationState() {
		return registrationState;
	}
	public void setRegistrationState(String registrationState) {
		this.registrationState = registrationState;
	}
	public String getProfileStatus() {
		return profileStatus;
	}
	public void setProfileStatus(String profileStatus) {
		this.profileStatus = profileStatus;
	}
	public String getCommPromo() {
		return commPromo;
	}
	public void setCommPromo(String commPromo) {
		this.commPromo = commPromo;
	}
	
	
}
