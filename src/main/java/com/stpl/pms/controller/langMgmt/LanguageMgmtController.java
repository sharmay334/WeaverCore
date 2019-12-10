package com.stpl.pms.controller.langMgmt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.daoImpl.langMgmt.LanguageMgmtDaoImpl;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.StGenWordSentenceMaster;
import com.stpl.pms.utility.Utility;

public class LanguageMgmtController {

	private static final Logger log = Logger
			.getLogger(LanguageMgmtController.class);

	public Integer insertNewWordSentence(StGenWordSentenceMaster wordSentence) throws PMSException {

		Integer resultCode = null;
		Session session = null;
		Transaction tx = null;
		LanguageMgmtDaoImpl service = new LanguageMgmtDaoImpl();
		String apiKey = "AIzaSyBeSXZZ_jfMH7POQ_tzs_5Og4Ekxd_c9SE";
		BufferedReader in = null;
		Map<Integer, String> langCodes = null;
		Map<Integer, String> mapId = new HashMap<Integer, String>();
		Map<String, String> mapCode = new HashMap<String, String>();

		String string = null;
		String requestURL = null;
		String translatedText = null;
		int currentLangId = wordSentence.getWordSentenceLanguageId();
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			langCodes = service.getActiveLanguages(session);
			String language = langCodes.get(currentLangId);
			langCodes.remove(currentLangId);
			/*
			 * Language API Call to be made here which will give converted
			 * strings to the corressponding Language Ids
			 */
			string = wordSentence.getWordSentence();

			for (Map.Entry<Integer, String> entry : langCodes.entrySet()) {
				requestURL = "https://www.googleapis.com/language/translate/v2?key="
						+ apiKey
						+ "&q="
						+ URLEncoder.encode(string,"UTF-8")
						+ "&source=" + language + "&target=" + entry.getValue();
				URL url = new URL(requestURL);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setRequestMethod("GET");
				connection.setDoInput(true);
				connection.setDoOutput(true);
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(3000);
				in = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));
				String json;
				String response = "";
				while ((json = in.readLine()) != null) {
					response += json;
				}
				log.info(response);

				JsonElement jelement = new JsonParser().parse(response);
				JsonObject jobject = jelement.getAsJsonObject();
				jobject = jobject.getAsJsonObject("data");
				JsonArray jarray = jobject.getAsJsonArray("translations");
				jobject = jarray.get(0).getAsJsonObject();
				translatedText = jobject.get("translatedText").toString();

				mapId.put(entry.getKey(), translatedText.replace("\"", ""));
				mapCode.put(entry.getValue(), translatedText.replace("\"", ""));

			}
			resultCode = service.insertNewWordSentence(wordSentence, mapId,
					session);
			mapCode.put(language, string);
			String defultPath = CommonMethodDaoImpl.getInstance().fetchSystemProperties("DEFAULT_CONTENT_PATH",session);
			for (Map.Entry<String, String> entry : mapCode.entrySet()) {
				Utility.callUrl(defultPath+"updateGp", "language="+entry.getKey()+"&resultCode="+resultCode+"&value="+ URLEncoder.encode(entry.getValue().replaceAll(",", "\\\\,"),"UTF-8"));
			}

			tx.commit();
		} catch (PMSException e) {
			tx.rollback();
			throw new PMSException("--Error in updating global Properties or insert word--");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new PMSException("--Error in updating global Properties or insert word--");
		} catch (ProtocolException e) {
			e.printStackTrace();
			throw new PMSException("--Error in updating global Properties or insert word--");
		} catch (IOException e) {
			e.printStackTrace();
			throw new PMSException("--Error in updating global Properties or insert word--");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("--Error in updating global Properties or insert word--");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return resultCode;

	}

	public Integer getDisplayCode(String fieldDispName, int i,
			int currentLocale, Short domainId) throws PMSException {

		Integer fieldDispCode = null;
		PropertiesConfiguration props = Utility.fetchGlobalProperties();
		Map<String, String> map = new HashMap<String, String>();
		for (Iterator<String> iterator = props.getKeys(); iterator.hasNext();) {
			String key = iterator.next();
			if(!map.containsKey(props.getString(key))){
				map.put(props.getString(key), key);
			}
		}

		if (!map.containsKey(fieldDispName)) {
			StGenWordSentenceMaster wordSentence = null;
			int baseLangId = 1;
			wordSentence = new StGenWordSentenceMaster();

			wordSentence.setWordSentence(fieldDispName);

			wordSentence.setWordSentenceLanguageId(currentLocale);
			wordSentence
					.setEnteredDateTime(new Timestamp(new Date().getTime()));
			wordSentence.setEnteredByUserType("BO");
			wordSentence.setEnteredByUserId((long) 1);
			if (baseLangId == currentLocale) {
				wordSentence.setBaseLangReviewed("Y");
				wordSentence.setBaseLangReviewdDateTime(new Timestamp(
						new Date().getTime()));
				wordSentence.setBaseLangReviewedUserId(1);
				wordSentence.setBaseLangTranslatedWord(fieldDispName);
				wordSentence.setBaseLangWordChanged("N");
			}
			fieldDispCode = insertNewWordSentence(wordSentence);
		} else {
			fieldDispCode = fetchWordSentence(map.get(fieldDispName)
					.substring(7),currentLocale,fieldDispName);
//			fieldDispCode = Integer.parseInt(map.get(fieldDispName)
//					.substring(7));
		}
		return fieldDispCode;
	}
	
	public Integer fetchWordSentence(String wordCode,int currentLocale,String fieldDispName) throws PMSException{
		Integer fieldDispCode = null;
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Criteria cri = session.createCriteria(StGenWordSentenceMaster.class);
			cri.add(Restrictions.eq("wordSentenceCode", Integer.valueOf(wordCode)));
			@SuppressWarnings("unchecked")
			List<StGenWordSentenceMaster> wordList = cri.list();
			if(wordList.size()>0){
				fieldDispCode = wordList.get(0).getWordSentenceCode();
			}else{
				StGenWordSentenceMaster wordSentence = new StGenWordSentenceMaster();
				int baseLangId = 1;
				wordSentence.setWordSentence(fieldDispName);
				wordSentence.setWordSentenceLanguageId(currentLocale);
				wordSentence
						.setEnteredDateTime(new Timestamp(new Date().getTime()));
				wordSentence.setEnteredByUserType("BO");
				wordSentence.setEnteredByUserId((long) 1);
				fieldDispCode = Integer.valueOf(wordCode);
				if (baseLangId == currentLocale) {
					wordSentence.setBaseLangReviewed("Y");
					wordSentence.setBaseLangReviewdDateTime(new Timestamp(
							new Date().getTime()));
					wordSentence.setBaseLangReviewedUserId(1);
					wordSentence.setBaseLangTranslatedWord(fieldDispName);
					wordSentence.setBaseLangWordChanged("N");
					wordSentence.setWordSentenceCode(fieldDispCode);
					
				}
				session.save(wordSentence);
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw new PMSException("Hibernate Exception");
		}catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
			throw new PMSException("Some Internal Error");
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return fieldDispCode;
	}
}
