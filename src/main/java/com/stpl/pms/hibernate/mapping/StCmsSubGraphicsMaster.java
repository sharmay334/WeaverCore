package com.stpl.pms.hibernate.mapping;

/**
 * StGenSubGraphicsMaster entity. @author MyEclipse Persistence Tools
 */

public class StCmsSubGraphicsMaster implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private StCmsGraphicsMaster stCmsGraphicsMaster;
	private String languageCode;
	private String currencyCode;
	private String path;

	// Constructors

	/** default constructor */
	public StCmsSubGraphicsMaster() {
	}

	/** full constructor */
	public StCmsSubGraphicsMaster(StCmsGraphicsMaster stCmsGraphicsMaster, String languageCode,
			String currencyCode, String path) {
		this.stCmsGraphicsMaster = stCmsGraphicsMaster;
		this.languageCode = languageCode;
		this.currencyCode = currencyCode;
		this.path = path;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setStCmsGraphicsMaster(StCmsGraphicsMaster stGenGraphicsMaster) {
		this.stCmsGraphicsMaster = stGenGraphicsMaster;
	}

	public StCmsGraphicsMaster getStCmsGraphicsMaster() {
		return stCmsGraphicsMaster;
	}

}