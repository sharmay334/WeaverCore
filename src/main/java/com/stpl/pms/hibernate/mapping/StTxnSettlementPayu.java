package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

public class StTxnSettlementPayu implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	
	private String requestId;
	private Timestamp transactionDate;
	private String payuId;
	private String customerName;
	private Double txnAmount;
	private String reqAction;
	private String pgStatus;
	private String txnId;
	private String status;
	private String pgRefNo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getPayuId() {
		return payuId;
	}
	public void setPayuId(String payuId) {
		this.payuId = payuId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Double getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(Double txnAmount) {
		this.txnAmount = txnAmount;
	}
	public String getReqAction() {
		return reqAction;
	}
	public void setReqAction(String reqAction) {
		this.reqAction = reqAction;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}	
	public String getPgStatus() {
		return pgStatus;
	}
	public void setPgStatus(String pgStatus) {
		this.pgStatus = pgStatus;
	}	
	
	public String getPgRefNo() {
		return pgRefNo;
	}
	public void setPgRefNo(String pgRefNo) {
		this.pgRefNo = pgRefNo;
	}
	@Override
	public String toString() {
		return "StTxnSettlementPayu [id=" + id + ", requestId=" + requestId
				+ ", transactionDate=" + transactionDate + ", payuId=" + payuId
				+ ", customerName=" + customerName + ", txnAmount=" + txnAmount
				+ ", reqAction=" + reqAction + ", pgStatus=" + pgStatus
				+ ", txnId=" + txnId + ", status=" + status + ", pgRefNo="
				+ pgRefNo + "]";
	}
	
	

	
}
