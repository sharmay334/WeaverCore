package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.Map;

public class PlrVariableBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, String> variableEmailMap;
	private Map<String, String> variableReqMap;

	public void setVariableEmailMap(Map<String, String> variableEmailMap) {
		this.variableEmailMap = variableEmailMap;
	}

	public Map<String, String> getVariableEmailMap() {
		return variableEmailMap;
	}

	public void setVariableReqMap(Map<String, String> variableReqMap) {
		this.variableReqMap = variableReqMap;
	}

	public Map<String, String> getVariableReqMap() {
		return variableReqMap;
	}

}
