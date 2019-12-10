package com.stpl.pms.javabeans;

public class BetGamesTvRespBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String method;
	private String token;
	private BetGamesTvRespParamBean params;
	private Long time;
	private String signature;
	private int success;
	private int error_code;
	private String error_text="";

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public BetGamesTvRespParamBean getParams() {
		return params;
	}

	public void setParams(BetGamesTvRespParamBean params) {
		this.params = params;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int errorCode) {
		error_code = errorCode;
	}

	public String getError_text() {
		return error_text;
	}

	public void setError_text(String errorText) {
		error_text = errorText;
	}

}