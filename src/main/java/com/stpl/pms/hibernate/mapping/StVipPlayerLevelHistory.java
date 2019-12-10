package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StVipPlayerLevelHistory entity. @author MyEclipse Persistence Tools
 */

public class StVipPlayerLevelHistory implements java.io.Serializable,Cloneable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Long playerId;
	private Short domainId;
	private Integer boUserId;
	private Integer oldVipLevel;
	private Integer newVipLevel;
	private String oldVipType;
	private String newVipType;
	private Timestamp changeDate;

	// Constructors

	/** default constructor */
	public StVipPlayerLevelHistory() {
	}

	/** full constructor */
	public StVipPlayerLevelHistory(Long playerId, Short domainId,
			Integer boUserId, Integer oldVipLevel, Integer newVipLevel,
			String oldVipType, String newVipType, Timestamp changeDate) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.boUserId = boUserId;
		this.oldVipLevel = oldVipLevel;
		this.newVipLevel = newVipLevel;
		this.oldVipType = oldVipType;
		this.newVipType = newVipType;
		this.changeDate = changeDate;
	}
	
	@Override
	public StVipPlayerLevelHistory clone() throws CloneNotSupportedException {
		StVipPlayerLevelHistory newObj = (StVipPlayerLevelHistory)super.clone();
		newObj.id = null;
		return newObj;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public Integer getBoUserId() {
		return this.boUserId;
	}

	public void setBoUserId(Integer boUserId) {
		this.boUserId = boUserId;
	}

	public Integer getOldVipLevel() {
		return this.oldVipLevel;
	}

	public void setOldVipLevel(Integer oldVipLevel) {
		this.oldVipLevel = oldVipLevel;
	}

	public Integer getNewVipLevel() {
		return this.newVipLevel;
	}

	public void setNewVipLevel(Integer newVipLevel) {
		this.newVipLevel = newVipLevel;
	}

	public String getOldVipType() {
		return this.oldVipType;
	}

	public void setOldVipType(String oldVipType) {
		this.oldVipType = oldVipType;
	}

	public String getNewVipType() {
		return this.newVipType;
	}

	public void setNewVipType(String newVipType) {
		this.newVipType = newVipType;
	}

	public Timestamp getChangeDate() {
		return this.changeDate;
	}

	public void setChangeDate(Timestamp changeDate) {
		this.changeDate = changeDate;
	}

}