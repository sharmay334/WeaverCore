package com.stpl.pms.hibernate.mapping;

/**
 * Created by rachit on 6/4/18.
 */
public class StTxnWinningPreferenceMaster implements java.io.Serializable {

    private final static long serialVersionUID = 1L;
    private Long winPreferId;
    private short domainId;
    private short aliasId;
    private String serviceCode;
    private Double winningMinRange;
    private Double winningMaxRange;
    private String priority;
    private String processMethod;

    public StTxnWinningPreferenceMaster() {
    }

    public StTxnWinningPreferenceMaster(Long winPreferId, short domainId, short aliasId, String serviceCode, Double winningMinRange, Double winningMaxRange, String priority, String processMethod) {
        this.winPreferId = winPreferId;
        this.domainId = domainId;
        this.aliasId = aliasId;
        this.serviceCode = serviceCode;
        this.winningMinRange = winningMinRange;
        this.winningMaxRange = winningMaxRange;
        this.priority = priority;
        this.processMethod = processMethod;
    }

    public Long getWinPreferId() {
        return winPreferId;
    }

    public void setWinPreferId(Long winPreferId) {
        this.winPreferId = winPreferId;
    }

    public short getDomainId() {
        return domainId;
    }

    public void setDomainId(short domainId) {
        this.domainId = domainId;
    }

    public short getAliasId() {
        return aliasId;
    }

    public void setAliasId(short aliasId) {
        this.aliasId = aliasId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public Double getWinningMinRange() {
        return winningMinRange;
    }

    public void setWinningMinRange(Double winningMinRange) {
        this.winningMinRange = winningMinRange;
    }

    public Double getWinningMaxRange() {
        return winningMaxRange;
    }

    public void setWinningMaxRange(Double winningMaxRange) {
        this.winningMaxRange = winningMaxRange;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getProcessMethod() {
        return processMethod;
    }

    public void setProcessMethod(String processMethod) {
        this.processMethod = processMethod;
    }
}
