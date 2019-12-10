package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StCshPlrDepositRequestChequeTrans entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositRequestChequeTrans implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Long requestId;
	private String chequeNo;
	private String playerBankName;
	private Timestamp chequeDate;

	// Constructors

	/** default constructor */
	public StCshPlrDepositRequestChequeTrans() {
	}

	/** full constructor */
	public StCshPlrDepositRequestChequeTrans(Long playerId, Short domainId, Short aliasId,
			Long requestId, String chequeNo, String playerBankName,
			Timestamp chequeDate) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.requestId = requestId;
		this.chequeNo = chequeNo;
		this.playerBankName = playerBankName;
		this.chequeDate = chequeDate;
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

	public String getChequeNo() {
		return this.chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getPlayerBankName() {
		return this.playerBankName;
	}

	public void setPlayerBankName(String playerBankName) {
		this.playerBankName = playerBankName;
	}

	public Timestamp getChequeDate() {
		return this.chequeDate;
	}

	public void setChequeDate(Timestamp chequeDate) {
		this.chequeDate = chequeDate;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}