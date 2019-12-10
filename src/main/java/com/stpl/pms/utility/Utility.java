package com.stpl.pms.utility;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.RoundingMode;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.net.util.SubnetUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.jboss.vfs.VirtualFile;
import org.jfree.util.Log;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Subdivision;
import com.stpl.pms.controller.commonMethods.CommonMethodController;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.StCshProviderProcessingChargeMaster;
import com.stpl.pms.hibernate.mapping.StPmPlayerMaster;
import com.stpl.pms.javabeans.BetGamesTokenBean;
import com.stpl.pms.javabeans.CurrencyConversionDefBean;
import com.stpl.pms.javabeans.LocationDetailBean;
import com.stpl.pms.javabeans.PlayerInfoBean;
import com.stpl.pms.uaparser.Client;
import com.stpl.pms.uaparser.Parser;

public class Utility {
	private static final Logger logger = Logger.getLogger(Utility.class);
	public static final DecimalFormat twoDigitFmt = new DecimalFormat("0.00");
	public static Map<String, BetGamesTokenBean> betSoftTokenMap;
	public static Map<String, BetGamesTokenBean> betGamesTokenMap;
	public static Map<String, String> sheriffTokenMap;
	private static String BUILD_VERSION = null;

	public static enum txnControlTypes {
		DEPOSIT, WITHDRAWAL, WAGER_CASINO, WAGER_RUMMY, WAGER_SPORTS, WAGER_BINGO, WAGER_POKER, WAGER_LIVE_CASINO,WAGER_GAMES,WAGER_DRAW_GAMES,WAGER_SPORTS_LOTTERY,WAGER_INSTANT_DRAW,WAGER_GOLDEN_RACE
	}

	public static PropertiesConfiguration fetchGlobalProperties() throws PMSException {
		PropertiesConfiguration props;
		try {
			if(CommonMethodController.getInstance().fetchSystemProperties("GLOBAL_PROPERTIES_FLAG").equals("Y"))
				props =new PropertiesConfiguration(new URL(CommonMethodController.getInstance().fetchSystemProperties("DEFAULT_CONTENT_PATH")+ "GLOBAL_PROPERTIES/global.properties"));
			else 
				props =new PropertiesConfiguration("globalPortalContent.properties");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new PMSException("--Problem in loading global Properties--");
		} catch (ConfigurationException e) {
			e.printStackTrace();
			throw new PMSException("--Problem in loading global Properties--");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("--Problem in loading global Properties--");
		}
		return props;
	}

	public static PropertiesConfiguration fetchGlobalProperties(Session session) throws PMSException {
		PropertiesConfiguration props;
		try {
			if(CommonMethodDaoImpl.getInstance().fetchSystemProperties("GLOBAL_PROPERTIES_FLAG",session).equals("Y"))
				props =new PropertiesConfiguration(new URL(CommonMethodDaoImpl.getInstance().fetchSystemProperties("DEFAULT_CONTENT_PATH",session)+ "GLOBAL_PROPERTIES/global.properties"));
			else 
				props =new PropertiesConfiguration("globalPortalContent.properties");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new PMSException("--Problem in loading global Properties--");
		} catch (ConfigurationException e) {
			e.printStackTrace();
			throw new PMSException("--Problem in loading global Properties--");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException("--Problem in loading global Properties--");
		}
		return props;
	}


	//	public static CurrencyConversionDefBean fetchCurrencyExchangeBean(
	//			int frmCurId, int toCurId) throws PMSException {
	//		CurrencyConversionDefBean curBean = null;
	//		CommonMethodController controller = CommonMethodController.getInstance();
	//		int baseCurId = Integer.parseInt(controller.fetchSystemProperties("NATIVE_CURRENCY"));
	//		if (baseCurId == frmCurId) {
	//			curBean = controller.fetchUpdateCurrencyConversionRate(frmCurId,toCurId);
	//		} else {
	//			CurrencyConversionDefBean frmCurBean = controller.fetchUpdateCurrencyConversionRate(baseCurId,frmCurId);
	//			CurrencyConversionDefBean toCurBean = controller.fetchUpdateCurrencyConversionRate(baseCurId,toCurId);
	//			if (frmCurBean != null && toCurBean != null) {
	//				curBean = new CurrencyConversionDefBean();
	//				curBean.setCurrencyId(toCurBean.getCurrencyId());
	//				curBean.setExchangeChargeCurrId(toCurBean
	//						.getExchangeChargeCurrId());
	//				curBean.setExchangeCharge(toCurBean.getExchangeCharge());
	//				curBean.setExchangeRate(toCurBean.getExchangeRate()
	//						/ frmCurBean.getExchangeRate());
	//			}
	//		}
	//		if (curBean == null) {
	//			throw new PMSException("Exchange Rate Not Available");
	//		}
	//		return curBean;
	//	}

	public static CurrencyConversionDefBean fetchCurrencyExchangeBean(
			int frmCurId, int toCurId,Session session) throws PMSException {
		CurrencyConversionDefBean curBean = null;
		CommonMethodDaoImpl daoImpl = CommonMethodDaoImpl.getInstance();
		int baseCurId = Integer.parseInt(daoImpl.fetchSystemProperties("NATIVE_CURRENCY",session));
		if (baseCurId == frmCurId) {
			curBean = daoImpl.fetchUpdateCurrencyConversionRate(frmCurId,toCurId,session);
		} else {
			CurrencyConversionDefBean frmCurBean = daoImpl.fetchUpdateCurrencyConversionRate(baseCurId,frmCurId,session);
			CurrencyConversionDefBean toCurBean = daoImpl.fetchUpdateCurrencyConversionRate(baseCurId,toCurId,session);
			if (frmCurBean != null && toCurBean != null) {
				curBean = new CurrencyConversionDefBean();
				curBean.setCurrencyId(toCurBean.getCurrencyId());
				curBean.setExchangeChargeCurrId(toCurBean
						.getExchangeChargeCurrId());
				curBean.setExchangeCharge(toCurBean.getExchangeCharge());
				curBean.setExchangeRate(toCurBean.getExchangeRate()
						/ frmCurBean.getExchangeRate());
			}
		}
		if (curBean == null) {
			throw new PMSException("Exchange Rate Not Available");
		}
		return curBean;
	}

