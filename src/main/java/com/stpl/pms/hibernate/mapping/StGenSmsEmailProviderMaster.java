package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;

public class StGenSmsEmailProviderMaster implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private int domainId;
	private int aliasId;
	private String providerName;
	private String providerKey;
	private String providerPass;
	private int priorityOrder;
	private double meanProcessingTime;
	private String status;
	private String providerType;

	public StGenSmsEmailProviderMaster() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDomainId() {
		return domainId;
	}

	public void setDomainId(int domainId) {
		this.domainId = domainId;
	}

	public int getAliasId() {
		return aliasId;
	}

	public void setAliasId(int aliasId) {
		this.aliasId = aliasId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public int getPriorityOrder() {
		return priorityOrder;
	}

	public void setPriorityOrder(int priorityOrder) {
		this.priorityOrder = priorityOrder;
	}

	public double getMeanProcessingTime() {
		return meanProcessingTime;
	}

	public void setMeanProcessingTime(double meanProcessingTime) {
		this.meanProcessingTime = meanProcessingTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProviderType() {
		return providerType;
	}

	public void setProviderType(String providerType) {
		this.providerType = providerType;
	}

	public String getProviderPass() {
		return providerPass;
	}

	public void setProviderPass(String providerPass) {
		this.providerPass = providerPass;
	}

	public String getProviderKey() {
		return providerKey;
	}

	public void setProviderKey(String providerKey) {
		this.providerKey = providerKey;
	}

}
