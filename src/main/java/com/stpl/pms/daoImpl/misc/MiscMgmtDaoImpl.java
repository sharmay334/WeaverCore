package com.stpl.pms.daoImpl.misc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.StGenAppVersionDetails;
import com.stpl.pms.hibernate.mapping.StGenCurrencyConversionRate;
import com.stpl.pms.hibernate.mapping.StGenCurrencyConversionRateHistory;
import com.stpl.pms.hibernate.mapping.StGenCurrencyMaster;
import com.stpl.pms.hibernate.mapping.StPmPlayerNickNameMapping;
import com.stpl.pms.hibernate.mapping.StRmBoAllowedIp;
import com.stpl.pms.javabeans.CurrencyConversionDefBean;

@SuppressWarnings("unchecked")
public class MiscMgmtDaoImpl {
	private static final Logger log = Logger.getLogger(MiscMgmtDaoImpl.class);
	public MiscMgmtDaoImpl() {

	}

	public List<CurrencyConversionDefBean> getCurrencyConversion(Session session,
			int nativeCurrencyId) {
		List<CurrencyConversionDefBean> stGenCurrencyConversionRates = new ArrayList<CurrencyConversionDefBean>();
		Criteria criteria = null;
		criteria = session.createCriteria(StGenCurrencyConversionRate.class);
		criteria.add(Restrictions.eq("fromCurrencyId", nativeCurrencyId));
		List<StGenCurrencyConversionRate> conversionRateList = criteria.list();
		
		criteria = session.createCriteria(StGenCurrencyMaster.class)
				.setCacheable(true);
		List<StGenCurrencyMaster> currencyMasterlist = criteria.list();

		if (conversionRateList.size() != 0) {
			for (StGenCurrencyConversionRate master : conversionRateList) {
				for (StGenCurrencyMaster master1 : currencyMasterlist) {
					if (master1.getCurrencyId().intValue() == master
							.getToCurrencyId().intValue()) {
						CurrencyConversionDefBean e = new CurrencyConversionDefBean();
						e.setCurrencyId(master1.getCurrencyId());
						e.setCurrencyName( master1.getCurrencyDescription());
						e.setStatus(master.getStatus());
						e.setExchangeChargeCurrId(nativeCurrencyId);
						e.setExchangeRate(master.getExchangeRate());
						stGenCurrencyConversionRates.add(e);
						break;
					}
				}
			}
		} else {
			for (StGenCurrencyMaster master : currencyMasterlist) {
				CurrencyConversionDefBean e = new CurrencyConversionDefBean();
				//Map<Integer, String> currencyIdNameMap = new HashMap<Integer, String>();
//				currencyIdNameMap.put(master.getCurrencyId(), master
//						.getCurrencyDescription());
//				e.setCurrencyIdNameMap(currencyIdNameMap);
				e.setCurrencyId(master.getCurrencyId());
				e.setCurrencyName(master.getCurrencyDescription());
				e.setExchangeChargeCurrId(nativeCurrencyId);

				stGenCurrencyConversionRates.add(e);
			}

		}

		return stGenCurrencyConversionRates;
	}

