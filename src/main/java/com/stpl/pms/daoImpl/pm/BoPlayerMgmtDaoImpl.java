package com.stpl.pms.daoImpl.pm;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.DomainFieldsWithValueBean;
import com.stpl.pms.hibernate.mapping.StCmsTemplateMaster;
import com.stpl.pms.hibernate.mapping.StDmAliasPropertyMaster;
import com.stpl.pms.hibernate.mapping.StDmDomainAliasNameMaster;
import com.stpl.pms.hibernate.mapping.StGenLanguageMaster;
import com.stpl.pms.hibernate.mapping.StPmFieldDomainMapping;
import com.stpl.pms.hibernate.mapping.StPmPlayerAdhaarData;
import com.stpl.pms.hibernate.mapping.StPmPlayerInboxMaster;
import com.stpl.pms.hibernate.mapping.StPmPlayerMaster;
import com.stpl.pms.hibernate.mapping.StPmPlrDocumentMaster;
import com.stpl.pms.hibernate.mapping.StPmPlrLoginStatus;
import com.stpl.pms.javabeans.PlayerDocumentMasterBean;
import com.stpl.pms.javabeans.PlrMailContentBean;
import com.stpl.pms.javabeans.TemplateMasterBean;
import com.stpl.pms.utility.ConfigurationVariables;
import com.stpl.pms.utility.MD5;

public class BoPlayerMgmtDaoImpl {
	public BoPlayerMgmtDaoImpl() {

	}

