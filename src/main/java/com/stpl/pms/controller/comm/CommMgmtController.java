package com.stpl.pms.controller.comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stpl.pms.controller.gm.GameMgmtController;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.StCmsTemplateMaster;
import com.stpl.pms.hibernate.mapping.StDmDomainAliasNameMaster;
import com.stpl.pms.hibernate.mapping.StGenSmsEmailProviderMaster;
import com.stpl.pms.hibernate.mapping.StPmPlrFalconideMailResponseHistory;
import com.stpl.pms.hibernate.mapping.StPmPlrMailResponseHistory;
import com.stpl.pms.javabeans.MailResponseBean;
import com.stpl.pms.javabeans.PlayerInfoBean;
import com.stpl.pms.javabeans.UserDetailsBean;
import com.stpl.pms.javabeans.UserInfoBean;
import com.stpl.pms.mail.services.SMSDetailImpl;
import com.stpl.pms.mail.services.SMTPMailService;
import com.stpl.pms.security.ZipFileProtection;
import com.stpl.pms.utility.AWSWrapper;
import com.stpl.pms.utility.Utility;
import com.stpl.pms.utility.XmlUtil;

public class CommMgmtController extends Thread {

	private Map<String, String> emailContentMap = new LinkedHashMap<String, String>();
	private String mailType;
	private short domainId;
	private short aliasId;
	private String templateName;
	private String emailType;
	private int userId;
	private UserInfoBean userInfoBean;
	private String emailId;
	private String text;
	private int gameNo;
	private int batchNo;
	private String mailMsg;
	private String userEmail;
	

	private static final Logger logger = Logger.getLogger(CommMgmtController.class);

	public CommMgmtController() {

	}


	public CommMgmtController(Map<String, String> emailContentMap, String mailType, short domainId, String templateName,
			int userId, short aliasId) {
		this.emailContentMap = emailContentMap;
		this.mailType = mailType;
		this.domainId = domainId;
		this.templateName = templateName;
		this.userId = userId;
		this.aliasId = aliasId;
	}

	public CommMgmtController(Map<String, String> emailContentMap, String mailType, short domainId, int userId) {
		this.emailContentMap = emailContentMap;
		this.mailType = mailType;
		this.domainId = domainId;
		this.userId = userId;
	}

	public CommMgmtController(String emailId, String text, short domainId, short aliasId) {
		this.emailId = emailId;
		this.text = text;
		this.domainId = domainId;
		this.aliasId = aliasId;
	}

	public CommMgmtController(String emailId, String text, short domainId, short aliasId, String emailType) {
		this.emailId = emailId;
		this.text = text;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.emailType = emailType;
	}

	public CommMgmtController(String emailId, String text, short domainId, short aliasId, String emailType,
			UserInfoBean userInfoBean) {
		this.userInfoBean = userInfoBean;
		this.emailId = emailId;
		this.text = text;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.emailType = emailType;
		// TODO Auto-generated constructor stub
	}

