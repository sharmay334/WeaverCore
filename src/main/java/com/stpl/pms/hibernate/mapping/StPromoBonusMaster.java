package com.stpl.pms.hibernate.mapping;

import java.sql.Blob;
import java.sql.Timestamp;

import org.hibernate.Hibernate;

/**
 * StPromoBonusMaster entity. @author MyEclipse Persistence Tools
 */

public class StPromoBonusMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long bonusId;
	private Short domainId;
	private String bonusDispCode;
	private String availabilityType;
	private Timestamp availableFromDate;
	private Timestamp availableToDate;
	private Integer availableBeforeDays;
	private Integer availableAfterDays;
	private String playerEvent;
	private Integer maxUsageCount;
	private Integer totalUsageCount;
	private Integer playerUsageCount;
	private String expiryAfterAcceptType;
	private Timestamp expiryAfterAcceptDate;
	private Integer expiryAfterAcceptDays;
	private Integer activityId;
	private String activityValue;
	private Double activityValueMin;
	private Double activityValueMax;
	private String wrType;
	private String wrTargetType;
	private Double wrTargetValue;
	private Integer redemptionCycle;
	private String bonusValueAs;
	private String bonusValueType;
	private Double bonusValue;
	private Double maxBonusValue;
	private String optoutOption;
	private String singleBonus;
	private String deliveryMode;
	private String isRedeemable;
	private Blob criteriaXml;
	private String eligibilityGroup;
	private String ifDuplicate;
	private Short bonusOrderBo;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifyBy;
	private Timestamp modifyOn;
	private String status;
	private String promoCode;
	private String visibility;
	private Blob deviceXml;

	private Blob gameGroupXml;
	private String gameBonusCriteria;
	
	private Short aliasId;
	
	// Constructors

	/** default constructor */
	public StPromoBonusMaster() {
	}

	// Property accessors

	public Long getBonusId() {
		return this.bonusId;
	}

	public void setBonusId(Long bonusId) {
		this.bonusId = bonusId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getBonusDispCode() {
		return this.bonusDispCode;
	}

	public void setBonusDispCode(String bonusDispCode) {
		this.bonusDispCode = bonusDispCode;
	}

	public String getAvailabilityType() {
		return this.availabilityType;
	}

	public void setAvailabilityType(String availabilityType) {
		this.availabilityType = availabilityType;
	}

	public Timestamp getAvailableFromDate() {
		return this.availableFromDate;
	}

	public void setAvailableFromDate(Timestamp availableFromDate) {
		this.availableFromDate = availableFromDate;
	}

	public Timestamp getAvailableToDate() {
		return this.availableToDate;
	}

	public void setAvailableToDate(Timestamp availableToDate) {
		this.availableToDate = availableToDate;
	}

	public Integer getAvailableBeforeDays() {
		return this.availableBeforeDays;
	}

	public void setAvailableBeforeDays(Integer availableBeforeDays) {
		this.availableBeforeDays = availableBeforeDays;
	}

	public Integer getAvailableAfterDays() {
		return this.availableAfterDays;
	}

	public void setAvailableAfterDays(Integer availableAfterDays) {
		this.availableAfterDays = availableAfterDays;
	}

	public String getPlayerEvent() {
		return this.playerEvent;
	}

	public void setPlayerEvent(String playerEvent) {
		this.playerEvent = playerEvent;
	}

	public Integer getMaxUsageCount() {
		return this.maxUsageCount;
	}

	public void setMaxUsageCount(Integer maxUsageCount) {
		this.maxUsageCount = maxUsageCount;
	}

	public Integer getPlayerUsageCount() {
		return this.playerUsageCount;
	}

	public void setPlayerUsageCount(Integer playerUsageCount) {
		this.playerUsageCount = playerUsageCount;
	}

	public String getExpiryAfterAcceptType() {
		return this.expiryAfterAcceptType;
	}

	public void setExpiryAfterAcceptType(String expiryAfterAcceptType) {
		this.expiryAfterAcceptType = expiryAfterAcceptType;
	}

	public Timestamp getExpiryAfterAcceptDate() {
		return this.expiryAfterAcceptDate;
	}

	public void setExpiryAfterAcceptDate(Timestamp expiryAfterAcceptDate) {
		this.expiryAfterAcceptDate = expiryAfterAcceptDate;
	}

	public Integer getExpiryAfterAcceptDays() {
		return this.expiryAfterAcceptDays;
	}

	public void setExpiryAfterAcceptDays(Integer expiryAfterAcceptDays) {
		this.expiryAfterAcceptDays = expiryAfterAcceptDays;
	}

	public Integer getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityValue() {
		return this.activityValue;
	}

	public void setActivityValue(String activityValue) {
		this.activityValue = activityValue;
	}

	public Double getActivityValueMin() {
		return this.activityValueMin;
	}

	public void setActivityValueMin(Double activityValueMin) {
		this.activityValueMin = activityValueMin;
	}

	public Double getActivityValueMax() {
		return this.activityValueMax;
	}

	public void setActivityValueMax(Double activityValueMax) {
		this.activityValueMax = activityValueMax;
	}

	public String getWrType() {
		return this.wrType;
	}

	public void setWrType(String wrType) {
		this.wrType = wrType;
	}

	public String getWrTargetType() {
		return this.wrTargetType;
	}

	public void setWrTargetType(String wrTargetType) {
		this.wrTargetType = wrTargetType;
	}

	public Double getWrTargetValue() {
		return this.wrTargetValue;
	}

	public void setWrTargetValue(Double wrTargetValue) {
		this.wrTargetValue = wrTargetValue;
	}

	public Integer getRedemptionCycle() {
		return this.redemptionCycle;
	}

	public void setRedemptionCycle(Integer redemptionCycle) {
		this.redemptionCycle = redemptionCycle;
	}

	public String getBonusValueAs() {
		return this.bonusValueAs;
	}

	public void setBonusValueAs(String bonusValueAs) {
		this.bonusValueAs = bonusValueAs;
	}

	public String getBonusValueType() {
		return this.bonusValueType;
	}

	public void setBonusValueType(String bonusValueType) {
		this.bonusValueType = bonusValueType;
	}

	public Double getBonusValue() {
		return this.bonusValue;
	}

	public void setBonusValue(Double bonusValue) {
		this.bonusValue = bonusValue;
	}

	public Double getMaxBonusValue() {
		return this.maxBonusValue;
	}

	public void setMaxBonusValue(Double maxBonusValue) {
		this.maxBonusValue = maxBonusValue;
	}

	public String getOptoutOption() {
		return this.optoutOption;
	}

	public void setOptoutOption(String optoutOption) {
		this.optoutOption = optoutOption;
	}

	public String getSingleBonus() {
		return this.singleBonus;
	}

	public void setSingleBonus(String singleBonus) {
		this.singleBonus = singleBonus;
	}

	public String getDeliveryMode() {
		return this.deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getIsRedeemable() {
		return this.isRedeemable;
	}

	public void setIsRedeemable(String isRedeemable) {
		this.isRedeemable = isRedeemable;
	}

	public Blob getCriteriaXml() {
		return this.criteriaXml;
	}

	public void setCriteriaXml(Blob criteriaXml) {
		this.criteriaXml = criteriaXml;
	}

	public void setCriteriaXml(String criteriaXml) {
		this.criteriaXml = Hibernate.createBlob(criteriaXml.getBytes());
	}

	
	public Blob getDeviceXml() {
		return this.deviceXml;
	}

	public void setDeviceXml(Blob deviceXml) {
		this.deviceXml = deviceXml;
	}
	
	public void setDeviceXml(String deviceXml) {
		this.deviceXml = Hibernate.createBlob(deviceXml.getBytes());
	}

	public String getEligibilityGroup() {
		return this.eligibilityGroup;
	}

	public void setEligibilityGroup(String eligibilityGroup) {
		this.eligibilityGroup = eligibilityGroup;
	}

	public String getIfDuplicate() {
		return this.ifDuplicate;
	}

	public void setIfDuplicate(String ifDuplicate) {
		this.ifDuplicate = ifDuplicate;
	}

	public Short getBonusOrderBo() {
		return this.bonusOrderBo;
	}

	public void setBonusOrderBo(Short bonusOrderBo) {
		this.bonusOrderBo = bonusOrderBo;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getModifyBy() {
		return this.modifyBy;
	}

	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Timestamp getModifyOn() {
		return this.modifyOn;
	}

	public void setModifyOn(Timestamp modifyOn) {
		this.modifyOn = modifyOn;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTotalUsageCount(Integer totalUsageCount) {
		this.totalUsageCount = totalUsageCount;
	}

	public Integer getTotalUsageCount() {
		return totalUsageCount;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public Blob getGameGroupXml() {
		return gameGroupXml;
	}

	public void setGameGroupXml(Blob gameGroupXml) {
		this.gameGroupXml = gameGroupXml;
	}

	public void setGameGroupXml(String gameGroupXml) {
		this.gameGroupXml = Hibernate.createBlob(gameGroupXml.getBytes());
	}
	
	public String getGameBonusCriteria() {
		return gameBonusCriteria;
	}

	public void setGameBonusCriteria(String gameBonusCriteria) {
		this.gameBonusCriteria = gameBonusCriteria;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}
	
	
	
}