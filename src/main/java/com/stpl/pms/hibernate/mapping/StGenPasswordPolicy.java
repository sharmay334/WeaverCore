package com.stpl.pms.hibernate.mapping;

/**
 * StGenPasswordPolicy entity. @author MyEclipse Persistence Tools
 */

public class StGenPasswordPolicy implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer passwordPolicyId;
	private String passwordPolicy;
	private String passwordExpression;
	private String passwordStrengthCheck;
	private Integer helpStringCode;
	private String status;

	// Constructors

	/** default constructor */
	public StGenPasswordPolicy() {
	}

	/** minimal constructor */
	public StGenPasswordPolicy(String passwordStrengthCheck, String status) {
		this.passwordStrengthCheck = passwordStrengthCheck;
		this.status = status;
	}

	/** full constructor */
	public StGenPasswordPolicy(String passwordPolicy,
			String passwordExpression, String passwordStrengthCheck, Integer helpStringCode,
			String status) {
		this.passwordPolicy = passwordPolicy;
		this.passwordExpression = passwordExpression;
		this.passwordStrengthCheck = passwordStrengthCheck;
		this.helpStringCode = helpStringCode;
		this.status = status;
	}

	// Property accessors

	public Integer getPasswordPolicyId() {
		return this.passwordPolicyId;
	}

	public void setPasswordPolicyId(Integer passwordPolicyId) {
		this.passwordPolicyId = passwordPolicyId;
	}

	public String getPasswordPolicy() {
		return this.passwordPolicy;
	}

	public void setPasswordPolicy(String passwordPolicy) {
		this.passwordPolicy = passwordPolicy;
	}

	public String getPasswordExpression() {
		return this.passwordExpression;
	}

	public void setPasswordExpression(String passwordExpression) {
		this.passwordExpression = passwordExpression;
	}

	public String getPasswordStrengthCheck() {
		return this.passwordStrengthCheck;
	}

	public void setPasswordStrengthCheck(String passwordStrengthCheck) {
		this.passwordStrengthCheck = passwordStrengthCheck;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setHelpStringCode(Integer helpStringCode) {
		this.helpStringCode = helpStringCode;
	}

	public Integer getHelpStringCode() {
		return helpStringCode;
	}

}