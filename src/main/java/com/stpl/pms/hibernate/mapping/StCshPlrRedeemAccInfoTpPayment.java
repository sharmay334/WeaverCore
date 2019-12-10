package com.stpl.pms.hibernate.mapping;

public class StCshPlrRedeemAccInfoTpPayment extends StCshPlrRedeemAccMaster implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Long redeemAccId;
	private Long mobileNo;
	private String status;
	private String senderName;

	private StCshPaySubMaster subTypeMas;

	// Constructors

	/** default constructor */
	public StCshPlrRedeemAccInfoTpPayment() {
	}

	/** minimal constructor */
	public StCshPlrRedeemAccInfoTpPayment(String status) {
		this.status = status;
	}

	public StCshPlrRedeemAccInfoTpPayment(StCshPlrRedeemAccMaster redAccMaster, Long mobileNo, String senderName,
			String status, StCshPaySubMaster subTypeMas) {
		super(redAccMaster.getPaymentType(), redAccMaster.getProviderId(), redAccMaster.getPlayerId(),
				redAccMaster.getStatus(), redAccMaster.getPaymentTypeMas());
		this.senderName = senderName;
		this.mobileNo = mobileNo;
		this.status = status;
		this.subTypeMas = subTypeMas;
	}

	// Property accessors
	@Override
	public Long getRedeemAccId() {
		return this.redeemAccId;
	}

	@Override
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

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public StCshPaySubMaster getSubTypeMas() {
		return subTypeMas;
	}

	public void setSubTypeMas(StCshPaySubMaster subTypeMas) {
		this.subTypeMas = subTypeMas;
	}
}
