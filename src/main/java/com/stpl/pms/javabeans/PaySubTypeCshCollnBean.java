package com.stpl.pms.javabeans;

import java.util.ArrayList;

public class PaySubTypeCshCollnBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer subTypeId;
	private String city;
	private ArrayList<String> pinCode;
	
	public void setSubTypeId(Integer subTypeId) {
		this.subTypeId = subTypeId;
	}
	public Integer getSubTypeId() {
		return subTypeId;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return city;
	}
	public void setPinCode(ArrayList<String> pinCode) {
		this.pinCode = pinCode;
	}
	public ArrayList<String> getPinCode() {
		return pinCode;
	}
}
