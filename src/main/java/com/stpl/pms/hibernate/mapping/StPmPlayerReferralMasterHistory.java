package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlayerReferralMaster entity. @author MyEclipse Persistence Tools
 */

public class StPmPlayerReferralMasterHistory implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private String invitedMode;
	private Timestamp invitationDate;
	private String invitedEmailId;
	private Long invitedMobileNo;
	private String invitationStatus;
	private Long registeredPlayerId;
	private String bonusOnInvited;
	private Timestamp visitedDate;

	// Constructors

	/** default constructor */
	public StPmPlayerReferralMasterHistory() {
	}

	public StPmPlayerReferralMasterHistory(StPmPlayerReferralMaster refMaster) {
		this.playerId = refMaster.getPlayerId();
		this.domainId = refMaster.getDomainId();
		this.aliasId = refMaster.getAliasId();
		this.invitedMode = refMaster.getInvitedMode();
		this.invitationDate = refMaster.getInvitationDate();
		this.invitedEmailId = refMaster.getInvitedEmailId();
		this.invitedMobileNo = refMaster.getInvitedMobileNo();
		this.invitationStatus = refMaster.getInvitationStatus();
		this.bonusOnInvited = refMaster.getBonusOnInvited();
		this.registeredPlayerId = refMaster.getRegisteredPlayerId();
		this.visitedDate = refMaster.getVisitedDate();
	}
	/** minimal constructor */
	public StPmPlayerReferralMasterHistory(Long playerId,Short domainId, Timestamp invitationDate,
			String invitedEmailId, String invitationStatus,String bonusOnInvited) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.invitationDate = invitationDate;
		this.invitedEmailId = invitedEmailId;
		this.invitationStatus = invitationStatus;
		this.bonusOnInvited=bonusOnInvited;
	}

	/** full constructor */
	public StPmPlayerReferralMasterHistory(Long playerId,Short domainId, Short aliasId, Timestamp invitationDate,
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

}