package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PokerSettlementReportBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Short domainId;
	private Short aliasId;
	private Long playerId;
	private String userName;
	private String actionId;
	private String txnType;
	private String systemStatus;
	private String pokerStaus;
	private Double amount;
	private Long transactionId;
	private String withdrawImpact;
	private String correctionOption;
	private String reason ;
	private String txnTime;
	private String refActionId;
	
	
	public PokerSettlementReportBean(){
		
		
	}

	
	public Short getDomainId() {
		return domainId;
	}


	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}


	public Short getAliasId() {
		return aliasId;
	}


	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}


	public Long getPlayerId() {
		return playerId;
	}


	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getSystemStatus() {
		return systemStatus;
	}

	public void setSystemStatus(String systemStatus) {
		this.systemStatus = systemStatus;
	}

	public String getPokerStaus() {
		return pokerStaus;
	}

	public void setPokerStaus(String pokerStaus) {
		this.pokerStaus = pokerStaus;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getCorrectionOption() {
		return correctionOption;
	}

	public void setCorrectionOption(String correctionOption) {
		this.correctionOption = correctionOption;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getTxnTime() {
		return txnTime;
	}


	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}

	public String getWithdrawImpact() {
		return withdrawImpact;
	}

	public void setWithdrawImpact(String withdrawImpact) {
		this.withdrawImpact = withdrawImpact;
	}


	public String getRefActionId() {
		return refActionId;
	}


	public void setRefActionId(String refActionId) {
		this.refActionId = refActionId;
	}

}
