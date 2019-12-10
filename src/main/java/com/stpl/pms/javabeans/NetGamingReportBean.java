package com.stpl.pms.javabeans;

import java.sql.Timestamp;

public class NetGamingReportBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long txnId;
	private Long accountId;
	private Short domainId;
	private String userName;
	private Double amount;
	private String paymentType;
	private String providerName;
	private Timestamp txnTime;

	private String gameType;
	

	public NetGamingReportBean() {
	}

	public NetGamingReportBean(Long txnId, Long accountId, String userName,
			Double amount, String paymentType, String providerName,
			Timestamp txnTime, String gameType) {
		this.txnId = txnId;
		this.setAccountId(accountId);
		this.userName = userName;
		this.amount = amount;
		this.paymentType = paymentType;
		this.providerName = providerName;
		this.txnTime = txnTime;
		this.gameType = gameType;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public void setTxnTime(Timestamp txnTime) {
		this.txnTime = txnTime;
	}

	public Timestamp getTxnTime() {
		return txnTime;
	}

	@Override
	public String toString() {
		return "NetGamingReportBean [amount=" + amount + ", gameType="
				+ gameType + ", paymentType=" + paymentType + ", accountId="
				+ accountId + ", providerName=" + providerName + ", txnId="
				+ txnId + ", txnTime=" + txnTime + ", userName=" + userName
				+ "]";
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Short getDomainId() {
		return domainId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getAccountId() {
		return accountId;
	}
}
