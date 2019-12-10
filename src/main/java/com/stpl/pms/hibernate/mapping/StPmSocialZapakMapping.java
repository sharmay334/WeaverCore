package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPmSocialZapakMapping entity. @author MyEclipse Persistence Tools
 */

public class StPmSocialZapakMapping implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private String zapakUserId;
	private Timestamp zapakRegDate;

	// Constructors

	/** default constructor */
	public StPmSocialZapakMapping() {
	}

	/** full constructor */
	public StPmSocialZapakMapping(Long playerId, String zapakUserId,
			Timestamp zapakRegDate) {
		this.playerId = playerId;
		this.zapakUserId = zapakUserId;
		this.zapakRegDate = zapakRegDate;
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

	public String getZapakUserId() {
		return this.zapakUserId;
	}

	public void setZapakUserId(String zapakUserId) {
		this.zapakUserId = zapakUserId;
	}

	public void setZapakRegDate(Timestamp zapakRegDate) {
		this.zapakRegDate = zapakRegDate;
	}

	public Timestamp getZapakRegDate() {
		return zapakRegDate;
	}

}