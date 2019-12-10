package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

public class PasswordRequestBean extends CommonRequestBean implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private String oldPassword;
	private String newPassword;
	private String emailId;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
