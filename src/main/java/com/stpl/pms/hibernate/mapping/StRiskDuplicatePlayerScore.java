package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

@SuppressWarnings("serial")
public class StRiskDuplicatePlayerScore implements java.io.Serializable {

	private Long id;
	private Long newPlayerId;
	private Long oldPlayerId;
	private Double regDupScore;
	private Timestamp regVerifyDate;
	private String regStatus;
	private Integer regUserId;
	private Double depoDupScore;
	private Timestamp depoVerifyDate;
	private String depoStatus;
	private Integer depoUserId;
	private Double withDupScore;
	private Timestamp withVerifyDate;
	private String withStatus;
	private Integer withUserId;

	/** default constructor */
	public StRiskDuplicatePlayerScore() {
	}

	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNewPlayerId() {
		return this.newPlayerId;
	}

	public void setNewPlayerId(Long newPlayerId) {
		this.newPlayerId = newPlayerId;
	}

	public Long getOldPlayerId() {
		return this.oldPlayerId;
	}

	public void setOldPlayerId(Long oldPlayerId) {
		this.oldPlayerId = oldPlayerId;
	}

	public Double getRegDupScore() {
		return this.regDupScore;
	}

	public void setRegDupScore(Double regDupScore) {
		this.regDupScore = regDupScore;
	}

	public Timestamp getRegVerifyDate() {
		return this.regVerifyDate;
	}

	public void setRegVerifyDate(Timestamp regVerifyDate) {
		this.regVerifyDate = regVerifyDate;
	}

	public String getRegStatus() {
		return this.regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}

	public Integer getRegUserId() {
		return this.regUserId;
	}

	public void setRegUserId(Integer regUserId) {
		this.regUserId = regUserId;
	}

	public Double getDepoDupScore() {
		return this.depoDupScore;
	}

	public void setDepoDupScore(Double depoDupScore) {
		this.depoDupScore = depoDupScore;
	}

	public Timestamp getDepoVerifyDate() {
		return this.depoVerifyDate;
	}

	public void setDepoVerifyDate(Timestamp depoVerifyDate) {
		this.depoVerifyDate = depoVerifyDate;
	}

	public String getDepoStatus() {
		return this.depoStatus;
	}

	public void setDepoStatus(String depoStatus) {
		this.depoStatus = depoStatus;
	}

	public Integer getDepoUserId() {
		return this.depoUserId;
	}

	public void setDepoUserId(Integer depoUserId) {
		this.depoUserId = depoUserId;
	}

	public Double getWithDupScore() {
		return this.withDupScore;
	}

	public void setWithDupScore(Double withDupScore) {
		this.withDupScore = withDupScore;
	}

	public Timestamp getWithVerifyDate() {
		return this.withVerifyDate;
	}

	public void setWithVerifyDate(Timestamp withVerifyDate) {
		this.withVerifyDate = withVerifyDate;
	}

	public String getWithStatus() {
		return this.withStatus;
	}

	public void setWithStatus(String withStatus) {
		this.withStatus = withStatus;
	}

	public Integer getWithUserId() {
		return this.withUserId;
	}

	public void setWithUserId(Integer withUserId) {
		this.withUserId = withUserId;
	}

}