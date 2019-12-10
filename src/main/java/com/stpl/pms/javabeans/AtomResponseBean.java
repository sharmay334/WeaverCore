package com.stpl.pms.javabeans;

import java.util.HashMap;


public class AtomResponseBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String url;
	private HashMap<String, String> paramMap;
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	public void setParamMap(HashMap<String, String> paramMap) {
		this.paramMap = paramMap;
	}
	public void setParamMap(String key, String value) {
		if (paramMap==null) {
			paramMap = new HashMap<String, String>();
		}
		paramMap.put(key, value);
	}
	public HashMap<String, String> getParamMap() {
		return paramMap;
	}
	@Override
	public String toString() {
		return "AtomResponseBean [paramMap=" + paramMap + ", url=" + url + "]";
	}
	
}
