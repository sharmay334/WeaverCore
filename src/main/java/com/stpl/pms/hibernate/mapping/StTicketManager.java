package com.stpl.pms.hibernate.mapping;

/**
 * StTicketManager entity. @author MyEclipse Persistence Tools
 */

public class StTicketManager implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long ticketId;
	private Short domainId;
	private Short aliasId;
	private String ticketSource;
	private String ticketCode;

	// Constructors

	/** default constructor */
	public StTicketManager() {
	}

	/** full constructor */
	public StTicketManager(Short domainId, Short aliasId, String ticketSource,
			String ticketCode) {
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.ticketSource = ticketSource;
		this.ticketCode = ticketCode;
	}

	// Property accessors

	public Long getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getTicketSource() {
		return this.ticketSource;
	}

	public void setTicketSource(String ticketSource) {
		this.ticketSource = ticketSource;
	}

	public String getTicketCode() {
		return this.ticketCode;
	}

	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}