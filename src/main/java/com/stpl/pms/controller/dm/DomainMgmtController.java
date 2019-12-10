package com.stpl.pms.controller.dm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.daoImpl.dm.DomainMgmtDaoImpl;
import com.stpl.pms.daoImpl.um.UserMgmtDaoImpl;
import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.StDmDomainDeviceMaster;
import com.stpl.pms.hibernate.mapping.StDmDomainLocationDeviceMapping;
import com.stpl.pms.hibernate.mapping.StDmDomainLocationMaster;
import com.stpl.pms.hibernate.mapping.StGenSmsEmailProviderMaster;
import com.stpl.pms.hibernate.mapping.StGenVerificationSourceMaster;
import com.stpl.pms.hibernate.mapping.StPmReferenceLabelOptionMapping;
import com.stpl.pms.hibernate.mapping.StPmReferenceMaster;
import com.stpl.pms.hibernate.mapping.StPmSecurityQuesMaster;
import com.stpl.pms.hibernate.mapping.StPortalLayoutMaster;
import com.stpl.pms.javabeans.AliasPropertyBean;
import com.stpl.pms.javabeans.CountryBean;
import com.stpl.pms.javabeans.CountryStateBean;
import com.stpl.pms.javabeans.DeviceMasterBean;
import com.stpl.pms.javabeans.DomainPropertyBean;
import com.stpl.pms.javabeans.LanguageBean;
import com.stpl.pms.javabeans.LocDevMappingBean;
import com.stpl.pms.javabeans.LocationMaster;
import com.stpl.pms.javabeans.MenuContentBean;
import com.stpl.pms.javabeans.MenuDataBean;
import com.stpl.pms.javabeans.PortalMenuBean;
import com.stpl.pms.javabeans.PrivFunctionBean;
import com.stpl.pms.javabeans.ReferenceInfoBean;
import com.stpl.pms.javabeans.SecurityQuesInfoBean;
import com.stpl.pms.javabeans.UserDetailsBean;
import com.stpl.pms.javabeans.UserInfoBean;

public class DomainMgmtController {
	private static final Logger log = Logger.getLogger(DomainMgmtController.class);
	
