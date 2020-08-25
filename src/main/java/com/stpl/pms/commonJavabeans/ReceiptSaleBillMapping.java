package com.stpl.pms.commonJavabeans;

public class ReceiptSaleBillMapping {

	private String sNo;
	private String saleVoucher;
	private String receiptVoucher;
	private String refType;
	private String amount;
	private String txnType;
	private String billTable;
	
	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public String getSaleVoucher() {
		return saleVoucher;
	}

	public void setSaleVoucher(String saleVoucher) {
		this.saleVoucher = saleVoucher;
	}

	public String getReceiptVoucher() {
		return receiptVoucher;
	}

	public void setReceiptVoucher(String receiptVoucher) {
		this.receiptVoucher = receiptVoucher;
	}

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
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

	public String getBillTable() {
		return billTable;
	}

	public void setBillTable(String billTable) {
		this.billTable = billTable;
	}

}
