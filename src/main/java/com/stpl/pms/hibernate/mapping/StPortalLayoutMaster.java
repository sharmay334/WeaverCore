package com.stpl.pms.hibernate.mapping;

/**
 * StPortalLayoutMaster entity. @author MyEclipse Persistence Tools
 */

public class StPortalLayoutMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Short id;
	private String groupCode;
	private String layoutCode;
	private String layoutPath;
	private String cssPath;
	private String isDefault;
	private String deviceFor;
	private String status;
	private String maxSize;

	// Constructors

	/** default constructor */
	public StPortalLayoutMaster() {
	}

	/** minimal constructor */
	public StPortalLayoutMaster(String isDefault, String deviceFor,
			String status, String maxSize) {
		this.isDefault = isDefault;
		this.deviceFor = deviceFor;
		this.status = status;
		this.maxSize = maxSize;
	}

	/** full constructor */
	public StPortalLayoutMaster(String groupCode, String layoutCode,
			String layoutPath, String cssPath, String isDefault,
			String deviceFor, String status, String maxSize) {
		this.groupCode = groupCode;
		this.layoutCode = layoutCode;
		this.layoutPath = layoutPath;
		this.cssPath = cssPath;
		this.isDefault = isDefault;
		this.deviceFor = deviceFor;
		this.status = status;
		this.maxSize = maxSize;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getGroupCode() {
		return this.groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getLayoutCode() {
		return this.layoutCode;
	}

	public void setLayoutCode(String layoutCode) {
		this.layoutCode = layoutCode;
	}

	public String getLayoutPath() {
		return this.layoutPath;
	}

	public void setLayoutPath(String layoutPath) {
		this.layoutPath = layoutPath;
	}

	public String getCssPath() {
		return this.cssPath;
	}

	public void setCssPath(String cssPath) {
		this.cssPath = cssPath;
	}

	public String getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getDeviceFor() {
		return this.deviceFor;
	}

	public void setDeviceFor(String deviceFor) {
		this.deviceFor = deviceFor;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMaxSize() {
		return this.maxSize;
	}

	public void setMaxSize(String maxSize) {
		this.maxSize = maxSize;
	}

}