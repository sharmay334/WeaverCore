package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlrMailResponseHistory entity. @author MyEclipse Persistence Tools
 */

public class StPmPlrFalconideMailResponseHistory  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Integer userId;
	private Integer templateId;
	private String emailId;
	private String mailResponse;
	private Timestamp responseTime;

	// Constructors

	/** default constructor */
	public StPmPlrFalconideMailResponseHistory() {
	}

	/** minimal constructor */
	public StPmPlrFalconideMailResponseHistory(Short domainId, Integer userId,
			String mailResponse) {
		this.domainId = domainId;
		this.userId = userId;
		this.mailResponse = mailResponse;
	}

	/** full constructor */
	public StPmPlrFalconideMailResponseHistory(Long playerId, Short domainId, Short aliasId, Integer templateId,
			Integer userId, String emailId, String mailResponse,
			 Timestamp responseTime) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.userId = userId;
		this.emailId = emailId;
		this.templateId = templateId;
		this.mailResponse = mailResponse;
		this.responseTime = responseTime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
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
	
	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMailResponse() {
		return this.mailResponse;
	}

	public void setMailResponse(String mailResponse) {
		this.mailResponse = mailResponse;
	}

	public Timestamp getResponseTime() {
		return this.responseTime;
	}

	public void setResponseTime(Timestamp responseTime) {
		this.responseTime = responseTime;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}