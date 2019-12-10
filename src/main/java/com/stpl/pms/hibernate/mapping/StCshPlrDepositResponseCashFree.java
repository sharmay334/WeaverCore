package com.stpl.pms.hibernate.mapping;

public class StCshPlrDepositResponseCashFree implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String orderId;
	private String referenceId;
	private Double txnAmount;
	private String status;
	private String respMsg;
	private String txnDate;
	private String paymentMode;
	private String signature;

	public StCshPlrDepositResponseCashFree( String orderId,
			String referenceId, Double txnAmount, String status,
			String respMsg, String txnDate, String paymentMode, String signature) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.referenceId = referenceId;
		this.txnAmount = txnAmount;
		this.status = status;
		this.respMsg = respMsg;
		this.txnDate = txnDate;
		this.paymentMode = paymentMode;
		this.signature = signature;
	}
  
	public StCshPlrDepositResponseCashFree() {
	
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public Double getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(Double txnAmount) {
		this.txnAmount = txnAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public String getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
