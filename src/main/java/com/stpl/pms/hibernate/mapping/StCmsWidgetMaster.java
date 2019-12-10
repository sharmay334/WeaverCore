package com.stpl.pms.hibernate.mapping;

/**
 * StCmsWidgetMaster entity. @author MyEclipse Persistence Tools
 */

public class StCmsWidgetMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short domainId;
	private String widgetName;
	private Integer widgetHeight;
	private Integer widgetWidth;
	private StPortalContentMaster stPortalContentMaster;
	private String status;

	// Constructors

	/** default constructor */
	public StCmsWidgetMaster() {
	}

	/** full constructor */
	public StCmsWidgetMaster(Short domainId, String widgetName,
			Integer widgetHeight, Integer widgetWidth, StPortalContentMaster stPortalContentMaster,
			String status) {
		this.domainId = domainId;
		this.widgetName = widgetName;
		this.widgetHeight = widgetHeight;
		this.widgetWidth = widgetWidth;
		this.setStPortalContentMaster(stPortalContentMaster);
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getWidgetName() {
		return this.widgetName;
	}

	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}

	public Integer getWidgetHeight() {
		return this.widgetHeight;
	}

	public void setWidgetHeight(Integer widgetHeight) {
		this.widgetHeight = widgetHeight;
	}

	public Integer getWidgetWidth() {
		return this.widgetWidth;
	}

	public void setWidgetWidth(Integer widgetWidth) {
		this.widgetWidth = widgetWidth;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStPortalContentMaster(StPortalContentMaster stPortalContentMaster) {
		this.stPortalContentMaster = stPortalContentMaster;
	}

	public StPortalContentMaster getStPortalContentMaster() {
		return stPortalContentMaster;
	}

}