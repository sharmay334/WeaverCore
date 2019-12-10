package com.stpl.pms.hibernate.mapping;

/**
 * StGenPropertyMaster entity. @author MyEclipse Persistence Tools
 */

public class StGenPropertyMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String propertyCode;
	private String propertyDevName;
	private String propertyDisplayName;
	private String status;
	private String editable;
	private String value;
	private String valueType;
	private String description;

	// Constructors

	/** default constructor */
	public StGenPropertyMaster() {
	}

	/** full constructor */
	public StGenPropertyMaster(String propertyCode, String propertyDevName,
			String propertyDisplayName, String status, String editable,
			String value, String valueType, String description) {
		this.propertyCode = propertyCode;
		this.propertyDevName = propertyDevName;
		this.propertyDisplayName = propertyDisplayName;
		this.status = status;
		this.editable = editable;
		this.value = value;
		this.valueType = valueType;
		this.description = description;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPropertyCode() {
		return this.propertyCode;
	}

	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	public String getPropertyDevName() {
		return this.propertyDevName;
	}

	public void setPropertyDevName(String propertyDevName) {
		this.propertyDevName = propertyDevName;
	}

	public String getPropertyDisplayName() {
		return this.propertyDisplayName;
	}

	public void setPropertyDisplayName(String propertyDisplayName) {
		this.propertyDisplayName = propertyDisplayName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEditable() {
		return this.editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValueType() {
		return this.valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}