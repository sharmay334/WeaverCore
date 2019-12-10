package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnPlrWagerRefundMasterGoldenRace18 entity. @author MyEclipse Persistence
 * Tools
 */

public class StTxnPlrWagerRefundMasterGoldenRace18 implements
		java.io.Serializable {

	// Fields

	private Long id;
	private Long transactionId;
	private Long playerId;
	private Integer unitId;
	private Integer staffId;
	private Short domainId;
	private Short aliasId;
	private Timestamp transactionDate;
	private Double amount;
	private Double amountNative;
	private Integer currencyId;
	private Short gameId;
	private Double vatAmount;
	private Double vatAmountNative;
	private String refTxnNo;
	private Double wgrContriAmt;
	private String gameType;
	private String gameName;
	private Short vendorId;
	private Double processChargeRefund;
	private Long refWagerTxnId;
	private Double refundCharge;
	private Double refundChargeNative;
	private String isCancel;

	// Constructors

	/** default constructor */
	public StTxnPlrWagerRefundMasterGoldenRace18() {
	}

	/** minimal constructor */
	public StTxnPlrWagerRefundMasterGoldenRace18(Long transactionId,
			Long playerId, Short domainId, Short aliasId,
			Timestamp transactionDate, Double amount, Double amountNative,
			Integer currencyId, Short vendorId, Double processChargeRefund,
			Long refWagerTxnId, Double refundCharge, Double refundChargeNative,
			String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.amountNative = amountNative;
		this.currencyId = currencyId;
		this.vendorId = vendorId;
		this.processChargeRefund = processChargeRefund;
		this.refWagerTxnId = refWagerTxnId;
		this.refundCharge = refundCharge;
		this.refundChargeNative = refundChargeNative;
		this.isCancel = isCancel;
	}

	/** full constructor */
	public StTxnPlrWagerRefundMasterGoldenRace18(Long transactionId,
			Long playerId, Integer unitId, Integer staffId, Short domainId,
			Short aliasId, Timestamp transactionDate, Double amount,
			Double amountNative, Integer currencyId, Short gameId,
			Double vatAmount, Double vatAmountNative, String refTxnNo,
			Double wgrContriAmt, String gameType, String gameName,
			Short vendorId, Double processChargeRefund, Long refWagerTxnId,
			Double refundCharge, Double refundChargeNative, String isCancel) {
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.unitId = unitId;
		this.staffId = staffId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.amountNative = amountNative;
		this.currencyId = currencyId;
		this.gameId = gameId;
		this.vatAmount = vatAmount;
		this.vatAmountNative = vatAmountNative;
		this.refTxnNo = refTxnNo;
		this.wgrContriAmt = wgrContriAmt;
		this.gameType = gameType;
		this.gameName = gameName;
		this.vendorId = vendorId;
		this.processChargeRefund = processChargeRefund;
		this.refWagerTxnId = refWagerTxnId;
		this.refundCharge = refundCharge;
		this.refundChargeNative = refundChargeNative;
		this.isCancel = isCancel;
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

	public Integer getUnitId() {
		return this.unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
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

	public Timestamp getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAmountNative() {
		return this.amountNative;
	}

	public void setAmountNative(Double amountNative) {
		this.amountNative = amountNative;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Short getGameId() {
		return this.gameId;
	}

	public void setGameId(Short gameId) {
		this.gameId = gameId;
	}

	public Double getVatAmount() {
		return this.vatAmount;
	}

	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public Double getVatAmountNative() {
		return this.vatAmountNative;
	}

	public void setVatAmountNative(Double vatAmountNative) {
		this.vatAmountNative = vatAmountNative;
	}

	public String getRefTxnNo() {
		return this.refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public Double getWgrContriAmt() {
		return this.wgrContriAmt;
	}

	public void setWgrContriAmt(Double wgrContriAmt) {
		this.wgrContriAmt = wgrContriAmt;
	}

	public String getGameType() {
		return this.gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getGameName() {
		return this.gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Short getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Short vendorId) {
		this.vendorId = vendorId;
	}

	public Double getProcessChargeRefund() {
		return this.processChargeRefund;
	}

	public void setProcessChargeRefund(Double processChargeRefund) {
		this.processChargeRefund = processChargeRefund;
	}

	public Long getRefWagerTxnId() {
		return this.refWagerTxnId;
	}

	public void setRefWagerTxnId(Long refWagerTxnId) {
		this.refWagerTxnId = refWagerTxnId;
	}

	public Double getRefundCharge() {
		return this.refundCharge;
	}

	public void setRefundCharge(Double refundCharge) {
		this.refundCharge = refundCharge;
	}

	public Double getRefundChargeNative() {
		return this.refundChargeNative;
	}

	public void setRefundChargeNative(Double refundChargeNative) {
		this.refundChargeNative = refundChargeNative;
	}

	public String getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}

}