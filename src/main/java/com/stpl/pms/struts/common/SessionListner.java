package com.stpl.pms.struts.common;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SessionListner implements HttpSessionListener {

	private static final Logger log=Logger.getLogger(SessionListner.class);
	public void sessionCreated(HttpSessionEvent se) {
			log.info("session created");
//			callAPI(se.getSession());
	}

	
	public void sessionDestroyed(HttpSessionEvent se) {
		log.info("BO USER  Session Destroyed");

	}

	
}
