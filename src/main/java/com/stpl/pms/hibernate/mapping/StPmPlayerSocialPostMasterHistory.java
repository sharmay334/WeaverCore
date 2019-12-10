package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlayerSocialPostMaster entity. @author MyEclipse Persistence Tools
 */

public class StPmPlayerSocialPostMasterHistory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	
	private Long id;
	private Short domainId;
	private Short aliasId;
	private Long playerId;
	private String postId;
	private Timestamp postedTime;
	private String referFrom;
	private String status;

	// Constructors

	/** default constructor */
	public StPmPlayerSocialPostMasterHistory() {
	}

	public StPmPlayerSocialPostMasterHistory(StPmPlayerSocialPostMaster postMaster) {
		this.domainId = postMaster.getDomainId();
		this.aliasId = postMaster.getAliasId();
		this.playerId = postMaster.getPlayerId();
		this.postId = postMaster.getPostId();
		this.postedTime = postMaster.getPostedTime();
		this.referFrom = postMaster.getReferFrom();
		this.status = postMaster.getStatus();
	}
	
	/** minimal constructor */
	public StPmPlayerSocialPostMasterHistory(Short domainId, Long playerId,
			Timestamp postedTime, String referFrom, String status) {
		this.domainId = domainId;
		this.playerId = playerId;
		this.postedTime = postedTime;
		this.referFrom = referFrom;
		this.status = status;
	}

	/** full constructor */
	public StPmPlayerSocialPostMasterHistory(Short domainId, Long playerId,
			String postId, Timestamp postedTime, String referFrom, String status) {
		this.domainId = domainId;
		this.playerId = playerId;
		this.postId = postId;
		this.postedTime = postedTime;
		this.referFrom = referFrom;
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPostId() {
		return this.postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public Timestamp getPostedTime() {
		return this.postedTime;
	}

	public void setPostedTime(Timestamp postedTime) {
		this.postedTime = postedTime;
	}

	public String getReferFrom() {
		return this.referFrom;
	}

	public void setReferFrom(String referFrom) {
		this.referFrom = referFrom;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}