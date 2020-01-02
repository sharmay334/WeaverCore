package com.stpl.pms.controller.comm;

import com.stpl.pms.javabeans.UserDetailsBean;


public class  CommMgmtSmsController extends Thread {

	private UserDetailsBean userDetailsBean;
	private String smsType;
	private String userName;
	private String password;
	private String smsContent;
	
	public CommMgmtSmsController(){
		
	}
	public CommMgmtSmsController(UserDetailsBean userDetailbean, String smsType, String providerKey, String providerPass,
			String smsContent) {
		// TODO Auto-generated constructor stub
		this.userDetailsBean = userDetailbean;
		this.smsType = smsType;
		this.userName = providerKey;
		this.password = providerPass;
		this.smsContent = smsContent;

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		smsSending();
		
		
		
	}
	private void smsSending() {}
	public UserDetailsBean getUserDetailsBean() {
		return userDetailsBean;
	}
	public void setUserDetailsBean(UserDetailsBean userDetailsBean) {
		this.userDetailsBean = userDetailsBean;
	}
	public String getSmsType() {
		return smsType;
	}
	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSmsContent() {
		return smsContent;
	}
	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
	
}
