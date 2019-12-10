package com.stpl.pms.javabeans;

import java.sql.Timestamp;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
@JsonSerialize(include = Inclusion.NON_NULL)
public class WeaverServiceResponseBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String requestType;
	private String domainName;
	private String userName;
	private String emailId;
	private Long mobileNo;
	private Timestamp registrationDate; 
	private Double amount;
	private Long requestId;
	private Long accountId;
	
	private String fromDate;
	private String toDate;
	private List<NetGamingTxnReportBean> netGamingTxnReport; 
	
	private Integer errorCode;
	private String errorMsg;
	private String respMsg;
	private Long withTxnId;
	private String playerPassword;
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setNetGamingTxnReport(List<NetGamingTxnReportBean> netGamingTxnReport) {
		this.netGamingTxnReport = netGamingTxnReport;
	}

	public List<NetGamingTxnReportBean> getNetGamingTxnReport() {
		return netGamingTxnReport;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getToDate() {
		return toDate;
	}
	
	public Long getWithTxnId() {
		return withTxnId;
	}

	public void setWithTxnId(Long withTxnId) {
		this.withTxnId = withTxnId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getPlayerPassword() {
		return playerPassword;
	}

	public void setPlayerPassword(String playerPassword) {
		this.playerPassword = playerPassword;
	}	
	
	

}