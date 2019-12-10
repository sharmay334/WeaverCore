package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlrMailResponseHistory entity. @author MyEclipse Persistence Tools
 */

public class StPmPlrMailResponseHistory  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Integer userId;
	private Integer templateId;
	private String emailId;
	private String mailResponse;
	private String totalNoOfRecipients;
	private String noOfEmailsSent;
	private String noOfUnsentEmails;
	private String noOfSuppressedEmails;
	private String noOfFilteredEmails;
	private String message;
	private String errorCode;
	private String requestedId;
	private Timestamp responseTime;

	// Constructors

	/** default constructor */
	public StPmPlrMailResponseHistory() {
	}

	/** minimal constructor */
	public StPmPlrMailResponseHistory(Short domainId, Integer userId,
			String mailResponse, String message, String requestedId) {
		this.domainId = domainId;
		this.userId = userId;
		this.mailResponse = mailResponse;
		this.message = message;
		this.requestedId = requestedId;
	}

	/** full constructor */
	public StPmPlrMailResponseHistory(Long playerId, Short domainId, Short aliasId, Integer templateId,
			Integer userId, String emailId, String mailResponse,
			String totalNoOfRecipients, String noOfEmailsSent,
			String noOfUnsentEmails, String noOfSuppressedEmails,
			String noOfFilteredEmails, String message, String errorCode,
			String requestedId, Timestamp responseTime) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.userId = userId;
		this.emailId = emailId;
		this.templateId = templateId;
		this.mailResponse = mailResponse;
		this.totalNoOfRecipients = totalNoOfRecipients;
		this.noOfEmailsSent = noOfEmailsSent;
		this.noOfUnsentEmails = noOfUnsentEmails;
		this.noOfSuppressedEmails = noOfSuppressedEmails;
		this.noOfFilteredEmails = noOfFilteredEmails;
		this.message = message;
		this.errorCode = errorCode;
		this.requestedId = requestedId;
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

	public String getTotalNoOfRecipients() {
		return this.totalNoOfRecipients;
	}

	public void setTotalNoOfRecipients(String totalNoOfRecipients) {
		this.totalNoOfRecipients = totalNoOfRecipients;
	}

	public String getNoOfEmailsSent() {
		return this.noOfEmailsSent;
	}

	public void setNoOfEmailsSent(String noOfEmailsSent) {
		this.noOfEmailsSent = noOfEmailsSent;
	}

	public String getNoOfUnsentEmails() {
		return this.noOfUnsentEmails;
	}

	public void setNoOfUnsentEmails(String noOfUnsentEmails) {
		this.noOfUnsentEmails = noOfUnsentEmails;
	}

	public String getNoOfSuppressedEmails() {
		return this.noOfSuppressedEmails;
	}

	public void setNoOfSuppressedEmails(String noOfSuppressedEmails) {
		this.noOfSuppressedEmails = noOfSuppressedEmails;
	}

	public String getNoOfFilteredEmails() {
		return this.noOfFilteredEmails;
	}

	public void setNoOfFilteredEmails(String noOfFilteredEmails) {
		this.noOfFilteredEmails = noOfFilteredEmails;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getRequestedId() {
		return this.requestedId;
	}

	public void setRequestedId(String requestedId) {
		this.requestedId = requestedId;
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