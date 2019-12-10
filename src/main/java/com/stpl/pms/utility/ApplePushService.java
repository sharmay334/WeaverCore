package com.stpl.pms.utility;

import java.net.URL;
import java.util.Collection;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.json.JSONObject;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.exception.PMSException;

public class ApplePushService extends Thread{
	
	private static final Logger logger = Logger.getLogger(ApplePushService.class);
	private String apple_Password;
	private String apple_ck_P12_Path;
	private Collection<String> token;
	private String deeplink;
	private String message;
	private ApnsService pushService;
	
	public ApplePushService(String path,String password,Collection<String> token,String deeplink,String message){
		this.token=token;
		this.deeplink=deeplink;
		this.message=message;
		URL certUrl= Thread.currentThread().getContextClassLoader().getResource(path);
		this.apple_ck_P12_Path=certUrl.toString().contains("vfs:")?Utility.vfsToRealPath(certUrl):certUrl.getPath();
		this.apple_Password=password;
		pushService= APNS.newService()
				.withCert(apple_ck_P12_Path , apple_Password)
				.withProductionDestination()
				.build();
		}
		
	public static void callApplePushService(short aliasId,Set<String> deviceIdSet,String deeplink,String message,Session session) throws PMSException {
		CommonMethodDaoImpl comDao=CommonMethodDaoImpl.getInstance();
		if("Y".equals(comDao.fetchSystemProperties("SYSTEM_SEND_NOTIFICATION",session))){
			ApplePushService sendAPSN =new  ApplePushService(comDao.fetchAliasProperty("APNS_CERT_PATH", aliasId, session),
					comDao.fetchAliasProperty("APNS_CERT_PASSWORD", aliasId, session),
					deviceIdSet,deeplink,message);
				sendAPSN.start();					
			}
		}
		
		@Override
		public void run() {
			sendNotify();
		}
		
		public void sendNotify() {
			logger.info("-------------Notification Send to iOS Start----------");			
				try{
					String payload = APNS.newPayload().alertBody(message).build();
					JSONObject obj=new JSONObject(payload);
					JSONObject obj1=(JSONObject) obj.get("aps");
					obj1.put("sound", "default");
					obj.put("deeplink",deeplink);
					
			        
			        pushService.push(token, obj.toString());
			        logger.info("-------------Notification Send to iOS End----------");			
				} catch (Exception e) {
					e.printStackTrace();
			logger.info("-------------Notification Send to iOS terminated----------");
				}
		}
}
