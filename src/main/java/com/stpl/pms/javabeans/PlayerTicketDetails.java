package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

import com.stpl.pms.hibernate.mapping.StTxnPlrTicketDetails;

public class PlayerTicketDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long ticketDetailId;
	private Short domainId;
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
	public PlayerTicketDetails() {
	}

	/** full constructor */
	public PlayerTicketDetails(StTxnPlrTicketDetails detail) {
		this.domainId = detail.getDomainId();
		this.playerId = detail.getPlayerId();
		this.ticketId = detail.getTicketId();
		this.ticketCode = detail.getTicketCode();
		this.ticketCount = detail.getTicketCount();
		this.pendingTickets = detail.getPendingTickets();
		this.receivedDate = detail.getReceivedDate();
		this.expiredDate = detail.getExpiredDate();
		this.refUsageDate = detail.getRefUsageDate();
		this.status = detail.getStatus();
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

}
