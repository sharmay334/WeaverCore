package com.stpl.pms.daoImpl.lm;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.StDmDomainAliasNameMaster;
import com.stpl.pms.hibernate.mapping.StDmDomainMaster;
import com.stpl.pms.hibernate.mapping.StPmPlayerDeviceMapping;
import com.stpl.pms.hibernate.mapping.StPmPlayerLoginDetails;
import com.stpl.pms.hibernate.mapping.StPmPlayerMaster;
import com.stpl.pms.hibernate.mapping.StPmPlrLoginStatus;
import com.stpl.pms.hibernate.mapping.StPmPlrVerificationMaster;
import com.stpl.pms.javabeans.LocationDetailBean;
import com.stpl.pms.javabeans.PlayerMasterAndLoginStatusBean;
import com.stpl.pms.utility.MD5;
import com.stpl.pms.utility.Security;
import com.stpl.pms.utility.location.MaxmindSPI;

public class PortalLoginDaoImpl {
	private static final Logger logger = Logger
			.getLogger(PortalLoginDaoImpl.class);
	
	private final String FACEBOOK = "FACEBOOK";

	public PlayerMasterAndLoginStatusBean authenticatePlayer(String username,
			String password, String loginToken, Short domainId, StDmDomainAliasNameMaster aliasMaster, String device,
			String requestIp, Map<String, String> domainMap, String sessionId, String userAgent, String appVersion,
			Session session) throws PMSException {
		return authenticatePlayer(username, password, loginToken, domainId, aliasMaster, device, requestIp, domainMap,
				sessionId, userAgent, appVersion, false, session,null);
	}
	
	public PlayerMasterAndLoginStatusBean authenticatePlayer(String username,
			String password, String loginToken, Short domainId, StDmDomainAliasNameMaster aliasMaster, String device,
			String requestIp, Map<String, String> domainMap, String sessionId, String userAgent, String appVersion,
			boolean isUSSD, Session session) throws PMSException {
		return authenticatePlayer(username, password, loginToken, domainId, aliasMaster, device, requestIp, domainMap,
				sessionId, userAgent, appVersion, isUSSD, session,null);
	}

