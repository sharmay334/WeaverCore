package com.stpl.pms.javabeans;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown= true)
public class WeaverServiceRequestBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String serviceUserName;
	private String servicePassword;
	private String requestType;
	private String domainName;
	private String availabilityValue;

	private PlayerRegAPIBean playerRegistrationData;

	private String userName;
	private String mobileNo;
	private String emailId;
	
	private String affiliateReference;
	
	private Double amount;
	private String refTxnNo;
	private String paymentType;
	private String providerName;
	private String depositMode;
	
	private String fromDate;
	private String toDate;
	private Long withTxnId;
	private String verficationCode;
	
	public String getAffiliateReference() {
		return affiliateReference;
	}

	public void setAffiliateReference(String affiliateReference) {
		this.affiliateReference = affiliateReference;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getAvailabilityValue() {
		return availabilityValue;
	}

	public void setAvailabilityValue(String availabilityValue) {
		this.availabilityValue = availabilityValue;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getRefTxnNo() {
		return refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public void setPlayerRegistrationData(
			PlayerRegAPIBean playerRegistrationData) {
		this.playerRegistrationData = playerRegistrationData;
	}

	public PlayerRegAPIBean getPlayerRegistrationData() {
		return playerRegistrationData;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setServicePassword(String servicePassword) {
		this.servicePassword = servicePassword;
	}

	public String getServicePassword() {
		return servicePassword;
	}

	public void setServiceUserName(String serviceUserName) {
		this.serviceUserName = serviceUserName;
	}

	public String getServiceUserName() {
		return serviceUserName;
	}

	public void setDepositMode(String depositMode) {
		this.depositMode = depositMode;
	}

	public String getDepositMode() {
		return depositMode;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getToDate() {
		return toDate;
	}

	public Long getWithTxnId() {
		return withTxnId;
	}
	
	public void setWithTxnId(Long withTxnId) {
		this.withTxnId = withTxnId;
	}
	
	public void setVerficationCode(String verficationCode) {
		this.verficationCode = verficationCode;
	}
	
	public String getVerficationCode() {
		return verficationCode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
