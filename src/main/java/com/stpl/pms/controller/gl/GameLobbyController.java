package com.stpl.pms.controller.gl;

import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Logger;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.apache.commons.io.IOUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.joda.time.Days;
import org.joda.time.LocalDateTime;
import org.joda.time.Months;
import org.joda.time.Years;
import org.json.JSONObject;

import com.stpl.pms.commonJavabeans.AttendanceBean;
import com.stpl.pms.commonJavabeans.BatteryBean;
import com.stpl.pms.commonJavabeans.BillsBean;
import com.stpl.pms.commonJavabeans.EmpDistributorBean;
import com.stpl.pms.commonJavabeans.EmployeeExpenseBean;
import com.stpl.pms.commonJavabeans.ExpenseBean;
import com.stpl.pms.commonJavabeans.FrightReportBean;
import com.stpl.pms.commonJavabeans.InterestBean;
import com.stpl.pms.commonJavabeans.LedgerReportBean;
import com.stpl.pms.commonJavabeans.LedgerSecondStepBean;
import com.stpl.pms.commonJavabeans.ManufacturingBean;
import com.stpl.pms.commonJavabeans.ProfitLossBean;
import com.stpl.pms.commonJavabeans.ReceiptSaleBillMapping;
import com.stpl.pms.commonJavabeans.SalaryReportBean;
import com.stpl.pms.commonJavabeans.SaleBean;
import com.stpl.pms.commonJavabeans.SaleBillsBean;
import com.stpl.pms.commonJavabeans.VisitBean;
import com.stpl.pms.constants.ServerStatusBean;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.daoImpl.gl.GameLobbyDaoImpl;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.CreateCompany;
import com.stpl.pms.hibernate.mapping.Itgs;
import com.stpl.pms.hibernate.mapping.StDmDomainAliasNameMaster;
import com.stpl.pms.hibernate.mapping.StPortalLobbyMaster;
import com.stpl.pms.hibernate.mapping.StRmBoAllowedIp;
import com.stpl.pms.hibernate.mapping.StRmBoUserInfo;
import com.stpl.pms.hibernate.mapping.StRmBoUserMaster;
import com.stpl.pms.hibernate.mapping.StRmGameUserMapping;
import com.stpl.pms.hibernate.mapping.StRmServiceVendorProperties;
import com.stpl.pms.hibernate.mapping.TransactionApprovalMaster;
import com.stpl.pms.javabeans.AccountGroupMaster;
import com.stpl.pms.javabeans.BoVendorGameBean;
import com.stpl.pms.javabeans.CountryBean;
import com.stpl.pms.javabeans.GameLobbyMasterBean;
import com.stpl.pms.javabeans.LedgerBankAccount;
import com.stpl.pms.javabeans.LedgerBean;
import com.stpl.pms.javabeans.LedgerCustomBean;
import com.stpl.pms.javabeans.StockCatBean;
import com.stpl.pms.javabeans.StockGroupBean;
import com.stpl.pms.javabeans.StockItemBean;
import com.stpl.pms.javabeans.UnitBean;
import com.stpl.pms.javabeans.VisitFormBean;
import com.stpl.pms.javabeans.VoucherBean;
import com.stpl.pms.struts.common.GetGameListHelper;
import com.stpl.pms.utility.SendSMS;

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

	public boolean insertGroup(String groupName, String group_under, String sub_ledger, String deb_cred_bln_rep,
			String calc, String pur_invoice) {

		Session session = null;
		Transaction txn = null;
		try {
			session = HibernateSessionFactory.getSession();
			txn = session.beginTransaction();
			int value = getGroupUnderIdByName(group_under);
			String queryString = "INSERT INTO st_rm_acc_group_master(`group_name`,`group_under_id`,`sub_ledger`,`deb_cred_bal_rep`,`calculation`,`purchase_invoice`) values('"
					+ groupName + "'," + value + ",'" + sub_ledger + "','" + deb_cred_bln_rep + "','" + calc + "','"
					+ pur_invoice + "')";
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
		}
		return false;
	}

	private int getGroupUnderIdByName(String group_under) {

		try {
			if (group_under.equalsIgnoreCase("primary")) {
				return 0;
			} else {
				Session session = HibernateSessionFactory.getSession();
				String queryString = "SELECT group_id,group_name from st_rm_acc_group_master WHERE group_name='"
						+ group_under + "'";
				SQLQuery query = session.createSQLQuery(queryString);
				List<Object[]> result = query.list();
				if (result != null || !result.isEmpty()) {
					for (Object[] obj : result) {
						return (int) obj[0];
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("null")
	public List<String> getCustomGroupNameList() {

		List<String> lst = null;
		try {
			lst = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			String queryString = "SELECT * FROM st_rm_acc_group_master";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					lst.add(obj[1].toString());
				}
				return lst;
			}
		} catch (Exception r) {
			r.printStackTrace();
		}
		return lst;
	}

	public List<AccountGroupMaster> getAccountGroupMaster(String groupName) {

		try {
			AccountGroupMaster accountGroupMaster = new AccountGroupMaster();
			List<AccountGroupMaster> accountGroupMastersList = new ArrayList<AccountGroupMaster>();
			Session session = HibernateSessionFactory.getSession();
			String queryString = "SELECT group_id,CAST(group_name AS CHAR) as gn,group_under_id,CAST(sub_ledger AS CHAR) as sl,CAST(deb_cred_bal_rep AS CHAR) as dcbr,CAST(calculation AS CHAR) as calc,CAST(purchase_invoice AS CHAR) as pi FROM st_rm_acc_group_master WHERE group_name='"
					+ groupName + "'";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					accountGroupMaster.setGroupId((int) obj[0]);
					accountGroupMaster.setGroupName(obj[1].toString());
					accountGroupMaster.setGroupUnderName(getGroupUnderNameById((int) obj[2]));
					accountGroupMaster.setSubLedger(obj[3].toString());
					accountGroupMaster.setBlncForRep(obj[4].toString());
					accountGroupMaster.setForCalc(obj[5].toString());
					accountGroupMaster.setPurInvoice(obj[6].toString());
					accountGroupMastersList.add(accountGroupMaster);
				}
				return accountGroupMastersList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getGroupUnderNameById(int i) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "SELECT * from st_rm_acc_group_master where group_id=" + i;
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			for (Object[] obj : result)
				return obj[1].toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Primary";
	}

	public boolean deleteGroupByName(String groupName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "DELETE FROM st_rm_acc_group_master WHERE group_name='" + groupName + "'";
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			return true;
		} catch (Exception r) {
			r.printStackTrace();
		}
		return false;
	}

	public AccountGroupMaster getEditGroupDisplay(int groupId) {

		try {
			AccountGroupMaster accountGroupMaster = new AccountGroupMaster();
			Session session = HibernateSessionFactory.getSession();
			String queryString = "SELECT group_id,CAST(group_name AS CHAR) as gn,group_under_id,CAST(sub_ledger AS CHAR) as sl,CAST(deb_cred_bal_rep AS CHAR) as dcbr,CAST(calculation AS CHAR) as calc,CAST(purchase_invoice AS CHAR) as pi FROM st_rm_acc_group_master WHERE group_id="
					+ groupId + "";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					accountGroupMaster.setGroupId((int) obj[0]);
					accountGroupMaster.setGroupName(obj[1].toString());
					accountGroupMaster.setGroupUnderName(getGroupUnderNameById((int) obj[2]));
					accountGroupMaster.setSubLedger(obj[3].toString());
					accountGroupMaster.setBlncForRep(obj[4].toString());
					accountGroupMaster.setForCalc(obj[5].toString());
					accountGroupMaster.setPurInvoice(obj[6].toString());

				}
				return accountGroupMaster;
			}
		} catch (Exception r) {
			r.printStackTrace();
		}
		return null;
	}

	public boolean editGroupDetails(AccountGroupMaster groupMaster) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "UPDATE st_rm_acc_group_master SET sub_ledger='"
					+ groupMaster.getSubLedger().toUpperCase() + "',deb_cred_bal_rep='"
					+ groupMaster.getBlncForRep().toUpperCase() + "',calculation='"
					+ groupMaster.getForCalc().toUpperCase() + "',purchase_invoice='"
					+ groupMaster.getPurInvoice().toUpperCase() + "' WHERE group_id=" + groupMaster.getGroupId();
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean createLedger(String ledgerName, String groupUnder, String name, String address, String country,
			String state, String pincode, LedgerBankAccount ledgerBankAccount, String blcBillByBill,
			String defCreditPeriod, String creditDayDuringVoucher, String specifyCreditLimit, String empName,
			String txnByTxnInterest, String intesestBasedOn, String foramtAdded, String foramtDeduct, String rate,
			String ratePer, String rateOn, String intersetCalculationApplicability,
			String intersetCalculationApplicabilityDays, String intersetCalculationFrom,
			String intersetCalculationApplicabilityGracePeriod, String intersetCalculationSecurityAmt,
			String security) {

		Transaction txn = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			txn = session.beginTransaction();
			int emp_id = getEmployeeId(empName);

			String queryString = "INSERT INTO st_rm_acc_ledger_master(`ledger_name`,`ledger_under_group_name`,`name`,`address`,`country`,`state`,`pincode`,`emp_under_id`) values('"
					+ ledgerName + "','" + groupUnder + "','" + name + "','" + address + "','" + country + "','" + state
					+ "','" + pincode + "'," + emp_id + ")";
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			queryString = "select ledger_id from st_rm_acc_ledger_master WHERE ledger_name='" + ledgerName + "'";
			SQLQuery query2 = session.createSQLQuery(queryString);
			List<Integer> result = query2.list();
			Integer Ledger_id = result.get(0);
			String bankAccQuery = "INSERT INTO st_rm_acc_ledger_bank_acc_master(`ledgerId`,`activateInterestCalculation`,`accHolderName`,`bankName`,`accNumber`,`ifsc`,`branch`,`gstNumber`,`chequePrinting`,`chequeBook`) values("
					+ Ledger_id + ",'" + ledgerBankAccount.getActivateInterestCalculation() + "','"
					+ ledgerBankAccount.getAccHolderName() + "','" + ledgerBankAccount.getBankName() + "','"
					+ ledgerBankAccount.getAccNumber() + "','" + ledgerBankAccount.getIfsc() + "','"
					+ ledgerBankAccount.getBranch() + "','" + ledgerBankAccount.getGstNumber() + "','"
					+ ledgerBankAccount.getChequePrinting() + "','" + ledgerBankAccount.getChequeBook() + "')";
			SQLQuery bankAccQueryquery = session.createSQLQuery(bankAccQuery);
			bankAccQueryquery.executeUpdate();
			if (groupUnder.equals("Sundry creditors") || groupUnder.equals("Sundry debtors")) {
				if (defCreditPeriod.isEmpty())
					defCreditPeriod = "-1";
				if (specifyCreditLimit.isEmpty())
					specifyCreditLimit = "-1";
				queryString = "INSERT INTO st_rm_credit_limit(`ledger_id`,`blnc_bill_by_bill`,`credit_period`,`credit_day_vchr_entry`,`credit_limit`) values("
						+ Ledger_id + ",'" + blcBillByBill + "'," + defCreditPeriod + ",'" + creditDayDuringVoucher
						+ "'," + specifyCreditLimit + ")";
				SQLQuery query3 = session.createSQLQuery(queryString);
				query3.executeUpdate();
			}

			String[] foramtAddedArr = foramtAdded.split(",");
			String[] foramtDeductArr = foramtDeduct.split(",");
			String[] rateArr = rate.split(",");
			String[] ratePerArr = ratePer.split(",");
			String[] rateOnArr = rateOn.split(",");
			String[] intersetCalculationApplicabilityArr = intersetCalculationApplicability.split(",");
			String[] intersetCalculationApplicabilityDaysArr = intersetCalculationApplicabilityDays.split(",");
			String[] intersetCalculationFromArr = intersetCalculationFrom.split(",");
			String[] intersetCalculationApplicabilityGracePeriodArr = intersetCalculationApplicabilityGracePeriod
					.split(",");
			String[] intersetCalculationSecurityAmtArr = intersetCalculationSecurityAmt.split(",");
			String[] securityArr = security.split(",");
			int length = rateArr.length;

			for (int i = 0; i < length; i++) {
				if (rateArr[i].trim().isEmpty() || rateArr[i].trim().equals("-1") || rateArr[i].trim().equals("0"))
					continue;
				queryString = "INSERT INTO st_rm_ledger_interset_calculation(`ledger_id`,`txn_by_txn`,`interest_based_on`,`amt_added`,`amt_deduct`,`rate`,`rate_per`,`rate_on`,`applicability`,`by`,`grace_period`,`calc_from`,`security_amt`,`is_security`) values("
						+ Ledger_id + ",'" + txnByTxnInterest + "','" + intesestBasedOn + "','"
						+ foramtAddedArr[i].trim() + "','" + foramtDeductArr[i].trim() + "','" + rateArr[i].trim()
						+ "','" + ratePerArr[i].trim() + "','" + rateOnArr[i].trim() + "','"
						+ intersetCalculationApplicabilityArr[i].trim() + "','"
						+ intersetCalculationApplicabilityDaysArr[i].trim() + "','"
						+ intersetCalculationApplicabilityGracePeriodArr[i].trim() + "','"
						+ intersetCalculationFromArr[i].trim() + "','" + intersetCalculationSecurityAmtArr[i].trim()
						+ "','" + securityArr[i].trim() + "')";
				SQLQuery query3 = session.createSQLQuery(queryString);
				query3.executeUpdate();
			}

			txn.commit();
			return true;
		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();

		}
		return false;
	}

	public List<String> getLedgerNamesList() {

		List<String> list = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			list = new ArrayList<String>();
			String queryString = "SELECT * from st_rm_acc_ledger_master order by ledger_name ASC";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					list.add(obj[1].toString());
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<LedgerBean> getAccountLedgerMaster(String ledgerName) {
		try {
			LedgerBean accountLedgerMaster = null;
			List<LedgerBean> accountGroupMastersList = new ArrayList<LedgerBean>();
			Session session = HibernateSessionFactory.getSession();
			String queryString = "SELECT * FROM st_rm_acc_ledger_master WHERE ledger_name='" + ledgerName + "'";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					accountLedgerMaster = new LedgerBean();
					accountLedgerMaster.setLedgerId((int) obj[0]);
					accountLedgerMaster.setLedgerName(obj[1].toString());
					accountLedgerMaster.setGroupUnder(obj[2].toString());
					accountLedgerMaster.setAddress(obj[4].toString());
					accountLedgerMaster.setName(obj[3].toString());
					accountLedgerMaster.setCountry(obj[5].toString());
					accountLedgerMaster.setState(obj[6].toString());
					accountLedgerMaster.setPincode(obj[7].toString());
					accountGroupMastersList.add(accountLedgerMaster);
				}
				return accountGroupMastersList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteLedgerByName(String ledgerName) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "DELETE FROM st_rm_acc_ledger_master WHERE ledger_name='" + ledgerName + "'";
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			return true;
		} catch (Exception r) {
			r.printStackTrace();
		}
		return false;
	}

	public boolean createNewStockGroup(String stockName, String stockUnder, String quantityCheck,
			String gstDetailCheck) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "INSERT INTO st_rm_stock_group_master(`stock_name`,`stock_under`,`quantity_check`,`gst_detail_check`) values('"
					+ stockName + "','" + stockUnder + "','" + quantityCheck + "','" + gstDetailCheck + "')";
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<String> getEmployeeNamesList() {
		List<String> list = null;
		try {
			list = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
			criteria.add(Restrictions.gt("parentUserId", 0));
			List<StRmBoUserMaster> result = criteria.list();
			if (result != null || !result.isEmpty()) {
				for (StRmBoUserMaster boUserMaster : result) {
					list.add(boUserMaster.getUserName());
				}
				return list;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<String> getAllStockGroup() {
		List<String> stockList = null;
		try {
			stockList = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			String StringQuery = "select * from st_rm_stock_group_master";
			SQLQuery query = session.createSQLQuery(StringQuery);
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty()) {
				for (Object[] obj : result) {
					stockList.add(obj[1].toString());
				}
				return stockList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockList;
	}

	public List<StockGroupBean> getStockGrpBeanList() {
		try {
			Session session = HibernateSessionFactory.getSession();
			StockGroupBean bean = null;
			List<StockGroupBean> beans = new ArrayList<StockGroupBean>();
			String queryString = "SELECT * FROM st_rm_stock_group_master";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					bean = new StockGroupBean();
					bean.setStGpId((int) obj[0]);
					bean.setStockName(obj[1].toString());
					bean.setStockUnder(obj[2].toString());
					bean.setQtyCheck(obj[3].toString());
					bean.setGstDetCheck(obj[4].toString());
					beans.add(bean);
				}
				return beans;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public StockGroupBean getStockBean(int st_gp_id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "SELECT * FROM st_rm_stock_group_master where st_gp_id=" + st_gp_id;
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			StockGroupBean bean = new StockGroupBean();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					bean.setStGpId((int) obj[0]);
					bean.setStockName(obj[1].toString());
					bean.setStockUnder(obj[2].toString());
					bean.setQtyCheck(obj[3].toString());
					bean.setGstDetCheck(obj[4].toString());
				}
				return bean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateStockGroup(StockGroupBean stockBean) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "UPDATE st_rm_stock_group_master SET stock_name='" + stockBean.getStockName()
					+ "',quantity_check='" + stockBean.getQtyCheck() + "',gst_detail_check='"
					+ stockBean.getGstDetCheck() + "' WHERE st_gp_id=" + stockBean.getStGpId();
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteStockByName(String stockName) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "DELETE FROM st_rm_stock_group_master WHERE stock_name='" + stockName + "'";
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean createNewStockCatagory(String stockName, String stockUnder) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "INSERT INTO st_rm_stock_catagory_master(`stock_name`,`stock_under`) values('"
					+ stockName + "','" + stockUnder + "')";
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			return true;
		} catch (Exception r) {
			r.printStackTrace();
		}
		return false;
	}

	public List<String> getStockCatagoryNames() {
		List<String> listResponse = null;
		try {
			listResponse = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * FROM st_rm_stock_catagory_master";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {

				for (Object[] obj : result) {
					listResponse.add(obj[1].toString());
				}
				return listResponse;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listResponse;
	}

	public List<StockCatBean> getStockCatagoryDetails(String stockCatagoryName) {
		try {
			Session session = HibernateSessionFactory.getSession();
			List<StockCatBean> beans = new ArrayList<StockCatBean>();
			StockCatBean bean = new StockCatBean();
			String sqlString = "SELECT * FROM st_rm_stock_catagory_master where stock_name='" + stockCatagoryName + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					bean.setStCtId((int) obj[0]);
					bean.setStockName(obj[1].toString());
					bean.setStock_under(obj[2].toString());
					beans.add(bean);
				}
				return beans;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public StockCatBean getStockCategoryBean(int st_ct_id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			StockCatBean bean = new StockCatBean();
			String queryString = "SELECT * FROM st_rm_stock_catagory_master WHERE st_ct_id=" + st_ct_id;
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			if (result != null) {
				for (Object[] obj : result) {
					bean.setStCtId((int) obj[0]);
					bean.setStockName(obj[1].toString());
					bean.setStock_under(obj[2].toString());
				}
				return bean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteStockCatagory(String stockCatagoryName) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "DELETE FROM st_rm_stock_catagory_master where stock_name='" + stockCatagoryName + "'";
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("null")
	public List<String> getAllStockCatagory() {
		List<String> listResult = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			listResult = new ArrayList<String>();
			listResult.add("Primary");
			String queryString = "SELECT * FROM st_rm_stock_catagory_master";
			SQLQuery query = session.createSQLQuery(queryString);
			@SuppressWarnings("unchecked")
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					listResult.add(obj[1].toString());
				}
				return listResult;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listResult;
	}

	public List<String> getAllStockItem() {
		List<String> resultList = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			resultList = new ArrayList();
			resultList.add("Not Applicable");
			String sqlString = "SELECT * from st_rm_unit_master where unit_type='Simple'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					resultList.add(obj[3].toString());
				}
				return resultList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	public boolean createNewUnit(String unitType, String unitSymbol, String formalName, String uQC, String decimalPlace,
			String firstCompoundUnit, String conversionOf, String secondCompoundUnit) {
		try {
			Session session = HibernateSessionFactory.getSession();
			int decplc = Integer.valueOf(decimalPlace);
			String queryString = "";
			if (unitType.equalsIgnoreCase("Simple"))
				queryString = "INSERT INTO st_rm_unit_master(`unit_type`,`Symbol`,`formal_name`,`unit_quantity_code`,`no_of_dec_places`) values('"
						+ unitType + "','" + unitSymbol + "','" + formalName + "','" + uQC + "'," + decplc + ")";
			else
				queryString = "INSERT INTO st_rm_unit_master(`unit_type`,`first_compound_unit`,`conversionOf`,`second_compound_unit`) values('"
						+ unitType + "','" + firstCompoundUnit + "','" + conversionOf + "','" + secondCompoundUnit
						+ "')";

			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<String> getUnitMeasureList() {
		List<String> response = null;
		try {
			response = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			String queryString = "SELECT * FROM st_rm_unit_master where unit_type='Simple'";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					response.add(obj[3].toString());
				}
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public List<UnitBean> getUnitMeasureBeanByName(String unitSymbol) {
		try {
			Session session = HibernateSessionFactory.getSession();
			UnitBean unitBean = null;
			List<UnitBean> list = new ArrayList();
			String queryString = "SELECT * FROM st_rm_unit_master WHERE Symbol='" + unitSymbol + "'";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					unitBean = new UnitBean();
					unitBean.setUnitId((int) obj[0]);
					unitBean.setUnitType(obj[1].toString());
					unitBean.setFormalName(obj[4].toString());
					unitBean.setUQC(obj[5].toString());
					unitBean.setDecimalPlace((int) obj[6]);
					unitBean.setUnitSymbol(obj[3].toString());
					list.add(unitBean);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteUnitMeasure(String unitSymbol) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "DELETE FROM st_rm_unit_master WHERE Symbol='" + unitSymbol + "'";
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			return true;
		} catch (Exception r) {
			r.printStackTrace();
		}
		return false;
	}

	public boolean itemCreationFirstStep(String stItm_stockItemName, String stItm_stockUnderItem,
			String stItm_stockItemCat, String stItm_stockItemUnit, String stItm_isGst, String stItm_alterGst,
			String stItm_supplyType, String stItm_dutyRate, String stockItemAlterUnit, String funit, String sunit,
			String isbatches, String dom, String expDate, String standRate, String costTrack, String itax, String ctax,
			String stax, String cess, String stockItemWholesaleUnit, String fwunit, String swunit, String hsn_uac,
			Session session, Transaction transaction) {
		String sqlQuery = "";
		try {
			sqlQuery = "INSERT INTO st_rm_stock_item_unit_master(`is_alternate`,`conversion_from`,`from_unit`,`conversion_to`,`to_unit`,`is_batches`,`date_of_manu`,`use_expiry`,`is_standard`,`cost_track`,`bulk_unit_name`,`bulk_from_unit`,`bulk_to_unit`,`hsn_sac_code`) values('"
					+ stockItemAlterUnit + "','" + funit + "','" + stockItemAlterUnit + "','" + sunit + "','"
					+ stItm_stockItemUnit + "','" + isbatches + "','" + dom + "','" + expDate + "','" + standRate
					+ "','" + costTrack + "','" + stockItemWholesaleUnit + "','" + fwunit + "','" + swunit + "','"
					+ hsn_uac + "')";
			SQLQuery unitQuery = session.createSQLQuery(sqlQuery);
			unitQuery.executeUpdate();
			int gstId = 0;
			if (stItm_alterGst.equalsIgnoreCase("Yes")) {
				Double i = Double.valueOf(itax);
				Double c = Double.valueOf(ctax);
				Double s = Double.valueOf(stax);
				Double ces = cess.isEmpty() ? 0 : Double.valueOf(cess);
				String gstQuery = "INSERT INTO st_rm_stock_gst_master(`igst`,`cgst`,`sgst`,`cess`) values(" + i + ","
						+ c + "," + s + "," + ces + ")";
				SQLQuery querygst = session.createSQLQuery(gstQuery);
				querygst.executeUpdate();
				gstId = getItemGSTIdFromMaster();
			}
			int unitId = getItemUnitIdFromMaster();
			sqlQuery = "INSERT INTO st_rm_stock_item_master(`item_name`,`under_grp`,`under_cat`,`is_unit`,`item_unit_id`,`is_gst_applicable`,`alter_gst`,`alter_gst_id`,`type_of_supply`,`rate_of_duty`) values('"
					+ stItm_stockItemName + "','" + stItm_stockUnderItem + "','" + stItm_stockItemCat + "','"
					+ stItm_stockItemUnit + "'," + unitId + ",'" + stItm_isGst + "','" + stItm_alterGst + "'," + gstId
					+ ",'" + stItm_supplyType + "','" + stItm_dutyRate + "')";
			SQLQuery masterQuery = session.createSQLQuery(sqlQuery);
			masterQuery.executeUpdate();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	private int getItemGSTIdFromMaster() {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT MAX(gst_id) from st_rm_stock_gst_master");
			List<Integer> result = query.list();
			int itemId = 0;
			if (result != null || !result.isEmpty()) {
				for (Integer obj : result) {
					itemId = obj;
				}
				return itemId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	private int getItemUnitIdFromMaster() {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT MAX(item_unit_id) from st_rm_stock_item_unit_master");
			List<Integer> result = query.list();
			int itemId = 0;
			if (result != null || !result.isEmpty()) {
				for (Integer obj : result) {
					itemId = obj;
				}
				return itemId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public List<String> getAllStockItemsList() {

		List<String> listResult = null;
		try {
			listResult = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			String query = "SELECT DISTINCT item_name from st_rm_stock_item_master ORDER BY item_name ASC";
			SQLQuery sqlQuery = session.createSQLQuery(query);
			List<String> result = sqlQuery.list();
			if (result != null || !result.isEmpty()) {
				for (String s : result)
					listResult.add(s);
				return listResult;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listResult;
	}

	public List<StockItemBean> getStockItemBeanByName(String stockItemSelected) {

		try {
			StockItemBean bean = new StockItemBean();
			List<StockItemBean> response = new ArrayList<StockItemBean>();
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM `st_rm_stock_item_master` AS a   LEFT JOIN  `st_rm_stock_item_unit_master` AS b ON a.item_unit_id = b.item_unit_id WHERE a.item_name='"
							+ stockItemSelected + "'");
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {

					bean.setItemId((int) obj[0]);
					bean.setItemName(obj[1].toString());
					bean.setUnderGroup(obj[2].toString());
					bean.setUnderCatagory(obj[3].toString());
					bean.setIsUnit(obj[4].toString());
					bean.setGstApplicable(obj[6].toString());
					bean.setAlterGST(obj[7].toString());
					bean.setSupplyType(obj[9].toString());
					bean.setRateDuty(obj[10].toString());
					bean.setIsAlternate(obj[12].toString());
					bean.setHsnCode(obj[26] != null ? obj[26].toString() : "");
					bean.setBulkUnit(obj[23] != null ? obj[23].toString() : "");
					if (!obj[12].toString().equalsIgnoreCase("not applicable")) {
						bean.setConversionFrom(obj[13].toString() + " " + obj[13].toString());
						bean.setConversionTo(obj[15].toString() + " " + obj[15].toString());
					}
					bean.setIsBatches(obj[17].toString());
					if (bean.getIsBatches().equalsIgnoreCase("YES")) {
						bean.setDom(obj[18].toString());
						bean.setExpiry(obj[19].toString());
					}
					bean.setIsStandard(obj[20] != null ? obj[20].toString() : "");
					bean.setCostTrack(obj[22] != null ? obj[22].toString() : "");
					response.add(bean);
				}
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteStockItem(String stockItemSelected) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			int id = getUnitItemId(stockItemSelected);
			String query = "delete from st_rm_stock_item_master where item_name='" + stockItemSelected + "'";
			SQLQuery query2 = session.createSQLQuery(query);
			query2.executeUpdate();
			if (id > 0) {
				String nextQuery = "delete from st_rm_stock_item_unit_master where item_unit_id=" + id + "";
				SQLQuery query3 = session.createSQLQuery(nextQuery);
				query3.executeUpdate();
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		}
		return false;
	}

	private int getUnitItemId(String stockItemSelected) {

		Session session = HibernateSessionFactory.getSession();
		String sqlString = "SELECT item_unit_id from st_rm_stock_item_master where item_name ='" + stockItemSelected
				+ "'";
		SQLQuery query = session.createSQLQuery(sqlString);
		List<Integer> result = query.list();
		if (result != null || !result.isEmpty()) {
			return result.get(0);
		}
		return 0;
	}

	public List<String> getAllGoDownList() {

		List<String> response = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "SELECT * FROM st_rm_Godown_master";
			SQLQuery query = session.createSQLQuery(queryString);
			response = new ArrayList<String>();
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result)
					response.add(obj[1].toString());
				return response;
			}
		} catch (Exception r) {
			r.printStackTrace();
		}
		return response;
	}

	public boolean createNewGodown(String godownName, String godownUnder, String allowStorage,
			String ourStockwithTparty, String thirdPartyStockWithus) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "INSERT INTO st_rm_Godown_master(`name`,`under`,`allow_storage`,`our_stock_with_3_party`,`3_party_stock_with_us`) values('"
					+ godownName + "','" + godownUnder + "','" + allowStorage + "','" + ourStockwithTparty + "','"
					+ thirdPartyStockWithus + "')";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<String> getVoucherTypeList() {

		List<String> response = null;
		try {
			response = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			String queryString = "SELECT * FROM st_rm_voucher_list_master";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					response.add(obj[1].toString());
				}
				return response;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public boolean createNewVoucher(VoucherBean voucherBean) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int voucherUnderId = getVoucherUnder(voucherBean.getVoucherType());
			if (voucherUnderId > 0) {
				String sqlString = "INSERT INTO st_rm_voucher_master(`vc_name`,`under_id`,`vchr_numbering`,`eff_date_of_vchr`,`narration_allowd`,`is_advance`,`numbering`,`prefix`,`suffix`,`decimal_digit`,`start_date`,`end_date`) values('"
						+ voucherBean.getVoucherName() + "'," + voucherUnderId + ",'"
						+ voucherBean.getVoucherNumbering() + "','" + voucherBean.getEffctvDateOfVchr() + "','"
						+ voucherBean.getNarrationAllowed() + "','" + voucherBean.getAdvanceNumbering() + "',"
						+ voucherBean.getStartingNumber() + ",'" + voucherBean.getPrefix() + "/','"
						+ voucherBean.getSuffix() + "/'," + voucherBean.getDecimalNumber() + ",'"
						+ voucherBean.getStartDate() + "','" + voucherBean.getEndDate() + "')";
				SQLQuery query = session.createSQLQuery(sqlString);
				query.executeUpdate();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private int getVoucherUnder(String voucherType) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select * from st_rm_voucher_list_master WHERE voucher_name='" + voucherType + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result)
					return (int) obj[0];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<String> getCustomVoucherList() {
		List<String> response = null;
		try {
			response = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * FROM st_rm_voucher_master";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					response.add(obj[1].toString());
				}
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	public List<VoucherBean> getVouchetBeanByName(String voucherName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			VoucherBean bean = new VoucherBean();
			List<VoucherBean> beans = new ArrayList<VoucherBean>();
			String sqlString = "SELECT * FROM st_rm_voucher_master WHERE vc_name='" + voucherName + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					bean.setVoucherId((int) obj[0]);
					bean.setVoucherName(obj[1].toString());
					bean.setVoucherType(getVoucherTypeById((int) obj[2]));
					bean.setVoucherNumbering(obj[3].toString());
					bean.setEffctvDateOfVchr(obj[4].toString());
					bean.setNarrationAllowed(obj[4].toString());
					beans.add(bean);
				}

				return beans;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getVoucherTypeById(int id) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * FROM st_rm_voucher_list_master WHERE vchr_id=" + id + "";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					return obj[1].toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteVoucher(String voucherName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "DELETE FROM st_rm_voucher_master WHERE vc_name='" + voucherName + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<String> getaccountListForTxnPayment(String type, int emp_id) {

		List<String> response = null;
		try {
			String suffixQuery = "";

			if (emp_id != 1) {
				if (type.equals("accList"))
					suffixQuery = "WHERE ledger_under_group_name IN('Bank Account','Bank occ a/c','Bank od a/c','Cash in hand') and emp_under_id="
							+ emp_id;
				else if (type.equals("sales acc"))
					suffixQuery = "WHERE ledger_under_group_name IN('Sales account') and emp_under_id=" + emp_id;
				else if (type.equals("purchase acc"))
					suffixQuery = "WHERE ledger_under_group_name IN('Purchase account')  and emp_under_id=" + emp_id;
				else if (type.equals("payment"))
					suffixQuery = "WHERE ledger_under_group_name NOT IN('Bank Account','Bank occ a/c','Bank od a/c')  and emp_under_id="
							+ emp_id;

				else
					suffixQuery = "WHERE emp_under_id=" + emp_id;

			} else {
				if (type.equals("accList"))
					suffixQuery = "WHERE ledger_under_group_name IN('Bank Account','Bank occ a/c','Bank od a/c','Cash in hand')";
				else if (type.equals("sales acc"))
					suffixQuery = "WHERE ledger_under_group_name IN('Sales account')";
				else if (type.equals("purchase acc"))
					suffixQuery = "WHERE ledger_under_group_name IN('Purchase account')";
				else if (type.equals("payment"))
					suffixQuery = "WHERE ledger_under_group_name NOT IN('Bank Account','Bank occ a/c','Bank od a/c')";
				else
					suffixQuery = "";

			}
			response = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			String sqlQuery = "SELECT * FROM st_rm_acc_ledger_master " + suffixQuery + " ORDER BY ledger_name ASC";
			SQLQuery query = session.createSQLQuery(sqlQuery);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					response.add(obj[1].toString());
				}
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public boolean createTransactionPayment(String account, String employeeUnder, String currBalance,
			String particulars, String amount, String bankName, String txnType, String narration, String currentblnc,
			String hiddenTypeOfRef, String hiddenBillWiseName, String hiddenAmnt, String hiddenBilId,
			String activeVoucherNumber, String paymentDate, String paymentNoVoucher, Session session,
			Transaction transaction, String accountOldBal, String particularsOldBal, String totalAmt) {
		try {
			int empId = getEmployeeId(employeeUnder);
			LocalDate date1 = LocalDate.now();
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date1.format(formatter1);
			if (paymentDate == null || paymentDate.isEmpty()) {
				paymentDate = currentDate;
			}
			String sqlString = "INSERT INTO st_rm_txn_payment_master(`account`,`empId`,`currentBalance`,`Particulars`,`amount`,`txnType`,`bank_name`,`narration`,`finalBalance`,`voucher_numbering`,`under_vcr_id`,`paymentDate`) values('"
					+ account + "'," + empId + ",'" + currBalance + "','" + particulars + "','" + amount + "','"
					+ txnType + "','" + bankName + "','" + narration + "'," + totalAmt + ",'" + paymentNoVoucher + "',"
					+ activeVoucherNumber + ",'" + paymentDate + "')";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			String particularArr[] = particulars.split(",");
			String currentblncArr[] = currentblnc.split(",");
			String typeOfRefArr[] = hiddenTypeOfRef.split(",");
			String amountArr[] = amount.split(",");
			String hiddenBillWiseNameArr[] = hiddenBillWiseName.split(",");
			String hiddenAmntArr[] = hiddenAmnt.split(",");
			String hiddenBilIdArr[] = new String[hiddenBillWiseNameArr.length];
			for (int i = 0; i < hiddenBillWiseNameArr.length; i++) {
				String TemphiddenBillWiseNameArr[] = hiddenBillWiseNameArr[i].split(" ");
				if (TemphiddenBillWiseNameArr.length > 0) {
					if (i > 0)
						hiddenBilIdArr[i] = TemphiddenBillWiseNameArr[1];
					else
						hiddenBilIdArr[i] = TemphiddenBillWiseNameArr[0];

				}
			}
			int length = particularArr.length;
			int lengthBillWise = hiddenBilIdArr.length;
			for (int i = 0; i < length - 1; i++) {
				if (particularArr[i].contains("none"))
					continue;
				String sqlString1 = "SELECT * from st_rm_acc_ledger_master where ledger_name='"
						+ particularArr[i].trim() + "'";
				SQLQuery query1 = session.createSQLQuery(sqlString1);
				List<Object[]> partyIds = query1.list();
				int partyLedgerId = 0;
				for (Object[] obj : partyIds) {
					partyLedgerId = (int) obj[0];
				}
				sqlString1 = "SELECT balance_type FROM st_rm_purchase_party_master_balance WHERE party_id="
						+ partyLedgerId + "";
				SQLQuery queryn = session.createSQLQuery(sqlString1);
				List<String> rs = queryn.list();
				String blnc_type = rs.get(0);
				Double blnc = Double.valueOf(currentblncArr[i].trim());
				String temp_blnc_type = "";

				if (blnc_type.equals("Cr")) {
					if (blnc < 0) {
						blnc = blnc * (-1);
						temp_blnc_type = ",balance_type='Dr'";
					} else {
						temp_blnc_type = ",balance_type='Cr'";
					}
				} else {
					temp_blnc_type = ",balance_type='Dr'";
				}

				sqlString1 = "UPDATE st_rm_purchase_party_master_balance SET balance='" + String.valueOf(blnc) + "' "
						+ temp_blnc_type + " WHERE party_id=" + partyLedgerId + "";
				SQLQuery query2 = session.createSQLQuery(sqlString1);
				query2.executeUpdate();

				LocalDate date = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				if (!hiddenBilIdArr[0].isEmpty()) {
					String is_used = "No";
					for (int j = 0; j < lengthBillWise; j++) {
						if (typeOfRefArr[j].trim().equals("Advance") || typeOfRefArr[j].trim().equals("On Account")) {
							sqlString1 = "INSERT INTO st_rm_bill_wise_details(`type_of_ref`,`party_id`,`balance`,`is_used`,`date`,`blnc_type`,`purchase_voucher_number`) values('"
									+ typeOfRefArr[j].trim() + "','" + partyLedgerId + "','" + hiddenAmntArr[j].trim()
									+ "','" + is_used + "','" + date.format(formatter) + "','Dr','"
									+ hiddenBilIdArr[j].trim() + "')";
							SQLQuery query3 = session.createSQLQuery(sqlString1);
							query3.executeUpdate();

						} else {
							sqlString1 = "SELECT * FROM st_rm_bill_wise_details WHERE party_id=" + partyLedgerId
									+ " and purchase_voucher_number='" + hiddenBilIdArr[j].trim() + "'";
							SQLQuery query3 = session.createSQLQuery(sqlString1);
							List<Object[]> rst = query3.list();
							Double Amount = 0.0;
							if (rst != null) {
								for (Object[] obj : rst)
									Amount = Double.valueOf(obj[3].toString());
							}
							Amount = Amount - Double.valueOf(hiddenAmntArr[i].trim());
							if (Amount <= 0) {
								is_used = "Yes";
							}
							sqlString1 = "UPDATE st_rm_bill_wise_details SET balance='" + String.valueOf(Amount)
									+ "',is_used='" + is_used + "' WHERE purchase_voucher_number='"
									+ hiddenBilIdArr[j].trim() + "'";
							SQLQuery query4 = session.createSQLQuery(sqlString1);
							query4.executeUpdate();
						}
					}
				}

			}
			int partyId = getLedgerIdByName(account);
			String[] accountOldBalArr = accountOldBal.split(" ");
			String balnType = accountOldBalArr[1];
			Double bankCashAmt = 0.0;
			Double receiptAmt = 0.0;
			for (int i = 0; i < amountArr.length; i++) {
				if (amountArr[i] != null && !amountArr[i].trim().isEmpty() && !amountArr[i].contains("-1")
						&& !amountArr[i].trim().equals(""))
					bankCashAmt = bankCashAmt + Double.valueOf(amountArr[i].trim());
			}
			receiptAmt = bankCashAmt;
			if (balnType.equals("Cr")) {
				bankCashAmt = bankCashAmt + Double.valueOf(accountOldBalArr[0].trim());
				balnType = "Cr";
			} else {

				bankCashAmt = Double.valueOf(accountOldBalArr[0].trim()) - bankCashAmt;
				if (bankCashAmt < 0) {
					bankCashAmt = bankCashAmt * (-1);
					balnType = "Cr";
				} else {
					balnType = "Dr";
				}

			}
			String bankCashAmtFinal = bankCashAmt + " " + balnType;
			String sqlStr = "INSERT INTO st_rm_party_txn_curr_balance_master(`party_id`,`party_balance_bef_txn`,`party_balance_aft_txn`,`date`,`txn_type`,`voucher_id`) values("
					+ partyId + ",'" + accountOldBal + "','" + bankCashAmtFinal + "','" + paymentDate + "','PAYMENT','"
					+ paymentNoVoucher + "')";
			SQLQuery query2 = session.createSQLQuery(sqlStr);
			query2.executeUpdate();

			String particularsOldBalArr[] = particularsOldBal.split(",");
			for (int i = 0; i < particularArr.length; i++) {

				if (particularArr[i] != null && !particularArr[i].isEmpty() && !particularArr[i].contains("-1")
						&& !particularArr[i].contains("none")) {

					int pId = getLedgerIdByName(particularArr[i].trim());
					String partyType = getPartyTypeById(pId);
					String particularArrArr[] = particularsOldBalArr[i].trim().split(" ");
					String parBalTyp = particularArrArr[1].trim();
					Double blncAftr = 0.0;
					if (parBalTyp.equalsIgnoreCase("Cr") && partyType.equalsIgnoreCase("Sundry debtors")) {
						blncAftr = Double.valueOf(particularArrArr[0].trim()) - receiptAmt;

						if (blncAftr < 0) {
							blncAftr = blncAftr * (-1);
							parBalTyp = "Dr";
						} else {
							parBalTyp = "Cr";
						}
					} else if (parBalTyp.equalsIgnoreCase("Dr") && partyType.equalsIgnoreCase("Sundry debtors")) {
						blncAftr = Double.valueOf(particularArrArr[0].trim()) + receiptAmt;
						parBalTyp = "Dr";

					} else if (parBalTyp.equalsIgnoreCase("Cr") && partyType.equalsIgnoreCase("Sundry creditors")) {
						blncAftr = Double.valueOf(particularArrArr[0].trim()) - receiptAmt;

						if (blncAftr < 0) {
							blncAftr = blncAftr * (-1);
							parBalTyp = "Dr";
						} else {
							parBalTyp = "Cr";
						}
					} else if (parBalTyp.equalsIgnoreCase("Dr") && partyType.equalsIgnoreCase("Sundry creditors")) {
						blncAftr = Double.valueOf(particularArrArr[0].trim()) + receiptAmt;
						parBalTyp = "Dr";
					}
					String aftrFinalBal = blncAftr + " " + parBalTyp;
					sqlStr = "INSERT INTO st_rm_party_txn_curr_balance_master(`party_id`,`party_balance_bef_txn`,`party_balance_aft_txn`,`date`,`txn_type`,`voucher_id`) values("
							+ pId + ",'" + particularsOldBalArr[i].trim() + "','" + aftrFinalBal + "','" + paymentDate
							+ "','PAYMENT','" + paymentNoVoucher + "')";
					SQLQuery query3 = session.createSQLQuery(sqlStr);
					query3.executeUpdate();
				}
			}
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean createTransactionPaymentEmp(String account, String particulars, String amount, String totAmt,
			String bankName, String txnType, String narration, int user_id, int parent_id) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			Date today = new Date();
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
			String date = df.format(today);
			String sqlString = "INSERT INTO st_rm_txn_payment_master_emp(`parent_id`,`emp_id`,`account`,`Particulars`,`amount`,`txnType`,`bank_name`,`narration`,`finalBalance`,`payment_date`) values('"
					+ parent_id + "','" + user_id + "','" + account + "','" + particulars + "','" + amount + "','"
					+ txnType + "','" + bankName + "','" + narration + "','" + totAmt + "','" + date + "')";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();

			sqlString = "SELECT max(paymentId) from st_rm_txn_payment_master_emp WHERE emp_id=" + user_id;
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<Integer> pId = query2.list();
			sqlString = "INSERT INTO payment_order_staus_alert(`emp_id`,`order_id`,`status`,`changed_by`) values("
					+ user_id + ",'" + pId.get(0) + "','pending'," + parent_id + ")";
			SQLQuery query3 = session.createSQLQuery(sqlString);
			query3.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean createTransactionReceiptEmp(String account, String particulars, String amount, String bankName,
			String txnType, String narration, int user_id, int parent_id, String totalAmt) {
		Transaction transaction = null;
		try {
			Date today = new Date();
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
			String date = df.format(today);
			int firstLevelUserId = getFirstLevelApproval(user_id);
			if (firstLevelUserId == 0)
				firstLevelUserId = parent_id;

			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sqlString = "INSERT INTO st_rm_txn_receipt_master_emp(`parent_id`,`emp_id`,`account`,`Particulars`,`amount`,`txnType`,`bank_name`,`narration`,`finalBalance`,`receipt_date`,`order_status_by`) values('"
					+ parent_id + "','" + user_id + "','" + account + "','" + particulars + "','" + amount + "','"
					+ txnType + "','" + bankName + "','" + narration + "','" + totalAmt + "','" + date + "',"
					+ firstLevelUserId + ")";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			sqlString = "SELECT max(receiptId) from st_rm_txn_receipt_master_emp WHERE emp_id=" + user_id;
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<Integer> saleId = query2.list();
			sqlString = "INSERT INTO receipt_order_staus_alert(`emp_id`,`order_id`,`status`,`changed_by`) values("
					+ user_id + ",'" + saleId.get(0) + "','pending'," + firstLevelUserId + ")";
			SQLQuery query3 = session.createSQLQuery(sqlString);

			query3.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public int getEmployeeId(String employeeUnder) {

		try {
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
			criteria.add(Restrictions.eq("userName", employeeUnder));
			List<StRmBoUserMaster> result = criteria.list();
			if (result != null || !result.isEmpty()) {
				for (StRmBoUserMaster obj : result) {
					return obj.getUserId();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getPaymentNo() {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(paymentId) from st_rm_txn_payment_master";
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public int getEmpPaymentNo() {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(paymentId) from st_rm_txn_payment_master_emp";
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public boolean createTransactionContra(String account, String employeeUnder, String currBalance, String particulars,
			String amount, String bankName, String txnType, String narration, String pcurBalance, String phcrdr) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int empId = getEmployeeId(employeeUnder);
			String sqlString = "INSERT INTO st_rm_txn_contra_master(`account`,`empId`,`currentBalance`,`Particulars`,`amount`,`txnType`,`bank_name`,`narration`,`finalBalance`) values('"
					+ account + "'," + empId + ",'" + currBalance + "','" + particulars + "','" + amount + "','"
					+ txnType + "','" + bankName + "','" + narration + "'," + currBalance + ")";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			String[] particularsArr = particulars.split(",");
			String[] pcurBalanceArr = pcurBalance.split(",");
			String[] phcrdrArr = phcrdr.split(",");
			int length = particularsArr.length;
			for (int i = 0; i < length - 1; i++) {
				sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_name='" + particularsArr[i] + "'";
				SQLQuery query1 = session.createSQLQuery(sqlString);
				List<Object[]> partyIds = query1.list();
				int partyLedgerId = 0;
				for (Object[] obj : partyIds) {
					partyLedgerId = (int) obj[0];
				}
				sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + pcurBalanceArr[i]
						+ "',balance_type='" + phcrdrArr[i] + "' WHERE party_id=" + partyLedgerId + "";
				SQLQuery query2 = session.createSQLQuery(sqlString);
				query2.executeUpdate();
			}

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getContraNo() {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(contraId) from st_rm_txn_contra_master";
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public int getReceiptNo() {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(receiptId) from st_rm_txn_receipt_master";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Integer> id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public int getReceiptNoEmp(int user_id) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(receiptId) from st_rm_txn_receipt_master_emp";
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public String createTransactionReceipt(String account, String employeeUnder, String currBalance, String particulars,
			String amount, String bankName, String txnType, String narration, String currentblnc,
			String hiddenTypeOfRef, String hiddenBillWiseName, String hiddenAmnt, String hiddenBilId,
			String receiptNoVoucher, String txn_dd_chq_no, String txn_bnkNm, String activeVoucherNumber,
			String paymentDate, String particularsBlncType, Session session, Transaction transaction,
			String accountOldBal, String particularsOldBal, String totalAmt) {

		try {
			int empId = getEmployeeId(employeeUnder);
			LocalDate date1 = LocalDate.now();
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date1.format(formatter1);
			if (paymentDate == null || paymentDate.isEmpty()) {
				paymentDate = currentDate;
			}
			String sqlString = "INSERT INTO st_rm_txn_receipt_master(`account`,`empId`,`currentBalance`,`Particulars`,`amount`,`txnType`,`bank_name`,`txn_dd_cheq_no`,`txn_bank_name`,`narration`,`totAmt`,`voucher_numbering`,`receipt_date`,`under_vcr_id`) values('"
					+ account + "'," + empId + ",'" + currBalance + "','" + particulars + "','" + amount + "','"
					+ txnType + "','" + bankName + "','" + txn_dd_chq_no + "','" + txn_bnkNm + "','" + narration + "',"
					+ totalAmt + ",'" + receiptNoVoucher + "','" + paymentDate + "'," + activeVoucherNumber + ")";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			String particularArr[] = particulars.split(",");
			String currentblncArr[] = currentblnc.split(",");
			String typeOfRefArr[] = hiddenTypeOfRef.split(",");
			String amountArr[] = amount.split(",");
			String hiddenBillWiseNameArr[] = hiddenBillWiseName.split(",");
			String hiddenAmntArr[] = hiddenAmnt.split(",");
			String particularsBlncTypeArr[] = particularsBlncType.split(",");
			String hiddenBilIdArr[] = new String[hiddenBillWiseNameArr.length];
			for (int i = 0; i < hiddenBillWiseNameArr.length; i++) {
				String TemphiddenBillWiseNameArr[] = hiddenBillWiseNameArr[i].split(" ");
				if (TemphiddenBillWiseNameArr.length > 0) {
					if (i > 0)
						hiddenBilIdArr[i] = TemphiddenBillWiseNameArr[1];
					else
						hiddenBilIdArr[i] = TemphiddenBillWiseNameArr[0];

				}
			}
			int length = particularArr.length;
			int lengthBillWise = hiddenBilIdArr.length;
			for (int i = 0; i < length - 1; i++) {
				if (particularArr[i].contains("none"))
					continue;
				String sqlString1 = "SELECT * from st_rm_acc_ledger_master where ledger_name='"
						+ particularArr[i].trim() + "'";
				SQLQuery query1 = session.createSQLQuery(sqlString1);
				List<Object[]> partyIds = query1.list();
				int partyLedgerId = 0;
				for (Object[] obj : partyIds) {
					partyLedgerId = (int) obj[0];
				}
				if (partyLedgerId == 0)
					return "Party " + particularArr[i].trim() + " Not Found!!";
				sqlString1 = "SELECT balance,balance_type FROM st_rm_purchase_party_master_balance WHERE party_id="
						+ partyLedgerId + "";
				SQLQuery queryn = session.createSQLQuery(sqlString1);
				List<Object[]> rs = queryn.list();
				String blnc_type = null;
				Double _balance = 0.0;
				for (Object[] o : rs) {
					blnc_type = o[1].toString().trim();
					_balance = Double.valueOf(o[0].toString().trim());
				}
				if (blnc_type == null)
					return "Party " + particularArr[i].trim() + " Blance Type Not Found!!";
				;
				Double blnc = _balance;
				String temp_blnc_type = "";
				if (blnc_type.equals("Dr")) {
					_balance = _balance - Double.valueOf(amountArr[i].trim());
					if (_balance < 0) {
						_balance = _balance * (-1);
						blnc_type = "Cr";
					} else
						blnc_type = "Dr";
					/*
					 * if (blnc < 0) { blnc = blnc * (-1); temp_blnc_type = ",balance_type='Cr'"; }
					 * else temp_blnc_type = ",balance_type='Dr'";
					 */

				} else if (blnc_type.equals("Cr")) {
					_balance = _balance + Double.valueOf(amountArr[i].trim());
					blnc_type = "Cr";
					// blnc_type = ",balance_type='Cr'";
				}

				sqlString1 = "UPDATE st_rm_purchase_party_master_balance SET balance='"
						+ String.format("%.2f", _balance) + "',balance_type='" + blnc_type + "' WHERE party_id="
						+ partyLedgerId + "";
				SQLQuery query2 = session.createSQLQuery(sqlString1);
				query2.executeUpdate();

				LocalDate date = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				if (!hiddenBilIdArr[0].isEmpty()) {

					for (int j = 0; j < lengthBillWise; j++) {
						String is_used = "No";
						if (typeOfRefArr[j].trim().equals("Advance") || typeOfRefArr[j].trim().equals("On Account")) {
							sqlString1 = "INSERT INTO st_rm_bill_wise_details_sale(`type_of_ref`,`party_id`,`balance`,`is_used`,`date`,`blnc_type`,`sale_voucher_number`) values('"
									+ typeOfRefArr[j].trim() + "','" + partyLedgerId + "','" + hiddenAmntArr[j].trim()
									+ "','" + is_used + "','" + date.format(formatter) + "','Cr','"
									+ hiddenBilIdArr[j].trim() + "')";
							SQLQuery query3 = session.createSQLQuery(sqlString1);
							query3.executeUpdate();
							sqlString1 = "INSERT INTO st_rm_receipt_sale_bill_mapping(`receiptVcr`,`saleVcr`,`amount`,`type_of_ref`) values('"
									+ receiptNoVoucher + "','" + hiddenBilIdArr[j].trim() + "','"
									+ hiddenAmntArr[j].trim() + "','" + typeOfRefArr[j].trim() + "')";
							query3 = session.createSQLQuery(sqlString1);
							query3.executeUpdate();

						} else {
							sqlString1 = "SELECT * FROM st_rm_bill_wise_details_sale WHERE party_id=" + partyLedgerId
									+ " and sale_voucher_number='" + hiddenBilIdArr[j].trim() + "'";
							SQLQuery query3 = session.createSQLQuery(sqlString1);
							List<Object[]> rst = query3.list();
							Double Amount = 0.0;
							if (rst != null) {
								for (Object[] obj : rst)
									Amount = Double.valueOf(obj[3].toString());
							}
							Amount = Amount - Double.valueOf(hiddenAmntArr[j].trim());
							if (Amount < 0)
								return "Multiple Same bill selected!";
							else if (Amount == 0) {
								is_used = "Yes";
							}
							sqlString1 = "UPDATE st_rm_bill_wise_details_sale SET balance='"
									+ String.format("%.2f", Amount) + "',is_used='" + is_used
									+ "' WHERE sale_voucher_number='" + hiddenBilIdArr[j].trim() + "'";
							SQLQuery query4 = session.createSQLQuery(sqlString1);
							query4.executeUpdate();
							sqlString1 = "INSERT INTO st_rm_receipt_sale_bill_mapping(`receiptVcr`,`saleVcr`,`amount`,`type_of_ref`) values('"
									+ receiptNoVoucher + "','" + hiddenBilIdArr[j].trim() + "','"
									+ hiddenAmntArr[j].trim() + "','" + typeOfRefArr[j].trim() + "')";
							query3 = session.createSQLQuery(sqlString1);
							query3.executeUpdate();

						}
					}
				}

			}
			int partyId = getLedgerIdByName(account);
			String[] accountOldBalArr = accountOldBal.split(" ");
			String balnType = accountOldBalArr[1];
			Double bankCashAmt = 0.0;
			Double receiptAmt = 0.0;
			for (int i = 0; i < amountArr.length; i++) {
				if (amountArr[i] != null && !amountArr[i].trim().isEmpty() && !amountArr[i].contains("-1")
						&& !amountArr[i].trim().equals(""))
					bankCashAmt = bankCashAmt + Double.valueOf(amountArr[i].trim());
			}
			receiptAmt = bankCashAmt;
			if (balnType.equals("Dr")) {
				bankCashAmt = bankCashAmt + Double.valueOf(accountOldBalArr[0].trim());
				balnType = "Dr";
			} else {

				bankCashAmt = Double.valueOf(accountOldBalArr[0].trim()) - bankCashAmt;
				if (bankCashAmt < 0) {
					bankCashAmt = bankCashAmt * (-1);
					balnType = "Dr";
				} else {
					balnType = "Cr";
				}

			}
			String bankCashAmtFinal = bankCashAmt + " " + balnType;
			String sqlStr = "INSERT INTO st_rm_party_txn_curr_balance_master(`party_id`,`party_balance_bef_txn`,`party_balance_aft_txn`,`date`,`txn_type`,`voucher_id`) values("
					+ partyId + ",'" + accountOldBal + "','" + bankCashAmtFinal + "','" + paymentDate + "','RECEIPT','"
					+ receiptNoVoucher + "')";
			SQLQuery query2 = session.createSQLQuery(sqlStr);
			query2.executeUpdate();

			String particularsOldBalArr[] = particularsOldBal.split(",");
			for (int i = 0; i < particularArr.length; i++) {

				if (particularArr[i] != null && !particularArr[i].isEmpty() && !particularArr[i].contains("-1")
						&& !particularArr[i].contains("none")) {

					int pId = getLedgerIdByName(particularArr[i].trim());
					String partyType = getPartyTypeById(pId);
					String particularArrArr[] = particularsOldBalArr[i].trim().split(" ");
					String parBalTyp = particularArrArr[1].trim();
					Double blncAftr = 0.0;
					if (parBalTyp.equalsIgnoreCase("Dr") && partyType.equalsIgnoreCase("Sundry debtors")) {
						blncAftr = Double.valueOf(particularArrArr[0].trim()) - receiptAmt;

						if (blncAftr < 0) {
							blncAftr = blncAftr * (-1);
							parBalTyp = "Cr";
						} else {
							parBalTyp = "Dr";
						}
					} else if (parBalTyp.equalsIgnoreCase("Cr") && partyType.equalsIgnoreCase("Sundry debtors")) {
						blncAftr = Double.valueOf(particularArrArr[0].trim()) + receiptAmt;
						parBalTyp = "Cr";

					} else if (parBalTyp.equalsIgnoreCase("Dr") && partyType.equalsIgnoreCase("Sundry creditors")) {
						blncAftr = Double.valueOf(particularArrArr[0].trim()) - receiptAmt;

						if (blncAftr < 0) {
							blncAftr = blncAftr * (-1);
							parBalTyp = "Cr";
						} else {
							parBalTyp = "Dr";
						}
					} else if (parBalTyp.equalsIgnoreCase("Cr") && partyType.equalsIgnoreCase("Sundry creditors")) {
						blncAftr = Double.valueOf(particularArrArr[0].trim()) + receiptAmt;
						parBalTyp = "Cr";
					}
					String aftrFinalBal = blncAftr + " " + parBalTyp;
					sqlStr = "INSERT INTO st_rm_party_txn_curr_balance_master(`party_id`,`party_balance_bef_txn`,`party_balance_aft_txn`,`date`,`txn_type`,`voucher_id`) values("
							+ pId + ",'" + particularsOldBalArr[i].trim() + "','" + aftrFinalBal + "','" + paymentDate
							+ "','RECEIPT','" + receiptNoVoucher + "')";
					SQLQuery query3 = session.createSQLQuery(sqlStr);
					query3.executeUpdate();
				}
			}
			return "success";
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return "Voucher number already exists!";
	}

	public int getJournalNo() {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(journalId) from st_rm_txn_journal_master";
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public String createTransactionJournal(String employeeUnder, String particulars, String cr_dr, String debitAmt,
			String creditAmt, String narration, String journalNoVoucher, String paymentDate, String activeVoucherNumber,
			Session session, Transaction transaction, String partyOldBal) {

		try {
			int empId = getEmployeeId(employeeUnder);
			LocalDate date1 = LocalDate.now();
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date1.format(formatter1);
			if (paymentDate == null || paymentDate.isEmpty()) {
				paymentDate = currentDate;
			}
			String sqlString = "INSERT INTO st_rm_txn_journal_master(`empId`,`Dr_Cr`,`particulars`,`debitAmt`,`creditAmt`,`narration`,`voucher_numbering`,`journal_date`,`under_vcr_id`) values("
					+ empId + ",'" + cr_dr + "','" + particulars + "','" + debitAmt + "','" + creditAmt + "','"
					+ narration + "','" + journalNoVoucher + "','" + paymentDate + "'," + activeVoucherNumber + ")";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			String particularsArr[] = particulars.split(",");
			String partyOldBalArr[] = partyOldBal.split(",");
			String cr_drArr[] = cr_dr.split(",");
			String debitAmtArr[] = debitAmt.split(",");
			String creditAmtArr[] = creditAmt.split(",");
			for (int i = 0; i < particularsArr.length; i++) {

				if (particularsArr[i] != null && !particularsArr[i].trim().isEmpty()) {

					int partyId = getLedgerIdByName(particularsArr[i].trim());
					String partyType = getPartyTypeById(partyId);
					String txnTyp = cr_drArr[i].trim();
					String oldBalType = partyOldBalArr[i].split(" ")[1].trim();
					Double amount = 0.0;
					String finalBalType = "";
					String POBA = "";
					if (i == 0)
						POBA = partyOldBalArr[i].split(" ")[0].trim();
					else
						POBA = partyOldBalArr[i].split(" ")[1].trim();
					if (cr_drArr[i].trim().equals("Dr") && partyType.equals("Sundry debtors")) {
						int ledgId = getLedgerIdByName(particularsArr[i].trim());
						String _tor = "Agst Ref";
						String adjustSQLString = "SELECT bill_id,balance FROM `st_rm_bill_wise_details_sale` WHERE type_of_ref!='Agst Ref' AND is_used='No' AND blnc_type ='Cr' AND party_id="
								+ ledgId;
						SQLQuery queryadjustSQL = session.createSQLQuery(adjustSQLString);
						List<Object[]> resultCrBal = queryadjustSQL.list();
						Double entryBalLeft = Double.valueOf(debitAmtArr[i].trim());

						if (resultCrBal != null && !resultCrBal.isEmpty()) {
							Double dbLeftBal = 0.0;
							String updateAdvanceBill = "";
							for (Object[] balObj : resultCrBal) {
								if (entryBalLeft <= 0.0)
									break;
								dbLeftBal = Double.valueOf(balObj[1].toString());
								if (dbLeftBal < 0.0)
									return "Negative Bill Amount Found For " + particularsArr[i].trim();
								if (dbLeftBal > entryBalLeft) {

									dbLeftBal = dbLeftBal - entryBalLeft;
									updateAdvanceBill = "update st_rm_bill_wise_details_sale set balance='" + dbLeftBal
											+ "' where bill_id=" + (int) balObj[0];
									entryBalLeft = 0.0;
								} else if (dbLeftBal == entryBalLeft) {

									dbLeftBal = dbLeftBal - Double.valueOf(debitAmtArr[i].trim());
									updateAdvanceBill = "update st_rm_bill_wise_details_sale set balance='" + dbLeftBal
											+ "',is_used='Yes' where bill_id=" + (int) balObj[0];
									entryBalLeft = 0.0;
								} else if (dbLeftBal < entryBalLeft) {

									dbLeftBal = 0.0;
									entryBalLeft = entryBalLeft - dbLeftBal;
									updateAdvanceBill = "update st_rm_bill_wise_details_sale set balance='" + dbLeftBal
											+ "',is_used='Yes' where bill_id=" + (int) balObj[0];
								}

							}

						}

						if (entryBalLeft >= 0.0) {
							SQLQuery billSQL = session.createSQLQuery(
									"INSERT INTO st_rm_bill_wise_details_sale(`type_of_ref`,`party_id`,`balance`,`is_used`,`date`,`blnc_type`,`sale_voucher_number`) values('"
											+ _tor + "'," + ledgId + ",'" + entryBalLeft + "','No','" + currentDate
											+ "','Dr','" + journalNoVoucher + "')");
							;
							billSQL.executeUpdate();

						}

						if (oldBalType.equals("Dr")) {
							amount = Double.valueOf(POBA) + Double.valueOf(debitAmtArr[i].trim());
							finalBalType = "Dr";
						} else {
							amount = Double.valueOf(POBA) - Double.valueOf(debitAmtArr[i].trim());
							if (amount < 0) {
								amount = amount * (-1);
								finalBalType = "Dr";
							}
							finalBalType = "Cr";

						}

					} else if (cr_drArr[i].trim().equals("Cr") && partyType.equals("Sundry debtors")) {
						if (oldBalType.equals("Cr")) {
							amount = Double.valueOf(POBA) + Double.valueOf(creditAmtArr[i].trim());
							finalBalType = "Cr";
						} else {
							amount = Double.valueOf(POBA) - Double.valueOf(creditAmtArr[i].trim());
							if (amount < 0) {
								amount = amount * (-1);
								finalBalType = "Cr";
							}
							finalBalType = "Dr";

						}

					}

					else if (cr_drArr[i].trim().equals("Dr") && partyType.equals("Sundry creditors")) {
						if (oldBalType.equals("Dr")) {
							amount = Double.valueOf(POBA) + Double.valueOf(debitAmtArr[i].trim());
							finalBalType = "Dr";
						} else {
							amount = Double.valueOf(POBA) - Double.valueOf(debitAmtArr[i].trim());
							if (amount < 0) {
								amount = amount * (-1);
								finalBalType = "Dr";
							}
							finalBalType = "Cr";

						}

					} else if (cr_drArr[i].trim().equals("Cr") && partyType.equals("Sundry creditors")) {
						if (oldBalType.equals("Cr")) {
							amount = Double.valueOf(POBA) + Double.valueOf(creditAmtArr[i].trim());
							finalBalType = "Cr";
						} else {
							amount = Double.valueOf(POBA) - Double.valueOf(creditAmtArr[i].trim());
							if (amount < 0) {
								amount = amount * (-1);
								finalBalType = "Cr";
							}
							finalBalType = "Dr";

						}

					} else if (cr_drArr[i].trim().equals("Dr") && partyType.equals("Expense(direct)")) {
						if (oldBalType.equals("Dr")) {
							amount = Double.valueOf(POBA) + Double.valueOf(debitAmtArr[i].trim());
							finalBalType = "Dr";
						} else {
							amount = Double.valueOf(POBA) - Double.valueOf(debitAmtArr[i].trim());
							if (amount < 0) {
								amount = amount * (-1);
								finalBalType = "Dr";
							}
							finalBalType = "Cr";

						}

					} else if (cr_drArr[i].trim().equals("Cr") && partyType.equals("Expense(direct)")) {
						if (oldBalType.equals("Cr")) {
							amount = Double.valueOf(POBA) + Double.valueOf(creditAmtArr[i].trim());
							finalBalType = "Cr";
						} else {
							amount = Double.valueOf(POBA) - Double.valueOf(creditAmtArr[i].trim());
							if (amount < 0) {
								amount = amount * (-1);
								finalBalType = "Cr";
							}
							finalBalType = "Dr";

						}

					}

					else if (cr_drArr[i].trim().equals("Dr") && partyType.equals("Expense(indirect)")) {
						if (oldBalType.equals("Dr")) {
							amount = Double.valueOf(POBA) + Double.valueOf(debitAmtArr[i].trim());
							finalBalType = "Dr";
						} else {
							amount = Double.valueOf(POBA) - Double.valueOf(debitAmtArr[i].trim());
							if (amount < 0) {
								amount = amount * (-1);
								finalBalType = "Dr";
							}
							finalBalType = "Cr";

						}

					} else if (cr_drArr[i].trim().equals("Cr") && partyType.equals("Expense(indirect)")) {
						if (oldBalType.equals("Cr")) {
							amount = Double.valueOf(POBA) + Double.valueOf(creditAmtArr[i].trim());
							finalBalType = "Cr";
						} else {
							amount = Double.valueOf(POBA) - Double.valueOf(creditAmtArr[i].trim());
							if (amount < 0) {
								amount = amount * (-1);
								finalBalType = "Cr";
							}
							finalBalType = "Dr";

						}

					}

					else if (cr_drArr[i].trim().equals("Dr") && partyType.equals("Income(indirect)")) {
						if (oldBalType.equals("Dr")) {
							amount = Double.valueOf(POBA) + Double.valueOf(debitAmtArr[i].trim());
							finalBalType = "Dr";
						} else {
							amount = Double.valueOf(POBA) - Double.valueOf(debitAmtArr[i].trim());
							if (amount < 0) {
								amount = amount * (-1);
								finalBalType = "Dr";
							}
							finalBalType = "Cr";

						}

					} else if (cr_drArr[i].trim().equals("Cr") && partyType.equals("Income(indirect)")) {
						if (oldBalType.equals("Cr")) {
							amount = Double.valueOf(POBA) + Double.valueOf(creditAmtArr[i].trim());
							finalBalType = "Cr";
						} else {
							amount = Double.valueOf(POBA) - Double.valueOf(creditAmtArr[i].trim());
							if (amount < 0) {
								amount = amount * (-1);
								finalBalType = "Cr";
							}
							finalBalType = "Dr";

						}

					}

					else if (cr_drArr[i].trim().equals("Dr") && partyType.equals("Income(direct)")) {
						if (oldBalType.equals("Dr")) {
							amount = Double.valueOf(POBA) + Double.valueOf(debitAmtArr[i].trim());
							finalBalType = "Dr";
						} else {
							amount = Double.valueOf(POBA) - Double.valueOf(debitAmtArr[i].trim());
							if (amount < 0) {
								amount = amount * (-1);
								finalBalType = "Dr";
							}
							finalBalType = "Cr";

						}

					} else if (cr_drArr[i].trim().equals("Cr") && partyType.equals("Income(direct)")) {
						if (oldBalType.equals("Cr")) {
							amount = Double.valueOf(POBA) + Double.valueOf(debitAmtArr[i].trim());
							finalBalType = "Cr";
						} else {
							amount = Double.valueOf(POBA) - Double.valueOf(debitAmtArr[i].trim());
							if (amount < 0) {
								amount = amount * (-1);
								finalBalType = "Cr";
							}
							finalBalType = "Dr";

						}

					}
					String finalBal = amount + " " + finalBalType;
					String sqlStr = "INSERT INTO st_rm_party_txn_curr_balance_master(`party_id`,`party_balance_bef_txn`,`party_balance_aft_txn`,`date`,`txn_type`,`voucher_id`) values("
							+ partyId + ",'" + partyOldBalArr[i].trim() + "','" + finalBal + "','" + paymentDate
							+ "','JOURNAL','" + journalNoVoucher + "')";
					SQLQuery query3 = session.createSQLQuery(sqlStr);
					query3.executeUpdate();

				}
			}

			return "success";

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return "Voucher Already Exists";
	}

	public int getSalesNo() {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(salesId) from st_rm_txn_sales_master";
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			System.out.println("error while getting new sales no : ignore it");
		}
		return 1;
	}

	public List<String> getSalesStockItemList() {

		List<String> response = null;
		try {
			response = new ArrayList<>();
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * from st_rm_stock_item_master ORDER BY item_name ASC";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {

				for (Object[] obj : result) {
					response.add(obj[1].toString());
				}
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public boolean createTransactionSales(String partyOldBalance, String employeeUnder, String partyAcc,
			String salesAccount, String salesStockItems, String amount, String qty, String rate, String narration,
			String salesNoVoucher, String consignee, String Dname, String propName, String contact, String address,
			String gstnNo, String ddn, String tn, String des, String billt, String vn, String transportFreight,
			String saleDate, String activeVoucherNumber, String totalAmt, String godown, String batch, Session session,
			Transaction transaction) {

		try {
			int empId = getEmployeeId(employeeUnder);
			int partyId = getLedgerIdByName(partyAcc);
			String sqlString = "SELECT voucher_numbering from st_rm_txn_sales_master";
			SQLQuery query1 = session.createSQLQuery(sqlString);
			List<String> list = query1.list();
			if (list != null && !list.isEmpty()) {

				if (list.contains(salesNoVoucher)) {
					return false;
				}
			}
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date.format(formatter);
			if (saleDate == null || saleDate.isEmpty()) {
				saleDate = currentDate;
			}
			sqlString = "INSERT INTO st_rm_txn_sales_master(`party_acc_name`,`emp_id`,`sales_ledger`,`name_item`,`actual_qty`,`rate`,`amount`,`narration`,`totalAmt`,`voucher_numbering`,`is_consignee`,`dealer_name`,`prop_name`,`contact`,`address`,`gstnNo`,`saleDate`,`dispatch_doc_no`,`tansport_name`,`destination`,`bill_t_no`,`vehicle_no`,`transport_fright`,`under_vcr_id`,`item_godown`,`item_batch`) values('"
					+ partyAcc + "'," + empId + ",'" + salesAccount + "','" + salesStockItems + "','" + qty + "','"
					+ rate + "','" + amount + "','" + narration + "','" + totalAmt + "','" + salesNoVoucher + "','"
					+ consignee + "','" + Dname + "','" + propName + "','" + contact + "','" + address + "','" + gstnNo
					+ "','" + saleDate + "','" + ddn + "','" + tn + "','" + des + "','" + billt + "','" + vn + "','"
					+ transportFreight + "'," + activeVoucherNumber + ",'" + godown + "','" + batch + "')";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			String[] balnArr = partyOldBalance.split(" ");
			Double afterTxnBal = 0.0;
			String blncType = "";
			if (balnArr[1].equalsIgnoreCase("Dr")) {
				afterTxnBal = Double.valueOf(balnArr[0]) + Double.valueOf(totalAmt);
				blncType = "Dr";
			} else {
				afterTxnBal = Double.valueOf(balnArr[0]) - Double.valueOf(totalAmt);
				if (afterTxnBal < 0) {
					afterTxnBal = afterTxnBal * (-1);
					blncType = "Dr";
				} else
					blncType = "Cr";
			}
			String aftTxn = afterTxnBal + " " + blncType;
			sqlString = "INSERT INTO st_rm_party_txn_curr_balance_master(`party_id`,`party_balance_bef_txn`,`party_balance_aft_txn`,`date`,`txn_type`,`voucher_id`) values("
					+ partyId + ",'" + partyOldBalance + "','" + aftTxn + "','" + saleDate + "','SALE','"
					+ salesNoVoucher + "')";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			query2.executeUpdate();

			int salesAccountId = getLedgerIdByName(salesAccount);

			String salesAccountsqlString = "SELECT * from st_rm_purchase_party_master_balance where party_id="
					+ salesAccountId + "";
			SQLQuery salesAccountquery = session.createSQLQuery(salesAccountsqlString);
			List<Object[]> salesAccountresult = salesAccountquery.list();
			Double dbBalance = 0.0;
			String dbBalanceType = "";
			Double finalBal = 0.0;
			String finalBalType = "";
			if (salesAccountresult != null && !salesAccountresult.isEmpty()) {
				for (Object[] obj : salesAccountresult) {
					dbBalance = Double.valueOf(obj[2].toString());
					dbBalanceType = obj[3].toString();
					finalBal = dbBalance;
				}

			}
			if (dbBalanceType.trim().equalsIgnoreCase("Cr")) {
				finalBal = finalBal + Double.valueOf(totalAmt);
				finalBalType = "Dr";

			} else if (dbBalanceType.trim().equalsIgnoreCase("Dr")) {
				finalBal = finalBal - Double.valueOf(totalAmt);
				if (finalBal < 0.0) {
					finalBal = finalBal * (-1);
					finalBalType = "Cr";
				} else
					finalBalType = "Dr";

			} else {
				return false;
			}

			String salesAccountIdsqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + finalBal
					+ "',balance_type='" + finalBalType + "' WHERE party_id=" + salesAccountId + "";
			SQLQuery salesAccountIdquery2 = session.createSQLQuery(salesAccountIdsqlString);
			salesAccountIdquery2.executeUpdate();

			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public int getPurchaseNo() {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(purchaseId) from st_rm_txn_purchase_master";
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public int getEmpPurchaseNo(int user_id) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(purchaseId) from st_rm_txn_purchase_master_emp where emp_id=" + user_id;
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public boolean createTransactionPurchase(String partyOldBalance, String employeeUnder, String partyAcc,
			String salesAccount, String salesStockItems, String amount, String qty, String rate, String narration,
			String purchaseNoVoucher, String consignee, String Dname, String propName, String contact, String address,
			String gstnNo, String ddn, String tn, String des, String billt, String vn, String transportFreight,
			String saleDate, String activeVoucherNumber, String totAmt, String godown, String batch, Session session,
			Transaction transaction) {

		try {
			int empId = getEmployeeId(employeeUnder);
			int partyId = getLedgerIdByName(partyAcc);

			String sqlString = "SELECT voucher_numbering from st_rm_txn_purchase_master";
			SQLQuery query1 = session.createSQLQuery(sqlString);
			List<String> list = query1.list();
			if (list != null && !list.isEmpty()) {

				if (list.contains(purchaseNoVoucher)) {
					return false;
				}
			}
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date.format(formatter);
			if (saleDate == null || saleDate.isEmpty()) {
				saleDate = currentDate;
			}

			sqlString = "INSERT INTO st_rm_txn_purchase_master(`party_acc_name`,`emp_id`,`purchase_ledger`,`name_item`,`actual_qty`,`rate`,`amount`,`narration`,`totalAmt`,`voucher_numbering`,`is_consignee`,`dealer_name`,`prop_name`,`contact`,`address`,`gstnNo`,`purchaseDate`,`dispatch_doc_no`,`tansport_name`,`destination`,`bill_t_no`,`vehicle_no`,`transport_fright`,`under_vcr_id`,`item_godown`,`item_batch`) values('"
					+ partyAcc + "'," + empId + ",'" + salesAccount + "','" + salesStockItems + "','" + qty + "','"
					+ rate + "','" + amount + "','" + narration + "','" + totAmt + "','" + purchaseNoVoucher + "','"
					+ consignee + "','" + Dname + "','" + propName + "','" + contact + "','" + address + "','" + gstnNo
					+ "','" + saleDate + "','" + ddn + "','" + tn + "','" + des + "','" + billt + "','" + vn + "','"
					+ transportFreight + "'," + activeVoucherNumber + ",'" + godown + "','" + batch + "')";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();

			String[] balnArr = partyOldBalance.split(" ");
			Double afterTxnBal = 0.0;
			String blncType = "";
			if (balnArr[1].equalsIgnoreCase("Cr")) {
				afterTxnBal = Double.valueOf(balnArr[0]) + Double.valueOf(totAmt);
				blncType = "Cr";
			} else {
				afterTxnBal = Double.valueOf(balnArr[0]) - Double.valueOf(totAmt);
				if (afterTxnBal < 0) {
					afterTxnBal = afterTxnBal * (-1);
					blncType = "Cr";
				} else
					blncType = "Dr";
			}
			String aftTxn = afterTxnBal + " " + blncType;
			sqlString = "INSERT INTO st_rm_party_txn_curr_balance_master(`party_id`,`party_balance_bef_txn`,`party_balance_aft_txn`,`date`,`txn_type`,`voucher_id`) values("
					+ partyId + ",'" + partyOldBalance + "','" + aftTxn + "','" + saleDate + "','PURCHASE','"
					+ purchaseNoVoucher + "')";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			query2.executeUpdate();

			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean createEmpTransactionPurchase(String referenceNo, String employeeUnder, String partyAcc,
			String salesAccount, String salesStockItems, String amount, String qty, String rate, String narration,
			int user_id, int parent_id, String finalBal, String consignee, String dname, String propName,
			String contact, String address, String gstnNo) {

		try {
			Session session = HibernateSessionFactory.getSession();
			Date today = new Date();
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
			String date = df.format(today);
			String sqlString = "INSERT INTO st_rm_txn_purchase_master_emp(`party_acc_name`,`parent_id`,`emp_id`,`purchase_ledger`,`name_item`,`actual_qty`,`rate`,`amount`,`narration`,`reference_no`,`finalBalance`,`is_consignee`,`dealer_name`,`prop_name`,`contact`,`address`,`gstnNo`,`pur_order_date`) values('"
					+ partyAcc + "'," + parent_id + "," + user_id + ",'" + salesAccount + "','" + salesStockItems
					+ "','" + qty + "','" + rate + "','" + amount + "','" + narration + "','" + referenceNo + "','"
					+ finalBal + "','" + consignee + "','" + dname + "','" + propName + "','" + contact + "','"
					+ address + "','" + gstnNo + "','" + date + "')";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			sqlString = "SELECT max(purchaseId) from st_rm_txn_purchase_master_emp WHERE emp_id=" + user_id;
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<Integer> purId = query2.list();
			sqlString = "INSERT INTO purchase_order_staus_alert(`emp_id`,`order_id`,`status`,`changed_by`) values("
					+ user_id + ",'" + purId.get(0) + "','pending'," + parent_id + ")";
			SQLQuery query3 = session.createSQLQuery(sqlString);
			query3.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getEmpCreditNoteNo(int user_id) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(cnId) from st_rm_txn_creditNote_master_emp where emp_id=" + user_id;
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public int getEmpDebitNoteNo(int user_id) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(dnId) from st_rm_txn_debitNote_master_emp where emp_id=" + user_id;
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public boolean createEmpTransactionCreditNote(String referenceNo, String employeeUnder, String partyAcc,
			String salesAccount, String salesStockItems, String amount, String qty, String rate, String narration,
			int user_id, int parent_id, String totalBalance, String consignee, String dname, String propName,
			String contact, String address, String gstnNo, String tn) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();

			transaction = session.beginTransaction();
			Date today = new Date();
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
			String date = df.format(today);
			int firstLevelUserId = getFirstLevelApproval(user_id);
			if (firstLevelUserId == 0)
				firstLevelUserId = parent_id;

			String sqlString = "INSERT INTO st_rm_txn_creditNote_master_emp(`party_acc_name`,`parent_id`,`emp_id`,`name_item`,`actual_qty`,`rate`,`amount`,`narration`,`reference_no`,`finalBalance`,`transport_name`,`creditNote_date`,`is_consignee`,`dealer_name`,`prop_name`,`contact`,`address`,`gstn_no`,`order_status_by`) values('"
					+ partyAcc + "'," + parent_id + "," + user_id + ",'" + salesStockItems + "','" + qty + "','" + rate
					+ "','" + amount + "','" + narration + "','" + referenceNo + "','" + totalBalance + "','" + tn
					+ "','" + date + "','" + consignee + "','" + dname + "','" + propName + "','" + contact + "','"
					+ address + "','" + gstnNo + "'," + firstLevelUserId + ")";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			sqlString = "SELECT max(cnId) from st_rm_txn_creditNote_master_emp WHERE emp_id=" + user_id;
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<Integer> cId = query2.list();
			sqlString = "INSERT INTO creditNote_order_staus_alert(`emp_id`,`order_id`,`status`,`changed_by`) values("
					+ user_id + ",'" + cId.get(0) + "','pending'," + firstLevelUserId + ")";
			SQLQuery query3 = session.createSQLQuery(sqlString);
			query3.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean createEmpTransactionDeditNote(String referenceNo, String employeeUnder, String partyAcc,
			String salesAccount, String salesStockItems, String amount, String qty, String rate, String narration,
			int user_id, int parent_id, String totAmt) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "INSERT INTO st_rm_txn_debitNote_master_emp(`party_acc_name`,`parent_id`,`emp_id`,`purchase_ledger`,`name_item`,`actual_qty`,`rate`,`amount`,`narration`,`reference_no`,`finalBalance`) values('"
					+ partyAcc + "'," + parent_id + "," + user_id + ",'" + salesAccount + "','" + salesStockItems
					+ "','" + qty + "','" + rate + "','" + amount + "','" + narration + "','" + referenceNo + "','"
					+ totAmt + "')";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			int purId = getEmpPurchaseNo(user_id);

			purId = purId + 1;
			sqlString = "INSERT INTO bo_um_emp_debitnote_num_master(`emp_id`,`dn_id`) values(" + user_id + "," + purId
					+ ")";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getCreditNoteNo() {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(cnId) from st_rm_txn_creditNote_master";
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public int getCreditNoteNoEmp(int user_id) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(cnId) from st_rm_txn_creditNote_master_emp WHERE emp_id=" + user_id;
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public int getDebitNoteNo() {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(dnId) from st_rm_txn_debitNote_master";
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public int getDebitNoteNoEmp(int user_id) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(dnId) from st_rm_txn_debitNote_master_emp WHERE emp_id=" + user_id;
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public boolean createTransactionDebitNote(String referenceNo, String employeeUnder, String partyAcc,
			String salesAccount, String salesStockItems, String amount, String qty, String rate, String narration,
			String dnNoVoucher) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			int empId = getEmployeeId(employeeUnder);
			String sqlString = "INSERT INTO st_rm_txn_debitNote_master(`party_acc_name`,`emp_id`,`purchase_ledger`,`name_item`,`actual_qty`,`rate`,`amount`,`narration`,`original_invoice_no`,`voucher_numbering`) values('"
					+ partyAcc + "'," + empId + ",'" + salesAccount + "','" + salesStockItems + "','" + qty + "','"
					+ rate + "','" + amount + "','" + narration + "','" + referenceNo + "','" + dnNoVoucher + "')";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public String getUnitByItemName(String var) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * FROM st_rm_stock_item_master WHERE item_name='" + var + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result)
					if (!obj[4].toString().equals("Not Applicable")) {
						return obj[4].toString();
					}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getAlternateUnitByItemName(String var) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT item_unit_id FROM st_rm_stock_item_master WHERE item_name='" + var + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Integer> result = query.list();
			int id = result.get(0);
			sqlString = "SELECT is_alternate,conversion_from,from_unit,conversion_to,to_unit from st_rm_stock_item_unit_master where item_unit_id="
					+ id;
			SQLQuery query1 = session.createSQLQuery(sqlString);
			List<Object[]> result1 = query1.list();
			if (result1 != null && result1.size() > 0) {
				for (Object[] obj : result1) {
					if (obj[0].toString().equalsIgnoreCase("Not Applicable")) {
						return "";
					} else {
						return obj[1].toString() + ";" + obj[2].toString() + ";" + obj[3].toString() + ";"
								+ obj[4].toString();
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public boolean updateTransactionPartyBalance(String partyAcc, String currBalance, String hcrdr, Session session,
			Transaction transaction) {

		try {
			String sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_name='" + partyAcc + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			int partyLedgerId = 0;
			for (Object[] obj : partyIds) {
				partyLedgerId = (int) obj[0];
			}

			String append = "";
			if (hcrdr != null && !hcrdr.isEmpty()) {
				append = ",balance_type='" + hcrdr + "'";
			}
			sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + String.valueOf(currBalance) + "' "
					+ append + " WHERE party_id=" + partyLedgerId + "";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			query2.executeUpdate();

			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public String getPartyBalanceByName(String partyAcc) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_name='" + partyAcc + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			int partyLedgerId = 0;
			for (Object[] obj : partyIds) {
				partyLedgerId = (int) obj[0];
			}
			sqlString = "SELECT * FROM st_rm_purchase_party_master_balance WHERE party_id=" + partyLedgerId + "";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<Object[]> rs = query2.list();
			if ((rs != null || !rs.isEmpty()) && rs.size() > 0) {
				for (Object[] obj : rs) {
					return obj[2].toString() + "," + obj[3].toString();
				}
			} else {
				int currBalance = 0;
				sqlString = "INSERT INTO st_rm_purchase_party_master_balance(`party_id`,`balance`) values("
						+ partyLedgerId + ",'" + currBalance + "')";
				SQLQuery query3 = session.createSQLQuery(sqlString);
				query3.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}

	public Map<String, Double> getTaxesByItemName(String itemName) {

		try {
			Map<String, Double> map = new HashMap<>();
			Session session = HibernateSessionFactory.getSession();
			String queryString = "SELECT alter_gst_id from st_rm_stock_item_master WHERE item_name='" + itemName + "'";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Integer> result = query.list();
			Integer id = 0;
			if (result != null || !result.isEmpty()) {
				for (Integer i : result)
					id = i;
			}
			if (id != null && id > 0) {
				queryString = "SELECT * FROM st_rm_stock_gst_master WHERE gst_id=" + id + "";
				SQLQuery query2 = session.createSQLQuery(queryString);
				List<Object[]> response = query2.list();
				if (response != null || !response.isEmpty()) {
					for (Object[] obj : response) {
						map.put("IGST", (Double) obj[1]);
						map.put("CGST", (Double) obj[2]);
						map.put("SGST", (Double) obj[3]);
						map.put("cess", (Double) obj[4]);

					}
					return map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkForBillByBill(String billByBill) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_name='" + billByBill + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			int partyLedgerId = 0;
			for (Object[] obj : partyIds) {
				partyLedgerId = (int) obj[0];
			}
			sqlString = "SELECT * from st_rm_credit_limit WHERE ledger_id=" + partyLedgerId
					+ " and blnc_bill_by_bill='Yes'";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<Object[]> result = query2.list();
			if (result != null && !result.isEmpty()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateOrCreateStock(String salesStockItems, String goDown, String qty, String unit,
			String hiddenBatchNumber, String hiddenMfgDate, String hiddenExpDate, String hiddenExpAlert,
			String hiddenExpAlertDate, Session session, Transaction transaction) {

		try {
			String[] stockItemArray = salesStockItems.split(",");
			String[] goDownArray = goDown.split(",");
			String[] qtyArray = qty.split(",");
			String[] unitArray = unit.split(",");
			String[] batchArray = hiddenBatchNumber.split(",");
			String[] MfgArray = hiddenMfgDate.split(",");
			String[] ExpArray = hiddenExpDate.split(",");
			String[] alertArray = hiddenExpAlert.split(",");
			String[] alertDateArray = hiddenExpAlertDate.split(",");

			int length = stockItemArray.length;
			for (int i = 0; i < length; i++) {
				if (stockItemArray[i].trim().equals("-1"))
					continue;
				String sqlString = "SELECT st_it_id FROM st_rm_stock_item_master WHERE item_name='"
						+ stockItemArray[i].trim() + "'";
				SQLQuery query = session.createSQLQuery(sqlString);
				List<Integer> itemIdResult = query.list();
				Integer itemId = itemIdResult.get(0);

				sqlString = "SELECT gd_id FROM st_rm_Godown_master WHERE name='" + goDownArray[i].trim() + "'";
				query = session.createSQLQuery(sqlString);
				List<Integer> godownResult = query.list();
				Integer godown = godownResult.get(0);

				sqlString = "SELECT availableQty FROM st_rm_item_qty_godown WHERE godown_id=" + godown + " and item_id="
						+ itemId + " and batch='" + batchArray[i].trim() + "'";
				query = session.createSQLQuery(sqlString);
				List<String> qtyresult = query.list();
				Double finalQty1 = 0.0;

				String finalQty = "0.0";

				if (qtyresult != null && qtyresult.size() > 0)
					finalQty = qtyresult.get(0);
				if (!qtyArray[i].trim().isEmpty() && qtyArray[i].trim() != null)
					finalQty1 = Double.valueOf(finalQty) + Double.valueOf(qtyArray[i].trim());

				sqlString = "SELECT batch FROM st_rm_item_qty_godown WHERE godown_id=" + godown + " and item_id="
						+ itemId + " and batch='" + batchArray[i].trim() + "'";
				query = session.createSQLQuery(sqlString);
				List<String> batchresult = query.list();
				if (!batchresult.isEmpty() && batchresult.size() > 0 && batchresult != null) {
					sqlString = "UPDATE st_rm_item_qty_godown SET unit ='" + unitArray[i].trim() + "',batch='"
							+ batchArray[i].trim() + "',mfg='" + MfgArray[i].trim() + "',exp='" + ExpArray[i].trim()
							+ "',is_alert='" + alertArray[i].trim() + "',alert_date='" + alertDateArray[i].trim()
							+ "',availableQty='" + finalQty1 + "' WHERE item_id=" + itemId + " and godown_id=" + godown
							+ " and batch='" + batchArray[i].trim() + "'";
					query = session.createSQLQuery(sqlString);
				} else {
					sqlString = "INSERT INTO st_rm_item_qty_godown(`item_id`,`godown_id`,`unit`,`availableQty`,`batch`,`mfg`,`exp`,`is_alert`,`alert_date`) values("
							+ itemId + "," + godown + ",'" + unitArray[i].trim() + "','" + finalQty1 + "','"
							+ batchArray[i].trim() + "','" + MfgArray[i].trim() + "','" + ExpArray[i].trim() + "','"
							+ alertArray[i].trim() + "','" + alertDateArray[i].trim() + "')";
					query = session.createSQLQuery(sqlString);

				}

				query.executeUpdate();

			}
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public String TotalQtyFromGoDown(String itemName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT st_it_id FROM st_rm_stock_item_master WHERE item_name='" + itemName + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Integer> itemIdResult = query.list();
			Integer itemId = itemIdResult.get(0);
			sqlString = "SELECT availableQty from  st_rm_item_qty_godown WHERE item_id=" + itemId + "";
			query = session.createSQLQuery(sqlString);
			List<String> rs = query.list();
			Double totalQty = 0.0;
			for (String obj : rs) {
				totalQty = Double.valueOf(totalQty) + Double.valueOf(obj);
			}
			return String.valueOf(totalQty);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String TotalQtyFromGoDownByName(String goDown, String itemName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT gd_id FROM st_rm_Godown_master WHERE name='" + goDown + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Integer> IdResult = query.list();
			Integer Id = IdResult.get(0);
			sqlString = "SELECT st_it_id FROM st_rm_stock_item_master WHERE item_name='" + itemName + "'";
			query = session.createSQLQuery(sqlString);
			List<Integer> itemResult = query.list();
			Integer itemId = itemResult.get(0);

			sqlString = "SELECT availableQty from  st_rm_item_qty_godown WHERE godown_id=" + Id + " and item_id="
					+ itemId + "";
			query = session.createSQLQuery(sqlString);
			List<String> rs = query.list();
			Double totalQty = 0.0;
			for (String obj : rs) {
				totalQty = Double.valueOf(totalQty) + Double.valueOf(obj);
			}
			return String.valueOf(totalQty);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public boolean updateOrCreateStockSale(String salesStockItems, String goDown, String qty, String unit,
			String hiddenBatchNumber, String hiddenMfgDate, String hiddenExpDate, String hiddenExpAlert,
			String hiddenExpAlertDate, String hiddenBatchApplicable, Session session, Transaction transaction) {

		try {
			String[] stockItemArray = salesStockItems.split(",");
			String[] goDownArray = goDown.split(",");
			String[] qtyArray = qty.split(",");
			String[] unitArray = unit.split(",");
			String[] batchArray = hiddenBatchNumber.split(",");
			String[] MfgArray = hiddenMfgDate.split(",");
			String[] ExpArray = hiddenExpDate.split(",");
			String[] alertArray = hiddenExpAlert.split(",");
			String[] alertDateArray = hiddenExpAlertDate.split(",");
			String[] hiddenBatchApplicableArr = hiddenBatchApplicable.split(",");
			int length = stockItemArray.length;
			for (int i = 0; i < length; i++) {
				if (!stockItemArray[i].trim().equals("-1") && !stockItemArray[i].trim().equals(" ")
						&& !stockItemArray[i].trim().isEmpty()) {

					String sqlString = "SELECT st_it_id FROM st_rm_stock_item_master WHERE item_name='"
							+ stockItemArray[i].trim() + "'";
					SQLQuery query = session.createSQLQuery(sqlString);
					List<Integer> itemIdResult = query.list();
					Integer itemId = itemIdResult.get(0);

					sqlString = "SELECT gd_id FROM st_rm_Godown_master WHERE name='" + goDownArray[i].trim() + "'";
					query = session.createSQLQuery(sqlString);
					List<Integer> godownResult = query.list();
					Integer godown = godownResult.get(0);

					sqlString = "SELECT availableQty FROM st_rm_item_qty_godown WHERE godown_id=" + godown
							+ " and item_id=" + itemId + "";
					query = session.createSQLQuery(sqlString);
					List<String> qtyresult = query.list();
					String finalQty1 = "0";
					Double finalQty = 0.0;
					if (qtyresult != null && qtyresult.size() > 0)
						finalQty1 = qtyresult.get(0);
					if (!qtyArray[i].trim().isEmpty() && qtyArray[i].trim() != null)
						finalQty = Double.valueOf(finalQty1) - Double.valueOf(qtyArray[i].trim());
					if (hiddenBatchApplicableArr[i].trim().equals("No")) {
						sqlString = "UPDATE st_rm_item_qty_godown SET availableQty=" + finalQty + " where item_id="
								+ itemId + " and godown_id=" + godown;
						SQLQuery query2 = session.createSQLQuery(sqlString);
						query2.executeUpdate();
					} else {
						sqlString = "SELECT batch FROM st_rm_item_qty_godown WHERE godown_id=" + godown
								+ " and item_id=" + itemId + " and batch='" + batchArray[i].trim() + "'";
						query = session.createSQLQuery(sqlString);
						List<String> batchresult = query.list();

						if (!batchresult.isEmpty() && batchresult.size() > 0 && batchresult != null) {
							sqlString = "UPDATE st_rm_item_qty_godown SET unit ='" + unitArray[i].trim() + "',batch='"
									+ batchArray[i].trim() + "',mfg='" + MfgArray[i].trim() + "',exp='"
									+ ExpArray[i].trim() + "',is_alert='" + alertArray[i].trim() + "',alert_date='"
									+ alertDateArray[i].trim() + "',availableQty=" + finalQty + " WHERE item_id="
									+ itemId + " and godown_id=" + godown + " and batch='" + batchArray[i].trim() + "'";
							query = session.createSQLQuery(sqlString);
						} else {
							sqlString = "INSERT INTO st_rm_item_qty_godown(`item_id`,`godown_id`,`unit`,`availableQty`,`batch`,`mfg`,`exp`,`is_alert`,`alert_date`) values("
									+ itemId + "," + godown + ",'" + unitArray[i].trim() + "'," + finalQty + ",'"
									+ batchArray[i].trim() + "','" + MfgArray[i].trim() + "','" + ExpArray[i].trim()
									+ "','" + alertArray[i].trim() + "','" + alertDateArray[i].trim() + "')";
							query = session.createSQLQuery(sqlString);

						}

						query.executeUpdate();
					}

				}
			}
			return true;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean insert_st_rm_stock_item_godown_opening_blc(String stockItemName, String itemGodown, String itemBatch,
			String mfg, String exp, String itemQty, String rate, String openingBalance, String stockItemUnit,
			Session session, Transaction transaction) {
		try {
			String sqlString = "Select st_it_id from st_rm_stock_item_master Where item_name='" + stockItemName + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Integer> result = query.list();
			Integer item_id = result.get(0);
			if (itemGodown == null || itemGodown.equals("") || itemGodown.isEmpty() || itemGodown.trim().equals("-1")) {
				itemGodown = "Primary";
			}
			sqlString = "select gd_id from st_rm_Godown_master where name = '" + itemGodown + "'";
			query = session.createSQLQuery(sqlString);
			List<Integer> godown_result = query.list();
			Integer gd_id = godown_result.get(0);
			sqlString = "insert into st_rm_stock_item_godown_opening_blc(`item_id`,`godown_id`,`batch_id`,`mfg_date`,`exp_date`,`quantity`,`rate`,`opening_amt`) values("
					+ item_id + "," + gd_id + ",'" + itemBatch + "','" + mfg + "','" + exp + "','" + itemQty + "','"
					+ rate + "','" + openingBalance + "')";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			query2.executeUpdate();

			sqlString = "insert into st_rm_item_qty_godown(`item_id`,`godown_id`,`availableQty`,`unit`,`batch`,`mfg`,`exp`) values("
					+ item_id + "," + gd_id + ",'" + itemQty + "','" + stockItemUnit + "','" + itemBatch + "','" + mfg
					+ "','" + exp + "')";
			SQLQuery query3 = session.createSQLQuery(sqlString);
			query3.executeUpdate();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public String TotalBatchesFromGoDownByName(String goDown, String itemName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT gd_id FROM st_rm_Godown_master WHERE name='" + goDown + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Integer> IdResult = query.list();
			Integer Id = IdResult.get(0);
			sqlString = "SELECT st_it_id FROM st_rm_stock_item_master WHERE item_name='" + itemName + "'";
			query = session.createSQLQuery(sqlString);
			List<Integer> itemResult = query.list();
			Integer itemId = itemResult.get(0);

			sqlString = "SELECT batch from  st_rm_item_qty_godown WHERE godown_id=" + Id + " and item_id=" + itemId
					+ "";
			query = session.createSQLQuery(sqlString);
			List<String> rs = query.list();
			String totalQty = "";
			for (String obj : rs) {
				if (!obj.isEmpty() && obj != null)
					totalQty = totalQty + "," + obj;
			}
			return String.valueOf(totalQty);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String TotalBatchesDtFromGoDownByName(String goDown, String itemName, String hiddenBatchNumber) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT gd_id FROM st_rm_Godown_master WHERE name='" + goDown + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Integer> IdResult = query.list();
			Integer Id = IdResult.get(0);
			sqlString = "SELECT st_it_id FROM st_rm_stock_item_master WHERE item_name='" + itemName + "'";
			query = session.createSQLQuery(sqlString);
			List<Integer> itemResult = query.list();
			Integer itemId = itemResult.get(0);

			sqlString = "SELECT * from  st_rm_item_qty_godown WHERE godown_id=" + Id + " and item_id=" + itemId
					+ " and batch='" + hiddenBatchNumber + "'";
			query = session.createSQLQuery(sqlString);
			List<Object[]> rs = query.list();
			String result = "";
			for (Object[] obj : rs) {
				result = obj[6].toString() + "," + obj[7].toString() + "," + obj[4].toString();
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public List<String> getBankNameList() {

		List<String> response = null;
		try {
			response = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * FROM st_rm_acc_ledger_master WHERE ledger_under_group_name IN('Bank occ a/c','Bank Account','Bank od a/c')";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null) {
				for (Object[] obj : result)
					response.add(obj[1].toString());
				return response;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public int InitialBalace(String openingDate, String openingBalance, String cr_Dr, String ledgerName,
			String groupUnder) {

		try {
			Session session = HibernateSessionFactory.getSession();
			if (openingDate == null || openingDate.isEmpty()) {
				LocalDate date = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				openingDate = date.format(formatter);
			}
			if (openingBalance == null || openingBalance.isEmpty()) {
				openingBalance = "0";
			}
			String sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_name='" + ledgerName + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			int partyLedgerId = 0;
			for (Object[] obj : partyIds) {
				partyLedgerId = (int) obj[0];
			}
			if (groupUnder.equals("Sundry creditors") || groupUnder.equals("Loans(liabilities)")
					|| groupUnder.equals("Bank od a/c") || groupUnder.equals("Capital account")
					|| groupUnder.equals("Branch/Division") || groupUnder.equals("Suspense account")
					|| groupUnder.equals("Provision") || groupUnder.equals("Bank occ a/c")
					|| groupUnder.equals("Current liabilities") || groupUnder.equals("Duties & taxes")
					|| groupUnder.equals("Duties & taxes") || groupUnder.equals("Income(indirect)")
					|| groupUnder.equals("Income(direct)") || groupUnder.equals("Sales account")
					|| groupUnder.equals("Reserves & surplus") || groupUnder.equals("Retained earning")
					|| groupUnder.equals("Secured loans") || groupUnder.equals("Unsecured Loans"))
				cr_Dr = "Cr";
			else
				cr_Dr = "Dr";
			sqlString = "INSERT INTO st_rm_purchase_party_master_balance(`party_id`,`balance`,`balance_type`,`opening_date`,`opening_balnc`,`opening_blnc_type`) values("
					+ partyLedgerId + ",'" + openingBalance + "','" + cr_Dr + "','" + openingDate + "','"
					+ openingBalance + "','" + cr_Dr + "')";
			SQLQuery query1 = session.createSQLQuery(sqlString);
			query1.executeUpdate();

			if (groupUnder.equalsIgnoreCase("Sundry debtors")) {

				query = session.createSQLQuery(
						"INSERT INTO st_rm_bill_wise_details_sale(`type_of_ref`,`party_id`,`balance`,`is_used`,`date`,`blnc_type`,`purchase_used`,`sale_voucher_number`,`tax_amount`) values('Agst Ref',"
								+ partyLedgerId + ",'" + openingBalance + "','No','" + openingDate + "','" + cr_Dr
								+ "','No','JSC/OPENING/BAL/" + partyLedgerId + "','0')");
				query.executeUpdate();
				String b = openingBalance + " " + cr_Dr;
				query = session.createSQLQuery(
						"INSERT INTO st_rm_party_txn_curr_balance_master(`party_id`,`party_balance_bef_txn`,`party_balance_aft_txn`,`date`,`txn_type`,`voucher_id`) values("
								+ partyLedgerId + ",'" + b + "','" + b + "','" + openingDate
								+ "','OPENING','JSC/OPENING/BAL/" + partyLedgerId + "')");
				query.executeUpdate();

			} else if (groupUnder.equalsIgnoreCase("Sundry creditors")) {

				query = session.createSQLQuery(
						"INSERT INTO st_rm_bill_wise_details(`type_of_ref`,`party_id`,`balance`,`is_used`,`date`,`blnc_type`,`purchase_used`,`purchase_voucher_number`,`tax_amount`) values('Agst Ref',"
								+ partyLedgerId + ",'" + openingBalance + "','No','" + openingDate + "','" + cr_Dr
								+ "','No','JSC/OPENING/BAL/" + partyLedgerId + "','0')");
				query.executeUpdate();
				String b = openingBalance + " " + cr_Dr;
				query = session.createSQLQuery(
						"INSERT INTO st_rm_party_txn_curr_balance_master(`party_id`,`party_balance_bef_txn`,`party_balance_aft_txn`,`date`,`txn_type`,`voucher_id`) values("
								+ partyLedgerId + ",'" + b + "','" + b + "','" + openingDate
								+ "','OPENING','JSC/OPENING/BAL')");
				query.executeUpdate();
			}

			return partyLedgerId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean insertCalculateInterest(String ledgerName, String txnByTxn, String intesestBasedOn,
			String foramtAdded, String foramtDeduct, String rate, String ratePer, String rateOn,
			String intersetCalculationApplicability, String intersetCalculationApplicabilityDays,
			String intersetCalculationFrom) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "select ledger_id from st_rm_acc_ledger_master WHERE ledger_name='" + ledgerName + "'";
			SQLQuery query2 = session.createSQLQuery(queryString);
			List<Integer> result = query2.list();
			Integer Ledger_id = result.get(0);
			queryString = "INSERT INTO st_rm_ledger_interset_calculation(`ledger_id`,`txn_by_txn`,`interest_based_on`,`amt_added`,`amt_deduct`,`rate`,`rate_per`,`rate_on`,`applicability`,`days`,`calculate_from`) values("
					+ Ledger_id + ",'" + txnByTxn + "','" + foramtAdded + "','" + foramtDeduct + "'," + rate + ",'"
					+ ratePer + "','" + rateOn + "','" + intersetCalculationApplicability + "','"
					+ intersetCalculationApplicabilityDays + "','" + intersetCalculationFrom + "')";
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getPartyCreditLimitByName(String partyAcc) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT ledger_id from st_rm_acc_ledger_master where ledger_name='" + partyAcc + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Integer> partyIds = query.list();
			int partyLedgerId = 0;
			partyLedgerId = partyIds.get(0);
			sqlString = "SELECT credit_limit FROM st_rm_credit_limit WHERE ledger_id=" + partyLedgerId + "";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<Integer> rs = query2.list();
			if ((rs != null || !rs.isEmpty()) && rs.size() > 0) {

				return String.valueOf(rs.get(0));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "none";
	}

	public String getNewBillNo(String partyAcc, String typeOfRef, String type) {
		String finalString = "";

		try {
			Session session = HibernateSessionFactory.getSession();
			String suffix = "";
			if (type.equalsIgnoreCase("Yes"))
				suffix = "_sale";
			String sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_name='" + partyAcc + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			int partyLedgerId = 0;
			for (Object[] obj : partyIds) {
				partyLedgerId = (int) obj[0];
			}
			sqlString = "SELECT * FROM st_rm_bill_wise_details" + suffix + " WHERE party_id=" + partyLedgerId
					+ " and type_of_ref IN('" + typeOfRef + "')";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<Object[]> rs = query2.list();
			if ((rs != null && !rs.isEmpty())) {
				for (Object[] obj : rs) {
					int id = (int) obj[0];
					id = id + 1;
					finalString = String.valueOf(id);
				}
			} else {
				finalString = "1";
			}
			sqlString = "SELECT * FROM st_rm_credit_limit WHERE ledger_id=" + partyLedgerId + "";
			SQLQuery query3 = session.createSQLQuery(sqlString);
			List<Object[]> rs1 = query3.list();
			if ((rs1 != null && !rs1.isEmpty())) {
				for (Object[] obj : rs1) {
					int id = (int) obj[2];
					finalString = finalString + "," + (int) obj[2];
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalString;
	}

	public String getOldBillNo(String partyAcc, String typeOfRef, String suffix) {

		String finalString = "";

		try {
			String tableName = "st_rm_bill_wise_details" + suffix;
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_name='" + partyAcc + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			int partyLedgerId = 0;
			for (Object[] obj : partyIds) {
				partyLedgerId = (int) obj[0];
			}
			sqlString = "SELECT * FROM " + tableName + " WHERE party_id=" + partyLedgerId
					+ " and type_of_ref IN('Agst Ref') and is_used='No'";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<Object[]> rs = query2.list();
			String tempString = "";
			if ((rs != null && !rs.isEmpty())) {
				for (Object[] obj : rs) {
					String id = obj[8].toString();

					tempString = tempString + String.valueOf(id) + " " + obj[5].toString() + " " + obj[3].toString()
							+ " " + obj[6].toString() + ";";
				}
				finalString = tempString;
			} else {
				finalString = "1";
			}
			sqlString = "SELECT * FROM st_rm_credit_limit WHERE ledger_id=" + partyLedgerId + "";
			SQLQuery query3 = session.createSQLQuery(sqlString);
			List<Object[]> rs1 = query3.list();
			if ((rs1 != null && !rs1.isEmpty())) {
				for (Object[] obj : rs1) {
					int id = (int) obj[2];
					finalString = finalString + "," + (int) obj[2];
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalString;
	}

	public boolean insertNewBill(String paymentDate, String string, String partyAcc, String totalAmt,
			String purchaseNoVoucher, Session session, Transaction transaction, String supp_invoice_no) {

		try {
			if (supp_invoice_no == null)
				supp_invoice_no = "";
			String sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_name='" + partyAcc + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			int partyLedgerId = 0;
			for (Object[] obj : partyIds) {
				partyLedgerId = (int) obj[0];
			}
			sqlString = "INSERT INTO st_rm_bill_wise_details(`type_of_ref`,`party_id`,`balance`,`is_used`,`date`,`purchase_used`,`purchase_voucher_number`,`supp_invoice_no`) values('"
					+ string + "'," + partyLedgerId + ",'" + totalAmt + "','No','" + paymentDate + "','No','"
					+ purchaseNoVoucher + "','" + supp_invoice_no + "')";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertNewBillSale(String saleDate, String string, String partyAcc, String totalAmt, String vcno,
			Session session, Transaction transaction, String superCashEligible, String orderNumber) {

		try {
			String sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_name='" + partyAcc + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			int partyLedgerId = 0;
			for (Object[] obj : partyIds) {
				partyLedgerId = (int) obj[0];
			}
			sqlString = "SELECT SUM(balance) from st_rm_bill_wise_details_sale WHERE type_of_ref IN('On Account','Advance') and party_id="
					+ partyLedgerId + " and is_used='No'";
			SQLQuery querySum = session.createSQLQuery(sqlString);
			List<Double> sumAmount = querySum.list();
			// need to work auto adjust sale amount with on account & advance
			double amount = 0.0;
			double saleAmount = Double.valueOf(totalAmt);
			double tempsaleAmount = Double.valueOf(totalAmt);
			String is_used = "No";
			if (sumAmount != null && sumAmount.get(0) != null && sumAmount.get(0) > 0.0) {

				amount = sumAmount.get(0);
			}

			if (amount > 0) {
				saleAmount = saleAmount - amount;
				if (saleAmount < 0) {
					saleAmount = 0.0;
					is_used = "Yes";
				}

				sqlString = "SELECT * from st_rm_bill_wise_details_sale WHERE type_of_ref IN('On Account','Advance') and party_id="
						+ partyLedgerId + " and is_used='No'";
				SQLQuery queryDetail = session.createSQLQuery(sqlString);
				List<Object[]> objDetailResult = queryDetail.list();

				if (objDetailResult != null && !objDetailResult.isEmpty() && objDetailResult.size() > 0
						&& objDetailResult.get(0) != null) {
					for (Object[] obj : objDetailResult) {
						String t_is_used = "No";
						String t_query_update = "";
						int billId = (int) obj[0];
						Double balance = Double.valueOf(obj[3].toString());
						if (tempsaleAmount == 0.0)
							break;
						else if (balance < tempsaleAmount) {
							tempsaleAmount = tempsaleAmount - balance;
							balance = 0.0;
							t_is_used = "Yes";
							t_query_update = "UPDATE st_rm_bill_wise_details_sale SET balance='" + balance
									+ "',is_used='" + t_is_used + "' WHERE bill_id=" + billId;
						} else if (balance > tempsaleAmount) {
							balance = balance - tempsaleAmount;
							tempsaleAmount = 0.0;
							t_is_used = "No";
							t_query_update = "UPDATE st_rm_bill_wise_details_sale SET balance='" + balance
									+ "',is_used='" + t_is_used + "' WHERE bill_id=" + billId;
						} else if (balance == tempsaleAmount) {
							balance = balance - tempsaleAmount;
							tempsaleAmount = 0.0;
							t_is_used = "Yes";
							t_query_update = "UPDATE st_rm_bill_wise_details_sale SET balance='" + balance
									+ "',is_used='" + t_is_used + "' WHERE bill_id=" + billId;

						}

						SQLQuery t_query_update_sql = session.createSQLQuery(t_query_update);
						t_query_update_sql.executeUpdate();

					}
				}
				sqlString = "SELECT * FROM st_rm_purchase_party_master_balance WHERE party_id=" + partyLedgerId;
				SQLQuery balanceQuery = session.createSQLQuery(sqlString);
				List<Object[]> balanceRes = balanceQuery.list();

				if (balanceRes != null && !balanceRes.isEmpty() && balanceRes.size() > 0) {
					Double currBal = 0.0;
					String balanceType = "";

					for (Object[] objBalance : balanceRes) {

						currBal = Double.valueOf(objBalance[2].toString());
						balanceType = objBalance[3].toString();
						if (balanceType.equals("Dr")) {

							currBal = (currBal - Double.valueOf(totalAmt)) + saleAmount;
							if (currBal < 0) {
								currBal = currBal * (-1);
								balanceType = "Cr";
							}

						} else {

							currBal = (currBal + Double.valueOf(totalAmt)) - saleAmount;
							if (currBal < 0) {
								currBal = currBal * (-1);
								balanceType = "Dr";
							}
						}
					}
					/*
					 * sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" +
					 * String.valueOf(currBal) + "',balance_type='" + balanceType +
					 * "' WHERE party_id=" + partyLedgerId + ""; SQLQuery queryupdateCBal =
					 * session.createSQLQuery(sqlString); queryupdateCBal.executeUpdate();
					 */

				}

			}
			if (orderNumber == null || orderNumber.isEmpty() || orderNumber.equals(""))
				orderNumber = "0";
			sqlString = "INSERT INTO st_rm_bill_wise_details_sale(`type_of_ref`,`party_id`,`balance`,`is_used`,`date`,`sale_voucher_number`,`superCashBill`,`order_id`) values('"
					+ string + "'," + partyLedgerId + ",'" + saleAmount + "','" + is_used + "','" + saleDate + "','"
					+ vcno + "','" + superCashEligible + "'," + orderNumber + ")";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateTransactionPartyBalanceSale(String partyAcc, String currBalance, String hcrdr, Session session,
			Transaction transaction) {
		try {
			int partyLedgerId = getLedgerIdByName(partyAcc);

			String sqlString = "SELECT * from st_rm_purchase_party_master_balance where party_id=" + partyLedgerId + "";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			Double dbBalance = 0.0;
			String dbBalanceType = "";
			Double finalBal = 0.0;
			String finalBalType = "";
			if (result != null && !result.isEmpty()) {
				for (Object[] obj : result) {
					dbBalance = Double.valueOf(obj[2].toString());
					dbBalanceType = obj[3].toString();
					finalBal = dbBalance;
				}

			}
			if (dbBalanceType.trim().equalsIgnoreCase("Cr")) {
				finalBal = finalBal - Double.valueOf(currBalance);
				if (finalBal < 0.0) {
					finalBal = finalBal * (-1);
					finalBalType = "Dr";
				} else
					finalBalType = "Cr";

			} else if (dbBalanceType.trim().equalsIgnoreCase("Dr")) {
				finalBal = finalBal + Double.valueOf(currBalance);
				finalBalType = "Dr";

			} else {
				return false;
			}

			sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + finalBal + "',balance_type='"
					+ finalBalType + "' WHERE party_id=" + partyLedgerId + "";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateTransactionPartyBalanceJournal(String particulars, String debitAmt, String creditAmt,
			String cr_dr, String hiddenAmnt, String hiddenTypeOfRef, String hiddenBillWiseName, String journalNoVoucher,
			Session session, Transaction transaction) {

		try {
			String particularsArr[] = particulars.split(",");
			String debitAmtArr[] = debitAmt.split(",");
			String creditAmtArr[] = creditAmt.split(",");
			String cr_drArr[] = cr_dr.split(",");
			int length = particularsArr.length;
			String sqlString = "";
			String[] typeOfRefArr = hiddenTypeOfRef.split(",");
			String[] hiddenAmtArr = hiddenAmnt.split(",");
			String[] hiddenBillWiseNameArr = hiddenBillWiseName.split(",");
			boolean flag = false;
			for (int i = 0; i < length; i++) {
				flag = false;
				String tempParticularName = particularsArr[i].trim();
				int ledgerId = findLedgerIdByName(tempParticularName);
				String partyBalance = getPartyBalanceById(ledgerId);
				String partyBalanceType = getPartyBalanceType(ledgerId);
				String partyType = getPartyTypeById(ledgerId);
				String BalanceSheetSide = getBalanceSheetSideByName(partyType);
				Double partyBalanceToInt = 0.0;
				String new_blnc_type = partyBalanceType;
				if (partyType.equals("Sundry creditors")) {
					Double AgstRefBal = 0.0;
					Double totalBlnc = Double.valueOf(debitAmtArr[i].trim()) + Double.valueOf(creditAmtArr[i].trim());
					LocalDate date = LocalDate.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					if (!hiddenAmnt.isEmpty()) {

						for (int j = 0; j < typeOfRefArr.length; j++) {
							flag = false;
							if (typeOfRefArr[j].trim().equals("New Ref")) {
								insertNewBill(date.format(formatter), "Agst Ref", tempParticularName,
										String.valueOf(totalBlnc), journalNoVoucher, session, transaction, null);
							} else if (typeOfRefArr[j].trim().equals("Agst Ref")) {
								String arr[] = hiddenBillWiseNameArr[j].trim().split(" ");
								int billId = Integer.valueOf(arr[0].trim());
								Double DBbalance = Double.valueOf(arr[2].trim());
								Double appBalance = Double.valueOf(hiddenAmtArr[j].trim());
								AgstRefBal = Double.valueOf(hiddenAmtArr[j].trim());
								Double diff = DBbalance - appBalance;
								String billSqlString = "";
								if (diff <= 0) {
									billSqlString = "UPDATE st_rm_bill_wise_details SET balance='"
											+ String.valueOf(diff) + "',is_used='Yes' WHERE purchase_voucher_number='"
											+ billId + "'";
								} else {
									billSqlString = "UPDATE st_rm_bill_wise_details SET balance='"
											+ String.valueOf(diff) + "' WHERE purchase_voucher_number='" + billId + "'";

								}
								SQLQuery sqlBillQuery = session.createSQLQuery(billSqlString);
								sqlBillQuery.executeUpdate();
								flag = true;
							} else {
								insertNewBill(date.format(formatter), typeOfRefArr[j], tempParticularName,
										String.valueOf(totalBlnc), journalNoVoucher, session, transaction, null);
							}
							String qu = "INSERT INTO st_rm_journal_bill_mapping(`jouVcr`,`billVcr`,`amount`,`type_of_ref`,`bill_type`) values('"
									+ journalNoVoucher + "','" + hiddenBillWiseNameArr[j].split(" ")[0].trim() + "','"
									+ hiddenAmtArr[j].trim() + "','" + typeOfRefArr[j].trim() + "','purchase')";
							SQLQuery sqlQuery = session.createSQLQuery(qu);
							sqlQuery.executeUpdate();

						}
					}

					if (partyBalanceType.equals("Dr")) {
						if (cr_drArr[i].trim().equals("Cr")) {
							partyBalanceToInt = Double.valueOf(partyBalance) - totalBlnc;
							if (partyBalanceToInt < 0) {
								partyBalanceToInt = partyBalanceToInt * (-1);
								new_blnc_type = "Cr";
							}
						} else {
							partyBalanceToInt = Double.valueOf(partyBalance) + totalBlnc;
							new_blnc_type = "Dr";
						}

					} else {
						if (cr_drArr[i].trim().equals("Dr")) {
							partyBalanceToInt = Double.valueOf(partyBalance) - totalBlnc;
							if (partyBalanceToInt < 0) {
								partyBalanceToInt = partyBalanceToInt * (-1);
								new_blnc_type = "Dr";
							}
						} else {
							partyBalanceToInt = Double.valueOf(partyBalance) + totalBlnc;
							new_blnc_type = "Cr";
						}

					}
					/*
					 * if (flag) partyBalanceToInt = partyBalanceToInt - AgstRefBal - totalBlnc;
					 * else partyBalanceToInt = partyBalanceToInt - AgstRefBal;
					 */
				}
				if (partyType.equals("Sundry debtors")) {
					flag = false;
					Double AgstRefBal = 0.0;
					Double totalBlnc = Double.valueOf(debitAmtArr[i].trim()) + Double.valueOf(creditAmtArr[i].trim());
					LocalDate date = LocalDate.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					if (!hiddenAmnt.isEmpty()) {

						for (int j = 0; j < typeOfRefArr.length; j++) {
							flag = false;
							if (typeOfRefArr[j].trim().equals("New Ref")) {
								insertNewBillSale(date.format(formatter), "Agst Ref", tempParticularName,
										String.valueOf(totalBlnc), journalNoVoucher, session, transaction, "no", null);
							} else if (typeOfRefArr[j].trim().equals("Agst Ref")) {
								String arr[] = hiddenBillWiseNameArr[j].trim().split(" ");
								String billId = String.valueOf(arr[0].trim());
								Double DBbalance = Double.valueOf(arr[2].trim());
								Double appBalance = Double.valueOf(hiddenAmtArr[j].trim());
								AgstRefBal = Double.valueOf(hiddenAmtArr[j].trim());
								Double diff = DBbalance - appBalance;
								String billSqlString = "";
								if (diff <= 0) {
									billSqlString = "UPDATE st_rm_bill_wise_details_sale SET balance='"
											+ String.valueOf(diff) + "',is_used='Yes' WHERE sale_voucher_number='"
											+ billId + "'";
								} else {
									billSqlString = "UPDATE st_rm_bill_wise_details_sale SET balance='"
											+ String.valueOf(diff) + "' WHERE sale_voucher_number='" + billId + "'";

								}
								SQLQuery sqlBillQuery = session.createSQLQuery(billSqlString);
								sqlBillQuery.executeUpdate();
								flag = true;
							} else {
								insertNewBillSale(date.format(formatter), typeOfRefArr[j], tempParticularName,
										String.valueOf(totalBlnc), journalNoVoucher, session, transaction, "no", null);
							}
							String qu = "INSERT INTO st_rm_journal_bill_mapping(`jouVcr`,`billVcr`,`amount`,`type_of_ref`,`bill_type`) values('"
									+ journalNoVoucher + "','" + hiddenBillWiseNameArr[j].split(" ")[0].trim() + "','"
									+ hiddenAmtArr[j].trim() + "','" + typeOfRefArr[j].trim() + "','sale')";
							SQLQuery sqlQuery = session.createSQLQuery(qu);
							sqlQuery.executeUpdate();
						}
					}

					if (partyBalanceType.equals("Cr")) {
						if (cr_drArr[i].trim().equals("Dr")) {
							partyBalanceToInt = Double.valueOf(partyBalance) - totalBlnc;
							if (partyBalanceToInt < 0) {
								partyBalanceToInt = partyBalanceToInt * (-1);
								new_blnc_type = "Dr";
							}

						} else {
							partyBalanceToInt = Double.valueOf(partyBalance) + totalBlnc;
							new_blnc_type = "Cr";
						}

					} else {
						if (cr_drArr[i].trim().equals("Dr")) {
							partyBalanceToInt = Double.valueOf(partyBalance) + totalBlnc;
							new_blnc_type = "Dr";
						} else {
							partyBalanceToInt = Double.valueOf(partyBalance) - totalBlnc;
							if (partyBalanceToInt < 0) {
								partyBalanceToInt = partyBalanceToInt * (-1);
								new_blnc_type = "Cr";
							}
						}

					}
					/*
					 * if (flag) partyBalanceToInt = partyBalanceToInt - AgstRefBal - totalBlnc;
					 * else partyBalanceToInt = partyBalanceToInt - AgstRefBal;
					 */
				}

				if (!partyType.equals("Sundry debtors") && !partyType.equals("Sundry creditors")) {
					Double totalBlnc = Double.valueOf(debitAmtArr[i].trim()) + Double.valueOf(creditAmtArr[i].trim());
					if (BalanceSheetSide.equals("Liability")) {
						if (partyBalanceType.equals("Cr")) {
							if (cr_drArr[i].trim().equals("Dr")) {
								partyBalanceToInt = Double.valueOf(partyBalance) - totalBlnc;
								if (partyBalanceToInt < 0) {
									partyBalanceToInt = partyBalanceToInt * (-1);
									new_blnc_type = "Dr";
								} else {
									new_blnc_type = "Cr";
								}
							} else {
								partyBalanceToInt = Double.valueOf(partyBalance) + totalBlnc;
								new_blnc_type = "Cr";
							}

						} else {
							if (cr_drArr[i].trim().equals("Cr")) {
								partyBalanceToInt = Double.valueOf(partyBalance) - totalBlnc;
								if (partyBalanceToInt < 0) {
									partyBalanceToInt = partyBalanceToInt * (-1);
									new_blnc_type = "Cr";
								}
							} else {
								partyBalanceToInt = Double.valueOf(partyBalance) + totalBlnc;
								new_blnc_type = "Dr";
							}

						}
					}
					if (BalanceSheetSide.equals("Assets")) {
						if (partyBalanceType.equals("Dr")) {
							if (cr_drArr[i].trim().equals("Cr")) {
								partyBalanceToInt = Double.valueOf(partyBalance) - totalBlnc;
								if (partyBalanceToInt < 0) {
									partyBalanceToInt = partyBalanceToInt * (-1);
									new_blnc_type = "Cr";
								} else {
									new_blnc_type = "Dr";
								}
							} else {
								partyBalanceToInt = Double.valueOf(partyBalance) + totalBlnc;
							}

						} else {
							if (cr_drArr[i].trim().equals("Cr")) {
								partyBalanceToInt = Double.valueOf(partyBalance) + totalBlnc;
								new_blnc_type = "Cr";
							} else {
								partyBalanceToInt = Double.valueOf(partyBalance) - totalBlnc;
								if (partyBalanceToInt < 0) {
									partyBalanceToInt = partyBalanceToInt * (-1);
									new_blnc_type = "Dr";
								}
							}

						}

					}

				}
				sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + partyBalanceToInt
						+ "',balance_type='" + new_blnc_type + "' WHERE party_id=" + ledgerId + "";
				SQLQuery query = session.createSQLQuery(sqlString);
				query.executeUpdate();

			}
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	private String getBalanceSheetSideByName(String partyType) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * from st_rm_acc_group_master where group_name='" + partyType + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			String partyLedgerType = "";
			for (Object[] obj : partyIds) {
				partyLedgerType = obj[7].toString();
			}
			return partyLedgerType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPartyTypeById(int ledgerId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_id=" + ledgerId + "";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			String partyLedgerType = "";
			for (Object[] obj : partyIds) {
				partyLedgerType = obj[2].toString();
			}
			return partyLedgerType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getPartyBalanceType(int ledgerId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * from st_rm_purchase_party_master_balance where party_id=" + ledgerId + "";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			String partyLedgerBlncType = "";
			for (Object[] obj : partyIds) {
				partyLedgerBlncType = obj[3].toString();
			}
			return partyLedgerBlncType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getPartyBalanceById(int ledgerId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * from st_rm_purchase_party_master_balance where party_id=" + ledgerId + "";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			String partyLedgerBlnc = "";
			for (Object[] obj : partyIds) {
				partyLedgerBlnc = obj[2].toString();
			}
			return partyLedgerBlnc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int findLedgerIdByName(String partyName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_name='" + partyName + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			int partyLedgerId = 0;
			for (Object[] obj : partyIds) {
				partyLedgerId = (int) obj[0];
			}
			return partyLedgerId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean updateTransactionPartyBalanceSaleCreditNote(String partyAcc, String currBalance, String hcrdr,
			Session session, Transaction transaction) {

		try {
			int partyLedgerId = getLedgerIdByName(partyAcc);

			String sqlString = "SELECT * from st_rm_purchase_party_master_balance where party_id=" + partyLedgerId + "";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			Double dbBalance = 0.0;
			String dbBalanceType = "";
			Double finalBal = 0.0;
			String finalBalType = "";
			if (result != null && !result.isEmpty()) {
				for (Object[] obj : result) {
					dbBalance = Double.valueOf(obj[2].toString());
					dbBalanceType = obj[3].toString();
					finalBal = dbBalance;
				}

			}
			if (dbBalanceType.trim().equalsIgnoreCase("Cr")) {
				finalBal = finalBal + Double.valueOf(currBalance);
				finalBalType = "Cr";

			} else if (dbBalanceType.trim().equalsIgnoreCase("Dr")) {
				finalBal = finalBal - Double.valueOf(currBalance);
				if (finalBal < 0.0) {
					finalBal = finalBal * (-1);
					finalBalType = "Cr";
				} else
					finalBalType = "Dr";

			} else {
				return false;
			}

			sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + finalBal + "',balance_type='"
					+ finalBalType + "' WHERE party_id=" + partyLedgerId + "";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public int getCreditPeriod(int partyId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * FROM st_rm_credit_limit WHERE ledger_id=" + partyId + "";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			for (Object[] obj : result) {
				if (obj[1].toString().equals("Yes")) {
					return (int) obj[2];
				} else {
					return -1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public List<String> getBillDetails(int partyId, String suffix, String dateBeforePeriod) {

		try {
			List<String> response = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * FROM st_rm_bill_wise_details" + suffix + " WHERE party_id=" + partyId
					+ " and type_of_ref='Agst Ref' and is_used='No' and STR_TO_DATE(DATE,'%d-%m-%Y') <= STR_TO_DATE('"
					+ dateBeforePeriod + "','%d-%m-%Y') ";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			for (Object[] obj : result) {
				Date today = new Date();
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
				Date dateBefPer = df.parse(dateBeforePeriod);
				Date billDatePer = df.parse(obj[5].toString().trim());
				df.applyPattern("yyyy-MM-dd");
				String dateBeforePeriod1 = df.format(dateBefPer);
				String billDate = df.format(billDatePer);
				LocalDateTime effectiveDate = LocalDateTime.parse(dateBeforePeriod1);
				LocalDateTime effectiveDateDb = LocalDateTime.parse(billDate);

				// Now access the values as below
				Years age = Years.yearsBetween(effectiveDateDb, effectiveDate);
				Months months = Months.monthsBetween(effectiveDateDb, effectiveDate);
				Days days = Days.daysBetween(effectiveDateDb, effectiveDate);
				String resu = "D:" + days.getDays() + " M:" + months.getMonths() + " Y:" + age.getYears();
				response.add("BillId=" + obj[8].toString() + " Date=" + obj[5].toString().trim() + ", Amount="
						+ obj[3].toString().trim() + " " + obj[6].toString() + ", Days Exceed=" + resu);
			}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getNewBillNoJournal(String partyAcc, String typeOfRef) {

		String finalString = "";

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_name='" + partyAcc + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			int partyLedgerId = 0;
			String partyType = "";
			for (Object[] obj : partyIds) {
				partyLedgerId = (int) obj[0];
				partyType = obj[2].toString();
			}
			String suffix = "";
			if (partyType.equals("Sundry creditors"))
				suffix = "";
			else
				suffix = "_sale";
			sqlString = "SELECT * FROM st_rm_bill_wise_details" + suffix + " WHERE party_id=" + partyLedgerId + " ";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<Object[]> rs = query2.list();
			if ((rs != null && !rs.isEmpty())) {
				for (Object[] obj : rs) {
					int id = (int) obj[0];
					id = id + 1;
					finalString = String.valueOf(id);
				}
			} else {
				finalString = "1";
			}
			sqlString = "SELECT * FROM st_rm_credit_limit WHERE ledger_id=" + partyLedgerId + "";
			SQLQuery query3 = session.createSQLQuery(sqlString);
			List<Object[]> rs1 = query3.list();
			if ((rs1 != null && !rs1.isEmpty())) {
				for (Object[] obj : rs1) {
					int id = (int) obj[2];
					finalString = finalString + "," + (int) obj[2];
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalString;
	}

	public boolean updateTransactionPartyBalancePymt(String partyAcc, String currBalance, String hcrdr, Session session,
			Transaction transaction) {

		try {
			int partyLedgerId = getLedgerIdByName(partyAcc);

			String sqlString = "SELECT * from st_rm_purchase_party_master_balance where party_id=" + partyLedgerId + "";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			Double dbBalance = 0.0;
			String dbBalanceType = "";
			Double finalBal = 0.0;
			String finalBalType = "";
			if (result != null && !result.isEmpty()) {
				for (Object[] obj : result) {
					dbBalance = Double.valueOf(obj[2].toString());
					dbBalanceType = obj[3].toString();
					finalBal = dbBalance;
				}

			}
			if (dbBalanceType.trim().equalsIgnoreCase("Dr")) {
				finalBal = finalBal + Double.valueOf(currBalance);
				finalBalType = "Dr";

			} else if (dbBalanceType.trim().equalsIgnoreCase("Cr")) {
				finalBal = finalBal - Double.valueOf(currBalance);
				if (finalBal < 0.0) {
					finalBal = finalBal * (-1);
					finalBalType = "Dr";
				} else
					finalBalType = "Cr";

			} else {
				return false;
			}

			sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + finalBal + "',balance_type='"
					+ finalBalType + "' WHERE party_id=" + partyLedgerId + "";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public String updateTransactionPartyBalancePayment(String partyAcc, String currBalance, String hcrdr,
			Session session, Transaction transaction) {

		try {
			int partyLedgerId = getLedgerIdByName(partyAcc);

			String sqlString = "SELECT * from st_rm_purchase_party_master_balance where party_id=" + partyLedgerId + "";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			Double dbBalance = 0.0;
			String dbBalanceType = "";
			Double finalBal = 0.0;
			String finalBalType = "";
			if (result != null && !result.isEmpty()) {
				for (Object[] obj : result) {
					dbBalance = Double.valueOf(obj[2].toString().trim());
					dbBalanceType = obj[3].toString().trim();
					finalBal = dbBalance;
				}

			}
			if (dbBalanceType.equalsIgnoreCase("Cr")) {
				finalBal = finalBal + Double.valueOf(currBalance);
				finalBalType = "Cr";

			} else if (dbBalanceType.equalsIgnoreCase("Dr")) {
				finalBal = finalBal - Double.valueOf(currBalance);
				if (finalBal < 0.0) {
					finalBal = finalBal * (-1);
					finalBalType = "Cr";
				} else
					finalBalType = "Dr";

			} else {
				return partyAcc + " balance type Not Found!!";
			}

			sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + finalBal + "',balance_type='"
					+ finalBalType + "' WHERE party_id=" + partyLedgerId + "";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			query2.executeUpdate();
			return "success";
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return "Internal Server Error";
	}

	public boolean updateTransactionPartyBalanceContra(String partyAcc, String currBalance, String hcrdr) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_name='" + partyAcc + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			int partyLedgerId = 0;
			for (Object[] obj : partyIds) {
				partyLedgerId = (int) obj[0];
			}
			String append = "";
			append = ",balance_type='" + hcrdr + "'";

			sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + currBalance + "' " + append
					+ " WHERE party_id=" + partyLedgerId + "";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			query2.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean markAttendance(int employeeUserName, String attendanceType, String workType, String workArea,
			String travellingMode, String odoMeterPicture, String selfiePicture, String odometer_reading,
			String leave_reason, String travellingModeVia, VisitFormBean bean, String visitLocation) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateSessionFactory.getSession();
			String sqlString = "";
			// java.time.LocalDateTime date = java.time.LocalDateTime.now();
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
			df1.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
			String YMD = df.format(date);
			String time = df1.format(date);

			if (attendanceType.equals("PI")) {
				attendanceType = "P";

				sqlString = "INSERT INTO bo_um_employee_attendance(`emp_id`,`attendance_type`,`date`,`present_in`) values("
						+ employeeUserName + ",'" + attendanceType + "','" + YMD + "','" + time + "')";

				SQLQuery query = session.createSQLQuery(sqlString);
				query.executeUpdate();
				sqlString = "SELECT * FROM bo_um_employee_attendance WHERE emp_id=" + employeeUserName + " and date='"
						+ YMD + "'";
				SQLQuery query2 = session.createSQLQuery(sqlString);
				List<Object[]> res = query2.list();
				for (Object[] obj : res) {
					sqlString = "UPDATE bo_um_employee_attendance SET detail_id=" + (int) obj[0] + " WHERE emp_id="
							+ employeeUserName + " and date='" + YMD + "'";
					SQLQuery query3 = session.createSQLQuery(sqlString);
					query3.executeUpdate();
					sqlString = "INSERT INTO bo_um_emp_attendace_details(`detail_id`,`work_type`,`work_area`,`travelling_mode`,`travelling_via`,`odometer_picture_in`,`odometer_reading_in`,`selfie_in`,`visit_location`) values("
							+ (int) obj[0] + ",'" + workType + "','" + workArea + "','" + travellingMode + "','"
							+ travellingModeVia + "','" + odoMeterPicture + "','" + odometer_reading.trim() + "','"
							+ selfiePicture + "','" + visitLocation + "')";
					SQLQuery query4 = session.createSQLQuery(sqlString);
					query4.executeUpdate();
					break;

				}
			} else if (attendanceType.equals("PO")) {
				sqlString = "SELECT * FROM bo_um_employee_attendance WHERE emp_id=" + employeeUserName + " and date='"
						+ YMD + "'";
				SQLQuery query2 = session.createSQLQuery(sqlString);
				List<Object[]> res = query2.list();
				int detail_id = 0;
				for (Object[] obj : res) {
					detail_id = (int) obj[4];
				}
				sqlString = "UPDATE bo_um_employee_attendance SET present_out='" + time + "' WHERE emp_id="
						+ employeeUserName + " and date='" + YMD + "'";
				SQLQuery query = session.createSQLQuery(sqlString);
				query.executeUpdate();
				for (Object[] obj : res) {
					sqlString = "UPDATE bo_um_emp_attendace_details SET odometer_picture_out='" + odoMeterPicture
							+ "',odometer_reading_out='" + odometer_reading.trim() + "',selfie_out='" + selfiePicture
							+ "' WHERE detail_id=" + detail_id;
					SQLQuery query4 = session.createSQLQuery(sqlString);
					query4.executeUpdate();
					break;

				}

			} else if (attendanceType.equals("L")) {
				sqlString = "INSERT INTO bo_um_employee_attendance(`emp_id`,`attendance_type`,`date`) values("
						+ employeeUserName + ",'" + attendanceType + "','" + YMD + "')";

				SQLQuery query = session.createSQLQuery(sqlString);
				query.executeUpdate();
				sqlString = "SELECT * FROM bo_um_employee_attendance WHERE emp_id=" + employeeUserName + " and date='"
						+ YMD + "'";
				SQLQuery query2 = session.createSQLQuery(sqlString);
				List<Object[]> res = query2.list();
				for (Object[] obj : res) {
					sqlString = "UPDATE bo_um_employee_attendance SET detail_id=" + (int) obj[0] + " WHERE emp_id="
							+ employeeUserName + " and date='" + YMD + "'";
					SQLQuery query3 = session.createSQLQuery(sqlString);
					query3.executeUpdate();
					sqlString = "INSERT INTO bo_um_emp_attendace_details(`detail_id`,`leave_reason`) values("
							+ (int) obj[0] + ",'" + leave_reason + "')";
					SQLQuery query4 = session.createSQLQuery(sqlString);
					query4.executeUpdate();
					break;

				}

			} else {
				sqlString = "INSERT INTO bo_um_employee_attendance(`emp_id`,`attendance_type`,`date`) values("
						+ employeeUserName + ",'" + attendanceType + "','" + YMD + "')";

				SQLQuery query = session.createSQLQuery(sqlString);
				query.executeUpdate();

			}

			if (bean != null && attendanceType.equals("PO") && workType.equalsIgnoreCase("Field_work")) {
				Integer no_of_visit = Integer.valueOf(bean.getVisitNumber());
				if (no_of_visit > 0 && no_of_visit != null) {
					sqlString = "SELECT * FROM bo_um_employee_attendance WHERE emp_id=" + employeeUserName
							+ " and date='" + YMD + "'";
					SQLQuery query2 = session.createSQLQuery(sqlString);
					List<Object[]> res = query2.list();
					int detail_id = 0;
					for (Object[] obj : res) {
						detail_id = (int) obj[4];
					}
					String propNameArr[] = bean.getPropName().split(",");
					String cusTypeArr[] = bean.getCustomerType().split(",");
					String distributorArr[] = bean.getDistributor().split(",");
					String retailrArr[] = bean.getRetailer().split(",");
					String retailrNameArr[] = bean.getRetailerName().split(",");
					String contactArr[] = bean.getContact().split(",");
					String addressArr[] = bean.getAddress().split(",");
					String districtArr[] = bean.getDistrict().split(",");
					String visitPurposeArr[] = bean.getVisitPurpose().split(",");
					String purposeArr[] = bean.getPurpose().split(",");
					String commentArr[] = bean.getComment().split(",");
					String reminderArr[] = bean.getReminder().split(",");
					for (int i = 0; i < propNameArr.length; i++) {
						if (!propNameArr[i].trim().equals("-1") && !propNameArr[i].trim().isEmpty()
								&& !propNameArr[i].trim().equals(" ")) {
							sqlString = "INSERT INTO bo_um_attendance_visit(`detail_id`,`no_of_visit`,`customerType`,`distributor`,`retailer`,`retailerName`,`propName`,`contact`,`address`,`district`,`visitPurpose`,`purpose`,`comment`,`reminder`) values("
									+ detail_id + "," + no_of_visit + ",'" + cusTypeArr[i].trim() + "','"
									+ distributorArr[i].trim() + "','" + retailrArr[i].trim() + "','"
									+ retailrNameArr[i].trim() + "','" + propNameArr[i].trim() + "','"
									+ contactArr[i].trim() + "','" + addressArr[i].trim() + "','"
									+ districtArr[i].trim() + "','" + visitPurposeArr[i].trim() + "','"
									+ purposeArr[i].trim() + "','" + commentArr[i].trim() + "','"
									+ reminderArr[i].trim() + "')";
							SQLQuery queryV = session.createSQLQuery(sqlString);
							queryV.executeUpdate();
						}

					}

				}

			}

			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public int getUserIdByName(String employeeName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
			criteria.add(Restrictions.eq("userName", employeeName));
			List<StRmBoUserMaster> res = criteria.list();
			return res.get(0).getUserId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getCompanyIdByName(String companyName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(CreateCompany.class);
			criteria.add(Restrictions.eq("name", companyName));
			List<CreateCompany> companies = criteria.list();
			return companies.get(0).getCompanyId();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Map<String, AttendanceBean> getAttendanceReport(int empId, int companyId, String fromDate, String toDate,
			String employeeName, String companyName) {

		try {
			AttendanceBean attendanceBean = new AttendanceBean();
			Map<String, AttendanceBean> map = new HashMap<String, AttendanceBean>();
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "";
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM `bo_um_employee_attendance` as a LEFT JOIN `bo_um_emp_attendace_details` as b ON a.detail_id=b.detail_id WHERE date>='"
							+ fromDate + "' and date<='" + toDate + "' and emp_id=" + empId + "");
			List<Object[]> result = query.list();

			for (Object[] obj : result) {
				attendanceBean = new AttendanceBean();

				attendanceBean.setCompanyName(companyName);
				attendanceBean.setEmpName(employeeName);
				attendanceBean.setAttendaceMark(obj[2] != null ? obj[2].toString() : "");
				attendanceBean.setPresentIn(obj[5] != null ? obj[5].toString() : "");
				attendanceBean.setPresentout(obj[6] != null ? obj[6].toString() : "");
				attendanceBean.setAttendanceDate(obj[3] != null ? obj[3].toString() : "");
				attendanceBean.setOdometerReadingIn(obj[13] != null ? obj[13].toString().trim() : "0");
				attendanceBean.setOdometerReadingOut(obj[16] != null ? obj[16].toString().trim() : "0");
				int reading = Integer.valueOf(attendanceBean.getOdometerReadingOut())
						- Integer.valueOf(attendanceBean.getOdometerReadingIn());
				if (reading < 0)
					attendanceBean.setTotalReading("-");
				else
					attendanceBean.setTotalReading(String.valueOf(reading));
				attendanceBean.setEmpId("CRM-" + empId);
				attendanceBean.setLeaveReason(obj[14] != null ? obj[14].toString() : "");
				attendanceBean.setTravellingMode(obj[11] != null ? obj[11].toString() : "");
				attendanceBean.setWorkArea(obj[10] != null ? obj[10].toString() : "");
				attendanceBean.setWorkType(obj[9] != null ? obj[9].toString() : "");
				attendanceBean.setVisitLocation(obj[20] != null ? obj[20].toString() : "");
				String sDate1 = obj[5] != null ? obj[5].toString() : null;
				String sDate2 = obj[6] != null ? obj[6].toString() : null;
				if (sDate1 != null && sDate2 != null) {
					Date date1 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(sDate1);
					Date date2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(sDate2);
					long diff = date2.getTime() - date1.getTime();
					long min = diff / (60 * 1000) % 60;
					String minString = "00";
					long hour = diff / (60 * 60 * 1000) % 24;
					if (min >= 0 && min < 10)
						minString = "0" + min;
					else
						minString = "" + min;

					attendanceBean.setWorkingHour(hour + " h " + minString + " m");
					String t = hour + "" + minString;
					if (Double.valueOf(t) < 730)
						attendanceBean.setAttendaceMark("H");
				} else {
					attendanceBean.setAttendaceMark("A");
					attendanceBean.setWorkingHour("0 h 00 m");
				}

				map.put(obj[3].toString(), attendanceBean);
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getFieldList() {

		try {
			List<String> ls = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT DISTINCT field_name FROM `bo_um_dynamic_field_master`");
			List<String> result = query.list();
			for (String s : result) {
				ls.add(s);
			}
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Integer, String> getFieldValuesByName(String fieldName) {

		try {
			Map<Integer, String> map = new HashMap<Integer, String>();
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT DISTINCT * FROM `bo_um_dynamic_field_master` WHERE is_active='Y' AND field_name ='"
							+ fieldName + "'");
			List<Object[]> result = query.list();
			if (result != null && result.size() > 0) {
				for (Object[] obj : result)
					map.put((int) obj[0], obj[2].toString());
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addDynamicValues(String fieldName, String dynamicList) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			String arr[] = dynamicList.split(",");
			String sqlString = "";
			transaction = session.beginTransaction();
			for (String s : arr) {
				if (!s.isEmpty() && !s.equals("") && !s.equals(" ")) {
					sqlString = "SELECT id from bo_um_dynamic_field_master WHERE field_name='" + fieldName
							+ "' and field_value='" + s.trim() + "'";
					SQLQuery query = session.createSQLQuery(sqlString);
					List<Integer> result = query.list();
					if (result != null && !result.isEmpty() && result.size() > 0) {

					} else {
						sqlString = "INSERT INTO bo_um_dynamic_field_master(`field_name`,`field_value`) values('"
								+ fieldName + "','" + s.trim() + "')";
						SQLQuery query2 = session.createSQLQuery(sqlString);
						query2.executeUpdate();
					}

				}
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public List<CountryBean> getCountryList() {

		try {
			List<CountryBean> map = new ArrayList<CountryBean>();
			CountryBean bean = new CountryBean();
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT country_code,name from st_gen_country_master WHERE status='ACTIVE'");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				for (Object[] obj : result) {
					bean = new CountryBean();
					bean.setCountryCode(obj[0].toString());
					bean.setName(obj[1].toString());
					map.add(bean);
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getDynamicFieldList(String string) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT DISTINCT field_value from bo_um_dynamic_field_master WHERE field_name ='"
							+ string + "' and is_active='Y'");
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getStateList() {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT DISTINCT name from st_gen_state_master WHERE country_code ='IN' order by name ASC");
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getLedgerStateList() {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT DISTINCT state from bo_um_ledger_details WHERE  NULLIF( TRIM(state) , '') IS NOT NULL order by state ASC");
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getCityList() {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT DISTINCT city_name from st_gen_city_master WHERE country_code ='IN'");
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getApproverList() {

		try {
			List<String> list = new ArrayList<String>();
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
			List<StRmBoUserMaster> boUserMasters = criteria.list();
			for (StRmBoUserMaster obj : boUserMasters) {
				list.add(obj.getUserName());
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getOldBillNoJournal(String partyAcc, String typeOfRef) {

		String finalString = "";

		try {
			String tableName = "st_rm_bill_wise_details";
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * from st_rm_acc_ledger_master where ledger_name='" + partyAcc + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> partyIds = query.list();
			int partyLedgerId = 0;
			String partyType = "";
			for (Object[] obj : partyIds) {
				partyLedgerId = (int) obj[0];
				partyType = obj[2].toString();
			}
			if (partyType.equals("Sundry debtors"))
				tableName = "st_rm_bill_wise_details_sale";
			sqlString = "SELECT * FROM " + tableName + " WHERE party_id=" + partyLedgerId
					+ " and type_of_ref IN('Agst Ref','Advance','On Account') and is_used='No'";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<Object[]> rs = query2.list();
			String tempString = "";
			if ((rs != null && !rs.isEmpty())) {
				for (Object[] obj : rs) {
					int id = (int) obj[0];
					tempString = tempString + obj[8].toString() + " " + obj[5].toString() + " " + obj[3].toString()
							+ " " + obj[6].toString() + ";";
				}
				finalString = tempString;
			} else {
				finalString = "1";
			}
			sqlString = "SELECT * FROM st_rm_credit_limit WHERE ledger_id=" + partyLedgerId + "";
			SQLQuery query3 = session.createSQLQuery(sqlString);
			List<Object[]> rs1 = query3.list();
			if ((rs1 != null && !rs1.isEmpty())) {
				for (Object[] obj : rs1) {
					int id = (int) obj[2];
					finalString = finalString + "," + (int) obj[2];
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalString;

	}

	public VoucherBean getVouchetBeanById(int voucherId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			VoucherBean bean = new VoucherBean();
			List<VoucherBean> beans = new ArrayList<VoucherBean>();
			String sqlString = "SELECT * FROM st_rm_voucher_master WHERE new_vcr_id=" + voucherId + "";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {
					bean.setVoucherId((int) obj[0]);
					bean.setVoucherName(obj[1].toString());
					bean.setVoucherType(getVoucherTypeById((int) obj[2]));
					bean.setVoucherNumbering(obj[3].toString());
					bean.setEffctvDateOfVchr(obj[4].toString());
					bean.setNarrationAllowed(obj[4].toString());
					beans.add(bean);
				}

				return beans.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateVoucher(VoucherBean voucherBean) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String query = "UPDATE st_rm_voucher_master SET vc_name='" + voucherBean.getVoucherName()
					+ "',vchr_numbering='" + voucherBean.getVoucherNumbering() + "',eff_date_of_vchr='"
					+ voucherBean.getEffctvDateOfVchr() + "',narration_allowd='" + voucherBean.getNarrationAllowed()
					+ "'";
			SQLQuery query2 = session.createSQLQuery(query);
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getEmployeePictureReport(int employeeUserName, String attendaceDate) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT detail_id from bo_um_employee_attendance WHERE emp_id=" + employeeUserName
					+ " and date='" + attendaceDate + "'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Integer> res = query.list();
			int det_id = res.get(0);
			sqlString = "SELECT odometer_picture_in,odometer_picture_out,selfie_in,selfie_out from bo_um_emp_attendace_details WHERE detail_id="
					+ det_id + "";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<Object[]> result = query2.list();
			String response = "";
			for (Object[] obj : result) {
				String odo_in = obj[0] != null ? obj[0].toString() : "no";
				String odo_out = obj[1] != null ? obj[1].toString() : "no";
				String sel_in = obj[2] != null ? obj[2].toString() : "no";
				String sel_out = obj[3] != null ? obj[3].toString() : "no";
				response = odo_in + ";" + odo_out + ";" + sel_in + ";" + sel_out;
				break;
			}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getEmployeeVisitPictureReport(String visitId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT visitor_picture from bo_um_attendance_visit WHERE id=" + visitId + "";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<String> result = query2.list();

			String response = "";
			if (result != null && result.size() > 0 && !result.isEmpty() && result.get(0) != null)
				for (String obj : result) {
					response = obj;
					break;
				}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAlerts(int userId) {

		try {
			if (userId == 1) {
				Session session = HibernateSessionFactory.getSession();
				SQLQuery query = session.createSQLQuery("SELECT * from bo_um_login_alert order by id DESC");
				List<Object[]> result = query.list();
				String notification = "";
				int count = 1;
				for (Object[] obj : result) {
					notification = notification + "<div>" + count + ".)" + "User <b>" + obj[1].toString()
							+ "</b> is logged in the system at <b>" + obj[2]
							+ "</b><a href='javascript:;' onclick='deleteNotificationById(" + (int) obj[0]
							+ ")'>X</a> </div>\n";
					count++;
				}
				return notification + "|" + (count - 1);
			} else {
				Session session = HibernateSessionFactory.getSession();
				SQLQuery query = session.createSQLQuery(
						"SELECT * FROM sale_order_staus_alert WHERE emp_id=" + userId + " ORDER BY id DESC");
				List<Object[]> result = query.list();
				String notification = "";
				int count = 1;
				for (Object[] obj : result) {
					String empName = getUserNameById((int) obj[4]);
					notification = notification + "<div>" + count + ".)" + "Sale order number <font color='red'><b>"
							+ obj[2].toString() + "</b></font> is <b><font color='#E67E22'<b>"
							+ obj[3].toString().toUpperCase() + "</b></font> by <b>" + empName.toUpperCase()
							+ "</b> <a href='javascript:;' onclick='showSalesOrderEmp(" + obj[2].toString()
							+ ")'>click here to view</a>. \n";
					count++;
				}
				SQLQuery query1 = session.createSQLQuery(
						"SELECT * FROM purchase_order_staus_alert WHERE emp_id=" + userId + " ORDER BY id DESC");
				List<Object[]> result1 = query1.list();
				for (Object[] obj : result1) {
					String empName = getUserNameById((int) obj[4]);
					notification = notification + "<div>" + count + ".)" + "Purchase order number <font color='red'><b>"
							+ obj[2].toString() + "</b></font> is <b><font color='#E67E22'<b>"
							+ obj[3].toString().toUpperCase() + "</b></font> by <b>" + empName.toUpperCase()
							+ "</b> <a href='javascript:;' onclick='showPurchaseOrderEmp(" + obj[2].toString()
							+ ")'>click here to view</a>. \n";
					count++;
				}
				SQLQuery query2 = session.createSQLQuery(
						"SELECT * FROM receipt_order_staus_alert WHERE emp_id=" + userId + " ORDER BY id DESC");
				List<Object[]> result2 = query2.list();
				for (Object[] obj : result2) {
					String empName = getUserNameById((int) obj[4]);
					notification = notification + "<div>" + count + ".)" + "Receipt order number <font color='red'><b>"
							+ obj[2].toString() + "</b></font> is <b><font color='#E67E22'<b>"
							+ obj[3].toString().toUpperCase() + "</b></font> by <b>" + empName.toUpperCase()
							+ "</b> <a href='javascript:;' onclick='showReceiptOrderEmp(" + obj[2].toString()
							+ ")'>click here to view</a>. \n";
					count++;
				}
				SQLQuery query3 = session.createSQLQuery(
						"SELECT * FROM payment_order_staus_alert WHERE emp_id=" + userId + " ORDER BY id DESC");
				List<Object[]> result3 = query3.list();
				for (Object[] obj : result3) {
					String empName = getUserNameById((int) obj[4]);
					notification = notification + "<div>" + count + ".)" + "Payment order number <font color='red'><b>"
							+ obj[2].toString() + "</b></font> is <b><font color='#E67E22'<b>"
							+ obj[3].toString().toUpperCase() + "</b></font> by <b>" + empName.toUpperCase()
							+ "</b> <a href='javascript:;' onclick='showPaymentOrderEmp(" + obj[2].toString()
							+ ")'>click here to view</a>. \n";
					count++;
				}
				SQLQuery query4 = session.createSQLQuery(
						"SELECT * FROM creditNote_order_staus_alert WHERE emp_id=" + userId + " ORDER BY id DESC");
				List<Object[]> result4 = query4.list();
				for (Object[] obj : result4) {
					String empName = getUserNameById((int) obj[4]);
					notification = notification + "<div>" + count + ".)"
							+ "Credit Note order number <font color='red'><b>" + obj[2].toString()
							+ "</b></font> is <b><font color='#E67E22'<b>" + obj[3].toString().toUpperCase()
							+ "</b></font> by <b>" + empName.toUpperCase()
							+ "</b> <a href='javascript:;' onclick='showCreditNoteOrderEmp(" + obj[2].toString()
							+ ")'>click here to view</a>. \n";
					count++;
				}

				return notification + "|" + (count - 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "There is no any notification yet!";
	}

	public String getAlertsPO(int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT * from st_rm_txn_purchase_master_emp WHERE parent_id IN("
					+ userId + ") order by purchaseId DESC");
			if (userId == 1)
				query = session.createSQLQuery("SELECT * from st_rm_txn_purchase_master_emp order by purchaseId DESC");

			List<Object[]> result = query.list();
			String notification = "";
			int count = 1;
			for (Object[] obj : result) {
				String empName = getUserNameById((int) obj[3]);
				String color = "";
				if (obj[12].toString().equalsIgnoreCase("accepted"))
					color = "<font color='green'><br>(" + obj[12].toString() + " )<br></font>";
				else if (obj[12].toString().equalsIgnoreCase("pending"))
					color = "<font color='blue'><br>(" + obj[12].toString() + " )<br></font>";
				else
					color = "<font color='red'><br>(" + obj[12].toString() + " )<br></font>";
				notification = notification + "<div>" + count + ".)" + "Purchase Request" + " is generated by <b> "
						+ empName.toUpperCase() + "</b>.   Click <a href='javascript:;' onclick='goToPurchaseOrder("
						+ (int) obj[0] + ")'>PO-" + (int) obj[3] + "-" + (int) obj[0] + "</a> (" + obj[20].toString()
						+ ") here to check. " + color + "\n";
				count++;
			}
			return notification + "|" + (count - 1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "There is no any notification yet!";
	}

	public String getAlertsSO(int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT * from st_rm_txn_sales_master_emp WHERE order_status_by IN("
					+ userId + ") order by salesId DESC");
			if (userId == 1)
				query = session.createSQLQuery("SELECT * from st_rm_txn_sales_master_emp order by salesId DESC");

			List<Object[]> result = query.list();
			String notification = "";
			int count = 1;
			for (Object[] obj : result) {
				String empName = getUserNameById((int) obj[3]);
				String color = "";
				if (obj[12].toString().equalsIgnoreCase("accepted"))
					color = "<font color='green'><br>(" + obj[12].toString() + " )<br></font>";
				else if (obj[12].toString().equalsIgnoreCase("pending"))
					color = "<font color='blue'><br>(" + obj[12].toString() + " )<br></font>";
				else
					color = "<font color='red'><br>(" + obj[12].toString() + " )<br></font>";
				notification = notification + "<div>" + count + ".)" + "Sale Request" + " is generated by <b> "
						+ empName.toUpperCase() + "</b>.   Click <a href='javascript:;' onclick='goToSaleOrder("
						+ (int) obj[0] + ")'>SO-" + (int) obj[3] + "-" + (int) obj[0] + "</a> (" + obj[20].toString()
						+ ") here to check.  " + color.toUpperCase() + "</div>\n";
				count++;
			}
			return notification + "|" + (count - 1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "There is no any notification yet!";
	}

	public String getAlertsCN(int userId) {

		Logger logger = null;
		try {
			logger = Logger.getLogger(GameLobbyController.class.getName());
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT * from st_rm_txn_creditNote_master_emp WHERE order_status_by IN(" + userId
							+ ") order by cnId DESC");
			if (userId == 1)
				query = session.createSQLQuery("SELECT * from st_rm_txn_creditNote_master_emp order by cnId DESC");

			List<Object[]> result = query.list();
			String notification = "";
			int count = 1;
			for (Object[] obj : result) {
				String empName = getUserNameById((int) obj[3]);
				String color = "";
				if (obj[14].toString().equalsIgnoreCase("accepted"))
					color = "<font color='green'><br>(" + obj[14].toString() + " )<br></font>";
				else if (obj[14].toString().equalsIgnoreCase("pending"))
					color = "<font color='blue'><br>(" + obj[14].toString() + " )<br></font>";
				else
					color = "<font color='red'><br>(" + obj[14].toString() + " )<br></font>";
				notification = notification + "<div>" + count + ".)" + "Credit Note Request" + " is generated by <b> "
						+ empName.toUpperCase() + "</b>.   Click <a href='javascript:;' onclick='goToCN(" + (int) obj[0]
						+ ")'>CN-" + (int) obj[3] + "-" + (int) obj[0] + "</a> (" + obj[13].toString()
						+ ") here to check." + color.toUpperCase() + " </div>\n";
				count++;
			}
			return notification + "|" + (count - 1);

		} catch (Exception e) {
			logger.info("Error: While fething credit note alert");
		}
		return "There is no any notification yet!";
	}

	public String getAlertsDN(int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT * from st_rm_txn_debitNote_master_emp WHERE parent_id IN("
					+ userId + ") order by dnId DESC");
			if (userId == 1)
				query = session.createSQLQuery("SELECT * from st_rm_txn_debitNote_master_emp order by dnId DESC");

			List<Object[]> result = query.list();
			String notification = "";
			int count = 1;
			for (Object[] obj : result) {
				String empName = getUserNameById((int) obj[3]);
				notification = notification + "<div>" + count + ".)" + "Debit Note Request" + " is generated by <b> "
						+ empName.toUpperCase() + "</b>.   Click <a href='javascript:;' onclick='goToDN(" + (int) obj[0]
						+ ")'>DN-" + (int) obj[3] + "-" + (int) obj[0]
						+ "</a> here to check.     <a href='javascript:;' onclick='deleteNotificationById("
						+ (int) obj[0] + ")'>X</a> </div>\n";
				count++;
			}
			return notification + "|" + (count - 1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "There is no any notification yet!";
	}

	public String getAlertsPMT(int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT * from st_rm_txn_payment_master_emp WHERE parent_id IN("
					+ userId + ") order by paymentId DESC");
			if (userId == 1)
				query = session.createSQLQuery("SELECT * from st_rm_txn_payment_master_emp order by paymentId DESC");

			List<Object[]> result = query.list();
			String notification = "";
			int count = 1;
			for (Object[] obj : result) {
				String empName = getUserNameById((int) obj[2]);
				notification = notification + "<div>" + count + ".)" + "Payment Request" + " is generated by <b> "
						+ empName.toUpperCase() + "</b>.   Click <a href='javascript:;' onclick='goToPMT("
						+ (int) obj[0] + ")'>PMT-" + (int) obj[2] + "-" + (int) obj[0] + "</a> (" + obj[13].toString()
						+ ") here to check.     <a href='javascript:;' onclick='deleteNotificationById(" + (int) obj[0]
						+ ")'>X</a> </div>\n";
				count++;
			}
			return notification + "|" + (count - 1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "There is no any notification yet!";
	}

	public String getAlertsRCPT(int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();

			SQLQuery query = session
					.createSQLQuery("SELECT * from st_rm_txn_receipt_master_emp WHERE order_status_by IN(" + userId
							+ ") order by receiptId DESC");
			if (userId == 1)
				query = session.createSQLQuery("SELECT * from st_rm_txn_receipt_master_emp order by receiptId DESC");
			List<Object[]> result = query.list();
			String notification = "";
			int count = 1;
			for (Object[] obj : result) {
				String empName = getUserNameById((int) obj[2]);
				String color = "";
				if (obj[11].toString().equalsIgnoreCase("accepted"))
					color = "<font color='green'><br>(" + obj[11].toString() + " )<br></font>";
				else if (obj[11].toString().equalsIgnoreCase("pending"))
					color = "<font color='blue'><br>(" + obj[11].toString() + " )<br></font>";
				else
					color = "<font color='red'><br>(" + obj[11].toString() + " )<br></font>";
				notification = notification + "<div>" + count + ".)" + "Receipt Request" + " is generated by <b> "
						+ empName.toUpperCase() + "</b>.   Click <a href='javascript:;' onclick='goToRCPT("
						+ (int) obj[0] + ")'>RCPT-" + (int) obj[2] + "-" + (int) obj[0] + "</a> (" + obj[13].toString()
						+ ")here to check. " + color.toUpperCase() + "</div>\n";
				count++;
			}
			return notification + "|" + (count - 1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "There is no any notification yet!";
	}

	private String getUserNameById(int i) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT first_name from st_rm_bo_user_info WHERE user_id=" + i);
			List<String> list = query.list();
			return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String deleteAlert(String deleteId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("DELETE FROM `bo_um_login_alert` WHERE id=" + deleteId);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String fetchEmpPOData(int userId, String pOId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT * FROM st_rm_txn_purchase_master_emp WHERE purchaseId=" + pOId);
			List<Object[]> result = query.list();
			String data = "";
			for (Object[] obj : result) {
				String status = obj[12] != null ? obj[12].toString() : "pending";
				String doc = obj[21] != null ? obj[21].toString() : "no image found";
				data = "" + (int) obj[0] + "|" + obj[1].toString() + "|" + (int) obj[3] + "|" + obj[5].toString() + "|"
						+ obj[6].toString() + "|" + obj[7].toString() + "|" + obj[8].toString() + "|"
						+ obj[9].toString() + "|" + obj[11].toString() + "|" + status + "|" + obj[15].toString() + "|"
						+ obj[16].toString() + "|" + obj[17].toString() + "|" + obj[18].toString() + "|"
						+ obj[19].toString() + "|" + obj[20].toString() + "|" + doc;
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String fetchEmpPaymentData(int userId, String pOId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT * FROM st_rm_txn_payment_master_emp WHERE paymentId=" + pOId);
			List<Object[]> result = query.list();
			String data = "";
			for (Object[] obj : result) {
				data = "" + (int) obj[0] + "|" + (int) obj[1] + "|" + obj[3].toString() + "|" + obj[5].toString() + "|"
						+ obj[6].toString() + "|" + obj[7].toString() + "|" + obj[8].toString() + "|"
						+ obj[9].toString() + "|" + obj[10].toString() + "|" + obj[11].toString() + "|"
						+ obj[13].toString() + "|" + obj[14].toString();
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String fetchEmpReceiptData(int userId, String pOId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT * FROM st_rm_txn_receipt_master_emp WHERE receiptId=" + pOId);
			List<Object[]> result = query.list();
			String data = "";
			for (Object[] obj : result) {
				String rejectedReason = obj[15] != null ? obj[15].toString() : "undefined";
				data = "" + (int) obj[0] + "|" + (int) obj[1] + "|" + obj[3].toString() + "|" + obj[5].toString() + "|"
						+ obj[6].toString() + "|" + obj[7].toString() + "|" + obj[8].toString() + "|"
						+ obj[9].toString() + "|" + obj[10].toString() + "|" + obj[11].toString() + "|"
						+ obj[13].toString() + "|" + obj[14].toString() + "|" + rejectedReason;
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean createTransactionSalesEmp(String referenceNo, String employeeUnder, String partyAcc,
			String salesAccount, String salesStockItems, String amount, String qty, String rate, String narration,
			int userId, int parentUserId, String finalBal, String consignee, String dname, String propName,
			String contact, String address, String gstnNo) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			Date today = new Date();
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
			String date = df.format(today);
			int firstLevelUserId = getFirstLevelApproval(userId);
			if (firstLevelUserId == 0)
				firstLevelUserId = parentUserId;

			String sqlString = "INSERT INTO st_rm_txn_sales_master_emp(`party_acc_name`,`parent_id`,`emp_id`,`name_item`,`actual_qty`,`rate`,`amount`,`narration`,`finalBalance`,`is_consignee`,`dealer_name`,`prop_name`,`contact`,`address`,`gstnNo`,`sale_order_date`,`order_status_by`) values('"
					+ partyAcc + "'," + parentUserId + "," + userId + ",'" + salesStockItems + "','" + qty + "','"
					+ rate + "','" + amount + "','" + narration + "','" + finalBal + "','" + consignee + "','" + dname
					+ "','" + propName + "','" + contact + "','" + address + "','" + gstnNo + "','" + date + "',"
					+ firstLevelUserId + ")";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			sqlString = "SELECT max(salesId) from st_rm_txn_sales_master_emp WHERE emp_id=" + userId;
			SQLQuery query2 = session.createSQLQuery(sqlString);
			List<Integer> saleId = query2.list();
			sqlString = "INSERT INTO sale_order_staus_alert(`emp_id`,`order_id`,`status`,`changed_by`) values(" + userId
					+ ",'" + saleId.get(0) + "','pending'," + firstLevelUserId + ")";
			SQLQuery query3 = session.createSQLQuery(sqlString);

			query3.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public int getEmpSaleNo(int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "Select max(salesId) from st_rm_txn_sales_master_emp";
			SQLQuery query = session.createSQLQuery(sqlString);
			List id = query.list();
			if (id != null || !id.isEmpty()) {
				int myId = (int) id.get(0);
				myId += 1;
				return myId;
			}
		} catch (Exception e) {

		}
		return 1;
	}

	public boolean assignApprover(String functionName, String userName, String approverName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int functionId = getFunctionId(functionName);
			int userId = getUserIdByName(userName);
			int approverId = getUserIdByName(approverName);
			SQLQuery query = session.createSQLQuery(
					"INSERT INTO bo_um_user_approver_master(`user_id`,`approver_id`,`function_id`) values(" + userId
							+ "," + approverId + "," + functionId + ")");
			query.executeUpdate();
			query = session.createSQLQuery("UPDATE st_rm_bo_user_master SET parent_user_id=" + approverId);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private String getUserNameByIdFromMaster(int id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT user_name from st_rm_bo_user_master where user_id=" + id);
			List<String> res = query.list();
			return res.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private int getFunctionId(String functionName) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT id from bo_um_dynamic_field_master WHERE field_name='functions' and field_value='"
							+ functionName + "'");
			List<Integer> result = query.list();
			return result.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String fetchEmpSOData(int i, String sOId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_txn_sales_master_emp WHERE salesId=" + sOId);
			List<Object[]> result = query.list();
			String data = "";
			for (Object[] obj : result) {
				String status = obj[12] != null ? obj[12].toString() : "pending";
				String doc = obj[21] != null ? obj[21].toString() : "no image found";
				String rejectReason = obj[22] != null ? obj[22].toString() : "undefined";
				String isSuperCash = obj[10] != null ? obj[10].toString() : "No";

				data = "" + (int) obj[0] + "|" + obj[1].toString() + "|" + (int) obj[3] + "|" + obj[5].toString() + "|"
						+ obj[6].toString() + "|" + obj[7].toString() + "|" + obj[8].toString() + "|"
						+ obj[9].toString() + "|" + obj[11].toString() + "|" + status + "|" + obj[15].toString() + "|"
						+ obj[16].toString() + "|" + obj[17].toString() + "|" + obj[18].toString() + "|"
						+ obj[19].toString() + "|" + obj[20].toString() + "|" + doc + "|" + rejectReason + "|"
						+ isSuperCash;
			}

			query = session.createSQLQuery("SELECT * FROM st_rm_txn_sales_master_emp_others WHERE saleId=" + sOId);
			List<Object[]> resultMore = query.list();
			if (resultMore != null && resultMore.size() > 0 && !resultMore.isEmpty() && resultMore.get(0) != null) {

				for (Object[] obj : resultMore) {
					String ddn = obj[2] != null ? obj[2].toString() : "";
					String transport_name = obj[3] != null ? obj[3].toString() : "";
					String destination = obj[4] != null ? obj[4].toString() : "";
					String biit = obj[5] != null ? obj[5].toString() : "";
					String vehical_no = obj[6] != null ? obj[6].toString() : "";
					String transport_frieght = obj[7] != null ? obj[7].toString() : "";
					String local_frieght = obj[8] != null ? obj[8].toString() : "";
					String load_unload_charge = obj[9] != null ? obj[9].toString() : "";
					String ddn_doc = obj[10] != null ? obj[10].toString() : "";
					String billt_doc = obj[11] != null ? obj[11].toString() : "";
					data = data + "|" + ddn + "|" + transport_name + "|" + destination + "|" + biit + "|" + vehical_no
							+ "|" + transport_frieght + "|" + local_frieght + "|" + load_unload_charge + "|" + ddn_doc
							+ "|" + billt_doc;
					break;
				}
			} else {
				String ddn = "";
				String transport_name = "";
				String destination = "";
				String biit = "";
				String vehical_no = "";
				String transport_frieght = "";
				String local_frieght = "";
				String load_unload_charge = "";
				String ddn_doc = "";
				String billt_doc = "";
				data = data + "|" + ddn + "|" + transport_name + "|" + destination + "|" + biit + "|" + vehical_no + "|"
						+ transport_frieght + "|" + local_frieght + "|" + load_unload_charge + "|" + ddn_doc + "|"
						+ billt_doc;

			}

			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String fetchEmpCNData(int i, String sOId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_txn_creditNote_master_emp WHERE cnId=" + sOId);
			List<Object[]> result = query.list();
			String data = "";
			for (Object[] obj : result) {
				String status = obj[14] != null ? obj[14].toString() : "pending";
				String ddnDoc = obj[16] != null ? obj[16].toString() : "no image found";
				String billtDoc = obj[17] != null ? obj[17].toString() : "no image found";
				String rejectReason = obj[24] != null ? obj[24].toString() : "undefined";

				data = "" + (int) obj[0] + "|" + obj[1].toString() + "|" + (int) obj[3] + "|" + obj[5].toString() + "|"
						+ obj[6].toString() + "|" + obj[7].toString() + "|" + obj[8].toString() + "|"
						+ obj[9].toString() + "|" + obj[11].toString() + "|" + obj[12] + "|" + obj[13].toString() + "|"
						+ status + "|" + ddnDoc + "|" + billtDoc + "|" + obj[18] + "|" + obj[19] + "|" + obj[20] + "|"
						+ obj[21] + "|" + obj[22] + "|" + obj[23] + "|" + rejectReason;
			}

			query = session.createSQLQuery("SELECT * FROM st_rm_txn_credit_master_emp_others WHERE cnId=" + sOId);
			List<Object[]> resultMore = query.list();
			if (resultMore != null && resultMore.size() > 0 && !resultMore.isEmpty() && resultMore.get(0) != null) {

				for (Object[] obj : resultMore) {
					String ddn = obj[2] != null ? obj[2].toString() : "";
					String destination = obj[3] != null ? obj[3].toString() : "";
					String biit = obj[4] != null ? obj[4].toString() : "";
					String vehical_no = obj[5] != null ? obj[5].toString() : "";
					String transport_frieght = obj[6] != null ? obj[6].toString() : "";
					String local_frieght = obj[7] != null ? obj[7].toString() : "";
					String load_unload_charge = obj[8] != null ? obj[8].toString() : "";
					String deliveryCharge = obj[9] != null ? obj[9].toString() : "";
					data = data + "|" + ddn + "|" + destination + "|" + biit + "|" + vehical_no + "|"
							+ transport_frieght + "|" + local_frieght + "|" + load_unload_charge + "|" + deliveryCharge;
					break;
				}
			} else {
				String ddn = "";
				String destination = "";
				String biit = "";
				String vehical_no = "";
				String transport_frieght = "";
				String local_frieght = "";
				String load_unload_charge = "";
				String deliveryCharge = "";
				data = data + "|" + ddn + "|" + destination + "|" + biit + "|" + vehical_no + "|" + transport_frieght
						+ "|" + local_frieght + "|" + load_unload_charge + "|" + deliveryCharge;

			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String fetchEmpDNData(int i, String sOId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_txn_debitNote_master_emp WHERE dnId=" + sOId);
			List<Object[]> result = query.list();
			String data = "";
			for (Object[] obj : result) {
				data = "" + (int) obj[0] + "|" + obj[1].toString() + "|" + (int) obj[3] + "|" + obj[5].toString() + "|"
						+ obj[6].toString() + "|" + obj[7].toString() + "|" + obj[8].toString() + "|"
						+ obj[9].toString() + "|" + obj[11].toString();
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getStandardRate(String itemName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT item_unit_id,st_it_id from st_rm_stock_item_master WHERE item_name='" + itemName + "'");
			List<Object[]> res = query.list();
			int item_id = 0;
			int item_unit_id = 0;
			for (Object[] obj : res) {
				item_id = (int) obj[1];
				item_unit_id = (int) obj[0];
			}

			query = session.createSQLQuery(
					"select is_standard from st_rm_stock_item_unit_master where item_unit_id=" + item_unit_id);
			List<String> res1 = query.list();
			if (res1.get(0).equals("Yes")) {

				query = session.createSQLQuery(
						"select rate from st_rm_stock_item_godown_opening_blc where item_id=" + item_id);
				List<Integer> res2 = query.list();
				return String.valueOf(res2.get(0));
			} else {
				return "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getStandardRate(String itemName, String isSuperCash) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT item_unit_id,st_it_id from st_rm_stock_item_master WHERE item_name='" + itemName + "'");
			List<Object[]> res = query.list();
			int item_id = 0;
			int item_unit_id = 0;
			for (Object[] obj : res) {
				item_id = (int) obj[1];
				item_unit_id = (int) obj[0];
			}

			query = session.createSQLQuery(
					"select is_standard from st_rm_stock_item_unit_master where item_unit_id=" + item_unit_id);
			List<String> res1 = query.list();
			if (res1.get(0).equals("Yes")) {

				query = session.createSQLQuery(
						"select super_cash_amt from st_rm_stock_item_godown_opening_blc where item_id=" + item_id);
				List<Integer> res2 = query.list();
				return String.valueOf(res2.get(0));
			} else {
				return "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getBatchApplicable(String itemName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT item_unit_id from st_rm_stock_item_master WHERE item_name='" + itemName + "'");
			List<Integer> res = query.list();
			int item_unit_id = 0;
			item_unit_id = res.get(0);

			query = session.createSQLQuery(
					"select is_batches from st_rm_stock_item_unit_master where item_unit_id=" + item_unit_id);
			List<String> res1 = query.list();
			if (res1.get(0).equals("Yes")) {
				return "Yes";
			} else {
				return "No";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "No";
	}

	public StockItemBean getStockItemBeanById(String unit_id) {

		try {
			StockItemBean bean = new StockItemBean();
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM `st_rm_stock_item_master` AS a   LEFT JOIN  `st_rm_stock_item_unit_master` AS b ON a.item_unit_id = b.item_unit_id WHERE a.st_it_id="
							+ unit_id);
			List<Object[]> result = query.list();
			if (result != null || !result.isEmpty()) {
				for (Object[] obj : result) {

					bean.setItemId((int) obj[0]);
					bean.setItemName(obj[1].toString());
					bean.setUnderGroup(obj[2].toString());
					bean.setUnderCatagory(obj[3].toString());
					bean.setIsUnit(obj[4].toString());
					bean.setGstApplicable(obj[6].toString());
					bean.setAlterGST(obj[7].toString());
					bean.setSupplyType(obj[9].toString());
					bean.setRateDuty(obj[10].toString());
					bean.setIsAlternate(obj[12].toString());
					if (!obj[12].toString().equalsIgnoreCase("not applicable")) {
						bean.setConversionFrom(obj[13].toString() + " " + obj[13].toString());
						bean.setConversionTo(obj[15].toString() + " " + obj[15].toString());
					}
					bean.setIsBatches(obj[17].toString());
					if (bean.getIsBatches().equalsIgnoreCase("YES")) {
						bean.setDom(obj[18].toString());
						bean.setExpiry(obj[19].toString());
					}
					bean.setIsStandard(obj[20] != null ? obj[20].toString() : "");
					bean.setCostTrack(obj[22] != null ? obj[22].toString() : "");
				}
				query = session.createSQLQuery(
						"SELECT rate from st_rm_stock_item_godown_opening_blc WHERE item_id=" + unit_id);
				List<Integer> rateRes = query.list();
				bean.setItemRate(String.valueOf(rateRes.get(0)));
				return bean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean updateStockItemDetails(StockItemBean stockItemBean) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("UPDATE st_rm_stock_item_master SET	under_grp='"
					+ stockItemBean.getUnderGroup() + "',under_cat='" + stockItemBean.getUnderCatagory() + "',is_unit='"
					+ stockItemBean.getIsUnit() + "',is_gst_applicable='" + stockItemBean.getIsAlternate()
					+ "' WHERE st_it_id=" + stockItemBean.getItemId());
			query.executeUpdate();
			query = session.createSQLQuery(
					"SELECT item_unit_id from st_rm_stock_item_master WHERE st_it_id=" + stockItemBean.getItemId());
			List<Integer> id = query.list();
			int item_id = id.get(0);
			query = session.createSQLQuery("UPDATE st_rm_stock_item_unit_master SET is_standard='"
					+ stockItemBean.getIsStandard() + "',hsn_sac_code='" + stockItemBean.getHsnCode()
					+ "',bulk_unit_name='" + stockItemBean.getBulkUnit() + "' WHERE item_unit_id=" + item_id);
			query.executeUpdate();
			query = session.createSQLQuery("UPDATE st_rm_stock_item_godown_opening_blc SET rate="
					+ stockItemBean.getItemRate() + " WHERE item_id=" + stockItemBean.getItemId());
			query.executeUpdate();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public LedgerCustomBean getLedgerDetails(String ledger_id) {

		try {
			Session session = HibernateSessionFactory.getSession();
			LedgerCustomBean ledgerCustomBean = new LedgerCustomBean();
			SQLQuery query = session
					.createSQLQuery("SELECT * from st_rm_acc_ledger_master WHERE ledger_id=" + ledger_id);
			List<Object[]> res = query.list();
			if (res != null && res.size() > 0) {
				for (Object[] obj : res) {

					ledgerCustomBean.setLedgerId((int) obj[0]);
					ledgerCustomBean.setLedgerName(obj[1].toString());
					ledgerCustomBean.setLedgerUnder(obj[2].toString());
					ledgerCustomBean.setLocation(obj[4] != null ? obj[4].toString() : "");
					Integer id = (int) obj[8];
					ledgerCustomBean.setUnderEmp(id != null ? getUserNameByIdFromMaster(id) : "");
				}
			}
			SQLQuery query1 = session.createSQLQuery(
					"SELECT date_of_security_interest,security_amt from st_rm_ledger_interset_calculation where is_security='Yes' and ledger_id="
							+ ledger_id);
			List<Object[]> objRes1 = query1.list();
			if (objRes1 != null && !objRes1.isEmpty() && objRes1.size() > 0) {
				for (Object[] o : objRes1) {
					ledgerCustomBean.setIntersetStartDate(o[0] != null ? o[0].toString() : "");
					ledgerCustomBean.setSecAmount(o[1] != null ? o[1].toString() : "0");

				}

			}

			SQLQuery query2 = session.createSQLQuery("SELECT * from bo_um_ledger_details where ledgerId=" + ledger_id);
			List<Object[]> objRes = query2.list();
			if (objRes != null && !objRes.isEmpty() && objRes.size() > 0) {
				for (Object[] o : objRes) {
					ledgerCustomBean.setPropName(o[2] != null ? o[2].toString() : "");
					ledgerCustomBean.setContact(o[10] != null ? o[10].toString() : "");
					ledgerCustomBean.setEmail(o[15] != null ? o[15].toString() : "");
					ledgerCustomBean.setAddress(o[5] != null ? o[5].toString() : "");
					ledgerCustomBean.setResPerAddr(o[12] != null ? o[12].toString() : "");
					ledgerCustomBean.setDistrict(o[7] != null ? o[7].toString() : "");
					ledgerCustomBean.setTehsil(o[8] != null ? o[8].toString() : "");
					ledgerCustomBean.setPincode(o[9] != null ? o[9].toString() : "");
					ledgerCustomBean.setGstnNo(o[14] != null ? o[14].toString() : "");
				}

			}

			SQLQuery query3 = session.createSQLQuery("SELECT * from st_rm_credit_limit WHERE ledger_id=" + ledger_id);
			List<Object[]> res1 = query3.list();
			if (res1 != null && res1.size() > 0) {
				for (Object[] obj : res1) {
					ledgerCustomBean.setCreditPeriod((int) obj[2]);
					ledgerCustomBean.setCredit_limit((int) obj[4]);
					if ((int) obj[4] == -1)
						ledgerCustomBean.setCreditLimitEligible("No");
					else
						ledgerCustomBean.setCreditLimitEligible("Yes");

				}
			}
			SQLQuery query4 = session
					.createSQLQuery("SELECT * from st_rm_purchase_party_master_balance WHERE party_id=" + ledger_id);
			List<Object[]> res2 = query4.list();
			if (res2 != null && res2.size() > 0) {
				for (Object[] obj : res2) {
					ledgerCustomBean.setBalanceType(obj[3].toString());
					ledgerCustomBean.setOpeningBalance(obj[2].toString());
					ledgerCustomBean.setOpeningDate(obj[4] != null ? obj[4].toString() : "");
					ledgerCustomBean.setoBalance(obj[5] != null ? obj[5].toString() : "");
					ledgerCustomBean.setoBalanceType(obj[6] != null ? obj[6].toString() : "");
				}
			}
			return ledgerCustomBean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean saveUpdateLedgerData(LedgerCustomBean ledgerCustomBean) {
		Transaction transaction = null;
		try {
			int emp_id = getEmployeeId(ledgerCustomBean.getUnderEmp());

			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			if (ledgerCustomBean.getCreditPeriod() == 0)
				ledgerCustomBean.setCreditPeriod(-1);
			SQLQuery query = session.createSQLQuery("UPDATE st_rm_credit_limit SET credit_period="
					+ ledgerCustomBean.getCreditPeriod() + ", credit_limit=" + ledgerCustomBean.getCredit_limit()
					+ " WHERE ledger_id=" + ledgerCustomBean.getLedgerId());
			query.executeUpdate();

			/*
			 * query = session.
			 * createSQLQuery("UPDATE st_rm_purchase_party_master_balance SET opening_date='"
			 * + ledgerCustomBean.getOpeningDate() + "',balance='" +
			 * ledgerCustomBean.getOpeningBalance() + "',balance_type='" +
			 * ledgerCustomBean.getBalanceType() + "',opening_balnc='" +
			 * ledgerCustomBean.getoBalance() + "',opening_blnc_type='" +
			 * ledgerCustomBean.getoBalanceType() + "' WHERE party_id=" +
			 * ledgerCustomBean.getLedgerId()); query.executeUpdate();
			 */
			query = session.createSQLQuery("UPDATE st_rm_acc_ledger_master SET emp_under_id=" + emp_id + ",prop_name='"
					+ ledgerCustomBean.getPropName() + "',contact='" + ledgerCustomBean.getContact() + "',email='"
					+ ledgerCustomBean.getEmail() + "',address='" + ledgerCustomBean.getLocation()
					+ "' WHERE ledger_id=	" + ledgerCustomBean.getLedgerId());
			query.executeUpdate();
			query = session.createSQLQuery(
					"UPDATE st_rm_ledger_interset_calculation SET security_amt='" + ledgerCustomBean.getSecAmount()
							+ "',date_of_security_interest='" + ledgerCustomBean.getIntersetStartDate()
							+ "' WHERE ledger_id=" + ledgerCustomBean.getLedgerId() + " and is_security='Yes'");
			query.executeUpdate();
			query = session.createSQLQuery("UPDATE bo_um_ledger_details SET address='" + ledgerCustomBean.getAddress()
					+ "',district='" + ledgerCustomBean.getDistrict() + "',tehsil='" + ledgerCustomBean.getTehsil()
					+ "',pincode='" + ledgerCustomBean.getPincode() + "',resPerAddr='"
					+ ledgerCustomBean.getResPerAddr() + "',contact='" + ledgerCustomBean.getContact() + "',firmGSTN='"
					+ ledgerCustomBean.getGstnNo() + "' WHERE ledgerId=" + ledgerCustomBean.getLedgerId());
			query.executeUpdate();
			query = session.createSQLQuery(
					"UPDATE bo_um_ledger_details SET customerName='" + ledgerCustomBean.getPropName() + "',firmEmail='"
							+ ledgerCustomBean.getEmail() + "' WHERE ledgerId=	" + ledgerCustomBean.getLedgerId());
			query.executeUpdate();
			String partyTy = getPartyTypeById(ledgerCustomBean.getLedgerId());

			if (partyTy.equalsIgnoreCase("Sundry debtors")) {

				String partyDBBalanceYet = "0.0";
				String partyDBBalanceYetType = "";

				String openingBalanceOld = "0.0";

				Double updatedPartyBalance = 0.0;
				String updatedPartyBalanceType = "";

				query = session.createSQLQuery("SELECT * FROM st_rm_purchase_party_master_balance WHERE party_id="
						+ ledgerCustomBean.getLedgerId());
				List<Object[]> result = query.list();
				if (result != null && !result.isEmpty() && result.size() > 0) {

					for (Object[] obj : result) {
						partyDBBalanceYet = obj[2].toString();
						partyDBBalanceYetType = obj[3].toString();
						openingBalanceOld = obj[5].toString();
					}

					if (partyDBBalanceYetType.equalsIgnoreCase("Dr")
							&& ledgerCustomBean.getBalanceType().equalsIgnoreCase("Dr")) {

						updatedPartyBalance = Double.valueOf(partyDBBalanceYet) - Double.valueOf(openingBalanceOld);
						updatedPartyBalance = updatedPartyBalance
								+ Double.valueOf(ledgerCustomBean.getOpeningBalance());

						if (updatedPartyBalance < 0) {

							updatedPartyBalance = updatedPartyBalance * (-1);
							ledgerCustomBean.setBalanceType("Cr");
						}
						/*
						 * query = session.
						 * createSQLQuery("UPDATE st_rm_purchase_party_master_balance SET balance='" +
						 * updatedPartyBalance + "',balance_type='" + ledgerCustomBean.getBalanceType()
						 * + "',opening_balnc='" + ledgerCustomBean.getOpeningBalance() +
						 * "' WHERE party_id=" + ledgerCustomBean.getLedgerId()); query.executeUpdate();
						 * 
						 * query = session
						 * .createSQLQuery("UPDATE st_rm_party_txn_curr_balance_master SET party_balance_bef_txn='"
						 * + ledgerCustomBean.getOpeningBalance() + " " +
						 * ledgerCustomBean.getBalanceType() + "' WHERE date='" +
						 * ledgerCustomBean.getOpeningDate().split(" ")[0] +
						 * "' and  voucher_id='JSC/OPENING/BAL' and party_id=" +
						 * ledgerCustomBean.getLedgerId()); query.executeUpdate();
						 * 
						 * query = session.createSQLQuery(
						 * "UPDATE st_rm_bill_wise_details_sale SET balance='" + updatedPartyBalance +
						 * "' WHERE date='" + ledgerCustomBean.getOpeningDate().split(" ")[0] +
						 * "' and  sale_voucher_number='JSC/OPENING/BAL' and party_id=" +
						 * ledgerCustomBean.getLedgerId()); query.executeUpdate();
						 */

					}

					else if (partyDBBalanceYetType.equalsIgnoreCase("Cr")
							&& ledgerCustomBean.getBalanceType().equalsIgnoreCase("Dr")) {

						updatedPartyBalance = Double.valueOf(partyDBBalanceYet) - Double.valueOf(openingBalanceOld);
						updatedPartyBalance = updatedPartyBalance
								- Double.valueOf(ledgerCustomBean.getOpeningBalance());

						if (updatedPartyBalance < 0) {

							updatedPartyBalance = updatedPartyBalance * (-1);
							ledgerCustomBean.setBalanceType("Dr");
						}

						/*
						 * query = session.
						 * createSQLQuery("UPDATE st_rm_purchase_party_master_balance SET balance='" +
						 * updatedPartyBalance + "',balance_type='" + ledgerCustomBean.getBalanceType()
						 * + "',opening_balnc='" + ledgerCustomBean.getOpeningBalance() +
						 * "' WHERE party_id=" + ledgerCustomBean.getLedgerId()); query.executeUpdate();
						 * 
						 * query = session.
						 * createSQLQuery("UPDATE st_rm_party_txn_curr_balance_master SET balance='" +
						 * updatedPartyBalance + "',opening_balnc='" +
						 * ledgerCustomBean.getOpeningBalance() + " " +
						 * ledgerCustomBean.getBalanceType() + "' WHERE date='" +
						 * ledgerCustomBean.getOpeningDate().split(" ")[0] +
						 * "' and  voucher_id='JSC/OPENING/BAL' and party_id=" +
						 * ledgerCustomBean.getLedgerId()); query.executeUpdate();
						 * 
						 * query = session.createSQLQuery(
						 * "UPDATE st_rm_bill_wise_details_sale SET balance='" + updatedPartyBalance +
						 * "' WHERE date='" + ledgerCustomBean.getOpeningDate().split(" ")[0] +
						 * "' and  sale_voucher_number='JSC/OPENING/BAL' and party_id=" +
						 * ledgerCustomBean.getLedgerId()); query.executeUpdate();
						 */

					}
					// more cases are left for opening balance
				}

			}

			if (ledgerCustomBean.getCreditLimitEligible().equalsIgnoreCase("No")) {
				query = session.createSQLQuery("UPDATE st_rm_credit_limit SET credit_limit=-1 WHERE ledger_id="
						+ ledgerCustomBean.getLedgerId());
				query.executeUpdate();

			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public VoucherBean getVoucherNumbering(String type) {

		try {
			Session session = HibernateSessionFactory.getSession();
			VoucherBean bean = null;
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String Cdate = date.format(formatter) + " 00:00";
			if (type.equals("Sales")) {
				SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_voucher_master WHERE under_id=22");
				List<Object[]> res = query.list();
				if (res != null && !res.isEmpty()) {
					bean = new VoucherBean();
					for (Object[] obj : res) {
						bean.setAdvanceNumbering(obj[4].toString());
						bean.setVoucherNumbering(obj[3].toString());
						bean.setPrefix(obj[8].toString());
						bean.setSuffix(obj[9].toString());
						bean.setStartingNumber(obj[7].toString());
						bean.setDecimalNumber(obj[10].toString());
						bean.setCurrentDate(Cdate);
						bean.setStartDate(obj[11] != null ? obj[11].toString() : "");
						bean.setEndDate(obj[12] != null ? obj[12].toString() : "");
					}
				}
				return bean;
			} else if (type.equals("Credit Note")) {
				SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_voucher_master WHERE under_id=3");
				List<Object[]> res = query.list();
				if (res != null && !res.isEmpty()) {
					bean = new VoucherBean();
					for (Object[] obj : res) {
						bean.setAdvanceNumbering(obj[4].toString());
						bean.setVoucherNumbering(obj[3].toString());
						bean.setPrefix(obj[8].toString());
						bean.setSuffix(obj[9].toString());
						bean.setStartingNumber(obj[7].toString());
						bean.setDecimalNumber(obj[10].toString());
						bean.setCurrentDate(Cdate);
						bean.setStartDate(obj[11] != null ? obj[11].toString() : "");
						bean.setEndDate(obj[12] != null ? obj[12].toString() : "");
					}
				}
				return bean;

			} else if (type.equals("Debit Note")) {
				SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_voucher_master WHERE under_id=4");
				List<Object[]> res = query.list();
				if (res != null && !res.isEmpty()) {
					bean = new VoucherBean();
					for (Object[] obj : res) {
						bean.setAdvanceNumbering(obj[4].toString());
						bean.setVoucherNumbering(obj[3].toString());
						bean.setPrefix(obj[8].toString());
						bean.setSuffix(obj[9].toString());
						bean.setStartingNumber(obj[7].toString());
						bean.setDecimalNumber(obj[10].toString());
						bean.setCurrentDate(Cdate);
						bean.setStartDate(obj[11] != null ? obj[11].toString() : "");
						bean.setEndDate(obj[12] != null ? obj[12].toString() : "");
					}
				}
				return bean;

			} else if (type.equals("purchase")) {
				SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_voucher_master WHERE under_id=15");
				List<Object[]> res = query.list();
				if (res != null && !res.isEmpty()) {
					bean = new VoucherBean();
					for (Object[] obj : res) {
						bean.setAdvanceNumbering(obj[4].toString());
						bean.setVoucherNumbering(obj[3].toString());
						bean.setPrefix(obj[8].toString());
						bean.setSuffix(obj[9].toString());
						bean.setStartingNumber(obj[7].toString());
						bean.setDecimalNumber(obj[10].toString());
						bean.setCurrentDate(Cdate);
						bean.setStartDate(obj[11] != null ? obj[11].toString() : "");
						bean.setEndDate(obj[12] != null ? obj[12].toString() : "");
					}
				}
				return bean;

			} else if (type.equals("Receipt")) {
				SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_voucher_master WHERE under_id=17");
				List<Object[]> res = query.list();
				if (res != null && !res.isEmpty()) {
					bean = new VoucherBean();
					for (Object[] obj : res) {
						bean.setAdvanceNumbering(obj[4].toString());
						bean.setVoucherNumbering(obj[3].toString());
						bean.setPrefix(obj[8].toString());
						bean.setSuffix(obj[9].toString());
						bean.setStartingNumber(obj[7].toString());
						bean.setDecimalNumber(obj[10].toString());
						bean.setCurrentDate(Cdate);
						bean.setStartDate(obj[11] != null ? obj[11].toString() : "");
						bean.setEndDate(obj[12] != null ? obj[12].toString() : "");
					}
				}
				return bean;

			} else if (type.equals("Journal")) {
				SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_voucher_master WHERE under_id=8");
				List<Object[]> res = query.list();
				if (res != null && !res.isEmpty()) {
					bean = new VoucherBean();
					for (Object[] obj : res) {
						bean.setAdvanceNumbering(obj[4].toString());
						bean.setVoucherNumbering(obj[3].toString());
						bean.setPrefix(obj[8].toString());
						bean.setSuffix(obj[9].toString());
						bean.setStartingNumber(obj[7].toString());
						bean.setDecimalNumber(obj[10].toString());
						bean.setCurrentDate(Cdate);
						bean.setStartDate(obj[11] != null ? obj[11].toString() : "");
						bean.setEndDate(obj[12] != null ? obj[12].toString() : "");
					}
				}
				return bean;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getSaleVoucherNumber(String activeVoucherNumber) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT voucher_numbering FROM st_rm_txn_sales_master  WHERE LENGTH(voucher_numbering) = (SELECT MAX(LENGTH(voucher_numbering)) FROM st_rm_txn_sales_master where under_vcr_id="
							+ activeVoucherNumber + ") ORDER BY voucher_numbering DESC LIMIT 1");
			List<String> res = query.list();
			if (res != null && !res.isEmpty() && !res.get(0).isEmpty() && res.get(0) != null) {
				String data = res.get(0);
				String val = data.substring(data.lastIndexOf("/") + 1, data.length());
				return Integer.valueOf(val.trim());
			}

		} catch (Exception e) {
			System.out.println("ERROR WHILE FETCHING SALE VOUCHER NUMBER");
		}
		return 0;
	}

	public int getReceiptVoucherNumber(String activeVoucherNumber) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT voucher_numbering FROM st_rm_txn_receipt_master  WHERE LENGTH(voucher_numbering) = (SELECT MAX(LENGTH(voucher_numbering)) FROM st_rm_txn_receipt_master WHERE under_vcr_id="
							+ activeVoucherNumber + ") ORDER BY voucher_numbering DESC LIMIT 1");
			List<String> res = query.list();
			if (res != null && !res.isEmpty() && !res.get(0).isEmpty() && res.get(0) != null) {
				String data = res.get(0);
				String val = data.substring(data.lastIndexOf("/") + 1, data.length());
				return Integer.valueOf(val.trim());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getPaymentVoucherNumber(String activeVoucherNumber) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT voucher_numbering FROM st_rm_txn_payment_master  WHERE paymentId = (SELECT MAX(paymentId) FROM st_rm_txn_payment_master where under_vcr_id="
							+ activeVoucherNumber + ")");
			List<String> res = query.list();
			if (res != null && !res.isEmpty() && !res.get(0).isEmpty() && res.get(0) != null) {
				String data = res.get(0);
				String val = data.substring(data.lastIndexOf("/") + 1, data.length());
				return Integer.valueOf(val.trim());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getJournalVoucherNumber(String activeVoucherNumber) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT voucher_numbering FROM st_rm_txn_journal_master  WHERE journalId = (SELECT MAX(journalId) FROM st_rm_txn_journal_master where under_vcr_id="
							+ activeVoucherNumber + ")");
			List<String> res = query.list();
			if (res != null && !res.isEmpty() && !res.get(0).isEmpty() && res.get(0) != null) {
				String data = res.get(0);
				String val = data.substring(data.lastIndexOf("/") + 1, data.length());
				return Integer.valueOf(val.trim());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getCNVoucherNumber(String activeVoucherNumber) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT voucher_numbering FROM st_rm_txn_creditNote_master  WHERE cnId = (SELECT MAX(cnId) FROM st_rm_txn_creditNote_master where under_vcr_id="
							+ activeVoucherNumber + ")");
			List<String> res = query.list();
			if (res != null && !res.isEmpty() && !res.get(0).isEmpty() && res.get(0) != null) {
				String data = res.get(0);
				String val = data.substring(data.lastIndexOf("/") + 1, data.length());
				return Integer.valueOf(val.trim());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getDNVoucherNumber() {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT voucher_numbering FROM st_rm_txn_debitNote_master  WHERE dnId = (SELECT MAX(dnId) FROM st_rm_txn_debitNote_master)");
			List<String> res = query.list();
			if (res != null && !res.isEmpty() && !res.get(0).isEmpty() && res.get(0) != null) {
				String data = res.get(0);
				String val = data.substring(data.lastIndexOf("/") + 1, data.length());
				return Integer.valueOf(val.trim());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getPurchaseVoucherNumber(String activeVoucherNumber) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT voucher_numbering FROM st_rm_txn_purchase_master  WHERE purchaseId = (SELECT MAX(purchaseId) FROM st_rm_txn_purchase_master where under_vcr_id="
							+ activeVoucherNumber + ")");
			List<String> res = query.list();
			if (res != null && !res.isEmpty() && !res.get(0).isEmpty() && res.get(0) != null) {
				String data = res.get(0);
				String val = data.substring(data.lastIndexOf("/") + 1, data.length());
				return Integer.valueOf(val.trim());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean createTransactionCreditNote(String partyOldBalance, String employeeUnder, String partyAcc,
			String salesAccount, String salesStockItems, String amount, String qty, String rate, String narration,
			String cnNoVoucher, String paymentDate, String ddn, String tn, String des, String billt,
			String transportFreight, String vn, String under_vcr_id, String totalAmt, String godown, String batch,
			Session session, Transaction transaction) {

		try {
			int empId = getEmployeeId(employeeUnder);
			int partyId = getLedgerIdByName(partyAcc);
			String sqlString = "SELECT voucher_numbering from st_rm_txn_creditNote_master";
			SQLQuery query1 = session.createSQLQuery(sqlString);
			List<String> list = query1.list();
			if (list != null && !list.isEmpty()) {

				if (list.contains(cnNoVoucher)) {
					return false;
				}
			}
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date.format(formatter);
			if (paymentDate == null || paymentDate.isEmpty()) {
				paymentDate = currentDate;
			}
			sqlString = "INSERT INTO st_rm_txn_creditNote_master(`party_acc_name`,`emp_id`,`sales_ledger`,`name_item`,`actual_qty`,`rate`,`amount`,`narration`,`totalAmt`,`voucher_numbering`,`cn_date`,`ddn`,`transport_name`,`destination`,`bill_t`,`transport_fright`,`vehicle_no`,`under_vcr_id`,`godown`,`batch`) values('"
					+ partyAcc + "'," + empId + ",'" + salesAccount + "','" + salesStockItems + "','" + qty + "','"
					+ rate + "','" + amount + "','" + narration + "','" + totalAmt + "','" + cnNoVoucher + "','"
					+ paymentDate + "','" + ddn + "','" + tn + "','" + des + "','" + billt + "','" + transportFreight
					+ "','" + vn + "'," + under_vcr_id + ",'" + godown + "','" + batch + "')";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();

			String[] balnArr = partyOldBalance.split(" ");
			Double afterTxnBal = 0.0;
			String blncType = "";
			if (balnArr[1].equalsIgnoreCase("Cr")) {
				afterTxnBal = Double.valueOf(balnArr[0]) + Double.valueOf(totalAmt);
				blncType = "Cr";
			} else {
				afterTxnBal = Double.valueOf(balnArr[0]) - Double.valueOf(totalAmt);
				if (afterTxnBal < 0) {
					afterTxnBal = afterTxnBal * (-1);
					blncType = "Cr";
				} else
					blncType = "Dr";
			}
			String aftTxn = afterTxnBal + " " + blncType;
			sqlString = "INSERT INTO st_rm_party_txn_curr_balance_master(`party_id`,`party_balance_bef_txn`,`party_balance_aft_txn`,`date`,`txn_type`,`voucher_id`) values("
					+ partyId + ",'" + partyOldBalance + "','" + aftTxn + "','" + paymentDate + "','CREDIT NOTE','"
					+ cnNoVoucher + "')";
			SQLQuery query2 = session.createSQLQuery(sqlString);
			query2.executeUpdate();

			int salesAccountId = getLedgerIdByName(salesAccount);

			String salesAccountsqlString = "SELECT * from st_rm_purchase_party_master_balance where party_id="
					+ salesAccountId + "";
			SQLQuery salesAccountquery = session.createSQLQuery(salesAccountsqlString);
			List<Object[]> salesAccountresult = salesAccountquery.list();
			Double dbBalance = 0.0;
			String dbBalanceType = "";
			Double finalBal = 0.0;
			String finalBalType = "";
			if (salesAccountresult != null && !salesAccountresult.isEmpty()) {
				for (Object[] obj : salesAccountresult) {
					dbBalance = Double.valueOf(obj[2].toString());
					dbBalanceType = obj[3].toString();
					finalBal = dbBalance;
				}

			}
			if (dbBalanceType.trim().equalsIgnoreCase("Dr")) {
				finalBal = finalBal + Double.valueOf(totalAmt);
				finalBalType = "Dr";

			} else if (dbBalanceType.trim().equalsIgnoreCase("Cr")) {
				finalBal = finalBal - Double.valueOf(totalAmt);
				if (finalBal < 0.0) {
					finalBal = finalBal * (-1);
					finalBalType = "Dr";
				} else
					finalBalType = "Cr";

			} else {
				return false;
			}

			String salesAccountIdsqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + finalBal
					+ "',balance_type='" + finalBalType + "' WHERE party_id=" + salesAccountId + "";
			SQLQuery salesAccountIdquery2 = session.createSQLQuery(salesAccountIdsqlString);
			salesAccountIdquery2.executeUpdate();

			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean rejectSalesOrder(int salesNo, int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("UPDATE st_rm_txn_sales_master_emp SET order_status='rejected',order_status_by="
							+ userId + " WHERE salesId=" + salesNo);
			query.executeUpdate();
			SQLQuery query2 = session
					.createSQLQuery("UPDATE sale_order_staus_alert SET status='rejected' WHERE order_id=" + salesNo);
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean rejectPurchaseOrder(int purNo, int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("UPDATE st_rm_txn_purchase_master_emp SET order_status='rejected',order_status_by="
							+ userId + " WHERE purchaseId=" + purNo);
			query.executeUpdate();
			SQLQuery query2 = session
					.createSQLQuery("UPDATE purchase_order_staus_alert SET status='rejected' WHERE order_id=" + purNo);
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changeStatusSuccess(int salesNo, int userId, String saleVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("UPDATE st_rm_txn_sales_master_emp SET order_status='accepted',order_status_by="
							+ userId + " WHERE salesId=" + salesNo);
			query.executeUpdate();
			SQLQuery query2 = session
					.createSQLQuery("UPDATE sale_order_staus_alert SET status='accepted' WHERE order_id=" + salesNo);
			query2.executeUpdate();

			SQLQuery query3 = session.createSQLQuery("UPDATE st_rm_txn_sales_master_emp_others SET txn_sale_voucher='"
					+ saleVoucher + "' WHERE saleId=" + salesNo);
			query3.executeUpdate();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changeStatusSuccessCreditNote(int cnNo, int userId, String cnVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"UPDATE st_rm_txn_creditNote_master_emp SET order_status='accepted',order_status_by=" + userId
							+ " WHERE cnId=" + cnNo);
			query.executeUpdate();
			SQLQuery query2 = session
					.createSQLQuery("UPDATE creditNote_order_staus_alert SET status='accepted' WHERE order_id=" + cnNo);
			query2.executeUpdate();

			SQLQuery query3 = session
					.createSQLQuery("UPDATE st_rm_txn_credit_master_emp_others SET txn_credit_note_voucher='"
							+ cnVoucher + "' WHERE cnId=" + cnNo);
			query3.executeUpdate();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changeStatusSuccessPurchase(int purNo, int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("UPDATE st_rm_txn_purchase_master_emp SET order_status='accepted',order_status_by="
							+ userId + " WHERE purchaseId=" + purNo);
			query.executeUpdate();
			SQLQuery query2 = session
					.createSQLQuery("UPDATE purchase_order_staus_alert SET status='accepted' WHERE order_id=" + purNo);
			query2.executeUpdate();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String checkSalesOrder(int salesNo) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT order_status from  st_rm_txn_sales_master_emp WHERE salesId=" + salesNo);
			List<String> res = query.list();
			if (res != null) {
				return res.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String checkPurchaseOrder(int purNo) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT order_status from  st_rm_txn_purchase_master_emp WHERE purchaseId=" + purNo);
			List<String> res = query.list();
			if (res != null) {
				return res.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getLedgerNames(int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String suffix = "";
			if (userId != 1) {
				suffix = "Where emp_under_id=" + userId;
			}
			SQLQuery query = session.createSQLQuery("select ledger_name from st_rm_acc_ledger_master " + suffix);
			List<String> res = query.list();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}

	public boolean adjustSaleBill(String hiddenAmnt, String hiddenBilId, String typeOfRef, String partyAcc, String cnNo,
			Session session, Transaction transaction) {

		try {
			int partyId = getLedgerIdByName(partyAcc);
			String hiddenAmntArr[] = hiddenAmnt.split(",");
			String hiddenBilIdArr[] = hiddenBilId.split(",");
			String typeOfRefArr[] = typeOfRef.split(",");
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			for (int i = 0; i < hiddenAmntArr.length; i++) {

				if (typeOfRefArr[i].trim().equalsIgnoreCase("Agst Ref")) {
					Double _hiddenAmnt = Double.valueOf(hiddenAmntArr[i].trim());
					String _billNo = hiddenBilIdArr[i].trim();

					String sqlString = "SELECT balance from st_rm_bill_wise_details_sale WHERE party_id=" + partyId
							+ " and sale_voucher_number='" + _billNo + "'";
					SQLQuery query = session.createSQLQuery(sqlString);
					List<String> rs = query.list();
					Double old_amt = 0.0;
					if (rs != null && !rs.isEmpty()) {
						old_amt = Double.valueOf(rs.get(0));

					}

					// new code
					if (old_amt < _hiddenAmnt)
						return false;
					// end of new code check
					_hiddenAmnt = _hiddenAmnt - old_amt;

					if (_hiddenAmnt < 0)
						_hiddenAmnt = _hiddenAmnt * (-1);
					if (_hiddenAmnt == 0)
						sqlString = "UPDATE st_rm_bill_wise_details_sale SET balance='" + _hiddenAmnt
								+ "',is_used='Yes',purchase_used='Yes' WHERE party_id=" + partyId
								+ " and sale_voucher_number='" + _billNo + "'";
					else
						sqlString = "UPDATE st_rm_bill_wise_details_sale SET balance='" + _hiddenAmnt
								+ "' WHERE party_id=" + partyId + " and sale_voucher_number='" + _billNo + "'";
					SQLQuery query2 = session.createSQLQuery(sqlString);
					query2.executeUpdate();

					sqlString = "INSERT INTO st_rm_sale_creditNote_bill_mapping(`cnVcr`,`saleVcr`,`amount`,`type_of_ref`) values('"
							+ cnNo + "','" + _billNo + "','" + hiddenAmntArr[i].trim() + "','" + typeOfRefArr[i].trim()
							+ "')";
					SQLQuery queryC = session.createSQLQuery(sqlString);
					queryC.executeUpdate();

				} else {
					Double _hiddenAmnt = Double.valueOf(hiddenAmntArr[i].trim());
					String _billNo = hiddenBilIdArr[i].trim();
					String sqlString = "SELECT bill_id from st_rm_bill_wise_details_sale WHERE party_id=" + partyId
							+ " and type_of_ref IN('Agst Ref','Advance')";
					SQLQuery query = session.createSQLQuery(sqlString);
					List<Integer> id = query.list();
					int bill_id = 0;
					if (id != null && !id.isEmpty() && id.size() > 0) {
						bill_id = id.get(0);
					}
					bill_id = bill_id + 1;
					String bType = "Cr";
					if (typeOfRefArr[i].trim().equalsIgnoreCase("Agst Ref")) {
						bType = "Dr";

					}
					sqlString = "INSERT INTO st_rm_bill_wise_details_sale(`type_of_ref`,`party_id`,`balance`,`is_used`,`date`,`blnc_type`,`purchase_used`,`sale_voucher_number`) values('"
							+ typeOfRefArr[i].trim() + "'," + partyId + ",'" + hiddenAmntArr[i].trim() + "','No','"
							+ date.format(formatter) + "','" + bType + "','No','" + bill_id + "')";
					SQLQuery query2 = session.createSQLQuery(sqlString);
					query2.executeUpdate();

					sqlString = "INSERT INTO st_rm_sale_creditNote_bill_mapping(`cnVcr`,`saleVcr`,`amount`,`type_of_ref`) values('"
							+ cnNo + "','" + _billNo + "','" + hiddenAmntArr[i].trim() + "','" + typeOfRefArr[i].trim()
							+ "')";
					SQLQuery queryC = session.createSQLQuery(sqlString);
					queryC.executeUpdate();

				}
			}
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	private int getLedgerIdByName(String partyAcc) {

		try {
			Session session = HibernateSessionFactory.getSession();

			SQLQuery query = session.createSQLQuery(
					"select ledger_id from st_rm_acc_ledger_master WHERE ledger_name='" + partyAcc + "'");
			List<Integer> res = query.list();
			return res.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	private int getRetailerIdByName(String partyAcc) {

		try {
			Session session = HibernateSessionFactory.getSession();

			SQLQuery query = session
					.createSQLQuery("select id from crm_retailer_master WHERE firm_name='" + partyAcc + "'");
			List<Integer> res = query.list();
			return res.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String getBillsOfParty(String ledgerName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int ledgerId = getLedgerIdByName(ledgerName);
			SQLQuery query = session.createSQLQuery(
					"SELECT sale_voucher_number from st_rm_bill_wise_details_sale WHERE party_id=" + ledgerId);
			List<String> list = query.list();
			String data = "";
			if (list != null && !list.isEmpty() && list.size() > 0) {
				for (String s : list) {
					data = data + s + ";";
				}
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getBillsOfPartyOverDue(String ledgerName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			Date today = new Date();
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
			c.setTimeZone(tz);
			String date = df.format(today);

			int ledgerId = getLedgerIdByName(ledgerName);
			Integer by = 0;
			Integer graceP = 0;
			Integer totalPeriod = 0;
			SQLQuery sqlQuery = session
					.createSQLQuery("select `by`,`grace_period` from st_rm_ledger_interset_calculation where ledger_id="
							+ ledgerId + " and is_security='No' and rate_on='Debit Balances Only'");
			List<Object[]> result = sqlQuery.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				for (Object[] o : result) {
					by = Integer.valueOf(o[0].toString());
					graceP = Integer.valueOf(o[1].toString());
				}

			}
			totalPeriod = by + graceP;

			SQLQuery query = session
					.createSQLQuery("SELECT date,sale_voucher_number from st_rm_bill_wise_details_sale WHERE party_id="
							+ ledgerId + " and is_used='No' and type_of_ref='Agst Ref'");
			List<Object[]> listResult = query.list();
			String data = "";
			if (listResult != null && !listResult.isEmpty() && listResult.size() > 0) {
				for (Object[] obj : listResult) {
					String billDate = obj[0].toString();
					c.setTime(df.parse(billDate));
					c.add(Calendar.DAY_OF_MONTH, totalPeriod);
					// Date after adding the days to the given date
					String dateAftPeriod = df.format(c.getTime());
					SQLQuery queryChk = session
							.createSQLQuery("SELECT * FROM temp_old_bill_bulk_schedule_master WHERE voucher_number='"
									+ obj[1].toString() + "'");
					List<Object[]> resultChk = queryChk.list();
					if (resultChk != null && !resultChk.isEmpty() && resultChk.size() > 0) {
						continue;
					} else {
						if (compareTwoDate(dateAftPeriod, date)) {
							data = data + obj[1].toString() + ";";
						}
					}

				}
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public SaleBillsBean getResultOfBills(String ledgerName, String billList) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SaleBillsBean bean = new SaleBillsBean();
			int ledgerId = getLedgerIdByName(ledgerName);
			SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_bill_wise_details_sale WHERE party_id="
					+ ledgerId + " and sale_voucher_number='" + billList.trim() + "'");
			List<Object[]> result = query.list();
			for (Object[] obj : result) {
				bean.setBalance(obj[3].toString());
				bean.setBalanceType(obj[6].toString());
				bean.setBillDate(obj[5].toString());
				bean.setIsAdjust(obj[4].toString());
				bean.setPartyName(ledgerName);
				bean.setRefType(obj[1].toString());
				bean.setVoucherNo(obj[8].toString());
			}
			return bean;
		} catch (Exception r) {
			r.printStackTrace();
		}
		return null;
	}

	public String getPropName(String partyName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int ledId = getLedgerIdByName(partyName);
			SQLQuery query = session
					.createSQLQuery("SELECT customerName from bo_um_ledger_details where ledgerId=" + ledId + "");
			List<String> res = query.list();
			return res.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPropName(int partyId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT customerName from bo_um_ledger_details where ledgerId=" + partyId + "");
			List<String> res = query.list();
			return res.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPropFirmName(int partyId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT firmName from bo_um_ledger_details where ledgerId=" + partyId + "");
			List<String> res = query.list();
			return res.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPropContact(String partyName) {

		Logger logger = Logger.getLogger(GameLobbyController.class.getName());
		try {
			Session session = HibernateSessionFactory.getSession();
			int ledgerId = getLedgerIdByName(partyName);
			SQLQuery query = session
					.createSQLQuery("SELECT contact from bo_um_ledger_details where ledgerId=" + ledgerId + "");
			List<String> res = query.list();
			return res.get(0);
		} catch (Exception e) {
			logger.info("ERROR: unable to get properiter contact......");
		}
		return "";
	}

	public String getPropContact(int ledgerId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT contact from bo_um_ledger_details where ledgerId=" + ledgerId + "");
			List<String> res = query.list();
			return res.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getUnderEmpName(String partyAcc) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT emp_under_id from st_rm_acc_ledger_master where ledger_name='" + partyAcc + "'");
			List<Integer> res = query.list();
			int id = 0;
			if (res != null && !res.isEmpty() && res.size() > 0)
				id = res.get(0);
			query = session.createSQLQuery("SELECT user_name from st_rm_bo_user_master WHERE user_id=" + id);
			List<String> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getUnderEmpName(int partyAcc) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT emp_under_id from st_rm_acc_ledger_master where ledger_id=" + partyAcc + "");
			List<Integer> res = query.list();
			int id = 0;
			if (res != null && !res.isEmpty() && res.size() > 0)
				id = res.get(0);
			query = session.createSQLQuery("SELECT user_name from st_rm_bo_user_master WHERE user_id=" + id);
			List<String> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getUnderEmpMobile(String partyAcc) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT emp_under_id from st_rm_acc_ledger_master where ledger_name='" + partyAcc + "'");
			List<Integer> res = query.list();
			int id = 0;
			if (res != null && !res.isEmpty() && res.size() > 0)
				id = res.get(0);
			query = session.createSQLQuery("SELECT phone_num from st_rm_bo_user_info WHERE user_id=" + id);
			List<String> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getUnderEmpMobile(int partyAcc) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT emp_under_id from st_rm_acc_ledger_master where ledger_id=" + partyAcc + "");
			List<Integer> res = query.list();
			int id = 0;
			if (res != null && !res.isEmpty() && res.size() > 0)
				id = res.get(0);
			query = session.createSQLQuery("SELECT phone_num from st_rm_bo_user_info WHERE user_id=" + id);
			List<String> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public Map<String, VisitBean> getVisitReport(String attendanceDate, String empId) {

		try {
			VisitBean visitBean = null;
			Map<String, VisitBean> map = new HashMap<String, VisitBean>();
			Session session = HibernateSessionFactory.getSession();
			empId = empId.replaceAll("CRM-", "");
			SQLQuery query = session.createSQLQuery("SELECT detail_id from bo_um_employee_attendance where date='"
					+ attendanceDate + "' and emp_id=" + empId);
			List<Integer> did = query.list();
			int _detId = did.get(0);
			SQLQuery query2 = session.createSQLQuery("SELECT * FROM bo_um_attendance_visit where detail_id=" + _detId);
			List<Object[]> res = query2.list();
			int i = 1;
			for (Object[] obj : res) {
				visitBean = new VisitBean();
				visitBean.setVisitUniqueId(String.valueOf((int) obj[0]));
				visitBean.setAddress(obj[9] != null ? obj[9].toString() : "");
				visitBean.setComment(obj[13] != null ? obj[13].toString() : "");
				visitBean.setContact(obj[8] != null ? obj[8].toString() : "");
				visitBean.setCustomerType(obj[3] != null ? obj[3].toString() : "");
				visitBean.setDistributor(obj[4] != null ? obj[4].toString() : "");
				visitBean.setDistrict(obj[10] != null ? obj[10].toString() : "");
				visitBean.setPropName(obj[7] != null ? obj[7].toString() : "");
				visitBean.setPurpose(obj[12] != null ? obj[12].toString() : "");
				visitBean.setReminder(obj[14] != null ? obj[14].toString() : "");
				visitBean.setRetailer(obj[5] != null ? obj[5].toString() : "");
				visitBean.setRetailerName(obj[6] != null ? obj[6].toString() : "");
				visitBean.setVisitPurpose(obj[11] != null ? obj[11].toString() : "");
				map.put("visit-" + i, visitBean);
				i++;
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, VisitBean> getVisitReportByDistributor(String disName, String visitId) {

		try {
			VisitBean visitBean = null;
			Map<String, VisitBean> map = new HashMap<String, VisitBean>();
			Session session = HibernateSessionFactory.getSession();
			String[] visitIdArr = visitId.split(";");
			int i = 1;
			for (String s : visitIdArr) {
				if (!s.isEmpty()) {
					SQLQuery query2 = session.createSQLQuery("SELECT * FROM bo_um_attendance_visit where id=" + s);
					List<Object[]> res = query2.list();

					for (Object[] obj : res) {
						visitBean = new VisitBean();
						SQLQuery query = session.createSQLQuery(
								"SELECT * from bo_um_employee_attendance WHERE detail_id=" + (int) obj[1]);
						List<Object[]> dateRes = query.list();
						if (dateRes != null && !dateRes.isEmpty()) {
							for (Object[] o : dateRes) {
								try {
									String[] dateArr = o[3].toString().split("-");
									visitBean.setVisitDate(dateArr[2] + "-" + dateArr[1] + "-" + dateArr[0]);
								} catch (Exception e1) {
								}
							}

						}
						visitBean.setVisitUniqueId(String.valueOf((int) obj[0]));
						visitBean.setAddress(obj[9] != null ? obj[9].toString() : "");
						visitBean.setComment(obj[13] != null ? obj[13].toString() : "");
						visitBean.setContact(obj[8] != null ? obj[8].toString() : "");
						visitBean.setCustomerType(obj[3] != null ? obj[3].toString() : "");
						visitBean.setDistributor(obj[4] != null ? obj[4].toString() : "");
						visitBean.setDistrict(obj[10] != null ? obj[10].toString() : "");
						visitBean.setPropName(obj[7] != null ? obj[7].toString() : "");
						visitBean.setPurpose(obj[12] != null ? obj[12].toString() : "");
						visitBean.setReminder(obj[14] != null ? obj[14].toString() : "");
						visitBean.setRetailer(obj[5] != null ? obj[5].toString() : "");
						visitBean.setRetailerName(obj[6] != null ? obj[6].toString() : "");
						visitBean.setVisitPurpose(obj[11] != null ? obj[11].toString() : "");
						map.put("visit-" + i, visitBean);
						i++;
					}
				}
			}

			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, VisitBean> getVisitReport(String empName, String fromDate, String toDate) {

		try {
			VisitBean visitBean = null;
			Map<String, VisitBean> map = new HashMap<String, VisitBean>();
			Session session = HibernateSessionFactory.getSession();
			int empId = getEmployeeId(empName);
			String sqlString = "";
			if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty())
				sqlString = "SELECT detail_id from bo_um_employee_attendance where STR_TO_DATE(`date`,'%Y-%m-%d') >= STR_TO_DATE('"
						+ fromDate + "','%d-%m-%Y') and STR_TO_DATE(`date`,'%Y-%m-%d') <= STR_TO_DATE('" + toDate
						+ "','%d-%m-%Y') and emp_id=" + empId;
			else
				sqlString = "SELECT detail_id from bo_um_employee_attendance where emp_id=" + empId;

			SQLQuery query = session.createSQLQuery(sqlString);
			List<Integer> did = query.list();
			if (did != null && did.size() > 0) {
				for (Integer id : did) {
					SQLQuery query2 = session
							.createSQLQuery("SELECT * FROM bo_um_attendance_visit where detail_id=" + id);
					List<Object[]> res = query2.list();

					for (Object[] obj : res) {
						visitBean = new VisitBean();
						// visitBean.setAddress(obj[9] != null ? obj[9].toString() : "");
						// visitBean.setComment(obj[13] != null ? obj[13].toString() : "");
						visitBean.setContact(obj[8] != null ? obj[8].toString() : "");
						// visitBean.setCustomerType(obj[3] != null ? obj[3].toString() : "");
						visitBean.setDistributor(obj[4] != null ? obj[4].toString() : "none");
						// visitBean.setDistrict(obj[10] != null ? obj[10].toString() : "");
						visitBean.setPropName(obj[7] != null ? obj[7].toString() : "");
						// visitBean.setPurpose(obj[12] != null ? obj[12].toString() : "");
						// visitBean.setReminder(obj[14] != null ? obj[14].toString() : "");
						// visitBean.setRetailer(obj[5] != null ? obj[5].toString() : "");
						visitBean.setRetailerName(obj[6] != null ? obj[6].toString() : "");
						// visitBean.setVisitPurpose(obj[11] != null ? obj[11].toString() : "");
						if (map.get(visitBean.getDistributor()) == null) {
							visitBean.setNoOfVisit("1");
							visitBean.setVisitUniqueId(String.valueOf((int) obj[0]) + ";");
							map.put(visitBean.getDistributor().trim().toUpperCase(), visitBean);

						} else {
							int c = Integer
									.valueOf(map.get(visitBean.getDistributor().trim().toUpperCase()).getNoOfVisit());
							c = c + 1;
							visitBean.setNoOfVisit("" + c);
							String vid = map.get(visitBean.getDistributor().trim().toUpperCase()).getVisitUniqueId();
							vid = vid + String.valueOf((int) obj[0]) + ";";
							visitBean.setVisitUniqueId(vid);
							map.put(visitBean.getDistributor().trim().toUpperCase(), visitBean);
						}

					}
				}
			}

			SQLQuery query2 = session.createSQLQuery(
					"SELECT DISTINCT ledger_name FROM `st_rm_acc_ledger_master`  a INNER JOIN `bo_um_ledger_user_mapping` b ON a.ledger_id = b.ledger_id AND b.emp_id = "
							+ empId);
			List<String> resultLedger = query2.list();
			if (resultLedger != null && !resultLedger.isEmpty()) {

				for (String str : resultLedger) {

					if (map.get(str.trim().toUpperCase()) == null) {
						visitBean = new VisitBean();
						visitBean.setDistributor(str.toUpperCase());
						visitBean.setNoOfVisit("0");
						map.put(str.trim().toUpperCase(), visitBean);
					}
				}
			}

			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, VoucherBean> getAvailableVoucherList(String voucherUnderName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			VoucherBean bean = null;
			Map<String, VoucherBean> map = new HashMap<String, VoucherBean>();
			SQLQuery query = session.createSQLQuery(
					"SELECT vchr_id FROM st_rm_voucher_list_master where voucher_name='" + voucherUnderName + "'");
			List<Integer> list = query.list();
			int vcrId = list.get(0);
			SQLQuery query2 = session.createSQLQuery("SELECT * FROM st_rm_voucher_master WHERE under_id=" + vcrId);
			List<Object[]> res = query2.list();
			if (res != null && res.size() > 0 && !res.isEmpty()) {
				int i = 1;
				for (Object[] obj : res) {
					bean = new VoucherBean();
					bean.setVoucherId((int) obj[0]);
					bean.setVoucherName(obj[1].toString());
					bean.setPrefix(obj[8].toString());
					bean.setSuffix(obj[9].toString());
					bean.setStartingNumber(obj[7].toString());
					bean.setStartDate(obj[11].toString());
					bean.setEndDate(obj[12].toString());
					bean.setStatus(obj[13].toString());
					map.put(String.valueOf(i), bean);
					i++;
				}
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean changeVoucherStatus(String voucherId, String status) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("UPDATE st_rm_voucher_master SET status='" + status.toUpperCase()
					+ "' WHERE new_vcr_id=" + voucherId);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getActiveVoucher(String type) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int underId = 0;
			if (type.equalsIgnoreCase("Sales"))
				underId = 22;
			else if (type.equalsIgnoreCase("receipt"))
				underId = 17;
			else if (type.equalsIgnoreCase("journal"))
				underId = 8;
			else if (type.equalsIgnoreCase("credit note"))
				underId = 3;
			else if (type.equalsIgnoreCase("purchase"))
				underId = 15;
			else if (type.equalsIgnoreCase("payment"))
				underId = 12;
			SQLQuery query = session.createSQLQuery(
					"SELECT new_vcr_id from st_rm_voucher_master where status='ACTIVE' and under_id=" + underId);
			List<Integer> list = query.list();
			if (list != null && !list.isEmpty() && list.size() > 0) {
				if (list.size() > 1) {
					return "duplicate";
				} else {
					return String.valueOf(list.get(0));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "not found";
	}

	public VoucherBean getVoucherNumbering(String string, String checkIsVoucherActive) {

		try {
			Session session = HibernateSessionFactory.getSession();
			VoucherBean bean = null;
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String Cdate = date.format(formatter) + " 00:00";
			int underId = 0;
			if (string.equals("Sales"))
				underId = 22;
			else if (string.equals("Receipt"))
				underId = 17;
			else if (string.equals("journal"))
				underId = 8;
			else if (string.equals("credit note"))
				underId = 3;
			else if (string.equals("purchase"))
				underId = 15;
			else if (string.equals("payment"))
				underId = 12;

			SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_voucher_master WHERE under_id=" + underId
					+ " and new_vcr_id=" + checkIsVoucherActive);
			List<Object[]> res = query.list();
			if (res != null && !res.isEmpty()) {
				bean = new VoucherBean();
				for (Object[] obj : res) {
					bean.setAdvanceNumbering(obj[4].toString());
					bean.setVoucherNumbering(obj[3].toString());
					bean.setPrefix(obj[8].toString());
					bean.setSuffix(obj[9].toString());
					bean.setStartingNumber(obj[7].toString());
					bean.setDecimalNumber(obj[10].toString());
					bean.setCurrentDate(Cdate);
					bean.setStartDate(obj[11] != null ? obj[11].toString() : "");
					bean.setEndDate(obj[12] != null ? obj[12].toString() : "");
				}
			}
			return bean;

		} catch (Exception e) {
			System.out
					.println("{}Error while fetching voucher numbering due to no entry found in st_rm_voucher_master");
			// e.printStackTrace();
		}
		return null;
	}

	private boolean compareTwoDate(String first, String second) {

		try {
			if (!first.contains("00:00"))
				first = first + " 00:00";
			if (!second.contains("00:00"))
				second = second + " 00:00";
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:m");
			if (sdf.parse(second).after(sdf.parse(first))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	private boolean compareEqualsDate(String first, String second) {

		try {
			if (!first.contains("00:00"))
				first = first + " 00:00";
			if (!second.contains("00:00"))
				second = second + " 00:00";

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:m");
			if (sdf.parse(second).equals(sdf.parse(first))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public void calculateTaxOnDebitBalanceOnly() {
		Transaction transaction = null;
		try {
			Logger logger = Logger.getLogger(GameLobbyController.class.getName());
			logger.info("::::::::::::SCHEDULING START OF TAX REPORT:::::::::::::::::::::::::");
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date.format(formatter);
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM st_rm_ledger_interset_calculation WHERE rate_on IN('Debit Balances Only')");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				for (Object[] obj : result) {
					String IstxnByTxn = obj[2].toString();
					String alwaysOrPastDueDate = obj[9].toString();
					String calculateFrom = obj[12].toString();
					if (IstxnByTxn.equalsIgnoreCase("yes")) {
						logger.info("::::::::::::INSIDE BILL WISE :::::::::::::::::::::::::");
						String rateMonthOrYear = obj[7].toString();
						if (rateMonthOrYear.equalsIgnoreCase("Calendar Month")) {
							logger.info("::::::::::::INSIDE CALENDAR MONTH:::::::::::::::::::::::::");
							String dueLimit = !obj[10].toString().isEmpty() ? obj[10].toString() : "0";
							String gracePeriod = !obj[11].toString().isEmpty() ? obj[11].toString() : "0";
							Integer totalDays = Integer.valueOf(dueLimit) + Integer.valueOf(gracePeriod);
							if (alwaysOrPastDueDate.equalsIgnoreCase("Always"))
								totalDays = 0;
							Integer ledgerId = (int) obj[1];

							SQLQuery query1 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details_sale WHERE type_of_ref IN('Agst Ref') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> saleBillsresult = query1.list();
							if (saleBillsresult != null && !saleBillsresult.isEmpty() && saleBillsresult.size() > 0) {

								for (Object[] saleObj : saleBillsresult) {
									if (isInterestAllow(ledgerId))
										continue;
									String saleBillDate = saleObj[5].toString();
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);
									c.setTime(sdf.parse(saleBillDate));
									c.add(Calendar.DAY_OF_MONTH, totalDays);
									String datePeriod = sdf.format(c.getTime());

									if (compareTwoDate(datePeriod + " 00:00", currentDate + " 00:00")) {

										Double taxRate = Double.valueOf(obj[6].toString());
										taxRate = taxRate * 12;
										int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
										logger.info("------------------->DAYS IN MONTH IS :" + monthMaxDays);
										double dayPercentRateCalculate = (taxRate / 365);

										Double saleBillAmount = Double.valueOf(saleObj[3].toString());
										Double repsaleBillAmount = saleBillAmount;
										Double billTax = (saleBillAmount * dayPercentRateCalculate) / 100;
										saleBillAmount = saleBillAmount + billTax;
										int saleBillId = (int) saleObj[0];
										logger.info("::::::::::::SALE BILL :::::::::::::::::::::::::" + saleBillId);
										String saleTaxAmountOld = saleObj[9].toString();
										Double saleTaxAmountNew = Double.valueOf(saleTaxAmountOld) + billTax;

										SQLQuery updateBillQuery = session
												.createSQLQuery("UPDATE st_rm_bill_wise_details_sale SET balance='"
														+ String.format("%.2f", saleBillAmount) + "',tax_amount='"
														+ String.format("%.2f", saleTaxAmountNew) + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + saleBillId);
										updateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString().trim();
											blncTyp = o[3].toString().trim();
										}
										if (blncTyp.equals("Dr")) {
											String balanceType = "Dr";
											String _partyBlnc = String.valueOf(Double.valueOf(partyBlnc) + billTax);
											Double stringformatterBal = Double.valueOf(partyBlnc) + billTax;
											SQLQuery queryCurBal = session.createSQLQuery(
													"UPDATE st_rm_purchase_party_master_balance SET balance='"
															+ String.format("%.2f", stringformatterBal)
															+ "',balance_type='" + balanceType + "' WHERE party_id="
															+ ledgerId);
											queryCurBal.executeUpdate();

										} else if (blncTyp.equals("Cr")) {

											String balanceType = "Cr";
											String _partyBlnc = String.valueOf(Double.valueOf(partyBlnc) + billTax);
											Double stringformatterBal = Double.valueOf(partyBlnc) + billTax;
											if (stringformatterBal < 0) {
												stringformatterBal = stringformatterBal * (-1);
												balanceType = "Dr";
											}
											SQLQuery queryCurBal = session.createSQLQuery(
													"UPDATE st_rm_purchase_party_master_balance SET balance='"
															+ String.format("%.2f", stringformatterBal)
															+ "',balance_type='" + balanceType + "' WHERE party_id="
															+ ledgerId);
											queryCurBal.executeUpdate();

											/*
											 * SQLQuery queryRate = session.createSQLQuery(
											 * "SELECT rate FROM st_rm_ledger_interset_calculation WHERE rate_on IN('Credit Balances Only') and ledger_id="
											 * + ledgerId + " limit 1"); List<String> queryRateRes = queryRate.list();
											 * if (queryRateRes != null && !queryRateRes.isEmpty() &&
											 * queryRateRes.size() > 0) {
											 * 
											 * Double _txRate = Double.valueOf(queryRateRes.get(0)); int _yearMaxDays =
											 * c.getActualMaximum(Calendar.DAY_OF_YEAR); double _dayPercentRateCalculate
											 * = (_txRate / 365) (double) _yearMaxDays; Double _billTax =
											 * (Double.valueOf(partyBlnc) * _dayPercentRateCalculate) / 100; Double
											 * _partyBlnc = Double.valueOf(partyBlnc) + _billTax;
											 * 
											 * SQLQuery queryCurBal = session.createSQLQuery(
											 * "UPDATE st_rm_purchase_party_master_balance SET balance='" +
											 * String.format("%.2f",partyBlnc) + "' WHERE party_id=" + ledgerId);
											 * queryCurBal.executeUpdate();
											 * 
											 * }
											 */
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + saleBillId + ",'" + saleObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ repsaleBillAmount + "','" + String.format("%.2f", billTax)
														+ "','" + saleBillAmount + "','" + partyBlnc + "','" + blncTyp
														+ "','Sale')");
										Schquery.executeUpdate();
										// sale tax billing end

										logger.info(
												"::::::::::::SALE BILL WISE TAX SCHEDULING SUCCESS:::::::::::::::::::::::::");
									}
								}
							}

							// purchase tax billing start
							logger.info(
									"::::::::::::SCHEDULING START OF TAX REPORT PURCHASING:::::::::::::::::::::::::");
							SQLQuery query2 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details WHERE type_of_ref IN('Agst Ref') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> purchaseBillsresult = query2.list();
							if (purchaseBillsresult != null && !purchaseBillsresult.isEmpty()
									&& purchaseBillsresult.size() > 0) {

								for (Object[] purchaseObj : purchaseBillsresult) {
									String purchaseBillDate = purchaseObj[5].toString();
									if (isInterestAllow(ledgerId))
										continue;
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);
									c.setTime(sdf.parse(purchaseBillDate));
									c.add(Calendar.DAY_OF_MONTH, totalDays);
									String purchasedatePeriod = sdf.format(c.getTime());
									if (compareTwoDate(purchasedatePeriod + " 00:00", currentDate + " 00:00")) {

										Double PtaxRate = Double.valueOf(obj[6].toString());
										PtaxRate = PtaxRate * 12;
										Calendar Pc = Calendar.getInstance();
										int PmonthMaxDays = Pc.getActualMaximum(Calendar.DAY_OF_MONTH);
										double PdayPercentRateCalculate = (PtaxRate / 365);

										Double purchaseBillAmount = Double.valueOf(purchaseObj[3].toString());
										Double reppurchaseBillAmount = purchaseBillAmount;
										Double purchasebillTax = (purchaseBillAmount * PdayPercentRateCalculate) / 100;
										purchaseBillAmount = purchaseBillAmount + purchasebillTax;
										int purchaseBillId = (int) purchaseObj[0];
										logger.info(
												"::::::::::::PURCHASE BILL :::::::::::::::::::::::::" + purchaseBillId);
										String purchaseTaxAmountOld = purchaseObj[9].toString();
										Double purchaseTaxAmountNew = Double.valueOf(purchaseTaxAmountOld)
												+ purchasebillTax;

										SQLQuery purchaseupdateBillQuery = session.createSQLQuery(
												"UPDATE st_rm_bill_wise_details SET balance='" + purchaseBillAmount
														+ "',tax_amount='" + purchaseTaxAmountNew + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + purchaseBillId);
										purchaseupdateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + purchaseBillId + ",'" + purchaseObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ reppurchaseBillAmount + "','" + purchasebillTax + "','"
														+ purchaseBillAmount + "','" + partyBlnc + "','" + blncTyp
														+ "','Purchase')");
										Schquery.executeUpdate();

										logger.info(
												"::::::::::::SCHEDULING TAX SUCCESS OF PURCHASE :::::::::::::::::::::::::");

									}

								}

							}

						} else if (rateMonthOrYear.equalsIgnoreCase("Calendar Year")) {
							logger.info("::::::::::::INSIDE CALENDAR Year:::::::::::::::::::::::::");
							String dueLimit = !obj[10].toString().isEmpty() ? obj[10].toString() : "0";
							String gracePeriod = !obj[11].toString().isEmpty() ? obj[11].toString() : "0";
							Integer totalDays = Integer.valueOf(dueLimit) + Integer.valueOf(gracePeriod);
							if (alwaysOrPastDueDate.equalsIgnoreCase("Always"))
								totalDays = 0;

							Integer ledgerId = (int) obj[1];
							SQLQuery query1 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details_sale WHERE type_of_ref IN('Agst Ref') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> saleBillsresult = query1.list();
							if (saleBillsresult != null && !saleBillsresult.isEmpty() && saleBillsresult.size() > 0) {

								for (Object[] saleObj : saleBillsresult) {
									if (isInterestAllow(ledgerId))
										continue;

									String saleBillDate = saleObj[5].toString();
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);

									c.setTime(sdf.parse(saleBillDate));
									c.add(Calendar.DAY_OF_MONTH, totalDays);
									String datePeriod = sdf.format(c.getTime());

									if (compareTwoDate(datePeriod + " 00:00", currentDate + " 00:00")) {

										Double taxRate = Double.valueOf(obj[6].toString());
										int yearMaxDays = c.getActualMaximum(Calendar.DAY_OF_YEAR);
										double dayPercentRateCalculate = (taxRate / 365);
										Double saleBillAmount = Double.valueOf(saleObj[3].toString());
										Double repsaleBillAmount = saleBillAmount;
										Double billTax = (saleBillAmount * dayPercentRateCalculate) / 100;
										saleBillAmount = saleBillAmount + billTax;
										int saleBillId = (int) saleObj[0];
										logger.info("::::::::::::SALE BILL :::::::::::::::::::::::::" + saleBillId);
										String saleTaxAmountOld = saleObj[9].toString();
										Double saleTaxAmountNew = Double.valueOf(saleTaxAmountOld) + billTax;

										SQLQuery updateBillQuery = session.createSQLQuery(
												"UPDATE st_rm_bill_wise_details_sale SET balance='" + saleBillAmount
														+ "',tax_amount='" + saleTaxAmountNew + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + saleBillId);
										updateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}
										if (blncTyp.equals("Dr")) {
											String balanceType = "Dr";
											String _partyBlnc = String.valueOf(Double.valueOf(partyBlnc) + billTax);
											Double stringformatterBal = Double.valueOf(partyBlnc) + billTax;
											SQLQuery queryCurBal = session.createSQLQuery(
													"UPDATE st_rm_purchase_party_master_balance SET balance='"
															+ String.format("%.2f", stringformatterBal)
															+ "',balance_type='" + balanceType + "' WHERE party_id="
															+ ledgerId);
											queryCurBal.executeUpdate();

										} else if (blncTyp.equals("Cr")) {

											String balanceType = "Cr";
											String _partyBlnc = String.valueOf(Double.valueOf(partyBlnc) - billTax);
											Double stringformatterBal = Double.valueOf(partyBlnc) - billTax;

											if (stringformatterBal < 0) {
												stringformatterBal = stringformatterBal * (-1);
												balanceType = "Dr";
											}

											SQLQuery queryCurBal = session.createSQLQuery(
													"UPDATE st_rm_purchase_party_master_balance SET balance='"
															+ String.format("%.2f", stringformatterBal)
															+ "',balance_type='" + balanceType + "' WHERE party_id="
															+ ledgerId);
											queryCurBal.executeUpdate();
											/*
											 * SQLQuery queryRate = session.createSQLQuery(
											 * "SELECT rate FROM st_rm_ledger_interset_calculation WHERE rate_on IN('Credit Balances Only') and ledger_id="
											 * + ledgerId + " limit 1"); List<String> queryRateRes = queryRate.list();
											 * if (queryRateRes != null && !queryRateRes.isEmpty() &&
											 * queryRateRes.size() > 0) {
											 * 
											 * Double _txRate = Double.valueOf(queryRateRes.get(0)); int _yearMaxDays =
											 * c.getActualMaximum(Calendar.DAY_OF_YEAR); double _dayPercentRateCalculate
											 * = (_txRate / 365) (double) _yearMaxDays; Double _billTax =
											 * (Double.valueOf(partyBlnc) * _dayPercentRateCalculate) / 100; Double
											 * _partyBlnc = Double.valueOf(partyBlnc) + _billTax; SQLQuery queryCurBal =
											 * session.createSQLQuery(
											 * "UPDATE st_rm_purchase_party_master_balance SET balance='" + _partyBlnc +
											 * "' WHERE party_id=" + ledgerId); queryCurBal.executeUpdate();
											 * 
											 * }
											 */
										}
										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + saleBillId + ",'" + saleObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ repsaleBillAmount + "','" + String.format("%.2f", billTax)
														+ "','" + saleBillAmount + "','" + partyBlnc + "','" + blncTyp
														+ "','Sale')");
										Schquery.executeUpdate();

										// sale tax billing end
										logger.info(
												"::::::::::::SALE BILL WISE TAX SCHEDULING SUCCESS:::::::::::::::::::::::::");
									}
								}
							}

							// purchase tax billing start
							logger.info(
									"::::::::::::SCHEDULING START OF TAX REPORT PURCHASING:::::::::::::::::::::::::");
							SQLQuery query2 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details WHERE type_of_ref IN('Agst Ref') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> purchaseBillsresult = query2.list();
							if (purchaseBillsresult != null && !purchaseBillsresult.isEmpty()
									&& purchaseBillsresult.size() > 0) {

								for (Object[] purchaseObj : purchaseBillsresult) {
									String purchaseBillDate = purchaseObj[5].toString();
									if (isInterestAllow(ledgerId))
										continue;

									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);

									c.setTime(sdf.parse(purchaseBillDate));
									c.add(Calendar.DAY_OF_MONTH, totalDays);
									String purchasedatePeriod = sdf.format(c.getTime());
									if (compareTwoDate(purchasedatePeriod + " 00:00", currentDate + " 00:00")) {

										Double PtaxRate = Double.valueOf(obj[6].toString());
										Calendar Pc = Calendar.getInstance();
										int PyearMaxDays = Pc.getActualMaximum(Calendar.DAY_OF_YEAR);
										double PdayPercentRateCalculate = (PtaxRate / 365);

										Double purchaseBillAmount = Double.valueOf(purchaseObj[3].toString());
										Double reppurchaseBillAmount = purchaseBillAmount;
										Double purchasebillTax = (purchaseBillAmount * PdayPercentRateCalculate) / 100;
										purchaseBillAmount = purchaseBillAmount + purchasebillTax;
										int purchaseBillId = (int) purchaseObj[0];
										logger.info(
												"::::::::::::PURCHASE BILL :::::::::::::::::::::::::" + purchaseBillId);
										String purchaseTaxAmountOld = purchaseObj[9].toString();
										Double purchaseTaxAmountNew = Double.valueOf(purchaseTaxAmountOld)
												+ purchasebillTax;

										SQLQuery purchaseupdateBillQuery = session.createSQLQuery(
												"UPDATE st_rm_bill_wise_details SET balance='" + purchaseBillAmount
														+ "',tax_amount='" + purchaseTaxAmountNew + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + purchaseBillId);
										purchaseupdateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + purchaseBillId + ",'" + purchaseObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ reppurchaseBillAmount + "','" + purchasebillTax + "','"
														+ purchaseBillAmount + "','" + partyBlnc + "','" + blncTyp
														+ "','Purchase')");
										Schquery.executeUpdate();

										logger.info(
												"::::::::::::SCHEDULING TAX SUCCESS OF PURCHASE :::::::::::::::::::::::::");

									}

								}

							}

						}
					}
				}
			}
			logger.info("::::::::::::SCHEDULING END  :::::::::::::::::::::::::");
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}

	private boolean isInterestAllow(Integer ledgerId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_alert_scheduling_mgmt WHERE ledger_id="
					+ ledgerId + " and alert_type='interest'");
			List<Object[]> obj = query.list();
			if (obj != null && !obj.isEmpty() && obj.size() > 0) {
				for (Object[] o : obj)
					return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	private boolean isInterestAllow(int partyId, int billId, String voucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT * FROM st_rm_alert_scheduling_mgmt WHERE ledger_id=" + partyId
							+ " and voucher_no='" + voucher + "' and bill_id=" + billId + " and alert_type='SCHEDULE'");
			List<Object[]> obj = query.list();
			if (obj != null && !obj.isEmpty() && obj.size() > 0) {
				for (Object[] o : obj)
					return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public void calculateTaxOnCreditBalanceOnly() {

		try {
			Logger logger = Logger.getLogger(GameLobbyController.class.getName());
			logger.info("::::::::::::SCHEDULING START OF TAX REPORT CREDIT BALANCE ONLY:::::::::::::::::::::::::");
			Session session = HibernateSessionFactory.getSession();
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date.format(formatter);
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM st_rm_ledger_interset_calculation WHERE rate_on IN('Credit Balances Only') and is_security='Yes'");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				for (Object[] obj : result) {
					Double rate = Double.valueOf(!obj[6].toString().isEmpty() ? obj[6].toString() : "0");
					String securityInterestDate = obj[15].toString().split(" ")[0];
					Double securityAmt = Double.valueOf(!obj[13].toString().isEmpty() ? obj[13].toString() : "0");
					String ratePer = obj[7].toString();
					int partyId = (int) obj[1];
					if (ratePer.equalsIgnoreCase("Calendar Month")) {
						logger.info(
								"::::::::::::[ CREDIT BALANCE ONLY ] INSIDE Calendar Month:::::::::::::::::::::::::");

						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						Calendar c = Calendar.getInstance();
						TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
						c.setTimeZone(tz);
						rate = rate * 12;
						int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
						double dayPercentRateCalculate = (rate / 365);
						double finalTaxAmount = (dayPercentRateCalculate * securityAmt) / 100;
						SQLQuery query1 = session.createSQLQuery(
								"SELECT * FROM st_rm_purchase_party_master_balance where party_id=" + partyId);
						List<Object[]> result1 = query1.list();
						if (result1 != null && !result1.isEmpty() && result1.size() > 0) {
							for (Object[] partyObj : result1) {

								if (compareTwoDate(currentDate, securityInterestDate))
									continue;

								Double partyBal = Double.valueOf(partyObj[2].toString());
								String balType = partyObj[3].toString();
								SQLQuery sqlQuery = session.createSQLQuery(
										"SELECT ledger_under_group_name from st_rm_acc_ledger_master where ledger_id="
												+ partyId);
								List<String> ledgerResult = sqlQuery.list();
								String groupUnder = ledgerResult.get(0);
								String cr_Dr = "";
								if (groupUnder.equals("Sundry creditors") || groupUnder.equals("Loans(liabilities)")
										|| groupUnder.equals("Bank od a/c") || groupUnder.equals("Capital account")
										|| groupUnder.equals("Branch/Division") || groupUnder.equals("Suspense account")
										|| groupUnder.equals("Provision") || groupUnder.equals("Bank occ a/c")
										|| groupUnder.equals("Current liabilities")
										|| groupUnder.equals("Duties & taxes") || groupUnder.equals("Duties & taxes")
										|| groupUnder.equals("Income(indirect)") || groupUnder.equals("Income(direct)")
										|| groupUnder.equals("Sales account") || groupUnder.equals("Reserves & surplus")
										|| groupUnder.equals("Retained earning") || groupUnder.equals("Secured loans")
										|| groupUnder.equals("Unsecured Loans"))
									cr_Dr = "Cr";
								else
									cr_Dr = "Dr";

								if (balType.equals("Dr") && cr_Dr.equals("Dr"))
									partyBal = partyBal + finalTaxAmount;
								else if (balType.equals("Cr") && cr_Dr.equals("Cr"))
									partyBal = partyBal + finalTaxAmount;
								else {
									partyBal = partyBal - finalTaxAmount;
									if (partyBal < 0) {
										partyBal = partyBal * (-1);
										balType = cr_Dr;
									}

								}

								SQLQuery sqlQuery2 = session.createSQLQuery(
										"UPDATE st_rm_purchase_party_master_balance SET balance='" + partyBal
												+ "',balance_type='" + balType + "' where party_id=" + partyId);
								sqlQuery2.executeUpdate();

								SQLQuery Schquery = session.createSQLQuery(
										"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
												+ partyId + ",'-1','none','success','" + date.format(formatter) + "','"
												+ securityAmt + "','" + finalTaxAmount + "','" + partyBal + "','"
												+ partyBal + "','" + balType + "','Security Amount')");
								Schquery.executeUpdate();

							}
						}

						logger.info("::::::::::::[ CREDIT BALANCE ONLY ] END Calendar Month:::::::::::::::::::::::::");
					} else if (ratePer.equalsIgnoreCase("Calendar Year")) {
						logger.info(
								"::::::::::::[ CREDIT BALANCE ONLY ] INSIDE Calendar Year:::::::::::::::::::::::::");
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						Calendar c = Calendar.getInstance();
						TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
						c.setTimeZone(tz);
						int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_YEAR);
						double dayPercentRateCalculate = (rate / 365);
						double finalTaxAmount = (dayPercentRateCalculate * securityAmt) / 100;
						SQLQuery query1 = session.createSQLQuery(
								"SELECT * FROM st_rm_purchase_party_master_balance where party_id=" + partyId);
						List<Object[]> result1 = query1.list();
						if (result1 != null && !result1.isEmpty() && result1.size() > 0) {
							for (Object[] partyObj : result1) {
								if (compareTwoDate(currentDate, securityInterestDate))
									continue;

								Double partyBal = Double.valueOf(partyObj[2].toString());
								String balType = partyObj[3].toString();
								SQLQuery sqlQuery = session.createSQLQuery(
										"SELECT ledger_under_group_name from st_rm_acc_ledger_master where ledger_id="
												+ partyId);
								List<String> ledgerResult = sqlQuery.list();
								String groupUnder = ledgerResult.get(0);
								String cr_Dr = "";
								if (groupUnder.equals("Sundry creditors") || groupUnder.equals("Loans(liabilities)")
										|| groupUnder.equals("Bank od a/c") || groupUnder.equals("Capital account")
										|| groupUnder.equals("Branch/Division") || groupUnder.equals("Suspense account")
										|| groupUnder.equals("Provision") || groupUnder.equals("Bank occ a/c")
										|| groupUnder.equals("Current liabilities")
										|| groupUnder.equals("Duties & taxes") || groupUnder.equals("Duties & taxes")
										|| groupUnder.equals("Income(indirect)") || groupUnder.equals("Income(direct)")
										|| groupUnder.equals("Sales account") || groupUnder.equals("Reserves & surplus")
										|| groupUnder.equals("Retained earning") || groupUnder.equals("Secured loans")
										|| groupUnder.equals("Unsecured Loans"))
									cr_Dr = "Cr";
								else
									cr_Dr = "Dr";

								if (balType.equals("Dr") && cr_Dr.equals("Dr"))
									partyBal = partyBal + finalTaxAmount;
								else if (balType.equals("Cr") && cr_Dr.equals("Cr"))
									partyBal = partyBal + finalTaxAmount;
								else {
									partyBal = partyBal - finalTaxAmount;
									if (partyBal < 0) {
										partyBal = partyBal * (-1);
										balType = cr_Dr;
									}

								}

								SQLQuery sqlQuery2 = session.createSQLQuery(
										"UPDATE st_rm_purchase_party_master_balance SET balance='" + partyBal
												+ "',balance_type='" + balType + "' where party_id=" + partyId);
								sqlQuery2.executeUpdate();
								SQLQuery Schquery = session.createSQLQuery(
										"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
												+ partyId + ",-1,'none','success','" + date.format(formatter) + "','"
												+ securityAmt + "','" + finalTaxAmount + "','" + partyBal + "','"
												+ partyBal + "','" + balType + "','Security Amount')");
								Schquery.executeUpdate();
							}
						}

						logger.info("::::::::::::[ CREDIT BALANCE ONLY ] END Calendar Month:::::::::::::::::::::::::");
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean isInterestAllow1(int partyId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_alert_scheduling_mgmt WHERE ledger_id="
					+ partyId + " and alert_type='SCHEDULE'");
			List<Object[]> obj = query.list();
			if (obj != null && !obj.isEmpty() && obj.size() > 0) {

				for (Object[] o : obj) {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public void calculateTaxOnAdvanceBalanceOnly() {

		try {
			Logger logger = Logger.getLogger(GameLobbyController.class.getName());
			logger.info("::::::::::::SCHEDULING START OF TAX REPORT ON ADVANCE AMOUNT:::::::::::::::::::::::::");
			Session session = HibernateSessionFactory.getSession();
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date.format(formatter);
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM st_rm_ledger_interset_calculation WHERE rate_on IN('Credit Balances Only')");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				for (Object[] obj : result) {
					String IstxnByTxn = obj[2].toString();
					String alwaysOrPastDueDate = obj[9].toString();
					String calculateFrom = obj[12].toString();
					if (IstxnByTxn.equalsIgnoreCase("yes")) {
						logger.info("::::::::::::INSIDE BILL WISE :::::::::::::::::::::::::");
						String rateMonthOrYear = obj[7].toString();
						if (rateMonthOrYear.equalsIgnoreCase("Calendar Month")) {
							logger.info("::::::::::::INSIDE CALENDAR MONTH:::::::::::::::::::::::::");
							String dueLimit = !obj[10].toString().isEmpty() ? obj[10].toString() : "0";
							String gracePeriod = !obj[11].toString().isEmpty() ? obj[11].toString() : "0";
							Integer totalDays = Integer.valueOf(dueLimit) + Integer.valueOf(gracePeriod);
							if (alwaysOrPastDueDate.equalsIgnoreCase("Always"))
								totalDays = 0;
							Integer ledgerId = (int) obj[1];
							SQLQuery query1 = session.createSQLQuery(
									"SELECT * FROM st_rm_purchase_party_master_balance WHERE party_id=" + ledgerId);
							List<Object[]> saleBillsresult = query1.list();
							if (saleBillsresult != null && !saleBillsresult.isEmpty() && saleBillsresult.size() > 0) {

								for (Object[] saleObj : saleBillsresult) {

									String partyBalance = saleObj[2].toString();
									String partyBalanceType = saleObj[3].toString();
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);
									// c.setTime(sdf.parse(saleBillDate));
									c.add(Calendar.DAY_OF_MONTH, totalDays);
									String datePeriod = sdf.format(c.getTime());

									if (compareTwoDate(datePeriod + " 00:00", currentDate + " 00:00")) {

										Double taxRate = Double.valueOf(obj[6].toString());
										int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
										logger.info("------------------->DAYS IN MONTH IS :" + monthMaxDays);
										double dayPercentRateCalculate = (taxRate / 365) * (double) monthMaxDays;

										Double saleBillAmount = Double.valueOf(saleObj[3].toString());
										Double repsaleBillAmount = saleBillAmount;
										Double billTax = (saleBillAmount * dayPercentRateCalculate) / 100;
										saleBillAmount = saleBillAmount + billTax;
										int saleBillId = (int) saleObj[0];
										logger.info("::::::::::::SALE BILL :::::::::::::::::::::::::" + saleBillId);
										String saleTaxAmountOld = saleObj[9].toString();
										Double saleTaxAmountNew = Double.valueOf(saleTaxAmountOld) + billTax;

										SQLQuery updateBillQuery = session.createSQLQuery(
												"UPDATE st_rm_bill_wise_details_sale SET balance='" + saleBillAmount
														+ "',tax_amount='" + saleTaxAmountNew + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + saleBillId);
										updateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + saleBillId + ",'" + saleObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ repsaleBillAmount + "','" + billTax + "','" + saleBillAmount
														+ "','" + partyBlnc + "','" + blncTyp + "','Sale')");
										Schquery.executeUpdate();
										// sale tax billing end

										logger.info(
												"::::::::::::SALE BILL WISE TAX SCHEDULING SUCCESS:::::::::::::::::::::::::");
									}
								}
							}

							// purchase tax billing start
							logger.info(
									"::::::::::::SCHEDULING START OF TAX REPORT PURCHASING:::::::::::::::::::::::::");
							SQLQuery query2 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details WHERE type_of_ref IN('On Account','Advance') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> purchaseBillsresult = query2.list();
							if (purchaseBillsresult != null && !purchaseBillsresult.isEmpty()
									&& purchaseBillsresult.size() > 0) {

								for (Object[] purchaseObj : purchaseBillsresult) {
									String purchaseBillDate = purchaseObj[5].toString();

									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);
									c.setTime(sdf.parse(purchaseBillDate));
									c.add(Calendar.DAY_OF_MONTH, totalDays);
									String purchasedatePeriod = sdf.format(c.getTime());
									if (compareTwoDate(purchasedatePeriod + " 00:00", currentDate + " 00:00")) {

										Double PtaxRate = Double.valueOf(obj[6].toString());
										Calendar Pc = Calendar.getInstance();
										int PmonthMaxDays = Pc.getActualMaximum(Calendar.DAY_OF_MONTH);
										double PdayPercentRateCalculate = (PtaxRate / 365) * (double) PmonthMaxDays;

										Double purchaseBillAmount = Double.valueOf(purchaseObj[3].toString());
										Double reppurchaseBillAmount = purchaseBillAmount;
										Double purchasebillTax = (purchaseBillAmount * PdayPercentRateCalculate) / 100;
										purchaseBillAmount = purchaseBillAmount + purchasebillTax;
										int purchaseBillId = (int) purchaseObj[0];
										logger.info(
												"::::::::::::PURCHASE BILL :::::::::::::::::::::::::" + purchaseBillId);
										String purchaseTaxAmountOld = purchaseObj[9].toString();
										Double purchaseTaxAmountNew = Double.valueOf(purchaseTaxAmountOld)
												+ purchasebillTax;

										SQLQuery purchaseupdateBillQuery = session.createSQLQuery(
												"UPDATE st_rm_bill_wise_details SET balance='" + purchaseBillAmount
														+ "',tax_amount='" + purchaseTaxAmountNew + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + purchaseBillId);
										purchaseupdateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + purchaseBillId + ",'" + purchaseObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ reppurchaseBillAmount + "','" + purchasebillTax + "','"
														+ purchaseBillAmount + "','" + partyBlnc + "','" + blncTyp
														+ "','Purchase')");
										Schquery.executeUpdate();

										logger.info(
												"::::::::::::SCHEDULING TAX SUCCESS OF PURCHASE :::::::::::::::::::::::::");

									}

								}

							}

						} else if (rateMonthOrYear.equalsIgnoreCase("Calendar Year")) {
							logger.info("::::::::::::INSIDE CALENDAR Year:::::::::::::::::::::::::");
							String dueLimit = !obj[10].toString().isEmpty() ? obj[10].toString() : "0";
							String gracePeriod = !obj[11].toString().isEmpty() ? obj[11].toString() : "0";
							Integer totalDays = Integer.valueOf(dueLimit) + Integer.valueOf(gracePeriod);
							if (alwaysOrPastDueDate.equalsIgnoreCase("Always"))
								totalDays = 0;

							Integer ledgerId = (int) obj[1];
							SQLQuery query1 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details_sale WHERE type_of_ref IN('Advance','On Account') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> saleBillsresult = query1.list();
							if (saleBillsresult != null && !saleBillsresult.isEmpty() && saleBillsresult.size() > 0) {

								for (Object[] saleObj : saleBillsresult) {
									String saleBillDate = saleObj[5].toString();
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);

									c.setTime(sdf.parse(saleBillDate));
									c.add(Calendar.DAY_OF_MONTH, totalDays);
									String datePeriod = sdf.format(c.getTime());

									if (compareTwoDate(datePeriod + " 00:00", currentDate + " 00:00")) {

										Double taxRate = Double.valueOf(obj[6].toString());
										int yearMaxDays = c.getActualMaximum(Calendar.DAY_OF_YEAR);
										double dayPercentRateCalculate = (taxRate / 365) * (double) yearMaxDays;

										Double saleBillAmount = Double.valueOf(saleObj[3].toString());
										Double repsaleBillAmount = saleBillAmount;
										Double billTax = (saleBillAmount * dayPercentRateCalculate) / 100;
										saleBillAmount = saleBillAmount + billTax;
										int saleBillId = (int) saleObj[0];
										logger.info("::::::::::::SALE BILL :::::::::::::::::::::::::" + saleBillId);
										String saleTaxAmountOld = saleObj[9].toString();
										Double saleTaxAmountNew = Double.valueOf(saleTaxAmountOld) + billTax;

										SQLQuery updateBillQuery = session.createSQLQuery(
												"UPDATE st_rm_bill_wise_details_sale SET balance='" + saleBillAmount
														+ "',tax_amount='" + saleTaxAmountNew + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + saleBillId);
										updateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + saleBillId + ",'" + saleObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ repsaleBillAmount + "','" + billTax + "','" + saleBillAmount
														+ "','" + partyBlnc + "','" + blncTyp + "','Sale')");
										Schquery.executeUpdate();

										// sale tax billing end
										logger.info(
												"::::::::::::SALE BILL WISE TAX SCHEDULING SUCCESS:::::::::::::::::::::::::");
									}
								}
							}

							// purchase tax billing start
							logger.info(
									"::::::::::::SCHEDULING START OF TAX REPORT PURCHASING:::::::::::::::::::::::::");
							SQLQuery query2 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details WHERE type_of_ref IN('On Account','Advance') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> purchaseBillsresult = query2.list();
							if (purchaseBillsresult != null && !purchaseBillsresult.isEmpty()
									&& purchaseBillsresult.size() > 0) {

								for (Object[] purchaseObj : purchaseBillsresult) {
									String purchaseBillDate = purchaseObj[5].toString();

									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);

									c.setTime(sdf.parse(purchaseBillDate));
									c.add(Calendar.DAY_OF_MONTH, totalDays);
									String purchasedatePeriod = sdf.format(c.getTime());
									if (compareTwoDate(purchasedatePeriod + " 00:00", currentDate + " 00:00")) {

										Double PtaxRate = Double.valueOf(obj[6].toString());
										Calendar Pc = Calendar.getInstance();
										int PyearMaxDays = Pc.getActualMaximum(Calendar.DAY_OF_YEAR);
										double PdayPercentRateCalculate = (PtaxRate / 365) * (double) PyearMaxDays;

										Double purchaseBillAmount = Double.valueOf(purchaseObj[3].toString());
										Double reppurchaseBillAmount = purchaseBillAmount;
										Double purchasebillTax = (purchaseBillAmount * PdayPercentRateCalculate) / 100;
										purchaseBillAmount = purchaseBillAmount + purchasebillTax;
										int purchaseBillId = (int) purchaseObj[0];
										logger.info(
												"::::::::::::PURCHASE BILL :::::::::::::::::::::::::" + purchaseBillId);
										String purchaseTaxAmountOld = purchaseObj[9].toString();
										Double purchaseTaxAmountNew = Double.valueOf(purchaseTaxAmountOld)
												+ purchasebillTax;

										SQLQuery purchaseupdateBillQuery = session.createSQLQuery(
												"UPDATE st_rm_bill_wise_details SET balance='" + purchaseBillAmount
														+ "',tax_amount='" + purchaseTaxAmountNew + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + purchaseBillId);
										purchaseupdateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + purchaseBillId + ",'" + purchaseObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ reppurchaseBillAmount + "','" + purchasebillTax + "','"
														+ purchaseBillAmount + "','" + partyBlnc + "','" + blncTyp
														+ "','Purchase')");
										Schquery.executeUpdate();

										logger.info(
												"::::::::::::SCHEDULING TAX SUCCESS OF PURCHASE :::::::::::::::::::::::::");

									}

								}

							}

						}
					}
				}
			}
			logger.info("::::::::::::SCHEDULING END  :::::::::::::::::::::::::");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean ledgerSecondStepInsert(LedgerSecondStepBean ledgerSecondStepBean) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "INSERT INTO bo_um_ledger_details (`ledgerId`,`customerName`, `firmName`, `firmType`, `address`, `state`, `district`, `tehsil`, `pincode`, `contact`, `resPerName`, `resPerAddr`, `resPerContact`, `firmGSTN`, `firmEmail`, `firmSince`, `firmPAN`, `firmAadhar`, `branch`, `landmark`, `seedLicenceNo`, `fertLicenceNo`, `pestLicenceNo`, `transportName`, `bankName`, `bankAccNo`, `bankIFSC`, `bankBranch`, `secCheqNo1`, `secCheqNo2`, `firmTernOver`, `expectedSalePerYr`, `otherCompanyDetail`,`customerDOB`,`firm_gstn_type`) VALUES ("
					+ ledgerSecondStepBean.getLedgerId() + ",'" + ledgerSecondStepBean.getCustomerName() + "', '"
					+ ledgerSecondStepBean.getFirmName() + "', '" + ledgerSecondStepBean.getFirmType() + "', '"
					+ ledgerSecondStepBean.getAddress() + "', '" + ledgerSecondStepBean.getState() + "', '"
					+ ledgerSecondStepBean.getDistrict() + "', '" + ledgerSecondStepBean.getTehsil() + "', '"
					+ ledgerSecondStepBean.getPincode() + "', '" + ledgerSecondStepBean.getContact() + "', '"
					+ ledgerSecondStepBean.getResPerName() + "', '" + ledgerSecondStepBean.getResPerAddr() + "', '"
					+ ledgerSecondStepBean.getResPerContact() + "', '" + ledgerSecondStepBean.getFirmGSTN() + "', '"
					+ ledgerSecondStepBean.getFirmEmail() + "', '" + ledgerSecondStepBean.getFirmSince() + "', '"
					+ ledgerSecondStepBean.getFirmPAN() + "', '" + ledgerSecondStepBean.getFirmAadhar() + "', '"
					+ ledgerSecondStepBean.getBranch() + "', '" + ledgerSecondStepBean.getLandmark() + "', '"
					+ ledgerSecondStepBean.getSeedLicenceNo() + "', '" + ledgerSecondStepBean.getFertLicenceNo()
					+ "', '" + ledgerSecondStepBean.getPestLicenceNo() + "', '"
					+ ledgerSecondStepBean.getTransportName() + "', '" + ledgerSecondStepBean.getBankName() + "', '"
					+ ledgerSecondStepBean.getBankAccNo() + "', '" + ledgerSecondStepBean.getBankIFSC() + "', '"
					+ ledgerSecondStepBean.getBankBranch() + "', '" + ledgerSecondStepBean.getSecCheqNo1() + "', '"
					+ ledgerSecondStepBean.getSecCheqNo2() + "', '" + ledgerSecondStepBean.getFirmTernOver() + "', '"
					+ ledgerSecondStepBean.getExpectedSalePerYr() + "', '"
					+ ledgerSecondStepBean.getOtherCompanyDetail() + "','" + ledgerSecondStepBean.getCustomerDOB()
					+ "','" + ledgerSecondStepBean.getFirmGSTNType() + "')";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getMobileNoByEmpId(int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT phone_num from st_rm_bo_user_info where user_id=" + userId);
			List<String> res = query.list();
			return res.get(0);
		} catch (Exception r) {
			r.printStackTrace();

		}
		return null;
	}

	public String getSecurity(String partyName) {
		try {
			Session session = HibernateSessionFactory.getSession();
			int ledgerId = getLedgerIdByName(partyName);
			SQLQuery query = session.createSQLQuery(
					"SELECT SUM(security_amt) from st_rm_ledger_interset_calculation where ledger_id=" + ledgerId);
			List<Double> res = query.list();
			if (res != null && !res.isEmpty() && res.size() > 0) {
				return String.valueOf(res.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}

	public boolean insertOrUpdateExpenses(EmployeeExpenseBean employeeExpenseBean) {

		Transaction transaction = null;

		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			if (employeeExpenseBean.getPicture1FileName() != null
					&& !employeeExpenseBean.getPicture1FileName().isEmpty()) {
				SQLQuery query1 = session.createSQLQuery(
						"INSERT INTO bo_um_emp_expenses(`emp_id`,`date`,`expense_type`,`amount`,`picture`) values("
								+ employeeExpenseBean.getEmpId() + ",'"
								+ employeeExpenseBean.getExpenseDate1().split(" ")[0] + "','"
								+ employeeExpenseBean.getExpenseType1() + "','" + employeeExpenseBean.getAmount1()
								+ "','" + employeeExpenseBean.getPicture1FileName() + "')");
				query1.executeUpdate();
			}
			if (employeeExpenseBean.getPicture2FileName() != null
					&& !employeeExpenseBean.getPicture2FileName().isEmpty()) {
				SQLQuery query2 = session.createSQLQuery(
						"INSERT INTO bo_um_emp_expenses(`emp_id`,`date`,`expense_type`,`amount`,`picture`) values("
								+ employeeExpenseBean.getEmpId() + ",'"
								+ employeeExpenseBean.getExpenseDate2().split(" ")[0] + "','"
								+ employeeExpenseBean.getExpenseType2() + "','" + employeeExpenseBean.getAmount2()
								+ "','" + employeeExpenseBean.getPicture2FileName() + "')");
				query2.executeUpdate();
			}
			if (employeeExpenseBean.getPicture3FileName() != null
					&& !employeeExpenseBean.getPicture3FileName().isEmpty()) {
				SQLQuery query3 = session.createSQLQuery(
						"INSERT INTO bo_um_emp_expenses(`emp_id`,`date`,`expense_type`,`amount`,`picture`) values("
								+ employeeExpenseBean.getEmpId() + ",'"
								+ employeeExpenseBean.getExpenseDate3().split(" ")[0] + "','"
								+ employeeExpenseBean.getExpenseType3() + "','" + employeeExpenseBean.getAmount3()
								+ "','" + employeeExpenseBean.getPicture3FileName() + "')");
				query3.executeUpdate();
			}
			if (employeeExpenseBean.getPicture4FileName() != null
					&& !employeeExpenseBean.getPicture4FileName().isEmpty()) {
				SQLQuery query4 = session.createSQLQuery(
						"INSERT INTO bo_um_emp_expenses(`emp_id`,`date`,`expense_type`,`amount`,`picture`) values("
								+ employeeExpenseBean.getEmpId() + ",'"
								+ employeeExpenseBean.getExpenseDate4().split(" ")[0] + "','"
								+ employeeExpenseBean.getExpenseType4() + "','" + employeeExpenseBean.getAmount4()
								+ "','" + employeeExpenseBean.getPicture4FileName() + "')");
				query4.executeUpdate();
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public void scheduleEmployeeAttendance() {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String currentDate = date.format(formatter);

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
			c.setTimeZone(tz);
			if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				String sqlString = "SELECT user_id from st_rm_bo_user_master where parent_user_id>0";
				SQLQuery query = session.createSQLQuery(sqlString);
				List<Integer> result = query.list();
				if (result != null && !result.isEmpty() && result.size() > 0) {
					for (Integer userId : result) {
						/*
						 * String weekDay="SUNDAY"; SQLQuery query1 = session.
						 * createSQLQuery("SELECT week_day_off from st_rm_bo_user_info WHERE user_id="
						 * +userId); List<String> res = query1.list(); if(res!=null && res.size()>0 &&
						 * !res.isEmpty()) {
						 * 
						 * for(String day:res) weekDay =
						 * day!=null?day.toString().split(",")[0].toUpperCase():"SUNDAY";
						 * 
						 * }
						 */
						sqlString = "SELECT * FROM bo_um_employee_attendance WHERE date='" + date.format(formatter)
								+ "' and attendance_type='W' and emp_id=" + userId + "";
						SQLQuery qu = session.createSQLQuery(sqlString);
						List<Object[]> oResult = qu.list();
						if (oResult != null && !oResult.isEmpty() && oResult.size() > 0)
							continue;
						sqlString = "INSERT INTO bo_um_employee_attendance(`emp_id`,`attendance_type`,`date`,`detail_id`) values("
								+ userId + ",'W','" + date.format(formatter) + "',1876)";
						SQLQuery query1 = session.createSQLQuery(sqlString);
						query1.executeUpdate();
					}

				}

			} else {

				String sqlString = "SELECT user_id from st_rm_bo_user_master where parent_user_id>0";
				SQLQuery query = session.createSQLQuery(sqlString);
				List<Integer> result = query.list();
				if (result != null && !result.isEmpty() && result.size() > 0) {

					for (Integer userId : result) {

						sqlString = "SELECT * FROM bo_um_employee_attendance where emp_id=" + userId + " and date='"
								+ date.format(formatter) + "'";
						SQLQuery sqlQuery = session.createSQLQuery(sqlString);
						List<Object[]> objresult = sqlQuery.list();
						if (objresult == null || objresult.isEmpty() || objresult.size() == 0) {

							sqlString = "INSERT INTO bo_um_employee_attendance(`emp_id`,`attendance_type`,`date`,`detail_id`) values("
									+ userId + ",'A','" + date.format(formatter) + "',1876)";
							SQLQuery query1 = session.createSQLQuery(sqlString);
							query1.executeUpdate();

						}

					}

				}

			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}

	public Map<String, BillsBean> getSchedularReport(String ledgerName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			Map<String, BillsBean> map = new HashMap<String, BillsBean>();
			BillsBean bean = null;
			int ledgerId = getLedgerIdByName(ledgerName);
			String sqlString = "SELECT ledger_under_group_name FROM st_rm_acc_ledger_master where ledger_id="
					+ ledgerId;
			SQLQuery query = session.createSQLQuery(sqlString);
			List<String> list = query.list();
			String ledgerUnderName = list.get(0);
			int limit = getCreditPeriod(ledgerId);
			if (limit <= 0)
				limit = 0;
			if (ledgerUnderName.equalsIgnoreCase("Sundry debtors")) {
				sqlString = "SELECT * FROM st_rm_bill_wise_details_sale where party_id=" + ledgerId;
				SQLQuery query2 = session.createSQLQuery(sqlString);
				List<Object[]> result = query2.list();
				if (result != null && !result.isEmpty() && result.size() > 0) {
					int i = 1;
					for (Object[] obj : result) {
						bean = new BillsBean();
						bean.setLedgerId(String.valueOf(ledgerId));
						bean.setBillAmount(obj[3].toString() + " " + obj[6].toString());
						bean.setBillDate(obj[5].toString());
						bean.setBillId((int) obj[0]);
						bean.setBillTaxAmount(obj[9].toString());
						bean.setBillUsed(obj[4].toString());
						bean.setBillVoucherNo(obj[8].toString());
						bean.setLastSchedularDate(obj[10].toString());
						bean.setLedgerName(ledgerName);
						bean.setBillDueLimit(String.valueOf(limit));
						bean.setTypeOfRef(obj[1].toString());
						bean.setSecurityAmt("0");
						bean.setMailAlert("NO");
						bean.setSmsAlert("NO");
						bean.setTaxSchedular("NO");
						sqlString = "SELECT * from st_rm_alert_scheduling_mgmt where ledger_id=" + ledgerId
								+ " and voucher_no='" + obj[8].toString() + "'";
						SQLQuery sqlQuery = session.createSQLQuery(sqlString);
						List<Object[]> schList = sqlQuery.list();
						if (schList != null && !schList.isEmpty() && schList.size() > 0 && !schList.contains(null)) {
							for (Object[] ob : schList) {
								String alert_type = ob[4].toString();
								String isActive = ob[5].toString();
								if (alert_type.equalsIgnoreCase("SCHEDULE")) {
									if (isActive.equalsIgnoreCase("Y")) {
										bean.setTaxSchedular("YES");
									} else {
										bean.setTaxSchedular("NO");
									}
								}
								if (alert_type.equalsIgnoreCase("MAIL")) {
									if (isActive.equalsIgnoreCase("Y")) {
										bean.setMailAlert("YES");
									} else {
										bean.setMailAlert("NO");
									}
								}
								if (alert_type.equalsIgnoreCase("SMS")) {
									if (isActive.equalsIgnoreCase("Y")) {
										bean.setSmsAlert("YES");
									} else {
										bean.setSmsAlert("NO");
									}
								}
							}
						} else {
							bean.setMailAlert("NO");
							bean.setSmsAlert("NO");
							bean.setTaxSchedular("NO");
						}

						map.put("" + i, bean);
						i++;
					}
				}
			} else if (ledgerUnderName.equalsIgnoreCase("Sundry creditors")) {
				sqlString = "SELECT * FROM st_rm_bill_wise_details where party_id=" + ledgerId;
				SQLQuery query2 = session.createSQLQuery(sqlString);
				List<Object[]> result = query2.list();
				if (result != null && !result.isEmpty() && result.size() > 0) {
					int i = 1;
					for (Object[] obj : result) {
						bean = new BillsBean();
						bean.setLedgerId(String.valueOf(ledgerId));
						bean.setBillAmount(obj[3].toString() + " " + obj[6].toString());
						bean.setBillDate(obj[5].toString());
						bean.setBillId((int) obj[0]);
						bean.setBillTaxAmount(obj[9].toString());
						bean.setBillUsed(obj[4].toString());
						bean.setBillVoucherNo(obj[8].toString());
						bean.setLastSchedularDate(obj[10].toString());
						bean.setLedgerName(ledgerName);
						bean.setBillDueLimit(String.valueOf(limit));
						bean.setTypeOfRef(obj[1].toString());
						bean.setSecurityAmt("0");
						bean.setMailAlert("NO");
						bean.setSmsAlert("NO");
						bean.setTaxSchedular("NO");
						sqlString = "SELECT * from st_rm_alert_scheduling_mgmt where ledger_id=" + ledgerId
								+ " and voucher_no='" + obj[8].toString() + "'";
						SQLQuery sqlQuery = session.createSQLQuery(sqlString);
						List<Object[]> schList = sqlQuery.list();
						if (schList != null && !schList.isEmpty() && schList.size() > 0 && !schList.contains(null)) {
							for (Object[] ob : schList) {
								String alert_type = ob[4].toString();
								String isActive = ob[5].toString();
								if (alert_type.equalsIgnoreCase("SCHEDULE")) {
									if (isActive.equalsIgnoreCase("Y")) {
										bean.setTaxSchedular("YES");
									} else {
										bean.setTaxSchedular("NO");
									}
								}
								if (alert_type.equalsIgnoreCase("MAIL")) {
									if (isActive.equalsIgnoreCase("Y")) {
										bean.setMailAlert("YES");
									} else {
										bean.setMailAlert("NO");
									}
								}
								if (alert_type.equalsIgnoreCase("SMS")) {
									if (isActive.equalsIgnoreCase("Y")) {
										bean.setSmsAlert("YES");
									} else {
										bean.setSmsAlert("NO");
									}
								}
							}
						} else {
							bean.setMailAlert("NO");
							bean.setSmsAlert("NO");
							bean.setTaxSchedular("NO");
						}

						map.put("" + i, bean);
						i++;
					}
				}
			}
			return map;
		} catch (Exception r) {
			r.printStackTrace();
		}
		return null;
	}

	public Map<String, BillsBean> getSchedularReportOverDueBills(String ledgerName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			Map<String, BillsBean> map = new HashMap<String, BillsBean>();
			BillsBean bean = null;
			int ledgerId = getLedgerIdByName(ledgerName);
			String sqlString = "SELECT ledger_under_group_name FROM st_rm_acc_ledger_master where ledger_id="
					+ ledgerId;
			SQLQuery query = session.createSQLQuery(sqlString);
			List<String> list = query.list();
			String ledgerUnderName = list.get(0);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
			c.setTimeZone(tz);

			int limit = getCreditPeriod(ledgerId);
			if (limit <= 0)
				limit = 0;
			if (ledgerUnderName.equalsIgnoreCase("Sundry debtors")) {
				sqlString = "SELECT * FROM st_rm_bill_wise_details_sale where party_id=" + ledgerId;
				SQLQuery query2 = session.createSQLQuery(sqlString);
				List<Object[]> result = query2.list();
				if (result != null && !result.isEmpty() && result.size() > 0) {
					int i = 1;
					for (Object[] obj : result) {
						bean = new BillsBean();
						bean.setLedgerId(String.valueOf(ledgerId));
						bean.setBillAmount(obj[3].toString() + " " + obj[6].toString());
						bean.setBillDate(obj[5].toString());
						bean.setBillId((int) obj[0]);
						bean.setBillTaxAmount(obj[9].toString());
						bean.setBillUsed(obj[4].toString());
						bean.setBillVoucherNo(obj[8].toString());
						bean.setLastSchedularDate(obj[10].toString());
						bean.setLedgerName(ledgerName);
						bean.setBillDueLimit(String.valueOf(limit));
						bean.setTypeOfRef(obj[1].toString());
						c.setTime(sdf.parse(obj[5].toString()));
						c.add(Calendar.DAY_OF_MONTH, limit);
						String datePeriod = sdf.format(c.getTime());
						bean.setBillDueDate(datePeriod);
						bean.setSecurityAmt("0");
						bean.setMailAlert("NO");
						bean.setSmsAlert("NO");
						bean.setTaxSchedular("NO");

						map.put("" + i, bean);
						i++;
					}
				}
			} else if (ledgerUnderName.equalsIgnoreCase("Sundry creditors")) {
				sqlString = "SELECT * FROM st_rm_bill_wise_details where party_id=" + ledgerId;
				SQLQuery query2 = session.createSQLQuery(sqlString);
				List<Object[]> result = query2.list();
				if (result != null && !result.isEmpty() && result.size() > 0) {
					int i = 1;
					for (Object[] obj : result) {
						bean = new BillsBean();
						bean.setLedgerId(String.valueOf(ledgerId));
						bean.setBillAmount(obj[3].toString() + " " + obj[6].toString());
						bean.setBillDate(obj[5].toString());
						bean.setBillId((int) obj[0]);
						bean.setBillTaxAmount(obj[9].toString());
						bean.setBillUsed(obj[4].toString());
						bean.setBillVoucherNo(obj[8].toString());
						bean.setLastSchedularDate(obj[10].toString());
						bean.setLedgerName(ledgerName);
						bean.setBillDueLimit(String.valueOf(limit));
						bean.setTypeOfRef(obj[1].toString());
						bean.setSecurityAmt("0");
						bean.setMailAlert("NO");
						bean.setSmsAlert("NO");
						bean.setTaxSchedular("NO");
						map.put("" + i, bean);
						i++;
					}
				}
			}
			return map;
		} catch (Exception r) {
			r.printStackTrace();
		}
		return null;
	}

	public boolean changeAlertStatus(String alertType, String partyId, String voucherNo, String status, String billId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "";
			if (status.equals("STOP")) {
				sqlString = "DELETE FROM st_rm_alert_scheduling_mgmt WHERE alert_type='" + alertType
						+ "' and ledger_id=" + partyId + " and voucher_no='" + voucherNo + "' and bill_id=" + billId;
			} else {

				sqlString = "INSERT INTO st_rm_alert_scheduling_mgmt(`ledger_id`,`voucher_no`,`bill_id`,`alert_type`,`is_active`) values("
						+ partyId + ",'" + voucherNo + "'," + billId + ",'" + alertType + "','Y')";
			}
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean allowAlert(String partyAcc, String alertType) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int ledgerId = getLedgerIdByName(partyAcc);
			SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_alert_scheduling_mgmt where ledger_id="
					+ ledgerId + " and alert_type='" + alertType + "'");
			List<Object[]> obj = query.list();
			if (obj != null && !obj.isEmpty() && obj.size() > 0) {
				for (Object[] o : obj)
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getInterestAmount(String partyAcc, String suffix, String referenceNo) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int ledgerId = getLedgerIdByName(partyAcc);
			String table = suffix;
			if (suffix.contains("sale"))
				suffix = " sale_voucher_number='" + referenceNo + "'";
			else
				suffix = " purchase_voucher_number='" + referenceNo + "'";
			SQLQuery query = session.createSQLQuery("SELECT tax_amount from st_rm_bill_wise_details" + table
					+ " where party_id=" + ledgerId + " and" + suffix);
			List<String> res = query.list();
			if (res != null && !res.isEmpty() && res.size() > 0) {
				return res.get(0) != null ? res.get(0) : "0";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}

	public boolean changeAlertStatus(String partyId, String voucherNo, String status, String billId,
			String remindBefDay, String remindAftDay, String remindInterval) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("DELETE FROM st_rm_bill_due_alert_scheduling_mgmt WHERE ledger_id="
					+ partyId + " and voucher_no='" + voucherNo + "' and bill_id='" + billId + "'");
			query.executeUpdate();
			SQLQuery query2 = session.createSQLQuery(
					"INSERT INTO st_rm_bill_due_alert_scheduling_mgmt(`ledger_id`,`voucher_no`,`bill_id`,`alert_day_before`,`alert_day_duration`,`alert_interval`) values("
							+ partyId + ",'" + voucherNo + "'," + billId + "," + remindBefDay + "," + remindAftDay + ","
							+ remindInterval + ")");
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changeAlertStatus(String partyName, String voucherNo) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int partyId = getLedgerIdByName(partyName);
			SQLQuery query = session.createSQLQuery("DELETE FROM st_rm_bill_due_alert_scheduling_mgmt WHERE ledger_id="
					+ partyId + " and voucher_no='" + voucherNo + "'");
			query.executeUpdate();
			int remindBefDay = 15;
			int remindAftDay = 300;
			int remindInterval = 300;
			SQLQuery query2 = session.createSQLQuery(
					"INSERT INTO st_rm_bill_due_alert_scheduling_mgmt(`ledger_id`,`voucher_no`,`alert_day_before`,`alert_day_duration`,`alert_interval`) values("
							+ partyId + ",'" + voucherNo + "'," + remindBefDay + "," + remindAftDay + ","
							+ remindInterval + ")");
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void runScheduleOverDueBillsSales() {

		try {
			Session session = HibernateSessionFactory.getSession();
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date.format(formatter);

			String sqlString = "SELECT * FROM st_rm_bill_wise_details_sale where type_of_ref='Agst Ref' and is_used='No'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
			c.setTimeZone(tz);
			if (result != null && !result.isEmpty() && result.size() > 0) {

				for (Object[] obj : result) {

					int billId = (int) obj[0];
					int partyId = (int) obj[2];

					boolean isSmsAllow = getIsSmsAllow(partyId);
					if (!isSmsAllow)
						continue;
					sqlString = "SELECT balance,balance_type from st_rm_purchase_party_master_balance where party_id="
							+ partyId;
					SQLQuery queryS = session.createSQLQuery(sqlString);
					List<Object[]> objBal = queryS.list();
					String partyBal = "";
					if (objBal != null && !objBal.isEmpty() && objBal.size() > 0) {
						for (Object[] o : objBal) {
							partyBal = o[0] + " " + o[1];
						}

					}
					String billDate = obj[5].toString();
					String vchrNo = obj[8].toString();
					String billamt = obj[3].toString();
					int billDueLimit = getCreditPeriod(partyId);
					c.setTime(sdf.parse(billDate));
					c.add(Calendar.DAY_OF_MONTH, billDueLimit);
					String DueBillDate = sdf.format(c.getTime());
					sqlString = "SELECT * FROM st_rm_bill_due_alert_scheduling_mgmt where ledger_id=" + partyId
							+ " and voucher_no='" + vchrNo + "'";
					SQLQuery queryString = session.createSQLQuery(sqlString);
					List<Object[]> rs = queryString.list();
					if (rs != null && !rs.isEmpty() && rs.size() > 0) {
						for (Object[] o : rs) {
							int alertBefore = (int) o[4];
							int alertAfter = (int) o[5];
							int interval = (int) o[6];
							c.setTime(sdf.parse(DueBillDate));
							c.add(Calendar.DAY_OF_MONTH, -alertBefore);
							String DueBillDateMinusAlertDay = sdf.format(c.getTime());
							if (compareTwoDate(DueBillDateMinusAlertDay + " 00:00", currentDate + " 00:00")) {
								String propContact = getPropContact(partyId);
								String propName = getPropName(partyId);
								String firmName = getPropFirmName(partyId);
								String sms = "Dear " + propName + ", Your bill no. " + vchrNo + ", billing date "
										+ billDate + " of amount " + billamt + " due on " + DueBillDate
										+ ". Your current balance is " + partyBal + "."
										+ ". Please pay your bill amount before due date to avoid interest charges. Please ignore if you have already paid. Regards JAMIDARA SEEDS CORPORATION (Karnataka) ";
								sendSMS(propContact, sms);
								String empMobile = getUnderEmpMobile(partyId);
								String empname = getUnderEmpName(partyId);
								String sms1 = "Dear " + empname + ", Your distributor " + firmName + " bill no. "
										+ vchrNo + ", billing date " + billDate + "of amount " + billamt + " due on "
										+ DueBillDate + ". Party Current Balance is " + partyBal + "."
										+ ". Please collect bill amount before due date to avoid interest charges & to avoid discontinuity of transactions. Regards JAMIDARA SEEDS CORPORATION (Karnataka) ";
								sendSMS(empMobile, sms1);
							}
						}

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean getIsSmsAllow(int partyId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM st_rm_alert_scheduling_mgmt WHERE alert_type='interest' and ledger_id=" + partyId);
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty()) {
				for (Object[] obj : result) {
					String status = obj[5].toString();
					if (status.equalsIgnoreCase("Y")) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private void sendSMS(String mobile, String sms) {
		try {
			SendSMS sendSMS1 = new SendSMS();
			sendSMS1.setMobileNo("91" + mobile);
			sendSMS1.setMsg(sms);
			Thread thread1 = new Thread(sendSMS1);
			thread1.setDaemon(true);
			thread1.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean deductInterestRate(String partyId, String voucherNo, String billId, String deductPercent) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sqlString = "SELECT ledger_under_group_name from st_rm_acc_ledger_master WHERE ledger_id=" + partyId;
			SQLQuery query = session.createSQLQuery(sqlString);
			List<String> result = query.list();
			String ledgerUnder = result.get(0);

			if (ledgerUnder.equalsIgnoreCase("Sundry debtors")) {

				sqlString = "SELECT balance,tax_amount from st_rm_bill_wise_details_sale WHERE sale_voucher_number='"
						+ voucherNo + "' and party_id=" + partyId;
				SQLQuery query2 = session.createSQLQuery(sqlString);
				List<Object[]> resultList = query2.list();
				if (resultList != null && !resultList.isEmpty() && resultList.size() > 0) {

					for (Object[] obj : resultList) {

						Double balcn = Double.valueOf(obj[0].toString());
						Double tax = Double.valueOf(obj[1].toString());

						Double ratePer = (tax * Double.valueOf(deductPercent)) / 100;
						String append = "";
						tax = tax - ratePer;
						balcn = balcn - ratePer;
						if (balcn < 0) {
							balcn = 0.0;
							append = ",is_used='Yes'";
						}
						sqlString = "UPDATE st_rm_bill_wise_details_sale SET balance='" + balcn + "',tax_amount='" + tax
								+ "'" + append + " WHERE sale_voucher_number='" + voucherNo + "' and party_id="
								+ partyId;
						SQLQuery query3 = session.createSQLQuery(sqlString);
						query3.executeUpdate();
					}
				}
			} else if (ledgerUnder.equalsIgnoreCase("Sundry creditors")) {

				sqlString = "SELECT balance,tax_amount from st_rm_bill_wise_details WHERE purchase_voucher_number='"
						+ voucherNo + "' and party_id=" + partyId;
				SQLQuery query2 = session.createSQLQuery(sqlString);
				List<Object[]> resultList = query2.list();
				if (resultList != null && !resultList.isEmpty() && resultList.size() > 0) {

					for (Object[] obj : resultList) {

						Double balcn = Double.valueOf(obj[0].toString());
						Double tax = Double.valueOf(obj[1].toString());

						Double ratePer = (tax * Double.valueOf(deductPercent)) / 100;
						String append = "";
						tax = tax - ratePer;
						balcn = balcn - ratePer;
						if (balcn < 0) {
							balcn = 0.0;
							append = ",is_used='Yes'";
						}
						sqlString = "UPDATE st_rm_bill_wise_details SET balance='" + balcn + "',tax_amount='" + tax
								+ "'" + append + " WHERE purchase_voucher_number='" + voucherNo + "' and party_id="
								+ partyId;
						SQLQuery query3 = session.createSQLQuery(sqlString);
						query3.executeUpdate();
					}
				}
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public void scheduleItemExpiryDate() {

		try {
			Session session = HibernateSessionFactory.getSession();
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date.format(formatter);
			String sqlString = "SELECT * FROM st_rm_item_qty_godown where is_alert='Yes'";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {

				for (Object[] obj : result) {

					String itemExpiry = obj[7].toString();
					String itemMan = obj[6].toString();
					String alert_date = obj[9].toString();
					int itemId = (int) obj[1];
					int godownId = (int) obj[2];

					if (alert_date.equals(currentDate)) {

						sqlString = "SELECT item_name from st_rm_stock_item_master where st_it_id=" + itemId;
						SQLQuery query2 = session.createSQLQuery(sqlString);
						List<String> rs = query2.list();
						sqlString = "SELECT name from st_rm_Godown_master where gd_id=" + godownId;
						SQLQuery query3 = session.createSQLQuery(sqlString);
						List<String> rs1 = query3.list();
						sqlString = "SELECT batch_id from st_rm_stock_item_godown_opening_blc where godown_id="
								+ godownId + " and item_id=" + itemId;
						SQLQuery query4 = session.createSQLQuery(sqlString);
						List<String> rs2 = query3.list();

						String itemName = rs.get(0);
						String godownName = rs1.get(0);
						String batch = rs2.get(0);
						String sms = "Dear admin, your item name " + itemName + " of godown " + godownName.toUpperCase()
								+ " of batch " + batch
								+ " is going to expire soon. Item manufacturing & expiry date is " + itemMan + " & "
								+ itemExpiry + ".";
						sendSMS("9785290750", sms);
						sendSMS("9414429966", sms);

					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void scheduleEmployeeVisit() {

		try {
			Session session = HibernateSessionFactory.getSession();
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date.format(formatter);

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			Calendar c = Calendar.getInstance();
			TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
			c.setTimeZone(tz);

			String sqlString = "SELECT detail_id,distributor,retailerName,reminder,visitPurpose from bo_um_attendance_visit where reminder NOT IN('')";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {

				for (Object[] obj : result) {
					int detailId = (int) obj[0];
					String dName = obj[1].toString();
					String rName = obj[2].toString();
					String rem = obj[3].toString();
					String visitPur = obj[4].toString();
					c.setTime(sdf.parse(rem));
					c.add(Calendar.DAY_OF_MONTH, -1);
					String DueBillDateMinusAlertDay = sdf.format(c.getTime());
					if (currentDate.equals(DueBillDateMinusAlertDay)) {

						int empId = getEmpIdfromDetailId(detailId);
						String empName = getEmpNameFromId(empId);
						String empPhone = getEmpMobileFromId(empId);
						String sms = "Dear " + empName
								+ "! This is a reminder that you have visit tomorrow with Distributor " + dName
								+ " Retailer " + rName + ".Your visit purpose is " + visitPur
								+ ". Please arrange your others visits accordingly. Regards JAMIDARA SEEDS CORPORATION (Karnataka) ";
						sendSMS(empPhone, sms);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String getEmpMobileFromId(int empId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT phone_num from st_rm_bo_user_info WHERE user_id=" + empId);
			List<String> empRs = query.list();
			return empRs.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getEmpNameFromId(int empId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT first_name from st_rm_bo_user_info WHERE user_id=" + empId);
			List<String> empRs = query.list();
			return empRs.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private int getEmpIdfromDetailId(int detailId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT emp_id from bo_um_employee_attendance WHERE detail_id=" + detailId);
			List<Integer> empRs = query.list();
			return empRs.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void setDocumentPath(int salesNo, String fileFullPath, int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("UPDATE st_rm_txn_sales_master_emp SET doc_path='" + fileFullPath
					+ "' WHERE salesId=" + salesNo + " and emp_id=" + userId);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setDocumentPathReceipt(int receiptNo, String fileFullPath, int userId, String txnType) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = null;

			if (txnType != null && txnType.equals("receipt")) {
				query = session.createSQLQuery("UPDATE st_rm_txn_receipt_master SET doc_path='" + fileFullPath
						+ "' WHERE receiptId=" + receiptNo + " and empId=" + userId);
				query.executeUpdate();

			} else {
				query = session.createSQLQuery("UPDATE st_rm_txn_receipt_master_emp SET doc_path='" + fileFullPath
						+ "' WHERE receiptId=" + receiptNo + " and emp_id=" + userId);
				query.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setDocumentPathPayment(int paymentNo, String fileFullPath, int userId, String txnType) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = null;

			if (txnType != null && txnType.equals("payment")) {
				query = session.createSQLQuery("UPDATE st_rm_txn_payment_master SET doc_path='" + fileFullPath
						+ "' WHERE paymentId=" + paymentNo + " and empId=" + userId);
				query.executeUpdate();

			} else {

				query = session.createSQLQuery("UPDATE st_rm_txn_payment_master_emp SET doc_path='" + fileFullPath
						+ "' WHERE paymentId=" + paymentNo + " and emp_id=" + userId);
				query.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setDocumentPathPurchase(int purchaseNo, String fileFullPath, int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("UPDATE st_rm_txn_purchase_master_emp SET doc_path='" + fileFullPath
					+ "' WHERE purchaseId=" + purchaseNo + " and emp_id=" + userId);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setDocumentPathSales(String salesNoVoucher, String fileFullPathDD, String fileFullPathTB,
			String vcrId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("UPDATE st_rm_txn_sales_master SET doc_dd_path='" + fileFullPathDD
					+ "',doc_billt_path='" + fileFullPathTB + "' WHERE voucher_numbering='" + salesNoVoucher
					+ "' and under_vcr_id=" + vcrId);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean getActiveInterest(String ledgerName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int ledgerId = getLedgerIdByName(ledgerName);
			SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_alert_scheduling_mgmt where ledger_id="
					+ ledgerId + " and alert_type='interest'");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean getActiveInterestSMS(String ledgerName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int ledgerId = getLedgerIdByName(ledgerName);
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM st_rm_alert_scheduling_mgmt where ledger_id=" + ledgerId + " and alert_type='SMS'");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0 && result.get(0) != null) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changeStatus(String ledgerName, String status) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int ledId = getLedgerIdByName(ledgerName);
			String sqlString = "";
			if (status.equalsIgnoreCase("start"))
				sqlString = "INSERT INTO st_rm_alert_scheduling_mgmt(`ledger_id`,`voucher_no`,`bill_id`,`alert_type`) values("
						+ ledId + ",'0',0,'interest')";
			else
				sqlString = "DELETE FROM st_rm_alert_scheduling_mgmt where ledger_id=" + ledId
						+ " and alert_type='interest'";

			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changeStatusSMS(String ledgerName, String status) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int ledId = getLedgerIdByName(ledgerName);
			String sqlString = "";
			if (status.equalsIgnoreCase("start"))
				sqlString = "INSERT INTO st_rm_alert_scheduling_mgmt(`ledger_id`,`voucher_no`,`bill_id`,`alert_type`) values("
						+ ledId + ",'0',0,'SMS')";
			else
				sqlString = "DELETE FROM st_rm_alert_scheduling_mgmt where ledger_id=" + ledId
						+ " and alert_type='SMS'";

			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void calculateOverDueAmountInterest() {

		try {
			Logger logger = Logger.getLogger(GameLobbyController.class.getName());
			logger.info("::::::::::::SCHEDULING START OF TAX REPORT:::::::::::::::::::::::::");
			Session session = HibernateSessionFactory.getSession();
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date.format(formatter);
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM st_rm_ledger_interset_calculation WHERE rate_on IN('Debit Balances Only')");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				for (Object[] obj : result) {
					String IstxnByTxn = obj[2].toString();
					String alwaysOrPastDueDate = obj[9].toString();
					String calculateFrom = obj[12].toString();
					if (IstxnByTxn.equalsIgnoreCase("yes")) {
						logger.info("::::::::::::INSIDE BILL WISE :::::::::::::::::::::::::");
						String rateMonthOrYear = obj[7].toString();
						if (rateMonthOrYear.equalsIgnoreCase("Calendar Month")) {
							logger.info("::::::::::::INSIDE CALENDAR MONTH:::::::::::::::::::::::::");
							String dueLimit = !obj[10].toString().isEmpty() ? obj[10].toString() : "0";
							String gracePeriod = !obj[11].toString().isEmpty() ? obj[11].toString() : "0";
							Integer totalDays = Integer.valueOf(dueLimit) + Integer.valueOf(gracePeriod);

							Integer ledgerId = (int) obj[1];

							SQLQuery query1 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details_sale WHERE type_of_ref IN('Agst Ref') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> saleBillsresult = query1.list();
							if (saleBillsresult != null && !saleBillsresult.isEmpty() && saleBillsresult.size() > 0) {

								for (Object[] saleObj : saleBillsresult) {
									if (isInterestAllow(ledgerId))
										continue;
									String saleBillDate = saleObj[5].toString();
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);
									c.setTime(sdf.parse(saleBillDate));
									int days = totalDays + 1;
									c.add(Calendar.DAY_OF_MONTH, days);
									String datePeriod = sdf.format(c.getTime());

									if (compareEqualsDate(datePeriod + " 00:00", currentDate + " 00:00")) {

										Double taxRate = Double.valueOf(obj[6].toString());
										taxRate = taxRate * 12;
										int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
										logger.info("------------------->DAYS IN MONTH IS :" + monthMaxDays);
										double dayPercentRateCalculate = (taxRate / 365) * (double) totalDays;

										Double saleBillAmount = Double.valueOf(saleObj[3].toString());
										Double repsaleBillAmount = saleBillAmount;
										Double billTax = (saleBillAmount * dayPercentRateCalculate) / 100;
										saleBillAmount = saleBillAmount + billTax;
										int saleBillId = (int) saleObj[0];
										logger.info("::::::::::::SALE BILL :::::::::::::::::::::::::" + saleBillId);
										String saleTaxAmountOld = saleObj[9].toString();
										Double saleTaxAmountNew = Double.valueOf(saleTaxAmountOld) + billTax;

										SQLQuery updateBillQuery = session
												.createSQLQuery("UPDATE st_rm_bill_wise_details_sale SET balance='"
														+ String.format("%.2f", saleBillAmount) + "',tax_amount='"
														+ String.format("%.2f", saleTaxAmountNew) + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + saleBillId);
										updateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + saleBillId + ",'" + saleObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ repsaleBillAmount + "','" + billTax + "','" + saleBillAmount
														+ "','" + partyBlnc + "','" + blncTyp + "','Sale')");
										Schquery.executeUpdate();
										// sale tax billing end

										logger.info(
												"::::::::::::SALE BILL WISE TAX SCHEDULING SUCCESS:::::::::::::::::::::::::");
									}
								}
							}

							// purchase tax billing start
							logger.info(
									"::::::::::::SCHEDULING START OF TAX REPORT PURCHASING:::::::::::::::::::::::::");
							SQLQuery query2 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details WHERE type_of_ref IN('Agst Ref') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> purchaseBillsresult = query2.list();
							if (purchaseBillsresult != null && !purchaseBillsresult.isEmpty()
									&& purchaseBillsresult.size() > 0) {

								for (Object[] purchaseObj : purchaseBillsresult) {
									String purchaseBillDate = purchaseObj[5].toString();
									if (isInterestAllow(ledgerId))
										continue;
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);
									c.setTime(sdf.parse(purchaseBillDate));
									int days = totalDays + 1;
									c.add(Calendar.DAY_OF_MONTH, days);
									String purchasedatePeriod = sdf.format(c.getTime());
									if (compareEqualsDate(purchasedatePeriod + " 00:00", currentDate + " 00:00")) {

										Double PtaxRate = Double.valueOf(obj[6].toString());
										Calendar Pc = Calendar.getInstance();
										int PmonthMaxDays = Pc.getActualMaximum(Calendar.DAY_OF_MONTH);
										PtaxRate = PtaxRate * 12;
										double PdayPercentRateCalculate = (PtaxRate / 365) * (double) totalDays;

										Double purchaseBillAmount = Double.valueOf(purchaseObj[3].toString());
										Double reppurchaseBillAmount = purchaseBillAmount;
										Double purchasebillTax = (purchaseBillAmount * PdayPercentRateCalculate) / 100;
										purchaseBillAmount = purchaseBillAmount + purchasebillTax;
										int purchaseBillId = (int) purchaseObj[0];
										logger.info(
												"::::::::::::PURCHASE BILL :::::::::::::::::::::::::" + purchaseBillId);
										String purchaseTaxAmountOld = purchaseObj[9].toString();
										Double purchaseTaxAmountNew = Double.valueOf(purchaseTaxAmountOld)
												+ purchasebillTax;

										SQLQuery purchaseupdateBillQuery = session.createSQLQuery(
												"UPDATE st_rm_bill_wise_details SET balance='" + purchaseBillAmount
														+ "',tax_amount='" + purchaseTaxAmountNew + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + purchaseBillId);
										purchaseupdateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + purchaseBillId + ",'" + purchaseObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ reppurchaseBillAmount + "','" + purchasebillTax + "','"
														+ purchaseBillAmount + "','" + partyBlnc + "','" + blncTyp
														+ "','Purchase')");
										Schquery.executeUpdate();

										logger.info(
												"::::::::::::SCHEDULING TAX SUCCESS OF PURCHASE :::::::::::::::::::::::::");

									}

								}

							}

						} else if (rateMonthOrYear.equalsIgnoreCase("Calendar Year")) {
							logger.info("::::::::::::INSIDE CALENDAR Year:::::::::::::::::::::::::");
							String dueLimit = !obj[10].toString().isEmpty() ? obj[10].toString() : "0";
							String gracePeriod = !obj[11].toString().isEmpty() ? obj[11].toString() : "0";
							Integer totalDays = Integer.valueOf(dueLimit) + Integer.valueOf(gracePeriod);

							Integer ledgerId = (int) obj[1];
							SQLQuery query1 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details_sale WHERE type_of_ref IN('Agst Ref') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> saleBillsresult = query1.list();
							if (saleBillsresult != null && !saleBillsresult.isEmpty() && saleBillsresult.size() > 0) {

								for (Object[] saleObj : saleBillsresult) {
									if (isInterestAllow(ledgerId))
										continue;

									String saleBillDate = saleObj[5].toString();
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);
									int days = totalDays + 1;
									c.setTime(sdf.parse(saleBillDate));
									c.add(Calendar.DAY_OF_MONTH, days);
									String datePeriod = sdf.format(c.getTime());

									if (compareEqualsDate(datePeriod + " 00:00", currentDate + " 00:00")) {

										Double taxRate = Double.valueOf(obj[6].toString());
										int yearMaxDays = c.getActualMaximum(Calendar.DAY_OF_YEAR);
										double dayPercentRateCalculate = (taxRate / 365) * (double) totalDays;

										Double saleBillAmount = Double.valueOf(saleObj[3].toString());
										Double repsaleBillAmount = saleBillAmount;
										Double billTax = (saleBillAmount * dayPercentRateCalculate) / 100;
										saleBillAmount = saleBillAmount + billTax;
										int saleBillId = (int) saleObj[0];
										logger.info("::::::::::::SALE BILL :::::::::::::::::::::::::" + saleBillId);
										String saleTaxAmountOld = saleObj[9].toString();
										Double saleTaxAmountNew = Double.valueOf(saleTaxAmountOld) + billTax;

										SQLQuery updateBillQuery = session
												.createSQLQuery("UPDATE st_rm_bill_wise_details_sale SET balance='"
														+ String.format("%.2f", saleBillAmount) + "',tax_amount='"
														+ String.format("%.2f", saleTaxAmountNew) + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + saleBillId);
										updateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + saleBillId + ",'" + saleObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ repsaleBillAmount + "','" + billTax + "','" + saleBillAmount
														+ "','" + partyBlnc + "','" + blncTyp + "','Sale')");
										Schquery.executeUpdate();

										// sale tax billing end
										logger.info(
												"::::::::::::SALE BILL WISE TAX SCHEDULING SUCCESS:::::::::::::::::::::::::");
									}
								}
							}

							// purchase tax billing start
							logger.info(
									"::::::::::::SCHEDULING START OF TAX REPORT PURCHASING:::::::::::::::::::::::::");
							SQLQuery query2 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details WHERE type_of_ref IN('Agst Ref') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> purchaseBillsresult = query2.list();
							if (purchaseBillsresult != null && !purchaseBillsresult.isEmpty()
									&& purchaseBillsresult.size() > 0) {

								for (Object[] purchaseObj : purchaseBillsresult) {
									String purchaseBillDate = purchaseObj[5].toString();
									if (isInterestAllow(ledgerId))
										continue;

									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);

									c.setTime(sdf.parse(purchaseBillDate));
									int days = totalDays + 1;
									c.add(Calendar.DAY_OF_MONTH, days);
									String purchasedatePeriod = sdf.format(c.getTime());
									if (compareTwoDate(purchasedatePeriod + " 00:00", currentDate + " 00:00")) {

										Double PtaxRate = Double.valueOf(obj[6].toString());
										Calendar Pc = Calendar.getInstance();
										int PyearMaxDays = Pc.getActualMaximum(Calendar.DAY_OF_YEAR);
										double PdayPercentRateCalculate = (PtaxRate / 365) * (double) totalDays;

										Double purchaseBillAmount = Double.valueOf(purchaseObj[3].toString());
										Double reppurchaseBillAmount = purchaseBillAmount;
										Double purchasebillTax = (purchaseBillAmount * PdayPercentRateCalculate) / 100;
										purchaseBillAmount = purchaseBillAmount + purchasebillTax;
										int purchaseBillId = (int) purchaseObj[0];
										logger.info(
												"::::::::::::PURCHASE BILL :::::::::::::::::::::::::" + purchaseBillId);
										String purchaseTaxAmountOld = purchaseObj[9].toString();
										Double purchaseTaxAmountNew = Double.valueOf(purchaseTaxAmountOld)
												+ purchasebillTax;

										SQLQuery purchaseupdateBillQuery = session.createSQLQuery(
												"UPDATE st_rm_bill_wise_details SET balance='" + purchaseBillAmount
														+ "',tax_amount='" + purchaseTaxAmountNew + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + purchaseBillId);
										purchaseupdateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + purchaseBillId + ",'" + purchaseObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ reppurchaseBillAmount + "','" + purchasebillTax + "','"
														+ purchaseBillAmount + "','" + partyBlnc + "','" + blncTyp
														+ "','Purchase')");
										Schquery.executeUpdate();

										logger.info(
												"::::::::::::SCHEDULING TAX SUCCESS OF PURCHASE :::::::::::::::::::::::::");

									}

								}

							}

						}
					}
				}
			}
			logger.info("::::::::::::SCHEDULING END  :::::::::::::::::::::::::");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Map<String, BillsBean> getPartyTransactionReport(String txnType, String toDate, String fromDate,
			String employeeName, String ledgerName, String billId) {

		try {
			BillsBean bean = null;
			Map<String, BillsBean> map = new HashMap<String, BillsBean>();
			Session session = HibernateSessionFactory.getSession();
			String tableName = "";
			if (!txnType.equals("-1")) {

				if (txnType.equals("SALES")) {
					tableName = "SELECT * FROM st_rm_txn_sales_master AS a INNER JOIN `st_rm_bill_wise_details_sale` AS b ON a.voucher_numbering = b.sale_voucher_number WHERE transport_fright>=0 ";
					if (!employeeName.equals("-1")) {
						int empId = getEmployeeId(employeeName);
						tableName += " and a.emp_id=" + empId + " ";
					}
					if (ledgerName != null && !ledgerName.equals("-1")) {
						tableName += " and a.party_acc_name='" + ledgerName + "' ";

					}
					if (billId != null && !billId.equals("-1")) {
						tableName += " and a.voucher_numbering='" + billId + "' ";

					}
					if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
						tableName += " and STR_TO_DATE(a.saleDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
								+ "','%d-%m-%Y') and STR_TO_DATE(a.saleDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
								+ "','%d-%m-%Y')";

					}

					SQLQuery query = session.createSQLQuery(tableName);
					List<Object[]> objTes = query.list();
					if (objTes != null && !objTes.isEmpty() && objTes.size() > 0) {
						int i = 1;
						for (Object[] obj : objTes) {
							bean = new BillsBean();
							bean.setLedgerName(obj[1].toString());
							bean.setTxnType(txnType);
							bean.setSubLedger(obj[3].toString());
							String[] dateArr = obj[17].toString().split("-");
							String date = dateArr[2] + "/" + dateArr[1] + "/" + dateArr[0];
							bean.setBillDate(date);
							bean.setBillVoucherNo(obj[10].toString());
							bean.setBillUsed(obj[33].toString());
							bean.setTypeOfRef(obj[30].toString());
							bean.setActualBillAmount(obj[9] != null ? obj[9].toString() : "0");
							bean.setBillAmount(obj[32].toString() + " " + obj[35].toString());
							map.put("" + i, bean);
							i++;
						}

					}
				} else if (txnType.equals("PURCHASE")) {

					tableName = "SELECT * FROM st_rm_txn_purchase_master AS a INNER JOIN `st_rm_bill_wise_details` AS b ON a.voucher_numbering = b.purchase_voucher_number WHERE transport_fright>=0 ";
					if (!employeeName.equals("-1")) {
						int empId = getEmployeeId(employeeName);
						tableName += " and a.emp_id=" + empId + " ";
					}
					if (ledgerName != null && !ledgerName.equals("-1")) {
						tableName += " and a.party_acc_name='" + ledgerName + "' ";

					}
					if (billId != null && !billId.equals("-1")) {
						tableName += " and a.voucher_numbering='" + billId + "' ";

					}
					if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
						tableName += " and STR_TO_DATE(a.purchaseDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
								+ "','%d-%m-%Y') and STR_TO_DATE(a.purchaseDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
								+ "','%d-%m-%Y')";

					}

					SQLQuery query = session.createSQLQuery(tableName);
					List<Object[]> objTes = query.list();
					if (objTes != null && !objTes.isEmpty() && objTes.size() > 0) {
						int i = 1;
						for (Object[] obj : objTes) {
							bean = new BillsBean();
							bean.setLedgerName(obj[1].toString());
							bean.setSubLedger(obj[3].toString());
							bean.setTxnType(txnType);
							String[] dateArr = obj[17].toString().split("-");
							String date = dateArr[2] + "/" + dateArr[1] + "/" + dateArr[0];
							bean.setBillDate(date);
							bean.setBillVoucherNo(obj[10].toString());
							bean.setBillUsed(obj[31].toString());
							bean.setTypeOfRef(obj[28].toString());
							bean.setBillAmount(obj[30].toString() + " " + obj[33].toString());
							bean.setActualBillAmount(obj[9] != null ? obj[9].toString() : "0");
							map.put("" + i, bean);
							i++;
						}

					}

				} else if (txnType.equals("RECEIPT")) {

					tableName = "SELECT * FROM st_rm_txn_receipt_master as a WHERE under_vcr_id>=0 ";
					if (!employeeName.equals("-1")) {
						int empId = getEmployeeId(employeeName);
						tableName += " and a.empId=" + empId + " ";
					}
					if (ledgerName != null && !ledgerName.equals("-1")) {
						tableName += " and a.Particulars like '%" + ledgerName + "%' ";

					}
					if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
						tableName += " and STR_TO_DATE(a.receipt_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
								+ "','%d-%m-%Y') and STR_TO_DATE(a.receipt_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
								+ "','%d-%m-%Y')";

					}

					SQLQuery query = session.createSQLQuery(tableName);
					List<Object[]> objTes = query.list();
					if (objTes != null && !objTes.isEmpty() && objTes.size() > 0) {
						int i = 1;
						for (Object[] obj : objTes) {
							bean = new BillsBean();
							String queryS = "SELECT type_of_ref FROM st_rm_receipt_sale_bill_mapping where receiptVcr='"
									+ obj[12].toString() + "'";
							SQLQuery querySQ = session.createSQLQuery(queryS);
							List<String> resultQ = querySQ.list();
							String vcrSuffix = "";
							if (resultQ != null && !resultQ.isEmpty() && resultQ.size() > 0) {
								for (String s : resultQ)
									vcrSuffix = vcrSuffix + s + ",";
							}
							if (vcrSuffix.length() > 0)
								vcrSuffix = vcrSuffix.substring(0, vcrSuffix.length() - 1);
							bean.setLedgerName(obj[4].toString().split(",")[0]);
							bean.setSubLedger("-");
							bean.setTxnType(txnType);
							String[] dateArr = obj[13].toString().split("-");
							String date = dateArr[2] + "/" + dateArr[1] + "/" + dateArr[0];
							bean.setBillDate(date);
							bean.setBillVoucherNo(obj[12].toString());
							bean.setBillUsed("-");
							bean.setTypeOfRef(vcrSuffix);
							bean.setActualBillAmount(obj[5].toString().split(",")[0]);
							bean.setBillAmount(obj[5].toString().split(",")[0]);
							map.put("" + i, bean);
							i++;
						}

					}

				} else if (txnType.equals("CREDIT NOTE")) {

					tableName = "SELECT * FROM st_rm_txn_creditNote_master AS a WHERE emp_id>=0 ";
					if (!employeeName.equals("-1")) {
						int empId = getEmployeeId(employeeName);
						tableName += " and a.emp_id=" + empId + " ";
					}
					if (ledgerName != null && !ledgerName.equals("-1")) {
						tableName += " and a.party_acc_name = '" + ledgerName + "' ";

					}
					if (billId != null && !billId.equals("-1")) {
						tableName += " and a.voucher_numbering='" + billId + "' ";

					}
					if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
						tableName += " and STR_TO_DATE(a.cn_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
								+ "','%d-%m-%Y') and STR_TO_DATE(a.cn_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
								+ "','%d-%m-%Y')";

					}

					SQLQuery query = session.createSQLQuery(tableName);
					List<Object[]> objTes = query.list();
					if (objTes != null && !objTes.isEmpty() && objTes.size() > 0) {
						int i = 1;
						for (Object[] obj : objTes) {
							bean = new BillsBean();
							bean.setLedgerName(obj[1].toString());
							bean.setSubLedger(obj[3].toString());
							bean.setTxnType(txnType);
							String[] dateArr = obj[11].toString().split("-");
							String date = dateArr[2] + "/" + dateArr[1] + "/" + dateArr[0];
							bean.setBillDate(date);
							bean.setBillVoucherNo(obj[10].toString());
							bean.setBillUsed("-");
							bean.setTypeOfRef("-");
							bean.setActualBillAmount(obj[9] != null ? obj[9].toString() : "0");
							bean.setBillAmount(obj[9].toString());
							map.put("" + i, bean);
							i++;
						}

					}

				} else if (txnType.equals("JOURNAL")) {

					tableName = "SELECT * FROM st_rm_txn_journal_master AS a WHERE empId>=0 ";
					if (!employeeName.equals("-1")) {
						int empId = getEmployeeId(employeeName);
						tableName += " and a.empId=" + empId + " ";
					}
					if (ledgerName != null && !ledgerName.equals("-1")) {
						tableName += " and a.particulars like '%" + ledgerName + "%' ";

					}
					if (billId != null && !billId.equals("-1")) {
						tableName += " and a.voucher_numbering='" + billId + "' ";

					}
					if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
						tableName += " and STR_TO_DATE(a.journal_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
								+ "','%d-%m-%Y') and STR_TO_DATE(a.journal_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
								+ "','%d-%m-%Y')";

					}

					SQLQuery query = session.createSQLQuery(tableName);
					List<Object[]> objTes = query.list();
					if (objTes != null && !objTes.isEmpty() && objTes.size() > 0) {
						int i = 1;
						for (Object[] obj : objTes) {
							bean = new BillsBean();
							String CrDr = obj[2].toString().split(",")[0];
							String[] DrLedger = obj[3].toString().split(",");
							String lName = "";
							if (CrDr.equalsIgnoreCase("Dr")) {
								lName = DrLedger[0].trim();
							} else {
								lName = DrLedger[1].trim();
							}
							bean.setLedgerName(ledgerName.equals("-1") ? "-" : ledgerName);
							bean.setSubLedger(lName);
							bean.setTxnType(txnType);
							String[] dateArr = obj[8].toString().split("-");
							String date = dateArr[2] + "/" + dateArr[1] + "/" + dateArr[0];
							bean.setBillDate(date);
							bean.setBillVoucherNo(obj[7].toString());
							bean.setBillUsed("-");
							bean.setTypeOfRef("-");
							String ar[] = obj[4].toString().split(",");
							Double d = 0.0;
							for (int p = 0; p < ar.length; p++) {
								if (!ar[p].trim().equals("0"))
									d = d + Double.valueOf(ar[p].trim());
							}
							bean.setBillAmount(String.valueOf(d));
							bean.setActualBillAmount(String.valueOf(d));
							map.put("" + i, bean);
							i++;
						}

					}

				}
			} else {
				tableName = "SELECT * from st_rm_txn_sales_master where party_acc_name='" + ledgerName + "'";
				SQLQuery query1 = session.createSQLQuery(tableName);
				List<Object[]> objTes1 = query1.list();

				tableName = "SELECT * from st_rm_txn_purchase_master where party_acc_name='" + ledgerName + "'";
				SQLQuery query2 = session.createSQLQuery(tableName);
				List<Object[]> objTes2 = query2.list();

				tableName = "SELECT * from st_rm_txn_receipt_master where Particulars like '%" + ledgerName + "%'";
				SQLQuery query3 = session.createSQLQuery(tableName);
				List<Object[]> objTes3 = query3.list();

				tableName = "SELECT * from st_rm_txn_creditNote_master where party_acc_name='" + ledgerName + "'";
				SQLQuery query4 = session.createSQLQuery(tableName);
				List<Object[]> objTes4 = query4.list();
				int j = 1;
				if (objTes1 != null && !objTes1.isEmpty() && objTes1.size() > 0) {
					for (Object[] obj : objTes1) {
						bean = new BillsBean();
						bean.setLedgerName(ledgerName);
						bean.setSubLedger(obj[3].toString());
						bean.setTxnType("SALE");
						bean.setBillDate(obj[17].toString());
						bean.setBillVoucherNo(obj[10].toString());
						bean.setBillUsed("-");
						bean.setTypeOfRef("-");
						bean.setBillAmount(obj[9].toString());
						bean.setActualBillAmount("0.0");
						map.put("" + j, bean);
						j++;
					}
				}
				if (objTes2 != null && !objTes2.isEmpty() && objTes2.size() > 0) {
					for (Object[] obj : objTes2) {
						bean = new BillsBean();
						bean.setLedgerName(ledgerName);
						bean.setSubLedger(obj[3].toString());
						bean.setTxnType("PURCHASE");
						bean.setBillDate(obj[17].toString());
						bean.setBillVoucherNo(obj[10].toString());
						bean.setBillUsed("-");
						bean.setTypeOfRef("-");
						bean.setActualBillAmount("0.0");
						bean.setBillAmount(obj[9].toString());
						map.put("" + j, bean);
						j++;
					}
				}
				if (objTes3 != null && !objTes3.isEmpty() && objTes3.size() > 0) {
					for (Object[] obj : objTes3) {
						bean = new BillsBean();
						bean.setLedgerName(ledgerName);
						bean.setSubLedger("-");
						bean.setTxnType("RECEIPT");
						bean.setBillDate(obj[13].toString());
						bean.setBillVoucherNo(obj[12].toString());
						bean.setBillUsed("-");
						bean.setActualBillAmount("0.0");
						bean.setTypeOfRef("-");
						bean.setBillAmount(obj[5].toString().split(",")[0]);
						map.put("" + j, bean);
						j++;
					}
				}
				if (objTes4 != null && !objTes4.isEmpty() && objTes4.size() > 0) {
					for (Object[] obj : objTes4) {
						bean = new BillsBean();
						bean.setLedgerName(ledgerName);
						bean.setSubLedger(obj[3].toString());
						bean.setTxnType("CREDIT NOTE");
						bean.setBillDate(obj[11].toString());
						bean.setBillVoucherNo(obj[10].toString());
						bean.setBillUsed("-");
						bean.setActualBillAmount("0.0");
						bean.setTypeOfRef("-");
						bean.setBillAmount(obj[9].toString());
						map.put("" + j, bean);
						j++;
					}
				}

			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteBill(String txnType, String voucherNo, String ledgerName) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sqlString = "";
			if (txnType.equalsIgnoreCase("receipt")) {

				sqlString = "SELECT * FROM st_rm_receipt_sale_bill_mapping WHERE receiptVcr='" + voucherNo + "'";
				SQLQuery query = session.createSQLQuery(sqlString);
				List<Object[]> result = query.list();
				if (result != null && result.size() > 0 && !result.isEmpty()) {

					for (Object[] obj : result) {

						String saleVcrNumber = obj[2].toString();
						String amount = obj[3].toString();
						String type = obj[4].toString();
						if (type.equalsIgnoreCase("Agst Ref")) {

							sqlString = "SELECT * FROM st_rm_bill_wise_details_sale WHERE sale_voucher_number='"
									+ saleVcrNumber + "'";
							query = session.createSQLQuery(sqlString);
							List<Object[]> saleResult = query.list();
							if (saleResult != null && saleResult.size() > 0 && !saleResult.isEmpty()) {
								for (Object[] obj1 : saleResult) {
									String billAmount = obj1[3].toString();
									int partyId = (int) obj1[2];
									Double d_billAmount = Double.valueOf(billAmount) + Double.valueOf(amount);
									billAmount = String.format("%.2f", d_billAmount);
									sqlString = "UPDATE st_rm_bill_wise_details_sale SET balance='" + billAmount
											+ "',is_used='No',purchase_used='No' WHERE sale_voucher_number='"
											+ saleVcrNumber + "'";
									query = session.createSQLQuery(sqlString);
									query.executeUpdate();

									sqlString = "SELECT * FROM st_rm_purchase_party_master_balance WHERE party_id="
											+ partyId;
									query = session.createSQLQuery(sqlString);
									List<Object[]> balanceResult = query.list();

									if (balanceResult != null && balanceResult.size() > 0 && !balanceResult.isEmpty()) {
										for (Object[] obj2 : balanceResult) {
											String balanceType = obj2[3].toString();
											String currBal = obj2[2].toString();
											if (balanceType.equalsIgnoreCase("Dr")) {

												Double d_currBal = Double.valueOf(currBal) + Double.valueOf(amount);
												currBal = String.format("%.2f", d_currBal);
												sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='"
														+ currBal + "' WHERE party_id=" + partyId;
												query = session.createSQLQuery(sqlString);
												query.executeUpdate();
											} else {
												Double d_currBal = Double.valueOf(currBal) - Double.valueOf(amount);
												String balType = "Cr";
												if (d_currBal < 0) {
													d_currBal = d_currBal * (-1);
													balType = "Dr";
												}
												currBal = String.format("%.2f", d_currBal);
												sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='"
														+ currBal + "',balance_type='" + balType + "' WHERE party_id="
														+ partyId;
												query = session.createSQLQuery(sqlString);
												query.executeUpdate();

											}
										}

									}
								}

							}
							// this else condition if bill not found or deleted when sale delete operation
							// happened
							else {
								String tor = "On Account";
								int partyId = getLedgerIdByName(ledgerName);
								String BType = "Cr";
								String isUsed = "No";
								LocalDate date = LocalDate.now();
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
								String currentDate = date.format(formatter);
								Long time = System.currentTimeMillis();
								sqlString = "INSERT INTO st_rm_bill_wise_details_sale(`type_of_ref`,`party_id`,`balance`,`is_used`,`date`,`blnc_type`,`purchase_used`,`sale_voucher_number`) values('"
										+ tor + "'," + partyId + ",'" + amount + "','" + isUsed + "','" + currentDate
										+ "','" + BType + "','" + isUsed + "','" + time + "')";
								query = session.createSQLQuery(sqlString);
								query.executeUpdate();

								sqlString = "SELECT * FROM st_rm_purchase_party_master_balance WHERE party_id="
										+ partyId;
								query = session.createSQLQuery(sqlString);
								List<Object[]> balanceResult = query.list();

								if (balanceResult != null && balanceResult.size() > 0 && !balanceResult.isEmpty()) {
									for (Object[] obj2 : balanceResult) {
										String balanceType = obj2[3].toString();
										String currBal = obj2[2].toString();
										if (balanceType.equalsIgnoreCase("Dr")) {

											Double d_currBal = Double.valueOf(currBal) + Double.valueOf(amount);
											currBal = String.format("%.2f", d_currBal);
											sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='"
													+ currBal + "' WHERE party_id=" + partyId;
											query = session.createSQLQuery(sqlString);
											query.executeUpdate();
										} else {
											Double d_currBal = Double.valueOf(currBal) - Double.valueOf(amount);
											String balType = "Cr";
											if (d_currBal < 0) {
												d_currBal = d_currBal * (-1);
												balType = "Dr";
											}
											currBal = String.format("%.2f", d_currBal);
											sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='"
													+ currBal + "',balance_type='" + balType + "' WHERE party_id="
													+ partyId;
											query = session.createSQLQuery(sqlString);
											query.executeUpdate();

										}
									}

								}

							}

						}

						else {

							sqlString = "delete from st_rm_bill_wise_details_sale where type_of_ref='" + type
									+ "' and sale_voucher_number='" + saleVcrNumber + "'";
							query = session.createSQLQuery(sqlString);
							query.executeUpdate();
							int partyId = getLedgerIdByName(ledgerName);
							sqlString = "SELECT * FROM st_rm_purchase_party_master_balance WHERE party_id=" + partyId;
							query = session.createSQLQuery(sqlString);
							List<Object[]> balanceResult = query.list();

							if (balanceResult != null && balanceResult.size() > 0 && !balanceResult.isEmpty()) {
								for (Object[] obj2 : balanceResult) {
									String balanceType = obj2[3].toString();
									String currBal = obj2[2].toString();
									if (balanceType.equalsIgnoreCase("Dr")) {

										Double d_currBal = Double.valueOf(currBal) + Double.valueOf(amount);
										currBal = String.format("%.2f", d_currBal);
										sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + currBal
												+ "' WHERE party_id=" + partyId;
										query = session.createSQLQuery(sqlString);
										query.executeUpdate();
									} else {
										Double d_currBal = Double.valueOf(currBal) - Double.valueOf(amount);
										String balType = "Cr";
										if (d_currBal < 0) {
											d_currBal = d_currBal * (-1);
											balType = "Dr";
										}
										currBal = String.format("%.2f", d_currBal);
										sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + currBal
												+ "',balance_type='" + balType + "' WHERE party_id=" + partyId;
										query = session.createSQLQuery(sqlString);
										query.executeUpdate();

									}
								}

							}

						}
					}
				}

				sqlString = "SELECT * from st_rm_txn_receipt_master WHERE voucher_numbering='" + voucherNo + "'";
				query = session.createSQLQuery(sqlString);
				List<Object[]> rcptResult = query.list();
				if (rcptResult != null && rcptResult.size() > 0) {

					for (Object[] o : rcptResult) {

						String bankName = o[1].toString();
						String amt = o[11].toString();
						int bankLedId = getLedgerIdByName(bankName);
						sqlString = "SELECT * FROM st_rm_purchase_party_master_balance WHERE party_id=" + bankLedId;
						query = session.createSQLQuery(sqlString);
						List<Object[]> balanceResult = query.list();

						if (balanceResult != null && balanceResult.size() > 0 && !balanceResult.isEmpty()) {
							for (Object[] obj2 : balanceResult) {
								String balanceType = obj2[3].toString();
								String currBal = obj2[2].toString();
								if (balanceType.equalsIgnoreCase("Cr")) {

									Double d_currBal = Double.valueOf(currBal) + Double.valueOf(amt);
									currBal = String.format("%.2f", d_currBal);
									sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + currBal
											+ "' WHERE party_id=" + bankLedId;
									query = session.createSQLQuery(sqlString);
									query.executeUpdate();
								} else {
									Double d_currBal = Double.valueOf(currBal) - Double.valueOf(amt);
									String balType = "Dr";
									if (d_currBal < 0) {
										d_currBal = d_currBal * (-1);
										balType = "Cr";
									}
									currBal = String.format("%.2f", d_currBal);
									sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + currBal
											+ "',balance_type='" + balType + "' WHERE party_id=" + bankLedId;
									query = session.createSQLQuery(sqlString);
									query.executeUpdate();

								}
							}

						}

					}
				}
				sqlString = "DELETE FROM st_rm_receipt_sale_bill_mapping WHERE receiptVcr='" + voucherNo + "'";
				query = session.createSQLQuery(sqlString);
				query.executeUpdate();

				sqlString = "DELETE FROM st_rm_txn_receipt_master WHERE voucher_numbering='" + voucherNo + "'";
				query = session.createSQLQuery(sqlString);
				query.executeUpdate();

			} else if (txnType.equalsIgnoreCase("sales")) {

				sqlString = "SELECT * FROM st_rm_txn_sales_master WHERE voucher_numbering='" + voucherNo + "'";
				SQLQuery query = session.createSQLQuery(sqlString);
				List<Object[]> result = query.list();
				if (result != null && !result.isEmpty() && result.size() > 0) {
					for (Object[] obj : result) {
						int partyId = getLedgerIdByName(obj[1].toString());
						String[] itemArr = obj[4].toString().split(",");
						String[] qtyArr = obj[5].toString().split(",");
						String totalAmt = obj[9].toString();
						String[] godownArr = obj[27].toString().split(",");
						String[] batchArr = obj[28].toString().split(",");
						for (int i = 0; i < itemArr.length; i++) {
							if (itemArr[i].trim().equals("-1"))
								continue;
							sqlString = "SELECT st_it_id from st_rm_stock_item_master WHERE item_name='"
									+ itemArr[i].trim() + "'";
							query = session.createSQLQuery(sqlString);
							List<Integer> itemIdObj = query.list();
							Integer itemId = itemIdObj.get(0);
							sqlString = "SELECT gd_id FROM st_rm_Godown_master WHERE name='" + godownArr[i].trim()
									+ "'";
							query = session.createSQLQuery(sqlString);
							List<Integer> godownIdObj = query.list();
							Integer godownId = godownIdObj.get(0);
							String suffix = "";
							if (batchArr[i] != null && !batchArr[i].toString().trim().equals("0")
									&& !batchArr[i].toString().trim().equals("-1"))
								suffix = " and batch='" + batchArr[i].toString().trim() + "'";
							sqlString = "SELECT availableQty FROM st_rm_item_qty_godown WHERE godown_id=" + godownId
									+ " and item_id=" + itemId + "" + suffix;
							query = session.createSQLQuery(sqlString);
							List<String> QtyRes = query.list();
							String availableQty = QtyRes.get(0);
							Double finalAvailableQty = 0.0;
							if (Double.valueOf(availableQty) < 0) {
								finalAvailableQty = Double.valueOf(availableQty) - Double.valueOf(qtyArr[i].trim());
							} else
								finalAvailableQty = Double.valueOf(availableQty) + Double.valueOf(qtyArr[i].trim());

							sqlString = "UPDATE st_rm_item_qty_godown SET availableQty='" + finalAvailableQty
									+ "' WHERE godown_id=" + godownId + " and item_id=" + itemId + "" + suffix;
							query = session.createSQLQuery(sqlString);
							query.executeUpdate();
						}

						sqlString = "SELECT balance,balance_type from st_rm_purchase_party_master_balance WHERE party_id="
								+ partyId;
						query = session.createSQLQuery(sqlString);
						List<Object[]> objRes = query.list();
						if (objRes != null && !objRes.isEmpty() && objRes.size() > 0) {
							for (Object[] obj1 : objRes) {
								String balance = obj1[0].toString().trim();
								String balanceType = obj1[1].toString().trim();
								Double finalBal = 0.0;
								if (balanceType.equals("Cr")) {
									finalBal = Double.valueOf(balance) + Double.valueOf(totalAmt);
								} else {

									finalBal = Double.valueOf(balance) - Double.valueOf(totalAmt);
									if (finalBal < 0) {
										finalBal = finalBal * (-1);
										balanceType = "Cr";
									}

								}
								sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + finalBal
										+ "',balance_type='" + balanceType + "' where party_id=" + partyId;
								query = session.createSQLQuery(sqlString);
								query.executeUpdate();
							}
						}
						sqlString = "DELETE FROM st_rm_bill_wise_details_sale WHERE sale_voucher_number='" + voucherNo
								+ "'";
						query = session.createSQLQuery(sqlString);
						query.executeUpdate();

						sqlString = "DELETE FROM st_rm_txn_sales_master WHERE voucher_numbering='" + voucherNo + "'";
						query = session.createSQLQuery(sqlString);
						query.executeUpdate();

						sqlString = "DELETE FROM st_rm_party_txn_curr_balance_master WHERE voucher_id='" + voucherNo
								+ "'";
						query = session.createSQLQuery(sqlString);
						query.executeUpdate();

					}
				}

			} else if (txnType.equalsIgnoreCase("purchase")) {

				sqlString = "SELECT * FROM st_rm_txn_purchase_master WHERE voucher_numbering='" + voucherNo + "'";
				SQLQuery query = session.createSQLQuery(sqlString);
				List<Object[]> result = query.list();
				if (result != null && !result.isEmpty() && result.size() > 0) {
					for (Object[] obj : result) {
						int partyId = getLedgerIdByName(obj[1].toString());
						String[] itemArr = obj[4].toString().split(",");
						String[] qtyArr = obj[5].toString().split(",");
						String totalAmt = obj[9].toString();
						String[] godownArr = obj[25].toString().split(",");
						String[] batchArr = obj[26].toString().split(",");
						for (int i = 0; i < itemArr.length; i++) {
							if (itemArr[i].trim().equals("-1"))
								continue;
							sqlString = "SELECT st_it_id from st_rm_stock_item_master WHERE item_name='"
									+ itemArr[i].trim() + "'";
							query = session.createSQLQuery(sqlString);
							List<Integer> itemIdObj = query.list();
							Integer itemId = itemIdObj.get(0);
							sqlString = "SELECT gd_id FROM st_rm_Godown_master WHERE name='" + godownArr[i].trim()
									+ "'";
							query = session.createSQLQuery(sqlString);
							List<Integer> godownIdObj = query.list();
							Integer godownId = godownIdObj.get(0);
							String suffix = "";
							if (batchArr[i] != null && !batchArr[i].toString().trim().equals("0")
									&& !batchArr[i].toString().trim().equals("-1"))
								suffix = " and batch='" + batchArr[i].toString().trim() + "'";
							sqlString = "SELECT availableQty FROM st_rm_item_qty_godown WHERE godown_id=" + godownId
									+ " and item_id=" + itemId + "" + suffix;
							query = session.createSQLQuery(sqlString);
							List<String> QtyRes = query.list();
							String availableQty = QtyRes.get(0);
							Double finalAvailableQty = 0.0;
							if (Double.valueOf(availableQty) < 0) {
								finalAvailableQty = Double.valueOf(availableQty) + Double.valueOf(qtyArr[i].trim());
							} else
								finalAvailableQty = Double.valueOf(availableQty) - Double.valueOf(qtyArr[i].trim());

							sqlString = "UPDATE st_rm_item_qty_godown SET availableQty='" + finalAvailableQty
									+ "' WHERE godown_id=" + godownId + " and item_id=" + itemId + "" + suffix;
							query = session.createSQLQuery(sqlString);
							query.executeUpdate();
						}

						sqlString = "SELECT balance,balance_type from st_rm_purchase_party_master_balance WHERE party_id="
								+ partyId;
						query = session.createSQLQuery(sqlString);
						List<Object[]> objRes = query.list();
						if (objRes != null && !objRes.isEmpty() && objRes.size() > 0) {
							for (Object[] obj1 : objRes) {
								String balance = obj1[0].toString().trim();
								String balanceType = obj1[1].toString().trim();
								Double finalBal = 0.0;
								if (balanceType.equals("Cr")) {
									finalBal = Double.valueOf(balance) - Double.valueOf(totalAmt);
									if (finalBal < 0) {
										finalBal = finalBal * (-1);
										balanceType = "Dr";
									}
								} else {

									finalBal = Double.valueOf(balance) + Double.valueOf(totalAmt);

								}
								sqlString = "UPDATE st_rm_purchase_party_master_balance SET balance='" + finalBal
										+ "',balance_type='" + balanceType + "' where party_id=" + partyId;
								query = session.createSQLQuery(sqlString);
								query.executeUpdate();
							}
						}
						sqlString = "DELETE FROM st_rm_bill_wise_details WHERE purchase_voucher_number='" + voucherNo
								+ "'";
						query = session.createSQLQuery(sqlString);
						query.executeUpdate();

						sqlString = "DELETE FROM st_rm_txn_purchase_master WHERE voucher_numbering='" + voucherNo + "'";
						query = session.createSQLQuery(sqlString);
						query.executeUpdate();

						sqlString = "DELETE FROM st_rm_party_txn_curr_balance_master WHERE voucher_id='" + voucherNo
								+ "'";
						query = session.createSQLQuery(sqlString);
						query.executeUpdate();

					}
				}

			} else if (txnType.equalsIgnoreCase("journal")) {

				sqlString = "SELECT * FROM st_rm_txn_journal_master WHERE voucher_numbering='" + voucherNo + "'";
				SQLQuery query = session.createSQLQuery(sqlString);
				List<Object[]> result = query.list();
				if (result != null && result.size() > 0) {
					for (Object[] obj : result) {
						String[] DrCRSplit = obj[2].toString().split(",");
						String[] ledgerSplit = obj[3].toString().split(",");
						String[] debitAmtSplit = obj[4].toString().split(",");
						String[] creditAmtSplit = obj[5].toString().split(",");

						int drLedgerId = getLedgerIdByName(ledgerSplit[0].trim());
						int crLedgerId = getLedgerIdByName(ledgerSplit[1].trim());

						adjustPartyAmount(drLedgerId, Double.valueOf(debitAmtSplit[0].trim()), "Cr");
						adjustPartyAmount(crLedgerId, Double.valueOf(creditAmtSplit[1].trim()), "Dr");

						query = session.createSQLQuery(
								"DELETE FROM st_rm_txn_journal_master WHERE voucher_numbering='" + voucherNo + "'");
						query.executeUpdate();

						query = session.createSQLQuery(
								"DELETE FROM st_rm_journal_bill_mapping WHERE jouVcr='" + voucherNo + "'");
						query.executeUpdate();

						query = session.createSQLQuery(
								"DELETE FROM st_rm_party_txn_curr_balance_master WHERE voucher_id='" + voucherNo + "'");
						query.executeUpdate();

					}

				}

			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	private void adjustPartyAmount(int partyId, Double balance, String balanceType) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("select * from st_rm_purchase_party_master_balance where party_id=" + partyId);
			List<Object[]> result = query.list();
			Double bal = 0.0;
			String balType = "";

			if (result != null && !result.isEmpty()) {
				for (Object[] obj : result) {

					String DBBalance = obj[2].toString().trim();
					String DBBalanceType = obj[3].toString().trim();
					if (DBBalanceType.equalsIgnoreCase("Dr") && balanceType.equalsIgnoreCase("Dr")) {
						bal = Double.valueOf(DBBalance) + Double.valueOf(balance);
						balType = "Dr";
					} else if (DBBalanceType.equalsIgnoreCase("Dr") && balanceType.equalsIgnoreCase("Cr")) {
						bal = Double.valueOf(DBBalance) - Double.valueOf(balance);
						balType = "Dr";
						if (bal < 0) {
							bal = bal * (-1);
							balType = "Cr";
						}

					} else if (DBBalanceType.equalsIgnoreCase("Cr") && balanceType.equalsIgnoreCase("Cr")) {
						bal = Double.valueOf(DBBalance) + Double.valueOf(balance);
						balType = "Cr";

					} else if (DBBalanceType.equalsIgnoreCase("Cr") && balanceType.equalsIgnoreCase("Dr")) {
						bal = Double.valueOf(DBBalance) - Double.valueOf(balance);
						balType = "Cr";
						if (bal < 0) {
							bal = bal * (-1);
							balType = "Dr";
						}

					}
					SQLQuery query2 = session.createSQLQuery("update st_rm_purchase_party_master_balance SET balance='"
							+ bal + "' AND balance_type='" + balType + "' WHERE party_id=" + partyId);
					query2.executeUpdate();
					transaction.commit();
					break;
				}
				// balance dr and adding cr -
				// balance cr and adding dr -

			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		}

	}

	public Map<String, ReceiptSaleBillMapping> getTransactionDetail(String txnType, String voucherNo) {

		try {
			Session session = HibernateSessionFactory.getSession();
			Map<String, ReceiptSaleBillMapping> map = new HashMap<>();
			ReceiptSaleBillMapping billMapping = null;
			if (txnType.equals("RECEIPT")) {

				String sqlString = "SELECT * FROM st_rm_receipt_sale_bill_mapping WHERE receiptVcr='" + voucherNo + "'";
				SQLQuery query = session.createSQLQuery(sqlString);
				List<Object[]> result = query.list();
				if (result != null && !result.isEmpty() && result.size() > 0) {
					int i = 1;
					for (Object[] obj : result) {
						billMapping = new ReceiptSaleBillMapping();
						billMapping.setReceiptVoucher(obj[1].toString());
						billMapping.setAmount(obj[3].toString());
						billMapping.setRefType(obj[4].toString());
						billMapping.setTxnType(txnType);
						billMapping.setSaleVoucher(obj[2].toString());
						billMapping.setsNo("" + i);
						map.put("" + i, billMapping);
						i++;
					}
					return map;
				}
			} else if (txnType.equals("CREDIT NOTE")) {

				String sqlString = "SELECT * FROM st_rm_sale_creditNote_bill_mapping WHERE cnVcr='" + voucherNo + "'";
				SQLQuery query = session.createSQLQuery(sqlString);
				List<Object[]> result = query.list();
				if (result != null && !result.isEmpty() && result.size() > 0) {
					int i = 1;
					for (Object[] obj : result) {
						billMapping = new ReceiptSaleBillMapping();
						billMapping.setReceiptVoucher(obj[1].toString());
						billMapping.setAmount(obj[3].toString());
						billMapping.setRefType(obj[4].toString());
						billMapping.setTxnType(txnType);
						billMapping.setSaleVoucher(obj[2].toString());
						billMapping.setsNo("" + i);
						map.put("" + i, billMapping);
						i++;
					}
					return map;
				}
			} else if (txnType.equals("JOURNAL")) {

				String sqlString = "SELECT * FROM st_rm_journal_bill_mapping WHERE jouVcr='" + voucherNo + "'";
				SQLQuery query = session.createSQLQuery(sqlString);
				List<Object[]> result = query.list();
				if (result != null && !result.isEmpty() && result.size() > 0) {
					int i = 1;
					for (Object[] obj : result) {
						billMapping = new ReceiptSaleBillMapping();
						billMapping.setReceiptVoucher(obj[1].toString());
						billMapping.setAmount(obj[3].toString());
						billMapping.setRefType(obj[4].toString());
						billMapping.setTxnType(txnType);
						billMapping.setSaleVoucher(obj[2].toString());
						billMapping.setBillTable(obj[5].toString());
						billMapping.setsNo("" + i);
						map.put("" + i, billMapping);
						i++;
					}
					return map;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteSingleBill(String txnType, String voucherNo) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sqlString = "";
			if (txnType.equalsIgnoreCase("receipt")) {
				String arr[] = voucherNo.split(",");
				String receiptVcrNo = arr[0];
				String saleVcrNo = arr[1];

			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public Map<String, ExpenseBean> getExpenseReport(Integer empId, String fromDate, String toDate) {

		try {
			Session session = HibernateSessionFactory.getSession();
			Map<String, ExpenseBean> map = new HashMap<String, ExpenseBean>();
			ExpenseBean bean = null;
			SQLQuery query = session.createSQLQuery("SELECT * FROM bo_um_emp_expenses WHERE emp_id=" + empId
					+ " and STR_TO_DATE(date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
					+ "','%d-%m-%Y') and STR_TO_DATE(date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate + "','%d-%m-%Y')");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				int i = 1;
				for (Object[] obj : result) {
					bean = new ExpenseBean();
					bean.setEmpId("" + empId);
					bean.setAmount(obj[4].toString());
					bean.setDate(obj[2].toString());
					bean.setExpenseType(obj[3].toString());
					bean.setPicturePath(obj[5].toString());
					bean.setsNo("" + i);
					map.put("" + i, bean);
					i++;
				}
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setDocumentPathCreditNote(int cnNo, String fileFullPathDD, String fileFullPathTB, int userId,
			String txnType) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "";
			if (txnType != null && txnType.equalsIgnoreCase("creditNote")) {
				sqlString = "UPDATE st_rm_txn_creditNote_master SET dispatch_doc='" + fileFullPathDD + "', billt_doc='"
						+ fileFullPathTB + "' where emp_id=" + userId + " and cnId=" + cnNo;
				SQLQuery query = session.createSQLQuery(sqlString);
				query.executeUpdate();

			} else {

				sqlString = "UPDATE st_rm_txn_creditNote_master_emp SET dispatch_doc='" + fileFullPathDD
						+ "', billt_doc='" + fileFullPathTB + "' where emp_id=" + userId + " and cnId=" + cnNo;
				SQLQuery query = session.createSQLQuery(sqlString);
				query.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean runOldOverDueBills(String ledgerName, String voucherNo) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			int partyId = getLedgerIdByName(ledgerName);

			String voucherArr[] = voucherNo.split(",");

			Date today = new Date();
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
			c.setTimeZone(tz);
			String date = df.format(today);

			int ledgerId = getLedgerIdByName(ledgerName);
			Integer by = 0;
			Integer graceP = 0;
			String retaPer = "";
			Integer totalPeriod = 0;
			Double rate = 0.0;
			SQLQuery sqlQuery = session.createSQLQuery(
					"select `by`,`grace_period`,`rate`,`rate_per` from st_rm_ledger_interset_calculation where ledger_id="
							+ ledgerId + " and is_security='No' and rate_on='Debit Balances Only'");
			List<Object[]> result = sqlQuery.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				for (Object[] o : result) {
					by = Integer.valueOf(o[0].toString());
					graceP = Integer.valueOf(o[1].toString());
					rate = Double.valueOf(o[2].toString());
					retaPer = o[3].toString();
				}

			}
			totalPeriod = by + graceP;

			for (int i = 0; i < voucherArr.length; i++) {

				String sqlString = "SELECT `date`,`balance`,`tax_amount` from st_rm_bill_wise_details_sale WHERE party_id="
						+ partyId + " and sale_voucher_number='" + voucherArr[i].trim()
						+ "' and is_used='No' and type_of_ref='Agst Ref'";
				SQLQuery query = session.createSQLQuery(sqlString);
				List<Object[]> resultSale = query.list();
				if (resultSale != null && !resultSale.isEmpty() && resultSale.size() > 0) {
					for (Object[] sale : resultSale) {

						String billDate = sale[0].toString();
						Double Balance = Double.valueOf(sale[1].toString());
						Double _interstAmt = Double.valueOf(sale[2].toString());
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
						Date _todayDate = sdf.parse(date);
						Date _Billdate = sdf.parse(billDate);
						sdf.applyPattern("yyyy-MM-dd");
						String _todayDate1 = sdf.format(_todayDate);
						String _Billdate1 = sdf.format(_Billdate);
						Double _rate = 0.0;
						LocalDateTime _dateToday = LocalDateTime.parse(_todayDate1);
						LocalDateTime _dateBill = LocalDateTime.parse(_Billdate1);

						Days days = Days.daysBetween(_dateBill, _dateToday);
						if (retaPer.equalsIgnoreCase("Calendar Month")) {
							_rate = rate * 12;
						}
						double dayPercentRateCalculate = (_rate / 365) * (double) days.getDays();

						Double interestCalc = (Balance * dayPercentRateCalculate) / 100;
						Balance = Balance + interestCalc;
						_interstAmt += interestCalc;
						sqlString = "UPDATE st_rm_bill_wise_details_sale SET balance='" + Balance + "',tax_amount='"
								+ _interstAmt + "',tax_updated_on='" + date + "' WHERE party_id=" + partyId
								+ " and sale_voucher_number='" + voucherArr[i].trim() + "'";
						SQLQuery query1 = session.createSQLQuery(sqlString);
						query1.executeUpdate();
						sqlString = "SELECT * from st_rm_purchase_party_master_balance where party_id=" + partyId;
						SQLQuery query2 = session.createSQLQuery(sqlString);
						List<Object[]> balancRes = query2.list();
						String partyBlnc = "";
						String blncTyp = "";
						if (balancRes != null && !balancRes.isEmpty() && balancRes.size() > 0) {
							for (Object[] o : balancRes) {
								partyBlnc = o[2].toString();
								blncTyp = o[3].toString();
							}

						}

						if (blncTyp.equals("Dr")) {
							String _partyBlnc = String.valueOf(Double.valueOf(partyBlnc) + interestCalc);
							SQLQuery queryCurBal = session
									.createSQLQuery("UPDATE st_rm_purchase_party_master_balance SET balance='"
											+ _partyBlnc + "' WHERE party_id=" + ledgerId);
							queryCurBal.executeUpdate();

						} else {
							Double _partyBlnc = Double.valueOf(partyBlnc) - interestCalc;
							if (_partyBlnc < 0) {
								_partyBlnc = _partyBlnc * (-1);
								blncTyp = "Dr";
							} else {
								blncTyp = "Cr";
							}
							SQLQuery queryCurBal = session.createSQLQuery(
									"UPDATE st_rm_purchase_party_master_balance SET balance='" + _partyBlnc
											+ "',balance_type='" + blncTyp + "' WHERE party_id=" + ledgerId);
							queryCurBal.executeUpdate();
						}

						SQLQuery queryLast = session.createSQLQuery(
								"INSERT INTO temp_old_bill_bulk_schedule_master(`voucher_number`) values('"
										+ voucherArr[i].trim() + "')");
						queryLast.executeUpdate();

					}

				}

			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Map<String, LedgerReportBean> loadLedgerReportResult(String ledgerName, String fromDate, String toDate) {
		Map<String, LedgerReportBean> map = new HashMap<String, LedgerReportBean>();

		try {
			Session session = HibernateSessionFactory.getSession();
			LedgerReportBean ledgerReportBean = null;
			int count = 1;
			String sqlString = "SELECT * FROM st_rm_txn_sales_master WHERE party_acc_name='" + ledgerName
					+ "' and STR_TO_DATE(saleDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
					+ "','%d-%m-%Y') and STR_TO_DATE(saleDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate + "','%d-%m-%Y')";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> saleResult = query.list();
			if (saleResult != null && !saleResult.isEmpty() && saleResult.size() > 0) {

				for (Object[] obj : saleResult) {
					ledgerReportBean = new LedgerReportBean();
					ledgerReportBean.setId(count);
					String date[] = obj[17].toString().split("-");
					String fdate = date[2] + "/" + date[1] + "/" + date[0];
					ledgerReportBean.setDate(fdate);
					sqlString = "SELECT superCashBill from st_rm_bill_wise_details_sale WHERE sale_voucher_number='"
							+ obj[10].toString() + "'";
					List<String> isSuperCashResult = session.createSQLQuery(sqlString).list();
					if (isSuperCashResult.get(0).equalsIgnoreCase("yes"))
						ledgerReportBean.setSubLedger(obj[3].toString() + " (supercash)");
					else
						ledgerReportBean.setSubLedger(obj[3].toString());
					ledgerReportBean.setTxnType("SALE");
					ledgerReportBean.setVoucherNumber(obj[10].toString());
					ledgerReportBean.setCredit("");
					ledgerReportBean.setDebit(obj[9].toString());
					map.put("" + count, ledgerReportBean);
					count++;
				}
			}
			sqlString = "SELECT * FROM st_rm_txn_purchase_master WHERE party_acc_name='" + ledgerName
					+ "' and STR_TO_DATE(purchaseDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
					+ "','%d-%m-%Y') and STR_TO_DATE(purchaseDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
					+ "','%d-%m-%Y')";
			query = session.createSQLQuery(sqlString);
			List<Object[]> purchaseResult = query.list();
			if (purchaseResult != null && !purchaseResult.isEmpty() && purchaseResult.size() > 0) {

				for (Object[] obj : purchaseResult) {
					ledgerReportBean = new LedgerReportBean();
					ledgerReportBean.setId(count);
					String date[] = obj[17].toString().split("-");
					String fdate = date[2] + "/" + date[1] + "/" + date[0];
					ledgerReportBean.setDate(fdate);
					ledgerReportBean.setSubLedger(obj[3].toString());
					ledgerReportBean.setTxnType("PURCHASE");
					ledgerReportBean.setVoucherNumber(obj[10].toString());
					ledgerReportBean.setCredit(obj[9].toString());
					ledgerReportBean.setDebit("");
					map.put("" + count, ledgerReportBean);
					count++;
				}
			}
			sqlString = "SELECT * FROM st_rm_txn_creditNote_master WHERE party_acc_name='" + ledgerName
					+ "' and STR_TO_DATE(cn_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
					+ "','%d-%m-%Y') and STR_TO_DATE(cn_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate + "','%d-%m-%Y')";
			query = session.createSQLQuery(sqlString);
			List<Object[]> creditNoteResult = query.list();
			if (creditNoteResult != null && !creditNoteResult.isEmpty() && creditNoteResult.size() > 0) {

				for (Object[] obj : creditNoteResult) {
					ledgerReportBean = new LedgerReportBean();
					ledgerReportBean.setId(count);
					String date[] = obj[11].toString().split("-");
					String fdate = date[2] + "/" + date[1] + "/" + date[0];
					ledgerReportBean.setDate(fdate);
					ledgerReportBean.setSubLedger(obj[3].toString());
					ledgerReportBean.setTxnType("Credit Note");
					ledgerReportBean.setVoucherNumber(obj[10].toString());
					ledgerReportBean.setCredit(obj[9].toString());
					ledgerReportBean.setDebit("");
					map.put("" + count, ledgerReportBean);
					count++;
				}
			}
			sqlString = "SELECT * FROM st_rm_txn_debitNote_master WHERE party_acc_name='" + ledgerName
					+ "' and STR_TO_DATE(dn_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
					+ "','%d-%m-%Y') and STR_TO_DATE(dn_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate + "','%d-%m-%Y')";
			query = session.createSQLQuery(sqlString);
			List<Object[]> debitNoteResult = query.list();
			if (debitNoteResult != null && !debitNoteResult.isEmpty() && debitNoteResult.size() > 0) {

				for (Object[] obj : debitNoteResult) {
					ledgerReportBean = new LedgerReportBean();
					ledgerReportBean.setId(count);
					String date[] = obj[11].toString().split("-");
					String fdate = date[2] + "/" + date[1] + "/" + date[0];
					ledgerReportBean.setDate(fdate);
					ledgerReportBean.setSubLedger(obj[3].toString());
					ledgerReportBean.setTxnType("Debit Note");
					ledgerReportBean.setVoucherNumber(obj[10].toString());
					ledgerReportBean.setCredit("");
					ledgerReportBean.setDebit(obj[9].toString());
					map.put("" + count, ledgerReportBean);
					count++;
				}
			}
			sqlString = "SELECT * FROM st_rm_txn_receipt_master WHERE Particulars like '%" + ledgerName
					+ "%' and STR_TO_DATE(receipt_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
					+ "','%d-%m-%Y') and STR_TO_DATE(receipt_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
					+ "','%d-%m-%Y')";
			query = session.createSQLQuery(sqlString);
			List<Object[]> receiptResult = query.list();
			if (receiptResult != null && !receiptResult.isEmpty() && receiptResult.size() > 0) {

				for (Object[] obj : receiptResult) {
					ledgerReportBean = new LedgerReportBean();
					ledgerReportBean.setId(count);
					String date[] = obj[13].toString().split("-");
					String fdate = date[2] + "/" + date[1] + "/" + date[0];
					ledgerReportBean.setDate(fdate);
					ledgerReportBean.setSubLedger(obj[1].toString());
					ledgerReportBean.setTxnType("Receipt");
					ledgerReportBean.setVoucherNumber(obj[12].toString());
					ledgerReportBean.setCredit(obj[11].toString());
					ledgerReportBean.setDebit("");
					map.put("" + count, ledgerReportBean);
					count++;
				}
			}
			sqlString = "SELECT * FROM st_rm_txn_payment_master WHERE Particulars like '%" + ledgerName
					+ "%' and STR_TO_DATE(paymentDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
					+ "','%d-%m-%Y') and STR_TO_DATE(paymentDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
					+ "','%d-%m-%Y')";
			query = session.createSQLQuery(sqlString);
			List<Object[]> paymentResult = query.list();
			if (paymentResult != null && !paymentResult.isEmpty() && paymentResult.size() > 0) {

				for (Object[] obj : paymentResult) {
					ledgerReportBean = new LedgerReportBean();
					ledgerReportBean.setId(count);
					String date[] = obj[12].toString().split("-");
					String fdate = date[2] + "/" + date[1] + "/" + date[0];
					ledgerReportBean.setDate(fdate);
					ledgerReportBean.setSubLedger(obj[1].toString());
					ledgerReportBean.setTxnType("Payment");
					ledgerReportBean.setVoucherNumber(obj[10].toString());
					ledgerReportBean.setCredit("");
					ledgerReportBean.setDebit(obj[9].toString());
					map.put("" + count, ledgerReportBean);
					count++;
				}
			}
			sqlString = "SELECT * FROM st_rm_txn_journal_master WHERE STR_TO_DATE(journal_date,'%d-%m-%Y') >= STR_TO_DATE('"
					+ fromDate + "','%d-%m-%Y') and STR_TO_DATE(journal_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
					+ "','%d-%m-%Y')";
			query = session.createSQLQuery(sqlString);
			List<Object[]> journalResult = query.list();
			if (journalResult != null && !journalResult.isEmpty() && journalResult.size() > 0) {

				for (Object[] obj : journalResult) {

					String subLedArr[] = obj[3].toString().split(",");
					String drCr[] = obj[2].toString().split(",");
					String debAmt[] = obj[4].toString().split(",");
					String credAmt[] = obj[5].toString().split(",");
					for (int i = 0; i < subLedArr.length; i++) {
						String ledger = subLedArr[i].trim();
						String drcr = drCr[i].trim();
						if (ledgerName.equals(ledger) && drcr.equalsIgnoreCase("Cr")) {
							ledgerReportBean = new LedgerReportBean();
							ledgerReportBean.setId(count);
							String date[] = obj[8].toString().split("-");
							String fdate = date[2] + "/" + date[1] + "/" + date[0];

							ledgerReportBean.setDate(fdate);
							ledgerReportBean.setSubLedger(subLedArr[0]);
							ledgerReportBean.setTxnType("Journal");
							ledgerReportBean.setVoucherNumber(obj[7].toString());
							ledgerReportBean.setCredit(credAmt[i].trim());
							ledgerReportBean.setDebit("");
							map.put("" + count, ledgerReportBean);
							count++;

						} else if (ledgerName.equals(ledger) && drcr.equalsIgnoreCase("Dr")) {
							ledgerReportBean = new LedgerReportBean();
							ledgerReportBean.setId(count);
							String date[] = obj[8].toString().split("-");
							String fdate = date[2] + "/" + date[1] + "/" + date[0];
							ledgerReportBean.setDate(fdate);
							ledgerReportBean.setSubLedger(subLedArr[1]);
							ledgerReportBean.setTxnType("Journal");
							ledgerReportBean.setVoucherNumber(obj[7].toString());
							ledgerReportBean.setCredit("");
							ledgerReportBean.setDebit(debAmt[i].trim());
							map.put("" + count, ledgerReportBean);
							count++;

						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, BillsBean> loadcreditDaysReminderReportResult(String ledgerName, String empName, String fromDate,
			String toDate) {

		try {
			Map<String, BillsBean> map = new HashMap<String, BillsBean>();
			BillsBean bean = null;
			int count = 1;
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
			c.setTimeZone(tz);
			String date = sdf.format(today);
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "";
			SQLQuery query = null;

			sqlString = "SELECT a.balance,a.date,a.sale_voucher_number,a.party_id,a.blnc_type,b.emp_id FROM st_rm_bill_wise_details_sale AS a INNER JOIN `st_rm_txn_sales_master`  AS b ON a.sale_voucher_number = b.voucher_numbering WHERE a.type_of_ref='Agst Ref' and a.is_used='No' ";
			if (ledgerName != null && !ledgerName.isEmpty() && !ledgerName.equals("-1")) {
				int partyId = getLedgerIdByName(ledgerName);
				sqlString += " and a.party_id=" + partyId + " ";
			}
			if (empName != null && !empName.isEmpty() && !empName.equals("-1")) {
				int empId = getEmployeeId(empName);
				sqlString += " and b.emp_id=" + empId + " ";
			}
			if (fromDate != null && !fromDate.isEmpty()) {

				sqlString += " and STR_TO_DATE(a.date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate + "','%d-%m-%Y') ";

			}
			if (toDate != null && !toDate.isEmpty()) {

				sqlString += " and STR_TO_DATE(a.date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate + "','%d-%m-%Y') ";

			}

			query = session.createSQLQuery(sqlString);
			List<Object[]> saleBillsList = query.list();
			if (saleBillsList != null && !saleBillsList.isEmpty() && saleBillsList.size() > 0) {

				for (Object[] obj : saleBillsList) {
					int creditPeriod = 0;
					sqlString = "SELECT credit_period FROM st_rm_credit_limit WHERE ledger_id=" + (int) obj[3];
					query = session.createSQLQuery(sqlString);
					List<Integer> creditPeriodList = query.list();
					if (creditPeriodList != null && !creditPeriodList.isEmpty() && creditPeriodList.size() > 0
							&& !creditPeriodList.get(0).equals("-1"))
						creditPeriod = creditPeriodList.get(0);

					bean = new BillsBean();
					c.setTime(sdf.parse(obj[1].toString()));
					c.add(Calendar.DAY_OF_MONTH, creditPeriod);
					bean.setBillDate(obj[1].toString());
					bean.setBillDueDate(sdf.format(c.getTime()));
					bean.setLedgerName(getPartyNameById((int) obj[3]));
					bean.setBillVoucherNo(obj[2].toString());
					bean.setEmpName(empName);
					bean.setBillAmount(obj[0].toString() + " " + obj[4].toString());

					SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
					Date _todayDate = df.parse(date);
					Date _Billdate = df.parse(obj[1].toString());
					df.applyPattern("yyyy-MM-dd");
					String _todayDate1 = df.format(_todayDate);
					String _Billdate1 = df.format(_Billdate);
					LocalDateTime _dateToday = LocalDateTime.parse(_todayDate1);
					LocalDateTime _dateBill = LocalDateTime.parse(_Billdate1);
					Days days = Days.daysBetween(_dateBill, _dateToday);
					bean.setDueDays("" + days.getDays());
					count++;
					map.put("" + count, bean);
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getPartyNameById(int i) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT ledger_name FROM st_rm_acc_ledger_master WHERE ledger_id=" + i);
			List<String> name = query.list();
			return name.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getOpeningBal(String ledgerName, String fromDate) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int ledgerId = getLedgerIdByName(ledgerName);
			SQLQuery query = session.createSQLQuery(
					"SELECT party_balance_bef_txn FROM st_rm_party_txn_curr_balance_master WHERE id = (SELECT MIN(id) FROM st_rm_party_txn_curr_balance_master WHERE `date`='"
							+ fromDate + "' and party_id=" + ledgerId + ")");
			List<String> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0 Dr";
	}

	public String getPartyTaxAmount(String ledgerName, String fromDate, String toDate) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int partyId = getLedgerIdByName(ledgerName);
			SQLQuery query = session
					.createSQLQuery("SELECT SUM(tax_amount) FROM st_rm_bill_wise_details_sale WHERE party_id=" + partyId
							+ " AND type_of_ref='Agst Ref' AND STR_TO_DATE(`date`,'%d-%m-%Y') >= STR_TO_DATE('"
							+ fromDate + "','%d-%m-%Y') AND  STR_TO_DATE(`date`,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
							+ "','%d-%m-%Y')");
			List<Double> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0 && result.get(0) != null) {
				return String.valueOf(result.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "0";
	}

	public String getOldSetReminder(String partyId, String vcrId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT * FROM st_rm_bill_due_alert_scheduling_mgmt WHERE ledger_id=" + partyId
							+ " and voucher_no='" + vcrId + "' ");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				for (Object[] obj : result) {
					return (int) obj[4] + ";" + (int) obj[5] + ";" + (int) obj[6];
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0;0;0";
	}

	public void calculateAddInterestAmtOnCurrentBalance() {

		try {
			Logger logger = Logger.getLogger(GameLobbyController.class.getName());
			logger.info("::::::::::::SCHEDULING START OF TAX REPORT:::::::::::::::::::::::::");
			Session session = HibernateSessionFactory.getSession();
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date.format(formatter);
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM st_rm_ledger_interset_calculation WHERE rate_on IN('Debit Balances Only')");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				for (Object[] obj : result) {
					String IstxnByTxn = obj[2].toString();
					String alwaysOrPastDueDate = obj[9].toString();
					String calculateFrom = obj[12].toString();
					if (IstxnByTxn.equalsIgnoreCase("yes")) {
						logger.info("::::::::::::INSIDE BILL WISE :::::::::::::::::::::::::");
						String rateMonthOrYear = obj[7].toString();
						if (rateMonthOrYear.equalsIgnoreCase("Calendar Month")) {
							logger.info("::::::::::::INSIDE CALENDAR MONTH:::::::::::::::::::::::::");
							String dueLimit = !obj[10].toString().isEmpty() ? obj[10].toString() : "0";
							String gracePeriod = !obj[11].toString().isEmpty() ? obj[11].toString() : "0";
							Integer totalDays = Integer.valueOf(dueLimit) + Integer.valueOf(gracePeriod);
							if (alwaysOrPastDueDate.equalsIgnoreCase("Always"))
								totalDays = 0;
							Integer ledgerId = (int) obj[1];

							SQLQuery query1 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details_sale WHERE type_of_ref IN('Agst Ref') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> saleBillsresult = query1.list();
							if (saleBillsresult != null && !saleBillsresult.isEmpty() && saleBillsresult.size() > 0) {

								for (Object[] saleObj : saleBillsresult) {
									if (isInterestAllow(ledgerId))
										continue;
									String saleBillDate = saleObj[5].toString();
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);
									c.setTime(sdf.parse(saleBillDate));
									c.add(Calendar.DAY_OF_MONTH, totalDays);
									String datePeriod = sdf.format(c.getTime());

									if (compareTwoDate(datePeriod + " 00:00", currentDate + " 00:00")) {

										Double taxRate = Double.valueOf(obj[6].toString());
										int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
										logger.info("------------------->DAYS IN MONTH IS :" + monthMaxDays);
										double dayPercentRateCalculate = (taxRate / 365) * (double) monthMaxDays;

										Double saleBillAmount = Double.valueOf(saleObj[3].toString());
										Double repsaleBillAmount = saleBillAmount;
										Double billTax = (saleBillAmount * dayPercentRateCalculate) / 100;
										saleBillAmount = saleBillAmount + billTax;
										int saleBillId = (int) saleObj[0];
										logger.info("::::::::::::SALE BILL :::::::::::::::::::::::::" + saleBillId);
										String saleTaxAmountOld = saleObj[9].toString();
										Double saleTaxAmountNew = Double.valueOf(saleTaxAmountOld) + billTax;

										SQLQuery updateBillQuery = session.createSQLQuery(
												"UPDATE st_rm_bill_wise_details_sale SET balance='" + saleBillAmount
														+ "',tax_amount='" + saleTaxAmountNew + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + saleBillId);
										updateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + saleBillId + ",'" + saleObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ repsaleBillAmount + "','" + billTax + "','" + saleBillAmount
														+ "','" + partyBlnc + "','" + blncTyp + "','Sale')");
										Schquery.executeUpdate();
										// sale tax billing end

										logger.info(
												"::::::::::::SALE BILL WISE TAX SCHEDULING SUCCESS:::::::::::::::::::::::::");
									}
								}
							}

							// purchase tax billing start
							logger.info(
									"::::::::::::SCHEDULING START OF TAX REPORT PURCHASING:::::::::::::::::::::::::");
							SQLQuery query2 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details WHERE type_of_ref IN('Agst Ref') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> purchaseBillsresult = query2.list();
							if (purchaseBillsresult != null && !purchaseBillsresult.isEmpty()
									&& purchaseBillsresult.size() > 0) {

								for (Object[] purchaseObj : purchaseBillsresult) {
									String purchaseBillDate = purchaseObj[5].toString();
									if (isInterestAllow(ledgerId))
										continue;
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);
									c.setTime(sdf.parse(purchaseBillDate));
									c.add(Calendar.DAY_OF_MONTH, totalDays);
									String purchasedatePeriod = sdf.format(c.getTime());
									if (compareTwoDate(purchasedatePeriod + " 00:00", currentDate + " 00:00")) {

										Double PtaxRate = Double.valueOf(obj[6].toString());
										Calendar Pc = Calendar.getInstance();
										int PmonthMaxDays = Pc.getActualMaximum(Calendar.DAY_OF_MONTH);
										double PdayPercentRateCalculate = (PtaxRate / 365) * (double) PmonthMaxDays;

										Double purchaseBillAmount = Double.valueOf(purchaseObj[3].toString());
										Double reppurchaseBillAmount = purchaseBillAmount;
										Double purchasebillTax = (purchaseBillAmount * PdayPercentRateCalculate) / 100;
										purchaseBillAmount = purchaseBillAmount + purchasebillTax;
										int purchaseBillId = (int) purchaseObj[0];
										logger.info(
												"::::::::::::PURCHASE BILL :::::::::::::::::::::::::" + purchaseBillId);
										String purchaseTaxAmountOld = purchaseObj[9].toString();
										Double purchaseTaxAmountNew = Double.valueOf(purchaseTaxAmountOld)
												+ purchasebillTax;

										SQLQuery purchaseupdateBillQuery = session.createSQLQuery(
												"UPDATE st_rm_bill_wise_details SET balance='" + purchaseBillAmount
														+ "',tax_amount='" + purchaseTaxAmountNew + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + purchaseBillId);
										purchaseupdateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + purchaseBillId + ",'" + purchaseObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ reppurchaseBillAmount + "','" + purchasebillTax + "','"
														+ purchaseBillAmount + "','" + partyBlnc + "','" + blncTyp
														+ "','Purchase')");
										Schquery.executeUpdate();

										logger.info(
												"::::::::::::SCHEDULING TAX SUCCESS OF PURCHASE :::::::::::::::::::::::::");

									}

								}

							}

						} else if (rateMonthOrYear.equalsIgnoreCase("Calendar Year")) {
							logger.info("::::::::::::INSIDE CALENDAR Year:::::::::::::::::::::::::");
							String dueLimit = !obj[10].toString().isEmpty() ? obj[10].toString() : "0";
							String gracePeriod = !obj[11].toString().isEmpty() ? obj[11].toString() : "0";
							Integer totalDays = Integer.valueOf(dueLimit) + Integer.valueOf(gracePeriod);
							if (alwaysOrPastDueDate.equalsIgnoreCase("Always"))
								totalDays = 0;

							Integer ledgerId = (int) obj[1];
							SQLQuery query1 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details_sale WHERE type_of_ref IN('Agst Ref') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> saleBillsresult = query1.list();
							if (saleBillsresult != null && !saleBillsresult.isEmpty() && saleBillsresult.size() > 0) {

								for (Object[] saleObj : saleBillsresult) {
									if (isInterestAllow(ledgerId))
										continue;

									String saleBillDate = saleObj[5].toString();
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);

									c.setTime(sdf.parse(saleBillDate));
									c.add(Calendar.DAY_OF_MONTH, totalDays);
									String datePeriod = sdf.format(c.getTime());

									if (compareTwoDate(datePeriod + " 00:00", currentDate + " 00:00")) {

										Double taxRate = Double.valueOf(obj[6].toString());
										int yearMaxDays = c.getActualMaximum(Calendar.DAY_OF_YEAR);
										double dayPercentRateCalculate = (taxRate / 365) * (double) yearMaxDays;

										Double saleBillAmount = Double.valueOf(saleObj[3].toString());
										Double repsaleBillAmount = saleBillAmount;
										Double billTax = (saleBillAmount * dayPercentRateCalculate) / 100;
										saleBillAmount = saleBillAmount + billTax;
										int saleBillId = (int) saleObj[0];
										logger.info("::::::::::::SALE BILL :::::::::::::::::::::::::" + saleBillId);
										String saleTaxAmountOld = saleObj[9].toString();
										Double saleTaxAmountNew = Double.valueOf(saleTaxAmountOld) + billTax;

										SQLQuery updateBillQuery = session.createSQLQuery(
												"UPDATE st_rm_bill_wise_details_sale SET balance='" + saleBillAmount
														+ "',tax_amount='" + saleTaxAmountNew + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + saleBillId);
										updateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + saleBillId + ",'" + saleObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ repsaleBillAmount + "','" + billTax + "','" + saleBillAmount
														+ "','" + partyBlnc + "','" + blncTyp + "','Sale')");
										Schquery.executeUpdate();

										// sale tax billing end
										logger.info(
												"::::::::::::SALE BILL WISE TAX SCHEDULING SUCCESS:::::::::::::::::::::::::");
									}
								}
							}

							// purchase tax billing start
							logger.info(
									"::::::::::::SCHEDULING START OF TAX REPORT PURCHASING:::::::::::::::::::::::::");
							SQLQuery query2 = session.createSQLQuery(
									"SELECT * FROM st_rm_bill_wise_details WHERE type_of_ref IN('Agst Ref') and is_used='No' and party_id="
											+ ledgerId);
							List<Object[]> purchaseBillsresult = query2.list();
							if (purchaseBillsresult != null && !purchaseBillsresult.isEmpty()
									&& purchaseBillsresult.size() > 0) {

								for (Object[] purchaseObj : purchaseBillsresult) {
									String purchaseBillDate = purchaseObj[5].toString();
									if (isInterestAllow(ledgerId))
										continue;

									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									Calendar c = Calendar.getInstance();
									TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
									c.setTimeZone(tz);

									c.setTime(sdf.parse(purchaseBillDate));
									c.add(Calendar.DAY_OF_MONTH, totalDays);
									String purchasedatePeriod = sdf.format(c.getTime());
									if (compareTwoDate(purchasedatePeriod + " 00:00", currentDate + " 00:00")) {

										Double PtaxRate = Double.valueOf(obj[6].toString());
										Calendar Pc = Calendar.getInstance();
										int PyearMaxDays = Pc.getActualMaximum(Calendar.DAY_OF_YEAR);
										double PdayPercentRateCalculate = (PtaxRate / 365) * (double) PyearMaxDays;

										Double purchaseBillAmount = Double.valueOf(purchaseObj[3].toString());
										Double reppurchaseBillAmount = purchaseBillAmount;
										Double purchasebillTax = (purchaseBillAmount * PdayPercentRateCalculate) / 100;
										purchaseBillAmount = purchaseBillAmount + purchasebillTax;
										int purchaseBillId = (int) purchaseObj[0];
										logger.info(
												"::::::::::::PURCHASE BILL :::::::::::::::::::::::::" + purchaseBillId);
										String purchaseTaxAmountOld = purchaseObj[9].toString();
										Double purchaseTaxAmountNew = Double.valueOf(purchaseTaxAmountOld)
												+ purchasebillTax;

										SQLQuery purchaseupdateBillQuery = session.createSQLQuery(
												"UPDATE st_rm_bill_wise_details SET balance='" + purchaseBillAmount
														+ "',tax_amount='" + purchaseTaxAmountNew + "',tax_updated_on='"
														+ date.format(formatter) + "' where bill_id=" + purchaseBillId);
										purchaseupdateBillQuery.executeUpdate();
										SQLQuery queryBln = session.createSQLQuery(
												"SELECT * from st_rm_purchase_party_master_balance where party_id="
														+ ledgerId);
										List<Object[]> blncC = queryBln.list();
										String partyBlnc = "";
										String blncTyp = "";
										for (Object[] o : blncC) {
											partyBlnc = o[2].toString();
											blncTyp = o[3].toString();
										}

										SQLQuery Schquery = session.createSQLQuery(
												"INSERT INTO st_rm_bill_balances_scheduling_report(`party_id`,`bill_id`,`voucher_no`,`scheduling_status`,`scheduling_date`,`bill_balnc`,`tax_blnc`,`final_blnc`,`party_curr_balnc_till`,`blnc_type`,`bill_type`) values("
														+ ledgerId + "," + purchaseBillId + ",'" + purchaseObj[8]
														+ "','success','" + date.format(formatter) + "','"
														+ reppurchaseBillAmount + "','" + purchasebillTax + "','"
														+ purchaseBillAmount + "','" + partyBlnc + "','" + blncTyp
														+ "','Purchase')");
										Schquery.executeUpdate();

										logger.info(
												"::::::::::::SCHEDULING TAX SUCCESS OF PURCHASE :::::::::::::::::::::::::");

									}

								}

							}

						}
					}
				}
			}
			logger.info("::::::::::::SCHEDULING END  :::::::::::::::::::::::::");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getItemRegularRate(String itemName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT b.rate,b.super_cash_amt FROM `st_rm_stock_item_godown_opening_blc` AS b INNER JOIN `st_rm_stock_item_master` AS a ON a.st_it_id = b.item_id AND a.item_name='"
							+ itemName + "'");
			List<Object[]> objResult = query.list();
			if (objResult != null && !objResult.isEmpty() && objResult.size() > 0) {

				for (Object[] obj : objResult)
					return String.valueOf((int) obj[0]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}

	public String getItemSuperCashRate(String itemName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT b.rate,b.super_cash_amt FROM `st_rm_stock_item_godown_opening_blc` AS b INNER JOIN `st_rm_stock_item_master` AS a ON a.st_it_id = b.item_id AND a.item_name='"
							+ itemName + "'");
			List<Object[]> objResult = query.list();
			if (objResult != null && !objResult.isEmpty() && objResult.size() > 0) {

				for (Object[] obj : objResult)
					return obj[1].toString();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}

	public boolean updatePriceListData(String itemName, String regularPrice, String superCashPrice) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT st_it_id from st_rm_stock_item_master where item_name='" + itemName + "'");
			List<Integer> result = query.list();
			int itemId = result.get(0);
			SQLQuery query2 = session.createSQLQuery("UPDATE st_rm_stock_item_godown_opening_blc SET rate="
					+ regularPrice + ",super_cash_amt='" + superCashPrice + "' where item_id=" + itemId);
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void blockSuperCashParty() {

		try {
			Session session = HibernateSessionFactory.getSession();
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String currentDate = date.format(formatter);
			SQLQuery query = session.createSQLQuery(
					"SELECT date,sale_voucher_number,party_id from st_rm_bill_wise_details_sale WHERE type_of_ref='Agst Ref' and is_used='No' and superCashBill='yes'");
			List<Object[]> result = query.list();

			for (Object[] obj : result) {

				String billDate = obj[0].toString();
				int partyId = (int) obj[2];
				Date today = new Date();
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));

				Date dateToday = df.parse(currentDate);
				Date billDatePer = df.parse(billDate);

				df.applyPattern("yyyy-MM-dd");
				String dateToday1 = df.format(dateToday);
				String billDatePer1 = df.format(billDatePer);
				LocalDateTime effectiveDate = LocalDateTime.parse(dateToday1);
				LocalDateTime effectiveDateDb = LocalDateTime.parse(billDatePer1);

				// Now access the values as below
				Days days = Days.daysBetween(effectiveDateDb, effectiveDate);
				if (days.getDays() > 0 && days.getDays() > 7) {
					query = session
							.createSQLQuery("SELECT * FROM party_block_superCash_master WHERE partyId=" + partyId);
					List<Object[]> checkExists = query.list();
					if (checkExists != null && checkExists.size() > 0 && !checkExists.isEmpty()
							&& checkExists.get(0) != null) {

					} else {
						SQLQuery queryIns = session
								.createSQLQuery("INSERT INTO party_block_superCash_master(`partyId`,`bill`) values("
										+ partyId + ",'" + obj[1].toString() + "')");
						queryIns.executeUpdate();
					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean getPartyBlockStatus(String partyAcc) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int partyId = getLedgerIdByName(partyAcc);
			SQLQuery query = session
					.createSQLQuery("Select * from party_block_superCash_master where partyId=" + partyId + "");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0 && result.get(0) != null
					&& !result.get(0).equals(null))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changePartyStatus(String partyName, String status) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String queryString = "";
			int partyId = getLedgerIdByName(partyName);
			if (status.equalsIgnoreCase("Block"))
				queryString = "INSERT INTO party_block_superCash_master(`partyId`,`status`) values(" + partyId
						+ ",'BLOCK')";
			else if (status.equalsIgnoreCase("Unblock"))
				queryString = "DELETE FROM party_block_superCash_master WHERE partyId=" + partyId;
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean setUpdateApprovalStages(String empName, String juniorAccName, String dispatcherName,
			String seniorAccName) {

		Transaction transaction = null;
		try {

			int empId = getUserIdByName(empName);
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sqlString = "SELECT * FROM st_rm_transaction_approval_master WHERE emp_id=" + empId;
			SQLQuery criteria = session.createSQLQuery(sqlString);
			List<Object[]> result = criteria.list();
			if (result != null && !result.isEmpty() && result.size() > 0 && result.get(0) != null) {
				TransactionApprovalMaster approvalMaster = new TransactionApprovalMaster();
				sqlString = "UPDATE st_rm_transaction_approval_master SET junior_acc_id="
						+ getUserIdByName(juniorAccName) + ",dispatcher_id=" + getUserIdByName(dispatcherName)
						+ ",senior_acc_id=" + getUserIdByName(seniorAccName) + " WHERE emp_id=" + empId;
			} else {

				sqlString = "INSERT INTO st_rm_transaction_approval_master(`emp_id`,`junior_acc_id`,`dispatcher_id`,`senior_acc_id`) values("
						+ empId + "," + getUserIdByName(juniorAccName) + "," + getUserIdByName(dispatcherName) + ","
						+ getUserIdByName(seniorAccName) + ")";
			}
			SQLQuery querysql = session.createSQLQuery(sqlString);
			querysql.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public String getAccNameByEmpId(int userId, String columnName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT " + columnName + " from st_rm_transaction_approval_master WHERE emp_id=" + userId);
			;
			List<Integer> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0 && result.get(0) != null) {
				return getUserNameByIdFromMaster(result.get(0));
			} else {
				return "-1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "-1";
	}

	public int getFirstLevelApproval(int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT * from st_rm_transaction_approval_master WHERE emp_id=" + userId);
			;
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0 && result.get(0) != null) {
				for (Object[] obj : result)
					return (int) obj[2];
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String getIsLastApproval(String Id, String txnType) {

		try {
			Session session = HibernateSessionFactory.getSession();
			String tableName = "";
			String suffix = "";
			if (txnType.equalsIgnoreCase("receipt")) {
				tableName = "st_rm_txn_receipt_master_emp";
				suffix = "receiptId=" + Id;
			} else if (txnType.equalsIgnoreCase("sales")) {
				tableName = "st_rm_txn_sales_master_emp";
				suffix = "salesId=" + Id;
			} else if (txnType.equalsIgnoreCase("credit note")) {
				tableName = "st_rm_txn_creditNote_master_emp";
				suffix = "cnId=" + Id;
			}
			SQLQuery query = session.createSQLQuery("SELECT approval_count from " + tableName + " WHERE " + suffix);
			int count = (int) query.list().get(0);
			int approvalCount = 0;
			if (txnType.equals("receipt") || txnType.equals("payment")) {
				approvalCount = 1;
			} else {
				approvalCount = 2;
			}
			if (count >= approvalCount || count == 1) {
				return "YES";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "NO";
	}

	public boolean rejectReceipt(String rcptId, String rejectReason, int userId) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("UPDATE st_rm_txn_receipt_master_emp SET order_status='rejected',order_status_by="
							+ userId + ",reject_reason='" + rejectReason + "' WHERE receiptId=" + rcptId);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean approveReceipt(String rcptId, int userId) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			int approveCount = 0;
			int createdUserId = 0;
			SQLQuery query = session
					.createSQLQuery("SELECT * FROM st_rm_txn_receipt_master_emp WHERE receiptId=" + rcptId);
			List<Object[]> result = query.list();
			if (result != null && result.size() > 0) {
				for (Object[] obj : result) {
					approveCount = (int) obj[4];
					createdUserId = (int) obj[2];
				}

			}
			approveCount = approveCount + 1;
			query = session.createSQLQuery("UPDATE st_rm_txn_receipt_master_emp SET approval_count=" + approveCount
					+ ",order_status_by=" + getLastApproval(createdUserId) + " WHERE receiptId=" + rcptId);
			query.executeUpdate();
			query = session.createSQLQuery(
					"UPDATE receipt_order_staus_alert SET changed_by=" + userId + " WHERE order_id=" + rcptId + "");
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	private int getLastApproval(int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT * from st_rm_transaction_approval_master WHERE emp_id=" + userId);
			;
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0 && result.get(0) != null) {
				for (Object[] obj : result)
					return (int) obj[4];
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	private int getSecondApproval(int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT * from st_rm_transaction_approval_master WHERE emp_id=" + userId);
			;
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0 && result.get(0) != null) {
				for (Object[] obj : result)
					return (int) obj[3];
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean changeStatusReceipt(String rcptId, int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int approveCount = 0;
			int createdUserId = 0;
			SQLQuery query = session
					.createSQLQuery("SELECT * FROM st_rm_txn_receipt_master_emp WHERE receiptId=" + rcptId);
			List<Object[]> result = query.list();
			if (result != null && result.size() > 0) {
				for (Object[] obj : result) {
					approveCount = (int) obj[4];
					createdUserId = (int) obj[2];
				}

			}
			approveCount = approveCount + 1;
			query = session.createSQLQuery("UPDATE st_rm_txn_receipt_master_emp SET approval_count=" + approveCount
					+ ",order_status_by=" + userId + ",order_status='accepted' WHERE receiptId=" + rcptId);
			query.executeUpdate();
			query = session.createSQLQuery("UPDATE receipt_order_staus_alert SET changed_by=" + userId
					+ ",status='accepted' WHERE order_id=" + rcptId + "");
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean rejectCreditNote(String orderNo, String rejectReason, int userId) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(
					"UPDATE st_rm_txn_creditNote_master_emp SET order_status='rejected',order_status_by=" + userId
							+ ",reject_reason='" + rejectReason + "' where cnId=" + orderNo);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean rejectSales(String orderNo, String rejectReason, int userId) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("UPDATE st_rm_txn_sales_master_emp SET order_status='rejected',order_status_by="
							+ userId + ",reject_reason='" + rejectReason + "' where salesId=" + orderNo);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean approveCreditNote(String orderNo, int userId) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			int approveCount = 0;
			int createdUserId = 0;
			SQLQuery query = session
					.createSQLQuery("SELECT * FROM st_rm_txn_creditNote_master_emp WHERE cnId=" + orderNo);
			List<Object[]> result = query.list();
			if (result != null && result.size() > 0) {
				for (Object[] obj : result) {
					approveCount = (int) obj[4];
					createdUserId = (int) obj[3];
				}

			}
			approveCount = approveCount + 1;
			query = session.createSQLQuery("UPDATE st_rm_txn_creditNote_master_emp SET approval_count=" + approveCount
					+ ",order_status_by=" + getSecondApproval(createdUserId) + " WHERE cnId=" + orderNo);
			query.executeUpdate();
			query = session.createSQLQuery(
					"UPDATE creditNote_order_staus_alert SET changed_by=" + userId + " WHERE order_id=" + orderNo + "");
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean approveSale(String orderNo, int userId) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			int approveCount = 0;
			int createdUserId = 0;
			SQLQuery query = session
					.createSQLQuery("SELECT * FROM st_rm_txn_sales_master_emp WHERE salesId=" + orderNo);
			List<Object[]> result = query.list();
			if (result != null && result.size() > 0) {
				for (Object[] obj : result) {
					approveCount = (int) obj[4];
					createdUserId = (int) obj[3];
				}

			}
			approveCount = approveCount + 1;
			query = session.createSQLQuery("UPDATE st_rm_txn_sales_master_emp SET approval_count=" + approveCount
					+ ",order_status_by=" + getSecondApproval(createdUserId) + " WHERE salesId=" + orderNo);
			query.executeUpdate();
			query = session.createSQLQuery(
					"UPDATE receipt_order_staus_alert SET changed_by=" + userId + " WHERE order_id=" + orderNo + "");
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean approveCreditNote(String orderNo, int userId, String isFinalApproval) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int approveCount = 0;
			int createdUserId = 0;
			SQLQuery query = session
					.createSQLQuery("SELECT * FROM st_rm_txn_creditNote_master_emp WHERE cnId=" + orderNo);
			List<Object[]> result = query.list();
			if (result != null && result.size() > 0) {
				for (Object[] obj : result) {
					approveCount = (int) obj[4];
					createdUserId = (int) obj[3];
				}

			}
			approveCount = approveCount + 1;
			query = session.createSQLQuery("UPDATE st_rm_txn_creditNote_master_emp SET approval_count=" + approveCount
					+ ",order_status_by=" + getLastApproval(createdUserId) + " WHERE cnId=" + orderNo);
			query.executeUpdate();
			query = session.createSQLQuery(
					"UPDATE creditNote_order_staus_alert SET changed_by=" + userId + " WHERE order_id=" + orderNo + "");
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean approveSale(String orderNo, int userId, String isFinalApproval) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int approveCount = 0;
			int createdUserId = 0;
			SQLQuery query = session
					.createSQLQuery("SELECT * FROM st_rm_txn_sales_master_emp WHERE salesId=" + orderNo);
			List<Object[]> result = query.list();
			if (result != null && result.size() > 0) {
				for (Object[] obj : result) {
					approveCount = (int) obj[4];
					createdUserId = (int) obj[3];
				}

			}
			approveCount = approveCount + 1;
			query = session.createSQLQuery("UPDATE st_rm_txn_sales_master_emp SET approval_count=" + approveCount
					+ ",order_status_by=" + getLastApproval(createdUserId) + " WHERE salesId=" + orderNo);
			query.executeUpdate();
			query = session.createSQLQuery(
					"UPDATE receipt_order_staus_alert SET changed_by=" + userId + " WHERE order_id=" + orderNo + "");
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void setDocumentPathSalesOrder(int userId, String orderNo, String fileFullPathDD, String fileFullPathTB,
			String tn, String des, String transportFreight, String vn, String loadUnloadCharge, String localFrieght,
			String ddn, String billt) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"INSERT INTO st_rm_txn_sales_master_emp_others(`saleId`,`ddn`,`transport_name`,`destination`,`biit`,`vehical_no`,`transport_frieght`,`local_frieght`,`load_unload_charge`,`ddn_doc`,`billt_doc`) values("
							+ orderNo + ",'" + ddn + "','" + tn + "','" + des + "','" + billt + "','" + vn + "','"
							+ transportFreight + "','" + localFrieght + "','" + loadUnloadCharge + "','"
							+ fileFullPathDD + "','" + fileFullPathTB + "')");
			query.executeUpdate();
			approveSale(orderNo, userId, "yes");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public Map<String, LedgerReportBean> getEmployeeBalanceSheetReport(String empName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			Map<String, LedgerReportBean> map = new HashMap<String, LedgerReportBean>();
			LedgerReportBean bean = null;
			if (empName != null && !empName.isEmpty()) {

				int empId = getUserIdByName(empName);

				SQLQuery query = session.createSQLQuery(
						"SELECT ledger_id,ledger_name from st_rm_acc_ledger_master WHERE emp_under_id=" + empId);
				List<Object[]> result = query.list();
				if (result != null && result.size() > 0 && result.get(0) != null) {
					for (Object[] obj : result) {

						query = session.createSQLQuery(
								"SELECT balance,balance_type from st_rm_purchase_party_master_balance WHERE party_id="
										+ (int) obj[0]);
						List<Object[]> resultSub = query.list();

						for (Object[] objSub : resultSub) {
							bean = new LedgerReportBean();
							bean.setSubLedger(obj[1].toString());
							if (objSub[1].toString().equalsIgnoreCase("Dr")) {
								bean.setDebit(objSub[0].toString());
							} else {
								bean.setCredit(objSub[0].toString());
							}
						}
						map.put(String.valueOf((int) obj[0]), bean);
					}
					return map;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean returnSalesOrder(String orderNo, String rejectReason, int userId) {

		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("DELETE FROM st_rm_txn_sales_master_emp_others where saleId=" + orderNo);
			query.executeUpdate();
			query = session.createSQLQuery(
					"SELECT emp_id,approval_count from st_rm_txn_sales_master_emp WHERE salesId=" + orderNo);
			List<Object[]> approvalCountResult = query.list();
			int count = 0;
			int empId = 0;
			for (Object[] obj : approvalCountResult) {
				count = (int) obj[1];
				empId = (int) obj[0];
			}

			count = count - 1;
			query = session.createSQLQuery("UPDATE st_rm_txn_sales_master_emp SET approval_count=" + count
					+ ",order_status_by=" + getSecondApproval(empId) + ",reject_reason='" + rejectReason
					+ "' WHERE salesId=" + orderNo);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public StDmDomainAliasNameMaster getAliasMaster() {

		try {
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StDmDomainAliasNameMaster.class);
			criteria.add(Restrictions.eq("aliasId", (short) 1));
			StDmDomainAliasNameMaster aliasNameMaster = (StDmDomainAliasNameMaster) criteria.list().get(0);
			return aliasNameMaster;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPartyAccountByVoucher(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT party_acc_name from st_rm_txn_sales_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPartyAccountByVoucherCreditNote(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT party_acc_name from st_rm_txn_creditNote_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPartyAccountByVoucherPurchase(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT party_acc_name from st_rm_txn_purchase_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getTransportNameByVoucher(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT tansport_name from st_rm_txn_sales_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "";
	}

	public String getTransportNameByVoucherCreditNote(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT tansport_name from st_rm_txn_creditNote_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "";
	}

	public String getTransportNameByVoucherPurchase(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT tansport_name from st_rm_txn_purchase_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "";
	}

	public String getVehicalNumberByVoucher(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT vehicle_no from st_rm_txn_sales_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "";
	}

	public String getVehicalNumberByVoucherCreditNote(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT vehicle_no from st_rm_txn_creditNote_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "";
	}

	public String getVehicalNumberByVoucherPurchase(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT vehicle_no from st_rm_txn_purchase_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "";
	}

	public String getDestinationByVoucher(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT destination from st_rm_txn_sales_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "";
	}

	public String getDestinationByVoucherCreditNote(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT destination from st_rm_txn_creditNote_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "";
	}

	public String getDestinationByVoucherPurchase(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT destination from st_rm_txn_purchase_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "";
	}

	public String getPaymentDateByVoucher(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT saleDate from st_rm_txn_sales_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "00-00-0000";
	}

	public String getPaymentDateByVoucherCreditNote(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT cn_date from st_rm_txn_creditNote_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "00-00-0000";
	}

	public String getPaymentDateByVoucherPurchase(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT purchaseDate from st_rm_txn_purchase_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "00-00-0000";
	}

	public String getTotalAmountByVoucher(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT totalAmt from st_rm_txn_sales_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "0.0";
	}

	public String getTotalAmountByVoucherCreditNote(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT totalAmt from st_rm_txn_creditNote_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "0.0";
	}

	public String getTotalAmountByVoucherPurchase(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT totalAmt from st_rm_txn_purchase_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {

		}
		return "0.0";
	}

	public String getSaleStockItemsByVoucher(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT name_item from st_rm_txn_sales_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getSaleStockItemsByVoucherCreditNote(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT name_item from st_rm_txn_creditNote_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getSaleStockItemsByVoucherPurchase(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT name_item from st_rm_txn_purchase_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getSaleStockQtyByVoucher(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT actual_qty from st_rm_txn_sales_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getSaleStockQtyByVoucherCreditNote(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT actual_qty from st_rm_txn_creditNote_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getSaleStockQtyByVoucherPurchase(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT actual_qty from st_rm_txn_purchase_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getSaleStockQtyRateByVoucher(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT rate from st_rm_txn_sales_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getSaleStockQtyRateByVoucherCreditNote(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT rate from st_rm_txn_creditNote_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getSaleStockQtyRateByVoucherPurchase(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT rate from st_rm_txn_purchase_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getSaleStockQtyAmtByVoucher(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT amount from st_rm_txn_sales_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getSaleStockQtyAmtByVoucherCreditNote(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT amount from st_rm_txn_creditNote_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getSaleStockQtyAmtByVoucherPurchase(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT amount from st_rm_txn_purchase_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> sqlResult = query.list();
			return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getFirmGSTN(String partyAcc) {

		try {
			int ledgerId = getLedgerIdByName(partyAcc);
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT firmGSTN from bo_um_ledger_details WHERE ledgerId=" + ledgerId);
			List<String> sqlResult = query.list();

			if (sqlResult != null && sqlResult.size() > 0 && !sqlResult.isEmpty())
				return sqlResult.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public List<String> getBulkUnitNumberByItem(String itemName) {

		List<String> response = null;
		Logger logger = Logger.getLogger(GameLobbyController.class.getName());
		try {
			response = new java.util.LinkedList<String>();
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT item_unit_id from st_rm_stock_item_master WHERE item_name='" + itemName + "'");
			List<Integer> sqlResult = query.list();
			if (sqlResult != null && !sqlResult.isEmpty() && sqlResult.size() > 0) {

				query = session.createSQLQuery(
						"SELECT bulk_unit_name,bulk_to_unit from st_rm_stock_item_unit_master WHERE item_unit_id="
								+ sqlResult.get(0));
				List<Object[]> finalResult = query.list();
				if (finalResult != null && finalResult.size() > 0 && !finalResult.isEmpty()) {

					for (Object[] obj : finalResult) {
						String name = obj[0].toString();
						String qty = obj[1].toString();
						response.add(name);
						response.add(qty);
					}
					return response;
				}

			}
		} catch (Exception e) {
			logger.info("ERROR: unable to fetch bulk unit number by item...");
		}
		return response;
	}

	public String getHSNCodeByItemName(String itemName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT item_unit_id from st_rm_stock_item_master WHERE item_name='" + itemName + "'");
			List<Integer> sqlResult = query.list();
			if (sqlResult != null && !sqlResult.isEmpty() && sqlResult.size() > 0) {

				query = session.createSQLQuery(
						"SELECT hsn_sac_code from st_rm_stock_item_unit_master WHERE item_unit_id=" + sqlResult.get(0));
				List<String> finalResult = query.list();
				if (finalResult != null && finalResult.size() > 0 && !finalResult.isEmpty()) {

					return finalResult.get(0);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getBatchNumberBySaleNo(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT item_batch from st_rm_txn_sales_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getBatchNumberByCreditNoteNo(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT batch from st_rm_txn_creditNote_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<String> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getBatchNumberByPurchase(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT item_batch from st_rm_txn_purchase_master WHERE voucher_numbering='"
							+ salesNoVoucher + "'");
			List<String> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public List<String> getMfgExpDateByItemName(String itemName) {

		List<String> response = null;
		try {
			response = new LinkedList<String>();
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT st_it_id from st_rm_stock_item_master WHERE item_name='" + itemName + "'");
			List<Integer> sqlResult = query.list();
			if (sqlResult != null && !sqlResult.isEmpty() && sqlResult.size() > 0) {

				query = session.createSQLQuery(
						"SELECT mfg_date,exp_date from st_rm_stock_item_godown_opening_blc WHERE item_id="
								+ sqlResult.get(0));
				List<Object[]> finalResult = query.list();
				if (finalResult != null && finalResult.size() > 0 && !finalResult.isEmpty()) {
					for (Object[] obj : finalResult) {
						String mfg = obj[0].toString();
						String exp = obj[1].toString();
						response.add(mfg);
						response.add(exp);
					}
					return response;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;
	}

	public String getItemUnitByName(String itemName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT is_unit from st_rm_stock_item_master WHERE item_name='" + itemName + "'");
			List<String> result = query.list();
			return result.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getUnderEmpNameBySale(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT emp_id from st_rm_txn_sales_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<Integer> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				int empId = result.get(0);
				if (empId != 0) {
					String empName = getEmpNameFromId(empId);
					return empName;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getUnderEmpNameByCreditNote(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT emp_id from st_rm_txn_creditNote_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<Integer> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				int empId = result.get(0);
				if (empId != 0) {
					String empName = getEmpNameFromId(empId);
					return empName;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getUnderEmpNameByPurchase(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT emp_id from st_rm_txn_purchase_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			List<Integer> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				int empId = result.get(0);
				if (empId != 0) {
					String empName = getEmpNameFromId(empId);
					return empName;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getUnderEmpNameOrderBySale(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT emp_id from st_rm_txn_sales_master_emp WHERE salesId=" + salesNoVoucher + "");
			List<Integer> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				int empId = result.get(0);
				if (empId != 0) {
					String empName = getUserNameByIdFromMaster(empId);
					return empName;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public Double getGSTByItemName(String itemName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT alter_gst_id from st_rm_stock_item_master WHERE item_name='" + itemName + "'");
			List<Integer> gstId = query.list();
			if (gstId != null && !gstId.isEmpty() && gstId.size() > 0) {

				query = session.createSQLQuery("SELECT igst from st_rm_stock_gst_master WHERE gst_id=" + gstId.get(0));
				List<Double> result = query.list();
				if (result != null && !result.isEmpty() && result.size() > 0) {
					return result.get(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.0;
	}

	public String getSaleDeliveryDate(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT saleDate from st_rm_txn_sales_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			return (String) query.list().get(0);
		} catch (Exception e) {
		}
		return "";
	}

	public String getCreditNoteDeliveryDate(String salesNoVoucher) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT cn_date from st_rm_txn_creditNote_master WHERE voucher_numbering='" + salesNoVoucher + "'");
			return (String) query.list().get(0);
		} catch (Exception e) {
		}
		return "";
	}

	public boolean createManufacturingRecord(ManufacturingBean manufacturingBean) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String sqlString = "INSERT INTO `crm`.`bo_um_manufacturing_master` (`item_name`, `item_godown`, `item_qty`, `item_batch`, `item_mfg`, `item_exp`, `com_item`, `com_godown`, `com_qty`, `com_rate`, `com_amt`, `scrap_item`, `scrap_godown`, `scrap_cost_alloc`, `scrap_qty`, `scrap_rate`, `scrap_amt`, `other_cost_type`, `other_cost_amt`, `tot_add_cost`, `eff_cost`, `alloc_primary_item`, `eff_rate_primary_item`, `eff_qty_primary_item`) VALUES \n"
					+ "('" + manufacturingBean.getStockItemName() + "','" + manufacturingBean.getStockGodown() + "','"
					+ manufacturingBean.getManufacturingQty() + "','" + manufacturingBean.getBatchNo() + "','"
					+ manufacturingBean.getMfg() + "','" + manufacturingBean.getExp() + "','"
					+ manufacturingBean.getComponentitemName() + "','" + manufacturingBean.getComponentitemGodown()
					+ "','" + manufacturingBean.getComponentItemQty() + "','" + manufacturingBean.getComponentItemRate()
					+ "','" + manufacturingBean.getComponentItemAmt() + "','" + manufacturingBean.getScrapitemName()
					+ "','" + manufacturingBean.getScrapitemGodown() + "','" + manufacturingBean.getScrapCostPercent()
					+ "','" + manufacturingBean.getScrapItemQty() + "','" + manufacturingBean.getScrapItemrate() + "','"
					+ manufacturingBean.getScrapItemAmt() + "','" + manufacturingBean.getCostComponentitemName() + "','"
					+ manufacturingBean.getCostComponentItemAmt() + "','" + manufacturingBean.getTotalAdditionalCost()
					+ "','" + manufacturingBean.getEffectiveCost() + "','"
					+ manufacturingBean.getAllocationPrimaryItem() + "','"
					+ manufacturingBean.getEffectiveRatePrimaryItem() + "','"
					+ manufacturingBean.getEffectiveQtyPrimaryItem() + "')";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();

			sqlString = "SELECT st_it_id from st_rm_stock_item_master WHERE item_name='"
					+ manufacturingBean.getStockItemName() + "'";
			query = session.createSQLQuery(sqlString);
			List<Integer> result = query.list();
			int itemId = result.get(0);

			sqlString = "SELECT gd_id from st_rm_Godown_master WHERE name='" + manufacturingBean.getStockGodown() + "'";
			query = session.createSQLQuery(sqlString);
			List<Integer> resultGoDown = query.list();
			int godownId = resultGoDown.get(0);

			sqlString = "SELECT is_unit from st_rm_stock_item_master WHERE item_name='"
					+ manufacturingBean.getStockItemName() + "'";
			query = session.createSQLQuery(sqlString);
			List<String> resultUnit = query.list();
			String unit = resultUnit.get(0);

			sqlString = "INSERT INTO st_rm_item_qty_godown(`item_id`,`godown_id`,`unit`,`availableQty`,`batch`,`mfg`,`exp`) values("
					+ itemId + "," + godownId + ",'" + unit + "','" + manufacturingBean.getEffectiveQtyPrimaryItem()
					+ "','" + manufacturingBean.getBatchNo() + "','" + manufacturingBean.getMfg() + "','"
					+ manufacturingBean.getExp() + "')";
			query = session.createSQLQuery(sqlString);
			query.executeUpdate();

			sqlString = "INSERT INTO st_rm_stock_item_godown_opening_blc(`item_id`,`godown_id`,`batch_id`,`mfg_date`,`exp_date`,`quantity`,`rate`) values("
					+ itemId + "," + godownId + ",'" + manufacturingBean.getBatchNo() + "','"
					+ manufacturingBean.getMfg() + "','" + manufacturingBean.getExp() + "','"
					+ manufacturingBean.getEffectiveQtyPrimaryItem() + "',0)";
			query = session.createSQLQuery(sqlString);
			query.executeUpdate();

			String[] itemNameArr = manufacturingBean.getComponentitemName().split(",");
			String[] itemQtyArr = manufacturingBean.getComponentItemQty().split(",");
			String[] itemGoDownArr = manufacturingBean.getComponentitemGodown().split(",");
			int c = 0;
			for (String itemNm : itemNameArr) {

				if (itemNm != null && !itemNm.isEmpty() && !itemNm.trim().equals("-1")) {

					Double item_qty = Double.valueOf(itemQtyArr[c].trim());
					int item_Id = getItemIdByItemName(itemNm.trim());
					int godown_id = getGodownIdByName(itemGoDownArr[c].trim());
					SQLQuery sqlQuerySelect = session
							.createSQLQuery("SELECT availableQty FROM st_rm_item_qty_godown WHERE item_id=" + item_Id
									+ " and godown_id=" + godown_id + "");
					List<String> dataResult = sqlQuerySelect.list();
					String availQty = "0.0";
					if (dataResult != null && !dataResult.isEmpty()) {
						for (String avQty : dataResult) {
							availQty = avQty.trim();
							break;

						}
					}
					Double updatedQty = Double.valueOf(availQty) - item_qty;

					SQLQuery sqlQueryUpdate = session.createSQLQuery("UPDATE st_rm_item_qty_godown SET availableQty='"
							+ updatedQty + "' WHERE item_id=" + item_Id + " and godown_id=" + godown_id + "");
					sqlQueryUpdate.executeUpdate();
				}
				c++;

			}
			String[] otherCostLedger = manufacturingBean.getCostComponentitemName().split(",");
			String[] otherCostLedgerAmt = manufacturingBean.getCostComponentItemAmt().split(",");
			int p = 0;
			for (String ledName : otherCostLedger) {
				if (ledName != null && !ledName.isEmpty() && !ledName.trim().equals("-1")) {
					int ledgerId = getLedgerIdByName(ledName.trim());
					adjustPartyAmount(ledgerId, Double.valueOf(otherCostLedgerAmt[c].trim()), "Dr");
				}

				p++;
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	private int getGodownIdByName(String godownName) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT gd_id from st_rm_Godown_master WHERE name='" + godownName + "'");
			List<Integer> result = query.list();
			if (result != null && !result.isEmpty())
				return result.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void scheduleAllClosingBalance() {

		try {
			Logger logger = Logger.getLogger(GameLobbyController.class.getName());
			logger.info(
					"------------------------SCHEDULAR FOR DAILY CLOSING BALANCE START-----------------------------");
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * FROM st_rm_purchase_party_master_balance";
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			Map<Integer, String> balanceMap = new HashMap<Integer, String>();
			if (result != null && result.size() > 0) {
				for (Object[] obj : result) {
					String balance = obj[2].toString().trim() + " " + obj[3].toString().trim();
					balanceMap.put((int) obj[1], balance);
				}
			}

			for (Entry<Integer, String> map : balanceMap.entrySet()) {

				int partyId = map.getKey();
				String partyBalc = map.getValue();
				String vcrId = "JSC/OPENING/BAL";
				String txn_type = "OPENING";
				Date today = new Date();
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
				String date = df.format(today);

				String sqlString1 = "INSERT INTO st_rm_party_txn_curr_balance_master(`party_id`,`party_balance_bef_txn`,`party_balance_aft_txn`,`date`,`txn_type`,`voucher_id`) values("
						+ partyId + ",'" + partyBalc + "','" + partyBalc + "','" + date + "','" + txn_type + "','"
						+ vcrId + "')";
				query = session.createSQLQuery(sqlString1);
				query.executeUpdate();
			}
			logger.info("------------------------SCHEDULAR FOR DAILY CLOSING BALANCE END-----------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String, InterestBean> getInterestReportResult(String ledgerName, String fromDate, String toDate) {

		Map<String, InterestBean> map = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "";
			String append = "";
			map = new HashMap<String, InterestBean>();
			InterestBean bean = null;
			int partyId = getLedgerIdByName(ledgerName);
			if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
				append = " AND STR_TO_DATE(scheduling_date,'%d-%m-%Y')>=STR_TO_DATE('" + fromDate
						+ "','%d-%m-%Y') AND STR_TO_DATE(scheduling_date,'%d-%m-%Y')<=STR_TO_DATE('" + toDate
						+ "','%d-%m-%Y')";

			}
			sqlString = "SELECT * FROM st_rm_bill_balances_scheduling_report WHERE bill_type='Sale' AND party_id="
					+ partyId + append;
			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();

			if (result != null && result.size() > 0) {
				int count = 0;
				for (Object[] obj : result) {
					count++;
					bean = new InterestBean();
					bean.setId(count);
					bean.setPartyId((int) obj[1]);
					bean.setBalanceType(obj[10].toString());
					bean.setBillBalance(obj[6].toString());
					bean.setBillType(obj[11].toString());
					bean.setInterestBalance(obj[7].toString());
					bean.setPartyCurrBalance(obj[8].toString());
					bean.setSchedulingDate(obj[5].toString());
					bean.setSchedulingStatus(obj[4].toString());
					bean.setVoucherNo(obj[3].toString());
					bean.setBillDate(getBillDateSale(bean.getVoucherNo()));
					map.put("" + count, bean);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	private String getBillDateSale(String voucherNo) {

		try {

			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM st_rm_bill_wise_details_sale WHERE sale_voucher_number='" + voucherNo + "'");
			List<Object[]> result = query.list();
			if (result != null && result.size() > 0) {

				for (Object[] obj : result) {
					return obj[5].toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Bill Not Exists";
	}

	public String getOrderNumber(String salesNoVoucher) {

		Logger logger = Logger.getLogger(GameLobbyController.class.getName());
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM st_rm_bill_wise_details_sale WHERE sale_voucher_number='" + salesNoVoucher + "'");
			List<Object[]> result = query.list();
			Integer orderNumber = 0;
			if (result != null && result.size() > 0) {
				for (Object[] obj : result)
					orderNumber = (int) obj[12];

				if (orderNumber != 0)
					return "" + orderNumber;
			}
		} catch (Exception e) {
			logger.info("ERROR: No sale order found in table");
		}
		return "";
	}

	public String getOrderDate(String orderNumber) {

		Logger logger = Logger.getLogger(GameLobbyController.class.getName());
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT sale_order_date FROM st_rm_txn_sales_master_emp WHERE salesId=" + orderNumber + "");
			List<String> result = query.list();
			String orderDate = "";
			if (result != null && result.size() > 0) {
				for (String obj : result)
					orderDate = obj;

				return orderDate;
			}
		} catch (Exception e) {
			logger.info("ERROR: No sale order found in table");
		}
		return "";
	}

	public String getEmpNameByOrder(String orderNo) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT emp_id from st_rm_txn_sales_master_emp WHERE salesId=" + orderNo);
			Integer empId = (Integer) query.list().get(0);
			String empname = getUserNameByIdFromMaster(empId);
			return empname;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getEmpNameByCreditNoteOrder(String orderNo) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT emp_id from st_rm_txn_creditNote_master_emp WHERE cnId=" + orderNo);
			Integer empId = (Integer) query.list().get(0);
			String empname = getUserNameByIdFromMaster(empId);
			return empname;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public void setDocumentPathCreditOrder(int userId, String orderNo, String ddn, String tn, String des, String billt,
			String vn, String transportFreight, String localFrieght, String loadUnloadCharge, String deliveryCharge,
			String ddn2) {
		try {
			Session session = HibernateSessionFactory.getSession();

			String sqlString = "UPDATE st_rm_txn_creditNote_master_emp SET transport_name='" + tn + "' WHERE cnId="
					+ orderNo;
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();

			query = session.createSQLQuery(
					"INSERT INTO st_rm_txn_credit_master_emp_others(`cnId`,`ddn`,`destination`,`biit`,`vehical_no`,`transport_frieght`,`local_frieght`,`load_unload_charge`,`delivery_charge`) values("
							+ orderNo + ",'" + ddn + "','" + des + "','" + billt + "','" + vn + "','" + transportFreight
							+ "','" + localFrieght + "','" + loadUnloadCharge + "','" + deliveryCharge + "')");
			query.executeUpdate();
			approveCreditNote(orderNo, userId, "yes");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public Map<Integer, BatteryBean> getBatteryReport(String attendanceDate, String empId) {

		BatteryBean batteryBean = null;
		Map<Integer, BatteryBean> map = new LinkedHashMap<Integer, BatteryBean>();
		try {
			empId = empId.replaceAll("CRM-", "");

			String[] str = attendanceDate.split("-");
			attendanceDate = str[2] + "-" + str[1] + "-" + str[0];
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_user_mobile_battery_info WHERE user_id="
					+ empId + " and STR_TO_DATE(login_date,'%d-%m-%Y') = STR_TO_DATE('" + attendanceDate
					+ "','%d-%m-%Y')");
			List<Object[]> result = query.list();
			if (result != null && result.size() > 0 && !result.isEmpty()) {

				for (Object[] obj : result) {

					batteryBean = new BatteryBean();
					batteryBean.setId((int) obj[0]);
					batteryBean.setDateTime(obj[4].toString());
					batteryBean.setBatteryPercentage(obj[3].toString());
					batteryBean.setReason(obj[5] != null ? obj[5].toString() : "");
					map.put((int) obj[0], batteryBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public boolean editAssignLedgerToUser(String ledgerName, String employeeNames) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int ledgerId = getLedgerIdByName(ledgerName);
			String[] empArr = employeeNames.split(",");
			String appendArr = "";
			for (String s : empArr) {
				s = s.trim();
				int empId = getUserIdByName(s);
				SQLQuery query = session
						.createSQLQuery("INSERT INTO bo_um_ledger_user_mapping(`ledger_id`,`emp_id`) values(" + ledgerId
								+ "," + empId + ")");
				query.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean editAssignRetailerToUser(String ledgerName, String employeeNames) {

		try {
			Session session = HibernateSessionFactory.getSession();
			int ledgerId = getRetailerIdByName(ledgerName);
			String[] empArr = employeeNames.split(",");
			String appendArr = "";
			for (String s : empArr) {
				s = s.trim();
				int empId = getUserIdByName(s);
				SQLQuery query = session
						.createSQLQuery("INSERT INTO bo_um_retailer_user_mapping(`retailer_id`,`emp_id`) values("
								+ ledgerId + "," + empId + ")");
				query.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getEmployeeDateOfJoining(String empName) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT doj from st_rm_bo_user_info WHERE user_id=" + getEmployeeId(empName));
			List<String> result = query.list();
			if (result != null && result.size() > 0 && !result.isEmpty() && result.get(0) != null) {

				return result.get(0).replaceAll("00:00", "").trim();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, SalaryReportBean> generateSalaryReportBean(String empName, String fromDate, String toDate,
			boolean holdFlag) {

		Map<String, SalaryReportBean> map = new HashMap<String, SalaryReportBean>();
		SalaryReportBean bean = null;

		try {
			int empId = getEmployeeId(empName);
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT b.emp_id,attendance_type,DATE,present_in,present_out,odometer_reading_in, odometer_reading_out FROM `bo_um_emp_attendace_details` as a INNER JOIN `bo_um_employee_attendance` as b WHERE STR_TO_DATE(DATE,'%Y-%m-%d') >= STR_TO_DATE('"
					+ fromDate + "','%Y-%m-%d')  AND STR_TO_DATE(DATE,'%Y-%m-%d') <= STR_TO_DATE('" + toDate
					+ "','%Y-%m-%d') AND a.detail_id = b.detail_id AND emp_id=" + empId;

			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			int count = 1;
			if (result != null && result.size() > 0 && !result.isEmpty()) {

				boolean salaryHold = false, TAHold = false, DAHold = false, hotelExpense = false, otherExpense = false;

				for (Object[] obj : result) {

					bean = new SalaryReportBean();
					salaryHold = false;
					TAHold = false;
					DAHold = false;
					hotelExpense = false;
					otherExpense = false;

					bean.setEmpId(String.valueOf("Emp-" + (int) obj[0]));
					bean.setDate(obj[2].toString());

					bean.setAttendanceType(obj[1].toString());
					bean.setTA("0.0");
					bean.setdA("0.0");
					bean.setSalary("0.0");
					bean.setOdoReading("0.0");
					bean.setHotelExp("0.0");
					bean.setOtherExp("0.0");
					String presentIn = obj[3] != null ? obj[3].toString() : "";
					String presentOut = obj[4] != null ? obj[4].toString() : presentIn;

					String odoIn = obj[5] != null ? obj[5].toString() : "0";
					String odoOut = obj[6] != null ? obj[6].toString() : "0";

					String[] dateSplit = obj[2].toString().split("-");
					String formattedDate = dateSplit[2] + "-" + dateSplit[1] + "-" + dateSplit[0];
					sqlString = "SELECT * FROM st_rm_emp_salary_hold WHERE Date='" + formattedDate + "' and emp_id="
							+ empId;
					query = session.createSQLQuery(sqlString);
					List<Object[]> holdResult = query.list();

					if (holdResult != null && !holdResult.isEmpty() && holdResult.size() > 0) {

						for (Object[] holdData : holdResult) {

							String type = holdData[3].toString();

							if (type.equalsIgnoreCase("TA"))
								TAHold = true;
							if (type.equalsIgnoreCase("Others Expense"))
								otherExpense = true;
							if (type.equalsIgnoreCase("Salary"))
								salaryHold = true;
							if (type.equalsIgnoreCase("Hotel Expense"))
								hotelExpense = true;
							if (type.equalsIgnoreCase("DA"))
								DAHold = true;

						}

					}

					String totalWorkingHour = "0.0";
					String min_String = "00";
					if (!presentIn.isEmpty() && !presentOut.isEmpty()) {

						SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
						Date date1 = format.parse(presentIn);
						Date date2 = format.parse(presentOut);
						long diff = date2.getTime() - date1.getTime();
						long min = diff / (60 * 1000) % 60;
						long hour = diff / (60 * 60 * 1000) % 24;
						if (min < 10)
							min_String = "0" + min;
						else
							min_String = "" + min;
						totalWorkingHour = hour + min_String;
						bean.setWorkingHour(hour + " hr" + " " + min + " min");
						}
						Double odoReading = 0.0;
						if (Double.valueOf(odoOut) > Double.valueOf(odoIn)) {
							odoReading = Double.valueOf(odoOut) - Double.valueOf(odoIn);

						}
						bean.setOdoReading(String.format("%.2f", odoReading));
						sqlString = "SELECT salary,avg_travelling_per_day,travelling_allowance,daily_allowance_doc from st_rm_bo_user_info WHERE user_id="
								+ empId;
						query = session.createSQLQuery(sqlString);
						List<Object[]> empInfoResult = query.list();
						if (empInfoResult != null & empInfoResult.size() > 0 && !empInfoResult.isEmpty()) {
							
							for (Object[] obj1 : empInfoResult) {

								String empSalary = obj1[0] != null ? obj1[0].toString() : "0";
								String TA = obj1[2] != null ? obj1[2].toString() : "0";
								String DA = obj1[3] != null ? obj1[3].toString() : "0";
								String avgTravel = obj1[1] != null ? obj1[1].toString() : "0";
								Double taAmt = Double.valueOf(TA) * odoReading;

								bean.setTA(String.format("%.2f", taAmt));
								if (odoReading >= 60 && Double.valueOf(totalWorkingHour) >= 730) {
									bean.setdA(DA);
								}
								if (Double.valueOf(totalWorkingHour) < 730 && !bean.getAttendanceType().equals("W")) {
									if (bean.getAttendanceType().equals("A"))
										bean.setAttendanceType("A");

									else
										bean.setAttendanceType("H");

								}

								Double salaryAmt = Double.valueOf(empSalary) / 12;
								String[] dtArr = obj[2].toString().split("-");
								YearMonth yearMonthObject = YearMonth.of(Integer.valueOf(dtArr[0].trim()),
										Integer.valueOf(dtArr[1].trim()));
								int daysInMonth = yearMonthObject.lengthOfMonth();
								salaryAmt = salaryAmt / daysInMonth;
								bean.setSalary(String.format("%.2f", salaryAmt));
								if (bean.getAttendanceType().equals("H")) {
									salaryAmt = salaryAmt / 2;
									bean.setSalary(String.format("%.2f", salaryAmt));
								}
							}
						}
						String dt = obj[2].toString();
						sqlString = "SELECT expense_type,amount FROM `bo_um_emp_expenses` WHERE STR_TO_DATE(DATE,'%d-%m-%Y') = STR_TO_DATE('"
								+ dt + "','%Y-%m-%d') and emp_id=" + empId;

						query = session.createSQLQuery(sqlString);
						List<Object[]> expenseResult = query.list();
						if (expenseResult != null && expenseResult.size() > 0 && !expenseResult.isEmpty()) {

							for (Object[] obj2 : expenseResult) {

								String expenseType = obj2[0].toString();

								if (expenseType.equals("Others Expense")) {

									bean.setOtherExp(obj2[1].toString());
								}
								if (expenseType.equals("Hotel Expense")) {

									bean.setHotelExp(obj2[1].toString());
								}
							}
						}
					

					if (holdFlag) {
						if (TAHold)
							bean.setTA("0.0");
						if (DAHold)
							bean.setdA("0.0");
						if (salaryHold)
							bean.setSalary("0.0");
						if (hotelExpense)
							bean.setHotelExp("0.0");
						if (otherExpense)
							bean.setOtherExp("0.0");

					}
					if (bean.getAttendanceType().equals("A")) {
						bean.setSalary("0.0");
						bean.setHotelExp("0.0");
						bean.setOtherExp("0.0");
						bean.setdA("0.0");
						bean.setTA("0.0");
					}
					if(bean.getAttendanceType().equals("W")) {
						
						
						
					}

					map.put("" + count, bean);
					count++;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public boolean saveUserInfoBean(StRmBoUserInfo userDetailsBean, int userId) {

		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("UPDATE st_rm_bo_user_info SET email_id='"
					+ userDetailsBean.getEmailId() + "',phone_num='" + userDetailsBean.getPhoneNum() + "',salary='"
					+ userDetailsBean.getSalary() + "',travelling_allowance='"
					+ userDetailsBean.getTravellingAllowance() + "',avg_travelling_per_day='"
					+ userDetailsBean.getAvgTravellingPerDay() + "',city_allowance='"
					+ userDetailsBean.getCityAllowance() + "',ex_city_allowance='"
					+ userDetailsBean.getExCityAllowance() + "',daily_allowance='" + userDetailsBean.getDailyAllowance()
					+ "',daily_allowance_doc='" + userDetailsBean.getDailyAllowanceDoc() + "',branch='"
					+ userDetailsBean.getBranch() + "',region='" + userDetailsBean.getRegion() + "',role='"
					+ userDetailsBean.getRole() + "',department='" + userDetailsBean.getDepartment()
					+ "',week_day_off='" + userDetailsBean.getWeekDay() + "' WHERE user_id=" + userId);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean setAmountOnHold(String empName, String fromDate, String type) {
		try {
			Session session = HibernateSessionFactory.getSession();
			int empId = getUserIdByName(empName);
			SQLQuery query = session.createSQLQuery("INSERT INTO st_rm_emp_salary_hold(`emp_id`,`Date`,`Type`) values("
					+ empId + ",'" + fromDate + "','" + type + "')");
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean setAmountOnUnHold(String empName, String fromDate, String type) {
		try {
			Session session = HibernateSessionFactory.getSession();
			int empId = getUserIdByName(empName);
			SQLQuery query = session.createSQLQuery("DELETE FROM st_rm_emp_salary_hold WHERE emp_id=" + empId
					+ " and Date='" + fromDate + "' and Type='" + type + "'");
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String showBatches(String itemName) {
		try {
			Session session = HibernateSessionFactory.getSession();
			int itemId = getItemIdByItemName(itemName);
			SQLQuery query = session.createSQLQuery("SELECT batch from st_rm_item_qty_godown WHERE item_id=" + itemId);
			String data = "";
			List<String> result = query.list();
			if (result != null) {
				for (String s : result) {
					data = data + s + ";";
				}
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public int getItemIdByItemName(String itemName) {

		Session session = HibernateSessionFactory.getSession();
		String sqlString = "SELECT st_it_id from st_rm_stock_item_master where item_name ='" + itemName + "'";
		SQLQuery query = session.createSQLQuery(sqlString);
		List<Integer> result = query.list();
		if (result != null || !result.isEmpty()) {
			return result.get(0);
		}
		return 0;
	}

	public Map<String, BillsBean> getProductTransactionReport(String txnType, String toDate, String fromDate,
			String employeeName, String ledgerName, String itemname, String batchNo) {

		try {
			BillsBean bean = null;
			Map<String, BillsBean> map = new HashMap<String, BillsBean>();
			Session session = HibernateSessionFactory.getSession();
			String tableName = "";
			if (!txnType.equals("-1")) {

				if (txnType.equals("SALES")) {
					tableName = "SELECT * FROM st_rm_txn_sales_master AS a INNER JOIN `st_rm_bill_wise_details_sale` AS b ON a.voucher_numbering = b.sale_voucher_number WHERE transport_fright>=0 ";
					if (!employeeName.equals("-1")) {
						int empId = getEmployeeId(employeeName);
						tableName += " and a.emp_id=" + empId + " ";
					}
					if (ledgerName != null && !ledgerName.equals("-1")) {
						tableName += " and a.party_acc_name='" + ledgerName + "' ";

					}
					if (itemname != null && !itemname.equals("-1")) {
						tableName += " and a.name_item like'%" + itemname + "%' ";

					}
					if (batchNo != null && !batchNo.equals("-1")) {
						tableName += " and a.item_batch like'%" + batchNo + "%' ";

					}

					if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
						tableName += " and STR_TO_DATE(a.saleDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
								+ "','%d-%m-%Y') and STR_TO_DATE(a.saleDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
								+ "','%d-%m-%Y')";

					}

					SQLQuery query = session.createSQLQuery(tableName);
					List<Object[]> objTes = query.list();
					Double qty = 0.0;
					Double totalPrice = 0.0;

					if (objTes != null && !objTes.isEmpty()) {
						int i = 1;
						for (Object[] obj : objTes) {
							String batches = "";
							String itemQty = "0";
							String itemPrice = "0";
							int p = 0;
							try {
								String[] itemNamesArr = obj[4].toString().split(",");
								String[] itemQtyArr = obj[5].toString().split(",");
								String[] itemPriceArr = obj[6].toString().split(",");
								String[] batchItemArr = obj[28] != null ? obj[28].toString().split(",") : "".split(",");

								for (String item : itemNamesArr) {
									if (item.trim().equals(itemname.trim())) {
										batches = batches + batchItemArr[p] + " ; ";
										itemQty = itemQtyArr[p].trim();
										itemPrice = itemPriceArr[p].trim();
									}
									p++;
								}
							} catch (Exception i1) {
							}
							bean = new BillsBean();
							bean.setLedgerName(obj[1].toString());
							bean.setTxnType(txnType);
							bean.setSubLedger(obj[3].toString());
							String[] dateArr = obj[17].toString().split("-");
							String date = dateArr[2] + "/" + dateArr[1] + "/" + dateArr[0];
							bean.setBillDate(date);
							bean.setBillVoucherNo(obj[10].toString());
							bean.setItemBatch(batches);
							bean.setItemUnit(getItemUnitByName(itemname));
							bean.setItemQty(itemQty);
							bean.setItemPrice(itemPrice);
							bean.setItemTotalValue("" + Double.valueOf(itemQty) * Double.valueOf(itemPrice));
							map.put("" + i, bean);
							i++;
							qty = qty + Double.valueOf(itemQty);
							totalPrice = totalPrice + Double.valueOf(bean.getItemTotalValue());
						}
						i++;
						bean = new BillsBean();
						bean.setBillDate("`");
						bean.setItemQty("" + qty);
						bean.setItemUnit("TOTAL");
						bean.setItemTotalValue("" + totalPrice);

						map.put("" + i, bean);
					}
				} else if (txnType.equals("PURCHASE")) {

					tableName = "SELECT * FROM st_rm_txn_purchase_master AS a INNER JOIN `st_rm_bill_wise_details` AS b ON a.voucher_numbering = b.purchase_voucher_number WHERE transport_fright>=0 ";
					if (!employeeName.equals("-1")) {
						int empId = getEmployeeId(employeeName);
						tableName += " and a.emp_id=" + empId + " ";
					}
					if (ledgerName != null && !ledgerName.equals("-1")) {
						tableName += " and a.party_acc_name='" + ledgerName + "' ";

					}
					if (itemname != null && !itemname.equals("-1")) {
						tableName += " and a.name_item like'%" + itemname + "%' ";

					}
					if (batchNo != null && !batchNo.equals("-1")) {
						tableName += " and a.item_batch like'%" + batchNo + "%' ";

					}
					if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
						tableName += " and STR_TO_DATE(a.purchaseDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
								+ "','%d-%m-%Y') and STR_TO_DATE(a.purchaseDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
								+ "','%d-%m-%Y')";

					}

					SQLQuery query = session.createSQLQuery(tableName);
					List<Object[]> objTes = query.list();
					Double qty = 0.0;
					Double totalPrice = 0.0;

					if (objTes != null && !objTes.isEmpty() && objTes.size() > 0) {
						int i = 1;
						for (Object[] obj : objTes) {
							String batches = "";
							String itemQty = "0";
							String itemPrice = "0";
							int p = 0;
							try {
								String[] itemNamesArr = obj[4].toString().split(",");
								String[] itemQtyArr = obj[5].toString().split(",");
								String[] itemPriceArr = obj[6].toString().split(",");
								String[] batchItemArr = obj[26] != null ? obj[26].toString().split(",") : "".split(",");

								for (String item : itemNamesArr) {
									if (item.trim().equals(itemname.trim())) {
										batches = batches + batchItemArr[p] + " ; ";
										itemQty = itemQtyArr[p].trim();
										itemPrice = itemPriceArr[p].trim();
									}
									p++;
								}
							} catch (Exception i1) {
							}
							bean = new BillsBean();
							bean.setLedgerName(obj[1].toString());
							bean.setSubLedger(obj[3].toString());
							bean.setTxnType(txnType);
							String[] dateArr = obj[17].toString().split("-");
							String date = dateArr[2] + "/" + dateArr[1] + "/" + dateArr[0];
							bean.setBillDate(date);
							bean.setBillVoucherNo(obj[10].toString());
							bean.setItemBatch(batches);
							bean.setItemUnit(getItemUnitByName(itemname));
							bean.setItemQty(itemQty);
							bean.setItemPrice(itemPrice);
							bean.setItemTotalValue("" + Double.valueOf(itemQty) * Double.valueOf(itemPrice));
							map.put("" + i, bean);
							i++;
							qty = qty + Double.valueOf(itemQty);
							totalPrice = totalPrice + Double.valueOf(bean.getItemTotalValue());
						}
						i++;
						bean = new BillsBean();
						bean.setBillDate("`");
						bean.setItemQty("" + qty);
						bean.setItemUnit("TOTAL");
						bean.setItemTotalValue("" + totalPrice);

						map.put("" + i, bean);

					}

				} else if (txnType.equals("CREDIT NOTE")) {

					tableName = "SELECT * FROM st_rm_txn_creditNote_master AS a WHERE emp_id>=0 ";
					if (!employeeName.equals("-1")) {
						int empId = getEmployeeId(employeeName);
						tableName += " and a.emp_id=" + empId + " ";
					}
					if (ledgerName != null && !ledgerName.equals("-1")) {
						tableName += " and a.party_acc_name like '%" + ledgerName + "%' ";

					}
					if (itemname != null && !itemname.equals("-1")) {
						tableName += " and a.name_item like'%" + itemname + "%' ";

					}
					if (batchNo != null && !batchNo.equals("-1")) {
						tableName += " and a.batch like'%" + batchNo + "%' ";

					}
					if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
						tableName += " and STR_TO_DATE(a.cn_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
								+ "','%d-%m-%Y') and STR_TO_DATE(a.cn_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
								+ "','%d-%m-%Y')";

					}

					SQLQuery query = session.createSQLQuery(tableName);
					List<Object[]> objTes = query.list();
					Double qty = 0.0;
					Double totalPrice = 0.0;

					if (objTes != null && !objTes.isEmpty() && objTes.size() > 0) {
						int i = 1;
						for (Object[] obj : objTes) {
							String batches = "";
							String itemQty = "0";
							String itemPrice = "0";
							int p = 0;
							try {
								String[] itemNamesArr = obj[4].toString().split(",");
								String[] itemQtyArr = obj[5].toString().split(",");
								String[] itemPriceArr = obj[6].toString().split(",");
								String[] batchItemArr = obj[20] != null ? obj[20].toString().split(",") : "".split(",");

								for (String item : itemNamesArr) {
									if (item.trim().equals(itemname.trim())) {
										batches = batches + batchItemArr[p] + " ; ";
										itemQty = itemQtyArr[p].trim();
										itemPrice = itemPriceArr[p].trim();
									}
									p++;
								}
							} catch (Exception i1) {
							}
							bean = new BillsBean();
							bean.setLedgerName(obj[1].toString());
							bean.setSubLedger(obj[3].toString());
							bean.setTxnType(txnType);
							String[] dateArr = obj[11].toString().split("-");
							String date = dateArr[2] + "/" + dateArr[1] + "/" + dateArr[0];
							bean.setBillDate(date);
							bean.setBillVoucherNo(obj[10].toString());
							bean.setItemBatch(batches);
							bean.setItemUnit(getItemUnitByName(itemname));
							bean.setItemQty(itemQty);
							bean.setItemPrice(itemPrice);
							bean.setItemTotalValue("" + Double.valueOf(itemQty) * Double.valueOf(itemPrice));
							map.put("" + i, bean);
							qty = qty + Double.valueOf(itemQty);
							totalPrice = totalPrice + Double.valueOf(bean.getItemTotalValue());
							map.put("" + i, bean);
							i++;

						}
						i++;
						bean = new BillsBean();
						bean.setBillDate("`");
						bean.setItemQty("" + qty);
						bean.setItemUnit("TOTAL");
						bean.setItemTotalValue("" + totalPrice);

						map.put("" + i, bean);

					}

				}
			} else {
				tableName = "SELECT * from st_rm_txn_sales_master where party_acc_name='" + ledgerName + "'";
				SQLQuery query1 = session.createSQLQuery(tableName);
				List<Object[]> objTes1 = query1.list();

				tableName = "SELECT * from st_rm_txn_purchase_master where party_acc_name='" + ledgerName + "'";
				SQLQuery query2 = session.createSQLQuery(tableName);
				List<Object[]> objTes2 = query2.list();

				tableName = "SELECT * from st_rm_txn_creditNote_master where party_acc_name='" + ledgerName + "'";
				SQLQuery query4 = session.createSQLQuery(tableName);
				List<Object[]> objTes4 = query4.list();
				int j = 1;
				if (objTes1 != null && !objTes1.isEmpty() && objTes1.size() > 0) {
					for (Object[] obj : objTes1) {
						bean = new BillsBean();
						bean.setLedgerName(ledgerName);
						bean.setSubLedger(obj[3].toString());
						bean.setTxnType("SALE");
						bean.setBillDate(obj[17].toString());
						bean.setBillVoucherNo(obj[10].toString());
						bean.setBillUsed("-");
						bean.setTypeOfRef("-");
						bean.setBillAmount(obj[9].toString());
						bean.setActualBillAmount("0.0");
						map.put("" + j, bean);
						j++;
					}
				}
				if (objTes2 != null && !objTes2.isEmpty() && objTes2.size() > 0) {
					for (Object[] obj : objTes2) {
						bean = new BillsBean();
						bean.setLedgerName(ledgerName);
						bean.setSubLedger(obj[3].toString());
						bean.setTxnType("PURCHASE");
						bean.setBillDate(obj[17].toString());
						bean.setBillVoucherNo(obj[10].toString());
						bean.setBillUsed("-");
						bean.setTypeOfRef("-");
						bean.setActualBillAmount("0.0");
						bean.setBillAmount(obj[9].toString());
						map.put("" + j, bean);
						j++;
					}
				}

				if (objTes4 != null && !objTes4.isEmpty() && objTes4.size() > 0) {
					for (Object[] obj : objTes4) {
						bean = new BillsBean();
						bean.setLedgerName(ledgerName);
						bean.setSubLedger(obj[3].toString());
						bean.setTxnType("CREDIT NOTE");
						bean.setBillDate(obj[11].toString());
						bean.setBillVoucherNo(obj[10].toString());
						bean.setBillUsed("-");
						bean.setActualBillAmount("0.0");
						bean.setTypeOfRef("-");
						bean.setBillAmount(obj[9].toString());
						map.put("" + j, bean);
						j++;
					}
				}

			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public Map<String, BillsBean> fetchAllItemNetStockReport(String itemGroupName, String itemCategory, String fromDate,
			String toDate) {
		Session session = null;
		Map<String, BillsBean> map = new HashMap<String, BillsBean>();
		BillsBean bean = null;

		try {
			session = HibernateSessionFactory.getSession();
			String sqlString = "";
			sqlString = "SELECT * FROM `st_rm_stock_item_master` WHERE item_name  IS NOT NULL";

			if (itemGroupName != null && !itemGroupName.trim().equals("-1") && !itemGroupName.isEmpty()) {
				sqlString = sqlString + " AND under_grp='" + itemGroupName + "'";
			}
			if (itemCategory != null && !itemCategory.trim().equals("-1") && !itemCategory.isEmpty()) {
				sqlString = sqlString + " AND under_cat='" + itemCategory + "'";
			}
			Double netTotal = 0.0;
			List<Object[]> result = session.createSQLQuery(sqlString).list();
			if (result != null && !result.isEmpty()) {

				for (Object[] obj : result) {

					String itemBulkUnit = "";
					String itemAltUnit = "";
					String alteConversiont = "1";
					String alteConversionf = "1";

					String bulkConversiont = "1";
					String bulkConversionf = "1";

					sqlString = "SELECT * FROM st_rm_stock_item_unit_master WHERE item_unit_id=" + (int) obj[5];
					List<Object[]> itemUnitRes = session.createSQLQuery(sqlString).list();
					if (itemUnitRes != null && !itemUnitRes.isEmpty()) {
						itemBulkUnit = itemUnitRes.get(0)[12] != null ? itemUnitRes.get(0)[12].toString() : "";
						itemAltUnit = itemUnitRes.get(0)[1] != null ? itemUnitRes.get(0)[1].toString() : "";
						if (!itemUnitRes.get(0)[1].toString().equals("Not Applicable")) {
							alteConversionf = itemUnitRes.get(0)[2].toString();
							alteConversiont = itemUnitRes.get(0)[4].toString();
						}
						if (!itemUnitRes.get(0)[12].toString().isEmpty()) {
							bulkConversionf = itemUnitRes.get(0)[13].toString();
							bulkConversiont = itemUnitRes.get(0)[14].toString();
						}
					}

					bean = new BillsBean();
					String itemName = obj[1].toString();

					Double itemSaleQty = 0.0;
					Double itemSalePrice = 0.0;

					Double itemCreditNoteQty = 0.0;
					Double itemCreditNotePrice = 0.0;

					Double itemPurQty = 0.0;
					Double itemPurPrice = 0.0;

					Double itemDebitQty = 0.0;
					Double itemDebitPrice = 0.0;

					sqlString = "SELECT * FROM st_rm_item_qty_godown WHERE item_id=" + (int) obj[0];
					SQLQuery queryQty = session.createSQLQuery(sqlString);
					List<Object[]> resultQty = queryQty.list();
					Double netQtyTill = 0.0;
					if (resultQty != null && !resultQty.isEmpty()) {
						for (Object[] oQty : resultQty)
							netQtyTill = netQtyTill + Double.valueOf(oQty[4].toString());
					}
					// start sale data fetched
					sqlString = "SELECT * FROM st_rm_txn_sales_master a WHERE a.saleDate IS NOT NULL";
					if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
						sqlString += " and STR_TO_DATE(a.saleDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
								+ "','%d-%m-%Y') and STR_TO_DATE(a.saleDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
								+ "','%d-%m-%Y')";
					}
					List<Object[]> saleResult = session.createSQLQuery(sqlString).list();

					if (saleResult != null && !saleResult.isEmpty()) {
						for (Object[] saleObj : saleResult) {

							try {
								String[] itemNamesArr = saleObj[4].toString().split(",");
								String[] itemQtyArr = saleObj[5].toString().split(",");
								// String[] itemPriceArr = saleObj[6].toString().split(",");
								int p = 0;
								for (String item : itemNamesArr) {
									if (item.trim().equals(itemName.trim())) {
										itemSaleQty = itemSaleQty + Double.valueOf(itemQtyArr[p].trim());
										// itemSalePrice = itemSalePrice+Double.valueOf(itemPriceArr[p].trim());
									}
									p++;
								}
							} catch (Exception e1) {
							}

						}
					}

					// end sale data fetched

					// start credit note data fetch

					sqlString = "SELECT * FROM st_rm_txn_creditNote_master a WHERE a.cn_date IS NOT NULL";
					if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
						sqlString += " and STR_TO_DATE(a.cn_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
								+ "','%d-%m-%Y') and STR_TO_DATE(a.cn_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
								+ "','%d-%m-%Y')";
					}
					List<Object[]> creditNoteResult = session.createSQLQuery(sqlString).list();

					if (creditNoteResult != null && !creditNoteResult.isEmpty()) {
						for (Object[] creditObj : creditNoteResult) {

							try {
								String[] itemNamesArr = creditObj[4].toString().split(",");
								String[] itemQtyArr = creditObj[5].toString().split(",");
								// String[] itemPriceArr = creditObj[6].toString().split(",");
								int p = 0;
								for (String item : itemNamesArr) {
									if (item.trim().equals(itemName.trim())) {
										itemCreditNoteQty = itemCreditNoteQty + Double.valueOf(itemQtyArr[p].trim());
										// itemCreditNotePrice =
										// itemCreditNotePrice+Double.valueOf(itemPriceArr[p].trim());
									}
									p++;
								}
							} catch (Exception e1) {
							}

						}
					}

					// end credit note data fetched

					// start purchase data fetch

					sqlString = "SELECT * FROM st_rm_txn_purchase_master a WHERE a.purchaseDate IS NOT NULL";
					if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
						sqlString += " and STR_TO_DATE(a.purchaseDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
								+ "','%d-%m-%Y') and STR_TO_DATE(a.purchaseDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
								+ "','%d-%m-%Y')";
					}
					List<Object[]> purchaseResult = session.createSQLQuery(sqlString).list();

					if (purchaseResult != null && !purchaseResult.isEmpty()) {

						int div = 0;
						for (Object[] purObj : purchaseResult) {

							try {
								String[] itemNamesArr = purObj[4].toString().split(",");
								String[] itemQtyArr = purObj[5].toString().split(",");
								String[] itemPriceArr = purObj[6].toString().split(",");
								int p = 0;

								for (String item : itemNamesArr) {
									if (item.trim().equals(itemName.trim())) {
										itemPurQty = itemPurQty + Double.valueOf(itemQtyArr[p].trim());
										itemPurPrice = itemPurPrice + Double.valueOf(itemPriceArr[p].trim());
										div = div + 1;
									}
									p++;
								}

							} catch (Exception e1) {

							}

						}
						itemPurPrice = itemPurPrice / div;
					}

					// end purchase data fetched

					// start debit note data fetch

					sqlString = "SELECT * FROM st_rm_txn_debitNote_master a WHERE a.dn_date IS NOT NULL";
					if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
						sqlString += " and STR_TO_DATE(a.dn_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
								+ "','%d-%m-%Y') and STR_TO_DATE(a.dn_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
								+ "','%d-%m-%Y')";
					}
					List<Object[]> debitNoteResult = session.createSQLQuery(sqlString).list();

					if (debitNoteResult != null && !debitNoteResult.isEmpty()) {
						for (Object[] debiitNoteObj : debitNoteResult) {

							try {
								String[] itemNamesArr = debiitNoteObj[4].toString().split(",");
								String[] itemQtyArr = debiitNoteObj[5].toString().split(",");
								// String[] itemPriceArr = debiitNoteObj[6].toString().split(",");
								int p = 0;
								for (String item : itemNamesArr) {
									if (item.trim().equals(itemName.trim())) {
										itemDebitQty = itemDebitQty + Double.valueOf(itemQtyArr[p].trim());
										// itemDebitPrice = itemDebitPrice+Double.valueOf(itemPriceArr[p].trim());
									}
									p++;
								}
							} catch (Exception e1) {
							}

						}
					}

					// end debit note fetched

					Double netQty = netQtyTill;

					Double netPriceVal = netQty * itemPurPrice;

					Double alterQty = Double.valueOf(alteConversiont) / Double.valueOf(alteConversionf);
					alterQty = netQty / alterQty;

					Double bulkQty = Double.valueOf(bulkConversiont) / Double.valueOf(bulkConversionf);
					bulkQty = netQty / bulkQty;

					bean.setItemName(itemName);
					bean.setItemQty("" + netQty);
					bean.setItemPrice("" + itemPurPrice);
					bean.setItemTotalValue("" + netPriceVal);
					bean.setItemUnitAlt(String.format("%.2f", alterQty) + " " + itemAltUnit);
					bean.setItemUnitBulk(String.format("%.2f", bulkQty) + " " + itemBulkUnit);
					bean.setItemUnit(obj[4].toString());
					netTotal = netTotal + netQty;
					map.put(itemName, bean);
				}
				bean = new BillsBean();
				bean.setItemName("z");
				bean.setItemQty("");
				bean.setItemPrice("TOTAL");
				bean.setItemTotalValue("" + netTotal);
				bean.setItemUnitAlt("");
				bean.setItemUnitBulk("");
				bean.setItemUnit("");
				map.put("zzz", bean);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public String getCurrStatusSalaryHoldUnhold(String empName, String date, String type) {
		try {
			Session session = HibernateSessionFactory.getSession();
			int empId = getEmployeeId(empName);
			SQLQuery query = session.createSQLQuery("SELECT * FROM st_rm_emp_salary_hold WHERE Type='" + type
					+ "' AND Date='" + date + "' AND emp_id=" + empId);
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {
				return "HOLD";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "UNHOLD";
	}

	public String getOrderNumberSuppInvoice(String salesNoVoucher) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT supp_invoice_no FROM st_rm_bill_wise_details WHERE purchase_voucher_number='"
							+ salesNoVoucher + "'");
			List<String> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {

				if (result.get(0) != null) {
					return result.get(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public boolean createBDMTeam(String teamName, String teamTarget) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"INSERT INTO crm_bdm_team_master(`team_name`,`team_target`,`team_target_pending`) VALUES('"
							+ teamName + "','" + teamTarget + "','" + teamTarget + "')");
			if (query.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<String> getAllBDMTeamsList() {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT team_name from crm_bdm_team_master");
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public String getBDMTargetAmount(String teamName) {
		String data = "0,0";
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT team_target,team_target_pending from crm_bdm_team_master WHERE team_name='"
							+ teamName + "'");
			List<Object[]> result = query.list();

			if (result != null && !result.isEmpty()) {
				for (Object[] obj : result)
					data = obj[0].toString() + "," + obj[1].toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public boolean createBDMSubTeam(String subTeamName, String teamName, String productCategory, String subTeamTarget) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			int teamId = getTeamIdByName(teamName);
			int stock_cat_id = getStockCatagoryIdByName(productCategory);
			SQLQuery query = session.createSQLQuery(
					"INSERT INTO crm_bdm_sub_team_master(`sub_team_name`,`team_id`,`stock_cat_id`,`target_amount`,`target_pending`) VALUES('"
							+ subTeamName + "'," + teamId + "," + stock_cat_id + ",'" + subTeamTarget + "','"
							+ subTeamTarget + "')");
			query.executeUpdate();

			SQLQuery _query = session
					.createSQLQuery("SELECT team_target_pending FROM crm_bdm_team_master WHERE team_id=" + teamId);
			List<String> result = _query.list();
			Double pendingAmt = Double.valueOf(result.get(0).trim());

			if (Double.valueOf(subTeamTarget.trim()) > pendingAmt)
				throw new Exception();
			pendingAmt = pendingAmt - Double.valueOf(subTeamTarget.trim());

			SQLQuery query2 = session.createSQLQuery(
					"UPDATE crm_bdm_team_master SET team_target_pending='" + pendingAmt + "' WHERE team_id=" + teamId);
			query2.executeUpdate();

			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	private int getStockCatagoryIdByName(String productCategory) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT st_ct_id FROM st_rm_stock_catagory_master WHERE stock_name='" + productCategory + "'");
			List<Integer> result = query.list();
			if (result != null && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	private int getTeamIdByName(String teamName) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT team_id FROM crm_bdm_team_master WHERE team_name='" + teamName + "'");
			List<Integer> result = query.list();
			if (result != null && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	private int getSubTeamIdByName(String teamName) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT sub_team_id FROM crm_bdm_sub_team_master WHERE sub_team_name='" + teamName + "'");
			List<Integer> result = query.list();
			if (result != null && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<String> getSubTeamList() {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT sub_team_name from crm_bdm_sub_team_master");
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public boolean assignRSMSubTam(String subTeamName, String rsmName, String rsmTarget) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			int empId = getEmployeeId(rsmName);
			int subTeamId = getSubTeamIdByName(subTeamName);
			final String ROLE = "RSM";
			String sqlString = "INSERT INTO crm_sub_team_assign_master(`emp_id`,`sub_team_id`,`role`,`target_amount`,`pending_amount`) values("
					+ empId + "," + subTeamId + ",'" + ROLE + "','" + rsmTarget + "','" + rsmTarget + "')";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();

			SQLQuery _query = session.createSQLQuery(
					"SELECT target_pending FROM crm_bdm_sub_team_master WHERE sub_team_id=" + subTeamId);
			List<String> result = _query.list();
			Double pendingAmt = Double.valueOf(result.get(0).trim());
			if (Double.valueOf(rsmTarget.trim()) > pendingAmt)
				throw new Exception();
			pendingAmt = pendingAmt - Double.valueOf(rsmTarget.trim());

			SQLQuery query2 = session.createSQLQuery("UPDATE crm_bdm_sub_team_master SET target_pending='" + pendingAmt
					+ "' WHERE sub_team_id=" + subTeamId);
			query2.executeUpdate();
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public String getBDMSubTeamTargetAmount(String teamName) {
		String data = "0,0";
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT target_amount,target_pending from crm_bdm_sub_team_master WHERE sub_team_name='" + teamName
							+ "'");
			List<Object[]> result = query.list();

			if (result != null && !result.isEmpty()) {
				for (Object[] obj : result)
					data = obj[0].toString() + "," + obj[1].toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public String getRSMTeamTargetAmount(String rsmName, String subTeamName, String role) {
		String data = "0,0";
		try {
			Session session = HibernateSessionFactory.getSession();

			int empId = getEmployeeId(rsmName);
			int subTeamId = getSubTeamIdByName(subTeamName);

			SQLQuery query = session
					.createSQLQuery("SELECT target_amount,pending_amount from crm_sub_team_assign_master WHERE emp_id="
							+ empId + " and sub_team_id=" + subTeamId + " and role='" + role + "'");
			List<Object[]> result = query.list();

			if (result != null && !result.isEmpty()) {
				for (Object[] obj : result)
					data = obj[0].toString() + "," + obj[1].toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public boolean assignTSMSubTam(String subTeamName, String rsmName, String tsmName, String tsmTarget) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			int rsmId = getEmployeeId(rsmName);
			int tsmId = getEmployeeId(tsmName);

			int subTeamId = getSubTeamIdByName(subTeamName);

			final String ROLE = "TSM";
			String sqlString = "INSERT INTO crm_sub_team_assign_master(`emp_id`,`sub_team_id`,`role`,`target_amount`,`pending_amount`,`parent_id`) values("
					+ tsmId + "," + subTeamId + ",'" + ROLE + "','" + tsmTarget + "','" + tsmTarget + "'," + rsmId
					+ ")";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();

			SQLQuery _query = session
					.createSQLQuery("SELECT target_amount FROM crm_sub_team_assign_master WHERE emp_id=" + rsmId
							+ " and sub_team_id=" + subTeamId);
			List<String> result = _query.list();
			Double pendingAmt = Double.valueOf(result.get(0).trim());
			if (Double.valueOf(tsmTarget.trim()) > pendingAmt)
				throw new Exception();
			pendingAmt = pendingAmt - Double.valueOf(tsmTarget.trim());

			SQLQuery query2 = session.createSQLQuery("UPDATE crm_sub_team_assign_master SET pending_amount='"
					+ pendingAmt + "' WHERE sub_team_id=" + subTeamId + " and emp_id=" + rsmId);
			query2.executeUpdate();
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean assignSMSubTam(String subTeamName, String tsmName, String smName, String smTarget) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			int smId = getEmployeeId(smName);
			int tsmId = getEmployeeId(tsmName);

			int subTeamId = getSubTeamIdByName(subTeamName);

			final String ROLE = "SM";
			String sqlString = "INSERT INTO crm_sub_team_assign_master(`emp_id`,`sub_team_id`,`role`,`target_amount`,`pending_amount`,`parent_id`) values("
					+ smId + "," + subTeamId + ",'" + ROLE + "','" + smTarget + "','" + smTarget + "'," + tsmId + ")";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();

			SQLQuery _query = session
					.createSQLQuery("SELECT target_amount FROM crm_sub_team_assign_master WHERE emp_id=" + tsmId
							+ " and sub_team_id=" + subTeamId);
			List<String> result = _query.list();
			Double pendingAmt = Double.valueOf(result.get(0).trim());
			if (Double.valueOf(smTarget.trim()) > pendingAmt)
				throw new Exception();
			pendingAmt = pendingAmt - Double.valueOf(smTarget.trim());

			SQLQuery query2 = session.createSQLQuery("UPDATE crm_sub_team_assign_master SET pending_amount='"
					+ pendingAmt + "' WHERE sub_team_id=" + subTeamId + " and emp_id=" + tsmId);
			query2.executeUpdate();
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean assignFASubTam(String subTeamName, String smName, String faName, String faTarget) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			int faId = getEmployeeId(faName);
			int smId = getEmployeeId(smName);

			int subTeamId = getSubTeamIdByName(subTeamName);

			final String ROLE = "SM";
			String sqlString = "INSERT INTO crm_sub_team_assign_master(`emp_id`,`sub_team_id`,`role`,`target_amount`,`pending_amount`,`parent_id`) values("
					+ faId + "," + subTeamId + ",'" + ROLE + "','" + faTarget + "','" + faTarget + "'," + smId + ")";
			SQLQuery query = session.createSQLQuery(sqlString);
			query.executeUpdate();

			SQLQuery _query = session
					.createSQLQuery("SELECT target_amount FROM crm_sub_team_assign_master WHERE emp_id=" + smId
							+ " and sub_team_id=" + subTeamId);
			List<String> result = _query.list();
			Double pendingAmt = Double.valueOf(result.get(0).trim());
			if (Double.valueOf(faTarget.trim()) > pendingAmt)
				throw new Exception();
			pendingAmt = pendingAmt - Double.valueOf(faTarget.trim());

			SQLQuery query2 = session.createSQLQuery("UPDATE crm_sub_team_assign_master SET pending_amount='"
					+ pendingAmt + "' WHERE sub_team_id=" + subTeamId + " and emp_id=" + smId);
			query2.executeUpdate();
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean assignYearlyTargetEmp(String empName, String targetYear, String target, String stockCat) {
		try {
			Session session = HibernateSessionFactory.getSession();
			int empId = getEmployeeId(empName);
			int stock_cat_id = getStockCatagoryIdByName(stockCat);
			SQLQuery query = session.createSQLQuery(
					"INSERT INTO crm_emp_bdp_year_target(`emp_id`,`emp_target`,`emp_pending_target`,`stock_cat_id`,`year`) values("
							+ empId + ",'" + target + "','" + target + "'," + stock_cat_id + ",'" + targetYear + "')");
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<String> getEmployeeNamesListByRole(String role) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT user_name from st_rm_bo_user_master um inner join st_rm_bo_user_info ui ON um.user_id=ui.user_id and ui.role='"
							+ role + "'");
			List<String> result = query.list();
			if (result != null && result.size() > 0)
				return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public String getAvgItemRateByName(String itemName) {
		Double itemPurPrice = 0.0;
		try {
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * FROM st_rm_txn_purchase_master a WHERE a.purchaseDate IS NOT NULL";

			List<Object[]> purchaseResult = session.createSQLQuery(sqlString).list();
			boolean flag = false;
			if (purchaseResult != null && !purchaseResult.isEmpty()) {

				int div = 0;
				for (Object[] purObj : purchaseResult) {

					try {
						String[] itemNamesArr = purObj[4].toString().split(",");
						String[] itemPriceArr = purObj[6].toString().split(",");
						int p = 0;

						for (String item : itemNamesArr) {
							if (item.trim().equals(itemName.trim())) {
								itemPurPrice = itemPurPrice + Double.valueOf(itemPriceArr[p].trim());
								div = div + 1;
								flag = true;
							}
							p++;
						}

					} catch (Exception e1) {

					}

				}
				if (flag)
					itemPurPrice = itemPurPrice / div;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.format("%.2f", itemPurPrice);
	}

	public boolean storeDefinedLocation(String sourceLoc, String targetLoc, String dynamicList) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String appender = " values";
			String[] splitLocations = dynamicList.split(",");
			for (String s : splitLocations) {
				if (!s.trim().isEmpty()) {
					appender += "('" + sourceLoc.toLowerCase() + "','" + targetLoc.toLowerCase() + "','"
							+ s.trim().toLowerCase() + "'),";
				}
			}
			appender = appender.substring(0, appender.length() - 1);
			SQLQuery query = session.createSQLQuery(
					"INSERT INTO crm_visit_locations_master(`source`,`target`,`locations`) " + appender + "");
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean storeDefinedRetailer(String retName, String retContact, String retAddress, String location,
			String firmName, String tehsil, String district) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"INSERT INTO crm_retailer_master(`retailer_name`,`retailer_mobile`,`retailer_address`,`retailer_location`,`firm_name`,`tehsil`,`district`) values('"
							+ retName + "','" + retContact + "','" + retAddress + "','" + location + "','" + firmName
							+ "','" + tehsil + "','" + district + "')");
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean uploadEmpSalary(String path, int empId, String monthYear) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("INSERT INTO crm_emp_salary_file(`emp_id`,`emp_month`,`filePath`) values(" + empId
							+ ",'" + monthYear + "','" + path + "')");
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean uploadBrochureFile(String path, String fileName, int itemId) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("DELETE FROM crm_item_android_pdf WHERE item_id=" + itemId);
			query.executeUpdate();
			SQLQuery query1 = session
					.createSQLQuery("INSERT INTO crm_item_android_pdf(`item_id`,`pdf_name`,`pdf_url`) values(" + itemId
							+ ",'" + fileName + "','" + path + "')");
			query1.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public List<String> getLocationListByColumnType(String COLUMN_NAME) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT DISTINCT " + COLUMN_NAME + " from crm_visit_locations_master");
			List<String> result = query.list();
			if (result != null && !result.isEmpty())
				return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public Map<Integer, String> getLocationData(String sourceLoc, String targetLoc) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("SELECT DISTINCT * FROM `crm_visit_locations_master` WHERE source='"
					+ sourceLoc + "' AND target ='" + targetLoc + "'");
			List<Object[]> result = query.list();
			if (result != null && result.size() > 0) {
				for (Object[] obj : result) {

					map.put((int) obj[0], obj[3].toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public void removeLocation(String sourceLoc, String targetLoc, String dynamicList) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("DELETE FROM crm_visit_locations_master WHERE source='" + sourceLoc
					+ "' and target='" + targetLoc + "' and locations='" + dynamicList + "'");
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Map<Integer, EmpDistributorBean> getEmpWiseDistributorReport(String employeeName) {
		Map<Integer, EmpDistributorBean> response = new HashMap<>();
		try {
			EmpDistributorBean bean = null;
			Session session = HibernateSessionFactory.getSession();

			int empId = getEmployeeId(employeeName);
			SQLQuery query = session
					.createSQLQuery("SELECT ledger_id from bo_um_ledger_user_mapping WHERE emp_id=" + empId);
			List<Integer> result = query.list();
			if (result != null && !result.isEmpty()) {
				int count = 1;
				for (Integer ledgerId : result) {

					query = session.createSQLQuery("SELECT * FROM bo_um_ledger_details WHERE ledgerId=" + ledgerId);
					List<Object[]> data = query.list();
					if (data != null && !data.isEmpty()) {

						for (Object[] obj : data) {
							String fName = obj[3] != null ? obj[3].toString() : "";
							String pName = obj[2] != null ? obj[2].toString() : "";
							String contact = obj[10] != null ? obj[10].toString() : "";
							String address = obj[5] != null ? obj[5].toString() : "";
							bean = new EmpDistributorBean(fName, pName, contact, address);

							response.put(count, bean);
							count++;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public List<String> getAllLocations() {
		try {

			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT DISTINCT source FROM crm_visit_locations_master UNION ALL SELECT DISTINCT target FROM crm_visit_locations_master UNION ALL SELECT DISTINCT locations FROM crm_visit_locations_master");
			List<String> result = query.list();
			if (result != null && !result.isEmpty()) {
				Collections.sort(result);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public List<String> getRetailerNamesList() {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery("select firm_name from crm_retailer_master");
			List<String> result = query.list();
			if (result != null && !result.isEmpty()) {
				Collections.sort(result);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public boolean isSuperCashBill(String salesNoVoucher) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session
					.createSQLQuery("SELECT superCashBill FROM st_rm_bill_wise_details_sale WHERE sale_voucher_number='"
							+ salesNoVoucher + "'");
			List<String> result = query.list();
			if (result != null && !result.isEmpty()) {
				if (result.get(0) != null && !result.get(0).equalsIgnoreCase(null)
						&& !result.get(0).equalsIgnoreCase("no") && !result.get(0).equalsIgnoreCase("null")) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean getIsSuperCashSaleOrder(String orderNo) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT is_super_cash FROM st_rm_txn_sales_master_emp WHERE salesId=" + orderNo + "");
			List<String> result = query.list();
			if (result != null && !result.isEmpty()) {
				if (result.get(0) != null && !result.get(0).equalsIgnoreCase(null)
						&& !result.get(0).equalsIgnoreCase("no") && !result.get(0).equalsIgnoreCase("null")) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<String> getAllLedgerDistrict() {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT DISTINCT district FROM `bo_um_ledger_details` WHERE  NULLIF( TRIM(district) , '') IS NOT NULL");
			List<String> result = query.list();
			if (result != null && !result.isEmpty()) {
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public Map<String, BillsBean> getSuperCashReportResult(String employeeName, String districtName, String fromDate,
			String toDate) {

		try {
			BillsBean bean = null;
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
			c.setTimeZone(tz);
			String date = sdf.format(today);

			Map<String, BillsBean> map = new HashMap<>();
			Session session = HibernateSessionFactory.getSession();
			String sqlString = "SELECT * FROM `st_rm_txn_sales_master` a INNER JOIN `st_rm_bill_wise_details_sale` b ON b.sale_voucher_number  = a.voucher_numbering AND b.superCashBill LIKE '%yes%'";
			if (employeeName != null && !employeeName.isEmpty() && !employeeName.contains("-1")) {
				int empId = getEmployeeId(employeeName);
				sqlString += " and a.emp_id=" + empId;
			}
			if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
				sqlString += " and STR_TO_DATE(a.saleDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
						+ "','%d-%m-%Y') and STR_TO_DATE(a.saleDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
						+ "','%d-%m-%Y')";
			}

			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty()) {
				int c1 = 1;
				for (Object[] obj : result) {

					int creditPeriod = 7;
					/*
					 * sqlString = "SELECT credit_period FROM st_rm_credit_limit WHERE ledger_id=" +
					 * (int) obj[31]; query = session.createSQLQuery(sqlString); List<Integer>
					 * creditPeriodList = query.list(); if (creditPeriodList != null &&
					 * !creditPeriodList.isEmpty() && creditPeriodList.size() > 0 &&
					 * !creditPeriodList.get(0).equals("-1")) creditPeriod =
					 * creditPeriodList.get(0);
					 */

					bean = new BillsBean();
					bean.setLedgerName(obj[1].toString());
					bean.setBillDate(obj[17].toString());
					bean.setBillVoucherNo(obj[10].toString());
					bean.setBillAmount(obj[32].toString());
					bean.setActualBillAmount(obj[9].toString());
					bean.setBillUsed(obj[33].toString());
					c.setTime(sdf.parse(obj[17].toString()));
					c.add(Calendar.DAY_OF_MONTH, creditPeriod);
					bean.setBillDueDate(sdf.format(c.getTime()));

					SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
					Date _todayDate = df.parse(date);
					Date _Billdate = df.parse(obj[17].toString());
					df.applyPattern("yyyy-MM-dd");
					String _todayDate1 = df.format(_todayDate);
					String _Billdate1 = df.format(_Billdate);
					LocalDateTime _dateToday = LocalDateTime.parse(_todayDate1);
					LocalDateTime _dateBill = LocalDateTime.parse(_Billdate1);
					Days days = Days.daysBetween(_dateBill, _dateToday);
					bean.setDueDays("" + days.getDays());

					map.put("" + c1, bean);
					c1++;
				}
				return map;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public JSONObject scheduleCheckForMismatchBalance() {
		try {
			org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GameLobbyController.class.getName());
			Session session = HibernateSessionFactory.getSession();
			Map<Integer, Double> saleBillBalMap = new HashMap<>();
			SQLQuery query = session.createSQLQuery("SELECT DISTINCT party_id FROM st_rm_bill_wise_details_sale");
			List<Integer> result = query.list();
			if (result != null && !result.isEmpty()) {

				Double debitSum = 0.0;
				Double creditSum = 0.0;
				Double partyBal = 0.0;
				for (Integer id : result) {
					logger.info(":::Party Id is " + id + " and name is " + getPartyNameById(id));

					debitSum = 0.0;
					partyBal = 0.0;
					creditSum = 0.0;
					query = session.createSQLQuery(
							"SELECT SUM(balance) from st_rm_bill_wise_details_sale WHERE blnc_type='Dr' and is_used='No' and party_id="
									+ id);
					List<Double> DrSum = query.list();
					if (DrSum != null && DrSum.get(0) != null && !DrSum.isEmpty()) {
						debitSum = DrSum.get(0);
					}
					query = session.createSQLQuery(
							"SELECT SUM(balance) from st_rm_bill_wise_details_sale WHERE blnc_type='Cr' and is_used='No' and party_id="
									+ id);
					List<Double> CrSum = query.list();
					if (CrSum != null && CrSum.get(0) != null && !CrSum.isEmpty()) {
						creditSum = CrSum.get(0);
					}
					partyBal = debitSum - creditSum;
					if (partyBal < 0) {
						partyBal = partyBal * (-1);
					}
					saleBillBalMap.put(id, partyBal);

				}

			}
			Map<Integer, String> finalMap = new HashMap<>();
			int c = 1;
			for (Entry<Integer, Double> map : saleBillBalMap.entrySet()) {

				SQLQuery sqlString = session.createSQLQuery(
						"SELECT balance from st_rm_purchase_party_master_balance where party_id=" + map.getKey() + "");
				List<String> balanceData = sqlString.list();
				Double partyDBBal = 0.0;
				if (balanceData != null && !balanceData.isEmpty()) {

					for (String val : balanceData) {
						partyDBBal = Double.valueOf(val);
					}

				}
				String temp1 = String.format("%.2f", Double.valueOf(map.getValue()));
				String temp2 = String.format("%.2f", partyDBBal);
				if (!temp1.equals(temp2)) {
					finalMap.put(map.getKey(),
							c + ".) Balance Mismatched for party " + getPartyNameById(map.getKey()) + ". (JSC-"
									+ map.getKey() + ") Bill balance is " + map.getValue() + " and balance is "
									+ partyDBBal + "<br>");
					c++;
				}
			}
			JSONObject jsonObject = new JSONObject();
			for (Entry<Integer, String> map : finalMap.entrySet()) {
				jsonObject.put("" + map.getKey(), map.getValue());

			}
			return jsonObject;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getDistrictFromState(String stateName) {
		try {
			Session session = HibernateSessionFactory.getSession();

			SQLQuery query = session.createSQLQuery(
					"select state_code from st_gen_state_master WHERE name='" + stateName + "' and country_code='IN'");
			List<String> result = query.list();
			String stateCode = result.get(0);
			query = session.createSQLQuery("SELECT city_name from st_gen_city_master where state_code='" + stateCode
					+ "' and country_code='IN' order by city_name ASC");
			List<String> cityResult = query.list();
			if (cityResult != null && !cityResult.isEmpty()) {
				String data = "";
				for (String str : cityResult) {
					data = data + str + ";";
				}
				data = data.substring(0, data.length() - 1);
				return data;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	public Map<String, ProfitLossBean> getProfitLossReportResult(String ledgerName, String empName, String itemName,
			String stateName, String districtName, String fromDate, String toDate, String filterType) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = null;
			Map<String, ProfitLossBean> resultMap = new HashMap<>();
			String sqlSaleString = "SELECT * FROM `st_rm_txn_sales_master` WHERE saleDate IS NOT NULL ";
			String journalString = "SELECT * FROM st_rm_txn_journal_master WHERE journal_date IS NOT NULL ";
			String creditNoteString = "";
			Double partyInterestAmount = 0.0;
			Double journalDebitAmt = 0.0;
			Double journalCreditAmt = 0.0;

			if (filterType.equals("Ledger Wise")) {

				sqlSaleString += " AND party_acc_name = '" + ledgerName + "' ";
				creditNoteString += " AND party_acc_name = '" + ledgerName + "' ";
				journalString += " AND particulars like '%" + ledgerName + "%'";

				if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {

					sqlSaleString += " AND STR_TO_DATE(saleDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
							+ "','%d-%m-%Y') and STR_TO_DATE(saleDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
							+ "','%d-%m-%Y')";
					creditNoteString += " AND STR_TO_DATE(cn_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
							+ "','%d-%m-%Y') and STR_TO_DATE(cn_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
							+ "','%d-%m-%Y')";

					journalString += " AND STR_TO_DATE(journal_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
							+ "','%d-%m-%Y') and STR_TO_DATE(journal_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
							+ "','%d-%m-%Y')";

					query = session.createSQLQuery(
							"SELECT SUM(tax_blnc) FROM st_rm_bill_balances_scheduling_report WHERE STR_TO_DATE(scheduling_date,'%d-%m-%Y') >= STR_TO_DATE('"
									+ fromDate
									+ "','%d-%m-%Y') AND STR_TO_DATE(scheduling_date,'%d-%m-%Y')<= STR_TO_DATE('"
									+ toDate + "','%d-%m-%Y') AND party_id=" + getLedgerIdByName(ledgerName));
					List<Double> interestResult = query.list();

					if (interestResult != null && !interestResult.isEmpty() && interestResult.get(0) != null
							&& !interestResult.get(0).equals(null)) {

						partyInterestAmount = interestResult.get(0);

					}

				} else {
					query = session.createSQLQuery(
							"SELECT SUM(tax_blnc) FROM st_rm_bill_balances_scheduling_report WHERE party_id="
									+ getLedgerIdByName(ledgerName));
					List<Double> interestResult = query.list();

					if (interestResult != null && !interestResult.isEmpty() && interestResult.get(0) != null
							&& !interestResult.get(0).equals(null)) {

						partyInterestAmount = interestResult.get(0);

					}

				}

			}

			else if (filterType.equals("Employee Wise")) {
				sqlSaleString += " AND emp_id =" + getEmployeeId(empName);
				creditNoteString += " AND emp_id =" + getEmployeeId(empName);
				journalString += " AND empId=" + getEmployeeId(empName);

				if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {

					sqlSaleString += " AND STR_TO_DATE(saleDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
							+ "','%d-%m-%Y') and STR_TO_DATE(saleDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
							+ "','%d-%m-%Y')";
					creditNoteString += " AND STR_TO_DATE(cn_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
							+ "','%d-%m-%Y') and STR_TO_DATE(cn_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
							+ "','%d-%m-%Y')";

					journalString += " AND STR_TO_DATE(journal_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
							+ "','%d-%m-%Y') and STR_TO_DATE(journal_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
							+ "','%d-%m-%Y')";

					query = session.createSQLQuery(
							"SELECT SUM(tax_blnc) FROM st_rm_bill_balances_scheduling_report WHERE STR_TO_DATE(scheduling_date,'%d-%m-%Y') >= STR_TO_DATE('"
									+ fromDate
									+ "','%d-%m-%Y') AND STR_TO_DATE(scheduling_date,'%d-%m-%Y')<= STR_TO_DATE('"
									+ toDate + "','%d-%m-%Y') ");
					List<Double> interestResult = query.list();

					if (interestResult != null && !interestResult.isEmpty() && interestResult.get(0) != null
							&& !interestResult.get(0).equals(null)) {

						partyInterestAmount = interestResult.get(0);

					}

				} else {

					query = session.createSQLQuery("SELECT SUM(tax_blnc) FROM st_rm_bill_balances_scheduling_report");
					List<Double> interestResult = query.list();

					if (interestResult != null && !interestResult.isEmpty() && interestResult.get(0) != null
							&& !interestResult.get(0).equals(null)) {

						partyInterestAmount = interestResult.get(0);

					}
				}

			}

			else if (filterType.equals("State Wise")) {

				query = session.createSQLQuery(
						"SELECT ledger_name from st_rm_acc_ledger_master a INNER JOIN bo_um_ledger_details b ON a.ledger_id = b.ledgerId and b.state= '"
								+ stateName + "'");
				List<String> ledgerResult = query.list();
				List<String> ledgerNames = new ArrayList<>();
				String appenderInClause = "";
				String journalLikeAppender = "";
				if (ledgerResult != null && !ledgerResult.isEmpty()) {

					for (String s : ledgerResult) {
						appenderInClause = appenderInClause + "\'" + s + "\'" + ",";
						journalLikeAppender = journalLikeAppender + "particulars like '%" + s + "%'" + " or ";
					}

					if (appenderInClause.length() > 1)
						appenderInClause = appenderInClause.substring(0, appenderInClause.length() - 1);

					if (journalString.length() > 1)
						journalLikeAppender = journalLikeAppender.substring(0, journalLikeAppender.length() - 3);
				}

				if (journalString.length() > 1)
					journalString += " AND " + journalLikeAppender;
				if (appenderInClause.length() > 1)
					sqlSaleString += " AND party_acc_name IN (" + appenderInClause + ")";
				if (appenderInClause.length() > 1)
					creditNoteString += " AND party_acc_name IN (" + appenderInClause + ")";

				if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {

					sqlSaleString += " AND STR_TO_DATE(saleDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
							+ "','%d-%m-%Y') and STR_TO_DATE(saleDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
							+ "','%d-%m-%Y')";
					creditNoteString += " AND STR_TO_DATE(cn_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
							+ "','%d-%m-%Y') and STR_TO_DATE(cn_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
							+ "','%d-%m-%Y')";

					journalString += " AND STR_TO_DATE(journal_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
							+ "','%d-%m-%Y') and STR_TO_DATE(journal_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
							+ "','%d-%m-%Y')";

					query = session.createSQLQuery(
							"SELECT SUM(tax_blnc) FROM st_rm_bill_balances_scheduling_report a inner join bo_um_ledger_details b ON a.party_id=b.ledgerId AND b.state='"
									+ stateName + "' STR_TO_DATE(scheduling_date,'%d-%m-%Y') >= STR_TO_DATE('"
									+ fromDate
									+ "','%d-%m-%Y') AND STR_TO_DATE(scheduling_date,'%d-%m-%Y')<= STR_TO_DATE('"
									+ toDate + "','%d-%m-%Y') ");
					List<Double> interestResult = query.list();

					if (interestResult != null && !interestResult.isEmpty() && interestResult.get(0) != null
							&& !interestResult.get(0).equals(null)) {

						partyInterestAmount = interestResult.get(0);

					}

				} else {

					query = session.createSQLQuery("SELECT SUM(tax_blnc) FROM st_rm_bill_balances_scheduling_report");
					List<Double> interestResult = query.list();

					if (interestResult != null && !interestResult.isEmpty() && interestResult.get(0) != null
							&& !interestResult.get(0).equals(null)) {

						partyInterestAmount = interestResult.get(0);

					}

				}

			}

			else if (filterType.equals("District Wise")) {

				query = session.createSQLQuery(
						"SELECT ledger_name from st_rm_acc_ledger_master a INNER JOIN bo_um_ledger_details b ON a.ledger_id = b.ledgerId and b.district= '"
								+ districtName + "'");
				List<String> ledgerResult = query.list();
				List<String> ledgerNames = new ArrayList<>();
				String appenderInClause = "";
				String journalLikeAppender = "";
				if (ledgerResult != null && !ledgerResult.isEmpty()) {

					for (String s : ledgerResult) {
						appenderInClause = appenderInClause + "\'" + s + "\'" + ",";
						journalLikeAppender = journalLikeAppender + "particulars like '%" + s + "%'" + " or ";
					}

					if (appenderInClause.length() > 1)
						appenderInClause = appenderInClause.substring(0, appenderInClause.length() - 1);

					if (journalString.length() > 1)
						journalLikeAppender = journalLikeAppender.substring(0, journalLikeAppender.length() - 3);
				}

				if (journalString.length() > 1)
					journalString += " AND " + journalLikeAppender;
				if (appenderInClause.length() > 1)
					sqlSaleString += " AND party_acc_name IN (" + appenderInClause + ")";
				if (appenderInClause.length() > 1)
					creditNoteString += " AND party_acc_name IN (" + appenderInClause + ")";

				if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {

					sqlSaleString += " AND STR_TO_DATE(saleDate,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
							+ "','%d-%m-%Y') and STR_TO_DATE(saleDate,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
							+ "','%d-%m-%Y')";
					creditNoteString += " AND STR_TO_DATE(cn_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
							+ "','%d-%m-%Y') and STR_TO_DATE(cn_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
							+ "','%d-%m-%Y')";

					journalString += " AND STR_TO_DATE(journal_date,'%d-%m-%Y') >= STR_TO_DATE('" + fromDate
							+ "','%d-%m-%Y') and STR_TO_DATE(journal_date,'%d-%m-%Y') <= STR_TO_DATE('" + toDate
							+ "','%d-%m-%Y')";

					query = session.createSQLQuery(
							"SELECT SUM(tax_blnc) FROM st_rm_bill_balances_scheduling_report a inner join bo_um_ledger_details b ON a.party_id=b.ledgerId AND b.district='"
									+ districtName + "' STR_TO_DATE(scheduling_date,'%d-%m-%Y') >= STR_TO_DATE('"
									+ fromDate
									+ "','%d-%m-%Y') AND STR_TO_DATE(scheduling_date,'%d-%m-%Y')<= STR_TO_DATE('"
									+ toDate + "','%d-%m-%Y') ");
					List<Double> interestResult = query.list();

					if (interestResult != null && !interestResult.isEmpty() && interestResult.get(0) != null
							&& !interestResult.get(0).equals(null)) {

						partyInterestAmount = interestResult.get(0);

					}

				} else {

					query = session.createSQLQuery("SELECT SUM(tax_blnc) FROM st_rm_bill_balances_scheduling_report");
					List<Double> interestResult = query.list();

					if (interestResult != null && !interestResult.isEmpty() && interestResult.get(0) != null
							&& !interestResult.get(0).equals(null)) {

						partyInterestAmount = interestResult.get(0);

					}

				}

			}

			query = session.createSQLQuery(journalString);
			List<Object[]> journalResult = query.list();
			if (journalResult != null && !journalResult.isEmpty()) {

				for (Object[] jouObj : journalResult) {

					String[] DrCrArr = jouObj[2].toString().split(",");
					String[] particularsArr = jouObj[3].toString().split(",");
					String[] debAmtArr = jouObj[4].toString().split(",");
					String[] credAmtArr = jouObj[5].toString().split(",");
					int jcounter = 0;
					for (String DrCr : DrCrArr) {

						if (DrCr.trim().equals("Dr"))
							journalDebitAmt = journalDebitAmt + Double.valueOf(debAmtArr[jcounter].trim());
						else if (DrCr.trim().equals("Cr"))
							journalCreditAmt = journalCreditAmt + Double.valueOf(credAmtArr[jcounter].trim());

						jcounter++;
					}

				}
			}

			Double netSaleAmount = 0.0;
			Double netCreditNoteAmount = 0.0;

			Map<String, SaleBean> saleQtyMap = new HashMap<>();
			Map<String, Double> creditNoteQtyMap = new HashMap<>();

			Double avgSalePrice = 0.0;
			Double avgcreditNotePrice = 0.0;
			Double avgPurchasePrice = 0.0;

			query = session.createSQLQuery(sqlSaleString);
			List<Object[]> saleResult = query.list();
			Set<String> itemSet = new HashSet<>();
			if (saleResult != null && !saleResult.isEmpty()) {
				int saleItemRepeat = 0;

				for (Object[] obj : saleResult) {
					String itemNames = obj[4].toString();
					String[] itemNamesArr = itemNames.split(",");
					String[] itemSaleQty = obj[5].toString().split(",");
					String[] itemSalePrice = obj[6].toString().split(",");
					String[] itemSaleAmount = obj[7].toString().split(",");

					int saleCounter = 0;

					for (String name : itemNamesArr) {
						SaleBean bean = null;
						if (!name.trim().equals("-1")) {

							if (saleQtyMap.get(name.trim()) == null) {
								bean = new SaleBean();

								Double gst = getGSTByItemName(name.trim());

								bean.setGstPercentage(gst);
								bean.setItemRepeat(1);
								bean.setPrice(Double.valueOf(itemSalePrice[saleCounter].trim()));
								bean.setQty(Double.valueOf(itemSaleQty[saleCounter].trim()));
								bean.setSaleAmount(Double.valueOf(itemSaleAmount[saleCounter].trim()));
								bean.setPurchaseRepeat(0);
								bean.setPurchasePrice(0.0);
								bean.setCreditNotePrice(0.0);
								bean.setCreditNoteQty(0.0);
								bean.setCreditNoteRepeat(0);
								bean.setCreditNoteAmount(0.0);
								saleQtyMap.put(name.trim(), bean);

							} else {

								bean = saleQtyMap.get(name.trim());

								Double gst = getGSTByItemName(name.trim());
								bean.setGstPercentage(gst);

								int repeat = bean.getItemRepeat();
								repeat = repeat + 1;
								bean.setItemRepeat(repeat);
								Double qty = bean.getQty();
								qty = qty + Double.valueOf(itemSaleQty[saleCounter].trim());
								bean.setQty(qty);
								Double pric = bean.getPrice();
								pric = pric + Double.valueOf(itemSalePrice[saleCounter].trim());
								bean.setPrice(pric);
								Double saleAmt = bean.getSaleAmount();
								saleAmt = saleAmt + Double.valueOf(itemSaleAmount[saleCounter].trim());
								bean.setSaleAmount(saleAmt);
								saleQtyMap.put(name.trim(), bean);
							}

						}
						saleCounter++;
					}

				}

			}
			for (Entry<String, SaleBean> map : saleQtyMap.entrySet()) {

				SaleBean bean = null;
				query = session.createSQLQuery(
						"SELECT * FROM st_rm_txn_purchase_master WHERE name_item like '%" + map.getKey() + "%'");
				List<Object[]> purResult = query.list();
				if (purResult != null && !purResult.isEmpty()) {

					for (Object[] pobj : purResult) {

						String[] pitemNameArr = pobj[4].toString().split(",");
						String[] pitemPriceArr = pobj[6].toString().split(",");
						int pcounter = 0;
						for (String pitemName : pitemNameArr) {

							if (pitemName.trim().equals(map.getKey())) {
								bean = saleQtyMap.get(pitemName.trim());
								int prepeat = bean.getPurchaseRepeat();
								prepeat = prepeat + 1;
								bean.setPurchaseRepeat(prepeat);
								Double pprice = bean.getPurchasePrice();
								pprice = pprice + Double.valueOf(pitemPriceArr[pcounter].trim());
								bean.setPurchasePrice(pprice);
								saleQtyMap.put(pitemName.trim(), bean);
							}
							pcounter++;
						}
					}
				} else {
					bean = saleQtyMap.get(map.getKey());
					bean.setPurchaseRepeat(1);
					bean.setPurchasePrice(1.0);
					saleQtyMap.put(map.getKey(), bean);

				}

				query = session.createSQLQuery("SELECT * FROM st_rm_txn_creditNote_master WHERE name_item like '%"
						+ map.getKey() + "%' " + creditNoteString);
				List<Object[]> creResult = query.list();
				if (creResult != null && !creResult.isEmpty()) {

					for (Object[] cobj : creResult) {

						String[] citemNameArr = cobj[4].toString().split(",");
						String[] citemPriceArr = cobj[6].toString().split(",");
						String[] citemQtyArr = cobj[5].toString().split(",");
						String[] citemAmountArr = cobj[7].toString().split(",");

						int ccounter = 0;
						for (String citemName : citemNameArr) {

							if (citemName.trim().equals(map.getKey())) {
								bean = saleQtyMap.get(citemName.trim());
								int crepeat = bean.getCreditNoteRepeat();
								crepeat = crepeat + 1;
								bean.setCreditNoteRepeat(crepeat);

								Double cQty = bean.getCreditNoteQty();
								cQty = cQty + Double.valueOf(citemQtyArr[ccounter].trim());
								bean.setCreditNoteQty(cQty);

								Double cprice = bean.getCreditNotePrice();
								cprice = cprice + Double.valueOf(citemPriceArr[ccounter].trim());
								bean.setCreditNotePrice(cprice);
								Double credAmt = bean.getCreditNoteAmount();
								credAmt = credAmt + Double.valueOf(citemAmountArr[ccounter].trim());
								bean.setCreditNoteAmount(credAmt);
								saleQtyMap.put(citemName.trim(), bean);
							}
							ccounter++;
						}
					}
				} else {
					bean = saleQtyMap.get(map.getKey());
					bean.setCreditNoteQty(0.0);
					bean.setCreditNotePrice(0.0);
					bean.setCreditNoteRepeat(0);
					bean.setCreditNoteAmount(0.0);
					saleQtyMap.put(map.getKey(), bean);

				}

			}

			Double netSaleValue = 0.0;
			Double netCreditNoteValue = 0.0;
			Double netPurchaseValue = 0.0;

			for (Entry<String, SaleBean> map : saleQtyMap.entrySet()) {

				// int saleRepeat = map.getValue().getItemRepeat();
				// Double salePrice = map.getValue().getPrice();
				Double saleQty = map.getValue().getQty();
				// salePrice = salePrice / saleRepeat;
				// Double salePMulQty = salePrice*saleQty;
				//Double gstAmountOnSale = (map.getValue().getSaleAmount() * map.getValue().getGstPercentage()) / 100;
				netSaleValue = netSaleValue + map.getValue().getSaleAmount();

				// int creditNoteRepeat = map.getValue().getCreditNoteRepeat();
				// Double creditNotePrice = map.getValue().getCreditNotePrice();
				// Double creditNoteQty = map.getValue().getCreditNoteQty();
				// creditNotePrice = creditNotePrice / creditNoteRepeat;
				// Double creditMulQty = creditNotePrice*creditNoteQty;
				Double gstAmountOnCreditNote = (map.getValue().getCreditNoteAmount()
						* map.getValue().getGstPercentage()) / 100;
				// if(!creditNotePrice.isNaN())
				netCreditNoteValue = netCreditNoteValue + map.getValue().getCreditNoteAmount() + gstAmountOnCreditNote;

				int purchaseRepeat = map.getValue().getPurchaseRepeat();
				Double purchasePrice = map.getValue().getPurchasePrice();
				purchasePrice = purchasePrice / purchaseRepeat;

				Double purchMulQty = saleQty * purchasePrice;

				Double gstAmountOnpurch = (purchMulQty * map.getValue().getGstPercentage()) / 100;

				if (!purchasePrice.isNaN())
					netPurchaseValue = netPurchaseValue + purchMulQty + gstAmountOnpurch;

			}

			ProfitLossBean profitLossBean = new ProfitLossBean();
			profitLossBean.setTotalSaleValue(String.format("%.2f", netSaleValue));
			profitLossBean.setTotalPurchaseValue(String.format("%.2f", netPurchaseValue));
			profitLossBean.setCreditNoteValue(String.format("%.2f", netCreditNoteValue));
			netSaleValue = netSaleValue - netCreditNoteValue - netPurchaseValue;
			netSaleValue = netSaleValue + journalDebitAmt + partyInterestAmount;
			Double finalValue = netSaleValue - journalCreditAmt;
			if (netSaleValue < 0) {
				netSaleValue = netSaleValue * (-1);
				profitLossBean.setNetLossValue(String.format("%.2f", netSaleValue));
				profitLossBean.setNetProfitValue("0.0");
			} else {
				profitLossBean.setNetProfitValue(String.format("%.2f", netSaleValue));
				profitLossBean.setNetLossValue("0.0");
			}
			if (finalValue < 0) {
				finalValue = finalValue * (-1);
				profitLossBean.setFinalLossValue(String.format("%.2f", finalValue));
				profitLossBean.setFinalProfitValue("0.0");
			} else {
				profitLossBean.setFinalLossValue("0.0");
				profitLossBean.setFinalProfitValue(String.format("%.2f", finalValue));
			}
			profitLossBean.setTotalExpense("0.0");

			resultMap.put("result", profitLossBean);
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, FrightReportBean> getFrightReport(String fromDate, String toDate, String godownName) {
		try {
			Map<String, FrightReportBean> map = new HashMap<>();
			FrightReportBean bean = null;
			Session session = HibernateSessionFactory.getSession();
			SQLQuery query = null;
			
			String sqlString="select a.item_godown,a.voucher_numbering,a.saleDate,b.transport_frieght,b.local_frieght,b.load_unload_charge from `st_rm_txn_sales_master` a inner join `st_rm_txn_sales_master_emp_others`  b on a.voucher_numbering = b.txn_sale_voucher";;
			String sqlCreditString = "SELECT a.godown,a.voucher_numbering,a.cn_date,b.transport_frieght,b.local_frieght,b.load_unload_charge FROM `st_rm_txn_creditNote_master` a INNER JOIN `st_rm_txn_credit_master_emp_others`  b ON a.voucher_numbering = b.txn_credit_note_voucher";
			if(fromDate!=null && toDate!=null && !toDate.isEmpty() && !fromDate.isEmpty()) {
				sqlString+=" AND STR_TO_DATE(a.saleDate,'%d-%m-%Y')>=STR_TO_DATE('"+fromDate+"','%d-%m-%Y') AND STR_TO_DATE(a.saleDate,'%d-%m-%Y')<=STR_TO_DATE('"+toDate+"','%d-%m-%Y')";
				sqlCreditString+=" AND STR_TO_DATE(a.cn_date,'%d-%m-%Y')>=STR_TO_DATE('"+fromDate+"','%d-%m-%Y') AND STR_TO_DATE(a.cn_date,'%d-%m-%Y')<=STR_TO_DATE('"+toDate+"','%d-%m-%Y')";
			}
			if(godownName!=null && !godownName.isEmpty() && !godownName.equals("-1")) {
				
				sqlString+=" AND a.item_godown like '%"+godownName+"%'";
				sqlCreditString+=" AND a.godown like '%"+godownName+"%'";
			}
			sqlString+=" ORDER BY STR_TO_DATE(a.saleDate,'%d-%m-%Y') ASC";
			sqlCreditString+=" ORDER BY STR_TO_DATE(a.cn_date,'%d-%m-%Y') ASC";
			
			query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			int c = 0;
			if(result!=null && !result.isEmpty()) {
					
				for(Object[] obj:result) {
					bean = new FrightReportBean();
					bean.setBillVoucherNumber(obj[1].toString());
					bean.setDate(obj[2].toString());
					String tf = obj[3]!=null?obj[3].toString():"0.0";
					if(tf.trim().isEmpty())
						tf = "0.0";
					bean.setTransportFright(tf);
					String lf  = obj[4]!=null?obj[4].toString():"0.0";
					if(lf.trim().isEmpty())
						lf = "0.0";
					
					bean.setLocalFright(lf);
					String loadFright = obj[5]!=null?obj[5].toString():"0.0";
					if(loadFright.trim().isEmpty())
						loadFright = "0.0";
					else {
						loadFright = loadFright.split(",")[0];
						if(loadFright.equals(null) || loadFright.equals("null"))
							loadFright = "0.0";
						
					}
					
					String unloadFright = obj[5]!=null?obj[5].toString():"0.0";
					if(unloadFright.trim().isEmpty())
						unloadFright = "0.0";
					else {
						try {
							unloadFright = unloadFright.split(",")[1];
							unloadFright = unloadFright.trim();
							if(unloadFright.equals(null) || unloadFright.equals("null"))
								unloadFright = "0.0";
						}catch(Exception p) {
							unloadFright = "0.0";
							
						}
						
						
					}
					bean.setLoadFright(loadFright);
					bean.setUnloadFright(unloadFright);
					map.put(""+c, bean);
					c++;
				}
				
			}
			
			c++;
			query = session.createSQLQuery(sqlCreditString);
			List<Object[]> result1 = query.list();
			if(result1!=null && !result1.isEmpty()) {
					
				for(Object[] obj:result1) {
					bean = new FrightReportBean();
					bean.setBillVoucherNumber(obj[1].toString());
					bean.setDate(obj[2].toString());
					String tf = obj[3]!=null?obj[3].toString():"0.0";
					if(tf.trim().isEmpty())
						tf = "0.0";
					bean.setTransportFright(tf);
					String lf  = obj[4]!=null?obj[4].toString():"0.0";
					if(lf.trim().isEmpty())
						lf = "0.0";
					
					bean.setLocalFright(lf);
					String loadFright = obj[5]!=null?obj[5].toString():"0.0";
					if(loadFright.trim().isEmpty())
						loadFright = "0.0";
					else {
						loadFright = loadFright.split(",")[0];
						if(loadFright.equals(null) || loadFright.equals("null"))
							loadFright = "0.0";
						
					}
					
					String unloadFright = obj[5]!=null?obj[5].toString():"0.0";
					if(unloadFright.trim().isEmpty())
						unloadFright = "0.0";
					else {
						try {
							unloadFright = unloadFright.split(",")[1];
							unloadFright = unloadFright.trim();
							if(unloadFright.equals(null) || unloadFright.equals("null"))
								unloadFright = "0.0";
						}catch(Exception p) {
							unloadFright = "0.0";
							
						}
						
						
					}
					bean.setLoadFright(loadFright);
					bean.setUnloadFright(unloadFright);
					map.put(""+c, bean);
					c++;
				}
				
			}
			
			
			return map;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
