package com.stpl.pms.javabeans;

import java.io.Serializable;

public class AliasPropertyBean  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Short domainId;
	private String aliasId;
	private String pcAlias;
	private String mobileAlias;
	private String tabAlias;
	public Short getDomainId() {
		return domainId;
	}
	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}
	public String getAliasId() {
		return aliasId;
	}
	public void setAliasId(String aliasId) {
		this.aliasId = aliasId;
	}
	public String getPcAlias() {
		return pcAlias;
	}
	public void setPcAlias(String pcAlias) {
		this.pcAlias = pcAlias;
	}
	public String getMobileAlias() {
		return mobileAlias;
	}
	public void setMobileAlias(String mobileAlias) {
		this.mobileAlias = mobileAlias;
	}
	public String getTabAlias() {
		return tabAlias;
	}
	public void setTabAlias(String tabAlias) {
		this.tabAlias = tabAlias;
	}
	
	

}
