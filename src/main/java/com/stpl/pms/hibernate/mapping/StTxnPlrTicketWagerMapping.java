package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrTicketWagerMapping entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrTicketWagerMapping implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Long transactionId;
	private Long ticketDetailId;
	private Timestamp transactionDate;
	private Integer ticketCount;
	private String wagerStatus;

	// Constructors

	/** default constructor */
	public StTxnPlrTicketWagerMapping() {
	}

	/** full constructor */
	public StTxnPlrTicketWagerMapping(Long playerId, Long transactionId,
			Long ticketDetailId, Timestamp transactionDate, Integer ticketCount,
			String wagerStatus) {
		this.playerId = playerId;
		this.transactionId = transactionId;
		this.ticketDetailId = ticketDetailId;
		this.transactionDate = transactionDate;
		this.ticketCount = ticketCount;
		this.wagerStatus = wagerStatus;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getTicketDetailId() {
		return this.ticketDetailId;
	}

	public void setTicketDetailId(Long ticketDetailId) {
		this.ticketDetailId = ticketDetailId;
	}

	public Timestamp getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Integer getTicketCount() {
		return this.ticketCount;
	}

	public void setTicketCount(Integer ticketCount) {
		this.ticketCount = ticketCount;
	}

	public String getWagerStatus() {
		return this.wagerStatus;
	}

	public void setWagerStatus(String wagerStatus) {
		this.wagerStatus = wagerStatus;
	}

}