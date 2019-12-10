package com.stpl.pms.javabeans;

import java.sql.Timestamp;

public class CashPayDepositRequestBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Long requestId;
	private Long playerId;
	private Long podmId;
	private String providerName;
	private Timestamp requestTime;
	private Double amount;
	private String status;
	private String payTypeCode;

	public CashPayDepositRequestBean() {
	}

	public CashPayDepositRequestBean(Long requestId, Long playerId,
			Long podmId, String providerName, Timestamp requestTime,
			Double amount, String status, String payTypeCode) {
		super();
		this.requestId = requestId;
		this.playerId = playerId;
		this.podmId = podmId;
		this.providerName = providerName;
		this.requestTime = requestTime;
		this.amount = amount;
		this.status = status;
		this.payTypeCode = payTypeCode;
	}

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

	public Long getPodmId() {
		return podmId;
	}

	public void setPodmId(Long podmId) {
		this.podmId = podmId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Timestamp getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CashPayDepositRequestBean [amount=" + amount + ", playerId="
				+ playerId + ", podmId=" + podmId + ", providerName="
				+ providerName + ", requestId=" + requestId + ", requestTime="
				+ requestTime + ", status=" + status + "]";
	}

	public void setPayTypeCode(String payTypeCode) {
		this.payTypeCode = payTypeCode;
	}

	public String getPayTypeCode() {
		return payTypeCode;
	}

}
