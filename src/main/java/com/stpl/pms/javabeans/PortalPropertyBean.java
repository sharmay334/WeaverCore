package com.stpl.pms.javabeans;

import java.util.ArrayList;

public class PortalPropertyBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<PortalMenuBean> menuList;
	private String layout;

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getLayout() {
		return layout;
	}

	public void setMenuList(ArrayList<PortalMenuBean> menuList) {
		this.menuList = menuList;
	}

	public ArrayList<PortalMenuBean> getMenuList() {
		return menuList;
	}

	
}
