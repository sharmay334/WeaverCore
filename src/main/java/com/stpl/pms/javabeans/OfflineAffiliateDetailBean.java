package com.stpl.pms.javabeans;

public class OfflineAffiliateDetailBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer affiliateId;
	private String affiliateCode;
	private String userName;
	private String password;
	private String secreatKey;
	private Integer providerId;

	public OfflineAffiliateDetailBean(Integer affiliateId, String affiliateCode,
			String userName, String password, String secreatKey, Integer providerId) {
		this.affiliateId = affiliateId;
		this.affiliateCode = affiliateCode;
		this.userName = userName;
		this.password = password;
		this.secreatKey = secreatKey;
		this.providerId = providerId;
	}

	public Integer getAffiliateId() {
		return affiliateId;
	}

	public void setAffiliateId(Integer affiliateId) {
		this.affiliateId = affiliateId;
	}

	public String getAffiliateCode() {
		return affiliateCode;
	}

	public void setAffiliateCode(String affiliateCode) {
		this.affiliateCode = affiliateCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecreatKey() {
		return secreatKey;
	}

	public void setSecreatKey(String secreatKey) {
		this.secreatKey = secreatKey;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

}
