package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrBonusTransferHistory entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrBonusTransferHistory implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Long bonusId;
	private Double totalAmount;
	private Double totalCash;
	private Double totalBonus;
	private Double totalPendingWining;
	private Double transferAmount;
	private Long refTransId;
	private Timestamp transferDate;

	// Constructors

	/** default constructor */
	public StTxnPlrBonusTransferHistory() {
	}

	/** full constructor */
	public StTxnPlrBonusTransferHistory(Long playerId, Long bonusId,
			Double totalAmount, Double totalCash, Double totalBonus,
			Double totalPendingWining, Double transferAmount, Long refTransId,
			Timestamp transferDate) {
		this.playerId = playerId;
		this.bonusId = bonusId;
		this.totalAmount = totalAmount;
		this.totalCash = totalCash;
		this.totalBonus = totalBonus;
		this.totalPendingWining = totalPendingWining;
		this.transferAmount = transferAmount;
		this.refTransId = refTransId;
		this.transferDate = transferDate;
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

	public Long getBonusId() {
		return this.bonusId;
	}

	public void setBonusId(Long bonusId) {
		this.bonusId = bonusId;
	}

	public Double getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getTotalCash() {
		return this.totalCash;
	}

	public void setTotalCash(Double totalCash) {
		this.totalCash = totalCash;
	}

	public Double getTotalBonus() {
		return this.totalBonus;
	}

	public void setTotalBonus(Double totalBonus) {
		this.totalBonus = totalBonus;
	}

	public Double getTotalPendingWining() {
		return this.totalPendingWining;
	}

	public void setTotalPendingWining(Double totalPendingWining) {
		this.totalPendingWining = totalPendingWining;
	}

	public Double getTransferAmount() {
		return this.transferAmount;
	}

	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public Long getRefTransId() {
		return this.refTransId;
	}

	public void setRefTransId(Long refTransId) {
		this.refTransId = refTransId;
	}

	public Timestamp getTransferDate() {
		return this.transferDate;
	}

	public void setTransferDate(Timestamp transferDate) {
		this.transferDate = transferDate;
	}

}