package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerInboxResponseBean extends CommonResponseBean implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private List<PlayerInboxBean> plrInboxList;
	private PlayerInboxBean inboxBean;

	public List<PlayerInboxBean> getPlrInboxList() {
		return plrInboxList;
	}

	public void setPlrInboxList(List<PlayerInboxBean> plrInboxList) {
		this.plrInboxList = plrInboxList;
	}

	public PlayerInboxBean getInboxBean() {
		return inboxBean;
	}

	public void setInboxBean(PlayerInboxBean inboxBean) {
		this.inboxBean = inboxBean;
	}
}
