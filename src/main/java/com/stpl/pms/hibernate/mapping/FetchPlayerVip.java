package com.stpl.pms.hibernate.mapping;

/**
 * FetchPlayerVip entity. @author MyEclipse Persistence Tools
 */

public class FetchPlayerVip implements java.io.Serializable {

	// Fields
	
	private static final long serialVersionUID = 1L;
	private Long playerId;
	private Short domainId;
	private Integer vipLevel;
	private String levelType;

	// Constructors

	/** default constructor */
	public FetchPlayerVip() {
	}

	// Property accessors

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Integer getVipLevel() {
		return this.vipLevel;
	}

	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getLevelType() {
		return this.levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Short getDomainId() {
		return domainId;
	}

}