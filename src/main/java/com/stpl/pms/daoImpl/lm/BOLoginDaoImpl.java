package com.stpl.pms.daoImpl.lm;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.daoImpl.misc.MiscMgmtDaoImpl;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.StRmBoAllowedIp;
import com.stpl.pms.hibernate.mapping.StRmBoUserInfo;
import com.stpl.pms.hibernate.mapping.StRmBoUserLoginStatus;
import com.stpl.pms.hibernate.mapping.StRmBoUserMaster;
import com.stpl.pms.hibernate.mapping.StRmBoUserPasswordHistory;
import com.stpl.pms.javabeans.LoginBean;
import com.stpl.pms.javabeans.UserInfoBean;
import com.stpl.pms.utility.AutoGenerate;
import com.stpl.pms.utility.MD5;

@SuppressWarnings("unchecked")
public class BOLoginDaoImpl {
	private static final Logger log = Logger.getLogger(BOLoginDaoImpl.class);

	public LoginBean loginAuthentication(String userName, String password,
			String loginToken, String interfaceType, String ipAddress,String sessionId,
			short domainId, String logintry, Session session) throws NumberFormatException, PMSException {
		log.info("Authentication Start");
		LoginBean loginBean = new LoginBean();

		// if(ipAddress)

		StRmBoUserMaster userMaster = null;
		UserInfoBean userInfo = null;
		String dbPass, status;
		int autoGenerate = 0;

		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		criteria.add(Restrictions.eq("userName", userName.trim()));
		List<StRmBoUserMaster> result = criteria.list();

		if (result.size() > 1) {
			log.info("More Then One User Exist with Same userName " + userName);
			loginBean.setStatus("Please Enter Correct Login Name and Password !!");
			return loginBean;
		}
		
		/* It Is Use For Add Ip For Restriction of Other IP which is not Available in List */
		
		
		if (result.size() != 0) {
			userMaster = result.get(0);
			status = userMaster.getStatus();
			
			if (status.equals("INACTIVE") || status.equals("TERMINATE")) {
				loginBean.setStatus("Your status has been set to Inactive or Terminate Please contact  Back Office immediately.");
				return loginBean;
			}else if ("DOMAIN".equals(userMaster.getUserType()) && userMaster.getDomainId()!=domainId) {
				loginBean.setStatus("Invalid domain user !!");
				return loginBean;
			}else if ("USER".equals(userMaster.getUserAccessType())) {
				/**** Ip List Of Skilrock and Mumbai for login INto BO     *****/
//				List<String> ipList = Arrays.asList("202.189.253.126","122.170.111.180","122.169.99.116","49.248.128.213","49.248.33.34","49.248.33.38","115.111.246.154","122.176.63.94","220.225.254.242","182.156.72.78","203.122.33.178","120.63.242.5","49.248.33.35");
//				if(!ipList.contains(ipAddress)){
//					loginBean.setStatus("You are not Authorized to Login");
//					return loginBean;
				MiscMgmtDaoImpl miscMgmtImpl = new MiscMgmtDaoImpl();
				if(!miscMgmtImpl.checkAllowedIp(ipAddress, domainId, session)){
					loginBean.setStatus("You are not Authorized to Login");
				return loginBean;
				}
			}

			dbPass = userMaster.getPassword();
			autoGenerate = userMaster.getAutoPassword();
			userInfo = new UserInfoBean();
			userInfo.setUserName(userName);
			userInfo.setUserId(userMaster.getUserId());
			userInfo.setParentUserId(userMaster.getParentUserId());
			userInfo.setIsRoleHeadUser(userMaster.getIsRoleHead());
			userInfo.setIsMasterRole(userMaster.getIsRoleHead());
			userInfo.setRoleId(userMaster.getStRmBoRoleMaster().getRoleId());
			userInfo.setStatus(userMaster.getStatus());
			userInfo.setRoleName(userMaster.getStRmBoRoleMaster().getRoleName());
			userInfo.setUserType(userMaster.getStRmBoRoleMaster().getTier());
			userInfo.setDomainId(userMaster.getDomainId());

		} else {// check the user's info before login
			loginBean.setStatus("Please Enter Correct Login Name and Password !!");
			return loginBean;
		}

		short invalidLoginTry = userMaster.getInvalidLoginTry();
		short maxInvalidTry = Short.valueOf(logintry);
		boolean checkPass=false;
		if (invalidLoginTry < maxInvalidTry || maxInvalidTry == -1) {
			userMaster.setLastLoginDate(new Timestamp(Calendar.getInstance()
					.getTimeInMillis()));
			userMaster.setLastLoginIp(ipAddress);
			if (password.equals(MD5.encode(dbPass + loginToken))) {
				checkPass=true;
				loginBean.setUserInfo(userInfo);
				userMaster.setInvalidLoginTry((short) 0);
				if (autoGenerate == 1)
					loginBean.setStatus("FirstTime");
				else
					loginBean.setStatus("success");
			} else {
				userMaster.setInvalidLoginTry(++invalidLoginTry);
				loginBean.setStatus("Please Enter Correct Login Name and Password !!");
			}
		} else {
			loginBean.setStatus("Invalid Password Try Limit Reached !!");
		}
		session.update(userMaster);
		
		if(checkPass){
			criteria = session.createCriteria(StRmBoUserLoginStatus.class);
			criteria.add(Restrictions.eq("userId", userMaster.getUserId()));
			List<StRmBoUserLoginStatus> loginStatus = criteria.list();
			StRmBoUserLoginStatus loginStatusBean =  null;
			if(loginStatus.size()==1){
				loginStatusBean = loginStatus.get(0);
				loginBean.setOldSessionId(loginStatusBean.getSessionId());
				loginStatusBean.setSessionId(sessionId);
				loginStatusBean.setIpAddress(ipAddress);
				loginStatusBean.setStatus("LOGGED_IN");
				session.update(loginStatusBean);
			}else{
				loginStatusBean = new StRmBoUserLoginStatus(userMaster.getDomainId(),userMaster.getUserId(),sessionId,ipAddress,"LOGGED_IN");
				session.save(loginStatusBean);
			}
			session.saveOrUpdate(loginStatusBean);
		}
		log.info("Authentication End");
		return loginBean;
	}

	
	public String changePassword(UserInfoBean userBean, String oldPass,
			String newPass, String ipAddress, Short passHistory, Session session) throws NumberFormatException, PMSException {
		log.info("Change Password for BO start");
		String dbPass = null;

		String oldEncPass = MD5.encode(oldPass);
		String newEncPass = MD5.encode(newPass);

		StRmBoUserMaster userMaster = (StRmBoUserMaster) session.get(
				StRmBoUserMaster.class, userBean.getUserId());
		if (userMaster != null) {
			dbPass = userMaster.getPassword();
		}
		if (dbPass.equals(oldEncPass) && !(newEncPass.equals(dbPass))) {
			userMaster.setAutoPassword((short)0);
			short maxHistory =passHistory ;
			if (maxHistory != -1) {
				StRmBoUserPasswordHistory historyBean = null;
				Criteria cri=session.createCriteria(StRmBoUserPasswordHistory.class);
				cri.add(Restrictions.eq("userId", userBean.getUserId()));
				cri.addOrder(Order.asc("updateTime"));
				List<StRmBoUserPasswordHistory> passworHistoryList=cri.list();
				
				if (passworHistoryList.size()>0) {
					for (StRmBoUserPasswordHistory history : passworHistoryList) {
						if (newEncPass.equals(history.getLastPassword())) {
							return "PASSWORD_IN_HISTORY";
						}
					}
				}
				
				if (passworHistoryList.size() < maxHistory) {
					historyBean = new StRmBoUserPasswordHistory();
					historyBean.setUserId(userBean.getUserId());
					historyBean.setLastPassword(dbPass);
					historyBean.setUpdateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
					session.save(historyBean);
				} else {
					historyBean = passworHistoryList.get(0);
					historyBean.setLastPassword(dbPass);
					historyBean.setUpdateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
					session.update(historyBean);
				}
			}
			userMaster.setPassword(newEncPass);
			session.update(userMaster);
			return "SUCCESS";
		} else {
			return "INCORRECT";
		}
	}

