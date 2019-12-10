package com.stpl.pms.javabeans;

import java.util.ArrayList;
import java.util.List;

public class ReferenceLabelInfoBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> id = new ArrayList<Integer>();
	private String labelname;
	private List<String> valueList = new ArrayList<String>();
	private List<String> statusList = new ArrayList<String>();
	
	public String getLabelname() {
		return labelname;
	}
	public void setLabelname(String labelname) {
		this.labelname = labelname;
	}
	public void setValueList(List<String> valueList) {
		this.valueList = valueList;
	}
	public List<String> getValueList() {
		return valueList;
	}
	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}
	public List<String> getStatusList() {
		return statusList;
	}
	public void setId(List<Integer> id) {
		this.id = id;
	}
	public List<Integer> getId() {
		return id;
	}
	
	
	

}
