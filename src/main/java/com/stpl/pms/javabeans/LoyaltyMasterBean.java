package com.stpl.pms.javabeans;

import java.io.Serializable;



public class LoyaltyMasterBean implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String success;
	private Integer tierId;
	private String tierName;
	private String DateTierEntered;
	private Long Balance;
	private Integer PointsThisPeriod;
	private Integer BasePointsThisPeriod;
	private Boolean TierForLife;
	private Boolean IsEnabled;
	private Integer GracePeriodDelta;
	private String PeriodStartDate;
	private String PeriodEndDate;
	private Integer RakedAmountThisPeriod;
	private Integer RakedHandCountThisPeriod;
	
	
	public String getTierName() {
		return tierName;
	}
	public void setTierName(String tierName) {
		this.tierName = tierName;
	}
	public String getDateTierEntered() {
		return DateTierEntered;
	}
	public void setDateTierEntered(String dateTierEntered) {
		DateTierEntered = dateTierEntered;
	}
	public Long getBalance() {
		return Balance;
	}
	public void setBalance(Long balance) {
		Balance = balance;
	}
	public Integer getPointsThisPeriod() {
		return PointsThisPeriod;
	}
	public void setPointsThisPeriod(Integer pointsThisPeriod) {
		PointsThisPeriod = pointsThisPeriod;
	}
	public Integer getBasePointsThisPeriod() {
		return BasePointsThisPeriod;
	}
	public void setBasePointsThisPeriod(Integer basePointsThisPeriod) {
		BasePointsThisPeriod = basePointsThisPeriod;
	}
	public Boolean getTierForLife() {
		return TierForLife;
	}
	public void setTierForLife(Boolean tierForLife) {
		TierForLife = tierForLife;
	}
	public Boolean getIsEnabled() {
		return IsEnabled;
	}
	public void setIsEnabled(Boolean isEnabled) {
		IsEnabled = isEnabled;
	}
	public Integer getGracePeriodDelta() {
		return GracePeriodDelta;
	}
	public void setGracePeriodDelta(Integer gracePeriodDelta) {
		GracePeriodDelta = gracePeriodDelta;
	}
	public String getPeriodStartDate() {
		return PeriodStartDate;
	}
	public void setPeriodStartDate(String periodStartDate) {
		PeriodStartDate = periodStartDate;
	}
	public String getPeriodEndDate() {
		return PeriodEndDate;
	}
	public void setPeriodEndDate(String periodEndDate) {
		PeriodEndDate = periodEndDate;
	}
	public Integer getRakedAmountThisPeriod() {
		return RakedAmountThisPeriod;
	}
	public void setRakedAmountThisPeriod(Integer rakedAmountThisPeriod) {
		RakedAmountThisPeriod = rakedAmountThisPeriod;
	}
	public Integer getRakedHandCountThisPeriod() {
		return RakedHandCountThisPeriod;
	}
	public void setRakedHandCountThisPeriod(Integer rakedHandCountThisPeriod) {
		RakedHandCountThisPeriod = rakedHandCountThisPeriod;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTierId() {
		return tierId;
	}
	public void setTierId(Integer tierId) {
		this.tierId = tierId;
	}
}
