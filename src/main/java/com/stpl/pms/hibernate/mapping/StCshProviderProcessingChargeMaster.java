package com.stpl.pms.hibernate.mapping;

/**
 * StCshProviderProcessingChargeMaster entity. @author MyEclipse Persistence
 * Tools
 */

public class StCshProviderProcessingChargeMaster implements
		java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long processingChargeId;
	private String charge1Type;
	private Double charge1Value;
	private String charge2Type;
	private Double charge2Value;
	private String relation;
	private Double maxValue;

	// Constructors

	/** default constructor */
	public StCshProviderProcessingChargeMaster() {
	}

	/** minimal constructor */
	public StCshProviderProcessingChargeMaster(String relation) {
		this.relation = relation;
	}

	/** full constructor */
	public StCshProviderProcessingChargeMaster(String charge1Type,
			Double charge1Value, String charge2Type, Double charge2Value,
			String relation, Double maxValue) {
		this.charge1Type = charge1Type;
		this.charge1Value = charge1Value;
		this.charge2Type = charge2Type;
		this.charge2Value = charge2Value;
		this.relation = relation;
		this.maxValue = maxValue;
	}

	// Property accessors

	public Long getProcessingChargeId() {
		return this.processingChargeId;
	}

	public void setProcessingChargeId(Long processingChargeId) {
		this.processingChargeId = processingChargeId;
	}

	public String getCharge1Type() {
		return this.charge1Type;
	}

	public void setCharge1Type(String charge1Type) {
		this.charge1Type = charge1Type;
	}

	public Double getCharge1Value() {
		return this.charge1Value;
	}

	public void setCharge1Value(Double charge1Value) {
		this.charge1Value = charge1Value;
	}

	public String getCharge2Type() {
		return this.charge2Type;
	}

	public void setCharge2Type(String charge2Type) {
		this.charge2Type = charge2Type;
	}

	public Double getCharge2Value() {
		return this.charge2Value;
	}

	public void setCharge2Value(Double charge2Value) {
		this.charge2Value = charge2Value;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Double getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	@Override
	public String toString() {
		return processingChargeId+"_"+charge1Type+"_"+charge2Value+"_"+charge2Type+"_"+charge2Value;
	}
}