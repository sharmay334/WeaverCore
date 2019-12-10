package com.stpl.pms.hibernate.mapping;

public class StCshPaySubMasterBackOffice  extends StCshPaySubMaster {

	private static final long serialVersionUID = 1L;
	// Fields
	
    private String walletName;
    private String status;

    
    
   	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }
}
