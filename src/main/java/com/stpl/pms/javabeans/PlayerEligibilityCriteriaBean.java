package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class PlayerEligibilityCriteriaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String playerType;
	private Integer depositCount;
	private String mobileVerified;
	private String emailVerified;
	private String ageVerified;
	private String addressVerified;
	private String playerStatus;
	private String isCashBalance;
	private String isBonusBalance;
	private Double wagerAmount; 
	private Timestamp depositStartDate;
	private Timestamp depositEndDate;
	private Timestamp wagerStartDate;
	private Timestamp wagerEndDate;
	private Double depositAmount;
	private String eligibilityRelation;
	private List<String> state;
	private List<String> loyaltyTier;
	
	
	public static final String AND="AND";
	public static final String OR="OR";
	

	public Timestamp getDepositStartDate() {
		return depositStartDate;
	}

	public void setDepositStartDate(Timestamp depositStartDate) {
		this.depositStartDate = depositStartDate;
	}

	public Timestamp getDepositEndDate() {
		return depositEndDate;
	}

	public void setDepositEndDate(Timestamp depositEndDate) {
		this.depositEndDate = depositEndDate;
	}

	public Timestamp getWagerStartDate() {
		return wagerStartDate;
	}

	public void setWagerStartDate(Timestamp wagerStartDate) {
		this.wagerStartDate = wagerStartDate;
	}

	public Timestamp getWagerEndDate() {
		return wagerEndDate;
	}

	public void setWagerEndDate(Timestamp wagerEndDate) {
		this.wagerEndDate = wagerEndDate;
	}

	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	public Integer getDepositCount() {
		return depositCount;
	}

	public void setDepositCount(Integer depositCount) {
		this.depositCount = depositCount;
	}

	public String getMobileVerified() {
		return mobileVerified;
	}

	public void setMobileVerified(String mobileVerified) {
		this.mobileVerified = mobileVerified;
	}

	public String getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(String emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getAgeVerified() {
		return ageVerified;
	}

	public void setAgeVerified(String ageVerified) {
		this.ageVerified = ageVerified;
	}

	public String getAddressVerified() {
		return addressVerified;
	}

	public void setAddressVerified(String addressVerified) {
		this.addressVerified = addressVerified;
	}

	public String getPlayerStatus() {
		return playerStatus;
	}

	public void setPlayerStatus(String playerStatus) {
		this.playerStatus = playerStatus;
	}

	public String getIsCashBalance() {
		return isCashBalance;
	}

	public void setIsCashBalance(String isCashBalance) {
		this.isCashBalance = isCashBalance;
	}

	public String getIsBonusBalance() {
		return isBonusBalance;
	}

	public void setIsBonusBalance(String isBonusBalance) {
		this.isBonusBalance = isBonusBalance;
	}

	public Double getWagerAmount() {
		return wagerAmount;
	}

	public void setWagerAmount(Double wagerAmount) {
		this.wagerAmount = wagerAmount;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public String getEligibilityRelation() {
		return eligibilityRelation;
	}

	public void setEligibilityRelation(String eligibilityRelation) {
		this.eligibilityRelation = eligibilityRelation;
	}

	public List<String> getState() {
		return state;
	}

	public void setState(List<String> state) {
		this.state = state;
	}

	public List<String> getLoyaltyTier() {
		return loyaltyTier;
	}

	public void setLoyaltyTier(List<String> loyaltyTier) {
		this.loyaltyTier = loyaltyTier;
	}

}
