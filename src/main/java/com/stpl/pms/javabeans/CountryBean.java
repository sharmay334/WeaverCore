package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CountryBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int countryId;
	private String countryCode;
	private String name;
	private String status;
	private List<StateBean> stateList;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StateBean> getStateList() {
		return stateList;
	}

	public void setStateList(List<StateBean> stateList) {
		this.stateList = stateList;
	}
	public void setStateList(StateBean state) {
		if (this.stateList==null) {
			this.stateList = new ArrayList<StateBean>();
		}
		this.stateList.add(state);
	}

	@Override
	public String toString() {
		return "CountryBean [countryCode=" + countryCode + ", countryId="
				+ countryId + ", name=" + name + ", stateList=" + stateList
				+ "]";
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
