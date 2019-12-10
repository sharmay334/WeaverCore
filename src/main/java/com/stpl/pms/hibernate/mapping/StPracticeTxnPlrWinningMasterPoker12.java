package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPracticeTxnPlrWinningMasterPoker12 entity. @author MyEclipse Persistence
 * Tools
 */

public class StPracticeTxnPlrWinningMasterPoker12 implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Timestamp transactionDate;
	private Double winningAmount;
	private Double tdsAmount;
	private Double amount;
	private Integer currencyId;
	private Long gameId;
	private String gameName;
	private Double vatAmount;
	private String refTxnNo;
	private String status;
	private Short vendorId;
	private String isCancel;

	// Constructors

	/** default constructor */
	public StPracticeTxnPlrWinningMasterPoker12() {
	}

	/** full constructor */
	public StPracticeTxnPlrWinningMasterPoker12(Long transactionId,
			Long playerId, Short domainId, Timestamp transactionDate,
			Double winningAmount, Double tdsAmount, Double amount,
			Integer currencyId, Long gameId, String gameName,
			Double vatAmount, String refTxnNo, String status, Short vendorId,
			String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.winningAmount = winningAmount;
		this.tdsAmount = tdsAmount;
		this.amount = amount;
		this.currencyId = currencyId;
		this.gameId = gameId;
		this.gameName = gameName;
		this.vatAmount = vatAmount;
		this.refTxnNo = refTxnNo;
		this.status = status;
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

	public Double getWinningAmount() {
		return this.winningAmount;
	}

	public void setWinningAmount(Double winningAmount) {
		this.winningAmount = winningAmount;
	}

	public Double getTdsAmount() {
		return this.tdsAmount;
	}

	public void setTdsAmount(Double tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
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

	public Double getVatAmount() {
		return this.vatAmount;
	}

	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public String getRefTxnNo() {
		return this.refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}