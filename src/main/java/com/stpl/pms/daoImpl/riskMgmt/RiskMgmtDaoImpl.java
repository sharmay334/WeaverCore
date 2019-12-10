package com.stpl.pms.daoImpl.riskMgmt;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.stat.SecondLevelCacheStatistics;

import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.StDmBlockedEmailId;
import com.stpl.pms.hibernate.mapping.StDmBlockedIp;
import com.stpl.pms.hibernate.mapping.StDmBlockedPhoneNo;
import com.stpl.pms.hibernate.mapping.StPmPlayerMaster;
import com.stpl.pms.hibernate.mapping.StRiskDecisionActivityDoerMapping;
import com.stpl.pms.hibernate.mapping.StRiskDecisionActivityMaster;
import com.stpl.pms.hibernate.mapping.StRiskDecisionDoerMaster;
import com.stpl.pms.hibernate.mapping.StRiskDuplicateActionNotification;
import com.stpl.pms.hibernate.mapping.StRiskDuplicateMaster;
import com.stpl.pms.hibernate.mapping.StRiskDuplicatePlayerScore;
import com.stpl.pms.hibernate.mapping.StRiskDuplicateWeightage;
import com.stpl.pms.hibernate.mapping.StRiskPlrProfileMaster;
import com.stpl.pms.hibernate.mapping.StRiskPlrTxnControl;
import com.stpl.pms.hibernate.mapping.StRmBoAllowedIp;
import com.stpl.pms.javabeans.DBConfigBean;
import com.stpl.pms.javabeans.DecisionInfoMarkerBean;
import com.stpl.pms.javabeans.DecisionMatrixMappingBean;
import com.stpl.pms.javabeans.DuplicationPlrScoreBean;
import com.stpl.pms.javabeans.DuplicationScoreActionBean;
import com.stpl.pms.javabeans.DuplicationScoreBean;
import com.stpl.pms.utility.Utility;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

@SuppressWarnings("unchecked")
public class RiskMgmtDaoImpl {

	public List<StRiskPlrTxnControl> getRiskPlrControl(StatelessSession session) {
		Criteria criteria = session.createCriteria(StRiskPlrTxnControl.class);
		return criteria.list();
	}

	public List<StRiskPlrProfileMaster> getRiskPlrProfileMaster(StatelessSession session) {
		Criteria criteria = session.createCriteria(StRiskPlrProfileMaster.class);
		List<StRiskPlrProfileMaster> oldScoresList = criteria.list();
		return oldScoresList;
	}

	public List<StRiskDuplicateActionNotification> getDLActionNotificationList(Session session) {
		Criteria criteria = session.createCriteria(StRiskDuplicateActionNotification.class);
		return criteria.list();
	}

	public void saveDLFieldWeightage(List<StRiskDuplicateWeightage> fieldWeighatgeList, StatelessSession session,
			long userId) {
		Timestamp currTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		for (StRiskDuplicateWeightage fieldWeighatge : fieldWeighatgeList) {
			fieldWeighatge.setCreatedBy(userId);
			fieldWeighatge.setCreationTime(currTime);
			fieldWeighatge.setLastUpdatedBy(userId);
			fieldWeighatge.setLastUpdationTime(currTime);
			session.insert(fieldWeighatge);
		}
	}

	public void updateDLScoreRangeMaster(List<StRiskDuplicateMaster> newDupScoreList, short privDomainId,
			StatelessSession session, long userId) {
		Timestamp currTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		Criteria criteria = session.createCriteria(StRiskDuplicateMaster.class);
		criteria.add(Restrictions.eq("domainId", privDomainId));
		criteria.addOrder(Order.asc("fromScore"));
		List<StRiskDuplicateMaster> oldDupScoreList = criteria.list();

		int i = 0;
		for (i = 0; i < oldDupScoreList.size(); i++) {
			StRiskDuplicateMaster oldMaster = oldDupScoreList.get(i);
			if (i < newDupScoreList.size()) {
				StRiskDuplicateMaster newMaster = newDupScoreList.get(i);
				oldMaster.setFromScore(newMaster.getFromScore());
				oldMaster.setToScore(newMaster.getToScore());
				oldMaster.setActionNew(newMaster.getActionNew());
				oldMaster.setActionOld(newMaster.getActionOld());
				oldMaster.setIsRecord(newMaster.getIsRecord());
				oldMaster.setNotoficationNew(newMaster.getNotoficationNew());
				oldMaster.setNotoficationOld(newMaster.getNotoficationOld());
				oldMaster.setStatus(newMaster.getStatus());
			} else {
				oldMaster.setStatus("INACTIVE");
			}
			oldMaster.setLastUpdatedBy(userId);
			oldMaster.setLastUpdationTime(currTime);
			session.update(oldMaster);
		}
		for (int j = i; j < newDupScoreList.size(); j++) {
			StRiskDuplicateMaster newMaster = newDupScoreList.get(i);
			newMaster.setLastUpdatedBy(userId);
			newMaster.setLastUpdationTime(currTime);
			newMaster.setCreatedBy(userId);
			newMaster.setCreationTime(currTime);
			session.insert(newMaster);
		}
	}

	public void updateDLFieldWeightage(List<StRiskDuplicateWeightage> fieldWeighatgeList, StatelessSession session,
			long userId) {
		Timestamp currTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		Criteria criteria = session.createCriteria(StRiskDuplicateWeightage.class);
		criteria.add(Restrictions.eq("domainId", fieldWeighatgeList.get(0).getDomainId()));
		criteria.addOrder(Order.asc("id"));
		List<StRiskDuplicateWeightage> oldDupScoreList = criteria.list();

		for (int i = 0; i < oldDupScoreList.size(); i++) {
			StRiskDuplicateWeightage oldMaster = oldDupScoreList.get(i);
			StRiskDuplicateWeightage weightMaster = fieldWeighatgeList.get(i);
			oldMaster.setFieldName(weightMaster.getFieldName());
			oldMaster.setMatchCriteria(weightMaster.getMatchCriteria());
			oldMaster.setDomainId(weightMaster.getDomainId());
			oldMaster.setSectionName(weightMaster.getSectionName());
			oldMaster.setStatus(weightMaster.getStatus());
			oldMaster.setWeightage(weightMaster.getWeightage());
			oldMaster.setLastUpdatedBy(userId);
			oldMaster.setLastUpdationTime(currTime);
			session.update(oldMaster);
		}

	}

