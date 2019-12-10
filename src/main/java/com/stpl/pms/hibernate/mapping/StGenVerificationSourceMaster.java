package com.stpl.pms.hibernate.mapping;

/**
 * StGenVerificationSourceMaster entity. @author MyEclipse Persistence Tools
 */

public class StGenVerificationSourceMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Short sourceId;
	private String sourceName;
	private String sourceAuthUserName;
	private String sourceAuthPwd;
	private String sourceServiceUrl;
	private String configName;
	private String sourceStatus;

	// Constructors

	/** default constructor */
	public StGenVerificationSourceMaster() {
	}

	/** minimal constructor */
	public StGenVerificationSourceMaster(String sourceName) {
		this.sourceName = sourceName;
	}

	/** full constructor */
	public StGenVerificationSourceMaster(String sourceName,
			String sourceAuthUserName, String sourceAuthPwd,
			String sourceServiceUrl, String configName, String sourceStatus) {
		this.sourceName = sourceName;
		this.sourceAuthUserName = sourceAuthUserName;
		this.sourceAuthPwd = sourceAuthPwd;
		this.sourceServiceUrl = sourceServiceUrl;
		this.configName = configName;
		this.sourceStatus = sourceStatus;
	}

	// Property accessors

	public Short getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(Short sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return this.sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceAuthUserName() {
		return this.sourceAuthUserName;
	}

	public void setSourceAuthUserName(String sourceAuthUserName) {
		this.sourceAuthUserName = sourceAuthUserName;
	}

	public String getSourceAuthPwd() {
		return this.sourceAuthPwd;
	}

	public void setSourceAuthPwd(String sourceAuthPwd) {
		this.sourceAuthPwd = sourceAuthPwd;
	}

	public String getSourceServiceUrl() {
		return this.sourceServiceUrl;
	}

	public void setSourceServiceUrl(String sourceServiceUrl) {
		this.sourceServiceUrl = sourceServiceUrl;
	}

	public String getConfigName() {
		return this.configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getSourceStatus() {
		return this.sourceStatus;
	}

	public void setSourceStatus(String sourceStatus) {
		this.sourceStatus = sourceStatus;
	}

}