	public static double calculateProcessingCharge(
			StCshProviderProcessingChargeMaster chargeMas, double amount,
			int toCurrencyId, short domainId,Session session) throws PMSException {
		double charge = 0.0;
		CommonMethodDaoImpl daoImpl = CommonMethodDaoImpl.getInstance();
		try {
			int fromCurrencyId = Integer.parseInt(daoImpl.getDmProperty(session,domainId, "currencyId"));
			CurrencyConversionDefBean nativCurrConvBean = fetchCurrencyExchangeBean(toCurrencyId, fromCurrencyId,session);
			amount = amount * nativCurrConvBean.getExchangeRate();
			double charge1 = 0.0;
			double charge2 = 0.0;
			if (chargeMas.getCharge1Type() != null
					&& chargeMas.getCharge1Value() != null) {
				charge1 = "FIXED".equals(chargeMas.getCharge1Type()) ? chargeMas
						.getCharge1Value()
						: "PERCENT".equals(chargeMas.getCharge1Type()) ? (amount
								* chargeMas.getCharge1Value() / 100)
								: 0.0;
			}

			if (chargeMas.getCharge2Type() != null
					&& chargeMas.getCharge2Value() != null) {
				charge2 = "FIXED".equals(chargeMas.getCharge2Type()) ? chargeMas
						.getCharge2Value()
						: "PERCENT".equals(chargeMas.getCharge2Type()) ? (amount
								* chargeMas.getCharge2Value() / 100)
								: 0.0;
			}
			charge = "MAX".equals(chargeMas.getRelation()) ? Math.max(charge1,
					charge2) : "SUM".equals(chargeMas.getRelation()) ? charge1
							+ charge2 : 0.0;
			if (chargeMas.getMaxValue() != null && chargeMas.getMaxValue() != 0) {
				charge = Math.min(chargeMas.getMaxValue(), charge);
			}

			// Currency Conversation here
			CurrencyConversionDefBean currConvBean = fetchCurrencyExchangeBean(fromCurrencyId, toCurrencyId,session);
			charge = charge * currConvBean.getExchangeRate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} 
		return charge;
	}
/*	
	*//**
	 * Prepare beans for update and insert process.
	 * @param beanList :-- null in insert task and bean list in update task.
	 * @param playerIdList
	 * @param eventList
	 * @param channelType
	 * @return
	 * @throws PMSException
	 *//*
	public static List<StCommPreferenceTrans> convertIntoPreferenceBean(List<StCommPreferenceTrans> beanList,
			List<Long> playerIdList, List<String> eventList, String channelType) throws PMSException {
		List<StCommPreferenceTrans> stCommPreferenceTransList = new ArrayList<>();
		if(playerIdList != null)
			Collections.sort(playerIdList);
		if (beanList == null) {
			for (Long playerId : playerIdList) {
				for (String eventType : eventList) {
					StCommPreferenceTrans stCommPreferenceTrans = new StCommPreferenceTrans(playerId, eventType, "N",
							"N", "N", "N", "Y");
					stCommPreferenceTrans = setChannelType(stCommPreferenceTrans, channelType);
					stCommPreferenceTransList.add(stCommPreferenceTrans);
				}
			}
		} else {
			for (StCommPreferenceTrans preferenceTrans : beanList) {
				preferenceTrans = setChannelType(preferenceTrans, channelType);
				stCommPreferenceTransList.add(preferenceTrans);
			}

		}
		return stCommPreferenceTransList;
	}
		*/
	
/*	public static StCommPreferenceTrans setChannelType(StCommPreferenceTrans objectName, String channelType)
			throws PMSException {
		try {
			switch (ChannelType.valueOf(channelType)) {
			case SMS:
				objectName.setSms("Y");
				break;
			case EMAIL:
				objectName.setEmail("Y");
				break;
			case ANDROID:
				objectName.setPushNotificationAndroid("Y");
				break;
			case IOS:
				objectName.setPushNotificationIos("Y");
				break;
			}
		} catch (Exception e) {
			throw e;
		}
		return objectName;
	}
	
	*//**
	 * Create StCommPlrInfo class beans to insert 
	 * @param playerDetails
	 * @return
	 *//*
	public static List<StCommPlrInfo> createPlrInfoBeans(List<Object[]> playerMasList) throws Exception {
		List<StCommPlrInfo> stCommPlrInfoList = new ArrayList<>();
		try {
			for (int count = 0; count < playerMasList.size(); count++) {
				StCommPlrInfo stCommPlrInfo = new StCommPlrInfo();
				stCommPlrInfo.setPlayerId((long) playerMasList.get(count)[0]);
				if("Y".equals(playerMasList.get(count)[3])){
					stCommPlrInfo.setMobileNo((long) playerMasList.get(count)[1]);
				} else {
					stCommPlrInfo.setMobileNo(null);
				}
				if("Y".equals(playerMasList.get(count)[4])){
					stCommPlrInfo.setEmailId(String.valueOf(playerMasList.get(count)[2]));
				} else {
					stCommPlrInfo.setEmailId(null);
				}
				stCommPlrInfoList.add(stCommPlrInfo);
			}
		} catch (Exception e) {
			throw e;
		}
		return stCommPlrInfoList;
	}
	
	public static List<StCommPlrInfo> updatePlrInfoBeans(List<Object[]> playerMasList, List<StCommPlrInfo> beanList)
			throws Exception {
		List<StCommPlrInfo> stCommPlrInfoList = new ArrayList<>();
		try {
			int flag = 0;
			for (int i = 0, j = 0; j < beanList.size(); i++, j++) {
				if (i + flag >= playerMasList.size()) {
					break;
				}
				Long plrIdMas = (Long) playerMasList.get(i + flag)[0]; // 3
				Long plrIdUpdate = beanList.get(j).getPlayerId(); // 1
				if (plrIdMas.equals(plrIdUpdate)) {
					if ("Y".equals(playerMasList.get(i)[3])) {
						beanList.get(j).setMobileNo((Long) playerMasList.get(i + flag)[1]);
					} else {
						beanList.get(j).setMobileNo(null);
					}
					if ("Y".equals(playerMasList.get(i)[4])) {
						beanList.get(j).setEmailId(String.valueOf(playerMasList.get(i + flag)[2]));
					} else {
						beanList.get(j).setEmailId(null);
					}
					stCommPlrInfoList.add(beanList.get(j));
				} else {
					while (true) {
						flag = flag + 1;
						Long plrIdMas1 = (Long) playerMasList.get(i + flag)[0];
						if (plrIdMas1.equals(plrIdUpdate)) {
							flag = flag - 1;
							j = j - 1;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return stCommPlrInfoList;
	}
	
	public static List<StCommPreferencePromo> createPrefPromotionBean(List<Long> playerIdList) throws Exception {
		List<StCommPreferencePromo> stCommPrefPromoList = new ArrayList<>();
		for (Long playerId : playerIdList) {
			StCommPreferencePromo stCommPreferencePromo = new StCommPreferencePromo();
			stCommPreferencePromo.setPlayerId(playerId);
			stCommPreferencePromo.setEventType(EventType.PROMOTION.toString());
			stCommPreferencePromo.setSms("Y");
			stCommPreferencePromo.setEmail("Y");
			stCommPreferencePromo.setPushNotificationAndroid("Y");
			stCommPreferencePromo.setPushNotificationIos("Y");
			stCommPreferencePromo.setOpt("Y");
			stCommPrefPromoList.add(stCommPreferencePromo);
		}
		if (!stCommPrefPromoList.isEmpty()) {
			return stCommPrefPromoList;
		}
		return null;
	}*/
	