	public String setSaveCurrencyExchange(
			List<CurrencyConversionDefBean> conversionRates, Session session,
			int nativeCurrencyId) {

		Criteria criteria = session
				.createCriteria(StGenCurrencyConversionRate.class);
		criteria = session.createCriteria(StGenCurrencyConversionRate.class);
		criteria.add(Restrictions.eq("fromCurrencyId", nativeCurrencyId));
		List<StGenCurrencyConversionRate> conversionRateList = criteria.list();
		if (conversionRateList.size() != 0) {
			for (StGenCurrencyConversionRate rate : conversionRateList) {
				StGenCurrencyConversionRateHistory rateHistory = new StGenCurrencyConversionRateHistory();
				rateHistory.setExchangeCharge(rate.getExchangeCharge());
				rateHistory.setExchangeChargeCurrencyId(rate
						.getExchangeChargeCurrencyId());
				rateHistory.setExchangeRate(rate.getExchangeRate());
				rateHistory.setFromCurrencyId(rate.getFromCurrencyId());
				rateHistory.setToCurrencyId(rate.getToCurrencyId());
				rateHistory.setUpdatedDate(new java.sql.Timestamp(new Date()
				.getTime()));
				rateHistory.setExchangeDate(rate.getExchangeDate());
				session.save(rateHistory);
				for (CurrencyConversionDefBean conversion : conversionRates) {
					if (rate.getToCurrencyId() == conversion.getCurrencyId()) {
						rate.setExchangeRate(conversion.getExchangeRate());
						rate.setExchangeChargeCurrencyId(nativeCurrencyId);
						rate.setStatus("ACTIVE");
						rate.setFromCurrencyId(nativeCurrencyId);
						rate.setExchangeDate(new java.sql.Timestamp(new Date()
								.getTime()));
						rate.setExchangeCharge(0.00);
						session.saveOrUpdate(rate);
						break;
					}
				}
				if (rate.getToCurrencyId() == nativeCurrencyId) {
					rate.setExchangeDate(new java.sql.Timestamp(new Date()
							.getTime()));
					session.saveOrUpdate(rate);
				}

			}
		}
		/*
		 * else{ for(CurrencyConversionBean conversion:conversionRates){
		 * StGenCurrencyConversionRate currencyConversionRate = new
		 * StGenCurrencyConversionRate();
		 * currencyConversionRate.setFromCurrencyId(nativeCurrencyId);
		 * currencyConversionRate.setToCurrencyId(conversion.getCurrencyId());
		 * currencyConversionRate.setExchangeRate(conversion.getExchangeRate());
		 * currencyConversionRate.setExchangeChargeCurrencyId(nativeCurrencyId);
		 * currencyConversionRate.setExchangeCharge(0.00);
		 * currencyConversionRate.setStatus(conversion.getStatus());
		 * currencyConversionRate.setExchangeDate(new java.sql.Timestamp(new
		 * Date().getTime())); session.save(currencyConversionRate); }
		 * StGenCurrencyConversionRate currencyConversionRate = new
		 * StGenCurrencyConversionRate();
		 * currencyConversionRate.setFromCurrencyId(nativeCurrencyId);
		 * currencyConversionRate.setToCurrencyId(nativeCurrencyId);
		 * currencyConversionRate.setExchangeRate(1.00);
		 * currencyConversionRate.setExchangeChargeCurrencyId(nativeCurrencyId);
		 * currencyConversionRate.setExchangeCharge(0.00);
		 * currencyConversionRate.setStatus("ACTIVE");
		 * currencyConversionRate.setExchangeDate(new java.sql.Timestamp(new
		 * Date().getTime())); session.save(currencyConversionRate);
		 * 
		 * }
		 */
		return "success";

	}

	public Map<Integer, String> allowedIpSearchResult(Session session,
			Short domainId, String ip) {
		Criteria criteria = session.createCriteria(StRmBoAllowedIp.class)
				.setCacheable(true);
		if(domainId != -1){
		criteria.add(Restrictions.eq("domainId", domainId));
		}
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		if (!ip.equals("")) {
			criteria.add(Restrictions.eq("allowedIp", ip));
		}
		// criteria.setProjection(Projections.property("blockedIp"));
		Map<Integer, String> allowip = new HashMap<Integer, String>();
		List<StRmBoAllowedIp> allowedIp = criteria.list();
		for (StRmBoAllowedIp ls : allowedIp) {
			
			allowip.put(ls.getId().intValue(), ls.getAllowedIp());
			
		}
		return allowip;
		
	}

	public void allowIpSave(Session session, Short domainId, Set<String> ipSet,
			int userId, String reason) {
			Timestamp currTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
			Criteria criteria = session.createCriteria(StRmBoAllowedIp.class);
			criteria.add(Restrictions.eq("domainId",domainId));
			criteria.add(Restrictions.in("allowedIp", ipSet));
			List<StRmBoAllowedIp> stRmBoAllowedIp = criteria.list();
			for (StRmBoAllowedIp domainIp : stRmBoAllowedIp) {
				domainIp.setStatus("ACTIVE".equals(domainIp.getStatus())?"INACTIVE":"ACTIVE");
				if(reason!=null)
					domainIp.setReason(reason);
				domainIp.setLastUpdatedBy((long)userId);
				domainIp.setLastUpdationTime(currTime);
				session.update(domainIp);
				ipSet.remove(domainIp.getAllowedIp());

			}
			for (String str : ipSet) {
				StRmBoAllowedIp stRmBoAllowIp = new StRmBoAllowedIp();
				stRmBoAllowIp.setAllowedIp(str);
				stRmBoAllowIp.setReason(reason);
				stRmBoAllowIp.setUserId(userId);
				stRmBoAllowIp.setDomainId(domainId);
				stRmBoAllowIp.setStatus("ACTIVE");
				stRmBoAllowIp.setCreationTime(currTime);
				stRmBoAllowIp.setLastUpdatedBy((long)userId);
				stRmBoAllowIp.setLastUpdationTime(currTime);
				session.save(stRmBoAllowIp);
		}
		session.flush();
	}
	
