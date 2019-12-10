package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.Map;

public class PaymentOptionSubTypeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int subTypeId;
	private String subTypeCode;
	private Map<Integer,PaymentProviderBean> providerMap;
	private String status;

	public int getSubTypeId() {
		return subTypeId;
	}

	public void setSubTypeId(int subTypeId) {
		this.subTypeId = subTypeId;
	}

	public String getSubTypeCode() {
		return subTypeCode;
	}

	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setProviderMap(Map<Integer,PaymentProviderBean> providerMap) {
		this.providerMap = providerMap;
	}

	public Map<Integer,PaymentProviderBean> getProviderMap() {
		return providerMap;
	}

	@Override
	public String toString() {
		return "PaymentOptionSubTypeBean [providerMap=" + providerMap
				+ ", status=" + status + ", subTypeCode=" + subTypeCode
				+ ", subTypeId=" + subTypeId + "]";
	}
}
