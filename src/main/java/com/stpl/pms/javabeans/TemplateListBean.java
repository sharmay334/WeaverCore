package com.stpl.pms.javabeans;


import java.io.Serializable;

public class TemplateListBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String subject;
	private String from;
	private String[] url;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String[] getUrl() {
		return url;
	}
	public void setUrl(String[] url) {
		this.url = url;
	}
	
}
