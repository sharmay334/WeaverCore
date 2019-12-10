package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PasswordBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private String newPassword;
	private Short domainId;
	
	private Integer helpStringCode;
	private String passwordExpression;
	private String passwordStrengthCheck;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Short getDomainId() {
		return domainId;
	}
	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public Integer getHelpStringCode() {
		return helpStringCode;
	}
	public void setHelpStringCode(Integer helpStringCode) {
		this.helpStringCode = helpStringCode;
	}
	public String getPasswordExpression() {
		return passwordExpression;
	}
	public void setPasswordExpression(String passwordExpression) {
		this.passwordExpression = passwordExpression;
	}
	public String getPasswordStrengthCheck() {
		return passwordStrengthCheck;
	}
	public void setPasswordStrengthCheck(String passwordStrengthCheck) {
		this.passwordStrengthCheck = passwordStrengthCheck;
	}

}