	public void saveDLScoreRangeMaster(List<StRiskDuplicateMaster> dupScoreList, StatelessSession session,
			long userId) {
		Timestamp currTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		for (StRiskDuplicateMaster scoreMaster : dupScoreList) {
			scoreMaster.setCreatedBy(userId);
			scoreMaster.setCreationTime(currTime);
			scoreMaster.setLastUpdatedBy(userId);
			scoreMaster.setLastUpdationTime(currTime);
			session.insert(scoreMaster);
		}
	}

	public List<StRiskDuplicateWeightage> getDLFieldWeightage(Session session, short domainId, String sectionName) {
		Criteria criteria = session.createCriteria(StRiskDuplicateWeightage.class);
		if (domainId != 0) {
			criteria.add(Restrictions.eq("domainId", domainId));
		}
		if (!sectionName.equals("")) {
			criteria.add(Restrictions.eq("sectionName", sectionName));
		}
		return criteria.list();
	}

	public List<StPmPlayerMaster> getDLPlayerMaster(Session session, String status) {
		Criteria criteria = session.createCriteria(StPmPlayerMaster.class);
		if (status != null) {
			criteria.add(Restrictions.eq("duplicationCheckReq", status));
		}
		criteria.add(Restrictions.eq("status", "FULL"));
		criteria.addOrder(Order.desc("playerId"));
		return criteria.list();
	}

	public List<StRiskDuplicateMaster> getDLScoreRangeMaster(Session session, short domainId, String sectionName) {
		Criteria criteria = session.createCriteria(StRiskDuplicateMaster.class);
		if (domainId != 0) {
			criteria.add(Restrictions.eq("domainId", domainId));
		}
		if (!sectionName.equals("")) {
			criteria.add(Restrictions.eq("sectionName", sectionName));
		}
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		return criteria.list();
	}

	public List<StRiskPlrProfileMaster> saveOrUpdateRiskPlrProfileScore(StatelessSession session,
			Map<Long, DuplicationScoreBean> scoreMap) {

		List<StRiskPlrProfileMaster> oldScoresList = getRiskPlrProfileMaster(session);

		for (int i = 0; i < oldScoresList.size(); i++) {
			StRiskPlrProfileMaster profileMaster = oldScoresList.get(i);
			if (scoreMap.containsKey(profileMaster.getPlayerId())) {
				DuplicationScoreBean bean = scoreMap.get(profileMaster.getPlayerId());
				if (profileMaster.getRegScoreAsNew() < bean.getRegScoreAsNew()) {
					profileMaster.setRegScoreAsNew(bean.getRegScoreAsNew());
				}
				if (profileMaster.getRegScoreAsOld() < bean.getRegScoreAsOld()) {
					profileMaster.setRegScoreAsOld(bean.getRegScoreAsOld());
				}
				if (profileMaster.getDepoScoreAsNew() < bean.getDepoScoreAsNew()) {
					profileMaster.setDepoScoreAsNew(bean.getDepoScoreAsNew());
				}
				if (profileMaster.getDepoScoreAsOld() < bean.getDepoScoreAsOld()) {
					profileMaster.setDepoScoreAsOld(bean.getDepoScoreAsOld());
				}
				if (profileMaster.getWithScoreAsNew() < bean.getWithScoreAsNew()) {
					profileMaster.setWithScoreAsNew(bean.getWithScoreAsNew());
				}
				if (profileMaster.getWithScoreAsOld() < bean.getWithScoreAsOld()) {
					profileMaster.setWithScoreAsOld(bean.getWithScoreAsOld());
				}
				scoreMap.remove(profileMaster.getPlayerId());
			} else {
				oldScoresList.remove(profileMaster);
				i--;
			}
		}

		if (oldScoresList.size() > 0) {
			for (StRiskPlrProfileMaster profileMaster : oldScoresList) {
				session.update(profileMaster);
			}
		}
		Set<Long> playerSet = scoreMap.keySet();
		for (Long playerId : playerSet) {
			StRiskPlrProfileMaster profileMaster = new StRiskPlrProfileMaster();
			profileMaster.setPlayerId(playerId);
			profileMaster.setRegScoreAsNew(scoreMap.get(playerId).getRegScoreAsNew());
			profileMaster.setRegScoreAsOld(scoreMap.get(playerId).getRegScoreAsOld());
			profileMaster.setDepoScoreAsNew(scoreMap.get(playerId).getDepoScoreAsNew());
			profileMaster.setDepoScoreAsOld(scoreMap.get(playerId).getDepoScoreAsOld());
			profileMaster.setWithScoreAsNew(scoreMap.get(playerId).getWithScoreAsNew());
			profileMaster.setWithScoreAsOld(scoreMap.get(playerId).getWithScoreAsOld());
			session.insert(profileMaster);
			oldScoresList.add(profileMaster);
		}
		return oldScoresList;
	}

