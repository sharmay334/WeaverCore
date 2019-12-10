package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPracticeTxnPlrWagerRefundMasterRummy2 entity. @author MyEclipse Persistence
 * Tools
 */

public class StPracticeTxnPlrWagerRefundMasterRummy2 implements
		java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Timestamp transactionDate;
	private Double amount;
	private Integer currencyId;
	private Long gameId;
	private Double vatAmount;
	private String refTxnNo;
	private Double wgrContriAmt;
	private String gameType;
	private String gameName;
	private Short vendorId;
	private Long refWagerTxnId;
	private Double refundCharge;
	private String isCancel;

	// Constructors

	/** default constructor */
	public StPracticeTxnPlrWagerRefundMasterRummy2() {
	}


	/** full constructor */
	public StPracticeTxnPlrWagerRefundMasterRummy2(Long transactionId,
			Long playerId, Short domainId, Short aliasId, Timestamp transactionDate,
			Double amount, Integer currencyId, Long gameId, Double vatAmount,
			String refTxnNo, Double wgrContriAmt, String gameType,
			Short vendorId, Long refWagerTxnId, Double refundCharge,
			String isCancel, String gameName) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.currencyId = currencyId;
		this.gameId = gameId;
		this.vatAmount = vatAmount;
		this.refTxnNo = refTxnNo;
		this.wgrContriAmt = wgrContriAmt;
		this.gameType = gameType;
		this.gameName = gameName;
		this.vendorId = vendorId;
		this.refWagerTxnId = refWagerTxnId;
		this.refundCharge = refundCharge;
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

	public Double getWgrContriAmt() {
		return this.wgrContriAmt;
	}

	public void setWgrContriAmt(Double wgrContriAmt) {
		this.wgrContriAmt = wgrContriAmt;
	}

	public String getGameType() {
		return this.gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public Short getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Short vendorId) {
		this.vendorId = vendorId;
	}

	public Long getRefWagerTxnId() {
		return this.refWagerTxnId;
	}

	public void setRefWagerTxnId(Long refWagerTxnId) {
		this.refWagerTxnId = refWagerTxnId;
	}

	public Double getRefundCharge() {
		return this.refundCharge;
	}

	public void setRefundCharge(Double refundCharge) {
		this.refundCharge = refundCharge;
	}

	public String getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}


	public void setGameName(String gameName) {
		this.gameName = gameName;
	}


	public String getGameName() {
		return gameName;
	}


	public Short getAliasId() {
		return aliasId;
	}


	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}