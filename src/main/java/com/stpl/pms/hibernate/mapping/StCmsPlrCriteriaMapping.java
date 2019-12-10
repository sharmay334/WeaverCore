package com.stpl.pms.hibernate.mapping;

/**
 * StCmsPlrCriteriaMapping entity. @author MyEclipse Persistence Tools
 */

public class StCmsPlrCriteriaMapping implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short aliasId;
	private Integer menuId;
	private String menuTitle;
	private Integer moduleId;
	private String moduleTitle;
	private String modulePosition;
	private Integer phCritId;
	private String status;

	// Constructors

	/** default constructor */
	public StCmsPlrCriteriaMapping() {
	}

	/** minimal constructor */
	public StCmsPlrCriteriaMapping(Short aliasId, Integer menuId,
			Integer moduleId, Integer phCritId, String status) {
		this.aliasId = aliasId;
		this.menuId = menuId;
		this.moduleId = moduleId;
		this.phCritId = phCritId;
		this.status = status;
	}

	/** full constructor */
	public StCmsPlrCriteriaMapping(Short aliasId, Integer menuId,
			String menuTitle, Integer moduleId, String moduleTitle,
			String modulePosition, Integer phCritId, String status) {
		this.aliasId = aliasId;
		this.menuId = menuId;
		this.menuTitle = menuTitle;
		this.moduleId = moduleId;
		this.moduleTitle = moduleTitle;
		this.modulePosition = modulePosition;
		this.phCritId = phCritId;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getAliasId() {
		return this.aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuTitle() {
		return this.menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public Integer getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleTitle() {
		return this.moduleTitle;
	}

	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}

	public String getModulePosition() {
		return this.modulePosition;
	}

	public void setModulePosition(String modulePosition) {
		this.modulePosition = modulePosition;
	}

	public Integer getPhCritId() {
		return this.phCritId;
	}

	public void setPhCritId(Integer phCritId) {
		this.phCritId = phCritId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}