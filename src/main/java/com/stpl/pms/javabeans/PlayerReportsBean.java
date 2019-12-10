package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import com.stpl.pms.commonJavabeans.PlayerBonusDetails;
import com.stpl.pms.commonJavabeans.PlayerLedgerBean;

public class PlayerReportsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private LinkedHashMap<Long, WithdrawalTxnBean> withdrawalTxnMap;
	private List<PlayerLedgerBean> txnLedger;
	private List<PlayerBonusDetails> bonusDetails;
	private List<PlayerTicketDetails> ticketDetails;
	private Double totalAmount;


	public void setTxnLedger(List<PlayerLedgerBean> txnLedger) {
		this.txnLedger = txnLedger;
	}

	public List<PlayerLedgerBean> getTxnLedger() {
		return txnLedger;
	}

	public void setBonusDetails(List<PlayerBonusDetails> bonusDetails) {
		this.bonusDetails = bonusDetails;
	}

	public List<PlayerBonusDetails> getBonusDetails() {
		return bonusDetails;
	}

	public void setWithdrawalTxnMap(
			LinkedHashMap<Long, WithdrawalTxnBean> withdrawalTxnMap) {
		this.withdrawalTxnMap = withdrawalTxnMap;
	}

	public LinkedHashMap<Long, WithdrawalTxnBean> getWithdrawalTxnMap() {
		return withdrawalTxnMap;
	}

	public List<PlayerTicketDetails> getTicketDetails() {
		return ticketDetails;
	}

	public void setTicketDetails(List<PlayerTicketDetails> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
