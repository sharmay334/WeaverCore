 package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

public class StCshUnclaimedDepositsBCEID implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private short domainId;
	private Long tpTxnId;
	private String requestMobileNo;
	private String actualMobileNo;
	private double amount;
	private String status;
	private Timestamp requestDate;

	public long getId() {
		return id;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public Long getTpTxnId() {
		return tpTxnId;
	}

	public void setTpTxnId(Long tpTxnId) {
		this.tpTxnId = tpTxnId;
	}

	public String getRequestMobileNo() {
		return requestMobileNo;
	}

	public void setRequestMobileNo(String requestMobileNo) {
		this.requestMobileNo = requestMobileNo;
	}

	public String getActualMobileNo() {
		return actualMobileNo;
	}

	public void setActualMobileNo(String actualMobileNo) {
		this.actualMobileNo = actualMobileNo;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}

}
