package com.stpl.pms.controller.rm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stpl.pms.controller.commonMethods.CommonMethodController;
import com.stpl.pms.daoImpl.rm.RoleMgmtDaoImpl;
import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.javabeans.DefPrivBean;
import com.stpl.pms.javabeans.DefPrivTemp1;
import com.stpl.pms.javabeans.LoginBean;
import com.stpl.pms.javabeans.PrivFunctionBean;
import com.stpl.pms.javabeans.PrivilegeManagementBean;
import com.stpl.pms.javabeans.UserInfoBean;
import com.stpl.pms.javabeans.UserPrivBean;

public class RoleMgmtController {
	public LoginBean fetchActivePriv(String interfaceType, UserInfoBean userInfoBean) throws PMSException {
		RoleMgmtDaoImpl daoImpl = new RoleMgmtDaoImpl();
		Session session = null;
		LoginBean loginBean = new LoginBean();
		try {
			session = HibernateSessionFactory.getSession();
			daoImpl.fetchActivePriv(interfaceType, userInfoBean.getUserId(),
					userInfoBean.getRoleId(), loginBean, userInfoBean
					.getUserType(),userInfoBean.getDomainId(), session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return loginBean;
	}

	public void managePriv(String privOwner) throws PMSException {
		RoleMgmtDaoImpl daoImpl = new RoleMgmtDaoImpl();
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			daoImpl.manageRolePrivilege(privOwner, session);
			session.flush();
			daoImpl.manageUserPrivilege(privOwner, session);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("ClassCast Exeption");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<String>>>>> getHeadsGroupNames(
			int userId, int roleId, String userType,Short domainId) throws PMSException {

		Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<String>>>>> headPriviledgeMap = null;
		Session session = null;
		try {
			RoleMgmtDaoImpl daoImpl = new RoleMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
				headPriviledgeMap = daoImpl.getHeadsGroupNames(userId, roleId,
						session, userType,domainId);
			return headPriviledgeMap;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PMSException("ClassCast Exeption");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public String createRole(String roleName, String roleDesc, String userType,
			String[] rolePriv, int[] mappingId, int[] privCount,
			int creatorRoleId, int userId)
			throws PMSException {
		Transaction tx = null;
		Session session = null;
		try {
			RoleMgmtDaoImpl daoImpl = new RoleMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String res = "ERROR";
			Map<Integer, String> privMap1 = new HashMap<Integer, String>();
			int roleId = 0;
			Map<Integer, Map<Integer, String>> map = new HashMap<Integer, Map<Integer, String>>();
			map = daoImpl.createRoleInactive(roleName, roleDesc, userType,
					rolePriv, mappingId, privCount, creatorRoleId, userId,
					session);

			for (Integer i : map.keySet()) {
				// log.info(i);
				roleId = i;
				privMap1 = map.get(i);
			}
			tx.commit();
			if (null != rolePriv) {
				tx = session.beginTransaction();
				res = daoImpl.createRoleActive(roleName, roleDesc,
						userType, rolePriv, mappingId, privCount,
						creatorRoleId, userId, session, privMap1, roleId);
			}
			if (res.equals("success")) {
				tx.commit();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("ClassCast Exeption");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return "success";
	}

	public Map<Integer, String> fetchRoles(int roleId, String roleName,
			int userId) throws PMSException {
		Map<Integer, String> roleMap = null;
		Session session = null;
		try {
			RoleMgmtDaoImpl daoImpl = new RoleMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			roleMap = daoImpl.fetchRoles(roleId, roleName, userId, session);
			return roleMap;
		} catch (HibernateException e) {
			throw new PMSException("Hibernate Exeption");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> fetchRolePriv(
			int roleId, String userType, int userId,
			int creatorRoleId,Short domainId) throws PMSException {

		Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> headPriviledgeMap = null;
		Session session = null;
		Transaction tx = null;
		try {
			RoleMgmtDaoImpl daoImpl = new RoleMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			headPriviledgeMap = daoImpl.fetchRolePriv(roleId, userType,
						userId,creatorRoleId,domainId, session);
			tx.commit();
			return headPriviledgeMap;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("ClassCast Exeption");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void editRolePriv(int roleId, String[] rolePriv, int[] mappingId,
			int[] privCount, int creatorRoleId, String userType) throws PMSException {

		Session session = null;
		Transaction tx = null;

		try {
			RoleMgmtDaoImpl daoImpl = new RoleMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
				daoImpl.editRolePriv(roleId, rolePriv, mappingId, privCount,
						creatorRoleId, userType, session);
			CommonMethodController.getInstance().invalidateCache("StRmBoRoleMasterCache");	
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("ClassCast Exeption");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void fetchDefaultPriv(String interfaceType, DefPrivBean defPrivBean,
			String userType, PrivFunctionBean privFunctionBean)
			throws PMSException {
		LinkedHashMap<String, DefPrivTemp1> serPrivMap = null;
		Session session = null;
		try {
			RoleMgmtDaoImpl daoImpl = new RoleMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			if (privFunctionBean.getFunctionSet().contains("fetchDefaultPriv")) {
				serPrivMap = daoImpl.fetchDefaultPriv(interfaceType,
						defPrivBean, userType, session);
			}
			defPrivBean.setActionServiceMap(serPrivMap);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	// public HashMap<String, String> fetchSeviceDisplayName(PrivFunctionBean
	// privFunctionBean) throws PMSException {
	// HashMap<String, String> serNameMap = null;
	// Session session = null;
	// try {
	// RoleMgmtDaoImpl daoImpl = new RoleMgmtDaoImpl();
	// session = HibernateSessionFactory.getSession();
	//			
	// if (privFunctionBean.getFunctionSet().contains("fetchSeviceDisplayName"))
	// {
	//				
	// serNameMap = daoImpl.fetchSeviceDisplayName(session);
	// }
	//		
	// } catch (PMSException e) {
	// e.printStackTrace();
	// /* throw new BOException(ErrorCode.DATABASE_ERROR); */
	// throw new PMSException("DATABASE_ERROR");
	// } finally {
	// }
	// return serNameMap;
	// }

	public Map<String, TreeMap<String, Integer>> fetchActiveServices(
			String tier) throws PMSException {
		Map<String, TreeMap<String, Integer>> serviceMap = null;
		Session session = null;
		try {
			RoleMgmtDaoImpl daoImpl = new RoleMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			serviceMap = daoImpl.fetchActiveServices(tier, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return serviceMap;
	}

	public Map<Integer, String> fetchRoles(String roleOwner, boolean fetchAll,int userId) throws PMSException {
		Session session = HibernateSessionFactory.getSession();
		Map<Integer, String> roleMap = new TreeMap<Integer, String>();
		try {
			session = HibernateSessionFactory.getSession();
//			if (privFunctionBean.getFunctionSet().contains("fetchRoles")) {
				RoleMgmtDaoImpl daoImpl = new RoleMgmtDaoImpl();
				roleMap = daoImpl.fetchRoles(roleOwner, fetchAll, userId, session);
//			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return roleMap;
	}

	public String checkRoleAvailability(String roleName, Short domainId) {

		Session session = null;
		try {
			RoleMgmtDaoImpl daoImpl = new RoleMgmtDaoImpl();
			session = HibernateSessionFactory.getSession();
			return daoImpl.checkRoleAvailability(roleName, domainId, session);
		} catch (Exception e) {
			new PMSException("Some Internal Error!");
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}
	public void addPrivilege(PrivilegeManagementBean privMgmtBean) throws PMSException{
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			new RoleMgmtDaoImpl().addPrivilege(privMgmtBean, session);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION, PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR, PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
 }
}