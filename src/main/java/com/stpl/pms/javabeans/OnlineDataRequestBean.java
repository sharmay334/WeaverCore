package com.stpl.pms.javabeans;

import java.io.Serializable;

public class OnlineDataRequestBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private GlobalInfo globalInfo; 
	private OperatorInfo operatorInfo;
	private String domainName;
	public GlobalInfo getGlobalInfo() {
		return globalInfo;
	}
	public void setGlobalInfo(GlobalInfo globalInfo) {
		this.globalInfo = globalInfo;
	}
	public OperatorInfo getOperatorInfo() {
		return operatorInfo;
	}
	public void setOperatorInfo(OperatorInfo operatorInfo) {
		this.operatorInfo = operatorInfo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
}
