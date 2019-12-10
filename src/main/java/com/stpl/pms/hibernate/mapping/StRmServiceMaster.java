package com.stpl.pms.hibernate.mapping;

public class StRmServiceMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Short serviceId;
	private String serviceName;
	private String serviceCode;
	private String status;
	private String privRepTable;
	private String menuMasterTable;

	// Constructors

	/** default constructor */
	public StRmServiceMaster() {
	}

	public Short getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Short serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceCode() {
		return this.serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrivRepTable() {
		return this.privRepTable;
	}

	public void setPrivRepTable(String privRepTable) {
		this.privRepTable = privRepTable;
	}

	public String getMenuMasterTable() {
		return this.menuMasterTable;
	}

	public void setMenuMasterTable(String menuMasterTable) {
		this.menuMasterTable = menuMasterTable;
	}

}