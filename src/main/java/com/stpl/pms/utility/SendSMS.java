package com.stpl.pms.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.stpl.pms.controller.commonMethods.CommonMethodController;
import com.stpl.pms.daoImpl.commonMethods.CommonMethodDaoImpl;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.mapping.StCmsTemplateMaster;
import com.stpl.pms.hibernate.mapping.StGenSmsEmailProviderMaster;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SendSMS extends Thread {
	
	private String  mobileNo;
	private String msg;
	private List<LinkedHashMap<String,String>> smsContentList;
	private Map<String,String> varMap;
	private String provider;
	private String smsType;
	private short domainId;
	private short aliasId;
	
	private static final Logger logger = Logger.getLogger(SendSMS.class);
	private final static String charset_utf8 = "UTF-8";
	private final static String POST = "POST";
	private static String unicelApiUserName = "Serntytr";
	private static String unicelApiPassword = "Stpl2011";
    private static String COUNTRY_PREFIX_EAST_TIMOR= "+670";
    private static String COUNTRY_PREFIX_GUINEA= "+224";


    public SendSMS(){
		
	}
	
	public SendSMS(short aliasId,String mobileNo,String msg, String provider) {
		this.msg = msg;
		this.mobileNo = mobileNo;
		this.aliasId=aliasId;
		this.provider = provider;
	}
	
	public SendSMS(List<LinkedHashMap<String,String>> smsContentList, String provider, String smsType, short domainId, short aliasId){
		this.smsContentList = smsContentList;
		this.provider = provider;
		this.smsType = smsType;
		this.domainId = domainId;
		this.aliasId = aliasId;
		
	}
	
	public SendSMS(Map<String,String> varMap, String provider, String smsType, short domainId, short aliasId){
		this.varMap = varMap;
		this.provider = provider;
		this.smsType = smsType;
		this.domainId = domainId;
		this.aliasId = aliasId;
	}
	
	public void run(){
		sendSMSAlert("","",mobileNo,"",msg,"","");
	}
	
	public  static void massMsgSend(List<LinkedHashMap<String,String>> smsContentList,String smsType, short domainId, short aliasId,Session session) throws PMSException{
		CommonMethodDaoImpl comMeDao=CommonMethodDaoImpl.getInstance();
		if ("Y".equals(comMeDao.fetchSystemProperties("SYSTEM_SEND_SMS",session))) {
			StGenSmsEmailProviderMaster providerInfo=comMeDao.fetchSmsEmailProvider(aliasId,"SMS", session);
			List<String> dynamicSenderProviders = Arrays.asList("unicel","AWS_SNS","MTN");
			SendSMS commDao = new SendSMS(smsContentList, providerInfo != null?(dynamicSenderProviders.contains(providerInfo.getProviderName())?providerInfo.getProviderName()+"#"+providerInfo.getProviderKey():providerInfo.getProviderName()):"", smsType, domainId, aliasId);
			commDao.setDaemon(false);
			commDao.start();
		} else{
			logger.info("---SYSTEM_SEND_SMS ---- set to N ");}
	}


	public  static boolean sendMsg(Map<String,String> varMap,String smsType, short domainId, short aliasId,Session session) throws PMSException{
		CommonMethodDaoImpl comMeDao=CommonMethodDaoImpl.getInstance();
		if ("Y".equals(comMeDao.fetchSystemProperties("SYSTEM_SEND_SMS",session))) {
			StGenSmsEmailProviderMaster providerInfo=comMeDao.fetchSmsEmailProvider(aliasId,"SMS", session);
			List<String> dynamicSenderProviders = Arrays.asList("unicel","AWS_SNS","MTN");
			SendSMS commDao = new SendSMS(varMap, providerInfo != null?(dynamicSenderProviders.contains(providerInfo.getProviderName())?providerInfo.getProviderName()+"#"+providerInfo.getProviderKey():providerInfo.getProviderName()):"", smsType, domainId, aliasId);
			commDao.setDaemon(false);
			commDao.start();
			return true;
		} else{
			logger.info("---SYSTEM_SEND_SMS ---- set to N ");
			return false;
		}
	}
	
	public void sendSMS(List<LinkedHashMap<String,String>> smsContentList, String provider, String smsType,  short domianId, short aliasId) {
		try {
			CommonMethodController cont = CommonMethodController.getInstance();
			StCmsTemplateMaster tempMas = cont.fetchTempleteUrlMap(aliasId, smsType, "SMS");
			String msg = tempMas.getTemplatePath();
			for (LinkedHashMap<String, String> smsVerMap : smsContentList) {
				msg = replaceMobVarWithValue(msg,smsVerMap);
				msg  = msg.replace("<br>", "\n").replace("<br />", "\n").replace("&nbsp;", " "); 
				sendSMS(aliasId,smsVerMap.get("mobileNo"), msg, provider);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sendSMSAlert(String user,String pass,String mobile,String smsId,String sms,String flash,String smsId1) {
		
		String urlHeader = "user=Gir2020&password=Aj!@%2376341&msisdn="+mobile+"&sid=SMSJSC&msg="+sms+"&fl=0&gwid=2";
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url("http://smst.sayonetechnologies.com/vendorsms/pushsms.aspx?"+urlHeader)
				  .method("GET", null)
				  .build();
				Response response = null;
				try {
					response = client.newCall(request).execute();
					
					System.out.println("[:::::::::::SMS INFO::::::] SENT SMS TO "+mobile +" -------RESPONSE"+response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("[:::::::::::SMS ERROR::::::]FAILED TO SEND SMS TO "+mobile);
				}
				finally {
					response.close();
				}
		
		
	}
	public void sendSMSComm(Map<String,String> varMap, String provider, StCmsTemplateMaster tempMas, short aliasId) {
		try {
			String msg = tempMas.getTemplatePath();
			msg = replaceMobVarWithValue(msg,varMap).replace("<br>", "\n").replace("<br />", "\n").replace("&nbsp;", " ");
			sendSMS(aliasId,varMap.get("mobileNo"), msg, provider);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendSMS(Map<String,String> varMap, String provider, String smsType,  short domianId, short aliasId) {
		try {
			StCmsTemplateMaster tempMas = CommonMethodController.getInstance().fetchTempleteUrlMap(aliasId, smsType, "SMS");
			String msg = tempMas.getTemplatePath();
			/*if("WARI".equals(varMap.get("WithdrawalProvider")))
				msg="Cher "+varMap.get("UserName")+", le transfert a ete effectue vers WARI. Code: "+varMap.get("ReferenceTxnNo")+". Presentez-vous avec une piece d’identite de "+(varMap.get("FirstName")!=null?varMap.get("FirstName"):"")+" "+(varMap.get("LastName")!=null?varMap.get("LastName"):"")+". "+Utility.getServerDate(0,0,0,"dd/MM/yy");
			else*/
				msg = replaceMobVarWithValue(msg,varMap).replace("<br>", "\n").replace("<br />", "\n").replace("&nbsp;", " ");
			sendSMS(aliasId,varMap.get("mobileNo"), msg, provider);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
	public String replaceMobVarWithValue(String msg,Map<String, String> smsVerMap) throws IOException{
//		if(smsVerMap.get("InvitionLink")!=null)
//			msg = msg.replace("{InvitionLink , fallback=}", smsVerMap.get("InvitionLink"));
//		if(smsVerMap.get("Email")!=null)
//			msg = msg.replace("{Email,fallback=}", smsVerMap.get("Email"));
//		if(smsVerMap.get("LastName")!=null)
//			msg = msg.replace("{LastName, fallback=}", smsVerMap.get("LastName"));
//		if(smsVerMap.get("MobileNo")!=null)
//			msg = msg.replace("{MobileNo, fallback=}", smsVerMap.get("MobileNo"));
//		if(smsVerMap.get("FirstName")!=null)	
//			msg = msg.replace("{FirstName,fallback=}", smsVerMap.get("FirstName"));
//		if(smsVerMap.get("UserName")!=null)
//			msg = msg.replace("{UserName, fallback=}", smsVerMap.get("UserName"));
//		if(smsVerMap.get("Name")!=null)	
//			msg = msg.replace("{Name,fallback=}", smsVerMap.get("Name"));
//		if(smsVerMap.get("ReferenceNo")!=null)	
//			msg = msg.replace("{ReferenceNo, fallback=}", smsVerMap.get("ReferenceNo"));
//		if(smsVerMap.get("SecureKey")!=null)	
//			msg = msg.replace("{SecureKey, fallback=}", smsVerMap.get("SecureKey"));
//		if(smsVerMap.get("Amount")!=null)	
//			msg = msg.replace("{amount, fallback=}", smsVerMap.get("Amount"));
//		if(smsVerMap.get("Date")!=null)	
//			msg = msg.replace("{Date, fallback=}", smsVerMap.get("Date"));
//		if(smsVerMap.get("ReferenceTxnNo")!=null)	
//			msg = msg.replace("{RefTxnNo, fallback=}", smsVerMap.get("ReferenceTxnNo"));
//		if(smsVerMap.get("DomainName")!=null)	
//			msg = msg.replace("{DomainName, fallback=}", smsVerMap.get("DomainName"));
		
		for(String key: smsVerMap.keySet()){
			if(smsVerMap.get(key)!=null)
				msg = msg.replace("{"+key.trim()+", fallback=}", smsVerMap.get(key));
		}
		return msg;
	}
	public static void main(String[] arg){
		/*sendSMS((short)1,"7891615021","Testing unicel sms service","unicel");
		*/
		String deliveryMessage = "Message Sent Successfully";
		testSMS();
		if(deliveryMessage.toLowerCase().contains("success")){
			System.out.println("soem");

		}

	}
	public static void testSMS() {
		
		String urlHeader = "https://masterdev-epns-eu1.api.vodafone.com/vbps/dxl/documentManagement/v1/document?id=1&accountId=1";
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url("https://masterdev-epns-eu1.api.vodafone.com/vbps/dxl/documentManagement/v1/document?id=1&accountId=1")
				  .method("GET", null)
				  .build();
				
				System.setProperty("javax.net.ssl.keyStore", "/home/yash/Desktop/start_sirioninc_net_public.pem/keystore.jks");

				System.setProperty("javax.net.ssl.keyStorePassword", "vodafone");
				System.setProperty("javax.net.ssl.keyStoreType", "JKS");    
				
						System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,SSLv3");
				
				Response response = null;
				try {
					response = client.newCall(request).execute();
					
					System.out.println(response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
				}
				finally {
					response.close();
				}
	}
	
	public  static void sendSMS(Short aliasId,String mobileNo,String msg, String provider) {
		try{
			String senderId = null;
			if(provider.contains("#")){
				senderId = provider.split("#")[1];
				provider = provider.split("#")[0];
			}
			if("AWS_SNS".equals(provider)){
			    AmazonSNSClient amazonSNSClient= (AmazonSNSClient) CommonMethodController.getInstance().provideAWSClient(aliasId, "SNS");
                String message =msg;
                String phoneNumber = System.getProperty("DIAL_CODE")+mobileNo;
                Map<String, MessageAttributeValue> smsAttributes =new HashMap<>();
                //set SMS attributes
                smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue()
                        .withStringValue("Transactional") //Sets the type to transactional.
                        .withDataType("String"));
                smsAttributes.put("AWS.SNS.SMS.SenderID", new MessageAttributeValue()
                        .withStringValue(senderId) //The sender ID shown on the device.
                        .withDataType("String"));
                PublishResult result = amazonSNSClient.publish(new PublishRequest()
                        .withMessage(message)
                        .withPhoneNumber(phoneNumber)
                        .withMessageAttributes(smsAttributes));
                logger.info(smsAttributes);
                logger.info("AWS SNS Status:"+ result);
			}else if("unicel".equals(provider)) {
				URL url = new URL("http://www.unicel.in/SendSMS/sendmsg.php");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setReadTimeout(5000);
				conn.setConnectTimeout(7000);
				OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
				String urlStr = "uname="+unicelApiUserName+"&pass="+unicelApiPassword+"&send="+senderId+"&dest=91"
						+ mobileNo + "&msg=" + msg + "&concat=1";
				logger.info("Arguments: " + urlStr);
				wr.write(urlStr);
				wr.flush();
				InputStream iStream = conn.getInputStream(); 
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						iStream));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				String deliveryMsg = sb.toString();
				System.out.println("--SMS Delivery Status--- "+ deliveryMsg);

				logger.info("--SMS Delivery Status---" + deliveryMsg);
			}else if("infobip".equals(provider)){
//				URL baseUrl= new URL("http://api2.infobip.com/api/sendsms/plain?");
				URL baseUrl= new URL("https://api.infobip.com/api/v3/sendsms/plain?");
				HttpURLConnection conn=(HttpURLConnection) baseUrl.openConnection();
				conn.setDoOutput(true);
				conn.setReadTimeout(5000);
				conn.setConnectTimeout(7000);
			//	String urlStr="user=AfricaLotto&password=mkting2016&sender=AfricaLotto&SMSText="+msg+"&GSM=263"+mobileNo;
//				String urlStr="user=afrilotto&password=tvPswgWZ&sender=AfricaLotto&SMSText="+msg+"&GSM=263"+mobileNo;
				String urlStr="user=calvinm1&password=htah2017&sender=AfricaLotto&SMSText="+msg+"&GSM=263"+mobileNo+"&type=longSMS";
				OutputStreamWriter osw=new OutputStreamWriter(conn.getOutputStream());
				osw.write(urlStr);
				osw.flush();
				osw.close();
				BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line=null;
				StringBuffer sb=new StringBuffer();
				while ((line=reader.readLine())!=null)
					sb.append(line);
				logger.info("---SMS DELIVERY STATUS:"+sb.toString());
				reader.close();
			} else if("cytech".equals(provider) ||  ("alertsindia".equalsIgnoreCase(provider))){
				InputStream iStream = null;
				String originator = "NLA";

				String smsURL = null;
				String urlStr = null;
				if("alertsindia".equalsIgnoreCase(provider)) {
					smsURL = "http://transapi.alertsindia.com/Desk2web/sendsms.aspx?";
					urlStr = "UserName=payworld&password=pay1world&MobileNo=91"+mobileNo+"&SenderID=ALERTS&CDMAHeader=ALERTS&Message="+msg+"&isFlash=False";
				} else {
					smsURL = "http://api.vasintel.smsp.gr:40000/mcore-in";
					urlStr = "mobile_number="+mobileNo+"&originator="+originator+"&text="+msg+"&concatenated=true&request_delivery=true";
				}
				URL url = new URL(smsURL);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setReadTimeout(5000);
				conn.setConnectTimeout(7000);
				if("cytech".equalsIgnoreCase(provider)) {				
					String loginPassword =  "api-demo@skilrock.com"+ ":" + "zHShsP8Xvwqg";
					String encoded = Base64.encodeBase64String(loginPassword.getBytes());
					conn.setRequestProperty ("Authorization", "Basic " + encoded);
				}
				OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
				wr.write(urlStr);
				wr.flush();
				if(conn.getResponseCode() == 200){
					iStream = conn.getInputStream();
				}else{
					iStream = conn.getErrorStream();
				}
				BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				logger.info("Sending SMS Response : " + sb);
			} else if ("orange".equals(provider)) {
				
				String receiverAddress = Utility.getEnvironmentProperty("DIAL_CODE", "+224")+mobileNo;
				
		/*		OrangeOutboundSMSMessage message = new OrangeOutboundSMSMessage(msg, receiverAddress);
				OrangeSmsService service = new OrangeSmsService();*/
				/*service.send(message);*/
			}else if("MTN".equals(provider)) {				
				
				msg=URLEncoder.encode(msg, "UTF-8");
				msg=msg.replace("+", "%20");
				String urlStr = "REQUESTTYPE=SMSSubmitReq&USERNAME=gnjeux5&PASSWORD=Guije@32&MOBILENO=224"+mobileNo+"&MESSAGE="+msg+"&ORIGIN_ADDR="+senderId+"&TYPE=0";
				logger.info(""+urlStr);
				URL url = new URL("http://10.13.7.145:9001/smshttpquery/qs?"+urlStr);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setReadTimeout(5000);
				conn.setConnectTimeout(7000);
			
				InputStream iStream = conn.getInputStream(); 
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						iStream));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				String deliveryMsg = sb.toString();
				logger.info("--SMS Delivery Status---" + deliveryMsg);
			}else if("Netone".equals(provider)) {			//1s2u gateway africalotto			
				
				msg=URLEncoder.encode(msg, "UTF-8");
				msg=msg.replace("+", "%20");
				String urlStr = "username=henry002&password=web4232&mno=263"+mobileNo+"&msg="+msg+"&Sid=AfricaLotto&fl=0&mt=0&ipcl=127.0.0.1";
				logger.info(""+urlStr);
				URL url = new URL("https://1s2u.com/sms/sendsms/sendsms.asp?"+urlStr);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setReadTimeout(5000);
				conn.setConnectTimeout(7000);
			
				InputStream iStream = conn.getInputStream(); 
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						iStream));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				String deliveryMsg = sb.toString();
				logger.info("--SMS Delivery Status---" + deliveryMsg);
			}
			
			
			/*URL url = new URL(
					"http://transapi.alertsindia.com/Desk2web/sendsms.aspx");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn
					.getOutputStream());
			String urlStr = "UserName=payworld&password=pay1world&MobileNo=91"
					+ mobileNo
					+ "&SenderID=ALERTS&CDMAHeader=ALERTS&Message=" + msg
					+ "&isFlash=False";
			logger.info("Arguments: " + urlStr);
			wr.write(urlStr);
			wr.flush();
			InputStream iStream = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					iStream));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String deliveryMsg = sb.toString();
			logger.info("--SMS Delivery Status---" + deliveryMsg);*/
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<LinkedHashMap<String, String>> getSmsContentList() {
		return smsContentList;
	}

	public String getProvider() {
		return provider;
	}

	public void setSmsContentList(List<LinkedHashMap<String, String>> smsContentList) {
		this.smsContentList = smsContentList;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getSmsType() {
		return smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public short getAliasId() {
		return aliasId;
	}

	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}

	public Map<String,String> getVarMap() {
		return varMap;
	}

	public void setVarMap(Map<String,String> varMap) {
		this.varMap = varMap;
	}
}
