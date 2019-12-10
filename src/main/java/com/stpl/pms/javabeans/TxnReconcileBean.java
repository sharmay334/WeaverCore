package com.stpl.pms.javabeans;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class TxnReconcileBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String txnId;
	private String refTxnId;
	private String status;

	public TxnReconcileBean(String txnId, String refTxnId, String status) {
		this.txnId = txnId;
		this.refTxnId = refTxnId;
		this.status = status;
	}

	public String getTxnId() {
		return txnId;
	}

	public String getRefTxnId() {
		return refTxnId;
	}

	public String getStatus() {
		return status;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public void setRefTxnId(String refTxnId) {
		this.refTxnId = refTxnId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
