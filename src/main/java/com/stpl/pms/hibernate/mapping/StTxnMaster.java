package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnMaster entity. @author MyEclipse Persistence Tools
 */

public class StTxnMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long transactionId;
	private String transactionWith;
	private String transactionType;
	private Short serviceId;
	private Long partyId;
	private Short domainId;
	private Short aliasId;
	private Timestamp transactionDate;

	// Constructors

	/** default constructor */
	public StTxnMaster() {
	}

	/** full constructor */
	public StTxnMaster(String transactionWith, String transactionType,
			Short serviceId, Long partyId, Short domainId, Short aliasId,
			Timestamp transactionDate) {
		this.transactionWith = transactionWith;
		this.transactionType = transactionType;
		this.serviceId = serviceId;
		this.partyId = partyId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.transactionDate = transactionDate;
	}

	// Property accessors

	public Long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionWith() {
		return this.transactionWith;
	}

	public void setTransactionWith(String transactionWith) {
		this.transactionWith = transactionWith;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Short getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Short serviceId) {
		this.serviceId = serviceId;
	}

	public Long getPartyId() {
		return this.partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Timestamp getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}