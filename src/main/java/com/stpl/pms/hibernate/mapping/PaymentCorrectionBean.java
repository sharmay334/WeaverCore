package com.stpl.pms.hibernate.mapping;

public class PaymentCorrectionBean {
	
	private String playerId;
	private String settlementAmount;
	private String reason;
	
	
	
	public PaymentCorrectionBean() {
	}
	public PaymentCorrectionBean(String playerId, String settlementAmount, String reason) {
		super();
		this.playerId = playerId;
		this.settlementAmount = settlementAmount;
		this.reason = reason;
	}
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getSettlementAmount() {
		return settlementAmount;
	}
	public void setSettlementAmount(String settlementAmount) {
		this.settlementAmount = settlementAmount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
