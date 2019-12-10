package com.stpl.pms.javabeans;

import java.util.Calendar;

import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;


public class BetGamesTokenBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private long tokenTime;
	private String tokenId;

	private String tokenString;

	public BetGamesTokenBean(long tokenTime, String tokenId ,String tokenString) {
		this.tokenTime = tokenTime;
		this.tokenId = tokenId;
		this.tokenString = tokenString;
	}

	public long getTokenTime() {
		return tokenTime;
	}

	public void setTokenTime(long tokenTime) {
		this.tokenTime = tokenTime;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getTokenString() {
		return tokenString;
	}

	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}
	
	public boolean validateToken() throws PMSException {
		if ((Calendar.getInstance().getTimeInMillis() - this.tokenTime) / 1000 > 60) {
			throw new PMSException(PMSErrorCode.API_TOKEN_EXPIRED,
					PMSErrorMessage.API_TOKEN_EXPIRED);
		}
		return true;
	}
}
