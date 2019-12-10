package com.stpl.pms.hibernate.mapping;


public class StCshPlrDepositResponseSafex  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String agId;
	private String meId;
	private long requestId;
	private double amount;
	private String country;
	private String currency;
	private String txnDate;
	private String txnTime;
	private String agRef;
	private String pgRef;
	private String status;
	private String resCode;
	private String resMessage;
	
	private String pgId;
	private String pgName;
	private String paymode;
	private String emiMonths;
	
	private String fraudAction;
	private String fraudMessage;
	private String score;
	
	private String udf1;
	private String udf2;
	private String udf3;
	private String udf4;
	private String udf5;
	
	

	
	
	/*no-arg constructor required since we have parameterize constructor
	and hibernate need no-arg and other mapper needs no-arg */
	public StCshPlrDepositResponseSafex() {}


	public StCshPlrDepositResponseSafex( String agId, String meId, Long requestId, double amount,
			String country, String currency, String txnDate, String txnTime, String agRef, String pgRef, String status,
			String resCode, String resMessage, String pgId, String pgName, String paymode, String emiMonths,
			String fraudAction, String fraudMessage, String score, String udf1, String udf2, String udf3, String udf4,
			String udf5) {
		super();
		this.agId = agId;
		this.meId = meId;
		this.requestId = requestId;
		this.amount = amount;
		this.country = country;
		this.currency = currency;
		this.txnDate = txnDate;
		this.txnTime = txnTime;
		this.agRef = agRef;
		this.pgRef = pgRef;
		this.status = status;
		this.resCode = resCode;
		this.resMessage = resMessage;
		this.pgId = pgId;
		this.pgName = pgName;
		this.paymode = paymode;
		this.emiMonths = emiMonths;
		this.fraudAction = fraudAction;
		this.fraudMessage = fraudMessage;
		this.score = score;
		this.udf1 = udf1;
		this.udf2 = udf2;
		this.udf3 = udf3;
		this.udf4 = udf4;
		this.udf5 = udf5;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getAgId() {
		return agId;
	}





	public void setAgId(String agId) {
		this.agId = agId;
	}





	public String getMeId() {
		return meId;
	}





	public void setMeId(String meId) {
		this.meId = meId;
	}





	public Long getRequestId() {
		return requestId;
	}





	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}





	public double getAmount() {
		return amount;
	}





	public void setAmount(double amount) {
		this.amount = amount;
	}





	public String getCountry() {
		return country;
	}





	public void setCountry(String country) {
		this.country = country;
	}





	public String getCurrency() {
		return currency;
	}





	public void setCurrency(String currency) {
		this.currency = currency;
	}





	public String getTxnDate() {
		return txnDate;
	}





	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}





	public String getTxnTime() {
		return txnTime;
	}





	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}





	public String getAgRef() {
		return agRef;
	}





	public void setAgRef(String agRef) {
		this.agRef = agRef;
	}





	public String getPgRef() {
		return pgRef;
	}





	public void setPgRef(String pgRef) {
		this.pgRef = pgRef;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}





	public String getResCode() {
		return resCode;
	}





	public void setResCode(String resCode) {
		this.resCode = resCode;
	}





	public String getResMessage() {
		return resMessage;
	}





	public void setResMessage(String resMessage) {
		this.resMessage = resMessage;
	}





	public String getPgId() {
		return pgId;
	}





	public void setPgId(String pgId) {
		this.pgId = pgId;
	}





	public String getPgName() {
		return pgName;
	}





	public void setPgName(String pgName) {
		this.pgName = pgName;
	}





	public String getPaymode() {
		return paymode;
	}





	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}





	public String getEmiMonths() {
		return emiMonths;
	}





	public void setEmiMonths(String emiMonths) {
		this.emiMonths = emiMonths;
	}





	public String getFraudAction() {
		return fraudAction;
	}





	public void setFraudAction(String fraudAction) {
		this.fraudAction = fraudAction;
	}





	public String getFraudMessage() {
		return fraudMessage;
	}





	public void setFraudMessage(String fraudMessage) {
		this.fraudMessage = fraudMessage;
	}





	public String getScore() {
		return score;
	}





	public void setScore(String score) {
		this.score = score;
	}





	public String getUdf1() {
		return udf1;
	}





	public void setUdf1(String udf1) {
		this.udf1 = udf1;
	}





	public String getUdf2() {
		return udf2;
	}





	public void setUdf2(String udf2) {
		this.udf2 = udf2;
	}





	public String getUdf3() {
		return udf3;
	}





	public void setUdf3(String udf3) {
		this.udf3 = udf3;
	}





	public String getUdf4() {
		return udf4;
	}





	public void setUdf4(String udf4) {
		this.udf4 = udf4;
	}





	public String getUdf5() {
		return udf5;
	}





	public void setUdf5(String udf5) {
		this.udf5 = udf5;
	}
	
	
	
	
	
}
