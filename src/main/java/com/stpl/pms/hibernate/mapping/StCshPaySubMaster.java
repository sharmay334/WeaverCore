package com.stpl.pms.hibernate.mapping;

/**
 * StCshPaySubMaster entity. @author MyEclipse Persistence Tools
 */

public class StCshPaySubMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer subTypeId;
	private String paymentType;
	private Integer paymentTypeId;
	
	// Constructors

	/** default constructor */
	public StCshPaySubMaster() {
	}

	// Property accessors

	public Integer getSubTypeId() {
		return this.subTypeId;
	}

	public void setSubTypeId(Integer subTypeId) {
		this.subTypeId = subTypeId;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public Integer getPaymentTypeId() {
		return paymentTypeId;
	}

}