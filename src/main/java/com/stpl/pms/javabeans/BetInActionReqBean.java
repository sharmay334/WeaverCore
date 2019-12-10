package com.stpl.pms.javabeans;


public class BetInActionReqBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String requestAction;
	private String userName;
	private String password;
	
	private SportsTxnRequestParam params;
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setParams(SportsTxnRequestParam params) {
		this.params = params;
	}

	public SportsTxnRequestParam getParams() {
		return params;
	}

	public void setRequestAction(String requestAction) {
		this.requestAction = requestAction;
	}

	public String getRequestAction() {
		return requestAction;
	}

	


	
	
}
