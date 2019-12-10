package com.stpl.pms.hibernate.mapping;

/**
 * StPmDomainPPMapping entity. @author MyEclipse Persistence Tools
 */

public class StPmDomainPPMapping implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String version;
	private Short domainId;
	private String countryCode;
	private String language;
	private String PPPath;
	private String isMandatory;

	// Constructors

	/** default constructor */
	public StPmDomainPPMapping() {
	}

	/** full constructor */
	public StPmDomainPPMapping(String version, Short domainId,
			String countryCode, String language, String PPPath,
			String isMandatory) {
		this.version = version;
		this.domainId = domainId;
		this.countryCode = countryCode;
		this.language = language;
		this.PPPath = PPPath;
		this.isMandatory = isMandatory;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPPPath() {
		return this.PPPath;
	}

	public void setPPPath(String PPPath) {
		this.PPPath = PPPath;
	}

	public String getIsMandatory() {
		return this.isMandatory;
	}

	public void setIsMandatory(String isMandatory) {
		this.isMandatory = isMandatory;
	}

}