package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StCommTemplateMaster entity. @author MyEclipse Persistence Tools
 */

public class StCmsTemplateMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer templateId;
	private Short domainId;
	private Short aliasId; 
	private String mode;
	private String templateType;
	private StGenLanguageMaster langMaster;
	private String templatePath;
	private String templateSubject;
	private String templateFromName;
	private String templateFromEmail;
	private String falconideTemplateFromEmail;
	private String status;
	private String sentOn;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;

	private Integer falconideTemplateId;
	
	// Constructors

	/** default constructor */
	public StCmsTemplateMaster() {
	}

	/** Minimal constructor */
	public StCmsTemplateMaster(Short domainId, String mode,String templateFromName, String templateFromEmail,
			String templateType, String templatePath, String templateSubject,
			String status, StGenLanguageMaster langMaster, String sentOn) {
		this.domainId = domainId;
		this.mode = mode;
		this.templateType = templateType;
		this.templatePath = templatePath;
		this.templateSubject = templateSubject;
		this.status = status;
		this.langMaster = langMaster;
		this.sentOn = sentOn;
		this.templateFromEmail = templateFromEmail;
		this.templateFromName = templateFromName;
	}

	/** full constructor */
	public StCmsTemplateMaster(Short domainId, Short aliasId, String mode,String templateFromName, String templateFromEmail,
			String templateType, String templatePath, String templateSubject,
			String status, StGenLanguageMaster langMaster, String sentOn) {
		this.domainId = domainId;
		this.mode = mode;
		this.templateType = templateType;
		this.templatePath = templatePath;
		this.templateSubject = templateSubject;
		this.status = status;
		this.langMaster = langMaster;
		this.sentOn = sentOn;
		this.templateFromEmail = templateFromEmail;
		this.templateFromName = templateFromName;
		this.aliasId = aliasId;
	}
	
	// Property accessors

	public Integer getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getMode() {
		return this.mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getTemplateType() {
		return this.templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public String getTemplateSubject() {
		return this.templateSubject;
	}

	public void setTemplateSubject(String templateSubject) {
		this.templateSubject = templateSubject;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplateFromName(String templateFromName) {
		this.templateFromName = templateFromName;
	}

	public String getTemplateFromName() {
		return templateFromName;
	}

	public void setTemplateFromEmail(String templateFromEmail) {
		this.templateFromEmail = templateFromEmail;
	}

	public String getTemplateFromEmail() {
		return templateFromEmail;
	}

	public void setLangMaster(StGenLanguageMaster langMaster) {
		this.langMaster = langMaster;
	}

	public StGenLanguageMaster getLangMaster() {
		return langMaster;
	}

	public void setSentOn(String sentOn) {
		this.sentOn = sentOn;
	}

	public String getSentOn() {
		return sentOn;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdationTime() {
		return lastUpdationTime;
	}

	public void setLastUpdationTime(Timestamp lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public Integer getFalconideTemplateId() {
		return falconideTemplateId;
	}

	public void setFalconideTemplateId(Integer falconideTemplateId) {
		this.falconideTemplateId = falconideTemplateId;
	}

	public String getFalconideTemplateFromEmail() {
		return falconideTemplateFromEmail;
	}

	public void setFalconideTemplateFromEmail(String falconideTemplateFromEmail) {
		this.falconideTemplateFromEmail = falconideTemplateFromEmail;
	}
	
	

}