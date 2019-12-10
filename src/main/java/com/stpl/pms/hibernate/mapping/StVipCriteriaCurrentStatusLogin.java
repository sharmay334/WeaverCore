package com.stpl.pms.hibernate.mapping;

/**
 * StVipCriteriaCurrentStatusLogin entity. @author MyEclipse Persistence Tools
 */

public class StVipCriteriaCurrentStatusLogin implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Double lastMonthFreq;
	private Long lastMonthCount;
	private Double lastQuarterFreq;
	private Long lastQuarterCount;
	private Double lastYearFreq;
	private Long lastYearCount;
	private Double sinceRegiFreq;
	private Long sinceRegiCount;

	// Constructors

	/** default constructor */
	public StVipCriteriaCurrentStatusLogin() {
	}

	/** full constructor */
	public StVipCriteriaCurrentStatusLogin(Long playerId, Short domainId,
			Double lastMonthFreq, Long lastMonthCount, Double lastQuarterFreq,
			Long lastQuarterCount, Double lastYearFreq, Long lastYearCount,
			Double sinceRegiFreq, Long sinceRegiCount) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.lastMonthFreq = lastMonthFreq;
		this.lastMonthCount = lastMonthCount;
		this.lastQuarterFreq = lastQuarterFreq;
		this.lastQuarterCount = lastQuarterCount;
		this.lastYearFreq = lastYearFreq;
		this.lastYearCount = lastYearCount;
		this.sinceRegiFreq = sinceRegiFreq;
		this.sinceRegiCount = sinceRegiCount;
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

	public Double getLastMonthFreq() {
		return this.lastMonthFreq;
	}

	public void setLastMonthFreq(Double lastMonthFreq) {
		this.lastMonthFreq = lastMonthFreq;
	}

	public Long getLastMonthCount() {
		return this.lastMonthCount;
	}

	public void setLastMonthCount(Long lastMonthCount) {
		this.lastMonthCount = lastMonthCount;
	}

	public Double getLastQuarterFreq() {
		return this.lastQuarterFreq;
	}

	public void setLastQuarterFreq(Double lastQuarterFreq) {
		this.lastQuarterFreq = lastQuarterFreq;
	}

	public Long getLastQuarterCount() {
		return this.lastQuarterCount;
	}

	public void setLastQuarterCount(Long lastQuarterCount) {
		this.lastQuarterCount = lastQuarterCount;
	}

	public Double getLastYearFreq() {
		return this.lastYearFreq;
	}

	public void setLastYearFreq(Double lastYearFreq) {
		this.lastYearFreq = lastYearFreq;
	}

	public Long getLastYearCount() {
		return this.lastYearCount;
	}

	public void setLastYearCount(Long lastYearCount) {
		this.lastYearCount = lastYearCount;
	}

	public Double getSinceRegiFreq() {
		return this.sinceRegiFreq;
	}

	public void setSinceRegiFreq(Double sinceRegiFreq) {
		this.sinceRegiFreq = sinceRegiFreq;
	}

	public Long getSinceRegiCount() {
		return this.sinceRegiCount;
	}

	public void setSinceRegiCount(Long sinceRegiCount) {
		this.sinceRegiCount = sinceRegiCount;
	}

}