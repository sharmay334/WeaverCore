package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StCshPlrOfflineDepositBonusMapping entity. @author MyEclipse Persistence
 * Tools
 */

public class StCshPlrOfflineDepositBonusMapping implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long requestId;
	private Long playerId;
	private Long bonusId;
	private String bonusCode;
	private Double bonusAmt;
	private String bonusValueAs;
	private String isRedeemable;
	private Double redeemedBonusFreq;
	private Double wrTarget;
	private String promoCode;
	private Timestamp expiredDate;

	// Constructors

	/** default constructor */
	public StCshPlrOfflineDepositBonusMapping() {
	}

	/** full constructor */
	public StCshPlrOfflineDepositBonusMapping(Long requestId, Long playerId,
			Long bonusId, String bonusCode, Double bonusAmt,
			String bonusValueAs, String isRedeemable, Double redeemedBonusFreq,
			Double wrTarget, String promoCode, Timestamp expiredDate) {
		this.requestId = requestId;
		this.playerId = playerId;
		this.bonusId = bonusId;
		this.bonusCode = bonusCode;
		this.bonusAmt = bonusAmt;
		this.bonusValueAs = bonusValueAs;
		this.isRedeemable = isRedeemable;
		this.redeemedBonusFreq = redeemedBonusFreq;
		this.wrTarget = wrTarget;
		this.promoCode = promoCode;
		this.expiredDate = expiredDate;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
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

	public String getBonusValueAs() {
		return this.bonusValueAs;
	}

	public void setBonusValueAs(String bonusValueAs) {
		this.bonusValueAs = bonusValueAs;
	}

	public String getIsRedeemable() {
		return this.isRedeemable;
	}

	public void setIsRedeemable(String isRedeemable) {
		this.isRedeemable = isRedeemable;
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

	public String getPromoCode() {
		return this.promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public Timestamp getExpiredDate() {
		return this.expiredDate;
	}

	public void setExpiredDate(Timestamp expiredDate) {
		this.expiredDate = expiredDate;
	}

}