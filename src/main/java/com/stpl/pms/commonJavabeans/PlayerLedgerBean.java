package com.stpl.pms.commonJavabeans;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerLedgerBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long playerId;
	private Long transactionId;
	private Short domainId;
	private Short aliasId;
	private Timestamp transactionDate;
	private String particular;
	private String txnType;
	private Integer currencyId;
	private Double creditAmount;
	private Double debitAmount;
	private Double txnAmount;
	private Double balance;
	private Double openingBalance;
	private String subwalletTxn;
	private String currency;
	private Double withdrawableBalance;
	private String gameGroup;

	// Constructors

	/** default constructor */
	public PlayerLedgerBean() {
	}

	/**
	 * full constructor
	 * 
	 * @param withdrawableBalance
	 */
	public PlayerLedgerBean(Long playerId, Short domainId, Short aliasId, Long transactionId,
			Timestamp transactionDate, String particular, String txnType,
			Integer currencyId, Double creditAmount, Double debitAmount,
			Double balance, Double openingBalance, String subwalletTxn,
			Double withdrawableBalance, String gameGroup) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
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
		this.txnAmount = creditAmount != null ? creditAmount : debitAmount;
		this.withdrawableBalance = withdrawableBalance;
		this.gameGroup = gameGroup;
	}

	public PlayerLedgerBean(Integer currencyId,String currency,Double debitAmount,String gameGroup,String particular,Timestamp transactionDate,Long transactionId, 
			Double txnAmount,String txnType) {
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.particular = particular;
		this.txnType = txnType;
		this.debitAmount = debitAmount;
		this.txnAmount = txnAmount;
		this.gameGroup=gameGroup;
		this.currency=currency;
		this.currencyId = currencyId;
	}

	public PlayerLedgerBean(Long transactionId, Timestamp transactionDate,
			String particular, String txnType, Integer currencyId,
			Double creditAmount, Double debitAmount, Double balance,
			Double openingBalance, String subwalletTxn,
			Double withdrawableBalance,String gameGroup) {
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
		this.txnAmount = creditAmount != null ? creditAmount : debitAmount;
		this.withdrawableBalance = withdrawableBalance;
		this.gameGroup=gameGroup;
	}

	public void prepareLedger(Long playerId, Short domainId, Short aliasId,
			Long transactionId, Timestamp transactionDate, String particular,
			String txnType, Integer currencyId, Double creditAmount,
			Double debitAmount, Double balance, Double openingBalance,
			String subwalletTxn, Double withdrawableBalance, String gameGroup) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
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

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Short getDomainId() {
		return domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Integer getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Double getBalance() {
		return balance;
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

	public void setTxnAmount(Double txnAmount) {
		this.txnAmount = txnAmount;
	}

	public Double getTxnAmount() {
		return txnAmount;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
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
