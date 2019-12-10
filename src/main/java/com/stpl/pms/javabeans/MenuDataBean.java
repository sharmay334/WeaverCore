package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.List;

public class MenuDataBean implements Serializable {
	private static final long serialVersionUID = 1L;
//	private String device;
	private Integer menuId;
	private String displayName;
	private Integer displayCode;
	//private String showBeforeLogin;
	private String contentType;
	private int contentName;
	private String status;
	private String highLightOpt;
	private List<MenuDataBean> subMenuList;

//	public String getDevice() {
//		return device;
//	}
//
//	public void setDevice(String device) {
//		this.device = device;
//	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

//	public String getShowBeforeLogin() {
//		return showBeforeLogin;
//	}
//
//	public void setShowBeforeLogin(String showBeforeLogin) {
//		this.showBeforeLogin = showBeforeLogin;
//	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public int getContentName() {
		return contentName;
	}

	public void setContentName(int contentName) {
		this.contentName = contentName;
	}

	public List<MenuDataBean> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(List<MenuDataBean> subMenuList) {
		this.subMenuList = subMenuList;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setDisplayCode(Integer displayCode) {
		this.displayCode = displayCode;
	}

	public Integer getDisplayCode() {
		return displayCode;
	}	

	public String getHighLightOpt() {
		return highLightOpt;
	}

	public void setHighLightOpt(String highLightOpt) {
		this.highLightOpt = highLightOpt;
	}

	@Override
	public String toString() {
		return "MenuDataBean [menuId=" + menuId + ", displayName="
				+ displayName + ", displayCode=" + displayCode
				+ ", contentType=" + contentType + ", contentName="
				+ contentName + ", status=" + status + ", highLightOpt="
				+ highLightOpt + ", subMenuList=" + subMenuList + "]";
	}
	
}
