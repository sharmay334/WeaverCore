package com.stpl.pms.controller.commonMethods;

import static com.stpl.pms.utility.Utility.defaultIfNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.stpl.pms.adv.ClickOnikInformer;
import com.stpl.pms.adv.CouponRajaInformer;
import com.stpl.pms.commonJavabeans.AttendanceBean;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.StCmsTemplateMaster;
import com.stpl.pms.hibernate.mapping.StDmAliasDeeplinkRep;
import com.stpl.pms.hibernate.mapping.StDmDomainAliasNameMaster;
import com.stpl.pms.hibernate.mapping.StGenSchedulerRunStatus;
import com.stpl.pms.hibernate.mapping.StGenStateMaster;
import com.stpl.pms.hibernate.mapping.StPortalDeviceDomainMapping;
import com.stpl.pms.hibernate.mapping.StPortalPathMaster;
import com.stpl.pms.hibernate.mapping.StRmVendorMaster;
import com.stpl.pms.javabeans.AliasBean;
import com.stpl.pms.javabeans.AnalyticalToolMappingBean;
import com.stpl.pms.javabeans.CityBean;
import com.stpl.pms.javabeans.CountryBean;
import com.stpl.pms.javabeans.CurrencyBean;
import com.stpl.pms.javabeans.CurrencyConversionDefBean;
import com.stpl.pms.javabeans.LanguageBean;
import com.stpl.pms.javabeans.OfflineAffiliateDetailBean;
import com.stpl.pms.javabeans.PasswordPolicyBean;
import com.stpl.pms.javabeans.PlayerInfoBean;
import com.stpl.pms.javabeans.PlayerReferralInfo;
import com.stpl.pms.javabeans.PortalPropertyBean;
import com.stpl.pms.javabeans.StateBean;
import com.stpl.pms.javabeans.UrlTagBean;
import com.stpl.pms.javabeans.UserInfoBean;
import com.stpl.pms.javabeans.VendorAuthInfoBean;
import com.stpl.pms.javabeans.VendorInfoBean;
import com.stpl.pms.javabeans.VipLevelMasterBean;
import com.stpl.pms.javabeans.WordSentenceBean;
import com.stpl.pms.service.mobile.rest.javabeans.GameEngineBean;

public class CommonMethodController {
	private static final Logger log = Logger.getLogger(CommonMethodController.class);
	private CommonMethodDaoImpl daoImpl = null;
	
//	private CommonMethodController(){}
//	CommonMethodController controller = null;
//	public static CommonMethodController getInstance() {
//	if(controller == null){
//		controller = new CommonMethodController();
//		return controller;
//	}else{
//		return controller;
//	}
//	Singleton modification

	private CommonMethodController() {
		daoImpl = CommonMethodDaoImpl.getInstance();
	}

	public static CommonMethodController getInstance() {
		return new CommonMethodController();
	}
	
