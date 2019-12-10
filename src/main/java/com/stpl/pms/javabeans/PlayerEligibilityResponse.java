package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PlayerEligibilityResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Boolean eligibility;
	private Integer errorCode;
	private String errorMsg;

	public Boolean getEligibility() {
		return eligibility;
	}

	public void setEligibility(Boolean eligibility) {
		this.eligibility = eligibility;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
