package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;


public class PlayerTdsDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private Short domainId;
	private Long playerId;
	private Long transactionId;
	private Double tdsAmount;
	private Timestamp transactionDate;
	private String particulars;

	// Constructors

	/** default constructor */
	public PlayerTdsDetails() {
	}

	

	public Short getDomainId() {
		return domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Double getTdsAmount() {
		return tdsAmount;
	}

	public void setTdsAmount(Double tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}



	public String getParticulars() {
		return particulars;
	}



	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}





}
