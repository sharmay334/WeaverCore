package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class WithdrawalResponsetBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long txnId;
	private Double amount;
	private Double netAmount;
	private Timestamp txnDate;
	private String status;
	private int errorCode;
	private String respMsg;
	private String otp;
	private String refTxnNo;
	
	public WithdrawalResponsetBean() {
	}
	
	
	public WithdrawalResponsetBean(Long txnId, Double amount, Double netAmount,
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

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public String getRespMsg() {
		return respMsg;
	}


	public String getOtp() {
		return otp;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}


	public String getRefTxnNo() {
		return refTxnNo;
	}


	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}
	
	

}
