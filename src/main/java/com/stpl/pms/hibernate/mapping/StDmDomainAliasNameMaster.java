package com.stpl.pms.hibernate.mapping;

public class StDmDomainAliasNameMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Short aliasId;
	private String aliasName;
	private StDmDomainMaster domainMaster;
	private String merchantProviderAccount;
	private String template;
	private String contentList;
	private String menuList;
	private String urlList;
	private String status;
	private String publicUrl;
	private String privateUrl;
	private String contentType;
	private Double depositAmt;
	private Short depositCount;
	private String multipleLogin;
	private String isLoyalty;
	private String withdrawStatusOlaOtp;
    private String playerPassword;
    private String sendPassword;
    private String forgotPasswordThrough;


    public StDmDomainAliasNameMaster() {
	}

	public StDmDomainAliasNameMaster(String aliasName, StDmDomainMaster domainMaster,
			String status) {
		this.aliasName = aliasName;
		this.domainMaster = domainMaster;
		this.status = status;
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

    public String getForgotPasswordThrough() {
        return forgotPasswordThrough;
    }

    public void setForgotPasswordThrough(String forgotPasswordThrough) {
        this.forgotPasswordThrough = forgotPasswordThrough;
    }

	public Short getAliasId() {
		return this.aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getAliasName() {
		return this.aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StDmDomainMaster getDomainMaster() {
		return domainMaster;
	}

	public void setDomainMaster(StDmDomainMaster domainMaster) {
		this.domainMaster = domainMaster;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
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

	public String getUrlList() {
		return urlList;
	}

	public void setUrlList(String urlList) {
		this.urlList = urlList;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getPublicUrl() {
		return publicUrl;
	}

	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}

	public String getPrivateUrl() {
		return privateUrl;
	}

	public void setPrivateUrl(String privateUrl) {
		this.privateUrl = privateUrl;
	}

	public String getMerchantProviderAccount() {
		return merchantProviderAccount;
	}

	public void setMerchantProviderAccount(String merchantProviderAccount) {
		this.merchantProviderAccount = merchantProviderAccount;
	}

	public Double getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
	}

	public Short getDepositCount() {
		return depositCount;
	}

	public void setDepositCount(Short depositCount) {
		this.depositCount = depositCount;
	}

	public String getMultipleLogin() {
		return multipleLogin;
	}

	public void setMultipleLogin(String multipleLogin) {
		this.multipleLogin = multipleLogin;
	}

	public String getIsLoyalty() {
		return isLoyalty;
	}

	public void setIsLoyalty(String isLoyalty) {
		this.isLoyalty = isLoyalty;
	}

	public String getWithdrawStatusOlaOtp() {
		return withdrawStatusOlaOtp;
	}

	public void setWithdrawStatusOlaOtp(String withdrawStatusOlaOtp) {
		this.withdrawStatusOlaOtp = withdrawStatusOlaOtp;
	}
}