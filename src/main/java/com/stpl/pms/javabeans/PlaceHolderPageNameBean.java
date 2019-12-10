package com.stpl.pms.javabeans;


public class PlaceHolderPageNameBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer contentId;
	private String contentName;
	private String contentType;
	private String  contentPath;
	private int language;
	private String device;
	
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
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}
	public String getContentPath() {
		return contentPath;
	}
	public void setLanguage(int language) {
		this.language = language;
	}
	public int getLanguage() {
		return language;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	
	@Override
	public boolean equals(Object obj) {
		return contentId.equals(((PlaceHolderPageNameBean)obj).getContentId());
	}
}