	public CommMgmtController(String emailId, String text, short domainId, short aliasId, String emailType,
			UserInfoBean userInfoBean, int gameNo, int batchNo, String mailMsg, String userEmail) {
		this.userInfoBean = userInfoBean;
		this.emailId = emailId;
		this.text = text;
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.emailType = emailType;
		this.gameNo = gameNo;
		this.batchNo = batchNo;
		this.mailMsg = mailMsg;
		this.userEmail = userEmail;
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void run() {
		mailSending();
	}

	private void mailSending() {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSessionFactory().openSession();
			CommonMethodDaoImpl commonMethodDaoImpl = CommonMethodDaoImpl.getInstance();
			StGenSmsEmailProviderMaster providerInfo = commonMethodDaoImpl.fetchSmsEmailProvider(aliasId, "EMAIL",
					session);
			if (providerInfo != null) {
				if (userInfoBean != null && gameNo != 0 && batchNo != 0 && mailMsg != null) {
					sendMail(providerInfo, session, emailType, userInfoBean, gameNo, batchNo, mailMsg, userEmail);
				} else if (userInfoBean != null) {
					sendMail(providerInfo, session, emailType, userInfoBean);
				}

				else {
					if (mailType == null && aliasId == 1 && (emailContentMap.size() == 0 && mailType == null)) {
						sendMail(providerInfo, session, emailType);
					}
					if ((emailContentMap.size() == 0 && mailType == null)) {
						sendBoMail(providerInfo);
					} else if (mailType.contains("BO_") && aliasId == 1) {
						sendMail(providerInfo, session);
					} else {
						sendMail(commonMethodDaoImpl, providerInfo, session);

					}
				}

			} else {
				throw new PMSException("Provider not available for aliasId" + aliasId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void sendBoMail(StGenSmsEmailProviderMaster providerInfo) {
		if ("Octane".equalsIgnoreCase(providerInfo.getProviderName())) {
			StringBuilder requestXmlMailSend = new StringBuilder("Request=<?xml version='1.0' encoding='UTF-8'?>")
					.append("<MailSend>").append("<ApiKey>").append(providerInfo.getProviderKey()).append("</ApiKey>")
					.append("<Password>").append(providerInfo.getProviderPass()).append("</Password>")
					.append("<Request>").append("<Mail>").append("<Subject>")
					.append(Base64.encodeBase64String("Weaver BackOffice".getBytes())).append("</Subject>")
					.append("<FromName>").append(Base64.encodeBase64String("Weaver Team".getBytes()))
					.append("</FromName>").append("<FromEmail>backoffice@khelplayrummy.in</FromEmail>")
					.append("<ReplyTo>backoffice@khelplayrummy.in</ReplyTo>").append("<Format>1</Format>")
					.append("<ContentSource>1</ContentSource>").append("<TextContent>")
					.append(Base64.encodeBase64String((text).getBytes())).append("</TextContent>").append("</Mail>")
					.append("<Recipients>").append("<Recipient>").append("<EmailId>").append(emailId)
					.append("</EmailId>").append("</Recipient>").append("</Recipients>").append("</Request>")
					.append("</MailSend>");
			logger.info(requestXmlMailSend);
			String result = Utility.callUrl("http://api.trackcampaigns.com/v2.1/?mail/send",
					requestXmlMailSend.toString());
			logger.info(result);

		} else if ("Falconide".equalsIgnoreCase(providerInfo.getProviderName())) {
			StringBuilder requestXmlMailSend = new StringBuilder("data=").append("{").append("	\"api_key\":\"")
					.append(providerInfo.getProviderKey())
					.append("\", \"email_details\":{ \"fromname\":\"Weaver Team\", \"subject\":\"Weaver BackOffice\", \"from\":\"")
					.append("backoffice@mails.khelplayrummy.in\", \"replytoid\": \"backoffice@mails.khelplayrummy.in\", \"content\":\"")
					.append(text).append("\"").append(" }, ").append(" \"recipients\":[\"").append(emailId)
					.append("\"]").append("}");
			logger.info("---Request Mail XML--" + requestXmlMailSend);
			String result = Utility.callUrl("https://api.falconide.com/falconapi/web.send.json?",
					requestXmlMailSend.toString());
			logger.info(result);
		}

	}

	public static void main(String args[]) {

	}

	public void sendMail(StGenSmsEmailProviderMaster providerInfo, Session session, String mailType) {
		StCmsTemplateMaster stCmsTemplateMaster = null;
		StringBuffer emailVar = new StringBuffer();
		StringBuffer recipientsVar = new StringBuffer();
		StDmDomainAliasNameMaster aliasMaster;
		String urlString = null;
		String content = null;
		try {
			CommonMethodDaoImpl commonMethodDaoImpl = CommonMethodDaoImpl.getInstance();
			aliasMaster = commonMethodDaoImpl.getAliasMaster(session, aliasId);
			stCmsTemplateMaster = commonMethodDaoImpl.fetchTempleteUrlMap(aliasId, emailType, templateName, "EMAIL",
					session);
			String subjectVal = stCmsTemplateMaster.getTemplateSubject().contains("#")
					? stCmsTemplateMaster.getTemplateSubject().substring(0,
							stCmsTemplateMaster.getTemplateSubject().indexOf("#"))
					: stCmsTemplateMaster.getTemplateSubject();
			String path = Utility.getEnvironmentProperty("backOfficeUrl", "");

			urlString = path + "/WeaverBO/email-templates/client-specific/" + Utility.getClientName()
					+ stCmsTemplateMaster.getTemplatePath();
			logger.info("--------------providerInfo.getProviderName()-----------" + providerInfo.getProviderName());
			if ("AWS_SES".equalsIgnoreCase(providerInfo.getProviderName())) {

				content = inflateEmail(urlString, emailContentMap);

				AWSWrapper.sendEmail(content, subjectVal, stCmsTemplateMaster.getTemplateFromEmail(),
						emailContentMap.get("EmailId"));
			} else if ("Octane".equalsIgnoreCase(providerInfo.getProviderName())) {
				for (Map.Entry<String, String> entry : emailContentMap.entrySet()) {
					emailVar.append("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">");
				}
				StringBuilder requestXmlMailSend = new StringBuilder(
						"Request=<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("<MailSend>").append("<ApiKey>")
								.append(providerInfo.getProviderKey()).append("</ApiKey>").append("<Password>")
								.append(providerInfo.getProviderPass()).append("</Password>").append("<Request>")
								.append("<Mail>").append("<ContentSource>2</ContentSource>")
								.append("<Format>2</Format>").append("<FromEmail>")
								.append(stCmsTemplateMaster.getTemplateFromEmail()).append("</FromEmail>")
								.append("<FromName>")
								.append(Base64.encodeBase64String(stCmsTemplateMaster.getTemplateFromName().getBytes()))
								.append("</FromName>").append("<HtmlUrl>").append(URLEncoder.encode(urlString, "UTF-8"))
								.append("</HtmlUrl>").append("<Subject>")
								.append(Base64.encodeBase64String(subjectVal.getBytes())).append("</Subject>")
								.append("<ReplyTo>").append(stCmsTemplateMaster.getTemplateFromEmail())
								.append("</ReplyTo>").append("</Mail>").append("<Recipients>").append("<Recipient>")
								.append(emailVar).append("</Recipient>").append("</Recipients>").append("</Request>")
								.append("</MailSend>");
				logger.info("---Request Mail XML--" + requestXmlMailSend);
				String result = Utility.callUrl("http://api.trackcampaigns.com/v2.1/?mail/send",
						requestXmlMailSend.toString());

				insertMailResponse(result, emailContentMap.get("EmailId"), stCmsTemplateMaster.getTemplateId(),
						domainId, aliasId, userId, session);
				logger.info(result + "Template name=" + stCmsTemplateMaster.getTemplatePath() + "----------");

			} else if ("Falconide".equalsIgnoreCase(providerInfo.getProviderName())) {
				int mapSize = emailContentMap.size();
				int count = 1;
				for (Map.Entry<String, String> entry : emailContentMap.entrySet()) {
					if (entry.getKey().equalsIgnoreCase("emailId")) {
						recipientsVar.append(entry.getValue());
						emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"],");
						count++;
					} else {
						if (count == mapSize)
							emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"]");
						else {
							emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"],");
							count++;
						}
					}
				}
				String requestXmlMailSend = "data=" + "{" + "	\"api_key\":\"" + providerInfo.getProviderKey()
						+ "\", \"email_details\":{ \"fromname\":\"" + stCmsTemplateMaster.getTemplateFromName()
						+ "\", \"subject\":\"" + subjectVal + "\", \"from\":\""
						+ stCmsTemplateMaster.getFalconideTemplateFromEmail() + "\", \"replytoid\": \""
						+ stCmsTemplateMaster.getFalconideTemplateFromEmail() + "\", \"content\":\"%3Cp%\"" + " }, "
						+ "\"settings\":" + "{" + " \"template\":\"" + stCmsTemplateMaster.getFalconideTemplateId()
						+ "\" }," + " \"attributes\":{" + emailVar + " }," + " \"recipients\":[\"" + recipientsVar
						+ "\"]" + "}";
				logger.info("---Request Mail XML--" + requestXmlMailSend);
				String result = Utility.callUrl("https://api.falconide.com/falconapi/web.send.json?",
						requestXmlMailSend);
				insertFalconideMailResponse(result, emailContentMap.get("EmailId"), stCmsTemplateMaster.getTemplateId(),
						domainId, aliasId, userId, session);
				logger.info(result + "Template name=" + stCmsTemplateMaster.getTemplatePath() + "----------");

			} else if ("SMTP".equalsIgnoreCase(providerInfo.getProviderName())) {
				String smtpHost = CommonMethodDaoImpl.getInstance().fetchSystemProperties("MAIL_SMTP_HOST", session);
				content = inflateEmail(aliasMaster.getPublicUrl() + stCmsTemplateMaster.getTemplatePath(),
						emailContentMap);
				/* content="ok" */;
				SMTPMailService.getInstance().sendMail(providerInfo.getProviderKey(),
						stCmsTemplateMaster.getTemplateFromName(), emailId, stCmsTemplateMaster.getTemplateFromEmail(),
						subjectVal, content, smtpHost);
			}
		} catch (PMSException pmse) {
			logger.error(pmse.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendMail(StGenSmsEmailProviderMaster providerInfo, Session session, String mailType,
			UserInfoBean userInfoBean) {
		StCmsTemplateMaster stCmsTemplateMaster = null;
		StringBuffer emailVar = new StringBuffer();
		StringBuffer recipientsVar = new StringBuffer();
		StDmDomainAliasNameMaster aliasMaster;
		String urlString = null;
		String content = null;
		try {
			CommonMethodDaoImpl commonMethodDaoImpl = CommonMethodDaoImpl.getInstance();
			aliasMaster = commonMethodDaoImpl.getAliasMaster(session, aliasId);
			stCmsTemplateMaster = commonMethodDaoImpl.fetchTempleteUrlMap(aliasId, emailType, templateName, "EMAIL",
					session);
			String subjectVal = stCmsTemplateMaster.getTemplateSubject().contains("#")
					? stCmsTemplateMaster.getTemplateSubject().substring(0,
							stCmsTemplateMaster.getTemplateSubject().indexOf("#"))
					: stCmsTemplateMaster.getTemplateSubject();
			String path = Utility.getEnvironmentProperty("backOfficeUrl", "");

			urlString = path + "/WeaverBO/email-templates/client-specific/" + Utility.getClientName()
					+ stCmsTemplateMaster.getTemplatePath();
			logger.info("--------------providerInfo.getProviderName()-----------" + providerInfo.getProviderName());
			if ("AWS_SES".equalsIgnoreCase(providerInfo.getProviderName())) {

				content = inflateEmail(urlString, emailContentMap);

				AWSWrapper.sendEmail(content, subjectVal, stCmsTemplateMaster.getTemplateFromEmail(),
						emailContentMap.get("EmailId"));
			} else if ("Octane".equalsIgnoreCase(providerInfo.getProviderName())) {
				for (Map.Entry<String, String> entry : emailContentMap.entrySet()) {
					emailVar.append("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">");
				}
				StringBuilder requestXmlMailSend = new StringBuilder(
						"Request=<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("<MailSend>").append("<ApiKey>")
								.append(providerInfo.getProviderKey()).append("</ApiKey>").append("<Password>")
								.append(providerInfo.getProviderPass()).append("</Password>").append("<Request>")
								.append("<Mail>").append("<ContentSource>2</ContentSource>")
								.append("<Format>2</Format>").append("<FromEmail>")
								.append(stCmsTemplateMaster.getTemplateFromEmail()).append("</FromEmail>")
								.append("<FromName>")
								.append(Base64.encodeBase64String(stCmsTemplateMaster.getTemplateFromName().getBytes()))
								.append("</FromName>").append("<HtmlUrl>").append(URLEncoder.encode(urlString, "UTF-8"))
								.append("</HtmlUrl>").append("<Subject>")
								.append(Base64.encodeBase64String(subjectVal.getBytes())).append("</Subject>")
								.append("<ReplyTo>").append(stCmsTemplateMaster.getTemplateFromEmail())
								.append("</ReplyTo>").append("</Mail>").append("<Recipients>").append("<Recipient>")
								.append(emailVar).append("</Recipient>").append("</Recipients>").append("</Request>")
								.append("</MailSend>");
				logger.info("---Request Mail XML--" + requestXmlMailSend);
				String result = Utility.callUrl("http://api.trackcampaigns.com/v2.1/?mail/send",
						requestXmlMailSend.toString());

				insertMailResponse(result, emailContentMap.get("EmailId"), stCmsTemplateMaster.getTemplateId(),
						domainId, aliasId, userId, session);
				logger.info(result + "Template name=" + stCmsTemplateMaster.getTemplatePath() + "----------");

			} else if ("Falconide".equalsIgnoreCase(providerInfo.getProviderName())) {
				int mapSize = emailContentMap.size();
				int count = 1;
				for (Map.Entry<String, String> entry : emailContentMap.entrySet()) {
					if (entry.getKey().equalsIgnoreCase("emailId")) {
						recipientsVar.append(entry.getValue());
						emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"],");
						count++;
					} else {
						if (count == mapSize)
							emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"]");
						else {
							emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"],");
							count++;
						}
					}
				}
				String requestXmlMailSend = "data=" + "{" + "	\"api_key\":\"" + providerInfo.getProviderKey()
						+ "\", \"email_details\":{ \"fromname\":\"" + stCmsTemplateMaster.getTemplateFromName()
						+ "\", \"subject\":\"" + subjectVal + "\", \"from\":\""
						+ stCmsTemplateMaster.getFalconideTemplateFromEmail() + "\", \"replytoid\": \""
						+ stCmsTemplateMaster.getFalconideTemplateFromEmail() + "\", \"content\":\"%3Cp%\"" + " }, "
						+ "\"settings\":" + "{" + " \"template\":\"" + stCmsTemplateMaster.getFalconideTemplateId()
						+ "\" }," + " \"attributes\":{" + emailVar + " }," + " \"recipients\":[\"" + recipientsVar
						+ "\"]" + "}";
				logger.info("---Request Mail XML--" + requestXmlMailSend);
				String result = Utility.callUrl("https://api.falconide.com/falconapi/web.send.json?",
						requestXmlMailSend);
				insertFalconideMailResponse(result, emailContentMap.get("EmailId"), stCmsTemplateMaster.getTemplateId(),
						domainId, aliasId, userId, session);
				logger.info(result + "Template name=" + stCmsTemplateMaster.getTemplatePath() + "----------");

			} else if ("SMTP".equalsIgnoreCase(providerInfo.getProviderName())) {
				String smtpHost = CommonMethodDaoImpl.getInstance().fetchSystemProperties("MAIL_SMTP_HOST", session);
				content = inflateEmail(aliasMaster.getPublicUrl() + stCmsTemplateMaster.getTemplatePath(),
						emailContentMap, userInfoBean);
				/* content="ok" */;
				SMTPMailService.getInstance().sendMail(providerInfo.getProviderKey(),
						stCmsTemplateMaster.getTemplateFromName(), emailId, stCmsTemplateMaster.getTemplateFromEmail(),
						subjectVal, content, smtpHost);
			}
		} catch (PMSException pmse) {
			logger.error(pmse.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendMail(StGenSmsEmailProviderMaster providerInfo, Session session, String mailType,
			UserInfoBean userInfoBean, int gameNo, int batchNO, String mailMsg, String userEmail) {
		StCmsTemplateMaster stCmsTemplateMaster = null;
		StringBuffer emailVar = new StringBuffer();
		StringBuffer recipientsVar = new StringBuffer();
		StDmDomainAliasNameMaster aliasMaster;
		String urlString = null;
		String content = null;
		try {
			CommonMethodDaoImpl commonMethodDaoImpl = CommonMethodDaoImpl.getInstance();
			aliasMaster = commonMethodDaoImpl.getAliasMaster(session, aliasId);
			stCmsTemplateMaster = commonMethodDaoImpl.fetchTempleteUrlMap(aliasId, emailType, templateName, "EMAIL",
					session);
			String subjectVal = stCmsTemplateMaster.getTemplateSubject().contains("#")
					? stCmsTemplateMaster.getTemplateSubject().substring(0,
							stCmsTemplateMaster.getTemplateSubject().indexOf("#"))
					: stCmsTemplateMaster.getTemplateSubject();
			String path = Utility.getEnvironmentProperty("backOfficeUrl", "");

			urlString = path + "/WeaverBO/email-templates/client-specific/" + Utility.getClientName()
					+ stCmsTemplateMaster.getTemplatePath();
			logger.info("--------------providerInfo.getProviderName()-----------" + providerInfo.getProviderName());
			if ("AWS_SES".equalsIgnoreCase(providerInfo.getProviderName())) {

				content = inflateEmail(urlString, emailContentMap);

				AWSWrapper.sendEmail(content, subjectVal, stCmsTemplateMaster.getTemplateFromEmail(),
						emailContentMap.get("EmailId"));
			} else if ("Octane".equalsIgnoreCase(providerInfo.getProviderName())) {
				for (Map.Entry<String, String> entry : emailContentMap.entrySet()) {
					emailVar.append("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">");
				}
				StringBuilder requestXmlMailSend = new StringBuilder(
						"Request=<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("<MailSend>").append("<ApiKey>")
								.append(providerInfo.getProviderKey()).append("</ApiKey>").append("<Password>")
								.append(providerInfo.getProviderPass()).append("</Password>").append("<Request>")
								.append("<Mail>").append("<ContentSource>2</ContentSource>")
								.append("<Format>2</Format>").append("<FromEmail>")
								.append(stCmsTemplateMaster.getTemplateFromEmail()).append("</FromEmail>")
								.append("<FromName>")
								.append(Base64.encodeBase64String(stCmsTemplateMaster.getTemplateFromName().getBytes()))
								.append("</FromName>").append("<HtmlUrl>").append(URLEncoder.encode(urlString, "UTF-8"))
								.append("</HtmlUrl>").append("<Subject>")
								.append(Base64.encodeBase64String(subjectVal.getBytes())).append("</Subject>")
								.append("<ReplyTo>").append(stCmsTemplateMaster.getTemplateFromEmail())
								.append("</ReplyTo>").append("</Mail>").append("<Recipients>").append("<Recipient>")
								.append(emailVar).append("</Recipient>").append("</Recipients>").append("</Request>")
								.append("</MailSend>");
				logger.info("---Request Mail XML--" + requestXmlMailSend);
				String result = Utility.callUrl("http://api.trackcampaigns.com/v2.1/?mail/send",
						requestXmlMailSend.toString());

				insertMailResponse(result, emailContentMap.get("EmailId"), stCmsTemplateMaster.getTemplateId(),
						domainId, aliasId, userId, session);
				logger.info(result + "Template name=" + stCmsTemplateMaster.getTemplatePath() + "----------");

			} else if ("Falconide".equalsIgnoreCase(providerInfo.getProviderName())) {
				int mapSize = emailContentMap.size();
				int count = 1;
				for (Map.Entry<String, String> entry : emailContentMap.entrySet()) {
					if (entry.getKey().equalsIgnoreCase("emailId")) {
						recipientsVar.append(entry.getValue());
						emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"],");
						count++;
					} else {
						if (count == mapSize)
							emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"]");
						else {
							emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"],");
							count++;
						}
					}
				}
				String requestXmlMailSend = "data=" + "{" + "	\"api_key\":\"" + providerInfo.getProviderKey()
						+ "\", \"email_details\":{ \"fromname\":\"" + stCmsTemplateMaster.getTemplateFromName()
						+ "\", \"subject\":\"" + subjectVal + "\", \"from\":\""
						+ stCmsTemplateMaster.getFalconideTemplateFromEmail() + "\", \"replytoid\": \""
						+ stCmsTemplateMaster.getFalconideTemplateFromEmail() + "\", \"content\":\"%3Cp%\"" + " }, "
						+ "\"settings\":" + "{" + " \"template\":\"" + stCmsTemplateMaster.getFalconideTemplateId()
						+ "\" }," + " \"attributes\":{" + emailVar + " }," + " \"recipients\":[\"" + recipientsVar
						+ "\"]" + "}";
				logger.info("---Request Mail XML--" + requestXmlMailSend);
				String result = Utility.callUrl("https://api.falconide.com/falconapi/web.send.json?",
						requestXmlMailSend);
				insertFalconideMailResponse(result, emailContentMap.get("EmailId"), stCmsTemplateMaster.getTemplateId(),
						domainId, aliasId, userId, session);
				logger.info(result + "Template name=" + stCmsTemplateMaster.getTemplatePath() + "----------");

			} else if ("SMTP".equalsIgnoreCase(providerInfo.getProviderName())) {
				String smtpHost = CommonMethodDaoImpl.getInstance().fetchSystemProperties("MAIL_SMTP_HOST", session);
				content = inflateEmail(aliasMaster.getPublicUrl() + stCmsTemplateMaster.getTemplatePath(),
						emailContentMap, userInfoBean, gameNo, batchNO, mailMsg, emailId, userEmail);
				/* content="ok" */;
				SMTPMailService.getInstance().sendMail(providerInfo.getProviderKey(),
						stCmsTemplateMaster.getTemplateFromName(), emailId, stCmsTemplateMaster.getTemplateFromEmail(),
						subjectVal, content, smtpHost);
			}
		} catch (PMSException pmse) {
			logger.error(pmse.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendMail(StGenSmsEmailProviderMaster providerInfo, Session session) {
		StCmsTemplateMaster stCmsTemplateMaster = null;
		StringBuffer emailVar = new StringBuffer();
		StringBuffer recipientsVar = new StringBuffer();
		StDmDomainAliasNameMaster aliasMaster;
		String urlString = null;
		String content = null;
		try {
			CommonMethodDaoImpl commonMethodDaoImpl = CommonMethodDaoImpl.getInstance();
			aliasMaster = commonMethodDaoImpl.getAliasMaster(session, aliasId);
			stCmsTemplateMaster = commonMethodDaoImpl.fetchTempleteUrlMap(aliasId, mailType, templateName, "EMAIL",
					session);
			String subjectVal = stCmsTemplateMaster.getTemplateSubject().contains("#")
					? stCmsTemplateMaster.getTemplateSubject().substring(0,
							stCmsTemplateMaster.getTemplateSubject().indexOf("#"))
					: stCmsTemplateMaster.getTemplateSubject();
			String path = Utility.getEnvironmentProperty("backOfficeUrl", "");

			urlString = path + "/WeaverBO/email-templates/client-specific/" + Utility.getClientName()
					+ stCmsTemplateMaster.getTemplatePath();
			logger.info("--------------providerInfo.getProviderName()-----------" + providerInfo.getProviderName());
			if ("AWS_SES".equalsIgnoreCase(providerInfo.getProviderName())) {

				content = inflateEmail(urlString, emailContentMap);

				AWSWrapper.sendEmail(content, subjectVal, stCmsTemplateMaster.getTemplateFromEmail(),
						emailContentMap.get("EmailId"));
			} else if ("Octane".equalsIgnoreCase(providerInfo.getProviderName())) {
				for (Map.Entry<String, String> entry : emailContentMap.entrySet()) {
					emailVar.append("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">");
				}
				StringBuilder requestXmlMailSend = new StringBuilder(
						"Request=<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("<MailSend>").append("<ApiKey>")
								.append(providerInfo.getProviderKey()).append("</ApiKey>").append("<Password>")
								.append(providerInfo.getProviderPass()).append("</Password>").append("<Request>")
								.append("<Mail>").append("<ContentSource>2</ContentSource>")
								.append("<Format>2</Format>").append("<FromEmail>")
								.append(stCmsTemplateMaster.getTemplateFromEmail()).append("</FromEmail>")
								.append("<FromName>")
								.append(Base64.encodeBase64String(stCmsTemplateMaster.getTemplateFromName().getBytes()))
								.append("</FromName>").append("<HtmlUrl>").append(URLEncoder.encode(urlString, "UTF-8"))
								.append("</HtmlUrl>").append("<Subject>")
								.append(Base64.encodeBase64String(subjectVal.getBytes())).append("</Subject>")
								.append("<ReplyTo>").append(stCmsTemplateMaster.getTemplateFromEmail())
								.append("</ReplyTo>").append("</Mail>").append("<Recipients>").append("<Recipient>")
								.append(emailVar).append("</Recipient>").append("</Recipients>").append("</Request>")
								.append("</MailSend>");
				logger.info("---Request Mail XML--" + requestXmlMailSend);
				String result = Utility.callUrl("http://api.trackcampaigns.com/v2.1/?mail/send",
						requestXmlMailSend.toString());

				insertMailResponse(result, emailContentMap.get("EmailId"), stCmsTemplateMaster.getTemplateId(),
						domainId, aliasId, userId, session);
				logger.info(result + "Template name=" + stCmsTemplateMaster.getTemplatePath() + "----------");

			} else if ("Falconide".equalsIgnoreCase(providerInfo.getProviderName())) {
				int mapSize = emailContentMap.size();
				int count = 1;
				for (Map.Entry<String, String> entry : emailContentMap.entrySet()) {
					if (entry.getKey().equalsIgnoreCase("emailId")) {
						recipientsVar.append(entry.getValue());
						emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"],");
						count++;
					} else {
						if (count == mapSize)
							emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"]");
						else {
							emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"],");
							count++;
						}
					}
				}
				String requestXmlMailSend = "data=" + "{" + "	\"api_key\":\"" + providerInfo.getProviderKey()
						+ "\", \"email_details\":{ \"fromname\":\"" + stCmsTemplateMaster.getTemplateFromName()
						+ "\", \"subject\":\"" + subjectVal + "\", \"from\":\""
						+ stCmsTemplateMaster.getFalconideTemplateFromEmail() + "\", \"replytoid\": \""
						+ stCmsTemplateMaster.getFalconideTemplateFromEmail() + "\", \"content\":\"%3Cp%\"" + " }, "
						+ "\"settings\":" + "{" + " \"template\":\"" + stCmsTemplateMaster.getFalconideTemplateId()
						+ "\" }," + " \"attributes\":{" + emailVar + " }," + " \"recipients\":[\"" + recipientsVar
						+ "\"]" + "}";
				logger.info("---Request Mail XML--" + requestXmlMailSend);
				String result = Utility.callUrl("https://api.falconide.com/falconapi/web.send.json?",
						requestXmlMailSend);
				insertFalconideMailResponse(result, emailContentMap.get("EmailId"), stCmsTemplateMaster.getTemplateId(),
						domainId, aliasId, userId, session);
				logger.info(result + "Template name=" + stCmsTemplateMaster.getTemplatePath() + "----------");

			} else if ("SMTP".equalsIgnoreCase(providerInfo.getProviderName())) {
				String smtpHost = CommonMethodDaoImpl.getInstance().fetchSystemProperties("MAIL_SMTP_HOST", session);
				content = inflateEmail(aliasMaster.getPublicUrl() + stCmsTemplateMaster.getTemplatePath(),
						emailContentMap);
				/* content="ok" */;
				SMTPMailService.getInstance().sendMail(providerInfo.getProviderKey(),
						stCmsTemplateMaster.getTemplateFromName(), emailContentMap.get("EmailId"),
						stCmsTemplateMaster.getTemplateFromEmail(), subjectVal, content, smtpHost);
			}
		} catch (PMSException pmse) {
			logger.error(pmse.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendMail(CommonMethodDaoImpl commonMethodDaoImpl, StGenSmsEmailProviderMaster providerInfo,
			Session session) {
		StCmsTemplateMaster stCmsTemplateMaster = null;

		StringBuffer emailVar = new StringBuffer();
		StringBuffer recipientsVar = new StringBuffer();
		StDmDomainAliasNameMaster aliasMaster;
		String urlString = null;
		String domainName = null;
		String aliasName = null;
		try {
			aliasMaster = commonMethodDaoImpl.getAliasMaster(session, aliasId);
			if ("BYDEFAULT".equals(aliasMaster.getTemplate())) {
				aliasMaster = commonMethodDaoImpl.getAliasMaster(session, (short) 1);
				domainName = aliasMaster.getDomainMaster().getDomainName();
				aliasName = aliasMaster.getAliasName();
				stCmsTemplateMaster = commonMethodDaoImpl.fetchTempleteUrlMap((short) 1, mailType, null, "EMAIL",
						session);
				String layout = commonMethodDaoImpl.fetchAliasLayout(aliasId, "pc", session);
				String path = commonMethodDaoImpl.fetchSystemProperties("DEFAULT_CONTENT_PATH", session) + domainName
						+ "/" + aliasName + "/" + layout + "/pc/LR/email/eng/";
				urlString = URLEncoder.encode(path + stCmsTemplateMaster.getTemplatePath(), "UTF-8");
			} else {
				domainName = aliasMaster.getDomainMaster().getDomainName();
				aliasName = aliasMaster.getAliasName();
				if (templateName != null && templateName.contains("#")) {
					String[] parts = templateName.split("#");
					templateName = parts[0];
					urlString = URLEncoder.encode(aliasMaster.getPublicUrl() + parts[2], "UTF-8");
					stCmsTemplateMaster = commonMethodDaoImpl.fetchTempleteUrlMap(aliasId, mailType,
							templateName + "#" + parts[1], "EMAIL", session);
				} else {
					stCmsTemplateMaster = commonMethodDaoImpl.fetchTempleteUrlMap(aliasId, mailType, templateName,
							"EMAIL", session);
					String path = null;
					if ("PORTALCONTENT".equalsIgnoreCase(aliasMaster.getContentType())) {
						String layout = commonMethodDaoImpl.fetchAliasLayout(aliasId, "pc", session);
						path = commonMethodDaoImpl.fetchSystemProperties("DEFAULT_CONTENT_PATH", session) + domainName
								+ "/" + aliasName + "/" + layout + "/pc/LR/email/eng/";
					} else {
						path = aliasMaster.getPublicUrl();
					}
					urlString = URLEncoder.encode(path + stCmsTemplateMaster.getTemplatePath(), "UTF-8");
				}
			}
			String subjectVal = stCmsTemplateMaster.getTemplateSubject().contains("#")
					? stCmsTemplateMaster.getTemplateSubject().substring(0,
							stCmsTemplateMaster.getTemplateSubject().indexOf("#"))
					: stCmsTemplateMaster.getTemplateSubject();
			if ("AWS_SES".equalsIgnoreCase(providerInfo.getProviderName())) {
				String content = inflateEmail(aliasMaster.getPublicUrl() + stCmsTemplateMaster.getTemplatePath(),
						emailContentMap);
				AWSWrapper.sendEmail(content, subjectVal, stCmsTemplateMaster.getTemplateFromEmail(),
						emailContentMap.get("EmailId"));
			} else if ("Octane".equalsIgnoreCase(providerInfo.getProviderName())) {
				for (Map.Entry<String, String> entry : emailContentMap.entrySet()) {
					emailVar.append("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">");
				}
				StringBuilder requestXmlMailSend = new StringBuilder(
						"Request=<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("<MailSend>").append("<ApiKey>")
								.append(providerInfo.getProviderKey()).append("</ApiKey>").append("<Password>")
								.append(providerInfo.getProviderPass()).append("</Password>").append("<Request>")
								.append("<Mail>").append("<ContentSource>2</ContentSource>")
								.append("<Format>2</Format>").append("<FromEmail>")
								.append(stCmsTemplateMaster.getTemplateFromEmail()).append("</FromEmail>")
								.append("<FromName>")
								.append(Base64.encodeBase64String(stCmsTemplateMaster.getTemplateFromName().getBytes()))
								.append("</FromName>").append("<HtmlUrl>").append(urlString).append("</HtmlUrl>")
								.append("<Subject>").append(Base64.encodeBase64String(subjectVal.getBytes()))
								.append("</Subject>").append("<ReplyTo>")
								.append(stCmsTemplateMaster.getTemplateFromEmail()).append("</ReplyTo>")
								.append("</Mail>").append("<Recipients>").append("<Recipient>").append(emailVar)
								.append("</Recipient>").append("</Recipients>").append("</Request>")
								.append("</MailSend>");
				logger.info("---Request Mail XML--" + requestXmlMailSend);
				String result = Utility.callUrl("http://api.trackcampaigns.com/v2.1/?mail/send",
						requestXmlMailSend.toString());

				insertMailResponse(result, emailContentMap.get("EmailId"), stCmsTemplateMaster.getTemplateId(),
						domainId, aliasId, userId, session);
				logger.info(result + "Template name=" + stCmsTemplateMaster.getTemplatePath() + "----------");

			} else if ("Falconide".equalsIgnoreCase(providerInfo.getProviderName())) {
				int mapSize = emailContentMap.size();
				int count = 1;
				for (Map.Entry<String, String> entry : emailContentMap.entrySet()) {
					if (entry.getKey().equalsIgnoreCase("emailId")) {
						recipientsVar.append(entry.getValue());
						emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"],");
						count++;
					} else {
						if (count == mapSize)
							emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"]");
						else {
							emailVar.append("\"" + entry.getKey() + "\":[\"" + entry.getValue() + "\"],");
							count++;
						}
					}
				}
				String requestXmlMailSend = "data=" + "{" + "	\"api_key\":\"" + providerInfo.getProviderKey()
						+ "\", \"email_details\":{ \"fromname\":\"" + stCmsTemplateMaster.getTemplateFromName()
						+ "\", \"subject\":\"" + subjectVal + "\", \"from\":\""
						+ stCmsTemplateMaster.getFalconideTemplateFromEmail() + "\", \"replytoid\": \""
						+ stCmsTemplateMaster.getFalconideTemplateFromEmail() + "\", \"content\":\"%3Cp%\"" + " }, "
						+ "\"settings\":" + "{" + " \"template\":\"" + stCmsTemplateMaster.getFalconideTemplateId()
						+ "\" }," + " \"attributes\":{" + emailVar + " }," + " \"recipients\":[\"" + recipientsVar
						+ "\"]" + "}";
				logger.info("---Request Mail XML--" + requestXmlMailSend);
				String result = Utility.callUrl("https://api.falconide.com/falconapi/web.send.json?",
						requestXmlMailSend);
				insertFalconideMailResponse(result, emailContentMap.get("EmailId"), stCmsTemplateMaster.getTemplateId(),
						domainId, aliasId, userId, session);
				logger.info(result + "Template name=" + stCmsTemplateMaster.getTemplatePath() + "----------");
			}
		} catch (PMSException pmse) {
			logger.error(pmse.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String sendRegistrationSMS(PlayerInfoBean playerRegDataBean) {
		try {
			/*
			 * MSG to be Fetched Here
			 */
			Session session = HibernateSessionFactory.getSession();
			String msg = "Dear " + playerRegDataBean.getFirstName() + " " + playerRegDataBean.getLastName() + ",\n\n"
					+ "Your login password for "
					+ CommonMethodDaoImpl.getInstance()
							.getAliasPropertyMap(session, playerRegDataBean.getAliasId(), "aliasName").get("aliasName")// Utility.dmPropMap.get(playerRegDataBean.getDomainId())
					+ " is " + playerRegDataBean.getPassword() + ".\n\n Thanks & Regards \n  Weaver Team";
			URL url = new URL("http://transapi.alertsindia.com/Desk2web/sendsms.aspx");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setReadTimeout(3000);
			conn.setConnectTimeout(5000);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			String urlStr = "UserName=payworld&password=pay1world&MobileNo=91"
					+ playerRegDataBean.getMobileNo().toString() + "&SenderID=ALERTS&CDMAHeader=ALERTS&Message=" + msg
					+ "&isFlash=False";
			logger.info("Arguments: " + urlStr);
			wr.write(urlStr);
			wr.flush();
			InputStream iStream = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String deliveryMsg = sb.toString();
			return deliveryMsg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";

	}

	public String sendRegistrationSMS(UserInfoBean userInfoBean, String username, String password) {
		try {
			/*
			 * MSG to be Fetched Here
			 */
			Session session = HibernateSessionFactory.getSession();
			String msg = "msg";
			URL url = new URL("http://124.158.6.45/CMC_BRAND/Service.asmx/SendSMSBrandName?");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setReadTimeout(3000);
			conn.setConnectTimeout(5000);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			String urlStr = "phone=string&sms=string&sender=string&username=string&password=string";
			logger.info("Arguments: " + urlStr);
			wr.write(urlStr);
			wr.flush();
			InputStream iStream = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String deliveryMsg = sb.toString();
			return deliveryMsg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";

	}

	public static void sendOLAWdrlProcesssSMS(String plrName, double amount, String mobileNo) {
		try {

			String msg = "Dear " + plrName + ",\n\n" + "Your withdrawal request for the amount of " + amount
					+ " has been processed.Please contact to your prefered retailer to collect the money."
					+ "\n\n Thanks & Regards \n  Weaver Team";

			URL url = new URL("http://transapi.alertsindia.com/Desk2web/sendsms.aspx");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(3000);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			String urlStr = "UserName=payworld&password=pay1world&MobileNo=91" + mobileNo
					+ "&SenderID=ALERTS&CDMAHeader=ALERTS&Message=" + msg + "&isFlash=False";
			logger.info("Arguments: " + urlStr);
			wr.write(urlStr);
			wr.flush();
			InputStream iStream = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String deliveryMsg = sb.toString();
			logger.info("---deliveryMsg---" + deliveryMsg);
		} catch (Exception e) {
			logger.error("---SMS sending failed---");
			e.printStackTrace();
		} catch (Error e) {
			logger.error("---SMS sending failed---");
			e.printStackTrace();
		}
	}

	public static void callSendMail(Map<String, String> emailContentMap, String mailType, short domainId, short aliasId,
			int userId, Session session) throws PMSException {
		callSendMail(emailContentMap, mailType, domainId, aliasId, null, userId, session);
	}

	public static void callSendSms(UserDetailsBean userDetailsBean, String smsType, Session session,Map<String,String> emailContentMap)
			throws PMSException {
		callSendSMS(userDetailsBean, smsType, session,emailContentMap);
	}

	public static void callSendSMS(UserDetailsBean userInfobean, String smsType, Session session,Map<String,String> emailContentMap) throws PMSException {

		SMSDetailImpl smsDetailImpl = new SMSDetailImpl();
		CommMgmtSmsController commDao = new CommMgmtSmsController(userInfobean, smsType,
				smsDetailImpl.getSmsAuthorization(session).getProviderKey(),
				smsDetailImpl.getSmsAuthorization(session).getProviderPass(),
				smsDetailImpl.getSMSContent(session, smsType,emailContentMap));
		commDao.setDaemon(false);
		commDao.start();

		
	}

	public static void callSendMail(Map<String, String> emailContentMap, String mailType, short domainId, short aliasId,
			String templateName, int userId, Session session) throws PMSException {
		if ("Y".equals(CommonMethodDaoImpl.getInstance().fetchSystemProperties("SYSTEM_SEND_MAIL", session))) {
			CommMgmtController commDao = new CommMgmtController(emailContentMap, mailType, domainId, templateName,
					userId, aliasId);
			commDao.setDaemon(false);
			commDao.start();
		} else
			logger.info("---SYSTEM_SEND_MAIL ---- set to N ");
	}

	public static void boMailSending(String emailId, String text, short domainId, short aliasId, Session session) {
		try {

			if ("Y".equals(CommonMethodDaoImpl.getInstance().fetchSystemProperties("SYSTEM_SEND_BO_MAIL", session))) {
				CommMgmtController commMgmtController = new CommMgmtController(emailId, text, domainId, aliasId);
				commMgmtController.setDaemon(false);
				commMgmtController.start();
			}
		} catch (PMSException e) {
			e.printStackTrace();
		}
	}

	public static void boMailSending(String emailId, String text, short domainId, short aliasId, Session session,
			String emailType) {
		try {

			if ("Y".equals(CommonMethodDaoImpl.getInstance().fetchSystemProperties("SYSTEM_SEND_BO_MAIL", session))) {
				CommMgmtController commMgmtController = new CommMgmtController(emailId, text, domainId, aliasId,
						emailType);
				commMgmtController.setDaemon(false);
				commMgmtController.start();
			}
		} catch (PMSException e) {
			e.printStackTrace();
		}
	}

	public static void boMailSending(String emailId, String text, short domainId, short aliasId, Session session,
			String emailType, UserInfoBean userInfoBean, int gameNO, int batchNo, String mailMsg, String userEmail) {
		try {

			if ("Y".equals(CommonMethodDaoImpl.getInstance().fetchSystemProperties("SYSTEM_SEND_BO_MAIL", session))) {
				CommMgmtController commMgmtController = new CommMgmtController(emailId, text, domainId, aliasId,
						emailType, userInfoBean, gameNO, batchNo, mailMsg, userEmail);
				commMgmtController.setDaemon(false);
				commMgmtController.start();
			}
		} catch (PMSException e) {
			e.printStackTrace();
		}
	}

	public static void boMailSending(String emailId, String text, short domainId, short aliasId, Session session,
			String emailType, UserInfoBean userInfoBean) {
		try {

			if ("Y".equals(CommonMethodDaoImpl.getInstance().fetchSystemProperties("SYSTEM_SEND_BO_MAIL", session))) {
				CommMgmtController commMgmtController = new CommMgmtController(emailId, text, domainId, aliasId,
						emailType, userInfoBean);
				commMgmtController.setDaemon(false);
				commMgmtController.start();
			}
		} catch (PMSException e) {
			e.printStackTrace();
		}
	}

	private void insertMailResponse(String xmlString, String emailId, Integer templateId, short domainId, short aliasId,
			int userId, Session session) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			char[] replaceAfter = { '<', '/' };
			xmlString = xmlString.replace("Response", "externalMailResponseString")
					.replace("Result", "mailResponseInfoDataBean").replace("Error>", "mailResponseInfoDataBean>");
			xmlString = WordUtils.uncapitalize(xmlString, replaceAfter);
			MailResponseBean respBean = (MailResponseBean) XmlUtil.reader("externalMailResponseString",
					MailResponseBean.class, xmlString, MailResponseBean.class.getPackage());
			StPmPlrMailResponseHistory mailResponseBean = new StPmPlrMailResponseHistory(null, domainId, aliasId,
					templateId, userId, emailId, respBean.getSuccess(),
					respBean.getMailResponseInfoDataBean().getTotalNumberOfRecipients(),
					respBean.getMailResponseInfoDataBean().getNoOfEmailsSent(),
					respBean.getMailResponseInfoDataBean().getNoOfUnsentEmails(),
					respBean.getMailResponseInfoDataBean().getNoOfSuppressedEmails(),
					respBean.getMailResponseInfoDataBean().getNoOfFilteredEmails(),
					respBean.getMailResponseInfoDataBean().getMessage(),
					respBean.getMailResponseInfoDataBean().getErrorcode(), respBean.getRequestId(),
					new Timestamp(Calendar.getInstance().getTimeInMillis()));
			session.save(mailResponseBean);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
	}

	private static void insertFalconideMailResponse(String xmlString, String emailId, Integer templateId,
			short domainId, short aliasId, int userId, Session session) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			StPmPlrFalconideMailResponseHistory mailResponseBean = new StPmPlrFalconideMailResponseHistory(null,
					domainId, aliasId, templateId, userId, emailId, xmlString,
					new Timestamp(Calendar.getInstance().getTimeInMillis()));
			session.save(mailResponseBean);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
	}

	public String inflateEmail(String templateUrl, Map<String, String> emailContentMap) {
		String templaterStr = null;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(templateUrl).openStream()))) {
			String line;
			StringBuffer template = new StringBuffer("");
			while ((line = br.readLine()) != null)
				template.append(line);
			templaterStr = template.toString();
			if (emailContentMap.get("Name") != null)
				templaterStr = templaterStr.replaceAll("Name", emailContentMap.get("name"));

			for (Map.Entry<String, String> entry : emailContentMap.entrySet())
				templaterStr = templaterStr.replaceAll("\\{\\s*" + entry.getKey() + "\\s*,\\s*fallback\\s*=\\}",
						entry.getValue());
		} catch (MalformedURLException mu) {
			mu.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();

		}
		return templaterStr;
	}

	public String inflateEmail(String templateUrl, Map<String, String> emailContentMap, UserInfoBean userInfoBean) {
		String templaterStr = null;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(templateUrl).openStream()))) {
			String line;
			StringBuffer template = new StringBuffer("");
			while ((line = br.readLine()) != null)
				template.append(line);
			templaterStr = template.toString();
			if (emailContentMap.get("Name") != null)
				templaterStr = templaterStr.replaceAll("Name", emailContentMap.get("name"));
			if (userInfoBean != null) {
				emailContentMap.put("EmailId", userInfoBean.getUserName());
				emailContentMap.put("FirstName", userInfoBean.getUserName());
				emailContentMap.put("UserName", userInfoBean.getUserName());
				emailContentMap.put("UserPassword", ZipFileProtection.ZIP_LOGIN_PASSWORD.substring(4,
						ZipFileProtection.ZIP_LOGIN_PASSWORD.length()));
			}
			for (Map.Entry<String, String> entry : emailContentMap.entrySet())
				templaterStr = templaterStr.replaceAll("\\{\\s*" + entry.getKey() + "\\s*,\\s*fallback\\s*=\\}",
						entry.getValue());
		} catch (MalformedURLException mu) {
			mu.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();

		}
		return templaterStr;
	}

	public String inflateEmail(String templateUrl, Map<String, String> emailContentMap, UserInfoBean userInfoBean,
			int gameNO, int batchNO, String mailMsg, String emailId, String userEmail) {
		String templaterStr = null;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(templateUrl).openStream()))) {
			String line;
			StringBuffer template = new StringBuffer("");
			while ((line = br.readLine()) != null)
				template.append(line);
			templaterStr = template.toString();
			if (emailContentMap.get("Name") != null)
				templaterStr = templaterStr.replaceAll("Name", emailContentMap.get("name"));
			if (userInfoBean != null) {
				emailContentMap.put("EmailId", userEmail);
				emailContentMap.put("FirstName", userInfoBean.getUserName().toUpperCase());
				emailContentMap.put("UserName", userInfoBean.getUserName().toUpperCase());
				emailContentMap.put("GameNo", gameNO + "");
				emailContentMap.put("BatchNo", batchNO + "");
				emailContentMap.put("MailMsg", mailMsg.replaceAll("'", ""));
				if (mailMsg.equalsIgnoreCase("'requested for print ready'")) {
					emailContentMap.put("UserPassword", ZipFileProtection.ZIP_LOGIN_PASSWORD.substring(4,
							ZipFileProtection.ZIP_LOGIN_PASSWORD.length()));
					emailContentMap.put("PasswordMsg", "Here is your zip file password : ");
					emailContentMap.put("ZipUserName", userInfoBean.getUserName().toUpperCase());
					emailContentMap.put("ZipUsernameMsg", "Username : ");
					emailContentMap.put("ZipPasswordMsg", "Password : ");
					emailContentMap.put("HINT", "HINT : ");
					emailContentMap.put("HINTMSG",
							"example, if your username is Kathleen and password that you've received on bomaster mail is 999999 then your final password will be KATH999999.");

				} else {
					templaterStr = templaterStr.replaceAll("\\{\\s*" + "UserPassword" + "\\s*,\\s*fallback\\s*=\\}",
							"");
					templaterStr = templaterStr.replaceAll("\\{\\s*" + "PasswordMsg" + "\\s*,\\s*fallback\\s*=\\}", "");
					templaterStr = templaterStr.replaceAll("\\{\\s*" + "ZipUserName" + "\\s*,\\s*fallback\\s*=\\}", "");
					templaterStr = templaterStr.replaceAll("\\{\\s*" + "ZipUsernameMsg" + "\\s*,\\s*fallback\\s*=\\}",
							"");
					templaterStr = templaterStr.replaceAll("\\{\\s*" + "ZipPasswordMsg" + "\\s*,\\s*fallback\\s*=\\}",
							"");
					templaterStr = templaterStr.replaceAll("\\{\\s*" + "HINT" + "\\s*,\\s*fallback\\s*=\\}", "");
					templaterStr = templaterStr.replaceAll("\\{\\s*" + "HINTMSG" + "\\s*,\\s*fallback\\s*=\\}", "");

				}

			}

			for (Map.Entry<String, String> entry : emailContentMap.entrySet())
				templaterStr = templaterStr.replaceAll("\\{\\s*" + entry.getKey() + "\\s*,\\s*fallback\\s*=\\}",
						entry.getValue());

		} catch (MalformedURLException mu) {
			mu.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();

		}
		return templaterStr;
	}

	public String getMailType() {
		return mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
	}

	public Map<String, String> getEmailContentMap() {
		return emailContentMap;
	}

	public void setEmailContentMap(Map<String, String> emailContentMap) {
		this.emailContentMap = emailContentMap;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public short getAliasId() {
		return aliasId;
	}

	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public UserInfoBean getUserInfoBean() {
		return userInfoBean;
	}

	public void setUserInfoBean(UserInfoBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}

	public int getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}

	public String getMailMsg() {
		return mailMsg;
	}

	public void setMailMsg(String mailMsg) {
		this.mailMsg = mailMsg;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	
}
