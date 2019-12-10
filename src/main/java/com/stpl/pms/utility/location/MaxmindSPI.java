package com.stpl.pms.utility.location;

import org.hibernate.HibernateException;

import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;

public class MaxmindSPI {
	private static final String MAXMIND_LICENCED = "MAXMIND_LICENCED";
	
	public static MaxmindService db(){
		return new DBMaxmindService();
	}
	
	public static MaxmindService api(){
		return new APIMaxmindService();
	}
	
	public static MaxmindService api(short aliasId){
		Boolean maxmindLicenced = false;
		
		try {
			String flag = CommonMethodDaoImpl.getInstance().fetchAliasProperty(MAXMIND_LICENCED, aliasId,
					HibernateSessionFactory.getSession());
			if("true".equalsIgnoreCase(flag))
				maxmindLicenced = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (PMSException e) {
			e.printStackTrace();
		}
		
		if(maxmindLicenced)
			return api();
		else
			return db();
	}
}
