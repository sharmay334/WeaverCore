package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StCshPlrDepositRequestWireTrans entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositRequestWireTrans implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Long requestId;
	private Integer providerId;
	private String refBankTxnNo;
	private Timestamp txnDate;

	// Constructors

	/** default constructor */
	public StCshPlrDepositRequestWireTrans() {
	}

	/** full constructor */
	public StCshPlrDepositRequestWireTrans(Long playerId, Short domainId, Short aliasId,
			Long requestId, Integer providerId, String refBankTxnNo,
			Timestamp txnDate) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.requestId = requestId;
		this.providerId = providerId;
		this.refBankTxnNo = refBankTxnNo;
		this.txnDate = txnDate;
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

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Integer getProviderId() {
		return this.providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getRefBankTxnNo() {
		return this.refBankTxnNo;
	}

	public void setRefBankTxnNo(String refBankTxnNo) {
		this.refBankTxnNo = refBankTxnNo;
	}

	public Timestamp getTxnDate() {
		return this.txnDate;
	}

	public void setTxnDate(Timestamp txnDate) {
		this.txnDate = txnDate;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}
}