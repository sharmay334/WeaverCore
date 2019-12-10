package com.stpl.pms.controller.um;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.controller.comm.CommMgmtController;
import com.stpl.pms.controller.comm.CommMgmtEmailController;
import com.stpl.pms.controller.gm.GameMgmtController;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.daoImpl.um.UserMgmtDaoImpl;
import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.StRmBoUserInfo;
import com.stpl.pms.hibernate.mapping.StRmBoUserMaster;
import com.stpl.pms.javabeans.UserDetailsBean;
import com.stpl.pms.javabeans.UserInfoBean;
import com.stpl.pms.javabeans.UserPrivBean;
import com.stpl.pms.security.ZipFileProtection;

public class UserMgmtController {

	public String createBoUser(UserInfoBean userInfoBean, String userName, String status, String secQues, String secAns,
			String firstName, String lastName, String gender, String email, String phone, String roleIdStr,
			String ipAddress) throws PMSException {
		Session session = null;
		Transaction tx = null;
		try {
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String res = "";
			// if (privFunctionBean.getFunctionSet().contains("createBoUser")) {
			res = daoImpl.createBoUser(userInfoBean, userName, status, secQues, secAns, firstName, lastName, gender,
					email, phone, roleIdStr, ipAddress, session, userInfoBean.getDomainId(),
					userInfoBean.getUserType());
			if (!res.equalsIgnoreCase("USER_ALREADY_EXIST") && !res.equalsIgnoreCase("WRONG_ROLE_ID")) {
				// send mail to user String msgFor =
				Map<String, String> emailContentMap = new LinkedHashMap<String, String>();
				emailContentMap.put("EmailId", email);
				emailContentMap.put("FirstName", firstName);
				emailContentMap.put("UserName", userName);
				emailContentMap.put("UserPassword", res);
				CommMgmtController.callSendMail(emailContentMap, "BO_USER_REGISTRATION", userInfoBean.getDomainId(),
						(short) 1, userInfoBean.getUserId(), session);
				// commMgmtController.sendMailBO(email,emailMsgTxt);
				res = "success";
				// }
			}
			if (res.equalsIgnoreCase("success")) {
				tx.commit();
				// Sent Mail
				return "SUCCESS";
			} else if (res.equalsIgnoreCase("USER_ALREADY_EXIST")) {
				return "USER_ALREADY_EXIST";
			} else {
				return "INPUT";
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Some Internal Error!");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public boolean checkUsernameAvailability(String userName, Short domainId) throws PMSException {
		Session session = null;
		UserMgmtDaoImpl dao;
		try {
			session = HibernateSessionFactory.getSession();
			dao = new UserMgmtDaoImpl();
			return dao.checkUsernameAvailability(userName, domainId, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR, PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public boolean checkUserEmailIdAvailability(String emailId, Short domainId) throws PMSException {
		Session session = null;
		UserMgmtDaoImpl dao;
		try {
			session = HibernateSessionFactory.getSession();
			dao = new UserMgmtDaoImpl();
			return dao.checkUserEmailIdAvailability(emailId, domainId, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR, PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public boolean checkUserEmailIdAvailabilityForDomain(String emailId, Short domainId, int userId)
			throws PMSException {
		Session session = null;
		UserMgmtDaoImpl dao;
		try {
			session = HibernateSessionFactory.getSession();
			dao = new UserMgmtDaoImpl();
			return dao.checkUserEmailIdAvailabilityForDomain(emailId, domainId, userId, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR, PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
    public void sendSmsService(String smsType,UserDetailsBean usrdetBean,String gameName,int gameNo,int batchNo){
    	try{
    		Session session = HibernateSessionFactory.getSession();
    		Map<String,String> smscontentMap = new HashMap<>();
    		
    		smscontentMap.put("FirstName", usrdetBean.getFirstName());
    		smscontentMap.put("GameName", gameName);
    		smscontentMap.put("GameNo", String.valueOf(gameNo));
    		smscontentMap.put("BatchNo", String.valueOf(batchNo));
    		smscontentMap.put("UserName", usrdetBean.getUserName());
    		smscontentMap.put("Passcode", ZipFileProtection.ZIP_LOGIN_PASSWORD);
    		
    		
    		
    		CommMgmtController.callSendSms(usrdetBean,smsType,session,smscontentMap);
    	}catch(Exception e){e.printStackTrace();}
    }
    public void sendSmsServiceBO(String smsType,UserDetailsBean usrdetBean,String gameName,int gameNo,int batchNo,String username,String firstName){
    	try{
    		Session session = HibernateSessionFactory.getSession();
    		Map<String,String> smscontentMap = new HashMap<>();
    		
    		smscontentMap.put("FirstName", firstName);
    		smscontentMap.put("GameName", gameName);
    		smscontentMap.put("GameNo", String.valueOf(gameNo));
    		smscontentMap.put("BatchNo", String.valueOf(batchNo));
    		smscontentMap.put("UserName", username);
    		if(ZipFileProtection.ZIP_LOGIN_PASSWORD!=null){
    			smscontentMap.put("Passcode", ZipFileProtection.ZIP_LOGIN_PASSWORD.substring(4));  
    		}
    		 		
    		CommMgmtController.callSendSms(usrdetBean,smsType,session,smscontentMap);
    		
    	}catch(Exception e){e.printStackTrace();}
    }
	public String assignGroups(int creatorUserId, String[] rolePriv, short creatorRoleId, UserDetailsBean usrdetBean,
			int[] mappingId, int[] privCount, String ipAddress, short domainId) throws PMSException {
		String password = null;
		Session session = null;
		Transaction tx = null;
		UserDetailsBean TempuserdetailBean = new UserDetailsBean();
		try {
			GameMgmtController gameMgmtController = new GameMgmtController();
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			// if (privFunctionBean.getFunctionSet().contains("assignGroups")) {
			password = daoImpl.assignGroups(creatorUserId, rolePriv, creatorRoleId, usrdetBean, mappingId, privCount,
					ipAddress, domainId, session);
 			if (!password.equalsIgnoreCase("USER_ALREADY_EXIST")) {
 				tx.commit();
				Map<String, String> emailContentMap = new LinkedHashMap<String, String>();
				Map<String, String> tempEmailContentMap = new LinkedHashMap<String, String>();
				emailContentMap.put("EmailId", usrdetBean.getEmailId());
				emailContentMap.put("FirstName", usrdetBean.getFirstName());
				emailContentMap.put("UserName", usrdetBean.getUserName());
				emailContentMap.put("UserPassword", password);
				emailContentMap.put("ScratchUrl", "www.scratchweaver.com");
				//CommMgmtController.callSendSms(usrdetBean,"BO_USER_REGISTRATION",session,emailContentMap);
				
				TempuserdetailBean = gameMgmtController.getParentUserData(usrdetBean.getUserName(),usrdetBean);
				tempEmailContentMap.put("EmailId", TempuserdetailBean.getEmailId());
				tempEmailContentMap.put("FirstName", usrdetBean.getFirstName());
				tempEmailContentMap.put("UserName", usrdetBean.getUserName());
				tempEmailContentMap.put("UserPassword", password);
				tempEmailContentMap.put("ScratchUrl", "www.scratchweaver.com");
				System.out.println("PASSWORD IS:::::::::::::::"+password);
				
				/*
				 * CommMgmtController.callSendMail(emailContentMap, "BO_USER_REGISTRATION",
				 * domainId, (short) 1, creatorUserId, session);
				 * CommMgmtController.callSendMail(tempEmailContentMap, "BO_USER_REG_EMAIL",
				 * domainId, (short) 1, creatorUserId, session);
				 */
				
				//CommMgmtController.callSendSms(TempuserdetailBean,"BO_USER_REG_SMS",session,emailContentMap);
				
				// CommMgmtController commMgmtController = new
				// CommMgmtController();
				// commMgmtController.sendMailBO(usrdetBean.getEmailId(),emailMsgTxt);

			}
			// }
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("ClassCast Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return password;
	}

	public List<String> fetchSubUserName(int roleId, int userId) throws PMSException {
		List<String> userList = null;
		Session session = null;
		try {
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			// if
			// (privFunctionBean.getFunctionSet().contains("fetchSubUserName"))
			// {
			userList = daoImpl.fetchSubUserName(roleId, userId, session);
			// }
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return userList;
	}

	public Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> getSubUserPriviledges(
			String userName, int parentUserId, String tierType, Short domainId) throws PMSException {

		Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> headPriviledgeMap = null;
		Session session = null;
		try {
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			// if (privFunctionBean.getFunctionSet().contains(
			// "getSubUserPriviledges")) {
			headPriviledgeMap = daoImpl.getSubUserPriviledges(userName, parentUserId, tierType, domainId, session);
			// }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PMSException("ClassCast Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return headPriviledgeMap;
	}

	public void editSubUserPriviledges(String userName, String[] rolePriv, int[] mappingId, int[] privCount)
			throws PMSException {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			daoImpl.editSubUserPriviledges(userName, rolePriv, mappingId, privCount, session);
			tx.commit();
		} catch (ClassNotFoundException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw new PMSException("ClassCast Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public List<UserDetailsBean> searchBoUsers(String userName, int roleId, String type, String status,
			UserInfoBean parentUserBean) throws PMSException {
		Session session = null;
		List<UserDetailsBean> userList = null;
		try {
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			// if (privFunctionBean.getFunctionSet().contains("searchBoUsers"))
			// {
			userList = daoImpl.searchBoUsers(userName, roleId, type, status, parentUserBean, session);
			// }
			return userList;

		} catch (HibernateException se) {
			se.printStackTrace();
			throw new PMSException("Hibernate Exeption");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public UserDetailsBean showBOUserDetails(int userId, String type) throws PMSException {
		UserDetailsBean userBean = null;
		Session session = null;
		try {
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			// if
			// (privFunctionBean.getFunctionSet().contains("showBOUserDetails"))
			// {
			userBean = daoImpl.showBOUserDetails(userId, type, session);
			// }
		} catch (HibernateException se) {
			se.printStackTrace();
			throw new PMSException("Hibernate Exeption");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return userBean;
	}

	public void resetPassBO(int userId, String autoPass, String emailId, String userName, String firstName,
			String lastName) throws PMSException {
		Session session = null;
		Transaction tx = null;
		try {

			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			// if (privFunctionBean.getFunctionSet().contains("resetPassBO")) {
			String password = daoImpl.resetPassBO(userId, autoPass, emailId, userName, firstName, lastName, session);

			Map<String, String> emailContentMap = new LinkedHashMap<String, String>();
			emailContentMap.put("EmailId", emailId);
			emailContentMap.put("FirstName", firstName);
			emailContentMap.put("UserName", userName);
			emailContentMap.put("UserPassword", password);
			Short domainId = 1;
			CommMgmtController.callSendMail(emailContentMap, "BO_USER_REGISTRATION", domainId, (short) 1, userId,
					session);
			// CommMgmtController commMgmtController = new
			// CommMgmtController();
			// commMgmtController.sendMailBO(emailId,emailMsgTxt);

			// }
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
	
	public void editBOUserDetails(int userId, String emailId, String phoneNbr,String lastName,String status, String type,Double val)
			throws PMSException {
		Session session = null;
		Transaction tx = null;
		try {
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			daoImpl.editBOUserDetails(userId, emailId, phoneNbr,lastName, status, type, session);
			tx.commit();
			String msgFor = "You are block for our BackOffice,Contact to Admin.";
			try {
				if ("INACTIVE".equals(status) || "TERMINATE".equals(status) || "downloadCase".equalsIgnoreCase(status))
					CommMgmtController.boMailSending(emailId, msgFor, (short) 1, (short) 1, session);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
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

	public void editBOUserDetails(int userId, String emailId, String phoneNbr, String status, String type)
			throws PMSException {
		Session session = null;
		Transaction tx = null;
		try {
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			daoImpl.editBOUserDetails(userId, emailId, phoneNbr, status, type, session);
			tx.commit();
			String msgFor = "You are block for our BackOffice,Contact to Admin.";
			try {
				if ("INACTIVE".equals(status) || "TERMINATE".equals(status) || "downloadCase".equalsIgnoreCase(status))
					CommMgmtController.boMailSending(emailId, msgFor, (short) 1, (short) 1, session);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
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
	
	public void editBOUserDetails(int userId, String emailId, String phoneNbr, String status, String type,String emailType)
			throws PMSException {
		Session session = null;
		Transaction tx = null;
		try {
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			//daoImpl.editBOUserDetails(userId, emailId, phoneNbr, status, type, session);
			tx.commit();
			String msgFor = "You are block for our BackOffice,Contact to Admin.";
			try {
				if ("INACTIVE".equals(status) || "TERMINATE".equals(status) || "downloadCase".equalsIgnoreCase(status))
					CommMgmtController.boMailSending(emailId, msgFor, (short) 1, (short) 1, session,emailType);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
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
	
	public void sendMailITGS(Map<String,String> emailContentMap,String emailType,UserInfoBean userInfoBean){
		try{
			CommMgmtEmailController.sendMail(emailContentMap,emailType,userInfoBean);  
		}catch(Exception e){e.printStackTrace();}
	}
	
	public void editBOUserDetails(int userId, String emailId, String phoneNbr, String status, String gameName,String emailType,UserInfoBean userInfoBean,int gameNo,int batchNO,String mailMsg,String userEmail)
			throws PMSException {
		Session session = null;
		Transaction tx = null;
		try {
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			//daoImpl.editBOUserDetails(userId, emailId, phoneNbr, status, type, session);
			tx.commit();
			String msgFor = "You are block for our BackOffice,Contact to Admin.";
			try {
				if ("INACTIVE".equals(status) || "TERMINATE".equals(status) || "useractivity".equalsIgnoreCase(status))
					CommMgmtController.boMailSending(emailId, msgFor, (short) 1, (short) 1, session,emailType,userInfoBean,gameNo,batchNO,mailMsg,userEmail);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
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
	public void editBOUserDetails(int userId, String emailId, String phoneNbr, String status, String type,String emailType,UserInfoBean userInfoBean)
			throws PMSException {
		Session session = null;
		Transaction tx = null;
		try {
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			//daoImpl.editBOUserDetails(userId, emailId, phoneNbr, status, type, session);
			tx.commit();
			String msgFor = "You are block for our BackOffice,Contact to Admin.";
			try {
				if ("INACTIVE".equals(status) || "TERMINATE".equals(status) || "printCase".equalsIgnoreCase(status))
					CommMgmtController.boMailSending(emailId, msgFor, (short) 1, (short) 1, session,emailType,userInfoBean);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
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

	public String getUserNameById(Integer userId) throws PMSException {
		Session session = null;
		String userName;
		try {
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			userName = daoImpl.getUserNameById(session, userId);
		} catch (HibernateException se) {
			se.printStackTrace();
			throw new PMSException("Hibernate Exeption");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return userName;

	}

	public Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> getDomainPriviledges(
			String tierType) throws PMSException {

		Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> headPriviledgeMap = null;
		Session session = null;
		try {

			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			headPriviledgeMap = daoImpl.getDomainPriviledges(tierType, session);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PMSException("ClassCast Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return headPriviledgeMap;
	}

	public boolean checkRummyServiceAvailable(String tierType) throws PMSException {

		boolean rummyServiceAvailable = false;
		Session session = null;
		try {

			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();

			rummyServiceAvailable = daoImpl.checkRummyServiceAvailable(tierType, session);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return rummyServiceAvailable;
	}

	public List<String> fetchDomainUserName(int roleId, int userId) throws PMSException {
		List<String> userList = null;
		Session session = null;
		try {
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			userList = daoImpl.fetchDomainUserName(roleId, userId, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return userList;
	}

	public Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> getDomainUserPriviledges(
			String userName, String tierType) throws PMSException {

		Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> headPriviledgeMap = null;
		Session session = null;
		try {
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			headPriviledgeMap = daoImpl.getDomainUserPriviledges(userName, tierType, session);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PMSException("ClassCast Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return headPriviledgeMap;
	}

	public void editDomainUserPriviledges(String userName, String[] rolePriv, int[] mappingId, int[] privCount,
			String rolePrivRUMMY[]) throws PMSException {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			UserMgmtDaoImpl daoImpl = new UserMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			daoImpl.editDomainUserPriviledges(userName, rolePriv, mappingId, privCount, rolePrivRUMMY, session);
			tx.commit();
		} catch (ClassNotFoundException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw new PMSException("ClassCast Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Map<Integer, String> getBoUserMap(Integer selfId) {
		Session session;
		try {
			session = HibernateSessionFactory.getSession();
			return new UserMgmtDaoImpl().getBoUserMap(selfId, session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserInfoBean getImpersonatee(String sessionId, Integer impersonateeId) throws PMSException {
		Session session = null;
		UserInfoBean impersonatee;
		try {
			session = HibernateSessionFactory.getSession();
			CommonMethodDaoImpl.getInstance().checkBoUserLogin(sessionId, session, false);
			impersonatee = new UserMgmtDaoImpl().getInpersonatedBean(impersonateeId, session);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return impersonatee;
	}

	public List<String> fetchRoleHeadUsers(int userId) {
		// TODO Auto-generated method stub
		try
		{
			List<String> usersList = new ArrayList<>();
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
			criteria.add(Restrictions.eq("parentUserId",userId));
			List<StRmBoUserMaster> result = criteria.list();
			
			if(result!=null)
			{
				for(StRmBoUserMaster obj:result)
				{
					usersList.add(obj.getUserName());
				}
				
			}
			return usersList;
			
			
		}catch(Exception e){e.printStackTrace();}
		return null;
	}
	public List<StRmBoUserInfo> getUserInformation(int userId)
	{
		try
		{
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmBoUserInfo.class);
			criteria.add(Restrictions.eq("userId",userId));
			List<StRmBoUserInfo> result = criteria.list(); 
			return result;
		}catch(Exception e){e.printStackTrace();}
		return null;
		
	}

	public String getUserMailId(int userId) {
		// TODO Auto-generated method stub
		try{
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmBoUserInfo.class);
			criteria.add(Restrictions.eq("userId", userId));
			List<StRmBoUserInfo> result = criteria.list();
			if(result!=null){
				for(StRmBoUserInfo obj:result){
					return obj.getEmailId();
				}
			}
		}catch(Exception e){e.printStackTrace();}
		return null;
	}

	public String getUserFirstName(int userId) {
		// TODO Auto-generated method stub
		try{
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmBoUserInfo.class);
			criteria.add(Restrictions.eq("userId", userId));
			List<StRmBoUserInfo> result = criteria.list();
			if(result!=null){
				for(StRmBoUserInfo obj : result)
					return obj.getFirstName();
			}
			
		}catch(Exception e){e.printStackTrace();}
		return null;
	}

	public UserDetailsBean getUserInfoBeanPhone(String userEmail,UserDetailsBean userDetailsBean) {
		// TODO Auto-generated method stub
		try{
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmBoUserInfo.class);
			criteria.add(Restrictions.eq("emailId", userEmail));
			List<StRmBoUserInfo> result = criteria.list();
			if(result!=null){
				for(StRmBoUserInfo obj:result){
					userDetailsBean.setPhoneNbr(obj.getPhoneNum());
					userDetailsBean.setEmailId(obj.getEmailId());
					userDetailsBean.setFirstName(obj.getFirstName());
					
					
				}
				return userDetailsBean;
			}
		}catch(Exception e){e.printStackTrace();}
		return null;
	}
}
