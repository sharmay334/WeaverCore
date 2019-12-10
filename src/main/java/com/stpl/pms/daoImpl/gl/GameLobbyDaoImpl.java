package com.stpl.pms.daoImpl.gl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.lang.WordUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.StPortalGameDomainRoleMapping;
import com.stpl.pms.hibernate.mapping.StPortalGameLobbyMapping;
import com.stpl.pms.hibernate.mapping.StPortalGameThemeMaster;
import com.stpl.pms.hibernate.mapping.StPortalGamesMaster;
import com.stpl.pms.hibernate.mapping.StPortalLobbyMaster;
import com.stpl.pms.hibernate.mapping.StRmServiceVendorProperties;
import com.stpl.pms.hibernate.mapping.StRmVendorMaster;
import com.stpl.pms.javabeans.BoVendorGameBean;
import com.stpl.pms.javabeans.GameLobbyMasterBean;
import com.stpl.pms.javabeans.GameLobbyResponseBean;

@SuppressWarnings("unchecked")
public class GameLobbyDaoImpl {

	// public StPortalLobbyMaster getLobbyDetail(String lobbyCode, Session
	// session) {
	// Criteria criteria = session.createCriteria(StPortalLobbyMaster.class);
	// criteria.add(Restrictions.eq("lobbyCode", lobbyCode));
	// return (StPortalLobbyMaster) criteria.list().get(0);
	// }

	public ArrayList<StPortalGameLobbyMapping> getGameLobby(Session session) {
		Criteria criteria = session
				.createCriteria(StPortalGameLobbyMapping.class);
		criteria.add(Restrictions.eq("status", "ACTIVE"));
		return (ArrayList<StPortalGameLobbyMapping>) criteria.list();
	}

	public ArrayList<StPortalGameDomainRoleMapping> getDomainRoleGame(
			Session session, int domainId, int roleId) {
		Criteria criteria = session
				.createCriteria(StPortalGameDomainRoleMapping.class);
		criteria.add(Restrictions.eq("domainId", domainId));
		criteria.add(Restrictions.eq("roleId", roleId));
		return (ArrayList<StPortalGameDomainRoleMapping>) criteria.list();
	}

	public List<StRmServiceVendorProperties> getVendorGameListUrl(
			Session session, Short vendorId) {
		Criteria criteria = session
				.createCriteria(StRmServiceVendorProperties.class);
		criteria.createAlias("stRmVendorMaster", "vm");
		criteria.add(Restrictions.eq("vm.vendorId", vendorId));
		criteria.add(Restrictions.eq("propertyKey", "game_list_url"))
		.setCacheable(true);
		return (List<StRmServiceVendorProperties>) criteria.list();
	}

	public Map<Short, String> getVendorIdAndName(Session session) {
		Map<Short, String> vendorMap = new HashMap<Short, String>();
		Criteria criteria = session.createCriteria(StRmVendorMaster.class);
		criteria.createAlias("stRmServiceVendorProperties", "vm");
		criteria.add(Restrictions.eq("vm.propertyKey", "game_list_url"));
		criteria.add(Restrictions.eq("vm.tier", "BO"));
		ProjectionList pro = Projections.projectionList();
		pro.add(Projections.property("vendorId"));
		pro.add(Projections.property("vendorName"));
		criteria.setProjection(pro);
		List<Object[]> list = criteria.list();
		if (list.size() != 0) {
			for (Object[] obj : list) {
				vendorMap.put((Short) obj[0], obj[1] + "");
			}
		}
		return vendorMap;
	}

	public void storeGameLobbbyList(Session session,
			GameLobbyMasterBean gameLobbyMasterBean, short vendorId,
			String defaultType, Set<Short> domainIdList) throws PMSException {
		List<GameLobbyResponseBean> gameLobbyResponseBean = gameLobbyMasterBean
				.getGameLobbyResponseBean();

		Iterator<GameLobbyResponseBean> it = gameLobbyResponseBean.iterator();
		while (it.hasNext()) {
			GameLobbyResponseBean list = it.next();

			Criteria criteria = null;
			criteria = session.createCriteria(StPortalGamesMaster.class);
			criteria.add(Restrictions.eq("gameNumber", list.getGameNumber()));
			criteria.add(Restrictions.eq("vendorId", vendorId));
			criteria.add(Restrictions.eq("gameGroupType", defaultType));
			List<StPortalGamesMaster> list1 = criteria.list();
			if (list1.size() == 1) {
				StPortalGamesMaster gameMaster = (StPortalGamesMaster) list1
						.get(0);
				updateGamesMaster(gameMaster, list, session);
			} else {
				addGamesMaster(list, vendorId, session, defaultType,
						domainIdList);
			}
		}
	}

