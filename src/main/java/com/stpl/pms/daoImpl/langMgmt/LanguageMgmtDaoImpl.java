package com.stpl.pms.daoImpl.langMgmt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.StGenLanguageMaster;
import com.stpl.pms.hibernate.mapping.StGenWordSentenceLanguageMapping;
import com.stpl.pms.hibernate.mapping.StGenWordSentenceMaster;

public class LanguageMgmtDaoImpl {
	
	
	
	@SuppressWarnings("unchecked")
	public Map<Integer, String> getActiveLanguages(Session session) throws PMSException{
		
		Map<Integer, String> result = new HashMap<Integer, String>();;
		Criteria criteria = null;
		try{
		criteria = session.createCriteria(StGenLanguageMaster.class).setProjection(Projections.projectionList().add(Projections.property("languageId")).add(Projections.property("languageCode"))).add(Restrictions.eq("status", "Active"));
		List<Object> list = criteria.list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object object[] =  (Object[]) iterator.next();

			result.put((Integer) object[0], object[1].toString());
		}
		}catch (HibernateException e) {
		e.printStackTrace();
		throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION);
		}
		
		return result;
		
		
	}
	
//	public String fetchLastCode() throws PMSException{
//		
//		String result = null;
//		try{
//			
//			result = session.createCriteria(StGenWordSentenceMaster.class).setProjection(Projections.max("wordSentenceId")).setProjection(Projections.property("wordSentenceCode"));
//			
//		}catch (Exception e) {
//			throw new PMSException("Unknown Error"); 
//		}
//		
//		return result;
//		
//	}
	
	public Integer insertNewWordSentence(StGenWordSentenceMaster wordSentence,
			Map<Integer, String> mapId, Session session) throws PMSException {
		
		StGenWordSentenceLanguageMapping mapping = null;
	
		Integer lastCode = null;
		Criteria criteria = null;
		
		try{
			criteria = session.createCriteria(StGenWordSentenceMaster.class).setProjection(Projections.max("wordSentenceCode"));
			List<Integer> list =  criteria.list();
			if(list.get(0)==null)
				lastCode = 100001;
			else{
				lastCode = list.get(0);
				lastCode++;
			}
			wordSentence.setWordSentenceCode(lastCode);
			
			session.save(wordSentence);
			
			
			for (Map.Entry<Integer, String> entry : mapId.entrySet()) {
				
			
				mapping = new StGenWordSentenceLanguageMapping();
				mapping.setStGenWordSentenceMaster(wordSentence);
				mapping.setTranslatedString(entry.getValue());
				mapping.setTranslationLanguageId(entry.getKey());
				mapping.setTranslationChanged("N");
				session.save(mapping);
			}
			
			
		}catch (HibernateException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_HIBERNATE_EXCEPTION,PMSErrorMessage.GEN_HIBERNATE_EXCEPTION); 
		}
		
		return lastCode;
	}

	public Map<Integer, StGenWordSentenceLanguageMapping > fetchGLobalProperties(Session session) throws PMSException {
			
		Map<Integer, StGenWordSentenceLanguageMapping> map = new HashMap<Integer, StGenWordSentenceLanguageMapping>();
//		Criteria criteria = null;
//		StGenWordSentenceLanguageMapping stGenWordSentenceLanguageMapping;
//		try{
//			criteria = session.createCriteria(StGenWordSentenceLanguageMapping.class,"mapping");
//			criteria.createAlias("mapping.stGenWordSentenceMaster", "stGenWordSentenceMaster");
//			criteria.add(Restrictions.eq("stGenWordSentenceMaster.checkReq", "N"));
//			criteria.setProjection(Projections.projectionList().add(Projections.property("stGenWordSentenceMaster.wordSentenceCode")).add(Projections.property("mapping.languageCode")).add(Projections.property("mapping.convertedString")));
//			List<Object> list = criteria.list();
//			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//				stGenWordSentenceLanguageMapping = new StGenWordSentenceLanguageMapping();
//				Object object[] =  (Object[]) iterator.next();
//				stGenWordSentenceLanguageMapping.setLanguageCode((String) object[1]);
//				stGenWordSentenceLanguageMapping.setConvertedString((String) object[2]);
//				map.put(Integer.parseInt(object[0].toString()), stGenWordSentenceLanguageMapping );
//			}
//			
//		}catch (HibernateException e) {
//			e.printStackTrace();
//			throw new PMSException("Unknown Error"); 
//		}
		
		return map;
		
		
	}
	
	
}
