package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrTicketWinningRummy2 entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrLoyaltyWinningRummy2 implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private long transactionId;
	private long playerId;
	private short domainId;
	private short aliasId;
	private double loyaltyPoint;
	private Timestamp transactionDate;
	private long gameId;
	private String gameName;
	private String refTxnNo;
	private short vendorId;
	private String isCancel;
	private String gameSessionId;

	// Constructors

	/** default constructor */
	public StTxnPlrLoyaltyWinningRummy2() {
	}

	/** full constructor */
	public StTxnPlrLoyaltyWinningRummy2(long transactionId, long playerId,
			short domainId, short aliasId, double loyaltyPoint, Timestamp transactionDate,
			 long gameId, String gameName,
			String refTxnNo, short vendorId, String isCancel,String gameSessionId) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.loyaltyPoint = loyaltyPoint;
		this.transactionDate = transactionDate;
		this.gameId = gameId;
		this.gameName = gameName;
		this.refTxnNo = refTxnNo;
		this.vendorId = vendorId;
		this.isCancel = isCancel;
		this.gameSessionId = gameSessionId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public short getAliasId() {
		return aliasId;
	}

	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}

	public double getLoyaltyPoint() {
		return loyaltyPoint;
	}

	public void setLoyaltyPoint(double loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getRefTxnNo() {
		return refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public short getVendorId() {
		return vendorId;
	}

	public void setVendorId(short vendorId) {
		this.vendorId = vendorId;
	}

	public String getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}

	public String getGameSessionId() {
		return gameSessionId;
	}

	public void setGameSessionId(String gameSessionId) {
		this.gameSessionId = gameSessionId;
	}
	
	

	
	// Property accessors

	

}