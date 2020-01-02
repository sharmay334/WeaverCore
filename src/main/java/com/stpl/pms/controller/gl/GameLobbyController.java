package com.stpl.pms.controller.gl;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.constants.ServerStatusBean;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.daoImpl.gl.GameLobbyDaoImpl;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.CreateCompany;
import com.stpl.pms.hibernate.mapping.Itgs;
import com.stpl.pms.hibernate.mapping.StPortalLobbyMaster;
import com.stpl.pms.hibernate.mapping.StRmBoAllowedIp;
import com.stpl.pms.hibernate.mapping.StRmBoUserMaster;
import com.stpl.pms.hibernate.mapping.StRmGameUserMapping;
import com.stpl.pms.hibernate.mapping.StRmServiceVendorProperties;
import com.stpl.pms.javabeans.BoVendorGameBean;
import com.stpl.pms.javabeans.GameLobbyMasterBean;
import com.stpl.pms.struts.common.GetGameListHelper;
import com.stpl.pms.utility.AES;

public class GameLobbyController {

	public void getGameLobbyList(String domainName, Short vendorId) throws PMSException {
		Session session = null;
		GameLobbyDaoImpl daoImpl = new GameLobbyDaoImpl();
		Transaction tx = null;

		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			List<StRmServiceVendorProperties> list = daoImpl.getVendorGameListUrl(session, vendorId);
			if (list.size() != 0) {
				Set<Short> domainIdList = (Set<Short>) CommonMethodDaoImpl.getInstance().getDomainIdMap(session)
						.keySet();
				for (StRmServiceVendorProperties stRmServiceVendorProperties : list) {
					GameLobbyMasterBean gameLobbyMasterBean = GetGameListHelper.getGameList(stRmServiceVendorProperties,
							domainName);
					daoImpl.storeGameLobbbyList(session, gameLobbyMasterBean,
							stRmServiceVendorProperties.getStRmVendorMaster().getVendorId(),
							stRmServiceVendorProperties.getStRmVendorMaster().getDefaultGameGroup(), domainIdList);
				}
				tx.commit();
			} else {
				throw new PMSException("Game List is Null");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("hibernate Exception");
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Some Internal Error");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	public Boolean addNewCompany(CreateCompany company) {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(company);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		return true;
	}

	public List<Object[]> getGameSearchData(int gameNO, String userName, String gameName, Double ticket_Price) {

		try {
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.eq("game_No", gameNO));
			// criteria.add(Restrictions.eq("userName", userName));
			criteria.add(Restrictions.eq("game_Name", gameName));
			criteria.add(Restrictions.eq("price", ticket_Price));

			List<Object[]> result = criteria.list();

			if (!result.isEmpty()) {
				return result;
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@SuppressWarnings("unchecked")
	public Map<String, String> generateTestFiles(int gameNo, int batchNo) {
		// TODO Auto-generated method stub
		try {
			Map<String, String> ticketData = new LinkedHashMap<String, String>();
			Session session = HibernateSessionFactory.getSession();
			String query = "SELECT ticket_nbr,prize_amount FROM ig_ticket_archive_" + gameNo + "_batchNo_" + batchNo;
			Query query2 = session.createSQLQuery(query);
			List<Object[]> result = query2.list();
			if (result != null) {
				for (Object[] obj : result) {
					ticketData.put(obj[0].toString(), obj[1].toString());
				} // AES.decrypt(obj[1].toString(), AES.KEY + obj[0].toString())
				return ticketData;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Short, String> getVendorIdAndName() throws PMSException {
		Session session = null;
		GameLobbyDaoImpl daoImpl = new GameLobbyDaoImpl();
		Map<Short, String> map = null;
		try {
			session = HibernateSessionFactory.getSession();
			map = daoImpl.getVendorIdAndName(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("hibernate Exception");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException("Some Internal Error");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return map;
	}

	public Map<String, List<BoVendorGameBean>> getGameListVendorWise(short domainId, String gameGroupType)
			throws PMSException {
		Session session = null;
		GameLobbyDaoImpl daoImpl = new GameLobbyDaoImpl();
		Map<String, List<BoVendorGameBean>> vendorGameMap = null;
		try {
			session = HibernateSessionFactory.getSession();
			vendorGameMap = daoImpl.domainGameAlready(session, domainId, gameGroupType);
			if (vendorGameMap == null) {
				vendorGameMap = daoImpl.getGameListVendorWise(session, domainId);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException("Some Internal Error");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return vendorGameMap;
	}

	public String saveDomainGame(String[] selectDomainGame, short domainId) throws PMSException {
		Session session = null;
		GameLobbyDaoImpl daoImpl = new GameLobbyDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			daoImpl.saveDomainGame(session, selectDomainGame, domainId);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException("Some Internal Error");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return "success";
	}

	public Map<String, List<BoVendorGameBean>> getGameThemeAndList(short domainId, String gameGroupType)
			throws PMSException {
		Session session = null;
		GameLobbyDaoImpl daoImpl = new GameLobbyDaoImpl();
		Map<String, List<BoVendorGameBean>> gameThemeMap = null;
		try {
			session = HibernateSessionFactory.getSession();
			gameThemeMap = daoImpl.getGameThemeAndList(session, domainId, gameGroupType);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException("Some Internal Error");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return gameThemeMap;
	}

	public String addDomainThemeGame(LinkedHashMap<String, List<BoVendorGameBean>> finalDomainGameMap, short domainId,
			int lobbyId) throws PMSException {
		Session session = null;
		GameLobbyDaoImpl daoImpl = new GameLobbyDaoImpl();
		String result = null;
		try {
			session = HibernateSessionFactory.getSession();
			result = daoImpl.addDomainThemeGame(finalDomainGameMap, domainId, lobbyId, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException("Some Internal Error");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return result;
	}

	public List<StPortalLobbyMaster> getGameLobbyDetail() throws PMSException {
		Session session = null;
		GameLobbyDaoImpl daoImpl = new GameLobbyDaoImpl();
		List<StPortalLobbyMaster> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			list = daoImpl.getGameLobbyDetail(session);
			if (list.size() == 0) {
				throw new PMSException("Game Lobby are Not found");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException("Some Internal Error");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}

	public int addThemeName(String themeName, Integer themeId) throws PMSException {
		Session session = null;
		GameLobbyDaoImpl daoImpl = new GameLobbyDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();
			themeId = daoImpl.addThemeName(themeName, themeId, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception ex) {
			throw new PMSException("Some Internal Error");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return themeId;
	}

	public Map<Integer, String> fetchThemeMap() throws PMSException {
		Session session = null;
		GameLobbyDaoImpl daoImpl = new GameLobbyDaoImpl();
		Map<Integer, String> themeMap = new HashMap<Integer, String>();
		try {
			session = HibernateSessionFactory.getSession();
			themeMap = daoImpl.fetchThemeMap(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception ex) {
			throw new PMSException("Some Internal Error");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return themeMap;
	}

	public String addThemeOrder(List<BoVendorGameBean> beanList) throws PMSException {
		Session session = null;
		GameLobbyDaoImpl daoImpl = new GameLobbyDaoImpl();
		String returnType = null;
		try {
			session = HibernateSessionFactory.getSession();
			returnType = daoImpl.addThemeOrder(beanList, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception ex) {
			throw new PMSException("Some Internal Error");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return returnType;
	}

	public String removeSelectGame() throws PMSException {
		Session session = null;
		GameLobbyDaoImpl daoImpl = new GameLobbyDaoImpl();
		String returnType = null;
		try {
			session = HibernateSessionFactory.getSession();
			returnType = daoImpl.removeSelectGame(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception ex) {
			throw new PMSException("Some Internal Error");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return returnType;
	}

	public String uploadNewGamesItgs(Map<String, FileInputStream> inputStream, String gameName, int gameNO,
			Double ticketPrize, int noOfTickets, int noOfTicketsPerBook, int noOfBooksPerPack, int virnDigits,
			int user_id, byte[] pdfile) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null; // transaction Management
		try {

			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();

			int starting_pack = 1;
			String is_append_game_no = "Yes";
			byte[] bytests = IOUtils.toByteArray(inputStream.get("ts"));
			byte[] bytesge = IOUtils.toByteArray(inputStream.get("ge"));
			byte[] bytespd = IOUtils.toByteArray(inputStream.get("pd"));
			byte[] bytespdc = IOUtils.toByteArray(inputStream.get("pdc"));
			byte[] bytesav = IOUtils.toByteArray(inputStream.get("av"));
			byte[] bytesls = IOUtils.toByteArray(inputStream.get("ls"));

			String ts = new String(bytests);
			String ge = new String(bytesge);
			String pd = new String(pdfile);
			String pdc = new String(bytespdc);
			String av = new String(bytesav);
			String ls = new String(bytesls);

			String selectQuery = "select MAX(batch_no) from itgs_input where game_no=" + gameNO;
			Query selectQuery1 = session.createSQLQuery(selectQuery);
			@SuppressWarnings("unchecked")
			List selectResult = selectQuery1.list();
			int batchNo = 0;
			if (!(selectResult.contains(null))) {
				for (Object obj : selectResult)
					batchNo = (int) obj;
			}

			int status = getPreviousBatch(session, gameNO, noOfTicketsPerBook, noOfBooksPerPack, noOfTickets,
					ticketPrize);
			boolean flag = false;

			if (status == -99) {
				starting_pack = 1;
				flag = true;
			} else if (status != -1) {
				starting_pack = status + noOfTickets / (noOfTicketsPerBook * noOfBooksPerPack);
				flag = true;

			} else {
				return "Error: Prize distribution doesn't match with the previously generated batch. Either change GAME NUMBER or choose the previously used PRIZE DISTRIBUTION.";
			}

			if (flag == true) {
				batchNo += 1;
				String insertquery = "Insert into itgs_input SET game_no=" + gameNO + ",game_name='" + gameName + "'"
						+ ",price=" + ticketPrize + ",xml_type='Printed',no_of_tickets=" + noOfTickets
						+ ",no_of_tickets_per_book=" + noOfTicketsPerBook + ",no_of_books_per_pack=" + noOfBooksPerPack
						+ ",starting_pack=" + starting_pack + ",batch_no=" + batchNo + ",status='Initiated'";

				String insertquery2 = "update itgs_input SET ticket_str_xml='" + ts + "',game_exp_xml='" + ge
						+ "',pd_xml='" + pd + "',pdc_xml='" + pdc + "',agtvc_xml='" + av + "',location_xml='" + ls
						+ "',is_append_game_no='" + is_append_game_no + "',virn_digits=" + virnDigits
						+ " where game_no=" + gameNO + " and batch_no=" + batchNo;
				String insertquery1 = "insert into st_rm_game_user_mapping SET batch_no=" + batchNo + ",user_id="
						+ user_id + ",game_no=" + gameNO + ",status='Initiated',save_mode='submit'";

				if (ServerStatusBean.SERVER_TYPE.equals("P")) {
					byte[] front_img = IOUtils.toByteArray(inputStream.get("frontImg"));
					byte[] back_img = IOUtils.toByteArray(inputStream.get("backImg"));
					byte[] scratched_img = IOUtils.toByteArray(inputStream.get("scratchedImg"));
					String insertQueryTicketImg = "update itgs_input SET front_img=?,back_img=?,scratched_img=? where game_no="
							+ gameNO + " and batch_no=" + batchNo;
					Query query3 = session.createSQLQuery(insertQueryTicketImg);
					query3.setBinary(0, front_img);
					query3.setBinary(1, back_img);
					query3.setBinary(2, scratched_img);
					Query query = session.createSQLQuery(insertquery);
					Query query1 = session.createSQLQuery(insertquery2);
					Query query2 = session.createSQLQuery(insertquery1);

					query.executeUpdate();
					query1.executeUpdate();
					query2.executeUpdate();
					query3.executeUpdate();

				} else {
					Query query = session.createSQLQuery(insertquery);
					Query query1 = session.createSQLQuery(insertquery2);
					Query query2 = session.createSQLQuery(insertquery1);

					query.executeUpdate();
					query1.executeUpdate();
					query2.executeUpdate();
				}

				tx.commit();
				return "success" + batchNo;
			} else {
				return "error";
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		}
		return "error";
	}

	private int getPreviousBatch(Session session, int gameNO, int noOfTicketsPerBook, int noOfBooksPerPack,
			int noOfTickets, Double ticketPrize) {
		// TODO Auto-generated method stub
		try {

			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.eq("game_No", gameNO));
			List<Itgs> result = criteria.list();
			if (!result.isEmpty()) {
				Criteria criteria1 = session.createCriteria(Itgs.class);
				criteria1.add(Restrictions.eq("game_No", gameNO));
				criteria1.add(Restrictions.eq("no_Of_Tickets_Per_Book", noOfTicketsPerBook));
				criteria1.add(Restrictions.eq("no_Of_Books_Per_Pack", noOfBooksPerPack));
				criteria1.add(Restrictions.eq("no_Of_Tickets", noOfTickets));
				criteria1.add(Restrictions.eq("price", ticketPrize));
				List<Itgs> reItgs = criteria1.list();
				if (!reItgs.isEmpty()) {
					// ned to chk pz amts+
					return reItgs.get(reItgs.size() - 1).getStarting_Pack();

				}
			} else {
				return -99;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}

	public String uploadNewGamesItgs(String gameName, int gameNO, Double ticketPrize, int noOfTickets,
			int noOfTicketsPerBook, int noOfBooksPerPack, int virnDigits, int user_id) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null; // transaction Management
		try {

			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.eq("game_No", gameNO));
			List<Object[]> result = criteria.list();

			if (!result.isEmpty()) {
				return "Game No=" + gameNO + " Already Exist";
			} else {
				int starting_pack = 1;
				String is_append_game_no = "Yes";

				String insertquery = "Insert into itgs_input SET game_no=" + gameNO + ",game_name='" + gameName + "'"
						+ ",price=" + ticketPrize + ",xml_type='Printed',no_of_tickets=" + noOfTickets
						+ ",no_of_tickets_per_book=" + noOfTicketsPerBook + ",no_of_books_per_pack=" + noOfBooksPerPack
						+ ",starting_pack=" + starting_pack + ",virn_digits=" + virnDigits + ",status='Initiated'";

				String insertquery1 = "insert into st_rm_game_user_mapping SET user_id=" + user_id + ",game_no="
						+ gameNO + ",status='Initiated',save_mode='draft'";

				Query query = session.createSQLQuery(insertquery);
				Query query2 = session.createSQLQuery(insertquery1);
				query.executeUpdate();
				query2.executeUpdate();
				tx.commit();
				return "success";

			}

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		}
		return null;
	}

	public List<Integer> getGameList() {
		Session session = null;
		List<Integer> userList = new ArrayList<Integer>();
		try {

			session = HibernateSessionFactory.getSession();
			/*
			 * Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
			 * 
			 * criteria.add(Restrictions.eq("parentUserId", userId));
			 */
			String insertquery = "select user_id from st_rm_bo_user_master";
			Query query = session.createSQLQuery(insertquery);
			List<Integer> result = query.list();
			if (!result.isEmpty()) {
				for (Integer obj : result) {

					// System.out.println(":::::::::::::"+obj.getUserId());
					userList.add((Integer) obj);
				}
				return userList;
			}

			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Integer> getGameList(int userId) {
		Session session = null;
		List<Integer> userList = new ArrayList<Integer>();
		try {

			session = HibernateSessionFactory.getSession();
			/*
			 * Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
			 * 
			 * criteria.add(Restrictions.eq("parentUserId", userId));
			 */
			String insertquery = "select user_id from st_rm_bo_user_master where parent_user_id=" + userId;
			Query query = session.createSQLQuery(insertquery);
			List<Integer> result = query.list();
			if (!result.isEmpty()) {
				for (Integer obj : result) {

					// System.out.println(":::::::::::::"+obj.getUserId());
					userList.add((Integer) obj);
				}
				return userList;
			}

			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Integer> getGameNoList(List<Integer> getGameNoList) {
		Session session = null;
		List<Integer> userList = new ArrayList<Integer>();
		try {

			session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmGameUserMapping.class);
			criteria.add(Restrictions.in("user_id", getGameNoList));
			List<StRmGameUserMapping> result = criteria.list();
			if (!result.isEmpty()) {
				for (StRmGameUserMapping obj : result) {

					// System.out.println(":::::::::::::"+obj.getUserId());
					userList.add(obj.getGame_no());
				}
				return userList;
			}

			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Object[]> getGameSearchData(List<Integer> getGameNoList, List<Integer> batchNoList) {
		Session session = null;
		List<Object[]> userList = new ArrayList<Object[]>();
		try {

			session = HibernateSessionFactory.getSession();

			// Query query = session.createQuery("from Itgs where game_No in
			// (:gameNoList)");
			// query.setParameterList("gameNoList", getGameNoList);
			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.in("game_No", getGameNoList));
			criteria.add(Restrictions.in("batch_no", batchNoList));

			List<Object[]> result = criteria.list();
			if (!result.isEmpty()) {
				return result;
			}

			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Object[]> getGameSearchData(List<Integer> getGameNoList) {
		Session session = null;
		List<Object[]> userList = new ArrayList<Object[]>();
		try {

			session = HibernateSessionFactory.getSession();

			// Query query = session.createQuery("from Itgs where game_No in
			// (:gameNoList)");
			// query.setParameterList("gameNoList", getGameNoList);
			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.in("game_No", getGameNoList));

			List<Object[]> result = criteria.list();
			if (!result.isEmpty()) {
				return result;
			}

			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String deleteExistingGame(int gameNO, int batchNo, int user_id) {
		try {
			Session session = null;

			session = HibernateSessionFactory.getSession();

			Query query = session.createQuery("delete Itgs where game_No = :gameNo and batch_no = :batchNo");
			query.setParameter("gameNo", gameNO);
			query.setParameter("batchNo", batchNo);

			Query query1 = session.createQuery(
					"delete StRmGameUserMapping where game_no = :gameNo and user_id = :userId and batch_no = :batchNo");
			query1.setParameter("gameNo", gameNO);
			query1.setParameter("userId", user_id);
			query1.setParameter("batchNo", batchNo);
			int result = query.executeUpdate();

			if (result > 0) {
				int result1 = query1.executeUpdate();
				if (result1 > 0)
					return "deleted";

			} else {
				return "no data";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error occured";
	}

	public List<String> getDraftStatus(int user_id) {

		try {
			List<String> selectdata = new ArrayList<String>();
			Session session = null;
			session = HibernateSessionFactory.getSession();
			String queryString = "SELECT a.game_no,a.game_name FROM `itgs_input` a INNER JOIN `st_rm_game_user_mapping` b ON a.game_no = b.game_no AND b.save_mode='draft' AND b.user_id="
					+ user_id;
			Query query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			if (!result.isEmpty()) {
				for (Object[] obj : result) {
					selectdata.add(obj[0].toString());
				}
			}
			if (selectdata.isEmpty()) {
				selectdata.add("No Draft Data Available");
			}
			return selectdata;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Itgs> getDraftData(int gameNo, int userId) {
		// TODO Auto-generated method stub

		try {
			List<Itgs> getData = new ArrayList<Itgs>();
			Session session = null;
			session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.eq("game_No", gameNo));
			List<Itgs> result = criteria.list();
			if (!result.isEmpty()) {
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String uploadNewGamesItgs(Map<String, FileInputStream> inputStream, String gameName, int gameNO,
			Double ticketPrize, int noOfTickets, int noOfTicketsPerBook, int noOfBooksPerPack, int virnDigits,
			int userId, String string) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null; // transaction Management
		try {

			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();

			int starting_pack = 1;
			String is_append_game_no = "Yes";
			byte[] bytests = IOUtils.toByteArray(inputStream.get("ts"));
			byte[] bytesge = IOUtils.toByteArray(inputStream.get("ge"));
			byte[] bytespd = IOUtils.toByteArray(inputStream.get("pd"));
			byte[] bytespdc = IOUtils.toByteArray(inputStream.get("pdc"));
			byte[] bytesav = IOUtils.toByteArray(inputStream.get("av"));
			byte[] bytesls = IOUtils.toByteArray(inputStream.get("ls"));

			String ts = new String(bytests);
			String ge = new String(bytesge);
			String pd = new String(bytespd);
			String pdc = new String(bytespdc);
			String av = new String(bytesav);
			String ls = new String(bytesls);

			String insertquery = "update itgs_input SET game_no=" + gameNO + ",game_name='" + gameName + "'" + ",price="
					+ ticketPrize + ",xml_type='Printed',no_of_tickets=" + noOfTickets + ",no_of_tickets_per_book="
					+ noOfTicketsPerBook + ",no_of_books_per_pack=" + noOfBooksPerPack + ",starting_pack="
					+ starting_pack + ",status='Initiated',batch_no='1'" + " where game_no=" + gameNO + "";

			String insertquery2 = "update itgs_input SET ticket_str_xml='" + ts + "',game_exp_xml='" + ge + "',pd_xml='"
					+ pd + "',pdc_xml='" + pdc + "',agtvc_xml='" + av + "',location_xml='" + ls
					+ "',is_append_game_no='" + is_append_game_no + "',virn_digits=" + virnDigits + " where game_no="
					+ gameNO;

			String insertquery1 = "update st_rm_game_user_mapping SET user_id=" + userId + ",game_no=" + gameNO
					+ ",status='Initiated',save_mode='submit' where game_no=" + gameNO;

			Query query = session.createSQLQuery(insertquery);
			Query query1 = session.createSQLQuery(insertquery2);
			Query query2 = session.createSQLQuery(insertquery1);
			query.executeUpdate();
			query1.executeUpdate();
			query2.executeUpdate();
			tx.commit();
			return "success";

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		}
		return null;
	}

	public List<Integer> getGameStatus(int gameNo, String ticketStatus) {
		// TODO Auto-generated method stub
		try {
			List<Integer> batchNoData = new ArrayList<Integer>();
			Session session = null;
			session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.eq("game_No", gameNo));
			criteria.add(Restrictions.eq("status", ticketStatus));
			List<Itgs> result = criteria.list();
			if (!result.isEmpty()) {
				for (Itgs obj : result)
					batchNoData.add(obj.getBatch_no());
				return batchNoData;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Integer> getGameStatus(int gameNo, String ticketStatus, int userId) {
		// TODO Auto-generated method stub
		try {
			List<Integer> batchNoData = new ArrayList<Integer>();
			Session session = null;
			session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmGameUserMapping.class);
			criteria.add(Restrictions.eq("game_no", gameNo));
			criteria.add(Restrictions.eq("status", ticketStatus));
			criteria.add(Restrictions.eq("user_id", userId));

			List<StRmGameUserMapping> result = criteria.list();
			if (!result.isEmpty()) {
				for (StRmGameUserMapping obj : result)
					batchNoData.add(obj.getBatch_no());
				return batchNoData;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Integer> getGameStatus(int gameNo, int userId, String nouse) {
		// TODO Auto-generated method stub
		try {
			List<Integer> batchNoData = new ArrayList<Integer>();
			Session session = null;
			session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmGameUserMapping.class);
			criteria.add(Restrictions.eq("game_no", gameNo));
			criteria.add(Restrictions.eq("user_id", userId));
			List<StRmGameUserMapping> result = criteria.list();
			if (!result.isEmpty()) {
				for (StRmGameUserMapping obj : result)
					batchNoData.add(obj.getBatch_no());
				return batchNoData;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Integer> getGameStatus(int gameNo) {
		// TODO Auto-generated method stub
		try {
			List<Integer> batchNoData = new ArrayList<Integer>();
			Session session = null;
			session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.eq("game_No", gameNo));
			List<Itgs> result = criteria.list();
			if (!result.isEmpty()) {
				for (Itgs obj : result)
					batchNoData.add(obj.getBatch_no());
				return batchNoData;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void changeStatus(String string, int batchNo, int gameNo) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Query query = session.createSQLQuery("update itgs_input SET status='" + string + "' where batch_no="
					+ batchNo + " and game_no=" + gameNo);
			Query query2 = session.createSQLQuery("update st_rm_game_user_mapping SET status='" + string
					+ "' where batch_no=" + batchNo + " and game_no=" + gameNo);
			query.executeUpdate();
			query2.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public String assignSubUserNetworkAccess(String ipAddress, String status, Short domainId, long userId,
			Timestamp time, String userName) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			int selectedUserId = -1;
			Criteria criteria1 = session.createCriteria(StRmBoUserMaster.class);
			criteria1.add(Restrictions.eq("userName", userName));
			List<StRmBoUserMaster> userIdResult = criteria1.list();
			if (userIdResult != null) {

				for (StRmBoUserMaster obj : userIdResult) {
					selectedUserId = obj.getUserId();
				}
			}

			Criteria criteria = session.createCriteria(StRmBoAllowedIp.class);
			criteria.add(Restrictions.eq("allowedIp", ipAddress));
			criteria.add(Restrictions.eq("userId", selectedUserId));

			List<String> ipResult = criteria.list();

			if (ipResult.size() > 1) {
				return "error";
			} else if (ipResult.size() == 1) {
				Query query = session.createSQLQuery("update st_rm_bo_allowed_ip set status='" + status
						+ "',last_updation_time='" + time + "',user_id='" + selectedUserId + "',last_updated_by='"
						+ userId + "' where allowed_ip='" + ipAddress + "' and user_id='" + selectedUserId + "'");
				query.executeUpdate();
				tx.commit();
				return "success";
			} else if (ipResult.isEmpty() || ipResult == null) {
				Query query = session.createSQLQuery("insert into st_rm_bo_allowed_ip set allowed_ip='" + ipAddress
						+ "',status='" + status + "',domain_id='" + domainId + "',user_id='" + selectedUserId
						+ "' ,creation_time='" + time + "',reason='none',last_updated_by='" + userId
						+ "',last_updation_time='" + time + "'");
				query.executeUpdate();
				tx.commit();
				return "success";
			}

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return "error";

	}

	public List<Integer> getBatchNoList(int userId) {
		try {
			List<Integer> batchNoList = new ArrayList<>();
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmGameUserMapping.class);
			criteria.add(Restrictions.eq("user_id", userId));
			List<StRmGameUserMapping> result = criteria.list();
			if (result != null) {
				for (StRmGameUserMapping stRmGameUserMapping : result) {
					batchNoList.add(stRmGameUserMapping.getBatch_no());
				}
				return batchNoList;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void deleteGameData(int gameNo, int batchNo) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateSessionFactory.getSession();
			String query1 = "delete from itgs_input where game_no='" + gameNo + "' and batch_no='" + batchNo + "'";
			Query query = session.createSQLQuery(query1);
			query.executeUpdate();

			String query2 = "delete from st_rm_game_user_mapping where game_no='" + gameNo + "' and batch_no='"
					+ batchNo + "'";
			Query query3 = session.createSQLQuery(query2);
			query3.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Integer> getGameStatus(String ticketStatus) {
		// TODO Auto-generated method stub
		try {
			List<Integer> gameNoList = new ArrayList<>();
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.eq("status", ticketStatus));
			List<Itgs> result = criteria.list();
			if (result != null) {
				for (Itgs obj : result) {
					gameNoList.add(obj.getGame_No());
				}
				return gameNoList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Integer> getGameStatus(String ticketStatus, int userId) {
		// TODO Auto-generated method stub
		try {
			List<Integer> gameNoList = new ArrayList<>();
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmGameUserMapping.class);
			criteria.add(Restrictions.eq("status", ticketStatus));
			criteria.add(Restrictions.eq("user_id", userId));
			List<StRmGameUserMapping> result = criteria.list();
			if (result != null) {
				for (StRmGameUserMapping obj : result) {
					gameNoList.add(obj.getGame_no());
				}
				return gameNoList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void changeInProgressStatus() {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query1 = session
					.createSQLQuery("update itgs_input set status='Initiated' where status='InProgress'");
			SQLQuery query2 = session
					.createSQLQuery("update st_rm_game_user_mapping set status='Initiated' where status='InProgress'");
			query1.executeUpdate();
			query2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public byte[] getPDXml(int gameNO, int noOfTicketsPerBook, int noOfBooksPerPack, int noOfTickets,
			Double ticketPrize) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.eq("game_No", gameNO));
			List<Itgs> result = criteria.list();
			if (!result.isEmpty()) {
				Criteria criteria1 = session.createCriteria(Itgs.class);
				criteria1.add(Restrictions.eq("game_No", gameNO));
				criteria1.add(Restrictions.eq("no_Of_Tickets_Per_Book", noOfTicketsPerBook));
				criteria1.add(Restrictions.eq("no_Of_Books_Per_Pack", noOfBooksPerPack));
				criteria1.add(Restrictions.eq("no_Of_Tickets", noOfTickets));
				criteria1.add(Restrictions.eq("price", ticketPrize));
				List<Itgs> reItgs = criteria1.list();
				if (!reItgs.isEmpty()) {
					// ned to chk pz amts+
					return reItgs.get(reItgs.size() - 1).getPd_Xml();

				}
			} else {
				return null;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public void getProductionType() {
		// TODO Auto-generated method stub
		try {

			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("select * from itgs_game_limit_master where status='ACTIVE'");
			List<Object[]> result = query.list();
			if (result != null) {
				for (Object[] obj : result) {
					ServerStatusBean.setGAME_START_RANGE((int) obj[1]);
					ServerStatusBean.setGAME_END_RANGE((int) obj[2]);
					ServerStatusBean.setSERVER_TYPE(obj[3].toString());

				}
				System.out.println(":::::::::::SERVER TYPE:::::::::::::" + ServerStatusBean.SERVER_TYPE);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public List<String> getCompanyNameList() {
		// TODO Auto-generated method stub
		List<String> compNameList = null;
		try {
			compNameList = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(CreateCompany.class);
			List<CreateCompany> result = criteria.list();
			if (!result.isEmpty()) {
				for (CreateCompany company : result) {
					compNameList.add(company.getName());
				}
				return compNameList;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return compNameList;
	}

	public List<CreateCompany> getCompanyNameList(String name) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(CreateCompany.class);
			criteria.add(Restrictions.eq("name", name));
			List<CreateCompany> result = criteria.list();
			if (!result.isEmpty()) {

				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getGroupNamesList() {
		// TODO Auto-generated method stub
		try {
			List<String> list = new ArrayList<>();
			Session session = HibernateSessionFactory.getSession();
			String queryString = "select * from st_rm_acc_group_master order by group_id";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			if (result != null) {
				for (Object[] obj : result) {
					list.add(obj[1].toString());
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertGroup(String groupName, String group_under, String sub_ledger, String deb_cred_bln_rep, String calc,
			String pur_invoice) {
		// TODO Auto-generated method stub
				Session session = null;
				Transaction txn = null;
		try {
				session = HibernateSessionFactory.getSession();
				txn = session.beginTransaction();
				
				String queryString = "INSERT INTO st_rm_acc_group_master";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
