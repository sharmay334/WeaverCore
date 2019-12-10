package com.stpl.pms.javabeans;

public class BetGamesTvReqBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String method;
	private String token;
	private BetGamesTvReqParamBean params;
	private Long time;
	private String signature;

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

	public BetGamesTvReqParamBean getParams() {
		return params;
	}

	public void setParams(BetGamesTvReqParamBean params) {
		this.params = params;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Long getTime() {
		return time;
	}

}
