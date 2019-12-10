package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrRedeemAccInfoPrepaidWallet entity. @author MyEclipse Persistence
 * Tools
 */

public class StCshPlrRedeemAccInfoPrepaidWallet extends StCshPlrRedeemAccMaster implements java.io.Serializable { 
	private static final long serialVersionUID = 1L;
	// Fields

	private Long redeemAccId;
	private String userName;
	private String emailId;
	private Long mobileNo;
	private String status;
	private StCshPaySubMaster subTypeMas;

	// Constructors

	/** default constructor */
	public StCshPlrRedeemAccInfoPrepaidWallet() {
	}

	/** minimal constructor */
	public StCshPlrRedeemAccInfoPrepaidWallet(String status) {
		this.status = status;
	}

	/** full constructor */
	public StCshPlrRedeemAccInfoPrepaidWallet(StCshPlrRedeemAccMaster redAccMaster,String userName, String emailId,
			Long mobileNo, String status, StCshPaySubMaster subTypeMas) {
		super(redAccMaster.getPaymentType(),
				redAccMaster.getProviderId(), redAccMaster.getPlayerId(),
				redAccMaster.getStatus(), redAccMaster.getPaymentTypeMas());
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.status = status;
		this.subTypeMas = subTypeMas;
	}

	// Property accessors

	public Long getRedeemAccId() {
		return this.redeemAccId;
	}

	public void setRedeemAccId(Long redeemAccId) {
		this.redeemAccId = redeemAccId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StCshPaySubMaster getSubTypeMas() {
		return subTypeMas;
	}

	public void setSubTypeMas(StCshPaySubMaster subTypeMas) {
		this.subTypeMas = subTypeMas;
	}

}