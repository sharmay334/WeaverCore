package com.stpl.pms.javabeans;

import java.io.Serializable;

public class StateBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int stateId;
	private String stateCode;
	private String name;
	private String status;
	//code added for downloading state list acc to country id
	private Integer countryId;
	
	public StateBean(int stateId, String stateCode, String name, String status) {
		this.stateId = stateId;
		this.stateCode = stateCode;
		this.name = name;
		this.status = status;
	}

	public StateBean() {
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StateBean [name=" + name + ", stateCode=" + stateCode
				+ ", stateId=" + stateId + "]";
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
}
