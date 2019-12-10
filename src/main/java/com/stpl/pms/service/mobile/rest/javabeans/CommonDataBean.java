package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.util.List;

public class CommonDataBean extends CommonRequestBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<String> commonRequestList;
	private String countryCode;
	private Integer countryId;//code added for state dropdown

	public void setCommonRequestList(List<String> commonRequestList) {
		this.commonRequestList = commonRequestList;
	}

	public List<String> getCommonRequestList() {
		return commonRequestList;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	
}
