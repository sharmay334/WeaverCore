package com.stpl.pms.javabeans;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown= true)
public class PlayerReferralInfo implements Comparable<PlayerReferralInfo>,
		java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long referalId;
	private int playerId;
	private String playerEmailId;
	private String fullName;
	private String firstName;
	private String lastName;
	private String emailId;
	private boolean checked;
	private String bonusOnInvite;
	private String inviteDate;
	private Long mobileNo;

	public PlayerReferralInfo() {
	}

	public PlayerReferralInfo(int playerId, String playerEmailId,
			String fullName, String firstName, String lastName, String emailId,
			boolean checked) {
		super();
		this.playerId = playerId;
		this.playerEmailId = playerEmailId;
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.checked = checked;
	}

	public PlayerReferralInfo(String fullName, String firstName,
			String lastName, String emailId, boolean checked) {
		super();
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.checked = checked;
	}

	public PlayerReferralInfo(String firstName, String lastName, String emailId, Long mobileNo, String inviteDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.inviteDate = inviteDate;
		this.mobileNo = mobileNo;
	}

	public String getFullName() {
		return fullName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public String getPlayerEmailId() {
		return playerEmailId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public void setPlayerEmailId(String playerEmailId) {
		this.playerEmailId = playerEmailId;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getBonusOnInvite() {
		return bonusOnInvite;
	}

	public void setBonusOnInvite(String bonusOnInvite) {
		this.bonusOnInvite = bonusOnInvite;
	}

	public String getInviteDate() {
		return inviteDate;
	}

	public void setInviteDate(String inviteDate) {
		this.inviteDate = inviteDate;
	}

	public long getReferalId() {
		return referalId;
	}

	public void setReferalId(long referalId) {
		this.referalId = referalId;
	}

	public int compareTo(PlayerReferralInfo o) {
		return this.getEmailId().toLowerCase().compareTo(
				o.getEmailId().toLowerCase());
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
}
