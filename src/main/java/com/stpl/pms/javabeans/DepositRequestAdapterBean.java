package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.stpl.pms.hibernate.mapping.StCshPlrDepositRequest;
/*
 * The paramerters and Constructors are adjustable i.e, more parameters can be added according to the requiremnet.
 */
@JsonSerialize(include = Inclusion.NON_NULL)
public class DepositRequestAdapterBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long requestId;
	private Timestamp requestTime;
	private Double amount;
	private String status;
	private String depostTypeCode;
	
	public DepositRequestAdapterBean(long requestId, Timestamp requestDate,
			Double amount, String status) {
		this.requestId = requestId;
		this.setRequestTime(requestDate);
		this.setAmount(amount);
		this.status = status;
	}
	
	public DepositRequestAdapterBean(StCshPlrDepositRequest depositReq) {
		this.requestId = depositReq.getRequestId();
		this.setRequestTime(depositReq.getRequestTime());
		this.setAmount(depositReq.getFromAmount());
		this.status = depositReq.getSettlementStatus();
		this.depostTypeCode=depositReq.getPayOptDomMapping().getPaymentTypeMas().getPaymentTypeCode();
	}
	
	public long getRequestId() {
		return requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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

	public String getDepostTypeCode() {
		return depostTypeCode;
	}

	public void setDepostTypeCode(String depostTypeCode) {
		this.depostTypeCode = depostTypeCode;
	}
}
