package com.stpl.pms.javabeans;

public class CreateCompany implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String currentAddress;
	private String country;
	private String state;
	private String pincode;
	private String fyb;
	private String bbf;
	private String contactNo;
	private String faxNo;
	private String gstNo;
	private String panNo;
	private String bankDetails;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getFyb() {
		return fyb;
	}

	public void setFyb(String fyb) {
		this.fyb = fyb;
	}

	public String getBbf() {
		return bbf;
	}

	public void setBbf(String bbf) {
		this.bbf = bbf;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

}
