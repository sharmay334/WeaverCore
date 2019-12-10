package com.stpl.pms.controller.riskMgmt;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.daoImpl.dm.DomainMgmtDaoImpl;
import com.stpl.pms.daoImpl.riskMgmt.RiskMgmtDaoImpl;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.StPmPlayerInfo;
import com.stpl.pms.hibernate.mapping.StPmPlayerMaster;
import com.stpl.pms.hibernate.mapping.StRiskDuplicateActionNotification;
import com.stpl.pms.hibernate.mapping.StRiskDuplicateMaster;
import com.stpl.pms.hibernate.mapping.StRiskDuplicatePlayerScore;
import com.stpl.pms.hibernate.mapping.StRiskDuplicateWeightage;
import com.stpl.pms.hibernate.mapping.StRiskPlrProfileMaster;
import com.stpl.pms.hibernate.mapping.StRiskPlrTxnControl;
import com.stpl.pms.hibernate.mapping.StRmBoUserMaster;
import com.stpl.pms.javabeans.DBConfigBean;
import com.stpl.pms.javabeans.DecisionMatrixMappingBean;
import com.stpl.pms.javabeans.DuplicationPlrScoreBean;
import com.stpl.pms.javabeans.DuplicationScoreActionBean;
import com.stpl.pms.javabeans.DuplicationScoreBean;
import com.stpl.pms.struts.common.DuplicationLogic;

@SuppressWarnings("unchecked")
public class BORiskMgmtController {
	private static final Logger log = Logger.getLogger(BORiskMgmtController.class);

