package com.stpl.pms.utility;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Message.Builder;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.exception.PMSException;

public class SendGCM extends Thread {

	private static final Logger logger = Logger.getLogger(SendGCM.class);
	private static final String SENDER_ID = "AIzaSyAD_fyAnoN_lkvplWhYyDQeRZf1DfHi1N0";
	 /*private static final String DEVICE_ID =
	 "APA91bGsf__KU1aXhUk73rf5cFkeEW1MukB1XwsCCMEJLmpc7SK54lp8uyYrTN4kfvus1fx9zrM-3CL1dwwLsFNGxtd9HjFnaqzTIreDkcoSGD8JRiAhRJMI3PtSg7EpfjTIX7E8tNEj";*/

	private String gcmId;
	private Map<String, String> messageData;
	private List<String> gcmIdArr;

	public SendGCM() {

	}

	public SendGCM(String gcmIdNo, Map<String, String> gcmData) {
		this.gcmId = gcmIdNo;
		this.messageData = gcmData;
		//sendGCMToUsers(gcmIdNo,gcmData);
	}

	public SendGCM(List<String> gcmIdList, Map<String, String> gcmData) {
		this.gcmIdArr = gcmIdList;
		this.messageData = gcmData;

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
	
	/*public static void main(String[] args) throws IOException {
		String msg = "Welcome to Khelplay Rummy :Your account has been created successfully, "
				+ "and Your Deposit Request of Amt:100 has been initiated with "
				+ "PlrName:Shobhit and "
				+ "RefCode:1240,please visit the cashier page at khelplayrummy.com to confirm deposit";
		Map<String, String> messageData = new HashMap<String, String>();
		messageData.put("message", msg);
		messageData.put("title", "Welcome");
		sendGCMToUsers(DEVICE_ID, messageData);

	}*/

	@Override
	public void run() {
		sendGCMToUsers(gcmId,messageData);
	}
	
	public static void callSendGCM(String gcmId, Map<String, String> messageData,Session session) throws PMSException {
		if("Y".equals(CommonMethodDaoImpl.getInstance().fetchSystemProperties("SYSTEM_SEND_NOTIFICATION",session))){
			SendGCM sendGCM = new SendGCM(gcmId,messageData);
			sendGCM.start();
		}
	}
	
	private static String sendGCMToUsers(String gcmId, Map<String, String> messageData) {

		// Instance of com.android.gcm.server.Sender, that does the
		// transmission of a Message to the Google Cloud Messaging service.
		try {
			Sender sender = new Sender(SENDER_ID);

			System.out.println(sender.toString());
			// This Message object will hold the data that is being transmitted
			// to the Android client devices. For this demo, it is a simple text
			// string, but could certainly be a JSON object.

			Builder builder = new Message.Builder().collapseKey("hai")
					.timeToLive(30).delayWhileIdle(true);
			for (Map.Entry<String, String> data : messageData.entrySet()) {
				builder.addData(data.getKey(), data.getValue());
			}
			Message message = builder.build();

			/*
			 * Message message = new
			 * Message.Builder().collapseKey("").timeToLive
			 * (30).delayWhileIdle(true) .addData("message",
			 * "").addData("title", "") .build();
			 */

			// use this for multicast messages. The second parameter
			// of sender.send() will need to be an array of register ids.

			Result result = sender.send(message, gcmId, 1);
			logger.info(result);

			// MulticastResult result = sender.send(message, "egf", 1);
			/*
			 * if (result.getErrorCodeName() != null) { String canonicalRegId =
			 * result.toString()
			 * 
			 * } else { String error = result.getErrorCodeName();
			 * logger.info("Broadcast failure: " + error); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/*
	 * private static String sendBroadCastGCMToUsers(List<String> gcmIdArr,
	 * Map<String, String> messageData) {
	 * 
	 * // Instance of com.android.gcm.server.Sender, that does the //
	 * transmission of a Message to the Google Cloud Messaging service. Sender
	 * sender = new Sender(SENDER_ID);
	 * 
	 * // This Message object will hold the data that is being transmitted // to
	 * the Android client devices. For this demo, it is a simple text // string,
	 * but could certainly be a JSON object.
	 * 
	 * Builder builder = new Message.Builder().collapseKey("dregfdegv")
	 * .timeToLive(30).delayWhileIdle(true); for (Map.Entry<String, String> data
	 * : messageData.entrySet()) { builder.addData(data.getKey(),
	 * data.getValue()); } Message message = builder.build();
	 * 
	 * 
	 * Message message = new
	 * Message.Builder().collapseKey("").timeToLive(30).delayWhileIdle(true)
	 * .addData("message", "").addData("title", "") .build();
	 * 
	 * 
	 * try { // use this for multicast messages. The second parameter // of
	 * sender.send() will need to be an array of register ids.
	 * 
	 * Result result = sender.send(message, DEVICE_ID, 1);
	 * 
	 * // MulticastResult result = sender.send(message, "egf", 1);
	 * 
	 * if (result.getErrorCodeName() != null) { String canonicalRegId =
	 * result.toString()
	 * 
	 * } else { String error = result.getErrorCodeName();
	 * logger.info("Broadcast failure: " + error); }
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return null;
	 * 
	 * }
	 */

	/*
	 * public void run() {
	 * 
	 * try { System.out.println("Message" + gcmId); if (gcmId != null) { //
	 * System.out.println("Msg Length"+message.length()); String deliveryMsg =
	 * sendGCMToUsers(gcmId, messageData); System.out.println("Delivery Msg :" +
	 * deliveryMsg); } else if (gcmIdArr.size() > 0) { //
	 * System.out.println("Msg Length"+message.length()); // String deliveryMsg
	 * = sendBroadCastGCMToUsers(gcmIdArr, // messageData); //
	 * System.out.println("Delivery Msg :"+deliveryMsg); }
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
}
