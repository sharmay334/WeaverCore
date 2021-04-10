package com.stpl.pms.commonJavabeans;

public class EmpDistributorBean {

	private String firmName;
	private String propName;
	private String contact;
	private String address;
	
	

	public EmpDistributorBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpDistributorBean(String firmName, String propName, String contact, String address) {
		super();
		this.firmName = firmName;
		this.propName = propName;
		this.contact = contact;
		this.address = address;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
