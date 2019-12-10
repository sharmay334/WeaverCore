package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmMobileAppDownload entity. @author MyEclipse Persistence Tools
 */

public class StPmMobileAppDownload implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Long playerId;
	private Short domainId;
	private Long mobileNo;
	private Timestamp msgSendTime;
	private Short msgCount;
	private String userAgent;

	// Constructors

	/** default constructor */
	public StPmMobileAppDownload() {
	}

	/** minimal constructor */
	public StPmMobileAppDownload(Short domainId, Long mobileNo,
			Timestamp msgSendTime, Short msgCount) {
		this.domainId = domainId;
		this.mobileNo = mobileNo;
		this.msgSendTime = msgSendTime;
		this.msgCount = msgCount;
	}

	/** full constructor */
	public StPmMobileAppDownload(Long playerId, Short domainId, Long mobileNo,
			Timestamp msgSendTime, Short msgCount, String userAgent) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.mobileNo = mobileNo;
		this.msgSendTime = msgSendTime;
		this.msgCount = msgCount;
		this.userAgent = userAgent;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Long getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Timestamp getMsgSendTime() {
		return this.msgSendTime;
	}

	public void setMsgSendTime(Timestamp msgSendTime) {
		this.msgSendTime = msgSendTime;
	}

	public Short getMsgCount() {
		return this.msgCount;
	}

	public void setMsgCount(Short msgCount) {
		this.msgCount = msgCount;
	}

	public String getUserAgent() {
		return this.userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

}