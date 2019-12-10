package com.stpl.pms.javabeans;

import java.io.Serializable;

public class CurrencyBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int currencyId;
	private String currCode;
	private String currName;
	private String checked;

	public CurrencyBean() {
	}

	public CurrencyBean(int currencyId, String currCode, String currName) {
		this.currencyId = currencyId;
		this.currCode = currCode;
		this.currName = currName;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}

	public String getCurrCode() {
		return currCode;
	}

	public void setCurrName(String currName) {
		this.currName = currName;
	}

	public String getCurrName() {
		return currName;
	}

}
