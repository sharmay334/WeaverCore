package com.stpl.pms.hibernate.mapping;

/**
 * StPortalContentSubMaster entity. @author MyEclipse Persistence Tools
 */

public class StPortalContentSubMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer contentId;
	private String languageCode;
	private String contentPath;

	// Constructors

	/** default constructor */
	public StPortalContentSubMaster() {
	}

	/** full constructor */
	public StPortalContentSubMaster(Integer contentId, String languageCode,
			String contentPath) {
		this.contentId = contentId;
		this.languageCode = languageCode;
		this.setContentPath(contentPath);
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContentId() {
		return this.contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

	public String getContentPath() {
		return contentPath;
	}


}