package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

public interface StTxnWagerMaster {

	
	public Double getCashPortion();
	public Double getBonusPortion();
	public Double getPendingWinPortion();
	public Double getSubwalletPortion();
	public Double getProcessChargeRefund();
	public Double getWithdrawableBalPortion();
	public Double getAmount();
	public String getGameName();
	public void setWagerStatus(String string);
	public void setConfirmationDate(Timestamp timestamp);
	public void setBonusToCash(Double updateWagerContribution);
	public Double getBonusToCash();
	public Double getRake();
	public Long getPlayerId();
	public Long getTransactionId();
	public Timestamp getTransactionDate();
	public String getRefTxnNo();
	public String getWagerStatus();
}
