package com.stpl.pms.javabeans;

import java.sql.Timestamp;

public class ReferenceInfoBean implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer referenceName;
	private String displayName;
	private Short referenceId;
	private Integer refTxtLabel1;
	private Integer refTxtLabel2;
	private Integer refTxtLabel3;
	private String refTxtLabel1Type;
	private String refTxtLabel2Type;
	private String refTxtLabel3Type;
	private ReferenceLabelInfoBean labelInfoBean1 = new ReferenceLabelInfoBean();
	private ReferenceLabelInfoBean labelInfoBean2 = new ReferenceLabelInfoBean();
	private ReferenceLabelInfoBean labelInfoBean3 = new ReferenceLabelInfoBean();
	private String status;
	private Long createdBy;
	private Timestamp creationTime;
	
	public Short getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(Short referenceId) {
		this.referenceId = referenceId;
	}
	public String getRefTxtLabel1Type() {
		return refTxtLabel1Type;
	}
	public void setRefTxtLabel1Type(String refTxtLabel1Type) {
		this.refTxtLabel1Type = refTxtLabel1Type;
	}
	public String getRefTxtLabel2Type() {
		return refTxtLabel2Type;
	}
	public void setRefTxtLabel2Type(String refTxtLabel2Type) {
		this.refTxtLabel2Type = refTxtLabel2Type;
	}
	public String getRefTxtLabel3Type() {
		return refTxtLabel3Type;
	}
	public void setRefTxtLabel3Type(String refTxtLabel3Type) {
		this.refTxtLabel3Type = refTxtLabel3Type;
	}
	public Integer getReferenceName() {
		return referenceName;
	}
	public void setReferenceName(Integer referenceName) {
		this.referenceName = referenceName;
	}
	public Integer getRefTxtLabel1() {
		return refTxtLabel1;
	}
	public void setRefTxtLabel1(Integer refTxtLabel1) {
		this.refTxtLabel1 = refTxtLabel1;
	}
	public Integer getRefTxtLabel2() {
		return refTxtLabel2;
	}
	public void setRefTxtLabel2(Integer refTxtLabel2) {
		this.refTxtLabel2 = refTxtLabel2;
	}
	public Integer getRefTxtLabel3() {
		return refTxtLabel3;
	}
	public void setRefTxtLabel3(Integer refTxtLabel3) {
		this.refTxtLabel3 = refTxtLabel3;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ReferenceLabelInfoBean getLabelInfoBean1() {
		return labelInfoBean1;
	}
	public void setLabelInfoBean1(ReferenceLabelInfoBean labelInfoBean1) {
		this.labelInfoBean1 = labelInfoBean1;
	}
	public ReferenceLabelInfoBean getLabelInfoBean2() {
		return labelInfoBean2;
	}
	public void setLabelInfoBean2(ReferenceLabelInfoBean labelInfoBean2) {
		this.labelInfoBean2 = labelInfoBean2;
	}
	public ReferenceLabelInfoBean getLabelInfoBean3() {
		return labelInfoBean3;
	}
	public void setLabelInfoBean3(ReferenceLabelInfoBean labelInfoBean3) {
		this.labelInfoBean3 = labelInfoBean3;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDisplayName() {
		return displayName;
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
    

}
