package com.stpl.pms.javabeans;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlrRedeemAccPrepaidWalletInfoBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long redeemAccId;

	private Integer paymentTypeId;
	private String paymentType;
	private Integer providerId;
	
	private Integer subtypeId;
	private String userName;
	private String emailId;
	private Long mobileNo;
	private String status;
	private String walletName;
	
	public PlrRedeemAccPrepaidWalletInfoBean() {
	}


	public PlrRedeemAccPrepaidWalletInfoBean(Long redeemAccId, Integer subTypeId,
			String userName, String emailId, Long mobileNo,
			String status, Integer paymentTypeId, String paymentType,
			Integer providerId, String walletName) {
		this.subtypeId = subTypeId;
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.status = status;
		this.redeemAccId = redeemAccId;
		this.paymentTypeId = paymentTypeId;
		this.paymentType = paymentType;
		this.providerId = providerId;
		this.walletName = walletName;
	}

	public Long getRedeemAccId() {
		return redeemAccId;
	}

	public void setRedeemAccId(Long redeemAccId) {
		this.redeemAccId = redeemAccId;
	}

	public Integer getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Integer getSubtypeId() {
		return subtypeId;
	}

	public void setSubtypeId(Integer subtypeId) {
		this.subtypeId = subtypeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getWalletName() {
		return walletName;
	}


	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}

	
}
