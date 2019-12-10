package com.stpl.pms.hibernate.mapping;

/**
 * Created by rachit on 13/11/17.
 */
public class StCshPaySubMasterFreecharge extends StCshPaySubMaster implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Integer subTypeId;
    private String walletName;
    private String status;

    public StCshPaySubMasterFreecharge() {
    }

    public StCshPaySubMasterFreecharge(Integer subTypeId, String walletName, String status) {
        this.subTypeId = subTypeId;
        this.walletName = walletName;
        this.status = status;
    }

    public Integer getSubTypeId() {
        return subTypeId;
    }

    public String getWalletName() {
        return walletName;
    }

    public String getStatus() {
        return status;
    }

    public void setSubTypeId(Integer subTypeId) {
        this.subTypeId = subTypeId;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
