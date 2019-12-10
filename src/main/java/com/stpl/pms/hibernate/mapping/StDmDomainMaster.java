package com.stpl.pms.hibernate.mapping;

/**
 * StDmDomainMaster entity. @author MyEclipse Persistence Tools
 */

public class StDmDomainMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Short domainId;
	private String domainName;
	private String registrationType;
	private String registrationMode;
	private Integer languageId;
	private Short serviceId;
	private Integer currencyId;
	private String registrationPage;
	private String termCondition;
	private String privacyPolicy;
	private String securityQuesList;
	private String referralList;
	private StGenPasswordPolicy stGenPasswordPolicy;
	private String gameMapping;
	private String paymentOption;
	private String rolePreference;
	private String allowedCountries;
	private String allowedStates;

	private String merchantProviderAccount;
	private String duplicateLogic;
	private String paymentOptionCurrency;
	private String bonusUsageOrder;
	private String depActionPendingWdr;
	private String tdsOn;
	private String plrVisibleWallet;
	private String loginThroughEmail;
	private String loginThroughUsername;
	private String loginThroughMobileNo;
	private String loginThroughFconnect;
	private String gameTryBeforeLogin;
	private String blockedIp;
	private String blockedEmail;
	private String blockedPhone;
	private String domainStatus;
	private Double wdrApprovalLimit;
	private Integer wdrCodeExpiry;
	private Integer wdrCodeResendAfterTime;
	private String domainImagePath;
	private String allowedfeatureBlockedCountry;
	private String playerPassword;
	private String sendPassword;
	private String firstVerification;
	private String footer;

	// private String playerUniqueness;
	// private String allowedBoIp;

	private String verificationThrough;
	private String vipLevel;
	private String contentList;
	private String menuList;
	private Integer defaultVipLevel;
	private String playerLedgerFormat;
	private String urlList;
	private String template;
	private String bonusWrCarryFwd;
	private Short verificationSourceId;
	private String tPAutoVerification;
	private Short allowedInvaildLoginTry;
	private Short playerPasswordHistoryCount;
	private String rgOperatorLimit;
	private String checkRg;
	private Double bonusExipryLimit;
	private String forgotPasswordThrough;
	private String multipleLogin;

	// Constructors

	/** default constructor */
	public StDmDomainMaster() {
	}

	// Property accessors

	public Short getDomainId() {
		return this.domainId;
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

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getDomainName() {
		return this.domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getRegistrationType() {
		return this.registrationType;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public String getRegistrationMode() {
		return this.registrationMode;
	}

	public void setRegistrationMode(String registrationMode) {
		this.registrationMode = registrationMode;
	}

	public Integer getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Short getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Short serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public String getRegistrationPage() {
		return this.registrationPage;
	}

	public void setRegistrationPage(String registrationPage) {
		this.registrationPage = registrationPage;
	}

	public String getTermCondition() {
		return this.termCondition;
	}

	public void setTermCondition(String termCondition) {
		this.termCondition = termCondition;
	}

	public void setSecurityQuesList(String securityQuesList) {
		this.securityQuesList = securityQuesList;
	}

	public String getReferralList() {
		return this.referralList;
	}

	public void setReferralList(String referralList) {
		this.referralList = referralList;
	}

	public String getGameMapping() {
		return this.gameMapping;
	}

	public void setGameMapping(String gameMapping) {
		this.gameMapping = gameMapping;
	}

	public String getPaymentOption() {
		return this.paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public String getRolePreference() {
		return this.rolePreference;
	}

	public void setRolePreference(String rolePreference) {
		this.rolePreference = rolePreference;
	}

	public String getAllowedCountries() {
		return this.allowedCountries;
	}

	public void setAllowedCountries(String allowedCountries) {
		this.allowedCountries = allowedCountries;
	}

	public String getAllowedStates() {
		return this.allowedStates;
	}

	public void setAllowedStates(String allowedStates) {
		this.allowedStates = allowedStates;
	}

	public String getMerchantProviderAccount() {
		return this.merchantProviderAccount;
	}

	public void setMerchantProviderAccount(String merchantProviderAccount) {
		this.merchantProviderAccount = merchantProviderAccount;
	}

	public String getDuplicateLogic() {
		return this.duplicateLogic;
	}

	public void setDuplicateLogic(String duplicateLogic) {
		this.duplicateLogic = duplicateLogic;
	}

	public String getPaymentOptionCurrency() {
		return this.paymentOptionCurrency;
	}

	public void setPaymentOptionCurrency(String paymentOptionCurrency) {
		this.paymentOptionCurrency = paymentOptionCurrency;
	}

	public String getBonusUsageOrder() {
		return this.bonusUsageOrder;
	}

	public void setBonusUsageOrder(String bonusUsageOrder) {
		this.bonusUsageOrder = bonusUsageOrder;
	}

	public String getTdsOn() {
		return this.tdsOn;
	}

	public void setTdsOn(String tdsOn) {
		this.tdsOn = tdsOn;
	}

	public String getPlrVisibleWallet() {
		return this.plrVisibleWallet;
	}

	public void setPlrVisibleWallet(String plrVisibleWallet) {
		this.plrVisibleWallet = plrVisibleWallet;
	}

	public String getLoginThroughEmail() {
		return this.loginThroughEmail;
	}

	public void setLoginThroughEmail(String loginThroughEmail) {
		this.loginThroughEmail = loginThroughEmail;
	}

	public String getLoginThroughUsername() {
		return this.loginThroughUsername;
	}

	public void setLoginThroughUsername(String loginThroughUsername) {
		this.loginThroughUsername = loginThroughUsername;
	}

	public String getLoginThroughMobileNo() {
		return this.loginThroughMobileNo;
	}

	public void setLoginThroughMobileNo(String loginThroughMobileNo) {
		this.loginThroughMobileNo = loginThroughMobileNo;
	}

	public String getLoginThroughFconnect() {
		return this.loginThroughFconnect;
	}

	public void setLoginThroughFconnect(String loginThroughFconnect) {
		this.loginThroughFconnect = loginThroughFconnect;
	}

	public String getGameTryBeforeLogin() {
		return this.gameTryBeforeLogin;
	}

	public void setGameTryBeforeLogin(String gameTryBeforeLogin) {
		this.gameTryBeforeLogin = gameTryBeforeLogin;
	}

	public String getBlockedIp() {
		return this.blockedIp;
	}

	public void setBlockedIp(String blockedIp) {
		this.blockedIp = blockedIp;
	}

	public String getDomainStatus() {
		return this.domainStatus;
	}

	public void setDomainStatus(String domainStatus) {
		this.domainStatus = domainStatus;
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

	public String getAllowedfeatureBlockedCountry() {
		return allowedfeatureBlockedCountry;
	}

	public void setAllowedfeatureBlockedCountry(
			String allowedfeatureBlockedCountry) {
		this.allowedfeatureBlockedCountry = allowedfeatureBlockedCountry;
	}

	public String getFirstVerification() {
		return firstVerification;
	}

	public void setFirstVerification(String firstVerification) {
		this.firstVerification = firstVerification;
	}

	public Double getWdrApprovalLimit() {
		return wdrApprovalLimit;
	}

	public String getPrivacyPolicy() {
		return privacyPolicy;
	}

	public void setPrivacyPolicy(String privacyPolicy) {
		this.privacyPolicy = privacyPolicy;
	}

	public String getDomainImagePath() {
		return domainImagePath;
	}

	public void setDomainImagePath(String domainImagePath) {
		this.domainImagePath = domainImagePath;
	}

	public String getPlayerPassword() {
		return playerPassword;
	}

	public void setPlayerPassword(String playerPassword) {
		this.playerPassword = playerPassword;
	}

	public String getSendPassword() {
		return sendPassword;
	}

	public void setSendPassword(String sendPassword) {
		this.sendPassword = sendPassword;
	}

	public String getVerificationThrough() {
		return verificationThrough;
	}

	public void setVerificationThrough(String verificationThrough) {
		this.verificationThrough = verificationThrough;
	}

	public String getSecurityQuesList() {
		return securityQuesList;
	}

	public void setVipLevel(String vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getVipLevel() {
		return vipLevel;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getFooter() {
		return footer;
	}

	public String getContentList() {
		return contentList;
	}

	public void setContentList(String contentList) {
		this.contentList = contentList;
	}

	public String getMenuList() {
		return menuList;
	}

	public void setMenuList(String menuList) {
		this.menuList = menuList;
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

	public void setUrlList(String urlList) {
		this.urlList = urlList;
	}

	public String getUrlList() {
		return urlList;
	}

	public void setStGenPasswordPolicy(StGenPasswordPolicy stGenPasswordPolicy) {
		this.stGenPasswordPolicy = stGenPasswordPolicy;
	}

	public StGenPasswordPolicy getStGenPasswordPolicy() {
		return stGenPasswordPolicy;
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

	public void setVerificationSourceId(Short verificationSourceId) {
		this.verificationSourceId = verificationSourceId;
	}

	public Short getVerificationSourceId() {
		return verificationSourceId;
	}

	public void settPAutoVerification(String tPAutoVerification) {
		this.tPAutoVerification = tPAutoVerification;
	}

	public String gettPAutoVerification() {
		return tPAutoVerification;
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

	public void setBonusExipryLimit(Double bonusExipryLimit) {
		this.bonusExipryLimit = bonusExipryLimit;
	}

	public Double getBonusExipryLimit() {
		return bonusExipryLimit;
	}

	public String getForgotPasswordThrough() {
		return forgotPasswordThrough;
	}

	public void setForgotPasswordThrough(String forgotPasswordThrough) {
		this.forgotPasswordThrough = forgotPasswordThrough;
	}

	public Integer getWdrCodeResendAfterTime() {
		return wdrCodeResendAfterTime;
	}

	public void setWdrCodeResendAfterTime(Integer wdrCodeResendAfterTime) {
		this.wdrCodeResendAfterTime = wdrCodeResendAfterTime;
	}

	public Integer getWdrCodeExpiry() {
		return wdrCodeExpiry;
	}

	public void setWdrCodeExpiry(Integer wdrCodeExpiry) {
		this.wdrCodeExpiry = wdrCodeExpiry;
	}

	public String getMultipleLogin() {
		return multipleLogin;
	}

	public void setMultipleLogin(String multipleLogin) {
		this.multipleLogin = multipleLogin;
	}

}