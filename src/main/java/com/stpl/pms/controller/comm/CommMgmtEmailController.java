package com.stpl.pms.controller.comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.hibernate.Session;

import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.StCmsTemplateMaster;
import com.stpl.pms.hibernate.mapping.StDmDomainAliasNameMaster;
import com.stpl.pms.hibernate.mapping.StGenSmsEmailProviderMaster;
import com.stpl.pms.javabeans.UserInfoBean;
import com.stpl.pms.mail.services.SMTPMailService;
import com.stpl.pms.security.ZipFileProtection;

public class CommMgmtEmailController extends Thread {

	Map<String,String> emailContentMap;
	UserInfoBean userInfoBean;
	String emailType;
	
	
	
	public CommMgmtEmailController(){
		
	}
	public CommMgmtEmailController(Map<String, String> emailContentMap, String emailType, UserInfoBean userInfoBean) {
		// TODO Auto-generated constructor stub
	this.emailContentMap = emailContentMap;
	this.userInfoBean = userInfoBean;
	this.emailType = emailType;
	
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		mailSending();
		
	}
	
	private void mailSending() {
		// TODO Auto-generated method stub
		StCmsTemplateMaster stCmsTemplateMaster = null;
		StDmDomainAliasNameMaster aliasMaster;
		String content = null;
		try{
			Session session = HibernateSessionFactory.getSession();
			CommonMethodDaoImpl commonMethodDaoImpl = CommonMethodDaoImpl.getInstance();
			StGenSmsEmailProviderMaster providerInfo = commonMethodDaoImpl.fetchSmsEmailProvider((short)1, "EMAIL",
					session);
			aliasMaster = commonMethodDaoImpl.getAliasMaster(session, (short)1);
			stCmsTemplateMaster = commonMethodDaoImpl.fetchTempleteUrlMap((short)1, emailType, null, "EMAIL",
					session);
			String subjectVal = stCmsTemplateMaster.getTemplateSubject().contains("#")
					? stCmsTemplateMaster.getTemplateSubject().substring(0,
							stCmsTemplateMaster.getTemplateSubject().indexOf("#"))
					: stCmsTemplateMaster.getTemplateSubject();
			String smtpHost = CommonMethodDaoImpl.getInstance().fetchSystemProperties("MAIL_SMTP_HOST", session);
			content = inflateEmail(aliasMaster.getPublicUrl() + stCmsTemplateMaster.getTemplatePath(),
					emailContentMap);
			/* content="ok" */;
			if(subjectVal.contains("supp")) {
				String text = "#"+emailContentMap.get("GameNo")+" - #"+emailContentMap.get("BatchNo");
				subjectVal = subjectVal.replaceAll("supp", text);
			}
			SMTPMailService.getInstance().sendMail(providerInfo.getProviderKey(),
					stCmsTemplateMaster.getTemplateFromName(), emailContentMap.get("EmailId"),
					stCmsTemplateMaster.getTemplateFromEmail(), subjectVal, content, smtpHost);
		}catch(Exception e){e.printStackTrace();}
		
	}
	public static void sendMail(Map<String, String> emailContentMap, String emailType, UserInfoBean userInfoBean){
		
		try{
			CommMgmtEmailController commMgmtController = new CommMgmtEmailController(emailContentMap,emailType,userInfoBean);
			commMgmtController.setDaemon(false);
			commMgmtController.start();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
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
	public Map<String, String> getEmailContentMap() {
		return emailContentMap;
	}
	public void setEmailContentMap(Map<String, String> emailContentMap) {
		this.emailContentMap = emailContentMap;
	}
	public UserInfoBean getUserInfoBean() {
		return userInfoBean;
	}
	public void setUserInfoBean(UserInfoBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}
	public String getEmailType() {
		return emailType;
	}
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	
}
