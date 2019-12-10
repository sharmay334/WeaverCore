package com.stpl.pms.javabeans;

import java.sql.Timestamp;

public class BonusSearchBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private long bonusId;
	private String bonusDispCode;
	private String relatedTo;
	private String activityName;
	private String activityValue;
	private double activityValueMin;
	private double activityValueMax;
	private String availabilityType;
	private Timestamp availableFromDate;
	private Timestamp availableToDate;
	private Integer availableBeforeDays;
	private Integer availableAfterDays;
	private String playerEvent;
	private String eligibilityGroup;
	private BonusEligibilityCriteriaBean eligibilityBean;
	private BonusDevicEligibilityBean bonusDevicEligibilityBean;
	private String status;
	private String visibility;
	private Short bonusOrderBo;
	private String promoCode;
	private String domainName;
	private String aliasName;
	private String gameBonusEligibilityCriteria;

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

	public String getRelatedTo() {
		return relatedTo;
	}

	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
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

	public String getPlayerEvent() {
		return playerEvent;
	}

	public void setPlayerEvent(String playerEvent) {
		this.playerEvent = playerEvent;
	}

	public String getEligibilityGroup() {
		return eligibilityGroup;
	}

	public void setEligibilityGroup(String eligibilityGroup) {
		this.eligibilityGroup = eligibilityGroup;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setEligibilityBean(BonusEligibilityCriteriaBean eligibilityBean) {
		this.eligibilityBean = eligibilityBean;
	}

	public BonusEligibilityCriteriaBean getEligibilityBean() {
		return eligibilityBean;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public BonusDevicEligibilityBean getBonusDevicEligibilityBean() {
		return bonusDevicEligibilityBean;
	}

	public void setBonusDevicEligibilityBean(
			BonusDevicEligibilityBean bonusDevicEligibilityBean) {
		this.bonusDevicEligibilityBean = bonusDevicEligibilityBean;
	}

	public Short getBonusOrderBo() {
		return bonusOrderBo;
	}

	public void setBonusOrderBo(Short bonusOrderBo) {
		this.bonusOrderBo = bonusOrderBo;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getGameBonusEligibilityCriteria() {
		return gameBonusEligibilityCriteria;
	}

	public void setGameBonusEligibilityCriteria(String gameBonusEligibilityCriteria) {
		this.gameBonusEligibilityCriteria = gameBonusEligibilityCriteria;
	}
	
	
}
