package com.stpl.pms.javabeans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="Response")
public class InterSwitchDepRespBean {

	private String responseCode;
	private String responseDescription;
	private String mac;
	private String transDate;
	private String transReference;
	private String transSet;
	private String transResponseCode;
	private String transferCode;
	private String pin;
	private String status;

	public InterSwitchDepRespBean() {
	}

	public String getResponseCode() {
		return responseCode;
	}

	@XmlElement (name="ResponseCode")
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	@XmlElement (name="ResponseDescription")
	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	public String getMac() {
		return mac;
	}

	@XmlElement (name="MAC")
	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getTransDate() {
		return transDate;
	}

	@XmlElement (name="TransactionDate")
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getTransReference() {
		return transReference;
	}

	@XmlElement (name="TransactionReference")
	public void setTransReference(String transReference) {
		this.transReference = transReference;
	}

	public String getTransSet() {
		return transSet;
	}

	@XmlElement (name="TransactionSet")
	public void setTransSet(String transSet) {
		this.transSet = transSet;
	}

	public String getTransResponseCode() {
		return transResponseCode;
	}

	@XmlElement (name="TransactionResponseCode")
	public void setTransResponseCode(String transResponseCode) {
		this.transResponseCode = transResponseCode;
	}

	public String getTransferCode() {
		return transferCode;
	}

	@XmlElement (name="TransferCode")
	public void setTransferCode(String transferCode) {
		this.transferCode = transferCode;
	}

	public String getPin() {
		return pin;
	}

	@XmlElement (name="Pin")
	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getStatus() {
		return status;
	}

	@XmlElement (name="Status")
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResponseBean [mac=" + mac + ", pin=" + pin + ", responseCode="
				+ responseCode + ", responseDescription=" + responseDescription
				+ ", status=" + status + ", transDate=" + transDate
				+ ", transReference=" + transReference + ", transResponseCode="
				+ transResponseCode + ", transSet=" + transSet
				+ ", transferCode=" + transferCode + "]";
	}
}