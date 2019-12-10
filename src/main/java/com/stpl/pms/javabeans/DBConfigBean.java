package com.stpl.pms.javabeans;

import java.io.Serializable;

public class DBConfigBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String domainName;
	private String aliasName;
	private String portalContDmName;
	private String pcSiteName;
	private String msiteName;
	private String contentType;
	private String publicURL;
	private String privateURL;
	private String sendmail;
	private String sendSms;
	private String cshDmName;
	private String commonContDmName;
	private String plrContentURL;
	private String landingPageURL;
	private String emailTempURL;
	private String rummyIpCur;
	private String rummyIplive;

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getPortalContDmName() {
		return portalContDmName;
	}

	public void setPortalContDmName(String portalContDmName) {
		this.portalContDmName = portalContDmName;
	}

	public String getCshDmName() {
		return cshDmName;
	}

	public void setCshDmName(String cshDmName) {
		this.cshDmName = cshDmName;
	}

	public String getSendmail() {
		return sendmail;
	}

	public void setSendmail(String sendmail) {
		this.sendmail = sendmail;
	}

	public String getSendSms() {
		return sendSms;
	}

	public void setSendSms(String sendSms) {
		this.sendSms = sendSms;
	}

	public String getRummyIplive() {
		return rummyIplive;
	}

	public void setRummyIplive(String rummyIplive) {
		this.rummyIplive = rummyIplive;
	}

	public String getRummyIpCur() {
		return rummyIpCur;
	}

	public void setRummyIpCur(String rummyIpCur) {
		this.rummyIpCur = rummyIpCur;
	}

	public String getPcSiteName() {
		return pcSiteName;
	}

	public void setPcSiteName(String pcSiteName) {
		this.pcSiteName = pcSiteName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getPublicURL() {
		return publicURL;
	}

	public void setPublicURL(String publicURL) {
		this.publicURL = publicURL;
	}

	public String getPrivateURL() {
		return privateURL;
	}

	public void setPrivateURL(String privateURL) {
		this.privateURL = privateURL;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getPlrContentURL() {
		return plrContentURL;
	}

	public void setPlrContentURL(String plrContentURL) {
		this.plrContentURL = plrContentURL;
	}

	public String getLandingPageURL() {
		return landingPageURL;
	}

	public void setLandingPageURL(String landingPageURL) {
		this.landingPageURL = landingPageURL;
	}

	public String getEmailTempURL() {
		return emailTempURL;
	}

	public void setEmailTempURL(String emailTempURL) {
		this.emailTempURL = emailTempURL;
	}

	public String getMsiteName() {
		return msiteName;
	}

	public void setMsiteName(String msiteName) {
		this.msiteName = msiteName;
	}

	public String getCommonContDmName() {
		return commonContDmName;
	}

	public void setCommonContDmName(String commonContDmName) {
		this.commonContDmName = commonContDmName;
	}

}
