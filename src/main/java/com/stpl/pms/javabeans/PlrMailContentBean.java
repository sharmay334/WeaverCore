package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PlrMailContentBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pageType;
	private short domainVal;
	private Long[] playerIdArr;
	private String emailType;
	private String[] int_ext_mail;
	private boolean sentToAll;
	private String language;
	private String subject;
	private String content;
	private String fileName;
	private int boUser;
	private String path;
	private short aliasId;
	private String tempId;
	private String contentType;
	private String tempUrl;
	private String from;
	
	
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public short getDomainVal() {
		return domainVal;
	}
	public void setDomainVal(short domainVal) {
		this.domainVal = domainVal;
	}
	public Long[] getPlayerIdArr() {
		return playerIdArr;
	}
	public void setPlayerIdArr(Long[] playerIdArr) {
		this.playerIdArr = playerIdArr;
	}
	public String getEmailType() {
		return emailType;
	}
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	public String[] getInt_ext_mail() {
		return int_ext_mail;
	}
	public void setInt_ext_mail(String[] intExtMail) {
		int_ext_mail = intExtMail;
	}
	public boolean getSentToAll() {
		return sentToAll;
	}
	public void setSentToAll(boolean sentToAll) {
		this.sentToAll = sentToAll;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getBoUser() {
		return boUser;
	}
	public void setBoUser(int boUser) {
		this.boUser = boUser;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public short getAliasId() {
		return aliasId;
	}
	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getTempUrl() {
		return tempUrl;
	}
	public void setTempUrl(String tempUrl) {
		this.tempUrl = tempUrl;
	}
	public String getTempId() {
		return tempId;
	}
	public void setTempId(String tempId) {
		this.tempId = tempId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
}
