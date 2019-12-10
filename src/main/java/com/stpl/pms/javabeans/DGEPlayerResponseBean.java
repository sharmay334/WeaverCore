package com.stpl.pms.javabeans;

import java.io.Serializable;

public class DGEPlayerResponseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String token;
	private DGEPlayerDetailBean playerInfo;
	private PlrWalletinfoBean playerWalletInfo;

	private Integer errorCode;
	private String errorMsg;

	public DGEPlayerResponseBean(String token, DGEPlayerDetailBean playerInfo,
			PlrWalletinfoBean playerWalletInfo) {
		this.token = token;
		this.playerInfo = playerInfo;
		this.playerWalletInfo = playerWalletInfo;
	}

	public DGEPlayerResponseBean() {
	}

	public DGEPlayerDetailBean getPlayerInfo() {
		return playerInfo;
	}

	public void setPlayerInfo(DGEPlayerDetailBean playerInfo) {
		this.playerInfo = playerInfo;
	}

	public PlrWalletinfoBean getPlayerWalletInfo() {
		return playerWalletInfo;
	}

	public void setPlayerWalletInfo(PlrWalletinfoBean playerWalletInfo) {
		this.playerWalletInfo = playerWalletInfo;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
