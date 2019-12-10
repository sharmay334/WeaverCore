package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class WithdrawalTxnBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long transactionId;
	private long playerId;
	private short domainId;
	private Timestamp transactionDate;
	private int currencyId;
	private double amount;
	private int processCurrencyId;
	private double processCharges;
	private int convCurrencyId;
	private double convCharges;
	private double tdsAmount;
	private int toCurrencyId;
	private double toAmount;
	private String withdrawalMode;
	private Timestamp processTime;
	private String refTxnNo;
	private Timestamp refTxnDate;
	private String status;
	private String isCancel;
	private String userName;
	private String firstName;
	private String lastName;
	private int vipLevel;
	
	private long podmId;
	private int paymentTypeId;
	private String payTypeCode;
	private String payTypeDispCode;
	private String providerNameCode;
	private PlayerWalletBean walletInfo;
	
	private int subtypeId;
	
	private PlrRedeemAccBankInfoBean bankRedAcc;
	private PlrRedeemAccChequeInfoBean chqRedAcc;
	private PlrRedeemAccCshPayInfoBean cshPayRedAcc;
	private PlrRedeemAccPrepaidWalletInfoBean walletAcc;
	private PlrRedeemAccWariInfoBean wariRedAcc;
	private String reasonForCancel;
	private Integer countCancelByBo;
	
	private long redeemAccountId;

	public int getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public long getPodmId() {
		return podmId;
	}

	public void setPodmId(long podmId) {
		this.podmId = podmId;
	}

	public String getPayTypeCode() {
		return payTypeCode;
	}

	public void setPayTypeCode(String payTypeCode) {
		this.payTypeCode = payTypeCode;
	}

	public String getPayTypeDispCode() {
		return payTypeDispCode;
	}

	public void setPayTypeDispCode(String payTypeDispCode) {
		this.payTypeDispCode = payTypeDispCode;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getProcessCurrencyId() {
		return processCurrencyId;
	}

	public void setProcessCurrencyId(int processCurrencyId) {
		this.processCurrencyId = processCurrencyId;
	}

	public double getProcessCharges() {
		return processCharges;
	}

	public void setProcessCharges(double processCharges) {
		this.processCharges = processCharges;
	}

	public int getConvCurrencyId() {
		return convCurrencyId;
	}

	public void setConvCurrencyId(int convCurrencyId) {
		this.convCurrencyId = convCurrencyId;
	}

	public double getConvCharges() {
		return convCharges;
	}

	public void setConvCharges(double convCharges) {
		this.convCharges = convCharges;
	}

	public double getTdsAmount() {
		return tdsAmount;
	}

	public void setTdsAmount(double tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

	public int getToCurrencyId() {
		return toCurrencyId;
	}

	public void setToCurrencyId(int toCurrencyId) {
		this.toCurrencyId = toCurrencyId;
	}

	public double getToAmount() {
		return toAmount;
	}

	public void setToAmount(double toAmount) {
		this.toAmount = toAmount;
	}

	public String getWithdrawalMode() {
		return withdrawalMode;
	}

	public void setWithdrawalMode(String withdrawalMode) {
		this.withdrawalMode = withdrawalMode;
	}

	public Timestamp getProcessTime() {
		return processTime;
	}

	public void setProcessTime(Timestamp processTime) {
		this.processTime = processTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}

	public PlrRedeemAccBankInfoBean getBankRedAcc() {
		return bankRedAcc;
	}

	public void setBankRedAcc(PlrRedeemAccBankInfoBean bankRedAcc) {
		this.bankRedAcc = bankRedAcc;
	}

	public PlrRedeemAccChequeInfoBean getChqRedAcc() {
		return chqRedAcc;
	}

	public void setChqRedAcc(PlrRedeemAccChequeInfoBean chqRedAcc) {
		this.chqRedAcc = chqRedAcc;
	}

	public long getRedeemAccountId() {
		return redeemAccountId;
	}

	public void setRedeemAccountId(long redeemAccountId) {
		this.redeemAccountId = redeemAccountId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	public int getVipLevel() {
		return vipLevel;
	}

	public void setSubtypeId(int subtypeId) {
		this.subtypeId = subtypeId;
	}

	public int getSubtypeId() {
		return subtypeId;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public String getRefTxnNo() {
		return refTxnNo;
	}

	public void setRefTxnDate(Timestamp refTxnDate) {
		this.refTxnDate = refTxnDate;
	}

	public Timestamp getRefTxnDate() {
		return refTxnDate;
	}

	public void setCshPayRedAcc(PlrRedeemAccCshPayInfoBean cshPayRedAcc) {
		this.cshPayRedAcc = cshPayRedAcc;
	}

	public PlrRedeemAccCshPayInfoBean getCshPayRedAcc() {
		return cshPayRedAcc;
	}

	public void setProviderNameCode(String providerNameCode) {
		this.providerNameCode = providerNameCode;
	}

	public String getProviderNameCode() {
		return providerNameCode;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public PlayerWalletBean getWalletInfo() {
		return walletInfo;
	}

	public void setWalletInfo(PlayerWalletBean walletInfo) {
		this.walletInfo = walletInfo;
	}

	public String getReasonForCancel() {
		return reasonForCancel;
	}

	public void setReasonForCancel(String reasonForCancel) {
		this.reasonForCancel = reasonForCancel;
	}

	public Integer getCountCancelByBo() {
		return countCancelByBo;
	}

	public void setCountCancelByBo(Integer countCancelByBo) {
		this.countCancelByBo = countCancelByBo;
	}

	public PlrRedeemAccPrepaidWalletInfoBean getWalletAcc() {
		return walletAcc;
	}

	public void setWalletAcc(PlrRedeemAccPrepaidWalletInfoBean walletAcc) {
		this.walletAcc = walletAcc;
	}

	public PlrRedeemAccWariInfoBean getWariRedAcc() {
		return wariRedAcc;
	}

	public void setWariRedAcc(PlrRedeemAccWariInfoBean wariRedAcc) {
		this.wariRedAcc = wariRedAcc;
	}
	
	
}
