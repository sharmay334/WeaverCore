package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * Created by stpl on 25/10/17.
 */
public class StTxnSettlementSafex implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String merchantName;
    private String transactionId;
    private String gatewayRef;
    private String requestId;
    private Double transactionAmount;
    private double transactionFee;
    private double meigst;
    private double mecgst;
    private double mesgst;
    private double netAmount;
    private String country;
    private String currency;
    private String gateway;
    private String paymode;
    private String scheme;
    private String email;
    private double mobile;
    private String safexStatus;
    private String subStatus;
    private Timestamp transactionDate;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StTxnSettlementSafex(){

}

    public StTxnSettlementSafex(String merchantName, String transactionId, String gatewayRef, String requestId, Double transactionAmount, double transactionFee, double meigst, double mecgst, double mesgst, double netAmount, String country, String currency, String gateway, String paymode, String scheme, String email, double mobile, String safexStatus, String subStatus, Timestamp transactionDate, String status) {
        this.merchantName = merchantName;
        this.transactionId = transactionId;
        this.gatewayRef = gatewayRef;
        this.requestId = requestId;
        this.transactionAmount = transactionAmount;
        this.transactionFee = transactionFee;
        this.meigst = meigst;
        this.mecgst = mecgst;
        this.mesgst = mesgst;
        this.netAmount = netAmount;
        this.country = country;
        this.currency = currency;
        this.gateway = gateway;
        this.paymode = paymode;
        this.scheme = scheme;
        this.email = email;
        this.mobile = mobile;
        this.safexStatus = safexStatus;
        this.subStatus = subStatus;
        this.transactionDate = transactionDate;
        this.status=status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getGatewayRef() {
        return gatewayRef;
    }

    public void setGatewayRef(String gatewayRef) {
        this.gatewayRef = gatewayRef;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public double getMeigst() {
        return meigst;
    }

    public void setMeigst(double meigst) {
        this.meigst = meigst;
    }

    public double getMecgst() {
        return mecgst;
    }

    public void setMecgst(double mecgst) {
        this.mecgst = mecgst;
    }

    public double getMesgst() {
        return mesgst;
    }

    public void setMesgst(double mesgst) {
        this.mesgst = mesgst;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMobile() {
        return mobile;
    }

    public void setMobile(double mobile) {
        this.mobile = mobile;
    }

    public String getSafexStatus() {
        return safexStatus;
    }

    public void setSafexStatus(String safexStatus) {
        this.safexStatus = safexStatus;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }
}
