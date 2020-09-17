package com.stpl.pms.controller.gm;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.Itgs;
import com.stpl.pms.hibernate.mapping.StRmBoUserInfo;
import com.stpl.pms.hibernate.mapping.StRmBoUserMaster;
import com.stpl.pms.hibernate.mapping.StRmGameUserMapping;
import com.stpl.pms.javabeans.UserDetailsBean;
import com.stpl.pms.security.ZipFileProtection;

public class GameMgmtController {
	private static final Logger log = Logger.getLogger(GameMgmtController.class);

	public void getDomain(short domainId, int roleId, int countryId, int currencyId, String txnType)
			throws PMSException {
		Session session = null;
		// GameMgmtDaoImpl daoImpl = new GameMgmtDaoImpl();
		try {
			session = HibernateSessionFactory.getSession();

			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		log.info("---fetch Payment Option List End---");
		// return null;
	}

	public List<String> getGameNoList() {
		// TODO Auto-generated method stub
		try {
			List<String> gameNoList = new ArrayList<>();
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.eq("status", "Downloaded"));
			List<Itgs> result = criteria.list();
			if (result != null) {
				for (Itgs obj : result) {
					gameNoList.add(String.valueOf(obj.getGame_No()));
				}
				return gameNoList;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getGameNoList(int userId) {
		// TODO Auto-generated method stub
		try {
			List<String> gameNoList = new ArrayList<>();
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmGameUserMapping.class);
			criteria.add(Restrictions.eq("user_id", userId));
			criteria.add(Restrictions.eq("status", "Downloaded"));
			List<StRmGameUserMapping> reStRmGameUserMappings = criteria.list();
			if (reStRmGameUserMappings != null) {
				for (StRmGameUserMapping obj : reStRmGameUserMappings) {
					gameNoList.add(String.valueOf(obj.getGame_no()));
				}
				return gameNoList;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getBatchNoList(int gameNo, int userId) {
		// TODO Auto-generated method stub
		try {
			List<String> batchNoList = new ArrayList<>();
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmGameUserMapping.class);
			criteria.add(Restrictions.eq("user_id", userId));
			criteria.add(Restrictions.eq("game_no", gameNo));
			criteria.add(Restrictions.eq("status", "Downloaded"));
			List<StRmGameUserMapping> result = criteria.list();
			if (result != null) {
				for (StRmGameUserMapping obj : result) {
					batchNoList.add(String.valueOf(obj.getBatch_no()));
				}
				return batchNoList;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getBatchNoList(int gameNo) {
		// TODO Auto-generated method stub
		try {
			List<String> batchNoList = new ArrayList<>();
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmGameUserMapping.class);
			criteria.add(Restrictions.eq("game_no", gameNo));
			criteria.add(Restrictions.eq("status", "Downloaded"));

			List<StRmGameUserMapping> result = criteria.list();
			if (result != null) {
				for (StRmGameUserMapping obj : result) {
					batchNoList.add(String.valueOf(obj.getBatch_no()));
				}
				return batchNoList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, String> getZipFileName(int gameNo, int batchNo, String path, String userName) {
		// TODO Auto-generated method stub
		try {
			ZipFileProtection fileProtection = new ZipFileProtection();

			return fileProtection.zipFileName(gameNo, batchNo, path, userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Itgs getGameDataForPrintTicket(int gameNo, int batchNo) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.eq("game_No", gameNo));
			criteria.add(Restrictions.eq("batch_no", batchNo));
			List<Itgs> result = criteria.list();
			if (result != null) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserDetailsBean getUserDetailsBean(int userId) {
		// TODO Auto-generated method stub
		try {

			UserDetailsBean userDetailsBean = new UserDetailsBean();
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(StRmBoUserInfo.class);
			criteria.add(Restrictions.eq("userId", userId));
			List<StRmBoUserInfo> result = criteria.list();
			if (result != null) {
				Criteria criteria1 = session.createCriteria(StRmBoUserMaster.class);
				criteria1.add(Restrictions.eq("userId", userId));
				List<StRmBoUserMaster> result1 = criteria1.list();
				if (result1 != null) {
					for (StRmBoUserMaster obj : result1) {
						userDetailsBean.setUserName(obj.getUserName());
					}
				}
				for (StRmBoUserInfo obj : result) {
					userDetailsBean.setFirstName(obj.getFirstName());
					userDetailsBean.setLastName(obj.getLastName());
					userDetailsBean.setGender(obj.getGender());
					userDetailsBean.setEmailId(obj.getEmailId());
					userDetailsBean.setAddressLine1(obj.getAddressLine1());
					userDetailsBean.setAddressLine2(obj.getAddressLine2());
					userDetailsBean.setCity(obj.getCity());
					userDetailsBean.setCountryCode(obj.getCountryCode());
					userDetailsBean.setStateCode(obj.getStateCode());
					userDetailsBean.setPostalCode(obj.getPostalCode());
					userDetailsBean.setPhoneNbr(obj.getPhoneNum());
				}
				return userDetailsBean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getGameName(int gameNo, int batchNo) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.eq("game_No", gameNo));
			criteria.add(Restrictions.eq("batch_no", batchNo));
			List<Itgs> result = criteria.list();
			if (result != null) {
				for (Itgs obj : result) {
					return obj.getGame_Name();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserDetailsBean getParentUserData(String userName, UserDetailsBean userDetailsBean) {
		// TODO Auto-generated method stub
		try {
			// code to set phone number to bomaster phone number only ---rest user
			// information remains same
			int parentUserId = 0;
			Session session = HibernateSessionFactory.getSession();
			UserDetailsBean userDetailsBean2 = new UserDetailsBean();
			userDetailsBean2 = userDetailsBean;
			Criteria criteria = session.createCriteria(StRmBoUserMaster.class);
			criteria.add(Restrictions.eq("userName", userName));
			List<StRmBoUserMaster> parentUserIdResult = criteria.list();
			if (parentUserIdResult != null) {
				for (StRmBoUserMaster obj : parentUserIdResult) {
					parentUserId = obj.getParentUserId();
				}
				Criteria criteria2 = session.createCriteria(StRmBoUserInfo.class);
				criteria2.add(Restrictions.eq("userId", parentUserId));
				List<StRmBoUserInfo> beanResult = criteria2.list();
				if (beanResult != null) {
					for (StRmBoUserInfo obj : beanResult) {
						userDetailsBean2.setPhoneNbr(obj.getPhoneNum());
						userDetailsBean2.setEmailId(obj.getEmailId());
					}
					return userDetailsBean2;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	public Map<String, byte[]> getAllImages(int gameNo, int batchNo) throws Exception {
		// TODO Auto-generated method stub
		Map<String, byte[]> images = new HashMap<>();
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Itgs.class);
		criteria.add(Restrictions.eq("game_No", gameNo));
		criteria.add(Restrictions.eq("batch_no", batchNo));
		List<Itgs> result = criteria.list();
		if (result != null) {
			for (Itgs obj : result) {
				images.put("frontImg_" + gameNo + "_" + batchNo, obj.getFront_img());
				images.put("backImg_" + gameNo + "_" + batchNo, obj.getBack_img());
				images.put("scratchedImg_" + gameNo + "_" + batchNo, obj.getScratched_img());

			}
			return images;
		}
		return null;
	}

	public Map<Integer, Integer> getSaleReportByStoredProc() {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = null;
		try {
			map = new TreeMap<Integer, Integer>();
			Session session = HibernateSessionFactory.getSession();
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			String yearInString = String.valueOf(year);
			SQLQuery query = session.createSQLQuery("CALL GET_TRANSACTION_REPORT_SALE('" + yearInString + "')");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {

				for (Object[] obj : result) {
					map.put((int) obj[0],((BigInteger) obj[1]).intValue());

				}
				for (int i = 1; i < 13; i++) {
					if (map.get(i) == null)
						map.put(i, 0);
				}
			} else {

				for (int i = 1; i < 13; i++) {
					map.put(i, 0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<Integer, Integer> getPurchaseReportByStoredProc() {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = null;
		try {
			map = new TreeMap<Integer, Integer>();
			Session session = HibernateSessionFactory.getSession();
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			String yearInString = String.valueOf(year);
			SQLQuery query = session.createSQLQuery("CALL GET_TRANSACTION_REPORT_PURCHASE('" + yearInString + "')");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {

				for (Object[] obj : result) {
					map.put((int) obj[0],((BigInteger) obj[1]).intValue());

				}
				for (int i = 1; i < 13; i++) {
					if (map.get(i) == null)
						map.put(i, 0);
				}
			} else {

				for (int i = 1; i < 13; i++) {
					map.put(i, 0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public Map<Integer, Integer> getCNReportByStoredProc() {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = null;
		try {
			map = new TreeMap<Integer, Integer>();
			Session session = HibernateSessionFactory.getSession();
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			String yearInString = String.valueOf(year);
			SQLQuery query = session.createSQLQuery("CALL GET_TRANSACTION_REPORT_CN('" + yearInString + "')");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {

				for (Object[] obj : result) {
					map.put((int) obj[0],((BigInteger) obj[1]).intValue());

				}
				for (int i = 1; i < 13; i++) {
					if (map.get(i) == null)
						map.put(i, 0);
				}
			} else {

				for (int i = 1; i < 13; i++) {
					map.put(i, 0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public Map<Integer, Integer> getDNReportByStoredProc() {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = null;
		try {
			map = new TreeMap<Integer, Integer>();
			Session session = HibernateSessionFactory.getSession();
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			String yearInString = String.valueOf(year);
			SQLQuery query = session.createSQLQuery("CALL GET_TRANSACTION_REPORT_DN('" + yearInString + "')");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {

				for (Object[] obj : result) {
					map.put((int) obj[0],((BigInteger) obj[1]).intValue());

				}
				for (int i = 1; i < 13; i++) {
					if (map.get(i) == null)
						map.put(i, 0);
				}
			} else {

				for (int i = 1; i < 13; i++) {
					map.put(i, 0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<Integer, Integer> getSalePendingBillsStoredProc() {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = null;
		try {
			map = new TreeMap<Integer, Integer>();
			Session session = HibernateSessionFactory.getSession();
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			String yearInString = String.valueOf(year);
			SQLQuery query = session.createSQLQuery("CALL GET_PENDING_BILLS_REPORT_SALE('" + yearInString + "')");
			List<Object[]> result = query.list();
			if (result != null && !result.isEmpty() && result.size() > 0) {

				for (Object[] obj : result) {
					map.put((int) obj[0],((BigInteger) obj[1]).intValue());

				}
				for (int i = 1; i < 13; i++) {
					if (map.get(i) == null)
						map.put(i, 0);
				}
			} else {

				for (int i = 1; i < 13; i++) {
					map.put(i, 0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public String getTotalSaleAmount() {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateSessionFactory.getSession();
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			String yearInString = String.valueOf(year);
			SQLQuery query =session.createSQLQuery("CALL GET_SALE_AMOUNT_REPORT_PIE_CHART('"+yearInString+"')");
			List<Double> result = query.list();
			if(result!=null && !result.isEmpty() && result.size()>0) {
				
				return String.valueOf(result.get(0));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "0";
	}
	public String getTotalReceiptAmount() {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateSessionFactory.getSession();
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			String yearInString = String.valueOf(year);
			SQLQuery query =session.createSQLQuery("CALL GET_RECEIPT_AMOUNT_REPORT_PIE_CHART('"+yearInString+"')");
			List<Double> result = query.list();
			if(result!=null && !result.isEmpty() && result.size()>0) {
				
				return String.valueOf(result.get(0));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "0";
	}
	public String getTotalCNAmount() {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateSessionFactory.getSession();
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			String yearInString = String.valueOf(year);
			SQLQuery query =session.createSQLQuery("CALL GET_CN_AMOUNT_REPORT_PIE_CHART('"+yearInString+"')");
			List<Double> result = query.list();
			if(result!=null && !result.isEmpty() && result.size()>0) {
				
				return String.valueOf(result.get(0));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "0";
	}
}
