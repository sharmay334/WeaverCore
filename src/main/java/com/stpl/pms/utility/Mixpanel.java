package com.stpl.pms.utility;

import java.util.HashMap;

import org.json.JSONObject;

import com.mixpanel.mixpanelapi.ClientDelivery;
import com.mixpanel.mixpanelapi.MessageBuilder;
import com.mixpanel.mixpanelapi.MixpanelAPI;


public class Mixpanel implements Runnable {
	
	private  HashMap<String, Object> profileProperties=null; 
	private MessageBuilder messageBuilder=null;
	private String eventName;
	private String distinctId;
	private HashMap<String, Object> eventProperties;
	private HashMap<String,Long> incrementProperties;
	private  HashMap<String, Object> setOnceProperties=null;
	
	
	public Mixpanel(String tokenId,String eventName,String distinctId,HashMap<String,Long> incrementProperties,  HashMap<String, Object> setOnceProperties,HashMap<String, Object> eventProperties,HashMap<String, Object> profileProperties){
		
		
		 messageBuilder =new MessageBuilder(tokenId);
		 this.eventName=eventName;
		 this.distinctId=distinctId;
		 this.eventProperties=eventProperties;
		 this.profileProperties=profileProperties;		
		 this.incrementProperties=incrementProperties;
		 this.setOnceProperties=setOnceProperties;
	}
	
	public void run() {
		toStoreEventPropertiesProfileUpdate();		
	}
	
	public  void toStoreEventPropertiesProfileUpdate() {
		
		JSONObject update=null;
		JSONObject props=null;
		JSONObject planEvent =null;
		boolean flag =false;
			try{
				
				
				ClientDelivery delivery = new ClientDelivery();							
				
				if(eventProperties!=null){
					flag=true;
					props = new JSONObject(eventProperties);		
					planEvent = messageBuilder.event(distinctId, eventName, props);
					delivery.addMessage(planEvent);
				}
				
				
				if(profileProperties!=null){
					flag=true;
					JSONObject profileProps = new JSONObject(profileProperties);
					update = messageBuilder.set(distinctId, profileProps);
					delivery.addMessage(update);
				}
				
				if(incrementProperties!=null){
					flag=true;
					JSONObject incrementData = messageBuilder.increment(distinctId, incrementProperties);
					delivery.addMessage(incrementData);	
					
				}
				
				if(setOnceProperties!=null){
					flag=true;
					JSONObject onceProperties = new JSONObject(setOnceProperties);
					update = messageBuilder.setOnce(distinctId, onceProperties,null);
					delivery.addMessage(update);
					
				}
				
				if(flag){
					MixpanelAPI mixpanel = new MixpanelAPI();					
					mixpanel.deliver(delivery);
					
				}
				
		}catch (Exception e) {
			e.printStackTrace();
			
		}		
			
	}		
	
}
