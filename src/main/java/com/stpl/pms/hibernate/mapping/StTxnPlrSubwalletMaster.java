package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrSubwalletMaster entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrSubwalletMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private String gameGroup;
	private Short vendorId;
	private String subwalletRefNo;
	private Integer currencyId;
	private Double amount;
	private String status;
	private Timestamp lastUpdationTime;
	private String subWalletCreationTime; 

	// Constructors

	/** default constructor */
	public StTxnPlrSubwalletMaster() {
	}

	/** full constructor */
	public StTxnPlrSubwalletMaster(Long playerId, Short domainId, Short aliasId,
			String gameGroup, Short vendorId, String subwalletRefNo,
			Integer currencyId, Double amount, String status,String subWalletTime) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.gameGroup = gameGroup;
		this.vendorId = vendorId;
		this.subwalletRefNo = subwalletRefNo;
		this.currencyId = currencyId;
		this.amount = amount;
		this.status = status;
		this.subWalletCreationTime = subWalletTime;
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

	public String getGameGroup() {
		return this.gameGroup;
	}

	public void setGameGroup(String gameGroup) {
		this.gameGroup = gameGroup;
	}

	public Short getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Short vendorId) {
		this.vendorId = vendorId;
	}

	public String getSubwalletRefNo() {
		return this.subwalletRefNo;
	}

	public void setSubwalletRefNo(String subwalletRefNo) {
		this.subwalletRefNo = subwalletRefNo;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getLastUpdationTime() {
		return this.lastUpdationTime;
	}

	public void setLastUpdationTime(Timestamp lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}

	public String getSubWalletCreationTime() {
		return subWalletCreationTime;
	}

	public void setSubWalletCreationTime(String subWalletCreationTime) {
		this.subWalletCreationTime = subWalletCreationTime;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}