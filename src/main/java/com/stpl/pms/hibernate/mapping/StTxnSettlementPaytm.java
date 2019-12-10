package com.stpl.pms.hibernate.mapping;


public class StTxnSettlementPaytm implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Long id;
		private String txnID;
	    private String  transactionDate;
	    private String mid;
	    private String txnChannel;
	    private Double transactionAmount;
	    private String currType;
	    private String requestId;
	    private String respCode;
	    private String paymentMode;
	    private String custID;
	    private String bankTxnId;
	    private String card;
	    private String status;
	    private String issuingBank;
	    private String bank;
	    private Double settledAmt;
	    private String statusType;
	    private Double commission;
	    private Double serTax;
	   private String settledDate;
	   private String website;
	   private String baseAmount;
	   private String posId;
	   private String merchantRef;
	   private String txnUpdatedDate;
	   private String binNo;
	   private String childTxnFlag;
	   private String parentTxnID;
	   private String pgRefNo;   
       
	   private String merchantName;    
	   private String cardIssuer;
	   private String authCode;
	   private String rrn;
	   private String utr;
	   private String promoCode;
	   private String promoResponse;
	   private String extSrlNo;
   
	
	
	

	public StTxnSettlementPaytm(Long id, String txnID, String transactionDate, String mid, String txnChannel,
			Double transactionAmount, String currType, String requestId, String respCode, String paymentMode,
			String custID, String bankTxnId, String card, String status, String issuingBank, String bank,
			Double settledAmt, String statusType, Double commission, Double serTax, String settledDate, String website,
			String baseAmount, String posId, String merchantRef, String txnUpdatedDate, String binNo,
			String childTxnFlag, String parentTxnID, String pgRefNo, String merchantName, String cardIssuer,
			String authCode, String rrn, String utr, String promoCode, String promoResponse, String extSrlNo) {
		super();
		this.id = id;
		this.txnID = txnID;
		this.transactionDate = transactionDate;
		this.mid = mid;
		this.txnChannel = txnChannel;
		this.transactionAmount = transactionAmount;
		this.currType = currType;
		this.requestId = requestId;
		this.respCode = respCode;
		this.paymentMode = paymentMode;
		this.custID = custID;
		this.bankTxnId = bankTxnId;
		this.card = card;
		this.status = status;
		this.issuingBank = issuingBank;
		this.bank = bank;
		this.settledAmt = settledAmt;
		this.statusType = statusType;
		this.commission = commission;
		this.serTax = serTax;
		this.settledDate = settledDate;
		this.website = website;
		this.baseAmount = baseAmount;
		this.posId = posId;
		this.merchantRef = merchantRef;
		this.txnUpdatedDate = txnUpdatedDate;
		this.binNo = binNo;
		this.childTxnFlag = childTxnFlag;
		this.parentTxnID = parentTxnID;
		this.pgRefNo = pgRefNo;
		this.merchantName = merchantName;
		this.cardIssuer = cardIssuer;
		this.authCode = authCode;
		this.rrn = rrn;
		this.utr = utr;
		this.promoCode = promoCode;
		this.promoResponse = promoResponse;
		this.extSrlNo = extSrlNo;
	}

	public String getPgRefNo() {
		return pgRefNo;
	}

	public void setPgRefNo(String pgRefNo) {
		this.pgRefNo = pgRefNo;
	}

	public StTxnSettlementPaytm() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTxnID() {
		return txnID;
	}

	public void setTxnID(String txnID) {
		this.txnID = txnID;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getTxnChannel() {
		return txnChannel;
	}

	public void setTxnChannel(String txnChannel) {
		this.txnChannel = txnChannel;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getCurrType() {
		return currType;
	}

	public void setCurrType(String currType) {
		this.currType = currType;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getBankTxnId() {
		return bankTxnId;
	}

	public void setBankTxnId(String bankTxnId) {
		this.bankTxnId = bankTxnId;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIssuingBank() {
		return issuingBank;
	}

	public void setIssuingBank(String issuingBank) {
		this.issuingBank = issuingBank;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Double getSettledAmt() {
		return settledAmt;
	}

	public void setSettledAmt(Double settlementAmt) {
		this.settledAmt = settlementAmt;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public Double getSerTax() {
		return serTax;
	}

	public void setSerTax(Double serTax) {
		this.serTax = serTax;
	}

	public String getSettledDate() {
		return settledDate;
	}

	public void setSettledDate(String settledDate) {
		this.settledDate = settledDate;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(String baseAmount) {
		this.baseAmount = baseAmount;
	}

	public String getPosId() {
		return posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}

	public String getMerchantRef() {
		return merchantRef;
	}

	public void setMerchantRef(String merchantRef) {
		this.merchantRef = merchantRef;
	}

	public String getBinNo() {
		return binNo;
	}

	public void setBinNo(String binNo) {
		this.binNo = binNo;
	}

	public String getChildTxnFlag() {
		return childTxnFlag;
	}

	public void setChildTxnFlag(String childTxnFlag) {
		this.childTxnFlag = childTxnFlag;
	}

	public String getParentTxnID() {
		return parentTxnID;
	}

	public void setParentTxnID(String parentTxnID) {
		this.parentTxnID = parentTxnID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTxnUpdatedDate() {
		return txnUpdatedDate;
	}

	public void setTxnUpdatedDate(String txnUpdatedDate) {
		this.txnUpdatedDate = txnUpdatedDate;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getCardIssuer() {
		return cardIssuer;
	}

	public void setCardIssuer(String cardIssuer) {
		this.cardIssuer = cardIssuer;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getUtr() {
		return utr;
	}

	public void setUtr(String utr) {
		this.utr = utr;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getPromoResponse() {
		return promoResponse;
	}

	public void setPromoResponse(String promoResponse) {
		this.promoResponse = promoResponse;
	}

	public String getExtSrlNo() {
		return extSrlNo;
	}

	public void setExtSrlNo(String extSrlNo) {
		this.extSrlNo = extSrlNo;
	}	    
	    
}