package com.stpl.pms.javabeans;

public class TemplateMasterBean implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer templateId;
	private String templateType;
	private String templatePath;
	private String templateSubject;
	private String templateFromName;
	private String templateFromEmail;
	private String mode;
	private String sentOn;
	
	public Integer getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	public String getTemplateType() {
		return templateType;
	}
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
	public String getTemplatePath() {
		return templatePath;
	}
	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}
	public String getTemplateSubject() {
		return templateSubject;
	}
	public void setTemplateSubject(String templateSubject) {
		this.templateSubject = templateSubject;
	}
	public String getTemplateFromName() {
		return templateFromName;
	}
	public void setTemplateFromName(String templateFromName) {
		this.templateFromName = templateFromName;
	}
	public String getTemplateFromEmail() {
		return templateFromEmail;
	}
	public void setTemplateFromEmail(String templateFromEmail) {
		this.templateFromEmail = templateFromEmail;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getMode() {
		return mode;
	}
	public void setSentOn(String sentOn) {
		this.sentOn = sentOn;
	}
	public String getSentOn() {
		return sentOn;
	}
	
	

}
