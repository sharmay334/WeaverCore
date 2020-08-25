package com.stpl.pms.commonJavabeans;

public class ReceiptBean {
	private int rowId;
	private String Particulars;
	private String amount;
	private String txnType;
	private String bank_name;

	public String getParticulars() {
		return Particulars;
	}

	public void setParticulars(String particulars) {
		Particulars = particulars;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

}
