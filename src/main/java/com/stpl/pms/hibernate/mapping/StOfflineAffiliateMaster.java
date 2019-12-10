package com.stpl.pms.hibernate.mapping;

/**
 * StOfflineAffiliateMaster entity. @author MyEclipse Persistence Tools
 */

public class StOfflineAffiliateMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer affiliateId;
	private String affiliateCode;
	private String userName;
	private String password;
	private String secreatKey;
	private Integer providerId;

	// Constructors

	/** default constructor */
	public StOfflineAffiliateMaster() {
	}

	/** full constructor */
	public StOfflineAffiliateMaster(String affiliateCode, String userName,
			String password, String secreatKey, Integer providerId) {
		this.affiliateCode = affiliateCode;
		this.userName = userName;
		this.password = password;
		this.secreatKey = secreatKey;
		this.providerId = providerId;
	}

	// Property accessors

	public Integer getAffiliateId() {
		return this.affiliateId;
	}

	public void setAffiliateId(Integer affiliateId) {
		this.affiliateId = affiliateId;
	}

	public String getAffiliateCode() {
		return this.affiliateCode;
	}

	public void setAffiliateCode(String affiliateCode) {
		this.affiliateCode = affiliateCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecreatKey() {
		return this.secreatKey;
	}

	public void setSecreatKey(String secreatKey) {
		this.secreatKey = secreatKey;
	}

	public Integer getProviderId() {
		return this.providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

}