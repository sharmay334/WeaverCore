package com.stpl.pms.javabeans;

import java.io.Serializable;

public class AutoVerificationBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String uniqueTrxId;
	private String result;
	private short sourceId;
	private long playerId;
	private short domainId;
	private boolean name;
	private boolean dob;
	private boolean address;
	private boolean isOver18;
	private String tpVerificationId;
	
	public boolean isName() {
		return name;
	}
	public void setName(boolean name) {
		this.name = name;
	}
	public boolean isDob() {
		return dob;
	}
	public void setDob(boolean dob) {
		this.dob = dob;
	}
	public boolean isAddress() {
		return address;
	}
	public void setAddress(boolean address) {
		this.address = address;
	}
	public boolean isOver18() {
		return isOver18;
	}
	public void setOver18(boolean isOver18) {
		this.isOver18 = isOver18;
	}
	public String getUniqueTrxId() {
		return uniqueTrxId;
	}
	public void setUniqueTrxId(String uniqueTrxId) {
		this.uniqueTrxId = uniqueTrxId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public short getSourceId() {
		return sourceId;
	}
	public void setSourceId(short sourceId) {
		this.sourceId = sourceId;
	}
	public long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
	public short getDomainId() {
		return domainId;
	}
	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}
	public void setTpVerificationId(String tpVerificationId) {
		this.tpVerificationId = tpVerificationId;
	}
	public String getTpVerificationId() {
		return tpVerificationId;
	}
	
}
