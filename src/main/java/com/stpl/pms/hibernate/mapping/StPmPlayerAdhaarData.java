package com.stpl.pms.hibernate.mapping;

public class StPmPlayerAdhaarData implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private short domainId;
	private long playerId;
	private String adhaarData;

	public StPmPlayerAdhaarData() {
		// TODO Auto-generated constructor stub
	}

	public StPmPlayerAdhaarData(short domainId, long playerId, String adhaarData) {
		super();
		this.domainId = domainId;
		this.playerId = playerId;
		this.adhaarData = adhaarData;
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

	public String getAdhaarData() {
		return adhaarData;
	}

	public void setAdhaarData(String adhaarData) {
		this.adhaarData = adhaarData;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

}
