package com.stpl.pms.controller.gameService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.stpl.pms.daoImpl.gameService.GameServiceDaoImpl;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.StRmServiceVendorProperties;
import com.stpl.pms.javabeans.VendorGameLobbybean;
import com.stpl.pms.javabeans.VendorInfoBean;
import com.stpl.pms.utility.Utility;

public class GameServiceController {
	private static Logger log = Logger.getLogger(GameServiceController.class);
	
	public VendorInfoBean fetchVendorInfo(String vendorName) throws PMSException {
		VendorInfoBean vendorInfo = new VendorInfoBean();
		Session session = null;
		GameServiceDaoImpl daoImpl = new GameServiceDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			vendorInfo = daoImpl.fetchVendorInfo(vendorName, session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Vendor Info has some problem");
		}finally{
			if (session!=null && session.isOpen()) {
				session.close();
			}
		}
		return vendorInfo;
	}
	
	public String fetchExternalVendorPropertyUrl(String vendorName, long playerId, String sessionId, String aliasName, String deepLink, String isPlay2x) throws PMSException{
		log.info("--External Lobby--");
		Session session = null;
		String url = null;
		try {
			GameServiceDaoImpl daoImpl = new GameServiceDaoImpl();
			session = HibernateSessionFactory.getSession();
			VendorInfoBean vendorInfo = daoImpl.fetchVendorInfo("YES".equals(isPlay2x)?"Rummy_2X":vendorName, session);
			url = vendorInfo.getVendorDomainName();
			url += daoImpl.fetchVendorPropertyUrl(vendorInfo.getVendorId(), "service_url", session);
			if("External".equals(vendorInfo.getVendorLobbyType())){
				url = updateExternalVendorUrl(vendorInfo, url, playerId, sessionId,aliasName,deepLink);
			}else{
				throw new PMSException("Vendor Is not External Type");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Vendor Info has some problem");
		}finally{
			if (session!=null && session.isOpen()) {
				session.close();
			}
		}
		return url;
	}
	
	public String fetchVendorPropertyUrl(VendorInfoBean vendorInfo,String propertyKey) throws PMSException{
		Session session = null;
		String url = null;
		try {
			session = HibernateSessionFactory.getSession();
			url = vendorInfo.getVendorDomainName();
			url += new GameServiceDaoImpl().fetchVendorPropertyUrl(vendorInfo.getVendorId(), propertyKey, session);
			if("External".equals(vendorInfo.getVendorLobbyType())){
				throw new PMSException("Vendor Is not Internal Type");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Vendor Info has some problem");
		}finally{
			if (session!=null && session.isOpen()) {
				session.close();
			}
		}
		return url;
	}

	private String updateExternalVendorUrl(VendorInfoBean vendorInfo,String url,
			long playerId, String sessionId,String aliasName, String deepLink) {
		String redirectUrl = null;
		try {
			Integer merchantKey = vendorInfo.getVendorKey();
			String secertKeys = vendorInfo.getVendorPassword();
			if ("rummy".equalsIgnoreCase(vendorInfo.getVendorName()) || "poker".equalsIgnoreCase(vendorInfo.getVendorName()) || "Rummy_2X".equalsIgnoreCase(vendorInfo.getVendorName())) {
				StringBuffer buffer = new StringBuffer(url);
				buffer.append("?paramString=");
				if(deepLink != null)
					buffer.append(URLEncoder.encode(Utility.encodeString(merchantKey+"$"+secertKeys+"$"+(playerId!=0)+"$"+aliasName+"$"+sessionId+"$"+deepLink),"UTF-8"));
				else
					buffer.append(URLEncoder.encode(Utility.encodeString(merchantKey+"$"+secertKeys+"$"+(playerId!=0)+"$"+aliasName+"$"+sessionId),"UTF-8"));
				redirectUrl = buffer.toString();
			} else if("BINGO".equalsIgnoreCase(vendorInfo.getVendorName())){
				redirectUrl = redirectUrl+"/"+merchantKey+"/"+playerId+"/"+vendorInfo.getVendorId()+"/"+sessionId;
			} else if ("instantdraw".equalsIgnoreCase(vendorInfo.getVendorName())) {
				redirectUrl =  vendorInfo.getVendorDomainName();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return redirectUrl;
	}

	public String getBOServiceRedirectUrl(String serviceName) {
		String url = "";
		Session session = null;
		GameServiceDaoImpl daoImpl = new GameServiceDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			StRmServiceVendorProperties serviceVendorProperties = daoImpl
					.getBOServiceRedirectUrl(serviceName, session);
			String urlParameter[] = serviceVendorProperties.getUrlParameter()
					.split(",");
			url = serviceVendorProperties.getPropertyValue();
			url = url + "?" + urlParameter[0] + "="
					+ serviceVendorProperties.getId();
			url = url + "&" + urlParameter[1] + "="
					+ serviceVendorProperties.getPropertyKey();
			url = url + "&" + urlParameter[2] + "=";

		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return url;
	}
	
	public List<VendorGameLobbybean>  fetchCasinoThemeMap(short domainId,String device) throws PMSException {
		Session session = null;
		GameServiceDaoImpl daoImpl = new GameServiceDaoImpl();
		List<VendorGameLobbybean> themeList;
		try{
			session = HibernateSessionFactory.getSession();
			themeList = daoImpl.fatchCasinoThemeMap(domainId,device,session);
		}catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("themeMap occure problem");
		}finally{
			if (session!=null && session.isOpen()) {
				session.close();
			}
		}
		return themeList;
	}
	
	public VendorGameLobbybean  fetchCasinoGameDetail(short domainId,String gameNumber) throws PMSException {
		Session session = null;
		GameServiceDaoImpl daoImpl = new GameServiceDaoImpl();
		VendorGameLobbybean bean;
		try{
			session = HibernateSessionFactory.getSession();
			bean = daoImpl.fetchCasinoGameDetail(domainId, gameNumber, session);
		}catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("themeMap occure problem");
		}finally{
			if (session!=null && session.isOpen()) {
				session.close();
			}
		}
		return bean;
	}
}
