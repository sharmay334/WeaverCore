package com.stpl.pms.javabeans;

public class DomainDetailsBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String domainName;
	private int domainId;
	
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainId(int domainId) {
		this.domainId = domainId;
	}

	public int getDomainId() {
		return domainId;
	}
	
}
