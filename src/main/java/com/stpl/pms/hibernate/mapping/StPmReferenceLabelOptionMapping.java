package com.stpl.pms.hibernate.mapping;

/**
 * StPmReferenceLabelOptionMapping entity. @author MyEclipse Persistence Tools
 */

public class StPmReferenceLabelOptionMapping implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short referenceId;
	private String labelName;
	private String labelOptionValue;
	private String status;

	// Constructors

	/** default constructor */
	public StPmReferenceLabelOptionMapping() {
	}

	/** full constructor */
	public StPmReferenceLabelOptionMapping(Short referenceId, String labelName,
			String labelOptionValue, String status) {
		this.referenceId = referenceId;
		this.labelName = labelName;
		this.labelOptionValue = labelOptionValue;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(Short referenceId) {
		this.referenceId = referenceId;
	}

	public String getLabelName() {
		return this.labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getLabelOptionValue() {
		return this.labelOptionValue;
	}

	public void setLabelOptionValue(String labelOptionValue) {
		this.labelOptionValue = labelOptionValue;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}