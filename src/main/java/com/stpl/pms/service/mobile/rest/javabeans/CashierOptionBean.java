package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.stpl.pms.javabeans.CashPayDepositRequestBean;
import com.stpl.pms.javabeans.PaymentTypeBean;
import com.stpl.pms.javabeans.RedeemAccBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CashierOptionBean extends CommonResponseBean implements
		Serializable {
	private static final long serialVersionUID = 1L;

	private HashMap<Integer, PaymentTypeBean> payTypeMap;
	private RedeemAccBean redeemAccounts;

	private HashMap<Long, CashPayDepositRequestBean> cashPayDepReq;

	public CashierOptionBean() {
	}

	public void setPayTypeMap(HashMap<Integer, PaymentTypeBean> payTypeMap) {
		this.payTypeMap = payTypeMap;
	}

	public HashMap<Integer, PaymentTypeBean> getPayTypeMap() {
		return payTypeMap;
	}

	public void setRedeemAccounts(RedeemAccBean redeemAccounts) {
		this.redeemAccounts = redeemAccounts;
	}

	public RedeemAccBean getRedeemAccounts() {
		return redeemAccounts;
	}

	public HashMap<Long, CashPayDepositRequestBean> getCashPayDepReq() {
		return cashPayDepReq;
	}

	public void setCashPayDepReq(
			HashMap<Long, CashPayDepositRequestBean> cashPayDepReq) {
		this.cashPayDepReq = cashPayDepReq;
	}

}
