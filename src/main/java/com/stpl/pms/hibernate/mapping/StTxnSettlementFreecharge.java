package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;
import java.sql.Timestamp;

public class StTxnSettlementFreecharge implements Serializable {
	private static final long serialVersionUID = 1L;
	public StTxnSettlementFreecharge(Long id, Timestamp txnDate, String requestId, String transactionId,
			String merchantId, String merchantName, String transactionType, Double transactionAmount,
			Double merchantFee, Double serviceTax, Double swachhBharatCess, Double krishiKalyanCess,
			Double netDeduction, Double payableAmount, String platformId, String terminalId, String terminalName,
			String storeId, String storeName, String productId, String customerId, String customerName,
			String transactionStatus, String location, String shippingCity, String mobile, String emailId,
			String dealerId, String dealerName, String partnerId, String bankReferenceNumber, String status) {
		super();
		this.id = id;
		this.txnDate = txnDate;
		this.requestId = requestId;
		this.transactionId = transactionId;
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.merchantFee = merchantFee;
		this.serviceTax = serviceTax;
		this.swachhBharatCess = swachhBharatCess;
		this.krishiKalyanCess = krishiKalyanCess;
		this.netDeduction = netDeduction;
		this.payableAmount = payableAmount;
		this.platformId = platformId;
		this.terminalId = terminalId;
		this.terminalName = terminalName;
		this.storeId = storeId;
		this.storeName = storeName;
		this.productId = productId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.transactionStatus = transactionStatus;
		this.location = location;
		this.shippingCity = shippingCity;
		this.mobile = mobile;
		this.emailId = emailId;
		this.dealerId = dealerId;
		this.dealerName = dealerName;
		this.partnerId = partnerId;
		this.bankReferenceNumber = bankReferenceNumber;
		this.status = status;
	}

	public StTxnSettlementFreecharge() {
		// TODO Auto-generated constructor stub
	}

	private Long id;
	private Timestamp txnDate;
	private String requestId;
	private String transactionId;
	private String merchantId;
	private String merchantName;
	private String transactionType;
	private Double transactionAmount;
	private Double merchantFee;
	private Double serviceTax;
	private Double swachhBharatCess;
	private Double krishiKalyanCess;
	private Double netDeduction;
	private Double payableAmount;
	private String platformId;
	private String terminalId;
	private String terminalName;
	private String storeId;
	private String storeName;
	private String productId;
	private String customerId;
	private String customerName;
	private String transactionStatus;
	private String location;
	private String shippingCity;
	private String mobile;
	private String emailId;
	private String dealerId;
	private String dealerName;
	private String partnerId;
	private String bankReferenceNumber;
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Timestamp txnDate) {
		this.txnDate = txnDate;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Double getMerchantFee() {
		return merchantFee;
	}

	public void setMerchantFee(Double merchantFee) {
		this.merchantFee = merchantFee;
	}

	public Double getServiceTax() {
		return serviceTax;
	}

	public void setServiceTax(Double serviceTax) {
		this.serviceTax = serviceTax;
	}

	public Double getSwachhBharatCess() {
		return swachhBharatCess;
	}

	public void setSwachhBharatCess(Double swachhBharatCess) {
		this.swachhBharatCess = swachhBharatCess;
	}

	public Double getKrishiKalyanCess() {
		return krishiKalyanCess;
	}

	public void setKrishiKalyanCess(Double krishiKalyanCess) {
		this.krishiKalyanCess = krishiKalyanCess;
	}

	public Double getNetDeduction() {
		return netDeduction;
	}

	public void setNetDeduction(Double netDeduction) {
		this.netDeduction = netDeduction;
	}

	public Double getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(Double payableAmount) {
		this.payableAmount = payableAmount;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getBankReferenceNumber() {
		return bankReferenceNumber;
	}

	public void setBankReferenceNumber(String bankReferenceNumber) {
		this.bankReferenceNumber = bankReferenceNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StTxnSettlementFreecharge [id=" + id + ", txnDate=" + txnDate + ", requestId="
				+ requestId + ", transactionId=" + transactionId + ", merchantId=" + merchantId + ", merchantName="
				+ merchantName + ", transactionType=" + transactionType + ", transactionAmount=" + transactionAmount
				+ ", merchantFee=" + merchantFee + ", serviceTax=" + serviceTax + ", swachhBharatCess="
				+ swachhBharatCess + ", krishiKalyanCess=" + krishiKalyanCess + ", netDeduction=" + netDeduction
				+ ", payableAmount=" + payableAmount + ", platformId=" + platformId + ", terminalId=" + terminalId
				+ ", terminalName=" + terminalName + ", storeId=" + storeId + ", storeName=" + storeName
				+ ", productId=" + productId + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", transactionStatus=" + transactionStatus + ", location=" + location + ", shippingCity="
				+ shippingCity + ", mobile=" + mobile + ", emailId=" + emailId + ", dealerId=" + dealerId
				+ ", dealerName=" + dealerName + ", partnerId=" + partnerId + ", bankReferenceNumber="
				+ bankReferenceNumber + ", status=" + status + "]";
	}
}
