package com.stpl.pms.hibernate.mapping;

/**
 * StCmsPlaceHolderMaster entity. @author MyEclipse Persistence Tools
 */

public class StCmsPlaceholderMaster implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer phId;
	private Integer height;
	private Integer width;
	private String	name;
	private String placeHolderCode;
	private String languageCode;
	private String status;
	private StPortalContentMaster portalContentMaster;

	// Constructors

	/** default constructor */
	public StCmsPlaceholderMaster() {
	}

	/** minimal constructor */
	public StCmsPlaceholderMaster(Integer height, Integer width,
			String placeHolderCode) {
		this.height = height;
		this.width = width;
		this.placeHolderCode = placeHolderCode;
	}

	/** full constructor */
	public StCmsPlaceholderMaster(Integer height, Integer width,
			String placeHolderCode, String name, String languageCode, String status) {
		this.height = height;
		this.width = width;
		this.placeHolderCode = placeHolderCode;
		this.languageCode = languageCode;
		this.name = name;
		this.status = status;
	}

	// Property accessors

	public Integer getPhId() {
		return this.phId;
	}

	public void setPhId(Integer phId) {
		this.phId = phId;
	}

	
	public Integer getHeight() {
		return this.height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return this.width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getPlaceHolderCode() {
		return this.placeHolderCode;
	}

	public void setPlaceHolderCode(String placeHolderCode) {
		this.placeHolderCode = placeHolderCode;
	}

	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setPortalContentMaster(StPortalContentMaster portalContentMaster) {
		this.portalContentMaster = portalContentMaster;
	}

	public StPortalContentMaster getPortalContentMaster() {
		return portalContentMaster;
	}

}