package com.stpl.pms.hibernate.mapping;

/**
 * StPmSocialGoogleMapping entity. @author MyEclipse Persistence Tools
 */

public class StPmSocialGoogleMapping implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private String token;
	private String googleId;

	// Constructors

	/** default constructor */
	public StPmSocialGoogleMapping() {
	}

	/** minimal constructor */
	public StPmSocialGoogleMapping(Long playerId, String googleId) {
		this.playerId = playerId;
		this.googleId = googleId;
	}

	/** full constructor */
	public StPmSocialGoogleMapping(Long playerId, String token, String googleId) {
		this.playerId = playerId;
		this.token = token;
		this.googleId = googleId;
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

	public String getGoogleId() {
		return this.googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

}