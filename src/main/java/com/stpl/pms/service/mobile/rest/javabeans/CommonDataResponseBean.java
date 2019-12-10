package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonDataResponseBean extends CommonResponseBean implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> commonData;

	public void setCommonData(Map<String, Object> commonData) {
		this.commonData = commonData;
	}

	public Map<String, Object> getCommonData() {
		return commonData;
	}

}