	public PortalPropertyBean fetchMenuLayout(Short aliasId, String device,
			String loginStatus,String url) throws PMSException {
		PortalPropertyBean propertyBean = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			aliasId = "BYDEFAULT".equals(CommonMethodDaoImpl.getInstance().getDmAliasProperty(session, aliasId, "menuList"))?(short)1:aliasId; 
			propertyBean = daoImpl.fetchMenuBean(aliasId, device,
					loginStatus, url, session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return propertyBean;
	}

	public Integer fetchActionId(String actionName, String checkLogin)
			throws PMSException {
		Integer actionId = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			actionId = daoImpl.fetchActionId(actionName, checkLogin, session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return actionId;
	}

/*
	public void authanticateVendorIp(String requestIp,String allowedIps) throws PMSException{
		if(!new CashierController().validateSource(requestIp,allowedIps))
			throw new PMSException(PMSErrorCode.API_UNAUTH_SERVICE_USER,PMSErrorMessage.API_UNAUTH_SERVICE_USER);
	}*/
	public StRmVendorMaster getVendorAuthDetails(
			VendorAuthInfoBean vendorAuthInfo) throws PMSException {
		log.info("---getVendorAuthDetails Start---");
		StRmVendorMaster vendorMaster;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			vendorMaster = daoImpl
					.getVendorAuthDetails(vendorAuthInfo, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		log.info("---getVendorAuthDetails End---");
		return vendorMaster;
	}

	public List<String> fetchPath() {
		List<String> list = new ArrayList<String>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			list = daoImpl.fetchPath(session);
		} catch (PMSException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;

	}

	public List<StPortalPathMaster> fetchServerDetail() {
		List<StPortalPathMaster> serverDetailList = new ArrayList<StPortalPathMaster>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			serverDetailList = daoImpl.fetchServerDetail(session);
		} catch (PMSException e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return serverDetailList;

	}

	public List<String> getUploadedContent() {
		List<String> contentList = new ArrayList<String>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			contentList = daoImpl.getUploadedContent(session);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return contentList;
	}

	public void updateUploadedContent(List<String> uploadedContent) {
//		Session session = null;
//		Transaction tx = null;
//		
//		try {
//			session = HibernateSessionFactory.getSession();
//			tx = session.beginTransaction();
//			daoImpl.updateUploadedContent(uploadedContent, session);
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null && tx.isActive())
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//		if (session != null && session.isOpen()) {
//			session.close();
//		}
//	}
	}

	public String fetchSystemProperties(String propName) throws PMSException {
		String value = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			value = daoImpl.fetchSystemProperties(propName, session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return value;
	}

	public Map<Integer, CurrencyBean> fetchCurrencyMasterMap()
			throws PMSException {
		Map<Integer, CurrencyBean> currencyMasterMap = new HashMap<Integer, CurrencyBean>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			currencyMasterMap = daoImpl.fetchCurrencyMasterMap(session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Currency Master Map has some problem");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return currencyMasterMap;
	}

	public Map<Integer, String> fetchCurrencyMasterMap(short domainId)
			throws PMSException {
		Map<Integer, String> currencyMap;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			currencyMap = daoImpl.fetchCurrencyMasterMap(session,domainId);
		} catch (Exception e) {
			throw e;
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return currencyMap;
	}


	public CurrencyBean fetchCurrencyMasterBean(Integer currId)
			throws PMSException {
		CurrencyBean currencyBean = new CurrencyBean();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			currencyBean = daoImpl.fetchCurrencyMasterBean(currId, session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(
					"Fetch Currency master Bean has some problem");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return currencyBean;
	}

	public CurrencyConversionDefBean fetchUpdateCurrencyConversionRate(
			Integer fromCurId, Integer toCurId) throws PMSException {
		CurrencyConversionDefBean currConvBean = new CurrencyConversionDefBean();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			currConvBean = daoImpl.fetchUpdateCurrencyConversionRate(fromCurId,
					toCurId, session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(
					"Update Currency Cunversion has some problem");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return currConvBean;
	}

	public VendorInfoBean fetchVendorInfo(String userName) throws PMSException {
		Session session = null;
		try{
			if (userName!=null && !"".equals(userName)) {
				session = HibernateSessionFactory.getSession();
				return daoImpl.fetchVendorInfo("rummyuser_2x".equals(userName)?"rummyuser":userName,null, session);
			}else{
				log.info("-------vendor userName null---------");
				throw new PMSException(PMSErrorCode.API_UNAUTH_SERVICE_USER, PMSErrorMessage.API_UNAUTH_SERVICE_USER);
			}
		} catch (PMSException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
	}
	
	public VendorInfoBean fetchTxnVendorInfo(String userName) throws PMSException{
		log.info("------------------------Start Fetch vendor Information from fetchTxnVendorInfo -----");
		Session session = null;
		try{
			if (userName!=null && !"".equals(userName)) {
				session = HibernateSessionFactory.getSession();
				return daoImpl.fetchTxnVendorInfo(userName,null, session);
			}else{
				log.info("-------vendor userName null---------");
				throw new PMSException(PMSErrorCode.API_UNAUTH_SERVICE_USER, PMSErrorMessage.API_UNAUTH_SERVICE_USER);
			}
		} catch (PMSException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
	}

	public VendorInfoBean fetchVendorInfo(String userName, String password) throws PMSException {
		Session session = null;
		try{
			if (userName!=null && !"".equals(userName)) {
				session = HibernateSessionFactory.getSession();
				return daoImpl.fetchVendorInfo(userName, password, session);
			}else{
				log.info("-------vendor userName null---------" + "userName = "+ userName);
				throw new PMSException(PMSErrorCode.API_UNAUTH_SERVICE_USER, PMSErrorMessage.API_UNAUTH_SERVICE_USER);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
	}
	
	public String fetchVendorPropertyUrl(String userName, String propertyKey)
			throws PMSException {
		String url = null;
		String propValue = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			VendorInfoBean vendorInfo = daoImpl.fetchVendorInfo(userName, null,
					session);
			propValue= daoImpl.fetchVendorPropertyUrl(vendorInfo.getVendorId(),
					propertyKey, session);
			if( propertyKey.indexOf("next_seed") !=-1 || propertyKey.indexOf("feed_url") !=-1)
				url = propValue;
			else
				url = vendorInfo.getVendorDomainName()!= null?vendorInfo.getVendorDomainName():"" + propValue;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Vendor Property has some problem");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return url;
	}
	
	public UrlTagBean fetchUrlMap(short aliasId, String actionUrl, String device)
			throws PMSException {
		UrlTagBean tagBean = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			tagBean = daoImpl.fetchUrlTags(session, aliasId, actionUrl, device);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Language Master Bean has some problem");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return tagBean;
	}

	public LanguageBean fetchLanguageMasterBean(Integer langId)
			throws PMSException {
		LanguageBean languageBean = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			languageBean = new LanguageBean();
			languageBean = daoImpl.fetchLanguageMasterBean(langId, session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Language Master Bean has some problem");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return languageBean;
	}

	public OfflineAffiliateDetailBean authenticateOfflineAffiliate(
			String userName, String password) throws PMSException {
		OfflineAffiliateDetailBean affiliateBean = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			affiliateBean = daoImpl.authenticateOfflineAffiliate(userName,
					password, session);
		}catch (PMSException e){
		 throw e;
        }catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR, "System Property has some problem");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return affiliateBean;
	}
/*
	public String contentUpload(List<String> filePath) {
		ContentUploadJob contentUploadJob = new ContentUploadJob();
		contentUploadJob.doUpload(filePath);
		return "success";
	}*/

	public List<String> fetchAvtaarList() throws PMSException {
		List<String> list = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			list = daoImpl.fetchAvtaarList(session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Avtaar Map has some problem");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return list;
	}

	public ArrayList<PlayerReferralInfo> storePlayerReferralContactList(
			ArrayList<PlayerReferralInfo> playerReferralInfo, long playerId,
			String playerEmailId) throws PMSException {
		Transaction tx = null;
		ArrayList<PlayerReferralInfo> referalInfo = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			referalInfo = daoImpl.storePlayerReferralContactList(session,
					playerReferralInfo, playerId, playerEmailId);
			//Collections.sort(referalInfo);
			tx.commit();
			session.flush();
		} catch (PMSException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally{
			if(session!=null && session.isOpen()){
				session.close();
			}
		}
		return referalInfo;
	}

/*	public void invitedFriend(ArrayList<PlayerReferralInfo> playerReferralInfo,
			Long playerId, String playerName, short domainId, short aliasId, String inviteMode)
			throws PMSException {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			List<PlayerReferralInfo> referralList = daoImpl.invitedFriend(
					session, playerReferralInfo, playerId, domainId, aliasId, inviteMode);
			PlayerInfoBean playerInfoBean = daoImpl.checkPlrLoginStatus(playerId, true, session);
			StDmDomainAliasNameMaster aliasMass = daoImpl.getAliasMaster(session, aliasId);
			String contentType = aliasMass.getContentType();
			List<LinkedHashMap<String, String>> refInofList = new ArrayList<LinkedHashMap<String, String>>();
			for (PlayerReferralInfo referralInfo : referralList) {
				LinkedHashMap<String, String> infoMap = new LinkedHashMap<String, String>();
				infoMap.put("EmailId", referralInfo.getEmailId());
				infoMap.put("mobileNo",String.valueOf(referralInfo.getMobileNo()));
				infoMap.put("DomainName", aliasMass.getAliasName());
				if (referralInfo.getFirstName() != null
						&& !"".equals(referralInfo.getFirstName())) {
					infoMap.put("Name", referralInfo.getFirstName());
				} else {
					infoMap.put("Name", "Friend");
				}
				infoMap.put("UserName", playerName);
				infoMap.put("WebSiteLink",String.valueOf(domainId));
				CmsDaoImpl cmsDaoImpl = new CmsDaoImpl();
				String landingPageWithRummyUrl[] = cmsDaoImpl.fetchReferUrl(aliasId,"REFER_FRIEND", contentType, session).split("~");
				//String encrypyUrl =cmsDaoImpl.genEncodeString("REFER_FRIEND",playerId,referralInfo.getReferalId(),(landingPageWithRummyUrl.length==2?"/"+landingPageWithRummyUrl[1]:""));
				
				String encrypyUrl=CommonMethodDaoImpl.getInstance().getReferFriendCode(playerId, session);
				
				infoMap.put("ReferFriendCode", encrypyUrl);
				String relativeUrl = "REFER_FRIEND/" + playerId.toString()
						+ "/" + String.valueOf(referralInfo.getReferalId())+(landingPageWithRummyUrl.length==2?"/"+landingPageWithRummyUrl[1]:"");
				String encrypyUrl = Utility.encodeString(relativeUrl);
				
				encrypyUrl = URLEncoder.encode(encrypyUrl.replaceAll("/", "_")
						.replaceAll("\\+", "-"), "UTF-8");
				
				if("PORTALCONTENT".equalsIgnoreCase(contentType)) {
						infoMap.put("InvitionLink", aliasMass.getAliasName()
								+ "/" + landingPageWithRummyUrl[0] + "/" + encrypyUrl + "/");
				} else {
						infoMap.put("InvitionLink", (landingPageWithRummyUrl[0]!=null? landingPageWithRummyUrl[0].split(".com/")[1] + "?data=" + encrypyUrl + "/":""));
				}
				
				Set username as First_Last name in case of it's available and it's MOBILE
				if("MOBILE".equals(inviteMode) && playerInfoBean!=null && playerInfoBean.getFirstName()!=null){
					infoMap.put("UserName", playerInfoBean.getFirstName()+(playerInfoBean.getLastName()!=null?" "+playerInfoBean.getLastName():""));
				}
				
				refInofList.add(infoMap);
			}
			tx.commit();
			if(referralList.size()!=0) {
				if("MOBILE".equals(inviteMode)) {
					SendSMS.massMsgSend(refInofList,"INVITE_FRIEND",domainId,aliasId,session);
				} else {
					MassMailling.callingMassMail(refInofList, "INVITE_FRIEND",
					domainId,aliasId, playerId,playerName, session);
				}
			}
			
			session = HibernateSessionFactory.getSession();
			PlayerMgmtDaoImpl playerMgmtDaoImpl = new PlayerMgmtDaoImpl();
			BonusController.getInstance().checkNGiveBonus(playerMgmtDaoImpl.getPlayerInfoById(playerId,session), 9,"YES", session);
			
			
		} catch (PMSException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
	}*/

/*	public void inviteManual(ArrayList<PlayerReferralInfo> playerReferralInfo,
			PlayerInfoBean playerInfoBean, short aliasId, String inviteMode) throws PMSException {
		ArrayList<PlayerReferralInfo> referList = storePlayerReferralContactList(
				playerReferralInfo, playerInfoBean.getPlayerId(),
				playerInfoBean.getEmailId());
		for (int i = 0; i < referList.size(); i++) {
			if (referList.get(i).isChecked()) {
				referList.remove(i);
			}
		}
		invitedFriend(referList, playerInfoBean.getPlayerId(), playerInfoBean
				.getUserName(), playerInfoBean.getDomainId(), aliasId, inviteMode);
	}

	public Map<String, String> getDmPropertyMap(Short domainId,
			String... strings) throws PMSException {
		Map<String, String> propMap = new HashMap<String, String>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			propMap = daoImpl.getDmPropertyMap(session, domainId, strings);
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw pmse;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Domain Property Exception");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return propMap;
	}
*/
	
	public Map<String, String> getAliasPropertyMap(Short aliasId,
			String... strings) throws PMSException {
		Map<String, String> propMap = new HashMap<String, String>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			propMap = daoImpl.getAliasPropertyMap(session, aliasId, strings);
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw pmse;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Domain Property Exception");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return propMap;
	}
	
	public StDmDomainAliasNameMaster getAliasMaster(Short aliasId)
			throws PMSException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return daoImpl.getAliasMaster(session, aliasId);
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw pmse;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Domain Property Exception");
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
	
	
	
	public Map<String, String> getDmPropFromAliasId(Short aliasId,
			String... strings) throws PMSException {
		Map<String, String> propMap = new HashMap<String, String>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			propMap = daoImpl.getDmPropFromAliasId(session, aliasId, strings);
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw pmse;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Domain Property Exception");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return propMap;
	}
	
	public String getDmProperty(Short domainId, String propStr)
			throws PMSException {
		String propVal = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			propVal = daoImpl.getDmProperty(session, domainId, propStr);
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw pmse;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Domain Property Exception");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return propVal;

	}
	
	public String getDmAliasProperty(Short aliasId, String propStr)
			throws PMSException {
		String propVal = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			propVal = daoImpl.getDmAliasProperty(session, aliasId, propStr);
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw pmse;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Domain Property Exception");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return propVal;

	}

	public StCmsTemplateMaster fetchTempleteUrlMap(Short aliasId,
			String templateType, String mode) throws PMSException {
		StCmsTemplateMaster templateMaster = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			templateMaster = daoImpl.fetchTempleteUrlMap(aliasId,
					templateType, null, mode, session);
		} catch (PMSException pmse) {
			throw pmse;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Templete Map Exception");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return templateMaster;
	}

	public boolean checkBlockedEmailId(String emailId, short domainId)
			throws PMSException {
		boolean result = true;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			result = daoImpl.checkBlockedEmailId(emailId, domainId, session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return result;
	}

	public boolean checkBlockedIPAddress(String ipAddress, short domainId)
			throws PMSException {
		boolean result = true;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			result = daoImpl
					.checkBlockedIPAddress(ipAddress, domainId, session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return result;
	}

	public boolean checkBlockedPhoneNo(String mobileNo, short domainId)
			throws PMSException {
		boolean result = true;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			result = daoImpl.checkBlockedPhoneNo(mobileNo, domainId, session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return result;
	}

	public Map<Integer, CurrencyBean> fetchActiveDmCurrMap(Short domainId)
			throws PMSException {
		Map<Integer, CurrencyBean> dmActiveCurrMap = new HashMap<Integer, CurrencyBean>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			dmActiveCurrMap = daoImpl.fetchActiveDmCurrMap(domainId, session);
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw pmse;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Domain Map Exception");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return dmActiveCurrMap;

	}
	
	public List<AliasBean>  fetchActiveAliasList(Short domainId)
			throws PMSException {
		List<AliasBean> aliasList = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			aliasList = daoImpl.fetchActiveAliasMap(domainId, session);
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw pmse;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Domain Map Exception");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return aliasList;

	}

//	public short getDomainIdFromName(String domainName) throws PMSException {
//		short domainId = 0;
//		Session session = null;
//		try {
//			session = HibernateSessionFactory.getSession();
//			domainId = daoImpl.getDomainIdFromName(domainName, session);
//		} catch (PMSException pmse) {
//			pmse.printStackTrace();
//			throw pmse;
//		} finally {
//			if(session!=null && session.isOpen())
//				session.close();
//		}
//		return domainId;
//	}

	public Integer getCurrencyIdFromCurrencyCode(String currencyCode) throws PMSException{
		Session session=null;
		Integer currencyId;
		try {
			session = HibernateSessionFactory.getSession();
			currencyId = daoImpl.getCurrencyIdFromCurrencyCode(currencyCode, session);

		}catch (PMSException exception) {
			throw exception;
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return currencyId;
	}

	public short getDomainIdFromDomainName(String domainName) throws PMSException {
		short domainId;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			domainId = daoImpl.getDomainIdFromDomainName(domainName, session);
			if(domainId == 0){
				throw new PMSException(PMSErrorCode.DOMAIN_NOT_VAILD,PMSErrorMessage.DOMAIN_NOT_VAILD);
			}
		} catch (PMSException exception) {
			throw exception;
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return domainId;
	}
	
	public short getDomainIdFromName(String domainName) throws PMSException {
		short domainId = 0;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			domainId = daoImpl.getDomainIdFromDomainName(domainName, session);
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw pmse;
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return domainId;
	}

	public List<VipLevelMasterBean> fetchDomainVipLevelList(short domainId,
			String string) throws PMSException {
		List<VipLevelMasterBean> vipMasterBean = new ArrayList<VipLevelMasterBean>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			vipMasterBean = daoImpl.fetchDomainVipLevelList(domainId, string,
					session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("System Property has some problem");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return vipMasterBean;
	}
/*
	public List<PortalWinnersList> fetchWinnersList(Short aliasId,String durationParam,String gameType,String subGameType) throws PMSException {
		List<PortalWinnersList> list = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			list = daoImpl.fetchWinnersList(aliasId,durationParam,gameType,subGameType,session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return list;
	}*/

	public List<CountryBean> fetchActiveCountryList(short domainId)
			throws PMSException {
		List<CountryBean> countryList = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			if ("BYDEFAULT".equals(daoImpl.getDmProperty(session, domainId,
					"allowedCountries"))) {
				domainId = 1;
			}
			countryList = daoImpl.fetchActiveCountryList(domainId, session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());

		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return countryList;
	}

	public Map<Integer, LanguageBean> fetchDmActiveLangMap(Short domainId)
			throws PMSException {
		Map<Integer, LanguageBean> dmLanMap = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			dmLanMap = daoImpl.fetchDmActiveLangMap(domainId, session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return dmLanMap;

	}


	public List<StateBean> fetchActiveStateList(short domainId,
			Integer countryId) throws PMSException {//parameter updated from string to integer for country id
		List<StateBean> stateList = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			if ("BYDEFAULT".equals(daoImpl.getDmProperty(session, domainId,
					"allowedStates"))) {
				domainId = 1;
			}
			stateList = daoImpl.fetchActiveStateList(domainId, countryId,
					session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return stateList;
	}

	public Map<Short, String> getDomainIdMap() throws PMSException {
		Map<Short, String> dmIdMap = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			dmIdMap = daoImpl.getDomainIdMap(session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());

		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return dmIdMap;
	}

	public String getDeviceLayout(Short domainId, String device)
			throws PMSException {
		String layout = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			layout = daoImpl.getDeviceLayout(domainId, device, session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());

		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return layout;
	}
	
	public String fetchAliasLayout(Short aliasId, String device)
			throws PMSException {
		String layout = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			layout = daoImpl.fetchAliasLayout(aliasId, device, session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());

		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return layout;
	}
	
	public String fetchDomainNameLayout(String domainName)
			throws PMSException {
		String layout = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			layout = daoImpl.fetchDomainNameLayout(domainName, session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return layout;
	}

	public Map<Short, Map<String, String>> gameServiceProperties()
			throws PMSException {
		Map<Short, Map<String, String>> map = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			map = daoImpl.gameServiceProperties(session);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return map;
	}


	public List<String> gameServiceLogutUrl(Short aliasId) {
		List<String> list = new ArrayList<String>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
//			Map<Short, Map<String, String>> gameServiceProp = daoImpl
//					.gameServiceProperties(session);
			Map<Short, Map<String, String>> gameServiceProp = daoImpl
					.getVendorPropertiesById(aliasId,session);
			for (Short vendorId : gameServiceProp.keySet()) {
				if (gameServiceProp.get(vendorId).containsKey(
						"service_logout_url")) {
					list.add(gameServiceProp.get(vendorId).get(
							"service_logout_url"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return list;
	}
	
	public List<String> gameServiceLogutUrl(Short aliasId, String vendorName) {
		List<String> list = new ArrayList<String>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
//			Map<Short, Map<String, String>> gameServiceProp = daoImpl
//					.gameServiceProperties(session);
			Map<Short, Map<String, String>> gameServiceProp = daoImpl
					.getVendorPropertiesById(aliasId,vendorName,session);
			for (Short vendorId : gameServiceProp.keySet()) {
				if (gameServiceProp.get(vendorId).containsKey(
						"service_logout_url")) {
					list.add(gameServiceProp.get(vendorId).get(
							"service_logout_url"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return list;
	}
	

	/*public PlayerInfoBean checkPlrLoginStatus(String sessionId)
			throws PMSException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return daoImpl.checkPlrLoginStatus(sessionId, session);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	public PlayerInfoBean checkPlrLoginStatus(String sessionId, Long playerId,
			boolean plrInfoReq) throws PMSException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return daoImpl.checkPlrLoginStatus(sessionId, playerId, plrInfoReq, session);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
*/
/*	public String getRSAIdFromPlayerId(short domainId, Long playerId) throws Exception {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return new PlayerMgmtDaoImpl().getRSAIdFromPlayerId(playerId, domainId, session);
		} catch (HibernateException e){
			log.error(e.getMessage(),e);
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION, PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e){
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}*/
/*	
	public PlayerInfoBean checkPlrLoginStatus(Long playerId,
			boolean plrInfoReq) throws PMSException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return daoImpl.checkPlrLoginStatus(playerId, plrInfoReq, session);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}*/
	
	public Long getPlayerIdFromMobOrEmailId(String emailId, Long mobileNo) throws PMSException{
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return daoImpl.getPlayerIdFromMobOrEmailId(session, emailId, mobileNo);
		} catch (PMSException e) {
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public String fetchCountryNameByCode(String countryCode) {
		String str = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			str = daoImpl.fetchCountryNameByCode(countryCode, session);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return str;
	}

	public String fetchStateNameByCode(String stateCode) {
		String str = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			str = daoImpl.fetchStateNameByCode(stateCode, session);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return str;
	}

	public int fetchOnlinePlayers(short domainId) {
		int str = 0;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			str = daoImpl.fetchOnlinePlayers(domainId, session);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return str;
	}

	public PasswordPolicyBean fetchDomainWisePasswordValidation(short domainId)
			throws PMSException {
		PasswordPolicyBean passwordPolicyBean = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			passwordPolicyBean = daoImpl.fetchDomainWisePasswordValidation(
					session, domainId);
		} catch (Exception pmse) {
			pmse.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return passwordPolicyBean;
	}

	public String fetchDomainDeviceAlias(short domainId, String device)
			throws PMSException {
		String str = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			str = daoImpl.fetchDomainDeviceAlias(domainId, device, session);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return str;
	}

	public StGenSchedulerRunStatus getLastScheduledTime(String schedulerCode)
			throws PMSException {
		StGenSchedulerRunStatus str = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			str = daoImpl.getLastScheduledTime(schedulerCode, session);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return str;
	}

	public void updateSchedulerTime(StGenSchedulerRunStatus runStatus)
			throws PMSException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			daoImpl.updateSchedulerTime(runStatus, session);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void updateSystemProperties(String property,String propValue) throws PMSException {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			daoImpl.updateSystemProperties(property,propValue,session);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
	}
	
	public UserInfoBean checkBoUserLogin(String sessionId) throws PMSException{
		Session session = null;
		UserInfoBean userInfoBean;
		try {
			session = HibernateSessionFactory.getSession();
			userInfoBean = daoImpl.checkBoUserLogin(sessionId,session,true);
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return userInfoBean;
	}

	public int fetchTotalDepositCount(PlayerInfoBean playerInfo) throws PMSException {
		Session session = null;
		int count = 0;
		try {
			session = HibernateSessionFactory.getSession();
			count = daoImpl.fetchTotalDepositCount(playerInfo,session);
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return count;
	}
	
	public LinkedHashMap<String, String> playerRequestVariables(long playerId, short domainId) {
		Session session = null;
		LinkedHashMap<String, String> map =null;
		try{
			session = HibernateSessionFactory.getSession();
			map = daoImpl.variableMap(playerId, domainId, "REQUEST", session);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return map;
	}

	public List<CityBean> fetchActiveCityList(int stateId, int countryId) throws PMSException {
		List<CityBean> cityList = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			cityList = daoImpl.fetchActiveCityList(stateId,countryId, session);
		} catch (PMSException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Some Internal Error!");
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return cityList;
	}

	public List<WordSentenceBean> fetchWordSentence(short domainId,
			String language) throws PMSException {
		List<WordSentenceBean> wordList = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			wordList = daoImpl.fetchWordSentence(domainId, language, session);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return wordList;
	}
	
	public List<StRmVendorMaster> fetchServer(String vendorCode)
			throws PMSException {
		Session session = null;
		List<StRmVendorMaster> serverList = null;
		try {
			session = HibernateSessionFactory.getSession();
			serverList = daoImpl.fetchServerDetail(vendorCode, session);
		} catch (PMSException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Some Internal Error");
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return serverList;
	}
	
	public String detectOS(String userAgent) {
		String ua=userAgent.toLowerCase();
		System.out.println(ua);
		return (ua.contains("android")) ? "ANDROID_APP" : (ua.matches(".*(iphone|ipad|ipod).*")) ? "IOS_APP_CASH" : null;
	}
	
	public Integer fetchCountryId(short domainId,String countryCode) throws PMSException {//parameter updated from string to integer for country id
		int countryId = 0;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			if ("BYDEFAULT".equals(daoImpl.getDmProperty(session, domainId,
					"allowedStates"))) {
				domainId = 1;
			}
			countryId = daoImpl.fetchCountryId(domainId, countryCode,session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return countryId;
	}
	
	public Integer fetchStateId(short domainId,String stateCode) throws PMSException {//parameter updated from string to integer for country id
		int stateId = 0;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			if ("BYDEFAULT".equals(daoImpl.getDmProperty(session, domainId,
					"allowedStates"))) {
				domainId = 1;
			}
			stateId = daoImpl.fetchStateId(domainId, stateCode,session);
		} catch (PMSException pmse) {
			throw pmse;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return stateId;
	}
	
	public void invalidateCache(String cacheReginName) throws PMSException {
		try {
			SessionFactory sessFectory = HibernateSessionFactory
					.getSessionFactory();
			daoImpl.invalidateCache(cacheReginName, sessFectory);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Some Internal Error");
		}
	}
	
/*	public CommonInfoBean fetchBasicInfo(String serverName,
			String sessionId, String[] pathArry, String actionUrl) throws PMSException {
		Session session  = null;
		try {
			session  = HibernateSessionFactory.getSession();
			return daoImpl.fetchBasicInfo(serverName, sessionId, pathArry, actionUrl, session);
		} catch (PMSException e) {
			if(e.getErrorMessage().equals("Domain Not Found")){
				log.error(e.getErrorMessage());
			}else{
				e.printStackTrace();
			}
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Some Internal Error!");
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
	}
	*/
	public Map<Short, String> fetchAliasMap(short domainId) throws PMSException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return daoImpl.fetchAliasMap(domainId, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Unknown Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	public Map<Short, String> fetchGameMap(short domainId, short aliasId) throws PMSException {
		Session session = null;
		try {
			Map<Short, String> gameMap = new HashMap<>();
			session = HibernateSessionFactory.getSession();
			gameMap = daoImpl.fetchGameMap(domainId,aliasId,session);
			//TODO Change After ICE 
			 Set<Short> set = new HashSet<>();
				set.add((short)2);
				set.add((short)4);
				set.add((short)6);
				set.add((short)12);
				set.add((short)14);
				set.add((short)17);
				set.add((short)19);
				gameMap=daoImpl.fetchGameMap(domainId,aliasId,session);
				gameMap.keySet().retainAll(set);
				return gameMap;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Unknown Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public StPortalDeviceDomainMapping fetchDeviceDmMapping(String serverName)
			throws PMSException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return CommonMethodDaoImpl.getInstance().fetchDeviceDmMapping(
					session, serverName);
		} catch (PMSException e) {
			if(e.getErrorMessage().equals("Domain Not Found")){
				log.error(e.getErrorMessage());
			}
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Unknown Exception");
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public StDmDomainAliasNameMaster fetchAliasMasFromAliasName(String aliasName) throws PMSException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return CommonMethodDaoImpl.getInstance().fetchAliasMasFromAliasName(session, aliasName);
		} catch (PMSException e) {
			log.error(e.getErrorMessage());
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public short fetchAliasIDFromAliasName(String aliasName) throws PMSException {
		log.info("--------------Start controller fetch alias id from alias name------------");
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return CommonMethodDaoImpl.getInstance().fetchAliasIDFromAliasName(session, aliasName);
		} catch (PMSException e) {
			if(e.getErrorMessage().equals("Invalid Alias Name")){
				log.error(e.getErrorMessage());
			}else{
				e.printStackTrace();
			}
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Unknown Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void updateVendorProperties(String handNextSeed, String propVal) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			CommonMethodDaoImpl.getInstance().updateVendorProperties(handNextSeed,propVal,session,tx);
		}catch (PMSException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
		}catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		
	}
	
	public AnalyticalToolMappingBean fetchAnalyticalToolProperty(Short domainId , Short aliasId , String toolName)throws PMSException{
		
		Session session = null;
		AnalyticalToolMappingBean  beanObj=null;
		try {
			session = HibernateSessionFactory.getSession();
			beanObj=daoImpl.fetchAnalyticalToolProperty(domainId,aliasId,toolName,session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Some Internal Error!");
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		
		return beanObj;
	}
	/*
	public StaticContentDataBean getStaticContentBean(ContentDataBean dataBean)
			throws PMSException {
		Session session = null;
		Transaction txn = null;
		try {
			List<String> params = null;
			CmsDaoImpl cmsDao = new CmsDaoImpl();
			CommonMethodDaoImpl commDao = CommonMethodDaoImpl.getInstance();
			CommonInfoBean infoBean = new CommonInfoBean();
			session = HibernateSessionFactory.getSession();
			txn = session.beginTransaction();
			StDmDomainAliasNameMaster aliasMaster = CommonMethodController.getInstance()
					.fetchAliasMasFromAliasName(dataBean.getServerName());
			dataBean.setAliasId(aliasMaster.getAliasId());
			StDmDomainMaster domainMaster = aliasMaster.getDomainMaster();
			dataBean.setDomainId(domainMaster.getDomainId());
			infoBean.setAliasId(aliasMaster.getAliasId());
			infoBean.setAliasName(aliasMaster.getAliasName());
			infoBean.setDomainId(domainMaster.getDomainId());
			infoBean.setDomainName(domainMaster.getDomainName());
			if ("BYDEFAULT".equals(aliasMaster.getContentList())) {
				dataBean.setAliasId((short) 1);
				aliasMaster = commDao.getAliasMaster(session,
						dataBean.getAliasId());
			}
			Map<String, String> reqParams = dataBean.getReqParams();
			if (dataBean.getReferSourceType() != null
					&& "PPC".equals(dataBean.getReferSourceType())) {
				params = cmsDao.getCampaignParams(dataBean.getReferSourceId(),
						session);
			}
			if (params != null && params.size() > 0) {
				for (int i = 0; i < params.size(); i++) {
					dataBean.getParamValues().add(reqParams.get(params.get(i)));
				}
			}
			StaticContentDataBean contentData = cmsDao.fetchContentDataBean(
					dataBean,aliasMaster.getContentType(), session);
			contentData.setDomainName(aliasMaster.getDomainMaster()
					.getDomainName());
			contentData.setAliasName(aliasMaster.getAliasName());
			infoBean = commDao.fetchInfoBean(infoBean, dataBean.getSessionId(),
					dataBean.getReqProp(), dataBean.getUrlStr(), session);
			contentData.setInfobean(infoBean);
			txn.commit();
			return contentData;
		} catch (Exception e) {
			e.printStackTrace();
			if (txn != null && txn.isActive())
				txn.rollback();
			throw new PMSException("Some Internal Error");
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
	}*/

	public Map<Short, Map<String, String>> getPokerVendorPropertiesById(
			Short aliasId) throws PMSException {
		Session session = null;
		Map<Short,Map<String,String>> pokerInfo = null;
		try{
			session = HibernateSessionFactory.getSession();
			pokerInfo = CommonMethodDaoImpl.getInstance().getPokerVendorPropertiesById(aliasId, session);
		}catch (PMSException e) {
			e.printStackTrace();
			throw new PMSException();
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return pokerInfo;
	}

	public boolean checkDomainVendorAvailable(Short domainId,String vendorCode) throws PMSException{
		
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return daoImpl.checkDomainVendorAvailable(session, domainId, vendorCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Some Internal Error");
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}		
	}

	public String fetchProgressWidth(Long playerId,Short domainId) throws PMSException {
		Session session = null;
		String widthVal = "";
		try {
			session = HibernateSessionFactory.getSession();
			widthVal=daoImpl.fetchProgressWidth(playerId,domainId,session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Some Internal Error");
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return widthVal;
	}

	public List<StRmVendorMaster> getActiveGameMap(Short aliasId) throws PMSException{
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return CommonMethodDaoImpl.getInstance().getActiveGameMap(aliasId, session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
		
	public Integer fetchLocationDeviceMapping(Short aliasId, String macAdd) throws PMSException{
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return daoImpl.fetchLocationDeviceMapping(session, macAdd, aliasId);
		} catch (PMSException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}		
	}
	
	public List<StDmAliasDeeplinkRep> getDeepLinkList(Short aliasId,String appType) throws PMSException {
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			return CommonMethodDaoImpl.getInstance().getDeepLinkList(aliasId,appType,session);
		}catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION, PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}finally{
			if (session!=null && session.isOpen()) 
				session.close();
		}
	}
	
	public StDmAliasDeeplinkRep getDeepLink(Short aliasId,String appType,String dispCode) throws PMSException{
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			return CommonMethodDaoImpl.getInstance().getDeepLink(aliasId, appType, dispCode, session).get(0);
		}catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION, PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_NO_RECORD_FOUND, PMSErrorMessage.GEN_NO_RECORD_FOUND);
		}finally{
			if (session!=null && session.isOpen()) 
				session.close();
		}
	}

	public List<StRmVendorMaster> fetchvendorInfoByAliasId(short aliasId) throws PMSException {
		Session session = null;
		List<StRmVendorMaster> list = null;
		try {
			 session = HibernateSessionFactory.getSession();
			 list = CommonMethodDaoImpl.getInstance().fetchvendorInfoByAliasId(aliasId,session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION, PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}catch(PMSException e){
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (session!=null && session.isOpen()) 
				session.close();
		}
		return list;
	}

	public Map<String, GameEngineBean> fetchGameEngineInfo(short aliasId,
			String vendorType) throws PMSException {
		Session session = null;
		Map<String,GameEngineBean> gameEngineMap = null;
		GameEngineBean gameEngineBean = null;
		try {
			session = HibernateSessionFactory.getSession();
			List<StRmVendorMaster> serverList = CommonMethodDaoImpl.getInstance().fetchvendorInfoByAliasId(aliasId,session);
			if (serverList.size() > 0) {
				for (StRmVendorMaster stRmVendorMaster : serverList) {
					if("rummy".equalsIgnoreCase(stRmVendorMaster.getVendorCode())){
						gameEngineBean = new GameEngineBean();
						gameEngineBean.setServerIp(Arrays.asList(stRmVendorMaster.getServerIp().split("\\,")));
						gameEngineBean.setServerPort(stRmVendorMaster.getServerPort());
						gameEngineBean.setServerUrl(stRmVendorMaster.getVendorDomainName());
					}
				}
			}
			gameEngineMap = new HashMap<String, GameEngineBean>();
			gameEngineMap.put(vendorType, gameEngineBean);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION, PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}catch (PMSException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return gameEngineMap;
	}
	
	public void callVCommission(short aliasId,
			long playerId,String urlType) throws PMSException {
		Session session = null;
		session = HibernateSessionFactory.getSession();
		CommonMethodDaoImpl.getInstance().callVCommission(aliasId,playerId,urlType,session);	
		
		if(session.isOpen())
			session.close();
	}
	

	public boolean isRummyActive() throws PMSException {
		Session session = null;
		boolean active;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			active = CommonMethodDaoImpl.getInstance().fetchActiveServices(session).size() == 1;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION, PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR, PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return active;
	}	

	public Long getPlayerIdByReferalCode(String referalCode) throws PMSException {
		Session session = null;
		session = HibernateSessionFactory.getSession();
		Long playerId=CommonMethodDaoImpl.getInstance().getPlayerIdByReferalCode(referalCode,session);	
		
		if(session.isOpen())
			session.close();
		
		return playerId;
	}
	

	public void callParentAdCompany(PlayerInfoBean playerInfoBean, Double amount) throws PMSException {
		log.info("Check and send information to the adversiting company who have referred this "+playerInfoBean.getUserName()+" to our site.");
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			
			ClickOnikInformer clickOnikInformer = new ClickOnikInformer(186l, playerInfoBean.getPlayerId(), amount, playerInfoBean.getCampTrckId());
			if(clickOnikInformer.checkAndinform(session)) return;
			
			CouponRajaInformer couponRajaInformer = new CouponRajaInformer(1210l, playerInfoBean.getPlayerId(), amount, playerInfoBean.getCampTrckId());
			if(couponRajaInformer.checkAndinform(session)) return;
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session.isOpen())
				session.close();
		}	
	}
	
	public List <String> fetchCampaignMap(Short domainId,Short aliasId)
			throws PMSException {
		List <String> dmCampList = null;
		Session session = null;
		try { 
			session = HibernateSessionFactory.getSession();
			dmCampList = daoImpl.fetchCampaignMap(domainId,aliasId, session);
		} catch (PMSException pmse) {
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		return dmCampList;

	}

    /**
     *
     * @param aliasId id of the alias.
     * @param awsService Type of AWS Service to to be used.
     *                   Supported services strings are "S3" for Simple Storage Service and "SNS" for Simple Notification Service.
     * @return The ASWServiceClient of the awsService type supplied. It needs to be further type-casted into specific
     *         Client type.
     * @throws PMSException if awsService is invalid.
     */
    public AmazonWebServiceClient provideAWSClient(Short aliasId, String awsService) throws PMSException{
        AWSCredentials cred=null;
        Session session=null;
        AmazonWebServiceClient client=null;
        try {
            String regionKey="AWS_"+awsService.toUpperCase()+"_REGION";
            session=HibernateSessionFactory.getSession();
            CommonMethodDaoImpl comDao=CommonMethodDaoImpl.getInstance();
            final Map<String, String> propMap = comDao.fetchSystemPropMap(session, "AWS_ACCESS_KEY_ID", "AWS_SECRET_ACCESS_KEY");
            propMap.putAll(comDao.fetchAliasPropMap(session, aliasId, regionKey));
            final String awsAccessKeyId = propMap.get("AWS_ACCESS_KEY_ID");
            final String awsSecretAccessKey = propMap.get("AWS_SECRET_ACCESS_KEY");
            //getting AWS Endpoint region.
            final Region region= Region.getRegion(Regions.fromName(propMap.get(regionKey)));
            cred=new AWSCredentials() {
                @Override
                public String getAWSAccessKeyId() {return awsAccessKeyId;}

                @Override
                public String getAWSSecretKey() {return awsSecretAccessKey;}
            };
            switch (awsService){
                case "S3":
                    if(region.isServiceSupported(AmazonS3.ENDPOINT_PREFIX)){
                        client=new AmazonS3Client(cred);
                        client.setRegion(region);
                    }else {
                        log.info("Primary AWS region ("+region.getName()+") does not supports "+awsService+" service" +
                                "\nRetrying default region: "+Regions.DEFAULT_REGION);
                        client=new AmazonS3Client(cred);
                        client.setRegion(Region.getRegion(Regions.DEFAULT_REGION));
                    }
                    break;
                case "SNS":
                    if(region.isServiceSupported(AmazonSNS.ENDPOINT_PREFIX)){
                        client=new AmazonSNSClient(cred);
                        client.setRegion(region);
                    }else {
                        log.info("Primary AWS region ("+region.getName()+") does not supports "+awsService+" service" +
                                "\nRetrying default region: "+Regions.DEFAULT_REGION);
                        client=new AmazonSNSClient(cred);
                        client.setRegion(Region.getRegion(Regions.DEFAULT_REGION));
                    }
                    break;
                case "SES":
                    if(region.isServiceSupported(AmazonSimpleEmailServiceClient.ENDPOINT_PREFIX)){
                        client=new AmazonSimpleEmailServiceClient(cred);
                        client.setRegion(region);
                    }else {
                        log.info("Primary AWS region ("+region.getName()+") does not supports "+awsService+" service" +
                                "\nRetrying default region: "+Regions.DEFAULT_REGION);
                        client=new AmazonSimpleEmailServiceClient(cred);
                        client.setRegion(Region.getRegion(Regions.DEFAULT_REGION));
                    }
                    break;
                default: throw new PMSException(PMSErrorCode.AWS_SERVICE_UNSUPPORTED,PMSErrorMessage.AWS_SERVICE_UNSUPPORTED+"(service:"+awsService+")");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR, PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
        }
        return client;
    }
    
	public StGenStateMaster fetchStateMasterByName(String stateName) {
		StGenStateMaster stateMaster = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			stateMaster = daoImpl.fetchStateMasterByName(stateName, session);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return stateMaster;
	}
	
	public Double calculateTDS(Double winning, Double wager) throws PMSException{
		Double taxableAmt = defaultIfNull(winning, 0.0)-defaultIfNull(wager, 0.0);
		//if taxable amount is less than 10000 then deduct 0.0 tds else make it 30% of taxable amt
		return (taxableAmt > 10000.0)? (0.3*taxableAmt) : 0.0; 
	}

	 public List<String> fetchAnalyticalTool(Short domainId , Short aliasId , String[] toolNames) throws PMSException {
		 Session session = null;
		 List<String> list =null;
		 try {
				session = HibernateSessionFactory.getSessionFactory().openSession();
				list= daoImpl.fetchAnalyticalTool(domainId, aliasId,toolNames,session);
			} catch (HibernateException e) {
				e.printStackTrace();
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		 return list;
		 
	 }

	 public String getServiceProperty(Short aliasId, String vendorName,String propertyName) {
		 Session session = null;
		 try {
			 session = HibernateSessionFactory.getSession();
			 Map<Short, Map<String, String>> gameServiceProp = daoImpl
					 .getVendorPropertiesById(aliasId,vendorName,session);

			 for(Short vendorId: gameServiceProp.keySet()){
				 if(gameServiceProp.get(vendorId).containsKey(propertyName)){
					 return gameServiceProp.get(vendorId).get(propertyName);
				 }
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 if(session!=null && session.isOpen())
				 session.close();
		 }
		 return "";
	 }

	public Map<String, AttendanceBean> getAttendanceReport(int empId, int companyId, String fromDate, String toDate,
			String employeeName, String companyName) {return null;}
	 
	 /***
	  * Event List for Map New Event module in back office.
	  * @param domainId
	  * @param aliasId
	  * @param channelType
	  * @return
	  * @throws PMSException
	  */
	/* public List<String> fetchEventList(short domainId,short aliasId,String channelType) throws PMSException {
			Session session = null;
			try {
				log.info("<<<<<<------:: COMMON METHOD CONTROLLER CLASS  ::------>>>>>>");
				session = HibernateSessionFactory.getSession();
				return daoImpl.fetchEventList(domainId,aliasId,channelType, session);
			} catch (Exception e) {
				log.error("<<<<<<------:: COMMON METHOD CONTROLLER CLASS EXCEPTION OCCURED  ::------>>>>>>");
				throw e;
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}*/
	 
}