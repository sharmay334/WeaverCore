package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PlaceHolderBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer height;
	private Integer width;
	private String name;
	private String placeHolderCode;
	private String languageCode;
	
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public String getPlaceHolderCode() {
		return placeHolderCode;
	}
	public void setPlaceHolderCode(String placeHolderCode) {
		this.placeHolderCode = placeHolderCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
