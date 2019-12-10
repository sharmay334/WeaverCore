package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class DefPrivBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedHashMap<String, DefPrivTemp1> actionServiceMap;

	public void setActionServiceMap(LinkedHashMap<String, DefPrivTemp1> actionServiceMap) {
		this.actionServiceMap = actionServiceMap;
	}

	public LinkedHashMap<String, DefPrivTemp1> getActionServiceMap() {
		return actionServiceMap;
	}

}
