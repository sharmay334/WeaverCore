package com.stpl.pms.hibernate.mapping;

public class StRmServiceDeliveryMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Short sdmId;
	private StRmServiceMaster stRmServiceMaster;
	private Short domainId;
	private String tier;
	private String interfaceType;
	private String serviceDisplayName;
	private String status;
	private Short menuOrder;

	// Constructors

	/** default constructor */
	public StRmServiceDeliveryMaster() {
	}

	public Short getSdmId() {
		return this.sdmId;
	}

	public void setSdmId(Short sdmId) {
		this.sdmId = sdmId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getTier() {
		return this.tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	public String getServiceDisplayName() {
		return this.serviceDisplayName;
	}

	public void setServiceDisplayName(String serviceDisplayName) {
		this.serviceDisplayName = serviceDisplayName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getMenuOrder() {
		return this.menuOrder;
	}

	public void setMenuOrder(Short menuOrder) {
		this.menuOrder = menuOrder;
	}

	public void setStRmServiceMaster(StRmServiceMaster stRmServiceMaster) {
		this.stRmServiceMaster = stRmServiceMaster;
	}

	public StRmServiceMaster getStRmServiceMaster() {
		return stRmServiceMaster;
	}

}