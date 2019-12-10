package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StGenAppVersionDetails entity. @author MyEclipse Persistence Tools
 */

public class StGenAppVersionDetails implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private String appTag;
	private Short domainId;
	private Short aliasId;
	private String os;
	private String appType;
	private String version;
	private String versionCode;
	private Timestamp versionDate;
	private String url;
	private String mandatory;
	private String message;
	private String lastMandatoryVersionCode;
	private String pushToAll;
	private String status;
	private String version_type;

	// Constructors

	/** default constructor */
	public StGenAppVersionDetails() {
	}

	/** minimal constructor */
	public StGenAppVersionDetails(String appTag, Short domainId, Short aliasId,
			String os, String version, String versionCode,
			Timestamp versionDate, String url, String mandatory, String pushToAll, String status) {
		this.appTag = appTag;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.os = os;
		this.version = version;
		this.versionCode = versionCode;
		this.versionDate = versionDate;
		this.url = url;
		this.mandatory = mandatory;
		this.pushToAll = pushToAll;
		this.status = status;
	}

	/** full constructor */
	public StGenAppVersionDetails(String appTag, Short domainId, Short aliasId,
			String os, String appType, String version, String versionCode,
			Timestamp versionDate, String url, String mandatory,
			String message, String lastMandatoryVersionCode, String pushToAll, String status,String version_type) {
		this.appTag = appTag;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.os = os;
		this.appType = appType;
		this.version = version;
		this.versionCode = versionCode;
		this.versionDate = versionDate;
		this.url = url;
		this.mandatory = mandatory;
		this.message = message;
		this.lastMandatoryVersionCode = lastMandatoryVersionCode;
		this.pushToAll = pushToAll;
		this.status = status;
		this.version_type=version_type;
	}

	// Property accessors


	public String getVersion_type() {
		return version_type;
	}

	public void setVersion_type(String version_type) {
		this.version_type = version_type;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppTag() {
		return this.appTag;
	}

	public void setAppTag(String appTag) {
		this.appTag = appTag;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Short getAliasId() {
		return this.aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getOs() {
		return this.os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getAppType() {
		return this.appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersionCode() {
		return this.versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public Timestamp getVersionDate() {
		return this.versionDate;
	}

	public void setVersionDate(Timestamp versionDate) {
		this.versionDate = versionDate;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMandatory() {
		return this.mandatory;
	}

	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLastMandatoryVersionCode() {
		return this.lastMandatoryVersionCode;
	}

	public void setLastMandatoryVersionCode(String lastMandatoryVersionCode) {
		this.lastMandatoryVersionCode = lastMandatoryVersionCode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPushToAll() {
		return pushToAll;
	}

	public void setPushToAll(String pushToAll) {
		this.pushToAll = pushToAll;
	}

}