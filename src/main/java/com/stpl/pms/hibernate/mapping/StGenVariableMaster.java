package com.stpl.pms.hibernate.mapping;

/**
 * StGenVariableMaster entity. @author MyEclipse Persistence Tools
 */

public class StGenVariableMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer variableId;
	private String variableDisplayName;
	private String variableCode;
	private String variableType;
	private String variableTag;
	private String variableScope;
	private String variableReplaceValue;
	private String status;

	// Constructors

	/** default constructor */
	public StGenVariableMaster() {
	}

	/** minimal constructor */
	public StGenVariableMaster(String variableDisplayName, String variableCode,
			String variableType, String variableTag) {
		this.variableDisplayName = variableDisplayName;
		this.variableCode = variableCode;
		this.variableType = variableType;
		this.variableTag = variableTag;
	}

	/** full constructor */
	public StGenVariableMaster(String variableDisplayName, String variableCode,
			String variableType, String variableTag, String variableScope,
			String variableReplaceValue, String status) {
		this.variableDisplayName = variableDisplayName;
		this.variableCode = variableCode;
		this.variableType = variableType;
		this.variableTag = variableTag;
		this.variableScope = variableScope;
		this.variableReplaceValue = variableReplaceValue;
		this.status = status;
	}

	// Property accessors

	public Integer getVariableId() {
		return this.variableId;
	}

	public void setVariableId(Integer variableId) {
		this.variableId = variableId;
	}

	public String getVariableDisplayName() {
		return this.variableDisplayName;
	}

	public void setVariableDisplayName(String variableDisplayName) {
		this.variableDisplayName = variableDisplayName;
	}

	public String getVariableCode() {
		return this.variableCode;
	}

	public void setVariableCode(String variableCode) {
		this.variableCode = variableCode;
	}

	public String getVariableType() {
		return this.variableType;
	}

	public void setVariableType(String variableType) {
		this.variableType = variableType;
	}

	public String getVariableTag() {
		return this.variableTag;
	}

	public void setVariableTag(String variableTag) {
		this.variableTag = variableTag;
	}

	public String getVariableScope() {
		return this.variableScope;
	}

	public void setVariableScope(String variableScope) {
		this.variableScope = variableScope;
	}

	public String getVariableReplaceValue() {
		return this.variableReplaceValue;
	}

	public void setVariableReplaceValue(String variableReplaceValue) {
		this.variableReplaceValue = variableReplaceValue;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}