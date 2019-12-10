package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.Map;

public class PaymentOptionTypeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int paymentTypeId;
	private String payTypeCode;
	private String payTypeDispCode;
	private Map<Integer, PaymentOptionSubTypeBean> subTypeMap;
	private String status;

	public int getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getPayTypeCode() {
		return payTypeCode;
	}

	public void setPayTypeCode(String payTypeCode) {
		this.payTypeCode = payTypeCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSubTypeMap(Map<Integer, PaymentOptionSubTypeBean> subTypeMap) {
		this.subTypeMap = subTypeMap;
	}

	public Map<Integer, PaymentOptionSubTypeBean> getSubTypeMap() {
		return subTypeMap;
	}

	public void setPayTypeDispCode(String payTypeDispCode) {
		this.payTypeDispCode = payTypeDispCode;
	}

	public String getPayTypeDispCode() {
		return payTypeDispCode;
	}

	@Override
	public String toString() {
		return "PaymentOptionTypeBean [payTypeCode=" + payTypeCode
				+ ", payTypeDispCode=" + payTypeDispCode + ", paymentTypeId="
				+ paymentTypeId + ", status=" + status + ", subTypeMap="
				+ subTypeMap + "]";
	}

}
