package com.stpl.pms.javabeans;

import java.util.List;

public class TxnPaymentBean {
	private int payId;
	private String account;
	private String currBalance;
	private List<String> particulars;
	private List<String> particularAmount;

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCurrBalance() {
		return currBalance;
	}

	public void setCurrBalance(String currBalance) {
		this.currBalance = currBalance;
	}

	public List<String> getParticulars() {
		return particulars;
	}

	public void setParticulars(List<String> particulars) {
		this.particulars = particulars;
	}

	public List<String> getParticularAmount() {
		return particularAmount;
	}

	public void setParticularAmount(List<String> particularAmount) {
		this.particularAmount = particularAmount;
	}

}
