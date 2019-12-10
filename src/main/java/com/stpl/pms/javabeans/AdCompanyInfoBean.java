package com.stpl.pms.javabeans;

import java.io.Serializable;

public class AdCompanyInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long affilateId;
	private short domainId;
	private short aliasId;
	private String adCompanyName;
	private String offerId;
	private String affiliateOption;
	private double rakePercentage;
	private String status;
	
	public AdCompanyInfoBean(long affilateId, short domainId, short aliasId, String adCompanyName, String offerId,
			String affiliateOption, Double rakePercentage, String status) {
		super();
		this.affilateId = affilateId;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.adCompanyName = adCompanyName;
		this.offerId = offerId;
		this.affiliateOption = affiliateOption;
		this.rakePercentage = rakePercentage;
		this.status = status;
	}

	public long getAffilateId() {
		return affilateId;
	}

	public void setAffilateId(long affilateId) {
		this.affilateId = affilateId;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public short getAliasId() {
		return aliasId;
	}

	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}

	public String getAdCompanyName() {
		return adCompanyName;
	}

	public void setAdCompanyName(String adCompanyName) {
		this.adCompanyName = adCompanyName;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public String getAffiliateOption() {
		return affiliateOption;
	}

	public void setAffiliateOption(String affiliateOption) {
		this.affiliateOption = affiliateOption;
	}

	public double getRakePercentage() {
		return rakePercentage;
	}

	public void setRakePercentage(double rakePercentage) {
		this.rakePercentage = rakePercentage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
	
	
	
	
	

}
