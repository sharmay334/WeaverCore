package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerInboxBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long msgId;
	private String subject;
	private Timestamp sentDate;
	private String msgStatus;
	private String contentPath;

	public PlayerInboxBean() {
	}

	public PlayerInboxBean(Long msgId, String subject, Timestamp sentDate,
			String msgStatus, String contentPath) {
		this.msgId = msgId;
		this.subject = subject;
		this.sentDate = sentDate;
		this.msgStatus = msgStatus;
		this.contentPath = contentPath;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Timestamp getSentDate() {
		return sentDate;
	}

	public void setSentDate(Timestamp sentDate) {
		this.sentDate = sentDate;
	}

	public String getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}

	public String getContentPath() {
		return contentPath;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

}
