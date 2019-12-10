package com.stpl.pms.hibernate.mapping;

/**
 * StPmPlrPokerTicketHistory entity. @author MyEclipse Persistence Tools
 */

public class StPmPlrPokerTicketHistory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short aliasId;
	private Integer ticketId;
	private String ticketDesc;
	private String currency;
	private Integer buyIn;
	private Integer fee;
	private String expiry;
	private Integer ticketStatus;

	// Constructors

	/** default constructor */
	public StPmPlrPokerTicketHistory() {
	}

	/** full constructor */
	public StPmPlrPokerTicketHistory(Long playerId, Short aliasId,
			Integer ticketId, String ticketDesc, String currency,
			Integer buyIn, Integer fee, String expiry, Integer ticketStatus) {
		this.playerId = playerId;
		this.aliasId = aliasId;
		this.ticketId = ticketId;
		this.ticketDesc = ticketDesc;
		this.currency = currency;
		this.buyIn = buyIn;
		this.fee = fee;
		this.expiry = expiry;
		this.ticketStatus = ticketStatus;
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

	public Short getAliasId() {
		return this.aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public Integer getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketDesc() {
		return this.ticketDesc;
	}

	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getBuyIn() {
		return this.buyIn;
	}

	public void setBuyIn(Integer buyIn) {
		this.buyIn = buyIn;
	}

	public Integer getFee() {
		return this.fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public String getExpiry() {
		return this.expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public Integer getTicketStatus() {
		return this.ticketStatus;
	}

	public void setTicketStatus(Integer ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

}