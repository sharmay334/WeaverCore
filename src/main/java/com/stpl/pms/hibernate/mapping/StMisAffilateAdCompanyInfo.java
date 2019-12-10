package com.stpl.pms.hibernate.mapping;

public class StMisAffilateAdCompanyInfo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private short domainId;
	private short aliasId;
	private String adCompanyName;
	private String offerId;
	private String affiliateOption;
	private Double rakePercentage;
	private String status;	


	public StMisAffilateAdCompanyInfo(){}


	public StMisAffilateAdCompanyInfo(short domainId, short aliasId, String adCompanyName, String offerId,
			String affiliateOption, Double rakePercentage,String status) {
		super();
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.adCompanyName = adCompanyName;
		this.offerId = offerId;
		this.affiliateOption = affiliateOption;
		this.rakePercentage = rakePercentage;
		this.status=status;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Double getRakePercentage() {
		return rakePercentage;
	}


	public void setRakePercentage(Double rakePercentage) {
		this.rakePercentage = rakePercentage;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
}
