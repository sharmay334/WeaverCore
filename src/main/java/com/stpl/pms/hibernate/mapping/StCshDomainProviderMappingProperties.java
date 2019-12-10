package com.stpl.pms.hibernate.mapping;

/**
 * StCshDomainProviderMappingProperties entity. @author MyEclipse Persistence
 * Tools
 */

public class StCshDomainProviderMappingProperties implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer providerMappingId;
	private String propertyName;
	private String propertyValue;
	private String status;

	// Constructors

	/** default constructor */
	public StCshDomainProviderMappingProperties() {
	}

	/** full constructor */
	public StCshDomainProviderMappingProperties(Integer providerMappingId,
			String propertyName, String propertyValue, String status) {
		this.providerMappingId = providerMappingId;
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProviderMappingId() {
		return this.providerMappingId;
	}

	public void setProviderMappingId(Integer providerMappingId) {
		this.providerMappingId = providerMappingId;
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