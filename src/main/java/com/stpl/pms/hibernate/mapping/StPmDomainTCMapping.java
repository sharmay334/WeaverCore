package com.stpl.pms.hibernate.mapping;

/**
 * StPmDomainTCMapping entity. @author MyEclipse Persistence Tools
 */

public class StPmDomainTCMapping implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String version;
	private Short domainId;
	private String countryCode;
	private String language;
	private String TCPath;
	private String isMandatory;

	// Constructors

	/** default constructor */
	public StPmDomainTCMapping() {
	}

	/** full constructor */
	public StPmDomainTCMapping(String version, Short domainId,
			String countryCode, String language, String TCPath,
			String isMandatory) {
		this.version = version;
		this.domainId = domainId;
		this.countryCode = countryCode;
		this.language = language;
		this.TCPath = TCPath;
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

	public String getTCPath() {
		return this.TCPath;
	}

	public void setTCPath(String TCPath) {
		this.TCPath = TCPath;
	}

	public String getIsMandatory() {
		return this.isMandatory;
	}

	public void setIsMandatory(String isMandatory) {
		this.isMandatory = isMandatory;
	}

}