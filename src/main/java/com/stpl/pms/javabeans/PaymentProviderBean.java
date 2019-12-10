package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PaymentProviderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int providerId;
	private long pomId;
	private String providerDiscCode;
	private double succesRate;
	private double meanProccessTime;
	private short priorityOrder;
	private String typicalProcessTime;
	private String status;
	private long podmId;

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getProviderDiscCode() {
		return providerDiscCode;
	}

	public void setProviderDiscCode(String providerDiscCode) {
		this.providerDiscCode = providerDiscCode;
	}

	public double getSuccesRate() {
		return succesRate;
	}

	public void setSuccesRate(double succesRate) {
		this.succesRate = succesRate;
	}

	public double getMeanProccessTime() {
		return meanProccessTime;
	}

	public void setMeanProccessTime(double meanProccessTime) {
		this.meanProccessTime = meanProccessTime;
	}

	public short getPriorityOrder() {
		return priorityOrder;
	}

	public void setPriorityOrder(short priorityOrder) {
		this.priorityOrder = priorityOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PaymentProviderBean [meanProccessTime=" + meanProccessTime
				+ ", podmId=" + podmId + ", pomId=" + pomId
				+ ", priorityOrder=" + priorityOrder + ", providerDiscCode="
				+ providerDiscCode + ", providerId=" + providerId + ", status="
				+ status + ", succesRate=" + succesRate
				+ ", typicalProcessTime=" + typicalProcessTime + "]";
	}

	public void setTypicalProcessTime(String typicalProcessTime) {
		this.typicalProcessTime = typicalProcessTime;
	}

	public String getTypicalProcessTime() {
		return typicalProcessTime;
	}

	public void setPomId(long pomId) {
		this.pomId = pomId;
	}

	public long getPomId() {
		return pomId;
	}

	public void setPodmId(long podmId) {
		this.podmId = podmId;
	}

	public long getPodmId() {
		return podmId;
	}
}
