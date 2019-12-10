package com.stpl.pms.javabeans;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown= true)

public class WagerWinTxnInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double amount;
	private String refTxnNo;
	private String particular;
	private Double wrContriAmount;
	private String isWithdrawable;
	private boolean deviceCheck;
	private String macAddress;
	private String txnType;

	@JsonIgnore
	public TransactionDetailBean fetchTransactionDetailBean(Long gameId,String gameName,String gameType,String walletType,String balanceType) {
		TransactionDetailBean bean=new TransactionDetailBean();
		bean.setAmount(amount);
		bean.setWalletType(walletType);
		bean.setBalanceType(balanceType);
		bean.setRefTxnNo(refTxnNo);
		bean.setParticular(particular);
		bean.setWrContriAmount(wrContriAmount==null?100:wrContriAmount);
		bean.setGameId(gameId);
		bean.setGameName(gameName);
		bean.setGameType(gameType);
		return bean;
	}

	@JsonIgnore
	public PlayerTxnBean fetchPlayerTxnBean(Long playerId,String aliasName,String device,Long gameId,String gameName,String gameType,String walletType,String balanceType) {
		PlayerTxnBean bean=new PlayerTxnBean();
		bean.setAmount(amount==null?0:amount);
		bean.setWalletType(walletType);
		bean.setBalanceType(balanceType);
		bean.setRefTxnNo(refTxnNo);
		bean.setPlayerId(playerId);
		bean.setAliasName(aliasName);
		bean.setParticular(particular);
		bean.setGameType(gameType);
		bean.setGameName(gameName);
		bean.setGameId(gameId);
		bean.setIsWithdrawable(isWithdrawable==null?"Y":isWithdrawable);
		bean.setDevice(device);
		return bean;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getRefTxnNo() {
		return refTxnNo;
	}
	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public Double getWrContriAmount() {
		return wrContriAmount;
	}
	public void setWrContriAmount(Double wrContriAmount) {
		this.wrContriAmount = wrContriAmount;
	}
	
	public String getIsWithdrawable() {
		return isWithdrawable;
	}
	public void setIsWithdrawable(String isWithdrawable) {
		this.isWithdrawable = isWithdrawable;
	}
	public boolean isDeviceCheck() {
		return deviceCheck;
	}
	public void setDeviceCheck(boolean deviceCheck) {
		this.deviceCheck = deviceCheck;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

}
