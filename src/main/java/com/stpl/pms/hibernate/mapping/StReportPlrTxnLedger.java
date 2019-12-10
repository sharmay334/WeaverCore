package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StReportPlrTxnLedger entity. @author MyEclipse Persistence Tools
 */

public class StReportPlrTxnLedger implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Long transactionId;
	private Timestamp transactionDate;
	private String particular;
	private String txnType;
	private Integer currencyId;
	private Double creditAmount;
	private Double debitAmount;
	private Double balance;
	private Double openingBalance;
	private String subwalletTxn;
	private Double withdrawableBalance;
	private String gameGroup;

	// Constructors

	/** default constructor */
	public StReportPlrTxnLedger() {
	}

	/** minimal constructor 
	 * @param withdrawableBalance */
	public StReportPlrTxnLedger(Long playerId, Short domainId,
			Long transactionId, Timestamp transactionDate, String txnType,
			Integer currencyId, Double balance, Double openingBalance, Double withdrawableBalance) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.txnType = txnType;
		this.currencyId = currencyId;
		this.balance = balance;
		this.openingBalance = openingBalance;
		this.withdrawableBalance = withdrawableBalance;
	}

	/** full constructor 
	 * @param withdrawableBalance */
	public StReportPlrTxnLedger(Long playerId, Short domainId, Short aliasId,
			Long transactionId, Timestamp transactionDate, String particular,
			String txnType, Integer currencyId, Double creditAmount,
			Double debitAmount, Double balance, Double openingBalance,
			String subwalletTxn, Double withdrawableBalance, String gameGroup) {
		this.playerId = playerId;
		this.domainId = domainId;
		this .aliasId = aliasId;
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.particular = particular;
		this.txnType = txnType;
		this.currencyId = currencyId;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.balance = balance;
		this.openingBalance = openingBalance;
		this.subwalletTxn = subwalletTxn;
		this.withdrawableBalance = withdrawableBalance;
		this.gameGroup = gameGroup;
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

	public String getParticular() {
		return this.particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public String getTxnType() {
		return this.txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Double getCreditAmount() {
		return this.creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Double getDebitAmount() {
		return this.debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Double getOpeningBalance() {
		return openingBalance;
	}

	public void setSubwalletTxn(String subwalletTxn) {
		this.subwalletTxn = subwalletTxn;
	}

	public String getSubwalletTxn() {
		return subwalletTxn;
	}

	public Double getWithdrawableBalance() {
		return withdrawableBalance;
	}

	public void setWithdrawableBalance(Double withdrawableBalance) {
		this.withdrawableBalance = withdrawableBalance;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getGameGroup() {
		return gameGroup;
	}

	public void setGameGroup(String gameGroup) {
		this.gameGroup = gameGroup;
	}

}