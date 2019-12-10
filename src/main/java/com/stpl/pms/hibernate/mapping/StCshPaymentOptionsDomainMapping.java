package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * StCshPaymentOptionsDomainMapping entity. @author MyEclipse Persistence Tools
 */

public class StCshPaymentOptionsDomainMapping implements Serializable,
		Cloneable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long podmId;
	private Integer countryId;
	private String txnType;
	private Short domainId;
	private Integer roleId;
	private Integer subTypeId;
	private String chargePayee;
	private Short providerPrefOrder;
	private String status;
	private StCshPaymentOptionsMaster paymentOptMas;
	private StCshProviderMaster providerMas;
	private StCshPaymentTypeMaster paymentTypeMas;
	private StCshPaySubMaster paySubTypeMas;
	private StGenCurrencyMaster currencyMas;
	private StCshProviderProcessingChargeMaster processingChargeMas;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;
	private Double minValue;
	private Double maxValue;
	private String device;
	private short aliasId;
	// Constructors

	@Override
	public StCshPaymentOptionsDomainMapping clone()
			throws CloneNotSupportedException {
		return (StCshPaymentOptionsDomainMapping) super.clone();
	}

	/** default constructor */
	public StCshPaymentOptionsDomainMapping() {
	}

	public Long getPodmId() {
		return this.podmId;
	}

	public void setPodmId(Long podmId) {
		this.podmId = podmId;
	}

	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getTxnType() {
		return this.txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getChargePayee() {
		return this.chargePayee;
	}

	public void setChargePayee(String chargePayee) {
		this.chargePayee = chargePayee;
	}

	public Short getProviderPrefOrder() {
		return this.providerPrefOrder;
	}

	public void setProviderPrefOrder(Short providerPrefOrder) {
		this.providerPrefOrder = providerPrefOrder;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPaymentOptMas(StCshPaymentOptionsMaster paymentOptMas) {
		this.paymentOptMas = paymentOptMas;
	}

	public StCshPaymentOptionsMaster getPaymentOptMas() {
		return paymentOptMas;
	}

	public void setProviderMas(StCshProviderMaster providerMas) {
		this.providerMas = providerMas;
	}

	public StCshProviderMaster getProviderMas() {
		return providerMas;
	}

	public void setPaymentTypeMas(StCshPaymentTypeMaster paymentTypeMas) {
		this.paymentTypeMas = paymentTypeMas;
	}

	public StCshPaymentTypeMaster getPaymentTypeMas() {
		return paymentTypeMas;
	}

	public void setPaySubTypeMas(StCshPaySubMaster paySubTypeMas) {
		this.paySubTypeMas = paySubTypeMas;
	}

	public StCshPaySubMaster getPaySubTypeMas() {
		return paySubTypeMas;
	}

	public void setCurrencyMas(StGenCurrencyMaster currencyMas) {
		this.currencyMas = currencyMas;
	}

	public StGenCurrencyMaster getCurrencyMas() {
		return currencyMas;
	}

	public void setProcessingChargeMas(
			StCshProviderProcessingChargeMaster processingChargeMas) {
		this.processingChargeMas = processingChargeMas;
	}

	public StCshProviderProcessingChargeMaster getProcessingChargeMas() {
		return processingChargeMas;
	}

	public void setSubTypeId(Integer subTypeId) {
		this.subTypeId = subTypeId;
	}

	public Integer getSubTypeId() {
		return subTypeId;
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

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public Double getMinValue() {
		return minValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDevice() {
		return device;
	}

	@Override
	public String toString() {
		return "StCshPaymentOptionsDomainMapping [chargePayee=" + chargePayee
				+ ", countryId=" + countryId + ", createdBy=" + createdBy
				+ ", creationTime=" + creationTime + ", currencyMas="
				+ currencyMas + ", device=" + device + ", domainId=" + domainId
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdationTime="
				+ lastUpdationTime + ", maxValue=" + maxValue + ", minValue="
				+ minValue + ", paySubTypeMas=" + paySubTypeMas
				+ ", paymentOptMas=" + paymentOptMas + ", paymentTypeMas="
				+ paymentTypeMas + ", podmId=" + podmId
				+ ", processingChargeMas=" + processingChargeMas
				+ ", providerMas=" + providerMas + ", providerPrefOrder="
				+ providerPrefOrder + ", roleId=" + roleId + ", status="
				+ status + ", subTypeId=" + subTypeId + ", txnType=" + txnType
				+ ", aliasId=" + aliasId 
				+ "]";
	}

	public short getAliasId() {
		return aliasId;
	}

	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}

}