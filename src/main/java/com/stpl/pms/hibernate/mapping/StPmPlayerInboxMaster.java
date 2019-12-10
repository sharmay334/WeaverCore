package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * StPmPlayerInboxMaster entity. @author MyEclipse Persistence Tools
 */

public class StPmPlayerInboxMaster implements Serializable,Cloneable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private String subject;
	private String templateName;
	private Timestamp sentDate;
	private Timestamp readDate;
	private Timestamp deletedDate;
	private Timestamp expiryDate;
	private Integer userId;
	private String emailStatus;
	private String emailType;
	private String stared;

	// Constructors

	/** default constructor */
	public StPmPlayerInboxMaster() {
	}

	/** minimal constructor */
	public StPmPlayerInboxMaster(Long playerId, Short domainId, String subject,
			String emailPath, String templateName, Timestamp sentDate,
			Integer userId, String emailStatus, String emailType) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.subject = subject;
		this.templateName = templateName;
		this.sentDate = sentDate;
		this.userId = userId;
		this.emailStatus = emailStatus;
		this.emailType = emailType;
	}

	/** full constructor */
	public StPmPlayerInboxMaster(Long playerId, Short domainId, Short aliasId, String subject,
			String emailPath, String templateName, Timestamp sentDate,
			Timestamp readDate, Timestamp deletedDate, Timestamp expiryDate,
			Integer userId, String emailStatus, String emailType) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.subject = subject;
		this.templateName = templateName;
		this.sentDate = sentDate;
		this.readDate = readDate;
		this.deletedDate = deletedDate;
		this.expiryDate = expiryDate;
		this.userId = userId;
		this.emailStatus = emailStatus;
		this.emailType = emailType;
		this.aliasId = aliasId;
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
	
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Timestamp getSentDate() {
		return this.sentDate;
	}

	public void setSentDate(Timestamp sentDate) {
		this.sentDate = sentDate;
	}

	public Timestamp getReadDate() {
		return this.readDate;
	}

	public void setReadDate(Timestamp readDate) {
		this.readDate = readDate;
	}

	public Timestamp getDeletedDate() {
		return this.deletedDate;
	}

	public void setDeletedDate(Timestamp deletedDate) {
		this.deletedDate = deletedDate;
	}

	public Timestamp getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmailStatus() {
		return this.emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getEmailType() {
		return this.emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	@Override
	public StPmPlayerInboxMaster clone() throws CloneNotSupportedException {
		return (StPmPlayerInboxMaster) super.clone();
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}
	
	public String getStared() {
		return this.stared;
	}

	public void setStared(String stared) {
		this.stared = stared;
	}

}