package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private LinkedHashMap<String, LinkedHashMap<String,ArrayList<PriviledgeBean>>> actionServiceMap;	
	private String status;
	private Map<String, PrivFunctionBean > actionPrivFunctionMap;
	private UserInfoBean userInfo;
	private String menuStr;
	private String oldSessionId;

	public String getMenuStr() {
		return menuStr;
	}

	public void setMenuStr(String menuStr) {
		this.menuStr = menuStr;
	}

	public LinkedHashMap<String, LinkedHashMap<String, ArrayList<PriviledgeBean>>> getActionServiceMap() {
		return actionServiceMap;
	}

	public String getStatus() {
		return status;
	}

	public UserInfoBean getUserInfo() {
		return userInfo;
	}

	public void setActionServiceMap(
			LinkedHashMap<String, LinkedHashMap<String, ArrayList<PriviledgeBean>>> actionServiceMap) {
		this.actionServiceMap = actionServiceMap;
		
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUserInfo(UserInfoBean userInfo) {
		this.userInfo = userInfo;
	}


	public void setActionPrivFunctionMap(Map<String, PrivFunctionBean > actionPrivFunctionMap) {
		this.actionPrivFunctionMap = actionPrivFunctionMap;
	}

	public Map<String, PrivFunctionBean > getActionPrivFunctionMap() {
		return actionPrivFunctionMap;
	}

	public void setOldSessionId(String oldSessionId) {
		this.oldSessionId = oldSessionId;
	}

	public String getOldSessionId() {
		return oldSessionId;
	}

}
