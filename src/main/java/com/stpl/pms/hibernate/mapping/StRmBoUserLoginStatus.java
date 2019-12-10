package com.stpl.pms.hibernate.mapping;

/**
 * StRmBoUserLoginStatus entity. @author MyEclipse Persistence Tools
 */

public class StRmBoUserLoginStatus implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Short domainId;
	private Integer userId;
	private String sessionId;
	private String ipAddress;
	private String status;

	// Constructors

	/** default constructor */
	public StRmBoUserLoginStatus() {
	}

	/** full constructor */
	public StRmBoUserLoginStatus(Short domainId, Integer userId,
			String sessionId, String ipAddress, String status) {
		this.domainId = domainId;
		this.userId = userId;
		this.sessionId = sessionId;
		this.ipAddress = ipAddress;
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}