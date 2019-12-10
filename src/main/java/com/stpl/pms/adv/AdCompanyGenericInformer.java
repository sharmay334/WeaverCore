package com.stpl.pms.adv;

import org.apache.log4j.Logger;

import com.stpl.pms.exception.PMSException;
import com.stpl.pms.utility.Utility;

public abstract class AdCompanyGenericInformer {
	
	private static final Logger logger = Logger.getLogger(AdCompanyGenericInformer.class);
	
	protected abstract String fetchUrl() throws PMSException;
	protected abstract String fetchData();
	
	protected final void asyncSend(){
		logger.info("informing ad company asynchronously.");
		new Thread(this.new AsyncThread()).start();
	}
	
	protected final void send() {	
		logger.info("starting request async job process");
		String response ="";
		try{
			String url = fetchUrl();
			String data = fetchData();
			logger.info("sending request to :: "+url+"?"+data);
			response=Utility.callUrl(url, data);
		}catch(Exception e){
			logger.info(e.getMessage(), e);
		}		

		logger.info("Recieved response ::"+response);
	}
	
	class AsyncThread implements Runnable{
		@Override
		public void run() {
			send();
		}
	}
}

