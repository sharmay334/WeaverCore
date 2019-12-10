package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerVerificationBean extends CommonRequestBean implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private String verificationField;
	private String verificationCode;
	private String verificationType;

	public PlayerVerificationBean() {
	}

	public String getVerificationField() {
		return verificationField;
	}

	public void setVerificationField(String verificationField) {
		this.verificationField = verificationField;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public void setVerificationType(String verificationType) {
		this.verificationType = verificationType;
	}

	public String getVerificationType() {
		return verificationType;
	}

}
