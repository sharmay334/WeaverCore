package com.stpl.pms.daoImpl.pm;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.StPmSocialLoginMapping;

public class SocialPlayerMgmtDaoImpl {
	
	public void saveSocialMapping(StPmSocialLoginMapping loginMapping){
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(StPmSocialLoginMapping.class);
		criteria.add(Restrictions.eq("playerId", loginMapping.getPlayerId()));
		StPmSocialLoginMapping existing = (StPmSocialLoginMapping) criteria.uniqueResult();
		if(existing == null){
			session.save(loginMapping);
		}
	}
}
