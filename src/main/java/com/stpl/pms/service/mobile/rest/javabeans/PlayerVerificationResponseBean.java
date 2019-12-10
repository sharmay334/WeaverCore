package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerVerificationResponseBean extends CommonResponseBean implements
		Serializable {
	private static final long serialVersionUID = 1L;
	
	private String verificationCode;
	private String verificationBy;

	public PlayerVerificationResponseBean() {
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public void setVerificationBy(String verificationBy) {
		this.verificationBy = verificationBy;
	}

	public String getVerificationBy() {
		return verificationBy;
	}

}