	@SuppressWarnings("unchecked")
	public PlayerMasterAndLoginStatusBean authenticatePlayer(String username,
			String password, String loginToken, Short domainId, StDmDomainAliasNameMaster aliasMaster, String device,
			String requestIp, Map<String, String> domainMap, String sessionId, String userAgent,String appVersion,boolean isUSSD,
			Session session,String loginThrough) throws PMSException {
		StPmPlayerMaster plrMaster = null;
		Criteria cri ;
		Object userId = username.trim();
		boolean socialLogin = false;
		PlayerMasterAndLoginStatusBean playerDetailBean = null;
		try {
			if (username.contains("/social")) {
				socialLogin = true;
				userId = username.replace("/social", "");
			}else if(StringUtils.isNotEmpty(loginThrough)){
				if(FACEBOOK.equalsIgnoreCase(loginThrough))
					socialLogin = true;	
			}
			
			if (username != null) {
				String usernameType;

				String loginThroughEmail, loginThroughMobileNo, loginThroughUsername;
				loginThroughEmail = domainMap.get("loginThroughEmail");
				loginThroughMobileNo = domainMap.get("loginThroughMobileNo");
				loginThroughUsername = domainMap.get("loginThroughUsername");
				if (username.contains("@") && "YES".equals(loginThroughEmail)) {
					usernameType = "emailId";
				} else if (Pattern.matches("[\\d]{8,13}", username)
						&& "YES".equals(loginThroughMobileNo)) {
					usernameType = "mobileNo";
					userId = Long.parseLong(userId.toString());
				} else if ("YES".equals(loginThroughUsername)) {
					usernameType = "userName";
				} else {
					throw new PMSException(
							PMSErrorCode.LOGIN_NOT_ALLOWED_FOR_DOMAIN,
							PMSErrorMessage.LOGIN_NOT_ALLOWED_FOR_DOMAIN);
				}
				cri = session.createCriteria(StPmPlayerMaster.class);
				cri.add(Restrictions.eq(usernameType, userId));
				cri.add(Restrictions.eq("domainId", domainId));
				List<StPmPlayerMaster> result = cri.list();

				if (result.size() > 0) {
					plrMaster = (StPmPlayerMaster) result.get(0);

				} else {
					throw new PMSException(PMSErrorCode.INVALID_USER_PWD,
							PMSErrorMessage.INVALID_USER_PWD);
				}
			}
			if (plrMaster != null) {
				String dbPass ="";			
				if(isUSSD){
					try{						
						dbPass="V3CeIag3FS";// Utility.decrypt("encryptedData","Key");						
						if(!StringUtils.isEmpty(password))
							password=Security.decrypt(password, "ABHISHEK_KUMBHAT").split("~")[0];
					}catch (Exception e) {
						e.printStackTrace();
					}
				}else if(FACEBOOK.equalsIgnoreCase(loginThrough)){
					String fbCommonPassword = MD5.encode("SOCIAL_LOGIN");
					dbPass = MD5.encode( fbCommonPassword + loginToken);
				}else{
					dbPass= MD5
						.encode(plrMaster.getPassword() + loginToken);
				}
				
				short invalidLoginTry = plrMaster.getInvalidLoginTry();
				short maxInvalidTry = Short.parseShort(domainMap
						.get("allowedInvaildLoginTry"));
				plrMaster.setLastLoginThrough(device.toUpperCase());



				if (invalidLoginTry < maxInvalidTry || maxInvalidTry == -1) {
					if ((password).equals(dbPass)) {
						if (plrMaster.getPlrStatus().equals("INACTIVE")
								|| plrMaster.getPlrStatus().equals("TERMINATE")) {
							throw new PMSException(PMSErrorCode.INVALID_USER,
									PMSErrorMessage.INVALID_USER);
						} else if ("VERIFICATION_PENDING".equals(plrMaster
								.getPlrStatus())) {
							throw new PMSException(
									PMSErrorCode.VERIFICATION_PENDING,
									PMSErrorMessage.VERIFICATION_PENDING);
						} else {
							if (("10000" + plrMaster.getPlayerId())
									.equals(String.valueOf(plrMaster
											.getMobileNo()))) {
								throw new PMSException(
										PMSErrorCode.DUPLICATE_PLAYER,
										"Your mobile no is found as duplicate with some player."
												+ "Please contact customer support to change your mobile no.");
							} else if (("DUPLICATE_" + plrMaster.getPlayerId())
									.equals(plrMaster.getEmailId())) {
								throw new PMSException(
										PMSErrorCode.DUPLICATE_PLAYER,
										"Your email-id is found as duplicate with some player."
												+ "Please contact customer support to change your email-id.");
							}
						}
						plrMaster.setInvalidLoginTry((short) 0);

						if (!socialLogin
								&& plrMaster.getAutoPassword().equals("Y")) {
/*
 * ------------------commented by kapil ------- bug for email verified if auto password is "Y" in player master table---------
 */
						if("RANDOM".equalsIgnoreCase(domainMap.get("playerPassword"))){			
							if ("EMAIL".equals(domainMap.get("sendPassword")))// Utility.dmPropMap.get(domainId).getSendPassword()))
								plrMaster.setEmailVerified("Y");
							else if ("PHONE".equals(domainMap
									.get("sendPassword")) )
								plrMaster.setPhoneVerified("Y");
							
						}
						CommonMethodDaoImpl comMeDao=CommonMethodDaoImpl.getInstance();
						String forgotPwdCheck = comMeDao.fetchAliasProperty("FORGOT_PWD_RESET",aliasMaster.getAliasId(),session);

							if (!isUSSD) {
								plrMaster.setAutoPassword("N");

								if (forgotPwdCheck != null && "Y".equals(forgotPwdCheck)) {
									throw new PMSException(PMSErrorCode.CHNG_PWD_BEFORE_LOGIN,
											PMSErrorMessage.CHNG_PWD_BEFORE_LOGIN + "_" + plrMaster.getPlayerId());
								}
							}

							session.update(plrMaster);
						
						}
						playerDetailBean = new PlayerMasterAndLoginStatusBean();
						playerDetailBean.setPlayerLoginStatus(logoutPlayer(aliasMaster, session, plrMaster.getPlayerId(), sessionId));
						// Player Login Detail
						StPmPlayerLoginDetails loginDetails = new StPmPlayerLoginDetails();
						loginDetails.setDevice(device.toUpperCase());
						loginDetails.setLoginDate(new java.sql.Timestamp(
								new Date().getTime()));
						loginDetails.setDomainId(domainId);
						loginDetails.setLoginAliasId(aliasMaster.getAliasId());
						loginDetails.setPlayerId(plrMaster.getPlayerId());
						loginDetails.setIpAddress(requestIp);
						loginDetails.setUserAgent(userAgent);
						loginDetails.setStatus("LOG_IN");
						loginDetails.setAppVersion(appVersion);
						LocationDetailBean locationBean = MaxmindSPI.api(aliasMaster.getAliasId())
								.getLocation(requestIp);
						if (locationBean.getCountryCode() == null) {
							loginDetails.setCountryCode("UNKNOWN_COUNTRY");
						} else {
							loginDetails.setCountryCode(locationBean
									.getCountryCode());
						}
						if (locationBean.getCity() == null) {
							loginDetails.setCity("UNKNOWN_CITY");
						} else {
							loginDetails.setCity(locationBean.getCity());
						}
						session.save(loginDetails);
							
						
						} else {
							plrMaster.setInvalidLoginTry(++invalidLoginTry);
							if (invalidLoginTry == maxInvalidTry) {
								plrMaster.setStatus("INVALID_LOGIN_EXCEED");
								throw new PMSException(
										PMSErrorCode.INVALID_LOGIN_BLOCK_SEND_MAIL,
										PMSErrorMessage.INVALID_LOGIN_BLOCK_SEND_MAIL);
							} else {
								throw new PMSException(
										PMSErrorCode.INVALID_USER_PWD,
										PMSErrorMessage.INVALID_USER_PWD);
							}

						}
						
					}
				} else {
					throw new PMSException(PMSErrorCode.INVALID_LOGIN_BLOCK,
							PMSErrorMessage.INVALID_LOGIN_BLOCK);
				}

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
					PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} finally {
			if (plrMaster != null) {
				session.update(plrMaster);
				// session.flush();
			}
		}
		playerDetailBean.setPlayerMaster(plrMaster);
		logger.info(new Timestamp(Calendar.getInstance().getTimeInMillis())
				+ "--PLayer Login End  Dao--"
				+ Calendar.getInstance().getTimeInMillis());
		return playerDetailBean;
	}

