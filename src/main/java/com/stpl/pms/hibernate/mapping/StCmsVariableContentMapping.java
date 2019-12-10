package com.stpl.pms.hibernate.mapping;

/**
 * StCmsVariableContentMapping entity. @author MyEclipse Persistence Tools
 */

public class StCmsVariableContentMapping implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer variableId;
	private Integer contentId;
	private String relatedTo;
	private String isDefault;
	private String status;

	// Constructors

	/** default constructor */
	public StCmsVariableContentMapping() {
	}

	/** full constructor */
	public StCmsVariableContentMapping(Integer variableId, Integer contentId,
			String relatedTo, String isDefault, String status) {
		this.variableId = variableId;
		this.contentId = contentId;
		this.relatedTo = relatedTo;
		this.isDefault = isDefault;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVariableId() {
		return this.variableId;
	}

	public void setVariableId(Integer variableId) {
		this.variableId = variableId;
	}

	public Integer getContentId() {
		return this.contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public String getRelatedTo() {
		return this.relatedTo;
	}

	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}

	public String getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}