	public Map<String, Object> fetchDomainRegistrationMaps() throws PMSException {
		log.info("---fetching password policies----");
		Session session = null;
		Map<String, Object> allMaps = new HashMap<String, Object>();
		DomainMgmtDaoImpl dao;
		try {
			session = HibernateSessionFactory.getSession();
			dao = new DomainMgmtDaoImpl();
			Map<Integer, String> policyMap = dao.getPasswordPolicyMap(session);
			allMaps.put("policyMap", policyMap);
			Map<String, CountryBean> countryMap = dao.fetchCountryStateMasterMap(session);
			allMaps.put("countryMap", countryMap);
			HashMap<Short, String> serviceMap = dao.getServiceMap(session);
			allMaps.put("serviceMap", serviceMap);
			HashMap<Integer, LanguageBean> langMap = dao.getLangMap(session);
			allMaps.put("langMap", langMap);
			Map<Short, StGenVerificationSourceMaster> autoVeriPropMap = dao.getAutoVeriProp(session);
			allMaps.put("autoVeriPropMap", autoVeriPropMap);
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return allMaps;
	}

	public boolean checkDomainNameAvailability(String domainName)
			throws PMSException {
		log.info("---Checking domain name availability----");
		Session session = null;
		DomainMgmtDaoImpl dao;
		try {
			session = HibernateSessionFactory.getSession();
			dao = new DomainMgmtDaoImpl();
			return dao.checkDomainNameAvailability(domainName, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void domainRegSave(DomainPropertyBean domainBean,
			UserInfoBean userInfoBean, UserDetailsBean userDetail, long userId,
			String[] rolePriv,int[] mappingId,int[] privCount ,String[] rolePrivRUMMY )
			throws PMSException {
		Session session = null;
		Transaction tx = null;
		DomainMgmtDaoImpl domainMgmtImpl = new DomainMgmtDaoImpl();
		CommonMethodDaoImpl commonMethodDaoImpl = CommonMethodDaoImpl
				.getInstance();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Map<String, String> domainMap = commonMethodDaoImpl
					.getDmPropertyMap(session, (short) 1, "defaultVipLevel",
							"checkRg");
			Short domainId = domainMgmtImpl.domainRegSave(domainBean,
					domainMap, session, userId);

			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			String password = daoImpl.createDomainUser(userInfoBean, userDetail
					.getUserName(), "ACTIVE", userDetail.getSecQues(),
					userDetail.getSecAns(), userDetail.getFirstName(),
					userDetail.getLastName(), userDetail.getGender(),
					userDetail.getEmailId(), userDetail.getPhoneNbr(), "2", "",
					session, domainId, "DOMAIN", rolePriv, mappingId, privCount,rolePrivRUMMY);

			Map<String, String> emailContentMap = new LinkedHashMap<String, String>();
			emailContentMap.put("EmailId", userDetail.getEmailId());
			emailContentMap.put("FirstName", userDetail.getFirstName());
			emailContentMap.put("UserName", userDetail.getUserName());
			emailContentMap.put("UserPassword", password);
//			CommMgmtController.callSendMail(emailContentMap,"BO_USER_REGISTRATION", domainId,(short)1,userDetail.getUserId(),session);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void getdomainEditSave(DomainPropertyBean domainBean, long userId)
			throws PMSException {
		Session session = null;
		Transaction tx = null;
		DomainMgmtDaoImpl domainMgmtImpl = new DomainMgmtDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			domainMgmtImpl.domainEditSave(domainBean, session, userId);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	public List<ReferenceInfoBean> loadReferenceList(Short domainId)
			throws PMSException {
		DomainMgmtDaoImpl domainMgmtImpl = new DomainMgmtDaoImpl();
		List<StPmReferenceMaster> list = null;
		List<StPmReferenceLabelOptionMapping> list1 = null;
		List<ReferenceInfoBean> result = new ArrayList<ReferenceInfoBean>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			list = domainMgmtImpl.fetchReferenceFields(domainId, session);
			list1 = domainMgmtImpl
					.fetchReferenceLabeleValues(domainId, session);
			for (StPmReferenceMaster stPmReferenceMaster : list) {
				ReferenceInfoBean referenceInfoBean = new ReferenceInfoBean();
				referenceInfoBean.setReferenceId(stPmReferenceMaster
						.getReferenceId());
				referenceInfoBean.setReferenceName(stPmReferenceMaster
						.getReferenceName());
				referenceInfoBean.setDisplayName(stPmReferenceMaster
						.getReferenceDispName());
				referenceInfoBean.setRefTxtLabel1(stPmReferenceMaster
						.getRefTxtLabel1());
				referenceInfoBean.setRefTxtLabel2(stPmReferenceMaster
						.getRefTxtLabel2());
				referenceInfoBean.setRefTxtLabel3(stPmReferenceMaster
						.getRefTxtLabel3());
				referenceInfoBean.setRefTxtLabel1Type(stPmReferenceMaster
						.getRefTxtLabel1Type());
				referenceInfoBean.setRefTxtLabel2Type(stPmReferenceMaster
						.getRefTxtLabel2Type());
				referenceInfoBean.setRefTxtLabel3Type(stPmReferenceMaster
						.getRefTxtLabel3Type());
				for (StPmReferenceLabelOptionMapping referenceLabelOptionMapping : list1) {
					if (stPmReferenceMaster.getReferenceId().equals(
							referenceLabelOptionMapping.getReferenceId())) {
						if (referenceLabelOptionMapping.getLabelName().equals(
								"ref_txt_label_1")) {
							referenceInfoBean.getLabelInfoBean1().getId().add(
									referenceLabelOptionMapping.getId());
							referenceInfoBean.getLabelInfoBean1()
									.getValueList().add(
											referenceLabelOptionMapping
													.getLabelOptionValue());
							referenceInfoBean.getLabelInfoBean1()
									.getStatusList().add(
											referenceLabelOptionMapping
													.getStatus());
						}
						if (referenceLabelOptionMapping.getLabelName().equals(
								"ref_txt_label_2")) {
							referenceInfoBean.getLabelInfoBean2().getId().add(
									referenceLabelOptionMapping.getId());
							referenceInfoBean.getLabelInfoBean2()
									.getValueList().add(
											referenceLabelOptionMapping
													.getLabelOptionValue());
							referenceInfoBean.getLabelInfoBean2()
									.getStatusList().add(
											referenceLabelOptionMapping
													.getStatus());
						}
						if (referenceLabelOptionMapping.getLabelName().equals(
								"ref_txt_label_3")) {
							referenceInfoBean.getLabelInfoBean3().getId().add(
									referenceLabelOptionMapping.getId());
							referenceInfoBean.getLabelInfoBean3()
									.getValueList().add(
											referenceLabelOptionMapping
													.getLabelOptionValue());
							referenceInfoBean.getLabelInfoBean3()
									.getStatusList().add(
											referenceLabelOptionMapping
													.getStatus());
						}
					}
				}
				referenceInfoBean.setStatus(stPmReferenceMaster.getStatus());
				referenceInfoBean.setCreatedBy(stPmReferenceMaster.getCreatedBy());
				referenceInfoBean.setCreationTime(stPmReferenceMaster.getCreationTime());
				result.add(referenceInfoBean);

			}
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return result;
	}

	/*********/
	public List<StPortalLayoutMaster> getLayoutMap(
			PrivFunctionBean privFunctionBean) throws PMSException {
		Session session = null;
		Transaction tx = null;
		DomainMgmtDaoImpl domainMgmtImpl = new DomainMgmtDaoImpl();
		List<StPortalLayoutMaster> Map = new ArrayList<StPortalLayoutMaster>();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			if (privFunctionBean.getFunctionSet().contains("getLayoutMap")) {
				Map = domainMgmtImpl.getLayoutMap(session);
			}
			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Some Internal Error!");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return Map;

	}

	public void setReferralList(Short domainId,
			List<ReferenceInfoBean> referenceInfoBeans, long userId) throws PMSException {
		DomainMgmtDaoImpl domainMgmtImpl = new DomainMgmtDaoImpl();
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String domain = CommonMethodDaoImpl.getInstance().getDmProperty(
					session, domainId, "referralList");
			referenceInfoBeans = domainMgmtImpl.setReferralList(domainId,
					referenceInfoBeans, session, userId,domain);
			domainMgmtImpl.setReferralLabels(domainId, referenceInfoBeans,
					domain, session);
			tx.commit();

		} catch (PMSException pmse) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	public List<SecurityQuesInfoBean> fetchSecQues(Short domainId)
			throws PMSException {
		DomainMgmtDaoImpl domainMgmtImpl = new DomainMgmtDaoImpl();
		List<SecurityQuesInfoBean> result = new ArrayList<SecurityQuesInfoBean>();
		Session session = null;
		List<StPmSecurityQuesMaster> list = new ArrayList<StPmSecurityQuesMaster>();

		try {
			session = HibernateSessionFactory.getSession();
			list = domainMgmtImpl.fetchSecQues(domainId, session);
			UserMgmtDaoImpl userMgmtDaoImpl = new UserMgmtDaoImpl();
			for (StPmSecurityQuesMaster stPmSecurityQuesMaster : list) {
				SecurityQuesInfoBean securityQuesInfoBean = new SecurityQuesInfoBean();
				securityQuesInfoBean.setSecQues(stPmSecurityQuesMaster
						.getSecQues());
				securityQuesInfoBean.setDisplayName(stPmSecurityQuesMaster
						.getSecQuesDispName());
				securityQuesInfoBean.setAddedBy(stPmSecurityQuesMaster
						.getAddedBy());
				securityQuesInfoBean.setStatus(stPmSecurityQuesMaster
						.getStatus());
				securityQuesInfoBean.setUserId(stPmSecurityQuesMaster
						.getUserId().longValue());
				securityQuesInfoBean.setUserName(userMgmtDaoImpl
						.getUserNameById(session, stPmSecurityQuesMaster
								.getUserId().intValue()));
				result.add(securityQuesInfoBean);
			}
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return result;

	}

	public void setSecQuesList(Short domainId,
			List<SecurityQuesInfoBean> quesInfoBeans, long userId) throws PMSException {
		DomainMgmtDaoImpl domainMgmtImpl = new DomainMgmtDaoImpl();
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			domainMgmtImpl.setSecQuesList(domainId, quesInfoBeans, session, userId);
			tx.commit();

		} catch (PMSException pmse) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public List<CountryBean> fetchDomainCountryList(Short domainId)
			throws PMSException {
		DomainMgmtDaoImpl domainMgmtImpl = new DomainMgmtDaoImpl();
		Session session = null;
		List<CountryBean> countryBeanList = new ArrayList<CountryBean>();
		try {
			session = HibernateSessionFactory.getSession();
			if ("BYDEFAULT".equals(CommonMethodDaoImpl.getInstance()
					.getDmProperty(session, domainId, "allowedCountries"))) {
				domainId = 1;
			}
			countryBeanList = domainMgmtImpl.fetchDomainCountryList(domainId,
					session,false);
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return countryBeanList;
	}

	public void setAllowedCountryState(Short domainId,
			CountryStateBean countryStateBean,long userId) throws PMSException {
		DomainMgmtDaoImpl domainMgmtImpl = new DomainMgmtDaoImpl();
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			domainMgmtImpl.setAllowedCountryState(domainId, countryStateBean,
					 session, userId);
			tx.commit();
		} catch (PMSException pmse) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	// menu

	public Map<Integer, String> getContentList(String contentType)
			throws PMSException {
		DomainMgmtDaoImpl domainMgmtDaoImpl = new DomainMgmtDaoImpl();
		Session session = HibernateSessionFactory.getSession();
		Map<Integer, String> contentList = new HashMap<Integer, String>();
		try {
			contentList = domainMgmtDaoImpl
					.getContentList(contentType, session);
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return contentList;
	}

	public Map<String, List<MenuContentBean>> getPortalContentMap(Short aliasId, String device)
			throws PMSException {
		DomainMgmtDaoImpl domainMgmtDaoImpl = new DomainMgmtDaoImpl();
		Session session = HibernateSessionFactory.getSession();
		Map<String, List<MenuContentBean>> contentMap = new HashMap<String, List<MenuContentBean>>();
		try {
			if ("BYDEFAULT".equals(CommonMethodDaoImpl.getInstance()
					.getDmAliasProperty(session, aliasId, "contentList"))) {
				aliasId = 1;
			}
			contentMap = domainMgmtDaoImpl.getPortalContentMap(aliasId, device, session);
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return contentMap;
	}
	
	public void submitAddMenuDetail(MenuDataBean menuDataBean, short domainId, short aliasId,
			String device, long userId) throws PMSException {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		try {
			DomainMgmtDaoImpl domainMgmtDaoImpl = new DomainMgmtDaoImpl();
			String menulList = CommonMethodDaoImpl.getInstance().getDmAliasProperty(
					session, aliasId, "menuList");
			domainMgmtDaoImpl.submitAddMenuDetail(menuDataBean,
					domainId, aliasId, device, menulList, session, userId);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw new PMSException("Execption occur in submit menu detail");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void submitEditMenu(MenuDataBean menuDataBean, short domainId,
			short aliasId, String device, long userId) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		try {
			DomainMgmtDaoImpl domainMgmtDaoImpl = new DomainMgmtDaoImpl();
			String menulList = CommonMethodDaoImpl.getInstance().getDmAliasProperty(
					session, aliasId, "menuList");
			domainMgmtDaoImpl.submitEditMenu(menuDataBean,
					domainId, aliasId, device, menulList, session, userId);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
		} catch (PMSException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}
	
	public List<PortalMenuBean> fetchMenuBeanList(Short aliasId, String device)
			throws PMSException {
		Session session = HibernateSessionFactory.getSession();
		CommonMethodDaoImpl daoImpl = CommonMethodDaoImpl.getInstance();
		if ("BYDEFAULT".equals(daoImpl.getDmAliasProperty(session, aliasId,
				"menuList"))) {
			aliasId = 1;
		}
		List<PortalMenuBean> menuString = daoImpl.fetchBeanMenuList(aliasId,
				device, session);
		return menuString;
	}

	public DomainPropertyBean fetchDomainProperties(Short domainId)
			throws PMSException {
		DomainMgmtDaoImpl domainMgmtImpl = new DomainMgmtDaoImpl();
		Session session = null;
		DomainPropertyBean bean = null;
		try {
			session = HibernateSessionFactory.getSession();
			bean = domainMgmtImpl.fetchDomainProperties(session, domainId);
		} catch (PMSException pmse) {
			throw pmse;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return bean;
	}
	
	public Map<String, String> showCheckList(Short domainId)throws PMSException {
		DomainMgmtDaoImpl domainMgmtImpl = new DomainMgmtDaoImpl();
		Session session = null;
		try {
				session = HibernateSessionFactory.getSession();
				return domainMgmtImpl.showCheckListMap(domainId,session);
		} catch (PMSException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	
	public Map<String, String> activeReportsList(short domainId)
			throws PMSException {
		DomainMgmtDaoImpl domainMgmtDaoImpl = new DomainMgmtDaoImpl();
		Session session = null;
		Map<String, String> activeReportsList = null;
		try {
			session = HibernateSessionFactory.getSession();
			activeReportsList = domainMgmtDaoImpl.activeReportsList(domainId,
					session);
		} catch (HibernateException se) {
			se.printStackTrace();
			throw new PMSException("Hibernate Exeption");
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return activeReportsList;
	}

	public void activeReportListSave(short domainId,
			Map<String, String> activeMap) throws PMSException {
		Session session = null;
		Transaction tx = null;
		try {
			DomainMgmtDaoImpl daoImpl = new DomainMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			daoImpl.activeReportListSave(domainId, activeMap, session);
			session.flush();
			tx.commit();
		} catch (HibernateException se) {
			if (tx != null && tx.isActive())
				tx.rollback();
			se.printStackTrace();
			throw new PMSException("Hibernate Exeption");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public boolean checkAliasNameAvailability(String aliasName)
			throws PMSException {
		log.info("---Checking Alias name availability----");
		Session session = null;
		DomainMgmtDaoImpl dao;
		try {
			session = HibernateSessionFactory.getSession();
			dao = new DomainMgmtDaoImpl();
			return dao.checkAliasNameAvailability(aliasName, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void saveAlias(String aliasName,AliasPropertyBean aliasBean)throws PMSException{
		log.info("---Save Alias ----");
		Session session = null;
		DomainMgmtDaoImpl dao;
		try {
			session = HibernateSessionFactory.getSession();
			dao = new DomainMgmtDaoImpl();
			 dao.saveAlias(aliasName, aliasBean,session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	
	public List<StGenSmsEmailProviderMaster> searchSmsEmailProviderOptions(
			short domainId, short aliasId,String procviderType) throws PMSException {
		Session session = null;
		List<StGenSmsEmailProviderMaster> emailList = null;
		try {
			session = HibernateSessionFactory.getSession();
			DomainMgmtDaoImpl daoImpl = new DomainMgmtDaoImpl();
			emailList = daoImpl.searchSmsEmailProviderOptions(domainId, aliasId,procviderType,
				 session);
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return emailList;
	}
	
	
	public void updateEmailProviderOrder(Map<String, String> emailProviderOrder,
			UserInfoBean userInfo) throws PMSException {
		Session session = null;
		Transaction tx = null;
		DomainMgmtDaoImpl daoImpl = new DomainMgmtDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			daoImpl.updateOrder( emailProviderOrder, userInfo,session);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Unknown Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public List<LocationMaster> fetchLocations(short domainId) throws PMSException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			List<StDmDomainLocationMaster> locMaster = new DomainMgmtDaoImpl().fetchLocations(session, domainId, null);
			List<LocationMaster> list = new ArrayList<LocationMaster>();
			for (StDmDomainLocationMaster locMas : locMaster) {
				LocationMaster loc = new LocationMaster(locMas.getLocationId(), locMas.getDomainId(), locMas.getFullName(),
						locMas.getLocationName(), locMas.getAddress(), locMas.getEmail(), locMas.getMobileNo(), locMas.getLandlineNo(),locMas.getStatus());
				list.add(loc);
			}
			return list;
		}catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public List<DeviceMasterBean> fetchAllDevices(short aliasId) throws PMSException{
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			List<StDmDomainDeviceMaster> deviceMasList = new DomainMgmtDaoImpl().fetchAllDevices(session,aliasId, null);
			List<DeviceMasterBean> list = new ArrayList<DeviceMasterBean>();
			for (StDmDomainDeviceMaster devMas : deviceMasList) {
				DeviceMasterBean dev = new DeviceMasterBean(devMas);
				list.add(dev);
			}
			return list;
		}catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void updateLocation(LocationMaster locMaster){
		Session session = null;
		Transaction tx = null;
		
		try {
			session  = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			new DomainMgmtDaoImpl().updateLocation(session, locMaster);
			tx.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void updLocStatus(Integer locId[], String status) throws PMSException {
		Session session = null;
		Transaction tx = null;
		try {
			session  = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			new DomainMgmtDaoImpl().updLocStatus(session, locId, status);
			tx.commit();			
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException(e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException(e.getMessage(), e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void updDeviceStatus(Integer devId[], String status) throws PMSException {
		Session session = null;
		Transaction tx = null;
		try {
			session  = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			new DomainMgmtDaoImpl().updDeviceStatus(session, devId, status);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException(e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException(e.getMessage(), e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void updateDevices(DeviceMasterBean devMaster,Short aliasId){
		Session session = null;
		Transaction tx = null;
		try {
			session  = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			new DomainMgmtDaoImpl().updateDevices(session, devMaster,aliasId);
			tx.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public List<LocDevMappingBean> fetchLocDevMapping(short aliasId)
			throws PMSException {
		Session session = null;
		try {
			List<LocDevMappingBean> mappingList = new ArrayList<LocDevMappingBean>();
			session = HibernateSessionFactory.getSession();
			List<StDmDomainLocationDeviceMapping> devMapping = new DomainMgmtDaoImpl()
					.fetchLocDevMapping(session, aliasId);
			LocDevMappingBean bean = null;
			for (StDmDomainLocationDeviceMapping map : devMapping) {
				bean = new LocDevMappingBean(map.getId(), map.getAliasId(),
						new DeviceMasterBean(map.getLocDevices()),
						new LocationMaster(map.getLocMaster()),
						map.getStatus(), map.getCreatedBy(),
						map.getCreationTime(), map.getLastUpdatedBy(),
						map.getLastUpdationTime());
				mappingList.add(bean);
			}
			return mappingList;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void updDevMapStatus(Integer devMapId[], String status) throws PMSException {
		Session session = null;
		Transaction tx = null;
		try {
			session  = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			new DomainMgmtDaoImpl().updDevMapStatus(session, devMapId, status);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException(e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException(e.getMessage(), e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public List<Object> fetchLocDevList(short domainId, String status,Short alaisId)
			throws PMSException {
		Session session = null;
		try {
			DomainMgmtDaoImpl cont = new DomainMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			List<Object> locDevList = new ArrayList<Object>();
			locDevList.add(cont.fetchLocations(session, domainId, status));
			locDevList.add(cont.fetchDevices(session, status,alaisId));
			return locDevList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void updSaveDevMapping(LocDevMappingBean locDevMap,  long userId){
		Session session = null;
		Transaction tx = null;
		try {
			session  = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			new DomainMgmtDaoImpl().updSaveDevMapping(session, locDevMap, userId);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	@SuppressWarnings("rawtypes")
	public boolean checkUniqueMAC(String macAddress, int deviceId) {
		Session session=null;
		List list=null;
		try {
			session=HibernateSessionFactory.getSession();
			list=new DomainMgmtDaoImpl().checkUniqueMAC(macAddress,deviceId, session);
			return list.size()>0?false:true;
		} catch (Exception e) {
				e.printStackTrace();
				return false;
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public boolean checkUniqueDevName(Short aliasId,String deviceName, int deviceId) {
		Session session=null;
		List list=null;
		try {
			session=HibernateSessionFactory.getSession();
			list=new DomainMgmtDaoImpl().checkUniqueDevName(aliasId,deviceName,deviceId, session);
			return list.size()>0?false:true;
		} catch (Exception e) {
				e.printStackTrace();
				return false;
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public boolean checkUniqueLocName(String locationName, int locationId) {
		Session session=null;
		List list=null;
		try {
			session=HibernateSessionFactory.getSession();
			list=new DomainMgmtDaoImpl().checkUniqueLocName(locationName,locationId, session);
			return list.size()>0?false:true;
		} catch (Exception e) {
				e.printStackTrace();
				return false;
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Map<String, Object> fetchActiveDeviceLocation(short domainId,short aliasId) {
		Session session=null;
		try {
			session=HibernateSessionFactory.getSession();
			DomainMgmtDaoImpl dao=new DomainMgmtDaoImpl();
			Map<String,Object> locDevMap= new HashMap<String, Object>();
			locDevMap.put("locations",dao.fetchLocations(session, domainId, "ACTIVE"));
			locDevMap.put("devices",dao.fetchDevices(session, "ACTIVE",aliasId));
			return locDevMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(session !=null && session.isOpen())
				session.close();
		}
	}
}