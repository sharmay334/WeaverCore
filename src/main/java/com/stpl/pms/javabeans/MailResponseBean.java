package com.stpl.pms.javabeans;

import java.io.Serializable;

public class MailResponseBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String Success;
	private MailResponseDataBean mailResponseInfoDataBean;
	private String RequestId;
	
	public String getSuccess() {
		return Success;
	}
	public void setSuccess(String success) {
		this.Success = success;
	}
	public MailResponseDataBean getMailResponseInfoDataBean() {
		return mailResponseInfoDataBean;
	}
	public void setMailResponseInfoDataBean(
			MailResponseDataBean mailResponseInfoDataBean) {
		this.mailResponseInfoDataBean = mailResponseInfoDataBean;
	}
	public String getRequestId() {
		return RequestId;
	}
	public void setRequestId(String RequestId) {
		this.RequestId = RequestId;
	}
	
}
