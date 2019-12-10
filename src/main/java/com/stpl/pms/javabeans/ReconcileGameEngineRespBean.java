package com.stpl.pms.javabeans;


public class ReconcileGameEngineRespBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String refTxnNo;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRefTxnNo() {
		return refTxnNo;
	}
	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}
	

}