	public String forgotPassword(String email, Session session) {

		String newPassword = AutoGenerate.autoPassword();
		Criteria criteria = session.createCriteria(StRmBoUserInfo.class);
		criteria.add(Restrictions.eq("emailId", email));
		List<StRmBoUserInfo> result = criteria.list();
		if (result.size() == 0) {
			return "emailId_not_registered";
		}
		StRmBoUserInfo userInfo = (StRmBoUserInfo) result.get(0);
		StRmBoUserMaster userMaster = (StRmBoUserMaster) session.get(
				StRmBoUserMaster.class, userInfo.getUserId());
		userMaster.setPassword(MD5.encode(newPassword));
		session.update(userMaster);

		return userMaster.getUserName()+"_"+newPassword+"_"+userMaster.getDomainId();
	}

	public String logoutUser(String sessionId, Session session) {
		Criteria criteria = session.createCriteria(StRmBoUserLoginStatus.class);
		criteria.add(Restrictions.eq("sessionId", sessionId));
		criteria.add(Restrictions.eq("status", "LOGGED_IN"));
		List<StRmBoUserLoginStatus> loginStatus = criteria.list();
		if(loginStatus.size()>=1){
			for (StRmBoUserLoginStatus status : loginStatus) {
				status.setStatus("LOGGED_OUT");
				session.update(status);
			}
			return "success";
		}else{
			return "session Id not available";
		}
	}
	
	public String boUserDeviceId(Session session)
	{
		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		criteria.add(Restrictions.eq("userName", "bomaster"));
		String deviceId = null;
		List<StRmBoUserMaster> result = criteria.list();
		
		if (result.size() == 1) {
			StRmBoUserMaster stRmBoUserMaster = (StRmBoUserMaster) result.get(0);
			if(stRmBoUserMaster.getDeviceId() != null && !"".equals(stRmBoUserMaster.getDeviceId()))
				deviceId = stRmBoUserMaster.getDeviceId();
		}
		return deviceId;
	}


	public String getIPStatus(String ipAddress,int userId) {
		// TODO Auto-generated method stub
		Session session=null;
		try
		{
			
			session=HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmBoAllowedIp.class);
			criteria.add(Restrictions.eq("allowedIp",ipAddress));
			criteria.add(Restrictions.eq("status","ACTIVE"));
			criteria.add(Restrictions.eq("userId",userId));
			
			List<StRmBoAllowedIp> result=criteria.list();
			if(result.size()>0)
			{
				return "ALLOWEDIP";
			}
			else
			{
				return "BLOCKEDIP";
			}
			
			
		}catch(Exception e){e.printStackTrace();}
		return null;
	}



}
