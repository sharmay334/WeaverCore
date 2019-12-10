package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PriviledgeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String actionMapping;
	private String actionUrl;
	private String module;
	private String privTitle;
	private String relatedTo;

	public String getActionMapping() {
		return actionMapping;
	}

	public String getModule() {
		return module;
	}

	public String getPrivTitle() {
		return privTitle;
	}

	public String getRelatedTo() {
		return relatedTo;
	}

	public void setActionMapping(String actionMapping) {
		this.actionMapping = actionMapping;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public void setPrivTitle(String privTitle) {
		this.privTitle = privTitle;
	}

	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

}
