package com.stpl.pms.utility;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;
import com.sun.research.ws.wadl.HTTPMethods;



public class Postman {
	private static final Logger LOGGER = Logger.getLogger(Postman.class);

	private String url;
	private String message;
	private String method;
	private Integer expectedStatus;
	private Integer connectTimeout;
	private Integer readTimeout;
	private Map<String, String> headers;
	private	Map<Integer, Class> responseHandlers;



	public Postman() {
		this.headers = new HashMap<>();
		this.responseHandlers = new HashMap<>();
		this.method = HTTPMethods.POST.name();
		this.connectTimeout = 5000;
		this.readTimeout = 40000;
	}

	public String getUrl() {
		return url;
	}

	public Postman setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Postman setMessage(String message) {
		this.message = message;
		return this;
	}

	public String getMethod() {
		return method;
	}

	public Postman setMethod(HTTPMethods method) {
		this.method = method.toString();
		return this;
	}

	public Postman setMethod(String method) {
		this.method = method;
		return this;
	}

	public Integer getExpectedStatus() {
		return expectedStatus;
	}

	public Postman setExpectedStatus(Integer expectedStatus) {
		this.expectedStatus = expectedStatus;
		return this;
	}

	public Integer getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(Integer readTimeout) {
		this.readTimeout = readTimeout;
	}

	public Map<Integer, Class> getResponseHandlers() {
		return responseHandlers;
	}

	public void setResponseHandlers(Map<Integer, Class> responseHandlers) {
		this.responseHandlers = responseHandlers;
	}

	public Postman addHeader(String key,String value){
		headers.put(key, value);
		return this;
	}

	public Set<String> headerKeySet(){
		return headers.keySet();
	}

	public String getHeader(String key){
		return headers.get(key);
	}

	public Postman addResponseHandler(Integer code,Class handlerClass){
		responseHandlers.put(code,handlerClass);
		return this;
	}

	public Set<Integer> responseHandlerKeySet(){
		return responseHandlers.keySet();
	}

	public Class<?> getResponseHandler(String key){
		return responseHandlers.get(key);
	}

	public Object call() throws PMSException{

		if(StringUtils.isEmpty(url))
			throw new IllegalArgumentException("URL cannot be empty");

		InputStream input = null;
		HttpURLConnection conn = null;
		OutputStream output = null;
		try {

			if(StringUtils.contains(this.getUrl(),"https")){
				prepareSSLContext();
				conn = (HttpsURLConnection) new URL(this.getUrl()).openConnection();
			}else{
				conn = (HttpURLConnection) new URL(this.getUrl()).openConnection();
			}

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod(this.method);
			conn.setConnectTimeout(this.connectTimeout);
			conn.setReadTimeout(this.readTimeout);
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
			LOGGER.info("Sending Response : " + response);

			Class responseHandler = responseHandlers.containsKey(conn.getResponseCode())?
					responseHandlers.get(conn.getResponseCode()):responseHandlers.get(0); 

					if(responseHandler==null)
						return response.toString();
					else
						return Utility.jsonToBean(response.toString(), responseHandler);

		} catch (Exception e) {
			throw new PMSException(PMSErrorCode.GEN_SOME_INTERNAL_ERROR,
					PMSErrorMessage.GEN_SOME_INTERNAL_ERROR, e);
		}finally{
			conn.disconnect();
			try {
				if(input!=null)
					input.close();

				if(output!=null)
					output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void prepareSSLContext() throws NoSuchAlgorithmException, KeyManagementException{
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
	}
}
