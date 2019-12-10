package com.stpl.pms.javabeans;

import java.util.List;

public class JoomlaClientLandingResponse {
	
	private List<JoomlaClientLandingPageBean> pages;
	private int errorCode;
	private String respMsg;
	
	public List<JoomlaClientLandingPageBean> getPages() {
		return pages;
	}
	public void setPages(List<JoomlaClientLandingPageBean> pages) {
		this.pages = pages;
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
