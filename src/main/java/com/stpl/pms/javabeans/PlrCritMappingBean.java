package com.stpl.pms.javabeans;

public class PlrCritMappingBean {
	private Integer id; 
	private String position;
	private String status;
	private Integer moduleId;
	private String moduleTitle;
	private Integer menuId;
	private Integer phCritId;
	private String menuTitle;
	
	public PlrCritMappingBean() {
		
	}
	
	public PlrCritMappingBean(Integer id, String position,String status,Integer moduleId,String moduleTitle, Integer  menuId, Integer phCritId) {
		this.position = position;
		this.status = status;
		this.moduleId = moduleId;
		this.moduleTitle = moduleTitle;
		this.menuId = menuId;
		this.phCritId = phCritId;
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleTitle() {
		return moduleTitle;
	}

	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getPhCritId() {
		return phCritId;
	}

	public void setPhCritId(Integer phCritId) {
		this.phCritId = phCritId;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
