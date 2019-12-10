package com.stpl.pms.security;

import java.util.Calendar;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stpl.pms.javabeans.ClientAuthenticationBean;

public class SecurityUtility {
	private static Logger log = Logger.getLogger(SecurityUtility.class);
	private static final String LOG_TAG = "<<< SecurityController >>> ";
	private static SecurityUtility instance;

	private SecurityUtility() {
	}

	public static SecurityUtility getInstance() {
		if (instance == null) {
			instance = new SecurityUtility();
		}
		return instance;
	}

	public boolean verifyToken(String token) {
		try {
			String data = JwtSecurity.getInstance().decodeJwtToken(token);
			ClientAuthenticationBean obj = new ObjectMapper().readValue(data, ClientAuthenticationBean.class);
			long tokenLife = obj.getExp();
			Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			c.add(Calendar.MILLISECOND, 0);
			long x = c.getTimeInMillis();
			log.info("\nToken time Live :  " + tokenLife + "\nSystem Time : " + x);
			return (tokenLife >= x);

		} catch (Exception e) {
			log.error(LOG_TAG, e);
			return false;
		}

	}

	public static void main(String[] args) throws Exception {
		JwtSecurity.getInstance().encodeJwtToken();

	}
}
