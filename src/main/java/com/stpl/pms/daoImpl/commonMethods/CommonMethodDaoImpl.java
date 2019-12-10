package com.stpl.pms.daoImpl.commonMethods;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.transform.Transformers;

import com.stpl.pms.adv.ClickOnikInformer;
import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.MenuMasterView;
import com.stpl.pms.hibernate.mapping.StCmsTemplateMaster;
import com.stpl.pms.hibernate.mapping.StCmsUploadContentMaster;
import com.stpl.pms.hibernate.mapping.StDmAliasAnalyticalToolMapping;
import com.stpl.pms.hibernate.mapping.StDmAliasDeeplinkRep;
import com.stpl.pms.hibernate.mapping.StDmAliasPropertyMaster;
import com.stpl.pms.hibernate.mapping.StDmBlockedEmailId;
import com.stpl.pms.hibernate.mapping.StDmBlockedIp;
import com.stpl.pms.hibernate.mapping.StDmBlockedPhoneNo;
import com.stpl.pms.hibernate.mapping.StDmDomainAliasNameMaster;
import com.stpl.pms.hibernate.mapping.StDmDomainCountryMapping;
import com.stpl.pms.hibernate.mapping.StDmDomainCurrencyMapping;
import com.stpl.pms.hibernate.mapping.StDmDomainLanguageMapping;
import com.stpl.pms.hibernate.mapping.StDmDomainLocationDeviceMapping;
import com.stpl.pms.hibernate.mapping.StDmDomainMaster;
import com.stpl.pms.hibernate.mapping.StDmDomainStateMapping;
import com.stpl.pms.hibernate.mapping.StDmDomainWalletMapping;
import com.stpl.pms.hibernate.mapping.StGenAppVersionDetails;
import com.stpl.pms.hibernate.mapping.StGenCityMaster;
import com.stpl.pms.hibernate.mapping.StGenCountryMaster;
import com.stpl.pms.hibernate.mapping.StGenCurrencyConversionRate;
import com.stpl.pms.hibernate.mapping.StGenCurrencyMaster;
import com.stpl.pms.hibernate.mapping.StGenLanguageMaster;
import com.stpl.pms.hibernate.mapping.StGenPasswordPolicy;
import com.stpl.pms.hibernate.mapping.StGenPropertyMaster;
import com.stpl.pms.hibernate.mapping.StGenSchedulerRunStatus;
import com.stpl.pms.hibernate.mapping.StGenSmsEmailProviderMaster;
import com.stpl.pms.hibernate.mapping.StGenStateMaster;
import com.stpl.pms.hibernate.mapping.StGenVariableMaster;
import com.stpl.pms.hibernate.mapping.StGenWordSentenceMaster;
import com.stpl.pms.hibernate.mapping.StOfflineAffiliateMaster;
import com.stpl.pms.hibernate.mapping.StPmAvtaarMaster;
import com.stpl.pms.hibernate.mapping.StPmPlayerGetSetOfferDetail;
import com.stpl.pms.hibernate.mapping.StPmPlayerMaster;
import com.stpl.pms.hibernate.mapping.StPmPlayerReferralContactList;
import com.stpl.pms.hibernate.mapping.StPmPlayerReferralMaster;
import com.stpl.pms.hibernate.mapping.StPmPlrLoginStatus;
import com.stpl.pms.hibernate.mapping.StPortalContentMaster;
import com.stpl.pms.hibernate.mapping.StPortalDeviceDomainMapping;
import com.stpl.pms.hibernate.mapping.StPortalMenuMaster;
import com.stpl.pms.hibernate.mapping.StPortalPathMaster;
import com.stpl.pms.hibernate.mapping.StPortalPriviledgeRep;
import com.stpl.pms.hibernate.mapping.StRmBoUserLoginStatus;
import com.stpl.pms.hibernate.mapping.StRmBoUserMaster;
import com.stpl.pms.hibernate.mapping.StRmDomainAliasVendorMapping;
import com.stpl.pms.hibernate.mapping.StRmServiceMaster;
import com.stpl.pms.hibernate.mapping.StRmServiceVendorProperties;
import com.stpl.pms.hibernate.mapping.StRmVendorMaster;
import com.stpl.pms.hibernate.mapping.StTxnPlrBonusDetails;
import com.stpl.pms.hibernate.mapping.StTxnPlrDepositMaster;
import com.stpl.pms.hibernate.mapping.StVipCriteriaCurrentStatusDeposit;
import com.stpl.pms.hibernate.mapping.StVipCriteriaCurrentStatusWagerRummy;
import com.stpl.pms.hibernate.mapping.StVipCriteriaCurrentStatusWithdrawal;
import com.stpl.pms.hibernate.mapping.StVipLevelMaster;
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
import com.stpl.pms.javabeans.PortalMenuBean;
import com.stpl.pms.javabeans.PortalPropertyBean;
import com.stpl.pms.javabeans.StateBean;
import com.stpl.pms.javabeans.UrlTagBean;
import com.stpl.pms.javabeans.UserInfoBean;
import com.stpl.pms.javabeans.VendorAuthInfoBean;
import com.stpl.pms.javabeans.VendorInfoBean;
import com.stpl.pms.javabeans.VipLevelMasterBean;
import com.stpl.pms.javabeans.WordSentenceBean;
import com.stpl.pms.utility.RandomString;
import com.stpl.pms.utility.Utility;
import com.stpl.pms.utility.VCommissionThread;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class CommonMethodDaoImpl {

	private static Logger log = Logger.getLogger(CommonMethodDaoImpl.class);
	static RandomString random=new RandomString(5);
	private static CommonMethodDaoImpl singleton;

	private CommonMethodDaoImpl() {
	}

	public static CommonMethodDaoImpl getInstance() {
		if(singleton == null) {
			singleton = new CommonMethodDaoImpl();
		}
		return singleton;
	}

	public static Comparator<PortalMenuBean> menuSortComparator = new Comparator<PortalMenuBean>() {
		public int compare(PortalMenuBean obj1, PortalMenuBean obj2) {
			// log.info(obj1.getMiniRegSeqNo()-obj2.getMiniRegSeqNo());
			// ascending order
			return obj1.getOrderBy() - obj2.getOrderBy();
			// descending order
			// return obj2.getMiniRegSeqNo()-obj1.getMiniRegSeqNo();
		}
	};

	@SuppressWarnings("unchecked")
	public String fetchSystemProperties(String propName, Session session)
			throws PMSException {
		String value = null;
		try {
			Criteria cri = session.createCriteria(StGenPropertyMaster.class);
			cri.setCacheable(true);
			cri.setCacheRegion("StGenPropertyMasterCache");
			cri.setProjection(Projections.property("value"));
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.add(Restrictions.eq("propertyCode", propName));
			List<Object> objList = cri.list();
			if (objList.size() > 0) {
				value = (String) objList.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		log.info(propName + "---System Property--" + value);
		return value;
	}
	
	@SuppressWarnings("unchecked")
	public String fetchAliasProperty(String propName,short aliasId,Session session) throws PMSException{
		String value = null;
		try{
			Criteria cri = session.createCriteria(StDmAliasPropertyMaster.class);
			cri.add(Restrictions.eq("aliasId", aliasId));
			cri.add(Restrictions.eq("propertyName", propName));
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.setProjection(Projections.property("propertyValue"));
			List<Object> list = cri.list();
			if(list.size()>0) {
				value = (String)list.get(0);
			}
		}catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		log.info("Alias Property:"+propName);
		return value;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<CurrencyBean> fetchDomainCurrencyList(short domainId,
			Session session) throws PMSException {
		List<CurrencyBean> dmCurrList = null;
		CurrencyBean currencyBean = null;
		try {
			Criteria cri = session
					.createCriteria(StDmDomainCurrencyMapping.class)
					.setCacheable(true);
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.add(Restrictions.eq("domainId", domainId));
			List<StDmDomainCurrencyMapping> list = cri.list();
			if (list.size() > 0) {
				dmCurrList = new ArrayList<CurrencyBean>();
				for (StDmDomainCurrencyMapping mapping : list) {
					currencyBean = new CurrencyBean();
					currencyBean.setCurrencyId(mapping.getCurrencyMaster()
							.getCurrencyId());
					currencyBean.setCurrCode(mapping.getCurrencyMaster()
							.getCurrencyCode());
					currencyBean.setCurrName(mapping.getCurrencyMaster()
							.getCurrencyDescription());
					dmCurrList.add(currencyBean);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return dmCurrList;
	}

	@SuppressWarnings("unchecked")
	public Map<Integer, CurrencyBean> fetchCurrencyMasterMap(Session session)
			throws PMSException {
		Map<Integer, CurrencyBean> currencyMasterMap = new HashMap<Integer, CurrencyBean>();
		CurrencyBean currencyBean = null;
		try {
			Criteria cri = session.createCriteria(StGenCurrencyMaster.class)
					.setCacheable(true);
			List<StGenCurrencyMaster> list = cri.list();
			for (StGenCurrencyMaster curMas : list) {
				currencyBean = new CurrencyBean();
				currencyBean.setCurrencyId(curMas.getCurrencyId());
				currencyBean.setCurrCode(curMas.getCurrencyCode());
				currencyBean.setCurrName(curMas.getCurrencyDescription());
				currencyMasterMap.put(curMas.getCurrencyId(), currencyBean);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");

		}
		return currencyMasterMap;
	}

	@SuppressWarnings("unchecked")
	public Map<Integer, String> fetchCurrencyMasterMap(Session session,short domainId)
			throws PMSException {
		Map<Integer, String> currencyMap;
		try {
			currencyMap = new HashMap<>();
			Criteria cri = session.createCriteria(StDmDomainCurrencyMapping.class).
					add(Restrictions.eq("domainId",domainId)).
					add(Restrictions.eq("status","ACTIVE"));
			List<StDmDomainCurrencyMapping> list = cri.list();
			if(list.size()>0) {
				for (StDmDomainCurrencyMapping curMapping : list) {
					currencyMap.put(curMapping.getCurrencyMaster().getCurrencyId(),
							curMapping.getCurrencyMaster().getCurrencyCode());
				}
			}else{
				log.info(" Domain Not Found for domain Id for currency :: "+domainId);
				throw new PMSException(PMSErrorCode.DOMAIN_NOT_VAILD,PMSErrorMessage.DOMAIN_NOT_VAILD);
			}
		} catch (HibernateException e) {
			log.error(e.getMessage(),e);
			throw new PMSException("Hibernate Exception");
		}
		return currencyMap;
	}

	@SuppressWarnings("unchecked")
	public CurrencyBean fetchCurrencyMasterBean(Integer currId, Session session)
			throws PMSException {

		CurrencyBean currencyBean = null;
		try {
			Criteria cri = session.createCriteria(StGenCurrencyMaster.class);
			cri.add(Restrictions.eq("currencyId", currId))
			.setCacheable(true);
			List<StGenCurrencyMaster> list = cri.list();
			for (StGenCurrencyMaster curMas : list) {
				currencyBean = new CurrencyBean();
				currencyBean.setCurrencyId(curMas.getCurrencyId());
				currencyBean.setCurrCode(curMas.getCurrencyCode());
				currencyBean.setCurrName(curMas.getCurrencyDescription());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");

		}
		return currencyBean;
	}

	@SuppressWarnings("unchecked")
	public CurrencyConversionDefBean fetchUpdateCurrencyConversionRate(
			Integer fromCurId, Integer toCurId, Session session)
			throws PMSException {
		CurrencyConversionDefBean currConvBean = null;
		try {
			Criteria cri = session
					.createCriteria(StGenCurrencyConversionRate.class);
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.add(Restrictions.eq("fromCurrencyId", fromCurId));
			cri.add(Restrictions.eq("toCurrencyId", toCurId));
			List<StGenCurrencyConversionRate> list = cri.list();
			if (list.size() > 0) {
				for (StGenCurrencyConversionRate convRate : list) {
					currConvBean = new CurrencyConversionDefBean();
					currConvBean.setCurrencyId(convRate.getToCurrencyId());
					currConvBean.setExchangeChargeCurrId(convRate
							.getExchangeChargeCurrencyId());
					currConvBean
							.setExchangeCharge(convRate.getExchangeCharge());
					currConvBean.setExchangeRate(convRate.getExchangeRate());
				}
			} else {
				throw new PMSException("Exchange Rate not found");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return currConvBean;
	}

	@SuppressWarnings("unchecked")
	public String fetchDomainDeviceAlias(short domainId, String device,
			Session session) throws PMSException {
		String aliasName = null;
		try {
			Criteria cri = session
					.createCriteria(StPortalDeviceDomainMapping.class);
			cri.setCacheable(true);
			cri.setCacheRegion("StPortalDeviceDomainMappingCache");
			cri.createAlias("domainMaster", "dm");
			cri.add(Restrictions.eq("dm.domainId", domainId));
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.add(Restrictions.eq("device", device));
			List<StPortalDeviceDomainMapping> list = cri.list();
			StPortalDeviceDomainMapping mapping = null;
			if (!list.isEmpty()) {
				mapping = list.get(0);
				aliasName = mapping.getDomainAlias();
			} else {
				throw new PMSException(
						"No device domain mapping exists for domain Id ="
								+ domainId);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		
		return aliasName;
	}

	public PortalPropertyBean fetchMenuBean(Short aliasId, String device,
			String loginStatus, String url, Session session)
			throws PMSException {
		PortalPropertyBean portalPropBean = new PortalPropertyBean();
		try {
			if (loginStatus.equals("pre_login")) {
				portalPropBean.setMenuList(fetchMenuList(aliasId, device, true,
						0, url, session));
			} else {
				portalPropBean.setMenuList(fetchMenuList(aliasId, device,
						false, 0, url, session));
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return portalPropBean;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PortalMenuBean> fetchMenuList(Short aliasId,
			String device, Boolean isPreLogin, int parentId, String url,
			Session session) {
		ArrayList<PortalMenuBean> menuList = null;
		PortalMenuBean menuBean;
		try {
			Criteria criteria = session.createCriteria(MenuMasterView.class);
			criteria.setCacheable(true);
			criteria.setCacheRegion("MenuMasterViewCache");
			criteria.add(Restrictions.eq("aliasId", aliasId));
			criteria.add(Restrictions.eq("device", device.toUpperCase()));
			if (isPreLogin != null) {
				if (isPreLogin) {
					criteria.add(Restrictions.eq("isPreLogin", "Y"));
				} else {
					criteria.add(Restrictions.eq("isPostLogin", "Y"));
				}
				criteria.add(Restrictions.eq("status", "ACTIVE"));
			}
			criteria.add(Restrictions.eq("parentId", parentId));
			criteria.addOrder(Order.asc("orderBy"));
			List<MenuMasterView> list = criteria.list();
			if (list.size() > 0) {
				menuList = new ArrayList<PortalMenuBean>();
				int fetchParentId = 0;
				if (url != null) {
					Criteria cri = session.createCriteria(MenuMasterView.class);
					cri.setCacheable(true);
					cri.setCacheRegion("MenuMasterViewCache");
					cri.add(Restrictions.eq("aliasId", aliasId));
					cri.add(Restrictions.eq("device", device.toUpperCase()));
					if (isPreLogin != null) {
						if (isPreLogin) {
							cri.add(Restrictions.eq("isPreLogin", "Y"));
						} else {
							cri.add(Restrictions.eq("isPostLogin", "Y"));
						}
						cri.add(Restrictions.eq("status", "ACTIVE"));
					}
					cri.add(Restrictions.ne("parentId", parentId));
					cri.add(Restrictions.eq("url", url));
					cri.addOrder(Order.asc("orderBy"));
					List<MenuMasterView> parentIdList = cri.list();
					if (parentIdList.size() > 0) {
						MenuMasterView menu = parentIdList.get(0);
						fetchParentId = menu.getParentId();
						short level = menu.getLevel();
						while (level - 2 > 0) {
							StPortalMenuMaster menuMaster = (StPortalMenuMaster) session
									.load(StPortalMenuMaster.class,
											fetchParentId);
							fetchParentId = menuMaster.getParentId();
							level = menuMaster.getLevel();
						}
					}
				}
				for (MenuMasterView menu : list) {
					menuBean = new PortalMenuBean();
					menuBean.setMenuId(menu.getMenuId());
					menuBean.setMenuDisplayName(String.valueOf(menu
							.getDisplayCode()));
					menuBean.setActionUrl(menu.getUrl());
					menuBean.setIsPopUp(menu.getIsPopup());
					menuBean.setContentName(menu.getContentName());
					menuBean.setContentType(menu.getContentType());
					menuBean.setStatus(menu.getStatus());
					menuBean.setParentMenuId(menu.getParentId());
					menuBean.setOrderBy(menu.getOrderBy());
					menuBean.setLevel(menu.getLevel());
					menuBean.setHighLightOpt(menu.getHighLightOpts());
					menuBean.setCheckLogin("Y".equals(menu.getIsPostLogin()));
					if (menu.getLevel()>1 || (fetchParentId != 0 && fetchParentId == menu.getMenuId())) {
						menuBean.setMenuBeanList(fetchMenuList(aliasId, device,
								isPreLogin, menu.getMenuId(), null, session));
					}
					if (menuBean.getMenuBeanList() != null)
						Collections.sort(menuBean.getMenuBeanList(),
								menuSortComparator);
					menuList.add(menuBean);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}

	public ArrayList<PortalMenuBean> fetchBeanMenuList(Short aliasId,
			String device, Session session) {
		// String menuListJson = null;
		ArrayList<PortalMenuBean> menuList = new ArrayList<PortalMenuBean>();
		try {

			Criteria criteria = session
					.createCriteria(StPortalMenuMaster.class);
			criteria.setCacheable(true);
			criteria.setCacheRegion("StPortalMenuMasterCache");
			criteria.add(Restrictions.eq("aliasId", aliasId));
			criteria.add(Restrictions.eq("device", device.toUpperCase()));
			criteria.addOrder(Order.asc("order"));
			criteria.createAlias("stPortalContentMaster", "spcm");
			session.enableFilter("boMenuFilter")
					.setParameter("aliasId", aliasId)
					.setParameter("device", device.toUpperCase());
			criteria.add(Restrictions.eq("parentId", 0));
			@SuppressWarnings("unchecked")
			List<StPortalMenuMaster> list = criteria.list();
			if (list.size() > 0) {
				PropertiesConfiguration config = Utility
						.fetchGlobalProperties(session);
				for (StPortalMenuMaster mm : list) {
					menuList.add(subMenuList(mm, config));
				}
				Collections.sort(menuList, menuSortComparator);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}

	public PortalMenuBean subMenuList(StPortalMenuMaster dbMenuBean,
			PropertiesConfiguration config) throws ConfigurationException,
			PMSException {
		PortalMenuBean portalMenuBean = new PortalMenuBean();
		portalMenuBean.setMenuDisplayName(String.valueOf(config
				.getProperty("global." + dbMenuBean.getDisplayCode())));
		portalMenuBean.setActionUrl(dbMenuBean.getStPortalContentMaster()
				.getUrl());
		portalMenuBean.setIsPopUp(dbMenuBean.getStPortalContentMaster()
				.getIsPopup());
		portalMenuBean.setContentName(dbMenuBean.getStPortalContentMaster()
				.getContentName());
		portalMenuBean.setContentType(dbMenuBean.getStPortalContentMaster()
				.getContentType());
		portalMenuBean.setStatus(dbMenuBean.getStatus());
		portalMenuBean.setMenuId(dbMenuBean.getMenuId());
		portalMenuBean.setParentMenuId(dbMenuBean.getParentId());
		portalMenuBean.setOrderBy(dbMenuBean.getOrder());
		portalMenuBean.setLevel(dbMenuBean.getLevel());
		portalMenuBean.setCheckLogin("Y".equals(dbMenuBean
				.getStPortalContentMaster().getIsPostLogin()));
		portalMenuBean.setHighLightOpt(dbMenuBean.getHighLightOpt());
		if (dbMenuBean.getSubMenuMasterSet().size() > 0) {
			portalMenuBean.setMenuBeanList(new ArrayList<PortalMenuBean>());
			for (StPortalMenuMaster sub : dbMenuBean.getSubMenuMasterSet()) {
				portalMenuBean.getMenuBeanList().add(subMenuList(sub, config));
			}
			Collections.sort(portalMenuBean.getMenuBeanList(),
					menuSortComparator);
		}
		return portalMenuBean;
	}

	@SuppressWarnings("unchecked")
	public Integer fetchActionId(String actionName, String plrLogin,
			Session session) throws PMSException {
		Integer actionId = null;
		try {
			Criteria crit = session.createCriteria(StPortalPriviledgeRep.class);
			crit.setCacheable(true);
			crit.setCacheRegion("StPortalPriviledgeRepCache");
			crit.add(Restrictions.eq("actionMapping", actionName));
			if ("N".equals(plrLogin)) {
				crit.add(Restrictions.eq("checkPreLogin", "Y"));
			} else {
				crit.add(Restrictions.eq("checkPostLogin", "Y"));
			}
			crit.add(Restrictions.eq("status", "ACTIVE"));
			List<StPortalPriviledgeRep> list = crit.list();
			if (list.size() > 0) {
				actionId = list.get(0).getActionId();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return actionId;
	}

	@SuppressWarnings("unchecked")
	public StRmVendorMaster getVendorAuthDetails(
			VendorAuthInfoBean vendorAuthInfo, Session session) {
		Criteria criteria = session.createCriteria(StRmVendorMaster.class);
		criteria.setCacheable(true);
		criteria.setCacheRegion("StRmVendorMasterCache");
		criteria.add(Restrictions.eq("userName", vendorAuthInfo.getUserName()));
		criteria.add(Restrictions.eq("password", vendorAuthInfo.getPassword()));
		List<StRmVendorMaster> list = criteria.list();
		StRmVendorMaster rmVendorMaster = null;
		if (list.size() > 0) {
			rmVendorMaster = list.get(0);
		}
		return rmVendorMaster;
	}

	@SuppressWarnings("unchecked")
	public List<StRmServiceMaster> fetchServiceIdMap(Session session) {
		Criteria cri = session.createCriteria(StRmServiceMaster.class).setCacheable(true);
		cri.add(Restrictions.eq("status", "ACTIVE"));
		List<StRmServiceMaster> serMasList = cri.list();
		return serMasList;
	}

	@SuppressWarnings("unchecked")
	public VendorInfoBean fetchVendorInfo(String userName, String password, Session session)
			throws PMSException {
		VendorInfoBean vendorInfo = null;
		Criteria cri = session.createCriteria(StRmVendorMaster.class);
		cri.setCacheable(true);
		cri.setCacheRegion("StRmVendorMasterCache");
		cri.add(Restrictions.eq("status", "ACTIVE"));
		cri.add(Restrictions.eq("userName", userName));
		if(password!=null)
			cri.add(Restrictions.eq("password", password));
		List<StRmVendorMaster> list = cri.list();
		for (StRmVendorMaster vm : list) {
			vendorInfo = new VendorInfoBean();
			vendorInfo.setVendorId(vm.getVendorId());
			vendorInfo.setVendorCode(vm.getVendorCode());
			vendorInfo.setVendorName(vm.getVendorName());
			vendorInfo.setRegistrationDate(vm.getRegistrationDate());
			vendorInfo.setUserName(vm.getUserName());
			vendorInfo.setPassword(vm.getPassword());
			vendorInfo.setVendorRefNo(vm.getVendorRefNo());
			vendorInfo.setVendorKey(vm.getVendorKey());
			vendorInfo.setVendorLobbyType(vm.getVendorLobbyType());
			vendorInfo.setVendorPassword(vm.getVendorPassword());
			vendorInfo.setDefaultGameGroup(vm.getDefaultGameGroup());
			vendorInfo.setSecretKeys(vm.getSecretKeys());
			vendorInfo.setStatus(vm.getStatus());
			vendorInfo.setVendorDomainName(vm.getVendorDomainName());
			vendorInfo.setIpWhiteList(vm.getIpWhiteList());
		}
		return vendorInfo;
	}
	
	public VendorInfoBean fetchTxnVendorInfo(String userName, String password,
			Session session) {
		VendorInfoBean vendorInfo = null;
		Criteria cri = session.createCriteria(StRmVendorMaster.class);
		cri.setCacheRegion("StRmVendorMasterCache");
		cri.add(Restrictions.eq("status", "ACTIVE"));
		cri.add(Restrictions.eq("userName", userName));
		if(password!=null)
			cri.add(Restrictions.eq("password", password));
		@SuppressWarnings("unchecked")
		List<StRmVendorMaster> list = cri.list();
		for (StRmVendorMaster vm : list) {
			vendorInfo = new VendorInfoBean();
			vendorInfo.setVendorId(vm.getVendorId());
			vendorInfo.setVendorCode(vm.getVendorCode());
			vendorInfo.setVendorName(vm.getVendorName());
			vendorInfo.setRegistrationDate(vm.getRegistrationDate());
			vendorInfo.setUserName(vm.getUserName());
			vendorInfo.setPassword(vm.getPassword());
			vendorInfo.setVendorRefNo(vm.getVendorRefNo());
			vendorInfo.setVendorKey(vm.getVendorKey());
			vendorInfo.setVendorLobbyType(vm.getVendorLobbyType());
			vendorInfo.setVendorPassword(vm.getVendorPassword());
			vendorInfo.setDefaultGameGroup(vm.getDefaultGameGroup());
			vendorInfo.setSecretKeys(vm.getSecretKeys());
			vendorInfo.setStatus(vm.getStatus());
			vendorInfo.setVendorDomainName(vm.getVendorDomainName());
		}
		log.info("------------------------End Fetch vendor Information from DaoIml fetchTxnVendorInfo -----");
		return vendorInfo;
	}
	
/*	@SuppressWarnings("unchecked")
	public VendorInfoBean fetchTxnVendorInfo(String userName, Session session) throws PMSException{
		log.info("--------fetch vendor txn info Dao Start-------------");
		VendorInfoBean vendorInfo = null;
		Criteria cri = session.createCriteria(StRmVendorMaster.class);
		cri.setCacheRegion("StRmVendorMasterCache");
		cri.add(Restrictions.eq("status", "ACTIVE"));
		cri.add(Restrictions.eq("userName", userName));
		List<StRmVendorMaster> list = cri.list();
		for (StRmVendorMaster vm : list) {
			vendorInfo = new VendorInfoBean();
			vendorInfo.setVendorId(vm.getVendorId());
			vendorInfo.setVendorCode(vm.getVendorCode());
			vendorInfo.setVendorName(vm.getVendorName());
			vendorInfo.setRegistrationDate(vm.getRegistrationDate());
			vendorInfo.setUserName(vm.getUserName());
			vendorInfo.setPassword(vm.getPassword());
			vendorInfo.setVendorRefNo(vm.getVendorRefNo());
			vendorInfo.setVendorKey(vm.getVendorKey());
			vendorInfo.setVendorLobbyType(vm.getVendorLobbyType());
			vendorInfo.setVendorPassword(vm.getVendorPassword());
			vendorInfo.setDefaultGameGroup(vm.getDefaultGameGroup());
			vendorInfo.setSecretKeys(vm.getSecretKeys());
			vendorInfo.setStatus(vm.getStatus());
			vendorInfo.setVendorDomainName(vm.getVendorDomainName());
		}
		log.info("--------fetch vendor txn info Dao End-------------");
		return vendorInfo;
	}*/
	
	@SuppressWarnings("unchecked")
	public String fetchVendorPropertyUrl(short vendorId, String propertyKey,
			Session session) throws PMSException {
		String propVal = null;
		try {
			Criteria cri = session
					.createCriteria(StRmServiceVendorProperties.class)
					.setCacheable(true);
			cri.createAlias("stRmVendorMaster", "vm");
			cri.add(Restrictions.eq("vm.vendorId", vendorId));
			cri.add(Restrictions.eq("propertyKey", propertyKey));
			List<StRmServiceVendorProperties> list = cri.list();
			if (list.size() == 1) {
				for (StRmServiceVendorProperties vendorProp : list) {
					propVal = vendorProp.getPropertyValue();
				}
			} else {
				throw new PMSException("Multiple or No Property found ="
						+ list.size());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return propVal;
	}

	public String getCurrencyCode(int currencyId, Session session) {
		String currencyCode = null;
		Criteria crit = session.createCriteria(StGenCurrencyMaster.class)
				.setCacheable(true);
		crit.setProjection(Projections.property("currencyCode"));
		crit.add(Restrictions.eq("currencyId", currencyId));
		currencyCode = crit.list().toString().replace("[", "").replace("]", "");
		log.info(currencyCode);
		return currencyCode;
	}

	@SuppressWarnings("unchecked")
	public StGenPasswordPolicy getPasswordPolicy(Integer passwordPolicyId,
			Session session) {

		StGenPasswordPolicy stGenPasswordPolicy = null;
		Criteria criteria = null;

		try {
			criteria = session.createCriteria(StGenPasswordPolicy.class);
			criteria.add(Restrictions.eq("passwordPolicyId", passwordPolicyId));
			List<StGenPasswordPolicy> list = criteria.list();
			if (list.size() > 0) {
				stGenPasswordPolicy = list.get(0);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return stGenPasswordPolicy;
	}

	// @SuppressWarnings("unchecked")
	// public List<VipLevelMasterBean> fetchDomainVipLevelList(Short domainId,
	// Session session)
	// throws PMSException {
	// log.info("--Fetch Vip Level List--");
	// List<VipLevelMasterBean> vipLevelList = new
	// ArrayList<VipLevelMasterBean>();
	// try {
	// Criteria cri =
	// session.createCriteria(StVipLevelMaster.class).addOrder(Order.asc("vipLevel"));
	// cri.add(Restrictions.eq("domainId", domainId));
	// List<StVipLevelMaster> vipList = cri.list();
	// VipLevelMasterBean vipBean = null;
	// String dispCode = null;
	// for (StVipLevelMaster vip : vipList) {
	// dispCode = Utility.getDisplayCodeValue(vip.getVipDispCode());
	// vipBean = new VipLevelMasterBean(vip.getId(),
	// vip.getDomainId(), vip.getVipLevel(), vip.getVipCode(),
	// vip.getVipColor(), vip.getLevelType(),
	// vip.getVipRule(), vip.getStatus(),
	// vip.getVipGroup(),dispCode,vip.getRemarks());
	//
	// vipLevelList.add(vipBean);
	// }
	// } catch (HibernateException e) {
	// e.printStackTrace();
	// throw new PMSException("Hibernate Exception");
	// }
	// return vipLevelList;
	// }

	// @SuppressWarnings("unchecked")
	// public Map<Short, List<VipLevelMasterBean>> fetchDomainVipLevelList()
	// throws PMSException {
	// log.info("--Fetch Vip Level List--");
	// Map<Short, List<VipLevelMasterBean>> vipMap = null;
	// Session session = null;
	// try {
	// session = HibernateSessionFactory.getSession();
	// Criteria cri =
	// session.createCriteria(StVipLevelMaster.class).addOrder(Order.asc("vipLevel"));
	// List<StVipLevelMaster> vipList = cri.list();
	// vipMap = new HashMap<Short, List<VipLevelMasterBean>>();
	// VipLevelMasterBean vipBean = null;
	// String dispCode = null;
	// for (StVipLevelMaster vip : vipList) {
	// dispCode = Utility.getDisplayCodeValue(vip.getVipDispCode());
	// vipBean = new VipLevelMasterBean(vip.getId(),
	// vip.getDomainId(), vip.getVipLevel(), vip.getVipCode(),
	// vip.getVipColor(), vip.getLevelType(),
	// vip.getVipRule(), vip.getStatus(),
	// vip.getVipGroup(),dispCode,vip.getRemarks());
	//
	// if (!vipMap.containsKey(vip.getDomainId())) {
	// vipMap.put(vip.getDomainId(),
	// new ArrayList<VipLevelMasterBean>());
	// }
	// vipMap.get(vip.getDomainId()).add(vipBean);
	// }
	// } catch (HibernateException e) {
	// e.printStackTrace();
	// throw new PMSException("Hibernate Exception");
	// } finally {
	// if (session != null && session.isOpen()) {
	// session.close();
	// }
	// }
	// return vipMap;
	// }

	// @SuppressWarnings("unchecked")
	// public Map<String, VipLevelCriteriaBean> fetchVipLevelCriteriaList()
	// throws PMSException {
	// log.info("--Fetch Vip Level Criteria List --");
	// Session session = null;
	// Map<String, VipLevelCriteriaBean> criteriaMap = null;
	// try {
	// session = HibernateSessionFactory.getSession();
	// Criteria cri = session.createCriteria(StVipCriteriaList.class)
	// .addOrder(Order.asc("criteriaCode"));
	//
	// List<StVipCriteriaList> criList = cri.list();
	// VipLevelCriteriaBean criBean = null;
	// criteriaMap = new TreeMap<String, VipLevelCriteriaBean>();
	// for (StVipCriteriaList vipCri : criList) {
	// criBean = new VipLevelCriteriaBean(vipCri.getId(), vipCri
	// .getCriteriaCode(), vipCri.getCriteriaName(), vipCri
	// .getRelatedTo(), vipCri.getRelatedColumn(),vipCri.getCriteriaStatus());
	// criteriaMap.put(vipCri.getCriteriaCode(), criBean);
	// }
	// } catch (HibernateException e) {
	// e.printStackTrace();
	// throw new PMSException("Hibernate Exception");
	// } finally {
	// if (session != null && session.isOpen()) {
	// //session.close();
	// }
	// }
	// return criteriaMap;
	// }

	@SuppressWarnings("unchecked")
	public StGenSchedulerRunStatus getLastScheduledTime(String schedulerCode,
			Session session) throws PMSException {
		log.info("--Get last scheduled time --");
		List<StGenSchedulerRunStatus> criList = null;
		try {
			Criteria cri = session
					.createCriteria(StGenSchedulerRunStatus.class);
			cri.add(Restrictions.eq("schedulerCode", schedulerCode));
			criList = cri.list();
			if (criList.size() != 1)
				throw new PMSException("No Scheduler found for this code!");
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return criList.get(0);
	}

	public void updateSchedulerTime(StGenSchedulerRunStatus runStatus,
			Session session) throws PMSException {
		log.info("--Update Scheduler time --");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			runStatus.setLastRunTime(new Timestamp(Calendar.getInstance()
					.getTimeInMillis()));
			session.update(runStatus);
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
			throw new PMSException("Unknow Exception");
		}
	}

	@SuppressWarnings("unchecked")
	public List<String> fetchPath(Session session) throws PMSException {
		Criteria criteria = null;
		List<String> list;
		try {
			criteria = session.createCriteria(StPortalPathMaster.class);
			criteria.setProjection(Projections.property("serverUrl")).add(
					Restrictions.eq("status", "ACTIVE"));
			list = criteria.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<StPortalPathMaster> fetchServerDetail(Session session)
			throws PMSException {
		Criteria criteria = null;
		List<StPortalPathMaster> serverDetailList;
		try {
			criteria = session.createCriteria(StPortalPathMaster.class);
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			serverDetailList = criteria.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return serverDetailList;
	}

	@SuppressWarnings("unchecked")
	public List<String> getUploadedContent(Session session) {
		List<String> contentList = null;
		try {
			Criteria criteria = session
					.createCriteria(StCmsUploadContentMaster.class);
			criteria.setProjection(Projections.property("contentPath"));
			criteria.add(Restrictions.eq("status", "NOTUPLOAD"));
			contentList = criteria.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return contentList;
	}

	public void updateUploadedContent(List<String> uploadedContent,
			Session session) {
		// try {
		// Criteria criteria = session
		// .createCriteria(StCmsUploadContentMaster.class);
		// criteria.add(Restrictions.in("contentPath", uploadedContent));
		// List<StCmsUploadContentMaster> list = criteria.list();
		// for (StCmsUploadContentMaster stCmsUploadContentMaster : list) {
		// stCmsUploadContentMaster.setStatus("UPLOAD");
		// session.save(stCmsUploadContentMaster);
		// }
		// } catch (HibernateException e) {
		// e.printStackTrace();
		// }
	}

	@SuppressWarnings("unchecked")
	public UrlTagBean fetchUrlTags(Session session, short aliasId,
			String actionUrl, String device) throws PMSException {
		Criteria criteria = null;
		UrlTagBean tagBean = null;
		try {
			if ("BYDEFAULT".equals(getDmAliasProperty(session, aliasId,
					"contentList"))) {
				aliasId = 1;
			}
			criteria = session.createCriteria(StPortalContentMaster.class);
			criteria.setCacheable(true);
			criteria.setCacheRegion("StPortalContentMasterCache");
			criteria.add(Restrictions.eq("aliasId", aliasId));
			criteria.add(Restrictions.eq("url", actionUrl));
			if (device != null)
				criteria.add(Restrictions.eq("device", device.toUpperCase()));
			List<StPortalContentMaster> contentList = criteria.list();
			if (contentList.size() == 1) {
				for (StPortalContentMaster contentMaster : contentList) {
					tagBean = new UrlTagBean();
					tagBean.setTitle(contentMaster.getTitle());
					HashMap<String, String> metaMap = new HashMap<String, String>();
					if (contentMaster.getMetaDescription() != null)
						metaMap.put("description",
								contentMaster.getMetaDescription());
					if (contentMaster.getKeyword() != null)
						metaMap.put("keywords", contentMaster.getKeyword());
					if (metaMap.size() > 0)
						tagBean.setMeta(metaMap);
					tagBean.setCommonCSS("Y".equals(contentMaster
							.getIsCommonCSS()));
					tagBean.setCustomCSS("Y".equals(contentMaster
							.getIsCustomCSS()));
				}
			} else {
				log.info("Multiple or No Url Found for " + actionUrl);
				// throw new
				// PMSException("Multiple or No Url Found for "+actionUrl);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return tagBean;
	}

	@SuppressWarnings("unchecked")
	public LanguageBean fetchLanguageMasterBean(Integer langId, Session session)
			throws PMSException {
		LanguageBean languageBean = null;
		try {
			Criteria cri = session.createCriteria(StGenLanguageMaster.class);
			cri.setCacheable(true);
			cri.setCacheRegion("StGenLanguageMasterCache");
			cri.add(Restrictions.eq("languageId", langId));
			List<StGenLanguageMaster> list = cri.list();
			for (StGenLanguageMaster languageMaster : list) {
				languageBean = new LanguageBean();
				languageBean.setLanguageId(languageMaster.getLanguageId());
				languageBean.setLanguageCode(languageMaster.getLanguageCode());
				languageBean.setLanguageName(languageMaster.getLanguageName());
				languageBean.setLanguageBaseCode(languageMaster
						.getLanguageBaseCode());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return languageBean;
	}

	
	/**
	 * @return
	 * Gets values in the format:
	 * 						["VendorId","VendorPropertyMap"] 
	 *
	 * VendorPropertyMap's structure:
	 * 						["VendorPropertyKey","VendorPropertyValue"]
	 *
	 * @param aliasId
	 * @param session
	 *	 
	 * @throws PMSException
	 * @author Preetam Kumar
	 */
	@SuppressWarnings("unchecked")
	public Map<Short, Map<String, String>> getVendorPropertiesById(Short aliasId,Session session) throws PMSException {
		Map<Short,Map<String,String>> retMap=null;
		List<Short> vendorList = null;
		List<StRmServiceVendorProperties> vendorPropertyList=null;
		try{
			Criteria crit=session.createCriteria(StRmDomainAliasVendorMapping.class);

			if(aliasId!=null)
				crit.add(Restrictions.eq("aliasId", aliasId));
			crit.add(Restrictions.eq("status","ACTIVE"));
			crit.setProjection(Projections.property("vendorId"))
			.setCacheable(true);
			vendorList = crit.list();

			if(vendorList.size() == 0){
				throw new PMSException("No vendor or vendor-alias mapping exists!");
			}
			crit= session.createCriteria(StRmServiceVendorProperties.class);
			crit.createAlias("stRmVendorMaster", "vend");
			crit.add(Restrictions.eq("vend.status", "ACTIVE"));
			crit.add(Restrictions.in("vend.vendorId", vendorList));
			vendorPropertyList= crit.list();
			
			
			if (vendorList.size()>0 && vendorPropertyList!=null){ 	
				for (StRmServiceVendorProperties vendorProp : vendorPropertyList) {
					if(retMap==null){
						retMap= new HashMap<Short, Map<String,String>>();
						retMap.put(vendorProp.getStRmVendorMaster().getVendorId(), new HashMap<String, String>());
						retMap.get(vendorProp.getStRmVendorMaster().getVendorId()).put(vendorProp.getPropertyKey(), vendorProp.getStRmVendorMaster().getVendorDomainName()+vendorProp.getPropertyValue());
					}else
						if(!retMap.containsKey(vendorProp.getStRmVendorMaster().getVendorId())){
							retMap.put(vendorProp.getStRmVendorMaster().getVendorId(), new HashMap<String, String>());
							retMap.get(vendorProp.getStRmVendorMaster().getVendorId()).put(vendorProp.getPropertyKey(), vendorProp.getStRmVendorMaster().getVendorDomainName()+vendorProp.getPropertyValue());
						}
						else {
							retMap.get(vendorProp.getStRmVendorMaster().getVendorId()).put(vendorProp.getPropertyKey(), vendorProp.getStRmVendorMaster().getVendorDomainName()+vendorProp.getPropertyValue());
						}
				}
			}else {
				throw new PMSException("No vendor or vendor-alias mapping exists!");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR); 
		}
		return retMap;
	}
	
	public Map<Short, Map<String, String>> getVendorPropertiesById(
			Short aliasId, String vendorName, Session session) throws PMSException {
		Map<Short,Map<String,String>> retMap=null;
		List<Short> vendorList = null;
		List<StRmServiceVendorProperties> vendorPropertyList=null;
		log.info(aliasId+" "+vendorName);
		try{
			Criteria crit=session.createCriteria(StRmDomainAliasVendorMapping.class);

			if(aliasId!=null)
				crit.add(Restrictions.eq("aliasId", aliasId));
			crit.add(Restrictions.eq("status","ACTIVE"));
			crit.setProjection(Projections.property("vendorId"))
			.setCacheable(true);
			vendorList = crit.list();
			

			if(vendorList.size() == 0){
				throw new PMSException("No vendor or vendor-alias mapping exists!");
			}
			crit= session.createCriteria(StRmServiceVendorProperties.class);
			crit.createAlias("stRmVendorMaster", "vend");
			crit.add(Restrictions.eq("vend.status", "ACTIVE"));
			crit.add(Restrictions.in("vend.vendorId", vendorList));
			vendorPropertyList= crit.list();
			
			retMap= new HashMap<Short, Map<String,String>>();
			
			if (vendorList.size()>0 && vendorPropertyList!=null){ 	
				for (StRmServiceVendorProperties vendorProp : vendorPropertyList) {
					if(vendorName.equalsIgnoreCase(vendorProp.getStRmVendorMaster().getVendorCode())){
						if(retMap==null){
							retMap= new HashMap<Short, Map<String,String>>();
							retMap.put(vendorProp.getStRmVendorMaster().getVendorId(), new HashMap<String, String>());
							retMap.get(vendorProp.getStRmVendorMaster().getVendorId()).put(vendorProp.getPropertyKey(), vendorProp.getStRmVendorMaster().getVendorDomainName()+vendorProp.getPropertyValue());
						}else
							if(!retMap.containsKey(vendorProp.getStRmVendorMaster().getVendorId())){
								retMap.put(vendorProp.getStRmVendorMaster().getVendorId(), new HashMap<String, String>());
								retMap.get(vendorProp.getStRmVendorMaster().getVendorId()).put(vendorProp.getPropertyKey(), vendorProp.getStRmVendorMaster().getVendorDomainName()+vendorProp.getPropertyValue());
							}
							else {
								retMap.get(vendorProp.getStRmVendorMaster().getVendorId()).put(vendorProp.getPropertyKey(), vendorProp.getStRmVendorMaster().getVendorDomainName()+vendorProp.getPropertyValue());
							}
					}
				}
			}else {
				throw new PMSException("No vendor or vendor-alias mapping exists!");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR); 
		}
		
		return retMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<Short, Map<String, String>> getPokerVendorPropertiesById(Short aliasId,Session session) throws PMSException {
		Map<Short,Map<String,String>> retMap=null;
		List<Short> vendorList = null;
		List<StRmServiceVendorProperties> vendorPropertyList=null;
		try{
			Criteria crit=session.createCriteria(StRmDomainAliasVendorMapping.class);

			if(aliasId!=null)
				crit.add(Restrictions.eq("aliasId", aliasId));
			crit.add(Restrictions.eq("status","ACTIVE"));
			crit.setProjection(Projections.property("vendorId"))
			.setCacheable(true);
			vendorList = crit.list();

			if(vendorList.size() == 0){
				throw new PMSException(PMSErrorCode.UNKNOWN_VENDOR_ALIAS_MAPPING,"No vendor or vendor-alias mapping exists!");
			}
			crit= session.createCriteria(StRmServiceVendorProperties.class);
			crit.createAlias("stRmVendorMaster", "vend");
			crit.add(Restrictions.eq("vend.status", "ACTIVE"));
			crit.add(Restrictions.in("vend.vendorId", vendorList));
			crit.add(Restrictions.eq("vend.vendorCode","POKER"));
			vendorPropertyList= crit.list();
			
			if (vendorList.size()>0 && vendorPropertyList!=null){ 	
				for (StRmServiceVendorProperties vendorProp : vendorPropertyList) {
					if("Poker".equalsIgnoreCase(vendorProp.getStRmVendorMaster().getVendorCode())){
						if(retMap==null){
							retMap= new HashMap<Short, Map<String,String>>();		
							retMap.put(vendorProp.getStRmVendorMaster().getVendorId(), new HashMap<String, String>());
							retMap.get(vendorProp.getStRmVendorMaster().getVendorId()).put(vendorProp.getPropertyKey(), vendorProp.getPropertyValue());
						}else
							if(!retMap.containsKey(vendorProp.getStRmVendorMaster().getVendorId())){
								retMap.put(vendorProp.getStRmVendorMaster().getVendorId(), new HashMap<String, String>());
								retMap.get(vendorProp.getStRmVendorMaster().getVendorId()).put(vendorProp.getPropertyKey(), vendorProp.getPropertyValue());
							}
							else {
								retMap.get(vendorProp.getStRmVendorMaster().getVendorId()).put(vendorProp.getPropertyKey(), vendorProp.getPropertyValue());
							}
					}
				}
			}else {
				throw new PMSException(PMSErrorCode.UNKNOWN_VENDOR_ALIAS_MAPPING ,"Vendor property(s) doesn't exist!. Vendors are "+vendorList);
			}
		}catch(PMSException e){
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR); 
		}
		return retMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<Short, Map<String, String>> gameServiceProperties(Session session)
			throws PMSException {
		Map<Short, Map<String, String>> map = new HashMap<Short, Map<String, String>>();
		try {
			Criteria cri = session
					.createCriteria(StRmServiceVendorProperties.class)
					.setCacheable(true);
			cri.createAlias("stRmVendorMaster", "vend");
			cri.add(Restrictions.eq("vend.status", "ACTIVE"));
			List<StRmServiceVendorProperties> list = cri.list();
			for (StRmServiceVendorProperties stRmServiceVendorProperties : list) {
				if (!map.containsKey(stRmServiceVendorProperties
						.getStRmVendorMaster().getVendorId())) {
					map.put(stRmServiceVendorProperties.getStRmVendorMaster()
							.getVendorId(), new HashMap<String, String>());
					map.get(stRmServiceVendorProperties.getStRmVendorMaster()
							.getVendorId()).put(
							stRmServiceVendorProperties.getPropertyKey(),
							stRmServiceVendorProperties.getStRmVendorMaster()
									.getVendorDomainName()
									+ stRmServiceVendorProperties
											.getPropertyValue());
				} else {
					map.get(stRmServiceVendorProperties.getStRmVendorMaster()
							.getVendorId()).put(
							stRmServiceVendorProperties.getPropertyKey(),
							stRmServiceVendorProperties.getStRmVendorMaster()
									.getVendorDomainName()
									+ stRmServiceVendorProperties
											.getPropertyValue());
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Vendor Property some problem");
		}
		return map;
	}

	public void emailTemplate(Session session) {
		Criteria cri = session.createCriteria(StCmsTemplateMaster.class);
		cri.add(Restrictions.eq("status", "ACTIVE"));
	}

	@SuppressWarnings("unchecked")
	public List<String> fetchAvtaarList(Session session) {
		List<String> list = null;
		try {
			Criteria criteria = session.createCriteria(StPmAvtaarMaster.class)
					.setCacheable(true);
			criteria.setProjection(Projections.property("avtaarPath"));
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			list = criteria.list();

		} catch (HibernateException e) {
			e.printStackTrace();
			new PMSException("Avtaar Map has some problem");
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PlayerReferralInfo> storePlayerReferralContactList(
			Session session, ArrayList<PlayerReferralInfo> playerReferralInfo,
			long playerId, String playerEmailId) throws PMSException {
		List<String> emailReferList = new ArrayList<String>();
		for (PlayerReferralInfo refrInfo : playerReferralInfo) {
			emailReferList.add(refrInfo.getEmailId());
		}
		Criteria cri = session.createCriteria(StPmPlayerMaster.class);
		cri.add(Restrictions.in("emailId", emailReferList));
		List<String> emailList = cri.list();
		for (PlayerReferralInfo playerRefInfo : playerReferralInfo) {
			if (emailList.contains(playerRefInfo.getEmailId())) {
				playerRefInfo.setChecked(true);
				continue;
			}
			StPmPlayerReferralContactList stPmPlayerReferralContactList = new StPmPlayerReferralContactList(
					playerId, playerEmailId, playerRefInfo.getFirstName(),
					playerRefInfo.getLastName(), playerRefInfo.getEmailId(),
					null);
			session.save(stPmPlayerReferralContactList);
		}
		return playerReferralInfo;
	}

	/*@SuppressWarnings("unchecked")
	public List<PlayerReferralInfo> invitedFriend(Session session,
			ArrayList<PlayerReferralInfo> playerReferralInfo, long playerId,
			short domainId, short aliasId, String inviteMode) throws PMSException {
		List<PlayerReferralInfo> referralInfo = new ArrayList<PlayerReferralInfo>();
		PlayerMgmtDaoImpl playerDaoImplObj = new PlayerMgmtDaoImpl();
		for (PlayerReferralInfo playerRefInfo : playerReferralInfo) {
			if("MOBILE".equals(inviteMode)) {
				if ("false".equals(playerDaoImplObj.checkEmailMobileAvailability(
						null, playerRefInfo.getMobileNo(), domainId, session)))
					continue;
			} else if("EMAIL".equals(inviteMode)) {
				if ("false".equals(playerDaoImplObj.checkEmailMobileAvailability(
						playerRefInfo.getEmailId(), null, domainId, session)))
					continue;
			} else {
				throw new PMSException(PMSErrorCode.GEN_INVALID_REQ,
						PMSErrorMessage.GEN_INVALID_REQ);
			}
			Criteria cri = session.createCriteria(StPmPlayerReferralMaster.class);
			if("MOBILE".equals(inviteMode)) {
				cri.add(Restrictions.eq("invitedMobileNo",
						playerRefInfo.getMobileNo()));
			} else if("EMAIL".equals(inviteMode)) {
				cri.add(Restrictions.eq("invitedEmailId",
						playerRefInfo.getEmailId()));
			}
			cri.add(Restrictions.eq("playerId", playerId));
			List<StPmPlayerReferralMaster> list = cri.list();
			if (list.size() == 0) {
				StPmPlayerReferralMaster stPmPlayerReferralMaster = new StPmPlayerReferralMaster(
						playerId, domainId,aliasId, inviteMode, Timestamp.valueOf(playerRefInfo
								.getInviteDate()), playerRefInfo.getEmailId(),playerRefInfo.getMobileNo(),
						"INVITED", "NO");
				session.save(stPmPlayerReferralMaster);
				session.flush();
				playerRefInfo.setBonusOnInvite("NO");
				playerRefInfo.setReferalId(stPmPlayerReferralMaster.getId());
				referralInfo.add(playerRefInfo);
			} else {
				StPmPlayerReferralMaster stPmPlayerReferralMaster = (StPmPlayerReferralMaster) list
						.get(0);
				if (stPmPlayerReferralMaster.getRegisteredPlayerId() == null) {
					StPmPlayerReferralMasterHistory RefMasHistory = new StPmPlayerReferralMasterHistory(
							stPmPlayerReferralMaster);
					session.save(RefMasHistory);
					stPmPlayerReferralMaster.setInvitationDate(Timestamp
							.valueOf(playerRefInfo.getInviteDate()));
					stPmPlayerReferralMaster.setAliasId(aliasId);
					session.update(stPmPlayerReferralMaster);
					session.flush();
					playerRefInfo
							.setReferalId(stPmPlayerReferralMaster.getId());
					playerRefInfo.setBonusOnInvite(stPmPlayerReferralMaster
							.getBonusOnInvited());
					referralInfo.add(playerRefInfo);
				}
			}
		}
		return referralInfo;
	}*/

	@SuppressWarnings("unchecked")
	public void updateRerferalWithBouns(Session session,
			List<PlayerReferralInfo> playerReferralInfo, long playerId)
			throws PMSException {
		for (PlayerReferralInfo playerRefInfo : playerReferralInfo) {
			Criteria cri = session
					.createCriteria(StPmPlayerReferralMaster.class);
			cri.add(Restrictions.eq("invitedEmailId",
					playerRefInfo.getEmailId()));
			cri.add(Restrictions.eq("playerId", playerId));
			List<StPmPlayerReferralMaster> list = cri.list();
			if (list.size() != 0) {
				StPmPlayerReferralMaster stPmPlayerReferralMaster = (StPmPlayerReferralMaster) list
						.get(0);
				stPmPlayerReferralMaster.setBonusOnInvited("YES");
				session.update(stPmPlayerReferralMaster);
				session.flush();
			}
		}
	}

	/*@SuppressWarnings({ "deprecation", "unchecked" })
	public List<PortalWinnersList> fetchWinnersList(Short domainId,
			Session session) throws PMSException {
		List<PortalWinnersList> winList = null;
		Query query = null;
		try {
			// weekly winner
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			c.add(Calendar.DAY_OF_WEEK, -7);
			session.connection().setReadOnly(true);
			query = session.getNamedQuery("getWinner");
			query.setString("domainId", domainId.toString());
			query.setString("fromDate", sdf.format(c.getTime()));
			c.add(Calendar.DAY_OF_WEEK, 6);
			query.setString("toDate", sdf.format(c.getTime()));
			query.setString("listHeader", "WEEKLY");
			query.setResultTransformer(Transformers
					.aliasToBean(PortalWinnersList.class));
			;
			winList = query.list();
			session.connection().setReadOnly(false);
			// winListMap.put("WEEKLY WINNER", winList);
			// monthly winner
			c.setTime(new Date());
			c.add(Calendar.DAY_OF_MONTH, -1);
			c.set(Calendar.DATE, 0);
			session.connection().setReadOnly(true);
			query = session.getNamedQuery("getWinner");
			query.setString("domainId", domainId.toString());
			query.setString("toDate", sdf.format(c.getTime()));
			c.set(Calendar.DATE, 1);
			query.setString("fromDate", sdf.format(c.getTime()));
			query.setString("listHeader", "MONTHLY");
			query.setResultTransformer(Transformers
					.aliasToBean(PortalWinnersList.class));
			;
			winList.addAll(query.list());
			session.connection().setReadOnly(false);
			// yearly winner
			c.setTime(new Date());
			int year = (c.get(Calendar.YEAR)) - 1;
			c.set(Calendar.YEAR, year);com.stpl.pms.daoImpl.commonMethods;
			c.set(Calendar.WEEK_OF_YEAR, 1);
			c.set(Calendar.DAY_OF_WEEK, 1);
			session.connection().setReadOnly(true);
			query = session.getNamedQuery("getWinner");
			query.setString("domainId", domainId.toString());
			query.setString("fromDate", sdf.format(c.getTime()));
			c.set(Calendar.YEAR, year);
			c.set(Calendar.MONTH, 11); // 11 = december
			c.set(Calendar.DAY_OF_MONTH, 31);
			query.setString("toDate", sdf.format(c.getTime()));
			query.setString("listHeader", "YEARLY");
			query.setResultTransformer(Transformers
					.aliasToBean(PortalWinnersList.class));
			;
			winList.addAll(query.list());
			session.connection().setReadOnly(false);
			// all time winner
			session.connection().setReadOnly(true);
			query = session.getNamedQuery("getWinner");
			query.setString("domainId", domainId.toString());
			query.setString("fromDate", "");
			query.setString("toDate", "");
			query.setString("listHeader", "ALLTIME");
			query.setResultTransformer(Transformers
					.aliasToBean(PortalWinnersList.class));
			;
			winList.addAll(query.list());
			session.connection().setReadOnly(false);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Exception");
		}

		return winList;
	}*/

/*	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<PortalWinnersList> fetchWinnersList(Short aliasId,
			String durationParam,String gameType,String subGameType, Session session) throws PMSException {
		List<PortalWinnersList> winList = null;
		Query query = null;
		try {
			// weekly winner
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			// winListMap.put("WEEKLY WINNER", winList);
			// monthly winner

			if ("daily".equals(durationParam)) {
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				c.add(Calendar.DAY_OF_WEEK, -2);
				session.connection().setReadOnly(true);
				query = session.getNamedQuery("getWinner");
				query.setString("domainId", aliasId.toString());
				System.out.println("FROM:"+new Date(c.getTimeInMillis()));
				query.setString("fromDate", sdf.format(c.getTime())com.stpl.pms.daoImpl.commonMethods;
						+ " 00:00:00");
				c.add(Calendar.DAY_OF_WEEK, 1);
				System.out.println("TO:"+new Date(c.getTimeInMillis()));
				query.setString("toDate", sdf.format(c.getTime()) + " 00:00:00");
				query.setString("listHeader", "DAILY");
				query.setString("gameType", gameType);
				query.setString("subGameType", subGameType);
				query.setResultTransformer(Transformers
						.aliasToBean(PortalWinnersList.class));
				;
				winList = query.list();
				session.connection().setReadOnly(false);
				
			} else if ("month".equals(durationParam)) {
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH, -1);
				c.set(Calendar.DATE, 0);
				session.connection().setReadOnly(true);
				query = session.getNamedQuery("getWinner");
				query.setString("domainId", aliasId.toString());
				query.setString("toDate", sdf.format(c.getTime()) + " 23:59:59");
				c.set(Calendar.DATE, 1);
				query.setString("fromDate", sdf.format(c.getTime())
						+ " 00:00:00");
				query.setString("listHeader", "MONTHLY");
				query.setString("gameType", gameType);
				query.setString("subGameType", subGameType);
				query.setResultTransformer(Transformers
						.aliasToBean(PortalWinnersList.class));
				;
				winList = query.list();
				session.connection().setReadOnly(false);
			}
			// yearly winner
			else if ("year".equals(durationParam)) {
				c.setTime(new Date());
				int year = (c.get(Calendar.YEAR)) - 1;
				c.set(Calendar.YEAR, year);
				c.set(Calendar.WEEK_OF_YEAR, 1);
				c.set(Calendar.DAY_OF_WEEK, 1);
				session.connection().setReadOnly(true);
				query = session.getNamedQuery("getWinner");
				query.setString("domainId", aliasId.toString());
				query.setString("fromDate", sdf.format(c.getTime())
						+ " 00:00:00");
				c.set(Calendar.YEAR, year);
				c.set(Calendar.MONTH, 11); // 11 = december
				c.set(Calendar.DAY_OF_MONTH, 31);
				query.setString("toDate", sdf.format(c.getTime()) + " 23:59:59");
				query.setString("listHeader", "YEARLY");
				query.setString("gameType", gameType);
				query.setString("subGameType", subGameType);
				query.setResultTransformer(Transformers
						.aliasToBean(PortalWinnersList.class));
				;
				winList = query.list();
				session.connection().setReadOnly(false);
			}
			// all time winner
			else if ("all".equals(durationParam)) {
				session.connection().setReadOnly(true);
				query = session.getNamedQuery("getWinner");
				query.setString("domainId", aliasId.toString());
				query.setString("fromDate", "");
				query.setString("toDate", "");
				query.setString("listHeader", "ALLTIME");
				query.setString("gameType", gameType);
				query.setString("subGameType", subGameType);
				query.setResultTransformer(Transformers
						.aliasToBean(PortalWinnersList.class));
				;
				winList = query.list();
				session.connection().setReadOnly(false);
			} else {
				c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				c.add(Calendar.DAY_OF_WEEK, -7);
				session.connection().setReadOnly(true);
				query = session.getNamedQuery("getWinner");
				query.setString("domainId", aliasId.toString());
				query.setString("fromDate", sdf.format(c.getTime())
						+ " 00:00:00");
				c.add(Calendar.DAY_OF_WEEK, 6);
				query.setString("toDate", sdf.format(c.getTime()) + " 23:59:59");
				query.setString("listHeader", "WEEKLY");
				query.setString("gameType", gameType);
				query.setString("subGameType", subGameType);
				query.setResultTransformer(Transformers
						.aliasToBean(PortalWinnersList.class));
				winList = query.list();
				session.connection().setReadOnly(false);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Exception");
		}

		return winList;
	}*/

	public static void plrLastTxnData(Session session, long playerId,
			short domainId, short aliasId, String activity, Double activityVal,
			Timestamp activityTime) {
		Transaction tx=null;
		try {
			log.info("-----update player activity data start-------");
			log.info("---activity-----" + activity);
			log.info("----activity value---" + activityVal);
			log.info("------activity time-----" + activityTime + "------");
			StringBuilder sb = null;
			Query query = null;
			 tx = session.beginTransaction();
			sb = new StringBuilder(
					"update StPmPlayerLastActivityRecords set last"
							+ WordUtils.capitalize(activity.toLowerCase())
							+ "Date='" + activityTime + "'");
			sb.append(" ,last" + WordUtils.capitalize(activity.toLowerCase())
					+ "AliasId=" + aliasId);

			if (activityVal != null) {
				sb.append(" ,last"
						+ WordUtils.capitalize(activity.toLowerCase())
						+ "Amount=" + activityVal);
			}
			sb.append(" where playerId=" + playerId + " and domainId="
					+ domainId);
			query = session.createQuery(sb.toString());
			query.executeUpdate();
			session.flush();
			tx.commit();
			log.info("-----update player activity data end----");
		} catch (Exception e) {
			if(tx!=null && tx.isActive())
				tx.rollback();
			log.info("-----update player activity has encountered some error-------");
			e.printStackTrace();
		} catch (Error e) {
			log.info("-----update player activity has encountered some error-------");
			e.printStackTrace();
		}
	}

	public static void plrLastTxnData(Session session, Transaction tx,
			long playerId, short domainId, short aliasId, String activity,
			Double activityVal, Timestamp activityTime) {
		try {
			log.info("-----update player activity data start-------");
			log.info("---activity-----" + activity);
			log.info("----activity value---" + activityVal);
			log.info("------activity time-----" + activityTime + "------");
			StringBuilder sb = null;
			Query query = null;
			sb = new StringBuilder(
					"update StPmPlayerLastActivityRecords set last"
							+ WordUtils.capitalize(activity.toLowerCase())
							+ "Date='" + activityTime + "'");
			sb.append(" ,last" + WordUtils.capitalize(activity.toLowerCase())
					+ "AliasId=" + aliasId);
			if (activityVal != null) {
				sb.append(" ,last"
						+ WordUtils.capitalize(activity.toLowerCase())
						+ "Amount=" + activityVal);
			}
			sb.append(" where playerId=" + playerId + " and domainId="
					+ domainId);
			query = session.createQuery(sb.toString());
			query.executeUpdate();
			session.flush();
			log.info("-----update player activity data end----");
		} catch (Exception e) {
			log.info("-----update player activity has encountered some error-------");
			e.printStackTrace();
		} catch (Error e) {
			log.info("-----update player activity has encountered some error-------");
			e.printStackTrace();
		}
	}

	public boolean checkBlockedEmailId(String emailId, short domainId,
			Session session) throws PMSException {
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(StDmBlockedEmailId.class);
			criteria.add(Restrictions.like("emailId", emailId));
			criteria.add(Restrictions.eq("domainId", domainId));
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			if (criteria.list().size() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return false;
	}

	public boolean checkBlockedIPAddress(String ipAddress, short domainId,
			Session session) throws PMSException {
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(StDmBlockedIp.class)
					.setCacheable(true);
			criteria.add(Restrictions.like("blockedIp", ipAddress));
			criteria.add(Restrictions.eq("domainId", domainId));
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			if (criteria.list().size() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}

		return false;
	}

	public boolean checkBlockedPhoneNo(String mobileNo, short domainId,
			Session session) throws PMSException {
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(StDmBlockedPhoneNo.class);
			criteria.add(Restrictions.like("phoneNo", Long.valueOf(mobileNo)));
			criteria.add(Restrictions.eq("domainId", domainId));
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			if (criteria.list().size() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	public OfflineAffiliateDetailBean authenticateOfflineAffiliate(
			String userName, String password, Session session)
			throws PMSException {
		try {
			Criteria criteria = session
					.createCriteria(StOfflineAffiliateMaster.class);
			criteria.add(Restrictions.eq("userName", userName));
			criteria.add(Restrictions.eq("password", password));

			List<StOfflineAffiliateMaster> list = criteria.list();
			if (list.size() == 1) {
				StOfflineAffiliateMaster affiliateMaster = list.get(0);
				return new OfflineAffiliateDetailBean(
						affiliateMaster.getAffiliateId(),
						affiliateMaster.getAffiliateCode(),
						affiliateMaster.getUserName(),
						affiliateMaster.getPassword(),
						affiliateMaster.getSecreatKey(),
						affiliateMaster.getProviderId());
			} else {
				throw new PMSException(PMSErrorCode.API_UNAUTH_SERVICE_USER,
						PMSErrorMessage.API_UNAUTH_SERVICE_USER);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
					PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (PMSException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
	}

	public OfflineAffiliateDetailBean getOfflineAffiliateInfo(
			Integer affiliateId, Session session) throws PMSException {
		StOfflineAffiliateMaster affiliateMaster = (StOfflineAffiliateMaster) session
				.get(StOfflineAffiliateMaster.class, affiliateId);

		return new OfflineAffiliateDetailBean(affiliateMaster.getAffiliateId(),
				affiliateMaster.getAffiliateCode(),
				affiliateMaster.getUserName(), affiliateMaster.getPassword(),
				affiliateMaster.getSecreatKey(),
				affiliateMaster.getProviderId());

	}

	@SuppressWarnings("unchecked")
	public LinkedHashMap<String, String> variableMap(long playerId,
			short domainId, String variableScope, Session sess)
			throws PMSException {
		log.info("---- Inside Variable Map Fetch for player ----" + playerId);
		Criteria playerInfoCri = null;
		Criteria variableMasterCri = null;
		Criteria deposit = null;
		Criteria withdrawal = null;
		Criteria wager = null;
		LinkedHashMap<String, String> varibleMap = new LinkedHashMap<String, String>();
		Object object = null;
		Method method = null;
		String value = null;
		StVipCriteriaCurrentStatusDeposit lastMonthD = null;
		StVipCriteriaCurrentStatusWithdrawal withdrawalDetails = null;
		StVipCriteriaCurrentStatusWagerRummy wagerDetails = null;
		Map<String, Method> methodsMap = new HashMap<String, Method>();
		try {
			Method[] allMethods = StPmPlayerMaster.class.getMethods();
			for (Method m : allMethods) {
				methodsMap.put(m.getName(), m);
			}
			playerInfoCri = sess.createCriteria(StPmPlayerMaster.class);
			playerInfoCri.add(Restrictions.eq("playerId", playerId));
			playerInfoCri.add(Restrictions.eq("domainId", domainId));
			List<Object> list = playerInfoCri.list();
			StPmPlayerMaster playerInfo = null;
			if (list.size() > 0) {
				playerInfo = (StPmPlayerMaster) list.get(0);
			} else {
				throw new PMSException("No player exists for playerId = "
						+ playerId);
			}
			deposit = sess
					.createCriteria(StVipCriteriaCurrentStatusDeposit.class);
			deposit.add(Restrictions.eq("playerId", playerId));
			deposit.add(Restrictions.eq("domainId", domainId));
			list = deposit.list();
			if (list.size() > 0) {
				lastMonthD = (StVipCriteriaCurrentStatusDeposit) list.get(0);
			}
			withdrawal = sess
					.createCriteria(StVipCriteriaCurrentStatusWithdrawal.class);
			withdrawal.add(Restrictions.eq("playerId", playerId));
			withdrawal.add(Restrictions.eq("domainId", domainId));
			list = withdrawal.list();
			if (list.size() > 0) {
				withdrawalDetails = (StVipCriteriaCurrentStatusWithdrawal) list
						.get(0);
			}
			wager = sess
					.createCriteria(StVipCriteriaCurrentStatusWagerRummy.class);
			wager.add(Restrictions.eq("playerId", playerId));
			wager.add(Restrictions.eq("domainId", domainId));
			list = wager.list();
			if (list.size() > 0) {
				wagerDetails = (StVipCriteriaCurrentStatusWagerRummy) list
						.get(0);
			}
			variableMasterCri = sess.createCriteria(StGenVariableMaster.class);
			variableMasterCri.add(Restrictions.eq("variableScope",
					variableScope));
			variableMasterCri.add(Restrictions.eq("status", "ACTIVE"));
			List<StGenVariableMaster> tempList = variableMasterCri.list();
			varibleMap.put("EmailId", playerInfo.getEmailId());
			varibleMap.put(
					"DomainName",
					CommonMethodDaoImpl
							.getInstance()
							.getAliasPropertyMap(sess, playerInfo.getAliasId(),
									"aliasName").get("aliasName"));
			varibleMap.put("Balance", playerInfo.getPlayerWallet()
					.getTotalBal().toString());
			varibleMap.put("City", playerInfo.getStPmPlayerInfo().getCity());
			if (playerInfo.getStPmPlayerInfo().getStGenStateMaster() != null) {
				varibleMap.put("State", playerInfo.getStPmPlayerInfo()
						.getStGenStateMaster().getName());
			}
			if (playerInfo.getStPmPlayerInfo().getStGenCountryMaster() != null) {
				varibleMap.put("Country", playerInfo.getStPmPlayerInfo()
						.getStGenCountryMaster().getName());
			}
			varibleMap.put("Address", playerInfo.getStPmPlayerInfo()
					.getAddressLine1());
			if (lastMonthD != null) {
				varibleMap.put("LastMonthDeposit", lastMonthD
						.getLastMonthValue().toString());
				varibleMap.put("LastQuarterDeposit", lastMonthD
						.getLastQuarterValue().toString());
				varibleMap.put("LastYearDeposit", lastMonthD.getLastYearValue()
						.toString());
				varibleMap.put("SinceRegDeposit", lastMonthD
						.getSinceRegiValue().toString());
			}
			if (withdrawalDetails != null) {
				varibleMap.put("LastMonthWithdrawal", withdrawalDetails
						.getLastMonthValue().toString());
				varibleMap.put("LastQuarterWithdrawal", withdrawalDetails
						.getLastQuarterValue().toString());
				varibleMap.put("LastYearWithdrawal", withdrawalDetails
						.getLastYearValue().toString());
				varibleMap.put("SinceRegWithdrawal", withdrawalDetails
						.getSinceRegiValue().toString());
			}
			if (wagerDetails != null) {
				varibleMap.put("LastMonthWagerRummy", wagerDetails
						.getLastMonthValue().toString());
				varibleMap.put("LastQuarterWagerRummy", wagerDetails
						.getLastQuarterValue().toString());
				varibleMap.put("LastYearWagerRummy", wagerDetails
						.getLastYearValue().toString());
				varibleMap.put("SinceRegWagerRummy", wagerDetails
						.getSinceRegiValue().toString());
			}
			varibleMap.put("CashBalance", playerInfo.getPlayerWallet()
					.getCashBal().toString());
			varibleMap.put("TotalDeposit", playerInfo.getPlayerWallet()
					.getTotalDeposit().toString());
			varibleMap.put("TotalBonus", playerInfo.getPlayerWallet()
					.getTotalBonus().toString());
			varibleMap.put("TotalWager", playerInfo.getPlayerWallet()
					.getTotalWager().toString());
			varibleMap.put("TotalWinning", playerInfo.getPlayerWallet()
					.getTotalWinning().toString());
			varibleMap.put("TotalWithdrawal", playerInfo.getPlayerWallet()
					.getTotalWithdrawal().toString());
			for (StGenVariableMaster temp : tempList) {
				value = WordUtils.capitalize(temp.getVariableCode());
				if (!varibleMap.containsKey(value)) {
					if (methodsMap.containsKey("get" + value)) {
						method = methodsMap.get("get" + value);
						object = method.invoke(playerInfo);
					} else {
						object = "0.0";
					}
					if (object != null) {
						varibleMap.put(temp.getVariableCode(),
								object.toString());
					} else {
						varibleMap.put(temp.getVariableCode(), "");// For Mini
																	// Reg First
																	// Name and
																	// last Name
																	// will be
																	// null
					}
				}
			}
			log.info("---- Complete Variable Map Fetch for player -------");
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
					PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return varibleMap;
	}

	public CurrencyConversionDefBean fetchCurrencyExchangeBean(
			CurrencyConversionDefBean frmCurBean,
			CurrencyConversionDefBean toCurBean) throws PMSException {
		CurrencyConversionDefBean curBean = null;
		if (frmCurBean != null && toCurBean != null) {
			curBean = new CurrencyConversionDefBean();
			curBean.setCurrencyId(toCurBean.getCurrencyId());
			curBean.setExchangeChargeCurrId(toCurBean.getExchangeChargeCurrId());
			curBean.setExchangeCharge(toCurBean.getExchangeCharge());
			curBean.setExchangeRate(toCurBean.getExchangeRate()
					/ frmCurBean.getExchangeRate());
		}
		if (curBean == null) {
			throw new PMSException("Exchange Rate Not Available");
		}
		return curBean;
	}

	public Map<String, String> getDmPropertyMap(Session session,
			Short domainId, String... strings) throws PMSException {
		Map<String, String> propMap = new HashMap<String, String>();
		try {
			StDmDomainMaster domainMaster = (StDmDomainMaster) session.get(
					StDmDomainMaster.class, domainId);
			if (domainMaster != null) {
				propMap = new HashMap<String, String>();
				for (int i = 0; i < strings.length; i++) {
					propMap.put(strings[i],
							BeanUtils.getProperty(domainMaster, strings[i]));
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return propMap;
	}

    /**
     * A lightweight method to get alias properties from StDmAliasPropertyMaster, in a single hit.
     * @param session Hibernate session.
     * @param aliasId aliasId of Alias.
     * @param props property names as string vararg.
     * @return A relevant map of key-value pairs.
     */
	public Map<String,String> fetchAliasPropMap(Session session,Short aliasId, String... props){
	    Map<String,String> propMap=new HashMap<>();
        Criteria criteria = session.createCriteria(StDmAliasPropertyMaster.class);
        List<StDmAliasPropertyMaster> propList = criteria.add(Restrictions.eq("aliasId", aliasId))
                .add(Restrictions.in("propertyName", props))
                .add(Restrictions.eq("status", "ACTIVE"))
                .list();
        for(StDmAliasPropertyMaster prop:propList)
            propMap.put(prop.getPropertyName(),prop.getPropertyValue());
        return propMap;
    }

	public Map<String, String> getAliasPropertyMap(Session session,
			Short aliasId, String... strings) throws PMSException {
		Map<String, String> propMap=null;
		try {
			StDmDomainAliasNameMaster aliasMaster = (StDmDomainAliasNameMaster) session
					.get(StDmDomainAliasNameMaster.class, aliasId);
			if (aliasMaster != null) {
				propMap = new HashMap<>();
				for (int i = 0; i < strings.length; i++) {
					propMap.put(strings[i],
							BeanUtils.getProperty(aliasMaster, strings[i]));
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return propMap;
	}

	public StDmDomainAliasNameMaster getAliasMaster(Session session,
			Short aliasId) throws PMSException {
		try {
			return (StDmDomainAliasNameMaster) session.get(
					StDmDomainAliasNameMaster.class, aliasId);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
	}

	public Map<String, String> getDmPropFromAliasId(Session session,
			Short aliasId, String... strings) throws PMSException {
		Map<String, String> propMap = new HashMap<String, String>();
		try {
			StDmDomainAliasNameMaster aliasMaster = (StDmDomainAliasNameMaster) session
					.get(StDmDomainAliasNameMaster.class, aliasId);
			if (aliasMaster != null) {
				StDmDomainMaster domainMaster = aliasMaster.getDomainMaster();
				propMap = new HashMap<String, String>();
				for (int i = 0; i < strings.length; i++) {
					propMap.put(strings[i],
							BeanUtils.getProperty(domainMaster, strings[i]));
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return propMap;

	}

	@SuppressWarnings("unchecked")
	public String getDmProperty(Session session, Short domainId, String propStr)
			throws PMSException {
		String propValue;
		log.info("-------Domian Property Name---------" + propStr);
		try {
			if (domainId > 0) {
				Query qry = session.createQuery("select " + propStr
						+ " from StDmDomainMaster where domainId=:domainId");
				qry.setParameter("domainId", domainId);
				qry.setCacheable(true);
				qry.setCacheRegion("StDmDomainMasterCache");
				List<Object> prop = qry.list();
				if (!prop.isEmpty()) {
					propValue = String.valueOf(prop.get(0));
				} else {
					throw new PMSException(PMSErrorCode.GEN_OP_NOT_SUPPORTED,PMSErrorMessage.GEN_OP_NOT_SUPPORTED);
				}
			} else {
				throw new PMSException(PMSErrorCode.API_INVALID_DOMAIN,PMSErrorMessage.API_INVALID_DOMAIN);
			}
		} catch (PMSException e) {
			e.printStackTrace();
			throw e;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return propValue;
	}
	 

	@SuppressWarnings("unchecked")
	public String getDmAliasProperty(Session session, Short aliasId,
			String propStr) throws PMSException {
		String propValue = null;
		log.info("-------Domian Alias Property Name---------" + propStr);
		try {
			if (aliasId > 0) {
				Query qry = session
						.createQuery("select "
								+ propStr
								+ " from StDmDomainAliasNameMaster where aliasId=:aliasId");
				qry.setParameter("aliasId", aliasId);
				List<Object> prop = qry.list();
				if (prop.size() > 0) {
					propValue = String.valueOf(prop.get(0));
				} else {
					throw new PMSException("Property Not Available");
				}
			} else {
				throw new PMSException("Alias Not Found " + aliasId);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return propValue;
	}

	@SuppressWarnings("unchecked")
	public PasswordPolicyBean fetchDomainWisePasswordValidation(
			Session session, short domainId) throws PMSException {
		PasswordPolicyBean bean = null;
		// StDmDomainMaster dmBean =
		// (StDmDomainMaster)session.load(StDmDomainMaster.class, domainId);
		Criteria cri = session.createCriteria(StDmDomainMaster.class);
		// cri.setCacheable(true);
		cri.createAlias("stGenPasswordPolicy", "gpp");
		ProjectionList prop = Projections.projectionList();
		// prop.add(Projections.property("gpp.passwordPolicyId"));
		prop.add(Projections.property("gpp.passwordPolicy"), "passwordPolicy");
		prop.add(Projections.property("gpp.passwordExpression"),
				"passwordExpression");
		prop.add(Projections.property("gpp.passwordStrengthCheck"),
				"passwordStrengthCheck");
		prop.add(Projections.property("gpp.helpStringCode"), "helpStringCode");
		prop.add(Projections.property("gpp.status"), "status");
		cri.setProjection(prop);
		cri.add(Restrictions.eq("domainId", domainId));
		cri.add(Restrictions.eq("domainStatus", "ACTIVE"));
		cri.setResultTransformer(Transformers
				.aliasToBean(PasswordPolicyBean.class));
		List<PasswordPolicyBean> list = cri.list();
		if (list != null) {
			for (PasswordPolicyBean obj : list) {
				bean = obj;
			}
		} else {
			throw new PMSException("No Password Policy found");
		}
		return bean;
	}

	@SuppressWarnings("unchecked")
	public StCmsTemplateMaster fetchTempleteUrlMap(short aliasId,
			String templateType, String templateName, String mode, Session session)
			throws PMSException {
		StCmsTemplateMaster templateMaster = null;
		try {
			Criteria crit = session.createCriteria(StCmsTemplateMaster.class);
			crit.add(Restrictions.eq("aliasId", aliasId));
			crit.add(Restrictions.eq("templateType", templateType));
			crit.add(Restrictions.eq("mode", mode));
			if ("BO_USE".equals(templateType) && templateName != null) {
				crit.add(Restrictions.eq("templateSubject", templateName));
				crit.add(Restrictions.eq("sentOn", "EXTERNAL"));
			}
			crit.add(Restrictions.eq("status", "ACTIVE"));
			List<StCmsTemplateMaster> list = crit.list();
			if (list.size() == 1) {
				templateMaster = list.get(0);
			} else {
				throw new PMSException("No or Multiple template found for "
						+ templateType + "---" + templateName);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}

		return templateMaster;
	}

	@SuppressWarnings("unchecked")
	public Map<Integer, CurrencyBean> fetchActiveDmCurrMap(Short domainId,
			Session session) throws PMSException {
		Map<Integer, CurrencyBean> dmActiveCurrMap = new HashMap<Integer, CurrencyBean>();
		CurrencyBean currencyBean = null;
		try {
			Criteria cri = session
					.createCriteria(StDmDomainCurrencyMapping.class)
					.setCacheable(true);
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.add(Restrictions.eq("domainId", domainId));
			List<StDmDomainCurrencyMapping> list = cri.list();
			for (StDmDomainCurrencyMapping mapping : list) {
				currencyBean = new CurrencyBean();
				currencyBean.setCurrencyId(mapping.getCurrencyMaster()
						.getCurrencyId());
				currencyBean.setCurrCode(mapping.getCurrencyMaster()
						.getCurrencyCode());
				currencyBean.setCurrName(mapping.getCurrencyMaster()
						.getCurrencyDescription());
				dmActiveCurrMap.put(
						mapping.getCurrencyMaster().getCurrencyId(),
						currencyBean);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return dmActiveCurrMap;
	}
	
	@SuppressWarnings("unchecked")
	public List<AliasBean> fetchActiveAliasMap(Short domainId,
			Session session) throws PMSException {
		List<AliasBean> aliasList = new ArrayList<AliasBean>();
		AliasBean aliasBean = null;
		try {
			Criteria cri = session
					.createCriteria(StDmDomainAliasNameMaster.class).createAlias(
							"domainMaster", "domainMaster", Criteria.LEFT_JOIN);
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.add(Restrictions.eq("domainMaster.domainId", domainId));
			List<StDmDomainAliasNameMaster> list = cri.list();
			for (StDmDomainAliasNameMaster mapping : list) {
				aliasBean = new AliasBean();
				aliasBean.setAliasId(mapping.getAliasId());
				aliasBean.setAliasName(mapping.getAliasName());
				aliasList.add(aliasBean);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return aliasList;
	}

	// public double convertToNativeCurrency(double amt, int
	// fromCurrencyId,Session session)
	// throws PMSException {
	// double nativCurrency = 0;
	// try {
	// int nativeCurrencyId =
	// Integer.parseInt(fetchSystemProperties("NATIVE_CURRENCY",session).toString());
	// nativCurrency = amt
	// * fetchCurrencyExchangeBean(
	// fromCurrencyId, nativeCurrencyId).getExchangeRate();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return nativCurrency;
	// }

	@SuppressWarnings("unchecked")
	public List<VipLevelMasterBean> fetchDomainVipLevelList(short domainId,
			String vipLevel, Session session) throws PMSException {
		List<VipLevelMasterBean> vipLavelList = new ArrayList<VipLevelMasterBean>();
		try {
			if (vipLevel != null) {
				Criteria cri = session.createCriteria(StVipLevelMaster.class)
						.addOrder(Order.asc("vipLevel"));
				if (!vipLevel.equals("")) {
					// vipLevel = "AUTO";
					cri.add(Restrictions.eq("levelType", vipLevel));
				}
				cri.add(Restrictions.eq("domainId", domainId));
				cri.add(Restrictions.eq("status", "ACTIVE"));
				List<StVipLevelMaster> vipList = cri.list();
				VipLevelMasterBean vipBean = null;
				String dispCode = null;
				for (StVipLevelMaster vip : vipList) {
					dispCode = Utility.getDisplayCodeValue(
							vip.getVipDispCode(), session);
					vipBean = new VipLevelMasterBean(vip.getId(),
							vip.getDomainId(), vip.getVipLevel(),
							vip.getVipCode(), vip.getVipColor(),
							vip.getLevelType(), vip.getVipRule(),
							vip.getStatus(), vip.getVipGroup(), dispCode,
							vip.getRemarks());
					vipLavelList.add(vipBean);
				}
			} else {
				throw new PMSException("Vip Level Can't be NULL");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return vipLavelList;

	}
	

	public double convertToNativeCurrency(double amt, int fromCurrencyId,
			Session session) throws PMSException {
		int nativeCurrencyId = Integer.parseInt(fetchSystemProperties(
				"NATIVE_CURRENCY", session));
		return amt
				* fetchUpdateCurrencyConversionRate(fromCurrencyId,
						nativeCurrencyId, session).getExchangeRate();
	}

	@SuppressWarnings("unchecked")
	public String getDeviceLayout(Short domainId, String device, Session session)
			throws PMSException {
		String layout = null;
		try {
			Criteria cri = session
					.createCriteria(StPortalDeviceDomainMapping.class);
			cri.createAlias("domainMaster", "dm");
			cri.setProjection(Projections.property("layout"));
			cri.add(Restrictions.eq("dm.domainId", domainId));
			cri.add(Restrictions.eq("device", device));
			List<Object> list = cri.list();
			if (!list.isEmpty()) {
				layout = (String) list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return layout;
	}

	@SuppressWarnings("unchecked")
	public String fetchAliasLayout(Short aliasId, String device, Session session)
			throws PMSException {
		String layout = null;
		try {
			Criteria cri = session
					.createCriteria(StPortalDeviceDomainMapping.class);
			cri.createAlias("aliasMaster", "am");
			cri.setProjection(Projections.property("layout"));
			cri.add(Restrictions.eq("am.aliasId", aliasId));
			cri.add(Restrictions.eq("device", device));
			List<Object> list = cri.list();
			if (!list.isEmpty()) {
				layout = (String) list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return layout;
	}

	@SuppressWarnings("unchecked")
	public String fetchDomainNameLayout(String domainName, Session session)
			throws PMSException {
		String layout = null;
		try {
			Criteria cri = session
					.createCriteria(StPortalDeviceDomainMapping.class);
			cri.setCacheable(true);
			cri.setCacheRegion("StPortalDeviceDomainMappingCache");
			cri.add(Restrictions.eq("domainAlias", domainName));
			cri.add(Restrictions.eq("status", "ACTIVE"));
			List<StPortalDeviceDomainMapping> list = cri.list();
			StPortalDeviceDomainMapping mappingBean = null;
			if (!list.isEmpty()) {
				mappingBean = list.get(0);
				layout = mappingBean.getLayout() + "/"
						+ mappingBean.getDevice() + "/LR";
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return layout;
	}

	@SuppressWarnings("unchecked")
	public Map<Short, String> getDomainIdMap(Session session)
			throws PMSException {
		Map<Short, String> dmIdMap = new HashMap<Short, String>();
		try {
			Criteria cri = session.createCriteria(StDmDomainMaster.class).setCacheable(true);
			List<StDmDomainMaster> domainMasterList = cri.list();
			for (StDmDomainMaster stDmDomainMaster : domainMasterList) {
				dmIdMap.put(stDmDomainMaster.getDomainId(),
						stDmDomainMaster.getDomainName());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return dmIdMap;
	}

	@SuppressWarnings("unchecked")
	public List<CountryBean> fetchActiveCountryList(short domainId,
			Session session) throws PMSException {
		List<CountryBean> countryList = new ArrayList<CountryBean>();
		CountryBean countryBean = null;
		try {
			Criteria cri = session
					.createCriteria(StDmDomainCountryMapping.class);
			cri.createAlias("countryMaster", "cm");
			if (domainId == 0) {
				domainId = 1;
			}
			cri.add(Restrictions.eq("domainId", domainId));
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.add(Restrictions.eq("cm.status", "ACTIVE"));
			List<StDmDomainCountryMapping> list = cri.list();
			for (StDmDomainCountryMapping mapping : list) {
				countryBean = new CountryBean();
				countryBean.setCountryId(mapping.getCountryMaster().getId());
				countryBean.setCountryCode(mapping.getCountryMaster()
						.getCountryCode());
				countryBean.setName(mapping.getCountryMaster().getName());
				countryBean.setStateList(new ArrayList<StateBean>());
				countryList.add(countryBean);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return countryList;

	}

	@SuppressWarnings("unchecked")
	public List<StateBean> fetchActiveStateList(short domainId,
			Integer countryId, Session session) throws PMSException {
		List<StateBean> stateList = new ArrayList<StateBean>();
		StateBean stateBean = null;
		try {
			String domainProp = getDmProperty(session, domainId,
					"allowedStates");
			Criteria cri = session.createCriteria(StDmDomainStateMapping.class);
			cri.createAlias("stateMaster", "sm");
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.add(Restrictions.eq("countryId", countryId));
			cri.add(Restrictions.eq("sm.status", "ACTIVE"));
			cri.add(Restrictions.eq("domainId",
					domainProp.equals("BYDEFAULT") ? (short) 1 : domainId));
			cri.addOrder(Order.asc("sm.name"));
			List<StDmDomainStateMapping> list = cri.list();
			for (StDmDomainStateMapping mapping : list) {
				stateBean = new StateBean();
				stateBean.setStateId(mapping.getStateMaster().getId());
				stateBean.setStateCode(mapping.getStateMaster().getStateCode());
				stateBean.setName(mapping.getStateMaster().getName());
				// code added for state and country mapping
				stateBean.setCountryId(mapping.getStateMaster().getCountryId());
				stateList.add(stateBean);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return stateList;

	}

	@SuppressWarnings("unchecked")
	public Map<Integer, LanguageBean> fetchDmActiveLangMap(Short domainId,
			Session session) throws PMSException {
		Map<Integer, LanguageBean> dmLanMap = new HashMap<Integer, LanguageBean>();
		LanguageBean languageBean = null;
		try {
			Criteria cri = session
					.createCriteria(StDmDomainLanguageMapping.class);
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.add(Restrictions.eq("domainId", domainId));
			List<StDmDomainLanguageMapping> list = cri.list();
			for (StDmDomainLanguageMapping mapping : list) {
				languageBean = new LanguageBean();
				languageBean.setLanguageId(mapping.getLanguageMaster()
						.getLanguageId());
				languageBean.setLanguageCode(mapping.getLanguageMaster()
						.getLanguageCode());
				languageBean.setLanguageBaseCode(mapping.getLanguageMaster()
						.getLanguageBaseCode());
				languageBean.setLanguageName(mapping.getLanguageMaster()
						.getLanguageName());
				dmLanMap.put(mapping.getLanguageMaster().getLanguageId(),
						languageBean);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return dmLanMap;

	}

	@SuppressWarnings("unchecked")
	public short getDomainIdFromName(String domainName, Session session)
			throws PMSException {
		short domainId = 0;
		try {
			Criteria cri = session
					.createCriteria(StPortalDeviceDomainMapping.class);
			cri.setCacheable(true);
			cri.setCacheRegion("StPortalDeviceDomainMappingCache");
			cri.createAlias("domainMaster", "dm");
			cri.setProjection(Projections.property("dm.domainId"));
			cri.add(Restrictions.eq("domainAlias", domainName));
			List<Object> list = cri.list();
			if (!list.isEmpty()) {
				domainId = (Short) list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return domainId;
	}


	@SuppressWarnings("unchecked")
	public Integer getCurrencyIdFromCurrencyCode(String currencyCode, Session session)
			throws PMSException {
		Integer currencyId;
		try {
			Criteria cri = session
					.createCriteria(StGenCurrencyMaster.class);
			cri.setProjection(Projections.property("currencyId"));
			cri.add(Restrictions.eq("currencyCode", currencyCode ));
			List<Integer> list = cri.list();
			if (list.size() > 0)
				currencyId = list.get(0);
			else
				throw new PMSException(PMSErrorCode.INVALID_CURRENCY_CODE,PMSErrorMessage.INVALID_CURRENCY_CODE);
		}
		catch(PMSException e){
			log.error(e.getMessage(),e);
			throw e;
		}
		catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return currencyId;
	}


	@SuppressWarnings("unchecked")
	public short getDomainIdFromDomainName(String domainName, Session session)
			throws PMSException {
		log.debug(":: Fetch Domain Id From Alias Name :: "+domainName);
		short domainId=0;
		try {
			Criteria cri = session
					.createCriteria(StDmDomainAliasNameMaster.class);
			cri.createAlias("domainMaster", "dm");
			cri.setProjection(Projections.property("dm.domainId"));
			cri.add(Restrictions.eq("aliasName", domainName));
			List<Object> list = cri.list();
//			if (list.size() > 0)
//				domainId = (Short) list.get(0);
//			else
//				throw new PMSException(PMSErrorCode.DOMAIN_NOT_VAILD,PMSErrorMessage.DOMAIN_NOT_VAILD);
			
			if (!list.isEmpty()) {
				domainId = (Short) list.get(0);
			}

		}
//		catch(PMSException e){
//			log.error(e.getMessage(),e);
//			throw e;
//		}
		catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return domainId;
	}

	@SuppressWarnings("unchecked")
	public Short[] getDomainAliasIdFromDomainName(String domainName, Session session)
			throws PMSException {
		log.debug(":: Fetch Domain Id and alias Id From Alias Name :: "+domainName);
		Short arr[];
		try {
			arr = new Short[2];
			Criteria cri = session
					.createCriteria(StDmDomainAliasNameMaster.class);
			cri.createAlias("domainMaster", "dm");

			cri.setProjection(Projections.property("dm.domainId"));
			cri.add(Restrictions.eq("aliasName", domainName));

			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.property("dm.domainId"));
			proList.add(Projections.property("aliasId"));
			cri.setProjection(proList);
			List<Object[]> resultList = cri.list();
			if (resultList.size() == 1){
				for (Object[] list : resultList) {
					arr[0] = (Short)list[0];
					arr[1] = (Short)list[1];
				}
			}
			else
				throw new PMSException(PMSErrorCode.DOMAIN_NOT_VAILD,PMSErrorMessage.DOMAIN_NOT_VAILD);

		}
		catch(PMSException e){
			log.error(e.getMessage(),e);
			throw e;
		}
		catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return arr;
	}

	@SuppressWarnings("unchecked")
	public StPortalDeviceDomainMapping fetchDeviceDmMapping(Session session,
			String serverName) throws PMSException {
		Criteria cri = session
				.createCriteria(StPortalDeviceDomainMapping.class);
		cri.add(Restrictions.eq("domainAlias", serverName));
		cri.add(Restrictions.eq("status", "ACTIVE"));
		List<StPortalDeviceDomainMapping> list = cri.list();
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			throw new PMSException("Domain Not Found");
		}
	}

	@SuppressWarnings("unchecked")
	public StDmDomainAliasNameMaster fetchAliasMasFromAliasName(
			Session session, String aliasName) throws PMSException {
		Criteria cri = session.createCriteria(StDmDomainAliasNameMaster.class);
		cri.add(Restrictions.eq("aliasName", aliasName));
		cri.setCacheable(true);
		cri.setCacheRegion("StDmDomainAliasNameMasterCache");
		List<StDmDomainAliasNameMaster> list = cri.list();
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			throw new PMSException(PMSErrorCode.API_INVALID_ALIAS_NAME,PMSErrorMessage.API_INVALID_ALIAS_NAME);
		}
	}

	@SuppressWarnings("unchecked")
	public short fetchAliasIDFromAliasName(Session session, String aliasName)
			throws PMSException {
		log.info("--------------Start fetch alias id from alias name from dao------------");
		Criteria cri = session.createCriteria(StDmDomainAliasNameMaster.class);
		cri.add(Restrictions.eq("aliasName", aliasName));
		cri.setProjection(Projections.property("aliasId"));
		List<Short> list = cri.list();
		if (list.size() > 0) {
			log.info("--------------End fetch alias id from alias name from dao------------");
			return list.get(0);
		} else {
			throw new PMSException(PMSErrorCode.API_INVALID_ALIAS_NAME,
					PMSErrorMessage.API_INVALID_ALIAS_NAME);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> fetchGenProperties(Session session,
			String... propName) throws PMSException {
		try {
			Criteria cri = session.createCriteria(StGenPropertyMaster.class);
			cri.setCacheable(true);
			cri.setCacheRegion("StGenPropertyMasterCache");
			cri.add(Restrictions.in("propertyCode", propName));
			cri.add(Restrictions.eq("status", "ACTIVE"));
			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.property("propertyCode"));
			proList.add(Projections.property("value"));
			cri.setProjection(proList);
			return (List<Object[]>) cri.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
	}

	@SuppressWarnings("unchecked")
	public String fetchCountryNameByCode(String countryCode, Session session) {
		try {
			Criteria cri = session.createCriteria(StGenCountryMaster.class);
			cri.setCacheable(true);
			cri.setCacheRegion("StGenCountryMasterCache");
			cri.setProjection(Projections.property("name"));

			cri.add(Restrictions.eq("countryCode", countryCode));
			List<String> list = cri.list();
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return countryCode;
		}
		return countryCode;

	}

	@SuppressWarnings("unchecked")
	public String fetchStateNameByCode(String stateCode, Session session) {
		try {
			Criteria cri = session.createCriteria(StGenStateMaster.class);
			cri.setCacheable(true);
			cri.setCacheRegion("StGenStateMasterCache");
			cri.setProjection(Projections.property("name"));
			cri.add(Restrictions.eq("stateCode", stateCode));
			List<String> list = cri.list();
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return stateCode;
		}
		return stateCode;
	}

	/*public PlayerInfoBean checkPlrLoginStatus(String sessionId, Session session)
			throws PMSException {
		return checkPlrLoginStatus(sessionId, null, true, session);
	}
	
	@SuppressWarnings("unchecked")
	public PlayerInfoBean checkPlrLoginStatus(String sessionId,
			boolean plrInfoReq, Session session) throws PMSException {
		Criteria criteria = null;
		PlayerInfoBean playerBean = null;
		try {
			criteria = session.createCriteria(StPmPlrLoginStatus.class);
			if (sessionId != null)
				criteria.add(Restrictions.eq("sessionId", sessionId));
			criteria.add(Restrictions.eq("status", "LOGGED_IN"));
			List<StPmPlrLoginStatus> list = criteria.list();
			if (list.size() == 1) {
				if (plrInfoReq) {
					PlayerMgmtDaoImpl obj = new PlayerMgmtDaoImpl();
					playerBean = obj.getPlrInfoBean(list.get(0)
							.getPlayerId(), session);
					playerBean.setRemoteAddress(list.get(0).getIpAddress());
					playerBean.setDeviceType(list.get(0).getAppType());
					playerBean.setDevice(list.get(0).getDevice());
				}
			} else {
				throw new PMSException(PMSErrorCode.TXN_PLR_NOT_LOGIN,
						PMSErrorMessage.TXN_PLR_NOT_LOGIN);
			}
		} catch (PMSException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return playerBean;
	}
	
	@SuppressWarnings("unchecked")
	public PlayerInfoBean checkPlrLoginStatus( Long playerId,
			boolean plrInfoReq, Session session) throws PMSException {
		Criteria criteria = null;
		PlayerInfoBean playerBean = null;
		try {
			criteria = session.createCriteria(StPmPlrLoginStatus.class);
			criteria.add(Restrictions.eq("playerId", playerId));
			criteria.add(Restrictions.eq("status", "LOGGED_IN"));
			criteria.setMaxResults(1);
			List<StPmPlrLoginStatus> list = criteria.list();
			if (list.size()>0) {
				if (plrInfoReq) {
					PlayerMgmtDaoImpl obj = new PlayerMgmtDaoImpl();
					StPmPlrLoginStatus loginStatus = list.get(0);
					playerBean = obj.getPlayerInfoById(loginStatus
							.getPlayerId(), session);
					playerBean.setRemoteAddress(loginStatus.getIpAddress());
					playerBean.setDeviceType(loginStatus.getAppType());
					playerBean.setDevice(loginStatus.getDevice());
					playerBean.setLoginAliasId(loginStatus.getLastAliasId());
					playerBean.setUnreadCount(obj.getUnreadMailCount(playerBean.getPlayerId(), loginStatus.getLastAliasId(), session));
				}
			} else {
				throw new PMSException(PMSErrorCode.TXN_PLR_NOT_LOGIN,
						PMSErrorMessage.TXN_PLR_NOT_LOGIN);
			}
		} catch (PMSException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return playerBean;
	}*/
	
	/*@SuppressWarnings("unchecked")
	public PlayerInfoBean checkPlrLoginStatus(String sessionId, Long playerId,
			boolean plrInfoReq, Session session) throws PMSException {
		Criteria criteria = null;
		PlayerInfoBean playerBean = null;
		try {
			criteria = session.createCriteria(StPmPlrLoginStatus.class);
			if (playerId != null)
				criteria.add(Restrictions.eq("playerId", playerId));
			criteria.add(Restrictions.eq("sessionId", sessionId));
			criteria.add(Restrictions.eq("status", "LOGGED_IN"));
			List<StPmPlrLoginStatus> list = criteria.list();
			if (list.size() == 1) {
				if (plrInfoReq) {
					PlayerMgmtDaoImpl obj = new PlayerMgmtDaoImpl();
					StPmPlrLoginStatus loginStatus = list.get(0);
					playerBean = obj.getPlayerInfoById(loginStatus
							.getPlayerId(), session);
					playerBean.setRemoteAddress(loginStatus.getIpAddress());
					playerBean.setDeviceType(loginStatus.getAppType());
					playerBean.setDevice(loginStatus.getDevice());
					playerBean.setLoginAliasId(loginStatus.getLastAliasId());
					playerBean.setUnreadCount(obj.getUnreadMailCount(playerBean.getPlayerId(), loginStatus.getLastAliasId(), session));
					playerBean.setTotalDepCount(fetchTotalDepositCount(playerBean, session));
				}
			} else {
				throw new PMSException(PMSErrorCode.TXN_PLR_NOT_LOGIN,
						PMSErrorMessage.TXN_PLR_NOT_LOGIN);
			}
		} catch (PMSException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return playerBean;
	}*/

	@SuppressWarnings("unchecked")
	public int fetchOnlinePlayers(short domainId, Session session) {
		List<Object> count  = null;
		Criteria cri = session.createCriteria(StPmPlrLoginStatus.class);
		cri.setProjection(Projections.distinct(Projections.property("playerId")));
		cri.add(Restrictions.eq("status", "LOGGED_IN"));
		if (domainId > 1) {
			cri.add(Restrictions.eq("domainId", domainId));
		}
		try {
			session.connection().setReadOnly(true);
			count = cri.list();
		session.connection().setReadOnly(false);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count.size();
	}

	@SuppressWarnings("unchecked")
	public void updateSystemProperties(String property, String propValue,
			Session session) {
		Criteria cri = session.createCriteria(StGenPropertyMaster.class);
		cri.add(Restrictions.eq("propertyCode", property));
		List<StGenPropertyMaster> list = cri.list();
		for (StGenPropertyMaster bean : list) {
			bean.setValue(propValue);
			session.update(bean);
		}
	}

	@SuppressWarnings("unchecked")
	public UserInfoBean checkBoUserLogin(String sessionId, Session session,boolean infoReq)
			throws PMSException {
		Criteria criteria = null;
		UserInfoBean userInfo = null;
		try {
			criteria = session.createCriteria(StRmBoUserLoginStatus.class);
			criteria.add(Restrictions.eq("sessionId", sessionId));
			criteria.add(Restrictions.eq("status", "LOGGED_IN"));
			List<StRmBoUserLoginStatus> list = criteria.list();
			if (list.size() == 1) {
				if(infoReq){
					StRmBoUserMaster userMaster = (StRmBoUserMaster) session.load(
							StRmBoUserMaster.class, list.get(0).getUserId());
					if (userMaster.getUserName() != null) {
						userInfo = new UserInfoBean();
						userInfo.setUserName(userMaster.getUserName());
						userInfo.setUserId(userMaster.getUserId());
						userInfo.setParentUserId(userMaster.getParentUserId());
						userInfo.setIsRoleHeadUser(userMaster.getIsRoleHead());
						userInfo.setIsMasterRole(userMaster.getIsRoleHead());
						userInfo.setRoleId(userMaster.getStRmBoRoleMaster()
								.getRoleId());
						userInfo.setStatus(userMaster.getStatus());
						userInfo.setRoleName(userMaster.getStRmBoRoleMaster()
								.getRoleName());
						userInfo.setUserType(userMaster.getStRmBoRoleMaster()
								.getTier());
						userInfo.setDomainId(userMaster.getDomainId());
					} else {
						throw new PMSException("Username null");
					}
				}
			} else {
				throw new PMSException("User Not Login");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (PMSException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return userInfo;
	}
	
	@SuppressWarnings("unchecked")
	public int fetchTotalDepositCount(PlayerInfoBean playerInfo, Session session)
			throws PMSException {
		Criteria criteria = null;
		int count = 0;
		try {
			criteria = session.createCriteria(StTxnPlrDepositMaster.class);
			criteria.add(Restrictions.eq("playerId", playerInfo.getPlayerId()));
			criteria.add(Restrictions.eq("domainId", playerInfo.getDomainId()));
			criteria.setProjection(Projections.projectionList()
					.add(Projections.count("transactionId"))
					.add(Projections.groupProperty("playerId"))
					.add(Projections.groupProperty("domainId")));
			List<Object[]> list = criteria.list();
			if (list.size() > 0) {
				count = Integer.parseInt(list.get(0)[0].toString());
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return count;
	}

	public String[] tableSelectionAccordingToVendorCode(String vendorCode, String txnType) throws PMSException{
		String tableNames[]=new String[2];
		if(txnType.equals("WAGER")){
			switch (vendorCode){
				case "SGE" : tableNames[0] = "st_txn_plr_wager_master_casino_4";
					break;
				case "IGE" : tableNames[0] = "st_txn_plr_wager_master_casino_6";
					break;
				case "DGE" : tableNames[0] = "st_txn_plr_wager_master_draw_games_14";
					break;
				case "SLE" : tableNames[0] = "st_txn_plr_wager_master_sports_lottery_17";
					break;
				case "SBS" : tableNames[0] = "st_txn_plr_wager_master_sports_19";
					break;
			}
		}
		else if(txnType.equals("WINNING")){
			switch (vendorCode){
				case "SGE" : tableNames[0] = "st_txn_plr_winning_master_casino_4";
					break;
				case "IGE" : tableNames[0] = "st_txn_plr_winning_master_casino_6";
					break;
				case "DGE" : tableNames[0] = "st_txn_plr_winning_master_draw_games_14";
					break;
				case "SLE" : tableNames[0] = "st_txn_plr_winning_master_sports_lottery_17";
					break;
				case "SBS" : tableNames[0] = "st_txn_plr_winning_master_sports_19";
					break;
			}
		}
		else if(txnType.equals("ALL")){
			switch (vendorCode){
				case "SGE" : tableNames[0] = "st_txn_plr_wager_master_casino_4";
					         tableNames[1] = "st_txn_plr_winning_master_casino_4";
								break;
				case "IGE" : tableNames[0] = "st_txn_plr_wager_master_casino_6";
							 tableNames[1] = "st_txn_plr_winning_master_casino_6";
								break;
				case "DGE" : tableNames[0] = "st_txn_plr_wager_master_draw_games_14";
							 tableNames[1] = "st_txn_plr_winning_master_draw_games_14";
								break;
				case "SLE" : tableNames[0] = "st_txn_plr_wager_master_sports_lottery_17";
							 tableNames[1] = "st_txn_plr_winning_master_sports_lottery_17";
								break;
				case "SBS" : tableNames[0] = "st_txn_plr_wager_master_sports_19";
					   		 tableNames[1] = "st_txn_plr_winning_master_sports_19";
								break;
			}
		} else {
			throw new PMSException(PMSErrorCode.API_INVALID_REQUEST_METHOD,PMSErrorMessage.API_INVALID_REQUEST_METHOD);
		}
		return tableNames;
	}

	/*private List<GameTopPlayerBean> addWagerORWinningList(List<Object[]> list,Integer fromCurrencyId, Integer tocurrencyId,Session session)
			throws PMSException {
		List<GameTopPlayerBean> wagerORWinningList = new ArrayList<>();
		for(Object[] rows : list){
			Double amount = ((BigDecimal)rows[3]).doubleValue();
			amount = amount
					* fetchUpdateCurrencyConversionRate(fromCurrencyId, tocurrencyId, session).getExchangeRate();

			GameTopPlayerBean gameTopPlayerBean=new GameTopPlayerBean((String)rows[0], (String)rows[1], (String)rows[2], amount);
			wagerORWinningList.add(gameTopPlayerBean);
		}
		return wagerORWinningList;
	}

	public GameWiseTopPlayerBean fetchGameTopPlayerList(short domainId, Integer toCurrencyId, String vendorCode, String gameName,
																			Integer fetchLimit, String txnType, Session session) throws PMSException {
		String tableNames[];
		GameWiseTopPlayerBean gameWiseTopPlayerBean;
		List<GameTopPlayerBean> wagerList;
		List<GameTopPlayerBean> winningList = null;
		Integer nativeCurrencyId;
		Query qry;
		try {
			gameWiseTopPlayerBean=new GameWiseTopPlayerBean();
			tableNames = tableSelectionAccordingToVendorCode(vendorCode,txnType);
			nativeCurrencyId = Integer.parseInt(fetchSystemProperties(
					"NATIVE_CURRENCY", session));

			if(tableNames[1]==null) {

				qry = session.
						createSQLQuery("SELECT i.user_name, i.first_name, i.last_name, a.amount_native FROM (SELECT  player_id, amount_native FROM " + tableNames[0] + " WHERE domain_id = " + domainId + " and game_name = '" + gameName + "' ORDER BY transaction_date DESC )  AS a JOIN st_pm_player_master AS i ON a.player_id=i.player_id ");

				qry.setMaxResults(fetchLimit);

				List<Object[]> 	list = qry.list();
				wagerList = addWagerORWinningList(list, nativeCurrencyId, toCurrencyId, session);

			} else {
				qry = session.
						createSQLQuery("SELECT i.user_name, i.first_name, i.last_name, a.amount_native FROM (SELECT  player_id, amount_native FROM " + tableNames[0] + " WHERE domain_id = " + domainId + " and game_name = '" + gameName + "' ORDER BY transaction_date DESC )  AS a JOIN st_pm_player_master AS i ON a.player_id=i.player_id ");
				Query qry2 = session.
						createSQLQuery("SELECT i.user_name, i.first_name, i.last_name, a.amount_native FROM (SELECT  player_id, amount_native FROM " + tableNames[1] + " WHERE domain_id = " + domainId + " and game_name = '" + gameName + "' ORDER BY transaction_date DESC )  AS a JOIN st_pm_player_master AS i ON a.player_id=i.player_id ");

				qry.setMaxResults(fetchLimit);
				qry2.setMaxResults(fetchLimit);

				List<Object[]> 	list1 = qry.list();
				List<Object[]> 	list2 = qry2.list();

				wagerList = addWagerORWinningList(list1, nativeCurrencyId, toCurrencyId, session);
				winningList = addWagerORWinningList(list2, nativeCurrencyId, toCurrencyId, session);
			}

			if(txnType.equals("WAGER")){
				gameWiseTopPlayerBean.setGameName(gameName);
				gameWiseTopPlayerBean.setWager(wagerList);
			} else if(txnType.equals("WINNING")) {
				gameWiseTopPlayerBean.setGameName(gameName);
				gameWiseTopPlayerBean.setWinning(wagerList);
			} else if(txnType.equals("ALL")) {
				gameWiseTopPlayerBean.setGameName(gameName);
				gameWiseTopPlayerBean.setWager(wagerList);
				gameWiseTopPlayerBean.setWinning(winningList);
			} else {
				throw new PMSException(PMSErrorCode.API_INVALID_REQUEST_METHOD,PMSErrorMessage.API_INVALID_REQUEST_METHOD);
			}


		} catch (HibernateException e) {
				e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}

		return gameWiseTopPlayerBean;
	}*/

	@SuppressWarnings("unchecked")
	public List<CityBean> fetchActiveCityList(int stateId, int countryId,
			Session session) throws PMSException {
		CityBean cityBean = null;
		List<CityBean> cityList = null;
		try {
			Criteria cri = session.createCriteria(StGenCityMaster.class);
			cri.add(Restrictions.eq("stateId", stateId));
			cri.add(Restrictions.eq("countryId", countryId));
			cri.add(Restrictions.eq("status", "ACTIVE"));
			List<StGenCityMaster> list = cri.list();
			cityList = new ArrayList<CityBean>();
			for (StGenCityMaster cityMaster : list) {
				cityBean = new CityBean();
				cityBean.setStateCode(cityMaster.getStateCode());
				cityBean.setValue(cityMaster.getCityName());
				cityList.add(cityBean);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return cityList;
	}

	@SuppressWarnings("unchecked")
	public List<StGenCityMaster> fetchActiveCityList(String stateCode,String countryCode,
			Session session) throws PMSException {
		try {
			Criteria cri = session.createCriteria(StGenCityMaster.class);
			cri.add(Restrictions.eq("stateCode", stateCode));
			cri.add(Restrictions.eq("countryCode", countryCode));
			cri.add(Restrictions.eq("status", "ACTIVE"));
			return cri.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}	
	}
	
	@SuppressWarnings("unchecked")
	public List<WordSentenceBean> fetchWordSentence(short domainId,
			String language, Session session) throws PMSException {
		WordSentenceBean wordBean = null;
		List<WordSentenceBean> wordList = null;
		try {
			DetachedCriteria dc = DetachedCriteria
					.forClass(StGenLanguageMaster.class);
			dc.setProjection(Projections.property("languageId"));
			dc.add(Restrictions.eq("languageBaseCode", language));
			Criteria cri = session
					.createCriteria(StGenWordSentenceMaster.class);
			cri.setCacheRegion("StGenWordSentenceMasterCache");
			cri.setCacheable(true);
			ProjectionList pro = Projections.projectionList();
			pro.add(Projections.property("wordSentence"), "wordSentence");
			pro.add(Projections.property("wordSentenceCode"),
					"wordSentenceCode");
			cri.setProjection(pro);
			cri.add(Subqueries.propertyIn("wordSentenceLanguageId", dc));
			List<Object[]> list = cri.list();
			wordList = new ArrayList<WordSentenceBean>();
			if (list.size() == 0) {
				throw new PMSException("No Sentence Available");
			} else {
				for (Object[] wsm : list) {
					wordBean = new WordSentenceBean();
					wordBean.setWordSentence(wsm[0].toString());
					wordBean.setWordSentenceCode(Integer.parseInt(wsm[1]
							.toString()));
					wordList.add(wordBean);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return wordList;
	}

	@SuppressWarnings("unchecked")
	public List<StRmVendorMaster> fetchServerDetail(String vendorCode,
			Session session) throws PMSException {
		try {
			Criteria cri = session.createCriteria(StRmVendorMaster.class);
			cri.add(Restrictions.eq("vendorCode", vendorCode));
			return cri.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
	}

	@SuppressWarnings("unchecked")
	public Integer fetchCountryId(short domainId, String countryCode,
			Session session) throws PMSException {
		Integer countryId = 0;
		try {
			String domainProp = getDmProperty(session, domainId,
					"allowedStates");
			Criteria cri = session
					.createCriteria(StDmDomainCountryMapping.class);
			cri.createAlias("countryMaster", "cm");
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.add(Restrictions.eq("cm.countryCode", countryCode));
			cri.add(Restrictions.eq("cm.status", "ACTIVE"));
			cri.add(Restrictions.eq("domainId",
					domainProp.equals("BYDEFAULT") ? (short) 1 : domainId));
			cri.addOrder(Order.asc("cm.name"));
			List<StDmDomainCountryMapping> list = cri.list();
			if (list.size() > 0) {
				countryId = list.get(0).getCountryMaster().getId();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return countryId;

	}

	@SuppressWarnings("unchecked")
	public Integer fetchStateId(short domainId, String stateCode,
			Session session) throws PMSException {
		Integer stateId = 0;
		try {
			String domainProp = getDmProperty(session, domainId,
					"allowedStates");
			Criteria cri = session.createCriteria(StDmDomainStateMapping.class);
			cri.createAlias("stateMaster", "sm");
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.add(Restrictions.eq("sm.stateCode", stateCode));
			cri.add(Restrictions.eq("sm.status", "ACTIVE"));
			cri.add(Restrictions.eq("domainId",
					domainProp.equals("BYDEFAULT") ? (short) 1 : domainId));
			cri.addOrder(Order.asc("sm.name"));
			List<StDmDomainStateMapping> list = cri.list();
			if (list.size() > 0) {
				stateId = list.get(0).getStateMaster().getId();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return stateId;

	}

	public void invalidateCache(String cacheReginName,
			SessionFactory sessFectory) {
		//check if cache is attached to hibernate
		if(Arrays.asList(sessFectory.getStatistics().getSecondLevelCacheRegionNames()).contains(cacheReginName) ){
			sessFectory.evictQueries(cacheReginName);
		}else{
			CacheManager manager = CacheManager.getInstance();
			Cache cache = manager.getCache(cacheReginName);
			
			if (cache!=null) {
				cache.removeAll();
				cache.getKeys();
			}
		}
		
	}

	@SuppressWarnings("unchecked")
	public Map<Short, String> fetchAliasMap(short domainId, Session session) {
		Map<Short, String> aliasMap = new HashMap<Short, String>();
		Criteria cri = session.createCriteria(StDmDomainAliasNameMaster.class).setCacheable(true);
		cri.createAlias("domainMaster", "dm");
		cri.add(Restrictions.eq("dm.domainId", domainId));
		List<StDmDomainAliasNameMaster> list = cri.list();
		for (StDmDomainAliasNameMaster aliasMas : list) {
			aliasMap.put(aliasMas.getAliasId(), aliasMas.getAliasName());
		}
		return aliasMap;

	}
	@SuppressWarnings("unchecked")
	public Map<Short, String> fetchGameMap(short domainId,short aliasId, Session session) {
		Map<Short, String> GameMap = new HashMap<Short, String>();
		DetachedCriteria dc = DetachedCriteria.forClass(StRmDomainAliasVendorMapping.class,"vmp");
		if(aliasId!=-1){
		
		dc.add(Restrictions.eq("vmp.domainId", domainId));
		dc.add(Restrictions.eq("vmp.aliasId", aliasId));
		dc.add(Restrictions.eq("vmp.status", "ACTIVE"));
		dc.setProjection(Projections.property("vmp.vendorId"));
		}else{
					dc.add(Restrictions.eq("vmp.domainId", domainId))
					.add(Restrictions.eq("status", "ACTIVE"))
					.setProjection(Projections.property("vmp.vendorId"));
		}
			
		Criteria criteria = session
				.createCriteria(StRmVendorMaster.class);
		
		criteria.add(Subqueries.propertyIn("vendorId", dc));
		
		
		List<StRmVendorMaster> list =criteria.list();
		for (StRmVendorMaster game : list) {
			GameMap.put(game.getVendorId() ,game.getVendorCode() );
		}
		return GameMap;

	}
	@SuppressWarnings("unchecked")
	public Map<Long, String> checkPlrPokerLoginStatus(Short aliasId,String token,String playType, Session session) throws PMSException {
		Criteria criteria = null;
		Map<Long, String> retMap=new HashMap<Long, String>();
		try {
			if("true".equalsIgnoreCase(playType)){
				criteria = session.createCriteria(StPmPlayerMaster.class);
			//	criteria.add(Restrictions.eq("aliasId", aliasId));    It will not work if player register with Khelplayrummy 
				int lastIndexOfDelimiter = token.lastIndexOf("_");
				String userName = token.substring(0,lastIndexOfDelimiter);
				criteria.add(Restrictions.eq("userName", userName));
				criteria.setProjection(Projections.property("playerId"));
				List<Long> list = criteria.list();
				if(list != null && list.size() ==1){
					retMap.put(list.get(0), "PC");
				}
				else
					throw new PMSException(PMSErrorCode.POKER_PLR_LOGIN_ERROR,PMSErrorMessage.POKER_PLR_LOGIN_ERROR);
			}else{
				criteria = session.createCriteria(StPmPlrLoginStatus.class);
				if(token!=null)
					criteria.add(Restrictions.eq("sessionId", token.substring(0,token.lastIndexOf("-"))));
				criteria.add(Restrictions.eq("status", "LOGGED_IN"));
				criteria.setProjection(Projections.projectionList().add(Projections.property("playerId")).add(Projections.property("device")));
				List<Object[]> list = criteria.list(); 
				if(list.size() == 1 && list != null){
					retMap.put((Long)list.get(0)[0], (String)list.get(0)[1]);
				}else{
//					throw new PMSException(PMSErrorCode.POKER_TOKEN_IS_INVALID, PMSErrorMessage.POKER_TOKEN_IS_INVALID);
					
				}
			}
		} catch (PMSException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.POKER_TXN_ERROR, PMSErrorMessage.POKER_TXN_ERROR);
		}
		return retMap;
	}

	public void updateVendorProperties(String handNextSeed,
			String propKey, Session session, Transaction tx) throws PMSException {
		Query query = null;
		try{
			query = session.createQuery("update StRmServiceVendorProperties set propertyValue="+handNextSeed+" where propertyKey='"+propKey+"'");
			query.executeUpdate();
			session.flush();
			tx.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
	}
	
	@SuppressWarnings("unchecked")
	public AnalyticalToolMappingBean fetchAnalyticalToolProperty(Short domainId , Short aliasId , String toolName, Session session) throws PMSException {
			
		StDmAliasAnalyticalToolMapping obj=null;
		AnalyticalToolMappingBean  beanObj=null;
		try {
			//log.info("--------Fetch AnalyticalTool -"+ toolName+ "----------- property");
				Criteria cri = session.createCriteria(StDmAliasAnalyticalToolMapping.class);
				cri.add(Restrictions.eq("domainId", domainId));
				cri.add(Restrictions.eq("aliasId", aliasId));
				cri.add(Restrictions.eq("analyticalTool", toolName));
				cri.add(Restrictions.eq("status", "ACTIVE"));
				List<StDmAliasAnalyticalToolMapping> list = cri.list();
				
				if (list.size() > 0) {
					obj = list.get(0);
					beanObj=new AnalyticalToolMappingBean(obj.getDomainId(),obj.getAliasId(),obj.getAnalyticalTool(),
							obj.getProperty1(),obj.getProperty2(),obj.getProperty3(),obj.getProperty4());				
				}
			
		}catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}  
		catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return beanObj;
	}
	/*
	public CommonInfoBean fetchBasicInfo(String serverName, String sessionId,
			String[] pathArry, String actionUrl, Session session)
			throws PMSException {
		CommonInfoBean infoBean = new CommonInfoBean();
		StDmDomainAliasNameMaster aliasMaster = CommonMethodController.getInstance()
				.fetchAliasMasFromAliasName(serverName);
		StDmDomainMaster domainMaster = aliasMaster.getDomainMaster();
		infoBean.setAliasId(aliasMaster.getAliasId());
		infoBean.setAliasName(aliasMaster.getAliasName());
		infoBean.setDomainId(domainMaster.getDomainId());
		infoBean.setDomainName(domainMaster.getDomainName());
		return fetchInfoBean(infoBean, sessionId, pathArry, actionUrl, session);
	}*/
		
	/*public CommonInfoBean fetchInfoBean(CommonInfoBean infoBean, String sessionId,
			String[] pathArry, String actionUrl, Session session) throws PMSException{
		CommonMethodDaoImpl daoImpl = new CommonMethodDaoImpl();
		Short aliasId = infoBean.getAliasId();
		short domainId = infoBean.getDomainId();
		String device = infoBean.getDevice();
		if (pathArry.length > 0) {
			List<Object[]> props = daoImpl
					.fetchGenProperties(session, pathArry);
			for (Object[] str : props) {
				if ("DEFAULT_CONTENT_PATH".equals(str[0])) {
					infoBean.setDefaultContentPath(str[1].toString());
				} else if ("DEFAULT_CSS_PATH".equals(str[0])) {
					infoBean.setDefaultCssPath(str[1].toString());
				} else if ("DEFAULT_JS_PATH".equals(str[0])) {
					infoBean.setDefaultJsPath(str[1].toString());
				}else if ("JS_CSS_VERSION".equals(str[0])) {
					infoBean.setJsCssVersion(str[1].toString());
				}else if("COMMON_CONTENT_PATH".equals(str[0])){
					infoBean.setCommonContentPath(str[1].toString());
				}
			}
		}
		PlayerInfoBean plrInfo = null;
		AnalyticalToolMappingBean analyticalBean =null;
		try {
			plrInfo = checkPlrLoginStatus(sessionId, true, session);
			plrInfo.setUnreadCount(new PlayerMgmtDaoImpl().getUnreadMailCount(plrInfo.getPlayerId(), aliasId, session));
			
			plrInfo.setTotalDepCount(fetchTotalDepositCount(plrInfo, session));
		} catch (PMSException e) { }
			analyticalBean = fetchAnalyticalToolProperty(domainId , aliasId , "Mixpanel", session);
			if(analyticalBean!=null)
				infoBean.setMixpanelToken(analyticalBean.getProperty1());	
		analyticalBean = fetchAnalyticalToolProperty(domainId , aliasId , "Inspectlet", session);
		if(analyticalBean!=null)
			infoBean.setInspectletToken(analyticalBean.getProperty1());
		infoBean.setPlayerInfoBean(plrInfo);
		infoBean.setTagBean(daoImpl.fetchUrlTags(session, aliasId, actionUrl,
				device));
		short defAliasId = "BYDEFAULT".equals(daoImpl.getDmAliasProperty(
				session, aliasId, "menuList")) ? (short) 1 : aliasId;
		List<PortalMenuBean> menuList = null;
		if (plrInfo != null && !"".equals(actionUrl)) {
			menuList = daoImpl.fetchMenuBean(defAliasId, device, "post_login",
					actionUrl, session).getMenuList();
		} else {
			menuList = daoImpl.fetchMenuBean(defAliasId, device, "pre_login",
					actionUrl, session).getMenuList();
		}
		infoBean.setMenuList(menuList);
		return infoBean;
	}
	*/
	@SuppressWarnings("unchecked")
	public StGenSmsEmailProviderMaster fetchSmsEmailProvider(Short aliasId,String providerType, Session session) {
		StGenSmsEmailProviderMaster providerInfo = null;
		try {
			Criteria cri = session.createCriteria(StGenSmsEmailProviderMaster.class);
			//cri.setProjection(Projections.property("providerName"));
			cri.add(Restrictions.eq("providerType", providerType));
			cri.add(Restrictions.eq("aliasId", (int)aliasId));
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.addOrder(Order.asc("priorityOrder"));
			List<StGenSmsEmailProviderMaster> list = cri.list();
			if (list != null && list.size() > 0) {
				providerInfo = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return providerInfo;
		}
		return providerInfo;

	}
	
	
	@SuppressWarnings("unchecked")
	public boolean checkDomainVendorAvailable(Session session,Short domainId,String vendorCode){
		
		boolean availableFlag=false;		
		Query qry = session.createQuery("from StRmDomainAliasVendorMapping as davm,StRmVendorMaster as vm where davm.vendorId=vm.vendorId and davm.domainId =:domainId and davm.status=:status and vm.vendorCode=:vendorCode");
		qry.setParameter("domainId", domainId);
		qry.setParameter("status", "ACTIVE");
		qry.setParameter("vendorCode", vendorCode);
		List<Object[]> prop = qry.list();
		if(prop.size()>0)
			availableFlag=true;
		return availableFlag;
	}

	public String fetchProgressWidth(Long playerId,Short domainId, Session session) {
		try{
			Criteria cri = session.createCriteria(StTxnPlrBonusDetails.class);
			cri.setProjection(Projections.projectionList().add(Projections.sum("bonusAmt")).add(Projections.sum("redeemedBonusAmt")));
			cri.add(Restrictions.eq("domainId", domainId));
			cri.add(Restrictions.eq("playerId", playerId));
			cri.add(Restrictions.eq("wrStatus","PENDING"));
			@SuppressWarnings("unchecked")
			List<Object[]> res = cri.list();
			if(res.get(0)[0]!=null && res.get(0)[1]!= null){
				Double totalBonus = (Double) res.get(0)[0];
				Double bonusRedeemed = (Double) res.get(0)[1];
				if(totalBonus == 0.0)
					return "0";
				else if(totalBonus.toString().equals(bonusRedeemed.toString()))
					return "0";
				else if(bonusRedeemed == 0.0 && totalBonus != 0.0)
					return "100|"+res.get(0)[0]+"|0";
				else{
					  Double percent = ((totalBonus-bonusRedeemed)/totalBonus)*100;
					  return percent.toString()+"|"+res.get(0)[0]+"|"+res.get(0)[1];
				}
			}else
				return "0";
		}catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<StRmVendorMaster> getActiveGameMap(short aliasId, Session session){
		DetachedCriteria aliasVendormapping = DetachedCriteria.forClass(
				StRmDomainAliasVendorMapping.class).setProjection(
				Property.forName("vendorId"));
		aliasVendormapping.add(Restrictions.eq("aliasId", aliasId));
		aliasVendormapping.add(Restrictions.eq("status","ACTIVE"));
		Criteria cri = session.createCriteria(StRmVendorMaster.class);
		cri.add(Subqueries.propertyIn("vendorId", aliasVendormapping));
		return cri.list(); 
	}
	
	@SuppressWarnings("unchecked")
	public StDmDomainWalletMapping fetchWalletMapping(short domainId, String status, Session sess) throws PMSException{
		Criteria cri = sess.createCriteria(StDmDomainWalletMapping.class);
		cri.add(Restrictions.eq("domainId", domainId));
		cri.add(Restrictions.eq("status", status));
		List<StDmDomainWalletMapping> list = cri.list();
		if(list.size()==1){	
			return list.get(0);
		} else {
			throw new PMSException("No or Multiple Wallet mapping found for this domain, DomainID = "+domainId);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Integer fetchLocationDeviceMapping(Session session, String macAdd, Short aliasId) throws PMSException{
		Criteria cri = session.createCriteria(StDmDomainLocationDeviceMapping.class);
		cri.createAlias("locDevices", "locDevices");
		cri.add(Restrictions.eq("locDevices.deviceMacAddress", macAdd));
		cri.add(Restrictions.eq("aliasId", aliasId));
		cri.add(Restrictions.eq("status", "ACTIVE"));
		cri.setProjection(Projections.property("id"));
		List<Integer> list = cri.list();
		if(list.size()==1){
			return list.get(0);
		} else {
			throw new PMSException(PMSErrorCode.TXN_INVALID_MAC_ADDRESS, PMSErrorMessage.TXN_INVALID_MAC_ADDRESS);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Long getPlayerIdFromMobOrEmailId(Session session,String emailId, Long mobileNo) throws PMSException{
		Criteria cri = session.createCriteria(StPmPlayerMaster.class);
		if(emailId!=null)
			cri.add(Restrictions.eq("emailId", emailId));
		else if(mobileNo!=null)	
			cri.add(Restrictions.eq("mobileNo", mobileNo));
		cri.setProjection(Projections.property("playerId"));
		List<Long> list = cri.list();
		if(list.size()>0){
			return list.get(0);
		} else {
			throw new PMSException(PMSErrorCode.API_NO_PLAYER_FOUND,
					PMSErrorMessage.API_NO_PLAYER_FOUND);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public StPmPlrLoginStatus fetchPlrAppDetail (Session session, Short domainId,
			Short aliasId, String playerToken, String deviceId, String os,
			String appType){
		Criteria cri=session.createCriteria(StPmPlrLoginStatus.class);
		cri.add(Restrictions.eq("domainId", domainId));
		cri.add(Restrictions.eq("appType", (os+"_APP_"+appType).toUpperCase()));
		cri.add(Restrictions.eq("lastAliasId", aliasId));
		cri.add(Restrictions.eq("sessionId",playerToken));
		List<StPmPlrLoginStatus> list = cri.list();
		if(list.size()>0) {
			return list.get(0);
		}
		return null; 
	}
	
	@SuppressWarnings("unchecked")
	public StGenAppVersionDetails fetchAppDetailFromVersion(Session session, Short domainId,
			Short aliasId, String os, String appType, String appVersion){
		Criteria cri = session.createCriteria(StGenAppVersionDetails.class);
		cri.add(Restrictions.eq("domainId", domainId));
		cri.add(Restrictions.eq("aliasId", aliasId));
		cri.add(Restrictions.eq("version", appVersion));
		cri.add(Restrictions.eq("appType", appType));
		cri.add(Restrictions.eq("os", os.toUpperCase()));
		cri.add(Restrictions.eq("status", "ACTIVE"));
		List<StGenAppVersionDetails> list = cri.list();
		if(list.size()>0){
			return list.get(0);
		} 
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<StGenAppVersionDetails> fetchLatestsAppVer(Session session, Short domainId,
			Short aliasId, String os, String appType){
		Query qry =session.createQuery("from  StGenAppVersionDetails where domainId=:domainId and aliasId=:aliasId and appType=:appType and "+
			"os=:os and status=:status and versionDate>=(select max(versionDate) from StGenAppVersionDetails where aliasId=:aliasId " +
			"and appType=:appType and os=:os and status=:status and version_type=:version_type) order by versionDate asc ");
		qry.setParameter("domainId", domainId);
		qry.setParameter("aliasId", aliasId);
		qry.setParameter("appType", appType);
		qry.setParameter("os", os.toUpperCase());
		qry.setParameter("status", "ACTIVE");
//		qry.setParameter("mandatory", "YES");
//		qry.setParameter("pushToAll", "YES");
		qry.setParameter("version_type", "PRODUCTION");
		return qry.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> fetchLastMandatoryVersion(Session session,
			Short aliasId, String os, String appType){
		Query qry =session.createQuery("select max(version) from StGenAppVersionDetails where aliasId=:aliasId " +
			"and appType=:appType and os=:os and status=:status and version_type=:version_type and mandatory=:mandatory");
		qry.setParameter("aliasId", aliasId);
		qry.setParameter("appType", appType);
		qry.setParameter("os", os.toUpperCase());
		qry.setParameter("status", "ACTIVE");
		qry.setParameter("mandatory", "YES");
		qry.setParameter("version_type", "PRODUCTION");
		return qry.list();
	}

	@SuppressWarnings("unchecked")
	public List<StDmAliasDeeplinkRep> getDeepLinkList(Short aliasId,
			String appType, Session session) {
		Criteria cri=session.createCriteria(StDmAliasDeeplinkRep.class);
		if(aliasId!=null)
			cri.add(Restrictions.eq("aliasId",aliasId));
		if (appType!=null) 
			cri.add(Restrictions.eq("appType",appType));
		cri.add(Restrictions.eq("status","ACTIVE"));
		List<StDmAliasDeeplinkRep> list =  cri.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<StRmVendorMaster> fetchvendorInfoByAliasId(Short aliasId,
			Session session) throws PMSException {
		List<StRmVendorMaster> vendorList = null;
		Criteria cri = null;
		try {
			cri = session.createCriteria(StRmDomainAliasVendorMapping.class);
			cri.add(Restrictions.eq("aliasId", aliasId));
			cri.add(Restrictions.eq("status", "ACTIVE"));
			cri.setProjection(Projections.property("vendorId"));
			List<Short> vendorIds =  cri.list();
			if (vendorIds.size() != 0) {
				cri = session.createCriteria(StRmVendorMaster.class);
				cri.add(Restrictions.in("vendorId", vendorIds));
				vendorList = cri.list();
			} else {
				throw new PMSException("No Vendor is available for aliasId"
						+ aliasId);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
					PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return vendorList;
	}
	
	/*public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		CommonMethodDaoImpl.getInstance().getDeepLinkList((short)2, null, session);
	}
	*/
	@SuppressWarnings("unchecked")
	public List<StDmAliasDeeplinkRep> getDeepLink(Short aliasId,
			String appType,String  dispCode ,Session session) {
		Criteria criteria=session.createCriteria(StDmAliasDeeplinkRep.class);
		if(aliasId!=null)
			criteria.add(Restrictions.eq("aliasId",aliasId));
		if (appType!=null) 
			criteria.add(Restrictions.eq("appType",appType));
		return criteria.add(Restrictions.eq("status","ACTIVE")).list();
	}


	public void callVCommission(Short aliasId,
			long playerId ,String urlType,Session session) {
		try{
			
					String emailVerifyURLVCommision=fetchAliasProperty(urlType, aliasId, session);	
					if(emailVerifyURLVCommision!=null){
						Criteria criteria = session.createCriteria(StPmPlayerGetSetOfferDetail.class);
						criteria.add(Restrictions.eq("playerId", playerId));
						criteria.add(Restrictions.isNotNull("idVCommission"));
						List <StPmPlayerGetSetOfferDetail> data=criteria.list();						
												
						if(data.size()==1){	
							StPmPlayerGetSetOfferDetail obj =data.get(0);
							if(!"".equals(obj.getIdVCommission())){
								VCommissionThread.submitVCommissionRequest(emailVerifyURLVCommision, playerId, obj.getIdVCommission());						
							}
					}
			}
		}catch (Exception e) {
			log.info(e.getMessage(),e);
		}
		
	}
	
	public String getReferFriendCode(Long playerId ,Session session) {
		
		String query="select referFriendCode from st_pm_player_master where player_id="+playerId;
		
		return (String)session.createSQLQuery(query).list().get(0);		
		
	}
	
	
	public Long getPlayerIdByReferalCode(String referalCode ,Session session) throws PMSException{
			
			Long playerId=0l;
			String query="select player_id from st_pm_player_master where referFriendCode = '"+referalCode+"'";
			@SuppressWarnings("unchecked")
			List <Object> list=session.createSQLQuery(query).list();
			
			if(list.size()==1)
				playerId=Long.parseLong(list.get(0).toString());
			else{
				log.error("Invalid referFriendCode in refer Friend Url");
			}
				
			return playerId;		
			
	}
	
	public static void genarateRandomNo(StPmPlayerMaster playerMstr ,Session session){
		String randomValue="";
		try{	
			randomValue = random.nextString();
			playerMstr.setReferFriendCode(randomValue); 
			session.flush();
		}catch (ConstraintViolationException e) {
			log.error("---------------duplicate random value generate  -------------------"+randomValue);
			genarateRandomNo(playerMstr,session);
		}
		
	}


	@SuppressWarnings("unchecked")
	public List<StRmServiceMaster> fetchActiveServices(Session session) {
		return session.createCriteria(StRmServiceMaster.class).add(Restrictions.eq("serviceCode", "RUMMY"))
				.add(Restrictions.eq("status", "ACTIVE")).list();
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> fetchServiceVendorProperties(Session session, Short vendorId) {
		Map<String, String> retmap=new HashMap<String, String>();
		List<StRmServiceVendorProperties> propList= session.createCriteria(StRmServiceVendorProperties.class)
				.createAlias("stRmVendorMaster", "vm")
				.add(Restrictions.eq("vm.vendorId", vendorId)).list();
		for (StRmServiceVendorProperties prop:propList) 
			retmap.put(prop.getPropertyKey(), prop.getPropertyValue());
		return retmap;
	}

	
	public void callClickOnik(PlayerInfoBean playerInfoBean, Double amount, Session session) throws PMSException {
		ClickOnikInformer informer = new ClickOnikInformer(186l, playerInfoBean.getPlayerId(), amount, playerInfoBean.getCampTrckId());
		informer.checkAndinform(session);
	}
	
	@SuppressWarnings("unchecked")
	public List< String> fetchCampaignMap(Short domainId, Short aliasId,
			Session session) throws PMSException {
		
		String aliasCond="";
		List< String> dataList=new ArrayList<>();
		try {
			Timestamp curDate=new Timestamp(Calendar.getInstance()
					.getTimeInMillis());
			
			if(aliasId != 0)
				aliasCond=" and alias_id = "+aliasId;
			
			Query query=session.createSQLQuery("select sub_campaign_id,sub_campaign_name from st_cms_campaign_master camp join st_cms_campaign_sub_master sub_camp on camp.campaign_id=sub_camp.campaign_id where "
												+ " domain_id = "+ domainId + aliasCond +" and  campaign_type = 'PPC' and  camp.status='ACTIVE' and to_date >'"+ curDate+"'");
			
			
			List<Object[][]> data =	query.list();
			
			for (Object objects : data) {
				Object object[]=(Object[]) objects;
				dataList.add(new Integer(object[0].toString())+"~"+object[1].toString());
			}
		
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return dataList;

	}

    public Map<String,String> fetchSystemPropMap(Session session,String... props) throws PMSException {
        Map<String,String> retMap=new HashMap<>();
        List<Object[]> list = fetchGenProperties(session, props);
        for (Object[] entry: list)
            retMap.put((String) entry[0],(String) entry[1]);
        return retMap;
    }
/*    public PlayerInfoBean checkUserNameInDomain(Session session,short domainId,String userName) throws PMSException{
    	Criteria cri = null;
		try {
			cri = session.createCriteria(StPmPlayerMaster.class);
			Object userId = userName.trim();
			String usernameType = "";
				if (userName.contains("@")) {
					usernameType = "emailId";
				} else if (Pattern.matches("[\\d]{8,13}", userName)
						) {
					usernameType = "mobileNo";

					userId=Long.parseLong(userName.trim());

				} else {
					usernameType = "userName";
				}

			cri.add(Restrictions.eq(usernameType, userId));
			cri.add(Restrictions.eq("domainId", domainId));
			List<StPmPlayerMaster> dataList= cri.list();
			if(dataList.size()==0)
				throw new PMSException(PMSErrorCode.INVALID_USER, PMSErrorMessage.INVALID_USER);
			else 
				return new PlayerMgmtDaoImpl().getPlayerInfo(dataList.get(0), session);
		} catch (PMSException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
    }
*/
@SuppressWarnings("unchecked")
	public StGenStateMaster fetchStateMasterByName(String stateName, Session session) {
    	
		try{	
    		Criteria cri = session.createCriteria(StGenStateMaster.class);
			cri.setCacheable(true);
			cri.setCacheRegion("StGenStateMasterCache");
			cri.add(Restrictions.eq("name", stateName));
			cri.add(Restrictions.eq("countryCode", "IN"));
			List<StGenStateMaster> list = cri.list();
			if (list.size()==1) {
				return list.get(0);
			}
		}catch(Exception e){
			log.error(e);
		}
			return null;
		
	}
    
    public List<String> fetchAnalyticalTool(Short domainId , Short aliasId , String[] toolNames, Session session) throws PMSException {
		
    	List<String> list=null;
		
		try {
			//log.info("--------Fetch AnalyticalTool -"+ toolName+ "----------- property");
				Criteria cri = session.createCriteria(StDmAliasAnalyticalToolMapping.class);
				cri.add(Restrictions.eq("domainId", domainId));
				cri.add(Restrictions.eq("aliasId", aliasId));
				cri.add(Restrictions.in("analyticalTool", toolNames));
				cri.add(Restrictions.eq("status", "ACTIVE"));
				cri.setProjection(Projections.property("analyticalTool"));
				list = cri.list();
				
				
			
		}catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}  
		catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return list;
	}
 
    /**
     * Fetch Events List for "Map New Event" module in back office.
     * @param domainId
     * @param aliasId
     * @param channelType
     * @param session	
     * @return eventList
     */
	/*@SuppressWarnings("unchecked")
	public List<String> fetchEventList(short domainId, short aliasId, String channelType, Session session)
			throws PMSException {
		List<String> eventList = new ArrayList<String>();
		try {
			log.info("<<<<<<------:: COMMON METHOD DAO IMPL CLASS  ::------>>>>>>");
			Criteria cri = session.createCriteria(StCommDetailMaster.class).setCacheable(true);
			cri.add(Restrictions.eq("domainId", domainId));
			cri.add(Restrictions.eq("aliasId", aliasId));
			cri.add(Restrictions.eq("channelType", channelType));
			cri.add(Restrictions.eq("playerOption", "Y"));
			cri.setProjection(Projections.property("eventType"));
			eventList = cri.list();
			eventList.add("ALL");
		} catch (Exception e) {
			log.error("<<<<<<------:: COMMON METHOD DAO IMPL CLASS EXCEPTION OCCURED  ::------>>>>>>");
			throw e;
		}
		return eventList;
	}*/
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> fetchPlrDetails(Long playerId, Session session) throws PMSException {
		Map<String, Object> plrData = new HashMap<String, Object>();
		try {
			log.info("\n----------:::: fetchPlrDetails ::::----------\n");
			Criteria cri = session.createCriteria(StPmPlayerMaster.class);
			cri.add(Restrictions.eq("playerId", playerId));
			cri.setProjection(Projections.projectionList().add(Projections.property("domainId"))
					.add(Projections.property("aliasId")).add(Projections.property("mobileNo"))
					.add(Projections.property("userName")));
			List<Object[]> plrMasData = cri.list();
			if (!plrMasData.isEmpty()) {
				plrData.put("domainId", plrMasData.get(0)[0]);
				plrData.put("aliasId", plrMasData.get(0)[1]);
				plrData.put("mobileNo", plrMasData.get(0)[2]);
				plrData.put("userName", plrMasData.get(0)[3]);
				return plrData;
			}
		} catch (HibernateException e) {
			log.error(e);
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION, PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception e) {
			log.error(e);
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR, PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return null;
	}
    
}	