	public boolean checkAllowedIp(String ipAddress, short domainId,
			Session session) throws PMSException{
		try{
			Criteria criteria = session.createCriteria(StRmBoAllowedIp.class)
					.setCacheable(true);
			criteria.add(Restrictions.eq("domainId",domainId==0?2:domainId));
			criteria.add(Restrictions.eq("status","ACTIVE"));
			criteria.setProjection(Projections.property("allowedIp"));
			List<Object> stRmBoAllowedIp = criteria.list();
			if(stRmBoAllowedIp.contains(ipAddress)){
					return true;
			}
		}catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
			return false;
		}
	public boolean releaseVersionExist(Session session, Short domainId, Short aliasId, String version_type, String appType, String os) {
		Criteria criteria = session
				.createCriteria(StGenAppVersionDetails.class);
		criteria.add(Restrictions.eq("domainId", domainId));
		criteria.add(Restrictions.eq("aliasId", aliasId));
		criteria.add(Restrictions.eq("appType", appType));
		criteria.add(Restrictions.eq("os", os));
		criteria.add(Restrictions.eq("version_type", version_type));
				if (criteria.list().size() > 0)
					return true;
				else
					return false;
	}
	
	public boolean appVersionExist(Session session, Short domainId,
			Short aliasId, String version, String versionCode, String appType,
			String os) {
		Criteria criteria = session
				.createCriteria(StGenAppVersionDetails.class);
		criteria.add(Restrictions.eq("domainId", domainId));
		criteria.add(Restrictions.eq("aliasId", aliasId));
		criteria.add(Restrictions.eq("appType", appType));
		criteria.add(Restrictions.eq("os", os));

		if (version != null) {
			criteria.addOrder(Order.desc("version"));
			criteria.setMaxResults(1);
			List<StGenAppVersionDetails> l=criteria.list();

			if(Integer.parseInt(l.get(0).getVersion().replace(".",""))>=Integer.parseInt(version.replace(".",""))){
				return true;
			}
			else{
				return false;
			}
			//criteria.add(Restrictions.eq("version", version));
		}
		else if (versionCode != null) {
			criteria.addOrder(Order.desc("versionCode"));
			criteria.setMaxResults(1);
			//criteria.add(Restrictions.eq("versionCode", versionCode));
			List<StGenAppVersionDetails> l=criteria.list();

			if(Integer.parseInt(l.get(0).getVersionCode().replace(".",""))>=Integer.parseInt(versionCode.replace(".",""))){
				return true;
			}
			else{
				return false;
			}

		}
		else{
			return true;
		}



//		if (criteria.list().size() > 0)
//			return true;
//		else
//			return false;
	}
	
	public StGenAppVersionDetails validateData(Session session, Short domainId, Short aliasId, String os, String appType)
	{
		StGenAppVersionDetails appVersionBean2 = null;
		Criteria criteria = session.createCriteria(StGenAppVersionDetails.class);
		criteria.add(Restrictions.eq("domainId",domainId));
		criteria.add(Restrictions.eq("aliasId", aliasId));
		criteria.add(Restrictions.eq("os", os));
		criteria.add(Restrictions.eq("appType", appType));
		criteria.addOrder(Order.desc("id"));
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		List<StGenAppVersionDetails> appList = criteria.list();
		if(appList.size()==1)
		{
			for(StGenAppVersionDetails appBean : appList) {
				appVersionBean2 = new StGenAppVersionDetails();
				appVersionBean2.setVersion(appBean.getVersion());
				appVersionBean2.setVersionCode(appBean.getVersionCode());
			}
		}
		return appVersionBean2;
	}
	
	public void saveAppVersion(Session session, Short domainId, Short aliasId,
			String os, String appType, String version, String versionCode,
			String url, String mandatory, String message, String pushAppToAll,String version_type) {
		StGenAppVersionDetails appDeatail = new StGenAppVersionDetails((os
				+ "_" + appType + "_" + version).toUpperCase(), domainId,
				aliasId, os, appType, version, versionCode, new Timestamp(
						Calendar.getInstance().getTimeInMillis()), url,
				mandatory, message, null, pushAppToAll, "ACTIVE",version_type);
		session.save(appDeatail);
		if(version_type.equals("PRODUCTION")) {
			checkandupdateRelease(session);
		}
	}
	public void checkandupdateRelease(Session session){
		Query qry=session.createQuery("UPDATE StGenAppVersionDetails SET version_type='PRODUCTION' where os='ANDROID' and appType='CASH'");
		qry.executeUpdate();
	}
	
