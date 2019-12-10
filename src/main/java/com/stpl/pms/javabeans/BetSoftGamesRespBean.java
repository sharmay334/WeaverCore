package com.stpl.pms.javabeans;


public class BetSoftGamesRespBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String TIME;
	private BetSoftReqParamBean REQUEST;
	private BetSoftRespParamBean RESPONSE;

	public String getTIME() {
		return TIME;
	}

	public void setTIME(String tIME) {
		TIME = tIME;
	}

	public BetSoftReqParamBean getREQUEST() {
		return REQUEST;
	}

	public void setREQUEST(BetSoftReqParamBean rEQUEST) {
		REQUEST = rEQUEST;
	}

	public BetSoftRespParamBean getRESPONSE() {
		return RESPONSE;
	}

	public void setRESPONSE(BetSoftRespParamBean rESPONSE) {
		RESPONSE = rESPONSE;
	}

}