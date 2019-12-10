package com.stpl.pms.javabeans;

import static org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = NON_NULL)
public class PlrRedeemAccWariInfoBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long redeemAccId;
	private Integer paymentTypeId;
	private String paymentType;
	private Integer providerId;
	private Integer subtypeId;
	private Long mobileNo;
	private String firstName;
	private String lastName;
	private String senderName;
	private String status;
	private String walletName;
	
	public PlrRedeemAccWariInfoBean() {
	}


	public PlrRedeemAccWariInfoBean(Long redeemAccId, Integer subTypeId,
			String firstName,  String lastName,String senderName, Long mobileNo,
			String status, Integer paymentTypeId, String paymentType,
			Integer providerId) {
		this.subtypeId = subTypeId;
		this.mobileNo = mobileNo;
		this.status = status;
		this.redeemAccId = redeemAccId;
		this.paymentTypeId = paymentTypeId;
		this.paymentType = paymentType;
		this.providerId = providerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.senderName = senderName;
		
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

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getSenderName() {
		return senderName;
	}


	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}


	public String getWalletName() {
		return walletName;
	}


	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}	
	
	

}
