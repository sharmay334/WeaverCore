package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlayerReferralContactList entity. @author MyEclipse Persistence Tools
 */

public class StPmPlayerReferralContactList implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Long playerId;
	private String playerEmail;
	private String invitedFname;
	private String invitedLname;
	private String invitedEmail;
	private Timestamp inivitedDob;

	// Constructors

	/** default constructor */
	public StPmPlayerReferralContactList() {
	}

	/** minimal constructor */
	public StPmPlayerReferralContactList(Integer id, Long playerId) {
		this.id = id;
		this.playerId = playerId;
	}

	/** full constructor */
	public StPmPlayerReferralContactList(Integer id, Long playerId,
			String playerEmail, String invitedFname, String invitedLname,
			String invitedEmail, Timestamp inivitedDob) {
		this.id = id;
		this.playerId = playerId;
		this.playerEmail = playerEmail;
		this.invitedFname = invitedFname;
		this.invitedLname = invitedLname;
		this.invitedEmail = invitedEmail;
		this.inivitedDob = inivitedDob;
	}
	public StPmPlayerReferralContactList(Long playerId,
			String playerEmail, String invitedFname, String invitedLname,
			String invitedEmail, Timestamp inivitedDob) {
	
		this.playerId = playerId;
		this.playerEmail = playerEmail;
		this.invitedFname = invitedFname;
		this.invitedLname = invitedLname;
		this.invitedEmail = invitedEmail;
		this.inivitedDob = inivitedDob;
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

	public String getPlayerEmail() {
		return this.playerEmail;
	}

	public void setPlayerEmail(String playerEmail) {
		this.playerEmail = playerEmail;
	}

	public String getInvitedFname() {
		return this.invitedFname;
	}

	public void setInvitedFname(String invitedFname) {
		this.invitedFname = invitedFname;
	}

	public String getInvitedLname() {
		return this.invitedLname;
	}

	public void setInvitedLname(String invitedLname) {
		this.invitedLname = invitedLname;
	}

	public String getInvitedEmail() {
		return this.invitedEmail;
	}

	public void setInvitedEmail(String invitedEmail) {
		this.invitedEmail = invitedEmail;
	}

	public Timestamp getInivitedDob() {
		return this.inivitedDob;
	}

	public void setInivitedDob(Timestamp inivitedDob) {
		this.inivitedDob = inivitedDob;
	}

}