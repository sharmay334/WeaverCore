package com.stpl.pms.javabeans;

import java.io.Serializable;

public class WagerQueryRespBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String status;
	private Long refTxnNo;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getRefTxnNo() {
		return refTxnNo;
	}
	public void setRefTxnNo(Long refTxnNo) {
		this.refTxnNo = refTxnNo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{\"status\":\""+status+"\",\"refTxnNo\":"+refTxnNo+"}";
	}
}
