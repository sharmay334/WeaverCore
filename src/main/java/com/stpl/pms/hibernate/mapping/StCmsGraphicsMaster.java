package com.stpl.pms.hibernate.mapping;

/**
 * StGenGraphicsMaster entity. @author MyEclipse Persistence Tools
 */

public class StCmsGraphicsMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer graphicsId;
	private Short domainId;
	private Short aliasId;
	private StGenLanguageMaster langMaster;
	private StGenCurrencyMaster currencyMaster;
	private String graphicsType;
	private String defaultPath;
	private String size;
	private String relatedTo;

	// Constructors

	/** default constructor */
	public StCmsGraphicsMaster() {
	}

	/** minimal constructor */
	public StCmsGraphicsMaster(String graphicsType, String relatedTo) {
		this.graphicsType = graphicsType;
		this.relatedTo = relatedTo;
	}

	/** full constructor */
	public StCmsGraphicsMaster(Short domainId, String graphicsType, StGenLanguageMaster langMaster, StGenCurrencyMaster currencyMaster,
			String defaultPath, String size, String relatedTo) {
		this.domainId = domainId;
		this.graphicsType = graphicsType;
		this.defaultPath = defaultPath;
		this.langMaster = langMaster;
		this.currencyMaster = currencyMaster;
		this.size = size;
		this.relatedTo = relatedTo;
	}

	// Property accessors

	public Integer getGraphicsId() {
		return this.graphicsId;
	}

	public void setGraphicsId(Integer graphicsId) {
		this.graphicsId = graphicsId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getGraphicsType() {
		return this.graphicsType;
	}

	public void setGraphicsType(String graphicsType) {
		this.graphicsType = graphicsType;
	}

	public String getDefaultPath() {
		return this.defaultPath;
	}

	public void setDefaultPath(String defaultPath) {
		this.defaultPath = defaultPath;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getRelatedTo() {
		return this.relatedTo;
	}

	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}

	public void setLangMaster(StGenLanguageMaster langMaster) {
		this.langMaster = langMaster;
	}

	public StGenLanguageMaster getLangMaster() {
		return langMaster;
	}

	public void setCurrencyMaster(StGenCurrencyMaster currencyMaster) {
		this.currencyMaster = currencyMaster;
	}

	public StGenCurrencyMaster getCurrencyMaster() {
		return currencyMaster;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

}