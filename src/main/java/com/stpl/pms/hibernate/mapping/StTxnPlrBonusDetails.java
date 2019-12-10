package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrBonusDetails entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrBonusDetails implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Short domainId;
	private Short aliasId;
	private Long playerId;
	private Long bonusId;
	private String bonusCode;
	private Double bonusAmt;
	private Double bonusAmtNative;
	private Double redeemedBonusAmt;
	private Double redeemedBonusAmtNative;
	private Double redeemedBonusFreq;
	private Double wrTarget;
	private Double wrContribution;
	private Double pendingWinning;
	private Double pendingBonus;
	private Timestamp receivedDate;
	private Timestamp expiredDate;
	private Timestamp refUsageDate;
	private String isRedeemable;
	private String wrStatus;
	private String bonusCriteria;
	// Constructors

	/** default constructor */
	public StTxnPlrBonusDetails() {
	}

	/** minimal constructor */
	public StTxnPlrBonusDetails(Short domainId, Long playerId, Long bonusId,
			String bonusCode, Double bonusAmt, Double bonusAmtNative,
			Double redeemedBonusAmtNative, Double wrTarget,
			Double wrContribution, Double pendingWinning, Double pendingBonus,
			String isRedeemable, String wrStatus) {
		this.domainId = domainId;
		this.playerId = playerId;
		this.bonusId = bonusId;
		this.bonusCode = bonusCode;
		this.bonusAmt = bonusAmt;
		this.bonusAmtNative = bonusAmtNative;
		this.redeemedBonusAmtNative = redeemedBonusAmtNative;
		this.wrTarget = wrTarget;
		this.wrContribution = wrContribution;
		this.pendingWinning = pendingWinning;
		this.pendingBonus = pendingBonus;
		this.isRedeemable = isRedeemable;
		this.wrStatus = wrStatus;
	}

	/** full constructor */
	public StTxnPlrBonusDetails(Short domainId, Long playerId, Long bonusId,
			String bonusCode, Double bonusAmt, Double bonusAmtNative,
			Double redeemedBonusAmt, Double redeemedBonusAmtNative,
			Double redeemedBonusFreq, Double wrTarget, Double wrContribution,
			Double pendingWinning, Double pendingBonus, Timestamp receivedDate,
			Timestamp expiredDate, Timestamp refUsageDate, String isRedeemable,
			String wrStatus) {
		this.domainId = domainId;
		this.playerId = playerId;
		this.bonusId = bonusId;
		this.bonusCode = bonusCode;
		this.bonusAmt = bonusAmt;
		this.bonusAmtNative = bonusAmtNative;
		this.redeemedBonusAmt = redeemedBonusAmt;
		this.redeemedBonusAmtNative = redeemedBonusAmtNative;
		this.redeemedBonusFreq = redeemedBonusFreq;
		this.wrTarget = wrTarget;
		this.wrContribution = wrContribution;
		this.pendingWinning = pendingWinning;
		this.pendingBonus = pendingBonus;
		this.receivedDate = receivedDate;
		this.expiredDate = expiredDate;
		this.refUsageDate = refUsageDate;
		this.isRedeemable = isRedeemable;
		this.wrStatus = wrStatus;
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

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Long getBonusId() {
		return this.bonusId;
	}

	public void setBonusId(Long bonusId) {
		this.bonusId = bonusId;
	}

	public String getBonusCode() {
		return this.bonusCode;
	}

	public void setBonusCode(String bonusCode) {
		this.bonusCode = bonusCode;
	}

	public Double getBonusAmt() {
		return this.bonusAmt;
	}

	public void setBonusAmt(Double bonusAmt) {
		this.bonusAmt = bonusAmt;
	}

	public Double getBonusAmtNative() {
		return this.bonusAmtNative;
	}

	public void setBonusAmtNative(Double bonusAmtNative) {
		this.bonusAmtNative = bonusAmtNative;
	}

	public Double getRedeemedBonusAmt() {
		return this.redeemedBonusAmt;
	}

	public void setRedeemedBonusAmt(Double redeemedBonusAmt) {
		this.redeemedBonusAmt = redeemedBonusAmt;
	}

	public Double getRedeemedBonusAmtNative() {
		return this.redeemedBonusAmtNative;
	}

	public void setRedeemedBonusAmtNative(Double redeemedBonusAmtNative) {
		this.redeemedBonusAmtNative = redeemedBonusAmtNative;
	}

	public Double getRedeemedBonusFreq() {
		return this.redeemedBonusFreq;
	}

	public void setRedeemedBonusFreq(Double redeemedBonusFreq) {
		this.redeemedBonusFreq = redeemedBonusFreq;
	}

	public Double getWrTarget() {
		return this.wrTarget;
	}

	public void setWrTarget(Double wrTarget) {
		this.wrTarget = wrTarget;
	}

	public Double getWrContribution() {
		return this.wrContribution;
	}

	public void setWrContribution(Double wrContribution) {
		this.wrContribution = wrContribution;
	}

	public Double getPendingWinning() {
		return this.pendingWinning;
	}

	public void setPendingWinning(Double pendingWinning) {
		this.pendingWinning = pendingWinning;
	}

	public Double getPendingBonus() {
		return this.pendingBonus;
	}

	public void setPendingBonus(Double pendingBonus) {
		this.pendingBonus = pendingBonus;
	}

	public Timestamp getReceivedDate() {
		return this.receivedDate;
	}

	public void setReceivedDate(Timestamp receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Timestamp getExpiredDate() {
		return this.expiredDate;
	}

	public void setExpiredDate(Timestamp expiredDate) {
		this.expiredDate = expiredDate;
	}

	public Timestamp getRefUsageDate() {
		return this.refUsageDate;
	}

	public void setRefUsageDate(Timestamp refUsageDate) {
		this.refUsageDate = refUsageDate;
	}

	public String getIsRedeemable() {
		return this.isRedeemable;
	}

	public void setIsRedeemable(String isRedeemable) {
		this.isRedeemable = isRedeemable;
	}

	public String getWrStatus() {
		return this.wrStatus;
	}

	public void setWrStatus(String wrStatus) {
		this.wrStatus = wrStatus;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getBonusCriteria() {
		return bonusCriteria;
	}

	public void setBonusCriteria(String bonusCriteria) {
		this.bonusCriteria = bonusCriteria;
	}
	
	

}