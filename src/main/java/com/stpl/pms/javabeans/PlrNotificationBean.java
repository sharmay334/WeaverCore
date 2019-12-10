package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.List;

public class PlrNotificationBean  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> appTypeList;
	private String pageName;
	private String message;
	private List<String> deeplinkList;
 	private boolean sentToAll;

	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSentToAll() {
		return sentToAll;
	}
	public void setSentToAll(boolean sentToAll) {
		this.sentToAll = sentToAll;
	}
	public List<String> getDeeplinkList() {
		return deeplinkList;
	}
	public void setDeeplinkList(List<String> deeplinkList) {
		this.deeplinkList = deeplinkList;
	}
	public List<String> getAppTypeList() {
		return appTypeList;
	}
	public void setAppTypeList(List<String> appTypeList) {
		this.appTypeList = appTypeList;
	}
}
