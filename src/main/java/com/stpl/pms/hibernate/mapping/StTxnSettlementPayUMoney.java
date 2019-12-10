package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

public class StTxnSettlementPayUMoney implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	
	private String pgRefNo;
	private Double transactionAmount;
	private Timestamp transactionDate;
	private String requestId;
	private Timestamp settlementDate;
	private Double settlementAmount;
	private Double utrNumber;
	private String customerName;
	private String customerEmail;
	private String customerPhone;
	private String productInfo;
	private String paymentSource;
	private String paymentParts;
	private String payeeInfo;
	private String status;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public Double getSettlementAmount() {
		return settlementAmount;
	}
	public void setSettlementAmount(Double settlementAmount) {
		this.settlementAmount = settlementAmount;
	}
	public Timestamp getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Timestamp settlementDate) {
		this.settlementDate = settlementDate;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public String getPaymentSource() {
		return paymentSource;
	}
	public void setPaymentSource(String paymentSource) {
		this.paymentSource = paymentSource;
	}
	public String getPaymentParts() {
		return paymentParts;
	}
	public void setPaymentParts(String paymentParts) {
		this.paymentParts = paymentParts;
	}
	public String getPayeeInfo() {
		return payeeInfo;
	}
	public void setPayeeInfo(String payeeInfo) {
		this.payeeInfo = payeeInfo;
	}
	public Double getUtrNumber() {
		return utrNumber;
	}
	public void setUtrNumber(Double utrNumber) {
		this.utrNumber = utrNumber;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	public String getPgRefNo() {
		return pgRefNo;
	}
	public void setPgRefNo(String pgRefNo) {
		this.pgRefNo = pgRefNo;
	}
	public StTxnSettlementPayUMoney()
	{
		
	}
	
	public StTxnSettlementPayUMoney(String pgRefNo, Double transactionAmount,
			Timestamp transactionDate, Timestamp succeededOnDate,
			String requestId, String customerName,
			String customerEmail, String customerPhone, String paymentStatus,
			Double settlementAmount, Timestamp settlementDate,
			Double payUMoneyTdrCharges, Double serviceTax,
			Double convenienceFeeCharges, String paymentMode,
			String productInfo, String paymentSource, String paymentParts,
			String payeeInfo, Double utrNumber, String udf1, String udf2,
			String udf3, String udf4, String udf5, String errorMessage, String status) {
		super();
		this.pgRefNo = pgRefNo;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.requestId = requestId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.settlementAmount = settlementAmount;
		this.settlementDate = settlementDate;
		this.productInfo = productInfo;
		this.paymentSource = paymentSource;
		this.paymentParts = paymentParts;
		this.payeeInfo = payeeInfo;
		this.utrNumber = utrNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