	public void saveOrUpdateDLPlayerScore(StatelessSession session, List<StRiskDuplicatePlayerScore> newScoresList) {
		Criteria criteria = session.createCriteria(StRiskDuplicatePlayerScore.class);
		List<StRiskDuplicatePlayerScore> oldScoresList = criteria.list();

		if (oldScoresList.size() != 0) {
			StRiskDuplicatePlayerScore oldScore = null;
			StRiskDuplicatePlayerScore newScore = null;
			for (int i = 0; i < oldScoresList.size(); i++) {
				oldScore = oldScoresList.get(i);
				boolean removeObject = true;
				for (int j = 0; j < newScoresList.size(); j++) {
					newScore = newScoresList.get(j);
					if (oldScore.getNewPlayerId().equals(newScore.getNewPlayerId())
							&& oldScore.getOldPlayerId().equals(newScore.getOldPlayerId())) {
						removeObject = false;

						if (newScore.getRegDupScore() != null)
							if (oldScore.getRegDupScore() == null
									|| newScore.getRegDupScore() > oldScore.getRegDupScore()) {
								oldScore.setRegDupScore(newScore.getRegDupScore());
								oldScore.setRegStatus("PENDING");
								oldScore.setRegUserId(0);
								oldScore.setRegVerifyDate(new Timestamp(new Date().getTime()));
							}
						if (newScore.getDepoDupScore() != null)
							if (oldScore.getRegDupScore() == null
									|| newScore.getDepoDupScore() > oldScore.getDepoDupScore()) {
								oldScore.setRegDupScore(newScore.getDepoDupScore());
								oldScore.setDepoStatus("PENDING");
								oldScore.setDepoUserId(0);
								oldScore.setDepoVerifyDate(new Timestamp(new Date().getTime()));
							}
						if (newScore.getWithDupScore() != null)
							if (oldScore.getWithDupScore() == null
									|| newScore.getWithDupScore() > oldScore.getWithDupScore()) {
								oldScore.setWithDupScore(newScore.getWithDupScore());
								oldScore.setWithStatus("PENDING");
								oldScore.setWithUserId(0);
								oldScore.setWithVerifyDate(new Timestamp(new Date().getTime()));
							}
						// Remove object which is already present
						newScoresList.remove(newScore);
						j--;
					}
				}
				if (removeObject) {
					oldScoresList.remove(oldScore);
					i--;
				}
			}

			for (StRiskDuplicatePlayerScore duplicateScore : oldScoresList) {
				session.update(duplicateScore);
			}
		}

		for (StRiskDuplicatePlayerScore duplicateScore : newScoresList) {
			if (!duplicateScore.getNewPlayerId().equals(duplicateScore.getOldPlayerId()))
				session.insert(duplicateScore);
		}
	}

	public void updateDLPlayerMaster(StatelessSession session, List<StPmPlayerMaster> newRegPlrList) {
		for (StPmPlayerMaster playerMaster : newRegPlrList) {
			session.update(playerMaster);
		}
	}

	public void updateRiskPlrTxnControl(StatelessSession session, List<StRiskPlrTxnControl> newPlrTxnControlList) {
		for (StRiskPlrTxnControl riskPlrTxnControl : newPlrTxnControlList) {
			session.update(riskPlrTxnControl);
		}
	}

	public static void setPlrTxnControl(Long playerId, Session session) {
		session.save(new StRiskPlrTxnControl(playerId));
	}

	public static Map<String, String> fetchPlrTxnControl(Long playerId, Session session) {
		Map<String, String> txnControlMap = new HashMap<String, String>();
		Criteria crit = session.createCriteria(StRiskPlrTxnControl.class);
		crit.add(Restrictions.eq("playerId", playerId));
		List<StRiskPlrTxnControl> list = crit.list();
		for (StRiskPlrTxnControl stRiskPlrTxnControl : list) {
			txnControlMap.put(Utility.txnControlTypes.DEPOSIT.name(), stRiskPlrTxnControl.getDeposit());
			txnControlMap.put(Utility.txnControlTypes.WITHDRAWAL.name(), stRiskPlrTxnControl.getWithdrawal());
			txnControlMap.put(Utility.txnControlTypes.WAGER_BINGO.name(), stRiskPlrTxnControl.getWagerBingo());
			txnControlMap.put(Utility.txnControlTypes.WAGER_CASINO.name(), stRiskPlrTxnControl.getWagerCasino());
			txnControlMap.put(Utility.txnControlTypes.WAGER_LIVE_CASINO.name(),
					stRiskPlrTxnControl.getWagerLiveCasino());
			txnControlMap.put(Utility.txnControlTypes.WAGER_POKER.name(), stRiskPlrTxnControl.getWagerPoker());
			txnControlMap.put(Utility.txnControlTypes.WAGER_RUMMY.name(), stRiskPlrTxnControl.getWagerRummy());
			txnControlMap.put(Utility.txnControlTypes.WAGER_SPORTS.name(), stRiskPlrTxnControl.getWagerSports());
			txnControlMap.put(Utility.txnControlTypes.WAGER_GAMES.name(), stRiskPlrTxnControl.getWagerGames());
			txnControlMap.put(Utility.txnControlTypes.WAGER_DRAW_GAMES.name(), stRiskPlrTxnControl.getWagerDrawGames());
			txnControlMap.put(Utility.txnControlTypes.WAGER_SPORTS_LOTTERY.name(),
					stRiskPlrTxnControl.getWagerSportsLottery());
			txnControlMap.put(Utility.txnControlTypes.WAGER_GOLDEN_RACE.name(),
					stRiskPlrTxnControl.getWagerSportsLottery());
			txnControlMap.put(Utility.txnControlTypes.WAGER_INSTANT_DRAW.name(),
					stRiskPlrTxnControl.getWagerInstantDraw());
		}
		return txnControlMap;
	}