	/* Games Section game update */
	public void updateGamesMaster(StPortalGamesMaster gameMaster,
			GameLobbyResponseBean list, Session session) {
		try {
			gameMaster.setGameNumber(list.getGameNumber());
			gameMaster.setGameName(list.getGameName());
			gameMaster.setGameImagePath(list.getGameImageLocations());
			gameMaster.setGamePrice(list.getGamePrice());
			gameMaster.setGameType(list.getGameCategory());
			gameMaster.setGameDesc(list.getGameDescription());
			gameMaster.setWindowHeight(list.getWindowHeight());
			gameMaster.setWindowWidth(list.getWindowWidth());
			gameMaster.setIsFlash(list.getIsFlash());
			gameMaster.setIsHtml5(list.getIsHtml5());
			session.saveOrUpdate(gameMaster);
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	/* Add Games section */
	public void addGamesMaster(GameLobbyResponseBean list, short vendorId,
			Session session, String defaultType, Set<Short> domainIdList) {
		StPortalGamesMaster addGame = null;
		// String criteriaXml = XmlUtil.writer("GameExtraParamterXml",
		// list.getIgeVendorGameBean(),
		// IgeVendorGameBean.class,
		// IgeVendorGameBean.class.getPackage());

		try {
			addGame = new StPortalGamesMaster(vendorId, list, defaultType,
					"ACTIVE");
			session.save(addGame);
			session.flush();
			for (Short domainId : domainIdList) {
				Criteria cri = session
						.createCriteria(StPortalGameDomainRoleMapping.class);
				cri.add(Restrictions.eq("domainId", domainId));
				if (cri.list().size() != 0) {
					StPortalGameDomainRoleMapping stPortalGameDomainRoleMapping = new StPortalGameDomainRoleMapping(
							domainId, 1001, "INACTIVE", addGame.getGameGroupType(), addGame);
					session.save(stPortalGameDomainRoleMapping);
					session.flush();
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public Map<String, List<BoVendorGameBean>> getGameListVendorWise(Session session, short domainId) {
		Map<String, List<BoVendorGameBean>> gameMap = new HashMap<String, List<BoVendorGameBean>>();
		List<BoVendorGameBean> boVendorGameBean = null;
		boVendorGameBean = new ArrayList<BoVendorGameBean>();
		Criteria criteria = session.createCriteria(StRmVendorMaster.class);
		ProjectionList pro = Projections.projectionList();
		pro.add(Projections.property("vendorId"));
		pro.add(Projections.property("vendorName"));
		criteria.setProjection(pro);
		List<Object[]> vendorList = criteria.list();
		if (vendorList.size() != 0) {
			for (Object[] obj : vendorList) {
				Criteria cri = session
						.createCriteria(StPortalGamesMaster.class);
				cri.add(Restrictions.eq("vendorId", (Short) obj[0]));
				List<StPortalGamesMaster> list = cri.list();
				if (list.size() != 0) {
					boVendorGameBean = new ArrayList<BoVendorGameBean>();
					for (StPortalGamesMaster gameMaster : list) {
						StPortalGameDomainRoleMapping stPortalGameDomainRoleMapping = new StPortalGameDomainRoleMapping(
								domainId, 1001, "INACTIVE", gameMaster
										.getGameGroupType(), gameMaster);
						session.save(stPortalGameDomainRoleMapping);
						session.flush();
						BoVendorGameBean vendorGamebean = new BoVendorGameBean(
								gameMaster.getGameId(), gameMaster
										.getGameName(), gameMaster
										.getGameNumber(), gameMaster
										.getGameType(), gameMaster
										.getGamePrice(), gameMaster
										.getVendorId(), (String) obj[1],
								gameMaster.getGameGroupType(), "INACTIVE");
						boVendorGameBean.add(vendorGamebean);
					}
					gameMap.put((String) obj[1], boVendorGameBean);
				}
			}
		}
		System.out.println(gameMap);
		return gameMap;
	}

	public Map<String, List<BoVendorGameBean>> domainGameAlready(
			Session session, short domainId, String gameGroupType) {
		Criteria cri = session
				.createCriteria(StPortalGameDomainRoleMapping.class);
		cri.add(Restrictions.eq("domainId", domainId));
		cri.add(Restrictions.eq("gameGroupType", gameGroupType));
		List<StPortalGameDomainRoleMapping> list = cri.list();
		Map<String, List<BoVendorGameBean>> gameMap = null;
		List<BoVendorGameBean> boVendorGameBean = null;
		if (list.size() != 0) {
			String vendorName = null;
			Map<Short, String> vendorMap = new HashMap<Short, String>();
			Criteria criteria = session.createCriteria(StRmVendorMaster.class);
			ProjectionList pro = Projections.projectionList();
			pro.add(Projections.property("vendorId"));
			pro.add(Projections.property("vendorName"));
			criteria.setProjection(pro);
			List<Object[]> vendorList = criteria.list();
			if (vendorList.size() != 0) {
				for (Object[] obj : vendorList) {
					vendorMap.put((Short) obj[0], (String) obj[1]);
				}
			}
			gameMap = new HashMap<String, List<BoVendorGameBean>>();

			for (StPortalGameDomainRoleMapping gameMaster : list) {
				vendorName = vendorMap.get(gameMaster.getStPortalGamesMaster()
						.getVendorId());
				boVendorGameBean = gameMap.get(vendorName);
				if (boVendorGameBean == null) {
					boVendorGameBean = new ArrayList<BoVendorGameBean>();
				}
				BoVendorGameBean vendorGamebean = new BoVendorGameBean(
						gameMaster.getStPortalGamesMaster().getGameId(),
						gameMaster.getStPortalGamesMaster().getGameName(),
						gameMaster.getStPortalGamesMaster().getGameNumber(),
						gameMaster.getStPortalGamesMaster().getGameType(),
						gameMaster.getStPortalGamesMaster().getGamePrice(),
						gameMaster.getStPortalGamesMaster().getVendorId(),
						vendorName, gameMaster.getStPortalGamesMaster()
								.getGameGroupType(), gameMaster.getStatus());
				boVendorGameBean.add(vendorGamebean);
				gameMap.put(vendorName, boVendorGameBean);
			}
		}
		return gameMap;
	}

	public void saveDomainGame(Session session, String[] selectDomainGame,
			short domainId) {
		Query query = session
				.createQuery("update StPortalGameDomainRoleMapping set status=? where domainId=? ");
		query.setParameter(0, "INACTIVE");
		query.setParameter(1, domainId);
		query.executeUpdate();
		query = session
				.createQuery("update StPortalGameLobbyMapping set status=? where domainId=? ");
		query.setParameter(0, "INACTIVE");
		query.setParameter(1, domainId);
		query.executeUpdate();

		String gameId = Arrays.toString(selectDomainGame).toString().replace(
				"[", "").replace("]", "");
		query = session
				.createQuery("update StPortalGameDomainRoleMapping set status=? where domainId=? and stPortalGamesMaster.gameId in("
						+ gameId + ") ");
		query.setParameter(0, "ACTIVE");
		query.setParameter(1, domainId);
		query.executeUpdate();
		query = session
				.createQuery("update StPortalGameLobbyMapping set status=? where domainId=? and stPortalGamesMaster.gameId in("
						+ gameId + ") ");
		query.setParameter(0, "ACTIVE");
		query.setParameter(1, domainId);
		query.executeUpdate();
	}

	public Map<String, List<BoVendorGameBean>> getGameThemeAndList(
			Session session, short domainId, String gameGroupType) {
			Map<String, List<BoVendorGameBean>> gameThemeMap = null;
				Criteria cri = session.createCriteria(StPortalGameDomainRoleMapping.class);
				cri.add(Restrictions.eq("domainId", domainId));
				cri.createAlias("stPortalGamesMaster", "gm");
				cri.add(Restrictions.eq("gm.gameGroupType", gameGroupType));
				cri.add(Restrictions.eq("status", "ACTIVE"));
				List<StPortalGameDomainRoleMapping> gameList = cri.list();
					cri = session.createCriteria(StPortalGameLobbyMapping.class);
					cri.add(Restrictions.eq("domainId", domainId));
					cri.createAlias("stPortalGamesMaster", "gm");
					cri.createAlias("stPortalGameThemeMaster", "themeMaster");
					cri.add(Restrictions.eq("gm.gameGroupType", gameGroupType));
					cri.add(Restrictions.eq("status", "ACTIVE"));
					cri.addOrder(Order.asc("themeMaster.showOrder"));
					cri.addOrder(Order.asc("showOrder"));
					List<StPortalGameLobbyMapping> gameLobby = cri.list();
						if(gameLobby.size() != 0){
							cri = session.createCriteria(StPortalGameThemeMaster.class);
							cri.add(Restrictions.eq("status", "ACTIVE"));
							cri.addOrder(Order.asc("showOrder"));
							List<StPortalGameThemeMaster> gameThemeMaster = cri.list();
							Map<Integer, String> themeMap = new LinkedHashMap<Integer, String>();
								if (gameThemeMaster.size() != 0) {
									for (StPortalGameThemeMaster map : gameThemeMaster) {
										themeMap.put(map.getThemeId(), map.getThemeName());
									}
								}
							Map<Integer, List<BoVendorGameBean>> gameLobbyMap = new LinkedHashMap<Integer, List<BoVendorGameBean>>();
							List<BoVendorGameBean> gameLobbyList = null;
						
							for (StPortalGameLobbyMapping st : gameLobby) {
								BoVendorGameBean game = new BoVendorGameBean(st
									.getStPortalGamesMaster().getGameId(), WordUtils
									.capitalize(st.getStPortalGamesMaster()
											.getGameName()), st
									.getStPortalGamesMaster().getGameNumber(), st
									.getStPortalGamesMaster().getGameType(), st
									.getStPortalGamesMaster().getGamePrice(), st
									.getStPortalGamesMaster().getGameGroupType(), st
									.getStPortalGameThemeMaster().getThemeName(), st
									.getStPortalGameThemeMaster().getThemeId(), st
									.getStatus(), st.getShowOrder());

								gameLobbyList = gameLobbyMap.get(st.getStPortalGameThemeMaster().getThemeId());
									if (gameLobbyList == null) {
										gameLobbyList = new LinkedList<BoVendorGameBean>();
									}
								gameLobbyList.add(game);
								gameLobbyMap.put(st.getStPortalGameThemeMaster().getThemeId(), gameLobbyList);
							 }
						gameThemeMap = new LinkedHashMap<String, List<BoVendorGameBean>>();
						for(StPortalGameThemeMaster themeMaster : gameThemeMaster){
							gameLobbyList = gameLobbyMap.get(themeMaster.getThemeId());
							if(gameLobbyList==null){
									gameLobbyList = new LinkedList<BoVendorGameBean>();
									for(StPortalGameDomainRoleMapping gameRoleMapping : gameList){
											BoVendorGameBean game = new BoVendorGameBean(gameRoleMapping
													.getStPortalGamesMaster().getGameId(), WordUtils
													.capitalize(gameRoleMapping.getStPortalGamesMaster()
															.getGameName()), gameRoleMapping
													.getStPortalGamesMaster().getGameNumber(), gameRoleMapping
													.getStPortalGamesMaster().getGameType(), gameRoleMapping
													.getStPortalGamesMaster().getGamePrice(), gameRoleMapping
													.getStPortalGamesMaster().getGameGroupType(), themeMaster.getThemeName(), 
													themeMaster.getThemeId(), "INACTIVE", themeMaster.getShowOrder());
											gameLobbyList.add(game);	
									}
							}else{
								 Iterator iterator = gameList.iterator();
								 StPortalGameDomainRoleMapping roleMappingBean = null;
								 while(iterator.hasNext()){
									 roleMappingBean =(StPortalGameDomainRoleMapping)iterator.next();
									 if(!gameLobbyList.contains(roleMappingBean)){
										 BoVendorGameBean game = new BoVendorGameBean(roleMappingBean
													.getStPortalGamesMaster().getGameId(), WordUtils
													.capitalize(roleMappingBean.getStPortalGamesMaster()
															.getGameName()), roleMappingBean
													.getStPortalGamesMaster().getGameNumber(), roleMappingBean
													.getStPortalGamesMaster().getGameType(), roleMappingBean
													.getStPortalGamesMaster().getGamePrice(), roleMappingBean
													.getStPortalGamesMaster().getGameGroupType(), themeMaster.getThemeName(), 
													themeMaster.getThemeId(), "INACTIVE", themeMaster.getShowOrder());
											gameLobbyList.add(game);	
									 }
								 }
								
							}	
						gameThemeMap.put(themeMaster.getThemeName(), gameLobbyList);
					}
				} else {
					Query query = session.createQuery("select new "
							+ BoVendorGameBean.class.getName()
							+ " (stPortalGamesMaster.gameId, "
							+ "stPortalGamesMaster.gameName,"
							+ "stPortalGamesMaster.gameType,"
							+ "stPortalGamesMaster.gameGroupType,"
							+ "stPortalGamesMaster.vendorId,"
							+ "status) from StPortalGameDomainRoleMapping as gDRM where gDRM.domainId=? and gDRM.stPortalGamesMaster.gameGroupType=? and gDRM.status=?");
					query.setParameter(0, domainId);
					query.setParameter(1, gameGroupType);
					query.setParameter(2, "ACTIVE");
					List<BoVendorGameBean> vendorGameList = query.list();
					if (gameList.size() != 0) {
						gameThemeMap = new LinkedHashMap<String, List<BoVendorGameBean>>();
						cri = session.createCriteria(StPortalGameThemeMaster.class);
						cri.add(Restrictions.eq("status", "ACTIVE"));
						cri.addOrder(Order.asc("showOrder"));
						List<StPortalGameThemeMaster> gameThemeMaster = cri.list();
						for (StPortalGameThemeMaster theme : gameThemeMaster) {
							List<BoVendorGameBean> afterThemeAdd = new LinkedList<BoVendorGameBean>();
							for (BoVendorGameBean gameBean : vendorGameList) {
								BoVendorGameBean newBean1 = null;
								try {
									newBean1 = (BoVendorGameBean) gameBean.clone();
								} catch (CloneNotSupportedException e) {
									e.printStackTrace();
								}
								newBean1.setStatus("INACTIVE");
								newBean1.setThemeId(theme.getThemeId());
								newBean1.setThemeName(theme.getThemeName());
								afterThemeAdd.add(newBean1);
							}
							BeanComparator beanSort = new BeanComparator("gameName");
							Collections.sort(afterThemeAdd, beanSort);
							gameThemeMap.put(theme.getThemeName(), afterThemeAdd);
						}
					}
				}
			return gameThemeMap;
	}

	public String addDomainThemeGame(
			LinkedHashMap<String, List<BoVendorGameBean>> finalDomainGameMap,
			short domainId, int lobbyId, Session session) {
				Query query = null;
				query = session.createQuery("update StPortalGameLobbyMapping set status='INACTIVE' where domainId=? and lobbyId=?");
				query.setParameter(0, domainId);
				query.setParameter(1, lobbyId);
				query.executeUpdate();
				Set<String> themeId = finalDomainGameMap.keySet();
				Criteria cri = session.createCriteria(StPortalGameThemeMaster.class);
				cri.add(Restrictions.eq("status", "ACTIVE"));
				List<StPortalGameThemeMaster> gameThemeMaster = cri.list();
				Map<Integer, String> themeMap = new HashMap<Integer, String>();
				for (StPortalGameThemeMaster map : gameThemeMaster) {
					themeMap.put(map.getThemeId(), map.getThemeName());
				}
		
				for (String tId : themeId) {
					List<BoVendorGameBean> boVendorGameBeaneList = finalDomainGameMap
							.get(tId);
					Criteria criteria = session
							.createCriteria(StPortalGameLobbyMapping.class);
					criteria.createAlias("stPortalGamesMaster", "gID");
					criteria.createAlias("stPortalGameThemeMaster", "theme");
					criteria.setProjection(Projections.projectionList().add(
							Projections.property("gID.gameId"), "gameId"));
					criteria
							.add(Restrictions.eq("theme.themeId",Integer.parseInt(tId)));
					criteria.add(Restrictions.eq("lobbyId", lobbyId));
					criteria.add(Restrictions.eq("domainId", domainId));
					List<Integer> gameIdList = criteria.list();
		
					for (BoVendorGameBean bean : boVendorGameBeaneList) {
						if (gameIdList.contains(bean.getGameId())) {
							query = session
									.createQuery("update StPortalGameLobbyMapping  set showOrder="
											+ bean.getShowOrder()
											+ " , status='ACTIVE' where stPortalGameThemeMaster.themeId=? and domainId=? and lobbyId=? and stPortalGamesMaster.gameId=?");
							query.setParameter(0, Integer.valueOf(tId));
							query.setParameter(1, domainId);
							query.setParameter(2, lobbyId);
							query.setParameter(3, bean.getGameId());
							query.executeUpdate();
						} else {
							StPortalGameLobbyMapping stPortalGameLobbyMapping = new StPortalGameLobbyMapping();
							StPortalGameThemeMaster stPortalGameThemeMaster = new StPortalGameThemeMaster();
							stPortalGameLobbyMapping.setDomainId(domainId);
							stPortalGameLobbyMapping
									.setStPortalGamesMaster(new StPortalGamesMaster(
											bean.getGameId()));
							stPortalGameLobbyMapping.setLobbyId(lobbyId);
							stPortalGameLobbyMapping.setShowOrder(bean.getShowOrder());
							stPortalGameThemeMaster.setThemeId(bean.getThemeId());
							stPortalGameLobbyMapping
									.setStPortalGameThemeMaster(stPortalGameThemeMaster);
							stPortalGameLobbyMapping.setStatus("ACTIVE");
							session.save(stPortalGameLobbyMapping);
							session.flush();
						}
					}
				}
			return "success";
	}

	public List<StPortalLobbyMaster> getGameLobbyDetail(Session session) {
		Criteria cri = session.createCriteria(StPortalLobbyMaster.class);
		List<StPortalLobbyMaster> list = cri.list();
		return list;
	}

	public int addThemeName(String themeName, int themeId, Session session)
			throws PMSException {
		themeId = themeId++;
		try {
			StPortalGameThemeMaster stPortalGameThemeMaster = new StPortalGameThemeMaster();
			stPortalGameThemeMaster.setStatus("ACTIVE");
			stPortalGameThemeMaster.setThemeName(themeName.toUpperCase());
			stPortalGameThemeMaster.setShowOrder(themeId);
			themeId = (Integer) session.save(stPortalGameThemeMaster);
			session.flush();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return themeId;
	}

	public Map<Integer, String> fetchThemeMap(Session session) {
		Map<Integer, String> themeMap = new HashMap<Integer, String>();
		try {
			Criteria cri = session
					.createCriteria(StPortalGameThemeMaster.class);
			cri.add(Restrictions.eq("status", "ACTIVE"));
			List<StPortalGameThemeMaster> gameThemeMaster = cri.list();
			for (StPortalGameThemeMaster map : gameThemeMaster) {
				themeMap.put(map.getThemeId(), map.getThemeName());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return themeMap;
	}

	public String addThemeOrder(List<BoVendorGameBean> beanList, Session session) {
		try {
			session.clear();
			
			for (BoVendorGameBean themeBean : beanList) {
				StPortalGameThemeMaster stPortalGameThemeMaster = new StPortalGameThemeMaster();
				stPortalGameThemeMaster.setShowOrder(themeBean.getShowOrder());
				stPortalGameThemeMaster.setThemeId(themeBean.getThemeId());
				stPortalGameThemeMaster.setThemeName(themeBean.getThemeName());
				stPortalGameThemeMaster.setStatus("ACTIVE");
				session.update(stPortalGameThemeMaster);
			}
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			return "exception_nodecorate";
		}
		return "success";
	}

	public String removeSelectGame(Session session) {
		try{
		Query query = null;
		query = session
				.createSQLQuery("truncate table  st_portal_game_lobby_mapping");
		query.executeUpdate();
		session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			return "exception_nodecorate";
		}
		return "success";
		}

}
