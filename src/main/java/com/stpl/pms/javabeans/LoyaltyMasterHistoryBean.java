package com.stpl.pms.javabeans;

import java.io.Serializable;

public class LoyaltyMasterHistoryBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String success;
	private String timeLastUpdate;
	private String historyDate;
	private Integer amount;
	private Integer eventId;
	private String Desc;
	private Integer balance;
	
	
	
	public String getTimeLastUpdate() {
		return timeLastUpdate;
	}
	public void setTimeLastUpdate(String timeLastUpdate) {
		this.timeLastUpdate = timeLastUpdate;
	}
	public String getHistoryDate() {
		return historyDate;
	}
	public void setHistoryDate(String historyDate) {
		this.historyDate = historyDate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
}
