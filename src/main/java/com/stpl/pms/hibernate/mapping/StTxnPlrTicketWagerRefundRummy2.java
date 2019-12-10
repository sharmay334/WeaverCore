package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrTicketWagerRefundRummy2 entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrTicketWagerRefundRummy2 implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Long ticketId;
	private Timestamp transactionDate;
	private Double ticketCount;
	private Long gameId;
	private String refTxnNo;
	private Long refWagerTxnId;
	private String gameType;
	private String gameName;
	private Short vendorId;
	private String isCancel;

	// Constructors

	/** default constructor */
	public StTxnPlrTicketWagerRefundRummy2() {
	}

	/** full constructor */
	public StTxnPlrTicketWagerRefundRummy2(Long transactionId, Long playerId,
			Short domainId, Short aliasId, Long ticketId, Timestamp transactionDate,
			Double ticketCount, Long gameId, String refTxnNo,
			Long refWagerTxnId, String gameType, String gameName,
			Short vendorId, String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.ticketId = ticketId;
		this.transactionDate = transactionDate;
		this.ticketCount = ticketCount;
		this.gameId = gameId;
		this.refTxnNo = refTxnNo;
		this.refWagerTxnId = refWagerTxnId;
		this.gameType = gameType;
		this.gameName = gameName;
		this.vendorId = vendorId;
		this.isCancel = isCancel;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Timestamp getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getTicketCount() {
		return this.ticketCount;
	}

	public void setTicketCount(Double ticketCount) {
		this.ticketCount = ticketCount;
	}

	public Long getGameId() {
		return this.gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getRefTxnNo() {
		return this.refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public Long getRefWagerTxnId() {
		return this.refWagerTxnId;
	}

	public void setRefWagerTxnId(Long refWagerTxnId) {
		this.refWagerTxnId = refWagerTxnId;
	}

	public String getGameType() {
		return this.gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getGameName() {
		return this.gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Short getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Short vendorId) {
		this.vendorId = vendorId;
	}

	public String getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}