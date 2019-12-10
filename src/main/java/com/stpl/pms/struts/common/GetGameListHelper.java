package com.stpl.pms.struts.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

import org.apache.commons.digester.Digester;
import org.apache.log4j.Logger;

import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.StRmServiceVendorProperties;
import com.stpl.pms.javabeans.GameLobbyMasterBean;
import com.stpl.pms.javabeans.GameLobbyResponseBean;
import com.stpl.pms.utility.Utility;

public class GetGameListHelper {
	private static final Logger log = Logger.getLogger(GetGameListHelper.class);

	public static GameLobbyMasterBean getGameList(StRmServiceVendorProperties stRmServiceVendorProperties,
			String domainName)throws PMSException {
		String gameUrl = null;
		String parameters = null;
		GameLobbyMasterBean gameLobbyResponseBean = null;
		StringTokenizer token = null;
		StringBuffer buffer = new StringBuffer();
		try {
				gameUrl = stRmServiceVendorProperties.getStRmVendorMaster().getVendorDomainName()+stRmServiceVendorProperties.getPropertyValue();
				parameters = stRmServiceVendorProperties.getUrlParameter();
				token = new StringTokenizer(parameters, ","); 
				buffer.append(token.nextToken()
						+ "="+ stRmServiceVendorProperties.getStRmVendorMaster()
							.getVendorKey() + "&");
				buffer.append(token.nextToken() + "=" + domainName + "&");
				buffer.append(token.nextToken()
					+ "="+ stRmServiceVendorProperties.getStRmVendorMaster().getVendorPassword());
				String responseUrl = Utility.callUrl(gameUrl, buffer.toString());
				gameLobbyResponseBean = readGameLobbyResponse(new ByteArrayInputStream(responseUrl
								.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gameLobbyResponseBean;
	}

	public static String httpPostRequestGet(String gameUrl, String parameter) {
		URL url;
		StringBuilder responseString = new StringBuilder();
		HttpURLConnection connection = null;
		try {
			log.info("gameListURL:- " + gameUrl + "?" + parameter);

			url = new URL(gameUrl + "?" + parameter);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String str = null;
			while ((str = rd.readLine()) != null) {
				responseString.append(str);
			}
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Error in Payment");
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		log.info("Payment response:- " + responseString);
		return responseString.toString();
	}
	public static  GameLobbyMasterBean readGameLobbyResponse(InputStream stream) throws Exception
	{
		
		Digester digester=new Digester();
		digester.addObjectCreate("games",GameLobbyMasterBean.class);
		digester.addObjectCreate("games/game",GameLobbyResponseBean.class);
		digester.addBeanPropertySetter("games/game/gameNumber","gameNumber");
		digester.addBeanPropertySetter("games/game/gameName","gameName");
		digester.addBeanPropertySetter("games/game/gameImageLocations/imagePath","gameImageLocations");
		digester.addBeanPropertySetter("games/game/gamePrice","gamePrice");
		digester.addBeanPropertySetter("games/game/currencyCode","currencyCode");
		digester.addBeanPropertySetter("games/game/gameDescription","gameDescription");
		digester.addBeanPropertySetter("games/game/gameCategory","gameCategory");
		digester.addBeanPropertySetter("games/game/windowHeight","windowHeight");
		digester.addBeanPropertySetter("games/game/windowWidth","windowWidth");
		digester.addBeanPropertySetter("games/game/isFlash","isFlash");
		digester.addBeanPropertySetter("games/game/isHtml5","isHtml5");
		digester.addSetNext("games/game","setGameMaster");
		GameLobbyMasterBean response = (GameLobbyMasterBean)digester.parse(stream);
		return response;
	}
}
