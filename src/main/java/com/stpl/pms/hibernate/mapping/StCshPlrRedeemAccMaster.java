package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrRedeemAccMaster entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrRedeemAccMaster implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long redeemAccId;
	private String paymentType;
	private Integer providerId;
	private Long playerId;
	private String status;
	private StCshPaymentTypeMaster paymentTypeMas;

	public StCshPlrRedeemAccMaster() {
	}

	public StCshPlrRedeemAccMaster( String paymentType,
			Integer providerId, Long playerId, String status,
			StCshPaymentTypeMaster paymentTypeMas) {
		this.paymentType = paymentType;
		this.providerId = providerId;
		this.playerId = playerId;
		this.status = status;
		this.paymentTypeMas = paymentTypeMas;
	}

	public Long getRedeemAccId() {
		return this.redeemAccId;
	}

	public void setRedeemAccId(Long redeemAccId) {
		this.redeemAccId = redeemAccId;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getProviderId() {
		return this.providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPaymentTypeMas(StCshPaymentTypeMaster paymentTypeMas) {
		this.paymentTypeMas = paymentTypeMas;
	}

	public StCshPaymentTypeMaster getPaymentTypeMas() {
		return paymentTypeMas;
	}

}