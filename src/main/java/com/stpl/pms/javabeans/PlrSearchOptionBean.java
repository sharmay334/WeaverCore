package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PlrSearchOptionBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String playerIdList;
	private short domainId;
	private String fname;
	private String lname;
	private String userName;
	private String[] isVerified;
	private Integer[] vipLevel;
	private Integer countryId;
	private Timestamp fromDate;
	private Timestamp toDate;
	private long fromAmount;
	private long toAmount;
	private Timestamp loginFromDate;
	private Timestamp loginToDate;
	private String city;
	private Integer stateId;
	private String[] device;
	private String ActivityTypeId;
	private String email;
	private String mobile;
	private Timestamp fromDob;
	private Timestamp toDob;
	private Timestamp fromRegDate;
	private Timestamp toRegDate;
	private String[] isAffiliated;
	private int preBal;
	private String deposit;
	private String withdraw;
	private List<vipCriteriaListBean> vipCriteriaBean;
	private String plrTaxId;
	private String[] gender;
	private Timestamp fromWagerDate;
	private Timestamp toWagerDate;
	private Timestamp fromWinDate;
	private Timestamp toWinDate;
	private Timestamp fromDepDate;
	private Timestamp toDepDate;
	private Timestamp fromWitDate;
	private Timestamp toWitDate;
	private String minPraBal;
	private String maxPraBal;
	private String minBal;
	private String maxBal;
	private String[] pendBonus;
	private String minBonBal;
	private String maxBonBal;
	private String minTotBal;
	private String maxTotBal;
	private String bonFromCash;
	private String bonToCash;
	private String[] pendBon;
	private String wagerRummy;
	private String minBonRecAmount;
	private String maxBonRecAmount;
	private String minBonExpAmount;
	private String maxBonExpAmount;
	private String maxPenAmount;
	private String minPenAmount;
	private Timestamp fromLoginDate;
	private Timestamp toLoginDate;
	private String[] status;
	private double minBonusAmount;
	private double maxBonusAmount;
	private double minDepositAmount;
	private double maxDepositAmount;
	private double minWagerAmount;
	private double maxWagerAmount;
	private double minWithdrawalAmount;
	private double maxWithdrawalAmount;
	private double minWinningAmount;
	private double maxWinningAmount;
	private double minCashBal;
	private double maxCashBal;
	private Timestamp fromFirstDepositDate;
	private Timestamp toFirstDepositDate;
	private String[] regIp;
	private String[] depositer;
	private String redirect;
	private boolean yearCheck;
	private String uploadedDoc;
	private String docUniqueNum;
	private String referSourceType;
	private long referSource;
	private short aliasId;
	private String[] plrStatus; 
	
	private String firstDepositReferSource;
	private Long firstDepositReferSourceId;
	
	public String getMinTotBal() {
		return minTotBal;
	}
	public void setMinTotBal(String minTotBal) {
		this.minTotBal = minTotBal;
	}
	public String getMaxTotBal() {
		return maxTotBal;
	}
	public void setMaxTotBal(String maxTotBal) {
		this.maxTotBal = maxTotBal;
	}
	public String getMinBonRecAmount() {
		return minBonRecAmount;
	}
	public void setMinBonRecAmount(String minBonRecAmount) {
		this.minBonRecAmount = minBonRecAmount;
	}
	public String getMaxBonRecAmount() {
		return maxBonRecAmount;
	}
	public void setMaxBonRecAmount(String maxBonRecAmount) {
		this.maxBonRecAmount = maxBonRecAmount;
	}
	public String getMinBonExpAmount() {
		return minBonExpAmount;
	}
	public void setMinBonExpAmount(String minBonExpAmount) {
		this.minBonExpAmount = minBonExpAmount;
	}
	public String getMaxBonExpAmount() {
		return maxBonExpAmount;
	}
	public void setMaxBonExpAmount(String maxBonExpAmount) {
		this.maxBonExpAmount = maxBonExpAmount;
	}
	public String getMaxPenAmount() {
		return maxPenAmount;
	}
	public void setMaxPenAmount(String maxPenAmount) {
		this.maxPenAmount = maxPenAmount;
	}
	public String getMinPenAmount() {
		return minPenAmount;
	}
	public void setMinPenAmount(String minPenAmount) {
		this.minPenAmount = minPenAmount;
	}
	
	public short getDomainId() {
		return domainId;
	}
	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String[] getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(String[] isVerified) {
		this.isVerified = isVerified;
	}
	public Integer[] getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(Integer[] vipLevel) {
		this.vipLevel = vipLevel;
	}
	
	/*public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}*/
	public Timestamp getFromDate() {
		return fromDate;
	}
	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}
	public Timestamp getToDate() {
		return toDate;
	}
	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}
	public long getFromAmount() {
		return fromAmount;
	}
	public void setFromAmount(long fromAmount) {
		this.fromAmount = fromAmount;
	}
	public long getToAmount() {
		return toAmount;
	}
	public void setToAmount(long toAmount) {
		this.toAmount = toAmount;
	}
	public Timestamp getLoginFromDate() {
		return loginFromDate;
	}
	public void setLoginFromDate(Timestamp loginFromDate) {
		this.loginFromDate = loginFromDate;
	}
	public Timestamp getLoginToDate() {
		return loginToDate;
	}
	public void setLoginToDate(Timestamp loginToDate) {
		this.loginToDate = loginToDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	/*public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}*/
	public String[] getDevice() {
		return device;
	}
	public void setDevice(String[] device) {
		this.device = device;
	}
	public String getActivityTypeId() {
		return ActivityTypeId;
	}
	public void setActivityTypeId(String activityTypeId) {
		ActivityTypeId = activityTypeId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Timestamp getFromDob() {
		return fromDob;
	}
	public void setFromDob(Timestamp fromDob) {
		this.fromDob = fromDob;
	}
	public Timestamp getToDob() {
		return toDob;
	}
	public void setToDob(Timestamp toDob) {
		this.toDob = toDob;
	}
	public Timestamp getFromRegDate() {
		return fromRegDate;
	}
	public void setFromRegDate(Timestamp fromRegDate) {
		this.fromRegDate = fromRegDate;
	}
	public Timestamp getToRegDate() {
		return toRegDate;
	}
	public void setToRegDate(Timestamp toRegDate) {
		this.toRegDate = toRegDate;
	}
	public String[] getIsAffiliated() {
		return isAffiliated;
	}
	public void setIsAffiliated(String[] isAffiliated) {
		this.isAffiliated = isAffiliated;
	}
	public int getPreBal() {
		return preBal;
	}
	public void setPreBal(int preBal) {
		this.preBal = preBal;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(String withdraw) {
		this.withdraw = withdraw;
	}
	public List<vipCriteriaListBean> getVipCriteriaBean() {
		return vipCriteriaBean;
	}
	public void setVipCriteriaBean(String vipCriteriaBean) {
		Type type = new TypeToken<List<vipCriteriaListBean>>() {
		}.getType();
		this.vipCriteriaBean = new Gson().fromJson(vipCriteriaBean, type);
	}
	public String getPlrTaxId() {
		return plrTaxId;
	}
	public void setPlrTaxId(String plrTaxId) {
		this.plrTaxId = plrTaxId;
	}
	public String[] getGender() {
		return gender;
	}
	public void setGender(String[] gender) {
		this.gender = gender;
	}
	public Timestamp getFromWagerDate() {
		return fromWagerDate;
	}
	public void setFromWagerDate(Timestamp fromWagerDate) {
		this.fromWagerDate = fromWagerDate;
	}
	public Timestamp getToWagerDate() {
		return toWagerDate;
	}
	public void setToWagerDate(Timestamp toWagerDate) {
		this.toWagerDate = toWagerDate;
	}
	public Timestamp getFromWinDate() {
		return fromWinDate;
	}
	public void setFromWinDate(Timestamp fromWinDate) {
		this.fromWinDate = fromWinDate;
	}
	public Timestamp getToWinDate() {
		return toWinDate;
	}
	public void setToWinDate(Timestamp toWinDate) {
		this.toWinDate = toWinDate;
	}
	public Timestamp getFromDepDate() {
		return fromDepDate;
	}
	public void setFromDepDate(Timestamp fromDepDate) {
		this.fromDepDate = fromDepDate;
	}
	public Timestamp getToDepDate() {
		return toDepDate;
	}
	public void setToDepDate(Timestamp toDepDate) {
		this.toDepDate = toDepDate;
	}
	public Timestamp getFromWitDate() {
		return fromWitDate;
	}
	public void setFromWitDate(Timestamp fromWitDate) {
		this.fromWitDate = fromWitDate;
	}
	public Timestamp getToWitDate() {
		return toWitDate;
	}
	public void setToWitDate(Timestamp toWitDate) {
		this.toWitDate = toWitDate;
	}
	public String getMinPraBal() {
		return minPraBal;
	}
	public void setMinPraBal(String minPraBal) {
		this.minPraBal = minPraBal;
	}
	public String getMaxPraBal() {
		return maxPraBal;
	}
	public void setMaxPraBal(String maxPraBal) {
		this.maxPraBal = maxPraBal;
	}
	public String getMinBal() {
		return minBal;
	}
	public void setMinBal(String minBal) {
		this.minBal = minBal;
	}
	public String getMaxBal() {
		return maxBal;
	}
	public void setMaxBal(String maxBal) {
		this.maxBal = maxBal;
	}
	public String[] getPendBonus() {
		return pendBonus;
	}
	public void setPendBonus(String[] pendBonus) {
		this.pendBonus = pendBonus;
	}
	public String getMinBonBal() {
		return minBonBal;
	}
	public void setMinBonBal(String minBonBal) {
		this.minBonBal = minBonBal;
	}
	public String getMaxBonBal() {
		return maxBonBal;
	}
	public void setMaxBonBal(String maxBonBal) {
		this.maxBonBal = maxBonBal;
	}
	public String getBonFromCash() {
		return bonFromCash;
	}
	public void setBonFromCash(String bonFromCash) {
		this.bonFromCash = bonFromCash;
	}
	public String getBonToCash() {
		return bonToCash;
	}
	public void setBonToCash(String bonToCash) {
		this.bonToCash = bonToCash;
	}
	public String[] getPendBon() {
		return pendBon;
	}
	public void setPendBon(String[] pendBon) {
		this.pendBon = pendBon;
	}
	public String getWagerRummy() {
		return wagerRummy;
	}
	public void setWagerRummy(String wagerRummy) {
		this.wagerRummy = wagerRummy;
	}
	
	public Timestamp getFromLoginDate() {
		return fromLoginDate;
	}
	public void setFromLoginDate(Timestamp fromLoginDate) {
		this.fromLoginDate = fromLoginDate;
	}
	public Timestamp getToLoginDate() {
		return toLoginDate;
	}
	public void setToLoginDate(Timestamp toLoginDate) {
		this.toLoginDate = toLoginDate;
	}
	
	public String[] getStatus() {
		return status;
	}
	public void setStatus(String[] status) {
		this.status = status;
	}
	
	public double getMinBonusAmount() {
		return minBonusAmount;
	}
	public void setMinBonusAmount(double minBonusAmount) {
		this.minBonusAmount = minBonusAmount;
	}
	public double getMaxBonusAmount() {
		return maxBonusAmount;
	}
	public void setMaxBonusAmount(double maxBonusAmount) {
		this.maxBonusAmount = maxBonusAmount;
	}
	public double getMinDepositAmount() {
		return minDepositAmount;
	}
	public void setMinDepositAmount(double minDepositAmount) {
		this.minDepositAmount = minDepositAmount;
	}
	public double getMaxDepositAmount() {
		return maxDepositAmount;
	}
	public void setMaxDepositAmount(double maxDepositAmount) {
		this.maxDepositAmount = maxDepositAmount;
	}
	public double getMinWagerAmount() {
		return minWagerAmount;
	}
	public void setMinWagerAmount(double minWagerAmount) {
		this.minWagerAmount = minWagerAmount;
	}
	public double getMaxWagerAmount() {
		return maxWagerAmount;
	}
	public void setMaxWagerAmount(double maxWagerAmount) {
		this.maxWagerAmount = maxWagerAmount;
	}
	public double getMinWithdrawalAmount() {
		return minWithdrawalAmount;
	}
	public void setMinWithdrawalAmount(double minWithdrawalAmount) {
		this.minWithdrawalAmount = minWithdrawalAmount;
	}
	public double getMaxWithdrawalAmount() {
		return maxWithdrawalAmount;
	}
	public void setMaxWithdrawalAmount(double maxWithdrawalAmount) {
		this.maxWithdrawalAmount = maxWithdrawalAmount;
	}
	public double getMinWinningAmount() {
		return minWinningAmount;
	}
	public void setMinWinningAmount(double minWinningAmount) {
		this.minWinningAmount = minWinningAmount;
	}
	public double getMaxWinningAmount() {
		return maxWinningAmount;
	}
	public void setMaxWinningAmount(double maxWinningAmount) {
		this.maxWinningAmount = maxWinningAmount;
	}
	
	public double getMinCashBal() {
		return minCashBal;
	}
	public void setMinCashBal(double minCashBal) {
		this.minCashBal = minCashBal;
	}
	public double getMaxCashBal() {
		return maxCashBal;
	}
	public void setMaxCashBal(double maxCashBal) {
		this.maxCashBal = maxCashBal;
	}
	
	public Timestamp getFromFirstDepositDate() {
		return fromFirstDepositDate;
	}
	public void setFromFirstDepositDate(Timestamp fromFirstDepositDate) {
		this.fromFirstDepositDate = fromFirstDepositDate;
	}
	public Timestamp getToFirstDepositDate() {
		return toFirstDepositDate;
	}
	public void setToFirstDepositDate(Timestamp toFirstDepositDate) {
		this.toFirstDepositDate = toFirstDepositDate;
	}
	public String[] getRegIp() {
		return regIp;
	}
	public void setRegIp(String[] regIp) {
		this.regIp = regIp;
	}
	public String[] getDepositer() {
		return depositer;
	}
	public void setDepositer(String[] depositer) {
		this.depositer = depositer;
	}
	public String getRedirect() {
		return redirect;
	}
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	public boolean getYearCheck() {
		return yearCheck;
	}
	public void setYearCheck(boolean yearCheck) {
		this.yearCheck = yearCheck;
	}
	public String getUploadedDoc() {
		return uploadedDoc;
	}
	public void setUploadedDoc(String uploadedDoc) {
		this.uploadedDoc = uploadedDoc;
	}
	public String getDocUniqueNum() {
		return docUniqueNum;
	}
	public void setDocUniqueNum(String docUniqueNum) {
		this.docUniqueNum = docUniqueNum;
	}
	public String getReferSourceType() {
		return referSourceType;
	}
	public void setReferSourceType(String referSourceType) {
		this.referSourceType = referSourceType;
	}
	public long getReferSource() {
		return referSource;
	}
	public void setReferSource(long referSource) {
		this.referSource = referSource;
	}
	@Override
	public String toString() {
		return "PlrSearchOptionBean [ActivityTypeId=" + ActivityTypeId
				+ ", bonFromCash=" + bonFromCash + ", bonToCash=" + bonToCash
				+ ", city=" + city + ", countryId=" + countryId + ", deposit="
				+ deposit + ", device=" +  Arrays.toString(device) + ", domainId=" + domainId
				+ ", email=" + email + ", fname=" + fname + ", fromAmount="
				+ fromAmount + ", fromDate=" + fromDate + ", fromDepDate="
				+ fromDepDate + ", fromDob=" + fromDob + ", fromLoginDate="
				+ fromLoginDate + ", fromRegDate=" + fromRegDate
				+ ", fromWagerDate=" + fromWagerDate + ", fromWinDate="
				+ fromWinDate + ", fromWitDate=" + fromWitDate + ", gender="
				+ Arrays.toString(gender) + ", isAffiliated="
				+ Arrays.toString(isAffiliated) + ", isVerified="
				+ Arrays.toString(isVerified) + ", lname=" + lname
				+ ", loginFromDate=" + loginFromDate + ", loginToDate="
				+ loginToDate + ", maxBal=" + maxBal + ", maxBonBal="
				+ maxBonBal + ", maxBonExpAmount=" + maxBonExpAmount
				+ ", maxBonRecAmount=" + maxBonRecAmount + ", maxBonusAmount="
				+ maxBonusAmount + ", maxDepositAmount=" + maxDepositAmount
				+ ", maxPenAmount=" + maxPenAmount + ", maxPraBal=" + maxPraBal
				+ ", maxTotBal=" + maxTotBal + ", maxWagerAmount="
				+ maxWagerAmount + ", maxWinningAmount=" + maxWinningAmount
				+ ", maxWithdrawalAmount=" + maxWithdrawalAmount + ", minBal="
				+ minBal + ", minBonBal=" + minBonBal + ", minBonExpAmount="
				+ minBonExpAmount + ", minBonRecAmount=" + minBonRecAmount
				+ ", minBonusAmount=" + minBonusAmount + ", minDepositAmount="
				+ minDepositAmount + ", minPenAmount=" + minPenAmount
				+ ", minPraBal=" + minPraBal + ", minTotBal=" + minTotBal
				+ ", minWagerAmount=" + minWagerAmount + ", minWinningAmount="
				+ minWinningAmount + ", minWithdrawalAmount="
				+ minWithdrawalAmount + ", mobile=" + mobile + ", pendBon="
				+ Arrays.toString(pendBon) + ", pendBonus="
				+ Arrays.toString(pendBonus) + ", plrTaxId=" + plrTaxId
				+ ", preBal=" + preBal + ", stateId=" + stateId + ", status="
				+ Arrays.toString(status) + ", toAmount=" + toAmount
				+ ", toDate=" + toDate + ", toDepDate=" + toDepDate
				+ ", toDob=" + toDob + ", toLoginDate=" + toLoginDate
				+ ", toRegDate=" + toRegDate + ", toWagerDate=" + toWagerDate
				+ ", toWinDate=" + toWinDate + ", toWitDate=" + toWitDate
				+ ", userName=" + userName + ", vipCriteriaBean="
				+ vipCriteriaBean + ", vipLevel=" + Arrays.toString(vipLevel)
				+ ", wagerRummy=" + wagerRummy + ", withdraw=" + withdraw + ", playerIdList=" + playerIdList + "]";
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
	public String getPlayerIdList() {
		return playerIdList;
	}
	public void setPlayerIdList(String playerIdList) {
		this.playerIdList = playerIdList;
	}
	public short getAliasId() {
		return aliasId;
	}
	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
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
	public String[] getPlrStatus() {
		return plrStatus;
	}
	public void setPlrStatus(String[] plrStatus) {
		this.plrStatus = plrStatus;
	}

	
}
