package com.stpl.pms.hibernate.mapping;

/**
 * StCshProviderMaster entity. @author MyEclipse Persistence Tools
 */

public class StCshProviderMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer providerId;
	private String providerNameCode;
	private String imagePath;
	private String providerUrl;
	private String status;
	private Integer timeOut;
	private String codeBase;
	private String ipWhiteList;

	// Constructors

	/** default constructor */
	public StCshProviderMaster() {
	}

	/** minimal constructor */
	public StCshProviderMaster(String status) {
		this.status = status;
	}

	/** full constructor */
	public StCshProviderMaster(String providerNameCode, String imagePath,
			String providerUrl, String status, Integer timeOut) {
		this.providerNameCode = providerNameCode;
		this.imagePath = imagePath;
		this.providerUrl = providerUrl;
		this.status = status;
		this.timeOut = timeOut;
	}

	// Property accessors

	public Integer getProviderId() {
		return this.providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getProviderNameCode() {
		return this.providerNameCode;
	}

	public void setProviderNameCode(String providerNameCode) {
		this.providerNameCode = providerNameCode;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getProviderUrl() {
		return this.providerUrl;
	}

	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTimeOut() {
		return this.timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}

	public String getCodeBase() {
		return codeBase;
	}

	public void setCodeBase(String codeBase) {
		this.codeBase = codeBase;
	}

	public String getIpWhiteList() {
		return ipWhiteList;
	}

	public void setIpWhiteList(String ipWhiteList) {
		this.ipWhiteList = ipWhiteList;
	}

}