package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;

public class StPmContactUsDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String emailId;
	private String subject;
	private String message;
	
	public StPmContactUsDetails(String userName, String emailId, String subject, String message) {
		this.userName = userName;
		this.emailId = emailId;
		this.subject = subject;
		this.message = message;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
