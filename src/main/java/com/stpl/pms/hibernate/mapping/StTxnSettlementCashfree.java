package com.stpl.pms.hibernate.mapping;

public class StTxnSettlementCashfree implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String requestId;
    private String cashFreeReferenceId;
    private String customerName;
    private String customerPhone;
    private String customerEmail;    
    private Double transactionAmount;
    private String transactionType;    
    private String paymentMode;
    private String transactionTime;
    private Double serviceCharge;
    private Double serviceTax;
    private Double netSettlementAmount;
    private String utrNo;
    private String pgRefNo;
    private String status;
    
    public StTxnSettlementCashfree(){
    	
    }
    
	public StTxnSettlementCashfree(String requestId, String cashFreeReferenceId, String customerName,
			String customerPhone, String customerEmail, Double transactionAmount, String transactionType,
			String paymentMode, String transactionTime, Double serviceCharge, Double serviceTax,
			Double netSettlementAmount, String utrNo, String pgRefNo, String status) {
		super();
		this.requestId = requestId;
		this.cashFreeReferenceId = cashFreeReferenceId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.paymentMode = paymentMode;
		this.transactionTime = transactionTime;
		this.serviceCharge = serviceCharge;
		this.serviceTax = serviceTax;
		this.netSettlementAmount = netSettlementAmount;
		this.utrNo = utrNo;
		this.pgRefNo = pgRefNo;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getCashFreeReferenceId() {
		return cashFreeReferenceId;
	}
	public void setCashFreeReferenceId(String cashFreeReferenceId) {
		this.cashFreeReferenceId = cashFreeReferenceId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	public Double getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(Double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public Double getServiceTax() {
		return serviceTax;
	}
	public void setServiceTax(Double serviceTax) {
		this.serviceTax = serviceTax;
	}
	public Double getNetSettlementAmount() {
		return netSettlementAmount;
	}
	public void setNetSettlementAmount(Double netSettlementAmount) {
		this.netSettlementAmount = netSettlementAmount;
	}
	public String getUtrNo() {
		return utrNo;
	}
	public void setUtrNo(String utrNo) {
		this.utrNo = utrNo;
	}
	public String getPgRefNo() {
		return pgRefNo;
	}
	public void setPgRefNo(String pgRefNo) {
		this.pgRefNo = pgRefNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}  
    
}
