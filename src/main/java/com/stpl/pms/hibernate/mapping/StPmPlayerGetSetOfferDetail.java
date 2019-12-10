package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

public class StPmPlayerGetSetOfferDetail  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private String wgrTargetPrize;
	private Timestamp lastUpdated;
	private String idVCommission;
	
	
	public StPmPlayerGetSetOfferDetail(){
		super();
	}
	
	public StPmPlayerGetSetOfferDetail(Long playerId, String wgrTargetPrize,
			Timestamp lastUpdated) {
		super();
		this.playerId = playerId;
		this.wgrTargetPrize = wgrTargetPrize;
		this.lastUpdated = lastUpdated;
	}
	
	
	
	public StPmPlayerGetSetOfferDetail(Long playerId, Timestamp lastUpdated, String idVCommission) {
		super();
		this.playerId = playerId;
		this.lastUpdated = lastUpdated;
		this.idVCommission = idVCommission;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public String getWgrTargetPrize() {
		return wgrTargetPrize;
	}
	public void setWgrTargetPrize(String wgrTargetPrize) {
		this.wgrTargetPrize = wgrTargetPrize;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getIdVCommission() {
		return idVCommission;
	}

	public void setIdVCommission(String idVCommission) {
		this.idVCommission = idVCommission;
	}
	
	
	

}
