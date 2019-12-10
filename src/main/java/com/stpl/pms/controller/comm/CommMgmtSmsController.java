package com.stpl.pms.controller.comm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.stpl.pms.javabeans.UserDetailsBean;
import com.stpl.pms.security.ZipFileProtection;

import rng.RNGUtilities;

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
	private void smsSending() {
		// TODO Auto-generated method stub
		System.out.println(":::::::::::::::SMS SENDING:::::::::::::::::::");
		try{
			
			URL url = new URL("http://124.158.14.49/CMCTelecom/api/sms/send?");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setReadTimeout(3000);
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("charset", "utf-8");
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			int msgId =RNGUtilities.generateRandomNumber(100,9999999);
			String urlStr = "phoneNumber="+userDetailsBean.getPhoneNbr()+"&message="+smsContent+"&brandName=TECHPRO.VN&messageId="+msgId+"&user="+userName+"&pass="+password+"";
			wr.write(urlStr);
			
			wr.flush();
			InputStream iStream = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String deliveryMsg = sb.toString();
			System.out.println("SMS TYPE:::::::::::::"+smsType);
			System.out.println(":::::MSG URL::::::    "+urlStr);
			System.out.println(":::::MSG SENT SUCCESSFULLY ->>>"+deliveryMsg);
			
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
		}
	}
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
