package com.stpl.pms.hibernate.mapping;


public class StCshPlrDepositResponsePayTm  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String subsId;
	private String mId;
	private String txnId;
	private String orderId;
	private String bankTxnId;
	private Double txnAmount;
	private String currency;
	private String status;
	private String respCode;
	private String respMsg;
	private String txnDate;
	private String gatewayName;
	private String bankName;
	private String paymentMode;
	private String checksumHash;
	private String promoCampId;
	private String promoStatus;
	private String promoRespCode;
	
	
	
	// Constructors

		/** default constructor */
		public StCshPlrDepositResponsePayTm() {
		}
		/** full constructor */
		public StCshPlrDepositResponsePayTm(String subsId, String mId,
				String txnId,  String orderId, 
				String bankTxnId,Double txnAmount, String currency, String status,String respCode,
				String respMsg,String txnDate,String gatewayName,String bankName,String paymentMode,String checksumHash,String promoCampId,String promoStatus ,String promoRespCode) {
			this.subsId = subsId;
			this.mId = mId;
			this.txnId = txnId;
			this.orderId = orderId;
			this.bankTxnId = bankTxnId;
			this.txnAmount = txnAmount;
			this.currency = currency;
			this.status = status;
			this.respCode = respCode;
			this.respMsg = respMsg;
			this.txnDate = txnDate;
			this.gatewayName = gatewayName;
			this.bankName = bankName;
			this.paymentMode = paymentMode;
			this.checksumHash = checksumHash;
			this.promoCampId=promoCampId;
			this.promoStatus=promoStatus;
			this.promoRespCode=promoRespCode;
			
		}

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubsId() {
		return subsId;
	}
	public void setSubsId(String subsId) {
		this.subsId = subsId;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getBankTxnId() {
		return bankTxnId;
	}
	public void setBankTxnId(String bankTxnId) {
		this.bankTxnId = bankTxnId;
	}
	public Double getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(Double txnAmount) {
		this.txnAmount = txnAmount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
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
	public String getGatewayName() {
		return gatewayName;
	}
	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	public String getChecksumHash() {
		return checksumHash;
	}
	public void setChecksumHash(String checksumHash) {
		this.checksumHash = checksumHash;
	}
	
	public String getPromoCampId() {
		return promoCampId;
	}
	public void setPromoCampId(String promoCampId) {
		this.promoCampId = promoCampId;
	}
	public String getPromoStatus() {
		return promoStatus;
	}
	public void setPromoStatus(String promoStatus) {
		this.promoStatus = promoStatus;
	}
	public String getPromoRespCode() {
		return promoRespCode;
	}
	public void setPromoRespCode(String promoRespCode) {
		this.promoRespCode = promoRespCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
