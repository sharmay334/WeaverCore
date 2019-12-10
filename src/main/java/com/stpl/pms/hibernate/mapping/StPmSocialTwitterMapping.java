package com.stpl.pms.hibernate.mapping;

/**
 * StPmSocialTwitterMapping entity. @author MyEclipse Persistence Tools
 */

public class StPmSocialTwitterMapping implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private String token;
	private String twitterId;

	// Constructors

	/** default constructor */
	public StPmSocialTwitterMapping() {
	}

	/** minimal constructor */
	public StPmSocialTwitterMapping(Long playerId, String twitterId) {
		this.playerId = playerId;
		this.twitterId = twitterId;
	}

	/** full constructor */
	public StPmSocialTwitterMapping(Long playerId, String token,
			String twitterId) {
		this.playerId = playerId;
		this.token = token;
		this.twitterId = twitterId;
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

	public String getTwitterId() {
		return this.twitterId;
	}

	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}

}