package com.stpl.pms.hibernate.mapping;

/**
 * StCshRedeemAccOptionMaster entity. @author MyEclipse Persistence Tools
 */

public class StCshRedeemAccOptionMaster implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer paymentTypeId;
	private Integer providerId;
	private String isRedeemAcc;

	// Constructors

	/** default constructor */
	public StCshRedeemAccOptionMaster() {
	}

	/** full constructor */
	public StCshRedeemAccOptionMaster(Integer paymentTypeId,
			Integer providerId, String isRedeemAcc) {
		this.paymentTypeId = paymentTypeId;
		this.providerId = providerId;
		this.isRedeemAcc = isRedeemAcc;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPaymentTypeId() {
		return this.paymentTypeId;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public Integer getProviderId() {
		return this.providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getIsRedeemAcc() {
		return this.isRedeemAcc;
	}

	public void setIsRedeemAcc(String isRedeemAcc) {
		this.isRedeemAcc = isRedeemAcc;
	}

}