package com.stpl.pms.javabeans;

import java.util.HashMap;

public class UrlTagBean implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private HashMap<String, String> meta;
	private boolean isCommonCSS;
	private boolean isCustomCSS;

	public boolean isCustomCSS() {
		return isCustomCSS;
	}

	public void setCustomCSS(boolean isCustomCSS) {
		this.isCustomCSS = isCustomCSS;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public HashMap<String, String> getMeta() {
		return meta;
	}

	public void setMeta(HashMap<String, String> meta) {
		this.meta = meta;
	}

	public boolean isCommonCSS() {
		return isCommonCSS;
	}

	public void setCommonCSS(boolean isCommonCSS) {
		this.isCommonCSS = isCommonCSS;
	}

}
