package com.stpl.pms.controller.lm;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class VerifyRecaptcha {
	
	
	public static VerifyRecaptcha  captcha =new VerifyRecaptcha();

	public static final String url = "https://www.google.com/recaptcha/api/siteverify";
	public static final String secret = "6LdPdG8UAAAAAHLyokUzmzuoFvspD0-YeII_bGsX";
	private final static String USER_AGENT = "Mozilla/5.0";

	public static boolean verify(String gRecaptchaResponse) throws IOException {
		if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
			return false;
		}
		
		try{
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String postParams = "secret=" + secret + "&response="
				+ gRecaptchaResponse;

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postParams);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		
		//parse JSON response and return 'success' value
		JsonElement jelement = new JsonParser().parse(response.toString());
		JsonObject  jobject = jelement.getAsJsonObject();		
		 String result = jobject.get("success").getAsString();
		
		boolean rf=false;
		
		if (result.equals("true"))
		{
			 rf=true;
		}
			
	
     
     return rf;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}