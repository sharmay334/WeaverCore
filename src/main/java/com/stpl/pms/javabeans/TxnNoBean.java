package com.stpl.pms.javabeans;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class TxnNoBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> refTxnNo;

	public TxnNoBean() {
		// TODO Auto-generated constructor stub
	}

	public TxnNoBean(List<String> refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	
	public void setRefTxnNo(List<String> refTxnNo) {
		this.refTxnNo = refTxnNo;
	}
	@JsonIgnore
	public void setRefTxnNo(String refTxnNo) {
		if (this.refTxnNo== null) {
			this.refTxnNo = new ArrayList<String>();
		}
		this.refTxnNo.add(refTxnNo);
	}

	public List<String> getRefTxnNo() {
		return refTxnNo;
	}

	@Override
	public String toString() {
		return "TxnNoBean [refTxnNo=" + refTxnNo + "]";
	}

}
