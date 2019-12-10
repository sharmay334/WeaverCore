package com.stpl.pms.hibernate.mapping;

public interface StTxnTicketWagerMaster {

	public void setWagerStatus(String string);
	public void setBonusToCash(Double updateWagerContribution);
	public Double getBonusToCash();
	public Double getRake();
	public Long getPlayerId();
	public Long getTransactionId();
}
