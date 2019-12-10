package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrRedeemAccInfoBank entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrRedeemAccInfoBank extends StCshPlrRedeemAccMaster
		implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String branchCity;
	private String branchLocation;
	private String branchAddress;
	private String micrCode;
	private String ifscCode;
	private String accHolderName;
	private String accNum;
	private String accType;
	private Integer countryId;
	private String status;
	private StCshPaySubMaster subTypeMas;

	public StCshPlrRedeemAccInfoBank() {
	}

	public StCshPlrRedeemAccInfoBank(StCshPlrRedeemAccMaster redAccMaster,
			String branchCity, String branchLocation, String branchAddress,
			String micrCode, String ifscCode, String accHolderName,
			String accNum, String accType, Integer countryId, String status,
			StCshPaySubMaster subTypeMas) {
		super(redAccMaster.getPaymentType(),
				redAccMaster.getProviderId(), redAccMaster.getPlayerId(),
				redAccMaster.getStatus(), redAccMaster.getPaymentTypeMas());
		this.branchCity = branchCity;
		this.branchLocation = branchLocation;
		this.branchAddress = branchAddress;
		this.micrCode = micrCode;
		this.ifscCode = ifscCode;
		this.accHolderName = accHolderName;
		this.accNum = accNum;
		this.accType = accType;
		this.countryId = countryId;
		this.status = status;
		this.subTypeMas = subTypeMas;
	}

	public String getBranchCity() {
		return this.branchCity;
	}

	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}

	public String getBranchLocation() {
		return this.branchLocation;
	}

	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}

	public String getBranchAddress() {
		return this.branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getMicrCode() {
		return this.micrCode;
	}

	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}

	public String getIfscCode() {
		return this.ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccHolderName() {
		return this.accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public String getAccNum() {
		return this.accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getAccType() {
		return this.accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
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

	public void setSubTypeMas(StCshPaySubMaster subTypeMas) {
		this.subTypeMas = subTypeMas;
	}

	public StCshPaySubMaster getSubTypeMas() {
		return subTypeMas;
	}

}