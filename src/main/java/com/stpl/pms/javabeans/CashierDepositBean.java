package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CashierDepositBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private LinkedHashMap<Integer, PaymentTypeBean> payTypeMap;
	private HashMap<Long, WithdrawalTxnBean> pendingWdrMap;
	private HashMap<Long, CashPayDepositRequestBean> cashPayDepReq;

	public LinkedHashMap<Integer, PaymentTypeBean> getPayTypeMap() {
		return payTypeMap;
	}

	public void setPayTypeMap(LinkedHashMap<Integer, PaymentTypeBean> payTypeMap) {
		this.payTypeMap = payTypeMap;
	}

	public HashMap<Long, WithdrawalTxnBean> getPendingWdrMap() {
		return pendingWdrMap;
	}

	public void setPendingWdrMap(HashMap<Long, WithdrawalTxnBean> pendingWdrMap) {
		this.pendingWdrMap = pendingWdrMap;
	}

	public void setCashPayDepReq(
			HashMap<Long, CashPayDepositRequestBean> cashPayDepReq) {
		this.cashPayDepReq = cashPayDepReq;
	}

	public HashMap<Long, CashPayDepositRequestBean> getCashPayDepReq() {
		return cashPayDepReq;
	}

}
