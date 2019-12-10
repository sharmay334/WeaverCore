package com.stpl.pms.service.mobile.rest.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.stpl.pms.service.mobile.rest.javabeans.AppsFlyerAndroidActivityBean;
import com.stpl.pms.service.mobile.rest.javabeans.AppsFlyerIosActivityBean;

public class AppsFlyerDaoImpl {

	private static final Logger logger = Logger
			.getLogger(AppsFlyerDaoImpl.class);
	
	public void setAppsFlyerIosData(AppsFlyerIosActivityBean appsFlyerIosActivityBean, Session session) {
		logger.info("---Apps flyer IOS device entrance----");
		session.save(appsFlyerIosActivityBean);
		logger.info("---Apps flyer IOS device saved----");
	}
	
	public void setAppsFlyerAndroidData(AppsFlyerAndroidActivityBean appsFlyerAndroidActivityBean, Session session) {
		logger.info("---Apps flyer Android device entrance----");
		session.save(appsFlyerAndroidActivityBean);
		logger.info("---Apps flyer Android device saved----");
	}
}