	public boolean chkUpdDecisionMatrix(short domainId, long playerId, String doerCode, String activityCode,
			String value, boolean isChange, String userId, StatelessSession session) throws PMSException {
		boolean isUpd = true;
		Criteria cri = null;
		try {
			cri = session.createCriteria(StRiskDecisionActivityMaster.class);
			cri.add(Restrictions.eq("activityCode", activityCode));
			cri.add(Restrictions.eq("status", "ACTIVE"));
			List<StRiskDecisionActivityMaster> activityList = cri.list();
			StRiskDecisionActivityMaster curActivity = null;

			cri = session.createCriteria(StRiskDecisionDoerMaster.class);
			cri.add(Restrictions.eq("doerCode", doerCode));
			cri.add(Restrictions.eq("status", "ACTIVE"));
			List<StRiskDecisionDoerMaster> doerList = cri.list();
			StRiskDecisionDoerMaster curDoer = null;

			if (activityList.size() == 1 && doerList.size() == 1) {
				curActivity = activityList.get(0);
				curDoer = doerList.get(0);
			} else if (activityList.size() > 1 && doerList.size() > 1) {
				throw new PMSException("Multiple Activity/Doer found");
			} else {
				throw new PMSException("No such Activity/Doer or INACTIVE");
			}

			cri = session
					.createCriteria(Class
							.forName("com.stpl.pms.hibernate.mapping.StRiskDecisionInfo" + curActivity.getActivityId()))
					.createAlias("doerMaster", "dm");
			cri.add(Restrictions.eq("domainId", domainId));
			cri.add(Restrictions.eq("playerId", playerId));
			List<Object> list = cri.list();
			DecisionInfoMarkerBean info = null;
			if (list.size() == 1) {
				info = (DecisionInfoMarkerBean) list.get(0);
				String lastValue = info.getValue();
				String criteriaValue = lastValue + "-" + value;
				if (lastValue.equals(value)) {
					// isUpd = false;
					criteriaValue = lastValue + "-" + (value.equals("Y") ? "N" : "Y");
					if (isChange) {
						criteriaValue = (value.equals("Y") ? "N" : "Y") + "-" + lastValue;
					}
				}

				StRiskDecisionDoerMaster newDoer = null;
				if (info.getDoerMaster().getDoerCode().equals(curDoer.getDoerCode())) {
					newDoer = curDoer;
				} else {
					cri = session.createCriteria(StRiskDecisionActivityDoerMapping.class);
					cri.add(Restrictions.eq("activityMaster", curActivity));
					cri.add(Restrictions.in("doerMaster",
							new StRiskDecisionDoerMaster[] { info.getDoerMaster(), curDoer }));
					cri.add(Restrictions.eq("status", "ACTIVE"));
					cri.add(Restrictions.eq("valueOn", criteriaValue));
					cri.addOrder(Order.asc("priorityOrder"));
					newDoer = ((StRiskDecisionActivityDoerMapping) cri.list().get(0)).getDoerMaster();
					if (info.getDoerMaster().getDoerCode().equals(newDoer.getDoerCode())) {
						isUpd = false;
					}
				}
				info.setDoerMaster(newDoer);
				info.setValue(value);
				info.setUserId(userId);
				info.setUpdDatetime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
				session.update(info);
			} else {
				info = (DecisionInfoMarkerBean) Class
						.forName("com.stpl.pms.hibernate.mapping.StRiskDecisionInfo" + curActivity.getActivityId())
						.newInstance();
				info.setPlayerId(playerId);
				info.setDomainId(domainId);
				info.setDoerMaster(curDoer);
				info.setValue(value);
				info.setUserId(userId);
				info.setUpdDatetime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
				session.insert(info);
			}
		} catch (ClassCastException e) {
			e.printStackTrace();
			throw new PMSException("Class Cast Exception");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PMSException("Class NotFoundException");
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new PMSException("InstantiationException");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new PMSException("IllegalAccessException");
		} catch (PMSException e) {
			e.printStackTrace();
			throw e;
		}
		return isUpd;
	}

	public Map<String, Map<String, List<DecisionMatrixMappingBean>>> fetchDecisionMatrix(Session session) {
		Criteria cri = session.createCriteria(StRiskDecisionActivityDoerMapping.class);
		cri.createAlias("activityMaster", "am");
		cri.createAlias("doerMaster", "dm");
		cri.add(Restrictions.eq("am.status", "ACTIVE"));
		cri.add(Restrictions.eq("dm.status", "ACTIVE"));
		cri.addOrder(Order.asc("am.activityId")).addOrder(Order.asc("valueOn")).addOrder(Order.asc("priorityOrder"));
		List<StRiskDecisionActivityDoerMapping> mappingList = cri.list();
		Map<String, Map<String, List<DecisionMatrixMappingBean>>> mappingBeanMap = new TreeMap<String, Map<String, List<DecisionMatrixMappingBean>>>();
		Map<String, List<DecisionMatrixMappingBean>> valueMap = null;
		List<DecisionMatrixMappingBean> mappingBeanList = null;
		DecisionMatrixMappingBean mappingBean = null;
		for (StRiskDecisionActivityDoerMapping mapping : mappingList) {
			mappingBean = new DecisionMatrixMappingBean();
			mappingBean.setMappingId(mapping.getId());
			mappingBean.setActivityName(mapping.getActivityMaster().getActivityName());
			mappingBean.setDoerName(mapping.getDoerMaster().getDoerName());
			mappingBean.setPriorityOrder(mapping.getPriorityOrder());
			mappingBean.setValueOn(mapping.getValueOn());
			mappingBean.setStatus(mapping.getStatus());
			if (!mappingBeanMap.containsKey(mappingBean.getActivityName())) {
				mappingBeanMap.put(mappingBean.getActivityName(),
						new TreeMap<String, List<DecisionMatrixMappingBean>>());
			}
			valueMap = mappingBeanMap.get(mappingBean.getActivityName());
			if (!valueMap.containsKey(mappingBean.getValueOn())) {
				valueMap.put(mappingBean.getValueOn(), new ArrayList<DecisionMatrixMappingBean>());
			}
			mappingBeanList = valueMap.get(mappingBean.getValueOn());
			mappingBeanList.add(mappingBean);
		}
		return mappingBeanMap;
	}

