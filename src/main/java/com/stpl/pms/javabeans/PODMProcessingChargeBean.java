package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PODMProcessingChargeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long processingChargeId;
	private String charge1Type;
	private Double charge1Value;
	private String charge2Type;
	private Double charge2Value;
	private String relation;
	private Double maxValue;
	private Map<Integer, PaymentOptionTypeBean> payTypeMap;
	private List<Long> podmId;
	
	public Long getProcessingChargeId() {
		return processingChargeId;
	}

	public void setProcessingChargeId(Long processingChargeId) {
		this.processingChargeId = processingChargeId;
	}

	public String getCharge1Type() {
		return charge1Type;
	}

	public void setCharge1Type(String charge1Type) {
		this.charge1Type = charge1Type;
	}

	public Double getCharge1Value() {
		return charge1Value;
	}

	public void setCharge1Value(Double charge1Value) {
		this.charge1Value = charge1Value;
	}

	public String getCharge2Type() {
		return charge2Type;
	}

	public void setCharge2Type(String charge2Type) {
		this.charge2Type = charge2Type;
	}

	public Double getCharge2Value() {
		return charge2Value;
	}

	public void setCharge2Value(Double charge2Value) {
		this.charge2Value = charge2Value;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public Map<Integer, PaymentOptionTypeBean> getPayTypeMap() {
		return payTypeMap;
	}

	public void setPayTypeMap(Map<Integer, PaymentOptionTypeBean> payTypeMap) {
		this.payTypeMap = payTypeMap;
	}

	public List<Long> getPodmId() {
		return podmId;
	}

	public void setPodmId(List<Long> podmId) {
		this.podmId = podmId;
	}

	@Override
	public String toString() {
		return "PODMProcessingChargeBean [charge1Type=" + charge1Type
				+ ", charge1Value=" + charge1Value + ", charge2Type="
				+ charge2Type + ", charge2Value=" + charge2Value
				+ ", maxValue=" + maxValue + ", payTypeMap=" + payTypeMap
				+ ", podmId=" + podmId + ", processingChargeId="
				+ processingChargeId + ", relation=" + relation + "]";
	}
}
