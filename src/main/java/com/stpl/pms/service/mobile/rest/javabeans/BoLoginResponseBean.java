package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.stpl.pms.javabeans.UserInfoBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoLoginResponseBean extends CommonResponseBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String status;
	private UserInfoBean userInfo;
	//private String oldSessionId;
	private String getTotalRegDayWiseImagePath;
	private String getTotalDepAmtDayWiseImagePath;
	private String getTotalWithDrawDayWiseImagePath;
	private String getTotalRummyWagerDayWiseImagePath;
	private String getTotalDepRequestStatusImagePath;
	private String getTotalBonusDayWiseImagePath;
	private String getRummyWagerDayWiseImagePath;
	private String getRummyWagerHourWiseImagePath;
	
	public BoLoginResponseBean()
	{
		
	}
	
	
	public BoLoginResponseBean(String status, UserInfoBean userInfo,
			 String getTotalRegDayWiseImagePath,
			String getTotalDepAmtDayWiseImagePath,
			String getTotalWithDrawDayWiseImagePath,
			String getTotalRummyWagerDayWiseImagePath,
			String getTotalDepRequestStatusImagePath,
			String getTotalBonusDayWiseImagePath,
			String getRummyWagerDayWiseImagePath,
			String getRummyWagerHourWiseImagePath) {
		this.status = status;
		this.userInfo = userInfo;
		//this.oldSessionId = oldSessionId;
		this.getTotalRegDayWiseImagePath = getTotalRegDayWiseImagePath;
		this.getTotalDepAmtDayWiseImagePath = getTotalDepAmtDayWiseImagePath;
		this.getTotalWithDrawDayWiseImagePath = getTotalWithDrawDayWiseImagePath;
		this.getTotalRummyWagerDayWiseImagePath = getTotalRummyWagerDayWiseImagePath;
		this.getTotalDepRequestStatusImagePath = getTotalDepRequestStatusImagePath;
		this.getTotalBonusDayWiseImagePath = getTotalBonusDayWiseImagePath;
		this.getRummyWagerDayWiseImagePath = getRummyWagerDayWiseImagePath;
		this.getRummyWagerHourWiseImagePath = getRummyWagerHourWiseImagePath;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserInfoBean getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoBean userInfo) {
		this.userInfo = userInfo;
	}

	/*public String getOldSessionId() {
		return oldSessionId;
	}

	public void setOldSessionId(String oldSessionId) {
		this.oldSessionId = oldSessionId;
	}*/

	public String getGetTotalRegDayWiseImagePath() {
		return getTotalRegDayWiseImagePath;
	}

	public void setGetTotalRegDayWiseImagePath(String getTotalRegDayWiseImagePath) {
		this.getTotalRegDayWiseImagePath = getTotalRegDayWiseImagePath;
	}

	public String getGetTotalDepAmtDayWiseImagePath() {
		return getTotalDepAmtDayWiseImagePath;
	}

	public void setGetTotalDepAmtDayWiseImagePath(
			String getTotalDepAmtDayWiseImagePath) {
		this.getTotalDepAmtDayWiseImagePath = getTotalDepAmtDayWiseImagePath;
	}

	public String getGetTotalWithDrawDayWiseImagePath() {
		return getTotalWithDrawDayWiseImagePath;
	}

	public void setGetTotalWithDrawDayWiseImagePath(
			String getTotalWithDrawDayWiseImagePath) {
		this.getTotalWithDrawDayWiseImagePath = getTotalWithDrawDayWiseImagePath;
	}

	public String getGetTotalRummyWagerDayWiseImagePath() {
		return getTotalRummyWagerDayWiseImagePath;
	}

	public void setGetTotalRummyWagerDayWiseImagePath(
			String getTotalRummyWagerDayWiseImagePath) {
		this.getTotalRummyWagerDayWiseImagePath = getTotalRummyWagerDayWiseImagePath;
	}

	public String getGetTotalDepRequestStatusImagePath() {
		return getTotalDepRequestStatusImagePath;
	}

	public void setGetTotalDepRequestStatusImagePath(
			String getTotalDepRequestStatusImagePath) {
		this.getTotalDepRequestStatusImagePath = getTotalDepRequestStatusImagePath;
	}

	public String getGetTotalBonusDayWiseImagePath() {
		return getTotalBonusDayWiseImagePath;
	}

	public void setGetTotalBonusDayWiseImagePath(
			String getTotalBonusDayWiseImagePath) {
		this.getTotalBonusDayWiseImagePath = getTotalBonusDayWiseImagePath;
	}

	public String getGetRummyWagerDayWiseImagePath() {
		return getRummyWagerDayWiseImagePath;
	}

	public void setGetRummyWagerDayWiseImagePath(
			String getRummyWagerDayWiseImagePath) {
		this.getRummyWagerDayWiseImagePath = getRummyWagerDayWiseImagePath;
	}

	public String getGetRummyWagerHourWiseImagePath() {
		return getRummyWagerHourWiseImagePath;
	}

	public void setGetRummyWagerHourWiseImagePath(
			String getRummyWagerHourWiseImagePath) {
		this.getRummyWagerHourWiseImagePath = getRummyWagerHourWiseImagePath;
	}
	
	
}
