package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class CashierWithdrawalBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private LinkedHashMap<Integer, PaymentTypeBean> payTypeMap;
	private RedeemAccBean plrRedeemAccMap;

	public void setPayTypeMap(LinkedHashMap<Integer, PaymentTypeBean> payTypeMap) {
		this.payTypeMap = payTypeMap;
	}

	public LinkedHashMap<Integer, PaymentTypeBean> getPayTypeMap() {
		return payTypeMap;
	}

	public void setPlrRedeemAccMap(RedeemAccBean plrRedeemAccMap) {
		this.plrRedeemAccMap = plrRedeemAccMap;
	}

	public RedeemAccBean getPlrRedeemAccMap() {
		return plrRedeemAccMap;
	}

}
