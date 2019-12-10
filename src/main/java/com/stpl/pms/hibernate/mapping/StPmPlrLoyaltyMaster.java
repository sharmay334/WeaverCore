package com.stpl.pms.hibernate.mapping;

/**
 * StPmPlrLoyaltyMaster entity. @author MyEclipse Persistence Tools
 */

public class StPmPlrLoyaltyMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Long id;
	private Long playerId;
	private String userName;
	private Short domainId;
	private Short aliasId;
	private String gameGroup;
	private Long tierId;
	private String tierName;
	private String dateTierEntered;
	private Long balance;
	private Long pointsThisPeriod;
	private Long basePointThisPeriod;
	private String tierForLife;
	private String isEnabled;
	private Long gracePeriodDelta;
	private String periodStartDate;
	private String periodEndDate;
	private Long rakeAmtThisPeriod;
	private Long rakeHandCountPeriod;

	// Constructors

	/** default constructor */
	public StPmPlrLoyaltyMaster() {
	}

	/** minimal constructor */
	public StPmPlrLoyaltyMaster(Long playerId, String userName,
			Long loyaltyPoint, Long tierId) {
		this.playerId = playerId;
		this.userName = userName;
		this.tierId = tierId;
	}

	/** full constructor */
	public StPmPlrLoyaltyMaster(Long playerId, String userName, Short domainId,
			Short aliasId, String gameGroup,  Long tierId,
			String tierName, String dateTierEntered, Long balance,
			Long pointsThisPeriod, Long basePointThisPeriod,
			String tierForLife, String isEnabled, Long gracePeriodDelta,
			String periodStartDate, String periodEndDate,
			Long rakeAmtThisPeriod, Long rakeHandCountPeriod) {
		this.playerId = playerId;
		this.userName = userName;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.gameGroup = gameGroup;
		this.tierId = tierId;
		this.tierName = tierName;
		this.dateTierEntered = dateTierEntered;
		this.balance = balance;
		this.pointsThisPeriod = pointsThisPeriod;
		this.basePointThisPeriod = basePointThisPeriod;
		this.tierForLife = tierForLife;
		this.isEnabled = isEnabled;
		this.gracePeriodDelta = gracePeriodDelta;
		this.periodStartDate = periodStartDate;
		this.periodEndDate = periodEndDate;
		this.rakeAmtThisPeriod = rakeAmtThisPeriod;
		this.rakeHandCountPeriod = rakeHandCountPeriod;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Short getAliasId() {
		return this.aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getGameGroup() {
		return this.gameGroup;
	}

	public void setGameGroup(String gameGroup) {
		this.gameGroup = gameGroup;
	}


	public Long getTierId() {
		return this.tierId;
	}

	public void setTierId(Long tierId) {
		this.tierId = tierId;
	}

	public String getTierName() {
		return this.tierName;
	}

	public void setTierName(String tierName) {
		this.tierName = tierName;
	}

	public String getDateTierEntered() {
		return this.dateTierEntered;
	}

	public void setDateTierEntered(String dateTierEntered) {
		this.dateTierEntered = dateTierEntered;
	}

	public Long getBalance() {
		return this.balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getPointsThisPeriod() {
		return this.pointsThisPeriod;
	}

	public void setPointsThisPeriod(Long pointsThisPeriod) {
		this.pointsThisPeriod = pointsThisPeriod;
	}

	public Long getBasePointThisPeriod() {
		return this.basePointThisPeriod;
	}

	public void setBasePointThisPeriod(Long basePointThisPeriod) {
		this.basePointThisPeriod = basePointThisPeriod;
	}

	public String getTierForLife() {
		return this.tierForLife;
	}

	public void setTierForLife(String tierForLife) {
		this.tierForLife = tierForLife;
	}

	public String getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Long getGracePeriodDelta() {
		return this.gracePeriodDelta;
	}

	public void setGracePeriodDelta(Long gracePeriodDelta) {
		this.gracePeriodDelta = gracePeriodDelta;
	}

	public String getPeriodStartDate() {
		return this.periodStartDate;
	}

	public void setPeriodStartDate(String periodStartDate) {
		this.periodStartDate = periodStartDate;
	}

	public String getPeriodEndDate() {
		return this.periodEndDate;
	}

	public void setPeriodEndDate(String periodEndDate) {
		this.periodEndDate = periodEndDate;
	}

	public Long getRakeAmtThisPeriod() {
		return this.rakeAmtThisPeriod;
	}

	public void setRakeAmtThisPeriod(Long rakeAmtThisPeriod) {
		this.rakeAmtThisPeriod = rakeAmtThisPeriod;
	}

	public Long getRakeHandCountPeriod() {
		return this.rakeHandCountPeriod;
	}

	public void setRakeHandCountPeriod(Long rakeHandCountPeriod) {
		this.rakeHandCountPeriod = rakeHandCountPeriod;
	}

}