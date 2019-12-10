package com.stpl.pms.javabeans;

import java.util.List;

public class JoomlaClientContentResponse {

	private List<JoomlaClientContentBean> images;
	private int errorCode;
	private String respMsg;
	
	
	public List<JoomlaClientContentBean> getImages() {
		return images;
	}
	public void setImages(List<JoomlaClientContentBean> images) {
		this.images = images;
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
