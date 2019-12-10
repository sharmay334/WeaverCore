package com.stpl.pms.hibernate.mapping;

/**
 * StCshPaySubMasterCshpay entity. @author MyEclipse Persistence Tools
 */

public class StCshPaySubMasterCshpay  extends StCshPaySubMaster implements java.io.Serializable  {
	private static final long serialVersionUID = 1L;
	private Integer subTypeId;
	private String cshpayTypeDispCode;
	private String status;

	// Constructors

	/** default constructor */
	public StCshPaySubMasterCshpay() {
	}

	/** full constructor */
	public StCshPaySubMasterCshpay(Integer subTypeId,
			String cshpayTypeDispCode, String status) {
		this.subTypeId = subTypeId;
		this.cshpayTypeDispCode = cshpayTypeDispCode;
		this.status = status;
	}

	// Property accessors

	public Integer getSubTypeId() {
		return this.subTypeId;
	}

	public void setSubTypeId(Integer subTypeId) {
		this.subTypeId = subTypeId;
	}

	public String getCshpayTypeDispCode() {
		return this.cshpayTypeDispCode;
	}

	public void setCshpayTypeDispCode(String cshpayTypeDispCode) {
		this.cshpayTypeDispCode = cshpayTypeDispCode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}