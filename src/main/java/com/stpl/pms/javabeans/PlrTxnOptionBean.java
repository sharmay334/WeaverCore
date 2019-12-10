package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class PlrTxnOptionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private short domainId;
	private long playerId;
	private Timestamp fromDate;
	private Timestamp toDate;
	private String txnType;
	private int startIndex;
	
	public PlrTxnOptionBean() {
	}

	public PlrTxnOptionBean(short domainId, long playerId, Timestamp fromDate,
			Timestamp toDate, String txnType) {
		this.domainId = domainId;
		this.playerId = playerId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.txnType = txnType;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public Timestamp getFromDate() {
		return fromDate;
	}

	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}

	public Timestamp getToDate() {
		return toDate;
	}

	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getTxnType() {
		return txnType;
	}

	@Override
	public String toString() {
		return "PlrTxnOptionBean [domainId=" + domainId + ", fromDate="
				+ fromDate + ", playerId=" + playerId + ", toDate=" + toDate
				+ ", txnType=" + txnType + "]";
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

}