	public String convertJSON(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	public static LocationDetailBean checkLocation(String ip) {
		LocationDetailBean locationDetailBean = new LocationDetailBean();
		CityResponse locationDetails=null;
		logger.info("Looking up IP in MaxMind DB\t\t...");
		Long startTime=System.currentTimeMillis();
		try {
			URL dbUrl = Thread.currentThread().getContextClassLoader().getResource("GeoLite2-City.mmdb");
			String path=dbUrl.toString().contains("vfs:")?vfsToRealPath(dbUrl):dbUrl.getPath();
			DatabaseReader reader = new DatabaseReader.Builder(new File(path)).build();
			try {
				locationDetails = reader.city(InetAddress.getByName(ip));
			} catch (GeoIp2Exception e) {
				logger.warn(e.getMessage());
				locationDetailBean.setCountryCode("UNKNOWN_COUNTRY");
				locationDetailBean.setCountryName("UNKNOWN_COUNTRY");
				locationDetailBean.setCity("UNKNOWN_CITY");
				locationDetailBean.setRegion("UNKNOWN_REGION");
				locationDetailBean.setRegionName("UNKNOWN_STATE");
			}
			if (locationDetails == null) {
				locationDetailBean.setCountryCode("UNKNOWN_COUNTRY");
				locationDetailBean.setCountryName("UNKNOWN_COUNTRY");
				locationDetailBean.setCity("UNKNOWN_CITY");
				locationDetailBean.setRegion("UNKNOWN_REGION");
				locationDetailBean.setRegionName("UNKNOWN_STATE");
			} else {
				locationDetailBean.setCountryCode(locationDetails.getCountry().getIsoCode());
				locationDetailBean.setCountryName(locationDetails.getCountry().getName());
				locationDetailBean.setCity(locationDetails.getCity().getName());
				Subdivision subDivision=locationDetails.getMostSpecificSubdivision()==null?locationDetails.getLeastSpecificSubdivision():locationDetails.getMostSpecificSubdivision();
				locationDetailBean.setRegion(subDivision==null?null:subDivision.getIsoCode());
				locationDetailBean.setPostalCode(locationDetails.getPostal().getCode());
				locationDetailBean.setRegionName(subDivision==null?null:subDivision.getName());
			}
		} catch (IOException e) {
			logger.info(e.getMessage());
		} catch (Exception e){
			logger.info(e.getMessage());
		}
		logger.info("Took "+(System.currentTimeMillis()-startTime)+" millis to fetch IP location!");
		return locationDetailBean;
	}

	public static void checkTransactionControl(
			Map<String, String> txnControlMap, String txnType, String groupCode)
					throws PMSException {
		boolean isAllowed = false;
		if (txnControlTypes.DEPOSIT.name().equals(txnType)) {
			isAllowed = "Y".equals(txnControlMap.get(txnControlTypes.DEPOSIT
					.name()));
		} else if (txnControlTypes.WITHDRAWAL.name().equals(txnType)) {
			isAllowed = "Y".equals(txnControlMap.get(txnControlTypes.WITHDRAWAL
					.name()));
		} else if ("WAGER".equals(txnType)) {
			isAllowed = "Y"
					.equals(txnControlMap.get(txnType + "_" + groupCode));
		}
		if (!isAllowed) {
			throw new PMSException(PMSErrorCode.TXN_NOT_ALLOWED,
					PMSErrorMessage.TXN_NOT_ALLOWED);
		}
	}
	
	public static void checkMendatory(Object obj, List<String> properties) throws PMSException{
		try {
			for (String property : properties) {
				property  = WordUtils.uncapitalize(WordUtils.capitalize(property.toLowerCase().replace("_", " ")).replace(" ",""));
				String field  = BeanUtils.getProperty(obj, property);
				if(field==null || "".equals(field)){
					throw new PMSException(
							RequiredFieldError.errCode().get(property),
							RequiredFieldError.errMsg().get(property));
				}
			}
		}
		catch(PMSException e) {
			logger.error(e);
			throw e;	
		} catch(Exception e){
			logger.error(e);			
			throw new PMSException(
					PMSErrorCode.PLR_INCOMPLETE_INFO,
					PMSErrorMessage.PLR_INCOMPLETE_INFO);
		}
	}

	/*	public static String callUrl(String urlString, String param) {
		int timeout[] = {};
		return callUrl(urlString, param,timeout);
	}*/

	/* deprecated - please use Postman class. Refer PostmanTest for usage instruction
	 */
	@Deprecated
	public static String callUrl(String urlString, String param, int ...timeout) {
		URL url = null;
		HttpURLConnection connection = null;
		InputStream response = null;
		StringBuilder sb = new StringBuilder("");
		//	System.setProperty("jsse.enableSNIExtension", "false");
		if(urlString.indexOf("atomtech") != -1)
			System.setProperty("https.protocols", "TLSv1"); // done to fix POODLE vulnerability

		try {
			url = new URL(urlString);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			if(urlString.indexOf("CasinoAPI")!=-1){
				connection.setRequestProperty("Content-Type",
						"text/xml");
			}else if(urlString.indexOf("isSubWalletActive")!=-1){
				connection.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON);
			}else
				connection.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded");
			if(timeout!=null && timeout.length!=0){
				connection.setConnectTimeout(timeout[0]);
				connection.setReadTimeout(timeout[1]);
			}
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			if (param != null) {
				DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.writeBytes(param);
			}
			if (connection.getResponseCode() >= 400) {
				response = connection.getErrorStream();
			}else{
				response = connection.getInputStream();
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					response));

			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			response.close();
		} catch (IOException e) {
			logger.error(e);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return sb.toString();
	}

	public static String callUrl(String requestUrl, String payload) {
		URL url = null;
		StringBuilder jsonString = null;
		HttpURLConnection connection = null;
		try {
			jsonString = new StringBuilder();
			url = new URL(requestUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			connection.setReadTimeout(5000);
			connection.setConnectTimeout(5000);
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			writer.write(payload);
			writer.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				jsonString.append(line);
			}
			br.close();
		}catch (SocketTimeoutException e) {
			e.printStackTrace();
		}catch (ConnectException e) {
			logger.error("Wrapper is not connecting......",e);
		}catch (Exception e) {
			logger.error("",e);
		} finally {
			connection.disconnect();
		}
		return jsonString.toString();
	}
	
	public static String encodeString(String str){
		byte[] main_key = new byte[]{22, 43, 56, -60, 56, -125, 51, -66, -48, -75, -43, -68, 93, 23, 120, 94};
		byte[] key2 = new byte[]{56, 81, 1, 37, -43, -118, 104, -98};
		byte[] key1 = EncpDecpUtil.encodeDES(key2, main_key);
		byte[] rawKey = EncpDecpUtil.decodeDES(key2, key1);
		return EncpDecpUtil.encodeAES(rawKey, str);
	}

	public static String decodeString(String str) {
		byte[] main_key = new byte[] { 22, 43, 56, -60, 56, -125, 51, -66, -48,
				-75, -43, -68, 93, 23, 120, 94 };
		byte[] key2 = new byte[] { 56, 81, 1, 37, -43, -118, 104, -98 };
		byte[] key1 = EncpDecpUtil.encodeDES(key2, main_key);
		byte[] rawKey = EncpDecpUtil.decodeDES(key2, key1);
		return EncpDecpUtil.decodeAES(rawKey, str);
	}

