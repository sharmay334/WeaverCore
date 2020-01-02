package com.stpl.pms.daoImpl.um;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.StRmBoRoleMaster;
import com.stpl.pms.hibernate.mapping.StRmBoRolePrivMapping;
import com.stpl.pms.hibernate.mapping.StRmBoUserInfo;
import com.stpl.pms.hibernate.mapping.StRmBoUserMaster;
import com.stpl.pms.hibernate.mapping.StRmBoUserPrivMapping;
import com.stpl.pms.hibernate.mapping.StRmServiceDeliveryMaster;
import com.stpl.pms.hibernate.mapping.StRmServiceMaster;
import com.stpl.pms.javabeans.UserDetailsBean;
import com.stpl.pms.javabeans.UserInfoBean;
import com.stpl.pms.javabeans.UserPrivBean;
import com.stpl.pms.utility.AutoGenerate;
import com.stpl.pms.utility.MD5;

@SuppressWarnings("unchecked")
public class UserMgmtDaoImpl {

	private static final Logger log=Logger.getLogger(UserMgmtDaoImpl.class);
	public String createBoUser(UserInfoBean userInfoBean, String userName,
			String status, String secQues, String secAns, String firstName,
			String lastName, String gender, String email, String phone,
			String roleIdStr, String ipAddress, Session session,Short domainId, String userType) {
		status="ACTIVE";
		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.setProjection(Projections.property("userName"));
		List<String> result = criteria.list();

		if (result.size() > 0) {
			return "USER_ALREADY_EXIST";
		}
		Integer roleId = -1;
		roleId = Integer.parseInt(roleIdStr.trim());
		if (roleId <= 0) {
			return "WRONG_ROLE_ID";
		}

		String autoPass = AutoGenerate.autoPassword();

		Short s = 1;
		StRmBoUserMaster stBoUserMaster = new StRmBoUserMaster();
		stBoUserMaster.setParentUserId(userInfoBean.getUserId());
		stBoUserMaster.setStRmBoRoleMaster((StRmBoRoleMaster)session.load(StRmBoRoleMaster.class,Integer.valueOf(roleId.toString())));
				/*new StRmBoRoleMaster(Integer
				.valueOf(roleId.toString())));*/
		stBoUserMaster.setRegistrationDate(new java.sql.Timestamp(new Date()
				.getTime()));
		stBoUserMaster.setLastLoginDate(new java.sql.Timestamp(new Date()
				.getTime()));
		stBoUserMaster.setUserName(userName.trim().toLowerCase());
		stBoUserMaster.setPassword(MD5.encode(autoPass));
		stBoUserMaster.setLastLoginIp("");
		stBoUserMaster.setAutoPassword(s);
		stBoUserMaster.setStatus(status);
		stBoUserMaster.setSecQues(secQues);
		stBoUserMaster.setSecAns(secAns);
		stBoUserMaster.setIsRoleHead("Y");
		stBoUserMaster.setDomainId(domainId);
		stBoUserMaster.setUserType(userType);
		stBoUserMaster.setUserAccessType("ADMIN");
		stBoUserMaster.setInvalidLoginTry((short)0);

		Integer newUserId = (Integer) session.save(stBoUserMaster);

		StRmBoUserInfo stBoUserInfo = new StRmBoUserInfo();
		stBoUserInfo.setUserId(newUserId);
		//stBoUserInfo.setStRmBoUserMaster(stBoUserMaster);
		stBoUserInfo.setFirstName(firstName);
		stBoUserInfo.setLastName(lastName);
		stBoUserInfo.setGender(gender);
		stBoUserInfo.setEmailId(email);
		stBoUserInfo.setPhoneNum(phone);
		stBoUserInfo.setAddressLine1("address");
		stBoUserInfo.setCity("gurgaon");
		stBoUserInfo.setCountryCode("IN");
		stBoUserInfo.setStateCode("RJ");
		stBoUserInfo.setPostalCode("122002");
		//stBoUserInfo.setStRmBoUserMaster(stBoUserMaster);
		session.save(stBoUserInfo);

		criteria = session.createCriteria(StRmBoRolePrivMapping.class);
		criteria.add(Restrictions.eq("roleId", roleId));
		criteria.setProjection(Projections.projectionList().add(
				Projections.property("privId")).add(
				Projections.property("sdmId")).add(
				Projections.property("status")));

		List<Object[]> fetchPrivQueryList = criteria.list();

		StRmBoUserPrivMapping stBoUserPrivMapping1 = null;
		for (int i = 0; i < fetchPrivQueryList.size(); i++) {
			stBoUserPrivMapping1 = new StRmBoUserPrivMapping();
			stBoUserPrivMapping1.setUserId(newUserId);
			stBoUserPrivMapping1.setRoleId(Integer.valueOf(roleId.toString()));
			stBoUserPrivMapping1
					.setPrivId((Integer) fetchPrivQueryList.get(i)[0]);
			stBoUserPrivMapping1.setSdmId((Short) fetchPrivQueryList.get(i)[1]);
			stBoUserPrivMapping1.setStatus(fetchPrivQueryList.get(i)[2]
					.toString());
			session.save(stBoUserPrivMapping1);
		}

		 log.info("mail sent after commit");
		return autoPass;

	}

