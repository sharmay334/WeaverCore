package com.stpl.pms.javabeans;

public class CssBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int cssId;
	private String cssName;
	private String cssPath;

	public CssBean() {
	}

	public CssBean(int cssId, String cssName, String cssPath) {
		this.cssId = cssId;
		this.cssName = cssName;
		this.cssPath = cssPath;
	}

	public int getCssId() {
		return cssId;
	}

	public void setCssId(int cssId) {
		this.cssId = cssId;
	}

	public String getCssName() {
		return cssName;
	}

	public void setCssName(String cssName) {
		this.cssName = cssName;
	}

	public String getCssPath() {
		return cssPath;
	}

	public void setCssPath(String cssPath) {
		this.cssPath = cssPath;
	}

}