	public static XMLGregorianCalendar convertTimeToXMLGregorianCalendar(long time) throws DatatypeConfigurationException{
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTimeInMillis(time);
		XMLGregorianCalendar xgcal = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(gcal);
		return xgcal;
	}


	public static String getDisplayCodeValue(String displayCode, Session session) {
		Object dispValue = null;
		try {
			PropertiesConfiguration config;
			CommonMethodDaoImpl commDao=CommonMethodDaoImpl.getInstance();
			if(commDao.fetchSystemProperties("GLOBAL_PROPERTIES_FLAG",session).equals("Y"))
				config =new PropertiesConfiguration(new URL(commDao.fetchSystemProperties("DEFAULT_CONTENT_PATH",session)+ "GLOBAL_PROPERTIES/global.properties"));
			else 
				config =new PropertiesConfiguration("globalPortalContent.properties");
			dispValue =  config.getProperty("global." + displayCode);
		} catch (Exception e) {
			logger.error(e);
		}
		return dispValue!=null ? dispValue.toString() : null;

	}
	public static String roundingNumber(double number){
		if(number < 0.01 && number > 0 )
			twoDigitFmt.applyPattern("0.000");
		else
			twoDigitFmt.applyPattern("0.00");
		twoDigitFmt.setRoundingMode(RoundingMode.HALF_UP);
		return twoDigitFmt.format(number);

	}

	public static String getServerDate(int dayDiff,int monthDiff,int yearDiff, String format) {
		SimpleDateFormat sdfSource = new SimpleDateFormat(format);
		Calendar reqDate = Calendar.getInstance();
		reqDate.add(Calendar.YEAR, yearDiff);
		reqDate.add(Calendar.MONTH, monthDiff);
		reqDate.add(Calendar.DATE, dayDiff);
		return sdfSource.format(reqDate.getTimeInMillis());
	}

