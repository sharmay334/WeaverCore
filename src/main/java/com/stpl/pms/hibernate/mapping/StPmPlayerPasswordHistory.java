package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmPlayerPasswordHistory entity. @author MyEclipse Persistence Tools
 */

public class StPmPlayerPasswordHistory implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private String lastPassword;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public StPmPlayerPasswordHistory() {
	}

	/** full constructor */
	public StPmPlayerPasswordHistory(Long playerId, Short domainId,
			String lastPassword, Timestamp updateTime) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.lastPassword = lastPassword;
		this.updateTime = updateTime;
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

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getLastPassword() {
		return this.lastPassword;
	}

	public void setLastPassword(String lastPassword) {
		this.lastPassword = lastPassword;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}