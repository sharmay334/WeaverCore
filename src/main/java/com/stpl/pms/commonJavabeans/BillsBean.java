package com.stpl.pms.commonJavabeans;

public class BillsBean {

	private String billVoucherNo;
	private String ledgerId;
	private Integer billId;
	private String ledgerName;
	private String billAmount;
	private String billDate;
	private String billUsed;
	private String billTaxAmount;
	private String typeOfRef;
	private String lastSchedularDate;
	private String securityAmt;
	private String smsAlert;
	private String mailAlert;
	private String taxSchedular;
	private String billDueLimit;
	private String billDueDate;
	private String subLedger; // in txn reporting this fields denotes sales ledger / purchase ledger tab in txn
	private String txnType;
	
	public String getBillVoucherNo() {
		return billVoucherNo;
	}

	public void setBillVoucherNo(String billVoucherNo) {
		this.billVoucherNo = billVoucherNo;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public String getLedgerName() {
		return ledgerName;
	}

	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}

	public String getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getBillUsed() {
		return billUsed;
	}

	public void setBillUsed(String billUsed) {
		this.billUsed = billUsed;
	}

	public String getBillTaxAmount() {
		return billTaxAmount;
	}

	public void setBillTaxAmount(String billTaxAmount) {
		this.billTaxAmount = billTaxAmount;
	}

	public String getTypeOfRef() {
		return typeOfRef;
	}

	public void setTypeOfRef(String typeOfRef) {
		this.typeOfRef = typeOfRef;
	}

	public String getLastSchedularDate() {
		return lastSchedularDate;
	}

	public void setLastSchedularDate(String lastSchedularDate) {
		this.lastSchedularDate = lastSchedularDate;
	}

	public String getSecurityAmt() {
		return securityAmt;
	}

	public void setSecurityAmt(String securityAmt) {
		this.securityAmt = securityAmt;
	}

	public String getSmsAlert() {
		return smsAlert;
	}

	public void setSmsAlert(String smsAlert) {
		this.smsAlert = smsAlert;
	}

	public String getMailAlert() {
		return mailAlert;
	}

	public void setMailAlert(String mailAlert) {
		this.mailAlert = mailAlert;
	}

	public String getTaxSchedular() {
		return taxSchedular;
	}

	public void setTaxSchedular(String taxSchedular) {
		this.taxSchedular = taxSchedular;
	}

	public String getLedgerId() {
		return ledgerId;
	}

	public void setLedgerId(String ledgerId) {
		this.ledgerId = ledgerId;
	}

	public String getBillDueLimit() {
		return billDueLimit;
	}

	public void setBillDueLimit(String billDueLimit) {
		this.billDueLimit = billDueLimit;
	}

	public String getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(String billDueDate) {
		this.billDueDate = billDueDate;
	}

	public String getSubLedger() {
		return subLedger;
	}

	public void setSubLedger(String subLedger) {
		this.subLedger = subLedger;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

}
