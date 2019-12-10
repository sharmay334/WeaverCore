package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PasswordPolicyBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String passwordPolicy;
	private String passwordExpression;
	private String passwordStrengthCheck;
	private Integer helpStringCode;
	private String status;
	
	public PasswordPolicyBean() {
	}

	public PasswordPolicyBean(String passwordPolicy, String passwordExpression,
			String passwordStrengthCheck, Integer helpStringCode, String status) {
		super();
		this.passwordPolicy = passwordPolicy;
		this.passwordExpression = passwordExpression;
		this.passwordStrengthCheck = passwordStrengthCheck;
		this.helpStringCode = helpStringCode;
		this.status = status;
	}

	public String getPasswordPolicy() {
		return passwordPolicy;
	}

	public void setPasswordPolicy(String passwordPolicy) {
		this.passwordPolicy = passwordPolicy;
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

	public Integer getHelpStringCode() {
		return helpStringCode;
	}

	public void setHelpStringCode(Integer helpStringCode) {
		this.helpStringCode = helpStringCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
