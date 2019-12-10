package com.stpl.pms.controller.pm;

import com.stpl.pms.daoImpl.pm.SocialPlayerMgmtDaoImpl;
import com.stpl.pms.hibernate.mapping.StPmSocialLoginMapping;
import com.stpl.pms.utility.Constants.SOCIAL_TYPE;

public class SocialPlayerMgmtController {
	
	public static void doSocialMapping(Long playerId,String token,String socialId,SOCIAL_TYPE provider){
		StPmSocialLoginMapping socialMap = new StPmSocialLoginMapping(playerId, token,
				socialId, provider.toString());
		SocialPlayerMgmtDaoImpl daoImpl = new SocialPlayerMgmtDaoImpl();
		daoImpl.saveSocialMapping(socialMap);
	}
	
}
