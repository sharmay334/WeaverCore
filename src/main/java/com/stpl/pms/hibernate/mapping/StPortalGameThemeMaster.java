package com.stpl.pms.hibernate.mapping;

/**
 * StPortalGameThemeMaster entity. @author MyEclipse Persistence Tools
 */

public class StPortalGameThemeMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer themeId;
	private String themeName;
	private String status;
	private int showOrder; 

	// Constructors

	/** default constructor */
	public StPortalGameThemeMaster() {
	}

	/** minimal constructor */
	public StPortalGameThemeMaster(Integer themeId) {
		this.themeId = themeId;
	}
	public StPortalGameThemeMaster(String themeName) {
		this.themeName = themeName;
	}

	/** full constructor */
	public StPortalGameThemeMaster(String themeName, String status) {
		this.themeName = themeName;
		this.status = status;
	}

	// Property accessors

	public Integer getThemeId() {
		return this.themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	public String getThemeName() {
		return this.themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(int showOrder) {
		this.showOrder = showOrder;
	}
}