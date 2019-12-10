package com.stpl.pms.javabeans;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class ThirdPartyWagerBean implements java.io.Serializable  {
	private static final long serialVersionUID = 1L;
	private Long transactionId;
	private Timestamp transactionDate;
	private Double amount;
	private String vendorName;
	private String walletProvider;
	private String particulars;
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public void setTransaction_id(BigInteger transactionId) {
		this.transactionId = transactionId.longValue();
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public void setTransaction_date(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount.doubleValue();
	}
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public void setVendor_name(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getWalletProvider() {
		return walletProvider;
	}
	public void setWalletProvider(String walletProvider) {
		this.walletProvider = walletProvider;
	}
	public void setWallet_provider(String walletProvider) {
		this.walletProvider = walletProvider;
	}
	public String getParticulars() {
		return particulars;
	}
	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}
}
