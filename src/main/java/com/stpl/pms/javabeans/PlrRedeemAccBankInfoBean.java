package com.stpl.pms.javabeans;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class PlrRedeemAccBankInfoBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long redeemAccId;

	private Integer paymentTypeId;
	private String paymentType;
	private Integer providerId;

	private Integer subtypeId;
	private String bankName;
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
	private Short domainId;
	private Short aliasId;

	public PlrRedeemAccBankInfoBean() {
	}


	public PlrRedeemAccBankInfoBean(Long redeemAccId, Integer subTypeId,
			String branchCity, String branchLocation, String branchAddress,
			String micrCode, String ifscCode, String accHolderName,
			String accNum, String accType, Integer countryId, String status,
			String bankName, Integer paymentTypeId, String paymentType,
			Integer providerId) {
		this.redeemAccId = redeemAccId;
		this.subtypeId = subTypeId;
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
		this.bankName = bankName;

		this.paymentTypeId = paymentTypeId;
		this.paymentType = paymentType;
		this.providerId = providerId;
	}

	public PlrRedeemAccBankInfoBean(Long redeemAccId, Integer subTypeId,
			String branchCity, String branchLocation, String branchAddress,
			String micrCode, String ifscCode, String accHolderName,
			String accNum, String accType, Integer countryId, String status,
			String bankName, Integer paymentTypeId, String paymentType,
			Integer providerId,Short domainId,Short aliasId) {
		this.redeemAccId = redeemAccId;
		this.subtypeId = subTypeId;
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
		this.bankName = bankName;

		this.paymentTypeId = paymentTypeId;
		this.paymentType = paymentType;
		this.providerId = providerId;
		this.domainId=domainId;
		this.aliasId=aliasId;
	}

	public Long getRedeemAccId() {
		return redeemAccId;
	}

	public void setRedeemAccId(Long redeemAccId) {
		this.redeemAccId = redeemAccId;
	}

	public Integer getSubtypeId() {
		return subtypeId;
	}

	public void setSubtypeId(Integer subtypeId) {
		this.subtypeId = subtypeId;
	}

	public String getBranchCity() {
		return branchCity;
	}

	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}

	public String getBranchLocation() {
		return branchLocation;
	}

	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getMicrCode() {
		return micrCode;
	}

	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public Integer getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Integer getProviderId() {
		return providerId;
	}


	public Short getDomainId() {
		return domainId;
	}


	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}


	public Short getAliasId() {
		return aliasId;
	}


	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}
	

}
