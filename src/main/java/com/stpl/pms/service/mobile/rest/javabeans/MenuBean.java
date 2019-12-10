package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String menuCode;
	private String menuDisplayName;
	private String actionUrl;
	private List<MenuBean> subMenuList;

	public MenuBean() {
	}

	public MenuBean(String menuCode, String menuDisplayName, String actionUrl,
			List<MenuBean> subMenuList) {
		this.menuCode = menuCode;
		this.menuDisplayName = menuDisplayName;
		this.actionUrl = actionUrl;
		this.subMenuList = subMenuList;
	}

	public String getMenuDisplayName() {
		return menuDisplayName;
	}

	public void setMenuDisplayName(String menuDisplayName) {
		this.menuDisplayName = menuDisplayName;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public List<MenuBean> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(List<MenuBean> subMenuList) {
		this.subMenuList = subMenuList;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuCode() {
		return menuCode;
	}

}
