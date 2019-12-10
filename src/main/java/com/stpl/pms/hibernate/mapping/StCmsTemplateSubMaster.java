package com.stpl.pms.hibernate.mapping;

/**
 * StCmsTemplateSubMaster entity. @author MyEclipse Persistence Tools
 */

public class StCmsTemplateSubMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private StCmsTemplateMaster stCmsTemplateMaster;
	private String languageCode;
	private String contentPath;

	// Constructors

	/** default constructor */
	public StCmsTemplateSubMaster() {
	}

	/** full constructor */
	public StCmsTemplateSubMaster(StCmsTemplateMaster stCmsTemplateMaster, String languageCode,
			String contentPath) {
		this.stCmsTemplateMaster = stCmsTemplateMaster;
		this.languageCode = languageCode;
		this.contentPath = contentPath;
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

	public void setStCmsTemplateMaster(StCmsTemplateMaster stCmsTemplateMaster) {
		this.stCmsTemplateMaster = stCmsTemplateMaster;
	}

	public StCmsTemplateMaster getStCmsTemplateMaster() {
		return stCmsTemplateMaster;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

	public String getContentPath() {
		return contentPath;
	}

}