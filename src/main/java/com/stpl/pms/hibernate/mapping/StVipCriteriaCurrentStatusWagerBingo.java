package com.stpl.pms.hibernate.mapping;

/**
 * StVipCriteriaCurrentStatusWagerBingo entity. @author MyEclipse Persistence
 * Tools
 */

public class StVipCriteriaCurrentStatusWagerBingo implements
		java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Double lastMonthFreq;
	private Long lastMonthCount;
	private Double lastMonthValue;
	private Double lastQuarterFreq;
	private Long lastQuarterCount;
	private Double lastQuarterValue;
	private Double lastYearFreq;
	private Long lastYearCount;
	private Double lastYearValue;
	private Double sinceRegiFreq;
	private Long sinceRegiCount;
	private Double sinceRegiValue;

	// Constructors

	/** default constructor */
	public StVipCriteriaCurrentStatusWagerBingo() {
	}

	/** full constructor */
	public StVipCriteriaCurrentStatusWagerBingo(Long playerId, Short domainId,
			Double lastMonthFreq, Long lastMonthCount, Double lastMonthValue,
			Double lastQuarterFreq, Long lastQuarterCount,
			Double lastQuarterValue, Double lastYearFreq, Long lastYearCount,
			Double lastYearValue, Double sinceRegiFreq, Long sinceRegiCount,
			Double sinceRegiValue) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.lastMonthFreq = lastMonthFreq;
		this.lastMonthCount = lastMonthCount;
		this.lastMonthValue = lastMonthValue;
		this.lastQuarterFreq = lastQuarterFreq;
		this.lastQuarterCount = lastQuarterCount;
		this.lastQuarterValue = lastQuarterValue;
		this.lastYearFreq = lastYearFreq;
		this.lastYearCount = lastYearCount;
		this.lastYearValue = lastYearValue;
		this.sinceRegiFreq = sinceRegiFreq;
		this.sinceRegiCount = sinceRegiCount;
		this.sinceRegiValue = sinceRegiValue;
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

	public Double getLastMonthValue() {
		return this.lastMonthValue;
	}

	public void setLastMonthValue(Double lastMonthValue) {
		this.lastMonthValue = lastMonthValue;
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

	public Double getLastQuarterValue() {
		return this.lastQuarterValue;
	}

	public void setLastQuarterValue(Double lastQuarterValue) {
		this.lastQuarterValue = lastQuarterValue;
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

	public Double getLastYearValue() {
		return this.lastYearValue;
	}

	public void setLastYearValue(Double lastYearValue) {
		this.lastYearValue = lastYearValue;
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

	public Double getSinceRegiValue() {
		return this.sinceRegiValue;
	}

	public void setSinceRegiValue(Double sinceRegiValue) {
		this.sinceRegiValue = sinceRegiValue;
	}

}