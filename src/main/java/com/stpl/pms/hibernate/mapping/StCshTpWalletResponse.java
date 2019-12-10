package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;
import java.sql.Timestamp;

public class StCshTpWalletResponse implements Serializable  {
    public final Long serialVersionUID=1L;

    private Long id;
    private String tpReference;
    private String weaverReference;
    private String responseDesc;
    private String extra;
    private String requestType;
    private String discriminant;
    private Timestamp responseMoment;
    private String status;
    private String responseCode;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StCshTpWalletResponse() {
    }

    public StCshTpWalletResponse(String tpReference, String weaverReference, String responseDesc, String extra, String requestType, String discriminant) {
        this.tpReference = tpReference;
        this.weaverReference = weaverReference;
        this.responseDesc = responseDesc;
        this.extra = extra;
        this.requestType = requestType;
        this.discriminant = discriminant;
    }

    public String getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(String discriminant) {
        this.discriminant = discriminant;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public String getWeaverReference() {
        return weaverReference;
    }

    public void setWeaverReference(String weaverReference) {
        this.weaverReference = weaverReference;
    }

    public String getTpReference() {
        return tpReference;
    }

    public void setTpReference(String tpReference) {
        this.tpReference = tpReference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getResponseMoment() {
        return responseMoment;
    }

    public void setResponseMoment(Timestamp responseMoment) {
        this.responseMoment = responseMoment;
    }

}
