package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StRmBoUserPasswordHistory entity. @author MyEclipse Persistence Tools
 */

public class StRmBoUserPasswordHistory implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer userId;
	private String lastPassword;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public StRmBoUserPasswordHistory() {
	}

	/** full constructor */
	public StRmBoUserPasswordHistory(Integer userId, String lastPassword,
			Timestamp updateTime) {
		this.userId = userId;
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

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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