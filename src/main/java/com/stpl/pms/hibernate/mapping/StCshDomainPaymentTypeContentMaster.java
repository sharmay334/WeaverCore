package com.stpl.pms.hibernate.mapping;

public class StCshDomainPaymentTypeContentMaster implements
		java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Short id;
	private Short domainId;
	private Integer paymentTypeId;
	private String contentPath;
	private String txnType;
	private String device;
	private String status;

	// Constructors

	/** default constructor */
	public StCshDomainPaymentTypeContentMaster() {
	}

	/** minimal constructor */
	public StCshDomainPaymentTypeContentMaster(Short domainId,
			Integer paymentTypeId) {
		this.domainId = domainId;
		this.paymentTypeId = paymentTypeId;
	}

	public StCshDomainPaymentTypeContentMaster(Short id, Short domainId,
			Integer paymentTypeId, String contentPath, String txnType,
			String device, String status) {
		this.id = id;
		this.domainId = domainId;
		this.paymentTypeId = paymentTypeId;
		this.contentPath = contentPath;
		this.txnType = txnType;
		this.device = device;
		this.status = status;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Integer getPaymentTypeId() {
		return this.paymentTypeId;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getContentPath() {
		return this.contentPath;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDevice() {
		return device;
	}

}