package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StPracticeTxnPlrWinningMasterRummy2 entity. @author MyEclipse Persistence
 * Tools
 */

public class StPracticeTxnPlrWinningMasterRummy2 implements
		java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long transactionId;
	private Long playerId;
	private Short domainId;
	private Short aliasId;
	private Timestamp transactionDate;
	private Double winningAmount;
	private Double tdsAmount;
	private Double amount;
	private Integer currencyId;
	private Long gameId;
	private String gameName;
	private Double vatAmount;
	private String refTxnNo;
	private String status;
	private Short vendorId;
	private String isCancel;
	private String device;
	private String userAgent;
	private String os;
	private String browser;
	private String model;
	private String gameSessionId;

	// Constructors

	/** default constructor */
	public StPracticeTxnPlrWinningMasterRummy2() {
	}

	/** minimal constructor */
	public StPracticeTxnPlrWinningMasterRummy2(Long transactionId,
			Long playerId, Short domainId, Timestamp transactionDate,
			Double winningAmount, Double tdsAmount, Double amount,
			Integer currencyId, Short vendorId, String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.transactionDate = transactionDate;
		this.winningAmount = winningAmount;
		this.tdsAmount = tdsAmount;
		this.amount = amount;
		this.currencyId = currencyId;
		this.vendorId = vendorId;
		this.isCancel = isCancel;
	}

	/** full constructor */
	public StPracticeTxnPlrWinningMasterRummy2(Long transactionId,
			Long playerId, Short domainId, Short aliasId, Timestamp transactionDate,
			Double winningAmount, Double tdsAmount, Double amount,
			Integer currencyId, Long gameId, Double vatAmount,
			String refTxnNo, String status, Short vendorId, String isCancel, String gameName,String device,String userAgent
			,String gameSessionId) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.transactionDate = transactionDate;
		this.winningAmount = winningAmount;
		this.tdsAmount = tdsAmount;
		this.amount = amount;
		this.currencyId = currencyId;
		this.gameId = gameId;
		this.gameName = gameName;
		this.vatAmount = vatAmount;
		this.refTxnNo = refTxnNo;
		this.status = status;
		this.vendorId = vendorId;
		this.isCancel = isCancel;
		this.device = device;
		this.userAgent = userAgent;
		this.gameSessionId = gameSessionId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
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

	public Timestamp getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getWinningAmount() {
		return this.winningAmount;
	}

	public void setWinningAmount(Double winningAmount) {
		this.winningAmount = winningAmount;
	}

	public Double getTdsAmount() {
		return this.tdsAmount;
	}

	public void setTdsAmount(Double tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Long getGameId() {
		return this.gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public Double getVatAmount() {
		return this.vatAmount;
	}

	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public String getRefTxnNo() {
		return this.refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Short vendorId) {
		this.vendorId = vendorId;
	}

	public String getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameName() {
		return gameName;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getGameSessionId() {
		return gameSessionId;
	}

	public void setGameSessionId(String gameSessionId) {
		this.gameSessionId = gameSessionId;
	}
	
	

}