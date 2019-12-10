package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnSettlementMg entity. @author MyEclipse Persistence Tools
 */

public class StTxnSettlementMg implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Short domainId;
	private Long playerId;
	private String userName;
	private String userId;
	private String casinoId;
	private String actionId;
	private String txnType;
	private String txnStatus;
	private Timestamp submitTime;
	private String txnTime;
	private Double amount;
	private String isoCode;
	private String multiTournamentId;
	private String pokerTableId;
	private String lastErrorCode;
	private String lastErrorMsg;
	private String status;
	private String refActionId;
	

	// Constructors

	/** default constructor */
	public StTxnSettlementMg() {
	}

	/** minimal constructor */
	public StTxnSettlementMg(String userName) {
		this.userName = userName;
	}

	/** full constructor */
	public StTxnSettlementMg(Short domainId,Long playerId, String userName, String userId,
			String casinoId, String actionId, String txnType, String txnStatus,
			Timestamp submitTime, Double amount, String isoCode,
			String multiTournamentId, String pokerTableId, String lastErrorCode,
			String lastErrorMsg,String status,String txnTime,String refActionId) {
		this.domainId=domainId;
		this.playerId = playerId;
		this.userName = userName;
		this.userId = userId;
		this.casinoId = casinoId;
		this.actionId = actionId;
		this.txnType = txnType;
		this.txnStatus = txnStatus;
		this.submitTime = submitTime;
		this.amount = amount;
		this.isoCode = isoCode;
		this.multiTournamentId = multiTournamentId;
		this.pokerTableId = pokerTableId;
		this.lastErrorCode = lastErrorCode;
		this.lastErrorMsg = lastErrorMsg;
		this.status=status;
		this.txnTime=txnTime;
		this.refActionId=refActionId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}	

	public Short getDomainId() {
		return domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCasinoId() {
		return this.casinoId;
	}

	public void setCasinoId(String casinoId) {
		this.casinoId = casinoId;
	}

	public String getActionId() {
		return this.actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getTxnType() {
		return this.txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getTxnStatus() {
		return this.txnStatus;
	}

	public void setTxnStatus(String txnStatus) {
		this.txnStatus = txnStatus;
	}

	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {		
		this.submitTime = submitTime;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getIsoCode() {
		return this.isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}	

	public String getMultiTournamentId() {
		return multiTournamentId;
	}

	public void setMultiTournamentId(String multiTournamentId) {
		this.multiTournamentId = multiTournamentId;
	}

	public String getPokerTableId() {
		return pokerTableId;
	}

	public void setPokerTableId(String pokerTableId) {
		this.pokerTableId = pokerTableId;
	}

	public String getLastErrorCode() {
		return this.lastErrorCode;
	}

	public void setLastErrorCode(String lastErrorCode) {
		this.lastErrorCode = lastErrorCode;
	}

	public String getLastErrorMsg() {
		return this.lastErrorMsg;
	}

	public void setLastErrorMsg(String lastErrorMsg) {
		this.lastErrorMsg = lastErrorMsg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}

	public String getRefActionId() {
		return refActionId;
	}

	public void setRefActionId(String refActionId) {
		this.refActionId = refActionId;
	}
	
}