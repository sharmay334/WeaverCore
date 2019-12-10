package com.stpl.pms.javabeans;

import java.sql.Timestamp;
import java.util.List;

import com.stpl.pms.hibernate.mapping.StCshPaymentOptionsDomainMapping;
import com.stpl.pms.hibernate.mapping.StCshPaymentOptionsMaster;
import com.stpl.pms.hibernate.mapping.StCshPaymentTypeMaster;
import com.stpl.pms.hibernate.mapping.StCshProviderMaster;
import com.stpl.pms.hibernate.mapping.StCshProviderProcessingChargeMaster;
import com.stpl.pms.hibernate.mapping.StGenCurrencyMaster;


public class PayOptBean {
	private Long paymentOptionId;
	private Integer providerId;
	private Integer paymentTypeId;
	private Integer[] subTypeIdArr;
	private String providerSubTypeCode;
	private Integer countryId;
	private Integer currencyId;
	private String providerCurrencyCode;
	private String typicalProcessTime;
	private String status;
	private Long podmId;
	private String txnType;
	private Short domainId;
	private Short aliasId;
	private Integer roleId;
	private List<Integer> roleIdArr;
	private Integer subTypeId;
	private String chargePayee;
	private Timestamp lastUpdationTime;
	private Double minValue;
	private Double maxValue;
	private String[] deviceArr;
	private String device;
	private Long processingChargeId;

	
	private Short providerPrefOrder;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
//	private StCshPaymentOptionsMaster paymentOptMas;
//	private StCshProviderMaster providerMas;
//	private StCshPaymentTypeMaster paymentTypeMas;
//	private StCshPaySubMaster paySubTypeMas;
//	private StGenCurrencyMaster currencyMas;
//	private StCshProviderProcessingChargeMaster processingChargeMas;
	
	
//	private Integer successReqCount;
//	private Integer processingTimeSecTotal;
	public StCshPaymentOptionsMaster getPOM(Integer subTypeId) {
		StCshPaymentOptionsMaster pom=new StCshPaymentOptionsMaster();
		pom.setCountryId(this.countryId);
		pom.setCurrencyId(this.currencyId);
		pom.setPaymentOptionId(this.paymentOptionId);
		pom.setPaymentTypeId(this.paymentTypeId);
		pom.setProcessingTimeSecTotal(0l);
		pom.setProviderCurrencyCode(this.providerCurrencyCode);
		pom.setProviderId(this.providerId);
		pom.setProviderSubTypeCode(this.providerSubTypeCode);
		pom.setStatus(this.status);
		pom.setSubTypeId(subTypeId);
		pom.setSuccessReqCount(0l);
		pom.setTotalReq(0l);
		pom.setTxnType(this.txnType);
		pom.setTypicalProcessTime(this.typicalProcessTime);
		return pom;
	} 
	
	public StCshPaymentOptionsMaster getPOM() {
		return getPOM(null);
	}
	
	public StCshPaymentOptionsDomainMapping getPODM(StGenCurrencyMaster currmas,StCshPaymentOptionsMaster pom,
			StCshPaymentTypeMaster ptm,StCshProviderMaster proMas,StCshProviderProcessingChargeMaster ppcm) {
		StCshPaymentOptionsDomainMapping podm=new StCshPaymentOptionsDomainMapping();
		
		podm.setCurrencyMas(currmas);
		podm.setPaymentOptMas(pom);
		podm.setPaymentTypeMas(ptm);
		podm.setProviderMas(proMas);
		podm.setProcessingChargeMas(ppcm);
		podm.setChargePayee(chargePayee);
		podm.setCountryId(countryId);
		podm.setCreatedBy(createdBy);
		podm.setCreationTime(new Timestamp(System.currentTimeMillis()));
		podm.setDevice(device);
		podm.setDomainId(domainId);
		podm.setAliasId(aliasId);
		podm.setLastUpdatedBy(lastUpdatedBy);
		podm.setLastUpdationTime(new Timestamp(System.currentTimeMillis()));
		podm.setMaxValue(maxValue);
		podm.setMinValue(minValue);
		podm.setPodmId(podmId);
		podm.setProviderPrefOrder((short)1);
		podm.setRoleId(roleId);
		podm.setStatus(status);
		podm.setSubTypeId(subTypeId);
		podm.setTxnType(txnType);
		
		return podm;
	} 
	
	public StCshPaymentOptionsDomainMapping getPODM() {
	return getPODM(null,null,null,null,null);
	}
	
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public Integer getPaymentTypeId() {
		return paymentTypeId;
	}
	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}
	public Integer getSubTypeId() {
		return subTypeId;
	}
	public void setSubTypeId(Integer subTypeId) {
		this.subTypeId = subTypeId;
	}
	public String getProviderSubTypeCode() {
		return providerSubTypeCode;
	}
	public void setProviderSubTypeCode(String providerSubTypeCode) {
		this.providerSubTypeCode = providerSubTypeCode;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public Integer getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}
	public String getProviderCurrencyCode() {
		return providerCurrencyCode;
	}
	public void setProviderCurrencyCode(String providerCurrencyCode) {
		this.providerCurrencyCode = providerCurrencyCode;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public String getTypicalProcessTime() {
		return typicalProcessTime;
	}
	public void setTypicalProcessTime(String typicalProcessTime) {
		this.typicalProcessTime = typicalProcessTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer[] getSubTypeIdArr() {
		return subTypeIdArr;
	}
	public void setSubTypeIdArr(Integer[] subTypeIdArr) {
		this.subTypeIdArr = subTypeIdArr;
	}
	public Long getPodmId() {
		return podmId;
	}
	public void setPodmId(Long podmId) {
		this.podmId = podmId;
	}
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Short getDomainId() {
		return domainId;
	}
	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}
	public String getChargePayee() {
		return chargePayee;
	}
	public void setChargePayee(String chargePayee) {
		this.chargePayee = chargePayee;
	}
	public Short getProviderPrefOrder() {
		return providerPrefOrder;
	}
	public void setProviderPrefOrder(Short providerPrefOrder) {
		this.providerPrefOrder = providerPrefOrder;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Timestamp getLastUpdationTime() {
		return lastUpdationTime;
	}
	public void setLastUpdationTime(Timestamp lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}
	public Double getMinValue() {
		return minValue;
	}
	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}
	public Double getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String[] getDeviceArr() {
		return deviceArr;
	}
	public void setDeviceArr(String[] deviceArr) {
		this.deviceArr = deviceArr;
	}

	public Long getPaymentOptionId() {
		return paymentOptionId;
	}

	public void setPaymentOptionId(Long paymentOptionId) {
		this.paymentOptionId = paymentOptionId;
	}

	public Long getProcessingChargeId() {
		return processingChargeId;
	}

	public void setProcessingChargeId(Long processingChargeId) {
		this.processingChargeId = processingChargeId;
	}

	public List<Integer> getRoleIdArr() {
		return roleIdArr;
	}

	public void setRoleIdArr(List<Integer> roleIdArr) {
		this.roleIdArr = roleIdArr;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}
}
