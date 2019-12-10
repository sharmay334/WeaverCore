package com.stpl.pms.hibernate.mapping;

/**
 * Created by rachit on 13/11/17.
 */
public class StCshPaySubMasterAtm extends StCshPaySubMaster implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Integer subTypeId;
    private String atmName;
    private String status;

    public StCshPaySubMasterAtm() {
    }

    public StCshPaySubMasterAtm(Integer subTypeId, String atmName, String status) {
        this.subTypeId = subTypeId;
        this.atmName = atmName;
        this.status = status;
    }


    @Override
    public Integer getSubTypeId() {
        return subTypeId;
    }

    @Override
    public void setSubTypeId(Integer subTypeId) {
        this.subTypeId = subTypeId;
    }

    public String getAtmName() {
        return atmName;
    }

    public void setAtmName(String atmName) {
        this.atmName = atmName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
