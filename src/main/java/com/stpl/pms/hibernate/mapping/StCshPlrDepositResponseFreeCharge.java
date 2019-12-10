package com.stpl.pms.hibernate.mapping;


public class StCshPlrDepositResponseFreeCharge  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long requestId;
	private String freechargeId;
	private String status;
	private Double amount;
	private String errorCode;
	private String errorMessage;
	private String mode;
	private String checksum;
	private String currency;
	private String pgUsed;
	private String pgUnderlier;
	
	
	/*no-arg constructor required since we have parameterize constructor
	and hibernate need no-arg and other mapper needs no-arg */
	public StCshPlrDepositResponseFreeCharge() {}
	
	public StCshPlrDepositResponseFreeCharge(Long requestId, String freechargeId, String status, Double amount,
			String errorCode, String errorMessage, String mode, String checksum, String currency, String pgUsed,
			String pgUnderlier) {
		this.requestId = requestId;
		this.freechargeId = freechargeId;
		this.status = status;
		this.amount = amount;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.mode = mode;
		this.checksum = checksum;
		this.currency = currency;
		this.pgUsed = pgUsed;
		this.pgUnderlier = pgUnderlier;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public String getFreechargeId() {
		return freechargeId;
	}
	public void setFreechargeId(String freechargeId) {
		this.freechargeId = freechargeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPgUsed() {
		return pgUsed;
	}
	public void setPgUsed(String pgUsed) {
		this.pgUsed = pgUsed;
	}
	public String getPgUnderlier() {
		return pgUnderlier;
	}
	public void setPgUnderlier(String pgUnderlier) {
		this.pgUnderlier = pgUnderlier;
	}
	
}
