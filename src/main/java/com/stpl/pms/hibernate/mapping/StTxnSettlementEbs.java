package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnSettlementEbs entity. @author MyEclipse Persistence Tools
 */

public class StTxnSettlementEbs implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String pgRefNo;
	private String paymentId;
	private String requestId;
	private String accountId;
	private Timestamp transactionDate;
	private Double transactionAmount;
	private String txnType;
	private String settlementId;
	private String status;

	// Constructors

	/** default constructor */
	public StTxnSettlementEbs() {
	}

	/** full constructor */
	public StTxnSettlementEbs(String pgRefNo, String paymentId,
			String requestId, String accountId, Timestamp transactionDate,
			Double transactionAmount, String txnType, String settlementId,
			String status) {
		this.pgRefNo = pgRefNo;
		this.paymentId = paymentId;
		this.requestId = requestId;
		this.accountId = accountId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.txnType = txnType;
		this.settlementId = settlementId;
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getRequestId() {
		return this.requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Timestamp getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getTransactionAmount() {
		return this.transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTxnType() {
		return this.txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getSettlementId() {
		return this.settlementId;
	}

	public void setSettlementId(String settlementId) {
		this.settlementId = settlementId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPgRefNo() {
		return pgRefNo;
	}

	public void setPgRefNo(String pgRefNo) {
		this.pgRefNo = pgRefNo;
	}

}