package com.stpl.pms.javabeans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlaceHolderDetailBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer phId;
	private Integer height;
	private Integer width;
	private String contentValue;
	private Map<Integer, String> phCritMap = null;
	private Integer phCritId;
	private String phName;
	private String mappingStatus;
	private String redirectPage;
	private Timestamp startDate;
	private Timestamp endDate ;

	private List<PlaceHolderSubDetailBean> placeHolderSubDetailList = new ArrayList<PlaceHolderSubDetailBean>();

	public Integer getPhId() {
		return phId;
	}

	public void setPhId(Integer phId) {
		this.phId = phId;
	}

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

	public List<PlaceHolderSubDetailBean> getPlaceHolderSubDetailList() {
		return placeHolderSubDetailList;
	}

	public void setPlaceHolderSubDetailList(
			List<PlaceHolderSubDetailBean> placeHolderSubDetailList) {
		this.placeHolderSubDetailList = placeHolderSubDetailList;
	}

	public void setContentValue(String contentValue) {
		this.contentValue = contentValue;
	}

	public String getContentValue() {
		return contentValue;
	}

	public String getPhName() {
		return phName;
	}

	public void setPhName(String phName) {
		this.phName = phName;
	}

	public Map<Integer, String> getPhCritMap() {
		return phCritMap;
	}

	public void setPhCritMap(Map<Integer, String> phCritMap) {
		this.phCritMap = phCritMap;
	}

	public Integer getPhCritId() {
		return phCritId;
	}

	public void setPhCritId(Integer phCritId) {
		this.phCritId = phCritId;
	}

	public String getMappingStatus() {
		return mappingStatus;
	}

	public void setMappingStatus(String mappingStatus) {
		this.mappingStatus = mappingStatus;
	}

	public String getRedirectPage() {
		return redirectPage;
	}

	public void setRedirectPage(String redirectPage) {
		this.redirectPage = redirectPage;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	
	
	
	

}
