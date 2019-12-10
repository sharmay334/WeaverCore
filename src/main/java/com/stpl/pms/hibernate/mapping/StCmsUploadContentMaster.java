package com.stpl.pms.hibernate.mapping;

/**
 * StCmsUploadContentMaster entity. @author MyEclipse Persistence Tools
 */

public class StCmsUploadContentMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String contentPath;
	private String status;

	// Constructors

	/** default constructor */
	public StCmsUploadContentMaster() {
	}

	/** full constructor */
	public StCmsUploadContentMaster(String contentPath, String status) {
		this.contentPath = contentPath;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContentPath() {
		return this.contentPath;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}