package com.stpl.pms.javabeans;

public class LedgerBankAccount {
	private int ledgerId;
	private String activateInterestCalculation;
	private String accHolderName;
	private String accNumber;
	private String ifsc;
	private String bankName;
	private String branch;
	private String gstNumber;
	private String chequePrinting;
	private String chequeBook;

	public String getActivateInterestCalculation() {
		return activateInterestCalculation;
	}

	public void setActivateInterestCalculation(String activateInterestCalculation) {
		this.activateInterestCalculation = activateInterestCalculation;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getChequePrinting() {
		return chequePrinting;
	}

	public void setChequePrinting(String chequePrinting) {
		this.chequePrinting = chequePrinting;
	}

	public String getChequeBook() {
		return chequeBook;
	}

	public void setChequeBook(String chequeBook) {
		this.chequeBook = chequeBook;
	}

	public int getLedgerId() {
		return ledgerId;
	}

	public void setLedgerId(int ledgerId) {
		this.ledgerId = ledgerId;
	}

}
