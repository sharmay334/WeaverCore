package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPracticeTxnPlrTransferFromSubwalletRummy2 entity. @author MyEclipse
 * Persistence Tools
 */

public class StPracticeTxnPlrTransferFromSubwalletRummy2 implements
		java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Short aliasId;;
	private Timestamp transactionDate;
	private Integer currencyId;
	private Double amount;
	private String refTxnNo;
	private Short vendorId;
	private String isCancel;

	// Constructors

	/** default constructor */
	public StPracticeTxnPlrTransferFromSubwalletRummy2() {
	}

	/** full constructor */
	public StPracticeTxnPlrTransferFromSubwalletRummy2(Long transactionId,
			Long playerId, Short domainId, Short aliasId, Timestamp transactionDate,
			Integer currencyId, Double amount, String refTxnNo, Short vendorId,
			String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.transactionDate = transactionDate;
		this.currencyId = currencyId;
		this.amount = amount;
		this.refTxnNo = refTxnNo;
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

}