	@SuppressWarnings("unchecked")
	public int checkTodayLoginCount(long playerId, short domainId,short aliasId,
			Timestamp curDate, Session session) {
		Criteria cri = session.createCriteria(StPmPlayerLoginDetails.class);
		cri.add(Restrictions.eq("playerId", playerId));
		cri.add(Restrictions.eq("domainId", domainId));
		cri.add(Restrictions.eq("loginAliasId", aliasId));
		cri.add(Restrictions.sqlRestriction("date(login_date)=date('" + curDate
				+ "')"));
		List<StPmPlayerLoginDetails> list = cri.list();
		return list.size();
	}

	@SuppressWarnings("unchecked")
	public StPmPlrLoginStatus fetchLoginStatus(short domainId, long playerId,String sessionId,
			Session session) {
		Criteria criteria = null;
		StPmPlrLoginStatus plrLoginStatus = null;
		criteria = session.createCriteria(StPmPlrLoginStatus.class);
		criteria.add(Restrictions.eq("domainId", domainId));
		criteria.add(Restrictions.eq("playerId", playerId));
		if(sessionId!=null)
			criteria.add(Restrictions.eq("sessionId", sessionId));
		List<StPmPlrLoginStatus> list = criteria.list();
		if (list.size() > 0) {
			plrLoginStatus = list.get(0);
		}
		return plrLoginStatus;
	}
	
/*	public void updateLoginStatus(StPmPlrLoginStatus plrLoginStatus,
			String status, Session session, String deviceType, String device,
			Short aliasId, String fcmIdAndroid, String fcmIdIos) throws Exception {
		plrLoginStatus.setStatus(status);
		if (deviceType != null)
			plrLoginStatus.setAppType(deviceType);
		if (device != null)
			plrLoginStatus.setDevice(device.toUpperCase());

		if((plrLoginStatus.getCurAppVer()!=null && plrLoginStatus.getPropAppVer()!=null&&
				compVersion(plrLoginStatus.getCurAppVer(),plrLoginStatus.getPropAppVer())>=0)
				||(plrLoginStatus.getAppType()!=null && plrLoginStatus.getAppType().equalsIgnoreCase("IOS_APP_CASH"))) {
			plrLoginStatus.setPropAppVer(null);
			plrLoginStatus.setPropAppMandatory(null);
		}
		plrLoginStatus.setLastAliasId(aliasId);
		plrLoginStatus.setLastActivityDate(new Timestamp(System.currentTimeMillis()));
		session.update(plrLoginStatus);
		session.flush();

		if(deviceType != null && fcmIdAndroid != null && deviceType.toUpperCase().contains("ANDROID")) {
			CommunicationProcessController.getInstance().updateCommDeviceInfo(session, new CommonCommBean(plrLoginStatus.getPlayerId(), deviceType, fcmIdAndroid));
		}
		if(deviceType!=null && plrLoginStatus.getDeviceId()!=null && deviceType.toUpperCase().contains("IOS")) {
			CommunicationProcessController.getInstance().updateCommDeviceInfo(session, new CommonCommBean(plrLoginStatus.getPlayerId(), deviceType, plrLoginStatus.getDeviceId()));
		}
	}*/
/*
	public void updateCommDeviceInfo(Session session, Long playerId, String appType, String deviceId) throws PMSException{
		Query query=null;
		try{
			if(appType.toUpperCase().contains("ANDROID")){
				query = session.createQuery("update StCommPlrInfo set gcmId='"+deviceId+"' where playerId="+playerId+"");
			}else if(appType.toUpperCase().contains("IOS")) {
				query = session.createQuery("update StCommPlrInfo set appleId='"+deviceId+"' where playerId="+playerId+"");
			}
			query.executeUpdate();
			session.flush();
		}catch (Exception e){
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.PLR_COMM_INFO_UPDATE,PMSErrorMessage.PLR_COMM_INFO_UPDATE);
		}
	}*/
/*
	public StPmPlrLoginStatus setfirstTimeLoginStatus(Short domainId, Short aliasId, long playerId,
			String requestIp, String sessionId, String device, String appType,
			String currentAppVersion, String deviceId, String imeiNo, String fcmIdAndroid, String fcmIdIos, Session session) throws Exception{
		StPmPlrLoginStatus plrLoginStatus = new StPmPlrLoginStatus();
		plrLoginStatus.setDomainId(domainId);
		plrLoginStatus.setLastAliasId(aliasId);
		plrLoginStatus.setPlayerId(playerId);
		plrLoginStatus.setIpAddress(requestIp);
		plrLoginStatus.setSessionId(sessionId);
		plrLoginStatus.setDevice(device.toUpperCase());
		plrLoginStatus.setStatus("LOGGED_IN");
		plrLoginStatus.setAppType(appType);
		plrLoginStatus.setCurAppVer(currentAppVersion);
		plrLoginStatus.setDeviceId(deviceId);
		plrLoginStatus.setImeiNo(imeiNo);
		plrLoginStatus.setLastActivity("LOGIN");
		plrLoginStatus.setLastActivityDate(new Timestamp(System.currentTimeMillis()));
		session.saveOrUpdate(plrLoginStatus);
		appType = appType.toUpperCase();

		if(appType!=null && fcmIdAndroid != null && appType.contains("ANDROID")) {
			CommunicationProcessController.getInstance().updateCommDeviceInfo(session, new CommonCommBean(plrLoginStatus.getPlayerId(), appType, fcmIdAndroid));
		}

		if(appType != null && fcmIdIos != null && appType.contains("IOS")) {
			CommunicationProcessController.getInstance().updateCommDeviceInfo(session, new CommonCommBean(plrLoginStatus.getPlayerId(), appType, fcmIdIos));
		}

		return plrLoginStatus;

	}
*/
	@SuppressWarnings("unchecked")
	public void updateLastLoginDetail(short domainId, short aliasId, long playerId,
			String status, Session session) {
		Criteria cri = session.createCriteria(StPmPlayerLoginDetails.class);
		cri.add(Restrictions.eq("domainId", domainId));
		cri.add(Restrictions.eq("playerId", playerId));
		cri.add(Restrictions.eq("status", "LOG_IN"));
		cri.setMaxResults(1);
		cri.addOrder(Order.desc("loginDate"));
		List<StPmPlayerLoginDetails> list = cri.list();
		StPmPlayerLoginDetails bean = null;
		if (list.size() > 0) {
			bean = list.get(0);
			bean.setLogoutDate(new Timestamp(System.currentTimeMillis()));
			bean.setLogoutAliasId(aliasId);
			bean.setStatus(status);
			session.update(bean);
		}
	}
	
