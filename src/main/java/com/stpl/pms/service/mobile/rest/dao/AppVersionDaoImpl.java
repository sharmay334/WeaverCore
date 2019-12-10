package com.stpl.pms.service.mobile.rest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.hibernate.mapping.StGenAppVersionDetails;
import com.stpl.pms.service.mobile.rest.javabeans.AppVersionRequestBean;
import com.stpl.pms.service.mobile.rest.javabeans.AppVersionResponseBean;

public class AppVersionDaoImpl
{
	public AppVersionResponseBean fetchAppVersionDetails(AppVersionRequestBean requestBean , Short domainId , Short aliasId, Session session) {
		
		AppVersionResponseBean appVersionResponseBean = new AppVersionResponseBean();
		//Query qry = session.createQuery("select version,versionCode,mandatory,message,lastMandatoryVersionCode from AppVersionBean where os like '"+requestBean.getOs()+ "' and appType like '"+requestBean.getAppType()+"' and domainId = "+domainId+" order by id desc limit 1");
		
		//AppVersionBean appVersionBean = new AppVersionBean();
		Criteria criteria = session.createCriteria(StGenAppVersionDetails.class);
		criteria.add(Restrictions.eq("domainId",domainId));
		criteria.add(Restrictions.eq("aliasId",aliasId));
		criteria.add(Restrictions.eq("os", requestBean.getOs()));
		criteria.add(Restrictions.eq("appType", requestBean.getAppType()));
		criteria.addOrder(Order.desc("id"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		List<StGenAppVersionDetails> list =criteria.list();
		if(list.size()==1)
		{
			for(StGenAppVersionDetails appVersionBean : list)
			{
				appVersionResponseBean.setVersion(appVersionBean.getVersion());
				appVersionResponseBean.setVersionCode(appVersionBean.getVersionCode());
				appVersionResponseBean.setMandatory(appVersionBean.getMandatory());
				appVersionResponseBean.setMessage(appVersionBean.getMessage());
				appVersionResponseBean.setLastMandatoryVersionCode(appVersionBean.getLastMandatoryVersionCode());
			}
		}
		
		return appVersionResponseBean;
	}

}
