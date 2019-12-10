package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

public class BoGraphRequestBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String domainName;

	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	
	
}
