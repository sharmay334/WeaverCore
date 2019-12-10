package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.stpl.pms.commonJavabeans.CashierBonusBean;
import com.stpl.pms.commonJavabeans.PlayerBonusDetails;
import com.stpl.pms.commonJavabeans.PlayerLedgerBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerReportBean extends CommonResponseBean implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private List<PlayerLedgerBean> txnList;
	private List<PlayerBonusDetails> bonusList;
	private List<WithdrawalDetailBean> withdrawalList;
	private List<CashierBonusBean> promoCodeList;

	public List<PlayerLedgerBean> getTxnList() {
		return txnList;
	}

	public void setTxnList(List<PlayerLedgerBean> txnList) {
		this.txnList = txnList;
	}

	public List<PlayerBonusDetails> getBonusList() {
		return bonusList;
	}

	public void setBonusList(List<PlayerBonusDetails> bonusList) {
		this.bonusList = bonusList;
	}


	public void setWithdrawalList(List<WithdrawalDetailBean> withdrawalList) {
		this.withdrawalList = withdrawalList;
	}

	public List<WithdrawalDetailBean> getWithdrawalList() {
		return withdrawalList;
	}

	public void setPromoCodeList(List<CashierBonusBean> promoCodeList) {
		this.promoCodeList = promoCodeList;
	}

	public List<CashierBonusBean> getPromoCodeList() {
		return promoCodeList;
	}

	/*public List<PortalWinnersList> getWinnersList() {
		return winnersList;
	}

	public void setWinnersList(List<PortalWinnersList> winnersList) {
		this.winnersList = winnersList;
	}*/

}
