package com.stpl.pms.daoImpl.gameService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.StPortalGameLobbyMapping;
import com.stpl.pms.hibernate.mapping.StRmServiceVendorProperties;
import com.stpl.pms.hibernate.mapping.StRmVendorMaster;
import com.stpl.pms.javabeans.VendorGameLobbybean;
import com.stpl.pms.javabeans.VendorInfoBean;

public class GameServiceDaoImpl {
	private static Logger log = Logger.getLogger(GameServiceDaoImpl.class);
	public StRmServiceVendorProperties serviceRedirectURL(String vendorName,
			Session session) {
		Criteria cri = session.createCriteria(StRmServiceVendorProperties.class);
		cri.createAlias("stRmVendorMaster", "vm");
		cri.add(Restrictions.eq("vm.vendorName", vendorName));
		cri.add(Restrictions.eq("propertyKey", "service_url"))
		.setCacheable(true);
		return (StRmServiceVendorProperties) cri.list().get(0);
	}

	@SuppressWarnings("unchecked")
	public StRmServiceVendorProperties getBOServiceRedirectUrl(
			String serviceName, Session session) {
		Criteria criteria = session.createCriteria(StRmServiceVendorProperties.class).createAlias(
				"stRmVendorMaster", "vendorMaster");
		criteria.add(Restrictions.eq("vendorMaster.vendorCode", serviceName));
		criteria.add(Restrictions.eq("propertyKey", "bo_login_url"));
		criteria.add(Restrictions.eq("tier", "BO"));
		ProjectionList p = Projections.projectionList();
		p.add(Projections.property("vendorMaster.vendorKey"));
		p.add(Projections.property("vendorMaster.secretKeys"));
		p.add(Projections.property("propertyValue"));
		p.add(Projections.property("urlParameter"));
		p.add(Projections.property("vendorMaster.gameEngineBoUrl"));
		criteria.setProjection(p);
		List<Object[]> venderProperty = criteria.list();
		StRmServiceVendorProperties venderProperties = new StRmServiceVendorProperties();
		venderProperties.setId(Integer.parseInt(venderProperty.get(0)[0]
				.toString()));
		venderProperties.setPropertyKey(venderProperty.get(0)[1].toString());
		/*old RUMMY BO*/
//		venderProperties.setPropertyValue(venderProperty.get(0)[4].toString() + venderProperty.get(0)[2].toString());
		/*end of old*/
		
		/*NEW RUMMY  bo*/
/*
		String vendorUrl = venderProperty.get(0)[4].toString().replace("RummyGameEngine", "RummyBO");
		
		if(vendorUrl.contains("InstantGameEngine"))
			vendorUrl = venderProperty.get(0)[4].toString().replace("InstantGameEngine", "IGEBackOffice");
*/
		venderProperties.setPropertyValue(venderProperty.get(0)[4].toString() + venderProperty.get(0)[2].toString());
		/*END OF NEW*/
		venderProperties.setUrlParameter(venderProperty.get(0)[3].toString());
		return venderProperties;
	}
	
	@SuppressWarnings("unchecked")
	public String fetchVendorPropertyUrl(short vendorId,String propertyKey,Session session) throws PMSException{
		String propVal = null;
		try {
			Criteria cri = session.createCriteria(StRmServiceVendorProperties.class);
			cri.createAlias("stRmVendorMaster", "vm");
			cri.setProjection(Projections.property("propertyValue"));
			cri.add(Restrictions.eq("vm.vendorId", vendorId));
			cri.add(Restrictions.eq("propertyKey", propertyKey))
			.setCacheable(true);
			List<Object> list = cri.list();
			if (list.size() == 1) {
				for (Object obj : list) {
					propVal = String.valueOf(obj);
				}
			}else{
				throw new PMSException("Multiple or No Property found ="+ list.size());
			}
		}catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		}
		return propVal;
	}

	@SuppressWarnings("unchecked")
	public List<VendorGameLobbybean> fatchCasinoThemeMap(short domainId, String device, Session session) {
		List<StPortalGameLobbyMapping> gameLobbyList = null;
		List<VendorGameLobbybean> vendorGameLobbyList = null;
		try {
			log.info(Calendar.getInstance().getTime() +" fetch game list start ="+Calendar.getInstance().getTimeInMillis());
			Criteria criteria = session.createCriteria(StPortalGameLobbyMapping.class);
			criteria.createAlias("stPortalGamesMaster", "gm");
			criteria.add(Restrictions.eq("domainId",domainId));
			if(!"pc".equals(device)){
				criteria.add(Restrictions.eq("gm.isHtml5","Y"));
			}
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			gameLobbyList = criteria.list();
			if(gameLobbyList.size()>0){
				VendorGameLobbybean bean = null;
				vendorGameLobbyList = new ArrayList<VendorGameLobbybean>();
				for (StPortalGameLobbyMapping gameDetail : gameLobbyList) {
					bean = new VendorGameLobbybean(gameDetail);
					vendorGameLobbyList.add(bean);
				}
				
			}
			log.info(Calendar.getInstance().getTime() +"fetch game list end ="+Calendar.getInstance().getTimeInMillis());
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return vendorGameLobbyList;
	}
	
	@SuppressWarnings("unchecked")
	public VendorGameLobbybean fetchCasinoGameDetail(short domainId,String gameNumber,Session session) {
		List<StPortalGameLobbyMapping> gameLobbyList = null;
		VendorGameLobbybean bean = null;
		try {
			log.info(Calendar.getInstance().getTime() +" fetch game detail start ="+Calendar.getInstance().getTimeInMillis());
			Criteria criteria = session.createCriteria(StPortalGameLobbyMapping.class);
			criteria.createAlias("stPortalGamesMaster", "gm");
			criteria.add(Restrictions.eq("domainId",domainId));
			criteria.add(Restrictions.eq("gm.gameNumber",gameNumber));
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			gameLobbyList = criteria.list();
			if(gameLobbyList.size()>0){
				for (StPortalGameLobbyMapping gameDetail : gameLobbyList) {
					bean = new VendorGameLobbybean(gameDetail);
				}
				
			}
			log.info(Calendar.getInstance().getTime() +"fetch game detail end ="+Calendar.getInstance().getTimeInMillis());
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return bean;
	}

	@SuppressWarnings("unchecked")
	public VendorInfoBean fetchVendorInfo(String vendorName, Session session) throws PMSException {
		VendorInfoBean vendorInfo = null;
		try {
			Criteria cri = session.createCriteria(StRmVendorMaster.class);
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.add(Restrictions.eq("vendorName", vendorName));
			List<StRmVendorMaster> list = cri.list();
			for (StRmVendorMaster vm : list) {
				vendorInfo = new VendorInfoBean();
				vendorInfo.setVendorId(vm.getVendorId());
				vendorInfo.setVendorCode(vm.getVendorCode());
				vendorInfo.setVendorName(vm.getVendorName());
				vendorInfo.setRegistrationDate(vm.getRegistrationDate());
				vendorInfo.setVendorLobbyType(vm.getVendorLobbyType());
				vendorInfo.setUserName(vm.getUserName());
				vendorInfo.setVendorKey(vm.getVendorKey());
				vendorInfo.setVendorPassword(vm.getVendorPassword());
				vendorInfo.setDefaultGameGroup(vm.getDefaultGameGroup());
				vendorInfo.setStatus(vm.getStatus());
				vendorInfo.setVendorDomainName(vm.getVendorDomainName());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		}
		return vendorInfo;
	}
}
