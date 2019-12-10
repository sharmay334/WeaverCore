package com.stpl.pms.hibernate.mapping;

public class StCshPlrRedeemAccInfoWari extends StCshPlrRedeemAccMaster implements java.io.Serializable { 
	private static final long serialVersionUID = 1L;
	// Fields

	private Long redeemAccId;
	private String firstName;
	private String lastName;
	private Long mobileNo;
	private String senderName;
	private String status;
	private StCshPaySubMaster subTypeMas;

	// Constructors

	/** default constructor */
	public StCshPlrRedeemAccInfoWari() {
	}

	/** minimal constructor */
	public StCshPlrRedeemAccInfoWari(String status) {
		this.status = status;
	}

	/** full constructor */
	public StCshPlrRedeemAccInfoWari(StCshPlrRedeemAccMaster redAccMaster,String firstName,String lastName, Long mobileNo,
			String senderName, String status, StCshPaySubMaster subTypeMas) {
		super(redAccMaster.getPaymentType(),
				redAccMaster.getProviderId(), redAccMaster.getPlayerId(),
				redAccMaster.getStatus(), redAccMaster.getPaymentTypeMas());
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
}
