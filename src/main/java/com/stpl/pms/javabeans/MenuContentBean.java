package com.stpl.pms.javabeans;

public class MenuContentBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer contentId;
	private String contentName;
	
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public Integer getContentId() {
		return contentId;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	public String getContentName() {
		return contentName;
	}

}
