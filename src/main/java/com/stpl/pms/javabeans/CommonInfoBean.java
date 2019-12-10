package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.List;

public class CommonInfoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Short aliasId;
	private Short domainId;
	private String aliasName;
	private String domainName;
	private String layout;
	private String device;
	private String defaultContentPath;
	private String defaultCssPath;
	private String defaultJsPath;
	private String mixpanelToken;
	private String jsCssVersion;
	private String commonContentPath;
	private PlayerInfoBean playerInfoBean;
	private UrlTagBean tagBean;
	private List<PortalMenuBean> menuList;
	private String inspectletToken;
	
	

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public Short getDomainId() {
		return domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDefaultCssPath() {
		return defaultCssPath;
	}

	public void setDefaultCssPath(String defaultCssPath) {
		this.defaultCssPath = defaultCssPath;
	}

	public String getDefaultJsPath() {
		return defaultJsPath;
	}

	public void setDefaultJsPath(String defaultJsPath) {
		this.defaultJsPath = defaultJsPath;
	}

	public String getDefaultContentPath() {
		return defaultContentPath;
	}

	public void setDefaultContentPath(String defaultContentPath) {
		this.defaultContentPath = defaultContentPath;
	}

	public String getJsCssVersion() {
		return jsCssVersion;
	}

	public void setJsCssVersion(String jsCssVersion) {
		this.jsCssVersion = jsCssVersion;
	}

	public String getMixpanelToken() {
		return mixpanelToken;
	}

	public void setMixpanelToken(String mixpanelToken) {
		this.mixpanelToken = mixpanelToken;
	}

	public PlayerInfoBean getPlayerInfoBean() {
		return playerInfoBean;
	}

	public void setPlayerInfoBean(PlayerInfoBean playerInfoBean) {
		this.playerInfoBean = playerInfoBean;
	}

	public UrlTagBean getTagBean() {
		return tagBean;
	}

	public void setTagBean(UrlTagBean tagBean) {
		this.tagBean = tagBean;
	}

	public List<PortalMenuBean> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<PortalMenuBean> menuList) {
		this.menuList = menuList;
	}

	public String getCommonContentPath() {
		return commonContentPath;
	}

	public void setCommonContentPath(String commonContentPath) {
		this.commonContentPath = commonContentPath;
	}

	public String getInspectletToken() {
		return inspectletToken;
	}

	public void setInspectletToken(String inspectletToken) {
		this.inspectletToken = inspectletToken;
	}



}
