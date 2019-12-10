package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StVipLevelMaster entity. @author MyEclipse Persistence Tools
 */

public class StVipLevelMaster implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Short domainId;
	private Integer vipLevel;
	private String vipCode;
	private String vipDispCode;
	private String vipGroup;
	private String vipColor;
	private String levelType;
	private String vipRule;
	private Long lastUpdateBy;
	private Timestamp updateDatetime;
	private String status;
	private String remarks;
	private Long createdBy;
	private Timestamp creationDate;

	// Constructors

	/** default constructor */
	public StVipLevelMaster() {
	}

	/** full constructor 
	 * @param remarks */
	public StVipLevelMaster(Short domainId, Integer vipLevel, String vipCode,
			String vipDispCode, String vipGroup, String vipColor,
			String levelType, String vipRule, Long lastUpdateBy,
			Timestamp updateDatetime, String status, String remarks) {
		this.domainId = domainId;
		this.vipLevel = vipLevel;
		this.vipCode = vipCode;
		this.vipGroup = vipGroup;
		this.vipColor = vipColor;
		this.levelType = levelType;
		this.vipRule = vipRule;
		this.lastUpdateBy = lastUpdateBy;
		this.updateDatetime = updateDatetime;
		this.status = status;
		this.vipDispCode = vipDispCode;
		this.remarks = remarks;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Integer getVipLevel() {
		return this.vipLevel;
	}

	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getVipCode() {
		return this.vipCode;
	}

	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}

	public String getVipColor() {
		return this.vipColor;
	}

	public void setVipColor(String vipColor) {
		this.vipColor = vipColor;
	}

	public String getLevelType() {
		return this.levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	public String getVipRule() {
		return this.vipRule;
	}

	public void setVipRule(String vipRule) {
		this.vipRule = vipRule;
	}

	public Long getLastUpdateBy() {
		return this.lastUpdateBy;
	}

	public void setLastUpdateBy(Long lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Timestamp getUpdateDatetime() {
		return this.updateDatetime;
	}

	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setVipGroup(String vipGroup) {
		this.vipGroup = vipGroup;
	}

	public String getVipGroup() {
		return vipGroup;
	}

	public void setVipDispCode(String vipDispCode) {
		this.vipDispCode = vipDispCode;
	}

	public String getVipDispCode() {
		return vipDispCode;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

}