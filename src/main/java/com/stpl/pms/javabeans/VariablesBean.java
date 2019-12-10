package com.stpl.pms.javabeans;

import java.io.Serializable;

public class VariablesBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String variableName;
	private String variableType;
	private String variableTag;
	private Integer variableReplaceId;
	private String variableReplaceValue;
	
	
	public String getVariableName() {
		return variableName;
	}
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}
	public String getVariableType() {
		return variableType;
	}
	public void setVariableType(String variableType) {
		this.variableType = variableType;
	}
	public String getVariableTag() {
		return variableTag;
	}
	public void setVariableTag(String variableTag) {
		this.variableTag = variableTag;
	}
	public Integer getVariableReplaceId() {
		return variableReplaceId;
	}
	public void setVariableReplaceId(Integer variableReplaceId) {
		this.variableReplaceId = variableReplaceId;
	}
	public String getVariableReplaceValue() {
		return variableReplaceValue;
	}
	public void setVariableReplaceValue(String variableReplaceValue) {
		this.variableReplaceValue = variableReplaceValue;
	}
	
}
