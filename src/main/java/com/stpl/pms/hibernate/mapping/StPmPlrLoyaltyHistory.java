package com.stpl.pms.hibernate.mapping;

/**
 * StPmPlrLoyaltyHistory entity. @author MyEclipse Persistence Tools
 */

public class StPmPlrLoyaltyHistory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short aliasId;
	private String timeLastUpdated;
	private String historyDate;
	private Integer amount;
	private Integer eventId;
	private String description;
	private Integer balance;

	// Constructors

	/** default constructor */
	public StPmPlrLoyaltyHistory() {
	}

	/** full constructor */
	public StPmPlrLoyaltyHistory(Long playerId, Short aliasId,
			String timeLastUpdated, String historyDate, Integer amount,
			Integer eventId, String description,Integer balance) {
		this.playerId = playerId;
		this.aliasId = aliasId;
		this.timeLastUpdated = timeLastUpdated;
		this.historyDate = historyDate;
		this.amount = amount;
		this.eventId = eventId;
		this.description = description;
		this.balance=balance;
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

	public String getTimeLastUpdated() {
		return this.timeLastUpdated;
	}

	public void setTimeLastUpdated(String timeLastUpdated) {
		this.timeLastUpdated = timeLastUpdated;
	}

	public String getHistoryDate() {
		return this.historyDate;
	}

	public void setHistoryDate(String historyDate) {
		this.historyDate = historyDate;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getEventId() {
		return this.eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

}