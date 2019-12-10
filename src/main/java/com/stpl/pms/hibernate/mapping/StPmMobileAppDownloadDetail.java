package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmMobileAppDownloadDetail entity. @author MyEclipse Persistence Tools
 */

public class StPmMobileAppDownloadDetail implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short domainId;
	private Timestamp linkVisitedDatetime;
	private String userAgent;
	private String mobileOs;
	private String ipAddress;
	private String referSource;
	private Integer referSourceId;
	private Integer subSourceId;
	private Integer campTrackId;

	// Constructors

	/** default constructor */
	public StPmMobileAppDownloadDetail() {
	}

	/** minimal constructor */
	public StPmMobileAppDownloadDetail(Short domainId, String userAgent,
			String mobileOs, String ipAddress, String referSource,
			Integer referSourceId, Integer subSourceId, Integer campTrackId) {
		this.domainId = domainId;
		this.userAgent = userAgent;
		this.mobileOs = mobileOs;
		this.ipAddress = ipAddress;
		this.referSource = referSource;
		this.referSourceId = referSourceId;
		this.subSourceId = subSourceId;
		this.campTrackId = campTrackId;
	}

	/** full constructor */
	public StPmMobileAppDownloadDetail(Short domainId,
			Timestamp linkVisitedDatetime, String userAgent, String mobileOs,
			String ipAddress, String referSource, Integer referSourceId,
			Integer subSourceId, Integer campTrackId) {
		this.domainId = domainId;
		this.linkVisitedDatetime = linkVisitedDatetime;
		this.userAgent = userAgent;
		this.mobileOs = mobileOs;
		this.ipAddress = ipAddress;
		this.referSource = referSource;
		this.referSourceId = referSourceId;
		this.subSourceId = subSourceId;
		this.campTrackId = campTrackId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Timestamp getLinkVisitedDatetime() {
		return this.linkVisitedDatetime;
	}

	public void setLinkVisitedDatetime(Timestamp linkVisitedDatetime) {
		this.linkVisitedDatetime = linkVisitedDatetime;
	}

	public String getUserAgent() {
		return this.userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getMobileOs() {
		return this.mobileOs;
	}

	public void setMobileOs(String mobileOs) {
		this.mobileOs = mobileOs;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getReferSource() {
		return this.referSource;
	}

	public void setReferSource(String referSource) {
		this.referSource = referSource;
	}

	public Integer getReferSourceId() {
		return this.referSourceId;
	}

	public void setReferSourceId(Integer referSourceId) {
		this.referSourceId = referSourceId;
	}

	public Integer getSubSourceId() {
		return this.subSourceId;
	}

	public void setSubSourceId(Integer subSourceId) {
		this.subSourceId = subSourceId;
	}

	public Integer getCampTrackId() {
		return this.campTrackId;
	}

	public void setCampTrackId(Integer campTrackId) {
		this.campTrackId = campTrackId;
	}

}