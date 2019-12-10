package com.stpl.pms.hibernate.mapping;

public class StMisAdCompanyPlrMapping implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private long id;
	private long adCompanyId;
	private long playerId;
	public StMisAdCompanyPlrMapping(){
		
	}
	
	public StMisAdCompanyPlrMapping(long adCompanyId, long playerId) {
		super();
		this.adCompanyId = adCompanyId;
		this.playerId = playerId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAdCompanyId() {
		return adCompanyId;
	}
	public void setAdCompanyId(long adCompanyId) {
		this.adCompanyId = adCompanyId;
	}
	public long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
	
	
	
	

}
