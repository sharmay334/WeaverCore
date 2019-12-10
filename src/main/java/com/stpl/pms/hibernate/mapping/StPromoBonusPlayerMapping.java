package com.stpl.pms.hibernate.mapping;

/**
 * StPromoBonusPlayerMapping entity. @author MyEclipse Persistence Tools
 */

public class StPromoBonusPlayerMapping implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long bonusId;
	private Long playerId;
	private Short domainId;
	private Integer usageCount;
	private String couponCode;
	private String status;

	// Constructors

	/** default constructor */
	public StPromoBonusPlayerMapping() {
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

	public Integer getUsageCount() {
		return this.usageCount;
	}

	public void setUsageCount(Integer usageCount) {
		this.usageCount = usageCount;
	}

	public String getCouponCode() {
		return this.couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setBonusId(Long bonusId) {
		this.bonusId = bonusId;
	}

	public Long getBonusId() {
		return bonusId;
	}

}