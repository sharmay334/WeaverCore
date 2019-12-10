package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlrPaymentResponseBean extends CommonResponseBean implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private Long txnId;
	private Double amount;
	private Double netAmount;
	private Timestamp txnDate;
	private String status;

	public PlrPaymentResponseBean() {
	}

	public PlrPaymentResponseBean(Long txnId, Double amount, Double netAmount,
			Timestamp txnDate, String status) {
		this.txnId = txnId;
		this.amount = amount;
		this.netAmount = netAmount;
		this.txnDate = txnDate;
		this.status = status;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public Timestamp getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Timestamp txnDate) {
		this.txnDate = txnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