	public void updatePlrLoginStatusIp(String ip,short domainId,long  playerId,Session session) {		
		
		Query updQry = session.createQuery("update StPmPlrLoginStatus set ipAddress =:ip  where domainId=:domainId and playerId=:playerId and status='LOGGED_IN'");
		updQry.setParameter("ip", ip);
		updQry.setParameter("domainId", domainId);
		updQry.setParameter("playerId", playerId);
		updQry.executeUpdate();		
	}
	
	@SuppressWarnings("unchecked")
	public void linkExpireAfterLogin(long playerId,Session session){
	
		Criteria criteria = session.createCriteria(StPmPlrVerificationMaster.class);
		criteria.add(Restrictions.eq("playerId", playerId));
		List<StPmPlrVerificationMaster> stpmPlrVerificationMasters = criteria.list();
		if(stpmPlrVerificationMasters.size()>0){
			StPmPlrVerificationMaster stPmPlrVerificationMaster = stpmPlrVerificationMasters.get(0);
			if (stPmPlrVerificationMaster.getPasswordVerificationExpiry()!=null &&  new Date().getTime() <= (stPmPlrVerificationMaster
					.getPasswordVerificationExpiry()).getTime()) {
				stPmPlrVerificationMaster
						.setPasswordVerificationExpiry(new java.sql.Timestamp(
								new Date().getTime()));
				session.update(stPmPlrVerificationMaster);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public StPmPlayerLoginDetails getLastLoginDetail(short domainId, long playerId, Session session) {
		Criteria cri = session.createCriteria(StPmPlayerLoginDetails.class);
		StPmPlayerLoginDetails plrLoginDetail=null;
		cri.add(Restrictions.eq("domainId", domainId));
		cri.add(Restrictions.eq("playerId", playerId));		
		cri.setMaxResults(1);
		cri.addOrder(Order.desc("loginDate"));
		List<StPmPlayerLoginDetails> list = cri.list();
		if (list.size() > 0) {
			plrLoginDetail = list.get(0);
		}
		return plrLoginDetail;
	}
	
	
	@SuppressWarnings("unchecked")
	public StPmPlayerLoginDetails fetchLastLoginDate(short domainId, long playerId,
			Session session) {
		Criteria criteria;
		StPmPlayerLoginDetails stPmPlayerLoginDetails = null;
		criteria = session.createCriteria(StPmPlayerLoginDetails.class);
		criteria.add(Restrictions.eq("domainId", domainId));
		criteria.add(Restrictions.eq("playerId", playerId));
		criteria.addOrder(Order.desc("id"));
		List<StPmPlayerLoginDetails> list = criteria.list();
		if (!list.isEmpty()) {
			stPmPlayerLoginDetails = list.get(0);
		}
		return stPmPlayerLoginDetails;
	}
	
	
	@SuppressWarnings("unchecked")
	public StPmPlayerLoginDetails fetchFirstLoginDate(short domainId, long playerId,
			Session session) {
		Criteria criteria = null;
		StPmPlayerLoginDetails stPmPlayerLoginDetails = null;
		criteria = session.createCriteria(StPmPlayerLoginDetails.class);
		criteria.add(Restrictions.eq("domainId", domainId));
		criteria.add(Restrictions.eq("playerId", playerId));
		criteria.addOrder(Order.asc("id"));
		List<StPmPlayerLoginDetails> list = criteria.list();
		if (list.size() > 0) {
			stPmPlayerLoginDetails = list.get(0);
		}
		return stPmPlayerLoginDetails;
	}
	
	@SuppressWarnings("unchecked")
	public void updatePlayerMappingdevice(Long playerId,String imeiNo,String appType,String deviceId ,
			Session session) {
		Criteria criteria = null;
		StPmPlayerDeviceMapping stPmPlayerDeviceMapping=null;
		criteria = session.createCriteria(StPmPlayerDeviceMapping.class);
		criteria.add(Restrictions.eq("playerId", playerId));
		criteria.add(Restrictions.eq("appType", appType));
		List<StPmPlayerDeviceMapping> list = criteria.list();
		if (list.size() == 0) {
			 stPmPlayerDeviceMapping = new StPmPlayerDeviceMapping(playerId,imeiNo,appType,deviceId);
			 			
		}else if(list.size() == 1){
			stPmPlayerDeviceMapping=list.get(0);
			if(stPmPlayerDeviceMapping.getImeiNo()==null || (imeiNo !=null &&  imeiNo.equals(stPmPlayerDeviceMapping.getImeiNo()))){
				stPmPlayerDeviceMapping.setImeiNo(imeiNo);
				stPmPlayerDeviceMapping.setDeviceId(deviceId);
			}else {//if(stPmPlayerDeviceMapping.getImeiNo()!=null && (imeiNo==null)
				stPmPlayerDeviceMapping=new StPmPlayerDeviceMapping(playerId,imeiNo,appType,deviceId); 
			}
			
		}else{
									
			boolean updateFlag=false;
			for (StPmPlayerDeviceMapping stPmPlayerDeviceMapping1 : list) {
				if(updateFlag || (stPmPlayerDeviceMapping1.getImeiNo()==null && imeiNo!=null)){
					stPmPlayerDeviceMapping1.setImeiNo(imeiNo);
					stPmPlayerDeviceMapping1.setDeviceId(deviceId);
					stPmPlayerDeviceMapping=stPmPlayerDeviceMapping1;
					updateFlag=true;			
				}else if(updateFlag || (stPmPlayerDeviceMapping1.getImeiNo()!=null && stPmPlayerDeviceMapping1.getImeiNo().equals(imeiNo))){
					stPmPlayerDeviceMapping1.setDeviceId(deviceId);
					stPmPlayerDeviceMapping=stPmPlayerDeviceMapping1;
					updateFlag=true;			
				}else if(updateFlag || stPmPlayerDeviceMapping1.getImeiNo()==null){
					stPmPlayerDeviceMapping1.setImeiNo(imeiNo);
					stPmPlayerDeviceMapping1.setDeviceId(deviceId);
					stPmPlayerDeviceMapping=stPmPlayerDeviceMapping1;
					updateFlag=true;			
				}
			}
			if(!updateFlag){
				stPmPlayerDeviceMapping=new StPmPlayerDeviceMapping(playerId,imeiNo,appType,deviceId);
			}
		}
		session.saveOrUpdate(stPmPlayerDeviceMapping);	
	}
	
	@SuppressWarnings({ "unchecked"})
	public boolean validatePlrSession(Session session, String username,
			String password, String loginToken, Short domainId) throws PMSException {
		StPmPlayerMaster plrMaster = null;
		Criteria cri = session.createCriteria(StPmPlayerMaster.class);
		cri.add(Restrictions.eq("userName", username));
		cri.add(Restrictions.eq("domainId", domainId));
		List<StPmPlayerMaster> result = cri.list();
		if (result.size() > 0) {
			plrMaster = (StPmPlayerMaster) result.get(0);
			String dbPass = MD5.encode(plrMaster.getPassword() + loginToken);
			if ((password).equals(dbPass)) 
				return true;
		} 
		throw new PMSException(PMSErrorCode.INVALID_USER_PWD,
				PMSErrorMessage.INVALID_USER_PWD);
	}
	
	public StPmPlrLoginStatus logoutPlayer(StDmDomainAliasNameMaster aliasMaster, Session session, Long playerId, String sessionId) throws PMSException{
		try {
			StPmPlrLoginStatus loginStatus  = null;
			StDmDomainMaster domainMaster = aliasMaster.getDomainMaster();
			String multiLoginDomain = domainMaster.getMultipleLogin();
			String multiLoginAlias = aliasMaster.getMultipleLogin();
			String loginMasterQry = "update StPmPlrLoginStatus set status='LOGGED_OUT',lastActivityDate=:lastActivityDate where " +
					"status='LOGGED_IN' and sessionId=:sessionId";
			logoutPlayerSession(sessionId, session, loginMasterQry);
			if("YES".equals(multiLoginDomain) && "NO".equals(multiLoginAlias)){
				String loginMasterQuery = "update StPmPlrLoginStatus set status='LOGGED_OUT', lastAliasId=:lastAliasId, lastActivityDate=:lastActivityDate where " +
						"domainId=:domainId and lastAliasId=:lastAliasId and playerId=:playerId and status='LOGGED_IN'";
				String LoginDetailsQuery = "update StPmPlayerLoginDetails set status='AUTO_LOG_OUT', logoutAliasId=:aliasId, logoutDate=:logoutDate" +
						" where domainId=:domainId and loginAliasId=:aliasId and playerId=:playerId and status='LOG_IN'";
				logoutPlayerSession(domainMaster.getDomainId(), aliasMaster.getAliasId(), session, playerId, loginMasterQuery, LoginDetailsQuery);
				loginStatus =  fetchLoginStatus(domainMaster.getDomainId(),playerId,sessionId, session);
				CommonMethodDaoImpl.plrLastTxnData(session,null, playerId, domainMaster.getDomainId(), 
						aliasMaster.getAliasId(), "LOGOUT", null, new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
			} else if("NO".equals(multiLoginDomain) && "YES".equals(multiLoginAlias)){
				String loginMasterQuery = "update StPmPlrLoginStatus set status='LOGGED_OUT', lastAliasId=:lastAliasId, lastActivityDate=:lastActivityDate where " +
						"domainId=:domainId and lastAliasId!=:lastAliasId and playerId=:playerId and status='LOGGED_IN'";
				String LoginDetailsQuery = "update StPmPlayerLoginDetails set status='AUTO_LOG_OUT', logoutAliasId=:aliasId, logoutDate=:logoutDate" +
						" where domainId=:domainId and loginAliasId!=:aliasId and playerId=:playerId and status='LOG_IN'";
				logoutPlayerSession(domainMaster.getDomainId(), aliasMaster.getAliasId(), session, playerId, loginMasterQuery, LoginDetailsQuery);
				loginStatus =  fetchLoginStatus(domainMaster.getDomainId(),playerId,sessionId, session);
				CommonMethodDaoImpl.plrLastTxnData(session,null, playerId, domainMaster.getDomainId(), 
						aliasMaster.getAliasId(), "LOGOUT", null, new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
			} else if("NO".equals(multiLoginDomain) && "NO".equals(multiLoginAlias)){
				String loginMasterQuery = "update StPmPlrLoginStatus set status='LOGGED_OUT', lastAliasId=:lastAliasId, lastActivityDate=:lastActivityDate where " +
						"domainId=:domainId and playerId=:playerId and status='LOGGED_IN'";
				String LoginDetailsQuery = "update StPmPlayerLoginDetails set status='AUTO_LOG_OUT', logoutAliasId=:aliasId, logoutDate=:logoutDate" +
						" where domainId=:domainId and playerId=:playerId and status='LOG_IN'";
				logoutPlayerSession(domainMaster.getDomainId(), aliasMaster.getAliasId(), session, playerId, loginMasterQuery, LoginDetailsQuery);
				loginStatus =  fetchLoginStatus(domainMaster.getDomainId(),playerId,null, session);
				CommonMethodDaoImpl.plrLastTxnData(session,null, playerId, domainMaster.getDomainId(), 
						aliasMaster.getAliasId(), "LOGOUT", null, new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
			} else if("YES".equals(multiLoginDomain) && "YES".equals(multiLoginAlias)){
				loginStatus =  fetchLoginStatus(domainMaster.getDomainId(),playerId,sessionId, session);
			}
			return loginStatus;
		} catch (Exception e) {
			throw new PMSException();
		}
	}
	
	public void logoutPlayerSession(Short domainId, Short aliasId, Session session, Long playerId, String loginMasterQuery, String LoginDetailsQuery){
		Timestamp currTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		Query qry = session.createQuery(loginMasterQuery);
		qry.setParameter("lastAliasId", aliasId);
		qry.setParameter("lastActivityDate", currTime);
		qry.setParameter("domainId", domainId);
		qry.setParameter("playerId", playerId);
		qry.executeUpdate();
		
		qry = session.createQuery(LoginDetailsQuery);
		qry.setParameter("aliasId", aliasId);
		qry.setParameter("logoutDate", currTime);
		qry.setParameter("domainId", domainId);
		qry.setParameter("playerId", playerId);
		qry.executeUpdate();
	}
	
	public void logoutPlayerSession(String sessionId, Session session, String loginMasterQuery){
		Timestamp currTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		Query qry = session.createQuery(loginMasterQuery);
		qry.setParameter("sessionId", sessionId);
		qry.setParameter("lastActivityDate", currTime);
		qry.executeUpdate();
	}
	
	
	public void logoutPlayerAllSessions(Short domainId, Short aliasId, Session session, Long playerId){
		String loginMasterQuery = "update StPmPlrLoginStatus set status='LOGGED_OUT', lastAliasId=:lastAliasId, lastActivityDate=:lastActivityDate where " +
				" domainId=:domainId and playerId=:playerId and status='LOGGED_IN'";
		String LoginDetailsQuery = "update StPmPlayerLoginDetails set status='AUTO_LOG_OUT', logoutAliasId=:aliasId, logoutDate=:logoutDate" +
				" where  domainId=:domainId and  playerId=:playerId and status='LOG_IN'";
		logoutPlayerSession(domainId, aliasId, session, playerId, loginMasterQuery, LoginDetailsQuery);
		CommonMethodDaoImpl.plrLastTxnData(session,null, playerId, domainId, 
				aliasId, "LOGOUT", null, new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
	}
	
	  
	
	
}