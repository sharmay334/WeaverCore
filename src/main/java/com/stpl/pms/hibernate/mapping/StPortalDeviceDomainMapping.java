package com.stpl.pms.hibernate.mapping;

/**
 * StPortalDeviceDomainMapping entity. @author MyEclipse Persistence Tools
 */

public class StPortalDeviceDomainMapping implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String domainAlias;
	private String device;
	private String layout;
	private String status;
	private StDmDomainMaster domainMaster;
	private StDmDomainAliasNameMaster aliasMaster;

	// Constructors

	/** default constructor */
	public StPortalDeviceDomainMapping() {
	}

	public StPortalDeviceDomainMapping(String domainAlias, String device,
			String layout, String status, StDmDomainMaster domainMaster, StDmDomainAliasNameMaster aliasMaster) {
		this.domainAlias = domainAlias;
		this.device = device;
		this.layout = layout;
		this.status = status;
		this.domainMaster = domainMaster;
		this.aliasMaster = aliasMaster;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDomainAlias() {
		return this.domainAlias;
	}

	public void setDomainAlias(String domainAlias) {
		this.domainAlias = domainAlias;
	}

	public String getDevice() {
		return this.device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDomainMaster(StDmDomainMaster domainMaster) {
		this.domainMaster = domainMaster;
	}

	public StDmDomainMaster getDomainMaster() {
		return domainMaster;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getLayout() {
		return layout;
	}

	public StDmDomainAliasNameMaster getAliasMaster() {
		return aliasMaster;
	}

	public void setAliasMaster(StDmDomainAliasNameMaster aliasMaster) {
		this.aliasMaster = aliasMaster;
	}

}