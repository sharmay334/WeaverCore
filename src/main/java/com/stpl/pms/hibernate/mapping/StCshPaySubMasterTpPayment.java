package com.stpl.pms.hibernate.mapping;

/**
 * tpPaymentTypeDispCode entity. @author MyEclipse Persistence Tools
 */

public class StCshPaySubMasterTpPayment extends StCshPaySubMaster implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer subTypeId;
	private String tpPaymentTypeDispCode;
	private String status;

	// Constructors

	/** default constructor */
	public StCshPaySubMasterTpPayment() {
	}

	/** full constructor */
	public StCshPaySubMasterTpPayment(Integer subTypeId, String tpPaymentTypeDispCode, String status) {
		this.subTypeId = subTypeId;
		this.tpPaymentTypeDispCode = tpPaymentTypeDispCode;
		this.status = status;
	}

	// Property accessors
	@Override
	public Integer getSubTypeId() {
		return this.subTypeId;
	}

	@Override
	public void setSubTypeId(Integer subTypeId) {
		this.subTypeId = subTypeId;
	}

	public String getTpPaymentTypeDispCode() {
		return this.tpPaymentTypeDispCode;
	}

	public void setTpPaymentTypeDispCode(String tpPaymentTypeDispCode) {
		this.tpPaymentTypeDispCode = tpPaymentTypeDispCode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}