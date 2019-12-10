package com.stpl.pms.adv;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.StCmsCampaignTracking;

public class ClickOnikInformer extends AdCompanyCommonInformer{
	public static final String CLICKONIK_FTD_URL = "CLICKONIK_FTD_URL";
	private static final Logger logger = Logger.getLogger(ClickOnikInformer.class);

	public ClickOnikInformer(Long offerId, Long advSub, Double amount, Long camptrackId) {
		super(offerId, advSub, amount, camptrackId);
	}

	@Override
	protected String fetchUrl() throws PMSException {
		
		String url = CommonMethodDaoImpl.getInstance().fetchSystemProperties(CLICKONIK_FTD_URL, HibernateSessionFactory.getSessionFactory().openSession());
		if(StringUtils.isEmpty(url)){
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,CLICKONIK_FTD_URL +" is missing in system property from Database. Note: please property, you can use https://clickonik.go2cloud.org/aff_l as value");
		}
		logger.info("url fetched "+url);
		return url;

	}

	protected boolean isEligible(Session session){
		logger.info("Check if campaign name is clickonik and while registering first param which is utm_source is equals to clickonik.");
		Query query = session.createSQLQuery("SELECT t.* FROM st_cms_campaign_tracking t INNER JOIN st_cms_campaign_master cm ON t.campaign_id=cm.campaign_id WHERE t.id =:campaign_trk_id AND LOWER(cm.campaign_name)=:campaign_name").addEntity(StCmsCampaignTracking.class);
		query.setParameter("campaign_name", "clickonik");
		query.setParameter("campaign_trk_id",this.getCamptrackId());

		StCmsCampaignTracking campaignTracking = (StCmsCampaignTracking) query.uniqueResult();
		boolean isEligible;
		//check if we have eligible camp track and track first value is ClickOnik or anywhere
		if ((campaignTracking != null && 
				("ClickOnik".equalsIgnoreCase(campaignTracking.getValue1()) || campaignTracking.toString().contains("=ClickOnik,")))) {
			isEligible = true;
		}else{
			isEligible = false;
		}
		
		logger.info("Campaign name is clickonik = "+isEligible);
		return isEligible;
		
	}


}
