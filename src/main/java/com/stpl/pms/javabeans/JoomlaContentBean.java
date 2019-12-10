package com.stpl.pms.javabeans;

public class JoomlaContentBean {
	private String errorCode;
	private String contentUrl;
	private JoomlaMenuBean[] menus;
	private JoomlaModuleBean[] modules;

	public JoomlaMenuBean[] getMenus() {
		return menus;
	}

	public void setMenus(JoomlaMenuBean[] menus) {
		this.menus = menus;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public JoomlaModuleBean[] getModules() {
		return modules;
	}

	public void setModules(JoomlaModuleBean[] modules) {
		this.modules = modules;
	}

	@Override
	public String toString() {
		return "ClassPojo [menus = " + menus + ", errorCode = " + errorCode
				+ ", modules = " + modules + "]";
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
}
