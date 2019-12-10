package com.stpl.pms.javabeans;

public class BetSoftRespParamBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String RESULT;
	private Integer CODE;

	private Long USERID;
	private String USERNAME;
	private String CURRENCY;
	private String FIRSTNAME;
	private String LASTNAME;
	private String EMAIL;
	private Double BALANCE;
	
	private Long EXTSYSTEMTRANSACTIONID;

	public String getRESULT() {
		return RESULT;
	}

	public void setRESULT(String rESULT) {
		RESULT = rESULT;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getCURRENCY() {
		return CURRENCY;
	}

	public void setCURRENCY(String cURRENCY) {
		CURRENCY = cURRENCY;
	}

	public String getFIRSTNAME() {
		return FIRSTNAME;
	}

	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}

	public String getLASTNAME() {
		return LASTNAME;
	}

	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public Double getBALANCE() {
		return BALANCE;
	}

	public void setBALANCE(Double bALANCE) {
		BALANCE = bALANCE;
	}

	public void setCODE(Integer cODE) {
		CODE = cODE;
	}

	public Integer getCODE() {
		return CODE;
	}

	public void setUSERID(Long uSERID) {
		USERID = uSERID;
	}

	public Long getUSERID() {
		return USERID;
	}

	public void setEXTSYSTEMTRANSACTIONID(Long eXTSYSTEMTRANSACTIONID) {
		EXTSYSTEMTRANSACTIONID = eXTSYSTEMTRANSACTIONID;
	}

	public Long getEXTSYSTEMTRANSACTIONID() {
		return EXTSYSTEMTRANSACTIONID;
	}

}
