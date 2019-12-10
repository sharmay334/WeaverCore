package com.stpl.pms.javabeans;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class WithdrawalRequestBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private short aliasId;
	private int currencyId;
	private double amount;
	private int paymentTypeId;
	private String currency;
	private String isNewRedeemAcc;
	private String withdrawalMode;
	private String status;
	private String paymentTypeCode;
	private long redeemAccountId;
	private int subtypeId;
	private int providerId;
	private String device;
	private String withDevice;
	private String txnType;
	private String providerNameCode;
	private String verificationCode;
	
	private PlrRedeemAccBankInfoBean bankRedAcc;
	private PlrRedeemAccChequeInfoBean chqRedAcc;
	private PlrRedeemAccCshPayInfoBean cshPayRedAcc;
	private PlrRedeemAccPrepaidWalletInfoBean prepaidAcc;
	private PlrRedeemAccMobMoneyInfoBean mobMoneyAcc;
	private PlrRedeemAccWariInfoBean  wariRedeemAcc;
	

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

	public int getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getRedeemAccountId() {
		return redeemAccountId;
	}

	public void setRedeemAccountId(long redeemAccountId) {
		this.redeemAccountId = redeemAccountId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setBankRedAcc(PlrRedeemAccBankInfoBean bankRedAcc) {
		this.bankRedAcc = bankRedAcc;
	}

	public PlrRedeemAccBankInfoBean getBankRedAcc() {
		return bankRedAcc;
	}

	public void setChqRedAcc(PlrRedeemAccChequeInfoBean chqRedAcc) {
		this.chqRedAcc = chqRedAcc;
	}

	public PlrRedeemAccChequeInfoBean getChqRedAcc() {
		return chqRedAcc;
	}

	public void setIsNewRedeemAcc(String isNewRedeemAcc) {
		this.isNewRedeemAcc = isNewRedeemAcc;
	}

	public String getIsNewRedeemAcc() {
		return isNewRedeemAcc;
	}

	public void setWithdrawalMode(String withdrawalMode) {
		this.withdrawalMode = withdrawalMode;
	}

	public String getWithdrawalMode() {
		return withdrawalMode;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setPaymentTypeCode(String paymentTypeCode) {
		this.paymentTypeCode = paymentTypeCode;
	}

	public String getPaymentTypeCode() {
		return paymentTypeCode;
	}

	public void setSubtypeId(int subtypeId) {
		this.subtypeId = subtypeId;
	}

	public int getSubtypeId() {
		return subtypeId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setCshPayRedAcc(PlrRedeemAccCshPayInfoBean cshPayRedAcc) {
		this.cshPayRedAcc = cshPayRedAcc;
	}

	public PlrRedeemAccCshPayInfoBean getCshPayRedAcc() {
		return cshPayRedAcc;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDevice() {
		return device;
	}

	public String getWithDevice() {
		return withDevice;
	}

	public void setWithDevice(String withDevice) {
		this.withDevice = withDevice;
	}

	public short getAliasId() {
		return aliasId;
	}

	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public PlrRedeemAccPrepaidWalletInfoBean getPrepaidAcc() {
		return prepaidAcc;
	}

	public void setPrepaidAcc(PlrRedeemAccPrepaidWalletInfoBean prepaidAcc) {
		this.prepaidAcc = prepaidAcc;
	}

	public PlrRedeemAccMobMoneyInfoBean getMobMoneyAcc() {
		return mobMoneyAcc;
	}

	public void setMobMoneyAcc(PlrRedeemAccMobMoneyInfoBean mobMoneyAcc) {
		this.mobMoneyAcc = mobMoneyAcc;
	}

	public String getProviderNameCode() {
		return providerNameCode;
	}

	public void setProviderNameCode(String providerNameCode) {
		this.providerNameCode = providerNameCode;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public PlrRedeemAccWariInfoBean getWariRedeemAcc() {
		return wariRedeemAcc;
	}

	public void setWariRedeemAcc(PlrRedeemAccWariInfoBean wariRedeemAcc) {
		this.wariRedeemAcc = wariRedeemAcc;
	}
	
	

}
