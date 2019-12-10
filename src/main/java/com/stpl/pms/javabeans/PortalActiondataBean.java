package com.stpl.pms.javabeans;

import java.util.Map;


public class PortalActiondataBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Integer,String> actionIdPreLoginMap;
	private Map<Integer,String> actionIdPostLoginMap;
	public Map<Integer, String> getActionIdPreLoginMap() {
		return actionIdPreLoginMap;
	}
	public void setActionIdPreLoginMap(Map<Integer, String> actionIdPreLoginMap) {
		this.actionIdPreLoginMap = actionIdPreLoginMap;
	}
	public Map<Integer, String> getActionIdPostLoginMap() {
		return actionIdPostLoginMap;
	}
	public void setActionIdPostLoginMap(Map<Integer, String> actionIdPostLoginMap) {
		this.actionIdPostLoginMap = actionIdPostLoginMap;
	}
}
