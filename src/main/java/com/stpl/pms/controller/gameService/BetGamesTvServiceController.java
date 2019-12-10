package com.stpl.pms.controller.gameService;

import java.util.Calendar;

import com.stpl.pms.javabeans.BetGamesTokenBean;
import com.stpl.pms.utility.Utility;


public class BetGamesTvServiceController {

	public void betGamesServiceLogin(String tokenString, long playerId,
			String sessionId) {
		BetGamesTokenBean tokenBean = new BetGamesTokenBean(Calendar
				.getInstance().getTimeInMillis(), sessionId, tokenString);
		Utility.betGamesTokenMap.put(tokenString, tokenBean);
	}

}
