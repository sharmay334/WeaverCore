package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;
import java.text.ParseException;

/**
 * StTxnSettlementTechprocess entity. @author MyEclipse Persistence Tools
 */

public class StTxnSettlementTechprocess implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String bankId;
	private String bankName;
	private String pgRefNo;
	private String requestId;
	private String bankTxnId;
	private Double transactionAmount;
	private Double charges;
	private Double serviceTax;
	private Double netAmount;
	private Timestamp transactionDate;
	private String transactionTime;
	private String paymentDate;
	private String srcItc;
	private String status;

	// Constructors

	/** default constructor */
	public StTxnSettlementTechprocess() {
	}

	/** full constructor 
	 * @param status */
	public StTxnSettlementTechprocess(String bankId, String bankName,
			String pgRefNo, String requestId, String bankTxnId,
			Double transactionAmount, Double charges, Double serviceTax,
			Double netAmount, Timestamp transactionDate,
			String transactionTime, String paymentDate, String srcItc, String status) {
		this.bankId = bankId;
		this.bankName = bankName;
		this.setPgRefNo(pgRefNo);
		this.requestId = requestId;
		this.bankTxnId = bankTxnId;
		this.setTransactionAmount(transactionAmount);
		this.charges = charges;
		this.serviceTax = serviceTax;
		this.netAmount = netAmount;
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;
		this.paymentDate = paymentDate;
		this.srcItc = srcItc;
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankId() {
		return this.bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankTxnId() {
		return this.bankTxnId;
	}

	public void setBankTxnId(String bankTxnId) {
		this.bankTxnId = bankTxnId;
	}

	public Double getCharges() {
		return this.charges;
	}

	public void setCharges(Double charges) {
		this.charges = charges;
	}

	public Double getServiceTax() {
		return this.serviceTax;
	}

	public void setServiceTax(Double serviceTax) {
		this.serviceTax = serviceTax;
	}

	public Double getNetAmount() {
		return this.netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public String getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(String paymentDate) throws ParseException {
		this.paymentDate = paymentDate;
	}

	public String getSrcItc() {
		return this.srcItc;
	}

	public void setSrcItc(String srcItc) {
		this.srcItc = srcItc;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setTransactionDate(Timestamp transactionDate)
			throws ParseException {
		this.transactionDate = transactionDate;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
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

}