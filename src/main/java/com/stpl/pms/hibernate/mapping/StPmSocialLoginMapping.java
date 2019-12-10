package com.stpl.pms.hibernate.mapping;

/**
 * StPmSocialFbMapping entity. @author MyEclipse Persistence Tools
 */

public class StPmSocialLoginMapping implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private String token;
	private String socialId;
	private String provider;

	// Constructors

	/** default constructor */
	public StPmSocialLoginMapping() {
	}

	/** minimal constructor */
	public StPmSocialLoginMapping(Long playerId, String socialId) {
		this.playerId = playerId;
		this.socialId = socialId;
	}

	/** full constructor */
	public StPmSocialLoginMapping(Long playerId, String token, String socialId) {
		this.playerId = playerId;
		this.token = token;
		this.socialId = socialId;
	}

	// Property accessors

	public StPmSocialLoginMapping(Long playerId, String token, String socialId, String provider) {
		super();
		this.playerId = playerId;
		this.token = token;
		this.socialId = socialId;
		this.provider = provider;
	}

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

	public String getSocialId() {
		return this.socialId;
	}

	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

}