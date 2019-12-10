package com.stpl.pms.javabeans;

import java.io.Serializable;

public class CshSessionRequestBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String SessionId;
	private String DepositrespSuccess;
	private String FirstdepositUrl;
	private String DepositrespError;
	private String PaysubtypeName;
	private String RefersourceType;
	private Long RefersourceId;
	private Long SubsourceId;
	private Long CamptrackId;
	private String PaytypeCode;
	private String DepositPromocode;
	
	public CshSessionRequestBean(){}
	
	
	public String getSessionId() {
		return SessionId;
	}
	public void setSessionId(String sessionId) {
		SessionId = sessionId;
	}
	public String getDepositrespSuccess() {
		return DepositrespSuccess;
	}
	public void setDepositrespSuccess(String depositrespSuccess) {
		DepositrespSuccess = depositrespSuccess;
	}
	public String getFirstdepositUrl() {
		return FirstdepositUrl;
	}
	public void setFirstdepositUrl(String firstdepositUrl) {
		FirstdepositUrl = firstdepositUrl;
	}
	public String getDepositrespError() {
		return DepositrespError;
	}
	public void setDepositrespError(String depositrespError) {
		DepositrespError = depositrespError;
	}
	public String getPaysubtypeName() {
		return PaysubtypeName;
	}
	public void setPaysubtypeName(String paysubtypeName) {
		PaysubtypeName = paysubtypeName;
	}
	public String getRefersourceType() {
		return RefersourceType;
	}
	public void setRefersourceType(String refersourceType) {
		RefersourceType = refersourceType;
	}
	public Long getRefersourceId() {
		return RefersourceId;
	}
	public void setRefersourceId(Long refersourceId) {
		RefersourceId = refersourceId;
	}
	public Long getSubsourceId() {
		return SubsourceId;
	}
	public void setSubsourceId(Long subsourceId) {
		SubsourceId = subsourceId;
	}
	public Long getCamptrackId() {
		return CamptrackId;
	}
	public void setCamptrackId(Long camptrackId) {
		CamptrackId = camptrackId;
	}
	public String getPaytypeCode() {
		return PaytypeCode;
	}
	public void setPaytypeCode(String paytypeCode) {
		PaytypeCode = paytypeCode;
	}
	public String getDepositPromocode() {
		return DepositPromocode;
	}
	public void setDepositPromocode(String depositPromocode) {
		DepositPromocode = depositPromocode;
	}
	
	
}
