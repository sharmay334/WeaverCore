package com.stpl.pms.javabeans;

public class ReferenceListBean implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String referenceName;
	private String refTxtLabel1;
	private String refTxtLabel2;
	private String refTxtLabel3;
	private String refTxtLabel1Type;
	private String refTxtLabel2Type;
	private String refTxtLabel3Type;
	private ReferenceLabelInfoBean labelInfoBean1 = new ReferenceLabelInfoBean();
	private ReferenceLabelInfoBean labelInfoBean2 = new ReferenceLabelInfoBean();
	private ReferenceLabelInfoBean labelInfoBean3 = new ReferenceLabelInfoBean();
	private String status;
	
	
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
	public String getReferenceName() {
		return referenceName;
	}
	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	public String getRefTxtLabel1() {
		return refTxtLabel1;
	}
	public void setRefTxtLabel1(String refTxtLabel1) {
		this.refTxtLabel1 = refTxtLabel1;
	}
	public String getRefTxtLabel2() {
		return refTxtLabel2;
	}
	public void setRefTxtLabel2(String refTxtLabel2) {
		this.refTxtLabel2 = refTxtLabel2;
	}
	public String getRefTxtLabel3() {
		return refTxtLabel3;
	}
	public void setRefTxtLabel3(String refTxtLabel3) {
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
    

}
