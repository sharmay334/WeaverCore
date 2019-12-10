package com.stpl.pms.javabeans;

public class PlrRedeemAccCshPayInfoBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer paymentTypeId;
	private String paymentType;
	private Integer providerId;

	private Long redeemAccId;
	private String affiliateCode;
	private Integer affiliateId;
	private String status;
	private boolean redeemAccCreated;

	public PlrRedeemAccCshPayInfoBean() {
	}

	public PlrRedeemAccCshPayInfoBean(Long redeemAccId, String affiliateCode,
			Integer affiliateId, String status, boolean redeemAccCreated,
			Integer paymentTypeId, String paymentType, Integer providerId) {
		this.redeemAccId = redeemAccId;
		this.affiliateCode = affiliateCode;
		this.affiliateId = affiliateId;
		this.status = status;
		this.redeemAccCreated = redeemAccCreated;
		this.paymentTypeId = paymentTypeId;
		this.paymentType = paymentType;
		this.providerId = providerId;
	}

	public Long getRedeemAccId() {
		return redeemAccId;
	}

	public void setRedeemAccId(Long redeemAccId) {
		this.redeemAccId = redeemAccId;
	}

	public String getAffiliateCode() {
		return affiliateCode;
	}

	public void setAffiliateCode(String affiliateCode) {
		this.affiliateCode = affiliateCode;
	}

	public Integer getAffiliateId() {
		return affiliateId;
	}

	public void setAffiliateId(Integer affiliateId) {
		this.affiliateId = affiliateId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isRedeemAccCreated() {
		return redeemAccCreated;
	}

	public void setRedeemAccCreated(boolean redeemAccCreated) {
		this.redeemAccCreated = redeemAccCreated;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public Integer getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Integer getProviderId() {
		return providerId;
	}

}
