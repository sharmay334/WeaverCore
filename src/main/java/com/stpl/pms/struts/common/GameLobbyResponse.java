package com.stpl.pms.struts.common;

import java.io.InputStream;

import org.apache.commons.digester.Digester;

import com.stpl.pms.javabeans.GameLobbyMasterBean;
import com.stpl.pms.javabeans.GameLobbyResponseBean;

public class GameLobbyResponse {
		public static GameLobbyMasterBean readGameLobbyResponse(InputStream stream) throws Exception
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



