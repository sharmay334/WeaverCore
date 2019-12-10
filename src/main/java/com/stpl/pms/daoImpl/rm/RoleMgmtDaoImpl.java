package com.stpl.pms.daoImpl.rm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import com.stpl.pms.hibernate.mapping.ActionFunctionMappingInterface;
import com.stpl.pms.hibernate.mapping.PrivilegeRepMgmtInterface;
import com.stpl.pms.hibernate.mapping.StRmActionFunctionMappingMgmt;
import com.stpl.pms.hibernate.mapping.StRmBoRoleMaster;
import com.stpl.pms.hibernate.mapping.StRmBoRolePrivMapping;
import com.stpl.pms.hibernate.mapping.StRmBoUserMaster;
import com.stpl.pms.hibernate.mapping.StRmBoUserPrivMapping;
import com.stpl.pms.hibernate.mapping.StRmMenuMasterMgmt;
import com.stpl.pms.hibernate.mapping.StRmPrivilegeRepMgmt;
import com.stpl.pms.hibernate.mapping.StRmServiceDeliveryMaster;
import com.stpl.pms.hibernate.mapping.StRmServiceMaster;
import com.stpl.pms.javabeans.DefPrivBean;
import com.stpl.pms.javabeans.DefPrivTemp1;
import com.stpl.pms.javabeans.LoginBean;
import com.stpl.pms.javabeans.PrivFunctionBean;
import com.stpl.pms.javabeans.PriviledgeBean;
import com.stpl.pms.javabeans.PrivilegeManagementBean;
import com.stpl.pms.javabeans.UserInfoBean;
import com.stpl.pms.javabeans.UserPrivBean;

@SuppressWarnings("unchecked")
public class RoleMgmtDaoImpl {

	private static final Logger log = Logger.getLogger(RoleMgmtDaoImpl.class);

