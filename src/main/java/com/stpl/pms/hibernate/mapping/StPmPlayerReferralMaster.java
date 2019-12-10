package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlayerReferralMaster entity. @author MyEclipse Persistence Tools
 */

public class StPmPlayerReferralMaster implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Timestamp invitationDate;
	private String invitedEmailId;
	private String invitationStatus;
	private Long registeredPlayerId;
	private String bonusOnInvited;
	private Timestamp visitedDate;
	private String invitedMode;
	private Long invitedMobileNo;
	private Long socialPostId;
	private String visitorIp;
	private String visitorCountryCode;
	private String visitorCity;

	// Constructors

	/** default constructor */
	public StPmPlayerReferralMaster() {
	}

	/** minimal constructor */
	public StPmPlayerReferralMaster(Long playerId,Short domainId,Short aliasId, String invitedMode, Timestamp invitationDate,
			String invitedEmailId, Long invitedMobileNo, String invitationStatus,String bonusOnInvited) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.invitedMode = invitedMode;
		this.invitationDate = invitationDate;
		this.invitedEmailId = invitedEmailId;
		this.invitationStatus = invitationStatus;
		this.bonusOnInvited=bonusOnInvited;
		this.invitedMobileNo = invitedMobileNo;
	}

	/** full constructor */
	public StPmPlayerReferralMaster(Long playerId,Short domainId, Short aliasId, Timestamp invitationDate,
			String invitedEmailId, String invitationStatus,
			Long registeredPlayerId) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.invitationDate = invitationDate;
		this.invitedEmailId = invitedEmailId;
		this.invitationStatus = invitationStatus;
		this.registeredPlayerId = registeredPlayerId;
	}

	public StPmPlayerReferralMaster(Long playerId, Short domainId,
			Short aliasId, Timestamp invitationDate, String invitedEmailId,
			String invitationStatus, Long registeredPlayerId,
			String bonusOnInvited, Timestamp visitedDate, String invitedMode,
			Long invitedMobileNo, Long socialPostId, String visitorIp, String visitorCity, String visitorCountryCode ) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.invitationDate = invitationDate;
		this.invitedEmailId = invitedEmailId;
		this.invitationStatus = invitationStatus;
		this.registeredPlayerId = registeredPlayerId;
		this.bonusOnInvited = bonusOnInvited;
		this.visitedDate = visitedDate;
		this.invitedMode = invitedMode;
		this.invitedMobileNo = invitedMobileNo;
		this.socialPostId = socialPostId;
		this.visitorIp = visitorIp;
		this.visitorCity = visitorCity;
		this.visitorCountryCode = visitorCountryCode;
	}
	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getInvitedEmailId() {
		return this.invitedEmailId;
	}

	public void setInvitedEmailId(String invitedEmailId) {
		this.invitedEmailId = invitedEmailId;
	}

	public String getInvitationStatus() {
		return this.invitationStatus;
	}

	public void setInvitationStatus(String invitationStatus) {
		this.invitationStatus = invitationStatus;
	}

	public Long getRegisteredPlayerId() {
		return this.registeredPlayerId;
	}

	public void setRegisteredPlayerId(Long registeredPlayerId) {
		this.registeredPlayerId = registeredPlayerId;
	}

	public String getBonusOnInvited() {
		return bonusOnInvited;
	}

	public void setBonusOnInvited(String bonusOnInvited) {
		this.bonusOnInvited = bonusOnInvited;
	}
	
	public Short getDomainId() {
		return domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Timestamp getVisitedDate() {
		return visitedDate;
	}

	public void setVisitedDate(Timestamp visitedDate) {
		this.visitedDate = visitedDate;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getInvitedMode() {
		return invitedMode;
	}

	public void setInvitedMode(String invitedMode) {
		this.invitedMode = invitedMode;
	}

	public Long getInvitedMobileNo() {
		return invitedMobileNo;
	}

	public void setInvitedMobileNo(Long invitedMobileNo) {
		this.invitedMobileNo = invitedMobileNo;
	}

	public Long getSocialPostId() {
		return socialPostId;
	}

	public void setSocialPostId(Long socialPostId) {
		this.socialPostId = socialPostId;
	}

	public String getVisitorIp() {
		return visitorIp;
	}

	public void setVisitorIp(String visitorIp) {
		this.visitorIp = visitorIp;
	}

	public String getVisitorCountryCode() {
		return visitorCountryCode;
	}

	public void setVisitorCountryCode(String visitorCountryCode) {
		this.visitorCountryCode = visitorCountryCode;
	}

	public String getVisitorCity() {
		return visitorCity;
	}

	public void setVisitorCity(String visitorCity) {
		this.visitorCity = visitorCity;
	}

}