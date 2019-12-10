package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InboxActivityBean extends CommonRequestBean implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private Long msgId;
	private String activity;
	private List<Long> msgList;

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public List<Long> getMsgList() {
		return msgList;
	}

	public void setMsgList(List<Long> msgList) {
		this.msgList = msgList;
	}

}
