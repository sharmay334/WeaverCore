package com.stpl.pms.javabeans;

import java.io.Serializable;

public class CurrencyConversionDefBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String CurrencyName;
	private int currencyId;
	private double exchangeRate;
	private int exchangeChargeCurrId;
	private double exchangeCharge;
	private String status;

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeCharge(double exchangeCharge) {
		this.exchangeCharge = exchangeCharge;
	}

	public double getExchangeCharge() {
		return exchangeCharge;
	}

	public void setExchangeChargeCurrId(int exchangeChargeCurrId) {
		this.exchangeChargeCurrId = exchangeChargeCurrId;
	}

	public int getExchangeChargeCurrId() {
		return exchangeChargeCurrId;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCurrencyName(String currencyName) {
		CurrencyName = currencyName;
	}

	public String getCurrencyName() {
		return CurrencyName;
	}

}
