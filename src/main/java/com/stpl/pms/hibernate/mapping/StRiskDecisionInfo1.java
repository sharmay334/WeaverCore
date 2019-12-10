package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

import com.stpl.pms.javabeans.DecisionInfoMarkerBean;

/**
 * StRiskDecisionInfo1 entity. @author MyEclipse Persistence Tools
 */

public class StRiskDecisionInfo1 implements java.io.Serializable,DecisionInfoMarkerBean {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short domainId;
	private Long playerId;
	private String value;
	private String userId;
	private Timestamp updDatetime;
	private StRiskDecisionDoerMaster doerMaster;
	// Constructors

	/** default constructor */
	public StRiskDecisionInfo1() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getUpdDatetime() {
		return this.updDatetime;
	}

	public void setUpdDatetime(Timestamp updDatetime) {
		this.updDatetime = updDatetime;
	}

	public void setDoerMaster(StRiskDecisionDoerMaster doerMaster) {
		this.doerMaster = doerMaster;
	}

	public StRiskDecisionDoerMaster getDoerMaster() {
		return doerMaster;
	}

}