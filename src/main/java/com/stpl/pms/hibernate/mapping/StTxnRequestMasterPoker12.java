package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;

public class StTxnRequestMasterPoker12 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long pokerId;
	private Long playerId;
	private Long actionId;
	private Long transactionId;
	private Double amount;
	private String reqStatus;
	private String reqTime;
	private Long tableId;
	private String txnType;
	private String pokerStatus;
	
	public Long getPokerId() {
		return pokerId;
	}
	public void setPokerId(Long pokerId) {
		this.pokerId = pokerId;
	}
	
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public Long getActionId() {
		return actionId;
	}
	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	public String getReqTime() {
		return reqTime;
	}
	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Long getTableId() {
		return tableId;
	}
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public String getPokerStatus() {
		return pokerStatus;
	}
	public void setPokerStatus(String pokerStatus) {
		this.pokerStatus = pokerStatus;
	}
	

}
