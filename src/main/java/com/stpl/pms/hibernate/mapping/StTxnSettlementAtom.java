package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnSettlementAtom entity. @author MyEclipse Persistence Tools
 */

public class StTxnSettlementAtom implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String merchantId;
	private String merchantName;
	private String pgRefNo;
	private String transactionState;
	private Timestamp transactionDate;
	private String clientCode;
	private String requestId;
	private String productName;
	private String discriminator;
	private String bankName;
	private String cardType;
	private String cardNo;
	private String cardIssuingBank;
	private String bankRefNo;
	private String refundRefNo;
	private Double grossTxnAmount;
	private Double txnCharges;
	private Double serviceTax;
	private Double sBCess;
	private Double krishiKalyanCess;
	private Double totalChargeable;
	private Double netAmounttobePaid;
	private String refundStatus;
	private String paymentStatus;
	private String settlementDate;

	// Constructors

	/** default constructor */
	public StTxnSettlementAtom() {
	}

	public StTxnSettlementAtom(Long id, String merchantId, String merchantName,
			String pgRefNo, String transactionState, Timestamp transactionDate,
			String clientCode, String requestId, String productName,
			String discriminator, String bankName, String cardType,
			String cardNo, String cardIssuingBank, String bankRefNo,
			String refundRefNo, Double grossTxnAmount, Double txnCharges,
			Double serviceTax, Double sBCess, Double krishiKalyanCess,
			Double totalChargeable, Double netAmounttobePaid,
			String refundStatus, String paymentStatus, String settlementDate) {
		super();
		this.id = id;
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.pgRefNo = pgRefNo;
		this.transactionState = transactionState;
		this.transactionDate = transactionDate;
		this.clientCode = clientCode;
		this.requestId = requestId;
		this.productName = productName;
		this.discriminator = discriminator;
		this.bankName = bankName;
		this.cardType = cardType;
		this.cardNo = cardNo;
		this.cardIssuingBank = cardIssuingBank;
		this.bankRefNo = bankRefNo;
		this.refundRefNo = refundRefNo;
		this.grossTxnAmount = grossTxnAmount;
		this.txnCharges = txnCharges;
		this.serviceTax = serviceTax;
		this.sBCess = sBCess;
		this.krishiKalyanCess = krishiKalyanCess;
		this.totalChargeable = totalChargeable;
		this.netAmounttobePaid = netAmounttobePaid;
		this.refundStatus = refundStatus;
		this.paymentStatus = paymentStatus;
		this.settlementDate = settlementDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getPgRefNo() {
		return pgRefNo;
	}

	public void setPgRefNo(String pgRefNo) {
		this.pgRefNo = pgRefNo;
	}

	public String getTransactionState() {
		return transactionState;
	}

	public void setTransactionState(String transactionState) {
		this.transactionState = transactionState;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDiscriminator() {
		return discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardIssuingBank() {
		return cardIssuingBank;
	}

	public void setCardIssuingBank(String cardIssuingBank) {
		this.cardIssuingBank = cardIssuingBank;
	}

	public String getBankRefNo() {
		return bankRefNo;
	}

	public void setBankRefNo(String bankRefNo) {
		this.bankRefNo = bankRefNo;
	}

	public String getRefundRefNo() {
		return refundRefNo;
	}

	public void setRefundRefNo(String refundRefNo) {
		this.refundRefNo = refundRefNo;
	}

	public Double getGrossTxnAmount() {
		return grossTxnAmount;
	}

	public void setGrossTxnAmount(Double grossTxnAmount) {
		this.grossTxnAmount = grossTxnAmount;
	}

	public Double getTxnCharges() {
		return txnCharges;
	}

	public void setTxnCharges(Double txnCharges) {
		this.txnCharges = txnCharges;
	}

	public Double getServiceTax() {
		return serviceTax;
	}

	public void setServiceTax(Double serviceTax) {
		this.serviceTax = serviceTax;
	}

	public Double getsBCess() {
		return sBCess;
	}

	public void setsBCess(Double sBCess) {
		this.sBCess = sBCess;
	}

	public Double getKrishiKalyanCess() {
		return krishiKalyanCess;
	}

	public void setKrishiKalyanCess(Double krishiKalyanCess) {
		this.krishiKalyanCess = krishiKalyanCess;
	}

	public Double getTotalChargeable() {
		return totalChargeable;
	}

	public void setTotalChargeable(Double totalChargeable) {
		this.totalChargeable = totalChargeable;
	}

	public Double getNetAmounttobePaid() {
		return netAmounttobePaid;
	}

	public void setNetAmounttobePaid(Double netAmounttobePaid) {
		this.netAmounttobePaid = netAmounttobePaid;
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}