	public List<StGenAppVersionDetails> fetchAppList(Session session,
			Short domainId, Short aliasId, String os, String status,
			Integer limit, Integer offset,String version_type)  {
		Criteria criteria = session.createCriteria(StGenAppVersionDetails.class);
		criteria.add(Restrictions.eq("domainId", domainId));
		criteria.add(Restrictions.eq("aliasId", aliasId));
		criteria.add(Restrictions.eq("status", status));
		if(!version_type.equals("all")) {
			criteria.setMaxResults(1);
			criteria.add(Restrictions.eq("version_type", version_type));
		}

		//criteria.add(Restrictions.eq("os", "IOS"));
		criteria.addOrder(Order.desc("versionDate"));
		if (os != null)
			criteria.add(Restrictions.eq("os", os));
		if (limit != null) {
			criteria.setFetchSize(++limit);
			criteria.setFirstResult(offset);
		}
		return criteria.list();
	}
	
	public void makeAppObsolete(Session session,Long appId) {
		Query qry=session.createQuery("UPDATE StGenAppVersionDetails SET status='INACTIVE' where id="+appId);
		qry.executeUpdate();
	}
	public void updateVersionRelease(Session session,Long appId){
		Query qry=session.createQuery("UPDATE StGenAppVersionDetails SET version_type='PRODUCTION' where id="+appId);
		qry.executeUpdate();
	}
	
	public List<StGenAppVersionDetails> fetchAltVersion(Session session,Long appVerId,Short domainId,Short aliasId,String os,String appType) {
		Criteria criteria=session.createCriteria(StGenAppVersionDetails.class);
		criteria.add(Restrictions.eq("domainId",domainId));
		criteria.add(Restrictions.eq("aliasId",aliasId));
		criteria.add(Restrictions.eq("os", os));
		criteria.add(Restrictions.eq("appType", appType));
		criteria.add(Restrictions.ne("id", appVerId));
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		return criteria.list();
	}

	public void pushAppToAll(Session session, Short domainId, Short aliasId,
			String appType, String appVer, String mandate, String oldAppVer,
			Long[] playerArr, String pushToAll) {
		String hq = "UPDATE StPmPlrLoginStatus SET propAppVer =:propAppVer ,propAppMandatory=:mandate WHERE domainId=:domainId AND lastAliasId=:aliasId AND appType =:appType ";
		if (oldAppVer != null)
			hq += " AND curAppVer=:oldAppVer";
		if (playerArr != null && playerArr.length > 0)
			hq += " AND playerId IN (:playerArr)";
			/*hq+=" AND (curAppVer=propAppVer " +
				"OR propAppMandatory='NO')";
*/
			//"OR 'YES'=:mandate " +
		//"OR 'YES'=:pushToAll " +
		Query qry = session.createQuery(hq);
		qry.setParameter("propAppVer", appVer);
		qry.setParameter("appType", appType);
		qry.setParameter("domainId", domainId);
		qry.setParameter("aliasId", aliasId);
		qry.setParameter("mandate", mandate);
//		qry.setParameter("pushToAll",  pushToAll);
		if (oldAppVer != null)
			qry.setParameter("oldAppVer", oldAppVer);
		if (playerArr != null && playerArr.length > 0)
			qry.setParameterList("playerArr", playerArr);
		int recordUpd = qry.executeUpdate();
		log.info("App Version " + appVer + " Pushed to " + recordUpd
				+ " users.");
	}

	public StGenAppVersionDetails getAppVersionBean(Session session,Long appId) {
		return (StGenAppVersionDetails)session.get(StGenAppVersionDetails.class, appId);
	}
	
	public void updateAppVersion(Session session, StGenAppVersionDetails appVersion){
		session.update(appVersion);
	}
	
	public StPmPlayerNickNameMapping fetchPokerNickName(Session session, StPmPlayerNickNameMapping bean){
		/*fetch full StPmPlayerNickNameMapping bean using partial bean with example criteria*/ 
		bean = (StPmPlayerNickNameMapping) session.createCriteria(StPmPlayerNickNameMapping.class).add(Example.create(bean)).uniqueResult();
		return bean;
	}


}
