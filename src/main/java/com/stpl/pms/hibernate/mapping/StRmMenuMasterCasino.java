package com.stpl.pms.hibernate.mapping;

public class StRmMenuMasterCasino implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer menuId;
	private Integer actionId;
	private String menuName;
	private String menuDispCode;
	private Short parentMenuId;
	private Short itemOrder;

	// Constructors

	/** default constructor */
	public StRmMenuMasterCasino() {
	}

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getActionId() {
		return this.actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuDispCode() {
		return this.menuDispCode;
	}

	public void setMenuDispCode(String menuDispCode) {
		this.menuDispCode = menuDispCode;
	}

	public Short getParentMenuId() {
		return this.parentMenuId;
	}

	public void setParentMenuId(Short parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public Short getItemOrder() {
		return this.itemOrder;
	}

	public void setItemOrder(Short itemOrder) {
		this.itemOrder = itemOrder;
	}

}