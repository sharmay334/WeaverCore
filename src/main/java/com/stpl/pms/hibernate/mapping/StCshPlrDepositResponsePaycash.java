package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrDepositResponsePaycash entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositResponsePaycash implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String bid;
	private Long refRequestId;
	private Double amount;
	private String crn;
	private String itc;
	private String paymentStatus;
	private String verificationStatus;

	// Constructors

	/** default constructor */
	public StCshPlrDepositResponsePaycash() {
	}

	/** minimal constructor */
	public StCshPlrDepositResponsePaycash(Long refRequestId, Double amount,
			String itc, String paymentStatus) {
		this.refRequestId = refRequestId;
		this.amount = amount;
		this.itc = itc;
		this.paymentStatus = paymentStatus;
	}

	/** full constructor */
	public StCshPlrDepositResponsePaycash(String bid, Long refRequestId,
			Double amount, String crn, String itc, String paymentStatus,
			String verificationStatus) {
		this.bid = bid;
		this.refRequestId = refRequestId;
		this.amount = amount;
		this.crn = crn;
		this.itc = itc;
		this.paymentStatus = paymentStatus;
		this.verificationStatus = verificationStatus;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBid() {
		return this.bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public Long getRefRequestId() {
		return this.refRequestId;
	}

	public void setRefRequestId(Long refRequestId) {
		this.refRequestId = refRequestId;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCrn() {
		return this.crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getItc() {
		return this.itc;
	}

	public void setItc(String itc) {
		this.itc = itc;
	}

	public String getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getVerificationStatus() {
		return this.verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

}