package com.stpl.pms.hibernate.mapping;

/**
 * StCshPaySubMasterPrepaid entity. @author MyEclipse Persistence Tools
 */

public class StCshPaySubMasterPaytm extends StCshPaySubMaster implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer subTypeId;
	private String walletName;
	private String status;

	// Constructors

	/** default constructor */
	public StCshPaySubMasterPaytm() {
	}

	/** full constructor */
	public StCshPaySubMasterPaytm(Integer subTypeId, String walletName,
			String status) {
		this.subTypeId = subTypeId;
		this.walletName = walletName;
		this.status = status;
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

}