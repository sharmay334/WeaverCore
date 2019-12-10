package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.List;

public class EmailTemplateBean implements Serializable{

	private static final long serialVersionUID = 1L;
	 
	public List<TemplateListBean> emailTemplates;
	private String errorCode;
	private String respMsg;
	

//	public List<TemplateListBean> getEmailTemplates() {
//		return emailTemplates;
//	}
//	public void setEmailTemplates(List<TemplateListBean> emailTemplates) {
//		this.emailTemplates = emailTemplates;
//	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public List<TemplateListBean> getEmailTemplates() {
		return emailTemplates;
	}
	public void setEmailTemplates(List<TemplateListBean> emailTemplates) {
		this.emailTemplates = emailTemplates;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
}
