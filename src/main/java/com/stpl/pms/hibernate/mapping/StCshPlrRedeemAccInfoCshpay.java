package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrRedeemAccInfoCshpay entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrRedeemAccInfoCshpay extends StCshPlrRedeemAccMaster
		implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String affiliateCode;
	private Integer affiliateId;
	private String status;

	// Constructors

	/** default constructor */
	public StCshPlrRedeemAccInfoCshpay() {
	}

	public StCshPlrRedeemAccInfoCshpay(StCshPlrRedeemAccMaster redAccMaster,
			String affiliateCode, Integer affiliateId, String status) {
		super(redAccMaster.getPaymentType(), redAccMaster.getProviderId(),
				redAccMaster.getPlayerId(), redAccMaster.getStatus(),
				redAccMaster.getPaymentTypeMas());
		this.affiliateCode = affiliateCode;
		this.affiliateId = affiliateId;
		this.status = status;
	}

	public String getAffiliateCode() {
		return this.affiliateCode;
	}

	public void setAffiliateCode(String affiliateCode) {
		this.affiliateCode = affiliateCode;
	}

	public Integer getAffiliateId() {
		return this.affiliateId;
	}

	public void setAffiliateId(Integer affiliateId) {
		this.affiliateId = affiliateId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}