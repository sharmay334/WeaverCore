package com.stpl.pms.hibernate.mapping;

/**
 * StPmSocialLinkedinMapping entity. @author MyEclipse Persistence Tools
 */

public class StPmSocialLinkedinMapping implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private String token;
	private String linkedInId;

	// Constructors

	/** default constructor */
	public StPmSocialLinkedinMapping() {
	}

	/** minimal constructor */
	public StPmSocialLinkedinMapping(Long playerId, String linkedInId) {
		this.playerId = playerId;
		this.linkedInId = linkedInId;
	}

	/** full constructor */
	public StPmSocialLinkedinMapping(Long playerId, String token,
			String linkedInId) {
		this.playerId = playerId;
		this.token = token;
		this.linkedInId = linkedInId;
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

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLinkedInId() {
		return this.linkedInId;
	}

	public void setLinkedInId(String linkedInId) {
		this.linkedInId = linkedInId;
	}

}