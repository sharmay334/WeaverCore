package com.stpl.pms.javabeans;

public class PlayerLastDepositInfoBean {
	
	
	private int paymentTypeId;
	private int paymentSubTypeId;
	private double amount;
	
	
	public PlayerLastDepositInfoBean() {
		
	}
	

	public PlayerLastDepositInfoBean(int paymentTypeId, int paymentSubTypeId, double amount) {
		super();
		this.paymentTypeId = paymentTypeId;
		this.paymentSubTypeId = paymentSubTypeId;
		this.amount = amount;
	}

	public int getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public int getPaymentSubTypeId() {
		return paymentSubTypeId;
	}

	public void setPaymentSubTypeId(int paymentSubTypeId) {
		this.paymentSubTypeId = paymentSubTypeId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
}
