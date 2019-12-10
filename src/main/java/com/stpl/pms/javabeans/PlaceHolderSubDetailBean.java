package com.stpl.pms.javabeans;

public class PlaceHolderSubDetailBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer contentId;
	private String contentName;
	private String contentPath;
	
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
	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}
	public String getContentPath() {
		return contentPath;
	}
 
}
