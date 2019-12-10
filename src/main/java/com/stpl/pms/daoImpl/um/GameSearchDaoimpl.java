package com.stpl.pms.daoImpl.um;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import com.amazonaws.services.s3.model.GetS3AccountOwnerRequest;
import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.Itgs;
import com.stpl.pms.hibernate.mapping.StRmBoRoleMaster;
import com.stpl.pms.hibernate.mapping.StRmBoRolePrivMapping;
import com.stpl.pms.hibernate.mapping.StRmBoUserInfo;
import com.stpl.pms.hibernate.mapping.StRmBoUserMaster;
import com.stpl.pms.hibernate.mapping.StRmBoUserPrivMapping;
import com.stpl.pms.hibernate.mapping.StRmServiceDeliveryMaster;
import com.stpl.pms.hibernate.mapping.StRmServiceMaster;
import com.stpl.pms.javabeans.UserDetailsBean;
import com.stpl.pms.javabeans.UserInfoBean;
import com.stpl.pms.javabeans.UserPrivBean;
import com.stpl.pms.utility.AutoGenerate;
import com.stpl.pms.utility.MD5;

@SuppressWarnings("unchecked")
public class GameSearchDaoimpl {
	private static final Logger log=Logger.getLogger(GameSearchDaoimpl.class);
	
	Session session=null;
	
	public Object getGameSearchResult(int gameNO,String userName,String gameName,int ticket_Price )
	{
		
		try
		{
			session = HibernateSessionFactory.getSession();
			Criteria criteria = session
					.createCriteria(Itgs.class);
			criteria.add(Restrictions.eq("game_no", gameNO));
		//criteria.add(Restrictions.eq("userName", userName));
			criteria.add(Restrictions.eq("game_name", gameName));
			criteria.add(Restrictions.eq("price", ticket_Price));
			List<Object[]> result=criteria.list();
			
			if(!result.isEmpty())
			{
				return result;
			}
			return null;
			
		}catch(Exception e) {e.printStackTrace();}
		
		return null;
	}
	
	
	//Database 
	
	

}
