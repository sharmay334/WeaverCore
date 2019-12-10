package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * Created by rachit on 27/3/18.
 */
public class StTxnPlrCommMaster implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long transactionId;
    private Long playerId;
    private Short domainId;
    private Short aliasId;
    private Timestamp transactionDate;
    private Long commId;
    private String eventType;
    private String channelType;
    private Double amount;
    private String walletProvider;
    private Double amountNative;
    private Integer currencyId;
    private Double vatAmount;
    private Double vatAmountNative;
    private Double cashPortion;
    private Double bonusPortion;
    private Double depPortion;
    private Double winPortion;
    private Double pendingWinPortion;
    private Double withdrawableBalPortion;
    private Timestamp confirmationDate;
    private String isCancel;

    public StTxnPlrCommMaster() {
    }

    public StTxnPlrCommMaster(Long transactionId, Long playerId, Short domainId, Short aliasId, Timestamp transactionDate, Long commId, String eventType, String channelType, Double amount, String walletProvider, Double amountNative, Integer currencyId, Double vatAmount, Double vatAmountNative, Double cashPortion, Double bonusPortion, Double depPortion, Double winPortion, Double pendingWinPortion, Double withdrawableBalPortion, String isCancel) {
        this.transactionId = transactionId;
        this.playerId = playerId;
        this.domainId = domainId;
        this.aliasId = aliasId;
        this.transactionDate = transactionDate;
        this.commId = commId;
        this.eventType = eventType;
        this.channelType = channelType;
        this.amount = amount;
        this.walletProvider = walletProvider;
        this.amountNative = amountNative;
        this.currencyId = currencyId;
        this.vatAmount = vatAmount;
        this.vatAmountNative = vatAmountNative;
        this.cashPortion = cashPortion;
        this.bonusPortion = bonusPortion;
        this.depPortion = depPortion;
        this.winPortion = winPortion;
        this.pendingWinPortion = pendingWinPortion;
        this.withdrawableBalPortion = withdrawableBalPortion;
        this.isCancel = isCancel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Short getDomainId() {
        return domainId;
    }

    public void setDomainId(Short domainId) {
        this.domainId = domainId;
    }

    public Short getAliasId() {
        return aliasId;
    }

    public void setAliasId(Short aliasId) {
        this.aliasId = aliasId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getWalletProvider() {
        return walletProvider;
    }

    public void setWalletProvider(String walletProvider) {
        this.walletProvider = walletProvider;
    }

    public Double getAmountNative() {
        return amountNative;
    }

    public void setAmountNative(Double amountNative) {
        this.amountNative = amountNative;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Double getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(Double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Double getVatAmountNative() {
        return vatAmountNative;
    }

    public void setVatAmountNative(Double vatAmountNative) {
        this.vatAmountNative = vatAmountNative;
    }

    public Double getCashPortion() {
        return cashPortion;
    }

    public void setCashPortion(Double cashPortion) {
        this.cashPortion = cashPortion;
    }

    public Double getBonusPortion() {
        return bonusPortion;
    }

    public void setBonusPortion(Double bonusPortion) {
        this.bonusPortion = bonusPortion;
    }

    public Double getDepPortion() {
        return depPortion;
    }

    public void setDepPortion(Double depPortion) {
        this.depPortion = depPortion;
    }

    public Double getWinPortion() {
        return winPortion;
    }

    public void setWinPortion(Double winPortion) {
        this.winPortion = winPortion;
    }

    public Double getPendingWinPortion() {
        return pendingWinPortion;
    }

    public void setPendingWinPortion(Double pendingWinPortion) {
        this.pendingWinPortion = pendingWinPortion;
    }

    public Double getWithdrawableBalPortion() {
        return withdrawableBalPortion;
    }

    public void setWithdrawableBalPortion(Double withdrawableBalPortion) {
        this.withdrawableBalPortion = withdrawableBalPortion;
    }

    public Timestamp getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Timestamp confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public String getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel;
    }
}
