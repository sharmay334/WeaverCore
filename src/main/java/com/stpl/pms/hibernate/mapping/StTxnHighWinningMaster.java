package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * Created by rachit on 6/4/18.
 */
public class StTxnHighWinningMaster implements java.io.Serializable {

    private final static long serialVersionUID = 1L;

    private Long highWinningId;
    private short domainId;
    private short aliasId;
    private Long playerId;
    private Long transactionId;
    private Double amount;
    private String gameType;
    private String gameName;
    private String serviceCode;
    private String processMethod;
    private Long processBOUserId;
    private Timestamp initiateDate;
    private Timestamp processDate;
    private String pendingWinningStatus;
    private String userComment;


    public StTxnHighWinningMaster() {
    }

    public StTxnHighWinningMaster(short domainId, short aliasId, Long playerId, Long transactionId, Double amount, String gameType, String gameName, String serviceCode, String processMethod, String pendingWinningStatus, Timestamp initiateDate) {
        this.domainId = domainId;
        this.aliasId = aliasId;
        this.playerId = playerId;
        this.transactionId = transactionId;
        this.amount = amount;
        this.gameType = gameType;
        this.gameName = gameName;
        this.serviceCode = serviceCode;
        this.processMethod = processMethod;
        this.pendingWinningStatus = pendingWinningStatus;
        this.initiateDate = initiateDate;
    }

    public Long getHighWinningId() {
        return highWinningId;
    }

    public void setHighWinningId(Long highWinningId) {
        this.highWinningId = highWinningId;
    }

    public short getDomainId() {
        return domainId;
    }

    public void setDomainId(short domainId) {
        this.domainId = domainId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getProcessMethod() {
        return processMethod;
    }

    public void setProcessMethod(String processMethod) {
        this.processMethod = processMethod;
    }

    public Long getProcessBOUserId() {
        return processBOUserId;
    }

    public void setProcessBOUserId(Long processBOUserId) {
        this.processBOUserId = processBOUserId;
    }

    public Timestamp getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Timestamp processDate) {
        this.processDate = processDate;
    }

    public String getPendingWinningStatus() {
        return pendingWinningStatus;
    }

    public void setPendingWinningStatus(String pendingWinningStatus) {
        this.pendingWinningStatus = pendingWinningStatus;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }


    public short getAliasId() {
        return aliasId;
    }

    public void setAliasId(short aliasId) {
        this.aliasId = aliasId;
    }

    public Timestamp getInitiateDate() {
        return initiateDate;
    }

    public void setInitiateDate(Timestamp initiateDate) {
        this.initiateDate = initiateDate;
    }
}
