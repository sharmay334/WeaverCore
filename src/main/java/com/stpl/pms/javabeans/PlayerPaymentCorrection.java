package com.stpl.pms.javabeans;

import java.sql.Timestamp;

public class PlayerPaymentCorrection implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private long transactionId;
	private long playerId;
	private String userName;
	private short domainId;
	private short aliasId;
	private Timestamp transactionDate;
	private int currencyId;
	private double amount;
	private String correctionType;
	private String reason;
	private String isCancel;
	private String withdrawableImpact;

	public PlayerPaymentCorrection() {
	}

	public PlayerPaymentCorrection(long transactionId, long playerId,
			short domainId, Timestamp transactionDate, int currencyId,
			double amount, String correctionType, String reason, String isCancel,String withdrawableImpact) {
		super();
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.currencyId = currencyId;
		this.amount = amount;
		this.correctionType = correctionType;
		this.reason = reason;
		this.isCancel = isCancel;
		this.withdrawableImpact = withdrawableImpact;
	}

	public PlayerPaymentCorrection( long playerId, short domainId,
			Double amount, String correctionType, String particular,
			String withdrawableImpact) {
		super();
		this.playerId = playerId;
		this.domainId = domainId;
		this.amount = amount;
		this.correctionType= correctionType;
		this.reason = particular;
		this.withdrawableImpact = withdrawableImpact;
	}
	public PlayerPaymentCorrection( long playerId, short domainId,Short aliasId,
			Double amount, String correctionType, String particular,
			String withdrawableImpact) {
		super();
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.amount = amount;
		this.correctionType= correctionType;
		this.reason = particular;
		this.withdrawableImpact = withdrawableImpact;
	}
	public PlayerPaymentCorrection(short domainId, String correctionType,
			String withdrawableImpact) {
		super();
		this.domainId = domainId;
		this.correctionType = correctionType;
		this.withdrawableImpact = withdrawableImpact;
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

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCorrectionType() {
		return correctionType;
	}

	public void setCorrectionType(String correctionType) {
		this.correctionType = correctionType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}

	public void setWithdrawableImpact(String withdrawableImpact) {
		this.withdrawableImpact = withdrawableImpact;
	}

	public String getWithdrawableImpact() {
		return withdrawableImpact;
	}

	public short getAliasId() {
		return aliasId;
	}

	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
