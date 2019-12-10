package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponseBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int errorCode;
	private String respMsg;

	public CommonResponseBean() {
	}

	public CommonResponseBean(int errorCode, String respMsg) {
		this.errorCode = errorCode;
		this.respMsg = respMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

}
