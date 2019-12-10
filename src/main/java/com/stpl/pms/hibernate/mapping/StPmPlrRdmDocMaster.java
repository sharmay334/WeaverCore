package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * Created by rachit on 8/5/18.
 */
public class StPmPlrRdmDocMaster implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long docId;
    private Long playerId;
    private Long redeemAccId;
    private String bankIdUniqueNo;
    private String bankIdPath;
    private String identityIdUniqueNo;
    private String identityIdPath;
    private String bankIdVerification;
    private String identityIdVerification;
    private Timestamp uploadedDate;

    public StPmPlrRdmDocMaster() {
    }

    public StPmPlrRdmDocMaster(Long docId, Long playerId, Long redeemAccId, String bankIdUniqueNo, String bankIdPath, String identityIdUniqueNo, String identityIdPath, String bankIdVerification, String identityIdVerification, Timestamp uploadedDate) {
        this.docId = docId;
        this.playerId = playerId;
        this.redeemAccId = redeemAccId;
        this.bankIdUniqueNo = bankIdUniqueNo;
        this.bankIdPath = bankIdPath;
        this.identityIdUniqueNo = identityIdUniqueNo;
        this.identityIdPath = identityIdPath;
        this.bankIdVerification = bankIdVerification;
        this.identityIdVerification = identityIdVerification;
        this.uploadedDate = uploadedDate;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getRedeemAccId() {
        return redeemAccId;
    }

    public void setRedeemAccId(Long redeemAccId) {
        this.redeemAccId = redeemAccId;
    }

    public String getBankIdUniqueNo() {
        return bankIdUniqueNo;
    }

    public void setBankIdUniqueNo(String bankIdUniqueNo) {
        this.bankIdUniqueNo = bankIdUniqueNo;
    }

    public String getBankIdPath() {
        return bankIdPath;
    }

    public void setBankIdPath(String bankIdPath) {
        this.bankIdPath = bankIdPath;
    }

    public String getIdentityIdUniqueNo() {
        return identityIdUniqueNo;
    }

    public void setIdentityIdUniqueNo(String identityIdUniqueNo) {
        this.identityIdUniqueNo = identityIdUniqueNo;
    }

    public String getIdentityIdPath() {
        return identityIdPath;
    }

    public void setIdentityIdPath(String identityIdPath) {
        this.identityIdPath = identityIdPath;
    }

    public String getBankIdVerification() {
        return bankIdVerification;
    }

    public void setBankIdVerification(String bankIdVerification) {
        this.bankIdVerification = bankIdVerification;
    }

    public String getIdentityIdVerification() {
        return identityIdVerification;
    }

    public void setIdentityIdVerification(String identityIdVerification) {
        this.identityIdVerification = identityIdVerification;
    }

    public Timestamp getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(Timestamp uploadedDate) {
        this.uploadedDate = uploadedDate;
    }
}
