package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;
import java.sql.Timestamp;

public class TxnSettlementReportBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long requestId;
	private Long playerId;
	private Short domainId;
	private Integer fromCurrencyId;
	private Double fromAmount;
	private String reqStatus;
	private Timestamp requestTime;
	private String settlementStatus;
	private String userName;
//	private String providerNameCode;
	private String merchantRequestId;
	private Double transactionAmount;
	private Timestamp transactionDate;
	private String pgRefNo;
	private String pgStatus;
	
	
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public Short getDomainId() {
		return domainId;
	}
	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}
	public Integer getFromCurrencyId() {
		return fromCurrencyId;
	}
	public void setFromCurrencyId(Integer fromCurrencyId) {
		this.fromCurrencyId = fromCurrencyId;
	}
	public Double getFromAmount() {
		return fromAmount;
	}
	public void setFromAmount(Double fromAmount) {
		this.fromAmount = fromAmount;
	}
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	public Timestamp getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}
	public String getSettlementStatus() {
		return settlementStatus;
	}
	public void setSettlementStatus(String settlementStatus) {
		this.settlementStatus = settlementStatus;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
//	public String getProviderNameCode() {
//		return providerNameCode;
//	}
//	public void setProviderNameCode(String providerNameCode) {
//		this.providerNameCode = providerNameCode;
//	}
	public String getMerchantRequestId() {
		return merchantRequestId;
	}
	public void setMerchantRequestId(String merchantRequestId) {
		this.merchantRequestId = merchantRequestId;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getPgRefNo() {
		return pgRefNo;
	}
	public void setPgRefNo(String pgRefNo) {
		this.pgRefNo = pgRefNo;
	}
	@Override
	public String toString() {
		return "TxnSettlementReportBean [requestId=" + requestId + ",domainId=" + domainId
				+ ", fromAmount=" + fromAmount + ", fromCurrencyId="
				+ fromCurrencyId + ", merchantRequestId=" + merchantRequestId
				+ ", pgRefNo=" + pgRefNo + ", playerId=" + playerId
				+ ", pgStatus=" + pgStatus + ", reqStatus="
				+ reqStatus + ", requestId=" + requestId + ", requestTime="
				+ requestTime + ", settlementStatus=" + settlementStatus
				+ ", transactionAmount=" + transactionAmount
				+ ", transactionDate=" + transactionDate + ", userName="
				+ userName + "]";
	}
	public void setPgStatus(String pgStatus) {
		this.pgStatus = pgStatus;
	}
	public String getPgStatus() {
		return pgStatus;
	}

	
}
