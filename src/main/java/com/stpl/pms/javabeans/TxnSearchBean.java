package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class TxnSearchBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private short domainId;
	private short aliasId;
	private int vipLevel;
	private int currencyId;
	private int countryId;
	private Timestamp fromDate;
	private Timestamp toDate;
	private double fromAmount;
	private double toAmount;
	private String status;
	private int paymentTypeId;
	private String paymentTypeCode;
	private String device;

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public double getFromAmount() {
		return fromAmount;
	}

	public void setFromAmount(double fromAmount) {
		this.fromAmount = fromAmount;
	}

	public double getToAmount() {
		return toAmount;
	}

	public void setToAmount(double toAmount) {
		this.toAmount = toAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}

	public Timestamp getFromDate() {
		return fromDate;
	}

	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}

	public Timestamp getToDate() {
		return toDate;
	}

	public void setPaymentTypeCode(String paymentTypeCode) {
		this.paymentTypeCode = paymentTypeCode;
	}

	public String getPaymentTypeCode() {
		return paymentTypeCode;
	}

	@Override
	public String toString() {
		return "TxnSearchBean [countryId=" + countryId + ", currencyId="
				+ currencyId + ", domainId=" + domainId + ", fromAmount="
				+ fromAmount + ", fromDate=" + fromDate + ", paymentTypeCode="
				+ paymentTypeCode + ", paymentTypeId=" + paymentTypeId
				+ ", status=" + status + ", toAmount=" + toAmount + ", toDate="
				+ toDate + ", vipLevel=" + vipLevel + "]";
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDevice() {
		return device;
	}

	public short getAliasId() {
		return aliasId;
	}

	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}
}
