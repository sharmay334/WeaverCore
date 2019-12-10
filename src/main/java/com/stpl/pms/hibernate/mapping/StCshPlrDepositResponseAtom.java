package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StCshPlrDepositResponseAtom entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositResponseAtom implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String mmpTxn;
	private Long refRequestId;
	private String productId;
	private Timestamp txnDate;
	private String bankTxn;
	private Double amount;
	private String FCode;
	private String clientcode;
	private String bankName;

	// Constructors

	/** default constructor */
	public StCshPlrDepositResponseAtom() {
	}

	/** full constructor */
	public StCshPlrDepositResponseAtom(String mmpTxn, Long refRequestId,
			String productId, Timestamp txnDate, String bankTxn, Double amount,
			String FCode, String clientcode, String bankName) {
		this.mmpTxn = mmpTxn;
		this.refRequestId = refRequestId;
		this.productId = productId;
		this.txnDate = txnDate;
		this.bankTxn = bankTxn;
		this.amount = amount;
		this.FCode = FCode;
		this.clientcode = clientcode;
		this.bankName = bankName;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMmpTxn() {
		return this.mmpTxn;
	}

	public void setMmpTxn(String mmpTxn) {
		this.mmpTxn = mmpTxn;
	}

	public Long getRefRequestId() {
		return this.refRequestId;
	}

	public void setRefRequestId(Long refRequestId) {
		this.refRequestId = refRequestId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Timestamp getTxnDate() {
		return this.txnDate;
	}

	public void setTxnDate(Timestamp txnDate) {
		this.txnDate = txnDate;
	}

	public String getBankTxn() {
		return this.bankTxn;
	}

	public void setBankTxn(String bankTxn) {
		this.bankTxn = bankTxn;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getFCode() {
		return this.FCode;
	}

	public void setFCode(String FCode) {
		this.FCode = FCode;
	}

	public String getClientcode() {
		return this.clientcode;
	}

	public void setClientcode(String clientcode) {
		this.clientcode = clientcode;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}