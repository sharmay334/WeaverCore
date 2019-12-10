package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class VipLevelMasterBean implements Serializable,Comparable<VipLevelMasterBean> {
	private static final long serialVersionUID = 1L;

	private long id;
	private short domainId;
	private int vipLevel;
	private String vipCode;
	private String vipDispCode;
	private String vipColor;
	private String levelType;
	private String vipRule;
	private String vipGroup;
	private String status;
	private long lastUpdateBy;
	private Timestamp updateDatetime;
	private String remarks;
	
	public VipLevelMasterBean() {
	}

	public VipLevelMasterBean(long id, short domainId, int vipLevel,
			String vipCode, String vipColor, String levelType, String vipRule,
			String status, String vipGroup, String vipDispCode, String remarks) {
		this.id = id;
		this.domainId = domainId;
		this.vipLevel = vipLevel;
		this.vipCode = vipCode;
		this.vipColor = vipColor;
		this.levelType = levelType;
		this.vipRule = vipRule;
		this.status = status;
		this.vipGroup = vipGroup;
		this.vipDispCode = vipDispCode;
		this.remarks = remarks;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getVipCode() {
		return vipCode;
	}

	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}

	public String getVipColor() {
		return vipColor;
	}

	public void setVipColor(String vipColor) {
		this.vipColor = vipColor;
	}

	public String getLevelType() {
		return levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	public String getVipRule() {
		return vipRule;
	}

	public void setVipRule(String vipRule) {
		this.vipRule = vipRule;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setLastUpdateBy(long lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public long getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public Timestamp getUpdateDatetime() {
		return updateDatetime;
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

	public int compareTo(VipLevelMasterBean vip) {
		//for asc
		return this.vipLevel-vip.vipLevel;
	}

	@Override
	public String toString() {
		return "VipLevelMasterBean [domainId=" + domainId + ", id=" + id
				+ ", lastUpdateBy=" + lastUpdateBy + ", levelType=" + levelType
				+ ", status=" + status + ", updateDatetime=" + updateDatetime
				+ ", vipCode=" + vipCode + ", vipColor=" + vipColor
				+ ", vipDispCode=" + vipDispCode + ", vipGroup=" + vipGroup
				+ ", vipLevel=" + vipLevel + ", vipRule=" + vipRule + "]";
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}

}
