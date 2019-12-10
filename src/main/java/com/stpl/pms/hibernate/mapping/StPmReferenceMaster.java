package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;
import java.util.Set;

/**
 * StPmReferenceMaster entity. @author MyEclipse Persistence Tools
 */

public class StPmReferenceMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Short referenceId;
	private Integer referenceName;
	private String referenceDispName;
	private Short domainId;
	private Integer refTxtLabel1;
	private Integer refTxtLabel2;
	private Integer refTxtLabel3;
	private String refTxtLabel1Type;
	private String refTxtLabel2Type;
	private String refTxtLabel3Type;
	private String status;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;
	private Set<StPmReferenceLabelOptionMapping> labelOptions;

	// Constructors

	/** default constructor */
	public StPmReferenceMaster() {
	}

	// Property accessors

	public Short getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(Short referenceId) {
		this.referenceId = referenceId;
	}

	public Integer getReferenceName() {
		return this.referenceName;
	}

	public void setReferenceName(Integer referenceName) {
		this.referenceName = referenceName;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Integer getRefTxtLabel1() {
		return this.refTxtLabel1;
	}

	public void setRefTxtLabel1(Integer refTxtLabel1) {
		this.refTxtLabel1 = refTxtLabel1;
	}

	public Integer getRefTxtLabel2() {
		return this.refTxtLabel2;
	}

	public void setRefTxtLabel2(Integer refTxtLabel2) {
		this.refTxtLabel2 = refTxtLabel2;
	}

	public Integer getRefTxtLabel3() {
		return this.refTxtLabel3;
	}

	public void setRefTxtLabel3(Integer refTxtLabel3) {
		this.refTxtLabel3 = refTxtLabel3;
	}

	public String getRefTxtLabel1Type() {
		return this.refTxtLabel1Type;
	}

	public void setRefTxtLabel1Type(String refTxtLabel1Type) {
		this.refTxtLabel1Type = refTxtLabel1Type;
	}

	public String getRefTxtLabel2Type() {
		return this.refTxtLabel2Type;
	}

	public void setRefTxtLabel2Type(String refTxtLabel2Type) {
		this.refTxtLabel2Type = refTxtLabel2Type;
	}

	public String getRefTxtLabel3Type() {
		return this.refTxtLabel3Type;
	}

	public void setRefTxtLabel3Type(String refTxtLabel3Type) {
		this.refTxtLabel3Type = refTxtLabel3Type;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setReferenceDispName(String referenceDispName) {
		this.referenceDispName = referenceDispName;
	}

	public String getReferenceDispName() {
		return referenceDispName;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdationTime() {
		return lastUpdationTime;
	}

	public void setLastUpdationTime(Timestamp lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}

	public Set<StPmReferenceLabelOptionMapping> getLabelOptions() {
		return labelOptions;
	}

	public void setLabelOptions(
			Set<StPmReferenceLabelOptionMapping> labelOptions) {
		this.labelOptions = labelOptions;
	}

}