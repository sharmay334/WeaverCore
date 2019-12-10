package com.stpl.pms.service.mobile.rest.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.StRmBoUserLoginStatus;
import com.stpl.pms.hibernate.mapping.StRmBoUserMaster;
import com.stpl.pms.javabeans.UserInfoBean;
import com.stpl.pms.service.mobile.rest.javabeans.BoLoginResponseBean;
import com.stpl.pms.utility.MD5;

public class WeaverMobileBoLoginDaoImpl {

	private static final Logger log = Logger.getLogger(WeaverMobileBoLoginDaoImpl.class);
	
	public BoLoginResponseBean loginAuthentication(String userName, String password,
			String loginToken, String interfaceType, String ipAddress,String sessionId,
			short domainId, String logintry, String deviceId, Session session) throws NumberFormatException, PMSException {
		log.info("Authentication Start");
		BoLoginResponseBean boLoginResponseBean = new BoLoginResponseBean();

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
			boLoginResponseBean.setStatus("Please Enter Correct Login Name and Password !!");
			return boLoginResponseBean;
		}

		if (result.size() != 0) {
			userMaster = result.get(0);
			status = userMaster.getStatus();
			if (status.equals("INACTIVE") || status.equals("TERMINATE")) {
				boLoginResponseBean.setStatus("Your status has been set to Inactive or Terminate Please contact  Back Office immediately.");
				return boLoginResponseBean;
			}else if ("DOMAIN".equals(userMaster.getUserType()) && userMaster.getDomainId()!=domainId) {
				boLoginResponseBean.setStatus("Invalid domain user !!");
				return boLoginResponseBean;
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
			boLoginResponseBean.setStatus("Please Enter Correct Login Name and Password !!");
			return boLoginResponseBean;
		}

		short invalidLoginTry = userMaster.getInvalidLoginTry();
		short maxInvalidTry = Short.valueOf(logintry);
		boolean checkPass=false;
		if (invalidLoginTry < maxInvalidTry || maxInvalidTry == -1) {
			userMaster.setLastLoginDate(new Timestamp(Calendar.getInstance()
					.getTimeInMillis()));
			userMaster.setLastLoginIp(ipAddress);
			if(deviceId!=null && !"".equals(deviceId))
			{
				userMaster.setDeviceId(deviceId);
			}
			if (password.equals(MD5.encode(dbPass + loginToken))) {
				checkPass=true;
				boLoginResponseBean.setUserInfo(userInfo);
				userMaster.setInvalidLoginTry((short) 0);
				if (autoGenerate == 1)
					boLoginResponseBean.setStatus("FirstTime");
				else
					boLoginResponseBean.setStatus("success");
			} else {
				userMaster.setInvalidLoginTry(++invalidLoginTry);
				boLoginResponseBean.setStatus("Please Enter Correct Login Name and Password !!");
			}
		} else {
			boLoginResponseBean.setStatus("Invalid Password Try Limit Reached !!");
		}
		session.update(userMaster);
		
		if(checkPass){
			criteria = session.createCriteria(StRmBoUserLoginStatus.class);
			criteria.add(Restrictions.eq("userId", userMaster.getUserId()));
			List<StRmBoUserLoginStatus> loginStatus = criteria.list();
			StRmBoUserLoginStatus loginStatusBean =  null;
			if(loginStatus.size()==1){
				loginStatusBean = loginStatus.get(0);
				//boLoginResponseBean.setOldSessionId(loginStatusBean.getSessionId());
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
		return boLoginResponseBean;
	}
}
