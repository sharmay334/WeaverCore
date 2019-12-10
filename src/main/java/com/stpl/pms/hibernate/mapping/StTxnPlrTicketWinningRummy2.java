package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrTicketWinningRummy2 entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrTicketWinningRummy2 implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Long ticketDetailId;
	private Timestamp transactionDate;
	private Integer ticketCount;
	private Long gameId;
	private String gameName;
	private String refTxnNo;
	private Short vendorId;
	private String isCancel;
	private String gameSessionId;

	// Constructors

	/** default constructor */
	public StTxnPlrTicketWinningRummy2() {
	}

	/** full constructor */
	public StTxnPlrTicketWinningRummy2(Long transactionId, Long playerId,
			Short domainId, Short aliasId, Long ticketDetailId, Timestamp transactionDate,
			Integer ticketCount, Long gameId, String gameName,
			String refTxnNo, Short vendorId, String isCancel,String gameSessionId) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.ticketDetailId = ticketDetailId;
		this.transactionDate = transactionDate;
		this.ticketCount = ticketCount;
		this.gameId = gameId;
		this.gameName = gameName;
		this.refTxnNo = refTxnNo;
		this.vendorId = vendorId;
		this.isCancel = isCancel;
		this.gameSessionId = gameSessionId;
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

	public Long getTicketDetailId() {
		return this.ticketDetailId;
	}

	public void setTicketDetailId(Long ticketDetailId) {
		this.ticketDetailId = ticketDetailId;
	}

	public Timestamp getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Integer getTicketCount() {
		return this.ticketCount;
	}

	public void setTicketCount(Integer ticketCount) {
		this.ticketCount = ticketCount;
	}

	public Long getGameId() {
		return this.gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return this.gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getRefTxnNo() {
		return this.refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
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

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getGameSessionId() {
		return gameSessionId;
	}

	public void setGameSessionId(String gameSessionId) {
		this.gameSessionId = gameSessionId;
	}
	
	

}