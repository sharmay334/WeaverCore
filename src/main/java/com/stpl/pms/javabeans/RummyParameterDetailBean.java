package com.stpl.pms.javabeans;

import java.io.Serializable;

public class RummyParameterDetailBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private RummyPlayerInfoBean playerInfo;
	private RummyCashierDetailBean cashierDetail;
	private RummyPlaceHolderBean rummyPlaceHolders;

	public RummyParameterDetailBean(RummyPlayerInfoBean playerInfo,
			RummyCashierDetailBean cashierDetail,
			RummyPlaceHolderBean placeHolder) {
		super();
		this.playerInfo = playerInfo;
		this.cashierDetail = cashierDetail;
		this.rummyPlaceHolders = placeHolder;
	}

	public RummyPlayerInfoBean getPlayerInfo() {
		return playerInfo;
	}

	public void setPlayerInfo(RummyPlayerInfoBean playerInfo) {
		this.playerInfo = playerInfo;
	}

	public RummyCashierDetailBean getCashierDetail() {
		return cashierDetail;
	}

	public void setCashierDetail(RummyCashierDetailBean cashierDetail) {
		this.cashierDetail = cashierDetail;
	}

	public RummyPlaceHolderBean getRummyPlaceHolders() {
		return rummyPlaceHolders;
	}

	public void setRummyPlaceHolders(RummyPlaceHolderBean rummyPlaceHolders) {
		this.rummyPlaceHolders = rummyPlaceHolders;
	}

}
