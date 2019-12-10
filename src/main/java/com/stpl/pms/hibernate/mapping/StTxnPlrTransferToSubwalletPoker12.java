package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrTransferToSubwalletPoker12 entity. @author MyEclipse Persistence
 * Tools
 */

public class StTxnPlrTransferToSubwalletPoker12 implements java.io.Serializable, StTxnPlrTransferToSubwallet {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Timestamp transactionDate;
	private Integer currencyId;
	private Double amount;
	private Double amountNative;
	private Short vendorId;
	private String isCancel;
	private String gameId;
	private String actionId;
	private String gameRefre;
	private Double cashPortion;
	private Double bonusPortion;
	private Double pendingWinPortion;
	private String tableId;
	private Long subwalletId;
	private String isNewSubWallet;
	private Short aliasId;
	

	// Constructors

	/** default constructor */
	public StTxnPlrTransferToSubwalletPoker12() {
	}

	/** full constructor 
	 * @param aliasId */
	public StTxnPlrTransferToSubwalletPoker12(Long transactionId,
			Long playerId, Short domainId, short aliasId, Timestamp transactionDate,
			Integer currencyId, Double amount, Double amountNative,
			Short vendorId,String gameId,String tableId,String actionId,String gameRefre,Double cashPortion, Double bonusPortion,
			Double pendingWinPortion,String isCancel,Long subwalletId,String isNewSubwallet) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.currencyId = currencyId;
		this.amount = amount;
		this.amountNative = amountNative;
		this.vendorId = vendorId;
		this.gameId = gameId;
		this.actionId = actionId;
		this.gameRefre = gameRefre;
		this.cashPortion = cashPortion;
		this.bonusPortion = bonusPortion;
		this.pendingWinPortion = pendingWinPortion;
		this.isCancel = isCancel;
		this.tableId = tableId;
		this.subwalletId = subwalletId;
		this.isNewSubWallet = isNewSubwallet;
		this.aliasId = aliasId;
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

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAmountNative() {
		return this.amountNative;
	}

	public void setAmountNative(Double amountNative) {
		this.amountNative = amountNative;
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


	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getGameRefre() {
		return gameRefre;
	}

	public void setGameRefre(String gameRefre) {
		this.gameRefre = gameRefre;
	}
	public Double getCashPortion() {
		return this.cashPortion;
	}

	public void setCashPortion(Double cashPortion) {
		this.cashPortion = cashPortion;
	}

	public Double getBonusPortion() {
		return this.bonusPortion;
	}

	public void setBonusPortion(Double bonusPortion) {
		this.bonusPortion = bonusPortion;
	}

	public Double getPendingWinPortion() {
		return this.pendingWinPortion;
	}

	public void setPendingWinPortion(Double pendingWinPortion) {
		this.pendingWinPortion = pendingWinPortion;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public Long getSubwalletId() {
		return subwalletId;
	}

	public void setSubwalletId(Long subwalletId) {
		this.subwalletId = subwalletId;
	}

	public String getIsNewSubWallet() {
		return isNewSubWallet;
	}

	public void setIsNewSubWallet(String isNewSubWallet) {
		this.isNewSubWallet = isNewSubWallet;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}