package com.stpl.pms.hibernate.mapping;

/**
 * StCshPaySubMasterMobileMoney entity. @author MyEclipse Persistence Tools
 */

public class StCshPaySubMasterMobileWallet extends StCshPaySubMaster implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer subTypeId;
	private String walletName;
	private String status;
	private int uiOrder;
	// Constructors

	/** default constructor */
	public StCshPaySubMasterMobileWallet() {
	}

	/** full constructor */
	public StCshPaySubMasterMobileWallet(String walletName, String status,int uiOrder) {
		this.walletName = walletName;
		this.status = status;
		this.uiOrder = uiOrder;
	}

	// Property accessors

	public Integer getSubTypeId() {
		return this.subTypeId;
	}

	public void setSubTypeId(Integer subTypeId) {
		this.subTypeId = subTypeId;
	}

	public String getWalletName() {
		return this.walletName;
	}

	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUiOrder() {
		return uiOrder;
	}

	public void setUiOrder(int uiOrder) {
		this.uiOrder = uiOrder;
	}
}