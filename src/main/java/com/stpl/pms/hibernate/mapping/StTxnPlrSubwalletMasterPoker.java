package com.stpl.pms.hibernate.mapping;

/**
 * StTxnPlrSubwalletMasterPoker entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrSubwalletMasterPoker implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8719042245792864047L;
	private Long id;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private String gameGroup;
	private Short vendorId;
	private String subWalletTblId;
	private Integer currencyId;
	private Double amount;
	private String status;
	private String subWalletTime;
	private String subWalletUniqueId;
	private Long actionId;

	// Constructors

	/** default constructor */
	public StTxnPlrSubwalletMasterPoker() {
	}

	/** full constructor */
	public StTxnPlrSubwalletMasterPoker(Long playerId, Short domainId,
			Short aliasId, String gameGroup, Short vendorId,
			String subWalletTblId, Integer currencyId, Double amount,
			String status, String subWalletTime, String subWalletUniqueId) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.gameGroup = gameGroup;
		this.vendorId = vendorId;
		this.subWalletTblId = subWalletTblId;
		this.currencyId = currencyId;
		this.amount = amount;
		this.status = status;
		this.subWalletTime = subWalletTime;
		this.subWalletUniqueId = subWalletUniqueId;
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

	public Short getAliasId() {
		return this.aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
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

	public String getSubWalletTblId() {
		return this.subWalletTblId;
	}

	public void setSubWalletTblId(String subWalletTblId) {
		this.subWalletTblId = subWalletTblId;
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

	public String getSubWalletTime() {
		return this.subWalletTime;
	}

	public void setSubWalletTime(String subWalletTime) {
		this.subWalletTime = subWalletTime;
	}

	public String getSubWalletUniqueId() {
		return this.subWalletUniqueId;
	}

	public void setSubWalletUniqueId(String subWalletUniqueId) {
		this.subWalletUniqueId = subWalletUniqueId;
	}

	public Long getActionId() {
		return actionId;
	}

	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}
	
	

}