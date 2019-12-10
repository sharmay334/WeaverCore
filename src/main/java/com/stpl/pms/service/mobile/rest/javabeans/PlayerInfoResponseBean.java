package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerInfoResponseBean extends CommonResponseBean implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private PlrInfoBean playerInfoBean;
	private boolean isProfileUpdate;

	public PlrInfoBean getPlayerInfoBean() {
		return playerInfoBean;
	}

	public void setPlayerInfoBean(PlrInfoBean playerInfoBean) {
		this.playerInfoBean = playerInfoBean;
	}

	public void setProfileUpdate(boolean isProfileUpdate) {
		this.isProfileUpdate = isProfileUpdate;
	}

	public boolean isProfileUpdate() {
		return isProfileUpdate;
	}

}
