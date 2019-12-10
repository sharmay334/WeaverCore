package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlayerSocialReferralMaster entity. @author MyEclipse Persistence Tools
 */

public class StPmPlayerSocialReferralMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long socialPostId;
	private Short domainId;
	private Short aliasId;
	private Long playerId;
	private Timestamp invitationDate;
	private String invitationStatus;
	private Timestamp visitedDate;
	private Long regPlayerId;
	private String bonusOnInvited;

	// Constructors

	/** default constructor */
	public StPmPlayerSocialReferralMaster() {
	}

	/** minimal constructor */
	public StPmPlayerSocialReferralMaster(Long socialPostId, Short domainId,
			Long playerId, Timestamp invitationDate, String invitationStatus,
			String bonusOnInvited) {
		this.socialPostId = socialPostId;
		this.domainId = domainId;
		this.playerId = playerId;
		this.invitationDate = invitationDate;
		this.invitationStatus = invitationStatus;
		this.bonusOnInvited = bonusOnInvited;
	}

	/** full constructor */
	public StPmPlayerSocialReferralMaster(Long socialPostId, Short domainId, Short aliasId,
			Long playerId, Timestamp invitationDate, String invitationStatus,
			Timestamp visitedDate, Long regPlayerId, String bonusOnInvited) {
		this.socialPostId = socialPostId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.playerId = playerId;
		this.invitationDate = invitationDate;
		this.invitationStatus = invitationStatus;
		this.visitedDate = visitedDate;
		this.regPlayerId = regPlayerId;
		this.bonusOnInvited = bonusOnInvited;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSocialPostId() {
		return this.socialPostId;
	}

	public void setSocialPostId(Long socialPostId) {
		this.socialPostId = socialPostId;
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

	public Timestamp getInvitationDate() {
		return this.invitationDate;
	}

	public void setInvitationDate(Timestamp invitationDate) {
		this.invitationDate = invitationDate;
	}

	public String getInvitationStatus() {
		return this.invitationStatus;
	}

	public void setInvitationStatus(String invitationStatus) {
		this.invitationStatus = invitationStatus;
	}

	public Timestamp getVisitedDate() {
		return this.visitedDate;
	}

	public void setVisitedDate(Timestamp visitedDate) {
		this.visitedDate = visitedDate;
	}

	public Long getRegPlayerId() {
		return this.regPlayerId;
	}

	public void setRegPlayerId(Long regPlayerId) {
		this.regPlayerId = regPlayerId;
	}

	public String getBonusOnInvited() {
		return this.bonusOnInvited;
	}

	public void setBonusOnInvited(String bonusOnInvited) {
		this.bonusOnInvited = bonusOnInvited;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}