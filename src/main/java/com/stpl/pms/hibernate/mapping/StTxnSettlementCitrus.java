package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnSettlementCitrus entity. @author MyEclipse Persistence Tools
 */

public class StTxnSettlementCitrus implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String merchantId;
	private String merchantName;
	private String paymentMode;
	private String transactionType;
	private Timestamp transactionDate;
	private Double transactionAmount;
	private String transactionCurrency;
	private String requestId;
	private String pgRefNo;
	private String issuerRefNo;
	private String pgRefId;
	private String paymentConfirmId;
	private String issuerTxnRefNo;
	private String originalTxnMerchantRefNo;
	private String orgPgRefId;
	private String orgPaymentConfirmId;
	private String orgIssuerTxnRefNo;
	private String rrnNumber;
	private String netbankingPaymentId;
	private String cardType;
	private String pgPaymentId;
	private Double discountMsfAmount;
	private Double staxOnMsf;
	private Double netSettlementAmt;
	private String status;
	
	private Double igstAmtNet;
	private Double sgstAmtNet;
	private Double cgstAmtNet;
	private String settlementDate;
	

	// Constructors

	/** default constructor */
	public StTxnSettlementCitrus() {
	}

	/** full constructor 
	 * @param status 
	 * @param cardType */
	public StTxnSettlementCitrus(String merchantId, String merchantName,
			String paymentMode, String transactionType, Timestamp transactionDate,
			Double transactionAmount, String transactionCurrency,
			String requestId, String pgRefNo, String issuerRefNo,
			String pgRefId, String paymentConfirmId, String issuerTxnRefNo,
			String originalTxnMerchantRefNo, String orgPgRefId,
			String orgPaymentConfirmId, String orgIssuerTxnRefNo,
			String rrnNumber, String netbankingPaymentId, String pgPaymentId,
			Double discountMsfAmount, Double staxOnMsf, Double netSettlementAmt, String status, String cardType) {
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.paymentMode = paymentMode;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionCurrency = transactionCurrency;
		this.requestId = requestId;
		this.setPgRefNo(pgRefNo);
		this.issuerRefNo = issuerRefNo;
		this.pgRefId = pgRefId;
		this.paymentConfirmId = paymentConfirmId;
		this.issuerTxnRefNo = issuerTxnRefNo;
		this.originalTxnMerchantRefNo = originalTxnMerchantRefNo;
		this.orgPgRefId = orgPgRefId;
		this.orgPaymentConfirmId = orgPaymentConfirmId;
		this.orgIssuerTxnRefNo = orgIssuerTxnRefNo;
		this.rrnNumber = rrnNumber;
		this.netbankingPaymentId = netbankingPaymentId;
		this.cardType = cardType;
		this.pgPaymentId = pgPaymentId;
		this.discountMsfAmount = discountMsfAmount;
		this.staxOnMsf = staxOnMsf;
		this.netSettlementAmt = netSettlementAmt;
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return this.merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Timestamp getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate ;
	}

	public Double getTransactionAmount() {
		return this.transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionCurrency() {
		return this.transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public String getIssuerRefNo() {
		return this.issuerRefNo;
	}

	public void setIssuerRefNo(String issuerRefNo) {
		this.issuerRefNo = issuerRefNo;
	}

	public String getPgRefId() {
		return this.pgRefId;
	}

	public void setPgRefId(String pgRefId) {
		this.pgRefId = pgRefId;
	}

	public String getPaymentConfirmId() {
		return this.paymentConfirmId;
	}

	public void setPaymentConfirmId(String paymentConfirmId) {
		this.paymentConfirmId = paymentConfirmId;
	}

	public String getIssuerTxnRefNo() {
		return this.issuerTxnRefNo;
	}

	public void setIssuerTxnRefNo(String issuerTxnRefNo) {
		this.issuerTxnRefNo = issuerTxnRefNo;
	}

	public String getOriginalTxnMerchantRefNo() {
		return this.originalTxnMerchantRefNo;
	}

	public void setOriginalTxnMerchantRefNo(String originalTxnMerchantRefNo) {
		this.originalTxnMerchantRefNo = originalTxnMerchantRefNo;
	}

	public String getOrgPgRefId() {
		return this.orgPgRefId;
	}

	public void setOrgPgRefId(String orgPgRefId) {
		this.orgPgRefId = orgPgRefId;
	}

	public String getOrgPaymentConfirmId() {
		return this.orgPaymentConfirmId;
	}

	public void setOrgPaymentConfirmId(String orgPaymentConfirmId) {
		this.orgPaymentConfirmId = orgPaymentConfirmId;
	}

	public String getOrgIssuerTxnRefNo() {
		return this.orgIssuerTxnRefNo;
	}

	public void setOrgIssuerTxnRefNo(String orgIssuerTxnRefNo) {
		this.orgIssuerTxnRefNo = orgIssuerTxnRefNo;
	}

	public String getRrnNumber() {
		return this.rrnNumber;
	}

	public void setRrnNumber(String rrnNumber) {
		this.rrnNumber = rrnNumber;
	}

	public String getNetbankingPaymentId() {
		return this.netbankingPaymentId;
	}

	public void setNetbankingPaymentId(String netbankingPaymentId) {
		this.netbankingPaymentId = netbankingPaymentId;
	}

	public String getPgPaymentId() {
		return this.pgPaymentId;
	}

	public void setPgPaymentId(String pgPaymentId) {
		this.pgPaymentId = pgPaymentId;
	}

	public Double getDiscountMsfAmount() {
		return this.discountMsfAmount;
	}

	public void setDiscountMsfAmount(Double discountMsfAmount) {
		this.discountMsfAmount = discountMsfAmount;
	}

	public Double getStaxOnMsf() {
		return this.staxOnMsf;
	}

	public void setStaxOnMsf(Double staxOnMsf) {
		this.staxOnMsf = staxOnMsf;
	}

	public Double getNetSettlementAmt() {
		return this.netSettlementAmt;
	}

	public void setNetSettlementAmt(Double netSettlementAmt) {
		this.netSettlementAmt = netSettlementAmt;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setPgRefNo(String pgRefNo) {
		this.pgRefNo = pgRefNo;
	}

	public String getPgRefNo() {
		return pgRefNo;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Double getIgstAmtNet() {
		return igstAmtNet;
	}

	public void setIgstAmtNet(Double igstAmtNet) {
		this.igstAmtNet = igstAmtNet;
	}

	public Double getSgstAmtNet() {
		return sgstAmtNet;
	}

	public void setSgstAmtNet(Double sgstAmtNet) {
		this.sgstAmtNet = sgstAmtNet;
	}

	public Double getCgstAmtNet() {
		return cgstAmtNet;
	}

	public void setCgstAmtNet(Double cgstAmtNet) {
		this.cgstAmtNet = cgstAmtNet;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}
	
	
}