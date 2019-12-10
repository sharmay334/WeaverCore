package com.stpl.pms.utility;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class VCommissionThread implements Callable<String>{
	private static final Logger logger = Logger.getLogger(VCommissionThread.class);
	private String txnId;
	private Long playerId;
	private String url;
	
	
	
	public VCommissionThread(String txnId, Long playerId, String url) {
		super();
		this.txnId = txnId;
		this.playerId = playerId;
		this.url = url;
	}



	@Override
	public String call() throws Exception {		
		String response ="";
		try{
			StringBuffer sb =new StringBuffer();
			sb.append("adv_sub=");
			sb.append(playerId);
			sb.append("&transaction_id=");
			sb.append(txnId);			
			response=Utility.callUrl(url, sb.toString());
			
							
			
		}catch(Exception e){
			logger.info(e.getMessage(), e);
		}		
		
		return response;
	}
	
	
	public static void submitVCommissionRequest(String url, Long playerId, String txnId ){
		
		
		try{
			VCommissionThread vCommissionObj=new VCommissionThread(txnId, playerId, url);
			
			Future<String> response=ThreadPoolService.getInstance().submit(vCommissionObj);
			
			logger.info("----------VCommissionResponse--Start-----"+url+"------"+playerId+"---------");
			logger.info(response.get(5l ,TimeUnit.SECONDS));
			logger.info("----------VCommissionResponse--END--------"+url+"------"+playerId+"------");
		}catch (Exception e) {
			logger.info(e.getMessage(), e);
		}
		
		
	}
	
	
	
	

}