	public void saveUpdDecisionMatrix(int[] mappingId, int[] priorityOrder, String[] status, StatelessSession session) {
		try {
			Query updQry = session.createQuery(
					"update StRiskDecisionActivityDoerMapping set priorityOrder=:priorityOrder,status=:status where id=:mappingId");
			for (int i = 0; i < mappingId.length; i++) {
				updQry.setParameter("priorityOrder", priorityOrder[i]);
				updQry.setParameter("status", status[i]);
				updQry.setParameter("mappingId", mappingId[i]);
				updQry.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<StRiskDuplicateActionNotification> fetchAction(Session session) {

		Criteria criteria = session.createCriteria(StRiskDuplicateActionNotification.class);
		criteria.add(Restrictions.eq("type", "ACTION"));
		List<StRiskDuplicateActionNotification> actionNotificationsList = criteria.list();
		return actionNotificationsList;
	}

	public StPmPlayerMaster getplayerInfo(Object object, Session session) {
		StPmPlayerMaster playerMaster = (StPmPlayerMaster) session.load(StPmPlayerMaster.class,
				Long.valueOf(object.toString()));
		// (StPmPlayerMaster) session.get(StPmPlayerMaster.class,
		// Long.valueOf(object.toString()));
		return playerMaster;
	}

	public List<Object[]> getScoreRangeMaster(Session session, Short domainId, String section, Object object) {
		Criteria criteria = session.createCriteria(StRiskDuplicateMaster.class);
		criteria.add(Restrictions.eq("domainId", domainId));
		criteria.add(Restrictions.eq("sectionName", section));
		criteria.add(Restrictions.le("fromScore", Double.valueOf(object.toString()).intValue()));
		criteria.add(Restrictions.ge("toScore", Double.valueOf(object.toString()).intValue()));
		criteria.setProjection(Projections.property("actionNew"));
		criteria.setProjection(Projections.property("actionOld"));
		List<Object[]> ls = criteria.list();
		return ls;
	}

	// Block IP

	public Map<Integer, String> blockIpSearchResult(Session session, int userId) {
		Criteria criteria = session.createCriteria(StRmBoAllowedIp.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("status", "ACTIVE"));

		// criteria.setProjection(Projections.property("blockedIp"));
		Map<Integer, String> allowedIp = new HashMap<Integer, String>();
		List<StRmBoAllowedIp> allowIp = criteria.list();
		for (StRmBoAllowedIp ls : allowIp) {
			allowedIp.put(ls.getId().intValue(), ls.getAllowedIp());
		}
		return allowedIp;
	}

	public void blockIpSave(Session session, Short domainId, String reason, List<String> ipSet, int userId)
			throws PMSException {
		Timestamp currTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		if (ipSet != null) {

			Criteria criteria = session.createCriteria(StRmBoAllowedIp.class);
			criteria.add(Restrictions.eq("userId", userId));
			criteria.add(Restrictions.in("allowedIp", ipSet));

			List<StRmBoAllowedIp> result = criteria.list();

			for (StRmBoAllowedIp obj : result) {
				Query q = session.createQuery("delete StRmBoAllowedIp where id ="+obj.getId());
				q.executeUpdate();
				ipSet.remove(obj.getAllowedIp());
			}
			if (result.isEmpty()) {
				for (String str : ipSet) {
					String insertquery = "INSERT INTO st_rm_bo_allowed_ip SET allowed_ip=:allowed_ip,domain_id=:domain_id,status=:status,user_id=:user_id,creation_time=:creation_time,reason=:reason,last_updated_by=:last_updated_by,last_updation_time=:last_updation_time";
					SQLQuery query = session.createSQLQuery(insertquery);
					query.setParameter("allowed_ip", str);
					query.setParameter("domain_id", domainId);
					query.setParameter("status", "ACTIVE");
					query.setParameter("user_id", userId);
					query.setParameter("creation_time", currTime);
					query.setParameter("reason", reason);
					query.setParameter("last_updated_by", userId);
					query.setParameter("last_updation_time", currTime);
					query.executeUpdate();
				}
			}

			/*
			 * Criteria criteria = session.createCriteria(StDmBlockedIp.class);
			 * criteria.add(Restrictions.in("blockedIp", ipSet));
			 * criteria.add(Restrictions.eq("domainId", domainId));
			 * List<StDmBlockedIp> stDmBlockedIp2 = criteria.list(); for
			 * (StDmBlockedIp domainIp : stDmBlockedIp2) {
			 * domainIp.setStatus("ACTIVE".equals(domainIp.getStatus())?
			 * "INACTIVE":"ACTIVE"); domainIp.setLastUpdatedBy((long)userId);
			 * domainIp.setLastUpdationTime(currTime); if(reason!=null)
			 * domainIp.setReason(reason); session.update(domainIp);
			 * ipSet.remove(domainIp.getBlockedIp());
			 * 
			 * } for (String str : ipSet) { StDmBlockedIp stDmBlockedIp = new
			 * StDmBlockedIp(); stDmBlockedIp.setBlockedIp(str);
			 * stDmBlockedIp.setDateTime(currTime);
			 * stDmBlockedIp.setReason(reason); stDmBlockedIp.setUserId(userId);
			 * stDmBlockedIp.setDomainId(domainId);
			 * stDmBlockedIp.setStatus("ACTIVE");
			 * stDmBlockedIp.setLastUpdatedBy((long)userId);
			 * stDmBlockedIp.setLastUpdationTime(currTime);
			 * session.save(stDmBlockedIp); }
			 */
		}
	}

	// block E-mail
	public Map<Integer, String> blockEmailSearchResult(Session session, Short domainId, String email) {
		Criteria criteria = session.createCriteria(StDmBlockedEmailId.class);
		if (domainId != -1) {
			criteria.add(Restrictions.eq("domainId", domainId));
		}
		// criteria.add(Restrictions.eq("domainId", Integer.valueOf(domainId)));
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		if (!email.equals("")) {
			criteria.add(Restrictions.eq("emailId", email));
		}
		// criteria.setProjection(Projections.property("blockedIp"));
		Map<Integer, String> blockEmail = new HashMap<Integer, String>();
		List<StDmBlockedEmailId> blockedEmailId = criteria.list();
		for (StDmBlockedEmailId ls : blockedEmailId) {
			blockEmail.put(ls.getId(), ls.getEmailId());
		}
		return blockEmail;
	}

	public void blockEmailSave(Session session, Short domainId, String reason, Set<String> emailSet, int userId)
			throws PMSException {
		Timestamp currTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		if (emailSet != null) {
			String chkDefSpe = CommonMethodDaoImpl.getInstance().getDmProperty(session, domainId, "blockedEmail");
			if (domainId != 1) {
				if (chkDefSpe.equals("BYDEFAULT")) {
					Query qry = session
							.createQuery("update StDmDomainMaster set blockedIp='SPECIFIC' where domainId=:domainId");
					qry.setParameter("domainId", domainId);
					qry.executeUpdate();
				}
			}
			Criteria criteria = session.createCriteria(StDmBlockedEmailId.class);
			criteria.add(Restrictions.in("emailId", emailSet));
			criteria.add(Restrictions.eq("domainId", domainId));
			List<StDmBlockedEmailId> stDmBlockedEmail = criteria.list();
			for (StDmBlockedEmailId emailId : stDmBlockedEmail) {
				emailId.setStatus("ACTIVE".equals(emailId.getStatus()) ? "INACTIVE" : "ACTIVE");
				emailId.setLastUpdatedBy((long) userId);
				emailId.setLastUpdationTime(currTime);
				if (reason != null)
					emailId.setReason(reason);
				session.update(emailId);
				emailSet.remove(emailId.getEmailId());
			}
			for (String str : emailSet) {
				StDmBlockedEmailId stDmBlockedEmailId = new StDmBlockedEmailId();
				stDmBlockedEmailId.setEmailId(str);
				stDmBlockedEmailId.setDateTime(currTime);
				stDmBlockedEmailId.setReason(reason);
				stDmBlockedEmailId.setUserId(userId);
				stDmBlockedEmailId.setDomainId(domainId);
				stDmBlockedEmailId.setStatus("ACTIVE");
				stDmBlockedEmailId.setLastUpdatedBy((long) userId);
				stDmBlockedEmailId.setLastUpdationTime(currTime);
				session.save(stDmBlockedEmailId);
			}
		}
	}

	// Block Phone No:

	public Map<Integer, String> blockPhoneSearchResult(Session session, Short domainId, String phone) {
		Criteria criteria = session.createCriteria(StDmBlockedPhoneNo.class);
		if (domainId != -1) {
			criteria.add(Restrictions.eq("domainId", domainId));
		}
		// criteria.add(Restrictions.eq("domainId", Integer.valueOf(domainId)));
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		if (!phone.equals("")) {
			criteria.add(Restrictions.eq("phoneNo", Long.valueOf(phone)));
		}
		// criteria.setProjection(Projections.property("blockedIp"));
		Map<Integer, String> blockPh = new HashMap<Integer, String>();
		List<StDmBlockedPhoneNo> blockedPhone = criteria.list();
		for (StDmBlockedPhoneNo ls : blockedPhone) {
			blockPh.put(ls.getId(), ls.getPhoneNo().toString());
		}
		return blockPh;
	}

	public void blockPhoneSave(Session session, Short domainId, String reason, Set<Long> phoneSet, int userId)
			throws PMSException {
		Timestamp currTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		if (phoneSet != null) {
			String chkDefSpe = CommonMethodDaoImpl.getInstance().getDmProperty(session, domainId, "blockedEmail");
			if (domainId != 1) {
				if (chkDefSpe.equals("BYDEFAULT")) {
					Query qry = session
							.createQuery("update StDmDomainMaster set blockedIp='SPECIFIC' where domainId=:domainId");
					qry.setParameter("domainId", domainId);
					qry.executeUpdate();
				}
			}

			Criteria criteria = session.createCriteria(StDmBlockedPhoneNo.class);

			criteria.add(Restrictions.in("phoneNo", phoneSet));
			criteria.add(Restrictions.eq("domainId", domainId));
			List<StDmBlockedPhoneNo> stDmBlockedPhoneNo = criteria.list();
			for (StDmBlockedPhoneNo phoneNo : stDmBlockedPhoneNo) {
				phoneNo.setStatus("ACTIVE".equals(phoneNo.getStatus()) ? "INACTIVE" : "ACTIVE");
				phoneNo.setLastUpdatedBy((long) userId);
				phoneNo.setLastUpdationTime(currTime);
				if (reason != null)
					phoneNo.setReason(reason);
				session.update(phoneNo);
				phoneSet.remove(phoneNo.getPhoneNo());
			}

			for (Long str : phoneSet) {
				StDmBlockedPhoneNo stDmBlockedPhone = new StDmBlockedPhoneNo();
				stDmBlockedPhone.setPhoneNo(str);
				stDmBlockedPhone.setDateTime(currTime);
				stDmBlockedPhone.setReason(reason);
				stDmBlockedPhone.setUserId(userId);
				stDmBlockedPhone.setDomainId(domainId);
				stDmBlockedPhone.setStatus("ACTIVE");
				stDmBlockedPhone.setLastUpdatedBy((long) userId);
				stDmBlockedPhone.setLastUpdationTime(currTime);
				session.save(stDmBlockedPhone);
			}

		}
	}

	public List<DuplicationPlrScoreBean> getDuplicationPlayerScore(Short domainId, String scoreFor, Integer min,
			Integer max, Session session) throws PMSException {
		List<Long> playerIds = null;
		List<DuplicationPlrScoreBean> dpsList = new ArrayList<DuplicationPlrScoreBean>();
		try {
			Criteria criteria = session.createCriteria(StRiskPlrProfileMaster.class);
			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.property("playerId"));
			if (scoreFor.equalsIgnoreCase("Registration")) {
				proList.add(Projections.property("regScoreAsNew"));
				proList.add(Projections.property("regScoreAsOld"));
				criteria.add(Restrictions.between("regScoreAsNew", min.doubleValue(), max.doubleValue()));
				criteria.add(Restrictions.between("regScoreAsOld", min.doubleValue(), max.doubleValue()));
			} else if (scoreFor.equalsIgnoreCase("Deposit")) {
				proList.add(Projections.property("depoScoreAsNew"));
				proList.add(Projections.property("depoScoreAsOld"));
				criteria.add(Restrictions.between("depoScoreAsNew", min.doubleValue(), max.doubleValue()));
				criteria.add(Restrictions.between("depoScoreAsOld", min.doubleValue(), max.doubleValue()));
			} else if (scoreFor.equalsIgnoreCase("Withdrawal")) {
				proList.add(Projections.property("withScoreAsNew"));
				proList.add(Projections.property("withScoreAsOld"));
				criteria.add(Restrictions.between("withScoreAsNew", min.doubleValue(), max.doubleValue()));
				criteria.add(Restrictions.between("withScoreAsOld", min.doubleValue(), max.doubleValue()));

			}
			criteria.setProjection(proList);
			List<Object[]> playerScores = criteria.list();
			playerIds = new ArrayList<Long>();
			for (Object[] objects : playerScores) {
				playerIds.add((Long) objects[0]);
			}
			if (playerIds.size() > 0) {
				criteria = session.createCriteria(StPmPlayerMaster.class);
				criteria.createAlias("stPmPlayerInfo", "pi");
				proList = Projections.projectionList();
				proList.add(Projections.property("playerId"));
				proList.add(Projections.property("userName"));
				proList.add(Projections.property("firstName"));
				proList.add(Projections.property("lastName"));
				proList.add(Projections.property("pi.registrationDate"));
				criteria.setProjection(proList);
				criteria.add(Restrictions.in("playerId", playerIds));
				criteria.add(Restrictions.eq("domainId", domainId));
				List<Object[]> playerDetail = criteria.list();
				for (Object[] objects : playerScores) {
					for (Object[] object : playerDetail) {
						if (objects[0].equals(object[0])) {
							DuplicationPlrScoreBean plrScoreBean = new DuplicationPlrScoreBean();
							plrScoreBean.setPlayerId((Long) objects[0]);
							plrScoreBean.setScoreAsNew((Double) objects[1]);
							plrScoreBean.setScoreAsOld((Double) objects[2]);
							plrScoreBean.setUserName((String) object[1]);
							plrScoreBean.setFirstName((String) object[2]);
							plrScoreBean.setLastName((String) object[3]);
							plrScoreBean.setRegistrationDate((Timestamp) object[4]);
							dpsList.add(plrScoreBean);
						}
					}

				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION, PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception re) {
			re.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR, PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return dpsList;
	}

	public List<DuplicationScoreActionBean> duplicationSearchResult(Long playerId, String scoreFor, Integer min,
			Integer max, Session session) throws PMSException {
		List<Object[]> playerScores = null;
		List<DuplicationScoreActionBean> duplicatePlayerScoresList = new ArrayList<DuplicationScoreActionBean>();
		try {
			Criteria criteria = session.createCriteria(StRiskDuplicatePlayerScore.class);
			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.property("newPlayerId"));
			proList.add(Projections.property("oldPlayerId"));
			if (scoreFor.equalsIgnoreCase("Registration")) {
				proList.add(Projections.property("regDupScore"));
				criteria.addOrder(Order.asc("regDupScore"));
				criteria.add(Restrictions.between("regDupScore", min.doubleValue(), max.doubleValue()));
			} else if (scoreFor.equalsIgnoreCase("Deposite")) {
				proList.add(Projections.property("depoDupScore"));
				criteria.addOrder(Order.asc("depoDupScore"));
				criteria.add(Restrictions.between("depoDupScore", min.doubleValue(), max.doubleValue()));
			} else if (scoreFor.equalsIgnoreCase("Withdrawal")) {
				proList.add(Projections.property("withDupScore"));
				criteria.addOrder(Order.asc("withDupScore"));
				criteria.add(Restrictions.between("withDupScore", min.doubleValue(), max.doubleValue()));
			}
			criteria.add(Restrictions.or(Restrictions.eq("newPlayerId", playerId),
					Restrictions.eq("oldPlayerId", playerId)));
			criteria.setProjection(proList);
			playerScores = criteria.list();
			List<Long> playerIds = new ArrayList<Long>();
			for (Object[] objects : playerScores) {
				if (objects[0].equals(playerId)) {
					playerIds.add((Long) objects[1]);
				} else {
					playerIds.add((Long) objects[0]);
				}

			}
			criteria = session.createCriteria(StPmPlayerMaster.class);
			criteria.createAlias("stPmPlayerInfo", "pi");
			proList = Projections.projectionList();
			proList.add(Projections.property("userName"));
			proList.add(Projections.property("firstName"));
			proList.add(Projections.property("lastName"));
			proList.add(Projections.property("pi.registrationDate"));
			criteria.setProjection(proList);
			criteria.add(Restrictions.in("playerId", playerIds));
			List<Object[]> playerDetail = criteria.list();
			int i = 0;
			for (Object[] objects : playerScores) {
				DuplicationScoreActionBean duplicationScoreActionBean = new DuplicationScoreActionBean();
				if (objects[0].equals(playerId)) {
					duplicationScoreActionBean.setOldPlayerId((Long) objects[1]);
				} else {
					duplicationScoreActionBean.setNewPlayerId((Long) objects[0]);
				}
				duplicationScoreActionBean.setScore((Double) objects[2]);
				duplicationScoreActionBean.setFirstName((String) playerDetail.get(i)[1]);
				duplicationScoreActionBean.setUserName((String) playerDetail.get(i)[0]);
				duplicationScoreActionBean.setLastName((String) playerDetail.get(i)[2]);
				duplicationScoreActionBean.setRegistrationDate((Timestamp) playerDetail.get(i)[3]);
				duplicatePlayerScoresList.add(duplicationScoreActionBean);
				i++;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION, PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception re) {
			re.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR, PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}

		return duplicatePlayerScoresList;
	}

	public void submitDuplicationReport(Map<Long, String> dpData, Session session) throws PMSException {
		try {
			Iterator entries = dpData.entrySet().iterator();
			while (entries.hasNext()) {
				Entry thisEntry = (Entry) entries.next();
				StPmPlayerMaster playerMaster = (StPmPlayerMaster) session.load(StPmPlayerMaster.class,
						(Long) thisEntry.getKey());
				playerMaster.setPlrStatus(thisEntry.getValue().toString());
				session.save(playerMaster);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION, PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception re) {
			re.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR, PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
	}

	public String[][] cacheHitStatus(SessionFactory factory) {
		try {
			String regionNames[] = factory.getStatistics().getSecondLevelCacheRegionNames();

			CacheManager manager = CacheManager.getInstance();
			// retrieve all cache
			Set<String> otherCacheRegionNames = new HashSet<>(Arrays.asList(manager.getCacheNames()));

			String hitStatus[][] = new String[regionNames.length][7];
			SecondLevelCacheStatistics secLevelCache = null;
			for (int i = 0; i < regionNames.length; i++) {

				// remove those regions which are used as hibernate 2nd level
				// cache
				otherCacheRegionNames.remove(regionNames[i]);

				secLevelCache = factory.getStatistics().getSecondLevelCacheStatistics(regionNames[i]);
				int j = 6;
				hitStatus[i][j--] = String.valueOf(secLevelCache.getSizeInMemory());
				hitStatus[i][j--] = String.valueOf(secLevelCache.getElementCountOnDisk());
				hitStatus[i][j--] = String.valueOf(secLevelCache.getElementCountInMemory());
				hitStatus[i][j--] = String.valueOf(secLevelCache.getPutCount());
				hitStatus[i][j--] = String.valueOf(secLevelCache.getMissCount());
				hitStatus[i][j--] = String.valueOf(secLevelCache.getHitCount());
				hitStatus[i][j] = regionNames[i];
			}

			// collect stats for other cache regions
			String othersHitStatus[][] = new String[otherCacheRegionNames.size()][7];
			int i = 0;
			for (String cacheStr : otherCacheRegionNames) {
				Ehcache cache = manager.getCache(cacheStr);

				int j = 6;
				othersHitStatus[i][j--] = String.valueOf(cache.getSize());
				othersHitStatus[i][j--] = String.valueOf(cache.getDiskStoreSize());
				othersHitStatus[i][j--] = String.valueOf(cache.getMemoryStoreSize());
				othersHitStatus[i][j--] = String.valueOf(cache.getStatistics().cachePutCount());
				othersHitStatus[i][j--] = String.valueOf(cache.getStatistics().cacheMissCount());
				othersHitStatus[i][j--] = String.valueOf(cache.getStatistics().cacheHitCount());
				othersHitStatus[i][j] = cacheStr;
				i++;
			}

			return ArrayUtils.addAll(othersHitStatus, hitStatus);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void dbConfiguration(DBConfigBean configBean, Session session) {
		Query query = session.getNamedQuery("configDatabase");
		query.setString("domainName", configBean.getDomainName());
		query.setString("aliasName", configBean.getAliasName());
		query.setString("portalContDmName", configBean.getPortalContDmName());
		query.setString("pcSiteName", configBean.getPcSiteName());
		query.setString("mSiteName", configBean.getMsiteName());
		query.setString("contentType", configBean.getContentType());
		query.setString("publicURL", configBean.getPublicURL());
		query.setString("privateURL", configBean.getPrivateURL());
		query.setString("sendmail", configBean.getSendmail());
		query.setString("sendSms", configBean.getSendSms());
		query.setString("cshDmName", configBean.getCshDmName());
		query.setString("plrContentURL", configBean.getPlrContentURL());
		query.setString("landingPageURL", configBean.getLandingPageURL());
		query.setString("emailTempURL", configBean.getEmailTempURL());
		query.setString("rummyIpCur", configBean.getRummyIpCur());
		query.setString("rummyIplive", configBean.getRummyIplive());
		query.setString("commonContDmName", configBean.getCommonContDmName());
		query.executeUpdate();
	}

	public DBConfigBean fetchDBConfiguration(Session session) throws PMSException {
		DBConfigBean dbConfig = null;
		try {
			dbConfig = new DBConfigBean();
			Query query = session.getNamedQuery("fetchDBConfiguration");
			List<Object[]> list = query.list();
			for (Object[] objects : list) {
				BeanUtils.setProperty(dbConfig, objects[0].toString(), objects[1]);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new PMSException("IllegalAccess Exception");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new PMSException("InvocationTarget Exception");
		}
		return dbConfig;
	}

}
