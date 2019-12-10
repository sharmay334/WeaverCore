package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerLoginResponseBean extends CommonResponseBean implements
		Serializable {
	private static final long serialVersionUID = 1L;

	private String playerToken;
	private PlayerLoginInfoBean playerLoginInfo;
	private List<MenuBean> menuList;
	private Map<String,GameEngineBean> gameEngineInfo;

	public PlayerLoginResponseBean() {
	}


	public PlayerLoginResponseBean(String playerToken,
			PlayerLoginInfoBean playerLoginInfo, List<MenuBean> menuList,
			Map<String, GameEngineBean> gameEngineInfo,int errrCode, String respMsg) {
		this.playerToken = playerToken;
		this.playerLoginInfo = playerLoginInfo;
		this.menuList = menuList;
		this.gameEngineInfo = gameEngineInfo;
	}

	public String getPlayerToken() {
		return playerToken;
	}

	public void setPlayerToken(String playerToken) {
		this.playerToken = playerToken;
	}

	public PlayerLoginInfoBean getPlayerLoginInfo() {
		return playerLoginInfo;
	}

	public void setPlayerLoginInfo(PlayerLoginInfoBean playerLoginInfo) {
		this.playerLoginInfo = playerLoginInfo;
	}

	public List<MenuBean> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuBean> menuList) {
		this.menuList = menuList;
	}

	public Map<String,GameEngineBean> getGameEngineInfo() {
		return gameEngineInfo;
	}

	public void setGameEngineInfo(Map<String,GameEngineBean> gameEngineInfo) {
		this.gameEngineInfo = gameEngineInfo;
	}

}
