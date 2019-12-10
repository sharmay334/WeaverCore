package com.stpl.pms.hibernate.mapping;

/**
 * StPortalPathMaster entity. @author MyEclipse Persistence Tools
 */

public class StPortalPathMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String serverHostname;
	private String serverUsername;
	private String serverPassword;
	private String serverUrl;
	private String absolutePath;
	private String description;
	private String status;

	// Constructors

	/** default constructor */
	public StPortalPathMaster() {
	}

	/** minimal constructor */
	public StPortalPathMaster(String status) {
		this.status = status;
	}

	/** full constructor */
	public StPortalPathMaster(String serverHostname, String serverUsername,
			String serverPassword, String serverUrl, String absolutePath,
			String description, String status) {
		this.serverHostname = serverHostname;
		this.serverUsername = serverUsername;
		this.serverPassword = serverPassword;
		this.serverUrl = serverUrl;
		this.absolutePath = absolutePath;
		this.description = description;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServerHostname() {
		return this.serverHostname;
	}

	public void setServerHostname(String serverHostname) {
		this.serverHostname = serverHostname;
	}

	public String getServerUsername() {
		return this.serverUsername;
	}

	public void setServerUsername(String serverUsername) {
		this.serverUsername = serverUsername;
	}

	public String getServerPassword() {
		return this.serverPassword;
	}

	public void setServerPassword(String serverPassword) {
		this.serverPassword = serverPassword;
	}

	public String getServerUrl() {
		return this.serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public String getAbsolutePath() {
		return this.absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}