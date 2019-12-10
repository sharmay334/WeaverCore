package com.stpl.pms.javabeans;

import java.util.List;

public class GraphicsMasterBean implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private short domainId;
	private short aliasId;
	private String graphicsType;
	private String size;
	private String relatedTo;
	private String defaultGraphicsPath;
	private List<Integer> language;
	private List<Integer> currency;
	private List<String> graphicsPath; 

	
	public List<Integer> getLanguage() {
		return language;
	}
	public void setLanguage(List<Integer> language) {
		this.language = language;
	}
	public List<Integer> getCurrency() {
		return currency;
	}
	public void setCurrency(List<Integer> currency) {
		this.currency = currency;
	}
	public List<String> getGraphicsPath() {
		return graphicsPath;
	}
	public void setGraphicsPath(List<String> graphicsPath) {
		this.graphicsPath = graphicsPath;
	}
	public short getDomainId() {
		return domainId;
	}
	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}
	public String getGraphicsType() {
		return graphicsType;
	}
	public void setGraphicsType(String graphicsType) {
		this.graphicsType = graphicsType;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getRelatedTo() {
		return relatedTo;
	}
	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}
	public String getDefaultGraphicsPath() {
		return defaultGraphicsPath;
	}
	public void setDefaultGraphicsPath(String defaultGraphicsPath) {
		this.defaultGraphicsPath = defaultGraphicsPath;
	}
	public short getAliasId() {
		return aliasId;
	}
	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	} 

}
