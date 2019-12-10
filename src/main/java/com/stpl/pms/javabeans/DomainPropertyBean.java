package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stpl.pms.hibernate.mapping.StCmsTemplateMaster;

public class DomainPropertyBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Short domainId;
	private String domainName;
	private String domainOwner;
	private String address;
	private String countryCode;
	private String stateCode;
	private String contactPersonName;
	private Long ownerContactNo;

	private String registrationType;
	private String registrationMode;
	private Integer passwordPolicyId;
	private String loginThroughEmail;
	private String loginThroughUsername;
	private String loginThroughMobileNo;
	private String loginThroughFconnect;
	private String allowedfeatureBlockedCountry;
	private String plrPassword;
	private String sendPassword;
	private String verificationThrough;
	private String firstVerification;

	private List<Integer> currency;
	private int currencyId;
	private String paymentOptionCurrency;
	private String tdsOn;
	private String bonusUsageOrder;
	private String plrVisibleWallet;
	private Double wdrApprovalLimit;
	private String depActionPendingWdr;
	private String bonusWrCarryFwd;
	private Double bonusExipryLimit;

	private int languageId;
	private String languageCode;
	private List<Integer> language;
	private String layoutPc;
	private List<String> pcDomainAlias;
	private String layoutMobile;
	private List<String> mobileDomainAlias;
	private String layoutTab;
	private List<String> tabDomainAlias;

	private Short serviceId;
	private String gameTryBeforeLogin;
	private String playerLedgerFormat;

	private String domainLogo;
	private String domainLogoFileName;

	private String registrationPage;
	private String termCondition;
	private String privacyPolicy;
	private String securityQuesList;
	private String blockedIp;
	private String blockedEmail;
	private String blockedPhone;
	private String referralList;
	private String gameMapping;
	private String paymentOption;
	private String rolePreference;
	private String merchantProviderAccount;

	private String homePagePath;

	private String passwordPolicy;
	private String duplicateLogic;
	private String allowedCountries;
	private String allowedStates;
	private Map<String, LanguageBean> allowedLanguage;
	private String allowedCurrency;

	private String domainStatus;
	private String userImage;

	private String emailId;
	private String footer;
	private String vipLevel;
	private String menuList;
	private String contentList;
	private Integer defaultVipLevel;
	private String urlList;
	private Map<String, StCmsTemplateMaster> templeteUrlMap;
	private String passwordExpression;
	private String passwordHelpString;
	private String passwordStrengthCheck;
	private String template;
	private Short verificationSourceId;
	private String tpAutoVerification;
	private Short allowedInvaildLoginTry;
	private Short playerPasswordHistoryCount;
	private String rgOperatorLimit;
	private String checkRg;

	public String getFirstVerification() {
		return firstVerification;
	}

	public String getMenuList() {
		return menuList;
	}

	public void setMenuList(String menuList) {
		this.menuList = menuList;
	}

	public String getContentList() {
		return contentList;
	}

	public void setContentList(String contentList) {
		this.contentList = contentList;
	}

	public void setFirstVerification(String firstVerification) {
		this.firstVerification = firstVerification;
	}

	public String getAllowedfeatureBlockedCountry() {
		return allowedfeatureBlockedCountry;
	}

	public void setAllowedfeatureBlockedCountry(
			String allowedfeatureBlockedCountry) {
		this.allowedfeatureBlockedCountry = allowedfeatureBlockedCountry;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getLoginThroughEmail() {
		return loginThroughEmail;
	}

	public void setLoginThroughEmail(String loginThroughEmail) {
		this.loginThroughEmail = loginThroughEmail;
	}

	public String getLoginThroughUsername() {
		return loginThroughUsername;
	}

	public void setLoginThroughUsername(String loginThroughUsername) {
		this.loginThroughUsername = loginThroughUsername;
	}

	public String getLoginThroughMobileNo() {
		return loginThroughMobileNo;
	}

	public void setLoginThroughMobileNo(String loginThroughMobileNo) {
		this.loginThroughMobileNo = loginThroughMobileNo;
	}

	public String getLoginThroughFconnect() {
		return loginThroughFconnect;
	}

	public void setLoginThroughFconnect(String loginThroughFconnect) {
		this.loginThroughFconnect = loginThroughFconnect;
	}

	public String getGameTryBeforeLogin() {
		return gameTryBeforeLogin;
	}

	public void setGameTryBeforeLogin(String gameTryBeforeLogin) {
		this.gameTryBeforeLogin = gameTryBeforeLogin;
	}

	public String getRegistrationPage() {
		return registrationPage;
	}

	public void setRegistrationPage(String registrationPage) {
		this.registrationPage = registrationPage;
	}

	public String getTermCondition() {
		return termCondition;
	}

	public void setTermCondition(String termCondition) {
		this.termCondition = termCondition;
	}

	public String getPrivacyPolicy() {
		return privacyPolicy;
	}

	public void setPrivacyPolicy(String privacyPolicy) {
		this.privacyPolicy = privacyPolicy;
	}

	public String getSecurityQuesList() {
		return securityQuesList;
	}

	public void setSecurityQuesList(String securityQuesList) {
		this.securityQuesList = securityQuesList;
	}

	public String getReferralList() {
		return referralList;
	}

	public void setReferralList(String referralList) {
		this.referralList = referralList;
	}

	public String getGameMapping() {
		return gameMapping;
	}

	public void setGameMapping(String gameMapping) {
		this.gameMapping = gameMapping;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public String getRolePreference() {
		return rolePreference;
	}

	public void setRolePreference(String rolePreference) {
		this.rolePreference = rolePreference;
	}

	public String getMerchantProviderAccount() {
		return merchantProviderAccount;
	}

	public void setMerchantProviderAccount(String merchantProviderAccount) {
		this.merchantProviderAccount = merchantProviderAccount;
	}

	public String getPaymentOptionCurrency() {
		return paymentOptionCurrency;
	}

	public void setPaymentOptionCurrency(String paymentOptionCurrency) {
		this.paymentOptionCurrency = paymentOptionCurrency;
	}

	public String getBonusUsageOrder() {
		return bonusUsageOrder;
	}

	public void setBonusUsageOrder(String bonusUsageOrder) {
		this.bonusUsageOrder = bonusUsageOrder;
	}

	public String getTdsOn() {
		return tdsOn;
	}

	public void setTdsOn(String tdsOn) {
		this.tdsOn = tdsOn;
	}

	public String getHomePagePath() {
		return homePagePath;
	}

	public void setHomePagePath(String homePagePath) {
		this.homePagePath = homePagePath;
	}

	public Short getDomainId() {
		return domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public String getRegistrationMode() {
		return registrationMode;
	}

	public void setRegistrationMode(String registrationMode) {
		this.registrationMode = registrationMode;
	}

	public Integer getPasswordPolicyId() {
		return passwordPolicyId;
	}

	public void setPasswordPolicyId(Integer passwordPolicyId) {
		this.passwordPolicyId = passwordPolicyId;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public List<Integer> getLanguage() {
		if (language == null) {
			language = new ArrayList<Integer>();
		}
		return language;
	}

	public void setLanguage(List<Integer> language) {
		this.language = language;
	}

	public Short getServiceId() {
		return serviceId;
	}

	public void setServiceId(Short serviceId) {
		this.serviceId = serviceId;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getLayoutPc() {
		return layoutPc;
	}

	public void setLayoutPc(String layoutPc) {
		this.layoutPc = layoutPc;
	}

	public String getLayoutMobile() {
		return layoutMobile;
	}

	public void setLayoutMobile(String layoutMobile) {
		this.layoutMobile = layoutMobile;
	}

	public String getLayoutTab() {
		return layoutTab;
	}

	public void setLayoutTab(String layoutTab) {
		this.layoutTab = layoutTab;
	}

	public String getPasswordPolicy() {
		return passwordPolicy;
	}

	public void setPasswordPolicy(String passwordPolicy) {
		this.passwordPolicy = passwordPolicy;
	}

	public String getDuplicateLogic() {
		return duplicateLogic;
	}

	public void setDuplicateLogic(String duplicateLogic) {
		this.duplicateLogic = duplicateLogic;
	}

	public List<Integer> getCurrency() {
		if (currency == null) {
			currency = new ArrayList<Integer>();
		}
		return currency;
	}

	public void setCurrency(List<Integer> currency) {
		this.currency = currency;
	}

	public String getAllowedCountries() {
		return allowedCountries;
	}

	public void setAllowedCountries(String allowedCountries) {
		this.allowedCountries = allowedCountries;
	}

	public String getAllowedStates() {
		return allowedStates;
	}

	public void setAllowedStates(String allowedStates) {
		this.allowedStates = allowedStates;
	}

	public Map<String, LanguageBean> getAllowedLanguage() {
		return allowedLanguage;
	}

	public void setAllowedLanguage(Map<String, LanguageBean> allowedLanguage) {
		this.allowedLanguage = allowedLanguage;
	}

	public String getAllowedCurrency() {
		return allowedCurrency;
	}

	public void setAllowedCurrency(String allowedCurrency) {
		this.allowedCurrency = allowedCurrency;
	}

	public String getPlrVisibleWallet() {
		return plrVisibleWallet;
	}

	public void setPlrVisibleWallet(String plrVisibleWallet) {
		this.plrVisibleWallet = plrVisibleWallet;
	}

	public String getDomainStatus() {
		return domainStatus;
	}

	public void setDomainStatus(String domainStatus) {
		this.domainStatus = domainStatus;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSendPassword() {
		return sendPassword;
	}

	public void setSendPassword(String sendPassword) {
		this.sendPassword = sendPassword;
	}

	public String getPlrPassword() {
		return plrPassword;
	}

	public void setPlrPassword(String plrPassword) {
		this.plrPassword = plrPassword;
	}

	public Double getWdrApprovalLimit() {
		return wdrApprovalLimit;
	}

	public void setWdrApprovalLimit(Double wdrApprovalLimit) {
		this.wdrApprovalLimit = wdrApprovalLimit;
	}

	public String getDepActionPendingWdr() {
		return depActionPendingWdr;
	}

	public void setDepActionPendingWdr(String depActionPendingWdr) {
		this.depActionPendingWdr = depActionPendingWdr;
	}

	public String getBlockedIp() {
		return blockedIp;
	}

	public void setBlockedIp(String blockedIp) {
		this.blockedIp = blockedIp;
	}

	public String getBlockedEmail() {
		return blockedEmail;
	}

	public void setBlockedEmail(String blockedEmail) {
		this.blockedEmail = blockedEmail;
	}

	public String getBlockedPhone() {
		return blockedPhone;
	}

	public void setBlockedPhone(String blockedPhone) {
		this.blockedPhone = blockedPhone;
	}

	public void setVipLevel(String vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getVipLevel() {
		return vipLevel;
	}

	public void setDefaultVipLevel(Integer defaultVipLevel) {
		this.defaultVipLevel = defaultVipLevel;
	}

	public Integer getDefaultVipLevel() {
		return defaultVipLevel;
	}

	public void setPlayerLedgerFormat(String playerLedgerFormat) {
		this.playerLedgerFormat = playerLedgerFormat;
	}

	public String getPlayerLedgerFormat() {
		return playerLedgerFormat;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setUrlList(String urlList) {
		this.urlList = urlList;
	}

	public String getUrlList() {
		return urlList;
	}

	public Map<String, StCmsTemplateMaster> getTempleteUrlMap() {
		return templeteUrlMap;
	}

	public void setTempleteUrlMap(
			Map<String, StCmsTemplateMaster> templeteUrlMap) {
		this.templeteUrlMap = templeteUrlMap;
	}

	public void setPasswordExpression(String passwordExpression) {
		this.passwordExpression = passwordExpression;
	}

	public String getPasswordExpression() {
		return passwordExpression;
	}

	public void setPasswordHelpString(String passwordHelpString) {
		this.passwordHelpString = passwordHelpString;
	}

	public String getPasswordHelpString() {
		return passwordHelpString;
	}

	public void setPasswordStrengthCheck(String passwordStrengthCheck) {
		this.passwordStrengthCheck = passwordStrengthCheck;
	}

	public String getPasswordStrengthCheck() {
		return passwordStrengthCheck;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getTemplate() {
		return template;
	}

	public void setBonusWrCarryFwd(String bonusWrCarryFwd) {
		this.bonusWrCarryFwd = bonusWrCarryFwd;
	}

	public String getBonusWrCarryFwd() {
		return bonusWrCarryFwd;
	}

	public Short getAllowedInvaildLoginTry() {
		return allowedInvaildLoginTry;
	}

	public void setAllowedInvaildLoginTry(Short allowedInvaildLoginTry) {
		this.allowedInvaildLoginTry = allowedInvaildLoginTry;
	}

	public Short getPlayerPasswordHistoryCount() {
		return playerPasswordHistoryCount;
	}

	public void setPlayerPasswordHistoryCount(Short playerPasswordHistoryCount) {
		this.playerPasswordHistoryCount = playerPasswordHistoryCount;
	}

	public void setRgOperatorLimit(String rgOperatorLimit) {
		this.rgOperatorLimit = rgOperatorLimit;
	}

	public String getRgOperatorLimit() {
		return rgOperatorLimit;
	}

	public void setCheckRg(String checkRg) {
		this.checkRg = checkRg;
	}

	public String getCheckRg() {
		return checkRg;
	}

	public void setDomainOwner(String domainOwner) {
		this.domainOwner = domainOwner;
	}

	public String getDomainOwner() {
		return domainOwner;
	}

	public void setOwnerContactNo(Long ownerContactNo) {
		this.ownerContactNo = ownerContactNo;
	}

	public Long getOwnerContactNo() {
		return ownerContactNo;
	}

	public void setVerificationThrough(String verificationThrough) {
		this.verificationThrough = verificationThrough;
	}

	public String getVerificationThrough() {
		return verificationThrough;
	}

	public void setDomainLogo(String domainLogo) {
		this.domainLogo = domainLogo;
	}

	public String getDomainLogo() {
		return domainLogo;
	}

	public void setDomainLogoFileName(String domainLogoFileName) {
		this.domainLogoFileName = domainLogoFileName;
	}

	public String getDomainLogoFileName() {
		return domainLogoFileName;
	}

	public List<String> getPcDomainAlias() {
		if (pcDomainAlias == null) {
			pcDomainAlias = new ArrayList<String>();
		}
		return pcDomainAlias;
	}

	public List<String> getMobileDomainAlias() {
		if (mobileDomainAlias == null) {
			mobileDomainAlias = new ArrayList<String>();
		}
		return mobileDomainAlias;
	}

	public List<String> getTabDomainAlias() {
		if (tabDomainAlias == null) {
			tabDomainAlias = new ArrayList<String>();
		}
		return tabDomainAlias;
	}

	public void setPcDomainAlias(List<String> pCDomainAlias) {
		pcDomainAlias = pCDomainAlias;
	}

	public void setMobileDomainAlias(List<String> mobileDomainAlias) {
		this.mobileDomainAlias = mobileDomainAlias;
	}

	public void setTabDomainAlias(List<String> tabDomainAlias) {
		this.tabDomainAlias = tabDomainAlias;
	}

	public void setVerificationSourceId(Short verificationSourceId) {
		this.verificationSourceId = verificationSourceId;
	}

	public Short getVerificationSourceId() {
		return verificationSourceId;
	}

	public void setTpAutoVerification(String tpAutoVerification) {
		this.tpAutoVerification = tpAutoVerification;
	}

	public String getTpAutoVerification() {
		return tpAutoVerification;
	}

	public void setBonusExipryLimit(Double bonusExipryLimit) {
		this.bonusExipryLimit = bonusExipryLimit;
	}

	public Double getBonusExipryLimit() {
		return bonusExipryLimit;
	}

}
