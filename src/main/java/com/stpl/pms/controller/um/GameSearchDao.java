package com.stpl.pms.controller.um;

import com.stpl.pms.daoImpl.um.GameSearchDaoimpl;

public class GameSearchDao {

	GameSearchDaoimpl gameSearchDaoimpl;
	
	public void gameSearch(int gameNO,String userName,String gameName,int ticket_Price )
	{
		gameSearchDaoimpl.getGameSearchResult(gameNO,userName,gameName,ticket_Price);
	}
	
}
