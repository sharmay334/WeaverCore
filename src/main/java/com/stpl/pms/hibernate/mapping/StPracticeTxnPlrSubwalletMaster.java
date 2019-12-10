package com.stpl.pms.hibernate.mapping;

/**
 * StPracticeTxnPlrSubwalletMaster entity. @author MyEclipse Persistence Tools
 */

public class StPracticeTxnPlrSubwalletMaster implements java.io.Serializable {
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

	// Constructors

	/** default constructor */
	public StPracticeTxnPlrSubwalletMaster() {
	}

	/** full constructor */
	public StPracticeTxnPlrSubwalletMaster(Long playerId, Short domainId, Short aliasId,
			String gameGroup, Short vendorId, String subwalletRefNo,
			Integer currencyId, Double amount, String status) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.gameGroup = gameGroup;
		this.vendorId = vendorId;
		this.subwalletRefNo = subwalletRefNo;
		this.currencyId = currencyId;
		this.amount = amount;
		this.status = status;
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

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}