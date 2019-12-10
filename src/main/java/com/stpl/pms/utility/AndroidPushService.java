package com.stpl.pms.utility;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.json.JSONObject;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Message.Builder;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.exception.PMSException;

public class AndroidPushService extends Thread{

	private static final Logger logger = Logger.getLogger(AndroidPushService.class);
	private String senderId; /*= "AIzaSyCEQjRKxSyTtltQzG47GtYzwmS4tSxhne8";*/
	private String gcmId;
	private Map<String, String> messageData;
	private List<String> gcmIdArr;
	public AndroidPushService(String senderId,List<String> gcmIdList, Map<String, String> gcmData) {
		this.gcmIdArr = gcmIdList;
		this.messageData = gcmData;
		this.senderId=senderId;
	}

	public String getGcmId() {
		return gcmId;
	}

	public void setGcmId(String gcmId) {
		this.gcmId = gcmId;
	}

	public Map<String, String> getMessageData() {
		return messageData;
	}

	public void setMessageData(Map<String, String> messageData) {
		this.messageData = messageData;
	}

	public List<String> getGcmIdArr() {
		return gcmIdArr;
	}

	public void setGcmIdArr(List<String> gcmIdArr) {
		this.gcmIdArr = gcmIdArr;
	}
	
	public static void callSendGCM(short aliasId,List<String> deviceIdlist,Map<String, String> messageData,Session session) throws PMSException {
		CommonMethodDaoImpl comDao= CommonMethodDaoImpl.getInstance();
		if("Y".equals(comDao.fetchSystemProperties("SYSTEM_SEND_NOTIFICATION",session))){
			new AndroidPushService(comDao.fetchAliasProperty("ANDROID_SENDER_ID", aliasId, session),deviceIdlist, messageData).start();
		}
	}

	@Override
	public void run() {
		sendGCMToUsers();
	}
	
	private void sendGCMToUsers() {

		try {
			Sender sender = new Sender(senderId);
			System.out.println(sender.toString());
			Builder builder=null;
			JSONObject obj =new JSONObject(messageData)	;
			 builder = new Message.Builder().collapseKey("hai").timeToLive(30).delayWhileIdle(true).addData("message", obj.toString());
			Message message = builder.build();
			MulticastResult result = sender.send(message, gcmIdArr, 1);
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}


}