	private static final Logger logger = Logger
			.getLogger(BoPlayerMgmtDaoImpl.class);
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	@SuppressWarnings("unchecked")
	public Map<String, List<DomainFieldsWithValueBean>> fetchFieldListBO(
			int domainId, Session session) throws PMSException {
		logger.info("fetchFieldList execution started........");
		Map<String, List<DomainFieldsWithValueBean>> moduleFieldList = new HashMap<String, List<DomainFieldsWithValueBean>>();
		List<DomainFieldsWithValueBean> fields = new ArrayList<DomainFieldsWithValueBean>();
		Query query = null;
		try {

			query = session
					.createQuery("select new "
							+ DomainFieldsWithValueBean.class.getName()
							+ "(fieldId, fieldName, fieldDispCode, pageSectionNo,"
							+ "fieldSequenceNo, isMandatory, validationExp, helpStringCode, "
							+ "fieldInputType,optionValues, sectionNameCode, defaultValue, isEditable, isPartOfMiniReg, miniRegSeqNo) from StPmFieldDomainMapping where isShow='Y' and domainId = "
							+ domainId
							+ "  order by pageSectionNo, fieldSequenceNo");

			fields = query.list();

			// criteria = session.createCriteria(StPmFieldDomainMapping.class);
			// criteria.add(Restrictions.eq("domainId", (short) domainId)).add(
			// Restrictions.eq("isShow", "Y")).addOrder(
			// Order.asc("pageSectionNo").asc("fieldSequenceNo"));
			// fields = criteria.list();
			moduleFieldList.put("domainFields", fields);

			query = session
					.createQuery("select new "
							+ DomainFieldsWithValueBean.class.getName()
							+ "(fieldId, fieldName, fieldDispCode, pageSectionNo,"
							+ "fieldSequenceNo, isMandatory, validationExp, helpStringCode, "
							+ "fieldInputType,optionValues, sectionNameCode, defaultValue, isEditable, isPartOfMiniReg, miniRegSeqNo) from StPmFieldDomainMapping where isShow='N' and domainId = "
							+ domainId
							+ "  order by pageSectionNo, fieldSequenceNo");

			fields = query.list();

			// criteria = session.createCriteria(StPmFieldDomainMapping.class);
			// criteria.add(Restrictions.eq("domainId", (short) domainId)).add(
			// Restrictions.eq("isShow", "N")).addOrder(
			// Order.asc("pageSectionNo").asc("fieldSequenceNo"));
			// fields = criteria.list();
			moduleFieldList.put("spareFields", fields);

		} catch (HibernateException he) {
			he.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
		return moduleFieldList;
	}

	@SuppressWarnings("unchecked")
	public void saveModuleFieldList(
			List<DomainFieldsWithValueBean> fieldMasters, String regType,
			boolean fieldsChanged, Session session, long userId)
			throws PMSException {

		List<DomainFieldsWithValueBean> temp = null;
		Query query = null;
		int rows;
		Timestamp currTime = new Timestamp(Calendar.getInstance()
				.getTimeInMillis());
		Map<String, DomainFieldsWithValueBean> fieldName = new HashMap<String, DomainFieldsWithValueBean>();
		for (DomainFieldsWithValueBean stPmFieldDomainMapping : fieldMasters) {
			fieldName.put(stPmFieldDomainMapping.getFieldName(),
					stPmFieldDomainMapping);
		}
		try {
			String registrationPage = null;
			if (fieldMasters.get(0).getDomainId() == 1) {
				registrationPage = "BYDEFAULT";
			} else {
				registrationPage = "SPECIFIC";
			}
			session.createQuery(
					"update StDmDomainMaster set registrationPage='"
							+ registrationPage + "', registrationType='"
							+ regType + "' where domainId = '"
							+ fieldMasters.get(0).getDomainId() + "'")
					.executeUpdate();

			if (fieldsChanged) {

				rows = (Integer) session
						.createCriteria(StPmFieldDomainMapping.class)
						.setProjection(Projections.rowCount())
						.add(Restrictions.eq("domainId", fieldMasters.get(0)
								.getDomainId())).list().get(0);

				logger.info("rows---" + rows);

				if (rows > 0) {

					session.createQuery(
							"update StPmFieldDomainMapping set isShow='N',lastUpdatedBy="
									+ userId + ", lastUpdationTime='"
									+ currTime + "' where domainId="
									+ fieldMasters.get(0).getDomainId() + "")
							.executeUpdate();

					for (DomainFieldsWithValueBean stPmFieldDomainMapping : fieldMasters) {

						query = session
								.createQuery("update StPmFieldDomainMapping set fieldDispCode=?, pageSectionNo=?"
										+ ",fieldSequenceNo=?, isMandatory=?, sectionNameCode=?, isShow=?, isPartOfMiniReg=?, miniRegSeqNo=?, lastUpdatedBy=?, lastUpdationTime=? where fieldId=?");
						query.setParameter(0,
								stPmFieldDomainMapping.getFieldDispCode());
						query.setParameter(1,
								stPmFieldDomainMapping.getPageSectionNo());
						query.setParameter(2,
								stPmFieldDomainMapping.getFieldSequenceNo());
						query.setParameter(3,
								stPmFieldDomainMapping.getIsMandatory());
						query.setParameter(4,
								stPmFieldDomainMapping.getSectionNameCode());
						query.setParameter(5, "Y");
						query.setParameter(6,
								stPmFieldDomainMapping.getIsPartOfMiniReg());
						query.setParameter(7,
								stPmFieldDomainMapping.getMiniRegSeqNo());
						query.setParameter(8, userId);
						query.setParameter(9, currTime);
						query.setParameter(10,
								stPmFieldDomainMapping.getFieldId());

						query.executeUpdate();
					}
				} else {

					StPmFieldDomainMapping stPmFieldDomainMappings = new StPmFieldDomainMapping();
					Criteria cri = session
							.createCriteria(StPmFieldDomainMapping.class);
					cri.add(Restrictions.eq("domainId", (short) 1));
					temp = cri.list();
					logger.info("temp--" + temp.size());
					for (StPmFieldDomainMapping stPmFieldDomainMapping : temp) {

						stPmFieldDomainMappings
								.setFieldName(stPmFieldDomainMapping
										.getFieldName());
						stPmFieldDomainMappings
								.setFieldDispCode(stPmFieldDomainMapping
										.getFieldDispCode());
						stPmFieldDomainMappings
								.setPageSectionNo(stPmFieldDomainMapping
										.getPageSectionNo());
						stPmFieldDomainMappings
								.setFieldSequenceNo(stPmFieldDomainMapping
										.getFieldSequenceNo());
						stPmFieldDomainMappings
								.setIsMandatory(stPmFieldDomainMapping
										.getIsMandatory());

						stPmFieldDomainMappings
								.setSectionNameCode(stPmFieldDomainMapping
										.getSectionNameCode());
						stPmFieldDomainMappings.setDomainId(fieldMasters.get(0)
								.getDomainId());
						stPmFieldDomainMappings
								.setDefaultValue(stPmFieldDomainMapping
										.getDefaultValue());
						stPmFieldDomainMappings
								.setFieldInputType(stPmFieldDomainMapping
										.getFieldInputType());
						stPmFieldDomainMappings
								.setHelpStringCode(stPmFieldDomainMapping
										.getHelpStringCode());
						stPmFieldDomainMappings
								.setIsEditable(stPmFieldDomainMapping
										.getIsEditable());
						stPmFieldDomainMappings
								.setIsEditablePlayer(stPmFieldDomainMapping
										.getIsEditablePlayer());
						stPmFieldDomainMappings
								.setIsNull(stPmFieldDomainMapping.getIsNull());
						stPmFieldDomainMappings
								.setIsPartOfMiniReg(stPmFieldDomainMapping
										.getIsPartOfMiniReg());
						stPmFieldDomainMappings
								.setIsUnique(stPmFieldDomainMapping
										.getIsUnique());
						stPmFieldDomainMappings
								.setOptionValues(stPmFieldDomainMapping
										.getOptionValues());
						stPmFieldDomainMappings
								.setValidationExp(stPmFieldDomainMapping
										.getValidationExp());
						stPmFieldDomainMappings
								.setMiniRegSeqNo(stPmFieldDomainMapping
										.getMiniRegSeqNo());
						stPmFieldDomainMappings.setCreatedBy(userId);
						stPmFieldDomainMappings.setCreationTime(currTime);
						stPmFieldDomainMappings.setLastUpdatedBy(userId);
						stPmFieldDomainMappings.setLastUpdationTime(currTime);
						if (fieldName.containsKey(stPmFieldDomainMapping
								.getFieldName())) {
							stPmFieldDomainMappings.setIsShow("Y");
							stPmFieldDomainMappings.setFieldDispCode(fieldName
									.get(stPmFieldDomainMapping.getFieldName())
									.getFieldDispCode());
							stPmFieldDomainMappings.setPageSectionNo(fieldName
									.get(stPmFieldDomainMapping.getFieldName())
									.getPageSectionNo());
							stPmFieldDomainMappings
									.setFieldSequenceNo(fieldName.get(
											stPmFieldDomainMapping
													.getFieldName())
											.getFieldSequenceNo());
							stPmFieldDomainMappings.setIsMandatory(fieldName
									.get(stPmFieldDomainMapping.getFieldName())
									.getIsMandatory());
							stPmFieldDomainMappings
									.setIsPartOfMiniReg(fieldName.get(
											stPmFieldDomainMapping
													.getFieldName())
											.getIsPartOfMiniReg());
							stPmFieldDomainMappings.setMiniRegSeqNo(fieldName
									.get(stPmFieldDomainMapping.getFieldName())
									.getMiniRegSeqNo());
							stPmFieldDomainMappings
									.setSectionNameCode(fieldName.get(
											stPmFieldDomainMapping
													.getFieldName())
											.getSectionNameCode());
						} else
							stPmFieldDomainMappings.setIsShow("N");

						session.save(stPmFieldDomainMappings);
						session.flush();
						session.clear();
					}

				}

			}

		} catch (HibernateException he) {
			he.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Object> plrSearchForUploadDocument(short domainId, short aliasId,
			String firstName, String lastName, String userName, String status, String uploadStartDate, String uploadEndDate, Session session)
	{
		String str = "";
		Query qry;
		Boolean pageLoad = false;
		str = "select Date_Format(dm.uploadedDate,'%d/%m/%Y'),pm.userName,pm.firstName,pm.lastName,pm.ageVerified,pm.addressVerified,pm.taxationIdVerified,pm.playerId from StPmPlayerMaster pm, " +
				"StPmPlrDocumentMaster dm where pm.playerId = dm.playerId ";
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		Date date = new Date();
		Date startDate = new Date();
		Date endDate = new Date();
		if(domainId!=-1)
		{
			str = str + " and pm.domainId in (:domainId) ";
		}
		if (status != null && !"ALL".equals(status)) {
			str = str + " and (pm.ageVerified in (:status) or pm.addressVerified in (:status) or pm.taxationIdVerified in (:status))";
		}
		if((uploadStartDate==null || "null".equals(uploadStartDate) || "".equals(uploadStartDate) || "undefined".equals(uploadStartDate)|| " undefined".equals(uploadStartDate))&& ("".equals(firstName)&&"".equals(lastName)&&"".equals(userName)&& (aliasId==-1 || aliasId==0)
				&&("null".equals(uploadEndDate) || "".equals(uploadEndDate) || " undefined".equals(uploadEndDate) || "undefined".equals(uploadEndDate))))
		{
			pageLoad = true;
			c.add(Calendar.DAY_OF_YEAR, -6);
			date = c.getTime();
			str = str+" and dm.uploadedDate >= (:date)";
		}
		else
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			if(aliasId!=-1 && aliasId!=0)
			{
				str = str + " and pm.aliasId = '" + aliasId + "'";
			}
			if(firstName!=null && !"".equals(firstName))
			{
				str = str + " and pm.firstName like '%" + firstName + "%'";
			}
			if(lastName!=null && !"".equals(lastName))
			{
				str = str + " and pm.lastName like '%" + lastName + "%'";
			}
			if(userName!=null && !"".equals(userName))
			{
				str = str + " and pm.userName like '" + userName + "'";
			}
			if(!"null".equals(uploadStartDate) && !"".equals(uploadStartDate) && !" undefined".equals(uploadStartDate) &&  !"undefined".equals(uploadStartDate) )
			{
				try {
					startDate = df.parse(uploadStartDate); 
					c.setTime(startDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				startDate = c.getTime();
				str = str + " and dm.uploadedDate >= (:startDate)" ;
			}
			if(!"null".equals(uploadEndDate) && !"".equals(uploadEndDate) && !" undefined".equals(uploadEndDate) && !"undefined".equals(uploadEndDate))
			{
				try {
					endDate = df.parse(uploadEndDate); 
					c1.setTime(endDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				endDate = c1.getTime();
				str = str + " and dm.uploadedDate <= (:endDate)" ;
			}
		}
		str = str + " order by dm.uploadedDate desc";
		qry= session.createQuery(str);
		if(domainId!=-1)
		{
			qry.setParameter("domainId", domainId);
		}
		if (status != null && !"ALL".equals(status)) {
			qry.setParameter("status", status);
		}
		if((uploadStartDate==null || "null".equals(uploadStartDate) || "".equals(uploadStartDate) || "undefined".equals(uploadStartDate) || " undefined".equals(uploadStartDate))&& ("".equals(firstName)&&"".equals(lastName)&&"".equals(userName)&&(aliasId==-1 || aliasId==0)
				&&("null".equals(uploadEndDate) || "".equals(uploadEndDate) || " undefined".equals(uploadEndDate) || "undefined".equals(uploadEndDate))))
			qry.setParameter("date", date);
		if(!"null".equals(uploadStartDate) && !"".equals(uploadStartDate) && !" undefined".equals(uploadStartDate) &&  !"undefined".equals(uploadStartDate))
			qry.setParameter("startDate", startDate);
		if(!"undefined".equals(uploadEndDate) && !"null".equals(uploadEndDate) && !"".equals(uploadEndDate) && !" undefined".equals(uploadEndDate))
			qry.setParameter("endDate", endDate);
		
		if(qry.list()!=null && qry.list().size()==0 && !pageLoad && ("null".equals(uploadEndDate) || "".equals(uploadEndDate) || " undefined".equals(uploadEndDate) || "undefined".equals(uploadEndDate))
				&& ("null".equals(uploadStartDate) || "".equals(uploadStartDate) || " undefined".equals(uploadStartDate) || "undefined".equals(uploadStartDate)))
		{
			str = "select Date_Format(NOW(),'%d/%m/%Y'),pm.userName,pm.firstName,pm.lastName,pm.ageVerified,pm.addressVerified,pm.taxationIdVerified,pm.playerId from StPmPlayerMaster pm ";
			String qryStr = "";
			if(domainId!=-1)
			{
				qryStr = qryStr + " pm.domainId in (:domainId) ";
			}
			if(aliasId!=-1 && aliasId!=0)
			{
				if(!qryStr.equals(""))
					qryStr = qryStr + " and ";
				qryStr = qryStr + " pm.aliasId = '" + aliasId + "'";
			}
			if (status != null && !"ALL".equals(status)) {
				if(!qryStr.equals(""))
					qryStr = qryStr + " and ";
				qryStr = qryStr + " (pm.ageVerified in (:status) or pm.addressVerified in (:status) or pm.taxationIdVerified in (:status))";
			}
			if(firstName!=null && !"".equals(firstName))
			{
				if(!qryStr.equals(""))
					qryStr = qryStr + " and ";
				qryStr = qryStr + " pm.firstName like '%" + firstName + "%'";
			}
			if(lastName!=null && !"".equals(lastName))
			{
				if(!qryStr.equals(""))
					qryStr = qryStr + " and ";
				qryStr = qryStr + " pm.lastName like '%" + lastName + "%'";
			}
			if(userName!=null && !"".equals(userName))
			{
				if(!qryStr.equals(""))
					qryStr = qryStr + " and ";
				qryStr = qryStr + " pm.userName like '%" + userName + "%'";
			}
			if(!qryStr.equals(""))
				str = str + " where "+qryStr;
			qry= session.createQuery(str);
			if(domainId!=-1)
			{
				qry.setParameter("domainId", domainId);
			}
			if (status != null && !"ALL".equals(status)) {
				qry.setParameter("status", status);
			}
		}
		return qry.list();
	}

	// Its overloading method need to be change ... if any problem contact with
	// Amrinder Singh
	@SuppressWarnings("unchecked")
	public List<StPmPlayerMaster> plrSearchForUploadDoc(short domainId,
			String firstName, String lastName, String userName, Session session)
			throws PMSException {

		Criteria cri = session.createCriteria(StPmPlayerMaster.class);
		if (domainId != 0) {
			cri.add(Restrictions.eq("domainId", domainId));
		}
		if (firstName != null && !"".equals(firstName)) {
			cri.add(Restrictions.like("firstName", firstName,
					MatchMode.ANYWHERE));
		}
		if (lastName != null && !"".equals(lastName)) {
			cri.add(Restrictions.like("lastName", lastName, MatchMode.ANYWHERE));
		}
		if (userName != null && !"".equals(userName)) {
			cri.add(Restrictions.like("userName", userName, MatchMode.START));
		}
		List<StPmPlayerMaster> list = cri.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public PlayerDocumentMasterBean uploadOrEditPlrDocument(Session session,
			long playerId) throws PMSException {

		PlayerDocumentMasterBean playerDocumentMaster = null;
		try {
			Criteria cri = session.createCriteria(StPmPlrDocumentMaster.class);
			cri.add(Restrictions.eq("playerId", playerId));
			List<StPmPlrDocumentMaster> list = cri.list();
			
			cri = session.createCriteria(StPmPlayerAdhaarData.class);
			cri.add(Restrictions.eq("playerId", playerId));
			List<StPmPlayerAdhaarData> adhaarList = cri.list();
			boolean isAdhaarOtpVerify =false;
			if(adhaarList.size()>0)
				isAdhaarOtpVerify=true;
			if (list.size() == 1) {
				for (StPmPlrDocumentMaster stpmplrDocumentMaster : list) {
					playerDocumentMaster = new PlayerDocumentMasterBean();
					playerDocumentMaster.setPlayerId(stpmplrDocumentMaster
							.getPlayerId());
					if (stpmplrDocumentMaster.getAgeDocPath() != null || isAdhaarOtpVerify) {
						playerDocumentMaster
								.setAgeDocType(stpmplrDocumentMaster
										.getAgeDocType());
						playerDocumentMaster
								.setAgeDocUniqueNo(stpmplrDocumentMaster
										.getAgeDocUniqueNo());
						playerDocumentMaster
								.setAgeDocPath(stpmplrDocumentMaster
										.getAgeDocPath());

					}

					if (stpmplrDocumentMaster.getAddDocPath() != null || isAdhaarOtpVerify) {
						playerDocumentMaster
								.setAddDocType(stpmplrDocumentMaster
										.getAddDocType());
						playerDocumentMaster
								.setAddDocUniqueNo(stpmplrDocumentMaster
										.getAddDocUniqueNo());
						playerDocumentMaster
								.setAddDocPath(stpmplrDocumentMaster
										.getAddDocPath());

					}
					if ((stpmplrDocumentMaster.getTaxIdDocPath() != null) || (stpmplrDocumentMaster.getTaxIdDocUniqueNo()!=null)) {
						playerDocumentMaster
								.setTaxIdDocType(stpmplrDocumentMaster
										.getTaxIdDocType());
						playerDocumentMaster
								.setTaxIdDocUniqueNo(stpmplrDocumentMaster
										.getTaxIdDocUniqueNo());
						playerDocumentMaster
								.setTaxIdDocPath(stpmplrDocumentMaster
										.getTaxIdDocPath());

					}
				}
			} else {
				throw new PMSException("Document not found");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		}
		return playerDocumentMaster;
	}

	public String saveOrUpdatePlrDoc(Session session,
			PlayerDocumentMasterBean plrDocumentMaster) throws PMSException {
		
		Criteria cri = session.createCriteria(StPmPlrDocumentMaster.class);
		cri.add(Restrictions.eq("playerId", plrDocumentMaster.getPlayerId()));
		StPmPlrDocumentMaster plrDoc = null;
		if (cri.list().size() != 0){
			plrDoc = (StPmPlrDocumentMaster) cri.list().get(0);
		}
		else{
			plrDoc = new StPmPlrDocumentMaster();
			plrDoc.setPlayerId(plrDocumentMaster.getPlayerId());
			plrDoc.setUploadedDate(new java.sql.Timestamp(new Date().getTime()));
		}
		plrDoc.setAgeDocPath((plrDocumentMaster.getAgeDocPath()==null)?plrDoc.getAgeDocPath():plrDocumentMaster.getAgeDocPath());
		plrDoc.setAddDocPath((plrDocumentMaster.getAddDocPath()==null)?plrDoc.getAddDocPath():plrDocumentMaster.getAddDocPath());
		plrDoc.setTaxIdDocPath((plrDocumentMaster.getTaxIdDocPath()==null)?plrDoc.getTaxIdDocPath():plrDocumentMaster.getTaxIdDocPath());
		
		plrDoc.setAgeDocUniqueNo((plrDocumentMaster.getAgeDocUniqueNo()==null)?plrDoc.getAgeDocUniqueNo():plrDocumentMaster.getAgeDocUniqueNo());
		plrDoc.setAddDocUniqueNo((plrDocumentMaster.getAddDocUniqueNo()==null)?plrDoc.getAddDocUniqueNo():plrDocumentMaster.getAddDocUniqueNo());
		plrDoc.setTaxIdDocUniqueNo((plrDocumentMaster.getTaxIdDocUniqueNo()==null)?plrDoc.getTaxIdDocUniqueNo():plrDocumentMaster.getTaxIdDocUniqueNo());
		
		if (!"-1".equals(plrDocumentMaster.getAgeDocType())) {
			plrDoc.setAgeDocType(plrDocumentMaster.getAgeDocType());

		}
		if (!"-1".equals(plrDocumentMaster.getAddDocType())) {
			plrDoc.setAddDocType(plrDocumentMaster.getAddDocType());

		}
		if (!"-1".equals(plrDocumentMaster.getTaxIdDocType())) {
			plrDoc.setTaxIdDocType(plrDocumentMaster.getTaxIdDocType());
		}
		session.saveOrUpdate(plrDoc);
		StPmPlayerMaster plrMas = (StPmPlayerMaster) session.get(StPmPlayerMaster.class, plrDocumentMaster.getPlayerId());
		plrMas.setAgeVerified("-1".equals(plrDocumentMaster.getAgeDocVerified())?"PENDING":plrDocumentMaster.getAgeDocVerified());
		plrMas.setAddressVerified("-1".equals(plrDocumentMaster.getAddDocVerified())?"PENDING":plrDocumentMaster.getAddDocVerified());
		plrMas.setTaxationIdVerified("-1".equals(plrDocumentMaster.getTaxIdDocVerified())?"PENDING":plrDocumentMaster.getTaxIdDocVerified());
		//if (plrDocumentMaster.isAgeDocVerified()) {
		//	plrMas.setVerificationMode(ConfigurationVariables.AGE_VERIFICATION_MODE_OFFLINE);
		//	plrMas.setVerificationStatus(ConfigurationVariables.AGE_VERIFICATION_STATUS_VERIFIED);
		//}
		session.update(plrMas);
		session.flush();
		session.clear();
		return "success";
	}
	/*public String saveOrUpdatePlrBankDoc(Session session, StPmPlrRdmDocMasterBean plrBankDocumentMaster) throws PMSException {
		StPmPlrRdmDocMaster stPmPlrRdmDocMaster = new StPmPlrRdmDocMaster();
		Criteria criteria = session.createCriteria(StPmPlrRdmDocMaster.class);
		criteria.add(Restrictions.eq("playerId", plrBankDocumentMaster.getPlayerId()));
		criteria.add(Restrictions.eq("redeemAccId", plrBankDocumentMaster.getRedeemAccId()));
		criteria.setProjection(Projections.property("docId"));
		List list = criteria.list();
		if (!list.isEmpty()) {
			stPmPlrRdmDocMaster.setDocId((long) list.get(0));
		}
		stPmPlrRdmDocMaster.setPlayerId(plrBankDocumentMaster.getPlayerId());
		stPmPlrRdmDocMaster.setRedeemAccId(plrBankDocumentMaster.getRedeemAccId());
		stPmPlrRdmDocMaster.setBankIdPath(plrBankDocumentMaster.getBankIdPath());
		stPmPlrRdmDocMaster.setIdentityIdPath(plrBankDocumentMaster.getIdentityIdPath());
		stPmPlrRdmDocMaster.setUploadedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		stPmPlrRdmDocMaster.setBankIdVerification(plrBankDocumentMaster.getBankIdVerification());
		stPmPlrRdmDocMaster.setIdentityIdVerification(plrBankDocumentMaster.getIdentityIdVerification());
		stPmPlrRdmDocMaster.setBankIdUniqueNo(plrBankDocumentMaster.getBankIdUniqueNo());
		stPmPlrRdmDocMaster.setIdentityIdUniqueNo(plrBankDocumentMaster.getIdentityIdUniqueNo());
		session.saveOrUpdate(stPmPlrRdmDocMaster);
		session.flush();
		session.clear();
		return "success";
	}
*/
	@SuppressWarnings("unchecked")
	public List<TemplateMasterBean> fetchAvailableTemplate(short domainId,short aliasId,String sentOn,
			Session session) {
		List<TemplateMasterBean> tempList =  new ArrayList<TemplateMasterBean>();
		Criteria cri = session
				.createCriteria(StCmsTemplateMaster.class)
				.setProjection(
						Projections.distinct(Projections.projectionList().add(
								Projections.property("templateSubject"),
								"templateSubject")))
				.setResultTransformer(
						Transformers.aliasToBean(StCmsTemplateMaster.class));
		cri.add(Restrictions.eq("domainId", domainId));
		cri.add(Restrictions.eq("aliasId", aliasId));
		if(!("BOTH".equals(sentOn)))
			cri.add(Restrictions.eq("sentOn", sentOn));
		cri.add(Restrictions.eq("mode", "EMAIL"));
		cri.add(Restrictions.eq("templateType", "BO_USE"));
		cri.add(Restrictions.eq("status", "ACTIVE"));
		List<StCmsTemplateMaster> list = cri.list();
		if (list.size() > 0) {
			TemplateMasterBean bean = null;
			for (StCmsTemplateMaster temp : list) {
				bean = new TemplateMasterBean();
				bean.setTemplateSubject(temp.getTemplateSubject());
				tempList.add(bean);
			}
		}

		return tempList;
	}

	
	@SuppressWarnings("unchecked")
	public String getServiceUrl(short aliasId, Session session ) throws PMSException{
		String serviceUrl = null;
		String contentDomainName = null;
		Criteria cri = session.createCriteria(StDmAliasPropertyMaster.class);
		cri.add(Restrictions.eq("aliasId", aliasId));
		cri.add(Restrictions.eq("propertyName", "JOOMLA_EMAIL_TEMPLATE"));
		cri.setProjection(Projections.property("propertyValue"));
		List<Object> list = cri.list();
		if(list.size()>0) {
			serviceUrl = (String)list.get(0);
		}
		cri = session.createCriteria(StDmDomainAliasNameMaster.class);
		cri.add(Restrictions.eq("aliasId", aliasId));
		cri.setProjection(Projections.property("privateUrl"));
		list = cri.list();
		if(list.size()>0) {
			contentDomainName =  (String)list.get(0);
		} else {
			throw new PMSException("Invalid Alias Id");
		}
		if(serviceUrl!=null && contentDomainName!=null) {
			return contentDomainName+serviceUrl;
		} 
		return null;
	}
	
	
	
	/*@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList plrSearchForAutoVerification(Short domainId,
			String firstName, String lastName, String userName,
			String verificationStatus, Session session, int recordPerPage,
			int paginationPage) throws PMSException {
		ArrayList finalResult = new ArrayList();
		int count = 0;
		int index = 1;
		Criteria cri = session.createCriteria(StPmPlayerMaster.class);
		if (domainId != -1) {
			cri.add(Restrictions.eq("domainId", domainId));
		}
		if (firstName != null && !"".equals(firstName)) {
			cri.add(Restrictions.like("firstName", firstName,
					MatchMode.ANYWHERE));
		}
		if (lastName != null && !"".equals(lastName)) {
			cri.add(Restrictions.like("lastName", lastName, MatchMode.ANYWHERE));
		}
		if (userName != null && !"".equals(userName)) {
			cri.add(Restrictions.like("userName", userName, MatchMode.ANYWHERE));
		}
		cri.add(Restrictions.eq("verificationStatus", verificationStatus));
		cri.add(Restrictions.not(Restrictions.eq("status", "TERMINATE")));

		ScrollableResults scrollable = cri.setCacheMode(CacheMode.IGNORE)
				.scroll(ScrollMode.FORWARD_ONLY);
		scrollable.last();
		// count = 1000;
		count = scrollable.getRowNumber() + 1;
		// count = cri.list().size();
		if (paginationPage > 0) {
			index = (paginationPage - 1) * recordPerPage + 1;
			cri.setFirstResult(index - 1);
		}
		cri.setMaxResults(recordPerPage);

		List<StPmPlayerMaster> list = cri.list();
		for (StPmPlayerMaster stPmPlayerMaster : list) {
			
			 * Overriding total withdrawal with actual withdrawal
			 
			stPmPlayerMaster.getPlayerWallet().setTotalWithdrawal(
					new BOCashierDaoImpl().getProcessedWithdrawal(
							stPmPlayerMaster.getPlayerId(), session));
		}
		finalResult.add(list);
		finalResult.add(count);
		finalResult.add(recordPerPage);
		finalResult.add(paginationPage);
		return finalResult;
	}*/

	public StPmPlayerMaster plrTerminate(long playerId, Session session)
			throws PMSException {
		StPmPlayerMaster plrmaster = (StPmPlayerMaster) session.get(
				StPmPlayerMaster.class, playerId);
		plrmaster.setPlrStatus("TERMINATE");
		session.update(plrmaster);
		return plrmaster;
	}

	public StPmPlayerMaster plrMannualVerifyCancelPlr(long playerId,
			String veriAction, Session session) throws PMSException {
		StPmPlayerMaster plrmaster = (StPmPlayerMaster) session.get(
				StPmPlayerMaster.class, playerId);
		if (veriAction
				.equals(ConfigurationVariables.AGE_VERIFICATION_STATUS_VERIFIED)) {
			plrmaster.setPlrStatus(ConfigurationVariables.PLAYER_LOGIN_ACTIVE);
		} else {
			plrmaster.setPlrStatus(ConfigurationVariables.PLAYER_LOGIN_INACTIVE);
		}
		plrmaster.setVerificationStatus(veriAction);
		plrmaster
				.setVerificationMode(ConfigurationVariables.AGE_VERIFICATION_MODE_OFFLINE);
		session.update(plrmaster);
		return plrmaster;
	}

	public void saveTemplatePage(PlrMailContentBean plrEmailBean,
			StatelessSession session) throws PMSException {
		StPmPlayerInboxMaster plrInboxMaster = null;
		try {
			plrInboxMaster = new StPmPlayerInboxMaster();
			plrInboxMaster.setDomainId(plrEmailBean.getDomainVal());
			plrInboxMaster.setStared("N");
			plrInboxMaster.setSubject(plrEmailBean.getSubject());
			if(("PORTALCONTENT").equals(plrEmailBean.getContentType()) && ("manually").equals(plrEmailBean.getEmailType())){
				plrInboxMaster.setTemplateName(plrEmailBean.getFileName());
				if (plrEmailBean.getFileName().contains(".html")) {
					plrInboxMaster.setEmailType("SPECIFIC");
				} else {
					plrInboxMaster.setEmailType("TEMPLATE");
				}
			}
			else{
//				plrInboxMaster.setTemplateName(String.valueOf(plrEmailBean.getTempId()));
				plrInboxMaster.setTemplateName(plrEmailBean.getTempUrl()+"#"+plrEmailBean.getTempId());
				plrInboxMaster.setEmailType("TEMPLATE");
			}
			plrInboxMaster.setSentDate(new Timestamp(Calendar.getInstance()
					.getTimeInMillis()));
			plrInboxMaster.setUserId(plrEmailBean.getBoUser());
			plrInboxMaster.setEmailStatus("UNREAD");
			plrInboxMaster.setAliasId(plrEmailBean.getAliasId());
			StPmPlayerInboxMaster newPlrInbox = null;
			for (Long playerId : plrEmailBean.getPlayerIdArr()) {
				newPlrInbox = plrInboxMaster.clone();
				newPlrInbox.setPlayerId(playerId);
				session.insert(newPlrInbox);
			}
		} catch (HibernateException he) {
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (Exception he) {
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		}

	}

	
	@SuppressWarnings("unchecked")
	public String fetchTemplateByName(short domainId, short aliasId,String subject,String sentOn,
			Session session) throws PMSException {
		List<StCmsTemplateMaster> temp = null;
		try {
			Criteria cri = session.createCriteria(StCmsTemplateMaster.class);
			cri.add(Restrictions.eq("domainId", domainId));
			cri.add(Restrictions.eq("aliasId", aliasId));
			cri.add(Restrictions.eq("templateSubject", subject));
			if(!("both".equals(sentOn)))
				cri.add(Restrictions.eq("sentOn",sentOn));
			cri.add(Restrictions.eq("status", "ACTIVE"));
			temp = cri.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Error");
		}
		return temp.get(0).getTemplatePath();
	}

	@SuppressWarnings("unchecked")
	public Map<String,Set<String>> getPlayerDeviceId(short lastAliasId,Long[] playerId, String appType,
			Session session) throws PMSException {
		logger.info("INside :getPlayerDeviceId------------------");
		Map<String, Set<String>> retMap = new HashMap<String, Set<String>>();
		List<StPmPlrLoginStatus> loginStaList = null;
		Criteria criteria = null;
		criteria = session.createCriteria(StPmPlrLoginStatus.class);
		criteria.add(Restrictions.in("playerId", playerId));
		criteria.add(Restrictions.eq("lastAliasId",lastAliasId));
		criteria.add(Restrictions.eq("appType", appType));
		loginStaList = criteria.list();
		Comparator<StPmPlrLoginStatus> plrStatCom=new Comparator<StPmPlrLoginStatus>() {
			public int compare(StPmPlrLoginStatus o1, StPmPlrLoginStatus o2) {
				long diff=o1.getLastActivityDate().getTime()-o2.getLastActivityDate().getTime();
				return diff>0?1:(diff==0?0:-1);
			};
		};
		Map<Long, TreeSet<StPmPlrLoginStatus>> processedMap=new HashMap<Long, TreeSet<StPmPlrLoginStatus>>(); 
		//storing playerId and playerLoginStatus set in sorted ascending order by last activity...
		if(loginStaList.size()!=0){
			for (StPmPlrLoginStatus plrStat : loginStaList) {
				if (plrStat.getDeviceId() != null){
					if(processedMap.containsKey(plrStat.getPlayerId())){
						processedMap.get(plrStat.getPlayerId()).add(plrStat);
					} else {
						TreeSet<StPmPlrLoginStatus> initSet=new TreeSet<StPmPlrLoginStatus>(plrStatCom);
						initSet.add(plrStat);
						processedMap.put(plrStat.getPlayerId(), initSet);	
					}
				}
			}
		}		
		int count=0;
		if (processedMap.size() != 0) {
			for (Entry<Long, TreeSet<StPmPlrLoginStatus>> e: processedMap.entrySet()) {
				StPmPlrLoginStatus plrStatus=e.getValue().descendingSet().first();	
				if (retMap.containsKey(plrStatus.getAppType().split("_")[0])) {
					retMap.get(plrStatus.getAppType().split("_")[0]).add(plrStatus.getDeviceId());
					count++;
				} else {
					Set<String> initSet = new HashSet<String>();
					initSet.add(plrStatus.getDeviceId());
					count++;
					retMap.put(plrStatus.getAppType().split("_")[0], initSet);
				}
			}
		}
		logger.info("======================= GCMID COUNT:"+count+"=========================");
		return retMap;
	}
	
	public String fetchContentType(short aliasId, Session session) throws PMSException {
		List<StDmDomainAliasNameMaster> temp1=null;
		try {
			
			Criteria cri = session.createCriteria(StDmDomainAliasNameMaster.class);
			cri.add(Restrictions.eq("aliasId", aliasId));
			temp1 =cri.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Error");
		}
		if(temp1.size()!=0){
			return temp1.get(0).getContentType();
		}else
			return "";
	}

	public void insertJoomlaTemplate(PlrMailContentBean plrEmailBean, Session session) {
		Criteria cri = session.createCriteria(StCmsTemplateMaster.class);
		cri.add(Restrictions.eq("templateSubject",plrEmailBean.getSubject()+"#"+plrEmailBean.getTempId()));
		@SuppressWarnings("unchecked")
		List<StCmsTemplateMaster> list = cri.list();
		if (list.size() < 1) {
			Timestamp currTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
			StCmsTemplateMaster insertTemp;
			insertTemp = new StCmsTemplateMaster();
			insertTemp.setTemplateId(Integer.parseInt(plrEmailBean.getTempId()));
			insertTemp.setAliasId(plrEmailBean.getAliasId());
			insertTemp.setDomainId(plrEmailBean.getDomainVal());
			insertTemp.setMode("EMAIL");
			insertTemp.setStatus("ACTIVE");
			insertTemp.setTemplateType("BO_USE");
			insertTemp.setSentOn("EXTERNAL");
			insertTemp.setTemplateSubject(plrEmailBean.getSubject()+"#"+plrEmailBean.getTempId());
			insertTemp.setTemplateFromName("KhelPlay Team");
			insertTemp.setTemplateFromEmail(plrEmailBean.getFrom());
			insertTemp.setTemplatePath(plrEmailBean.getTempUrl());
			insertTemp.setCreatedBy((long) plrEmailBean.getBoUser());
			StGenLanguageMaster langMstr = new StGenLanguageMaster();
			langMstr.setLanguageId(1);
			insertTemp.setLangMaster(langMstr);
			insertTemp.setLastUpdatedBy((long) plrEmailBean.getBoUser());
			insertTemp.setCreationTime(currTime);
			insertTemp.setLastUpdationTime(currTime);
			session.save(insertTemp);
		}	
		
	}
	public StPmPlayerMaster fetchPlayerByMobile(String mobile,short domainId, Session session) throws PMSException {
		List<StPmPlayerMaster> list=null;
		
		Criteria cri = session.createCriteria(StPmPlayerMaster.class);
		cri.add(Restrictions.eq("mobileNo",Long.valueOf(mobile)));
		if(domainId!=0)
		cri.add(Restrictions.eq("domainId",domainId));
		list = cri.list();
		if(list.size()<1) {
			throw new PMSException(0,"No User Available With Given Mobile Number ");
		}
	
		
	
		return list.get(0);
	}

	public void savePassword(String pass,Long playerId, Session session) throws PMSException {
		StPmPlayerMaster stPmPlayerMaster=null;
		Transaction tx =null;
		try {
		 tx = session.beginTransaction();
		 stPmPlayerMaster = (StPmPlayerMaster) session.load(StPmPlayerMaster.class, playerId);
		stPmPlayerMaster.setPassword(MD5.encode(pass));
	    session.update(stPmPlayerMaster);
		}catch(Exception e) {
			e.printStackTrace();
			throw new PMSException("Hibernate Error");
		}
	    tx.commit();
	    session.close();
	}
	@SuppressWarnings({ "unchecked" })
	public List<Object> redPlrSearchForUploadDocument(short domainId, short aliasId,
			Long playerId, String userName, String status, String uploadStartDate, String uploadEndDate, Session session)
	{
		String str = "";
		Query qry;
		str = "select Date_Format(dm.uploadedDate,'%d/%m/%Y'),pm.userName,pm.playerId,dm.redeemAccId,dm.bankIdVerification,dm.identityIdVerification from StPmPlayerMaster pm,"
				+ "StPmPlrRdmDocMaster dm where pm.playerId=dm.playerId";
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		Date date = new Date();
		Date startDate = new Date();
		Date endDate = new Date();
		if (domainId != -1) {
			str = str + " and pm.domainId = (:domainId) ";
		}
		if (status != null && !"ALL".equals(status)) {
			str = str + "and (dm.bankIdVerification = (:status) or dm.identityIdVerification = (:status))";
		}
		if ((uploadStartDate == null || "null".equals(uploadStartDate) || "".equals(uploadStartDate)
				|| "undefined".equals(uploadStartDate) || " undefined".equals(uploadStartDate))
				&& ("".equals(userName) && (aliasId == -1 || aliasId == 0)
						&& ("null".equals(uploadEndDate) || "".equals(uploadEndDate)
								|| " undefined".equals(uploadEndDate) || "undefined".equals(uploadEndDate)))) {
			c.add(Calendar.DAY_OF_YEAR, -6);
			date = c.getTime();
			str = str + " and dm.uploadedDate >= (:date)";
		} else {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			if (aliasId != -1 && aliasId != 0) {
				str = str + " and pm.aliasId = '" + aliasId + "'";
			}
			if (userName != null && !"".equals(userName)) {
				str = str + " and pm.userName like '" + userName + "'";
			}
			if (!"null".equals(uploadStartDate) && !"".equals(uploadStartDate) && !" undefined".equals(uploadStartDate)
					&& !"undefined".equals(uploadStartDate)) {
				try {
					startDate = df.parse(uploadStartDate);
					c.setTime(startDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				startDate = c.getTime();
				str = str + " and dm.uploadedDate >= (:startDate)";
			}
			if (!"null".equals(uploadEndDate) && !"".equals(uploadEndDate) && !" undefined".equals(uploadEndDate)
					&& !"undefined".equals(uploadEndDate)) {
				try {
					endDate = df.parse(uploadEndDate);
					c1.setTime(endDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				endDate = c1.getTime();
				str = str + " and dm.uploadedDate <= (:endDate)";
			}
		}
		str = str + " order by dm.uploadedDate desc";
		qry = session.createQuery(str);
		if (domainId != -1) {
			qry.setParameter("domainId", domainId);
		}
		if (status != null && !"ALL".equals(status)) {
			qry.setParameter("status", status);
		}
		if ((uploadStartDate == null || "null".equals(uploadStartDate) || "".equals(uploadStartDate)
				|| "undefined".equals(uploadStartDate) || " undefined".equals(uploadStartDate))
				&& ("".equals(userName) && (aliasId == -1 || aliasId == 0)
						&& ("null".equals(uploadEndDate) || "".equals(uploadEndDate)
								|| " undefined".equals(uploadEndDate) || "undefined".equals(uploadEndDate))))
			qry.setParameter("date", date);
		if (!"null".equals(uploadStartDate) && !"".equals(uploadStartDate) && !" undefined".equals(uploadStartDate)
				&& !"undefined".equals(uploadStartDate))
			qry.setParameter("startDate", startDate);
		if (!"undefined".equals(uploadEndDate) && !"null".equals(uploadEndDate) && !"".equals(uploadEndDate)
				&& !" undefined".equals(uploadEndDate))
			qry.setParameter("endDate", endDate);

		return qry.list();

	}

	

	/*public StPmPlrRdmDocMasterBean getRdmBankDocumentDetail(Long playerId, Long redeemAccId, Session session)throws PMSException {
		List<StPmPlrRdmDocMaster> list = null;
		StPmPlrRdmDocMasterBean plrRdmDocMasterBean = null;
		try {
			Criteria criteria = session.createCriteria(StPmPlrRdmDocMaster.class);
			criteria.add(Restrictions.eq("playerId", playerId));
			criteria.add(Restrictions.eq("redeemAccId", redeemAccId));
			list = criteria.list();
			if (list.size() == 1) {
				for (StPmPlrRdmDocMaster docMaster : list) {
					plrRdmDocMasterBean = new StPmPlrRdmDocMasterBean();
					plrRdmDocMasterBean.setPlayerId(docMaster.getPlayerId());
					plrRdmDocMasterBean.setRedeemAccId(docMaster.getRedeemAccId());
					if (docMaster.getBankIdPath() != null) {
						plrRdmDocMasterBean.setBankIdPath(docMaster.getBankIdPath());
						plrRdmDocMasterBean.setBankIdUniqueNo(docMaster.getBankIdUniqueNo());
						plrRdmDocMasterBean.setBankIdVerification(docMaster.getBankIdVerification());
					}
					if (docMaster.getIdentityIdPath() != null) {
						plrRdmDocMasterBean.setIdentityIdPath(docMaster.getIdentityIdPath());
						plrRdmDocMasterBean.setIdentityIdUniqueNo(docMaster.getIdentityIdUniqueNo());
						plrRdmDocMasterBean.setIdentityIdVerification(docMaster.getIdentityIdVerification());
					}

				}
			} else {
				throw new PMSException("Document not found");
			}
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);				
			throw new PMSException("Hibernate Exception");
		}
		return plrRdmDocMasterBean;
	}*/
	
}