package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrTicketDetails entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrTicketDetails implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long ticketDetailId;
	private Short domainId;
	private Short aliasId;
	private Long playerId;
	private Long ticketId;
	private String ticketCode;
	private Integer ticketCount;
	private Integer pendingTickets;
	private Timestamp receivedDate;
	private Timestamp expiredDate;
	private Timestamp refUsageDate;
	private String status;

	// Constructors

	/** default constructor */
	public StTxnPlrTicketDetails() {
	}

	/** full constructor */
	public StTxnPlrTicketDetails(Short domainId, Short aliasId, Long playerId, Long ticketId,
			String ticketCode, Integer ticketCount, Integer pendingTickets,
			Timestamp receivedDate, Timestamp expiredDate,
			Timestamp refUsageDate, String status) {
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.playerId = playerId;
		this.ticketId = ticketId;
		this.ticketCode = ticketCode;
		this.ticketCount = ticketCount;
		this.pendingTickets = pendingTickets;
		this.receivedDate = receivedDate;
		this.expiredDate = expiredDate;
		this.refUsageDate = refUsageDate;
		this.status = status;
	}

	// Property accessors

	public Long getTicketDetailId() {
		return this.ticketDetailId;
	}

	public void setTicketDetailId(Long ticketDetailId) {
		this.ticketDetailId = ticketDetailId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Long getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketCode() {
		return this.ticketCode;
	}

	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}

	public Integer getTicketCount() {
		return this.ticketCount;
	}

	public void setTicketCount(Integer ticketCount) {
		this.ticketCount = ticketCount;
	}

	public Integer getPendingTickets() {
		return this.pendingTickets;
	}

	public void setPendingTickets(Integer pendingTickets) {
		this.pendingTickets = pendingTickets;
	}

	public Timestamp getReceivedDate() {
		return this.receivedDate;
	}

	public void setReceivedDate(Timestamp receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Timestamp getExpiredDate() {
		return this.expiredDate;
	}

	public void setExpiredDate(Timestamp expiredDate) {
		this.expiredDate = expiredDate;
	}

	public Timestamp getRefUsageDate() {
		return this.refUsageDate;
	}

	public void setRefUsageDate(Timestamp refUsageDate) {
		this.refUsageDate = refUsageDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}