	public static String readFileContent(String filePath, String fileName) {
		URL url = null;
		HttpURLConnection connection = null;
		InputStream response = null;
		StringBuilder sb = new StringBuilder("");
		try {
			String requestURL = CommonMethodController.getInstance().fetchSystemProperties("DEFAULT_CONTENT_PATH")+"read-servlet";
			url = new URL(requestURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setReadTimeout(15000);
			connection.setConnectTimeout(5000);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes("filePath="+URLEncoder.encode(filePath,"UTF-8"));
			wr.writeBytes("&fileName="+URLEncoder.encode(fileName,"UTF-8"));
			if (connection.getResponseCode() >= 400) {
				response = connection.getErrorStream();
			}else{
				response = connection.getInputStream();
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					response));

			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			response.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void saveOrUpdateContent(String fileContent, String fileName, String filePath)
			throws PMSException {
		String requestURL = CommonMethodController.getInstance().fetchSystemProperties("DEFAULT_CONTENT_PATH")+"fileupload";
		if("".equals(fileContent)){
			System.out.println("Blank File Can't Be Uploaded");
			return;
		}
		try {
			MultipartUtility multipart = new MultipartUtility(requestURL);
			multipart.addFormField("filePath", filePath);
			multipart.addFormField("fileName", fileName);
			multipart.addFormField("fileContent", fileContent);
			String response = multipart.finish();
			if(response.contains("Error")){
				throw new PMSException("Error in uploading file");
			}
		} catch (IOException ex) {
			throw new PMSException("Input/Output Error");
		}
	}

	public static void saveOrUpdateContent(File file, String fileName, String filePath)
			throws PMSException {
		String requestURL = CommonMethodController.getInstance().fetchSystemProperties("DEFAULT_CONTENT_PATH")+"fileupload";
		if((file!=null && file.length()==0)){
			System.out.println("Blank File Can't Be Uploaded");
			return;
		}
		try {
			MultipartUtility multipart = new MultipartUtility(requestURL);
			multipart.addFormField("filePath", filePath);
			multipart.addFormField("fileName", fileName);
			if(file!=null)
				multipart.addFilePart("file", file);
			String response = multipart.finish();
			if(response.contains("Error")){
				throw new PMSException("Error in uploading file");
			}
		} catch (IOException ex) {
			throw new PMSException("Input/Output Error");
		}
	}

	public static void saveOrUpdateContentZip(File file,String fileName,String filePath) throws PMSException{
		String requestURL = CommonMethodController.getInstance().fetchSystemProperties("DEFAULT_CONTENT_PATH")+"zip-file-upload";
		if((file!=null && file.length()==0)){
			System.out.println("Blank File Can't Be Uploaded");
			return;
		}
		try {
			StringBuilder dirPath = new StringBuilder(System.getProperty("jboss.home.dir"));
			File zipFile = new File(dirPath+"|bin|WeaverFiles|".replace('|', File.separatorChar)+fileName);
			FileUtils.copyFile(file, zipFile);
			ZipMultipartUtility multipart = new ZipMultipartUtility(requestURL);
			multipart.addFormField("filePath", filePath);
			multipart.addFormField("fileName", fileName);
			if(file!=null)
				multipart.addFilePart("file", zipFile);
			String response = multipart.finish();
			if(response.contains("Error")){
				throw new PMSException("Error in uploading file");
			}
		} catch (IOException ex) {
			throw new PMSException("Input/Output Error");
		}
	}

	public static void saveOrUpdateContent(byte[] fileContent, String fileName, String filePath)
			throws PMSException {
		String requestURL = CommonMethodController.getInstance().fetchSystemProperties("DEFAULT_CONTENT_PATH")+"fileupload";
		if((fileContent!=null && fileContent.length == 0)){
			System.out.println("Blank File Can't Be Uploaded");
			return;
		}
		try {
			MultipartUtility multipart = new MultipartUtility(requestURL);
			multipart.addFormField("filePath", filePath);
			multipart.addFormField("fileName", fileName);
			multipart.addFormField("fileContentEncoded", Base64.encodeBase64String(fileContent));
			String response = multipart.finish();
			if(response.contains("Error")){
				throw new PMSException("Error in uploading file");
			}
		} catch (IOException ex) {
			throw new PMSException("Input/Output Error");
		}
	}

	public static String reqPokerCAPI(Session session,String reqType,Long txnId,Double amount, String userName, Integer currencyId, Short aliasId, String otherData) throws PMSException{
		String resp = null;
		if("Y".equalsIgnoreCase(CommonMethodDaoImpl.getInstance().fetchSystemProperties("POKER_REQ",session))){

			Map<Short,Map<String, String>> vendorMap = CommonMethodDaoImpl.getInstance().getPokerVendorPropertiesById(aliasId, session);
			String url=null;
			String layerName=null;
			String serverId=null;
			String pokerUserName=null;
			String pokerPwd=null;

			if(vendorMap!=null)
				for (Map.Entry<Short, Map<String, String>> propmap : vendorMap.entrySet()){
					url=propmap.getValue().get("capi_req_url");					
					layerName=propmap.getValue().get("capi_layer_name");
					serverId=propmap.getValue().get("poker_server_id");
					pokerUserName=propmap.getValue().get("capi_user_name");
					pokerPwd=propmap.getValue().get("capi_password");
					if("LOYALTY".equals(reqType) || "LOYALTYPOINTSTMT".equals(reqType))
						layerName=propmap.getValue().get("capi_loyalty_layer_name");
				}

			if (url!=null){
				StringBuilder pokerReq = new StringBuilder();
				if("DEPOSIT".equals(reqType) || "WITH".equals(reqType)){
					DecimalFormat decimalFormat = new DecimalFormat("#####.##");
					decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
					Long amt = Math.round(Double.parseDouble(decimalFormat.format(amount))*100);
					//amt = "DEPOSIT".equals(reqType)?amt : amt*-1;
					pokerReq.append("<PKT>").append("<Method Name=\"ChangeBalanceMC3\" LayerName=\"").append(layerName).append("\" ServerID=\"").append(serverId).append("\"").append(">");
					pokerReq.append("<Auth Login=\"").append(pokerUserName).append("\" Password=\"").append(pokerPwd).append("\" TicketID=\"").append("").append("\" />");
					pokerReq.append("<Params>");
					pokerReq.append("<LoginName Value=\"").append(userName).append("\" />");
					pokerReq.append("<Amount Value=\"").append(0).append("\"/>");
					pokerReq.append("<CurrencyID Value=\"").append("62").append("\" />");
					pokerReq.append("<ExternalBalance Value=\"").append(amt).append("\"/>");
					pokerReq.append("</Params>");
					pokerReq.append("</Method></PKT>");
				}
				if("LOGOUT".equals(reqType)){
					pokerReq.append("<PKT>").append("<Method Name=\"LogoutUser\" LayerName=\"").append(layerName).append("\" ServerID=\"").append(serverId).append("\"").append(">");
					pokerReq.append("<Auth Login=\"").append(pokerUserName).append("\" Password=\"").append(pokerPwd).append("\" TicketID=\"").append("").append("\" />");
					pokerReq.append("<Params>");
					pokerReq.append("<CasinoLoginName Value=\"").append(userName).append("\" />");
					pokerReq.append("</Params>");
					pokerReq.append("</Method></PKT>");
				}if("LOYALTY".equals(reqType)){
					pokerReq.append("<PKT>").append("<Method Name=\"GetUserLoyaltyPointsBalanceDetails\" LayerName=\"").append(layerName).append("\" ServerID=\"").append(serverId).append("\"").append(">");
					pokerReq.append("<Auth Login=\"").append(pokerUserName).append("\" Password=\"").append(pokerPwd).append("\" TicketID=\"").append("").append("\" />");
					pokerReq.append("<Params>");
					pokerReq.append("<CasinoLoginName Value=\"").append(userName).append("\" />");
					pokerReq.append("</Params>");
					pokerReq.append("</Method></PKT>");
				}if("TICKET".equals(reqType)){
					pokerReq.append("<PKT>").append("<Method Name=\"GetPlayerTicketHistory\" LayerName=\"").append(layerName).append("\" ServerID=\"").append(serverId).append("\"").append(">");
					pokerReq.append("<Auth Login=\"").append(pokerUserName).append("\" Password=\"").append(pokerPwd).append("\" TicketID=\"").append("").append("\" />");
					pokerReq.append("<Params>");
					pokerReq.append("<LoginName Value=\"").append(userName).append("\" />");
					pokerReq.append("<Language Value=\"en\"").append("/>");
					pokerReq.append("<GuestTickets Value=\"true\"").append("/>");
					pokerReq.append("<RowsToReturn Value=\"2\"").append("/>");
					pokerReq.append("</Params>");
					pokerReq.append("</Method></PKT>");
				}if("NICKNAME".equals(reqType)){
					pokerReq.append("<PKT>").append("<Method Name=\"GetAlias\" LayerName=\"").append(layerName).append("\" ServerID=\"").append(serverId).append("\"").append(">");
					pokerReq.append("<Auth Login=\"").append(pokerUserName).append("\" Password=\"").append(pokerPwd).append("\" TicketID=\"").append("").append("\" />");
					pokerReq.append("<Params>");
					pokerReq.append("<LoginName Value=\"").append(userName).append("\" />");					
					pokerReq.append("</Params>");
					pokerReq.append("</Method></PKT>");	

				}if("LOYALTYPOINTSTMT".equals(reqType)){ // error
					pokerReq.append("<PKT>").append("<Method Name=\"GetUserLoyaltyPointsStatementLanguage\" LayerName=\"").append(layerName).append("\" ServerID=\"").append(serverId).append("\"").append(">");
					pokerReq.append("<Auth Login=\"").append(pokerUserName).append("\" Password=\"").append(pokerPwd).append("\" TicketID=\"").append("").append("\" />");
					pokerReq.append("<Params>");
					pokerReq.append("<CasinoLoginName Value=\"").append(userName).append("\" />");
					pokerReq.append("<Language Value=\"").append("en").append("\" />");
					pokerReq.append("</Params>");
					pokerReq.append("</Method></PKT>");					
				}if("CHANGEGUESTBAL".equals(reqType)){
					pokerReq.append("<PKT>").append("<Method Name=\"ChangeGuestBalance\" LayerName=\"").append(layerName).append("\" ServerID=\"").append(serverId).append("\"").append(">");
					pokerReq.append("<Auth Login=\"").append(pokerUserName).append("\" Password=\"").append(pokerPwd).append("\" TicketID=\"").append("").append("\" />");
					pokerReq.append("<Params>");
					pokerReq.append("<LoginName Value=\"").append(userName).append("\" />");
					pokerReq.append("<Amount Value=\"").append("200").append("\" />");
					pokerReq.append("</Params>");
					pokerReq.append("</Method></PKT>");					
				}if("CHECKALIASES".equals(reqType)){
					pokerReq.append("<PKT>").append("<Method Name=\"CheckAliases\" LayerName=\"").append(layerName).append("\" ServerID=\"").append(serverId).append("\"").append(">");
					pokerReq.append("<Auth Login=\"").append(pokerUserName).append("\" Password=\"").append(pokerPwd).append("\" TicketID=\"").append("").append("\" />");
					pokerReq.append("<Params>");
					pokerReq.append("<AliasCSV Value=\"").append("test,test12,test980").append("\" />");					
					pokerReq.append("</Params>");
					pokerReq.append("</Method></PKT>");
				}if("ADDPLRTOPLRGRP".equals(reqType)){
					pokerReq.append("<PKT>").append("<Method Name=\"AddPlayerToPlayerGroup\" LayerName=\"").append(layerName).append("\" ServerID=\"").append(serverId).append("\"").append(">");
					pokerReq.append("<Auth Login=\"").append(pokerUserName).append("\" Password=\"").append(pokerPwd).append("\" TicketID=\"").append("").append("\" />");
					pokerReq.append("<Params>");
					pokerReq.append("<LoginName Value=\"").append(userName).append("\" />");
					pokerReq.append("<PlayerGroupName Value=\"").append("GROUP NAME").append("\" />"); // Group Name
					pokerReq.append("</Params>");
					pokerReq.append("</Method></PKT>");
				}if("REMOVEPLRTOPLRGRP".equals(reqType)){
					pokerReq.append("<PKT>").append("<Method Name=\"RemovePlayerFromPlayerGroup\" LayerName=\"").append(layerName).append("\" ServerID=\"").append(serverId).append("\"").append(">");
					pokerReq.append("<Auth Login=\"").append(pokerUserName).append("\" Password=\"").append(pokerPwd).append("\" TicketID=\"").append("").append("\" />");
					pokerReq.append("<Params>");
					pokerReq.append("<LoginName Value=\"").append(userName).append("\" />");
					pokerReq.append("<PlayerGroupName Value=\"").append("GROUP NAME").append("\" />"); // Group Name
					pokerReq.append("</Params>");
					pokerReq.append("</Method></PKT>");
				}if("CheckAliases".equals(reqType)){
					pokerReq.append("<PKT>").append("<Method Name=\"CheckAliases\" LayerName=\"").append(layerName).append("\" ServerID=\"").append(serverId).append("\"").append(">");
					pokerReq.append("<Auth Login=\"").append(pokerUserName).append("\" Password=\"").append(pokerPwd).append("\" TicketID=\"").append("").append("\" />");
					pokerReq.append("<Params>");
					pokerReq.append("<AliasCSV Value=\"").append(otherData.split("~")[0]).append("\" />");
					pokerReq.append("</Params>");
					pokerReq.append("</Method></PKT>");
				}if("CreateAlias".equals(reqType)){
					pokerReq.append("<PKT>").append("<Method Name=\"CreateAlias\" LayerName=\"").append(layerName).append("\" ServerID=\"").append(serverId).append("\"").append(">");
					pokerReq.append("<Auth Login=\"").append(pokerUserName).append("\" Password=\"").append(pokerPwd).append("\" TicketID=\"").append("").append("\" />");
					pokerReq.append("<Params>");
					pokerReq.append("<LoginName Value=\"").append(userName).append("\" />");
					pokerReq.append("<Password Value=\"").append(otherData.split("~")[1]+"_"+otherData.split("~")[2]).append("\" />");
					pokerReq.append("<Alias Value=\"").append(otherData.split("~")[0]).append("\" />");
					pokerReq.append("<IdentifierIn Value=\"").append("").append("\" />");
					pokerReq.append("<cHDIdentifier Value=\"").append("").append("\" />");
					pokerReq.append("<BannerTag Value=\"").append("").append("\" />");
					pokerReq.append("<PromoCode Value=\"").append("").append("\" />");
					pokerReq.append("<BannerTag Value=\"").append("").append("\" />");
					pokerReq.append("<City Value=\"").append("").append("\" />");
					pokerReq.append("<CountryISOCode Value=\"").append("").append("\" />");
					pokerReq.append("<IPAddress Value=\"").append("").append("\" />");
					pokerReq.append("<CCID Value=\"").append(otherData.split("~")[2]).append("\" />");
					pokerReq.append("<CurrencyISOCode Value=\"").append("").append("\" />");
					pokerReq.append("</Params>");
					pokerReq.append("</Method></PKT>");
				}if("ChangeAlias".equals(reqType)){
					pokerReq.append("<PKT>").append("<Method Name=\"ChangeAlias\" LayerName=\"").append(layerName).append("\" ServerID=\"").append(serverId).append("\"").append(">");
					pokerReq.append("<Auth Login=\"").append(pokerUserName).append("\" Password=\"").append(pokerPwd).append("\" TicketID=\"").append("").append("\" />");
					pokerReq.append("<Params>");
					pokerReq.append("<LoginName Value=\"").append(userName).append("\" />");
					pokerReq.append("<NewAlias Value=\"").append(otherData.split("~")[0]).append("\" />");
					pokerReq.append("</Params>");
					pokerReq.append("</Method></PKT>");
				}

				System.out.println("******IN_CAPI"+pokerReq);
				resp=callServer( pokerReq.toString(),url,"text/xml");
				//resp = callUrl(url, pokerReq.toString());
			}
			else {
				resp="";
			}
		}
		return resp;
	}

	public synchronized String generateToken() {
		byte bytes[]=new byte[32];
		new SecureRandom().nextBytes(bytes);
		return Base64.encodeBase64URLSafeString(bytes);
	}

	public static void saveOrUpdateGraphContent(File file, String fileName, String filePath)
			throws PMSException {
		String requestURL = CommonMethodController.getInstance().fetchSystemProperties("COMMON_CONTENT_PATH")+"imageupload";
		if((file!=null && file.length()==0)){
			System.out.println("Blank File Can't Be Uploaded");
			return;
		}
		try {
			MultipartUtility multipart = new MultipartUtility(requestURL);
			multipart.addFormField("filePath", filePath);
			multipart.addFormField("fileName", fileName);
			if(file!=null)
				multipart.addFilePart("file", file);
			String response = multipart.finish();
			if(response.contains("Error")){
				throw new PMSException("Error in uploading file");
			}
		} catch (IOException ex) {
			throw new PMSException("Input/Output Error");
		}
	}

	/**
	 * 
	 * @param xml
	 * @param urlString
	 * @param encoding
	 * @return
	 * deprecated - please use Postman class. Refer PostmanTest for usage instruction
	 */
	@Deprecated
	public static  String callServer(String xml, String urlString, String encoding) {
		StringBuilder responseXml = new StringBuilder("");
		URLConnection conn;
		try {

			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
						String authType) throws CertificateException {
				}

				public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
						String authType) throws CertificateException {
				}
			}};

			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection
			.setDefaultSSLSocketFactory(sc.getSocketFactory());

			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

