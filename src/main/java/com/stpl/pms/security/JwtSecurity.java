package com.stpl.pms.security;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Projections;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.stpl.pms.exception.PMSException;
import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.StSecAwtAuthentication;

public class JwtSecurity {
	private static Logger log = Logger.getLogger(JwtSecurity.class);
	private static JwtSecurity instance;

	private JwtSecurity() {
	}

	public static JwtSecurity getInstance() {
		if (instance == null) {
			instance = new JwtSecurity();
		}
		return instance;
	}

	public String encodeJwtToken() throws UnsupportedEncodingException {
		Map<String, Object> headerMap = new HashMap<>();
		headerMap.put("iss", "Weaver");
		headerMap.put("aud", "abc");

		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, 5);
		Date expirationDate = c.getTime();
		headerMap.put("exp", expirationDate);

		String secret = Base64.encodeBase64String("rajnikanth".getBytes());
		String signed = JWT.create().withHeader(headerMap).withExpiresAt(expirationDate)
				.sign(Algorithm.HMAC256(secret));
		log.info(signed);
		return signed;
	}

	public String decodeJwtToken(String token) throws PMSException, UnsupportedEncodingException {
		String data = null;
		try {
			String secret = Base64.encodeBase64String(getJWTkey().getBytes());
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
			DecodedJWT decodeToken = verifier.verify(token);
			data = new String(Base64.decodeBase64(decodeToken.getHeader()));
			log.info(data);
		} catch (TokenExpiredException e) {
			throw new PMSException(111, "TokenExpired");
		} catch (JWTDecodeException e) {
			throw new PMSException(112, "Invalid token exception");
		} catch (Exception e) {
			log.error("<<< JwtSecurity >>>", e);
		}
		return data;
	}

	private String getJWTkey() {
		return (String) HibernateSessionFactory.getSession().createCriteria(StSecAwtAuthentication.class)
				.setCacheable(true).setProjection(Projections.property("jwtKey")).list().get(0);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getInstance().encodeJwtToken());
	}
}