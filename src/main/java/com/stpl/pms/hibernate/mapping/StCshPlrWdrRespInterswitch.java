package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrWdrRespInterswitch entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrWdrRespInterswitch implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private String respCode;
	private String mac;
	private String txnDate;
	private String txnRef;
	private String txnCode;
	private String pin;
	private String description;
	private String status;

	// Constructors

	/** default constructor */
	public StCshPlrWdrRespInterswitch() {
	}

	/** full constructor */
	public StCshPlrWdrRespInterswitch(String respCode, String mac,
			String txnDate, String txnRef, String txnCode, String pin,
			String description, String status) {
		this.respCode = respCode;
		this.mac = mac;
		this.txnDate = txnDate;
		this.txnRef = txnRef;
		this.txnCode = txnCode;
		this.pin = pin;
		this.description = description;
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRespCode() {
		return this.respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getMac() {
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getTxnDate() {
		return this.txnDate;
	}

	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}

	public String getTxnRef() {
		return this.txnRef;
	}

	public void setTxnRef(String txnRef) {
		this.txnRef = txnRef;
	}

	public String getTxnCode() {
		return this.txnCode;
	}

	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}

	public String getPin() {
		return this.pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}