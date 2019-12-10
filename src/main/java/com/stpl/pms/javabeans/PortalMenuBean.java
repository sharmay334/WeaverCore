package com.stpl.pms.javabeans;

import java.util.ArrayList;

public class PortalMenuBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer menuId;
	private Integer parentMenuId;
	private Integer menuDisplayCode;
	private String menuDisplayName;
	private String actionUrl;
	private String isPopUp;
	private String contentType;
	private String contentName;
	private Integer contentId;
	private int orderBy;
	private int level;
	private String status;
	private boolean checkLogin;
	private String highLightOpt;

	private ArrayList<PortalMenuBean> menuBeanList;

	public void setMenuDisplayCode(Integer menuDisplayCode) {
		this.menuDisplayCode = menuDisplayCode;
	}

	public Integer getMenuDisplayCode() {
		return menuDisplayCode;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setMenuBeanList(ArrayList<PortalMenuBean> menuBeanList) {
		this.menuBeanList = menuBeanList;
	}

	public ArrayList<PortalMenuBean> getMenuBeanList() {
		return menuBeanList;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public void setIsPopUp(String isPopUp) {
		this.isPopUp = isPopUp;
	}

	public String getIsPopUp() {
		return isPopUp;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuDisplayName(String menuDisplayName) {
		this.menuDisplayName = menuDisplayName;
	}

	public String getMenuDisplayName() {
		return menuDisplayName;
	}

	public void setParentMenuId(Integer parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public Integer getParentMenuId() {
		return parentMenuId;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setCheckLogin(boolean checkLogin) {
		this.checkLogin = checkLogin;
	}

	public boolean isCheckLogin() {
		return checkLogin;
	}
	
	public String getHighLightOpt() {
		return highLightOpt;
	}

	public void setHighLightOpt(String highLightOpt) {
		this.highLightOpt = highLightOpt;
	}

	@Override
	public String toString() {
		return "PortalMenuBean [actionUrl=" + actionUrl + "]";
	}

}
