package com.stpl.pms.javabeans;

public class PlaceHolderClientBean {
	private String path;
	private String url;

	public PlaceHolderClientBean(String path, String url) {
		super();
		this.path = path;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
