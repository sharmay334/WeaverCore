package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WithdrawalDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long transactionId;
	private Double amount;
	private Timestamp transactionDate;
	private String refTxnNo;
	private Timestamp refTxnDate;
	private String status;

	public WithdrawalDetailBean() {
	}

	public WithdrawalDetailBean(Long transactionId, Double amount,
			Timestamp transactionDate, String refTxnNo, Timestamp refTxnDate,
			String status) {
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.refTxnNo = refTxnNo;
		this.refTxnDate = refTxnDate;
		this.status = status;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getRefTxnNo() {
		return refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public Timestamp getRefTxnDate() {
		return refTxnDate;
	}

	public void setRefTxnDate(Timestamp refTxnDate) {
		this.refTxnDate = refTxnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
