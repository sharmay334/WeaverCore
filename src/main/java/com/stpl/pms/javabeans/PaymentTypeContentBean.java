package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PaymentTypeContentBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private short contentId;
	private int payTypeId;
	private String payTypeCode;
	private String payTypeDispCode;
	private short domainId;
	private String contentPath;
	private String txnType;
	private String content;
	private String status;

	
	public int getPayTypeId() {
		return payTypeId;
	}

	public void setPayTypeId(int payTypeId) {
		this.payTypeId = payTypeId;
	}

	public String getPayTypeCode() {
		return payTypeCode;
	}

	public void setPayTypeCode(String payTypeCode) {
		this.payTypeCode = payTypeCode;
	}

	public String getPayTypeDispCode() {
		return payTypeDispCode;
	}

	public void setPayTypeDispCode(String payTypeDispCode) {
		this.payTypeDispCode = payTypeDispCode;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public String getContentPath() {
		return contentPath;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setContentId(short contentId) {
		this.contentId = contentId;
	}

	public short getContentId() {
		return contentId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