	public List<StRiskDuplicateActionNotification> getDLActionNotificationList()
			throws PMSException {
		Session session = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		List<StRiskDuplicateActionNotification> actionNotiList = null;
		try {
			session = HibernateSessionFactory.getSession();
			actionNotiList = daoImpl.getDLActionNotificationList(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return actionNotiList;
	}

	public void updateDLScoreRangeMaster(
			List<StRiskDuplicateMaster> newScoreList,short privDomainId, long userId) throws PMSException {
		log.info("---updation of Duplication Score Range Start---");
		StatelessSession statelessSession = null;
		Transaction tx = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		 DomainMgmtDaoImpl domDaoImpl = new DomainMgmtDaoImpl();
		try {
			statelessSession = HibernateSessionFactory.getSessionFactory()
					.openStatelessSession();
			tx = statelessSession.beginTransaction();
			daoImpl.updateDLScoreRangeMaster(newScoreList, privDomainId,
					statelessSession, userId);
			// update domain Master;
			if (privDomainId == 1) {
				domDaoImpl.updateDomainMaster(privDomainId, "SPECIFIC",
						statelessSession);
			}
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} finally {
			statelessSession.close();
		}
		log.info("---updation of Duplication Score Range End---");
	}

	public void updateDLFieldWeightage(
			List<StRiskDuplicateWeightage> fieldWeighatgeList, long userId)
			throws PMSException {
		log.info("---updation of Duplication field weightage Start---");
		StatelessSession statelessSession = null;
		Transaction tx = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		 DomainMgmtDaoImpl domDaoImpl = new DomainMgmtDaoImpl();
		try {
			statelessSession = HibernateSessionFactory.getSessionFactory()
					.openStatelessSession();
			tx = statelessSession.beginTransaction();
			daoImpl
					.updateDLFieldWeightage(fieldWeighatgeList,
							statelessSession, userId);
			// update domain Master;
			if (fieldWeighatgeList.get(0).getDomainId().equals("1")) {
				domDaoImpl.updateDomainMaster(fieldWeighatgeList.get(0)
						.getDomainId(), "SPECIFIC", statelessSession);
			}
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} finally {
			statelessSession.close();
		}
		log.info("---updation of Duplication field weightage End---");
	}

	public void saveDLScoreRangeMaster(List<StRiskDuplicateMaster> dupScoreList, long userId)
			throws PMSException {
		log.info("---Insertion of Duplication Score Range Start---");
		StatelessSession statelessSession = null;
		Transaction tx = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		DomainMgmtDaoImpl domDaoImpl = new DomainMgmtDaoImpl();
		try {
			statelessSession = HibernateSessionFactory.getSessionFactory()
					.openStatelessSession();
			tx = statelessSession.beginTransaction();
			daoImpl.saveDLScoreRangeMaster(dupScoreList, statelessSession, userId);
			if(!dupScoreList.isEmpty()){
			domDaoImpl.updateDomainMaster(dupScoreList.get(0).getDomainId(),
					"SPECIFIC", statelessSession);
			}
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} finally {

			statelessSession.close();
		}
		log.info("---Insertion of Duplication Score Range End---");
	}

	public void saveDLFieldWeightage(
			List<StRiskDuplicateWeightage> fieldWeighatgeList, long userId)
			throws PMSException {
		log.info("---Insertion of Duplication Field Weightage Start---");
		StatelessSession statelessSession = null;
		Transaction tx = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		try {
			statelessSession = HibernateSessionFactory.getSessionFactory()
					.openStatelessSession();
			tx = statelessSession.beginTransaction();
			daoImpl.saveDLFieldWeightage(fieldWeighatgeList, statelessSession, userId);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} finally {

			statelessSession.close();
		}
		log.info("---Insertion of Duplication Field Weightage End---");
	}

	public List<StRiskDuplicateWeightage> getDLFieldWeightage(short domainId,
			String sectionName) throws PMSException {
		log.info("---Start Fetching of Duplication Field Weightage---");
		Session session = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		List<StRiskDuplicateWeightage> fieldWeightList = null;
		try {
			session = HibernateSessionFactory.getSession();
			fieldWeightList = daoImpl.getDLFieldWeightage(session,
						domainId, sectionName);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		log.info("---End Fetching of Duplication Field Weightage---");
		return fieldWeightList;
	}

	public List<StRiskDuplicateMaster> getDLScoreRangeMaster(short domainId,
			String sectionName) throws PMSException {
		log.info("---Start Fetching of Duplication Score Master---");
		Session session = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		List<StRiskDuplicateMaster> scoreRangeMasterList = null;
		try {
			session = HibernateSessionFactory.getSession();
			scoreRangeMasterList = daoImpl.getDLScoreRangeMaster(session,
						domainId, sectionName);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		log.info("---End Fetching of Duplication Score Master---");
		return scoreRangeMasterList;
	}

	public void updateDLPlayerDuplicationScore() {
		log.info("---Duplication Scheduler Start---");
		StatelessSession statelessSession = null;
		Session session = null;
		Transaction tx = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		Double comScore = 0.0;
		Map<Long, DuplicationScoreBean> scoreMap = new HashMap<Long, DuplicationScoreBean>();
		Map<Long, Short> playerIdDomainIdMap = new HashMap<Long, Short>();
		try {
			statelessSession = HibernateSessionFactory.getSessionFactory()
					.openStatelessSession();
			session = HibernateSessionFactory.getSession();
			session.clear();
			tx = statelessSession.beginTransaction();
			List<StPmPlayerMaster> newRegPlrList = daoImpl.getDLPlayerMaster(
					session, "Y");

			if (newRegPlrList.size() != 0) {
				StRiskDuplicatePlayerScore duplicateScore;

				List<StPmPlayerMaster> OldRegPlrList = daoImpl
						.getDLPlayerMaster(session, null);

				List<StRiskDuplicatePlayerScore> duplicateScoresList = new ArrayList<StRiskDuplicatePlayerScore>();
				Class masterBean = StPmPlayerMaster.class;
				Class infoBean = StPmPlayerInfo.class;
				Method method;
				Object oldValue = null, newValue = null;
				BeanInfo beanInfo = Introspector.getBeanInfo(masterBean);
				List<String> masterFieldList = new ArrayList<String>();
				for (int i = 0; i < beanInfo.getPropertyDescriptors().length; i++) {
					String fieldName = beanInfo.getPropertyDescriptors()[i]
							.getName();
					masterFieldList.add(fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1));
				}

				beanInfo = Introspector.getBeanInfo(infoBean);
				List<String> infoFieldList = new ArrayList<String>();
				for (int i = 0; i < beanInfo.getPropertyDescriptors().length; i++) {
					String fieldName = beanInfo.getPropertyDescriptors()[i]
							.getName();
					infoFieldList.add(fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1));
				}

				List<StRiskDuplicateMaster> duplicateMaster = daoImpl
						.getDLScoreRangeMaster(session, new Short(0 + ""), "");
				List<StRiskDuplicateWeightage> fieldWeightList = daoImpl
						.getDLFieldWeightage(session, new Short(0 + ""), "");

				// create is scoreMaster according to domainId
				Map<Short, Map<String, List<String>>> maxScoreRecordMap = new HashMap<Short, Map<String, List<String>>>();
				Map<Short, Map<String, List<StRiskDuplicateMaster>>> scoreMasterMap = new HashMap<Short, Map<String, List<StRiskDuplicateMaster>>>();
				Map<String, List<String>> sectionMap = null;
				Map<String, List<StRiskDuplicateMaster>> sectionScoreMap = null;
				List<StRiskDuplicateMaster> scoreList = null;
				List<String> rangeScoreList = null;
				
				for (StRiskDuplicateMaster duplcateMaster : duplicateMaster) {

					sectionScoreMap = scoreMasterMap.get(duplcateMaster
							.getDomainId());
					if (sectionScoreMap == null) {
						sectionScoreMap = new HashMap<String, List<StRiskDuplicateMaster>>();
					}
					scoreMasterMap.put(duplcateMaster.getDomainId(),
							sectionScoreMap);

					scoreList = sectionScoreMap.get(duplcateMaster
							.getSectionName());
					if (scoreList == null) {
						scoreList = new ArrayList<StRiskDuplicateMaster>();
					}
					sectionScoreMap.put(duplcateMaster.getSectionName(),
							scoreList);
					scoreList.add(duplcateMaster);

					if (!duplcateMaster.getIsRecord().equals("N")) {
						sectionMap = maxScoreRecordMap.get(duplcateMaster
								.getDomainId());
						if (sectionMap == null) {
							sectionMap = new HashMap<String, List<String>>();
							rangeScoreList = new ArrayList<String>();
						}
						rangeScoreList.add(duplcateMaster.getFromScore() +"-" + duplcateMaster.getToScore());
						sectionMap.put(duplcateMaster.getSectionName(),rangeScoreList);
						maxScoreRecordMap.put(duplcateMaster.getDomainId(),
								sectionMap);
					}
				}

				// create StPmDuplicateWeightage list according to domainId
				Map<Short, Map<String, List<StRiskDuplicateWeightage>>> domainFieldWeightMap = new HashMap<Short, Map<String, List<StRiskDuplicateWeightage>>>();
				Map<String, List<StRiskDuplicateWeightage>> sectionWeightMap = null;
				List<StRiskDuplicateWeightage> weightList = null;
				for (StRiskDuplicateWeightage duplicateWeightage : fieldWeightList) {
					String[] str = duplicateWeightage.getFieldName().split("_");
					StringBuilder builder = new StringBuilder();
					for (int i = 0; i < str.length; i++) {
						builder.append(str[i].substring(0, 1).toUpperCase()
								+ str[i].substring(1));
					}
					duplicateWeightage.setFieldName(builder.toString());

					sectionWeightMap = domainFieldWeightMap
							.get(duplicateWeightage.getDomainId());
					if (sectionWeightMap == null) {
						sectionWeightMap = new HashMap<String, List<StRiskDuplicateWeightage>>();
					}
					weightList = sectionWeightMap.get(duplicateWeightage
							.getSectionName());
					if (weightList == null) {
						weightList = new ArrayList<StRiskDuplicateWeightage>();
					}
					weightList.add(duplicateWeightage);
					sectionWeightMap.put(duplicateWeightage.getSectionName(),
							weightList);
					domainFieldWeightMap.put(duplicateWeightage.getDomainId(),
							sectionWeightMap);
				}

				short domainIdForIsDefault = 0;
				for (StPmPlayerMaster newPlayerMaster : newRegPlrList) {
					
					if (CommonMethodDaoImpl.getInstance().getDmProperty(session, newPlayerMaster.getDomainId(), "duplicateLogic").equals("BYDEFAULT")) {
						domainIdForIsDefault = 1;
					} else {
						domainIdForIsDefault = newPlayerMaster.getDomainId();
					}

					if (!playerIdDomainIdMap.containsKey(newPlayerMaster
							.getPlayerId())) {
						playerIdDomainIdMap.put(newPlayerMaster.getPlayerId(),
								domainIdForIsDefault);
					}
					Double newPlayerAsRegScore = 0.0;
					Double newPlayerAsDepoScore = 0.0;
					Double newPlayerAsWithScore = 0.0;
					for (StPmPlayerMaster oldPlayerMaster : OldRegPlrList) {

						if (!playerIdDomainIdMap.containsKey(oldPlayerMaster
								.getPlayerId())) {
							if (CommonMethodDaoImpl.getInstance().getDmProperty(session, oldPlayerMaster.getDomainId(), "duplicateLogic")
									.equals("BYDEFAULT")) {
								playerIdDomainIdMap.put(oldPlayerMaster
										.getPlayerId(), new Short(1 + ""));
							} else {
								playerIdDomainIdMap.put(oldPlayerMaster
										.getPlayerId(), oldPlayerMaster
										.getDomainId());
							}
						}

						if (newPlayerMaster.getPlayerId().equals(
								oldPlayerMaster.getPlayerId())
								|| newPlayerMaster.getPlayerId() < oldPlayerMaster
										.getPlayerId()) {
							continue;
						}
						// Check for same domain

						if (CommonMethodDaoImpl.getInstance().fetchSystemProperties(
								"CHECK_INTER_DOMAIN_DUPLICATION",session)
								.equals("N")) {
							if (!newPlayerMaster.getDomainId().equals(
									oldPlayerMaster.getDomainId())) {
								continue;
							}
						}

						double regScore = 0.0;
						double depoScore = 0.0;
						double withScore = 0.0;
						String regStatus = null;
						String depoStatus = null;
						;
						String withStatus = null;
						List<String> sectionList = new ArrayList<String>();

						sectionList.add("REGISTRATION");
						sectionList.add("DEPOSIT");
						sectionList.add("WITHDRAWAL");

						for (String sectionName : sectionList) {
							Double finalScore = 0.0;
							fieldWeightList = domainFieldWeightMap.get(
									domainIdForIsDefault).get(sectionName);
							if (fieldWeightList != null)
								for (StRiskDuplicateWeightage duplicateWeightage : fieldWeightList) {

									if (masterFieldList
											.contains(duplicateWeightage
													.getFieldName())) {
										method = masterBean.getMethod("get"
												+ duplicateWeightage
														.getFieldName());
										oldValue = method.invoke(
												oldPlayerMaster,
												(Object[]) null);
										newValue = method.invoke(
												newPlayerMaster,
												(Object[]) null);
									} else if (infoFieldList
											.contains(duplicateWeightage
													.getFieldName())) {
										method = infoBean.getMethod("get"
												+ duplicateWeightage
														.getFieldName());
										oldValue = method.invoke(
												oldPlayerMaster
														.getStPmPlayerInfo(),
												(Object[]) null);
										newValue = method.invoke(
												newPlayerMaster
														.getStPmPlayerInfo(),
												(Object[]) null);
									} else {
										// For address Hard Code
									}
									if (duplicateWeightage.getMatchCriteria()
											.equals("SIMILAR") && oldValue!=null && newValue!=null) {
										comScore = DuplicationLogic
												.compareStrings(oldValue
														.toString(), newValue
														.toString());
										finalScore = finalScore
												+ duplicateWeightage
														.getWeightage()
												* Math.round(comScore * 100.0)
												/ 100.0;
									} else {
										if (oldValue !=null && newValue!=null && oldValue.toString()
												.equalsIgnoreCase(
														newValue.toString())) {
											finalScore = finalScore
													+ duplicateWeightage
															.getWeightage();
										}
									}

								}

							if (sectionName.equals("REGISTRATION")) {
								regScore = finalScore;
							} else if (sectionName.equals("DEPOSIT")) {
								depoScore = finalScore;
							} else if (sectionName.equals("WITHDRAWAL")) {
								withScore = finalScore;
							}
							
							boolean scoreFound = false;
							// Check if score is less then record score
							if (maxScoreRecordMap.get(domainIdForIsDefault) != null
									&& maxScoreRecordMap.get(domainIdForIsDefault).get(sectionName) != null) {
								rangeScoreList = maxScoreRecordMap.get(domainIdForIsDefault).get(sectionName);
								
								
								for(String score : rangeScoreList){
									String[] scoreArr = score.split("-");
									if(Integer.parseInt(scoreArr[0]) <= finalScore
											&& finalScore <= Integer.parseInt(scoreArr[1])){
										scoreFound = true;
										break;
									}
								}
								if(scoreFound){
									if (sectionName.equals("REGISTRATION")) {
										regStatus = "PENDING";
									} else if (sectionName.equals("DEPOSIT")) {
										depoStatus = "PENDING";
									} else if (sectionName.equals("WITHDRAWAL")) {
										withStatus = "PENDING";
									}
								}
							}
							if(!scoreFound){
								if (sectionName.equals("REGISTRATION")) {
									regStatus = "PROCESSED";
								} else if (sectionName.equals("DEPOSIT")) {
									depoStatus = "PROCESSED";
								} else if (sectionName.equals("WITHDRAWAL")) {
									withStatus = "PROCESSED";
								}
							}
						}

						if (regStatus.equals("PENDING")
								|| depoStatus.equals("PENDING")
								|| withStatus.equals("PENDING")) {
							duplicateScore = new StRiskDuplicatePlayerScore();
							duplicateScore.setDepoDupScore(depoScore);
							duplicateScore.setDepoStatus(depoStatus);
							duplicateScore.setNewPlayerId(newPlayerMaster
									.getPlayerId());
							duplicateScore.setOldPlayerId(oldPlayerMaster
									.getPlayerId());
							duplicateScore.setRegDupScore(regScore);
							duplicateScore.setRegStatus(regStatus);
							duplicateScore.setWithDupScore(withScore);
							duplicateScore.setWithStatus(withStatus);
							duplicateScoresList.add(duplicateScore);
						}

						if (newPlayerAsRegScore < regScore) {
							newPlayerAsRegScore = regScore;
						}
						if (newPlayerAsDepoScore < depoScore) {
							newPlayerAsDepoScore = depoScore;
						}
						if (newPlayerAsWithScore < withScore) {
							newPlayerAsWithScore = withScore;
						}
						DuplicationScoreBean scoreBean = scoreMap
								.get(oldPlayerMaster.getPlayerId());
						if (scoreBean == null) {
							scoreBean = new DuplicationScoreBean();
							scoreBean.setRegScoreAsOld(regScore);
							scoreBean.setDepoScoreAsOld(depoScore);
							scoreBean.setWithScoreAsOld(withScore);
						}
						if (scoreBean.getRegScoreAsOld() < regScore) {
							scoreBean.setRegScoreAsOld(regScore);
						}
						if (scoreBean.getDepoScoreAsOld() < depoScore) {
							scoreBean.setDepoScoreAsOld(depoScore);
						}
						if (scoreBean.getWithScoreAsOld() < withScore) {
							scoreBean.setWithScoreAsOld(withScore);
						}
						scoreMap.put(oldPlayerMaster.getPlayerId(), scoreBean);
					}

					DuplicationScoreBean scoreBean = scoreMap
							.get(newPlayerMaster.getPlayerId());
					if (scoreBean == null) {
						scoreBean = new DuplicationScoreBean();
					}
					scoreBean.setRegScoreAsNew(newPlayerAsRegScore);
					scoreBean.setDepoScoreAsNew(newPlayerAsDepoScore);
					scoreBean.setWithScoreAsNew(newPlayerAsWithScore);

					if (scoreBean.getRegScoreAsOld() == null) {
						scoreBean.setRegScoreAsOld(0.0);
					}
					if (scoreBean.getDepoScoreAsOld() == null) {
						scoreBean.setDepoScoreAsOld(0.0);
					}
					if (scoreBean.getWithScoreAsOld() == null) {
						scoreBean.setWithScoreAsOld(0.0);
					}
					scoreMap.put(newPlayerMaster.getPlayerId(), scoreBean);
					newPlayerMaster.setDuplicationCheckReq("N");
				}
				// Save all score.
				daoImpl.saveOrUpdateDLPlayerScore(statelessSession,
						duplicateScoresList);
				List<StRiskPlrProfileMaster> oldScoresList = daoImpl
						.saveOrUpdateRiskPlrProfileScore(statelessSession,
								scoreMap);
				updatePlayerTxnControl(statelessSession, oldScoresList,
						duplicateMaster, playerIdDomainIdMap,duplicateScoresList);
				
				daoImpl.updateDLPlayerMaster(statelessSession, newRegPlrList);
				tx.commit();
				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			statelessSession.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			statelessSession.close();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		log.info("---Duplication Scheduler End---");
	}

	public void updatePlayerTxnControl(StatelessSession statelessSession,
			List<StRiskPlrProfileMaster> oldScoresList,
			List<StRiskDuplicateMaster> duplicateMaster,
			Map<Long, Short> playerIdDomainIdMap,
			List<StRiskDuplicatePlayerScore> duplicateScoresList) throws PMSException {

		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		
		List<StRiskPlrTxnControl> newRiskPlrTxControlList = new ArrayList<StRiskPlrTxnControl>();
		Map<Long, StRiskPlrTxnControl> riskPlrTxControlMap = new HashMap<Long, StRiskPlrTxnControl>();

		List<StRiskPlrTxnControl> riskPlrTxControl = daoImpl
				.getRiskPlrControl(statelessSession);

		for (StRiskPlrTxnControl proPlrTxnControl : riskPlrTxControl) {
			riskPlrTxControlMap.put(proPlrTxnControl.getPlayerId(),
					proPlrTxnControl);
		}

		List<String> actionNewList = null;
		List<String> actionOldList = null;
		List<String> notifiNewList = null;
		List<String> notifiOldList = null;
		String activityName = null;

		Map<String, List<StRiskDuplicateMaster>> sectionScoreMap = null;
		List<StRiskDuplicateMaster> scoreList = null;

		Map<Short, Map<String, List<StRiskDuplicateMaster>>> finalScoreMap = new HashMap<Short, Map<String, List<StRiskDuplicateMaster>>>();

		for (StRiskDuplicateMaster scoreMaster : duplicateMaster) {
			sectionScoreMap = finalScoreMap.get(scoreMaster.getDomainId());
			if (sectionScoreMap == null) {
				sectionScoreMap = new HashMap<String, List<StRiskDuplicateMaster>>();
			}
			finalScoreMap.put(scoreMaster.getDomainId(), sectionScoreMap);
			scoreList = sectionScoreMap.get(scoreMaster.getSectionName());
			if (scoreList == null) {
				scoreList = new ArrayList<StRiskDuplicateMaster>();
			}
			sectionScoreMap.put(scoreMaster.getSectionName(), scoreList);
			scoreList.add(scoreMaster);
		}

		try {
			for (StRiskPlrProfileMaster profileMaster : oldScoresList) {
				StRiskPlrTxnControl proPlrTxnControl = riskPlrTxControlMap
						.get(profileMaster.getPlayerId());

				sectionScoreMap = finalScoreMap.get(playerIdDomainIdMap
						.get(profileMaster.getPlayerId()));

				Set<String> keySet = sectionScoreMap.keySet();
				for (String sectionName : keySet) {

					scoreList = sectionScoreMap.get(sectionName);
					if (scoreList == null) {
						continue;
					}
					
					for(StRiskDuplicateMaster duplicationMaster : scoreList){
						if(duplicationMaster.getFromScore() <= profileMaster.getRegScoreAsNew()
								&& duplicationMaster.getToScore() >= profileMaster.getRegScoreAsNew()){
							
							actionNewList = duplicationMaster.getActionNewList();
							notifiNewList = duplicationMaster.getNotifiNewList();

						}
						if(duplicationMaster.getFromScore() <= profileMaster.getRegScoreAsOld()
								&& duplicationMaster.getToScore() >= profileMaster.getRegScoreAsOld()){
							
							actionOldList = duplicationMaster.getActionOldList();
							notifiOldList = duplicationMaster.getNotifiOldList();

						}
					}

					if (actionNewList != null)
						for (String actionNew : actionNewList) {
							if (actionNew.equals("")) {
								continue;
							}
							activityName = actionNew.substring(5).toLowerCase();
							actionNew = WordUtils.capitalizeFully(actionNew,
									new char[] { '_' }).substring(4).replaceAll("_", "");
							actionNew = Character.toLowerCase(actionNew.charAt(0))
									+ actionNew.substring(1);
							boolean isProceed = daoImpl.chkUpdDecisionMatrix(playerIdDomainIdMap
									.get(profileMaster.getPlayerId()), profileMaster.getPlayerId(), "DUPLICATION_LOGIC", 
									activityName, "N", false, "Auto", statelessSession);
							if (isProceed) {
								BeanUtils.setProperty(proPlrTxnControl,actionNew, "N");
							}
						}

					if (actionOldList != null)
						for (String actionOld : actionOldList) {
							if (actionOld.equals("")) {
								continue;
							}
							activityName = actionOld.substring(5).toLowerCase();
							actionOld = WordUtils.capitalizeFully(actionOld,
									new char[] { '_' }).substring(4)
									.replaceAll("_", "");
							actionOld = Character.toLowerCase(actionOld
									.charAt(0))
									+ actionOld.substring(1);
							boolean isProceed = daoImpl.chkUpdDecisionMatrix(playerIdDomainIdMap
									.get(profileMaster.getPlayerId()), profileMaster.getPlayerId(), "DUPLICATION_LOGIC", 
									activityName, "N", false, "Auto", statelessSession);
							if (isProceed) {
								BeanUtils.setProperty(proPlrTxnControl,
										actionOld, "N");
							}
						}

					newRiskPlrTxControlList.add(proPlrTxnControl);

					// Mail Sending API
					log.info("Player Mail " + profileMaster.getPlayerId() + " "
							+ notifiNewList + " " + notifiOldList);
					
//					for(String notiOldMail :  notifiNewList){
//						
////						CommMgmtController comController = new CommMgmtController();
////						String text = "Hi, "+ "\n" + "your new password is " + returnString;
////						returnString = comController.sendMailBO(email, text);
//						
//					}
					

				}

			}
			// update Risk Plr Txn Control
			daoImpl.updateRiskPlrTxnControl(statelessSession,
					newRiskPlrTxControlList);

		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new PMSException("Exeption");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new PMSException("Exeption");
		}
	}

//	public boolean chkUpdDecisionMatrix(short domainId, long playerId,
//			String doerCode, String activityCode, String value, boolean isChange, String userId) throws PMSException{
//		log.info("---Check and update Decision Matrix Start---");
//		Session session = null;
//		Transaction tx = null;
//		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
//		boolean isUpd=false;
//		try {
//			session = HibernateSessionFactory.getSession();
//			tx = session.beginTransaction();
//			isUpd=daoImpl.chkUpdDecisionMatrix(domainId, playerId, doerCode, activityCode, value, isChange, userId, session);
//			tx.commit();
//			session.flush();
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			if (tx != null && tx.isActive())
//				tx.rollback();
//			throw new PMSException("Hibernate Exception");
//		} finally {
//			session.close();
//		}
//		log.info("---Check and update Decision Matrix End---"+isUpd);
//		return isUpd;
//	}
	
	public Map<String, Map<String, List<DecisionMatrixMappingBean>>> fetchDecisionMatrix() throws PMSException {
		Session session = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		Map<String, Map<String, List<DecisionMatrixMappingBean>>> mappingBeanMap=null;
		try {
			session = HibernateSessionFactory.getSession();
			mappingBeanMap=daoImpl.fetchDecisionMatrix(session);
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			session.close();
		}
		return mappingBeanMap;
	}

	public void saveUpdDecisionMatrix(int[] mappingId, int[] priorityOrder,
			String[] status) throws PMSException {
		StatelessSession session = null;
		Transaction tx = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		try {
			session = HibernateSessionFactory.getSessionFactory().openStatelessSession();
			tx = session.beginTransaction();
			daoImpl.saveUpdDecisionMatrix(mappingId,priorityOrder,status, session);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Exception");
		} finally {
			session.close();
		}
	}
	
	
	public List<DuplicationScoreActionBean> duplicationSearchResult(Long playerId,String scoreFor,Integer min,Integer max) throws PMSException{
		Session session = null;
		Transaction tx = null;
		List<DuplicationScoreActionBean> duplicatePlayerScoresList = new ArrayList<DuplicationScoreActionBean>();
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			duplicatePlayerScoresList = daoImpl.duplicationSearchResult(playerId,scoreFor,min,max,session);
			//List<StRiskDuplicateActionNotification>actionNotifications =  new ArrayList<StRiskDuplicateActionNotification>();
			//daoImpl.fetchAction(session);
			//log.info(playerScores.get(0));
			
//			
//			for(Object[] score : playerScores){
//				StPmPlayerMaster playerInfo= daoImpl.getplayerInfo(score[1],session);
//				log.info(playerInfo.getDomainId());
//				log.info(playerInfo.getUserName());
//			List<Object[]>action = daoImpl.getScoreRangeMaster(session,playerInfo.getDomainId(),scoreFor.toUpperCase(),score[2]);
//			String actionList[] =action.get(0).toString().split(",");
			//daoImpl.getDLScoreRangeMaster(session, playerInfo.getDomainId(), scoreFor)
//				DuplicationScoreActionBean scoreActionBean =  new DuplicationScoreActionBean();
//				scoreActionBean.setActionNotifications(actionNotifications);
//				log.info(score[0]);
//				log.info(score);
//				log.info(score[1]);
//				log.info(score[2]);
				//score[1];
//				scoreActionBean.setNewPlayerId(Long.valueOf(score[0].toString()));
//				scoreActionBean.setOldPlayerId(Long.valueOf(score[1].toString()));
//				if(scoreFor.equalsIgnoreCase("Registration"))
//				{
//					scoreActionBean.setScore(Double.valueOf(score[2].toString()));
//					
//				}else if (scoreFor.equalsIgnoreCase("Deposite")){
//					scoreActionBean.setScore(Double.valueOf(score[2].toString()));
//					
//				}else if(scoreFor.equalsIgnoreCase("Withdrawal")){
//					scoreActionBean.setScore(Double.valueOf(score[2].toString()));
//				}
//				duplicatePlayerScoresList.add(scoreActionBean);
				//scoreActionBean.get
//			}
			tx.commit();
			return duplicatePlayerScoresList;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Some Internal Error!");
		} finally {
			session.close();
		}
	}
	// Block IP
	public Map<Integer, String> blockIpSearchResult(int userId)
			throws PMSException {
		Session session = null;
		Transaction tx = null;
		Map<Integer, String> Map = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Map = daoImpl.blockIpSearchResult(session,userId);
			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Some Internal Error!");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return Map;
	}

	public void blockIpSave(short domainId, String reason, List<String> ip,
			int userId) throws PMSException {
		Session session = null;
		Transaction tx = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			daoImpl.blockIpSave(session, domainId, reason, ip, userId);
			tx.commit();
			session.flush();
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

	// Block Email

	public Map<Integer, String> blockEmailSearchResult(Short domainId, String email)
			throws PMSException {
		Session session = null;
		Transaction tx = null;
		Map<Integer, String> Map = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Map = daoImpl.blockEmailSearchResult(session, domainId, email);
			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Some Internal Error!");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return Map;

	}

	public void blockEmailSave(Short domainId, String reason, Set<String> emailSet,
			int userId) throws PMSException {

		Session session = null;
		Transaction tx = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			daoImpl.blockEmailSave(session, domainId, reason, emailSet,
					userId);
			tx.commit();
			session.flush();
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

	// Block Phone

	public Map<Integer, String> blockPhoneSearchResult(Short domainId, String phone)
			 {
		Session session = null;
		Transaction tx = null;
		Map<Integer, String> Map = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Map = daoImpl.blockPhoneSearchResult(session, domainId, phone);
			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return Map;
	}

	public void blockPhoneSave(Short domainId, String reason, Set<Long> phoneSet,
			int userId) throws PMSException {
		Session session = null;
		Transaction tx = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			daoImpl.blockPhoneSave(session, domainId, reason, phoneSet,
					userId);
			tx.commit();
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

	public List<DuplicationPlrScoreBean> getDuplicationPlayerScore(Short domainId, String scoreFor,Integer min, Integer max)throws PMSException {
		Session session = null;
		Transaction tx = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		List<DuplicationPlrScoreBean> dpsList = new ArrayList<DuplicationPlrScoreBean>();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			dpsList = daoImpl.getDuplicationPlayerScore(domainId,scoreFor,min,max,session);
		}catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Some Internal Error!");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}

		}
		return dpsList;
    }

	public void submitDuplicationReport(Map<Long, String> dpData)throws PMSException {
		Session session = null;
		Transaction tx = null;
		RiskMgmtDaoImpl daoImpl = new RiskMgmtDaoImpl();
		try{
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			daoImpl.submitDuplicationReport(dpData,session);
			tx.commit();
		}catch (Exception e) {
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

	public String[][] cacheHitStatus() {
		try {
			SessionFactory factory =HibernateSessionFactory.getSessionFactory();
			return new RiskMgmtDaoImpl().cacheHitStatus(factory);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void dbConfiguration(DBConfigBean configBean) throws PMSException{
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			new RiskMgmtDaoImpl().dbConfiguration(configBean, session);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Hibernate Error");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Some Internal Error!");
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public DBConfigBean fetchDBConfiguration() throws PMSException{
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return new RiskMgmtDaoImpl().fetchDBConfiguration(session);
		}catch (PMSException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Some Internal Error!");
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}

		}
	}

	public int getUserId(String userName) {
		// TODO Auto-generated method stub
		try{
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
			criteria.add(Restrictions.eq("userName",userName));
			List<StRmBoUserMaster> result = criteria.list();
			if(result!=null){
				for(StRmBoUserMaster obj:result){
					return obj.getUserId();
				}
			}
			
		}catch(Exception e){e.printStackTrace();}
		return 0;
	}
}
