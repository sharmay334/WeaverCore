package com.stpl.pms.hibernate.mapping;

/**
 * StCshPaySubMasterNb entity. @author MyEclipse Persistence Tools
 */

public class StCshPaySubMasterNb  extends StCshPaySubMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer subTypeId;
	private String bankNameDispCode;
	private Integer countryId;
	private String status;

	// Constructors

	/** default constructor */
	public StCshPaySubMasterNb() {
	}

	/** full constructor */
	public StCshPaySubMasterNb(String bankNameDispCode, Integer countryId,
			String status) {
		this.bankNameDispCode = bankNameDispCode;
		this.countryId = countryId;
		this.status = status;
	}

	// Property accessors

	public Integer getSubTypeId() {
		return this.subTypeId;
	}

	public void setSubTypeId(Integer subTypeId) {
		this.subTypeId = subTypeId;
	}

	public String getBankNameDispCode() {
		return this.bankNameDispCode;
	}

	public void setBankNameDispCode(String bankNameDispCode) {
		this.bankNameDispCode = bankNameDispCode;
	}

	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}