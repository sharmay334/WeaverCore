package com.stpl.pms.hibernate.mapping;

public class StSecAwtAuthentication {

	private int id;
	private String audience;
	private String issuer;
	private String jwtKey;
	private int tokenExpiry;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAudience() {
		return audience;
	}

	public String getIssuer() {
		return issuer;
	}

	public String getJwtKey() {
		return jwtKey;
	}

	public int getTokenExpiry() {
		return tokenExpiry;
	}

	public void setAudience(String audience) {
		this.audience = audience;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public void setJwtKey(String jwtKey) {
		this.jwtKey = jwtKey;
	}

	public void setTokenExpiry(int tokenExpiry) {
		this.tokenExpiry = tokenExpiry;
	}

}
