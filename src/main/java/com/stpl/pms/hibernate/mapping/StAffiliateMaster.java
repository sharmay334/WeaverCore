package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * StAffiliateMaster entity. @author MyEclipse Persistence Tools
 */

public class StAffiliateMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer affiliateId;
	private Timestamp registrationDate;
	private Timestamp lastLoginDate;
	private String autoPassword;
	private Short domainId;
	private String userName;
	private String password;
	private String status;
	private String secQues;
	private String secAns;
	private Double realBalance;
	private String paymentMode;
	private Double withdrawalAmount;
	private Integer affiliateCode;
	private String affiliateType;
	@SuppressWarnings("unchecked")
	private Set stAffiliatePasswordHistories = new HashSet(0);
	@SuppressWarnings("unchecked")
	private Set stAffiliateInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public StAffiliateMaster() {
	}

	/** minimal constructor */
	public StAffiliateMaster(Timestamp registrationDate,
			Timestamp lastLoginDate, String autoPassword, String userName,
			String password, String status, String secQues, String secAns,
			Double realBalance, Double withdrawalAmount, String affiliateType) {
		this.registrationDate = registrationDate;
		this.lastLoginDate = lastLoginDate;
		this.autoPassword = autoPassword;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.secQues = secQues;
		this.secAns = secAns;
		this.realBalance = realBalance;
		this.withdrawalAmount = withdrawalAmount;
		this.affiliateType = affiliateType;
	}

	/** full constructor */
	@SuppressWarnings("unchecked")
	public StAffiliateMaster(Timestamp registrationDate,
			Timestamp lastLoginDate, String autoPassword, String userName,
			String password, String status, String secQues, String secAns,
			Double realBalance, String paymentMode, Double withdrawalAmount,
			Integer affiliateCode, String affiliateType,
			Set stAffiliatePasswordHistories, Set stAffiliateInfos) {
		this.registrationDate = registrationDate;
		this.lastLoginDate = lastLoginDate;
		this.autoPassword = autoPassword;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.secQues = secQues;
		this.secAns = secAns;
		this.realBalance = realBalance;
		this.paymentMode = paymentMode;
		this.withdrawalAmount = withdrawalAmount;
		this.affiliateCode = affiliateCode;
		this.affiliateType = affiliateType;
		this.stAffiliatePasswordHistories = stAffiliatePasswordHistories;
		this.stAffiliateInfos = stAffiliateInfos;
	}

	
	
	public StAffiliateMaster(Integer affiliateId) {
		super();
		this.affiliateId = affiliateId;
	}

	// Property accessors

	

	public Integer getAffiliateId() {
		return this.affiliateId;
	}

	public void setAffiliateId(Integer affiliateId) {
		this.affiliateId = affiliateId;
	}

	public Timestamp getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Timestamp getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
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

	public String getSecQues() {
		return this.secQues;
	}

	public void setSecQues(String secQues) {
		this.secQues = secQues;
	}

	public String getSecAns() {
		return this.secAns;
	}

	public void setSecAns(String secAns) {
		this.secAns = secAns;
	}

	public Double getRealBalance() {
		return this.realBalance;
	}

	public void setRealBalance(Double realBalance) {
		this.realBalance = realBalance;
	}

	public String getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Double getWithdrawalAmount() {
		return this.withdrawalAmount;
	}

	public void setWithdrawalAmount(Double withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	public Integer getAffiliateCode() {
		return this.affiliateCode;
	}

	public void setAffiliateCode(Integer affiliateCode) {
		this.affiliateCode = affiliateCode;
	}

	public String getAffiliateType() {
		return this.affiliateType;
	}

	public void setAffiliateType(String affiliateType) {
		this.affiliateType = affiliateType;
	}

	@SuppressWarnings("unchecked")
	public Set getStAffiliatePasswordHistories() {
		return this.stAffiliatePasswordHistories;
	}

	@SuppressWarnings("unchecked")
	public void setStAffiliatePasswordHistories(Set stAffiliatePasswordHistories) {
		this.stAffiliatePasswordHistories = stAffiliatePasswordHistories;
	}

	@SuppressWarnings("unchecked")
	public Set getStAffiliateInfos() {
		return this.stAffiliateInfos;
	}

	@SuppressWarnings("unchecked")
	public void setStAffiliateInfos(Set stAffiliateInfos) {
		this.stAffiliateInfos = stAffiliateInfos;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Short getDomainId() {
		return domainId;
	}

}