			URL url = new URL(urlString);


			if(urlString.contains("https"))
				conn = (HttpsURLConnection) url.openConnection();
			else
				conn = (HttpURLConnection) url.openConnection();


			conn.setConnectTimeout(3000);
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);

			if(urlString.indexOf("CasinoAPI")!=-1)
				conn.setReadTimeout(5000);

			if(encoding.equals("text/xml"))
				conn.setRequestProperty("Content-Type",	"text/xml");
			else
				conn.setRequestProperty("Authorization", "Basic " + encoding);

			if (xml != null) {
				DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
				wr.writeBytes(xml);
			}

			BufferedReader rd = new BufferedReader(new InputStreamReader(conn
					.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				responseXml.append(line);
			}

			rd.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(responseXml.toString());
		return responseXml.toString();

	}

	public static int compVersion(String ver1, String ver2){
		String[] verArr1,verArr2;
		verArr1=ver1.split("\\.");
		verArr2=ver2.split("\\.");
		for (int i = 0; i < Math.min(verArr1.length, verArr2.length); i++) {
			int j = Integer.parseInt(verArr1[i])-Integer.parseInt(verArr2[i]);
			if(j!=0){
				return j;
			}
		}
		if(verArr1.length>verArr2.length){
			return 1;
		} else if(verArr1.length<verArr2.length){
			return -1;
		}
		return 0;
	}

	public static String blobToString(Blob b) throws SQLException, IOException{
		String s=null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(b.getBinaryStream()));
		StringBuffer buf = new StringBuffer();
		while((s=reader.readLine()) != null)
			buf = buf.append(s);
		return buf.toString();		
	}

	public static String ConvertObjToXml(Object obj, Class className){
		StringWriter stringWriter = new StringWriter();
		try {
			JAXBContext.newInstance(className).createMarshaller().marshal(obj, stringWriter);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return stringWriter.toString();
	}

	public static Object ConvertXmlToObj(String xml,Class className) {
		Object obj = null;
		try {
			obj = JAXBContext.newInstance(className).createUnmarshaller().unmarshal(new ByteArrayInputStream(xml.getBytes()));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static Map<String,String> createVarMap(PlayerInfoBean plrInfoBean){
		Map<String,String> varMap = new HashMap<String, String>();
		varMap.put("Email", plrInfoBean.getEmailId());
		varMap.put("LastName", plrInfoBean.getLastName());
		varMap.put("MobileNo", String.valueOf(plrInfoBean.getMobileNo()));
		varMap.put("mobileNo", String.valueOf(plrInfoBean.getMobileNo()));
		varMap.put("FirstName", plrInfoBean.getFirstName());
		varMap.put("UserName", plrInfoBean.getUserName());
		varMap.put("Name", plrInfoBean.getUserName());
		return varMap;
	}

	public static Map<String,String> createVarMapFromPlayerMastrer(StPmPlayerMaster plrMaster){
		Map<String,String> varMap = new HashMap<String, String>();
		varMap.put("Email", plrMaster.getEmailId());
		varMap.put("LastName", plrMaster.getLastName());
		varMap.put("MobileNo", String.valueOf(plrMaster.getMobileNo()));
		varMap.put("mobileNo", String.valueOf(plrMaster.getMobileNo()));
		varMap.put("FirstName", plrMaster.getFirstName());
		varMap.put("UserName", plrMaster.getUserName());
		varMap.put("Name", plrMaster.getUserName());
		return varMap;
	}

	public static String vfsToRealPath(URL vfsUrl){
		try {
			logger.info("VFS>>>FILE");
			URLConnection conn = vfsUrl.openConnection();
			VirtualFile vf = (VirtualFile)conn.getContent();
			return vf.getPhysicalFile().getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String  getBucket(String commonContet) {
		Pattern pat=Pattern.compile(":\\/\\/(.*?)\\.s3");
		Matcher matcher= pat.matcher(commonContet);
		return matcher.find()?matcher.group(1):null;
	}

	public static String safeValue(String testValue,String defaultVal){
		return (testValue!=null && testValue != "")? testValue:defaultVal;
	}

	/**
	 * Utility for JSON to bean conversion.
	 * 
	 * @param JSON JSON String
	 * 
	 * @param type Class type of the java bean to be Constructed form JSON
	 * 
	 * @return the java bean of 'type' type
	 * 
	 * @throws JsonParseException
	 * 
	 * @throws JsonMappingException
	 * 
	 * @throws IOException

	 * @author Preetam Kumar
	 */
	public static <T> T jsonToBean(String JSON, Class<T> type) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		//		mapper.setDateFormat(COMMON_DATE_FORMAT);
		//		mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		T retVal;
		try {
			retVal=mapper.readValue(JSON, type);
		} catch (JsonMappingException e) {
			// I know i shouldn't do it.
			//			mapper.setDateFormat(new SimpleDateFormat("S"));
			retVal=mapper.readValue(JSON, type);
		}
		return retVal;
	}

	/*public static <T> T jsonToBean(String JSON,TypeReference<T> type) throws JsonParseException, JsonMappingException, IOException {
		HashMap<Long, CommonRequest> like=new HashMap<>();
		ObjectMapper mapper=new ObjectMapper();
		T retVal;
		try {
			retVal=mapper.readValue(JSON, type);
		} catch (JsonMappingException e) {
			retVal=mapper.readValue(JSON, type);
		}
		return retVal;
	}*/

	/**
	 * Utility for bean to JSON Conversion.
	 * 
	 * @param bean java bean to be JSONfied
	 * 
	 * @param prettyPrint set true for human readable format.
	 *  
	 * @return JSON String
	 * 
	 * @throws JsonGenerationException
	 * 
	 * @throws JsonMappingException
	 * 
	 * @throws IOException
	 * 
	 * @author Preetam Kumar
	 */
	public static String beanToJSON(Object bean, Boolean prettyPrint)
			throws JsonGenerationException, JsonMappingException, IOException {
		return beanToJSON(bean, prettyPrint, false, false);
	}
	
	public static String beanToJSON(Object bean, Boolean prettyPrint, Boolean sortAlphabetically, Boolean removeNull)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		if (removeNull) {
			mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
			mapper.setSerializationInclusion(Include.NON_EMPTY);
		}
		
		if (sortAlphabetically) {
			mapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
		}
		
		return prettyPrint ? mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean)
				: mapper.writeValueAsString(bean);
	}

	/**
	 * Utility to deserialize/convert the XML String to bean
	 * 
	 * @param XML String 
	 * 
	 * @param type of the object in Class.
	 * 
	 * @return the bean
	 * 
	 * @throws JAXBException
	 * 
	 * @author Preetam Kumar
	 */
	public static <T> T xmlTobean(String XML,Class<T> type) throws JAXBException{
		JAXBContext context=JAXBContext.newInstance(type);
		Unmarshaller unmarshaller=context.createUnmarshaller();
		return type.cast(unmarshaller.unmarshal(new StringReader(XML))) ;
	}

	/**
	 * Utility to prettify XML String.
	 * @param input
	 * @return Pretty formatted XML String.
	 */
	public static String prettyFormatXML(String input) {
		String output=null;
		try {
			Source xmlInput = new StreamSource(new StringReader(input));
			StringWriter stringWriter = new StringWriter();
			StreamResult xmlOutput = new StreamResult(stringWriter);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			transformerFactory.setAttribute("indent-number", 4);
			Transformer transformer = transformerFactory.newTransformer(); 
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(xmlInput, xmlOutput);
			output= xmlOutput.getWriter().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	public static String getDeviceType(String...args){
		String result = "";
		String device = args[0];
		String appVersion = args[2];

		try {
			Parser parser = new Parser();
			Client client = parser.parse(args[1]);
			switch(device){
			case "PC":result="WEB"; break;
			case "TAB":
			case "MOBILE": if(!StringUtils.isEmpty(appVersion.trim())){result = client.os.family+" v"+appVersion;break;}//else it will be mobile browser.
			case "MOBILE_WEB":result = "mobile_browser"; break;
			case "DOWNLOADABLE_CLIENT":result = "desktop"; break;
			default:result = "version unknown";
			}

		} catch (IOException e) {
			logger.error(e.getMessage()+" , usage: args[] -> device,ua,version");
		}

		return result;
	}

	public static boolean ipCheck(String validIplist, String targetIp){
		boolean isValid = false;
		StringTokenizer tokenizer = new StringTokenizer(validIplist, ",");

		while(tokenizer.hasMoreTokens() && !isValid){
			String frag = tokenizer.nextToken();
			if(frag.contains("/")){
				isValid = subnetCheck(frag, targetIp);
			}else{
				isValid = frag.equals(targetIp);
			}
		}

		return isValid;
	}

	public static boolean subnetCheck(String subnetRange, String targetIp){
		SubnetUtils utils = new SubnetUtils(subnetRange);
		return utils.getInfo().isInRange(targetIp);
	}

	public static <T> T defaultIfNull(T t, T d){
		return (t != null ?t:d);  
	}

	public static boolean notNull(Object t){
		return (t!=null);
	}
	
	public static boolean isNull(Object t){
		return !notNull(t);
	}

    /**
     * Generates digest with SHA512 algorithm
     * @param map orderedMap to be digested;
     * @return digest String;
     */
	public static String generateSecureHash(TreeMap map){
        String json=null;
        try {
            json = beanToJSON(map, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("tobe disgested:"+json);
        return DigestUtils.sha512Hex(json.getBytes());
    }

public static String getClientName(){
		return Utility.getEnvironmentProperty("client","ScratchWeaver");
	}
	public static String getEnvironmentProperty(String key,String defaultStr){
		String value = null;
		if(System.getProperty(key)!=null){
			value = System.getProperty(key);	
		}else{
			value= System.getenv(key);
		}
		return StringUtils.isNotEmpty(value)? value : defaultStr;
	}
	

	public static <T> String appendDataWithSeparator(List<T> dataList,String separator){
		StringBuilder sb =new StringBuilder();
		int count=0;
		
		for (T data : dataList) {
			++count;
			sb.append(data);
			if(count!=dataList.size())
				sb.append(separator);
		}
		return sb.toString();
	}
	public static String getBuildVersion(){
		if (isNull(BUILD_VERSION)) {
			final Properties properties = new Properties();
			try {
				properties.load(Utility.class.getClassLoader().getResourceAsStream("project.properties"));
				BUILD_VERSION = properties.getProperty("version");

				if (BUILD_VERSION != null && BUILD_VERSION.toUpperCase().contains("-SNAPSHOT"))
					BUILD_VERSION = BUILD_VERSION.replace("-SNAPSHOT", "");

			} catch (Exception e) {
				Log.warn(e.getMessage());
			} 
		}
		return defaultIfNull(BUILD_VERSION, "unknown");

	}
	
	@SafeVarargs
	public static <T> List<T> varArgDataIntoList(T ...data){
			return Arrays.asList(data);
	}	
	

	public static String replaceFallbackPattern(String msg, Map<String, String> emailVerMap){
		for (String key : emailVerMap.keySet()) {
			msg = msg.replace("{" + key.trim() + ", fallback=}", emailVerMap.get(key));
		}
		return msg;
	}

	public static List<String> getNames(Class<? extends Enum<?>> e) {
	    return Arrays.asList(Arrays.toString(e.getEnumConstants()).replaceAll("^.|.$", "").split(", "));
	}
	
	/**
	 * This method is used to call outbound APIs 
	 * @param urlStr : url to hit
	 * @param methodType : HTTP method type such as POST,GET etc.
	 * @param message: request body
	 * @param headers: request headers such as Content-Type etc.
	 * @param expectedStatus : Status number in which Inputstream need to be read else errorstream will be read
	 * @param responseHandlers: type of response bean need to be generated as per http status code, 0 for default 
	 * @return : Object type
	 * @throws PMSException
	 * deprecated - please use Postman class. Refer PostmanTest for usage instruction
	 */
	@Deprecated
	public static Object genericCaller(String urlStr,String methodType, String message, Map<String,String> headers,
			Integer expectedStatus,Map<Integer, Class> responseHandlers) throws PMSException{

		InputStream input = null;
		HttpURLConnection conn = null;
		OutputStream output = null;
		try {
			conn = (HttpURLConnection) new URL(urlStr).openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod(methodType);
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(40000);
			for(String key: headers.keySet())
				conn.setRequestProperty(key, headers.get(key));
			
			output = new BufferedOutputStream(conn.getOutputStream());
			output.write(message.getBytes());
			output.flush();
			
			// Get the response
			if (conn.getResponseCode() == expectedStatus) {
				input = conn.getInputStream();
			} else {
				input = conn.getErrorStream();
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			StringBuilder response = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			logger.info("Sending SMS Response : " + response);

			Class responseHandler = responseHandlers.containsKey(conn.getResponseCode())?
					responseHandlers.get(conn.getResponseCode()):responseHandlers.get(0); 

			if(responseHandler==null)
		    	return response.toString();
			else
				return Utility.jsonToBean(response.toString(), responseHandler);
					
		} catch (IOException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR, PMSErrorMessage.GEN_SOME_INTERNAL_ERROR, e);
		}finally{
			conn.disconnect();
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public KeyGenerator keygenerator;
	public SecretKey myDesKey;
	Cipher c;
	// Genrate the Key

	public byte[] doEncryption(String s) throws Exception {
		keygenerator = KeyGenerator.getInstance("DESede");
		myDesKey = keygenerator.generateKey();

		// Create the cipher
		c = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		// Initialize the cipher for encryption
		c.init(Cipher.ENCRYPT_MODE, myDesKey);

		// sensitive information
		byte[] text = s.getBytes();

		// Encrypt the text
		byte[] textEncrypted = c.doFinal(text);

		return (textEncrypted);

	}
	
	/* Check Email Id is valid or not */
	public static boolean validateEmailId(String emailId){
		Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = EMAIL_REGEX.matcher(emailId);
		return matcher.find();
	}
	
	public String doDecryption(byte[] s) throws Exception {
		keygenerator = KeyGenerator.getInstance("DESede");
		myDesKey = keygenerator.generateKey();
		// Initialize the same cipher for decryption
		c.init(Cipher.DECRYPT_MODE, myDesKey);

		// Decrypt the text
		byte[] textDecrypted = c.doFinal(s);

		return (new String(textDecrypted));
	}

	public  byte[] get3DESEncryptString(String inputString) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		keygenerator = KeyGenerator.getInstance("DESede");
		myDesKey = keygenerator.generateKey();

		// Create the cipher
		c = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		// Initialize the cipher for encryption
		c.init(Cipher.ENCRYPT_MODE, myDesKey);

		// sensitive information
		byte[] text = inputString.getBytes();

		// Encrypt the text
		byte[] textEncrypted = c.doFinal(text);

		return textEncrypted;

	}
	public static void main(String[] args) throws Exception {
		try {
			Utility util=new Utility();
			byte[] b=util.get3DESEncryptString("1234");
			System.out.println(b.toString()+"--/n");
			System.out.println(util.doDecryption(new Utility().get3DESEncryptString("1234")));
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}