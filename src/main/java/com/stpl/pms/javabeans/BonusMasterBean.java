package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Timestamp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class BonusMasterBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private long bonusId;
	private String bonusDispCode;
	// When to give bonus starts
	private String availabilityType;
	private Timestamp availableFromDate;
	private Timestamp availableToDate;
	private String playerEvent;
	private Integer availableBeforeDays;
	private Integer availableAfterDays;
	private Integer activityId;
	private String activityValue;
	private double activityValueMin;
	private double activityValueMax;
	// When to give bonus ends

	private short domainId;
	private String eligibilityGroup;
	private BonusEligibilityCriteriaBean eligibilityBean;
	private String eligibilityBeanStr;
	private String bonusValueAs;
	private String bonusValueType;
	private double bonusValue;
	private double maxBonusValue;

	private Integer maxUsageCount;
	private Integer totalUsageCount;
	private Integer playerUsageCount;
	private String expiryAfterAcceptType;
	private Timestamp expiryAfterAcceptDate;
	private Integer expiryAfterAcceptDays;

	//private String gameGroupType;
	private String gameBonusCriteria;
	private String wrType;
	private String wrTargetType;
	private double wrTargetValue;
	private Integer redemptionCycle;

	private String optoutOption;
	private String singleBonus;
	private String deliveryMode;
	private String isRedeemable;
	private String ifDuplicate;
	private Short bonusOrderBo;
	private String status;

	private String visibility;
	private String promoCode;
	
	private BonusDevicEligibilityBean bonusDevicEligibilityBean;
	private String deviceEligibilityBeanStr;
	
	private BonusGameEligibilityBean bonusGameEligibilityBean;
	private String gameEligibilityBeanStr;
	
	private short aliasId;

	public long getBonusId() {
		return bonusId;
	}

	public void setBonusId(long bonusId) {
		this.bonusId = bonusId;
	}

	public String getBonusDispCode() {
		return bonusDispCode;
	}

	public void setBonusDispCode(String bonusDispCode) {
		this.bonusDispCode = bonusDispCode;
	}

	public String getAvailabilityType() {
		return availabilityType;
	}

	public void setAvailabilityType(String availabilityType) {
		this.availabilityType = availabilityType;
	}

	public Timestamp getAvailableFromDate() {
		return availableFromDate;
	}

	public void setAvailableFromDate(Timestamp availableFromDate) {
		this.availableFromDate = availableFromDate;
	}

	public Timestamp getAvailableToDate() {
		return availableToDate;
	}

	public void setAvailableToDate(Timestamp availableToDate) {
		this.availableToDate = availableToDate;
	}

	public String getPlayerEvent() {
		return playerEvent;
	}

	public void setPlayerEvent(String playerEvent) {
		this.playerEvent = playerEvent;
	}

	public Integer getAvailableBeforeDays() {
		return availableBeforeDays;
	}

	public void setAvailableBeforeDays(Integer availableBeforeDays) {
		this.availableBeforeDays = availableBeforeDays;
	}

	public Integer getAvailableAfterDays() {
		return availableAfterDays;
	}

	public void setAvailableAfterDays(Integer availableAfterDays) {
		this.availableAfterDays = availableAfterDays;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityValue() {
		return activityValue;
	}

	public void setActivityValue(String activityValue) {
		this.activityValue = activityValue;
	}

	public double getActivityValueMin() {
		return activityValueMin;
	}

	public void setActivityValueMin(double activityValueMin) {
		this.activityValueMin = activityValueMin;
	}

	public double getActivityValueMax() {
		return activityValueMax;
	}

	public void setActivityValueMax(double activityValueMax) {
		this.activityValueMax = activityValueMax;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public String getBonusValueAs() {
		return bonusValueAs;
	}

	public void setBonusValueAs(String bonusValueAs) {
		this.bonusValueAs = bonusValueAs;
	}

	public String getBonusValueType() {
		return bonusValueType;
	}

	public void setBonusValueType(String bonusValueType) {
		this.bonusValueType = bonusValueType;
	}

	public double getBonusValue() {
		return bonusValue;
	}

	public void setBonusValue(double bonusValue) {
		this.bonusValue = bonusValue;
	}

	public double getMaxBonusValue() {
		return maxBonusValue;
	}

	public void setMaxBonusValue(double maxBonusValue) {
		this.maxBonusValue = maxBonusValue;
	}

	public Integer getMaxUsageCount() {
		return maxUsageCount;
	}

	public void setMaxUsageCount(Integer maxUsageCount) {
		this.maxUsageCount = maxUsageCount;
	}

	public Integer getPlayerUsageCount() {
		return playerUsageCount;
	}

	public void setPlayerUsageCount(Integer playerUsageCount) {
		this.playerUsageCount = playerUsageCount;
	}

	public String getExpiryAfterAcceptType() {
		return expiryAfterAcceptType;
	}

	public void setExpiryAfterAcceptType(String expiryAfterAcceptType) {
		this.expiryAfterAcceptType = expiryAfterAcceptType;
	}

	public Timestamp getExpiryAfterAcceptDate() {
		return expiryAfterAcceptDate;
	}

	public void setExpiryAfterAcceptDate(Timestamp expiryAfterAcceptDate) {
		this.expiryAfterAcceptDate = expiryAfterAcceptDate;
	}

	public Integer getExpiryAfterAcceptDays() {
		return expiryAfterAcceptDays;
	}

	public void setExpiryAfterAcceptDays(Integer expiryAfterAcceptDays) {
		this.expiryAfterAcceptDays = expiryAfterAcceptDays;
	}

	public String getWrType() {
		return wrType;
	}

	public void setWrType(String wrType) {
		this.wrType = wrType;
	}

	public String getWrTargetType() {
		return wrTargetType;
	}

	public void setWrTargetType(String wrTargetType) {
		this.wrTargetType = wrTargetType;
	}

	public double getWrTargetValue() {
		return wrTargetValue;
	}

	public void setWrTargetValue(double wrTargetValue) {
		this.wrTargetValue = wrTargetValue;
	}

	public Integer getRedemptionCycle() {
		return redemptionCycle;
	}

	public void setRedemptionCycle(Integer redemptionCycle) {
		this.redemptionCycle = redemptionCycle;
	}

	public String getOptoutOption() {
		return optoutOption;
	}

	public void setOptoutOption(String optoutOption) {
		this.optoutOption = optoutOption;
	}

	public String getSingleBonus() {
		return singleBonus;
	}

	public void setSingleBonus(String singleBonus) {
		this.singleBonus = singleBonus;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getIsRedeemable() {
		return isRedeemable;
	}

	public void setIsRedeemable(String isRedeemable) {
		this.isRedeemable = isRedeemable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	/*public void setEligibilityBean(String eligibilityBean) {
		Type type = new TypeToken<BonusEligibilityCriteriaBean>() {
		}.getType();
		this.eligibilityBean = new Gson().fromJson(eligibilityBean, type);
	}*/

	public void setEligibilityBean(BonusEligibilityCriteriaBean eligibilityBean) {
		this.eligibilityBean = eligibilityBean;
	}

	public BonusEligibilityCriteriaBean getEligibilityBean() {
		return eligibilityBean;
	}

	public String getEligibilityBeanStr() {
		return eligibilityBeanStr;
	}

	public void setEligibilityBeanStr(String eligibilityBeanStr) {
		Type type = new TypeToken<BonusEligibilityCriteriaBean>() {
		}.getType();
		this.eligibilityBean = new Gson().fromJson(eligibilityBeanStr, type);
	}
	
	public void setEligibilityGroup(String eligibilityGroup) {
		this.eligibilityGroup = eligibilityGroup;
	}

	public String getEligibilityGroup() {
		return eligibilityGroup;
	}

	public void setTotalUsageCount(Integer totalUsageCount) {
		this.totalUsageCount = totalUsageCount;
	}

	public Integer getTotalUsageCount() {
		return totalUsageCount;
	}

	public void setIfDuplicate(String ifDuplicate) {
		this.ifDuplicate = ifDuplicate;
	}

	public String getIfDuplicate() {
		return ifDuplicate;
	}

	public void setBonusOrderBo(Short bonusOrderBo) {
		this.bonusOrderBo = bonusOrderBo;
	}

	public Short getBonusOrderBo() {
		return bonusOrderBo;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public BonusDevicEligibilityBean getBonusDevicEligibilityBean() {
		return bonusDevicEligibilityBean;
	}

	public void setBonusDevicEligibilityBean(String bonusDevicEligibilityBean) {
		Type type = new TypeToken<BonusDevicEligibilityBean>() {
		}.getType();
		this.bonusDevicEligibilityBean = new Gson().fromJson(bonusDevicEligibilityBean, type);
	}
	
	public void setBonusDevicEligibilityBean(
			BonusDevicEligibilityBean bonusDevicEligibilityBean) {
		this.bonusDevicEligibilityBean = bonusDevicEligibilityBean;
	}
	
	

	public String getDeviceEligibilityBeanStr() {
		return deviceEligibilityBeanStr;
	}

	public void setDeviceEligibilityBeanStr(String deviceEligibilityBeanStr) {
		Type type = new TypeToken<BonusDevicEligibilityBean>() {
		}.getType();
		this.bonusDevicEligibilityBean = new Gson().fromJson(deviceEligibilityBeanStr, type);
	}
	
	

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	@Override
	public String toString() {
		return "BonusMasterBean [bonusId=" + bonusId + ", bonusDispCode="
				+ bonusDispCode + ", availabilityType=" + availabilityType
				+ ", availableFromDate=" + availableFromDate
				+ ", availableToDate=" + availableToDate + ", playerEvent="
				+ playerEvent + ", availableBeforeDays=" + availableBeforeDays
				+ ", availableAfterDays=" + availableAfterDays
				+ ", activityId=" + activityId + ", activityValue="
				+ activityValue + ", activityValueMin=" + activityValueMin
				+ ", activityValueMax=" + activityValueMax + ", domainId="
				+ domainId + ", eligibilityGroup=" + eligibilityGroup
				+ ", eligibilityBean=" + eligibilityBean
				+ ", eligibilityBeanStr=" + eligibilityBeanStr
				+ ", bonusValueAs=" + bonusValueAs + ", bonusValueType="
				+ bonusValueType + ", bonusValue=" + bonusValue
				+ ", maxBonusValue=" + maxBonusValue + ", maxUsageCount="
				+ maxUsageCount + ", totalUsageCount=" + totalUsageCount
				+ ", playerUsageCount=" + playerUsageCount
				+ ", expiryAfterAcceptType=" + expiryAfterAcceptType
				+ ", expiryAfterAcceptDate=" + expiryAfterAcceptDate
				+ ", expiryAfterAcceptDays=" + expiryAfterAcceptDays
				+ ", wrType=" + wrType + ", wrTargetType=" + wrTargetType
				+ ", wrTargetValue=" + wrTargetValue 
				+ ", optoutOption=" + optoutOption
				+ ", singleBonus=" + singleBonus + ", deliveryMode="
				+ deliveryMode + ", isRedeemable=" + isRedeemable
				+ ", ifDuplicate=" + ifDuplicate + ", bonusOrderBo="
				+ bonusOrderBo + ", status=" + status + ", promoCode="
				+ promoCode + ", bonusDevicEligibilityBean="
				+ bonusDevicEligibilityBean + ", deviceEligibilityBeanStr="
				+ deviceEligibilityBeanStr + ", visibility="+ visibility + "]";
	}

	/*public String getGameGroupType() {
		return gameGroupType;
	}

	public void setGameGroupType(String gameGroupType) {
		this.gameGroupType = gameGroupType;
	}*/

	public String getGameBonusCriteria() {
		return gameBonusCriteria;
	}

	public void setGameBonusCriteria(String gameBonusCriteria) {
		this.gameBonusCriteria = gameBonusCriteria;
	}

	

	public BonusGameEligibilityBean getBonusGameEligibilityBean() {
		return bonusGameEligibilityBean;
	}

	public void setBonusGameEligibilityBean(String bonusGameEligibilityBean) {
		Type type = new TypeToken<BonusGameEligibilityBean>() {
		}.getType();
		this.bonusGameEligibilityBean = new Gson().fromJson(bonusGameEligibilityBean, type);
	}
	public void setBonusGameEligibilityBean(
			BonusGameEligibilityBean bonusGameEligibilityBean) {
		this.bonusGameEligibilityBean = bonusGameEligibilityBean;
	}

	public String getGameEligibilityBeanStr() {
		return gameEligibilityBeanStr;
	}

	public void setGameEligibilityBeanStr(String gameEligibilityBeanStr) {
		Type type = new TypeToken<BonusGameEligibilityBean>() {
		}.getType();
		this.bonusGameEligibilityBean = new Gson().fromJson(gameEligibilityBeanStr, type);
	}

	public short getAliasId() {
		return aliasId;
	}

	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}
	

}