	public boolean checkUsernameAvailability(String userName, Short domainId, Session session) {
		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("domainId", domainId));
		criteria.setProjection(Projections.property("userName"));
		List<String> result = criteria.list();
		if (result.size() > 0) {
			return false;
		}
		return true;
	}
	
	public boolean checkUserEmailIdAvailability(String emailId, Short domainId, Session session) {
		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		criteria.createAlias("userInfo", "userInfo", Criteria.INNER_JOIN);
		criteria.add(Restrictions.eq("domainId", domainId));
		criteria.add(Restrictions.eq("userInfo.emailId", emailId));
		
		criteria.setProjection(Projections.property("userInfo.emailId"));
		List<String> result = criteria.list();
		if (result.size() > 0) {
			return false;
		}
		return true;
	}
	public boolean checkUserEmailIdAvailabilityForDomain(String emailId, Short domainId,int userId, Session session) {
		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		criteria.createAlias("userInfo", "userInfo", Criteria.INNER_JOIN);
		criteria.add(Restrictions.eq("domainId", domainId));
		criteria.add(Restrictions.eq("userInfo.emailId", emailId));
		
		criteria.setProjection(Projections.projectionList().add(Projections.property("userInfo.emailId")).add(Projections.property("userId")));
		
		List<Object[]> result = criteria.list();
		if (result.size() > 0) {
			for (int i = 0; i < result.size(); i++) {
				if(Integer.parseInt(result.get(i)[1].toString())!=userId)
				return false;
			}
		}
		return true;
	}

	public String assignGroups(int creatorUserId, String[] rolePriv,
			short creatorRoleId, UserDetailsBean usrdetBean, int[] mappingId,
			int[] privCount, String ipAddress, short domainId, Session session)
			throws ClassNotFoundException {

		int userId = 0;
		String password = null;
		password = AutoGenerate.autoPassword();
		//password =;
		
		Criteria criteria1 = session.createCriteria(StRmBoUserMaster.class);
		criteria1.add(Restrictions.eq("userName", usrdetBean.getUserName()));
		criteria1.setProjection(Projections.property("userName"));
		List<String> result = criteria1.list();

		if (result.size() > 0) {
			return "USER_ALREADY_EXIST";
		}
		StRmBoUserMaster stRmBoUserMaster = new StRmBoUserMaster();
		stRmBoUserMaster.setAutoPassword((short) 1);
		stRmBoUserMaster.setDomainId(domainId);
		stRmBoUserMaster.setIsRoleHead("N");
		stRmBoUserMaster.setLastLoginIp("");
		// stRmBoUserMaster.setLastLoginDate(new Timestamp());
		stRmBoUserMaster.setParentUserId(creatorUserId);
		stRmBoUserMaster.setPassword( MD5.encode(password));
		stRmBoUserMaster.setUserType(usrdetBean.getBoUserType());
		stRmBoUserMaster
				.setRegistrationDate(new Timestamp(new Date().getTime()));
		stRmBoUserMaster.setLastLoginDate(new Timestamp(new Date().getTime()));
		stRmBoUserMaster.setStRmBoRoleMaster((StRmBoRoleMaster)session.load(StRmBoRoleMaster.class,Integer
				.valueOf(creatorRoleId)) );/*   new StRmBoRoleMaster(Integer
				.valueOf(creatorRoleId)));*/
		stRmBoUserMaster.setSecAns(usrdetBean.getSecAns());
		stRmBoUserMaster.setSecQues(usrdetBean.getSecQues());
		stRmBoUserMaster.setStatus(usrdetBean.getStatus());
		stRmBoUserMaster.setUserName(usrdetBean.getUserName());
		stRmBoUserMaster.setUserAccessType("ADMIN");
		stRmBoUserMaster.setInvalidLoginTry((short)0);
		StRmBoUserInfo userInfo = new StRmBoUserInfo();
		userInfo.setEmailId(usrdetBean.getEmailId());
		userInfo.setFirstName(usrdetBean.getFirstName());
		userInfo.setGender(usrdetBean.getGender());
		//userInfo.setCity(usrdetBean.get)
		userInfo.setLastName(usrdetBean.getLastName());
		userInfo.setPhoneNum(usrdetBean.getPhoneNbr());
		userInfo.setAddressLine1("address");
		userInfo.setCity(usrdetBean.getCity());
		userInfo.setCountryCode("IN");
		userInfo.setStateCode("RJ");
		userInfo.setPostalCode("122002");
		userInfo.setCountry(usrdetBean.getCountry());
		userInfo.setState(usrdetBean.getState());
		userInfo.setPincode(usrdetBean.getPincode());
		userInfo.setDoj(usrdetBean.getDoj());
		userInfo.setDol(usrdetBean.getDol());
		userInfo.setDob(usrdetBean.getDob());
		userInfo.setPanNumber(usrdetBean.getPanNumber());
		userInfo.setAadharNumber(usrdetBean.getAadharNumber());
		userInfo.setVoterNumber(usrdetBean.getVoterNumber());
		userInfo.setPassportNumber(usrdetBean.getPassportNumber());
		userInfo.setFatherName(usrdetBean.getFatherName());
		userInfo.setAadharDoc(usrdetBean.getAadharDoc());
		userInfo.setAadharNumber(usrdetBean.getAadharNumber());
		userInfo.setAddressDoc(usrdetBean.getAddressDoc());
		userInfo.setAadharDoc(usrdetBean.getAddressDoc());
		userInfo.setDrivingDoc(usrdetBean.getDrivingDoc());
		userInfo.setEduCertificate(usrdetBean.getEduCertificate());
		userInfo.setExpCertificate(usrdetBean.getExpCertificate());
		userInfo.setOldSalarySlip(usrdetBean.getOldSalarySlip());
		userInfo.setPhoto_doc(usrdetBean.getPhoto_doc());
		userInfo.setPanDoc(usrdetBean.getPanDoc());
		userInfo.setVoterDoc(usrdetBean.getVoterDoc());
		userInfo.setDrivingDoc(usrdetBean.getDrivingDoc());
		userInfo.setPassbookDoc(usrdetBean.getPassbookDoc());
		userInfo.setBloodGroup(usrdetBean.getBloodGroup());
		userInfo.setBranch(usrdetBean.getBranch());
		userInfo.setCurrentAddress(usrdetBean.getCurrentAddress());
		userInfo.setPermanentAddress(usrdetBean.getPermanentAddress());
		
		//userInfo.setStRmBoUserMaster(stRmBoUserMaster);

//		stRmBoUserMaster.setStRmBoUserInfo(userInfo);
		userId = (Integer) session.save(stRmBoUserMaster);
		
		userInfo.setUserId(userId);
		session.save(userInfo);
		
//		StRmBoUserInfo stRmBoUserInfo = new StRmBoUserInfo();
//		stRmBoUserInfo.setStRmBoUserMaster(stRmBoUserMaster);

		Criteria criteria = session
				.createCriteria(StRmServiceDeliveryMaster.class);
		criteria.add(Restrictions.eq("tier", usrdetBean.getBoUserType()));
		if(domainId!=1)
			criteria.add(Restrictions.eq("domainId", domainId));
		criteria.createAlias("stRmServiceMaster", "serviceMaster");
		criteria.add(Restrictions.eq("serviceMaster.status", "ACTIVE"));
		List<StRmServiceDeliveryMaster> deliveryMasterList = criteria.list();

		for (StRmServiceDeliveryMaster deliveryMaster : deliveryMasterList) {
			String displayName = deliveryMaster.getServiceDisplayName();
			if(!("RUMMY".equalsIgnoreCase(displayName) || "IGE".equalsIgnoreCase(displayName) || "SGE".equalsIgnoreCase(displayName))) {
			
			
			String privT[] = deliveryMaster.getStRmServiceMaster()
					.getPrivRepTable().split("_");
			StringBuilder privTableName = new StringBuilder();
			privTableName.append(privT[0].substring(0, 1).toUpperCase()
					+ privT[0].substring(1));
			for (int i = 1; i < privT.length; i++) {
				privTableName.append(privT[i].substring(0, 1).toUpperCase()
						+ privT[i].substring(1));
			}

			Class clazz = Class.forName("com.stpl.pms.hibernate.mapping."
					+ privTableName.toString());

			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(StRmBoRolePrivMapping.class);
			detachedCriteria.add(Restrictions.eq("sdmId", deliveryMaster
					.getSdmId()));
			detachedCriteria.add(Restrictions.eq("roleId",  Integer.valueOf(creatorRoleId)));
			detachedCriteria.setProjection(Projections.distinct(Projections
					.property("privId")));

			criteria = session.createCriteria(StRmBoUserPrivMapping.class);
			criteria.add(Restrictions.eq("userId", creatorUserId));
			criteria.add(Restrictions.eq("sdmId", deliveryMaster.getSdmId()));
			criteria.add(Restrictions.eq("roleId", Integer.valueOf(creatorRoleId)));
			criteria.add(Subqueries.propertyIn("privId", detachedCriteria));
			criteria.setProjection(Projections.distinct(Projections
					.property("privId")));

			List<Integer> privIdList = criteria.list();

			criteria = session.createCriteria(clazz);
			criteria.add(Restrictions.in("privId", privIdList));
			criteria.setProjection(Projections.projectionList().add(
					Projections.groupProperty("privId")).add(
					Projections.property("isDefault")));

			List<Object[]> privMgmtArr = criteria.list();

			StRmBoUserPrivMapping stRmBoUserPrivMapping = null;
			for (Object[] obj : privMgmtArr) {
				stRmBoUserPrivMapping = new StRmBoUserPrivMapping();
				stRmBoUserPrivMapping.setPrivId((Integer) obj[0]);
				if (obj[1].toString().equals("Y"))
					stRmBoUserPrivMapping.setStatus("ACTIVE");
				else
					stRmBoUserPrivMapping.setStatus("INACTIVE");
				stRmBoUserPrivMapping.setRoleId(Integer.valueOf(creatorRoleId));
				stRmBoUserPrivMapping.setSdmId(deliveryMaster.getSdmId());
				stRmBoUserPrivMapping.setUserId(userId);
				session.save(stRmBoUserPrivMapping);
				session.flush();
			}
		}
		
	}
		StringBuilder grpName = null;
		StringBuilder strMappingId = new StringBuilder("");
		String grpNameStr = null;
		int privIdFrm = 0;
		int privIdTo = 0;
		String activeMapIds = "";
		HashMap<Integer, String> privMap = new HashMap<Integer, String>();
		for (int i = 0; i < mappingId.length; i++) {
			if (privCount[i] != 0) {
				grpName = new StringBuilder("");
				privIdTo = privIdTo + privCount[i];
				for (int j = privIdFrm; j < privIdTo; j++) {
					grpName.append("'" + rolePriv[j] + "',");
					privIdFrm++;
				}
				grpNameStr = grpName.substring(0, grpName.length() - 1);
				grpNameStr = grpNameStr.replace("*", "");
				activeMapIds = activeMapIds + mappingId[i] + ",";
				privMap.put(mappingId[i], grpNameStr);
			}
			strMappingId.append(mappingId[i] + ",");
		}
		strMappingId.deleteCharAt(strMappingId.length() - 1);
		List<String> ls =  Arrays.asList(strMappingId.toString().replace("'", "").split("\\s*,\\s*"));
		List<Short> list= new ArrayList<Short>();
		for(String l:ls){
			list.add(Short.valueOf(l));
		}
		criteria = session.createCriteria(StRmServiceDeliveryMaster.class);
		criteria.add(Restrictions.in("sdmId",list));
		criteria.setProjection(Projections.projectionList().add(
				Projections.distinct(Projections.property("sdmId"))).add(
				Projections.property("stRmServiceMaster")));

		List<Object[]> objArr = criteria.list();

		for (Object[] obj : objArr) {
			
			if (privMap.get(Integer.parseInt(obj[0].toString())) != null) {
				StRmServiceMaster master = (StRmServiceMaster)obj[1];
				String privT[] = master.getPrivRepTable().split("_");
				
				StringBuilder privTableName = new StringBuilder();
				//privTableName = master.getPrivRepTable();
				privTableName.append(privT[0].substring(0, 1).toUpperCase()
						+ privT[0].substring(1));
				for (int i = 1; i < privT.length; i++) {
					privTableName.append(privT[i].substring(0, 1).toUpperCase()
							+ privT[i].substring(1));
				}

				Class clazz = Class.forName("com.stpl.pms.hibernate.mapping."
						+ privTableName.toString());
				criteria = session.createCriteria(clazz);
				criteria.add(Restrictions.eq("privStatus", "ACTIVE"));
				criteria.add(Restrictions.in("privNameCode", Arrays
						.asList(privMap.get(Integer.parseInt(obj[0].toString())).replace("'", "").split(
								"\\s*,\\s*"))));
				criteria.add(Restrictions.isNotNull("dependentPriv"));
				criteria.setProjection(Projections.distinct(Projections
						.property("dependentPriv")));
				List<String> dependentPrivList = criteria.list();

				StringBuilder depPriv = new StringBuilder("");
				for (String dependentPriv : dependentPrivList) {
					if (depPriv == null) {
						depPriv = new StringBuilder();
					}
					depPriv.append(dependentPriv).append(",");
				}

				String depPrivs = null;
				if (depPriv != null) {
					depPrivs = depPriv.toString().replaceAll(",$", "");
				}
				
				@SuppressWarnings("unused")
				List<String> temp = Arrays.asList(
						privMap.get(Integer.parseInt(obj[0].toString())).replace("'", "").split("\\s*,\\s*"));
				
				DetachedCriteria dcCriteria = DetachedCriteria.forClass(clazz);
				dcCriteria.setProjection(Projections.distinct(Projections
						.property("privId")));
				dcCriteria.add(Restrictions.eq("privStatus", "ACTIVE"));
				
				if(depPrivs.equals("")|| depPrivs.equals(null)){
					dcCriteria.add(Restrictions.or(Restrictions
							.eq("isDefault", "Y"), Restrictions.in(
							"privNameCode", Arrays.asList(
						privMap.get(Integer.parseInt(obj[0].toString())).replace("'", "").split("\\s*,\\s*")))
							));
					
				}
				else{
					dcCriteria.add(Restrictions.or(Restrictions
							.eq("isDefault", "Y"), Restrictions.or(Restrictions.in(
							"privNameCode", Arrays.asList(
									privMap.get(Integer.parseInt(obj[0].toString())).replace("'", "").split("\\s*,\\s*"))),
							Restrictions.in("privId", Arrays.asList(depPrivs
									.split("\\s*,\\s*"))))));
				}
				dcCriteria.getExecutableCriteria(session).list();
				//List<Integer>list1 =
				criteria = session.createCriteria(StRmBoUserPrivMapping.class);
				criteria.add(Subqueries.propertyIn("privId", dcCriteria));
				criteria.add(Restrictions.eq("sdmId", Short.valueOf(obj[0].toString())));
				criteria.add(Restrictions.eq("roleId", Integer.valueOf(creatorRoleId)));

				List<StRmBoUserPrivMapping> userPriMappingList = criteria.list();
				for (StRmBoUserPrivMapping userMapping : userPriMappingList) {
					userMapping.setStatus("ACTIVE");
					session.update(userMapping);
				}
			}
		}

		return password;
	}

	public List<String> fetchSubUserName(int roleId, int userId, Session session) {
		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		criteria.add(Restrictions.eq("stRmBoRoleMaster.roleId", roleId));
		//criteria.add(Restrictions.eq("isRoleHead", "N"));
		criteria.add(Restrictions.eq("parentUserId", userId));
		criteria.addOrder(Order.asc("userName"));
		criteria.setProjection(Projections.property("userName"));
		List<String> userList = criteria.list();
		return userList;
	}

	public Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> getSubUserPriviledges(
			String userName, int parentUserId, String tierType ,Short domainId, Session session)
			throws ClassNotFoundException {

		Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> headPriviledgeMap = new TreeMap<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>>();
		Integer roleId = 0, userId = 0;

		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.setProjection(Projections.projectionList().add(
				Projections.property("userId")).add(
				Projections.property("stRmBoRoleMaster.roleId")));

		List<Object[]> list = criteria.list();
		if (list.size() > 0) {
			userId = (Integer) list.get(0)[0];
			roleId = (Integer) list.get(0)[1];
		}

		criteria = session.createCriteria(StRmServiceDeliveryMaster.class);
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		criteria.createAlias("stRmServiceMaster", "serviceMaster");
		criteria.add(Restrictions.eq("serviceMaster.status", "ACTIVE"));
		if(tierType.equals("DOMAIN"))
			criteria.add(Restrictions.eq("domainId", domainId));
		criteria.add(Restrictions.eq("tier", tierType));
		List<StRmServiceDeliveryMaster> deliveryMasterList = criteria.list();

		TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>> interfaceMap = null;
		for (StRmServiceDeliveryMaster deliveryMaster : deliveryMasterList) {
			String 	serviceName = deliveryMaster.getServiceDisplayName();
			if(!("rummy".equalsIgnoreCase(serviceName)|| "IGE".equalsIgnoreCase(serviceName) || "SGE".equalsIgnoreCase(serviceName))) {
			
		/*	if(!deliveryMaster.getServiceDisplayName().equalsIgnoreCase("rummy") ){*/
			
			String privT[] = deliveryMaster.getStRmServiceMaster()
					.getPrivRepTable().split("_");
			StringBuilder privTableName = new StringBuilder();
			privTableName.append(privT[0].substring(0, 1).toUpperCase()
					+ privT[0].substring(1));
			for (int i = 1; i < privT.length; i++) {
				privTableName.append(privT[i].substring(0, 1).toUpperCase()
						+ privT[i].substring(1));
			}

			Class clazz = Class.forName("com.stpl.pms.hibernate.mapping."
					+ privTableName.toString());

			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(StRmBoRolePrivMapping.class);
			detachedCriteria.add(Restrictions.eq("status", "ACTIVE"));
			detachedCriteria.add(Restrictions.eq("sdmId", deliveryMaster
					.getSdmId()));
			detachedCriteria.add(Restrictions.eq("roleId", roleId));
			detachedCriteria.setProjection(Projections.distinct(Projections
					.property("privId")));

			criteria = session.createCriteria(StRmBoUserPrivMapping.class);
			criteria.add(Restrictions.ne("status", "NA"));
			criteria.add(Restrictions.eq("userId", userId));
			criteria.add(Restrictions.eq("sdmId", deliveryMaster.getSdmId()));
			criteria.add(Restrictions.eq("roleId", roleId));
			criteria.add(Subqueries.propertyIn("privId", detachedCriteria));
			criteria.setProjection(Projections.projectionList().add(
					Projections.distinct(Projections.property("privId"))).add(
					Projections.property("status")));

			List<Object[]> objArr = criteria.list();
			if(objArr.size()!=0){
				List<Integer> privIdList = new ArrayList<Integer>();
				Map<Integer, String> privStatusMap = new HashMap<Integer, String>();
				for (Object[] obj : objArr) {
					privIdList.add((Integer) obj[0]);
					privStatusMap.put((Integer) obj[0], (String) obj[1]);
				}
	
				criteria = session.createCriteria(clazz);
				criteria.add(Restrictions.eq("privStatus", "ACTIVE"));
				criteria.add(Restrictions.eq("isDefault", "N"));
				criteria.add(Restrictions.in("privId", privIdList));
				criteria.add(Restrictions.eq("tier", tierType));
				criteria.setProjection(Projections.projectionList().add(
						Projections.distinct(Projections.property("privNameCode"))).add(
						Projections.groupProperty("relatedTo")).add(
						Projections.groupProperty("groupNameCode")).add(
						Projections.property("isDefaultGroup")).add(
								Projections.groupProperty("privId")).add(
								Projections.property("dependentPriv")));
	
				List<Object[]> privRepMgmtArr = criteria.list();
	
				String relatedTo = "";
				UserPrivBean privBean;
				String oldRelatedTo = "";
				List<UserPrivBean> groupNameList = null;
	
				if (!headPriviledgeMap.containsKey(deliveryMaster
						.getServiceDisplayName())) {
					interfaceMap = new TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>();
					headPriviledgeMap.put(deliveryMaster.getServiceDisplayName(),
							interfaceMap);
				}
	
				TreeMap<String, List<UserPrivBean>> groupNameMap = null;
				interfaceMap = headPriviledgeMap.get(deliveryMaster
						.getServiceDisplayName());
				TreeMap<String, TreeMap<String, List<UserPrivBean>>> privMap = new TreeMap<String, TreeMap<String, List<UserPrivBean>>>();
				String oldGpNameCode = "";
				String gpNameCode = "";
				String privNameCode = "";
				String oldPrivNameCode = "";
	
				for (Object[] obj1 : privRepMgmtArr) {
					relatedTo = obj1[1].toString();
					privBean = new UserPrivBean();
					gpNameCode = obj1[2].toString();
					privBean.setPrivRelatedTo(relatedTo);
					if (!relatedTo.equals(oldRelatedTo)) {
						groupNameMap = new TreeMap<String, List<UserPrivBean>>();
						oldRelatedTo = relatedTo;
						privMap.put(oldRelatedTo, groupNameMap);
					}
					if (!gpNameCode.equals(oldGpNameCode)) {
						groupNameList = new ArrayList<UserPrivBean>();
						privBean = new UserPrivBean();
						oldGpNameCode = gpNameCode;
						groupNameMap.put(gpNameCode, groupNameList);
					}
					privNameCode = obj1[0].toString();
					if (!privNameCode.equals(oldPrivNameCode)) {
						oldPrivNameCode = privNameCode;
						if (obj1[3].toString().equals("Y")) {
							privNameCode = "*" + privNameCode;
						}
						privBean.setPrivTitle(privNameCode);
						privBean.setStatus(privStatusMap.get((Integer) obj1[4]));
						groupNameList.add(privBean);
					}
				}
				if (privMap.size() > 0) {
					interfaceMap.put(deliveryMaster.getServiceDisplayName() + "-"
							+ deliveryMaster.getSdmId(), privMap);
				}
				if (interfaceMap.size() == 0) {
					headPriviledgeMap
							.remove(deliveryMaster.getServiceDisplayName());
				}
			}
		}
	}

		return headPriviledgeMap;
	}

	public void editSubUserPriviledges(String userName, String[] rolePriv,
			int[] mappingId, int[] privCount, Session session)
			throws ClassNotFoundException {
		int userId = 0, roleId = 0;

		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.setProjection(Projections.projectionList().add(
				Projections.property("userId")).add(
				Projections.property("stRmBoRoleMaster.roleId")));
		List<Object[]> list = criteria.list();

		userId = (Integer) list.get(0)[0];
		roleId = (Integer) list.get(0)[1];

		for (int element : mappingId) {
			criteria = session.createCriteria(StRmBoUserPrivMapping.class);
			criteria.add(Restrictions.eq("userId", userId));
			criteria.add(Restrictions.eq("roleId", roleId));
			criteria.add(Restrictions.eq("sdmId",Short.valueOf(String.valueOf(element))));
			criteria.add(Restrictions.ne("status", "NA"));
			List<StRmBoUserPrivMapping> userMappingList = criteria.list();
			for (StRmBoUserPrivMapping userPrivMapping : userMappingList) {
				userPrivMapping.setStatus("INACTIVE");
				session.update(userPrivMapping);
			}
		}

		StringBuilder grpName = null;
		List<Short> strMappingIds = new ArrayList<Short>();
		//StringBuilder strMappingId = new StringBuilder("");
		String grpNameStr = null;
		int privIdFrm = 0;
		int privIdTo = 0;
		String activeMapIds = "";
		HashMap<Integer, String> privMap = new HashMap<Integer, String>();
		for (int i = 0; i < mappingId.length; i++) {
			if (privCount[i] != 0) {
				grpName = new StringBuilder("");
				privIdTo = privIdTo + privCount[i];
				for (int j = privIdFrm; j < privIdTo; j++) {
					grpName.append("'" + rolePriv[j] + "',");
					privIdFrm++;
				}
				grpNameStr = grpName.substring(0, grpName.length() - 1);
				grpNameStr = grpNameStr.replace("*", "");
				activeMapIds = activeMapIds + mappingId[i] + ",";
				privMap.put(mappingId[i], grpNameStr);
			}
			strMappingIds.add(Short.valueOf(String.valueOf(mappingId[i])));
			//strMappingId.append(mappingId[i] + ",");

		}
		//strMappingId.deleteCharAt(strMappingId.length() - 1);

		criteria = session.createCriteria(StRmServiceDeliveryMaster.class)
		.createAlias("stRmServiceMaster", "serviceMaster");
		criteria.add(Restrictions.in("sdmId",strMappingIds));
		criteria.setProjection(Projections.projectionList().add(
				Projections.property("sdmId")).add(
				Projections.property("serviceMaster.privRepTable")));
		List<Object[]> fetchPrivTableList = criteria.list();

		for (Object[] obj : fetchPrivTableList) {
			if (privMap.get(Integer.valueOf(obj[0].toString())) != null) {

				String privT[] = obj[1].toString().split("_");
				StringBuilder privTableName = new StringBuilder();
				privTableName.append(privT[0].substring(0, 1).toUpperCase()
						+ privT[0].substring(1));
				for (int i = 1; i < privT.length; i++) {
					privTableName.append(privT[i].substring(0, 1).toUpperCase()
							+ privT[i].substring(1));
				}

				Class clazz = Class.forName("com.stpl.pms.hibernate.mapping."
						+ privTableName.toString());

				criteria = session.createCriteria(clazz);
				criteria.add(Restrictions.eq("privStatus", "ACTIVE"));
				criteria.add(Restrictions.in("privNameCode", Arrays
						.asList(privMap.get(Integer.valueOf(obj[0].toString())).toString()
								.replace("'", "").split(
								"\\s*,\\s*"))));
				criteria.add(Restrictions.isNotNull("dependentPriv"));
				criteria.setProjection(Projections.distinct(Projections
						.property("dependentPriv")));
				List<String> dependentPrivList = criteria.list();

				StringBuilder depPriv = null;
				for (String dependentPriv : dependentPrivList) {
					if (depPriv == null) {
						depPriv = new StringBuilder();
					}
					depPriv.append(dependentPriv).append(",");
				}

				String depPrivs = null;
				if (depPriv != null) {
					depPrivs = depPriv.toString().replaceAll(",$", "");
				}
				DetachedCriteria dcCriteria = DetachedCriteria.forClass(clazz);
				dcCriteria.setProjection(Projections.distinct(Projections
						.property("privId")));
				dcCriteria.add(Restrictions.eq("privStatus", "ACTIVE"));
				if (depPrivs != null) {
					
					dcCriteria.add(Restrictions.or(Restrictions
							.eq("isDefault", "Y"), Restrictions.or(Restrictions.in(
							"privNameCode", Arrays.asList(privMap.get(
									Integer.valueOf(obj[0].toString())).replace("'", "").split("\\s*,\\s*"))),
							Restrictions.in("privId", Arrays.asList(depPrivs
									.split("\\s*,\\s*"))))));
				}
				else{
					dcCriteria.add(Restrictions.or(Restrictions
							.eq("isDefault", "Y"), 
									Restrictions.in("privNameCode", Arrays.asList(privMap.get(
									Integer.valueOf(obj[0].toString())).replace("'", "").split("\\s*,\\s*")))
							));
				}
				
			
				dcCriteria.getExecutableCriteria(session).list();
				criteria = session.createCriteria(StRmBoUserPrivMapping.class);
				criteria.add(Subqueries.propertyIn("privId", dcCriteria));
				criteria.add(Restrictions.eq("sdmId", Short.valueOf(obj[0].toString())));
				criteria.add(Restrictions.eq("roleId", roleId));
				criteria.add(Restrictions.eq("userId", userId));

				List<StRmBoUserPrivMapping> userPriMappingList = criteria
						.list();
				for (StRmBoUserPrivMapping userMapping : userPriMappingList) {
					userMapping.setStatus("ACTIVE");
					session.update(userMapping);
				}

			}
		}
	}

	public List<UserDetailsBean> searchBoUsers(String userName, int roleId,
			String type, String status, UserInfoBean parentUserBean,
			Session session) {
		List<UserDetailsBean> userList = new ArrayList<UserDetailsBean>();
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(StRmBoUserInfo.class);
		String nameArr[] = null ; 
		if (userName != null && !"".equals(userName.trim())) {
			 nameArr = userName.trim().split(" ");
			boolean flag = true;
			int count = 0;
			for (int i = 0; i < nameArr.length; i++) {
				if (!"".equals(nameArr[i].trim())) {
					count += 1;
				}
				if (count > 1) {
					flag = false;
					//criteria.add(Restrictions.eq("userInfo.firstName", ""));
				}
			}
			if (flag){
				String str = nameArr[0].trim() + "%"; 
				detachedCriteria.add(Restrictions.like("firstName", str));
//				criteria.add(Restrictions.ilike("userInfo.firstName", "'"
//						+ nameArr[0].trim() + "'%"));
				for (int i = 1; i < nameArr.length; i++) {
					if (!"".equals(nameArr[i].trim())) {
					 str =nameArr[1].trim() + "%"; 
						detachedCriteria.add(Restrictions.like("lastName",
								str));
			}
				}
			}
		}
		
		
		
		
		
		List<StRmBoUserInfo>userInfos = detachedCriteria.getExecutableCriteria(session).list();
		
		detachedCriteria.setProjection(Projections.property("userId"));
		
		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		
		
		
		
		
		criteria.add(Subqueries.propertyIn("userId", detachedCriteria));
		if (roleId > 0) {
			criteria.add(Restrictions.eq("stRmBoRoleMaster.roleId", roleId));
		}
		if (type != null && !"".equals(type)) {
			if (type.equals("Role Head")) {
				criteria.add(Restrictions.eq("isRoleHead", "Y"));
			} else if (type.equals("Sub Users")) {
				criteria.add(Restrictions.eq("isRoleHead", "N"));
			}
		}

		if (status != null && !"".equals(status)) {
			if (status.equalsIgnoreCase("ACTIVE")
					|| status.equalsIgnoreCase("INACTIVE")
					|| status.equalsIgnoreCase("TERMINATE"))
				criteria.add(Restrictions.eq("status", status));
		}

		criteria.add(Restrictions
				.eq("parentUserId", parentUserBean.getUserId()));
		criteria.createAlias("stRmBoRoleMaster", "roleMaster");
		criteria.add(Restrictions.eq("roleMaster.tier", parentUserBean
				.getUserType()));
		//criteria.addOrder(Order.asc("userInfo.firstName"));
		List<StRmBoUserMaster> userMasterList = criteria.list();
		

		Map<Integer,StRmBoUserInfo> map = new HashMap<Integer, StRmBoUserInfo>();
		log.info(map);
		for(StRmBoUserInfo boUserInfo : userInfos){
			map.put(boUserInfo.getUserId(), boUserInfo);
		}
		
		UserDetailsBean userBean;
		String userDepartment;
		
		for (StRmBoUserMaster userMaster : userMasterList) {
			
			userBean = new UserDetailsBean();
			userBean.setUserName(userMaster.getUserName());
			userBean.setFirstName(map.get(userMaster.getUserId()).getFirstName());
			userBean.setLastName(map.get(userMaster.getUserId()).getLastName());
			userBean.setUserId(userMaster.getUserId());
			userBean.setStatus(userMaster.getStatus());
			String isroleHead = userMaster.getIsRoleHead();

			if (isroleHead.equals("Y")) {
				userBean.setBoUserType("Role Head");
			} else if (isroleHead.equals("N")) {
				userBean.setBoUserType("Sub User");
			}
			userDepartment = userMaster.getStRmBoRoleMaster().getRoleName();
			userBean.setDepartment(userDepartment);
			userList.add(userBean);
		}
		return userList;

	}

	public UserDetailsBean showBOUserDetails(int userId, String type,
			Session session) {
		UserDetailsBean userBean = null;

		StRmBoUserMaster stRmBoUserMaster = (StRmBoUserMaster) session.load(
				StRmBoUserMaster.class, userId);
		
		
		Criteria criteria = session.createCriteria(StRmBoUserInfo.class);
		criteria.add(Restrictions.eq("userId", userId));
		
		StRmBoUserInfo boUserInfo = (StRmBoUserInfo) criteria.list().get(0);
		
		userBean = new UserDetailsBean();
		
		
		
		userBean.setFirstName(boUserInfo.getFirstName());
		userBean.setLastName(boUserInfo.getLastName());
		userBean.setEmailId(boUserInfo.getEmailId());
		userBean.setPhoneNbr(boUserInfo.getPhoneNum());
		userBean.setUserName(stRmBoUserMaster.getUserName());
		userBean.setUserId(stRmBoUserMaster.getUserId());
		userBean.setStatus(stRmBoUserMaster.getStatus());
		userBean.setDomainId(stRmBoUserMaster.getDomainId());
		String isroleHead = stRmBoUserMaster.getIsRoleHead();

		if (isroleHead.equals("Y")) {
			userBean.setBoUserType("Head");
		} else if (isroleHead.equals("N")) {
			userBean.setBoUserType("Not Head");
		}

		String userDepartment = stRmBoUserMaster.getStRmBoRoleMaster()
				.getRoleName();
		userBean.setDepartment(userDepartment);

		return userBean;
	}

	public String resetPassBO(int userId, String autoPass, String emailId,
			String userName, String firstName, String lastName, Session session) {

		StRmBoUserMaster stRmBoUserMaster = (StRmBoUserMaster) session.load(
				StRmBoUserMaster.class, userId);
		short autoPasswrd = 1;
		stRmBoUserMaster.setAutoPassword(autoPasswrd);
		stRmBoUserMaster.setPassword(MD5.encode(autoPass));
		session.update(stRmBoUserMaster);
		return autoPass;
	}

	public void editBOUserDetails(int userId, String emailId, String phoneNbr,
			String status, String type, Session session) {
		// because master can not change his status himself thats why it
		// is not displayed at front page and it gives null here
		if (status == null || status.equalsIgnoreCase("downloadCase") || status.equalsIgnoreCase("useractivity")) {
			status = "ACTIVE";
		}
		StRmBoUserMaster stRmBoUserMaster = (StRmBoUserMaster) session.load(
				StRmBoUserMaster.class, userId);
		stRmBoUserMaster.setStatus(status);
		session.update(stRmBoUserMaster);

		Criteria criteria = session.createCriteria(StRmBoUserInfo.class);
		criteria.add(Restrictions.eq("userId", userId));
		List<StRmBoUserInfo> userInfoList = criteria.list();

		userInfoList.get(0).setEmailId(emailId);
		userInfoList.get(0).setPhoneNum(phoneNbr);
		session.update(userInfoList.get(0));
	}
	
	public void editBOUserDetails(int userId, String emailId, String phoneNbr,
			String lastName,String status, String type, Session session) {
		// because master can not change his status himself thats why it
		// is not displayed at front page and it gives null here
		if (status == null || status.equalsIgnoreCase("downloadCase") || status.equalsIgnoreCase("useractivity")) {
			status = "ACTIVE";
		}
		StRmBoUserMaster stRmBoUserMaster = (StRmBoUserMaster) session.load(
				StRmBoUserMaster.class, userId);
		stRmBoUserMaster.setStatus(status);
		session.update(stRmBoUserMaster);

		Criteria criteria = session.createCriteria(StRmBoUserInfo.class);
		criteria.add(Restrictions.eq("userId", userId));
		List<StRmBoUserInfo> userInfoList = criteria.list();

		userInfoList.get(0).setEmailId(emailId);
		userInfoList.get(0).setPhoneNum(phoneNbr);
		userInfoList.get(0).setLastName(lastName);
		
		session.update(userInfoList.get(0));
	}
	
	public String getUserNameById(Session session,Integer userId){
		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		List<StRmBoUserMaster> list = criteria.add(Restrictions.eq("userId", userId)).list();
		return list.get(0).getUserName();
		
	}
	
	public Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> getDomainPriviledges(String tierType, Session session)
			throws ClassNotFoundException {

		
		Integer domainId=0;
		Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> headPriviledgeMap = new TreeMap<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>>();
		Criteria criteria = session.createCriteria(StRmServiceDeliveryMaster.class)
				.setCacheable(true);
		
		criteria.add(Restrictions.eq("domainId", domainId.shortValue()));
		criteria.createAlias("stRmServiceMaster", "serviceMaster");
		criteria.add(Restrictions.eq("serviceMaster.status", "ACTIVE"));
		criteria.add(Restrictions.eq("tier", tierType));
		List<StRmServiceDeliveryMaster> deliveryMasterList = criteria.list();

		TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>> interfaceMap = null;
		for (StRmServiceDeliveryMaster deliveryMaster : deliveryMasterList) {
				
			if("Home".equalsIgnoreCase(deliveryMaster.getServiceDisplayName())){
			
			String privT[] = deliveryMaster.getStRmServiceMaster()
					.getPrivRepTable().split("_");
			StringBuilder privTableName = new StringBuilder();
			privTableName.append(privT[0].substring(0, 1).toUpperCase()
					+ privT[0].substring(1));
			for (int i = 1; i < privT.length; i++) {
				privTableName.append(privT[i].substring(0, 1).toUpperCase()
						+ privT[i].substring(1));
			}

			Class clazz = Class.forName("com.stpl.pms.hibernate.mapping."
					+ privTableName.toString());

			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(StRmBoRolePrivMapping.class);
			detachedCriteria.add(Restrictions.eq("status", "ACTIVE"));
			detachedCriteria.add(Restrictions.eq("sdmId", deliveryMaster
					.getSdmId()));
			detachedCriteria.add(Restrictions.eq("roleId", 2));
			detachedCriteria.setProjection(Projections.distinct(Projections
					.property("privId")));

			criteria = session.createCriteria(StRmBoUserPrivMapping.class);
			
			criteria.add(Restrictions.eq("sdmId", deliveryMaster.getSdmId()));
			criteria.add(Restrictions.eq("roleId", 2));
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			criteria.add(Subqueries.propertyIn("privId", detachedCriteria));
			criteria.setProjection(Projections.projectionList().add(
					Projections.distinct(Projections.property("privId"))).add(
					Projections.property("status")));

			List<Object[]> objArr = criteria.list();
			if(objArr.size()!=0){
				List<Integer> privIdList = new ArrayList<Integer>();
				Map<Integer, String> privStatusMap = new HashMap<Integer, String>();
				for (Object[] obj : objArr) {
					privIdList.add((Integer) obj[0]);
					privStatusMap.put((Integer) obj[0], (String) obj[1]);
				}
	
				criteria = session.createCriteria(clazz);
				criteria.add(Restrictions.eq("privStatus", "ACTIVE"));
				criteria.add(Restrictions.eq("isDefault", "N"));
				criteria.add(Restrictions.in("privId", privIdList));
				criteria.add(Restrictions.eq("tier", tierType));
				criteria.setProjection(Projections.projectionList().add(
						Projections.distinct(Projections.property("privNameCode"))).add(
						Projections.groupProperty("relatedTo")).add(
						Projections.groupProperty("groupNameCode")).add(
						Projections.property("isDefaultGroup")).add(
								Projections.groupProperty("privId")).add(
								Projections.property("dependentPriv")));
	
				List<Object[]> privRepMgmtArr = criteria.list();
	
				String relatedTo = "";
				UserPrivBean privBean;
				String oldRelatedTo = "";
				List<UserPrivBean> groupNameList = null;
	
				if (!headPriviledgeMap.containsKey(deliveryMaster
						.getServiceDisplayName())) {
					interfaceMap = new TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>();
					headPriviledgeMap.put(deliveryMaster.getServiceDisplayName(),
							interfaceMap);
				}
	
				TreeMap<String, List<UserPrivBean>> groupNameMap = null;
				interfaceMap = headPriviledgeMap.get(deliveryMaster
						.getServiceDisplayName());
				TreeMap<String, TreeMap<String, List<UserPrivBean>>> privMap = new TreeMap<String, TreeMap<String, List<UserPrivBean>>>();
				String oldGpNameCode = "";
				String gpNameCode = "";
				String privNameCode = "";
				String oldPrivNameCode = "";
	
				for (Object[] obj1 : privRepMgmtArr) {
					relatedTo = obj1[1].toString();
					privBean = new UserPrivBean();
					gpNameCode = obj1[2].toString();
					privBean.setPrivRelatedTo(relatedTo);
					if (!relatedTo.equals(oldRelatedTo)) {
						groupNameMap = new TreeMap<String, List<UserPrivBean>>();
						oldRelatedTo = relatedTo;
						privMap.put(oldRelatedTo, groupNameMap);
					}
					if (!gpNameCode.equals(oldGpNameCode)) {
						groupNameList = new ArrayList<UserPrivBean>();
						privBean = new UserPrivBean();
						oldGpNameCode = gpNameCode;
						groupNameMap.put(gpNameCode, groupNameList);
					}
					privNameCode = obj1[0].toString();
					if (!privNameCode.equals(oldPrivNameCode)) {
						oldPrivNameCode = privNameCode;
						if (obj1[3].toString().equals("Y")) {
							privNameCode = "*" + privNameCode;
						}
						privBean.setPrivTitle(privNameCode);
						privBean.setStatus(privStatusMap.get((Integer) obj1[4]));
						groupNameList.add(privBean);
					}
				}
				if (privMap.size() > 0) {
					interfaceMap.put(deliveryMaster.getServiceDisplayName() + "-"
							+ deliveryMaster.getSdmId(), privMap);
				}
				if (interfaceMap.size() == 0) {
					headPriviledgeMap
							.remove(deliveryMaster.getServiceDisplayName());
				}
			}
		}
	}

		return headPriviledgeMap;
	}
	
	public String createDomainUser(UserInfoBean userInfoBean, String userName,
			String status, String secQues, String secAns, String firstName,
			String lastName, String gender, String email, String phone,
			String roleIdStr, String ipAddress, Session session,Short domainId, String userType
			,String[] rolePriv,int[] mappingId,int[] privCount,String[] rolePrivRUMMY) {
		status="ACTIVE";
		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.setProjection(Projections.property("userName"));
		List<String> result = criteria.list();

		if (result.size() > 0) {
			return "USER_ALREADY_EXIST";
		}
		Integer roleId = -1;
		roleId = Integer.parseInt(roleIdStr.trim());
		if (roleId <= 0) {
			return "WRONG_ROLE_ID";
		}

		String autoPass = AutoGenerate.autoPassword();

		Short s = 1;
		StRmBoUserMaster stBoUserMaster = new StRmBoUserMaster();
		stBoUserMaster.setParentUserId(userInfoBean.getUserId());
		stBoUserMaster.setStRmBoRoleMaster((StRmBoRoleMaster)session.load(StRmBoRoleMaster.class,Integer.valueOf(roleId.toString())));
				/*new StRmBoRoleMaster(Integer
				.valueOf(roleId.toString())));*/
		stBoUserMaster.setRegistrationDate(new java.sql.Timestamp(new Date()
				.getTime()));
		stBoUserMaster.setLastLoginDate(new java.sql.Timestamp(new Date()
				.getTime()));
		stBoUserMaster.setUserName(userName.trim().toLowerCase());
		stBoUserMaster.setPassword(MD5.encode(autoPass));
		stBoUserMaster.setLastLoginIp("");
		stBoUserMaster.setAutoPassword(s);
		stBoUserMaster.setStatus(status);
		stBoUserMaster.setSecQues(secQues);
		stBoUserMaster.setSecAns(secAns);
		stBoUserMaster.setIsRoleHead("Y");
		stBoUserMaster.setDomainId(domainId);
		stBoUserMaster.setUserType(userType);
		stBoUserMaster.setInvalidLoginTry((short)0);

		Integer newUserId = (Integer) session.save(stBoUserMaster);

		StRmBoUserInfo stBoUserInfo = new StRmBoUserInfo();
		stBoUserInfo.setUserId(newUserId);
		//stBoUserInfo.setStRmBoUserMaster(stBoUserMaster);
		stBoUserInfo.setFirstName(firstName);
		stBoUserInfo.setLastName(lastName);
		stBoUserInfo.setGender(gender);
		stBoUserInfo.setEmailId(email);
		stBoUserInfo.setPhoneNum(phone);
		stBoUserInfo.setAddressLine1("address");
		stBoUserInfo.setCity("gurgaon");
		stBoUserInfo.setCountryCode("IN");
		stBoUserInfo.setStateCode("RJ");
		stBoUserInfo.setPostalCode("122002");
		//stBoUserInfo.setStRmBoUserMaster(stBoUserMaster);
		session.save(stBoUserInfo);	
		
		//		
		saveDomainUserPriviledge(rolePriv, privCount, userType,
				newUserId, ""+roleIdStr,domainId,rolePrivRUMMY,session);
		//
		

		 log.info("mail sent after commit");
		return autoPass;

	}
	

	public void saveDomainUserPriviledge(String[] rolePriv,int[] privCount,String tier,Integer userId ,String roleId,Short domainId,String[] rolePrivRUMMY,Session session){
		
		try{ 
			Integer bomasterService=0;
			Criteria criteria = session
					.createCriteria(StRmServiceDeliveryMaster.class);
			criteria.add(Restrictions.eq("tier", tier));
			criteria.add(Restrictions.eq( "domainId", bomasterService.shortValue()));
			criteria.createAlias("stRmServiceMaster", "serviceMaster");			
			criteria.add(Restrictions.eq("serviceMaster.status", "ACTIVE"));
			List<StRmServiceDeliveryMaster> deliveryMasterList = criteria.list();
			StRmServiceDeliveryMaster stRmServiceDeliveryMaster =null;
			int[] mappingId=new int[deliveryMasterList.size()];
			int index=0;
			for (StRmServiceDeliveryMaster deliveryMaster : deliveryMasterList) {
				if(!deliveryMaster.getServiceDisplayName().equalsIgnoreCase("RUMMY")){
					
					stRmServiceDeliveryMaster=new StRmServiceDeliveryMaster();
					stRmServiceDeliveryMaster.setStRmServiceMaster(deliveryMaster.getStRmServiceMaster());
					stRmServiceDeliveryMaster.setDomainId(domainId);
					stRmServiceDeliveryMaster.setTier("DOMAIN");
					stRmServiceDeliveryMaster.setInterfaceType(deliveryMaster.getInterfaceType());
					stRmServiceDeliveryMaster.setServiceDisplayName(deliveryMaster.getServiceDisplayName());
					stRmServiceDeliveryMaster.setStatus("ACTIVE");
					stRmServiceDeliveryMaster.setMenuOrder(deliveryMaster.getMenuOrder());	
					session.save(stRmServiceDeliveryMaster);
					session.flush();
					mappingId[index]=stRmServiceDeliveryMaster.getSdmId();
					++index;
				
				String privT[] = deliveryMaster.getStRmServiceMaster()
						.getPrivRepTable().split("_");
				StringBuilder privTableName = new StringBuilder();
				privTableName.append(privT[0].substring(0, 1).toUpperCase()
						+ privT[0].substring(1));
				for (int i = 1; i < privT.length; i++) {
					privTableName.append(privT[i].substring(0, 1).toUpperCase()
							+ privT[i].substring(1));
				}
	
				Class clazz = Class.forName("com.stpl.pms.hibernate.mapping."
						+ privTableName.toString());
	
				DetachedCriteria detachedCriteria = DetachedCriteria
						.forClass(StRmBoRolePrivMapping.class);
				detachedCriteria.add(Restrictions.eq("status", "ACTIVE"));
				detachedCriteria.add(Restrictions.eq("sdmId", deliveryMaster
						.getSdmId()));
				detachedCriteria.add(Restrictions.eq("roleId",  Integer.parseInt(roleId)));
				detachedCriteria.setProjection(Projections.distinct(Projections
						.property("privId")));
	
				criteria = session.createCriteria(StRmBoUserPrivMapping.class);				
				criteria.add(Restrictions.eq("sdmId", deliveryMaster.getSdmId()));
				criteria.add(Restrictions.eq("roleId", Integer.parseInt(roleId)));
				criteria.add(Subqueries.propertyIn("privId", detachedCriteria));
				criteria.setProjection(Projections.distinct(Projections
						.property("privId")));
	
				List<Integer> privIdList = criteria.list();
	
				criteria = session.createCriteria(clazz);
				criteria.add(Restrictions.in("privId", privIdList));
				criteria.setProjection(Projections.projectionList().add(
						Projections.groupProperty("privId")).add(
						Projections.property("isDefault")));
	
				List<Object[]> privMgmtArr = criteria.list();
				
				
				StRmBoRolePrivMapping stRmBoRolePrivMapping =null;
				for (Object[] obj : privMgmtArr) {
					stRmBoRolePrivMapping = new StRmBoRolePrivMapping();
					stRmBoRolePrivMapping.setRoleId(Integer.parseInt(roleId));
					stRmBoRolePrivMapping.setPrivId((Integer) obj[0]);
					stRmBoRolePrivMapping.setSdmId(stRmServiceDeliveryMaster.getSdmId());
					stRmBoRolePrivMapping.setStatus("ACTIVE");
					session.save(stRmBoRolePrivMapping);
					session.flush();
				}
				
	
				StRmBoUserPrivMapping stRmBoUserPrivMapping = null;
				for (Object[] obj : privMgmtArr) {
					stRmBoUserPrivMapping = new StRmBoUserPrivMapping();
					stRmBoUserPrivMapping.setPrivId((Integer) obj[0]);
					if (obj[1].toString().equals("Y"))
						stRmBoUserPrivMapping.setStatus("ACTIVE");
					else
						stRmBoUserPrivMapping.setStatus("INACTIVE");
					stRmBoUserPrivMapping.setRoleId(Integer.parseInt(roleId));
					stRmBoUserPrivMapping.setSdmId(stRmServiceDeliveryMaster.getSdmId());
					stRmBoUserPrivMapping.setUserId(userId);
					session.save(stRmBoUserPrivMapping);
					session.flush();
				}
			}
			else{
						stRmServiceDeliveryMaster=new StRmServiceDeliveryMaster();
						stRmServiceDeliveryMaster.setStRmServiceMaster(deliveryMaster.getStRmServiceMaster());
						stRmServiceDeliveryMaster.setDomainId(domainId);
						stRmServiceDeliveryMaster.setTier("DOMAIN");
						stRmServiceDeliveryMaster.setInterfaceType(deliveryMaster.getInterfaceType());
						stRmServiceDeliveryMaster.setServiceDisplayName(deliveryMaster.getServiceDisplayName());
						if(rolePrivRUMMY!=null)
							stRmServiceDeliveryMaster.setStatus("ACTIVE");
						else
							stRmServiceDeliveryMaster.setStatus("INACTIVE");
						stRmServiceDeliveryMaster.setMenuOrder(deliveryMaster.getMenuOrder());	
						session.save(stRmServiceDeliveryMaster);
						session.flush();
				}
			
		}
			StringBuilder grpName = null;
			StringBuilder strMappingId = new StringBuilder("");
			String grpNameStr = null;
			int privIdFrm = 0;
			int privIdTo = 0;
			String activeMapIds = "";
			HashMap<Integer, String> privMap = new HashMap<Integer, String>();
			for (int i = 0; i < mappingId.length; i++) {
				if (privCount[i] != 0) {
					grpName = new StringBuilder("");
					privIdTo = privIdTo + privCount[i];
					for (int j = privIdFrm; j < privIdTo; j++) {
						grpName.append("'" + rolePriv[j] + "',");
						privIdFrm++;
					}
					grpNameStr = grpName.substring(0, grpName.length() - 1);
					grpNameStr = grpNameStr.replace("*", "");
					activeMapIds = activeMapIds + mappingId[i] + ",";
					privMap.put(mappingId[i], grpNameStr);
				}
				strMappingId.append(mappingId[i] + ",");
			}
			strMappingId.deleteCharAt(strMappingId.length() - 1);
			List<String> ls =  Arrays.asList(strMappingId.toString().replace("'", "").split("\\s*,\\s*"));
			List<Short> list= new ArrayList<Short>();
			for(String l:ls){
				list.add(Short.valueOf(l));
			}
			criteria = session.createCriteria(StRmServiceDeliveryMaster.class);
			criteria.add(Restrictions.eq( "domainId", domainId));
			criteria.add(Restrictions.in("sdmId",list));
			criteria.setProjection(Projections.projectionList().add(
					Projections.distinct(Projections.property("sdmId"))).add(
					Projections.property("stRmServiceMaster")));
	
			List<Object[]> objArr = criteria.list();
	
			for (Object[] obj : objArr) {
				
				if (privMap.get(Integer.parseInt(obj[0].toString())) != null) {
					StRmServiceMaster master = (StRmServiceMaster)obj[1];
					String privT[] = master.getPrivRepTable().split("_");
					
					StringBuilder privTableName = new StringBuilder();
					//privTableName = master.getPrivRepTable();
					privTableName.append(privT[0].substring(0, 1).toUpperCase()
							+ privT[0].substring(1));
					for (int i = 1; i < privT.length; i++) {
						privTableName.append(privT[i].substring(0, 1).toUpperCase()
								+ privT[i].substring(1));
					}
	
					Class clazz = Class.forName("com.stpl.pms.hibernate.mapping."
							+ privTableName.toString());
					criteria = session.createCriteria(clazz);
					criteria.add(Restrictions.eq("privStatus", "ACTIVE"));
					criteria.add(Restrictions.in("privNameCode", Arrays
							.asList(privMap.get(Integer.parseInt(obj[0].toString())).replace("'", "").split(
									"\\s*,\\s*"))));
					criteria.add(Restrictions.isNotNull("dependentPriv"));
					criteria.setProjection(Projections.distinct(Projections
							.property("dependentPriv")));
					List<String> dependentPrivList = criteria.list();
	
					StringBuilder depPriv = new StringBuilder("");
					for (String dependentPriv : dependentPrivList) {
						if (depPriv == null) {
							depPriv = new StringBuilder();
						}
						depPriv.append(dependentPriv).append(",");
					}
	
					String depPrivs = null;
					if (depPriv != null) {
						depPrivs = depPriv.toString().replaceAll(",$", "");
					}
					
					@SuppressWarnings("unused")
					List<String> temp = Arrays.asList(
							privMap.get(Integer.parseInt(obj[0].toString())).replace("'", "").split("\\s*,\\s*"));
					
					DetachedCriteria dcCriteria = DetachedCriteria.forClass(clazz);
					dcCriteria.setProjection(Projections.distinct(Projections
							.property("privId")));
					dcCriteria.add(Restrictions.eq("privStatus", "ACTIVE"));
					
					if(depPrivs.equals("")|| depPrivs.equals(null)){
						dcCriteria.add(Restrictions.or(Restrictions
								.eq("isDefault", "Y"), Restrictions.in(
								"privNameCode", Arrays.asList(
							privMap.get(Integer.parseInt(obj[0].toString())).replace("'", "").split("\\s*,\\s*")))
								));
						
					}
					else{
						dcCriteria.add(Restrictions.or(Restrictions
								.eq("isDefault", "Y"), Restrictions.or(Restrictions.in(
								"privNameCode", Arrays.asList(
										privMap.get(Integer.parseInt(obj[0].toString())).replace("'", "").split("\\s*,\\s*"))),
								Restrictions.in("privId", Arrays.asList(depPrivs
										.split("\\s*,\\s*"))))));
					}
					dcCriteria.getExecutableCriteria(session).list();
					//List<Integer>list1 =
					criteria = session.createCriteria(StRmBoUserPrivMapping.class);
					criteria.add(Subqueries.propertyIn("privId", dcCriteria));
					criteria.add(Restrictions.eq("sdmId", Short.valueOf(obj[0].toString())));
					criteria.add(Restrictions.eq("roleId",Integer.parseInt(roleId)));
	
					List<StRmBoUserPrivMapping> userPriMappingList = criteria.list();
					for (StRmBoUserPrivMapping userMapping : userPriMappingList) {
						userMapping.setStatus("ACTIVE");
						session.update(userMapping);
					}
				}
			}
	
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean checkRummyServiceAvailable(String tier,Session session){
		
		boolean rummyServiceAvailable=false;
		Integer domainId=0;
		Criteria criteria = session
				.createCriteria(StRmServiceDeliveryMaster.class)
				.setCacheable(true);
		criteria.add(Restrictions.eq("tier", tier));
		criteria.add(Restrictions.eq("domainId", domainId.shortValue()));
		criteria.createAlias("stRmServiceMaster", "serviceMaster");
		criteria.add(Restrictions.eq("serviceMaster.status", "ACTIVE"));
		List<StRmServiceDeliveryMaster> deliveryMasterList = criteria.list();
		
		for (StRmServiceDeliveryMaster deliveryMaster : deliveryMasterList) {
			if(deliveryMaster.getServiceDisplayName().equalsIgnoreCase("RUMMY"))
				rummyServiceAvailable=true;
		}
		
		
		return rummyServiceAvailable;
	}
	
	public List<String> fetchDomainUserName(int roleId, int userId, Session session) {
		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		criteria.add(Restrictions.eq("stRmBoRoleMaster.roleId", roleId));
		criteria.add(Restrictions.eq("parentUserId", userId));
		criteria.addOrder(Order.asc("userName"));
		criteria.setProjection(Projections.property("userName"));
		List<String> userList = criteria.list();
		return userList;
	}
	
	public Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> getDomainUserPriviledges(
			String userName, String tierType, Session session)
			throws ClassNotFoundException {

		Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> headPriviledgeMap = new TreeMap<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>>();
		Integer roleId = 0, userId = 0;
		Short domainId=0;

		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.setProjection(Projections.projectionList().add(
				Projections.property("userId")).add(
				Projections.property("stRmBoRoleMaster.roleId")).add(Projections.property("domainId")));

		List<Object[]> list = criteria.list();
		if (list.size() > 0) {
			userId = (Integer) list.get(0)[0];
			roleId = (Integer) list.get(0)[1];
			domainId=(Short) list.get(0)[2];
		}

		criteria = session.createCriteria(StRmServiceDeliveryMaster.class);
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		criteria.add(Restrictions.eq("domainId", domainId));
		criteria.createAlias("stRmServiceMaster", "serviceMaster");
		criteria.add(Restrictions.eq("serviceMaster.status", "ACTIVE"));
		criteria.add(Restrictions.eq("tier", tierType));
		List<StRmServiceDeliveryMaster> deliveryMasterList = criteria.list();

		TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>> interfaceMap = null;
		for (StRmServiceDeliveryMaster deliveryMaster : deliveryMasterList) {
				
			if(!deliveryMaster.getServiceDisplayName().equalsIgnoreCase("rummy")){
			
			String privT[] = deliveryMaster.getStRmServiceMaster()
					.getPrivRepTable().split("_");
			StringBuilder privTableName = new StringBuilder();
			privTableName.append(privT[0].substring(0, 1).toUpperCase()
					+ privT[0].substring(1));
			for (int i = 1; i < privT.length; i++) {
				privTableName.append(privT[i].substring(0, 1).toUpperCase()
						+ privT[i].substring(1));
			}

			Class clazz = Class.forName("com.stpl.pms.hibernate.mapping."
					+ privTableName.toString());

			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(StRmBoRolePrivMapping.class);
			detachedCriteria.add(Restrictions.eq("status", "ACTIVE"));
			detachedCriteria.add(Restrictions.eq("sdmId", deliveryMaster
					.getSdmId()));
			detachedCriteria.add(Restrictions.eq("roleId", roleId));
			detachedCriteria.setProjection(Projections.distinct(Projections
					.property("privId")));

			criteria = session.createCriteria(StRmBoUserPrivMapping.class);
			criteria.add(Restrictions.ne("status", "NA"));
			criteria.add(Restrictions.eq("userId", userId));
			criteria.add(Restrictions.eq("sdmId", deliveryMaster.getSdmId()));
			criteria.add(Restrictions.eq("roleId", roleId));
			criteria.add(Subqueries.propertyIn("privId", detachedCriteria));
			criteria.setProjection(Projections.projectionList().add(
					Projections.distinct(Projections.property("privId"))).add(
					Projections.property("status")));

			List<Object[]> objArr = criteria.list();
			if(objArr.size()!=0){
				List<Integer> privIdList = new ArrayList<Integer>();
				Map<Integer, String> privStatusMap = new HashMap<Integer, String>();
				for (Object[] obj : objArr) {
					privIdList.add((Integer) obj[0]);
					privStatusMap.put((Integer) obj[0], (String) obj[1]);
				}
	
				criteria = session.createCriteria(clazz);
				criteria.add(Restrictions.eq("privStatus", "ACTIVE"));
				criteria.add(Restrictions.eq("isDefault", "N"));
				criteria.add(Restrictions.in("privId", privIdList));
				criteria.add(Restrictions.eq("tier", tierType));
				criteria.setProjection(Projections.projectionList().add(
						Projections.distinct(Projections.property("privNameCode"))).add(
						Projections.groupProperty("relatedTo")).add(
						Projections.groupProperty("groupNameCode")).add(
						Projections.property("isDefaultGroup")).add(
								Projections.groupProperty("privId")).add(
								Projections.property("dependentPriv")));
	
				List<Object[]> privRepMgmtArr = criteria.list();
	
				String relatedTo = "";
				UserPrivBean privBean;
				String oldRelatedTo = "";
				List<UserPrivBean> groupNameList = null;
	
				if (!headPriviledgeMap.containsKey(deliveryMaster
						.getServiceDisplayName())) {
					interfaceMap = new TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>();
					headPriviledgeMap.put(deliveryMaster.getServiceDisplayName(),
							interfaceMap);
				}
	
				TreeMap<String, List<UserPrivBean>> groupNameMap = null;
				interfaceMap = headPriviledgeMap.get(deliveryMaster
						.getServiceDisplayName());
				TreeMap<String, TreeMap<String, List<UserPrivBean>>> privMap = new TreeMap<String, TreeMap<String, List<UserPrivBean>>>();
				String oldGpNameCode = "";
				String gpNameCode = "";
				String privNameCode = "";
				String oldPrivNameCode = "";
	
				for (Object[] obj1 : privRepMgmtArr) {
					relatedTo = obj1[1].toString();
					privBean = new UserPrivBean();
					gpNameCode = obj1[2].toString();
					privBean.setPrivRelatedTo(relatedTo);
					if (!relatedTo.equals(oldRelatedTo)) {
						groupNameMap = new TreeMap<String, List<UserPrivBean>>();
						oldRelatedTo = relatedTo;
						privMap.put(oldRelatedTo, groupNameMap);
					}
					if (!gpNameCode.equals(oldGpNameCode)) {
						groupNameList = new ArrayList<UserPrivBean>();
						privBean = new UserPrivBean();
						oldGpNameCode = gpNameCode;
						groupNameMap.put(gpNameCode, groupNameList);
					}
					privNameCode = obj1[0].toString();
					if (!privNameCode.equals(oldPrivNameCode)) {
						oldPrivNameCode = privNameCode;
						if (obj1[3].toString().equals("Y")) {
							privNameCode = "*" + privNameCode;
						}
						privBean.setPrivTitle(privNameCode);
						privBean.setStatus(privStatusMap.get((Integer) obj1[4]));
						groupNameList.add(privBean);
					}
				}
				if (privMap.size() > 0) {
					interfaceMap.put(deliveryMaster.getServiceDisplayName() + "-"
							+ deliveryMaster.getSdmId(), privMap);
				}
				if (interfaceMap.size() == 0) {
					headPriviledgeMap
							.remove(deliveryMaster.getServiceDisplayName());
					}
				}
			}
		}

		return headPriviledgeMap;
	}
	
	public void editDomainUserPriviledges(String userName, String[] rolePriv,
			int[] mappingId, int[] privCount,String rolePrivRUMMY[], Session session)
			throws ClassNotFoundException {
		int userId = 0, roleId = 0;
		Short domainId=0;

		Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.setProjection(Projections.projectionList().add(
				Projections.property("userId")).add(
				Projections.property("stRmBoRoleMaster.roleId")).add(Projections.property("domainId")));
		List<Object[]> list = criteria.list();

		userId = (Integer) list.get(0)[0];
		roleId = (Integer) list.get(0)[1];
		domainId= (Short)list.get(0)[2];
		
		for (int element : mappingId) {
			criteria = session.createCriteria(StRmBoUserPrivMapping.class);
			criteria.add(Restrictions.eq("userId", userId));
			criteria.add(Restrictions.eq("roleId", roleId));
			criteria.add(Restrictions.eq("sdmId",Short.valueOf(String.valueOf(element))));
			criteria.add(Restrictions.ne("status", "NA"));
			List<StRmBoUserPrivMapping> userMappingList = criteria.list();
			for (StRmBoUserPrivMapping userPrivMapping : userMappingList) {
				userPrivMapping.setStatus("INACTIVE");
				session.update(userPrivMapping);
			}
		}

		StringBuilder grpName = null;
		List<Short> strMappingIds = new ArrayList<Short>();
		
		String grpNameStr = null;
		int privIdFrm = 0;
		int privIdTo = 0;
		String activeMapIds = "";
		HashMap<Integer, String> privMap = new HashMap<Integer, String>();
		for (int i = 0; i < mappingId.length; i++) {
			if (privCount[i] != 0) {
				grpName = new StringBuilder("");
				privIdTo = privIdTo + privCount[i];
				for (int j = privIdFrm; j < privIdTo; j++) {
					grpName.append("'" + rolePriv[j] + "',");
					privIdFrm++;
				}
				grpNameStr = grpName.substring(0, grpName.length() - 1);
				grpNameStr = grpNameStr.replace("*", "");
				activeMapIds = activeMapIds + mappingId[i] + ",";
				privMap.put(mappingId[i], grpNameStr);
			}
			strMappingIds.add(Short.valueOf(String.valueOf(mappingId[i])));
		}
		
		criteria = session.createCriteria(StRmServiceDeliveryMaster.class);
		criteria.setCacheable(true);
		criteria.add(Restrictions.eq("domainId", domainId));
		criteria.add(Restrictions.eq("serviceDisplayName", "Rummy"));
		List<StRmServiceDeliveryMaster> deliveryMasterList = criteria.list();
		StRmServiceDeliveryMaster stRmServiceDeliveryMaster=(StRmServiceDeliveryMaster)deliveryMasterList.get(0);
		
		if(rolePrivRUMMY!=null){
			stRmServiceDeliveryMaster.setStatus("Active");			
		}
		else{
			stRmServiceDeliveryMaster.setStatus("InActive");
		}
		session.update(stRmServiceDeliveryMaster);
		
		criteria = session.createCriteria(StRmServiceDeliveryMaster.class)
		.createAlias("stRmServiceMaster", "serviceMaster");
		criteria.add(Restrictions.in("sdmId",strMappingIds));
		criteria.add(Restrictions.eq("domainId",domainId));
		criteria.setProjection(Projections.projectionList().add(
				Projections.property("sdmId")).add(
				Projections.property("serviceMaster.privRepTable")));
		List<Object[]> fetchPrivTableList = criteria.list();

		for (Object[] obj : fetchPrivTableList) {
			if (privMap.get(Integer.valueOf(obj[0].toString())) != null) {

				String privT[] = obj[1].toString().split("_");
				StringBuilder privTableName = new StringBuilder();
				privTableName.append(privT[0].substring(0, 1).toUpperCase()
						+ privT[0].substring(1));
				for (int i = 1; i < privT.length; i++) {
					privTableName.append(privT[i].substring(0, 1).toUpperCase()
							+ privT[i].substring(1));
				}

				Class clazz = Class.forName("com.stpl.pms.hibernate.mapping."
						+ privTableName.toString());

				criteria = session.createCriteria(clazz);
				criteria.add(Restrictions.eq("privStatus", "ACTIVE"));
				criteria.add(Restrictions.in("privNameCode", Arrays
						.asList(privMap.get(Integer.valueOf(obj[0].toString())).toString()
								.replace("'", "").split(
								"\\s*,\\s*"))));
				criteria.add(Restrictions.isNotNull("dependentPriv"));
				criteria.setProjection(Projections.distinct(Projections
						.property("dependentPriv")));
				List<String> dependentPrivList = criteria.list();

				StringBuilder depPriv = null;
				for (String dependentPriv : dependentPrivList) {
					if (depPriv == null) {
						depPriv = new StringBuilder();
					}
					depPriv.append(dependentPriv).append(",");
				}

				String depPrivs = null;
				if (depPriv != null) {
					depPrivs = depPriv.toString().replaceAll(",$", "");
				}
				DetachedCriteria dcCriteria = DetachedCriteria.forClass(clazz);
				dcCriteria.setProjection(Projections.distinct(Projections
						.property("privId")));
				dcCriteria.add(Restrictions.eq("privStatus", "ACTIVE"));
				if (depPrivs != null) {
					
					dcCriteria.add(Restrictions.or(Restrictions
							.eq("isDefault", "Y"), Restrictions.or(Restrictions.in(
							"privNameCode", Arrays.asList(privMap.get(
									Integer.valueOf(obj[0].toString())).replace("'", "").split("\\s*,\\s*"))),
							Restrictions.in("privId", Arrays.asList(depPrivs
									.split("\\s*,\\s*"))))));
				}
				else{
					dcCriteria.add(Restrictions.or(Restrictions
							.eq("isDefault", "Y"), 
									Restrictions.in("privNameCode", Arrays.asList(privMap.get(
									Integer.valueOf(obj[0].toString())).replace("'", "").split("\\s*,\\s*")))
							));
				}
				
			
				dcCriteria.getExecutableCriteria(session).list();
				criteria = session.createCriteria(StRmBoUserPrivMapping.class);
				criteria.add(Subqueries.propertyIn("privId", dcCriteria));
				criteria.add(Restrictions.eq("sdmId", Short.valueOf(obj[0].toString())));
				criteria.add(Restrictions.eq("roleId", roleId));
				criteria.add(Restrictions.eq("userId", userId));

				List<StRmBoUserPrivMapping> userPriMappingList = criteria
						.list();
				for (StRmBoUserPrivMapping userMapping : userPriMappingList) {
					userMapping.setStatus("ACTIVE");
					session.update(userMapping);
				}

			}
		}
	}
	   
	public UserInfoBean getInpersonatedBean(Integer boUserId, Session session)
			throws PMSException {
		UserInfoBean userInfo = null;
		try {
				StRmBoUserMaster userMaster = (StRmBoUserMaster) session.load(StRmBoUserMaster.class, boUserId);
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

	public Map<Integer, String> getBoUserMap(Integer selfId,Session session) {
		Map<Integer, String> retMap= new HashMap<Integer, String>();
		List<Object[]> boUsrMasterList = session
				.createCriteria(StRmBoUserMaster.class)
				.add(Restrictions.ne("userId", selfId))
				.add(Restrictions.eq("status", "ACTIVE"))
				.setProjection(Projections.projectionList()
						.add(Projections.property("userId"))
						.add(Projections.property("userName")))
						.list();
		
		for(Object[] user:boUsrMasterList)
			retMap.put((Integer)user[0], (String)user[1]);
		return retMap;
	}
}
