package com.stpl.pms.utility;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stpl.pms.controller.commonMethods.CommonMethodController;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.StCmsTemplateMaster;
import com.stpl.pms.hibernate.mapping.StGenSmsEmailProviderMaster;
import com.stpl.pms.hibernate.mapping.StPmPlrFalconideMailResponseHistory;
import com.stpl.pms.hibernate.mapping.StPmPlrMailResponseHistory;
import com.stpl.pms.javabeans.MailResponseBean;

public class MassMailling extends Thread {
	private List<LinkedHashMap<String, String>> emailContentMap = new ArrayList<LinkedHashMap<String, String>>();
	private String mailType;
	private short domainId;
	private short aliasId;
	private long playerId;
	private String playerName;

	private static final Logger logger = Logger.getLogger(MassMailling.class);


	public MassMailling() {

	}

	public MassMailling(List<LinkedHashMap<String, String>> emailContentMap,
			String mailType, short domainId, short aliasId, long playerId, String playerName) {
		this.emailContentMap = emailContentMap;
		this.mailType = mailType;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.playerId = playerId;
		this.playerName = playerName;
	}

	@Override
	public void run() {
		massMailSending();
	}

	private  void massMailSending() {
		Session session= null;
		try {
			session= HibernateSessionFactory.getSessionFactory().openSession();
			StCmsTemplateMaster stCmsTemplateMaster = null;
			CommonMethodController commonMethodController = CommonMethodController
					.getInstance();
			CommonMethodDaoImpl commonMethodDaoImpl = CommonMethodDaoImpl.getInstance();
			StringBuffer emailVar = new StringBuffer();
			String domainName = commonMethodController.getDmProperty(domainId,
					"domainName");
			Map<String,String> propMap = commonMethodController.getAliasPropertyMap(aliasId, "aliasName" ,"template","publicUrl");
			String aliasName = propMap.get("aliasName");
			if ("BYDEFAULT".equals(propMap.get("template"))) {
				aliasName = commonMethodController.getDmAliasProperty((short) 1, "aliasName");
				stCmsTemplateMaster = commonMethodController
						.fetchTempleteUrlMap((short) 1, mailType, "EMAIL");
			} else {
				stCmsTemplateMaster = commonMethodController
						.fetchTempleteUrlMap(aliasId, mailType, "EMAIL");
			}
			String path = commonMethodController.fetchSystemProperties(
					"DEFAULT_CONTENT_PATH").toString();
			if(mailType.equals("INVITE_FRIEND"))
			{
				stCmsTemplateMaster.setTemplateSubject("You're Invited! Your friend "+playerName+" wants you to join KhelPlay.");
			}
			StGenSmsEmailProviderMaster providerInfo = commonMethodDaoImpl.fetchSmsEmailProvider(aliasId,"EMAIL", session);
			if("Octane".equalsIgnoreCase(providerInfo.getProviderName()))
			{
				for (Map<String, String> mapEmail : emailContentMap) {
					emailVar.append("<Recipient>");
					for (Map.Entry<String, String> entry : mapEmail.entrySet()) {
						emailVar.append("<" + entry.getKey() + ">"
								+ entry.getValue() + "</" + entry.getKey() + ">");
					}
					emailVar.append("</Recipient>");
				}
				String templatePath ="";
				
				if("PORTALCONTENT".equals(propMap.get("contentType"))){
					templatePath=URLEncoder.encode(path
							+domainName
							+"/"
							+ aliasName
							+ "/"
							+ CommonMethodController.getInstance()
									.fetchAliasLayout(aliasId, "pc")
							+ "/pc/LR/email/eng" + "/"
							+ stCmsTemplateMaster.getTemplatePath(), "UTF-8");
				}else{
					templatePath=	URLEncoder.encode(propMap.get("publicUrl")+stCmsTemplateMaster.getTemplatePath(), "UTF-8");
				}
				
				
				
				String requestXmlMailSend = "Request=<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
						+ "<MailSend>" + "<ApiKey>"
						+ providerInfo.getProviderKey()
						+ "</ApiKey>"
						+ "<Password>"
						+ providerInfo.getProviderPass()
						+ "</Password>"
						+ "<Request>"
						+ "<Mail>"
						+ "<ContentSource>2</ContentSource>"
						+ "<Format>2</Format>"
						+ "<FromEmail>"
						+ stCmsTemplateMaster.getTemplateFromEmail()
						+ "</FromEmail>"
						+ "<FromName>"
						+ Base64.encodeBase64String(stCmsTemplateMaster.getTemplateFromName()
								.getBytes())
						+ "</FromName>"
						+ "<HtmlUrl>"
						+ 	templatePath
						+ "</HtmlUrl>"
						+ "<Subject>"
						+ Base64.encodeBase64String(stCmsTemplateMaster.getTemplateSubject().getBytes())
						+ "</Subject>"
						+ "<ReplyTo>noreply@khelplayrummy.com</ReplyTo>"
						+ "</Mail>"
						+ "<Recipients>"
						+ emailVar
						+ "</Recipients>"
						+ "</Request>" + "</MailSend>";
				logger.info("---Request Mail XML--"+requestXmlMailSend);
				String result = Utility.callUrl(
						"http://api.trackcampaigns.com/v2.1/?mail/send",
						requestXmlMailSend);
				logger.info("---Request Mail XML--"+requestXmlMailSend);
				insertMailResponse(result,stCmsTemplateMaster.getTemplateId(), playerId, domainId, aliasId);
				logger.info(stCmsTemplateMaster.getTemplateSubject()
						+ "  domainName= " + aliasName + result + "----------");
			}
			else if("Falconide".equalsIgnoreCase(providerInfo.getProviderName()))
			{
				StringBuffer recipientsVar = new StringBuffer();
				StringBuffer nameVar = new StringBuffer();
				StringBuffer userNameVar = new StringBuffer();
				StringBuffer webSiteLinkVar = new StringBuffer();
				StringBuffer invitionLinkVar = new StringBuffer();
				StringBuffer domainNameVar = new StringBuffer();
				StringBuffer referFriendVar = new StringBuffer();
				int emailContentMapSize = emailContentMap.size();
				int emailContentMapCount = 1;
				for (Map<String, String> mapEmail : emailContentMap) {
					for (Map.Entry<String, String> entry : mapEmail.entrySet()) {
						if(entry.getKey().equalsIgnoreCase("emailId"))
						{
							if(emailContentMapCount == emailContentMapSize)
								recipientsVar.append("\"" + entry.getValue()+ "\"");
							else
							{
								recipientsVar.append("\""  + entry.getValue()+ "\",");
							}
						}
						if(entry.getKey().equalsIgnoreCase("Name"))
						{
							if(emailContentMapCount == 1)
								nameVar.append("\"" + entry.getKey() + "\":[");
							if(emailContentMapCount == emailContentMapSize)
								nameVar.append("\"" + entry.getValue()+ "\"]");
							else
							{
								nameVar.append("\""  + entry.getValue()+ "\",");
							}
						}
						if(entry.getKey().equalsIgnoreCase("UserName"))
						{
							if(emailContentMapCount == 1)
								userNameVar.append("\"" + entry.getKey() + "\":[");
							if(emailContentMapCount == emailContentMapSize)
								userNameVar.append("\"" + entry.getValue()+ "\"]");
							else
							{
								userNameVar.append("\""  + entry.getValue()+ "\",");
							}
						}
						if(entry.getKey().equalsIgnoreCase("WebSiteLink"))
						{
							if(emailContentMapCount == 1)
								webSiteLinkVar.append("\"" + entry.getKey() + "\":[");
							if(emailContentMapCount == emailContentMapSize)
								webSiteLinkVar.append("\"" + entry.getValue()+ "\"]");
							else
							{
								webSiteLinkVar.append("\""  + entry.getValue()+ "\",");
							}
						}
						if(entry.getKey().equalsIgnoreCase("InvitionLink"))
						{
							if(emailContentMapCount == 1)
								invitionLinkVar.append("\"" + entry.getKey() + "\":[");
							if(emailContentMapCount == emailContentMapSize)
								invitionLinkVar.append("\"" + entry.getValue()+ "\"]");
							else
							{
								invitionLinkVar.append("\""  + entry.getValue()+ "\",");
							}
						}
						if(entry.getKey().equalsIgnoreCase("DomainName"))
						{
							if(emailContentMapCount == 1)
								domainNameVar.append("\"" + entry.getKey() + "\":[");
							if(emailContentMapCount == emailContentMapSize)
								domainNameVar.append("\"" + entry.getValue()+ "\"]");
							else
							{
								domainNameVar.append("\""  + entry.getValue()+ "\",");
							}
						}
						if(entry.getKey().equalsIgnoreCase("ReferFriendCode"))
						{
							if(emailContentMapCount == 1)
								referFriendVar.append("\"" + entry.getKey() + "\":[");
							if(emailContentMapCount == emailContentMapSize)
								referFriendVar.append("\"" + entry.getValue()+ "\"]");
							else
							{
								referFriendVar.append("\""  + entry.getValue()+ "\",");
							}
						}					
						
					}
					emailContentMapCount++;
				}
				String requestXmlMailSend = "data=" +
						"{"+
						"	\"api_key\":\""+
						providerInfo.getProviderKey()+
						"\", \"email_details\":{ \"fromname\":\""+stCmsTemplateMaster.getTemplateFromName()+"\", \"subject\":\"" +
						stCmsTemplateMaster.getTemplateSubject()+"\", \"from\":\"" +
						stCmsTemplateMaster.getFalconideTemplateFromEmail()+"\", \"replytoid\": \"" +
						stCmsTemplateMaster.getFalconideTemplateFromEmail()+"\", \"content\":\"%3Cp%\"" +
						" }, "+
						"\"settings\":"
						+"{"
						+" \"template\":\""+stCmsTemplateMaster.getFalconideTemplateId()+"\" }," +
						" \"attributes\":{" + nameVar+","+userNameVar+","+webSiteLinkVar+","+invitionLinkVar+","+domainNameVar+","+referFriendVar+
						" },"+
						" \"recipients\":["+recipientsVar+
						"]"
						+"}";
				
				logger.info("---Request Mail XML--"+requestXmlMailSend);
				String result = Utility.callUrl(
						"https://api.falconide.com/falconapi/web.send.json?",
						requestXmlMailSend);
				insertFalconideMailResponse(result, stCmsTemplateMaster.getTemplateId(), playerId, domainId, aliasId, session);
				System.out.println("result "+result);
			} else if("Google".equals(providerInfo.getProviderName())){
				String  htmlData = IOUtils.toString(new URL(path +domainName +"/" + aliasName + "/" + CommonMethodController.getInstance()
						.fetchAliasLayout(aliasId, "pc") + "/pc/LR/email/eng" + "/" + stCmsTemplateMaster.getTemplatePath()).openStream());
				final String username = "app.skilrock@gmail.com";
				final String password = "SkilRock@123";
				Properties props = new Properties();
				props.put("mail.transport.protocol", "smtp");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");
				javax.mail.Session sess = javax.mail.Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
				for (Map<String, String> emailMap : emailContentMap) {
					Message message = new MimeMessage(sess);
					message.setFrom(new InternetAddress("amit.garg@skilrock.com"));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(emailMap.get("EmailId")));
					message.setSubject(stCmsTemplateMaster.getTemplateSubject());
					Multipart multipart = new MimeMultipart("alternative");
					BodyPart messageBodyPart = new MimeBodyPart();
				    messageBodyPart.setContent(replaceEmailVarWithValue(htmlData, emailMap), "text/html");
				    multipart.addBodyPart(messageBodyPart);
				    message.setContent(multipart);
					Transport.send(message);
					logger.info("Provider GOOGLE Message Sent to "+ emailMap.get("EmailId"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  static void callingMassMail(
			List<LinkedHashMap<String, String>> emailContentMap,
			String mailType, short domainId, short aliasId, long playerId, String playerName) throws PMSException {
		if ("Y".equals(CommonMethodController.getInstance()
				.fetchSystemProperties("SYSTEM_SEND_MAIL"))) {
			MassMailling commDao = new MassMailling(emailContentMap, mailType,
					domainId, aliasId, playerId, playerName);
			commDao.setDaemon(false);
			commDao.start();
		} else
			logger.info("---SYSTEM_SEND_MAIL ---- set to N ");
	}

	public  static void callingMassMail(
			List<LinkedHashMap<String, String>> emailContentMap,
			String mailType, short domainId, short aliasId, long playerId, String playerName, Session session) throws PMSException {
		if ("Y".equals(CommonMethodDaoImpl.getInstance()
				.fetchSystemProperties("SYSTEM_SEND_MAIL",session))) {
			MassMailling commDao = new MassMailling(emailContentMap, mailType,
					domainId, aliasId, playerId, playerName);
			commDao.setDaemon(false);
			commDao.start();
		} else
			logger.info("---SYSTEM_SEND_MAIL ---- set to N ");
	}
	
	public String replaceEmailVarWithValue(String htmlData,Map<String, String> mapEmail) throws IOException{
		if(mapEmail.get("InvitionLink")!=null)
			htmlData = htmlData.replace("{InvitionLink , fallback=}", mapEmail.get("InvitionLink"));
		if(mapEmail.get("Email")!=null)
			htmlData = htmlData.replace("{Email,fallback=}", mapEmail.get("Email"));
		if(mapEmail.get("LastName")!=null)
			htmlData = htmlData.replace("{LastName, fallback=}", mapEmail.get("LastName"));
		if(mapEmail.get("MobileNo")!=null)
			htmlData = htmlData.replace("{MobileNo, fallback=}", mapEmail.get("MobileNo"));
		if(mapEmail.get("FirstName")!=null)	
			htmlData = htmlData.replace("{FirstName,fallback=}", mapEmail.get("FirstName"));
		if(mapEmail.get("UserName")!=null)
			htmlData = htmlData.replace("{UserName, fallback=}", mapEmail.get("UserName"));
		if(mapEmail.get("Name")!=null)	
			htmlData = htmlData.replace("{Name,fallback=}", mapEmail.get("Name"));
		return htmlData;
	}
	
	private void insertMailResponse(String xmlString,Integer templateId, long playerId,
			 short domainId, short aliasId) {
		Session session = null;
		Transaction tx =null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			char[] replaceAfter = { '<', '/' };
			xmlString = xmlString.replace("Response",
					"externalMailResponseString").replace("Result",
					"mailResponseInfoDataBean").replace("Error",
					"mailResponseInfoDataBean");
			xmlString = WordUtils.uncapitalize(xmlString, replaceAfter);
			MailResponseBean respBean = (MailResponseBean) XmlUtil.reader(
					"externalMailResponseString", MailResponseBean.class,
					xmlString, MailResponseBean.class.getPackage());
			StPmPlrMailResponseHistory mailResponseBean = new StPmPlrMailResponseHistory(
					playerId, domainId, aliasId, templateId, 0, null, respBean.getSuccess(),
					respBean.getMailResponseInfoDataBean()
							.getTotalNumberOfRecipients(), respBean
							.getMailResponseInfoDataBean().getNoOfEmailsSent(),
					respBean.getMailResponseInfoDataBean()
							.getNoOfUnsentEmails(), respBean
							.getMailResponseInfoDataBean()
							.getNoOfSuppressedEmails(), respBean
							.getMailResponseInfoDataBean()
							.getNoOfFilteredEmails(), respBean
							.getMailResponseInfoDataBean().getMessage(),
					respBean.getMailResponseInfoDataBean().getErrorcode(),
					respBean.getRequestId(), new Timestamp(Calendar
							.getInstance().getTimeInMillis()));
			session.save(mailResponseBean);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx !=null && tx.isActive()) {
				tx.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tx !=null && tx.isActive()) {
				tx.rollback();
			}
		} finally{
			if (session!=null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	private void insertFalconideMailResponse(String xmlString,Integer templateId, long playerId, short domainId, short aliasId,Session session){
		Transaction tx =null;
		try{
			tx = session.beginTransaction();
			StPmPlrFalconideMailResponseHistory mailResponseBean = new StPmPlrFalconideMailResponseHistory(
					playerId, domainId, aliasId, templateId, 0, null, xmlString, new Timestamp(Calendar
							.getInstance().getTimeInMillis()));
			session.save(mailResponseBean);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx !=null && tx.isActive()) {
				tx.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tx !=null && tx.isActive()) {
				tx.rollback();
			}
		}
	}

	public String getMailType() {
		return mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
	}

	public List<LinkedHashMap<String, String>> getEmailContentMap() {
		return emailContentMap;
	}

	public void setEmailContentMap(
			List<LinkedHashMap<String, String>> emailContentMap) {
		this.emailContentMap = emailContentMap;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public short getAliasId() {
		return aliasId;
	}

	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}
	

}
