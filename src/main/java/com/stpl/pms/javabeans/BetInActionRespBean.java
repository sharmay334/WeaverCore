package com.stpl.pms.javabeans;


public class BetInActionRespBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private String requestAction;
	
	private SportsTxnResponseParam params;
	
	public void setParams(SportsTxnResponseParam params) {
		this.params = params;
	}

	public SportsTxnResponseParam getParams() {
		return params;
	}

	public void setRequestAction(String requestAction) {
		this.requestAction = requestAction;
	}

	public String getRequestAction() {
		return requestAction;
	}

	


	
	
}
