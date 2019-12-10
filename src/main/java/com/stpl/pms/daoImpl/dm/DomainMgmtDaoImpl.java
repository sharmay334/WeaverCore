package com.stpl.pms.daoImpl.dm;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.StCmsTemplateMaster;
import com.stpl.pms.hibernate.mapping.StCshPaymentOptionsDomainMapping;
import com.stpl.pms.hibernate.mapping.StDmDomainAliasNameMaster;
import com.stpl.pms.hibernate.mapping.StDmDomainCountryMapping;
import com.stpl.pms.hibernate.mapping.StDmDomainCurrencyMapping;
import com.stpl.pms.hibernate.mapping.StDmDomainDeviceMaster;
import com.stpl.pms.hibernate.mapping.StDmDomainInfo;
import com.stpl.pms.hibernate.mapping.StDmDomainLanguageMapping;
import com.stpl.pms.hibernate.mapping.StDmDomainLocationDeviceMapping;
import com.stpl.pms.hibernate.mapping.StDmDomainLocationMaster;
import com.stpl.pms.hibernate.mapping.StDmDomainMaster;
import com.stpl.pms.hibernate.mapping.StDmDomainStateMapping;
import com.stpl.pms.hibernate.mapping.StDmDomainWinApproveLimitMaster;
import com.stpl.pms.hibernate.mapping.StGenCountryMaster;
import com.stpl.pms.hibernate.mapping.StGenCurrencyMaster;
import com.stpl.pms.hibernate.mapping.StGenLanguageMaster;
import com.stpl.pms.hibernate.mapping.StGenPasswordPolicy;
import com.stpl.pms.hibernate.mapping.StGenSmsEmailProviderMaster;
import com.stpl.pms.hibernate.mapping.StGenStateMaster;
import com.stpl.pms.hibernate.mapping.StGenVerificationSourceMaster;
import com.stpl.pms.hibernate.mapping.StPmReferenceLabelOptionMapping;
import com.stpl.pms.hibernate.mapping.StPmReferenceMaster;
import com.stpl.pms.hibernate.mapping.StPmSecurityQuesMaster;
import com.stpl.pms.hibernate.mapping.StPortalContentMaster;
import com.stpl.pms.hibernate.mapping.StPortalLayoutMaster;
import com.stpl.pms.hibernate.mapping.StPortalMenuMaster;
import com.stpl.pms.hibernate.mapping.StRmServiceMaster;
import com.stpl.pms.hibernate.mapping.StRpBoMisAccountReportMaster;
import com.stpl.pms.hibernate.mapping.StVipLevelMaster;
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
import com.stpl.pms.javabeans.ReferenceInfoBean;
import com.stpl.pms.javabeans.SecurityQuesInfoBean;
import com.stpl.pms.javabeans.StateBean;
import com.stpl.pms.javabeans.UserInfoBean;
import com.stpl.pms.utility.DomainPropertyClasses;

public class DomainMgmtDaoImpl {
	private static final Logger logger = Logger
			.getLogger(DomainMgmtDaoImpl.class);

	@SuppressWarnings("unchecked")
	public Map<Integer, String> getPasswordPolicyMap(Session session) {
		HashMap<Integer, String> policyMap = new HashMap<Integer, String>();
		Criteria criteria = session.createCriteria(StGenPasswordPolicy.class)
				.add(Restrictions.eq("status", "ACTIVE"));
		List<StGenPasswordPolicy> policyList = criteria.list();
		for (StGenPasswordPolicy policy : policyList) {
			policyMap.put(policy.getPasswordPolicyId(), policy
					.getPasswordPolicy());
		}
		return policyMap;
	}

	@SuppressWarnings("unchecked")
	public HashMap<Short, String> getServiceMap(Session session) {
		HashMap<Short, String> serviceMap = new HashMap<Short, String>();
		Criteria criteria = session.createCriteria(StRmServiceMaster.class)
				.add(Restrictions.eq("status", "ACTIVE"))
				.setCacheable(true);
		List<StRmServiceMaster> serviceList = criteria.list();
		for (StRmServiceMaster service : serviceList) {
			serviceMap.put(service.getServiceId(), service.getServiceName());
		}
		return serviceMap;
	}

