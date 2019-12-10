package com.stpl.pms.hibernate.mapping;

/**
 * StGenLanguageMaster entity. @author MyEclipse Persistence Tools
 */

public class StGenLanguageMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer languageId;
	private Short domainId;
	private String languageCode;
	private String languageBaseCode;
	private String languageName;
	private String languageScript;
	private String countryCode;
	private String countryName;
	private String status;

	// Constructors

	/** default constructor */
	public StGenLanguageMaster() {
	}

	
	public StGenLanguageMaster(Integer languageId) {
		super();
		this.languageId = languageId;
	}


	/** minimal constructor */
	public StGenLanguageMaster(Short domainId, String languageBaseCode,
			String languageScript, String status) {
		this.domainId = domainId;
		this.languageBaseCode = languageBaseCode;
		this.languageScript = languageScript;
		this.status = status;
	}

	/** full constructor */
	public StGenLanguageMaster(Short domainId, String languageCode,
			String languageBaseCode, String languageName,
			String languageScript, String countryCode, String countryName,
			String status) {
		this.domainId = domainId;
		this.languageCode = languageCode;
		this.languageBaseCode = languageBaseCode;
		this.languageName = languageName;
		this.languageScript = languageScript;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.status = status;
	}

	// Property accessors

	public Integer getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageBaseCode() {
		return this.languageBaseCode;
	}

	public void setLanguageBaseCode(String languageBaseCode) {
		this.languageBaseCode = languageBaseCode;
	}

	public String getLanguageName() {
		return this.languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getLanguageScript() {
		return this.languageScript;
	}

	public void setLanguageScript(String languageScript) {
		this.languageScript = languageScript;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}