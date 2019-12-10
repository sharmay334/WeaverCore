package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.HashMap;

public class CashCollectionAddressReqBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int paymentTypeId;
	private int currencyId;
	private HashMap<Integer, PaySubTypeCshCollnBean> cityPinMap;
	private HashMap<String, PlrCashCollnAddressBean> plrCollAddMap;
	
	public void setCityPinMap(HashMap<Integer, PaySubTypeCshCollnBean> cityPinMap) {
		this.cityPinMap = cityPinMap;
	}
	public HashMap<Integer, PaySubTypeCshCollnBean> getCityPinMap() {
		return cityPinMap;
	}
	public void setPlrCollAddMap(HashMap<String, PlrCashCollnAddressBean> plrCollAddMap) {
		this.plrCollAddMap = plrCollAddMap;
	}
	public HashMap<String, PlrCashCollnAddressBean> getPlrCollAddMap() {
		return plrCollAddMap;
	}
	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}
	public int getPaymentTypeId() {
		return paymentTypeId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	public int getCurrencyId() {
		return currencyId;
	}

	
}