	@SuppressWarnings("unchecked")
	public HashMap<Integer, LanguageBean> getLangMap(Session session) {
		HashMap<Integer, LanguageBean> map = new HashMap<Integer, LanguageBean>();
		Criteria criteria = session.createCriteria(StGenLanguageMaster.class);
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		List<StGenLanguageMaster> langList = criteria.list();
		for (StGenLanguageMaster lang : langList) {
			map.put(lang.getLanguageId(), new LanguageBean(
					lang.getLanguageId(), lang.getLanguageName(), lang
							.getLanguageCode(), lang.getLanguageBaseCode()));
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<Short, StGenVerificationSourceMaster> getAutoVeriProp(
			Session session) throws PMSException {
		Map<Short, StGenVerificationSourceMaster> map = null;
		Criteria criteria = session
				.createCriteria(StGenVerificationSourceMaster.class);
		criteria.add(Restrictions.eq("sourceStatus", "ACTIVE"));
		List<StGenVerificationSourceMaster> list = criteria.list();
		if (list.size() > 0) {
			map = new HashMap<Short, StGenVerificationSourceMaster>();
			for (StGenVerificationSourceMaster stGenVerificationSourceMaster : list) {
				map.put(stGenVerificationSourceMaster.getSourceId(),
						stGenVerificationSourceMaster);
			}
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, CountryBean> fetchCountryStateMasterMap(Session session) {
		Criteria cri = session.createCriteria(StGenCountryMaster.class).add(
				Restrictions.eq("status", "ACTIVE"));
		List<StGenCountryMaster> countryList = cri.list();
		Map<String, CountryBean> countryStateMasterMap = new HashMap<String, CountryBean>();
		CountryBean countryBean;
		StateBean stateBean;
		for (StGenCountryMaster cm : countryList) {
			countryBean = new CountryBean();
			countryBean.setCountryId(cm.getId());
			countryBean.setCountryCode(cm.getCountryCode());
			countryBean.setName(cm.getName());
			countryBean.setStatus(cm.getStatus());
			for (StGenStateMaster sm : cm.getStateList()) {
				if ("ACTIVE".equals(sm.getStatus())) {
					stateBean = new StateBean(sm.getId(), sm.getStateCode(), sm
							.getName(), sm.getStatus());
					countryBean.setStateList(stateBean);
				}
			}
			countryStateMasterMap
					.put(countryBean.getCountryCode(), countryBean);
		}
		return countryStateMasterMap;
	}

	// old methods
	@SuppressWarnings("unchecked")
	public List<StPmReferenceMaster> fetchReferenceFields(Short domainId,
			Session session) throws PMSException {
		logger.info("Inside fetcReferenceField method..");
		List<StPmReferenceMaster> list = null;
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(StDmDomainMaster.class);
			List<StDmDomainMaster> domainMaster = criteria.add(
					Restrictions.eq("domainId", domainId)).list();
			if (domainMaster.get(0).getReferralList().equals("BYDEFAULT")) {
				domainId = 1;
			}
			criteria = session.createCriteria(StPmReferenceMaster.class);
			list = criteria.add(Restrictions.eq("domainId", domainId)).list();
		} catch (HibernateException he) {
			he.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<StPmReferenceLabelOptionMapping> fetchReferenceLabeleValues(
			Short domainId, Session session) throws PMSException {
		logger.info("fetchReferenceLabeleValues method Start Here..");
		List<StPmReferenceLabelOptionMapping> list = null;
		Criteria criteria = null;
		DetachedCriteria dc = null;
		try {
			criteria = session.createCriteria(StDmDomainMaster.class);
			List<StDmDomainMaster> domainMaster = criteria.add(
					Restrictions.eq("domainId", domainId)).list();
			if (domainMaster.get(0).getReferralList().equals("BYDEFAULT")) {
				domainId = 1;
			}
			dc = DetachedCriteria.forClass(StPmReferenceMaster.class);
			dc.setProjection(Projections.property("referenceId")).add(
					Restrictions.eq("domainId", domainId));
			criteria = session
					.createCriteria(StPmReferenceLabelOptionMapping.class);
			list = criteria.add(Subqueries.propertyIn("referenceId", dc))
					.list();
		} catch (HibernateException he) {
			he.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return list;

	}

	@SuppressWarnings("unchecked")
	public boolean checkDomainNameAvailability(String domainName,
			Session session) {
		Criteria criteria = session.createCriteria(StDmDomainMaster.class);
		criteria.add(Restrictions.eq("domainName", domainName));
		criteria.setProjection(Projections.property("domainName"));
		List<String> result = criteria.list();
		if (result.size() > 0) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Short domainRegSave(DomainPropertyBean domainBean,
			Map<String, String> domainMap, Session session, long userId)
			throws NumberFormatException, PMSException {

		// domainMaster
		StDmDomainMaster dm = new StDmDomainMaster();
		Timestamp currTime = new Timestamp(Calendar.getInstance()
				.getTimeInMillis());
		// domain detail
		dm.setDomainName(domainBean.getDomainName());
		dm.setDomainStatus("ACTIVE");
		//dm.setDomainImagePath(domainBean.getDomainLogo());

		// registration info
		dm.setRegistrationType("SINGLEPAGE");
		/*dm.setRegistrationMode(domainBean.getRegistrationMode());*/
		StGenPasswordPolicy genPasswordPolicy = (StGenPasswordPolicy) session
				.load(StGenPasswordPolicy.class, domainBean
						.getPasswordPolicyId());
		dm.setStGenPasswordPolicy(genPasswordPolicy);
		dm.setLoginThroughUsername(domainBean.getLoginThroughUsername());
		dm.setLoginThroughFconnect(domainBean.getLoginThroughFconnect());
		dm.setLoginThroughEmail(domainBean.getLoginThroughEmail());
		dm.setLoginThroughMobileNo(domainBean.getLoginThroughMobileNo());
		dm.setAllowedfeatureBlockedCountry(domainBean
				.getAllowedfeatureBlockedCountry());
		dm.setPlayerPassword(domainBean.getPlrPassword());//TODO ia alias master
		dm.setSendPassword(domainBean.getSendPassword());//TODO ia alias master
		dm.setFirstVerification(domainBean.getFirstVerification());
		dm.setVerificationThrough(domainBean.getVerificationThrough());

		// Payment Information
		dm.setCurrencyId(domainBean.getCurrencyId());
//		dm.setWalletType(domainBean.getWalletType());
		dm.setPaymentOptionCurrency(domainBean.getPaymentOptionCurrency());
		dm.setTdsOn(domainBean.getTdsOn());
		dm.setBonusUsageOrder(domainBean.getBonusUsageOrder());
		dm.setPlrVisibleWallet(domainBean.getPlrVisibleWallet());
		dm.setDepActionPendingWdr(domainBean.getDepActionPendingWdr());
		dm.setWdrApprovalLimit(domainBean.getWdrApprovalLimit());
		dm.setBonusWrCarryFwd(domainBean.getBonusWrCarryFwd());
		dm.setBonusExipryLimit(domainBean.getBonusExipryLimit());
		// portal Info
		dm.setLanguageId(domainBean.getLanguageId());

		// misc
		dm.setServiceId(domainBean.getServiceId());
		dm.setGameTryBeforeLogin(domainBean.getGameTryBeforeLogin());
		dm.setPlayerLedgerFormat(domainBean.getPlayerLedgerFormat());
		dm.settPAutoVerification(domainBean.getTpAutoVerification());
		dm.setVerificationSourceId(domainBean.getVerificationSourceId());
		// ByDefault and SPECIFIC properties
		dm.setRegistrationPage("SPECIFIC");
		dm.setTermCondition("SPECIFIC");
		dm.setPrivacyPolicy("SPECIFIC");
		dm.setSecurityQuesList("SPECIFIC");
		dm.setReferralList("BYDEFAULT");

		/*dm.setMenuList("BYDEFAULT");
		dm.setContentList("BYDEFAULT");
		dm.setUrlList("BYDEFAULT");
		dm.setFooter("BYDEFAULT");*/
		dm.setVipLevel("SPECIFIC");
		//dm.setTemplate("BYDEFAULT");

		dm.setGameMapping("BYDEFAULT");
		dm.setDuplicateLogic("BYDEFAULT");
		dm.setPaymentOption("SPECIFIC");
		dm.setMerchantProviderAccount("BYDEFAULT");
		dm.setRgOperatorLimit("BYDEFAULT");

		dm.setRolePreference("BYDEFAULT");
		dm.setBlockedIp("BYDEFAULT");
		dm.setBlockedEmail("BYDEFAULT");
		dm.setBlockedPhone("BYDEFAULT");
		dm.setAllowedCountries("BYDEFAULT");
		dm.setAllowedStates("BYDEFAULT");

		dm.setDefaultVipLevel(Integer.parseInt((domainMap
				.get("defaultVipLevel"))));
		// change from front end
		dm.setCheckRg(domainMap.get("checkRg"));
		dm.setAllowedInvaildLoginTry(domainBean.getAllowedInvaildLoginTry());
		dm.setPlayerPasswordHistoryCount(domainBean
				.getPlayerPasswordHistoryCount());
		dm.settPAutoVerification("NO");

		dm.setWdrCodeExpiry(-1);
		dm.setWdrCodeResendAfterTime(-1);
		dm.setForgotPasswordThrough("CODE");
		dm.setMultipleLogin("NO");

		session.save(dm);
		session.flush();
		
		Criteria crit = session.createCriteria(StVipLevelMaster.class);
		crit.add(Restrictions.eq("domainId", (short)1));
		
		List <StVipLevelMaster> viplist =crit.list();
		
		for (StVipLevelMaster stVipLevelMaster : viplist) {
			session.evict(stVipLevelMaster);
			stVipLevelMaster.setId(null);
			stVipLevelMaster.setDomainId(dm.getDomainId());
			session.save(stVipLevelMaster);
			
		}		
		
		// setting up payment options (PODM) info in the database.

		crit = session.createCriteria(StCshPaymentOptionsDomainMapping.class);
		crit.add(Restrictions.eq("domainId", (short)1));
		List<StCshPaymentOptionsDomainMapping> defaultPODM = crit.list();
		
		for (StCshPaymentOptionsDomainMapping podm : defaultPODM) {
				session.evict(podm);
				podm.setPodmId(null);
				podm.setDomainId(dm.getDomainId());
				session.save(podm);
		}
		

		// domain info
		StDmDomainInfo domainInfo = new StDmDomainInfo();
		domainInfo.setOwnerName(domainBean.getDomainOwner());
		domainInfo.setAddress(domainBean.getAddress());
		domainInfo.setContactPersonName(domainBean.getContactPersonName());
		domainInfo.setCountryCode(domainBean.getCountryCode());
		domainInfo.setStateCode(domainBean.getStateCode());
		domainInfo.setOwnerContactNo(domainBean.getOwnerContactNo());
		domainInfo.setDomainId(dm.getDomainId());
		session.save(domainInfo);
		session.flush();
		Criteria criteria = session.createCriteria(StGenCurrencyMaster.class);
		List<StGenCurrencyMaster> currencyMasterList = criteria.list();
		List<Integer> dmCurrencies = domainBean.getCurrency();
		for (StGenCurrencyMaster currencyMaster : currencyMasterList) {
			StDmDomainCurrencyMapping domainCurrencyMapping = new StDmDomainCurrencyMapping();
			domainCurrencyMapping.setCurrencyMaster(currencyMaster);
			domainCurrencyMapping.setDomainId(dm.getDomainId());
			domainCurrencyMapping.setStatus(dmCurrencies
					.contains(currencyMaster.getCurrencyId()) ? "ACTIVE"
					: "INACTIVE");
			domainCurrencyMapping.setCreatedBy(userId);
			domainCurrencyMapping.setCreationTime(currTime);
			domainCurrencyMapping.setLastUpdatedBy(userId);
			domainCurrencyMapping.setLastUpdationTime(currTime);
			session.save(domainCurrencyMapping);
			session.flush();
		}

		Criteria langCri = session.createCriteria(StGenLanguageMaster.class);
		List<StGenLanguageMaster> languageMasterList = langCri.list();
		List<Integer> dmLanguages = domainBean.getLanguage();
		for (StGenLanguageMaster languageMaster : languageMasterList) {
			StDmDomainLanguageMapping langMapping = new StDmDomainLanguageMapping();
			langMapping.setLanguageMaster(languageMaster);
			langMapping.setDomainId(dm.getDomainId());
			langMapping.setStatus(dmLanguages.contains(languageMaster
					.getLanguageId()) ? "ACTIVE" : "INACTIVE");
			langMapping.setCreatedBy(userId);
			langMapping.setCreationTime(currTime);
			langMapping.setLastUpdatedBy(userId);
			langMapping.setLastUpdationTime(currTime);
			session.save(langMapping);
			session.flush();
		}

		StDmDomainWinApproveLimitMaster approveLimitMaster = new StDmDomainWinApproveLimitMaster();
		approveLimitMaster.setDomainId(dm.getDomainId());
		approveLimitMaster.setBingoLimit(-1.00);
		approveLimitMaster.setCasinoLimit(-1.00);
		approveLimitMaster.setLiveCasinoLimit(-1.00);
		approveLimitMaster.setPokerLimit(-1.00);
		approveLimitMaster.setRummyLimit(-1.00);
		approveLimitMaster.setSportsLimit(-1.00);
		approveLimitMaster.setGamesLimit(-1.00);
		approveLimitMaster.setDrawGamesLimit(-1.00);
		approveLimitMaster.setSportsLotteryLimit(-1.00);
		approveLimitMaster.setCreatedBy(userId);
		approveLimitMaster.setCreationTime(currTime);
		approveLimitMaster.setLastUpdatedBy(userId);
		approveLimitMaster.setLastUpdationTime(currTime);
		approveLimitMaster.setGoldenRaceLimit(0d);
		session.save(approveLimitMaster);

		logger.info("The detail complete save");
		return dm.getDomainId();
	}

	@SuppressWarnings("unchecked")
	public void domainEditSave(DomainPropertyBean domainBean, Session session,
			long userId) {
		Timestamp currTime = new Timestamp(Calendar.getInstance()
				.getTimeInMillis());
		StDmDomainMaster dm = (StDmDomainMaster) session.get(
				StDmDomainMaster.class, domainBean.getDomainId());

		// registration info
	//	dm.setRegistrationType(domainBean.getRegistrationType());
	//	dm.setRegistrationMode(domainBean.getRegistrationMode());
		StGenPasswordPolicy genPasswordPolicy = (StGenPasswordPolicy) session
				.load(StGenPasswordPolicy.class, domainBean
						.getPasswordPolicyId());
		dm.setStGenPasswordPolicy(genPasswordPolicy);
		dm.setLoginThroughUsername(domainBean.getLoginThroughUsername());
		dm.setLoginThroughFconnect(domainBean.getLoginThroughFconnect());
		dm.setLoginThroughEmail(domainBean.getLoginThroughEmail());
		dm.setLoginThroughMobileNo(domainBean.getLoginThroughMobileNo());
		dm.setAllowedfeatureBlockedCountry(domainBean
				.getAllowedfeatureBlockedCountry());
		dm.setPlayerPassword(domainBean.getPlrPassword());//TODO in alias master
		dm.setSendPassword(domainBean.getSendPassword());//TODO ia alias master
		dm.setFirstVerification(domainBean.getFirstVerification());
		dm.setVerificationThrough(domainBean.getVerificationThrough());
		/*if (domainBean.getDomainLogo() != null
				&& !"".equals(domainBean.getDomainLogo())) {
			dm.setDomainImagePath(domainBean.getDomainLogo());
		}
*/
		// Payment Information
		dm.setCurrencyId(domainBean.getCurrencyId());
		//dm.setWalletType(domainBean.getWalletType());
		dm.setPaymentOptionCurrency(domainBean.getPaymentOptionCurrency());
		dm.setTdsOn(domainBean.getTdsOn());
		dm.setBonusUsageOrder(domainBean.getBonusUsageOrder());
		dm.setPlrVisibleWallet(domainBean.getPlrVisibleWallet());
		dm.setDepActionPendingWdr(domainBean.getDepActionPendingWdr());
		dm.setWdrApprovalLimit(domainBean.getWdrApprovalLimit());
		dm.setBonusWrCarryFwd(domainBean.getBonusWrCarryFwd());
		dm.setBonusExipryLimit(domainBean.getBonusExipryLimit());
		// portal Info
		dm.setLanguageId(domainBean.getLanguageId());

		// misc
		dm.setServiceId(domainBean.getServiceId());
		dm.setGameTryBeforeLogin(domainBean.getGameTryBeforeLogin());
		dm.setPlayerLedgerFormat(domainBean.getPlayerLedgerFormat());
		dm.settPAutoVerification(domainBean.getTpAutoVerification());
		dm.setVerificationSourceId(domainBean.getVerificationSourceId());

		// dm.setDefaultVipLevel(domainBean.getDefaultVipLevel());
		// change from front end
		dm.setCheckRg(domainBean.getCheckRg());
		dm.setAllowedInvaildLoginTry(domainBean.getAllowedInvaildLoginTry());
		dm.setPlayerPasswordHistoryCount(domainBean
				.getPlayerPasswordHistoryCount());
		//dm.setUrlList(domainBean.getUrlList());

		session.update(dm);
		session.flush();

		// domain info
		Criteria criteria1 = session.createCriteria(StDmDomainInfo.class);
		criteria1.add(Restrictions.eq("domainId", domainBean.getDomainId()));
		List<StDmDomainInfo> domain = criteria1.list();
		StDmDomainInfo domainInfo = domain.get(0);
		domainInfo.setOwnerName(domainBean.getDomainOwner());
		domainInfo.setAddress(domainBean.getAddress());
		domainInfo.setContactPersonName(domainBean.getContactPersonName());
		domainInfo.setCountryCode(domainBean.getCountryCode());
		domainInfo.setStateCode(domainBean.getStateCode());
		domainInfo.setOwnerContactNo(domainBean.getOwnerContactNo());
		domainInfo.setDomainId(dm.getDomainId());
		session.update(domainInfo);
		session.flush();
		Criteria criteria = session.createCriteria(StGenCurrencyMaster.class);
		List<StGenCurrencyMaster> currencyMasterList = criteria.list();
		List<Integer> dmCurrencies = domainBean.getCurrency();
		Criteria curCri = session.createCriteria(
				StDmDomainCurrencyMapping.class).add(
				Restrictions.eq("domainId", (short) 2));
		curCri.setProjection(Projections.projectionList().add(
				Projections.property("currencyMaster.currencyId")));
		List<Integer> domainCurrMapping = curCri.list();

		StDmDomainCurrencyMapping domainCurrencyMapping = null;
		for (StGenCurrencyMaster cm : currencyMasterList) {
			if (domainCurrMapping.contains(cm.getCurrencyId())) {
				session
						.createQuery(
								"update StDmDomainCurrencyMapping set status='"
										+ (dmCurrencies.contains(cm
												.getCurrencyId()) ? "ACTIVE"
												: "INACTIVE")
										+ "', lastUpdatedBy=" + userId
										+ ", lastUpdationTime='" + currTime
										+ "' where domainId = '"
										+ dm.getDomainId()
										+ "' and currencyMaster.currencyId = '"
										+ cm.getCurrencyId() + "'")
						.executeUpdate();

			} else {
				domainCurrencyMapping = new StDmDomainCurrencyMapping();
				domainCurrencyMapping.setCurrencyMaster(cm);
				domainCurrencyMapping.setDomainId(dm.getDomainId());
				domainCurrencyMapping.setStatus(dmCurrencies.contains(cm
						.getCurrencyId()) ? "ACTIVE" : "INACTIVE");
				domainCurrencyMapping.setCreatedBy(userId);
				domainCurrencyMapping.setCreationTime(currTime);
				domainCurrencyMapping.setLastUpdatedBy(userId);
				domainCurrencyMapping.setLastUpdationTime(currTime);
				session.save(domainCurrencyMapping);
			}
			session.flush();

		}

		criteria = session.createCriteria(StGenLanguageMaster.class);
		List<StGenLanguageMaster> langMasterList = criteria.list();
		List<Integer> dmLanguages = domainBean.getLanguage();
		Criteria langCri = session.createCriteria(
				StDmDomainLanguageMapping.class).add(
				Restrictions.eq("domainId", (short) 2));
		langCri.setProjection(Projections.projectionList().add(
				Projections.property("languageMaster.languageId")));
		List<Integer> domainLangMapping = langCri.list();
		StDmDomainLanguageMapping domainLanguageMapping = null;
		for (StGenLanguageMaster lm : langMasterList) {
			if (domainLangMapping.contains(lm.getLanguageId())) {
				session
						.createQuery(
								"update StDmDomainLanguageMapping set status='"
										+ (dmLanguages.contains(lm
												.getLanguageId()) ? "ACTIVE"
												: "INACTIVE")
										+ "', lastUpdatedBy='" + userId
										+ "', lastUpdationTime='" + currTime
										+ "' where domainId = '"
										+ dm.getDomainId()
										+ "' and languageMaster.languageId= '"
										+ lm.getLanguageId() + "'")
						.executeUpdate();

			} else {
				domainLanguageMapping = new StDmDomainLanguageMapping(dm
						.getDomainId(), lm, dmLanguages.contains(lm
						.getLanguageId()) ? "ACTIVE" : "INACTIVE");
				domainLanguageMapping.setCreatedBy(userId);
				domainLanguageMapping.setCreationTime(currTime);
				domainLanguageMapping.setLastUpdatedBy(userId);
				domainLanguageMapping.setLastUpdationTime(currTime);
				session.save(domainLanguageMapping);
			}
			session.flush();

		}

	}

	/**************/
	public void updateDomainMaster(short domainId, String duplicationLogic,
			StatelessSession session) {
		Criteria criteria = session.createCriteria(StDmDomainMaster.class);
		criteria.add(Restrictions.eq("domainId", domainId));
		StDmDomainMaster domainMaster = (StDmDomainMaster) criteria.list().get(
				0);
		domainMaster.setDuplicateLogic(duplicationLogic);
		session.update(domainMaster);
	}

	@SuppressWarnings("unchecked")
	public List<StPortalLayoutMaster> getLayoutMap(Session session) {
		Criteria criteria = session.createCriteria(StPortalLayoutMaster.class);
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		// criteria.add(Restrictions.eq("", value))
		List<StPortalLayoutMaster> layoutMasters = criteria.list();
		// for(StPortalLayoutMaster layoutMaster: layoutMasters ){
		return layoutMasters;
		// }
	}

	public List<ReferenceInfoBean> setReferralList(Short domainId,
			List<ReferenceInfoBean> refInfoBeans, Session session, long userId,
			String domain) throws PMSException {
		Timestamp currTime = new Timestamp(Calendar.getInstance()
				.getTimeInMillis());
		logger.info("Inside setReferralList method....");
		List<ReferenceInfoBean> referenceInfoList = refInfoBeans;
		try {
			for (int i = 0; i < referenceInfoList.size(); i++) {
				StPmReferenceMaster stPmReferenceMaster = new StPmReferenceMaster();
				if (referenceInfoList.get(i).getReferenceId() != null
						&& !referenceInfoList.get(i).getReferenceId()
								.equals("")
						&& (domainId == 1 || domain.equals("SPECIFIC"))) {
					stPmReferenceMaster.setReferenceId(referenceInfoList.get(i)
							.getReferenceId());
				}
				stPmReferenceMaster.setReferenceName(referenceInfoList.get(i)
						.getReferenceName());
				stPmReferenceMaster.setReferenceDispName(referenceInfoList.get(
						i).getDisplayName());
				stPmReferenceMaster.setRefTxtLabel1(referenceInfoList.get(i)
						.getRefTxtLabel1());
				stPmReferenceMaster.setRefTxtLabel2(referenceInfoList.get(i)
						.getRefTxtLabel2());
				stPmReferenceMaster.setRefTxtLabel3(referenceInfoList.get(i)
						.getRefTxtLabel3());
				stPmReferenceMaster.setDomainId(domainId);
				if (referenceInfoList.get(i).getRefTxtLabel1Type() != null
						&& !referenceInfoList.get(i).getRefTxtLabel1Type()
								.equals("")) {
					stPmReferenceMaster.setRefTxtLabel1Type(referenceInfoList
							.get(i).getRefTxtLabel1Type());
				}
				if (referenceInfoList.get(i).getRefTxtLabel2Type() != null
						&& !referenceInfoList.get(i).getRefTxtLabel2Type()
								.equals("")) {
					stPmReferenceMaster.setRefTxtLabel2Type(referenceInfoList
							.get(i).getRefTxtLabel2Type());
				}
				if (referenceInfoList.get(i).getRefTxtLabel3Type() != null
						&& !referenceInfoList.get(i).getRefTxtLabel3Type()
								.equals("")) {
					stPmReferenceMaster.setRefTxtLabel3Type(referenceInfoList
							.get(i).getRefTxtLabel3Type());
				}
				stPmReferenceMaster.setStatus(referenceInfoList.get(i)
						.getStatus());
				stPmReferenceMaster.setLastUpdatedBy(userId);
				stPmReferenceMaster.setLastUpdationTime(currTime);
				if (referenceInfoList.get(i).getReferenceId() != null
						&& !referenceInfoList.get(i).getReferenceId()
								.equals("")
						&& (domainId == 1 || domain.equals("SPECIFIC"))) {
					stPmReferenceMaster.setCreatedBy(referenceInfoList.get(i).getCreatedBy());
					stPmReferenceMaster.setCreationTime(referenceInfoList.get(i).getCreationTime());
					session.update(stPmReferenceMaster);
				} else {
					stPmReferenceMaster.setCreatedBy(userId);
					stPmReferenceMaster.setCreationTime(currTime);
					Short id = (Short) session.save(stPmReferenceMaster);
					refInfoBeans.get(i).setReferenceId(id);
				}
			}
			if ("BYDEFAULT".equals(domain) && domainId != 1) {
				StDmDomainMaster dmDomainMaster = (StDmDomainMaster) session
						.load(StDmDomainMaster.class, domainId);
				dmDomainMaster.setReferralList("SPECIFIC");
				session.save(dmDomainMaster);
			}
			session.flush();
			session.clear();

		} catch (HibernateException he) {
			he.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return refInfoBeans;
	}

	public void setReferralLabels(Short domainId,
			List<ReferenceInfoBean> referenceInfoBeans, String domain,
			Session session) throws PMSException {
		logger.info("Inside setReferralList method....");
		try {
			for (int i = 0; i < referenceInfoBeans.size(); i++) {
				if (referenceInfoBeans.get(i).getRefTxtLabel1Type() != null
						&& referenceInfoBeans.get(i).getRefTxtLabel1Type()
								.equals("List")
						|| referenceInfoBeans.get(i).getLabelInfoBean1()
								.getValueList().size() > 0) {
					for (int j = 0; j < referenceInfoBeans.get(i)
							.getLabelInfoBean1().getValueList().size(); j++) {
						StPmReferenceLabelOptionMapping referenceLabelOptionMapping = new StPmReferenceLabelOptionMapping();
						referenceLabelOptionMapping
								.setLabelName("ref_txt_label_1");
						referenceLabelOptionMapping
								.setLabelOptionValue(referenceInfoBeans.get(i)
										.getLabelInfoBean1().getValueList()
										.get(j));
						if (!referenceInfoBeans.get(i).getRefTxtLabel1Type()
								.equals("List")) {
							referenceLabelOptionMapping.setStatus("INACTIVE");
						} else {
							referenceLabelOptionMapping
									.setStatus(referenceInfoBeans.get(i)
											.getLabelInfoBean1()
											.getStatusList().get(j));
						}
						referenceLabelOptionMapping
								.setReferenceId(referenceInfoBeans.get(i)
										.getReferenceId());
						if (referenceInfoBeans.get(i).getLabelInfoBean1()
								.getId().size() > j
								&& referenceInfoBeans.get(i)
										.getLabelInfoBean1().getId().get(j) != null) {
							if (domainId == 1 || domain.equals("SPECIFIC")) {
								referenceLabelOptionMapping
										.setId(referenceInfoBeans.get(i)
												.getLabelInfoBean1().getId()
												.get(j));
							}
						}
						session.saveOrUpdate(referenceLabelOptionMapping);
						session.flush();
						session.clear();
					}

				}
				if (referenceInfoBeans.get(i).getRefTxtLabel2Type() != null
						&& referenceInfoBeans.get(i).getRefTxtLabel2Type()
								.equals("List")
						|| referenceInfoBeans.get(i).getLabelInfoBean2()
								.getValueList().size() > 0) {
					for (int j = 0; j < referenceInfoBeans.get(i)
							.getLabelInfoBean2().getValueList().size(); j++) {
						StPmReferenceLabelOptionMapping referenceLabelOptionMapping = new StPmReferenceLabelOptionMapping();
						referenceLabelOptionMapping
								.setLabelName("ref_txt_label_2");
						referenceLabelOptionMapping
								.setLabelOptionValue(referenceInfoBeans.get(i)
										.getLabelInfoBean2().getValueList()
										.get(j));
						if (!referenceInfoBeans.get(i).getRefTxtLabel2Type()
								.equals("List")) {
							referenceLabelOptionMapping.setStatus("INACTIVE");
						} else {
							referenceLabelOptionMapping
									.setStatus(referenceInfoBeans.get(i)
											.getLabelInfoBean2()
											.getStatusList().get(j));
						}
						referenceLabelOptionMapping
								.setReferenceId(referenceInfoBeans.get(i)
										.getReferenceId());
						if (referenceInfoBeans.get(i).getLabelInfoBean2()
								.getId().size() > j
								&& referenceInfoBeans.get(i)
										.getLabelInfoBean2().getId().get(j) != null) {
							if (domainId == 1 || domain.equals("SPECIFIC")) {
								referenceLabelOptionMapping
										.setId(referenceInfoBeans.get(i)
												.getLabelInfoBean2().getId()
												.get(j));
							}
						}

						session.saveOrUpdate(referenceLabelOptionMapping);
						session.flush();
						session.clear();
					}

				}
				if (referenceInfoBeans.get(i).getRefTxtLabel3Type() != null
						&& referenceInfoBeans.get(i).getRefTxtLabel3Type()
								.equals("List")
						|| referenceInfoBeans.get(i).getLabelInfoBean3()
								.getValueList().size() > 0) {
					for (int j = 0; j < referenceInfoBeans.get(i)
							.getLabelInfoBean3().getValueList().size(); j++) {
						StPmReferenceLabelOptionMapping referenceLabelOptionMapping = new StPmReferenceLabelOptionMapping();
						referenceLabelOptionMapping
								.setLabelName("ref_txt_label_3");
						referenceLabelOptionMapping
								.setLabelOptionValue(referenceInfoBeans.get(i)
										.getLabelInfoBean3().getValueList()
										.get(j));
						if (!referenceInfoBeans.get(i).getRefTxtLabel3Type()
								.equals("List")) {
							referenceLabelOptionMapping.setStatus("INACTIVE");
						} else {
							referenceLabelOptionMapping
									.setStatus(referenceInfoBeans.get(i)
											.getLabelInfoBean3()
											.getStatusList().get(j));
						}
						referenceLabelOptionMapping
								.setReferenceId(referenceInfoBeans.get(i)
										.getReferenceId());
						if (referenceInfoBeans.get(i).getLabelInfoBean3()
								.getId().size() > j
								&& referenceInfoBeans.get(i)
										.getLabelInfoBean3().getId().get(j) != null) {
							if (domainId == 1 || domain.equals("SPECIFIC")) {
								referenceLabelOptionMapping
										.setId(referenceInfoBeans.get(i)
												.getLabelInfoBean3().getId()
												.get(j));
							}
						}

						session.saveOrUpdate(referenceLabelOptionMapping);
						session.flush();
						session.clear();
					}

				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}

	}

	@SuppressWarnings("unchecked")
	public List<StPmSecurityQuesMaster> fetchSecQues(Short domainId,
			Session session) throws PMSException {
		logger.info("Inside fetchSecQues method....");
		List<StPmSecurityQuesMaster> secQuesList = new ArrayList<StPmSecurityQuesMaster>();
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(StDmDomainMaster.class);
			List<StDmDomainMaster> domainMaster = criteria.add(
					Restrictions.eq("domainId", domainId)).list();
			if (domainMaster.get(0).getSecurityQuesList().equals("BYDEFAULT")) {
				domainId = 1;
			}
			criteria = session.createCriteria(StPmSecurityQuesMaster.class);
			secQuesList = criteria.add(Restrictions.eq("domainId", domainId))
					.add(Restrictions.eq("addedBy", "BO")).list();

		} catch (HibernateException he) {
			he.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}

		return secQuesList;

	}

	@SuppressWarnings("unchecked")
	public void setSecQuesList(Short domainId,
			List<SecurityQuesInfoBean> quesInfoBeans, Session session,
			long userId) throws PMSException {
		logger.info("Inside setSecQuesList method....");
		Timestamp currTime = new Timestamp(Calendar.getInstance()
				.getTimeInMillis());
		List<SecurityQuesInfoBean> securityQuesList = quesInfoBeans;
		List<StDmDomainMaster> domainMaster = null;
		Criteria criteria = null;
		List<StPmSecurityQuesMaster> list = null;
		try {
			criteria = session.createCriteria(StDmDomainMaster.class);
			domainMaster = criteria.add(Restrictions.eq("domainId", domainId))
					.list();
			if (domainId != 1
					&& domainMaster.get(0).getSecurityQuesList().equals(
							"BYDEFAULT")) {
				StDmDomainMaster dmDomainMaster = domainMaster.get(0);
				dmDomainMaster.setSecurityQuesList("SPECIFIC");
				session.save(dmDomainMaster);
			}
			criteria = session.createCriteria(StPmSecurityQuesMaster.class);
			list = criteria.add(Restrictions.eq("domainId", domainId)).add(
					Restrictions.eq("addedBy", "BO")).list();
			for (int i = 0; i < securityQuesList.size(); i++) {
				if (list.size() != 0) {
					if (i < list.size()) {
						StPmSecurityQuesMaster stPmSecurityQuesMaster = (StPmSecurityQuesMaster) list
								.get(i);
						stPmSecurityQuesMaster.setStatus(securityQuesList
								.get(i).getStatus());
						stPmSecurityQuesMaster.setLastUpdatedBy(userId);
						stPmSecurityQuesMaster.setLastUpdationTime(currTime);
						session.saveOrUpdate(stPmSecurityQuesMaster);
					} else {
						StPmSecurityQuesMaster stPmSecurityQuesMaster = new StPmSecurityQuesMaster();
						stPmSecurityQuesMaster.setSecQues(securityQuesList.get(
								i).getSecQues());
						stPmSecurityQuesMaster
								.setSecQuesDispName(securityQuesList.get(i)
										.getDisplayName());
						stPmSecurityQuesMaster.setAddedBy("BO");
						stPmSecurityQuesMaster.setDomainId(domainId);
						stPmSecurityQuesMaster.setStatus("ACTIVE");
						stPmSecurityQuesMaster.setUserId(securityQuesList
								.get(i).getUserId());
						stPmSecurityQuesMaster.setCreationTime(currTime);
						stPmSecurityQuesMaster.setLastUpdatedBy(userId);
						stPmSecurityQuesMaster.setLastUpdationTime(currTime);
						session.save(stPmSecurityQuesMaster);
					}
				} else {
					StPmSecurityQuesMaster stPmSecurityQuesMaster = new StPmSecurityQuesMaster();
					stPmSecurityQuesMaster.setSecQues(securityQuesList.get(i)
							.getSecQues());
					stPmSecurityQuesMaster.setSecQuesDispName(securityQuesList
							.get(i).getDisplayName());
					stPmSecurityQuesMaster.setAddedBy("BO");
					stPmSecurityQuesMaster.setDomainId(domainId);
					stPmSecurityQuesMaster.setStatus(securityQuesList.get(i)
							.getStatus());
					stPmSecurityQuesMaster.setUserId(securityQuesList.get(i)
							.getUserId());
					stPmSecurityQuesMaster.setCreationTime(currTime);
					stPmSecurityQuesMaster.setLastUpdatedBy(userId);
					stPmSecurityQuesMaster.setLastUpdationTime(currTime);
					session.save(stPmSecurityQuesMaster);
				}
				session.flush();
				session.clear();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
	}

	@SuppressWarnings("unchecked")
	public List<CountryBean> fetchDomainCountryList(Short domainId,
			Session session, boolean checkStatus) throws PMSException {
		List<CountryBean> countryBeanList = new ArrayList<CountryBean>();
		CountryBean countryBean = null;
		try {
			short countryDomainId = domainId;
			short stateDomainId = domainId;
			if("BYDEFAULT".equals(CommonMethodDaoImpl.getInstance().getDmProperty(session, domainId,"allowedCountries"))){
				countryDomainId =1;
			}
			if("BYDEFAULT".equals(CommonMethodDaoImpl.getInstance().getDmProperty(session, domainId,"allowedStates"))){
				stateDomainId =1;
			}
			Criteria cri = session
					.createCriteria(StDmDomainCountryMapping.class);
			cri.setCacheable(true);
			cri.setCacheRegion("StDmDomainCountryMappingCache");
			cri.createAlias("countryMaster", "cm");
			cri.add(Restrictions.eq("domainId", countryDomainId));
			cri.add(Restrictions.eq("cm.status", "ACTIVE"));
			if (checkStatus) {
				cri.add(Restrictions.eq("status", "ACTIVE"));
			}
			cri.addOrder(Order.asc("cm.name"));
			List<StDmDomainCountryMapping> list = cri.list();
			for (StDmDomainCountryMapping mapping : list) {
				countryBean = new CountryBean();
				countryBean.setCountryId(mapping.getId());
				countryBean.setCountryCode(mapping.getCountryMaster()
						.getCountryCode());
				countryBean.setName(mapping.getCountryMaster().getName());
				countryBean.setStatus(mapping.getStatus());
				countryBean.setStateList(new ArrayList<StateBean>());
				Criteria stateCri = session
						.createCriteria(StDmDomainStateMapping.class);
				stateCri.setCacheable(true);
				stateCri.setCacheRegion("StDmDomainStateMappingCache");
				stateCri.createAlias("stateMaster", "sm");
				stateCri
						.add(Restrictions.eq("domainId", stateDomainId));
				stateCri.add(Restrictions.eq("countryCode", mapping
						.getCountryMaster().getCountryCode()));
				stateCri.add(Restrictions.eq("sm.countryCode", mapping
						.getCountryMaster().getCountryCode()));
				stateCri.add(Restrictions.eq("sm.status", "ACTIVE"));
				if (checkStatus) {
					stateCri.add(Restrictions.eq("status", "ACTIVE"));
				}
				stateCri.addOrder(Order.asc("sm.name"));
				List<StDmDomainStateMapping> stateList = stateCri.list();
				for (StDmDomainStateMapping state : stateList) {
					StateBean bean = new StateBean();
					bean.setStateId(state.getId());
					bean.setName(state.getStateMaster().getName());
					bean.setStateCode(state.getStateMaster().getStateCode());
					bean.setStatus(state.getStatus());
					bean.setCountryId(state.getCountryId());
					countryBean.getStateList().add(bean);
				}
				countryBeanList.add(countryBean);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return countryBeanList;

	}

	@SuppressWarnings("unchecked")
	public void setAllowedCountryState(Short domainId,
			CountryStateBean countryStateBean, Session session, long userId)
			throws PMSException {
		logger.info("Inside setAllowedCountryState method....");
		Criteria criteria = null;
		short countryDomainId = 1;
		short stateDomainId = 1;
		Timestamp currTime = new Timestamp(Calendar.getInstance()
				.getTimeInMillis());
		try {
			String allowedCountries = CommonMethodDaoImpl.getInstance()
					.getDmProperty(session, domainId, "allowedCountries");
			if (!"BYDEFAULT".equals(allowedCountries)) {
				countryDomainId = domainId;
			}
			String allowedStates = CommonMethodDaoImpl.getInstance()
					.getDmProperty(session, domainId, "allowedStates");
			if (!"BYDEFAULT".equals(allowedStates)) {
				stateDomainId = domainId;
			}
			Query countryQry = null;
			if (countryDomainId == domainId) {
				// update all country mapping for domain with status INACTIVE
				countryQry = session
						.createQuery("update StDmDomainCountryMapping set status='INACTIVE' where domainId='"
								+ domainId + "'");
				countryQry.executeUpdate();
			} else {
				// Insert all country mapping for domain with status INACTIVE
				criteria = session
						.createCriteria(StDmDomainCountryMapping.class);
				List<StDmDomainCountryMapping> list = criteria.add(
						Restrictions.eq("domainId", countryDomainId)).list();
				StDmDomainCountryMapping dmCountMap = null;
				for (StDmDomainCountryMapping countryMap : list) {
					dmCountMap = new StDmDomainCountryMapping();
					dmCountMap.setCountryMaster(countryMap.getCountryMaster());
					dmCountMap.setDomainId(domainId);
					dmCountMap.setCreatedBy(userId);
					dmCountMap.setCreationTime(currTime);
					dmCountMap.setStatus("INACTIVE");
					dmCountMap.setLastUpdatedBy(userId);
					dmCountMap.setLastUpdationTime(currTime);
					session.save(dmCountMap);
					session.flush();
				}
			}

			criteria = session.createCriteria(StDmDomainCountryMapping.class)
					.createAlias("countryMaster", "cm");
			List<StDmDomainCountryMapping> activeCountries = criteria.add(
					Restrictions.eq("domainId", domainId)).add(
					Restrictions.in("cm.countryCode", countryStateBean
							.getCountryCode())).list();
			for (StDmDomainCountryMapping country : activeCountries) {
				country.setStatus("ACTIVE");
				country.setLastUpdatedBy(userId);
				country.setLastUpdationTime(currTime);
				session.update(country);
			}

			Query stateQry = null;
			if (stateDomainId == domainId) {
				// update all state mapping for domain with status INACTIVE
				stateQry = session
						.createQuery("update StDmDomainStateMapping set status='INACTIVE' where domainId='"
								+ domainId + "'");
				stateQry.executeUpdate();
			} else {
				// Insert all state mapping for domain with status INACTIVE
				criteria = session.createCriteria(StDmDomainStateMapping.class);
				List<StDmDomainStateMapping> list = criteria.add(
						Restrictions.eq("domainId", stateDomainId)).list();
				StDmDomainStateMapping dmStateMap = null;
				for (StDmDomainStateMapping stateMap : list) {
					dmStateMap = new StDmDomainStateMapping();
					dmStateMap.setCountryCode(stateMap.getCountryCode());
					dmStateMap.setStateMaster(stateMap.getStateMaster());
					dmStateMap.setCountryId(stateMap.getCountryId());
					dmStateMap.setDomainId(domainId);
					dmStateMap.setCreatedBy(userId);
					dmStateMap.setCreationTime(currTime);
					dmStateMap.setStatus("INACTIVE");
					dmStateMap.setLastUpdatedBy(userId);
					dmStateMap.setLastUpdationTime(currTime);
					session.save(dmStateMap);
					session.flush();
				}
			}

			criteria = session.createCriteria(StDmDomainStateMapping.class)
					.createAlias("stateMaster", "sm");
			List<StDmDomainStateMapping> activeStates = criteria.add(
					Restrictions.eq("domainId", domainId)).add(
					Restrictions.in("sm.stateCode", countryStateBean
							.getStateCode())).list();
			for (StDmDomainStateMapping state : activeStates) {
				state.setStatus("ACTIVE");
				state.setLastUpdatedBy(userId);
				state.setLastUpdationTime(currTime);
				session.update(state);
			}

			if (countryDomainId != domainId) {
				session.createQuery(
						"update StDmDomainMaster set allowedCountries='SPECIFIC' where domainId="
								+ domainId).executeUpdate();
			}
			if (stateDomainId != domainId) {
				session.createQuery(
						"update StDmDomainMaster set allowedStates='SPECIFIC' where domainId="
								+ domainId).executeUpdate();
				
			}
			session.flush();
		} catch (HibernateException e) {
			logger.error("===HibernateException===");
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (RuntimeException re) {
			logger.error("*********Runtime Exception******");
			re.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
			}
		}

	@SuppressWarnings("unchecked")
	public Map<Integer, String> getContentList(String contentType,
			Session session) throws PMSException {
		Map<Integer, String> contentList = new HashMap<Integer, String>();
		try {
			Criteria crit = session.createCriteria(StPortalContentMaster.class);
			crit.add(Restrictions.eq("contentType", contentType.trim()));
			List<StPortalContentMaster> list = crit.list();
			for (StPortalContentMaster stPortalContentMaster : list) {
				contentList.put(stPortalContentMaster.getContentId(),
						stPortalContentMaster.getContentName());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
					PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return contentList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, List<MenuContentBean>> getPortalContentMap(Short aliasId,String device,
			Session session) throws PMSException {
		Map<String, List<MenuContentBean>> contentMap = new HashMap<String, List<MenuContentBean>>();
		try {
			Criteria crit = session.createCriteria(StPortalContentMaster.class);
			crit.add(Restrictions.eq("aliasId", aliasId));
			crit.add(Restrictions.eq("device", device));
			crit.add(Restrictions.eq("isLink", "Y"));
			List<StPortalContentMaster> list = crit.list();
			for (StPortalContentMaster contentMaster : list) {
				MenuContentBean contentBean = new MenuContentBean();
				List<MenuContentBean> contentBeansList = null;
				contentBean.setContentId(contentMaster.getContentId());
				contentBean.setContentName(contentMaster.getContentName());
				if (contentMap.containsKey(contentMaster.getContentType())) {
					contentBeansList = contentMap.get(contentMaster
							.getContentType());
					contentBeansList.add(contentBean);

				} else {
					contentBeansList = new ArrayList<MenuContentBean>();
					contentBeansList.add(contentBean);
				}
				contentMap
						.put(contentMaster.getContentType(), contentBeansList);

			}

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
					PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		return contentMap;

	}

	@SuppressWarnings("unchecked")
	public void submitAddMenuDetail(MenuDataBean menuDataBean, short domainId, short aliasId,
			String device, String menulList, Session session, long userId) {
		StPortalContentMaster contentMaster = null;
		StPortalMenuMaster menuMaster = null;
		Timestamp currTime = new Timestamp(Calendar.getInstance()
				.getTimeInMillis());
		try {
			if ("BYDEFAULT".equals(menulList) && domainId != 1 && aliasId!=1) {
				Criteria cri = session.createCriteria(StPortalMenuMaster.class);
				cri.add(Restrictions.eq("aliasId", (short) 1));
				List<StPortalMenuMaster> defaultMenuList = cri.list();
				for (StPortalMenuMaster stPortalMenuMaster2 : defaultMenuList) {
					StPortalMenuMaster stPortalMenuMaster = new StPortalMenuMaster(
							domainId, aliasId, stPortalMenuMaster2
									.getStPortalContentMaster(),
							stPortalMenuMaster2.getDisplayCode(),
							stPortalMenuMaster2.getOrder(), stPortalMenuMaster2
									.getLevel(), device, stPortalMenuMaster2
									.getContentType(), stPortalMenuMaster2
									.getParentId(), stPortalMenuMaster2
									.getStatus());
					stPortalMenuMaster.setCreatedBy(userId);
					stPortalMenuMaster.setCreationTime(currTime);
					stPortalMenuMaster.setLastUpdatedBy(userId);
					stPortalMenuMaster.setLastUpdationTime(currTime);
					session.save(stPortalMenuMaster);
				}
				Criteria criteria = session
						.createCriteria(StDmDomainAliasNameMaster.class);
				criteria.add(Restrictions.eq("aliasId", aliasId));
				StDmDomainAliasNameMaster aliasMaster = (StDmDomainAliasNameMaster) criteria
						.list().get(0);
				aliasMaster.setMenuList("SPECIFIC");
				session.update(aliasMaster);
			}
			Criteria crit = session.createCriteria(StPortalMenuMaster.class);
			crit.setProjection(Projections.max("order"));
			crit.add(Restrictions.eq("parentId", 0));
			Integer order = (Integer) crit.list().get(0);
			if (order == null) {
				order = 0;
			}
			contentMaster = (StPortalContentMaster) session.load(
					StPortalContentMaster.class, menuDataBean.getContentName());
			menuMaster = setMenuBean(session, menuDataBean, domainId, aliasId, device,
					contentMaster, (short) 1, ++order, 0, userId, currTime);
			int menuId = (Integer) session.save(menuMaster);
			int i = 0;
			if (menuDataBean.getSubMenuList() != null) {
				for (MenuDataBean level2 : menuDataBean.getSubMenuList()) {
					contentMaster = (StPortalContentMaster) session.load(
							StPortalContentMaster.class, level2
									.getContentName());
					menuMaster = setMenuBean(session, level2, domainId, aliasId, device,
							contentMaster, (short) 2, ++i, menuId, userId,
							currTime);
					int subMenuId = (Integer) session.save(menuMaster);
					int j = 0;
					if (level2.getSubMenuList() != null) {
						for (MenuDataBean level3 : level2.getSubMenuList()) {
							contentMaster = (StPortalContentMaster) session
									.load(StPortalContentMaster.class, level3
											.getContentName());
							menuMaster = setMenuBean(session, level3, domainId, aliasId,
									device, contentMaster, (short) 3, ++j,
									subMenuId, userId, currTime);
							session.save(menuMaster);
						}
					}
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void submitEditMenu(MenuDataBean menuDataBean, short domainId,short aliasId,
			String device, String menulList, Session session, long userId)
			throws HibernateException, PMSException {
		Timestamp currTime = new Timestamp(Calendar.getInstance()
				.getTimeInMillis());
		StPortalMenuMaster menuMaster = null;
		StPortalContentMaster contentMaster = null;
		// StPortalContentMaster contentMaster = null;

		if ("BYDEFAULT".equals(menulList) && domainId != 1 && aliasId!=1) {
			Criteria cri = session.createCriteria(StPortalMenuMaster.class);
			cri.add(Restrictions.eq("aliasId", (short) 1));
			List<StPortalMenuMaster> defaultMenuList = cri.list();
			for (StPortalMenuMaster stPortalMenuMaster2 : defaultMenuList) {
				StPortalMenuMaster stPortalMenuMaster = new StPortalMenuMaster(
						domainId, aliasId, stPortalMenuMaster2
								.getStPortalContentMaster(),
						stPortalMenuMaster2.getDisplayCode(),
						stPortalMenuMaster2.getOrder(), stPortalMenuMaster2
								.getLevel(), device, stPortalMenuMaster2
								.getContentType(), stPortalMenuMaster2
								.getParentId(), stPortalMenuMaster2.getStatus());
				stPortalMenuMaster.setCreatedBy(userId);
				stPortalMenuMaster.setCreationTime(currTime);
				stPortalMenuMaster.setLastUpdatedBy(userId);
				stPortalMenuMaster.setLastUpdationTime(currTime);
				session.save(stPortalMenuMaster);
			}

			Criteria criteria = session.createCriteria(StDmDomainAliasNameMaster.class);
			criteria.add(Restrictions.eq("aliasId", aliasId));
			StDmDomainAliasNameMaster aliasMaster = (StDmDomainAliasNameMaster) criteria.list()
					.get(0);
			aliasMaster.setMenuList("SPECIFIC");
			session.update(aliasMaster);

		}
		// contentMaster = (StPortalContentMaster)
		// session.load(StPortalContentMaster.class,
		// menuDataBean.getContentName());
		Criteria menuCrit = session.createCriteria(StPortalMenuMaster.class);
		menuCrit.add(Restrictions.eq("menuId", menuDataBean.getMenuId()));
		ProjectionList proList = Projections.projectionList();
		proList.add(Projections.property("order"));
		proList.add(Projections.property("level"));
		menuCrit.setProjection(proList);
		List<Object[]> list = menuCrit.list();
		Integer order = (Integer) list.get(0)[0];
		Short level = (Short) list.get(0)[1];
		contentMaster = (StPortalContentMaster) session.get(
				StPortalContentMaster.class, menuDataBean.getContentName());

		menuMaster = setMenuBean(session, menuDataBean, domainId, aliasId, device,
				contentMaster, level, order, 0, userId, currTime);

		session.saveOrUpdate(menuMaster);
		int i = 0;
		if (menuDataBean.getSubMenuList() != null) {
			for (MenuDataBean level2 : menuDataBean.getSubMenuList()) {
				contentMaster = (StPortalContentMaster) session.load(
						StPortalContentMaster.class, level2.getContentName());
				menuMaster = setMenuBean(session, level2, domainId, aliasId, device,
						contentMaster, (short) 2, ++i,
						menuDataBean.getMenuId(), userId, currTime);
				session.saveOrUpdate(menuMaster);
				int j = 0;
				level2.setMenuId(menuMaster.getMenuId());
				if (level2.getSubMenuList() != null) {
					for (MenuDataBean level3 : level2.getSubMenuList()) {
						contentMaster = (StPortalContentMaster) session.load(
								StPortalContentMaster.class, level3
										.getContentName());
						menuMaster = setMenuBean(session, level3, domainId,  aliasId,
								device, contentMaster, (short) 3, ++j, level2
										.getMenuId(), userId, currTime);
						session.saveOrUpdate(menuMaster);
					}
				}
			}
		}
	}
	
	private StPortalMenuMaster setMenuBean(Session session,
			MenuDataBean menuDataBean, Short domainId, Short aliasId, String device,
			StPortalContentMaster stPortalContentMaster, Short level,
			Integer order, Integer parentId, long userId, Timestamp currTime) {
		StPortalMenuMaster menuMaster = null;
		if (menuDataBean.getMenuId() != null && menuDataBean.getMenuId() != 0) {
			menuMaster = (StPortalMenuMaster) session.load(
					StPortalMenuMaster.class, menuDataBean.getMenuId());
		} else {
			menuMaster = new StPortalMenuMaster();
			menuMaster.setCreatedBy(userId);
			menuMaster.setCreationTime(currTime);
		}
		menuMaster.setDomainId(domainId);
		menuMaster.setAliasId(aliasId);
		menuMaster.setStPortalContentMaster(stPortalContentMaster);
		menuMaster.setDisplayCode(menuDataBean.getDisplayCode());
		menuMaster.setLevel(level);
		menuMaster.setOrder(order);
		menuMaster.setDevice(device);
		menuMaster.setContentType(menuDataBean.getContentType());
		menuMaster.setParentId(parentId);
		
		if(menuDataBean.getHighLightOpt()==null )
			menuMaster.setHighLightOpt("INACTIVE");
		else 
			menuMaster.setHighLightOpt(menuDataBean.getHighLightOpt());
		
		if (menuDataBean.getStatus() == null)
			menuMaster.setStatus("ACTIVE");
		else
			menuMaster.setStatus(menuDataBean.getStatus());
		menuMaster.setLastUpdatedBy(userId);
		menuMaster.setLastUpdationTime(currTime);
		return menuMaster;
	}

	@SuppressWarnings("unchecked")
	public DomainPropertyBean fetchDomainProperties(Session session,
			Short domainId) throws PMSException {
		DomainPropertyBean domainPropertyBean = null;
		Map<String, LanguageBean> domainLang = null;
		LanguageBean langBean = null;
		try {
			Criteria cri = session.createCriteria(StDmDomainMaster.class);
			cri.add(Restrictions.eq("domainStatus", "ACTIVE"));
			cri.add(Restrictions.eq("domainId", domainId));
			List<StDmDomainMaster> dmList = cri.list();
			StDmDomainMaster master = null;
			if (dmList.size() > 0) {
				master = dmList.get(0);
			} else {
				throw new PMSException("Domain Id not found ==" + domainId);
			}
			domainPropertyBean = new DomainPropertyBean();
			Criteria criteria1 = session.createCriteria(StDmDomainInfo.class);
			criteria1.add(Restrictions.eq("domainId", master.getDomainId()));
			List<StDmDomainInfo> domain = criteria1.list();
			StDmDomainInfo domainInfo = domain.get(0);
			domainPropertyBean.setDepActionPendingWdr(master
					.getDepActionPendingWdr());
			domainPropertyBean.setRolePreference(master.getRolePreference());

			domainPropertyBean.setTermCondition(master.getTermCondition());
			domainPropertyBean.setPrivacyPolicy(master.getPrivacyPolicy());
			domainPropertyBean
					.setSecurityQuesList(master.getSecurityQuesList());
			domainPropertyBean.setReferralList(master.getReferralList());
			domainPropertyBean.setPasswordPolicyId(master
					.getStGenPasswordPolicy().getPasswordPolicyId());
			domainPropertyBean.setDuplicateLogic(master.getDuplicateLogic());
			domainPropertyBean.setGameMapping(master.getGameMapping());
			domainPropertyBean.setServiceId(master.getServiceId());
			domainPropertyBean.setGameTryBeforeLogin(master
					.getGameTryBeforeLogin());
			domainPropertyBean.setDefaultVipLevel(master.getDefaultVipLevel());
			domainPropertyBean
					.setAllowedCountries(master.getAllowedCountries());

			domainPropertyBean.setAllowedStates(master.getAllowedStates());

			domainPropertyBean.setLoginThroughUsername(master
					.getLoginThroughUsername());
			domainPropertyBean.setLoginThroughFconnect(master
					.getLoginThroughFconnect());
			domainPropertyBean.setLoginThroughEmail(master
					.getLoginThroughEmail());
			domainPropertyBean.setLoginThroughMobileNo(master
					.getLoginThroughMobileNo());
			domainPropertyBean.setBlockedEmail(master.getBlockedEmail());
			domainPropertyBean.setBlockedIp(master.getBlockedIp());
			domainPropertyBean.setBlockedPhone(master.getBlockedPhone());

			domainPropertyBean.setLanguageId(master.getLanguageId());
			domainPropertyBean.setLanguageCode(((StGenLanguageMaster) session
					.get(StGenLanguageMaster.class, master.getLanguageId()))
					.getLanguageBaseCode());
			// new variable
			domainPropertyBean.setAllowedfeatureBlockedCountry(master
					.getAllowedfeatureBlockedCountry());
			domainPropertyBean.setPlrPassword(master.getPlayerPassword());//TODO in alias master
			domainPropertyBean.setVerificationThrough(master
					.getVerificationThrough());
			domainPropertyBean.setFirstVerification(master
					.getFirstVerification());
			domainPropertyBean.setSendPassword(master.getSendPassword());
			domainPropertyBean.setPasswordPolicy(master
					.getStGenPasswordPolicy().getPasswordPolicy());
			domainPropertyBean.setPasswordExpression(master
					.getStGenPasswordPolicy().getPasswordExpression());
			domainPropertyBean.setPasswordHelpString(master
					.getStGenPasswordPolicy().getHelpStringCode().toString());
			domainPropertyBean.setPasswordStrengthCheck(master
					.getStGenPasswordPolicy().getPasswordStrengthCheck());
			domainPropertyBean.setRgOperatorLimit(master.getRgOperatorLimit());
			domainPropertyBean.setCheckRg(master.getCheckRg());

			// payment Information
			domainPropertyBean.setPaymentOption(master.getPaymentOption());
			domainPropertyBean.setMerchantProviderAccount(master
					.getMerchantProviderAccount());

			domainPropertyBean.setCurrencyId(master.getCurrencyId());
			domainPropertyBean.setPaymentOptionCurrency(master
					.getPaymentOptionCurrency());
			domainPropertyBean.setTdsOn(master.getTdsOn());
			domainPropertyBean.setBonusUsageOrder(master.getBonusUsageOrder());
			domainPropertyBean
					.setBonusExipryLimit(master.getBonusExipryLimit());
			domainPropertyBean
					.setPlrVisibleWallet(master.getPlrVisibleWallet());

			domainPropertyBean.setDomainName(master.getDomainName());
			domainPropertyBean.setDomainStatus(master.getDomainStatus());
			// domain Info
			domainPropertyBean.setAddress(domainInfo.getAddress());
			domainPropertyBean.setDomainOwner(domainInfo.getOwnerName());
			domainPropertyBean.setCountryCode(domainInfo.getCountryCode());
			domainPropertyBean.setStateCode(domainInfo.getStateCode());
			domainPropertyBean.setContactPersonName(domainInfo
					.getContactPersonName());
			// domainPropertyBean.setEmailId(domainInfo.getEmailId());
			domainPropertyBean
					.setOwnerContactNo(domainInfo.getOwnerContactNo());

			domainPropertyBean
					.setWdrApprovalLimit(master.getWdrApprovalLimit());
			domainPropertyBean.setDepActionPendingWdr(master
					.getDepActionPendingWdr());
			// domainPropertyBean.setAllowedBoIp(master.getAllowedBoIp());
			//domainPropertyBean.setFooter(master.getFooter());
			domainPropertyBean.setVipLevel(master.getVipLevel());
			/*domainPropertyBean.setMenuList(master.getMenuList());
			domainPropertyBean.setContentList(master.getContentList());*/
			domainPropertyBean.setPlayerLedgerFormat(master
					.getPlayerLedgerFormat());
		//	domainPropertyBean.setUrlList(master.getUrlList());
			//domainPropertyBean.setTemplate(master.getTemplate());
			domainPropertyBean.setBonusWrCarryFwd(master.getBonusWrCarryFwd());
			domainPropertyBean.setAllowedInvaildLoginTry(master
					.getAllowedInvaildLoginTry());
			domainPropertyBean.setPlayerPasswordHistoryCount(master
					.getPlayerPasswordHistoryCount());
			domainPropertyBean.setDomainId(master.getDomainId());
			domainPropertyBean.setTpAutoVerification(master
					.gettPAutoVerification());
			domainPropertyBean.setVerificationSourceId(master
					.getVerificationSourceId());
			Criteria crit = session.createCriteria(StCmsTemplateMaster.class);
			crit.add(Restrictions.eq("domainId", master.getDomainId())).add(
					Restrictions.eq("status", "ACTIVE"))
					.add(
							Restrictions.not(Restrictions.eq("templateType",
									"BO_USE")));
			List<StCmsTemplateMaster> lst = crit.list();
			if (lst.size() != 0) {
				Map<String, StCmsTemplateMaster> templeUrl = new HashMap<String, StCmsTemplateMaster>();
				for (StCmsTemplateMaster templateMaster : lst) {
					templeUrl.put(templateMaster.getTemplateType(),
							templateMaster);
				}
				domainPropertyBean.setTempleteUrlMap(templeUrl);
			}
			Criteria langCri = session
					.createCriteria(StDmDomainLanguageMapping.class);
			langCri.add(Restrictions.eq("domainId", master.getDomainId())).add(
					Restrictions.eq("status", "ACTIVE"));
			List<StDmDomainLanguageMapping> langMapping = langCri.list();
			domainLang = new HashMap<String, LanguageBean>();
			for (StDmDomainLanguageMapping temp : langMapping) {
				langBean = new LanguageBean();
				langBean.setLanguageName(temp.getLanguageMaster()
						.getLanguageName());
				langBean.setLanguageBaseCode(temp.getLanguageMaster()
						.getLanguageBaseCode());
				langBean
						.setLanguageId(temp.getLanguageMaster().getLanguageId());
				domainLang.put(temp.getLanguageMaster().getLanguageBaseCode(),
						langBean);
			}
			domainPropertyBean.setAllowedLanguage(domainLang);

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		}
		return domainPropertyBean;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> showCheckListMap(Short domainId, Session session)
			throws PMSException {
		Map<String, String> domainCheckList = new HashMap<String, String>();
		try {
			Criteria cri = null;
			for (DomainPropertyClasses dmProp : DomainPropertyClasses.values()) {
				cri = session.createCriteria(
						Class.forName("com.stpl.pms.hibernate.mapping."
								+ dmProp.name())).add(
						Restrictions.eq("domainId", domainId));
				if (dmProp.getProp1() != null && dmProp.getProp2() != null) {
					cri.add(Restrictions.neProperty(dmProp.getProp1(), dmProp
							.getProp2()));
				}
				cri.setProjection(Projections.property("domainId"));
				List<Short> list = cri.list();
				domainCheckList.put(dmProp.getDisplayValue(),
						list.size() > 0 ? "Done" : "Pending");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Some innternal error.");
		}
		return domainCheckList;

	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> activeReportsList(short domainId, Session session) {
		Map<String, String> activeReportsMap = new HashMap<String, String>();
		Criteria cri = session.createCriteria(StRpBoMisAccountReportMaster.class);
		cri.add(Restrictions.eq("domainId", domainId));
		List<StRpBoMisAccountReportMaster> list = cri.list();
		for (StRpBoMisAccountReportMaster result : list) {
			activeReportsMap.put(result.getReportName(), result.getStatus());
		}
		return activeReportsMap;

	}

	public void activeReportListSave(short domainId,
			Map<String, String> activeMap, Session session) {
		Query qry = session.createQuery("update StRpBoMisReportMaster set status=:status where misReportName=:repName and domainId=:domainId");
		for (String repName : activeMap.keySet()) {
			qry.setParameter("status", activeMap.get(repName));
			qry.setParameter("repName", repName);
			qry.setParameter("domainId", domainId);
			qry.executeUpdate();
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean checkAliasNameAvailability(String aliasName,
			Session session) {
		Criteria criteria = session.createCriteria(StDmDomainAliasNameMaster.class);
		criteria.add(Restrictions.eq("aliasName", aliasName));
		criteria.setProjection(Projections.property("aliasName"));
		List<String> result = criteria.list();
		if (result.size() > 0) {
			return false;
		}
		return true;
	}
	
	public void saveAlias(String aliasName,AliasPropertyBean aliasBean,
			Session session){
		
		StDmDomainMaster dm=(StDmDomainMaster) session.load(StDmDomainMaster.class, aliasBean.getDomainId());
		
		StDmDomainAliasNameMaster dmAlias = new StDmDomainAliasNameMaster();
		dmAlias.setAliasName(aliasName);
		
		dmAlias.setDomainMaster(dm);
		dmAlias.setContentList("SPECIFIC");
		dmAlias.setTemplate("SPECIFIC");
		dmAlias.setPrivateUrl("");
		dmAlias.setPublicUrl("");
		dmAlias.setMerchantProviderAccount("SPECIFIC");
		dmAlias.setMenuList("SPECIFIC");
		dmAlias.setUrlList("SPECIFIC");
		dmAlias.setContentType("JOOMLA");
		dmAlias.setStatus("ACTIVE");
		
		session.save(dmAlias);
		session.flush();
		}
	
	@SuppressWarnings("unchecked")
	public List<StGenSmsEmailProviderMaster> searchSmsEmailProviderOptions(
			short domainId, short aliasId, String providerType,Session session) throws PMSException {
		
		Criteria cri = null;
		cri = session.createCriteria(StGenSmsEmailProviderMaster.class);
		cri.add(Restrictions.eq("domainId", (int)domainId));
		cri.add(Restrictions.eq("aliasId", (int)aliasId));
		cri.add(Restrictions.eq("status", "ACTIVE"));
		cri.add(Restrictions.eq("providerType", providerType));
		cri.addOrder(Order.asc("priorityOrder"));
		List<StGenSmsEmailProviderMaster> list = cri.list();
		StGenSmsEmailProviderMaster emailProviderBean = null;
		List<StGenSmsEmailProviderMaster> emailList = null;
		if (list.size() > 0) {
			emailList = new ArrayList<StGenSmsEmailProviderMaster>();
			for (StGenSmsEmailProviderMaster emailBean : list){
					emailProviderBean = new StGenSmsEmailProviderMaster();
					emailProviderBean.setId(emailBean.getId());
					emailProviderBean.setProviderType(emailBean.getProviderType());
					emailProviderBean.setProviderName(emailBean.getProviderName());
					emailProviderBean.setPriorityOrder(emailBean.getPriorityOrder());
					emailProviderBean.setMeanProcessingTime(emailBean.getMeanProcessingTime());
					emailList.add(emailProviderBean);
			}
		}
		return emailList;
	}
	
	@SuppressWarnings("unchecked")
	public void updateOrder(Map<String, String> emailProviderOrder, UserInfoBean userInfo,
			Session session) {

		Map<Long, Short> orderMap = new HashMap<Long, Short>();
		for (Entry<String, String> pair : emailProviderOrder.entrySet()) {
			orderMap.put(Long.valueOf(pair.getKey()),
					Short.valueOf(pair.getValue()));
		}
		if (orderMap.size() > 0) {
			Criteria cri = session.createCriteria(StGenSmsEmailProviderMaster.class);
			cri.add(Restrictions.in("id", orderMap.keySet()));
			List<StGenSmsEmailProviderMaster> list = cri.list();
			for (StGenSmsEmailProviderMaster emailProviderBean : list) {
				emailProviderBean.setPriorityOrder(orderMap.get(emailProviderBean.getId()));
				session.update(emailProviderBean);
			}
			session.flush();
		}

	}

	@SuppressWarnings("unchecked")
	public List<StDmDomainLocationMaster> fetchLocations(Session session,
			short domainId, String status) {
		Criteria cri = session.createCriteria(StDmDomainLocationMaster.class)
				.add(Restrictions.eq("domainId", domainId));
		if (status != null)
			cri.add(Restrictions.eq("status", status));
		return cri.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<StDmDomainDeviceMaster> fetchDevices(Session session,
			String status,Short aliasId) {
		Criteria cri = session.createCriteria(StDmDomainDeviceMaster.class);
		if (status != null)
			cri.add(Restrictions.eq("status", status));
		cri.add(Property.forName("deviceId").notIn(
				DetachedCriteria.forClass(StDmDomainLocationDeviceMapping.class).
				setProjection(Projections.property("locDevices.deviceId"))
				.add(Restrictions.ne("status", "DELETED"))))
				.add(Restrictions.eq("aliasId", aliasId));
		List<StDmDomainDeviceMaster> l=cri.list();
		return l;
	}
	
	@SuppressWarnings("unchecked")
	public List<StDmDomainDeviceMaster> fetchAllDevices(Session session,Short aliasId,
			String status) {
		Criteria cri = session.createCriteria(StDmDomainDeviceMaster.class).add(Restrictions.eq("aliasId", aliasId));
		if (status != null)
			cri.add(Restrictions.eq("status", status));
		return cri.list();
	}
	
	public void updateLocation(Session session, LocationMaster locMas){
		if(locMas.getLocationId()!=null && locMas.getLocationId()!=0) {
			Query qry = session.createQuery("update StDmDomainLocationMaster set fullName=:fullName, locationName=:locationName," +
					"address=:address, email=:email, mobileNo=:mobileNo, landlineNo=:landlineNo, status=:status where locationId=:locationId");
			qry.setString("fullName", locMas.getFullName());
			qry.setString("locationName", locMas.getLocationName());
			qry.setString("address", locMas.getAddress());
			qry.setString("email", locMas.getEmail());
			qry.setLong("mobileNo", locMas.getMobileNo());
			qry.setLong("landlineNo", locMas.getLandlineNo());
			qry.setString("status", locMas.getStatus());
			qry.setInteger("locationId", locMas.getLocationId());
			qry.executeUpdate();
			if("INACTIVE".equals(locMas.getStatus())){
				qry=session.createQuery("update StDmDomainLocationDeviceMapping set status='INACTIVE' where status !='DELETED' and locMaster.locationId in(:locId)");
				qry.setParameter("locId", locMas.getLocationId());
				qry.executeUpdate();
			}
		} else {
			StDmDomainLocationMaster locMaster = new StDmDomainLocationMaster(locMas.getDomainId(), locMas.getFullName(), locMas.getLocationName(),
					locMas.getAddress(), locMas.getEmail(), locMas.getMobileNo(), locMas.getLandlineNo(), locMas.getStatus());
			session.save(locMaster);
		}
		
	}
	
	public void updLocStatus(Session session, Integer locId[], String status) {
		Query qry = session
				.createQuery("update StDmDomainLocationMaster set status=:status where locationId in(:locId)");
		qry.setParameter("status", status);
		qry.setParameterList("locId", locId);
		qry.executeUpdate();
		if("INACTIVE".equals(status)){
			qry=session.createQuery("update StDmDomainLocationDeviceMapping set status='INACTIVE' where status !='DELETED' and locMaster.locationId in(:locId)");
			qry.setParameterList("locId", locId);
			qry.executeUpdate();
		}
	}
	
	public void updDeviceStatus(Session session, Integer devId[], String status) {
		Query qry = session
				.createQuery("update StDmDomainDeviceMaster set status=:status where deviceId in(:devId)");
		qry.setParameter("status", status);
		qry.setParameterList("devId", devId);
		qry.executeUpdate();
		if("INACTIVE".equals(status)){
			qry=session.createQuery("update StDmDomainLocationDeviceMapping set status='INACTIVE' where status !='DELETED' and locDevices.deviceId in(:devId)");
			qry.setParameterList("devId", devId);
			qry.executeUpdate();
		}
	}
	
	public void updateDevices(Session session, DeviceMasterBean devMas,Short aliasId){
		if(devMas.getDeviceId()!=null && devMas.getDeviceId()!=0) {
			Query qry = session.createQuery("update StDmDomainDeviceMaster set deviceName=:deviceName, deviceType=:deviceType,deviceOs=:deviceOs," +
					"deviceMacAddress=:deviceMacAddress, status=:status ,aliasId=:aliasId where deviceId=:deviceId");
			qry.setString("deviceName", devMas.getDeviceName());
			qry.setString("deviceType", devMas.getDeviceType());
			qry.setString("deviceMacAddress", devMas.getDeviceMacAddress());
			qry.setString("deviceOs", devMas.getDeviceOs());
			qry.setString("status", devMas.getStatus());
			qry.setShort("aliasId", aliasId);
			qry.setInteger("deviceId", devMas.getDeviceId());
			qry.executeUpdate();
			if("INACTIVE".equals(devMas.getStatus())){
				qry=session.createQuery("update StDmDomainLocationDeviceMapping set status='INACTIVE' where status !='DELETED' and locDevices.deviceId =:devId");
				qry.setParameter("devId", devMas.getDeviceId());
				qry.executeUpdate();
			}
		} else {
			StDmDomainDeviceMaster locMaster = new StDmDomainDeviceMaster(devMas.getDeviceName(), devMas.getDeviceType(),
						devMas.getDeviceMacAddress(),devMas.getDeviceOs(), devMas.getStatus(),aliasId);
			session.save(locMaster);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<StDmDomainLocationDeviceMapping> fetchLocDevMapping(Session session, short aliasId){
		Criteria cri =  session.createCriteria(StDmDomainLocationDeviceMapping.class);
		cri.add(Restrictions.eq("aliasId", aliasId));
		cri.add(Restrictions.ne("status","DELETED"));
		return cri.list();
		
	}
	
	public void updDevMapStatus(Session session, Integer devMapId[], String status) {
		
		if("ACTIVE".equals(status)) {
			String ignoreDev=" (select deviceId from StDmDomainDeviceMaster where status !='ACTIVE') " ;
			String ignoreLoc=" (select locationId from StDmDomainLocationMaster where status !='ACTIVE') " ;
			Query qry = session
					.createQuery("update StDmDomainLocationDeviceMapping set status='ACTIVE',lastUpdationTime=:currTime where locMaster.locationId not in ("+ignoreLoc+") and locDevices not in ("+ignoreDev+") and id in(:devMapId)");
			qry.setParameter("currTime", new Timestamp(System.currentTimeMillis()));
			qry.setParameterList("devMapId", devMapId);
			qry.executeUpdate();
		} else{
			Query qry = session
					.createQuery("update StDmDomainLocationDeviceMapping set status=:status,lastUpdationTime=:currTime where  id in(:devMapId)");
			qry.setParameter("currTime", new Timestamp(System.currentTimeMillis()));
			qry.setParameter("status", status);
			qry.setParameterList("devMapId", devMapId);
			qry.executeUpdate();
		}
	}
	
	public void updSaveDevMapping(Session session, LocDevMappingBean locDevMap,  long userId){
		Timestamp currTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		StDmDomainLocationDeviceMapping locDevMapping=null;;
		if(locDevMap.getMappingId()!=null){
			//loading mapping for editing...
			locDevMapping = (StDmDomainLocationDeviceMapping)session.load(StDmDomainLocationDeviceMapping.class, locDevMap.getMappingId());
		}else{
			//creation of new mapping...
			locDevMapping = new StDmDomainLocationDeviceMapping();
			locDevMapping.setCreationTime(currTime);
			locDevMapping.setCreatedBy(userId);
		}
		locDevMapping.setLocMaster((StDmDomainLocationMaster)session.load(StDmDomainLocationMaster.class, locDevMap.getLocMaster().getLocationId()));
		locDevMapping.setLocDevices((StDmDomainDeviceMaster)session.load(StDmDomainDeviceMaster.class, locDevMap.getLocDevices().getDeviceId()));
		locDevMapping.setLastUpdationTime(currTime);
		locDevMapping.setLastUpdatedBy(userId);
		locDevMapping.setStatus(locDevMap.getStatus());
		locDevMapping.setAliasId(locDevMap.getAliasId());
		session.saveOrUpdate(locDevMapping);
	}

	@SuppressWarnings("rawtypes")
	public List checkUniqueMAC(String macAddress,int deviceId, Session session) {
		return session.createCriteria(StDmDomainDeviceMaster.class).add(Restrictions.eq("deviceMacAddress", macAddress)).add(Restrictions.ne("deviceId", deviceId)).list();
	}

	@SuppressWarnings("rawtypes")
	public List checkUniqueDevName(Short aliasId,String deviceName, int deviceId, Session session) {
		return session.createCriteria(StDmDomainDeviceMaster.class)
				.add(Restrictions.eq("deviceName", deviceName))
				.add(Restrictions.eq("aliasId", aliasId))
				.add(Restrictions.ne("deviceId", deviceId)).list();
	}

	@SuppressWarnings("rawtypes")
	public List checkUniqueLocName(String locationName, int locationId,Session session) {
		return session.createCriteria(StDmDomainLocationMaster.class).add(Restrictions.eq("locationName", locationName)).add(Restrictions.ne("locationId", locationId)).list();
	}
}
