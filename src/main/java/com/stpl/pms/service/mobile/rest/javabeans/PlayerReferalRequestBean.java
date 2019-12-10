package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.util.List;

public class PlayerReferalRequestBean extends CommonRequestBean implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private List<PlayerReferalInfoBean> referalList;
	private String inviteMode;
	
	public PlayerReferalRequestBean() {
	}
	
	public void setReferalList(List<PlayerReferalInfoBean> referalList) {
		this.referalList = referalList;
	}
	public List<PlayerReferalInfoBean> getReferalList() {
		return referalList;
	}

	public String getInviteMode() {
		return inviteMode;
	}

	public void setInviteMode(String inviteMode) {
		this.inviteMode = inviteMode;
	}

}
