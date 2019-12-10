package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PortalUrlBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer contentId;
	private String contentName;
	private String actionMapping;
	private String actionNamespace;
	
	public Integer getContentId() {
		return contentId;
	}
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public String getContentName() {
		return contentName;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	public String getActionMapping() {
		return actionMapping;
	}
	public void setActionMapping(String actionMapping) {
		this.actionMapping = actionMapping;
	}
	public String getActionNamespace() {
		return actionNamespace;
	}
	public void setActionNamespace(String actionNamespace) {
		this.actionNamespace = actionNamespace;
	}

}
