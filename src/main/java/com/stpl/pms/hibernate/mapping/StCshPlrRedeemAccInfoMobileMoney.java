package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrRedeemAccInfoPrepaidWallet entity. @author MyEclipse Persistence
 * Tools
 */

public class StCshPlrRedeemAccInfoMobileMoney extends StCshPlrRedeemAccMaster implements java.io.Serializable { 
	private static final long serialVersionUID = 1L;
	// Fields

	private Long redeemAccId;
	private String name;
	private Long mobileNo;
	private String senderName;
	private String status;
	private StCshPaySubMaster subTypeMas;

	// Constructors

	/** default constructor */
	public StCshPlrRedeemAccInfoMobileMoney() {
	}

	/** minimal constructor */
	public StCshPlrRedeemAccInfoMobileMoney(String status) {
		this.status = status;
	}

	/** full constructor */
	public StCshPlrRedeemAccInfoMobileMoney(StCshPlrRedeemAccMaster redAccMaster,String name, Long mobileNo,
			String senderName, String status, StCshPaySubMaster subTypeMas) {
		super(redAccMaster.getPaymentType(),
				redAccMaster.getProviderId(), redAccMaster.getPlayerId(),
				redAccMaster.getStatus(), redAccMaster.getPaymentTypeMas());
		this.name = name;
		this.senderName = senderName;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

}