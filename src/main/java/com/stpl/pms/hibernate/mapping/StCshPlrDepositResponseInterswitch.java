package com.stpl.pms.hibernate.mapping;

import com.stpl.pms.javabeans.InterSwitchPGBean;

/**
 * StCshPlrDepositResponseInterswitch entity. @author MyEclipse Persistence
 * Tools
 */

public class StCshPlrDepositResponseInterswitch implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private String requestId;
	private String pgRefNo;
	private String payRef;
	private String amount;
	private String cardNo;
	private String leadBankCbnCode;
	private String leadBankName;
	private String transactionDate;
	private String splitAccount;
	private String responseCode;
	private String respDesc;
	
	// Constructors

	/** default constructor */
	public StCshPlrDepositResponseInterswitch() {
	}

	/** full constructor */
	public StCshPlrDepositResponseInterswitch(String requestId, String pgRefNo,
			String payRef, String amount, String cardNo,
			String leadBankCbnCode, String leadBankName,
			String transactionDate, String splitAccount, String responseCode,
			String respDesc) {
		this.requestId = requestId;
		this.pgRefNo = pgRefNo;
		this.payRef = payRef;
		this.amount = amount;
		this.cardNo = cardNo;
		this.leadBankCbnCode = leadBankCbnCode;
		this.leadBankName = leadBankName;
		this.transactionDate = transactionDate;
		this.splitAccount = splitAccount;
		this.responseCode = responseCode;
		this.respDesc = respDesc;
	}

	// Property accessors

	public StCshPlrDepositResponseInterswitch(InterSwitchPGBean depRep) {
		this.requestId = depRep.getMerchantReference()!=null?depRep.getMerchantReference().toString():null;
		this.pgRefNo = depRep.getRetrievalReferenceNumber()!=null?depRep.getRetrievalReferenceNumber().toString():null;
		this.payRef = depRep.getPaymentReference()!=null?depRep.getPaymentReference().toString():null;
		this.amount = depRep.getAmount()!=null?depRep.getAmount().toString():null;
		this.cardNo = depRep.getCardNumber()!=null?depRep.getCardNumber().toString():null;
		this.leadBankCbnCode = depRep.getLeadBankCbnCode()!=null?depRep.getLeadBankCbnCode().toString():null;
		this.leadBankName = depRep.getLeadBankName()!=null?depRep.getLeadBankName().toString():null;
		this.transactionDate = depRep.getTransactionDate()!=null?depRep.getTransactionDate().toString():null;
		this.splitAccount = depRep.getSplitAccounts()!=null?depRep.getSplitAccounts().toString():null;
		this.responseCode = depRep.getResponseCode()!=null?depRep.getResponseCode().toString():null;
		this.respDesc = depRep.getResponseDescription()!=null?depRep.getResponseDescription().toString():null;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestId() {
		return this.requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getPgRefNo() {
		return this.pgRefNo;
	}

	public void setPgRefNo(String pgRefNo) {
		this.pgRefNo = pgRefNo;
	}

	public String getPayRef() {
		return this.payRef;
	}

	public void setPayRef(String payRef) {
		this.payRef = payRef;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getLeadBankCbnCode() {
		return this.leadBankCbnCode;
	}

	public void setLeadBankCbnCode(String leadBankCbnCode) {
		this.leadBankCbnCode = leadBankCbnCode;
	}

	public String getLeadBankName() {
		return this.leadBankName;
	}

	public void setLeadBankName(String leadBankName) {
		this.leadBankName = leadBankName;
	}

	public String getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getSplitAccount() {
		return this.splitAccount;
	}

	public void setSplitAccount(String splitAccount) {
		this.splitAccount = splitAccount;
	}

	public String getResponseCode() {
		return this.responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getRespDesc() {
		return this.respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

}