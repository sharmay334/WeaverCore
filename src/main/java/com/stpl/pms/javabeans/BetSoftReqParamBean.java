package com.stpl.pms.javabeans;

public class BetSoftReqParamBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String TOKEN;
	private String HASH;

	private String USERID;

	public String getTOKEN() {
		return TOKEN;
	}

	public void setTOKEN(String tOKEN) {
		TOKEN = tOKEN;
	}

	public String getHASH() {
		return HASH;
	}

	public void setHASH(String hASH) {
		HASH = hASH;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getUSERID() {
		return USERID;
	}

}
