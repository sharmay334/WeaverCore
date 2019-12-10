package com.stpl.pms.hibernate.mapping;

/**
 * StDmAliasPropertyMaster entity. @author MyEclipse Persistence Tools
 */

public class StDmAliasPropertyMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Short id;
	private Short aliasId;
	private String propertyName;
	private String propertyValue;
	private String status;

	// Constructors

	/** default constructor */
	public StDmAliasPropertyMaster() {
	}

	/** minimal constructor */
	public StDmAliasPropertyMaster(Short aliasId) {
		this.aliasId = aliasId;
	}

	/** full constructor */
	public StDmAliasPropertyMaster(Short aliasId, String propertyName,
			String propertyValue, String status) {
		this.aliasId = aliasId;
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
		this.status = status;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Short getAliasId() {
		return this.aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyValue() {
		return this.propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}