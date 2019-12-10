package com.stpl.pms.controller.lm;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stpl.pms.controller.comm.CommMgmtController;
import com.stpl.pms.controller.comm.CommMgmtSmsController;
import com.stpl.pms.controller.um.UserMgmtController;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.daoImpl.lm.BOLoginDaoImpl;
import com.stpl.pms.daoImpl.rm.RoleMgmtDaoImpl;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.javabeans.LoginBean;
import com.stpl.pms.javabeans.UserDetailsBean;
import com.stpl.pms.javabeans.UserInfoBean;

public class BOLoginController {

	private static final Logger log = Logger.getLogger(BOLoginController.class);

	public String changePassword(UserInfoBean userBean, String oldPass, String newPass, String ipAddress)
			throws PMSException {
		String returnString = null;
		log.info("Change Password Start");
		Session session = null;
		Transaction tx = null;
		BOLoginDaoImpl daoImpl = new BOLoginDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Short passHistory = Short.valueOf(CommonMethodDaoImpl.getInstance()
					.fetchSystemProperties("BO_PASSWORD_HISTORY_COUNT", session).toString());
			returnString = daoImpl.changePassword(userBean, oldPass, newPass, ipAddress, passHistory, session);
			tx.commit();
		} catch (HibernateException se) {
			se.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		log.info("Change Password Start");
		return returnString;
	}

	public boolean verifyPasswordChars(String newPassword) {
		boolean isUpperThr = false;
		boolean isLowerThr = false;
		boolean isDigitThr = false;
		boolean isSpecialChar = false;
		char[] passArr = newPassword.toCharArray();
		for(int i=0;i<passArr.length;i++){
			if(Character.isUpperCase(passArr[i])){
				isUpperThr = true;
			}
			if(Character.isLowerCase(passArr[i])){
				isLowerThr = true;
			}
			if(Character.isDigit(passArr[i])){
				isDigitThr = true;
			}
			if(!Character.isLetterOrDigit(passArr[i]) && 
					!Character.isSpaceChar(passArr[i])){
				isSpecialChar = true;
			}
		}
		return (isUpperThr && isLowerThr & isDigitThr & isSpecialChar);
	}

	public String forgotPassword(String email) throws PMSException {
		log.info("Forgot Password Start");
		String returnString = null;
		Session session = null;
		Transaction tx = null;
		BOLoginDaoImpl daoImpl = new BOLoginDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			UserDetailsBean usrdetBean = new UserDetailsBean(); 
			UserMgmtController userMgmtController = new UserMgmtController();
			//today i have to fetch user detail bean for line no 97 as a parameter for sms service forgot password
			tx = session.beginTransaction();
			returnString = daoImpl.forgotPassword(email, session);
			
			if (!returnString.equals("emailId_not_registered")) {
				Map<String, String> emailContentMap = new LinkedHashMap<String, String>();
				emailContentMap.put("EmailId", email);
				emailContentMap.put("UserName", returnString.split("_")[0]);
				emailContentMap.put("ActivationCode", returnString.split("_")[1]);
				CommMgmtController.callSendMail(emailContentMap, "BO_FORGOT_PASSWORD",
						Short.valueOf(returnString.split("_")[2]), (short) 1, 0, session);
				usrdetBean = userMgmtController.getUserInfoBeanPhone(email,usrdetBean);
				usrdetBean.setUserName(returnString.split("_")[0]);
				CommMgmtController.callSendSms(usrdetBean,"BO_FORGOT_PASSWORD_SMS",session,emailContentMap);
			}
			tx.commit();
		} catch (HibernateException se) {
			se.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		log.info("Forgot Password End");
		return returnString;
	}

	public LoginBean loginAuthentication(String userName, String password, String loginToken, String interfaceType,
			String ipAddress, String sessionId, short domainId) throws PMSException {

		LoginBean loginBean = null;
		Session session = null;
		Transaction tx = null;
		BOLoginDaoImpl loginMgmtDao = new BOLoginDaoImpl();
		RoleMgmtDaoImpl roleMgmtDao = new RoleMgmtDaoImpl();
		try {
			// first logout all users which login with current sessionId
			logoutUser(sessionId);
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String logintry = CommonMethodDaoImpl.getInstance().fetchSystemProperties("BO_INVAILD_PASS_TRY", session);
			loginBean = loginMgmtDao.loginAuthentication(userName, password, loginToken, interfaceType, ipAddress,
					sessionId, domainId, logintry, session);
			tx.commit();
			session.flush();
			if(loginBean.getStatus().equals("FirstTime") || loginBean.getStatus().equals("success")) {
				roleMgmtDao.inactiveUserPriv(session,loginBean);
			}
			
			if (!(loginBean.getStatus().equals("success") || loginBean.getStatus().equals("FirstTime"))) {
				
				roleMgmtDao.inactiveUserPriv(session,loginBean);
				return loginBean;
			}

			roleMgmtDao.fetchActivePriv(interfaceType, loginBean.getUserInfo().getUserId(),
					loginBean.getUserInfo().getRoleId(), loginBean, loginBean.getUserInfo().getUserType(),
					loginBean.getUserInfo().getDomainId(), session);

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Some Internal error");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
			/*
			 * if(loginBean.getOldSessionId()!=null &&
			 * !loginBean.getOldSessionId().equals(sessionId)){ //Logout User
			 * Which login with oldSessionId
			 * logoutUser(loginBean.getOldSessionId()); }
			 */
		}
		return loginBean;
	}

	public void logoutUser(String sessionId) {
		Session session = null;
		Transaction tx = null;
		BOLoginDaoImpl loginMgmtDao = new BOLoginDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			loginMgmtDao.logoutUser(sessionId, session);
			tx.commit();
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			// throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
}
