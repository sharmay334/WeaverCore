package com.stpl.pms.hibernate.mapping;

public class StCshPaySubMasterUPI extends StCshPaySubMaster implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields
	
	private String walletName;
	private String status;

	public StCshPaySubMasterUPI() {
		// TODO Auto-generated constructor stub
	}

	public String getWalletName() {
		return walletName;
	}

	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
