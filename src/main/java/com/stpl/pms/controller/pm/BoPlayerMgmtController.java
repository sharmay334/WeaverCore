package com.stpl.pms.controller.pm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import com.stpl.pms.controller.comm.CommMgmtController;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.daoImpl.pm.BoPlayerMgmtDaoImpl;
import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.DomainFieldsWithValueBean;
import com.stpl.pms.javabeans.PlayerDocumentMasterBean;
import com.stpl.pms.javabeans.PlrMailContentBean;
import com.stpl.pms.javabeans.PrivFunctionBean;
import com.stpl.pms.javabeans.TemplateMasterBean;
import com.stpl.pms.utility.AndroidPushService;
import com.stpl.pms.utility.ApplePushService;

public class BoPlayerMgmtController {
	private static final Logger logger = Logger
			.getLogger(BoPlayerMgmtController.class);
	PrivFunctionBean privFunctionBean;

	public BoPlayerMgmtController() {
	}

	public BoPlayerMgmtController(PrivFunctionBean privFunctionBean) {
		super();
		this.privFunctionBean = privFunctionBean;
	}

	public Map<String, List<DomainFieldsWithValueBean>> fetchFieldList(
			int domainId) throws PMSException {
		BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
		Session session = null;
		Map<String, List<DomainFieldsWithValueBean>> result = new HashMap<String, List<DomainFieldsWithValueBean>>();
		try {
			session = HibernateSessionFactory.getSession();
			result = playerMgmtDaoImpl.fetchFieldListBO(domainId, session);
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;

	}

	public void saveModuleFieldList(
			List<DomainFieldsWithValueBean> fieldMasters, String regType,
			boolean fieldsChanged, long userId) throws PMSException {
		BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();

			playerMgmtDaoImpl.saveModuleFieldList(fieldMasters, regType,
					fieldsChanged, session, userId);
			tx.commit();

		} catch (PMSException pmse) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new PMSException(pmse.getErrorCode(), pmse.getErrorMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public List<Object> plrSearchForUploadDoc(short domainId, short aliasId,
			String firstName, String lastName, String userName, String status, String uploadStartDate, String uploadEndDate)
			throws PMSException {
		Session session = null;
		List<Object> result = null;
		try {
			session = HibernateSessionFactory.getSession();
			result = new BoPlayerMgmtDaoImpl().plrSearchForUploadDocument(domainId, aliasId,
					firstName, lastName, userName, status, uploadStartDate, uploadEndDate, session);
		}catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new PMSException("Hibernate Exception");
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return result;
	}
	public List<Object> redPlrSearchForUploadDoc(short domainId, short aliasId,
			Long playerId, String userName, String status, String uploadStartDate, String uploadEndDate)
			throws PMSException {
		Session session = null;
		List<Object> result = null;
		try {
			session = HibernateSessionFactory.getSession();
			result=new BoPlayerMgmtDaoImpl().redPlrSearchForUploadDocument(domainId, aliasId, 
					playerId, userName, status, uploadStartDate, uploadEndDate, session);
			
		}catch (HibernateException e) {
			logger.error(e.getMessage(), e);
			throw new PMSException("Hibernate Exception");
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return result;
	}

	public PlayerDocumentMasterBean uploadOrEditPlrDocument(long playerId)
			throws PMSException {
		BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
		Session session = null;
		PlayerDocumentMasterBean result = null;
		try {
			session = HibernateSessionFactory.getSession();
			result = playerMgmtDaoImpl.uploadOrEditPlrDocument(session,
					playerId);
		} catch (PMSException pmse) {
			throw pmse;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public String saveOrUpdatePlrDoc(PlayerDocumentMasterBean plrDocumentMaster)
			throws PMSException {
		BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
		Transaction tx = null;
		Session session = null;
		String result = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			result = playerMgmtDaoImpl.saveOrUpdatePlrDoc(session,
					plrDocumentMaster);
			tx.commit();
		} catch (PMSException pmse) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw pmse;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}
	/*public String saveOrUpdatePlrBankDoc(StPmPlrRdmDocMasterBean plrBankDocumentMaster)throws PMSException{
		BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
		Transaction tx = null;
		Session session = null;
		String result = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			result=playerMgmtDaoImpl.saveOrUpdatePlrBankDoc(session,
					plrBankDocumentMaster);
			tx.commit();
		} catch (PMSException pmse) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw pmse;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}
	*/
	/*public PlayerInfoBean getPlayerInfo(PlayerDocumentMasterBean plrDocumentMaster)
			throws PMSException {
		PlayerMgmtDaoImpl playerMgmtDaoImpl = new PlayerMgmtDaoImpl();
		Transaction tx = null;
		Session session = null;
		//String result = null;
		PlayerInfoBean playerInfoBean = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			playerInfoBean = playerMgmtDaoImpl.getPlayerInfoById(plrDocumentMaster.getPlayerId(),session);
			tx.commit();
		} catch (PMSException pmse) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw pmse;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return playerInfoBean;
	}
	public PlayerInfoBean getPlayerInfo(StPmPlrRdmDocMasterBean plrBankDocumentMaster)
			throws PMSException {
		PlayerMgmtDaoImpl playerMgmtDaoImpl = new PlayerMgmtDaoImpl();
		Transaction tx = null;
		Session session = null;
		//String result = null;
		PlayerInfoBean playerInfoBean = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			playerInfoBean = playerMgmtDaoImpl.getPlayerInfoById(plrBankDocumentMaster.getPlayerId(),session);
			tx.commit();
		} catch (PMSException pmse) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw pmse;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return playerInfoBean;
	}
*/

/*	@SuppressWarnings("rawtypes")
	public ArrayList plrSearchForAutoVerification(Short domainId,
			String firstName, String lastName, String userName,
			String verificationStatus, int recordPerPage, int paginationPage)
			throws PMSException {

		BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
		Session session = null;
		ArrayList result = null;
		try {
			session = HibernateSessionFactory.getSession();
			result = playerMgmtDaoImpl.plrSearchForAutoVerification(domainId,
					firstName, lastName, userName, verificationStatus, session,
					recordPerPage, paginationPage);
		} catch (PMSException pmse) {
			pmse.printStackTrace();
			throw pmse;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;

	}*/

	/*public void plrRefundProcessTerminate(long[] refundNTerPLrId, short domainId)
			throws PMSException {
		BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
		TransactionDaoImpl txnDao = TransactionDaoImpl.getInstance();
		Transaction tx = null;
		Session session = null;
		StPmPlayerMaster plrMaster = null;
		PlayerInfoBean playerInfoBean = null;
		WithdrawalRequestBean requestBean = null;
		PlrRedeemAccChequeInfoBean plrRedChkBean = null;
		PlayerLedgerBean ledger = new PlayerLedgerBean();
		double amount;
		for (long l : refundNTerPLrId) {

			try {
				session = HibernateSessionFactory.getSession();
				tx = session.beginTransaction();
				plrMaster = playerMgmtDaoImpl.plrTerminate(l, session);
				amount = plrMaster.getPlayerWallet().getTotalDeposit()
						- new BOCashierDaoImpl().getProcessedWithdrawal(l,
								session);
				txnDao.plrCancelAllTxn(l, domainId, plrMaster.getAliasId(), amount, ledger, session);
				tx.commit();
				ledger.setCurrencyId(plrMaster.getPlayerWallet()
						.getCurrencyId());
				txnDao.updatePlayerTxnLedger(ledger);
				
				 * Initiate Plr withdrawal if amount is greater than
				 
				if (amount > 0) {
					playerInfoBean = new PlayerMgmtDaoImpl().getPlayerInfo(
							plrMaster, session);
					requestBean = new WithdrawalRequestBean();
					requestBean.setAmount(amount);
					requestBean.setPaymentTypeCode("CHEQUE_TRANS");
					requestBean.setCurrencyId(plrMaster.getPlayerWallet()
							.getCurrencyId());
					plrRedChkBean = new PlrRedeemAccChequeInfoBean();
					plrRedChkBean.setAddressLine1(plrMaster.getStPmPlayerInfo()
							.getAddressLine1());
					plrRedChkBean.setAddressLine2(plrMaster.getStPmPlayerInfo()
							.getAddressLine2());
					plrRedChkBean.setCity(plrMaster.getStPmPlayerInfo()
							.getCity());
					plrRedChkBean.setCountryCode(plrMaster.getStPmPlayerInfo()
							.getStGenCountryMaster().getCountryCode());
					plrRedChkBean.setFirstName(plrMaster.getFirstName());
					plrRedChkBean.setHouseNum(plrMaster.getStPmPlayerInfo()
							.getHouseNum());
					plrRedChkBean.setLastName(plrMaster.getLastName());
					plrRedChkBean.setPostalCode(plrMaster.getStPmPlayerInfo()
							.getPostalCode());
					plrRedChkBean.setStateCode(plrMaster.getStPmPlayerInfo()
							.getStGenStateMaster().getStateCode());
					requestBean.setChqRedAcc(plrRedChkBean);
					new CashierWithdrawalController().chequeWithdrawalRequest(
							playerInfoBean, requestBean,null);
				}

			} catch (PMSException pmse) {
				pmse.printStackTrace();
				if (tx.isActive()) {
					tx.rollback();
				}
				throw pmse;
			} finally {
				if (session != null) {
					session.close();
				}
			}

		}
	}*/
	public String getServiceUrl(short aliasId) throws PMSException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			return new BoPlayerMgmtDaoImpl().getServiceUrl(aliasId, session);
		} catch (PMSException e) {
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	public void plrMannualVerifyCancelPlr(long[] refundNTerPLrId,
			String veriAction) throws PMSException {

		Transaction tx = null;
		Session session = null;

		for (long l : refundNTerPLrId) {

			try {
				session = HibernateSessionFactory.getSession();
				tx = session.beginTransaction();
				new BoPlayerMgmtDaoImpl().plrMannualVerifyCancelPlr(l,
						veriAction, session);
				tx.commit();

			} catch (PMSException pmse) {
				pmse.printStackTrace();
				if (tx.isActive()) {
					tx.rollback();
				}
				throw pmse;
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
	}

	public List<TemplateMasterBean> fetchTemplate(short domainId,short aliasId,String sentOn)
			throws PMSException {
		BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
		List<TemplateMasterBean> tempList = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			tempList = playerMgmtDaoImpl.fetchAvailableTemplate(domainId,aliasId,sentOn,
					session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("Unknown Exception");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return tempList;
	}

	public void saveTemplate(final PlrMailContentBean plrEmailBean,
			Long[] playerIdArr, int boUser) throws PMSException {
		try {
			plrEmailBean.setPlayerIdArr(playerIdArr);
			plrEmailBean.setBoUser(boUser);
			Thread th = new Thread(new Runnable() {
				public void run() {
					try {
						BoPlayerMgmtController controller = new BoPlayerMgmtController();
						controller.saveTemplatePage(plrEmailBean);
					} catch (PMSException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			th.start();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
					PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
	}

	public void saveTemplatePage(PlrMailContentBean plrEmailBean)
			throws PMSException {
		boolean isInternal = false;
		boolean isExternal = false;
			if ("internal".equals(plrEmailBean.getInt_ext_mail()[0])) {
				isInternal = true;
			} else if ("external".equals(plrEmailBean.getInt_ext_mail()[0])) {
				isExternal = true;
			}else if("both".equals(plrEmailBean.getInt_ext_mail()[0])){
				isInternal = true;
				isExternal = true;
			}
		Transaction tx = null;
		if (isInternal) {
			StatelessSession session = null;
			try {
				session = HibernateSessionFactory.getSessionFactory()
						.openStatelessSession();
				tx = session.beginTransaction();
				BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
				playerMgmtDaoImpl.saveTemplatePage(plrEmailBean, session);
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
				throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
						PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
			} finally {
				if (session != null)
					session.close();
			}
		}

		if (isExternal) {
			Session session = null;
			try {
				session = HibernateSessionFactory.getSession();
				Map<String, String> emailContentMap = null;
				CommonMethodDaoImpl dao = CommonMethodDaoImpl.getInstance();
				if(!("PORTALCONTENT".equals(plrEmailBean.getContentType()))){
					BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
					playerMgmtDaoImpl.insertJoomlaTemplate(plrEmailBean,session);
				}
				for (int i = 0; i < plrEmailBean.getPlayerIdArr().length; i++) {
					emailContentMap = dao.variableMap(
							plrEmailBean.getPlayerIdArr()[i],
							plrEmailBean.getDomainVal(), "EMAIL", session);
					if(!("PORTALCONTENT".equals(plrEmailBean.getContentType()))){
						plrEmailBean.setSubject(plrEmailBean.getSubject()+"#"+plrEmailBean.getTempId()+"#"+plrEmailBean.getTempUrl());
					}
					//Short aliasId = new PlayerMgmtDaoImpl().fetchAliasIdFromPlrId(plrEmailBean.getPlayerIdArr()[i], session);
					CommMgmtController.callSendMail(emailContentMap, "BO_USE",
									plrEmailBean.getDomainVal(),plrEmailBean.getAliasId(),
									plrEmailBean.getSubject(),
									plrEmailBean.getBoUser(),session);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
						PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
			} finally {
				if (session != null && session.isOpen())
					session.close();
			}
		}
	}

	public String fetchTemplateByName(short domainId,short aliasId, String subject,String sentOn)
			throws PMSException {
		BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
		Session session = null;
		String fileName = null;
		try {
			session = HibernateSessionFactory.getSession();
			fileName = playerMgmtDaoImpl.fetchTemplateByName(domainId,aliasId,subject,sentOn,
					session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
					PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} finally {
			session.close();
		}
		return fileName;
	}

	public void sendNotification(short aliasId,Long[] playerId, String appType,
								 String message,String deeplink) throws PMSException{
		BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
		Session session = null;
		Map<String, Set<String>> deviceIdMap = null;
		try {
			session = HibernateSessionFactory.getSession();
			deviceIdMap = playerMgmtDaoImpl.getPlayerDeviceId(aliasId,playerId, appType,session);
			if(deviceIdMap!=null && !deviceIdMap.isEmpty()){
				if(deviceIdMap.containsKey("ANDROID")){
					Map<String, String> messageData = new HashMap<String, String>();
					messageData.put("kh_message", message);
					messageData.put("kh_deeplink", deeplink);
					try{
						AndroidPushService.callSendGCM(aliasId,new ArrayList<String>(deviceIdMap.get("ANDROID")), messageData,session);
					}catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if(deviceIdMap.containsKey("IOS"))
					ApplePushService.callApplePushService(aliasId,deviceIdMap.get("IOS"),deeplink,message,session);
			}else {
				System.out.println("No device Ids to send Notification");
			}
		} catch (PMSException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			session.close();
		}
	}

	/*
	public void sendNotification(Long[] playerId, String message,String deepLink) throws PMSException{
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();

			CommonCommBean commonCommBean = new CommonCommBean();
			commonCommBean.setChannelType(ChannelType.ANDROID.toString());
			commonCommBean.setEventType(EventType.PROMOTION.toString());
			new CommunicationJob().sendFcmMessage(commonCommBean, playerId, message, deepLink, session);

			deviceIdMap = playerMgmtDaoImpl.getPlayerDeviceId(aliasId,playerId, appType,session);
			if(deviceIdMap!=null && !deviceIdMap.isEmpty()){
				if(deviceIdMap.containsKey("ANDROID")){
					Map<String, String> messageData = new HashMap<String, String>();
					messageData.put("kh_message", message);
					messageData.put("kh_deeplink", deeplink);
					try{
						AndroidPushService.callSendGCM(aliasId,new ArrayList<String>(deviceIdMap.get("ANDROID")), messageData,session);
					}catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if(deviceIdMap.containsKey("IOS"))
					ApplePushService.callApplePushService(aliasId,deviceIdMap.get("IOS"),deeplink,message,session);
			}else {
				System.out.println("No device Ids to send Notification");
			}

		} catch (PMSException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			session.close();
		}
	}

	public String fetchContentType(short aliasId) throws PMSException {
		BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
		Session session = null;
		String contentType = null;
		try {
			session = HibernateSessionFactory.getSession();
			contentType = playerMgmtDaoImpl.fetchContentType(aliasId,session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
					PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} finally {
			session.close();
		}
		return contentType;
	}
	public StPmPlayerMaster fetchPlayerByMobile(String mobile,short domainId) throws PMSException {
		BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
		StPmPlayerMaster playerMaster=null;
		Session session = null;
	try {
			session = HibernateSessionFactory.getSession();
			playerMaster = playerMgmtDaoImpl.fetchPlayerByMobile(mobile,domainId,session);
		} 
	catch(PMSException p) {
		throw new PMSException(p.getErrorCode(),p.getErrorMessage());
	}
	
	catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
					PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} 
		return playerMaster;
	}
	public List<TicketDetailBean> fetchPlayerTickets(Long playerId,String aliasName) throws PMSException {
		
		TPWeaverPlayerMgmtController playerMgmtController= new TPWeaverPlayerMgmtController();
		PlrTxnDataReqBean reqBean = new PlrTxnDataReqBean();
		
		List<TicketDetailBean> ticketDetailBean=null;
		reqBean.setOffset(0);
		reqBean.setDomainName(aliasName);
		reqBean.setLimit(10);
		reqBean.setPlayerId(playerId);
		Session session = null;
		try {
			
			session = HibernateSessionFactory.getSession();
			ticketDetailBean=playerMgmtController.getTicketTransactionDeatil(reqBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
					PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} 
		return ticketDetailBean;
	}
	public String savePassword(String pass,long playerId) throws PMSException {
		BoPlayerMgmtDaoImpl playerMgmtDaoImpl = new BoPlayerMgmtDaoImpl();
		Session session = null;
		String contentType = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			playerMgmtDaoImpl.savePassword(pass,playerId,session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
					PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} 
		return "success";
	}
	public StPmPlrRdmDocMasterBean getRdmBankDocDetail(Long playerId,Long redeemAccId) throws PMSException{
		BoPlayerMgmtDaoImpl boPlayerMgmtDaoImpl=new BoPlayerMgmtDaoImpl();
		StPmPlrRdmDocMasterBean plrRdmDocMaster=null;
		Session session=null;
		try {
			session=HibernateSessionFactory.getSession();
			plrRdmDocMaster=boPlayerMgmtDaoImpl.getRdmBankDocumentDetail(playerId,redeemAccId,session);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,
					PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		
		
		
		return plrRdmDocMaster;
	}
	
	public static void main(String a[]) {
	/*	
		BoPlayerMgmtController boPlayerMgmtController= new BoPlayerMgmtController();
		try {
			boPlayerMgmtController.fetchPlayerByMobile("9999323244");
		} catch (PMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
}
