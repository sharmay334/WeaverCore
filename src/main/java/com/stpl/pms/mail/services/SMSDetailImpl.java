package com.stpl.pms.mail.services;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.hibernate.mapping.StCmsTemplateMaster;
import com.stpl.pms.hibernate.mapping.StGenSmsEmailProviderMaster;

public class SMSDetailImpl {

	public StGenSmsEmailProviderMaster getSmsAuthorization(Session session){
		try{
			Criteria criteria = session.createCriteria(StGenSmsEmailProviderMaster.class);
			criteria.add(Restrictions.eq("providerType","SMS"));
			criteria.add(Restrictions.eq("priorityOrder", 1));
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			List<StGenSmsEmailProviderMaster> result = criteria.list();
			if(result!=null){
				for(StGenSmsEmailProviderMaster obj: result){
					return obj;
				}
			}
			
		}catch(Exception e){e.printStackTrace();}
	return null;	
	}

	public String getSMSContent(Session session, String smsType,Map<String,String> emailContentMap) {
		// TODO Auto-generated method stub
		try{
			String templatePath = null;
			Criteria criteria = session.createCriteria(StCmsTemplateMaster.class);
			criteria.add(Restrictions.eq("mode", "SMS"));
			criteria.add(Restrictions.eq("templateType", smsType));
			criteria.add(Restrictions.eq("status", "ACTIVE"));
			List<StCmsTemplateMaster> result = criteria.list();
			if(result!=null){
				for(StCmsTemplateMaster obj:result){
					templatePath = obj.getTemplatePath();
				}
				
					InputStream inputStream = new ByteArrayInputStream(templatePath.getBytes());
					String templaterStr = null;
					BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
					String line;
					StringBuffer template = new StringBuffer("");
					while((line = br.readLine()) != null)
						template.append(line);
					templaterStr = template.toString();
					for (Map.Entry<String, String> entry : emailContentMap.entrySet()){
						templaterStr = templaterStr.replaceAll("\\{\\s*" + entry.getKey() + "\\s*,\\s*fallback\\s*=\\}",
								entry.getValue());
					}
					return templaterStr;
					
				
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return null;
	}
	
}