	public void fetchActivePriv(String interfaceType, int userId, int roleId,
			LoginBean loginBean, String userType,Short domainId, Session session) {
		log.info("Start Fetching Active Priviledgel");
		try {
			LinkedHashMap<String, LinkedHashMap<String, ArrayList<PriviledgeBean>>> serPrivMap = new LinkedHashMap<String, LinkedHashMap<String, ArrayList<PriviledgeBean>>>();

			StringBuilder privStr = new StringBuilder("");
			Map<String, PrivFunctionBean> actionPrivFunctionMap = new HashMap<String, PrivFunctionBean>();
			Set<Entry<String, ArrayList<PriviledgeBean>>> menuSet = new HashSet<Entry<String, ArrayList<PriviledgeBean>>>();

			Criteria criteria = session
					.createCriteria(StRmServiceDeliveryMaster.class).setCacheable(true);
			criteria.add(Restrictions.eq("interfaceType", interfaceType));
			criteria.add(Restrictions.eq("tier", userType));
			if(domainId!=1){
				criteria.add(Restrictions.eq("domainId", domainId));
				criteria.add(Restrictions.eq("status", "ACTIVE"));
			}
			criteria.addOrder(Order.asc("menuOrder"));
			criteria.createAlias("stRmServiceMaster", "serviceMaster").add(
					Restrictions.eq("serviceMaster.status", "ACTIVE"));
			List<StRmServiceDeliveryMaster> serviceDeliveryMasterList = criteria
					.list();
			for (StRmServiceDeliveryMaster serviceDeliveryMaster : serviceDeliveryMasterList) {
				LinkedHashMap<String, ArrayList<PriviledgeBean>> privMap = new LinkedHashMap<String, ArrayList<PriviledgeBean>>();
				serPrivMap.put(serviceDeliveryMaster.getServiceDisplayName()
						+ "~"
						+ serviceDeliveryMaster.getStRmServiceMaster()
								.getServiceCode(), privMap);
				
				criteria = session.createCriteria(StRmBoRolePrivMapping.class).add(
						Restrictions.eq("status", "ACTIVE"));
				criteria.add(Restrictions.eq("roleId", roleId));
				criteria.add(Restrictions.eq("sdmId", serviceDeliveryMaster
						.getSdmId()));
				criteria.setProjection(Projections.distinct(Projections
						.property("roleId")));
				List<Integer> roleIdList = criteria.list();
				
				
				criteria = session.createCriteria(StRmBoUserPrivMapping.class);
				criteria.add(Restrictions.eq("status", "ACTIVE"));
				criteria.add(Restrictions.eq("sdmId", serviceDeliveryMaster
						.getSdmId()));
				if (roleIdList != null && roleIdList.size() > 0) {
					criteria.add(Restrictions.in("roleId", roleIdList));
				}
				criteria.add(Restrictions.eq("userId", userId));
				criteria.setProjection(Projections.distinct(Projections
						.property("privId")));
				List<Integer> privIdList = criteria.list();
				
				if (privIdList.size() != 0) {
					String privTlbName = "com.stpl.pms.hibernate.mapping."+WordUtils.capitalize(
							serviceDeliveryMaster.getStRmServiceMaster()
									.getPrivRepTable().replace("_", " "))
							.replace(" ", "");
					criteria = session.createCriteria(Class
							.forName(privTlbName));
					criteria.add(Restrictions.eq("privStatus", "ACTIVE"));
					criteria.add(Restrictions.eq("tier", userType));
					criteria.add(Restrictions.in("privId", privIdList));

					List<PrivilegeRepMgmtInterface> privRepList = criteria.list();

					List<Integer> fnIdList = new ArrayList<Integer>();
					for (PrivilegeRepMgmtInterface privRep : privRepList) {
						fnIdList.add(privRep.getFnId());
					}

					String menuTlbName = "com.stpl.pms.hibernate.mapping."+WordUtils.capitalize(
							serviceDeliveryMaster.getStRmServiceMaster()
									.getMenuMasterTable().replace("_", " "))
							.replace(" ", "");
					criteria = session.createCriteria(Class.forName(menuTlbName));
					criteria.setProjection(Projections.property("actionId"));
					List<Integer> actionIdList = criteria.list();
					
					String actionFnTlbName = "com.stpl.pms.hibernate.mapping.StRmActionFunctionMappingMgmt";
					if(menuTlbName.contains("Casino")){
						actionFnTlbName = "com.stpl.pms.hibernate.mapping.StRmActionFunctionMappingCasino";
					}

					criteria = session.createCriteria(Class.forName(actionFnTlbName));
					criteria.add(Restrictions.in("fnId", fnIdList));
					criteria.add(Restrictions.in("actionId", actionIdList));
					criteria.setProjection(Projections.projectionList().add(
							Projections.distinct(Projections
									.property("actionName"))).add(
							Projections.property("fnId")).add(
							Projections.property("actionUrl")));

					// criteria.setResultTransformer(Transformers.aliasToBean(StRmActionFunctionMappingMgmt.class));

					List<Object[]> funActionMenuList = criteria.list();
					// List<StRmActionFunctionMappingMgmt> menuActionFunList =
					// criteria.list();

					Map<Integer, PrivilegeRepMgmtInterface> funPrivMap = new HashMap<Integer, PrivilegeRepMgmtInterface>();
					for (PrivilegeRepMgmtInterface privMgmt : privRepList) {
						funPrivMap.put(privMgmt.getFnId(), privMgmt);
					}

					
					PrivFunctionBean privFunctionBean = null;
					Set<String> functionSet = null;
					Set<Integer> privSet = null;

					criteria = session.createCriteria(Class.forName(actionFnTlbName));
					criteria.add(Restrictions.in("fnId", fnIdList));
					List<ActionFunctionMappingInterface> actionFunList = criteria
							.list();

					for (ActionFunctionMappingInterface actionFunMappingMgmt : actionFunList) {
//						if (actionFunMappingMgmt.getActionName().equalsIgnoreCase("bo_um_boUserReg_Save")) {
//							System.out.println("hello");
//						}
						privFunctionBean = actionPrivFunctionMap
								.get(actionFunMappingMgmt.getActionName());
						if (privFunctionBean == null) {
							privFunctionBean = new PrivFunctionBean();
						}
						functionSet = privFunctionBean.getFunctionSet();
						privSet = privFunctionBean.getPrivSet();
						if (functionSet == null || privSet == null) {
							functionSet = new HashSet<String>();
							privSet = new HashSet<Integer>();
						}
						functionSet.add(funPrivMap.get(
								actionFunMappingMgmt.getFnId())
								.getFunctionName());
						privSet.add(funPrivMap.get(
								actionFunMappingMgmt.getFnId()).getPrivId());
						privFunctionBean.setFunctionSet(functionSet);
						privFunctionBean.setPrivSet(privSet);
						actionPrivFunctionMap.put(actionFunMappingMgmt
								.getActionName(), privFunctionBean);
					}
					ArrayList<PriviledgeBean> privList;
					PriviledgeBean privBean;

					for (Object[] obj : funActionMenuList) {
						PrivilegeRepMgmtInterface privRepMgmt = funPrivMap.get((Integer) obj[1]);
						privList = privMap.get(privRepMgmt.getRelatedTo());
						if (privList == null) {
							privList = new ArrayList<PriviledgeBean>();
						}
						privBean = new PriviledgeBean();
						privBean.setPrivTitle(privRepMgmt.getGroupNameCode());
						privBean.setActionMapping(obj[0].toString());
						privBean.setActionUrl(obj[2].toString());
						privBean.setRelatedTo(privRepMgmt.getRelatedTo());
						privList.add(privBean);
						privMap.put(privRepMgmt.getRelatedTo(), privList);
					}
				}
			}
			// }
			// }

			Iterator<Map.Entry<String, LinkedHashMap<String, ArrayList<PriviledgeBean>>>> iter = serPrivMap
					.entrySet().iterator();

			while (iter.hasNext()) {
				Entry<String, LinkedHashMap<String, ArrayList<PriviledgeBean>>> pair = (Map.Entry<String, LinkedHashMap<String, ArrayList<PriviledgeBean>>>) iter
						.next();
				String serviceCodeDisName = pair.getKey();
				Map<String, ArrayList<PriviledgeBean>> privMap = pair
						.getValue();

				String firstAction = "#";
				String firstActionUrl = "*";
				if (privMap.containsKey("LOGIN_MGT")) {
					firstAction = privMap.get("LOGIN_MGT").get(0)
							.getActionMapping();
					firstActionUrl = privMap.get("LOGIN_MGT").get(0)
							.getActionUrl();
					privMap.remove("LOGIN_MGT");
				}
				privStr.append(serviceCodeDisName + "@" + firstAction + "!"
						+ firstActionUrl + "${");

				Iterator<Entry<String, ArrayList<PriviledgeBean>>> privIter = privMap
						.entrySet().iterator();
				boolean check = false;

				while (privIter.hasNext()) {

					Map.Entry<String, ArrayList<PriviledgeBean>> privPair = (Map.Entry<String, ArrayList<PriviledgeBean>>) privIter
							.next();
					menuSet.add(privPair);

					String relatedTo = privPair.getKey();
					List<PriviledgeBean> privList = privPair.getValue();

					privStr.append(relatedTo + "={");

					for (PriviledgeBean privBean : privList) {
						privStr.append(privBean.getPrivTitle() + ":"
								+ privBean.getActionMapping() + "|"
								+ privBean.getActionUrl() + "!");
					}
					privStr.deleteCharAt(privStr.length() - 1);
					privStr.append("},");
					check = true;
				}
				if (check) {
					privStr.deleteCharAt(privStr.length() - 1);
				}
				privStr.append("};");
			}
			if (privStr.length() != 0)
				privStr.deleteCharAt(privStr.length() - 1);

			loginBean.setActionServiceMap(serPrivMap);
			loginBean.setActionPrivFunctionMap(actionPrivFunctionMap);
			loginBean.setMenuStr(privStr.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<String>>>>> getHeadsGroupNames(
			int userId, int roleId, Session session, String userType,Short domainId)
			throws ClassNotFoundException {
		Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<String>>>>> headPriviledgeMap = new TreeMap<String, TreeMap<String, TreeMap<String, TreeMap<String, List<String>>>>>();

		DetachedCriteria dcCriteria = DetachedCriteria
				.forClass(StRmBoRolePrivMapping.class);
		dcCriteria.add(Restrictions.eq("roleId", roleId));
		dcCriteria.add(Restrictions.eq("status", "ACTIVE"));
		dcCriteria.setProjection(Projections.property("sdmId"));

		Criteria criteria = session
				.createCriteria(StRmServiceDeliveryMaster.class)
				.setCacheable(true);
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		if(domainId!=1)
			criteria.add(Restrictions.eq("domainId", domainId));
		criteria.createAlias("stRmServiceMaster", "serviceMaster");
		criteria.add(Restrictions.eq("serviceMaster.status", "ACTIVE"));
		criteria.add(Subqueries.propertyIn("sdmId", dcCriteria));

		List<StRmServiceDeliveryMaster> deliveryMasterList = criteria.list();

		TreeMap<String, TreeMap<String, TreeMap<String, List<String>>>> interfaceMap = null;
		String gnStr = "";
		String privStr = "";
		for (StRmServiceDeliveryMaster deliveryMaster : deliveryMasterList) {
			if(deliveryMaster.getStRmServiceMaster()
					.getPrivRepTable()==null)
				continue;
				Class clazz = getClassName(deliveryMaster.getStRmServiceMaster()
						.getPrivRepTable());
	
				DetachedCriteria detachedCriteria = DetachedCriteria
						.forClass(StRmBoRolePrivMapping.class);
				detachedCriteria.add(Restrictions.eq("status", "ACTIVE"));
				detachedCriteria.add(Restrictions.eq("sdmId", deliveryMaster
						.getSdmId()));
				detachedCriteria.add(Restrictions.eq("roleId", roleId));
				detachedCriteria.setProjection(Projections.distinct(Projections
						.property("privId")));
	
				criteria = session.createCriteria(StRmBoUserPrivMapping.class);
				criteria.add(Restrictions.eq("status", "ACTIVE"));
				criteria.add(Restrictions.eq("userId", userId));
				criteria.add(Restrictions.eq("sdmId", deliveryMaster.getSdmId()));
				criteria.add(Restrictions.eq("roleId", roleId));
				criteria.add(Subqueries.propertyIn("privId", detachedCriteria));
				criteria.setProjection(Projections.distinct(Projections
						.property("privId")));
	
				List<Integer> privIdList = criteria.list();
	
				criteria = session.createCriteria(clazz);
				criteria.add(Restrictions.eq("privStatus", "ACTIVE"));
				criteria.add(Restrictions.eq("isDefault", "N"));
				criteria.add(Restrictions.eq("tier", userType));
				criteria.add(Restrictions.in("privId", privIdList));
				criteria.setProjection(Projections.projectionList().add(
						Projections.distinct(Projections.property("privNameCode")))
						.add(Projections.groupProperty("relatedTo")).add(
								Projections.groupProperty("groupNameCode")).add(
								Projections.property("isDefaultGroup")).add(
								Projections.groupProperty("privId")).add(
								Projections.property("dependentPriv")));
	
				List<Object[]> privMgmtArr = criteria.list();
	
				String relatedTo = "";
				TreeMap<String, List<String>> groupNameMap = null;
				List<String> listView = null;
	
				if (!headPriviledgeMap.containsKey(deliveryMaster
						.getServiceDisplayName())) {
					interfaceMap = new TreeMap<String, TreeMap<String, TreeMap<String, List<String>>>>();
					headPriviledgeMap.put(deliveryMaster.getServiceDisplayName(),
							interfaceMap);
				}
				interfaceMap = headPriviledgeMap.get(deliveryMaster
						.getServiceDisplayName());
				TreeMap<String, TreeMap<String, List<String>>> relToMap = new TreeMap<String, TreeMap<String, List<String>>>();
	
				for (Object[] obj : privMgmtArr) {
					if (!relatedTo.equals(obj[1].toString())) {
						// listView = new ArrayList<String>();
						groupNameMap = new TreeMap<String, List<String>>();
						relatedTo = obj[1].toString();
						relToMap.put(relatedTo, groupNameMap);
					}
					/*
					 * prepare gpnamemap .
					 */
					if (!gnStr.equals(obj[2].toString())) {
						gnStr = obj[2].toString();
						listView = new ArrayList<String>();
	
						groupNameMap.put(gnStr, listView);
					}
					/*
					 * prepare list
					 */
					if (!privStr.equals(obj[4].toString())) {
						String prName = obj[0].toString();
						privStr = obj[4].toString();
						if ((obj[3].toString()).equals("Y")) {
							prName = "*" + prName;
						}
						listView.add(prName);
					}
					// is priv same do nothing
				}
				if (relToMap.size() > 0) {
					interfaceMap.put(deliveryMaster.getServiceDisplayName() + "-"
							+ deliveryMaster.getSdmId(), relToMap);
				}
				if (interfaceMap.size() == 0) {
					headPriviledgeMap
							.remove(deliveryMaster.getServiceDisplayName());
				}
			}
		
		return headPriviledgeMap;
	}

	public Map<Integer, Map<Integer, String>> createRoleInactive(
			String roleName, String roleDesc, String userType,
			String[] rolePriv, int[] mappingId, int[] privCount,
			int creatorRoleId, int userId, Session session)
			throws ClassNotFoundException {
		String activeMapIds = "";
		StringBuilder privName = null;
		String privNameStr = null;
		int privIdFrm = 0;
		int privIdTo = 0;
		HashMap<Integer, String> privMap = new HashMap<Integer, String>();
		for (int i = 0; i < mappingId.length; i++) {
			if (privCount[i] != 0) {
				privName = new StringBuilder("");
				privIdTo = privIdTo + privCount[i];
				for (int j = privIdFrm; j < privIdTo; j++) {
					privName.append("'" + rolePriv[j] + "',");
					privIdFrm++;
				}
				privNameStr = privName.substring(0, privName.length() - 1);
				activeMapIds = activeMapIds + mappingId[i] + ",";
				privMap.put(mappingId[i], privNameStr);
			}
		}

		StRmBoRoleMaster stRmBoRoleMaster = new StRmBoRoleMaster();
		stRmBoRoleMaster.setRoleName(roleName);
		stRmBoRoleMaster.setCreatorUserId(userId);
		stRmBoRoleMaster.setIsMaster("N");
		stRmBoRoleMaster.setRoleDescription(roleDesc);
		stRmBoRoleMaster.setStatus("ACTIVE");
		stRmBoRoleMaster.setTier(userType);
		int roleId = (Integer) session.save(stRmBoRoleMaster);

		Criteria criteria = session.createCriteria(StRmBoRolePrivMapping.class);
		criteria.add(Restrictions.eq("roleId", creatorRoleId));
		List<StRmBoRolePrivMapping> rolePrivMappingList = criteria.list();

		for (StRmBoRolePrivMapping rolePrivMapping : rolePrivMappingList) {
			StRmBoRolePrivMapping mapping = new StRmBoRolePrivMapping(roleId,
					rolePrivMapping.getPrivId(), rolePrivMapping.getSdmId(),
					"INACTIVE");
			session.save(mapping);

		}
		Map<Integer, Map<Integer, String>> map = new HashMap<Integer, Map<Integer, String>>();
		map.put(roleId, privMap);
		return map;
	}

	public String createRoleActive(String roleName, String roleDesc,
			String userType, String[] rolePriv, int[] mappingId,
			int[] privCount, int creatorRoleId, int userId, Session session,
			Map<Integer, String> privMap, int roleId)
			throws ClassNotFoundException {

		Criteria criteria = session
				.createCriteria(StRmServiceDeliveryMaster.class)
				.setCacheable(true);
			criteria.add(Restrictions.eq("tier",userType));
		List<StRmServiceDeliveryMaster> deliveryMasterList = criteria.list();
		// StRummyPrivilegeRepMgmt;
		for (StRmServiceDeliveryMaster deliveryMaster : deliveryMasterList) {
			short key = deliveryMaster.getSdmId();

			if(deliveryMaster.getStRmServiceMaster()
					.getPrivRepTable()==null)
				continue;
			
			Class clazz = getClassName(deliveryMaster.getStRmServiceMaster()
					.getPrivRepTable());
			if (privMap.get((int) key) != null) {

				criteria = session.createCriteria(clazz);
				criteria.setProjection(Projections.distinct(Projections
						.property("dependentPriv")));
				criteria.add(Restrictions.in("privNameCode", Arrays
						.asList(privMap.get((int) key).split("\\s*,\\s*"))));
				criteria.add(Restrictions.isNotNull("dependentPriv"));
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

				criteria = session.createCriteria(clazz);
				// DetachedCriteria dcCriteria =
				// DetachedCriteria.forClass(clazz);
				criteria.setProjection(Projections.distinct(Projections
						.property("privId")));
				criteria.add(Restrictions.eq("privStatus", "ACTIVE"));
				List<String> privNameCode = Arrays.asList(privMap
						.get((int) key).replace("*", "").replace("'", "")
						.split(","));
				// privNameCode = privNameCode.subList(0,
				// privNameCode.size()-1);

				if (depPrivs != null) {
					criteria.add(Restrictions.or(Restrictions.eq("isDefault",
							"Y"), Restrictions.or(Restrictions.in(
							"privNameCode", Arrays.asList(privMap
									.get((int) key).split("\\s*,\\s*"))),
							Restrictions.in("privId", Arrays.asList(depPrivs
									.split("\\s*,\\s*"))))));
				} else {
					criteria.add(Restrictions.in("privNameCode", privNameCode));
				}
				List<Integer> privIds = criteria.list();
				criteria = session.createCriteria(StRmBoRolePrivMapping.class);
				criteria.add(Restrictions.in("privId", privIds));
				criteria.add(Restrictions
						.eq("sdmId", deliveryMaster.getSdmId()));
				criteria.add(Restrictions.eq("roleId", roleId));

				List<StRmBoRolePrivMapping> rolePriMappingList = criteria
						.list();
				for (StRmBoRolePrivMapping roleMapping : rolePriMappingList) {
					roleMapping.setStatus("ACTIVE");
					session.update(roleMapping);
				}
			}

		}

		return "success";

	}

	public Map<Integer, String> fetchRoles(int roleId, String userType,
			int userId, Session session) {

		Map<Integer, String> roleMap = new TreeMap<Integer, String>();

		Criteria criteria = session.createCriteria(StRmBoRoleMaster.class)
				.setCacheable(true);
		criteria.setProjection(Projections.projectionList().add(
				Projections.property("roleId")).add(
				Projections.property("roleName")));
		if (roleId != 0 && userId != 0) {
			criteria.add(Restrictions.eq("creatorUserId", userId));
			criteria.add(Restrictions.eq("isMaster", "N"));
			criteria.add(Restrictions.ne("roleId", roleId));
		} else {
			criteria.add(Restrictions.ne("roleId", roleId));
			criteria.add(Restrictions.eq("roleName", userType));
		}
		List<Object[]> roleArr = criteria.list();

		for (Object[] obj : roleArr) {
			roleMap.put((Integer) obj[0], obj[1].toString());
		}
		return roleMap;
	}

	public Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> fetchRolePriv(
			int roleId, String userType, int creatorRoleId, int userId,Short domainId, Session session)
			throws ClassNotFoundException {

		Map<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>> headPriviledgeMap = new TreeMap<String, TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>>();

		DetachedCriteria dcCriteria = DetachedCriteria
				.forClass(StRmBoRolePrivMapping.class);
		dcCriteria.add(Restrictions.eq("roleId", creatorRoleId));
		dcCriteria.add(Restrictions.eq("status", "ACTIVE"));
		dcCriteria.setProjection(Projections.property("sdmId"));
		dcCriteria.getExecutableCriteria(session).list();
		//List<Integer> ls = dcCriteria.getExecutableCriteria(session).list();
		Criteria criteria = session
				.createCriteria(StRmServiceDeliveryMaster.class)
				.setCacheable(true);
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		if(domainId!=1)
			criteria.add(Restrictions.eq("domainId", domainId));
		
		criteria.createAlias("stRmServiceMaster", "serviceMaster");
		
		criteria.add(Restrictions.eq("serviceMaster.status", "ACTIVE"));
		criteria.add(Subqueries.propertyIn("sdmId", dcCriteria));
		List<StRmServiceDeliveryMaster> deliveryMasterList = criteria.list();

		TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>> interfaceMap = null;
		for (StRmServiceDeliveryMaster deliveryMaster : deliveryMasterList) {
			
			if(deliveryMaster.getStRmServiceMaster()
					.getPrivRepTable()==null)
				continue;
			
			Class clazz = getClassName(deliveryMaster.getStRmServiceMaster()
					.getPrivRepTable());
			
//			************ For fetch user Wise Priv Start****************//	
			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(StRmBoRolePrivMapping.class);
			detachedCriteria.add(Restrictions.eq("status", "ACTIVE"));
			detachedCriteria.add(Restrictions.eq("sdmId", deliveryMaster
					.getSdmId()));
			detachedCriteria.add(Restrictions.eq("roleId", creatorRoleId));
			detachedCriteria.setProjection(Projections.distinct(Projections
					.property("privId")));

			criteria = session.createCriteria(StRmBoUserPrivMapping.class);
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			criteria.add(Restrictions.eq("userId", userId));
			criteria.add(Restrictions.eq("sdmId", deliveryMaster.getSdmId()));
			criteria.add(Restrictions.eq("roleId", creatorRoleId));
			criteria.add(Subqueries.propertyIn("privId", detachedCriteria));
			criteria.setProjection(Projections.distinct(Projections
					.property("privId")));

			List<Integer> privIdList = criteria.list();

			criteria = session.createCriteria(clazz);
			criteria.add(Restrictions.eq("privStatus", "ACTIVE"));
			criteria.add(Restrictions.eq("isDefault", "N"));
			criteria.add(Restrictions.eq("tier", userType));
			criteria.add(Restrictions.in("privId", privIdList));
			criteria.setProjection(Projections.projectionList().add(
					Projections.distinct(Projections.property("privNameCode")))
					.add(Projections.groupProperty("relatedTo")).add(
							Projections.groupProperty("groupNameCode")).add(
							Projections.property("isDefaultGroup")).add(
							Projections.groupProperty("privId")).add(
							Projections.property("dependentPriv")));

			List<Object[]> privMgmtArr = criteria.list();
//			************  For fetch user Wise Priv End****************//	
			
//		************ For fetch all priv Start****************//	
//			criteria = session.createCriteria(clazz);
//			criteria.add(Restrictions.eq("privStatus", "ACTIVE"));
//			criteria.add(Restrictions.eq("isDefault", "N"));
//
//			
//				criteria.add(Restrictions.eq("tier", userType));
//				criteria.setProjection(Projections.projectionList().add(
//						Projections.distinct(Projections
//								.property("privNameCode"))).add(
//						Projections.groupProperty("relatedTo")).add(
//						Projections.groupProperty("groupNameCode")).add(
//						Projections.property("isDefaultGroup")).add(
//						Projections.groupProperty("privId")));
//			
//
//			List<Object[]> privMgmtArr = criteria.list();
//			************ For fetch all priv End****************//	

			List<Integer> privList = new ArrayList<Integer>();
			for (Object[] obj : privMgmtArr) {
				privList.add((Integer) obj[4]);
			}

			criteria = session.createCriteria(StRmBoRolePrivMapping.class);
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			criteria.add(Restrictions.eq("sdmId", deliveryMaster.getSdmId()));
			criteria.add(Restrictions.in("privId", privList));
			criteria.add(Restrictions.eq("roleId", roleId));
			criteria.setProjection(Projections.projectionList().add(
					Projections.property("privId")).add(
					Projections.property("status")));
			List<Object[]> objA = criteria.list();

			Map<Integer, String> privStatusMap = new HashMap<Integer, String>();
			for (Object[] obj : objA) {
				privStatusMap.put((Integer) obj[0], (String) obj[1]);
			}

			UserPrivBean privBean;
			String oldRelatedTo = "";
			String oldGpNameCode = "";
			List<UserPrivBean> groupNameList = null;
			TreeMap<String, List<UserPrivBean>> groupNameMap = null;

			if (!headPriviledgeMap.containsKey(deliveryMaster
					.getServiceDisplayName())) {
				interfaceMap = new TreeMap<String, TreeMap<String, TreeMap<String, List<UserPrivBean>>>>();
				headPriviledgeMap.put(deliveryMaster.getServiceDisplayName(),
						interfaceMap);
			}
			interfaceMap = headPriviledgeMap.get(deliveryMaster
					.getServiceDisplayName());
			TreeMap<String, TreeMap<String, List<UserPrivBean>>> privMap = new TreeMap<String, TreeMap<String, List<UserPrivBean>>>();
			String privNameCode = "";
			String oldPrivNameCode = "";
			for (Object[] obj : privMgmtArr) {
				privBean = new UserPrivBean();
				String relatedTo = obj[1].toString();
				String gpNameCode = obj[2].toString();
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
				privNameCode = obj[0].toString();
				if (!privNameCode.equals(oldPrivNameCode)) {
					oldPrivNameCode = privNameCode;
					if (obj[3].toString().equals("Y")) {
						privNameCode = "*" + privNameCode;
					}
					privBean.setPrivTitle(privNameCode);
					privBean.setStatus(privStatusMap.get((Integer) obj[4]));
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
		return headPriviledgeMap;
	}

	public void editRolePriv(int roleId, String[] rolePriv, int[] mappingId,
			int[] privCount, int creatorRoleId, String userType, Session session)
			throws ClassNotFoundException {

		String activeMapIds = "";
		StringBuilder grpName = null;
		String grpNameStr = null;
		int privIdFrm = 0;
		int privIdTo = 0;
		HashMap<Integer, String> privMap = new HashMap<Integer, String>();
		for (int i = 0; i < mappingId.length; i++) {
			if (privCount[i] != 0) {
				grpName = new StringBuilder("");
				privIdTo += privCount[i];
				String[] rolePrivMappings = Arrays.copyOfRange(rolePriv,
						privIdFrm, privIdTo);
				int commonCount = (new ArrayList<String>(Arrays
						.asList(rolePrivMappings)).size());
				commonCount += privIdFrm;
				for (int j = privIdFrm; j < commonCount; j++) {
					grpName.append("'" + rolePriv[j] + "',");
					privIdFrm++;
				}

				grpNameStr = grpName.substring(0, grpName.length() - 1);
				grpNameStr = grpNameStr.replace("*", "");
				activeMapIds = activeMapIds + mappingId[i] + ",";
				privMap.put(mappingId[i], grpNameStr);
			}
		}

		Criteria criteria = session.createCriteria(StRmBoRolePrivMapping.class);
		criteria.add(Restrictions.eq("roleId", roleId));
		List<StRmBoRolePrivMapping> rolePrivMappingList = criteria.list();

		for (StRmBoRolePrivMapping roleMapping : rolePrivMappingList) {
			roleMapping.setStatus("INACTIVE");
			session.update(roleMapping);
		}

		criteria = session.createCriteria(StRmServiceDeliveryMaster.class);
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		criteria.add(Restrictions.eq("tier", userType));
		criteria.createAlias("stRmServiceMaster", "serviceMaster");
		criteria.add(Restrictions.eq("serviceMaster.status", "ACTIVE"));
		List<StRmServiceDeliveryMaster> deliveryMasterList = criteria.list();

		for (StRmServiceDeliveryMaster deliveryMaster : deliveryMasterList) {
			short key = deliveryMaster.getSdmId();
			
			if(deliveryMaster.getStRmServiceMaster()
					.getPrivRepTable()==null)
				continue;
			
			Class clazz = getClassName(deliveryMaster.getStRmServiceMaster()
					.getPrivRepTable());

			if (privMap.get((int) key) != null) {

				criteria = session.createCriteria(clazz);
				criteria.setProjection(Projections.distinct(Projections
						.property("dependentPriv")));
				criteria.add(Restrictions.in("privNameCode", Arrays
						.asList(privMap.get((int) key).split("\\s*,\\s*"))));
				criteria.add(Restrictions.isNotNull("dependentPriv"));
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

				if (privMap.get((int) key) != null) {

					if (depPrivs != null) {
						criteria
								.add(Restrictions.or(Restrictions.eq(
										"isDefault", "Y"), Restrictions.or(
										Restrictions.in("privNameCode", Arrays
												.asList(privMap.get((int) key)
														.split("\\s*,\\s*"))),
										Restrictions.in("privId", Arrays
												.asList(depPrivs
														.split("\\s*,\\s*"))))));
					} else {

						Arrays
								.asList(privMap.get((int) key).split(
										"\\s*,\\s*"));
						criteria = session.createCriteria(clazz);
						criteria.setProjection(Projections.distinct(Projections
								.property("privId")));
						criteria.add(Restrictions.eq("privStatus", "ACTIVE"));
						criteria.add(Restrictions.or(Restrictions.eq(
								"isDefault", "Y"),
								Restrictions.in("privNameCode", Arrays
										.asList(privMap.get((int) key).replace(
												"'", "").split(",")))));
					}

					List<Integer> privList = criteria.list();

					criteria = session
							.createCriteria(StRmBoRolePrivMapping.class);
					criteria.add(Restrictions.in("privId", privList));
					criteria.add(Restrictions.eq("sdmId", deliveryMaster
							.getSdmId()));
					criteria.add(Restrictions.eq("roleId", roleId));

					List<StRmBoRolePrivMapping> rolePriMappingList = criteria
							.list();
					for (StRmBoRolePrivMapping roleMapping : rolePriMappingList) {
						roleMapping.setStatus("ACTIVE");
						session.update(roleMapping);
					}
					session.flush();
				}
			}
		}

		for (StRmServiceDeliveryMaster deliveryMaster : deliveryMasterList) {
			DetachedCriteria dcriteria = DetachedCriteria
					.forClass(StRmBoRolePrivMapping.class);
			dcriteria.add(Restrictions.eq("status", "INACTIVE"));
			dcriteria.add(Restrictions.eq("roleId", roleId));
			dcriteria.add(Restrictions.eq("sdmId", deliveryMaster.getSdmId()));
			dcriteria.setProjection(Projections.property("privId"));
			criteria = session.createCriteria(StRmBoUserPrivMapping.class);
			 criteria.add(Subqueries.propertyIn("privId", dcriteria));
			criteria.add(Restrictions.eq("roleId", roleId));
			criteria.add(Restrictions.eq("sdmId", deliveryMaster.getSdmId()));

			List<StRmBoUserPrivMapping> userPrivList = criteria.list();
			for (StRmBoUserPrivMapping userPriv : userPrivList) {
				userPriv.setStatus("INACTIVE");
				session.update(userPriv);
			}

			criteria = session.createCriteria(StRmBoRolePrivMapping.class);
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			criteria.add(Restrictions.eq("roleId", roleId));
			criteria.add(Restrictions.eq("sdmId", deliveryMaster.getSdmId()));
			criteria.setProjection(Projections.property("privId"));
			List<Integer> privIds = criteria.list();

			if (privIds.size() != 0) {
				DetachedCriteria dCriteria2 = DetachedCriteria
						.forClass(StRmBoUserMaster.class);
				dCriteria2.add(Restrictions.eq("stRmBoRoleMaster.roleId",
						roleId));
				dCriteria2.add(Restrictions.eq("isRoleHead", "Y"));
				dCriteria2.setProjection(Projections.property("userId"));
				dCriteria2.getExecutableCriteria(session).list();

				criteria = session.createCriteria(StRmBoUserPrivMapping.class);
				criteria.add(Restrictions.eq("roleId", roleId));
				criteria.add(Restrictions
						.eq("sdmId", deliveryMaster.getSdmId()));
				if (!(deliveryMaster.getSdmId() >= 3)) {
					criteria.add(Restrictions.in("privId", privIds));
					criteria.add(Subqueries.propertyIn("userId", dCriteria2));
				}
				userPrivList = criteria.list();
				for (StRmBoUserPrivMapping userPriv : userPrivList) {
					userPriv.setStatus("ACTIVE");
					session.update(userPriv);
				}
			}
		}
	}

	public LinkedHashMap<String, DefPrivTemp1> fetchDefaultPriv(
			String interfaceType, DefPrivBean defPrivBean, String userType,
			Session session) {
		return null;
	}

	public Map<String, TreeMap<String, Integer>> fetchActiveServices(
			String tier, Session session) {
		Map<String, TreeMap<String, Integer>> serviceMap = new TreeMap<String, TreeMap<String, Integer>>();
		TreeMap<String, Integer> interfaceMap;

		Criteria criteria = session
				.createCriteria(StRmServiceDeliveryMaster.class)
				.setCacheable(true);
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		criteria.add(Restrictions.eq("tier", tier));
		criteria.createAlias("stRmServiceMaster", "serviceMaster");
		criteria.add(Restrictions.eq("serviceMaster.status", "ACTIVE"));

		List<StRmServiceDeliveryMaster> serviceDeliveryMasterList = criteria
				.list();

		for (StRmServiceDeliveryMaster deliveryMaster : serviceDeliveryMasterList) {
			StRmServiceMaster serviceMaster = deliveryMaster
					.getStRmServiceMaster();
			if (!serviceMap.containsKey(serviceMaster.getServiceCode() + "#"
					+ serviceMaster.getServiceName())) {
				interfaceMap = new TreeMap<String, Integer>();
				serviceMap.put(serviceMaster.getServiceCode() + "#"
						+ serviceMaster.getServiceName(), interfaceMap);
			}
			interfaceMap = serviceMap.get(serviceMaster.getServiceCode() + "#"
					+ serviceMaster.getServiceName());
			interfaceMap.put(deliveryMaster.getInterfaceType(), Integer
					.parseInt(deliveryMaster.getSdmId().toString()));
		}
		log.info(serviceMap);
		return serviceMap;
	}

	public Map<Integer, String> fetchRoles(String roleOwner, boolean fetchAll,int userId,
			Session session) {
		Map<Integer, String> roleMap = new TreeMap<Integer, String>();

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(StRmBoUserMaster.class);
		detachedCriteria.add(Restrictions.eq("isRoleHead", "Y"));
		detachedCriteria.setProjection(Projections.property("stRmBoRoleMaster.roleId"));

		Criteria criteria = session.createCriteria(StRmBoRoleMaster.class)
				.setCacheable(true);
		if (fetchAll) {
			criteria.add(Subqueries.propertyNotIn("roleId", detachedCriteria));
			criteria.add(Restrictions.eq("isMaster", "N"));
			criteria.add(Restrictions.eq("creatorUserId",userId));
		} else {
			criteria.add(Subqueries.propertyIn("roleId", detachedCriteria));
		}
		criteria.add(Restrictions.eq("tier", roleOwner));
		criteria.addOrder(Order.asc("roleName"));

		List<StRmBoRoleMaster> result = criteria.list();
		for (StRmBoRoleMaster obj : result) {
			roleMap.put(obj.getRoleId(), obj.getRoleName());
			// roleMap.put((Integer) obj[0], (String) obj[1]);
		}
		return roleMap;
	}

	public void manageRolePrivilege(String privOwner, Session session)
			throws ClassNotFoundException {

		Criteria criteria = session.createCriteria(StRmBoRoleMaster.class)
				.setCacheable(true);
		criteria.add(Restrictions.eq("tier", privOwner));
		criteria.setProjection(Projections.property("roleId"));
		criteria.setProjection(Projections.projectionList().add(
				Projections.property("roleId")).add(
				Projections.property("isMaster")));
		List<Object[]> objArr = criteria.list();

		for (Object[] obj : objArr) {

			int roleId = (Integer) obj[0];
			String isRoleMaster = (String) obj[1];

			criteria = session.createCriteria(StRmServiceDeliveryMaster.class)
					.setCacheable(true);
			criteria.add(Restrictions.eq("tier", privOwner));
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			List<StRmServiceDeliveryMaster> deliveryMasterList = criteria
					.list();

			for (StRmServiceDeliveryMaster serviceDeliveryMaster : deliveryMasterList) {
				
				if(serviceDeliveryMaster.getStRmServiceMaster().getPrivRepTable() == null)
						continue;
					
				Short mapId = serviceDeliveryMaster.getSdmId();
				String delStatus = serviceDeliveryMaster.getStatus();
				String servStatus = serviceDeliveryMaster
						.getStRmServiceMaster().getStatus();
				String privTable = serviceDeliveryMaster.getStRmServiceMaster()
						.getPrivRepTable();
				criteria = session.createCriteria(StRmBoRolePrivMapping.class);
				criteria.add(Restrictions.eq("roleId", roleId));
				criteria.add(Restrictions.eq("sdmId", mapId));
				criteria.setProjection(Projections.distinct(Projections
						.property("privId")));
				List<Integer> privIdList = criteria.list();

				Class clazz = getClassName(privTable);
				criteria = session.createCriteria(clazz);
				if (privIdList.size() != 0) {
					criteria.add(Restrictions.not(Restrictions.in("privId",
							privIdList)));
				}
				criteria.setProjection(Projections.projectionList().add(
						Projections.distinct(Projections.property("privId")))
						.add(Projections.property("privStatus")).add(
								Projections.property("isDefault")));

				criteria.add(Restrictions.eq("tier", privOwner));
				List<Object[]> privObjArr = criteria.list();

				boolean status = delStatus.equals("ACTIVE")
						&& servStatus.equals("ACTIVE");

				for (Object[] objArray : privObjArr) {
					String privStatus = (String) objArray[1];
					int pid = (Integer) objArray[0];
					String isDefaultPriv = (String) objArray[2];
					String insStatus = "INACTIVE";
					if (status
							&& privStatus.equals("ACTIVE")
							&& (isRoleMaster.equalsIgnoreCase("Y") || isDefaultPriv
									.equalsIgnoreCase("Y"))) {
						insStatus = "ACTIVE";
					}
					StRmBoRolePrivMapping rolePrivMapping = new StRmBoRolePrivMapping(
							roleId, pid, mapId, insStatus);
					session.save(rolePrivMapping);
				}
			}
		}
	}

	public void manageUserPrivilege(String privOwner, Session session)
			throws ClassNotFoundException {

		Criteria criteria = session.createCriteria(StRmBoRoleMaster.class);
		criteria.add(Restrictions.eq("tier", privOwner))
		.setCacheable(true);
		criteria.setProjection(Projections.property("roleId"));
		criteria.setProjection(Projections.projectionList().add(
				Projections.property("roleId")).add(
				Projections.property("isMaster")));
		List<Object[]> objArr = criteria.list();

		for (Object[] obj : objArr) {

			int roleId = (Integer) obj[0];
			criteria = session.createCriteria(StRmServiceDeliveryMaster.class)
					.setCacheable(true);
			criteria.add(Restrictions.eq("tier", privOwner));
			criteria.add(Restrictions.eq("status", "ACTIVE"));		
			List<StRmServiceDeliveryMaster> deliveryMasterList = criteria
					.list();

			for (StRmServiceDeliveryMaster serviceDeliveryMaster : deliveryMasterList) {
				
				if(serviceDeliveryMaster
						.getStRmServiceMaster().getPrivRepTable() == null){
					continue;
				}
				Short mapId = serviceDeliveryMaster.getSdmId();
				String channel = serviceDeliveryMaster.getTier();
				Class<?> clazz = getClassName(serviceDeliveryMaster
						.getStRmServiceMaster().getPrivRepTable());
				List<Object[]> userList = null;
				if (channel.equalsIgnoreCase("BO")
						|| channel.equalsIgnoreCase("DOMAIN")) {

					
					criteria = session.createCriteria(StRmBoUserMaster.class);
					criteria.add(Restrictions.eq("stRmBoRoleMaster.roleId",roleId));
					if(privOwner.equals("DOMAIN"))
						criteria.add(Restrictions.eq("domainId",serviceDeliveryMaster.getDomainId()));
					
					criteria.setProjection(Projections.projectionList().add(
							Projections.property("userId")).add(
							Projections.property("isRoleHead")));
					criteria.add(Restrictions.eq("userType", privOwner));
					userList = criteria.list();

					for (Object[] objectArr : userList) {
						int userId = (Integer) objectArr[0];
						DetachedCriteria dcCriteria = DetachedCriteria
								.forClass(StRmBoUserPrivMapping.class);
						dcCriteria.add(Restrictions.eq("roleId", roleId));
						dcCriteria.add(Restrictions.eq("sdmId", mapId));
						dcCriteria.add(Restrictions.eq("userId", userId));
						dcCriteria.setProjection(Projections
								.distinct(Projections.property("privId")));

						if (objectArr[1].toString().equalsIgnoreCase("N")) {
							criteria = session.createCriteria(clazz);
							criteria.setProjection(Projections.projectionList()
									.add(
											Projections.distinct(Projections
													.property("privId"))).add(
											Projections.property("isDefault")));

							List<Object[]> privDefaultList = criteria.list();

							Map<Integer, String> priDefaultMap = new HashMap<Integer, String>();
							List<Integer> privIds = new ArrayList<Integer>();
							for (Object[] obj2 : privDefaultList) {
								priDefaultMap.put((Integer) obj2[0],
										(String) obj2[1]);
								privIds.add((Integer) obj2[0]);
							}

							criteria = session
									.createCriteria(StRmBoRolePrivMapping.class);
							criteria.add(Subqueries.propertyNotIn("privId",
									dcCriteria));
							criteria.add(Restrictions.in("privId", privIds));
							criteria.add(Restrictions.eq("roleId", roleId));
							criteria.add(Restrictions.eq("sdmId", mapId));
							criteria.setProjection(Projections
									.property("privId"));

							List<Integer> finalPrivList = criteria.list();

							for (Integer priv : finalPrivList) {
								String privStatus;
								if (priDefaultMap.get(priv).equals("Y")) {
									privStatus = "ACTIVE";
								} else {
									privStatus = "INACTIVE";
								}
								StRmBoUserPrivMapping userPriMapping = new StRmBoUserPrivMapping(
										userId, roleId, priv, mapId, privStatus);
								session.save(userPriMapping);
							}

						} else {

							criteria = session
									.createCriteria(StRmBoRolePrivMapping.class);
							criteria.add(Subqueries.propertyNotIn("privId",
									dcCriteria));
							criteria.add(Restrictions.eq("roleId", roleId));
							criteria.add(Restrictions.eq("sdmId", mapId));
							criteria.setProjection(Projections.projectionList()
									.add(Projections.property("privId")).add(
											Projections.property("status")));

							List<Object[]> rolePrivIds = criteria.list();

							for (Object[] objA : rolePrivIds) {
								StRmBoUserPrivMapping userMapping = new StRmBoUserPrivMapping(
										userId, roleId, (Integer) objA[0],
										mapId, objA[1].toString());
								session.save(userMapping);
							}

						}
					}
				}
			}
		}
	}

	public Class getClassName(String className) throws ClassNotFoundException {
		String privT[] = className.split("_");
		StringBuilder privTableName = new StringBuilder();
		privTableName.append(privT[0].substring(0, 1).toUpperCase()
				+ privT[0].substring(1));
		for (int i = 1; i < privT.length; i++) {
			privTableName.append(privT[i].substring(0, 1).toUpperCase()
					+ privT[i].substring(1));
		}
		Class clazz = Class.forName("com.stpl.pms.hibernate.mapping."
				+ privTableName.toString());

		return clazz;
	}

	public String checkRoleAvailability(String roleName, Short domainId, Session session) {

		Criteria criteria = session.createCriteria(StRmBoRoleMaster.class)
				.setCacheable(true);
		criteria.add(Restrictions.eq("roleName", roleName));
		if (criteria.list().size() > 0) {
			return "false";
		}
		return "true";
	}
	public String addPrivilege(PrivilegeManagementBean privMgmtBean, Session session){
		// insertion into st_rm_privilege_rep_mgmt
		StRmPrivilegeRepMgmt privRepMgmt = new StRmPrivilegeRepMgmt();
		Criteria criteria = session.createCriteria(StRmPrivilegeRepMgmt.class).setProjection(Projections.max("fnId"));
		int fnId = (Integer)criteria.uniqueResult()+1;

		privRepMgmt.setCheckLogin(privMgmtBean.getCheckLogin());
		privRepMgmt.setFnId(fnId);
		privRepMgmt.setFunctionName(privMgmtBean.getFnName());
		privRepMgmt.setGroupNameCode(privMgmtBean.getGroupNameCode());		
		Criteria criteria1 = session.createCriteria(StRmPrivilegeRepMgmt.class);
        criteria1.add(Restrictions.eq("groupNameCode", privMgmtBean.getGroupNameCode()))
        		 .add(Restrictions.eq("relatedTo", privMgmtBean.getRelatedTo()));
	    List<StRmPrivilegeRepMgmt> groupNameList =criteria1.list();
	    if(groupNameList.size()>0)
	    	privRepMgmt.setGroupId(groupNameList.get(0).getGroupId());
	    else
	    	privRepMgmt.setGroupId((short)fnId);
	     
		Criteria criteria2 = session.createCriteria(StRmPrivilegeRepMgmt.class);
        criteria2.add(Restrictions.eq("privNameCode",privMgmtBean.getPrivNameCode()));
	    List<StRmPrivilegeRepMgmt> privNameList =criteria2.list();
		if(privNameList.size()>0)
			privRepMgmt.setPrivId(privNameList.get(0).getPrivId());
		else
			 privRepMgmt.setPrivId(fnId);
		
		privRepMgmt.setIsDefault(privMgmtBean.getIsDefault());
		privRepMgmt.setIsDefaultGroup(privMgmtBean.getIsDefaultGroup());
		privRepMgmt.setPrivNameCode(privMgmtBean.getPrivNameCode());
		privRepMgmt.setPrivStatus(privMgmtBean.getPrivStatus());
		privRepMgmt.setTier(privMgmtBean.getTier());
		privRepMgmt.setRelatedTo(privMgmtBean.getRelatedTo());
		
		session.save(privRepMgmt);
		
		// insertion into st_rm_action_function_mapping_mgmt
		if(privMgmtBean.getActionName()!=null && !privMgmtBean.getActionName().isEmpty()){
		StRmActionFunctionMappingMgmt actionFnMapping = new StRmActionFunctionMappingMgmt();
		actionFnMapping.setActionDesc(privMgmtBean.getActionDesc());
		Criteria criteria3 = session.createCriteria(StRmActionFunctionMappingMgmt.class);
		criteria3.add(Restrictions.eq("actionName",actionFnMapping.getActionName()));
	    List<StRmActionFunctionMappingMgmt> actionNameList =criteria3.list();
	    if(actionNameList.size()>0)
	    	actionFnMapping.setActionId(actionNameList.get(0).getActionId());
	    else
	    	actionFnMapping.setActionId(fnId);

	    actionFnMapping.setActionName(privMgmtBean.getActionName());
		actionFnMapping.setActionUrl("com");
		actionFnMapping.setFnId(fnId);
		actionFnMapping.setStatus(privMgmtBean.getActionStatus());
		session.save(actionFnMapping);
		}
		
		// insertion into st_rm_menu_master_mgmt
		StRmMenuMasterMgmt menuMaster = new StRmMenuMasterMgmt();
		Criteria criteria3=session.createCriteria(StRmMenuMasterMgmt.class);
		List<StRmMenuMasterMgmt> menuDisplayList=criteria3.add(Restrictions.eq("menuName",privMgmtBean.getGroupNameCode())).list();
		if(menuDisplayList.size()==0){
			menuMaster.setMenuName(privMgmtBean.getGroupNameCode());
			menuMaster.setMenuDispCode(privMgmtBean.getGroupNameCode());
			menuMaster.setParentMenuId((short) 0);
			menuMaster.setItemOrder((short) 0);
			menuMaster.setActionId(privRepMgmt.getPrivId());
			session.save(menuMaster);
		}
		return "success";
	}

	public void inactiveUserPriv(Session session, LoginBean loginBean) {
		// TODO Auto-generated method stub
		try {
			int autoPassword = -1;
			Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
			criteria.add(Restrictions.eq("userId",loginBean.getUserInfo().getUserId()));
			criteria.add(Restrictions.eq("userName",loginBean.getUserInfo().getUserName()));
			List<StRmBoUserMaster> beanResult = criteria.list();
			if(beanResult!=null) {
				for(StRmBoUserMaster obj:beanResult) {
					autoPassword = obj.getAutoPassword();
				}
			}
			if(autoPassword==1) {
			SQLQuery query = session.createSQLQuery("update st_rm_bo_user_priv_mapping set status='NA' where status = 'ACTIVE' and user_id ="+loginBean.getUserInfo().getUserId()); 	
			query.executeUpdate();
			}
			else {
				SQLQuery query = session.createSQLQuery("update st_rm_bo_user_priv_mapping set status='ACTIVE' where status = 'NA' and user_id ="+loginBean.getUserInfo().getUserId()); 	
				query.executeUpdate();
					
			}
			
			
		}catch(Exception e) {e.printStackTrace();}
	}
}
